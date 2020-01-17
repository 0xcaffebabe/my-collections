package wang.ismy.collections;

/**
 * 自己的List接口
 * @author MY
 * @date 2020/1/17 14:37
 */
public interface MyList<E> {

    /**
     * 添加一个元素
     * @param e
     */
    void add(E e);

    /**
     * 插入元素
     * @param index
     * @param e
     */
    void add(int index,E e);

    /**
     * 根据下标删除
     * @param index
     * @return
     */
    E remove(int index);

    /**
     * 根据下标获取
     * @param index
     * @return
     */
    E get(int index);

    /**
     * 获取列表大小
     * @return 列表大小
     */
    int size();


}
