package wang.ismy.collections;

/**
 * @author MY
 * @date 2020/1/16 14:21
 */
public class MyArrayList<E> {

    private Object[] elementData;

    /**
     * 实际大小
     */
    private int size = 0;

    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("初始容量不得小于0");
        }
        elementData = new Object[initialCapacity];
    }

    public MyArrayList() {
        this(10);
    }

    public void add(E value) {
        // 判断实际存放的元素数是否大于等于数组的长度
        ensureExplicitCapacity(size + 1);
        elementData[size++] = value;
    }

    public void add(int index, E value) {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException("下标越界");
        }
        ensureExplicitCapacity(size + 1);
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index]=value;
        size++;
    }

    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("下标越界");
        }
        E result = get(index);

        int length = size - index - 1;
        if (length > 0) {
            System.arraycopy(elementData, index+1 , elementData, index, length);
        }
        elementData[--size] = null;
        return result;
    }

    public boolean remove(E obj) {
        if (obj == null) {
            return false;
        }
        for (int i = 0; i < elementData.length; i++) {
            if (obj.equals(elementData[i])) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    private void ensureExplicitCapacity(int minCapacity) {
        if (size >= elementData.length) {
            // 扩容1.5倍
            int newCapacity = size + (size >> 1);
            if (newCapacity - minCapacity < 0) {
                newCapacity = minCapacity;
            }
            Object[] newElementData = new Object[newCapacity];
            // 转移数据
            System.arraycopy(elementData, 0, newElementData, 0, elementData.length);
            elementData = newElementData;
        }
    }

    public E get(int index) {
        return (E)elementData[index];
    }
}
