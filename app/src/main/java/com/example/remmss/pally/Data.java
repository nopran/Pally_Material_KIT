package com.example.remmss.pally;

/**
 * Created by wolfsoft1 on 3/3/17.
 */

public class Data {


    private String name;

    private String description;

    public Data(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
