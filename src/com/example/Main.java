package com.example;

import com.example.production.Actor;
import com.example.production.Production;
import com.example.services.ActorService;
import com.example.services.ProductionService;
import com.example.user.User;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static User currentUser = null;

    public static void main(String[] args) {
        currentUser = login();

        while (true) {
            System.out.println("1. List all productions");
            System.out.println("2. List all actors");
            System.out.println("3. Exit");
            System.out.println();

            int choice = scanNextInt();

            switch (choice) {
                case 1:
                    for (Production production : ProductionService.getAllProductions())
                        System.out.println(production.getTitle());
                    break;
                case 2:
                    for (Actor actor : ActorService.getAllActors())
                        System.out.println(actor.getName());
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }
    }

    private static User login() {
        System.out.println("Enter your email:");
        String email = scanNextLineNonBlank();
        System.out.println("Enter your password:");
        String password = scanNextLineNonBlank();
        System.out.println();

        List<User> users = IMDB.getInstance().getUsers();
        for (User user : users) {
            if (user.getCredentials().getEmail().equals(email) && user.getCredentials().getPassword().equals(password)) {
                System.out.println("Welcome, " + user.getUsername() + "!");
                return user;
            }
        }

        System.out.println("Invalid email or password! Please try again.");
        return login();
    }

    private static int scanNextInt() {
        System.out.print("> ");
        int input = 0;
        try {
            input = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input! Expected an integer!");
            scanner.nextLine(); // consume the \n character
            input = scanNextInt();
        }
        scanner.nextLine();
        System.out.println();
        return input;
    }

    public static String scanNextLine() {
        System.out.print("> ");
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }

    public static String scanNextLineNonBlank() {
        String input = scanNextLine();
        while (input.isBlank()) {
            System.out.println("Invalid input! Expected a non-blank line!");
            input = scanNextLine();
        }
        return input;
    }
}