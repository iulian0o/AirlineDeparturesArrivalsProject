package com.Iulian_Jaimie.airline.service;

import com.Iulian_Jaimie.airline.entity.Plane;
import com.Iulian_Jaimie.airline.repository.PlaneRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlaneService {
    private final PlaneRepository repository;

    public PlaneService(PlaneRepository repository) {
        this.repository = repository;
    }

    public Plane addPlane(Plane plane) {
        return repository.save(plane);
    }

    public List<Plane> getAllPlanes() {
        return repository.findAll();
    }

    public void deletePlane(Long id) {
        repository.deleteById(id);
    }
}