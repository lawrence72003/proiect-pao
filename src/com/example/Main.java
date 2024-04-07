package com.example;

import com.example.production.Actor;
import com.example.production.Movie;
import com.example.production.Production;
import com.example.services.ActorService;
import com.example.services.ProductionService;
import com.example.services.UserService;
import com.example.user.Credentials;
import com.example.user.Regular;
import com.example.user.User;
import com.example.user.UserType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static User currentUser = null;

    public static void main(String[] args) {
        UserService.addUser(new Regular("admin", 13, UserType.Regular, null, new Credentials("lawrence@gmail.com", "password")));

        ProductionService.addProduction(new Movie("Interstellar", "Space Adventure", 2014, 8.6F, new ArrayList<>(), new ArrayList<>(), 169));
        ProductionService.addProduction(new Movie("Inception", "Dream Adventure", 2010, 8.8F, new ArrayList<>(), new ArrayList<>(), 148));
        ProductionService.addProduction(new Movie("The Dark Knight", "Crime Thriller", 2008, 9.0F, new ArrayList<>(), new ArrayList<>(), 152));
        ProductionService.addProduction(new Movie("The Shawshank Redemption", "Drama", 1994, 9.3F, new ArrayList<>(), new ArrayList<>(), 142));

        ActorService.addActor(new Actor("Bahoi", "Rapper", new TreeSet<>()));
        ActorService.addActor(new Actor("Selly", "Rapper", new TreeSet<>()));
        ActorService.addActor(new Actor("Nane", "Rapper", new TreeSet<>()));

        currentUser = login();

        while (true) {
            System.out.println("1. List all productions");
            System.out.println("2. List all actors");
            System.out.println("3. List all users");
            System.out.println("4. See your favorites");
            System.out.println("5. Add a production to favorites");
            System.out.println("6. Remove a production from favorites");
            System.out.println("7. See your information");
            System.out.println("8. Add an actor");
            System.out.println("9. Add a production");
            System.out.println("10. Remove an actor");
            System.out.println("11. Remove a production");
            System.out.println("12. Exit");
            System.out.println();

            int choice = scanNextInt();

            switch (choice) {
                case 1:
                    for (Production production : ProductionService.getAllProductions())
                        System.out.println(production.getTitle());
                    System.out.println();
                    break;
                case 2:
                    for (Actor actor : ActorService.getAllActors())
                        System.out.println(actor.getName());
                    System.out.println();
                    break;
                case 3:
                    for (User user : UserService.getAllUsers())
                        System.out.println(user.getUsername());
                    System.out.println();
                    break;
                case 4:
                    for (Production production : currentUser.getFavorites())
                        System.out.println(production.getTitle());
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Enter the title of the production:");
                    String title = scanNextLineNonBlank();
                    List<Production> productions = ProductionService.getProductionByTitle(title);
                    if (productions == null) {
                        System.out.println("Production not found!");
                        break;
                    }
                    Production production = productions.get(0);
                    UserService.addFavorite(currentUser, production);
                    System.out.println("Production added to favorites!");
                    break;
                case 6:
                    System.out.println("Enter the title of the production:");
                    title = scanNextLineNonBlank();
                    productions = ProductionService.getProductionByTitle(title);
                    if (productions == null) {
                        System.out.println("Production not found!");
                        break;
                    }
                    production = productions.get(0);
                    UserService.removeFavorite(currentUser, production);
                    System.out.println("Production removed from favorites!");
                    break;
                case 7:
                    System.out.println("Username: " + currentUser.getUsername());
                    System.out.println("Experience: " + currentUser.getExperience());
                    System.out.println("Type: " + currentUser.getType());
                    System.out.println("Email: " + currentUser.getCredentials().getEmail());
                    System.out.println();
                    break;
                case 8:
                    System.out.println("Enter the name of the actor:");
                    String name = scanNextLineNonBlank();
                    System.out.println("Enter the description of the actor:");
                    String description = scanNextLineNonBlank();
                    ActorService.addActor(new Actor(name, description, new TreeSet<>()));
                    System.out.println("Actor added!");
                    break;
                case 9:
                    System.out.println("Enter the title of the production:");
                    title = scanNextLineNonBlank();
                    System.out.println("Enter the description of the production:");
                    description = scanNextLineNonBlank();
                    System.out.println("Enter the year of the production:");
                    int year = scanNextInt();
                    System.out.println("Enter the rating of the production:");
                    float rating = scanner.nextFloat();
                    System.out.println("Enter the duration of the production:");
                    int duration = scanNextInt();
                    ProductionService.addProduction(new Movie(title, description, year, rating, new ArrayList<>(), new ArrayList<>(), duration));
                    System.out.println("Production added!");
                    break;
                case 10:
                    System.out.println("Enter the name of the actor:");
                    name = scanNextLineNonBlank();
                    List<Actor> actors = ActorService.getActorByName(name);
                    if (actors == null) {
                        System.out.println("Actor not found!");
                        break;
                    }
                    Actor actor = actors.get(0);
                    ActorService.removeActor(actor);
                    System.out.println("Actor removed!");
                    break;
                case 11:
                    System.out.println("Enter the title of the production:");
                    title = scanNextLineNonBlank();
                    productions = ProductionService.getProductionByTitle(title);
                    if (productions == null) {
                        System.out.println("Production not found!");
                        break;
                    }
                    production = productions.get(0);
                    ProductionService.removeProduction(production);
                    System.out.println("Production removed!");
                    break;
                case 12:
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