package com.example.interview.kit;

/**
 * 保存每个报数的结果
 */
public class NumberResultItem {
    private int number;
    private String speak;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getSpeak() {
        return speak;
    }

    public void setSpeak(String speak) {
        this.speak = speak;
    }

    @Override
    public String toString() {
        return "NumberResultItem{" +
                "number=" + number +
                ", speak='" + speak + '\'' +
                '}';
    }
}
