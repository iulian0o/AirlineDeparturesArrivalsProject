package com.Iulian_Jaimie.airline.controller;

import com.Iulian_Jaimie.airline.entity.MilesReward;
import com.Iulian_Jaimie.airline.repository.MilesRewardRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/miles")
@CrossOrigin(origins = "*")
public class MilesRewardController {

    private final MilesRewardRepository repository;

    public MilesRewardController(MilesRewardRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<MilesReward> getAllRewards() {
        return repository.findAll();
    }

    @PostMapping
    public MilesReward addReward(@RequestBody MilesReward reward) {
        return repository.save(reward);
    }
}