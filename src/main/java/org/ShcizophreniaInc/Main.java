package org.ShcizophreniaInc;

import org.ShcizophreniaInc.in.controllers.RegistrationServiceController;
import org.ShcizophreniaInc.in.data.UserDAO;
import org.ShcizophreniaInc.in.data.UserDAOImpl;
import org.ShcizophreniaInc.in.services.RegistrationService;
import org.ShcizophreniaInc.in.services.RegistrationServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserDAO userDAO = new UserDAOImpl();
        RegistrationService registrationService = new RegistrationServiceImpl(userDAO);
        RegistrationServiceController registrationServiceController =
                new RegistrationServiceController(registrationService, scanner);

        System.out.println("Hello and welcome!");

        while (true) {
            System.out.println("Select your action:\n" +
                    "1. Authorize.\n" +
                    "2. Sign up.\n" +
                    "3. Logout.\n" +
                    "0. Exit.");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: registrationServiceController.authorizeUser(); break;
                case 2: registrationServiceController.registerUser(); break;
                case 3: registrationServiceController.logoutUser(); break;
                case 0:
                    System.out.println("Program finished");
                    scanner.close();
                    System.exit(0);
                default: System.out.println("Unknown command"); break;
            }
        }

    }
}