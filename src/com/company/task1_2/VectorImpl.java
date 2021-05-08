package com.company.task1_2;

public class VectorImpl {
    private double[] coordinates;
    private int length;

    public VectorImpl() {
        double[] a = {0};
        this.set(a);
    }
    public VectorImpl(double[] elements){
        this.set(elements);
    }
    public void set(double... elements) {
        length = elements.length-1;
        coordinates = new double[length];
        for(int i = 0;i < length; i++){
            coordinates[i] = elements[i+1];
        }
    }
    public double[] get() {
        return coordinates;
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
}







