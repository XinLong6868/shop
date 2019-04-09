package com.fh.shop.backend.mapTextDome;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        //创建map
        HashMap map = new HashMap<>();
        //放入值
        map.put("name","站三1");
        map.put("sex","男1");
        HashMap map1 = new HashMap<>();
        //放入值
        map1.put("name","站三2");
        map1.put("sex","男2");
        HashMap map3 = new HashMap<>();
        //放入值
        map3.put("name","站三3");
        map3.put("sex","男3");
        //将上面map放入到list集合中
        ArrayList<Map> mapList = new ArrayList<>();
        mapList.add(map);
        mapList.add(map1);
        mapList.add(map3);
        for (Map mapSTu : mapList) {
            Iterator iterator6 = mapSTu.keySet().iterator();
            while (iterator6.hasNext()){
                String key = (String) iterator6.next();
                System.out.println(key+""+mapSTu.get(key));
            }
            System.out.println("========");
        }



        //通过entrySet,进行
        Iterator iterator = map.entrySet().iterator();
        //循环遍历
        while (iterator.hasNext()){
            //强转数据类型
            Map.Entry next = (Map.Entry) iterator.next();
            System.out.println(next.getKey()+":"+next.getValue());
        }



        Iterator iterator1 = map.keySet().iterator();
        while (iterator1.hasNext()){
            String next =(String) iterator1.next();
            System.out.println(next+":"+map.get(next));
        }
    }
}
