import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NotaeCaesarianae {



    static void symbolPosition(int index, List temp, List abc){
        if(index<0){
            int s = abc.size() + index;
            temp.add(String.valueOf(abc.get(s)));
        }
        else {
            temp.add(String.valueOf(abc.get(index)));
        }
    }
}
