package com.example.primechecker;

public final class FinalPrimeValidator {

    public static boolean check(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}