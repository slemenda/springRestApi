package com.example.chiquita.controllers;

import com.example.chiquita.entities.Statistics;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/v1")
public class DashboardController {

    @GetMapping("/statistics")
    public ResponseEntity<Object> statistics() {
        Statistics statistics = new Statistics(580, 12, 1621, 58);

        return ResponseEntity.ok().body(statistics);
    }
}
