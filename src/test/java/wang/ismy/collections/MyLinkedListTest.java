package wang.ismy.collections;

import org.junit.Test;
import wang.ismy.collections.list.MyLinkedList;

import static org.junit.Assert.*;

public class MyLinkedListTest {

    @Test
    public void testAddAndGet(){
        MyList<String> list = new MyLinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        assertEquals("3",list.get(2));
    }

    @Test
    public void testRemove(){
        MyList<String> list = new MyLinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        assertEquals("2",list.remove(1));
        assertEquals(2,list.size());
        assertEquals("1",list.get(0));
        assertEquals("3",list.get(1));
        assertEquals("1",list.remove(0));
        assertEquals(1,list.size());
    }

    @Test
    public void testInsert(){
        MyList<String> list = new MyLinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add(0,"0");
        list.add(1,"x");
        assertEquals(5,list.size());
        String ret = "";
        for (int i = 0; i < 5; i++) {
            ret+=list.get(i);
        }
        assertEquals("0x123",ret);
    }

}