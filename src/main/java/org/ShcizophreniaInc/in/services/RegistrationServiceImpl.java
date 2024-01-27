package org.ShcizophreniaInc.in.services;

import org.ShcizophreniaInc.in.data.UserDAO;
import org.ShcizophreniaInc.in.entities.Admin;
import org.ShcizophreniaInc.in.entities.User;

import java.util.Optional;

public class RegistrationServiceImpl implements RegistrationService {
    private final UserDAO userDAO;
    private Optional<User> activeUser = Optional.empty();

    public RegistrationServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void registerUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public void authorizeUser(User user) {
        activeUser = Optional.ofNullable(userDAO.selectUser(user));
        if (activeUser.isEmpty()) {
            System.out.println("Such user does not exist!");
            return;
        }

        if (activeUser.get() instanceof Admin) {
            System.out.println("Welcome aboard, captain!");
        } else {
            System.out.println("Welcome to your profile!");
        }
    }

    @Override
    public void logoutUser() {
        activeUser = Optional.empty();
        System.out.println("Bye!");
    }

    @Override
    public Optional<User> getActiveUser() {
        return activeUser;
    }
}
