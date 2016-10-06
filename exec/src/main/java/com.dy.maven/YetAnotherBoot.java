package com.dy.maven;

public class YetAnotherBoot {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("YET ANOTHER BOOT is launched!!!");
        for (int i = 0; i < args.length; i++) {
            System.out.println("ARGUMENT " + i + ": " + args[i]);
        }
        System.out.println();
    }
}
