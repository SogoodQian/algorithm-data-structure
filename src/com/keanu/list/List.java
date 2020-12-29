package com.keanu.list;

public interface List<E> {

    /**
     * 常量，标志未找到
     */
    int INDEX_NOT_FOUND = -1;

    /**
     * 清空列表
     */
    void clear();

    /**
     * 获取索引为index的值
     * @param index
     * @return
     */
    E get(int index);

    /**
     * 设置index处的值
     * @param index
     * @param element
     * @return 原来的元素
     */
    E set(int index, E element);

    /**
     * 在index位置插入element
     * @param index
     * @param element
     */
    void add(int index, E element);

    /**
     * 删除index处的元素
     * @param index
     * @return
     */
    E remove(int index);


    /**
     * 返回element的位置
     * @param element
     * @return
     */
    int indexOf(E element);
}
