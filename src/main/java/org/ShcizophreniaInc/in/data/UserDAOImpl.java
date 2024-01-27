package org.ShcizophreniaInc.in.data;

import org.ShcizophreniaInc.in.entities.Admin;
import org.ShcizophreniaInc.in.entities.User;

import java.util.Map;

public class UserDAOImpl implements UserDAO {
    private Map<String, User> users = Map.ofEntries(Map.entry("admin", new Admin("admin", "admin")));
    @Override
    public void addUser(User user) {
        if (users.containsKey(user.getUsername())) {
            System.out.println("This name is occupied, try something else");
            return;
        }

        users.put(user.getUsername(), user);
    }

    @Override
    public User selectUser(User user) {
        try {
            return users.get(user.getUsername());
        } catch (Exception e) {
            System.out.println("Can't find such user");
        }
        return null;
    }
}
