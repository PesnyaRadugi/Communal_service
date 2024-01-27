package org.ShcizophreniaInc.in.services;

import org.ShcizophreniaInc.in.entities.User;

public interface RegistrationService {
    void registerUser(User user);
    void authorizeUser(User user);
    void logoutUser();
    User getActiveUser();
}
