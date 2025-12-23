package com.Iulian_Jaimie.airline.controller;

import com.Iulian_Jaimie.airline.entity.Client;
import com.Iulian_Jaimie.airline.entity.Employee;
import com.Iulian_Jaimie.airline.entity.User;
import com.Iulian_Jaimie.airline.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {
    private final UserService service;

    public UserController(UserService service) { this.service = service; }

    @GetMapping
    public List<User> getAllUsers() { return service.getAllUsers(); }

    @PostMapping("/client")
    public Client addClient(@RequestBody Client client) {
        return service.addClient(client);
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return service.addEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) { service.deleteUser(id); }
}