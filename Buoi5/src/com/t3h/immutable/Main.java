package com.t3h.immutable;

public class Main {
    public static void main(String[] args) {
        String str = "Hello    world,    Hello    ladies,    Hello   elephant   in    ban dols";
        int length = str.length();
        System.out.println(length);
        char c = str.charAt(1);
        System.out.println(c);
        int index = str.indexOf("l");
        System.out.println(index);
        int lastIndex = str.lastIndexOf("l");
        System.out.println(lastIndex);
        int secondIndex = str.indexOf("l", index + 1);
        System.out.println(secondIndex);

        int i = str.indexOf("l");
        while (i > -1) {
            System.out.print(i +"\t");
            i = str.indexOf("l", i + 1);
        }
        System.out.println();
        String str1 = str.substring(7, 10);
        System.out.println(str1);
        str1 = str1.toUpperCase();
        System.out.println(str1);
        str1 = str1.toLowerCase();
        System.out.println(str1);
        str = str.replace("Hello", "HELLO");
        System.out.println(str);

        int a = str.indexOf(" ");
        while (str.indexOf("  ") > -1) {
            str = str.replace("  ", " ");
        }
        while (a > -1) {
            String s = str.substring(a, a + 2);
            str = str.replace(s, s.toUpperCase());
            a = str.indexOf(" ", a + 1);
        }
        System.out.println(str);


        String s = "   Hello   world   ";
        s = s.trim();
        System.out.println(s);

        String s1 = "Hello";
        String s2 = "hello";
        boolean equals = s1.equals(s2);
        System.out.println(equals);
        boolean equalsIgnoreCase = s1.equalsIgnoreCase(s2);
        System.out.println(equalsIgnoreCase);

        int compare = s1.compareTo(s2);
        System.out.println(compare);
        int compareIgnoreCase = s1.compareToIgnoreCase(s2);
        System.out.println(compareIgnoreCase);

        String info = "bacnv_123456_Ha Noi";
        String[] arr = info.split("_");
        String userName = arr[0];
        String password = arr[1];
        String address = arr[2];
        System.out.println(userName);
        System.out.println(password);
        System.out.println(address);
    }
}
