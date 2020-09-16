package ru.job4j.cache;

import java.io.*;
import java.lang.ref.SoftReference;
import java.util.*;

/**
 * Class for cache of content of text files with soft references.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class TextFileCache implements Cache<String, String> {

    /**
     * List with soft references to keys.
     */
    private final List<SoftReference<String>> keysList = new LinkedList<>();

    /**
     * Map, that contains keys (file names) and content (file content).
     */
    private final Map<String, String> dataMap = new HashMap<>();

    /**
     * Directory with files.
     */
    private final File sourceDir = new File(TextFileCache.class.getClassLoader().getResource("").getPath());

    /**
     * Checks whether the file in storage and reads file from directory, if file is exist in there.
     *
     * @param key file name
     * @return file content
     */
    @Override
    public String read(String key) {
        String result = dataMap.get(key);
        if (result == null) {
            result = readTextFile(key);
            if (result != null) {
                add(key, result);
            }
        }
        return result;
    }

    /**
     * Reads content of file, if it is exist.
     *
     * @param key file name
     * @return file content or null, if file is not exist
     */
    private String readTextFile(String key) {
        String result = null;
        File file = new File(sourceDir, key);
        if (file.exists()) {
            StringBuilder builder = new StringBuilder();
            String line;
            try (BufferedReader read = new BufferedReader(new FileReader(file))) {
                line = read.readLine();
                while (line != null) {
                    builder.append(line);
                    line = read.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            result = builder.toString();
        }
        return result;
    }

    /**
     * Adds file to storage and clears list of soft references of null keys.
     *
     * @param key file name to add
     * @param content file content
     */
    private void add(String key, String content) {
        dataMap.put(key, content);
        keysList.add(new SoftReference<>(key));
        clearDataSoftRef();
    }

    /**
     * Clears list of soft references of null keys.
     */
    private void clearDataSoftRef() {
        keysList.removeIf(softReference -> softReference.get() == null);
    }
}
