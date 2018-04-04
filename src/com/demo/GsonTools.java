package com.demo;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class GsonTools {
    private static Gson mGson = new Gson();

    /**
     * ��json�ַ���ת����ʵ�����
     * @param json
     * @param classOfT
     * @return
     */
    public static Object stringToObject( String json , Class classOfT){
        return  mGson.fromJson( json , classOfT ) ;
    }

    /**
     * ������׼��Ϊjson�ַ��� ���� ��list ת����json
     * @param object
     * @param <T>
     * @return
     */
    public static <T> String objectToString(T object) {
        return mGson.toJson(object);
    }

    /**
     * ��json �ַ���ת����list
     * @param json
     * @param cls
     * @param <T>
     * @return
     */
    public static <T>  List<T> stringToList(String json ,Class<T> cls  ){
        Gson gson = new Gson();
        List<T> list = new ArrayList<T>();
        JsonArray array = new JsonParser().parse(json).getAsJsonArray();
        for(final JsonElement elem : array){
            list.add(gson.fromJson(elem, cls));
        }
        return list ;
    }
    public static <T> T getPerson(String jsonString, Class<T> cls) {
                T t = null;
                try {
                         Gson gson = new Gson();
                         t = gson.fromJson(jsonString, cls);
                     } catch (Exception e) {
                         // TODO: handle exception
                     }
                 return t;
           }

}
