package Project;

import java.util.Scanner;

public class arraytambahkaryawan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nama = new String[100];
        int[] umur = new int[100];
        
        System.out.print("Masukkan jumlah karyawan: ");
        int jumlah = sc.nextInt();
        for (int i = 0; i < jumlah; i++){
            System.out.print("Masukkan nama karyawan ke-"+(i+1)+" : ");
            sc.nextLine();
            nama[i] = sc.nextLine();

            System.out.print("Masukkan umur karyawan ke-"+(i+1)+" : ");
            umur[i] = sc.nextInt();
        }
        for (int i = 0; i < jumlah; i++) {
            System.out.println("Nama karyawan: " + nama[i] + ", Umur: " + umur[i]);
        }
    }
}
