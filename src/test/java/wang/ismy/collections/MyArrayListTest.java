package wang.ismy.collections;

import org.junit.Test;
import wang.ismy.collections.list.MyArrayList;

import java.util.UUID;

import static org.junit.Assert.*;

public class MyArrayListTest {

    @Test
    public void addTest(){
        MyArrayList<String> list = new MyArrayList<>(1);
        list.add("cxk");
        list.add("jntm");
        assertEquals("cxk",list.get(0));


    }

    @Test
    public void testIterate(){
        MyArrayList<String> list = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(UUID.randomUUID().toString()+i);
        }
        for (int i = 0; i < list.size(); i++) {
            assertTrue(list.get(i).toString().endsWith(i+""));
        }

    }

    @Test
    public void testRemove(){
        MyArrayList<String> list = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i+"");
        }
        list.remove(5);
        assertEquals(9,list.size());

        assertEquals("6",list.get(5));
        list.remove(7);
        assertEquals(8,list.size());
        assertEquals("9",list.get(7));
    }

    @Test
    public void testRemoveObject(){
        MyArrayList<String> list = new MyArrayList<>();
        list.add("1");
        list.add("@");
        assertTrue(list.remove("@"));
        assertEquals(1,list.size());
        assertEquals("1",list.get(0));
    }

    @Test
    public void testIndexAdd(){
        MyArrayList<String> list = new MyArrayList<>();
        list.add("1");
        list.add("3");
        list.add(1,"2");
        assertEquals(3,list.size());
        assertEquals("2",list.get(1));
    }
}