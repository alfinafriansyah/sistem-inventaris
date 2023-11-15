package Project;

import java.util.Scanner;

public class tambahbarang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String barang = "", output = "";
        int jumlah;
        System.out.print("Jumlah barang yang ingin ditambah: ");
        jumlah = input.nextInt();

        int i = 0;
        while (i < jumlah){
            System.out.print("Masukkan barang ke-" + (i+1) + ": ");
            barang = input.next();
            i++;
            output += barang + "\n";
        }
        System.out.println("Barang yang ditambahkan: ");
        System.out.println(output);
    }
}
