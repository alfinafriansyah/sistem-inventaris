package Project;

import java.util.Scanner;

public class arraytambahbarang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] barang = new String[100];
        int[] harga = new int[100];
        
        System.out.print("Masukkan jumlah barang: ");
        int jumlah = sc.nextInt();
        for (int i = 0; i < jumlah; i++){
            System.out.print("Masukkan barang ke-"+(i+1)+" : ");
            sc.nextLine();
            barang[i] = sc.nextLine();

            System.out.print("Masukkan harga barang ke-"+(i+1)+" : ");
            harga[i] = sc.nextInt();
        }
        for (int i = 0; i < jumlah; i++) {
            System.out.println("Nama barang: " + barang[i] + ", Harga: " + harga[i]);
        }
    }
}
