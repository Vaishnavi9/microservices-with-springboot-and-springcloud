package com.practice.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private static Integer userCount = 0;
    private static Integer generateId() {
        return ++userCount;
    }
    static {
        users.add(new User(generateId(), "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(generateId(), "Eve", LocalDate.now().minusYears(25)));
        users.add(new User(generateId(), "Jim", LocalDate.now().minusYears(27)));
        users.add(new User(generateId(), "Jade", LocalDate.now().minusYears(29)));
    }

    public List<User> findAll(){
        return users;
    }

    public User findByUserId(Integer id) {
        return users.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }

    public void deleteByUserId(Integer id) {
        users.removeIf(user -> user.getId().equals(id));
    }

    public User createNewUser(User user) {
        user.setId(generateId());
        users.add(user);
        return user;
    }
}
