package com.t3h.mutable;

public class Main {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        builder.append("Hello");
        builder.append(" World");
        builder.insert(1, "Banana");
        builder.delete(1, 3);
        builder.reverse();
        System.out.println(builder);
    }
}
