package ru.job4j;

import java.util.ArrayList;
import java.util.List;

public class Gc {
    public static void main(String[] args) {
        List<User> users1 = new ArrayList<>();
        int countObject1 = 0;
        for (int i = 0; i < 100000; i++) {
            users1.add(new User());
            System.out.println("to users2 added object № " + ++countObject1);
        }
        users1 = null;

        List<User> users2 = new ArrayList<>();
        int countObject2 = 0;
        boolean cond = true;
        while (cond) {
            users2.add(null);
            System.out.println("to users2 added object № " + ++countObject2);
        }
    }
}