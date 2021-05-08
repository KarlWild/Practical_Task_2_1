package com.company.task4;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class DeserializeMyClassToBePersisted {
    MyClassToBePersisted object;
    public DeserializeMyClassToBePersisted(){
        object = new MyClassToBePersisted();
    }

    public MyClassToBePersisted getObject() {
        return object;
    }

    public void deserializeObject(ObjectInput in) throws IOException, ClassNotFoundException {
        object = (MyClassToBePersisted) in.readObject();
    }
}
