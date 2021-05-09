package com.company.task1_2;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Vectors {
    /**
     * Умножение вектора на число
     *
     * @param a      - вектор, который будем умножать
     * @param factor - число, на которое умножаем
     * @return вектор a
     */
    public static VectorImpl mult(VectorImpl a, double factor) {
        for (int i = 0; i < a.getSize(); i++) {
            a.set(i, a.get(i) * factor);
        }
        return a;
    }

    /**
     * Сумма двух векторов
     *
     * @param a - вектор
     * @param b - вектор
     * @return сумму векторов a и b
     */
    public static VectorImpl sum(VectorImpl a, VectorImpl b) {
        VectorImpl vectorImpl = new VectorImpl();
        for (int i = 0; i < b.getSize(); i++) {
            if (i < a.getSize())
                vectorImpl.set(i, a.get(i) + b.get(i));
        }
        return vectorImpl;
    }

    /**
     * Скалярное умножение двух векторов
     *
     * @param a - вектор
     * @param b - вектор
     * @return результат скалярного умножения
     */
    public static double scalarMult(VectorImpl a, VectorImpl b) {
        double sum = 0;
        for (int i = 0; i < b.getSize(); i++) {
            if (i < a.getSize())
                sum += a.get(i) * b.get(i);
        }
        return sum;
    }

    /**
     * Запись вектора в байтовый поток
     *
     * @param v   - вектор для записи
     * @param out - байтовый поток
     */
    public void outputVector(VectorImpl v, OutputStream out) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(v.getSize() + " ");
        for (double a : v.get()) sb.append(a + " ");
        byte[] buffer = sb.toString().getBytes();
        try {
            out.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ;
        System.out.println(out.toString());
        //out.close();
    }

    /**
     * Чтение вектора из байтового потока
     *
     * @param in - байтовый поток
     * @return
     */
    public VectorImpl inputVector(InputStream in) throws IOException {
        byte[] a = in.readAllBytes();
        //in.close();
        String result = new String(a, StandardCharsets.UTF_8);
        StringTokenizer stringTokenizer = new StringTokenizer(result, " ");
        List<Double> data = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            data.add(Double.parseDouble(stringTokenizer.nextToken()));
        }
        double[] elements = new double[data.size()];
        int i = 0;
        for (double e : data) elements[i++] = e;
        return new VectorImpl(elements);
    }

    /**
     * Запись вектора в символьный поток
     *
     * @param v   - вектор
     * @param out - символьный поток
     */
    public void writeVector(VectorImpl v, Writer out) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(v.getSize() + " ");
        for (double a : v.get()) sb.append(a + " ");
        char[] buffer = sb.toString().toCharArray();
        try {
            out.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ;
        System.out.println(out.toString());
        //out.close();
    }

    /**
     * Чтение вектора из символьного потока
     *
     * @param in - поток
     * @return считанный вектор
     */
    public VectorImpl readVector(Reader in) throws IOException {
        StringBuilder sb = new StringBuilder();
        try {
            int data = in.read();
            while (data != -1 && data != 10) { //10 - это символ новой строки
                sb.append((char) data);
                data = in.read();
            }
            //in.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        StringTokenizer stringTokenizer = new StringTokenizer(sb.toString(), " ");
        List<Double> data = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            data.add(Double.parseDouble(stringTokenizer.nextToken()));
        }
        double[] elements = new double[data.size()];
        int i = 0;
        for (double e : data) elements[i++] = e;
        return new VectorImpl(elements);
    }
}
