package com.keanu.main;

import com.keanu.list.AbstractList;
import com.keanu.list.LinkedList;
import com.keanu.list.List;

public class Main {

    public static void main(String[] args) {
        AbstractList<Integer> arrayList = new LinkedList<Integer>();

        arrayList.add(99);
        arrayList.add(88);
        arrayList.add(77);

        arrayList.remove(0);

        System.out.println(arrayList);
    }
}
