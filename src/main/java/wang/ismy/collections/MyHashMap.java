package wang.ismy.collections;

import javax.naming.NoInitialContextException;

/**
 * 基于数组+单向链表
 *
 * @author MY
 * @date 2020/1/17 14:42
 */
public class MyHashMap<K, V> {

    private Node<K, V>[] table;

    private int size;

    private static final float LOAD_FACTOR = 0.75f;

    private static final int DEFAULT_SIZE = 16;

    public static class Entry<K, V> {
        K k;
        V v;

        public Entry(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }

    private static class Node<K, V> {
        Entry<K, V> entry;
        Node<K, V> next;
    }

    public void put(K key, V value) {
        if (table == null) {
            table = new Node[DEFAULT_SIZE];
        }
        ensureCapacity();
        int index = getIndex(key);
        Node<K, V> node = table[index];
        if (node == null) {
            node = new Node<>();
            node.entry = new Entry<>(key, value);
            table[index] = node;
        } else {
            // 发生hash冲突
            Node<K, V> insertNode = new Node<>();
            insertNode.entry = new Entry<>(key,value);
            // 判断同一位置的列表是否存在同一key，如果有，设置新value
            overrideValue(key, value, node);
            insertNode.next = table[index];
            table[index] = insertNode;
        }
        size++;
    }

    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> node = table[index];
        if (node == null) {
            return null;
        } else {
            while (node != null) {
                if (node.entry.k.equals(key)){
                    return node.entry.v;
                }
                node = node.next;
            }
            return null;
        }
    }

    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size / (table.length * 1.0) >= LOAD_FACTOR) {
            // 扩容
            Node<K,V>[] newTable = new Node[table.length << 1];
            // 重新计算索引
            for (Node<K, V> node : table) {
                while (node != null) {
                    int index = node.entry.k.hashCode() % newTable.length;
                    Node<K, V> oldNext = node.next;
                    node.next = newTable[index];
                    newTable[index] = node;
                    node = oldNext;
                }
            }
            table = newTable;
        }
    }

    private int getIndex(K key) {
        return key.hashCode() % table.length;
    }

    private void overrideValue(K key, V value, Node<K, V> node) {
        while (node != null) {
            if (node.entry.k.equals(key)) {
                node.entry.v = value;
                size--;
                break;
            }
            node = node.next;
        }
    }
}
