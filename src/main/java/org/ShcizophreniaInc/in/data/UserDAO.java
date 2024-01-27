package org.ShcizophreniaInc.in.data;

import org.ShcizophreniaInc.in.entities.User;

public interface UserDAO {
    void addUser(User user);
    User selectUser(User user);
}
