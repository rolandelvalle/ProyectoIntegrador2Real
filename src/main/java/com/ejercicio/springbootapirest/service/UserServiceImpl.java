package com.ejercicio.springbootapirest.service;

import com.ejercicio.springbootapirest.datos.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserServiceImpl implements UserService{

    private int count = 0;

    HashMap<Integer, User> userHashMap = new HashMap<>();

    @Override
    public User create(User user) {
        this.count ++;
        Integer key = count;
        return userHashMap.put(key, user);

    }

    @Override
    public User findById(Integer id) {
        return userHashMap.get(id);
    }

    @Override
    public HashMap<Integer, User> all() {

        return userHashMap;
    }

    @Override
    public User deleteById(Integer id) {
        userHashMap.remove(id);
        return null;
    }

    @Override
    public User update(User user, Integer userId) {
        userHashMap.replace(userId, user);
        return null;
    }
}
