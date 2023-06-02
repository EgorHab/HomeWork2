package EthHashArray;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class EthArray {
    public static void main(String[] args) {
        ArrayList<String> wallets  = new ArrayList<String>();
        String wal = "C:\\Кошельки.txt";
        File file = new File(wal);
        int number = 0;
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String hash = scanner.next();
                wallets.add(number + ". " + hash);
                number++;


            }
            System.out.println(wallets);
            scanner.close();
        }catch (FileNotFoundException e) {
            System.out.println("Ошибка чтения" + wallets);
        }
    }


}
