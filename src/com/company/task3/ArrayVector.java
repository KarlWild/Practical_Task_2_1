package com.company.task3;

import java.io.Serializable;
import java.util.Arrays;

public class ArrayVector implements Serializable {

    private double[] coordinates;
    private int length;
    private static final long serialVersionUID = 2L;// уникальный идентификатор версии сериализованного класса

    public ArrayVector() {
        double[] a = {0};
        this.set(a);
    }

    public ArrayVector(double[] elements) {
        this.set(elements);
    }

    public void set(double... elements) {
        coordinates = elements;
        length = elements.length;
    }

    public double[] get() {
        return coordinates;
    }


    public ArrayVector clone() {
        double[] a = coordinates.clone();
        return new ArrayVector(a);

    }


    public int getSize() {
        return length;
    }


    public void set(int index, double value) throws ArrayIndexOutOfBoundsException {
        if (index >= 0) {
            if (index >= getSize()) {
                double[] a = new double[index+1];
                for (int i = 0; i < length; i++) a[i] = coordinates[i];
                a[index] = value;
                this.set(a);
            }
            else coordinates[index] = value;
        }
    }


    public double get(int index) throws ArrayIndexOutOfBoundsException {
        return coordinates[index];
    }


    public double getMax() {
        return Arrays.stream(coordinates).max().getAsDouble();
    }


    public double getMin() {
        return Arrays.stream(coordinates).min().getAsDouble();
    }


    public void sortAscending() {
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (coordinates[i] > coordinates[j]) {
                    double a = coordinates[i];
                    coordinates[i] = coordinates[j];
                    coordinates[j] = a;
                }
            }
        }
    }


    public void mult(double factor) {
        for (int i = 0; i < length; i++) {
            coordinates[i] *= factor;
        }
    }


    public ArrayVector sum(ArrayVector anotherVector) {
        for (int i = 0; i < anotherVector.getSize(); i++) {
            coordinates[i] += anotherVector.get(i);
        }
        return this;
    }


    public double scalarMult(ArrayVector anotherVector) {
        double sum = 0;
        for (int i = 0; i < anotherVector.getSize(); i++) {
            sum += coordinates[i] * anotherVector.get(i);
        }
        return sum;
    }


    public double getNorm() {
        return Math.sqrt(scalarMult(this));
    }
}
