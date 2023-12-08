package models;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

public abstract class Base {
    private static int numberOfInstances = 0;
    protected int width;
    protected int length;
    protected int x;
    protected int y;
    protected int id;


    public Base(int length, int width, int x, int y, int id) {
        numberOfInstances++;
        this.length = length;
        this.width = width;
        this.id = id;
        this.x = x;
        this.y = y;

    }
    public Base(int length, int width, int x, int y) {
       numberOfInstances++;
       this.id = numberOfInstances;
       this.length = length;
       this.width = width;
       this.x = x;
       this.y = y;

    }
    public Base(int length, int width, int x) {
        numberOfInstances++;
        this.id = numberOfInstances;
        this.length = length;
        this.width = width;
        this.x = x;
        this.y = 0;
    }

    public Base(int length, int width){
        numberOfInstances++;
        this.id = numberOfInstances;
        this.length = length;
        this.width = width;
        this.x = 0;
        this.y = 0;
    }

    public static int getNumberOfInstances(){
        return Base.numberOfInstances;
    }
    public int getId(){
        return this.id;
    }
    public int getLength(){
        return this.length;
    }

    public int getWidth(){
        return this.width;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
    // defining setters

    public void setLength(int length){
        this.length = length;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setId(int id){
        this.id = id;
    }

    // implementing various methods

    /* method to save a json
    representation of the object in a file
    with the object's name
    */


    public static String to_jsonString(ArrayList<Map<String, Integer>> dictionary_list) {
        Gson gson = new Gson();
        if (dictionary_list.isEmpty()){
            return "[]";
        }
        String jsonString = gson.toJson(dictionary_list);
        return jsonString;
    }

    //public static void save_to_file() {
    //}


    /*
    create a new object from the json representation
    file of an object
     */
    public static  ArrayList<Map<String, Integer>> from_json_string(String json_string) {
        Gson gson = new Gson();

        Type type = new TypeToken<ArrayList<Map<String, Integer>>>(){}.getType();
        ArrayList<Map<String, Integer>> myList = gson.fromJson(json_string, type);
        return myList;
    }

    //public abstract void display();

    //public abstract int area();
}