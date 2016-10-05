package com.dy.maven;

public class Boot {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Where are arguments, Sir?!");
        } else  {
            System.out.println("Hello, " + args[0] + "!");
        }
    }
}
