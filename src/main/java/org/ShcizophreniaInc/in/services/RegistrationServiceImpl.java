package org.ShcizophreniaInc.in.services;

import org.ShcizophreniaInc.in.data.UserDAO;
import org.ShcizophreniaInc.in.entities.Admin;
import org.ShcizophreniaInc.in.entities.User;

public class RegistrationServiceImpl implements RegistrationService {
    private final UserDAO userDAO;
    private User activeUser = null;

    public RegistrationServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void registerUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public void authorizeUser(User user) {
        activeUser = userDAO.selectUser(user);
        if (activeUser == null) {
            System.out.println("Such user does not exist!");
            return;
        }

        if (activeUser instanceof Admin) {
            System.out.println("Welcome aboard, captain!");
        } else {
            System.out.println("Welcome to your profile!");
        }
    }

    @Override
    public void logoutUser() {
        activeUser = null;
        System.out.println("Bye!");
    }

    @Override
    public User getActiveUser() {
        return activeUser;
    }
}
