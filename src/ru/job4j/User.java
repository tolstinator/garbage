package ru.job4j;

public class User {

    private static int countFinalization;

    private final int field1 = 123456789;

    private final boolean field2 = true;

    private String field3 = "string";

    public User() {
    }

    public User(String field3) {
        this.field3 = field3;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("f: " + this.field3);
    }
}
