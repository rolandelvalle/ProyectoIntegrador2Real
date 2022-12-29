package com.ejercicio.springbootapirest.controller;

import com.ejercicio.springbootapirest.datos.User;
import com.ejercicio.springbootapirest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping( "/v1/user" )
public class UserController {
    private final UserService userService;

    public UserController(@Autowired UserService userService )
    {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<HashMap<Integer, User>> all()
    {
        return new ResponseEntity<>(userService.all(), HttpStatus.OK);
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<User> findById( @PathVariable("id") Integer id )
    {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<User> create( @RequestBody User userDto)
    {
        return new ResponseEntity<>(userService.create(userDto), HttpStatus.CREATED);
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<User> update( @RequestBody User userDto, @PathVariable("id") Integer id )
    {
        return new ResponseEntity<>(userService.update(userDto, id), HttpStatus.OK);
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity delete( @PathVariable("id") Integer id )
    {
        User user = userService.deleteById(id);
        if (user != null){
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
