package br.com.application.controllers.math.operations;

public interface Operations {

    public static double sum(double value, double value2) {
        return value + value2;
    }
    public static double sub(double value, double value2) {
        return value - value2;
    }
    public static double mult(double value, double value2) {
        return value * value2;
    }
    public static double div(double value, double value2) {
        return value / value2;
    }
    public static double mean(double value, double value2) {
        return (value + value2) / 2;
    }
    public static double sqrt(double value) {
        return Math.sqrt(value);
    }
}
