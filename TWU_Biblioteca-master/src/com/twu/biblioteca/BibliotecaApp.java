package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        ConsoleOutput output = new ConsoleOutput();
        System.out.println(output.WelcomeMessage());
        System.out.println(output.MenuOptions());
        System.out.println(output.OptionResponse());
    }
}