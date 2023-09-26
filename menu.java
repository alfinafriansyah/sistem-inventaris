package Project;
import java.util.Scanner;

public class menu {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        int angka;

        System.out.println("Silakan Pilih Menu: ");
        System.out.println("1. Input Data Barang");
        System.out.println("2. Update Data Barang");
        System.out.println("3. Input Barang Masuk");
        System.out.println("4. Input Barang Keluar");
        System.out.println("5. Laporan");
        angka = input.nextInt();

        switch (angka) {
            case 1 :
            System.out.println("Selamat datang di menu Input Data Barang!");
            break;
            case 2 :
            System.out.println("Selamat datang di menu Update Data Barang!");
            break;
            case 3 :
            System.out.println("Selamat datang di menu Input Barang Masuk!");
            break;
            case 4 :
            System.out.println("Selamat datang di menu Input Barang Keluar!");
            break;
            case 5 :
            System.out.println("Selamat datang di menu Laporan!");
            break;

            default:
            System.out.println("Maaf, menu yang anda pilih tidak valid ");
        }
    }
}
