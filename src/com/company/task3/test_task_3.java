package com.company.task3;

import java.io.IOException;
import java.util.LinkedList;

public class test_task_3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Task 3: Serialized LinkedListVector and ArrayVector");
        LinkedList<Double> list = new LinkedList<>();
        list.add(4.0);
        list.add(3.0);
        list.add(2.0);
        list.add(1.0);
        list.add(0.0);
        LinkedListVector listVector = new LinkedListVector(list);

        ArrayVector arrayVector = new ArrayVector(new double[]{4, 5, 6, 7});
        SaveLoad saveLoad = new SaveLoad();

        saveLoad.saveArrayVector(arrayVector);
        saveLoad.saveLinkedList(listVector); // сохраняем объект в файл
        ArrayVector copiedArrayVector = saveLoad.loadArrayVector();
        LinkedListVector copiedVector = saveLoad.loadLinkedList(); // загружаем объект из файла
        System.out.println("Serialized LinkedListVector: " + copiedVector.get());
        System.out.println("Serialized ArrayVector: " + copiedArrayVector.get());
        System.out.println("Serialized LinkedListVector == Original LinkedListVector? " + (copiedVector == listVector));
        System.out.println("Serialized ArrayVector == Original ArrayVector? " + (copiedArrayVector == arrayVector));
        System.out.println("Serialized LinkedListVector equals Original LinkedListVector? " + copiedVector.equals(listVector));
        System.out.println("Serialized ArrayVector equals Original ArrayVector? " + copiedArrayVector.equals(arrayVector));
    }
}
