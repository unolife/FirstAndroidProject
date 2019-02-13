package com.project.coding101.my.gradeCalculator;

public class Grade {
    public Integer input;
    public Integer one_one;
    public Integer one_two;
    public Integer two_one;
    public Integer two_two;
    public Integer three_one;
    public Integer three_two;
    public Integer four_one;
    public Integer four_two;
    public Integer total;
    public Integer getInput() {
        return input;
    }

    public void setInput(Integer input) {
        this.input = input;
    }

    public Integer getOne_one() {
        return one_one;
    }

    public void setOne_one(Integer one_one) {
        this.one_one = one_one;
    }

    public Integer getOne_two() {
        return one_two;
    }

    public void setOne_two(Integer one_two) {
        this.one_two = one_two;
    }

    public Integer getTwo_one() {
        return two_one;
    }

    public void setTwo_one(Integer two_one) {
        this.two_one = two_one;
    }

    public Integer getTwo_two() {
        return two_two;
    }

    public void setTwo_two(Integer two_two) {
        this.two_two = two_two;
    }

    public Integer getThree_one() {
        return three_one;
    }

    public void setThree_one(Integer three_one) {
        this.three_one = three_one;
    }

    public Integer getThree_two() {
        return three_two;
    }

    public void setThree_two(Integer three_two) {
        this.three_two = three_two;
    }

    public Integer getFour_one() {
        return four_one;
    }

    public void setFour_one(Integer four_one) {
        this.four_one = four_one;
    }

    public Integer getFour_two() {
        return four_two;
    }

    public void setFour_two(Integer four_two) {
        this.four_two = four_two;
    }

    public Grade(){}
    public Grade(Integer input, Integer one_one, Integer one_two, Integer two_one, Integer two_two, Integer three_one, Integer three_two
    ,Integer four_one, Integer four_two, Integer total){
        this.input=input;
        this.one_one=one_one;
        this.one_two=one_two;
        this.two_one=two_one;
        this.two_two=two_two;
        this.three_one=three_one;
        this.three_two=three_two;
        this.four_one=four_one;
        this.four_two=four_two;
        this.total =total;
    }


}
