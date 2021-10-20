package org.example.controller;

import org.example.entity.LogInfo;
import org.example.service.LogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/log")
public class LogController {
    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/show-info")
    public List<LogInfo> showInfo(@RequestParam String token) {
        return logService.showInfo(token);
    }
}
