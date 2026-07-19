package com.eldernest.controller;

import com.eldernest.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/health")
public class HealthController {

    @GetMapping
    public ResponseEntity<ApiResponse<Map<String, String>>> checkHealth() {

        Map<String, String> healthData = new LinkedHashMap<>();

        healthData.put("status", "UP");
        healthData.put("application", "ElderNest Backend");

        ApiResponse<Map<String, String>> response =
                new ApiResponse<>(
                        true,
                        "Health check successful",
                        healthData
                );

        return ResponseEntity.ok(response);
    }
}