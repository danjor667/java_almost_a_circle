import models.Base;
import models.Rectangle;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

import com.google.gson.Gson;
import models.Square;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, IOException {
        Rectangle myrectangle1 = new Rectangle(3, 2, 0, 0, 48);
        Rectangle myrectangle2 = new Rectangle (2, 3, 2, 0);
        Rectangle myrectangle3 = new Rectangle(4, 3, 2, 0);
        Rectangle myrectangle4= new Rectangle(3,  2, 2, 0);
        Rectangle myrectangle5 = new Rectangle(3, 3, 2, 0);
        Rectangle myrectangle6 = new Rectangle(4, 3, 2, 0);


        //System.out.println(myrectangle1.to_dictionary());

        ArrayList<Map<String, Integer>> myDictList = new ArrayList<>();
        myDictList.add(myrectangle1.to_dictionary());
        myDictList.add(myrectangle2.to_dictionary());
        myDictList.add(myrectangle3.to_dictionary());
        myDictList.add(myrectangle4.to_dictionary());
        myDictList.add(myrectangle5.to_dictionary());
        myDictList.add(myrectangle6.to_dictionary());


        ArrayList<Rectangle> mylist = new ArrayList<>();
        mylist.add(myrectangle1);
        mylist.add(myrectangle2);
        mylist.add(myrectangle3);
        mylist.add(myrectangle4);
        mylist.add(myrectangle5);
        mylist.add(myrectangle6);

        String json_string = Rectangle.to_jsonString(myDictList);

        System.out.println((json_string instanceof String));
        System.out.println(json_string);
        System.out.println((Rectangle.from_json_string(json_string) instanceof ArrayList<Map<String, Integer>>));
        System.out.println(Rectangle.from_json_string(json_string));


        //Square.save_to_file(mylist);


    }
}
