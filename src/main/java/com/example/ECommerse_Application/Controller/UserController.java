package com.example.ECommerse_Application.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ECommerse_Application.Entity.User;
import com.example.ECommerse_Application.Service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("All")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
    
   // @PostMapping("/saveuser")
    //public User createUsertest(@RequestBody User user) {
      //  return userService.saveUser(user);
    //}

    

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        Optional<User> optionalUser = userService.getUserById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUserName(userDetails.getUserName());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            user.setPhoneno(userDetails.getPhoneno());
            return ResponseEntity.ok(userService.saveUser(user));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
