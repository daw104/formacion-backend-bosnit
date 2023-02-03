package com.example.block6pathvariableheaders.block6pathvariableheaders.controllers;

import com.example.block6pathvariableheaders.block6pathvariableheaders.models.User;
import com.example.block6pathvariableheaders.block6pathvariableheaders.configurations.UserConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserConfiguration userConfiguration;

    private static AtomicLong counter = new AtomicLong();

    //Añadir usuarios
    @PostMapping(value = ("/addUser"))
    public User addUser(@RequestBody User user){
        user.setId(counter.incrementAndGet());
        user.setName(user.getName());
        return user;
    }

    @GetMapping(value = "/{id}")
    public int getId(@PathVariable int id ){
        return id;
    }


// *3    Petición PUT: mandando  Request Params (http://localhost:8080/post?var1=1&var2=2) devolver un HashMap con los datos mandados .
//    Por ejemplo: [ {var1: 1}, {var2: 2} ]
//            @PutMapping(value = "/post" )
//    public String putId(@RequestParam Map<String, Integer> parametros){
//        return "Los parametros son: " + parametros.entrySet();
//    }
    @PutMapping(value = "/post" )
    public HashMap putIdV2(@RequestParam (name ="var1") String param1 , @RequestParam (name ="var2") String param2){
        return userConfiguration.createMap(param1, param2);
    }


}
