package com.company.task4;

import java.io.IOException;
import java.io.ObjectOutput;

public class SerializeMyClassToBePersisted {
    MyClassToBePersisted object;
    public SerializeMyClassToBePersisted(){
        object = new MyClassToBePersisted();
    }

    public MyClassToBePersisted getObject() {
        return object;
    }

    public void serializeObject(ObjectOutput out) throws IOException {
        out.writeObject(object);
    }

}
