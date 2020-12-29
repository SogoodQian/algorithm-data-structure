package com.keanu.list;

public class ArrayList<E> extends AbstractList<E>{

    /**
     * 存放所有元素的数组
     */
    private E[] elements;

    /**
     * 列表的默认容量
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 构造函数
     * 没有参数
     */
    public ArrayList(){
        this(DEFAULT_CAPACITY);
    }

    /**
     * 构造函数
     * @param capacity 初始容量
     */
    public ArrayList(int capacity){
        capacity = (capacity<DEFAULT_CAPACITY)?DEFAULT_CAPACITY:capacity;
        this.elements = (E[]) new Object[capacity];
    }


    @Override
    public void clear(){
        for(int i=0; i<this.size; i++){
            this.elements[i] = null;
        }
        this.size = 0;
    }

    @Override
    public E get(int index){
        this.rangeCheck(index);

        return this.elements[index];
    }

    @Override
    public E set(int index, E element){
        this.rangeCheck(index);
        E old = this.elements[index];
        this.elements[index] = element;
        return old;
    }

    @Override
    public void add(int index, E element){
        this.rangeCheckForAdd(index);

        this.ensureCapacity(this.size+1);

        for(int i=size-1; i>=index; i--){
            this.elements[i+1] = this.elements[i];
        }

        this.elements[index] = element;
        this.size++;
    }

    /**
     * 动态扩容
     * @param capacity
     */
    public void ensureCapacity(int capacity){
        int oldCapacity = this.elements.length;
        if(oldCapacity>=capacity){
            return;
        }

        int newCapacity = oldCapacity+oldCapacity>>2;
        E[] newElements = (E[]) new Object[newCapacity];
        for(int i=0; i<this.size; i++){
            newElements[i] = this.elements[i];
        }

        this.elements = newElements;
    }

    @Override
    public E remove(int index){
        this.rangeCheck(index);
        E old = this.elements[index];
        for(int i=index+1; i<this.size; i++){
            this.elements[i-1] = this.elements[i];
        }
        this.elements[this.size--] = null;
        return old;
    }


    @Override
    public int indexOf(E element){
        if(element==null){
            for(int i=0; i<this.size; i++){
                if(this.elements[i] == null){
                    return  i;
                }
            }
        }else{
            for(int i=0; i<this.size; i++){
                if(element.equals(this.elements[i])){
                    return  i;
                }
            }
        }
        return INDEX_NOT_FOUND;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ArrayList{");
        sb.append("size=").append(size);
        sb.append(", elements=");
        if (elements == null) sb.append("null");
        else {
            sb.append('[');
            for (int i = 0; i < size; ++i)
                sb.append(i == 0 ? "" : ", ").append(elements[i]);
            sb.append(']');
        }
        sb.append('}');
        return sb.toString();
    }
}
