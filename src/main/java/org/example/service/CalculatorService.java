package org.example.service;

import org.example.entity.LogInfo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CalculatorService {

    private final LogService logService;

    public CalculatorService(LogService logService) {
        this.logService = logService;
    }

    private final Map<String, Double> sumMap = new HashMap<>();

    public double sum(Double firstElem, Double secondElem, String token) {
        return operation(firstElem, token, sumMap.get(token) != null ? sumMap.get(token) : 0 + secondElem,
                firstElem + secondElem, secondElem);
    }

    public double sub(Double firstElem, Double secondElem, String token) {
        return operation(firstElem, token, sumMap.get(token) != null ? sumMap.get(token) : 0 - secondElem,
                firstElem - secondElem, secondElem);
    }

    public double div(Double firstElem, Double secondElem, String token) {
        return operation(firstElem, token, sumMap.get(token) != null ? sumMap.get(token) : 0 / secondElem,
                firstElem / secondElem, secondElem);
    }

    public double mul(Double firstElem, Double secondElem, String token) {
        return operation(firstElem, token, sumMap.get(token) != null ? sumMap.get(token) : 0 * secondElem,
                firstElem * secondElem, secondElem);
    }

    private double operation(Double firstElem, String token, double mapSum,
                             double elemSum, Double secondElem) {
        double sum;
        if (firstElem == null) {
            sum = mapSum;
        } else {
            sumMap.remove(token);
            sum = elemSum;
        }
        sumMap.put(token, sum);
        logService.putInfo(token, new LogInfo(firstElem, secondElem, sum));
        return sum;
    }
}