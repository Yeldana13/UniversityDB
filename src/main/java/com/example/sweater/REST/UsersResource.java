package com.example.sweater.REST;


import com.example.sweater.domain.Users;
import com.example.sweater.Repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="rest/users")
public class UsersResource {

    @Autowired
    UsersRepo usersReposiroty;

    @GetMapping(value="/all")
    public List<Users> getall(){
        return usersReposiroty.findAll();
    }
    @PostMapping(value="/load")
    public List<Users> persist(@RequestParam String username, @RequestParam int salary){
        Users user = new Users(salary,username);
        usersReposiroty.save(user);
        return usersReposiroty.findAll();
    }
    @GetMapping(value="/id")
    public Users getById(@RequestParam int id)
    {
        return usersReposiroty.findById(id);
    }
    }

