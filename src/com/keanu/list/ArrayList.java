package com.keanu.list;

public class ArrayList<E> {

    /**
     * 列表的大小
     */
    private int size;

    /**
     * 存放所有元素的数组
     */
    private E[] elements;

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
        this.elements = (E[]) new Object[capacity];
    }

    /**
     * 数组越界异常
     * @param index
     */
    private void outOfBounds(int index){
        throw new IndexOutOfBoundsException("Index:"+index+", Size="+this.size);
    }

    /**
     * 越界检查
     * @param index
     */
    private void rangeCheck(int index){
        if(index<0 || index>=this.size){
            this.outOfBounds(index);
        }
    }

    /**
     * 添加的数组越界检查
     * @param index
     */
    private void rangeCheckForAdd(int index){
        if(index<0 || index>this.size){
            this.outOfBounds(index);
        }
    }

    /**
     * 清空列表
     */
    public void clear(){
        for(int i=0; i<this.size; i++){
            this.elements[i] = null;
        }
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

    /**
     * 获取索引为index的值
     * @param index
     * @return
     */
    public E get(int index){
        this.rangeCheck(index);

        return this.elements[index];
    }

    /**
     * 设置index处的值
     * @param index
     * @param element
     * @return 原来的元素
     */
    public E set(int index, E element){
        this.rangeCheck(index);
        E old = this.elements[index];
        this.elements[index] = element;
        return old;
    }

    /**
     * 在index位置插入element
     * @param index
     * @param element
     */
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

    /**
     * 删除index处的元素
     * @param index
     * @return
     */
    public E remove(int index){
        this.rangeCheck(index);
        E old = this.elements[index];
        for(int i=index+1; i<this.size; i++){
            this.elements[i-1] = this.elements[i];
        }
        this.elements[this.size--] = null;
        return old;
    }


    /**
     * 返回element的位置
     * @param element
     * @return
     */
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
