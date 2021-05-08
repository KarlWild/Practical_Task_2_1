package com.company.task3;

import java.io.*;

public class SaveLoad {
    public void saveLinkedList(LinkedListVector listVector) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/mac/Downloads/Practical_Task_2_1/src/com/company/files/savedLinked.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(listVector);
        outputStream.close();
    }

    public void saveArrayVector(ArrayVector listVector) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/mac/Downloads/Practical_Task_2_1/src/com/company/files/savedArrayVector.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(listVector);
        outputStream.close();
    }

    public LinkedListVector loadLinkedList() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("/Users/mac/Downloads/Practical_Task_2_1/src/com/company/files/savedLinked.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return  (LinkedListVector) objectInputStream.readObject();
    }

    public ArrayVector loadArrayVector() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("/Users/mac/Downloads/Practical_Task_2_1/src/com/company/files/savedArrayVector.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return (ArrayVector) objectInputStream.readObject();
    }
}
