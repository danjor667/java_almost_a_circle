package models;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Rectangle extends Base{
    public Rectangle(int length, int width, int x, int y, int id) {
        super(length, width, x, y, id);
    }
    public Rectangle(int length, int width, int x, int y) {
        super(length, width, x, y);
    }
    Rectangle(int length, int width, int x){
        super(length, width, x);
    }
    Rectangle(int length, int width) {
        super(length, width);
    }

    public int area() {
        return this.getLength() * this.getWidth();
    }
    public void display(){
        String ch = "#".repeat(this.getLength());
        for (int i = 0; i < this.getWidth(); i++) {
            System.out.println(ch);
        }
    }

    public String toString() {
        return String.format("Rectangle [%d]/[%d] - id[%d]", this.getLength(), this.getWidth(), this.getId());
    }

    // method to update the attributes of a rectangle

    public void update(Map<String, Integer> dict){
        this.setId(dict.get("id"));
        this.setLength(dict.get("length"));
        this.setWidth(dict.get("width"));
        this.setX(dict.get("x"));
        this.setY(dict.get("y"));
    }
    public void update(int id, int length, int width, int x, int y){
        this.setId(id);
        this.setLength(length);
        this.setWidth(width);
        this.setX(x);
        this.setY(y);
    }
    public void update(int id, int length, int width, int x){
        this.setId(id);
        this.setLength(length);
        this.setWidth(width);
        this.setX(x);
    }
    public void update(int id, int length, int width){
        this.setId(id);
        this.setLength(length);
        this.setWidth(width);
    }
    public void update(int id, int length){
        this.setId(id);
        this.setLength(length);
    }
    public void update(int id){
        this.setId(id);
    }

    public Map<String, Integer> to_dictionary() throws IllegalAccessException{
        Map myDict = new HashMap<>();
        Class<?> myClass = this.getClass();
        while (myClass.getSuperclass().getName() != "java.lang.Object"){
            myClass = myClass.getSuperclass();
        }
        Field[] myAttributes = myClass.getDeclaredFields();
        for (Field attr: myAttributes) {
            if (attr.getName() != "numberOfInstances"){
                myDict.put(attr.getName(), (Integer) attr.get(this));
            }
        }
        return myDict;
    }

    public static void save_to_file(ArrayList<Rectangle> rectangle_list) throws IllegalAccessException, IOException {
        ArrayList<Map<String, Integer>> myList = new ArrayList<>();
        for(Rectangle obj: rectangle_list){
            myList.add(obj.to_dictionary());
        }
        String jsonString = to_jsonString(myList);
        String filePath = "Rectangle.json";
        FileWriter fileWriter = new FileWriter(filePath);
        try{
            fileWriter.write(jsonString);
        }
        catch (Exception e){
            System.out.println("an error occurred");
        }
        finally{
            fileWriter.close();
        }
    }

    public Rectangle create(Map<String, Integer> myDict){
        //creating a dummy rectangle obj
        Rectangle myRectangle = new Rectangle(1,2,3,4);
        myRectangle.update(myDict);
        return myRectangle;
    }

}
