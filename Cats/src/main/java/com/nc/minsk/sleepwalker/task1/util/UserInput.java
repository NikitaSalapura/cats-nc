package com.nc.minsk.sleepwalker.task1.util;

import java.util.Scanner;

public class UserInput {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputString(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }

    public static Integer inputInteger(String msg) {
        System.out.print(msg);
        Integer integer = null;
        if (scanner.hasNextInt()) {
            integer = scanner.nextInt();
        }
        scanner.nextLine();
        return integer;
    }
}