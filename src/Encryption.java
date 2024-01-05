/*
Класс кодирования сообщения
принимает алфавит
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Encryption {
    static List abc;

    Encryption(List alphabet){ // Конструктор
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

    static void encrypt(List abc){
        Scanner cons = new Scanner(System.in);
        System.out.println("Введете ключ шифрования: ");
        int key = cons.nextInt();


        List<String> temp = new ArrayList<>();
        String joined = null;
        String strIn = ".\\src\\InputTextEncrypt.txt";
        String strOut = ".\\src\\OutputTextEncrypt.txt";

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
