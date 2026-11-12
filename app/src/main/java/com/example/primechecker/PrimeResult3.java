package com.example.primechecker;

record PrimeResult3(int number, PrimeNote note) {

    @Override
    public String toString() {
        return "Liczba: %d | Status: %s\n%s".formatted(number, note, note.getDescription());
    }
}