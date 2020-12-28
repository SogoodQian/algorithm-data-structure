package com.keanu.main;

import com.keanu.list.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(99);
        arrayList.add(88);
        arrayList.add(77);

        arrayList.remove(0);

        System.out.println(arrayList);
    }
}
