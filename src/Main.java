import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Character> alphabet = Arrays.asList('M', 'C', ' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h','i','j','k','l','m','n', 'o','p','q','r','s','t','u','v','w','x','y','z');
    //static int key = 4;

    public static void main(String[] args) {
        Scanner cons = new Scanner(System.in);

        System.out.println("Укажите режим работы:");
        System.out.println("1 - Шифроване текста");
        System.out.println("2 - Расшифровка текста");
        System.out.println("3 - Расшифровка текста перебором");

        int i = cons.nextInt();

        switch (i) {
            case 1 -> Encryption.encrypt(alphabet);
            case 2 -> Decryption.decrypt(alphabet);
            //case 3 -> Decryption.decrypt("Декодируем перебором");
            default -> System.out.println("Нет такого режима");
        }
    }
}

