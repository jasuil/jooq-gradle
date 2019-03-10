package com.example.jooq.settings;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;


public class ObjectUtils {

    public static Map convertObjectToMap(Object obj) {
        Map map = new HashMap();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            try {
                map.put(fields[i].getName(), fields[i].get(obj));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return map;
    }

    public static Object convertMapToObject(Map<String, Object> map, Object obj) {
        String keyAttribute = null;
        String setMethodString = "set";
        String methodString = null;
        Iterator itr = map.keySet().iterator();

        while (itr.hasNext()) {
            keyAttribute = (String) itr.next();
            methodString = setMethodString + keyAttribute.substring(0, 1).toUpperCase() + keyAttribute
                    .substring(1);
            Method[] methods = obj.getClass().getDeclaredMethods();
            for (int i = 0; i < methods.length; i++) {
                if (methodString.equals(methods[i].getName())) {
                    try {
                        methods[i].invoke(obj, map.get(keyAttribute));
                    } catch (Exception e) {
                        throw new RuntimeException();
                    }
                }
            }
        }
        return obj;
    }

    public static Map<String, Object> fieldFilterWithMap(Map<String, Object> map1, Map<String, Object> map2) {

        Map<String, Object> returnMap = new HashMap<>();

        for (String key1 : map1.keySet()) {
            for (String key2 : map2.keySet()) {

                if (map2.get(key2).equals(key1) == true) {
                    returnMap.put(key1, null);
                    break;
                } else {
                    returnMap.put(key1, map1.get(key1));
                }
            }
        }
        return returnMap;
    }


    public static Map<String, Object> fieldFilterWithMapList(Map<String, Object> map1, List<Map<String, Object>> listMap) {

        Map<String, Object> returnMap = new HashMap<>();
        Set<String> history = new HashSet<>();

        for (String key1 : map1.keySet()) {
            for (Map<String, Object> map2 : listMap) {
                for (String key2 : map2.keySet()) {
                    if (map2.get(key2) != null) {
                        if (map2.get(key2).equals(key1) == true) {
                            returnMap.put(key1, null);
                            history.add(key1);
                            break;
                        } else {
                            if (!history.contains(key1))
                                returnMap.put(key1, map1.get(key1));
                        }
                    }
                }
            }
        }

        return returnMap;
    }


    public static Map<String, Object> fieldFilterWithStringList(Map<String, Object> map1, List<String> list) {

        Map<String, Object> returnMap = new HashMap<>();
        Set<String> history = new HashSet<>(); //argument to avoid map1 member duplicate in list member

        if(!list.isEmpty()) {
            for (String key1 : map1.keySet()) {
                for (String fields : list) {
                    if (fields.equals(key1) == true) {
                        returnMap.put(key1, null);
                        history.add(key1);
                        break;
                    } else {
                        if (!history.contains(key1))
                            returnMap.put(key1, map1.get(key1));
                    }
                }
            }
        }else{
            returnMap = map1;
        }

        return returnMap;
    }

    public static Object objectFilter(Object ob1, Object ob2) throws Exception {
        //convert object to map
        Map map1 = convertObjectToMap(ob1);
        Map map2 = convertObjectToMap(ob2);

        //filter
        Map<String, Object> filteredMap = fieldFilterWithMap(map1, map2);

        Object returnObject = new Object();

        //convert map to object using create new instance with a given object
        Class<?> c = Class.forName(ob1.getClass().getName());
        Constructor<?> cons = c.getDeclaredConstructor();
        cons.setAccessible(true);
        returnObject = cons.newInstance();

        convertMapToObject(filteredMap, returnObject);
        return returnObject;
    }

    public static Object objectFilterWithObjectList(Object ob1, List<Object> obList) {

        List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
        obList.getClass();
        //convert object to map
        Map map1 = convertObjectToMap(ob1);
        obList.forEach(obj -> listMap.add(convertObjectToMap(obj)));

        //filter
        Map<String, Object> filteredMap = fieldFilterWithMapList(map1, listMap);

        Object returnObject = new Object();

        try {
            //convert map to object using create new instance with a given object
            Class<?> c = Class.forName(ob1.getClass().getName());
            Constructor<?> cons = c.getDeclaredConstructor();
            cons.setAccessible(true);
            returnObject = cons.newInstance();

            convertMapToObject(filteredMap, returnObject);
        }catch(Exception e){
            throw new RuntimeException(e);
        }

        return returnObject;
    }

    public static Object objectFilterWithStringList(Object ob1, List<String> list) {

        //convert object to map
        Map map1 = convertObjectToMap(ob1);

        //filter
        Map<String, Object> filteredMap = fieldFilterWithStringList(map1, list);

        Object returnObject = new Object();

        try {
            //convert map to object using create new instance with a given object
            Class<?> c = Class.forName(ob1.getClass().getName());
            Constructor<?> cons = c.getDeclaredConstructor();
            cons.setAccessible(true);
            returnObject = cons.newInstance();

            convertMapToObject(filteredMap, returnObject);
        }catch(Exception e){
            throw new RuntimeException(e);
        }

        return returnObject;
    }

    public static void main(String[] args) throws Exception {

/*
        AccountDTO.Output.Account vo1 = new AccountDTO.Output.Account();
        vo1.setMId("jasuil");
        vo1.setCompanyName("장성일");
        vo1.setAccountDivision("Korea");

        //create object to filter wish list
        AccountDTO.Output.Account vo3 = new AccountDTO.Output.Account();
        vo3.setMId("name");
        AccountDTO.Output.Account vo4 = new AccountDTO.Output.Account();
        vo4.setCompanyName("mId");

        List<Object> volist = new ArrayList<>();
        volist.add(vo3);
        volist.add(vo4);

        Object g = objectFilterWithObjectList(vo1, volist);
*/
    }

}