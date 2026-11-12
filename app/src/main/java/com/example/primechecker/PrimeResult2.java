package com.example.primechecker;

final class PrimeResult2 {
    private final int number;
    private final PrimeNote note;

    public PrimeResult2(int number, PrimeNote note) {
        this.number = number;
        this.note = note;
    }

    @Override
    public String toString() {
        return "Liczba: %d | Status: %s\n%s".formatted(number, note, note.getDescription());
    }

    public int getNumber() {
        return number;
    }

    public PrimeNote getNote() {
        return note;
    }
}