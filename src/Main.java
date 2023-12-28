import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Character> alphabet = Arrays.asList(' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h','i','j','k','l','m','n', 'o','p','q','r','s','t','u','v','w','x','y','z');
    static int key = 4;

    public static void main(String[] args) {
        Scanner cons = new Scanner(System.in);

        System.out.println("Укажите режим работы:");
        System.out.println("1 - Шифроване текста");
        System.out.println("2 - Расшифровка текста");
        System.out.println("3 - Расшифровка текста перебором");

        int i = cons.nextInt();

        switch (i) {
            case 1 -> encryption(alphabet, key);//Encryption.encrypt("Кодируем");
            case 2 -> Decryption.decrypt("Декодируем");
            case 3 -> Decryption.decrypt("Декодируем перебором");
            default -> System.out.println("Нет такого режима");
        }
    }

    public static void encryption(List alphabet, int key){
        List<String> temp = new ArrayList<>();
        String joined = null;
        //System.out.println(alphabet.get(3));
        String strIn = ".\\src\\InputText.txt";
        String strOut = ".\\src\\OutputText.txt";

        try(FileReader in = new FileReader(strIn);
            BufferedReader reader = new BufferedReader(in))
        {
            while (reader.ready()) {
                String line = reader.readLine();

                for (int i = 0; i < line.length(); i++) {
                    char id = line.charAt(i);
                    if(alphabet.contains(id)) {
                        int index = alphabet.indexOf(id) + key;
                        temp.add(String.valueOf(alphabet.get(index)));
                    }
                    else {
                        temp.add("|");
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

