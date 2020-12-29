package com.keanu.list;

public abstract class AbstractList<E> implements List<E>{
    /**
     * 列表的大小
     */
    protected int size;

    /**
     * 数组越界异常
     * @param index
     */
    protected void outOfBounds(int index){
        throw new IndexOutOfBoundsException("Index:"+index+", Size="+this.size);
    }

    /**
     * 越界检查
     * @param index
     */
    protected void rangeCheck(int index){
        if(index<0 || index>=this.size){
            this.outOfBounds(index);
        }
    }

    /**
     * 添加的数组越界检查
     * @param index
     */
    protected void rangeCheckForAdd(int index){
        if(index<0 || index>this.size){
            this.outOfBounds(index);
        }
    }

    /**
     * 获取列表大小
     * @return 列表的大小
     */
    public int size(){
        return this.size;
    }

    /**
     * 判断列表是否为空
     * @return
     */
    public boolean isEmpty(){
        return this.size==0;
    }

    /**
     * 判断是否包含元素element
     * @param element
     * @return
     */
    public boolean contains(E element){
        return indexOf(element)!=INDEX_NOT_FOUND;
    }

    /**
     * 将element元素添加到尾部
     * @param element
     */
    public void add(E element){
        this.add(this.size(), element);
    }
}
