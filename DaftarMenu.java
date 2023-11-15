package Project;

import java.util.Scanner;
   
class DaftarMenu {
  public static void main(String args[]){
            
    Scanner input = new Scanner(System.in);
       
    int pilihan;
    char ulang;
     
    do {
      System.out.println("##       Daftar Menu       ##");
      System.out.println("============================");
      System.out.println("1. Input Data Barang");
      System.out.println("2. Update Data Barang");
      System.out.println("3. Input Data Karyawan");
      System.out.println("4. Input Barang Masuk");
      System.out.println("5. Laporan");
      System.out.println();
       
      System.out.print("Pilihan anda: ");
      pilihan = input.nextInt();
    
      switch(pilihan){
        case 1:
          System.out.println("Selamat datang di menu Input Data Barang!");
          break;
        case 2:
          System.out.println("Selamat datang di menu Update Data Barang!");
          break;
        case 3:
          System.out.println("Selamat datang di menu Input Data Karyawan!");
          break;
        case 4:
          System.out.println("Selamat datang di menu Input Barang Masuk!");
          break;
        case 5:
          System.out.println("Selamat datang di menu Laporan!");
          break;
        default:
          System.out.println("Menu tidak tersedia");
      }
    
      System.out.println();
    
      System.out.print("Ingin memilih menu lain (y/t)? ");
      ulang = input.next().charAt(0);
       
      System.out.println();
    }
    while (ulang != 't');
    
    System.out.println("Terimakasih...");
  
  }
}