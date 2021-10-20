package org.example.controller;

import org.example.service.CalculatorService;
import org.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @Autowired
    private LoginService loginService;

    @PostMapping("/sum")
    public double sum(@RequestParam(required = false) Double firstElem,
                      @RequestParam Double secondElem, @RequestParam String token) {
        loginService.checkAuthorization(token);
        return calculatorService.sum(firstElem, secondElem, token);
    }

    @PostMapping("/sub")
    public double sub(@RequestParam(required = false) Double firstElem,
                      @RequestParam Double secondElem, @RequestParam String token) {
        loginService.checkAuthorization(token);
        return calculatorService.sub(firstElem, secondElem, token);
    }

    @PostMapping("/div")
    public double div(@RequestParam(required = false) Double firstElem,
                      @RequestParam Double secondElem, @RequestParam String token) {
        loginService.checkAuthorization(token);
        return calculatorService.div(firstElem, secondElem, token);
    }

    @PostMapping("/mul")
    public double mul(@RequestParam(required = false) Double firstElem,
                      @RequestParam Double secondElem, @RequestParam String token) {
        loginService.checkAuthorization(token);
        return calculatorService.mul(firstElem, secondElem, token);
    }
}
