package ee.city24.sampleapp.service;

import ee.city24.sampleapp.entity.User;

import java.util.List;

public interface UserService {

    User findByUserName(String userName);

    void saveUser(User user);

    void deleteUser(String userName);

    List<User> findUsers(String user);

    List<User> getAllUsers();

    long countUsers();
}
