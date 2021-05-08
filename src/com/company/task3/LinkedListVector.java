package com.company.task3;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class LinkedListVector implements Serializable {

    private LinkedList<Double> coordinates;
    private int length;

    /**
     * serialVersionUID - уникальный идентификатор версии сериализованного класса
     * Крайне рекомендуется всем сериализуемым классам декларировать это поле в явном виде,
     * ибо вычисление по умолчанию очень чувствительно к деталям структуры класса, которые могут различаться
     * в зависимости от реализации компилятора, и вызывать таким образом неожиданные InvalidClassException при десериализации. Объявлять это поле
     * лучше как private, т.к. оно относится исключительно к классу, в котором объявляется.
     */
    private static final long serialVersionUID = 1L;

    public LinkedListVector() {
        LinkedList<Double> list = new LinkedList<>();
        list.add(0.0);
        this.set(list);
    }

    public LinkedListVector(LinkedList<Double> elements) {
        this.set(elements);
    }

    public void set(LinkedList<Double> elements) {
        coordinates = elements;
        length = elements.size();
    }

    public LinkedList<Double> get() {
        return coordinates;
    }


    public LinkedListVector clone() {
        LinkedList<Double> a = (LinkedList) coordinates.clone();
        return new LinkedListVector(a);

    }


    public int getSize() {
        return length;
    }


    public void set(int index, double value) throws ArrayIndexOutOfBoundsException {
        if(index >= 0) {
            if(index >= getSize()) coordinates.add(value);
            else coordinates.set(index, value);
        }
    }


    public double get(int index) throws ArrayIndexOutOfBoundsException {
        return coordinates.get(index);
    }


    public double getMax() {
        double max = Double.MIN_VALUE;
        for(double a : coordinates) if(a>max) max = a;
        return max;
    }


    public double getMin() {
        double min = Double.MAX_VALUE;
        for(double a : coordinates) if(a<min) min = a;
        return min;
    }


    public void sortAscending() {
        Collections.sort(coordinates);
    }


    public void mult(double factor) {
        LinkedList<Double> list = new LinkedList<>();
        for(double a : coordinates){
            list.add(a*factor);
        }
        this.set(list);
    }


    public LinkedListVector sum(LinkedListVector anotherVector) {
        LinkedList<Double> list = new LinkedList<>();
        int i = 0;
        for(double a : coordinates) if(i!=anotherVector.getSize()) list.add(a + anotherVector.get(i++));
        this.set(list);
        return this;
    }


    public double scalarMult(LinkedListVector anotherVector) {
        double sum = 0;
        int i =0;
        for(double a : coordinates) if(i!=anotherVector.getSize()) sum += a * anotherVector.get(i++);
        return sum;
    }


    public double getNorm() {
        return Math.sqrt(scalarMult(this));
    }
}
