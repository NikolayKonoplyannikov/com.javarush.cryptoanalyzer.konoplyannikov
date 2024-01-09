/*
Класс расскодирования сообщения методом полного перебора
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BruteForce {
    static List<Character> abc;

    BruteForce(List<Character> alphabet){ // Конструктор
        this.abc = alphabet;



    }

    static void symbolPosition(int index, List temp, List abc){

        if(index<0){
            int s = abc.size() + index;
            temp.add(String.valueOf(abc.get(s)));
        }
        else {
            temp.add(String.valueOf(abc.get(index)));
        }
    }


    // проход по алфавиту с увеличением шага ключа декодирования
    static void test(List<Character> abc){
        for(int i=1; i<=28; i++){
            int key = i;
            String strOut = ".\\src\\FlowIO\\OutputTextDecryptBruteForce"+i+".txt";
            bruteForce(key, abc, strOut);
        }

    }

    static void bruteForce(int key, List abc, String strOut) {

        List<String> temp = new ArrayList<>();
        String joined = null;
        String strIn = ".\\src\\InputTextDecrypt.txt";

        try(FileReader in = new FileReader(strIn);
            BufferedReader reader = new BufferedReader(in))
        {
            while (reader.ready()) {
                String line = reader.readLine();

                for (int i = 0; i < line.length(); i++) {
                    char id = line.charAt(i);
                    if(abc.contains(id)) {
                        int index = (abc.indexOf(id) + key) % abc.size();
                        symbolPosition(index, temp, abc); // определяем позицию символа от шага спещения (в лево и в право)
                    }
                    else {
                        temp.add("|"); // если символа нет в алфавите, то подставляем "|"
                    }
                }
                temp.add("\n");
                joined = String.join("", temp);
            }
            try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(strOut))){

                bufferedWriter.write(joined);
                bufferedWriter.flush();
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}