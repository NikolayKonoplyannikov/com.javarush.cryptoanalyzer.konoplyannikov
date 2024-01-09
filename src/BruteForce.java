/*
Класс расскодирования сообщения методом полного перебора
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BruteForce extends NotaeCaesarianae{
    public static String strIn;

    // проход по алфавиту с увеличением шага ключа декодирования
    static void bruteForce(List<Character> abc){
        Scanner cons = new Scanner(System.in);
        System.out.println("Введите путь к исходному файлу: ");
        strIn = cons.nextLine(); //   ".\src\InputTextDecrypt.txt";

        for(int i=1; i<=28; i++){
            int key = i;
            String strOut = ".\\src\\Temp\\OutputTextDecryptBruteForce"+i+".txt";
            bruteForceProcess(key, abc, strOut);
        }

    }

    static void bruteForceProcess(int key, List abc, String strOut) {

        List<String> temp = new ArrayList<>();
        String joined = null;

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