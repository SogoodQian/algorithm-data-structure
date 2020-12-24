package com.keanu.list;

public class ArrayList {

    /**
     * 列表的大小
     */
    private int size;

    /**
     * 存放所有元素的数组
     */
    private int[] elements;

    /**
     * 列表的默认容量
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 未找到的值为-1
     */
    private static final int INDEX_NOT_FOUND = -1;

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
        this.elements = new int[capacity];
    }

    /**
     * 清空列表
     */
    public void clear(){
        this.size = 0;
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
    public boolean contains(int element){
        return indexOf(element)!=INDEX_NOT_FOUND;
    }

    /**
     * 将element元素添加到尾部
     * @param element
     */
    public void add(int element){

    }

    /**
     * 获取索引为index的值
     * @param index
     * @return
     */
    public int get(int index){
        if(index<0 || index>=this.size){
            throw new IndexOutOfBoundsException("Index:"+index+", Size="+this.size);
        }

        return this.elements[index];
    }

    /**
     * 设置index处的值
     * @param index
     * @param element
     * @return 原来的元素
     */
    public int set(int index, int element){
        if(index<0 || index>=this.size){
            throw new IndexOutOfBoundsException("Index:"+index+", Size="+this.size);
        }
        int old = this.elements[index];
        this.elements[index] = element;
        return old;
    }

    /**
     * 在index位置插入element
     * @param index
     * @param element
     */
    public void add(int index, int element){

    }

    /**
     * 删除index处的元素
     * @param index
     * @return
     */
    public int remove(int index){
        return 0;
    }


    /**
     * 返回element的位置
     * @param element
     * @return
     */
    public int indexOf(int element){
        for(int i=0; i<this.size; i++){
            if(this.elements[i]==element){
                return  i;
            }
        }

        return INDEX_NOT_FOUND;
    }
}
