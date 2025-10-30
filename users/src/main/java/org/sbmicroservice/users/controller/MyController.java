package org.sbmicroservice.users.controller;

import org.sbmicroservice.orders.entity.Orders;
import org.sbmicroservice.users.Repo.UserRepo;
import org.sbmicroservice.users.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyController {

    @Autowired
    private UserRepo userRepo;

//======== код Николая ================================================
    @GetMapping("/users")
    @ResponseBody
    public Iterable<Users> susers() {
        return userRepo.findAll();
    }

    @PostMapping("/users")
    @ResponseBody
    public ResponseEntity<?> registerUser(@RequestBody Users user) {
       if (user.getId() > 0) {userRepo.deleteById(user.getId());}
       else userRepo.save(user);
       return ResponseEntity.noContent().build();
    }

//======== конец кода Николая =========================================

}
