package models;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Square extends Rectangle {
    public Square(int size, int x, int y, int id) {
        super(size, size, x, y, id);
    }

    public Square(int size, int x, int y){
        super(size, size, x, y);
    }

    public Square(int size, int x){
        super(size, size, x);
    }

    Square(int size){
        super(size, size);
    }

    public String toString() {
        return String.format("Square [%d] - id[%d]", this.getWidth(), this.getId());
    }

    public void update(Map<String, Integer> dict){
        this.setId(dict.get("id"));
        this.setWidth(dict.get("size"));
        this.setLength(dict.get("size"));
        this.setX(dict.get("x"));
        this.setY(dict.get("y"));
    }

    public void update(int id, int size, int x, int y){
        this.setId(id);
        this.setLength(size);
        this.setWidth(size);
        this.setX(x);
        this.setY(y);
    }

    public void update(int id, int size, int x){
        this.setId(id);
        this.setLength(size);
        this.setWidth(size);
        this.setX(x);
    }

    public void update(int id, int size){
        this.setId(id);
        this.setLength(size);
        this.setWidth(size);
    }

    public void update(int id){
        this.setId(id);
    }

    public Map<String, Integer> to_dictionary() throws IllegalAccessException {
        Map myDict = new HashMap<>();
        Class<?> myClass = this.getClass();
        while (myClass.getSuperclass().getName() != "java.lang.Object"){
            myClass = myClass.getSuperclass();
        }
        Field[] myAttributes = myClass.getDeclaredFields();
        for (Field attr: myAttributes) {
            if (attr.getName() != "numberOfInstances") {
                if (attr.getName() == "length" || attr.getName() == "width") {
                    myDict.put("size", attr.get(this));
                }
                else {
                    myDict.put(attr.getName(), (Integer) attr.get(this));
                }

            }
        }
        return myDict;
    }

    public static void save_to_file(ArrayList<Rectangle> square_list) throws IllegalAccessException, IOException {
        ArrayList<Map<String, Integer>> myList = new ArrayList<>();
        for(Rectangle obj: square_list){
            myList.add(obj.to_dictionary());
        }
        String jsonString = to_jsonString(myList);
        String filePath = "Square.json";
        FileWriter fileWriter = new FileWriter(filePath);
        try{
            fileWriter.write(jsonString);
        }
        catch (Exception e){
            System.out.println("an error occurred");
        }
        finally {
            fileWriter.close();
        }
    }

    public Square create(Map<String, Integer> myDict){
        //creating a dummy rectangle obj
        Square mySquare = new Square(1,2,3);
        mySquare.update(myDict);
        return mySquare;
    }
}
