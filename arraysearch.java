package Project;

import java.util.Scanner;

public class arraysearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] barang = {"minyak", "beras", "susu", "roti", "snack"};
        int[] harga = {15000, 10000, 5000, 2500, 2000};
        int[] stok = {85, 40, 56, 112, 666};

        System.out.print("Masukkan barang yang ingin dicari: ");
        String cari = sc.nextLine();
        int hasil = 0;
        for (int i = 0; i < barang.length; i++){
            if (cari.equalsIgnoreCase(barang[i])){
                System.out.println("Harga: "+ harga[i]);
                System.out.println("Jumlah Stok: " + stok[i]);
                hasil = 1;
                break;
            }else {
                continue;
            }
        }
        if (hasil != 1){
            System.out.println("Barang tidak ditemukan");
        }
    }
}
