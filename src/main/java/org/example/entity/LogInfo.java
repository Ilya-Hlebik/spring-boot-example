package org.example.entity;

public class LogInfo {
    private Double firstElement;
    private Double secondElement;
    private Double sum;

    public LogInfo(Double firstElement, Double secondElement, Double sum) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
        this.sum = sum;
    }

    public Double getFirstElement() {
        return firstElement;
    }

    public void setFirstElement(Double firstElement) {
        this.firstElement = firstElement;
    }

    public Double getSecondElement() {
        return secondElement;
    }

    public void setSecondElement(Double secondElement) {
        this.secondElement = secondElement;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }
}
