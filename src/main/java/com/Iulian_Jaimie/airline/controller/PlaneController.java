package com.Iulian_Jaimie.airline.controller;

import com.Iulian_Jaimie.airline.entity.Plane;
import com.Iulian_Jaimie.airline.service.PlaneService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/planes")
@CrossOrigin(origins = "*")
public class PlaneController {
    private final PlaneService service;

    public PlaneController(PlaneService service) { this.service = service; }

    @PostMapping
    public Plane addPlane(@RequestBody Plane plane) {
        return service.addPlane(plane);
    }

    @GetMapping
    public List<Plane> getAllPlanes() {
        return service.getAllPlanes();
    }

    @DeleteMapping("/{id}")
    public void deletePlane(@PathVariable Long id) {
        service.deletePlane(id);
    }
}