package wang.ismy.collections;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyHashMapTest {

    @Test
    public void testPut(){
        MyHashMap<String,String> map = new MyHashMap<>();
        map.put("1","1");
        map.put("2","2");
        assertEquals("1",map.get("1"));
        assertEquals("2",map.get("2"));
    }

    @Test
    public void testOverride(){
        MyHashMap<String,String> map = new MyHashMap<>();
        map.put("1","1");
        map.put("2","2");
        assertEquals("1",map.get("1"));
        assertEquals("2",map.get("2"));
        map.put("1","x");
        assertEquals("x",map.get("1"));
    }

    @Test
    public void testResize(){
        MyHashMap<String,Integer> map = new MyHashMap<>();
        for (int i = 0; i < 1000; i++) {
            map.put(i+"",i);
        }
        assertEquals(1000,map.size());
        for (int i = 0; i < 1000; i++) {

            assertEquals(i,(int)map.get(i+""));
        }
    }
}