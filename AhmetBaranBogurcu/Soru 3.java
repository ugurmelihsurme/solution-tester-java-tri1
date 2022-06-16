package com.bites;

public class Main {

    public static void main(String[] args) {
        SqrtImpl sqrt = new SqrtImpl();
        System.out.println(sqrt.getSolution(8));
    }
}

class SqrtImpl implements Sqrt {

    @Override
    public int getSolution(int x) {
        Long number = 1L;

        while (number * number <= x) {
            ++number;
        }

        long result = (number - 1);
        return (int) result;
    }
}

interface Sqrt {
    public int getSolution(int x);
}