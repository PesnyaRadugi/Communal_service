package org.ShcizophreniaInc.in.services;

import org.ShcizophreniaInc.in.entities.User;

import java.util.Optional;

public interface RegistrationService {
    void registerUser(User user);
    void authorizeUser(User user);
    void logoutUser();
    Optional<User> getActiveUser();
}
