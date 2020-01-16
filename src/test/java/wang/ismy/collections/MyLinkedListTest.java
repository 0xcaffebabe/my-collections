package wang.ismy.collections;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class MyLinkedListTest {

    @Test
    public void testAddAndGet(){
        LinkedList<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        assertEquals("3",list.get(2));
    }

    @Test
    public void testRemove(){
        LinkedList<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.remove(1);
        assertEquals(2,list.size());
        assertEquals("1",list.get(0));
        assertEquals("3",list.get(1));
    }

}