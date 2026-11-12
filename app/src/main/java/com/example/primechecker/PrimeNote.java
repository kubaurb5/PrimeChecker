package com.example.primechecker;

public enum PrimeNote {
    PIERWSZA("To jest liczba pierwsza!"),
    ZLOZONA("To jest liczba złożona."),
    NIE_JEST_PIERWSZA("Liczba nie jest pierwsza (<= 1).");

    private final String description;

    PrimeNote(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}