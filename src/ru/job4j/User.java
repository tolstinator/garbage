package ru.job4j;

public class User {

    private static int countFinalization;

    private final int field1 = 123456789;

    private final boolean field2 = true;

    private final String field3 = "string";

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize № " + ++countFinalization);
    }
}
