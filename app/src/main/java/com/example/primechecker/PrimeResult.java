package com.example.primechecker;

public class PrimeResult {
    private int number;
    private PrimeNote note;

    public PrimeResult(int number, PrimeNote note) {
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

    public void setNumber(int number) {
        this.number = number;
    }

    public PrimeNote getNote() {
        return note;
    }

    public void setNote(PrimeNote note) {
        this.note = note;
    }
}