package org.ShcizophreniaInc.in.controllers;

import org.ShcizophreniaInc.in.entities.User;
import org.ShcizophreniaInc.in.services.RegistrationService;

import java.util.Scanner;

public class RegistrationServiceController {
    private final RegistrationService registrationService;
    private final Scanner scanner;
    public RegistrationServiceController(RegistrationService registrationService, Scanner scanner) {
        this.registrationService = registrationService;
        this.scanner = scanner;
    }

    public void registerUser() {
        if (registrationService.getActiveUser().isPresent()) {
            System.out.println("Logout from this account in order to create new!");
            logoutUser();
            return;
        }

        System.out.println("Create username: ");
        String username = scanner.nextLine();
        System.out.println("Create password: ");
        String password = scanner.nextLine();

        try {
            registrationService.registerUser(new User(username, password));
            System.out.println("You've successfully created an account!");
        } catch (Exception e) {
            System.out.println("Couldn't create user, please contact support: " + e.getMessage());
        }
    }

    public void authorizeUser() {
        if (registrationService.getActiveUser().isPresent()) {
            System.out.println("You need to logout from your account to log in another!");
            logoutUser();
            return;
        }

        System.out.println("Enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        try {
            registrationService.authorizeUser(new User(username, password));
        } catch (Exception e) {
            System.out.println("Couldn't authorize this user, please contact support: " + e.getMessage());
        }
    }

    public void logoutUser() {
        if (registrationService.getActiveUser().isEmpty()) {
            System.out.println("No one is logged!");
            return;
        }

        System.out.println("Are you sure you want to quit? y/n");
        switch (scanner.nextLine()) {
            case "y": registrationService.logoutUser(); break;
            case "n": System.out.println("Well then, what do you need?"); break;
            default: System.out.println("Unknown command"); break;
        }
    }
}
