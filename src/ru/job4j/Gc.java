package ru.job4j;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class Gc {
    public static void main(String[] args) {
        User user1 = new User("user1");
        User user2 = new User("user2");
        WeakReference<User> userWeak = new WeakReference<>(new User("user3"));
        SoftReference<User> userSoft = new SoftReference<>(user2);
        System.gc();
        System.out.println(userWeak);
        System.out.println(userSoft);
     }
}