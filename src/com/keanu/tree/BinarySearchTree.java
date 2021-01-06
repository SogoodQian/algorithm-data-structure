package com.keanu.tree;

import java.util.Comparator;

public class BinarySearchTree<E> {
    private int size;
    private Node<E> root;

    private Comparator<E> comparator;

    private static class Node<E>{
        E element;
        Node<E> parent;
        Node<E> left;
        Node<E> right;

        public Node(E element, Node<E> parent){
           this.element = element;
           this.parent = parent;
        }
    }

    public BinarySearchTree(){
        this(null);
    }

    public BinarySearchTree(Comparator<E> comparator){
        this.comparator = comparator;
    }

    private void elementNotNullCheck(E element){
        if(element==null){
            throw new IllegalArgumentException("element not be null");
        }
    }

    /**
     * 比较大小，待实现
     * @param e1
     * @param e2
     * @return 0表示相等，1表示e1>e2, -1表示e1<e2
     */
    private int compare(E e1, E e2){
        if(this.comparator != null){
            return this.comparator.compare(e1, e2);
        }
        return ((Comparable<E>)e1).compareTo(e2);
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size==0;
    }

    public void clear(){

    }

    public void add(E element){
        elementNotNullCheck(element);

        // 添加第一个节点
        if(this.root == null){
            this.root = new Node<>(element, null);
            this.size++;
            return;
        }

        // 添加不是第一个节点
        Node<E> parent = this.root;
        Node<E> node = this.root;
        int cmp = compare(element, node.element);
        while (node!=null){
            parent = node;
            if(cmp>0){
                node = node.right;
            }else if(cmp<0){
                node = node.left;
            }else{
                return;
            }
        }

        Node<E> newNode = new Node<>(element,node);
        if(cmp>0){
            parent.right = newNode;
        }else{
            parent.left = newNode;
        }

        this.size++;
    }

    public void remove(E element){

    }

    public boolean contains(E element){
        return false;
    }
}
