package com.ejercicio.springbootapirest.service;

import com.ejercicio.springbootapirest.datos.User;

import java.util.HashMap;

public interface UserService {

    User create(User user );

    User findById( Integer id );

    HashMap<Integer, User> all();

    User deleteById(Integer id );

    User update( User user, Integer userId );
}
