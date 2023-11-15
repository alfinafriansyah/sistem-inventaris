package Project;

import java.util.Scanner;

public class tambahstok {
    public static void main(String[] args) {
        int stok = 100;
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan menu: ");
        String menu = input.nextLine();
        if (menu.equalsIgnoreCase("tambah stok")){
            System.out.println("Jumlah Stok: " + stok);
            System.out.print("Masukkan Jumlah Stok yang akan ditambah: ");
            int jumlah = input.nextInt();
            if (jumlah > 0){
                int total = stok + jumlah;
                System.out.println("Jumlah Stok Sekarang: " + total);
            }else {
                System.out.println("Jumlah yang dimasukkan harus lebih dari 0");
            }
        }else {
            System.out.println("Menu yang dipilih tidak valid");
        }
    }
}
