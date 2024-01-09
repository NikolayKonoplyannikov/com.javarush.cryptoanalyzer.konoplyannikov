import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Character> alphabet = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H','I','J','K','L','M','N', 'O','P','Q','R','S','T','U','V','W','X','Y','Z', ' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h','i','j','k','l','m','n', 'o','p','q','r','s','t','u','v','w','x','y','z', '0', '1', '2', '3', '4', '5', '6', '7','8','9','!','@','#','$', '%','^','&','*','(',')', ',', 'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж','З','И','Й','К','Л','М', 'Н','О','П','Р','С','Т','У','Ф','Х','Ц','Ч','Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я', 'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж','з','и','й','к','л','м', 'н','о','п','р','с','т','у','ф','х','ц','ч','ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я');

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
            case 3 -> BruteForce.bruteForce(alphabet);
            default -> System.out.println("Нет такого режима");
        }
    }
}

