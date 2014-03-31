package ee.city24.sampleapp.dao;

import ee.city24.sampleapp.entity.User;

import java.util.List;

public interface UserDao extends AbstractDao<User, String> {
    void saveUser(User user);

    List<User> findUsers(String userName);

    List<User> getAllUsers();
}
