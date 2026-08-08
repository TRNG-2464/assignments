package com.mycompany.app;

public class App {

    public static void main(String[] args) {
        App app = new App();

        // should print a2b1c5a3
        System.out.println(app.compress("aabcccccaaa"));

        // should print a4
        System.out.println(app.compress("aaaa"));

        // should print abc (compressed a1b1c1 is longer than original)
        System.out.println(app.compress("abc"));

        // should print a (compressed a1 is longer than original)
        System.out.println(app.compress("a"));

        // should print aabb (compressed a2b2 is equal length to original)
        System.out.println(app.compress("aabb"));
    }

    public String compress(String s) {

        StringBuilder out = new StringBuilder();
        char currentChar = s.charAt(0);
        int currentFrequency = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != currentChar) {
                out.append(c).append(Integer.toString(currentFrequency));
                currentChar = c;
            } else {
                currentFrequency++;
            }

            if (out.length() >= s.length()) {
                return s;
            }
        }

        return new String(out);

    }

}
