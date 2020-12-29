package com.keanu.list;

public class LinkedList<E> extends AbstractList<E> {

    private Node<E> first;

    @Override
    public void clear() {
        this.size = 0;
        this.first = null;
    }

    @Override
    public E get(int index) {
        return this.node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        Node<E> newNode = new Node<>(element, null);
        if(index == 0){
            newNode.next = first;
            first = newNode;
        }else{
            Node<E> pre = node(index-1);
            newNode.next = pre.next;
            pre.next = newNode;
        }
        size++;
    }

    @Override
    public E remove(int index) {
        Node<E> node = first;
        if(index==0){
            first = first.next;
        }else{
            Node<E> pre = node(index-1);
            node = pre.next;
            pre.next = node.next;
        }
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        if(element == null){
            for (int i=0; i<size; i++){
                if(node.element == null){
                    return i;
                }
                node = node.next;
            }
        }else{
            for (int i=0; i<size; i++){
                if(node.element.equals(element)){
                    return i;
                }
                node = node.next;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * 获取index位置的node对象
     * @param index
     * @return
     */
    private Node<E> node(int index){
        rangeCheck(index);
        Node<E> node = first;
        for(int i=0;i<index; i++){
            node=node.next;
        }
        return node;
    }

    class Node<E>{
        E element;
        Node<E> next;

        public Node(E element, Node<E> next){
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        Node<E> node = first;
        final StringBuffer sb = new StringBuffer("ArrayList{");
        sb.append("size=").append(size);
        sb.append(", elements=");
        if (node == null) sb.append("null");
        else {
            sb.append('[');
            for (int i = 0; i < size; ++i){
                sb.append(i == 0 ? "" : ", ").append(node.element);
                node = node.next;
            }

            sb.append(']');
        }
        sb.append('}');
        return sb.toString();
    }
}
