package com.company.task4;

import java.io.Serializable;

public class MyClassToBePersisted implements Serializable {
    private static final long serialVersionUID = 1L;
    private String profile;
    private String group;

    public MyClassToBePersisted(){
        profile = "profile1";
        group = "1.2";
    }

    public String getGroup() {
        return group;
    }

    public String getProfile() {
        return profile;
    }
}
