package com.Iulian_Jaimie.airline.service;

import com.Iulian_Jaimie.airline.entity.Client;
import com.Iulian_Jaimie.airline.entity.Employee;
import com.Iulian_Jaimie.airline.entity.User;
import com.Iulian_Jaimie.airline.repository.ClientRepository;
import com.Iulian_Jaimie.airline.repository.EmployeeRepository;
import com.Iulian_Jaimie.airline.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ClientRepository clientRepository;
    private final EmployeeRepository employeeRepository;

    public UserService(UserRepository userRepository, ClientRepository clientRepository, EmployeeRepository employeeRepository) {
        this.userRepository = userRepository;
        this.clientRepository = clientRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}