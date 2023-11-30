package Project;

import java.util.Scanner;

public class rekursif2 {
    static String[][] karyawan = new String[100][2]; 
    static int index = 0;
    
    public static void main(String[] args) {
        inputData();
        tampilData();
    }

    static void inputData() {
        Scanner input = new Scanner(System.in);
        char lagi = 'y';
        
        while(lagi == 'Y' || lagi == 'y') {
            System.out.print("Masukkan Nama: ");
            String nama = input.nextLine();
            
            System.out.print("Masukkan Alamat: ");
            String alamat = input.nextLine();
            
            karyawan[index][0] = nama;
            karyawan[index][1] = alamat;
            index++;
            
            System.out.print("Tambah lagi (Y/T)?");
            lagi = input.nextLine().charAt(0);
        }
    }

    static void tampilData() {
        System.out.println("Data Karyawan:");
        for(int i = 0; i < index; i++) {
            System.out.println("Nama: " + karyawan[i][0]); 
            System.out.println("Alamat: " + karyawan[i][1]);
        }
    }
}
