package com.jrb.pardot.demo.secret;

public class Main {

    public static void main(String[] args) {
        int num = getIntArg(args);
        System.out.println("The secret for " + num + (isSecretAdditive(num) ? " is " : " is not ")
                + "additive for the secrets of all primes less than " + num + ".");
    }

    private static int getIntArg(String[] args) {
        int number = 0;

        if (args == null || args.length == 0) {
            System.out.println("Please specify a whole number greater than 1.");
            System.exit(-1);
        }

        try {
            number = Integer.valueOf(args[0]);
            if (number <= 1) {
                System.out.println("Please specify a whole number greater than 1.");
                System.exit(-1);
            }
        } catch (NumberFormatException e) {
            System.out.println("Please specify a whole number greater than 1.");
            System.exit(-1);
        }

        return number;
    }

    private static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSecretAdditive(int number) {
        int secretNumber = secret(number);

        for (int i = 2; i < (number / 2) + 1; i++) {
            if (isPrime(i) && isPrime(number - i) && (secret(i) + secret(number - i) != secretNumber)) {
                return false;
            }
        }
        return true;
    }

    private static int secret(int number) {
        return number;
    }
}