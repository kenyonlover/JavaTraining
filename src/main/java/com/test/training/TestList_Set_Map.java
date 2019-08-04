package com.test.training;

import java.util.*;

/**
 * created by Administrator on 2019/7/17
 * describe: 集合测试
 */
public class TestList_Set_Map {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("张三1", "男");
        map.put("张三2", "男");
        map.put("张三3", "男");
        //第一种遍历map的方法，通过加强for循环map.keySet()，然后通过键key获取到value值
        for(String s:map.keySet()){//遍历map的键
            System.out.println("key : "+s+" value : "+map.get(s));
        }
        //第二种只遍历键或者值，通过加强for循环
        for(String s2:map.values()) {//遍历map的值
            System.out.println("值value ：" + s2);
        }
        //第三种方式Map.Entry<String, String>的加强for循环遍历输出键key和值value
        for(Map.Entry<String, String> entry : map.entrySet()){
            System.out.println("键 key ："+entry.getKey()+" 值value ："+entry.getValue());
        }
        //第四种Iterator遍历获取，然后获取到Map.Entry<String, String>，再得到getKey()和getValue()
        Iterator<Map.Entry<String, String>> it=map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, String> entry=it.next();
            System.out.println("键key ："+entry.getKey()+" value ："+entry.getValue());
        }

        Set set = new HashSet();
        set.add("aa");

        LinkedList ll = new LinkedList();

        //去掉一个Vector集合中重复的元素
        Vector vector = new Vector();
        Vector vector2 = new Vector();
        String a = "a";
        String b = "b";
        String c = "c";
        vector.add("a");
        vector.add("a");
        vector.add("b");
        vector.add("c");
        vector2.add(a);
        vector2.add(a);
        vector2.add(b);
        vector2.add(c);
        System.out.println(vector.size() + "========" + vector);
        System.out.println(vector2.size() + "========" + vector2);
        Vector newVector = new Vector();
        Vector newVector2 = new Vector();
        for (int i=0;i<vector.size();i++) {
            Object obj = vector.get(i);
            if(!newVector.contains(obj)){
                newVector.add(obj);
            }
        }
        System.out.println(newVector.size() + "========" + newVector);
        HashSet setvec = new HashSet(vector);
        Iterator iterator = setvec.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }
        System.out.println(setvec.size() + "========" + setvec);

        //TreeMap
        Map<String, String> treeMap = new TreeMap<String, String>();
        treeMap.put("a","你好");
        treeMap.put("b","我是tom");
        treeMap.put("c","你好");
        treeMap.put("d","我是bob");
        treeMap.put("e","大家好才是真的好");
        System.out.println(treeMap.toString());
        for (String tree : treeMap.keySet()){
            System.out.println("key = " + tree + ", value = " + treeMap.get(tree));
        }

        //TreeMap
        Map<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("a","你好");
        hashMap.put("b","我是tom");
        hashMap.put("c","你好");
        hashMap.put("d","我是bob");
        hashMap.put("e","大家好才是真的好");
        System.out.println(hashMap.toString());
        for (String tree : hashMap.keySet()){
            System.out.println("key = " + tree + ", value = " + hashMap.get(tree));
        }
    }
}
