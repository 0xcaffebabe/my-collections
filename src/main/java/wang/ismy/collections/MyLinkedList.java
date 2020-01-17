package wang.ismy.collections;

import java.awt.*;

/**
 * @author MY
 * @date 2020/1/16 19:44
 */
public class MyLinkedList<E> {

    /**
     * 链表实际存储元素数
     */
    private int size = 0;

    /**
     * 头节点
     */
    private Node<E> first;

    /**
     * 尾节点
     */
    private Node<E> last;

    /**
     * 链表节点
     */
    private static class Node<E> {
        Node<E> pre;
        E data;
        Node<E> next;
    }

    public void add(E e) {
        Node<E> node = new Node<>();
        node.data = e;
        if (first == null) {
            // 第一次添加
            first = node;
        } else {
            node.pre = last;
            last.next = node;
        }
        last = node;
        size++;
    }

    public void add(int index,E e){
        checkRange(index);
        Node<E> node = getNode(index);
        Node<E> insertNode = new Node<>();
        insertNode.data = e;
        insertNode.next = node;
        if (node.pre == null){
            // 插入在头节点
           first = insertNode;
           node.pre = first;
        }else {
           insertNode.pre = node.pre;
           insertNode.pre.next = insertNode;
        }
        size++;
    }

    public E get(int index) {
        checkRange(index);
        return getNode(index).data;
    }

    public E remove(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("越界");
        }
        Node<E> node = getNode(index);

        E result = node.data;
        if (node.pre == null){
            // 当前删除的是头节点
            first = null;
            last = null;
        }else {
            // 将被删除节点前驱的后继指向被删除节点的后继
            node.pre.next = node.next;
        }
        size--;
        return result;
    }

    public int size(){
        return size;
    }

    private Node<E> getNode(int index){
        var node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private void checkRange(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("查询越界");
        }
    }

}
