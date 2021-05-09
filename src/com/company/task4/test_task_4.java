package com.company.task4;

import java.io.*;

public class test_task_4 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Task 4: Serialize and Deserialize MyClassToBePersisted");
        FileOutputStream fileOutputStream = new FileOutputStream("src/com/company/files/object.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        SerializeMyClassToBePersisted myClassToBePersisted = new SerializeMyClassToBePersisted();
        myClassToBePersisted.serializeObject(objectOutputStream);
        FileInputStream fileInputStream = new FileInputStream("src/com/company/files/object.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        DeserializeMyClassToBePersisted deserializeMyClassToBePersisted = new DeserializeMyClassToBePersisted();
        deserializeMyClassToBePersisted.deserializeObject(objectInputStream);
        MyClassToBePersisted object = deserializeMyClassToBePersisted.getObject();
        System.out.println(object.getGroup() + ' ' + object.getProfile());
    }
}