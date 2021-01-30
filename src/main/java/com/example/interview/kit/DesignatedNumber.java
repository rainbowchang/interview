package com.example.interview.kit;

public enum DesignatedNumber {
    Three("Fizz", 3), Five("Buzz", 5), Seven("Whizz", 7);

    private String name;
    private int index;

    private DesignatedNumber(String name, Integer index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public Integer getIndex() {
        return index;
    }
}
