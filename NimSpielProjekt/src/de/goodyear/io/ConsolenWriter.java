package de.goodyear.io;

public class ConsolenWriter implements Writer{
    @Override
    public void write(String message) {
        System.out.println(message);
    }
}
