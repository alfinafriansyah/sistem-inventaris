import java.util.Arrays;
import java.util.Scanner;

import javax.management.StringValueExp;

public class SistemInventaris {
    static Scanner sc = new Scanner(System.in);
    static String[] barang = new String[100];
    static int[] harga = new int[100];
    static int[] stok = new int[100];
    static String laporMasuk[] = new String[100];
    static String laporKeluar[] = new String[100];
    static String laporRusak[] = new String[100];
    static String RED = "\u001b[31m";
    static String GREEN = "\u001b[32m";
    static String RESET = "\u001b[0m";
    public static void main(String[] args) {
        barang[0] = "minyak"; barang[1] = "beras"; barang[2] = "susu"; barang[3] = "roti"; barang[4] = "snack";
        harga[0] = 15000; harga[1] = 10000; harga[2] = 5000; harga[3] = 2500; harga[4] = 2000;
        stok[0] = 85; stok[1] = 40; stok[2] = 56; stok[3] = 112; stok[4] = 666;
        login();
    }

    public static void login(){
        String username[] = {"iga", "firman", "satria","surya"};
        int password[] = {111, 222, 333, 444};

        System.out.println("=================================");
        System.out.println("      LOGIN SISTEM INVENTARIS    ");
        System.out.println("=================================");
        System.out.print("Masukkan Username: ");
        String user = sc.next();
        System.out.print("Masukkan Password: ");
        int pass = sc.nextInt();
        int login = 0;
        for (int i = 0; i < username.length; i++){
            if (user.equals(username[i]) && pass == password[i]){
                login = 1;
            }else {
                continue;
            }
        }
        if (login == 1){
            System.out.println();
            System.out.println(GREEN+"Login Berhasil"+RESET);
            System.out.println();
            menu();
        }else {
            System.out.println(RED+"Login Gagal"+RESET);
            System.out.println();
            System.out.print("Apakah anda ingin login ulang?(y/t) ");
            char ulang = sc.next().charAt(0);
            if (ulang == 'Y' || ulang == 'y'){
                login();
            }
        }
    }

    public static void menu(){
        System.out.println("=================================================");
        System.out.println("Silakan Pilih Menu: ");
        System.out.println("1. Input Data Barang");
        System.out.println("2. Update Data Barang");
        System.out.println("3. Input Barang Masuk");
        System.out.println("4. Input Barang Keluar (Terjual)");
        System.out.println("5. Input Barang Rusak");
        System.out.println("6. Laporan");
        System.out.println("=================================================");
        int angka = sc.nextInt();

        switch (angka) {
            case 1 :
            inputBarang();
            break;
            case 2 :
            updateBarang();
            break;
            case 3 :
            barangMasuk();
            break;
            case 4 :
            barangKeluar();
            break;
            case 5 :
            barangRusak();
            break;
            case 6 :
            laporan();
            break;

            default:
                System.out.println("Maaf, menu yang anda pilih tidak valid ");
        }
    }

    public static void inputBarang(){
        System.out.println("=================================================");
        System.out.println("                Input Data Barang              ");
        System.out.println("=================================================");
        System.out.print("Jumlah Barang : ");
        int n = sc.nextInt();
        int no = 1;
        for(int i = 5; i < (5 + n); i++){
            for(int j = 1; j <= n; j++){
                no = j;
            }
            System.out.println("Barang ke-"+no);
            System.out.print("Masukkan Nama Barang: ");
            barang[i] = sc.next();
            System.out.print("Masukkan Harga Barang: ");
            harga[i] = sc.nextInt();
            System.out.print("Masukkan Stok Barang: ");
            stok[i] = sc.nextInt();
        }

        System.out.println("Data Barang yang Dimasukkan: ");
        System.out.println("------------------------------------------------------");
        System.out.println("Nama Barang \t\tHarga \t\t\tStok \t");
        for(int i = 0; i < barang.length; i++){
            if(barang[i] != null){
                System.out.print(barang[i]+"\t\t\t\t"+harga[i]+"\t\t\t"+stok[i]);
                System.out.println();
            }
        }

        System.out.print("Apakah anda ingin memimih menu lain?(y/t) ");
        char kembali = sc.next().charAt(0);
        if (kembali == 'Y' || kembali == 'y'){
            menu();
        }
    }

    public static void barangKeluar(){
        System.out.print("Masukkan nama barang: ");
        String cari = sc.next();
        int hasil = 0;
        int key = 0;
        for (int i = 0; i < barang.length; i++){
            if (cari.equalsIgnoreCase(barang[i])){
                hasil = 1;
                key = i;
                break;
            }else {
                continue;
            }
        }
        if (hasil == 1){
            System.out.println("Stok barang saat ini: " + stok[key]);
            System.out.print("Masukkan Jumlah Barang Keluar: ");
            int jumlah = sc.nextInt();
            if (jumlah > 0 && jumlah <= stok[key]){
                stok[key] -= jumlah;
                System.out.println(GREEN+"Input berhasil!"+RESET);
                System.out.println();
            }else{
                System.out.println(RED+"Angka yang anda masukkan tidak valid!"+RESET);
                System.out.println();
            }
            System.out.println("Data Barang sekarang: ");
            System.out.println("------------------------------------------------------");
            System.out.println("Nama Barang \t\tHarga \t\t\tStok \t");

            for(int i = 0; i < barang.length; i++){
                if(barang[i] != null){
                    System.out.print(barang[i]+"\t\t\t\t"+harga[i]+"\t\t\t"+stok[i]);
                    System.out.println();
                }
            }
        }
        System.out.print("Apakah anda ingin memimih menu lain?(y/t) ");
        char kembali = sc.next().charAt(0);
        if (kembali == 'Y' || kembali == 'y'){
            menu();
        }
    }

    public static void updateBarang(){
        System.out.print("Masukkan nama barang: ");
        String cari = sc.next();
        int hasil = 0;
        int key = 0;
        for (int i = 0; i < barang.length; i++){
            if (cari.equalsIgnoreCase(barang[i])){
                hasil = 1;
                key = i;
                break;
            }else {
                continue;
            }
        }
        if (hasil == 1){
            System.out.println("Nama Barang: " + barang[key]);
            System.out.println("Harga: " + harga[key]);
            System.out.println("Stok: " + stok[key]);
            System.out.print("Masukkan Nama Barang Baru: ");
            String namaBaru = sc.next();
            System.out.print("Masukkan Harga Barang Baru: ");
            int hargaBaru = sc.nextInt();
            System.out.print("Masukkan Stok Barang Baru: ");
            int stokBaru = sc.nextInt();
            barang[key] = namaBaru;
            harga[key] = hargaBaru;
            stok [key] = stokBaru;
            System.out.println("Input berhasil!");
            System.out.println();
        }
        System.out.println("Data Barang sekarang: ");
        System.out.println("------------------------------------------------------");
        System.out.println("Nama Barang \t\tHarga \t\t\tStok \t");

        for(int i = 0; i < barang.length; i++){
            System.out.print(barang[i]+"\t\t\t\t"+harga[i]+"\t\t\t"+stok[i]);
            System.out.println();
        }
        System.out.print("Apakah anda ingin memimih menu lain?(y/t) ");
        char kembali = sc.next().charAt(0);
        if (kembali == 'Y' || kembali == 'y'){
            menu();
        }
    }

    public static void barangMasuk(){
        System.out.print("Jumlah Barang Masuk: ");
        int jml = sc.nextInt();
        for(int i = 0; i < jml; i++){
            System.out.println("Barang ke-"+(i+1));
            System.out.print("Masukkan nama barang: ");
            String cari = sc.next();
            int hasil = 0;
            int key = 0;
            for (int j = 0; j < barang.length; j++){
                if (cari.equalsIgnoreCase(barang[j])){
                    hasil = 1;
                    key = j;
                    break;
                }else {
                    continue;
                }
            }
            if (hasil == 1){
                System.out.println("Stok barang saat ini: " + stok[key]);
                System.out.print("Masukkan Jumlah Barang Masuk: ");
                int jumlah = sc.nextInt();
                if (jumlah > 0){
                    stok[key] += jumlah;
                    System.out.print("Masukkan Tanggal(dd/mm/yyy): ");
                    String tanggal = sc.next();
                    laporMasuk[i] = "Tanggal: "+tanggal+"\nNama Barang: "+cari+"\nJumlah: "+jumlah;
                    System.out.println(GREEN+"Input berhasil!"+RESET);
                    System.out.println();
                }else{
                    System.out.println(RED+"Angka yang anda masukkan tidak valid!"+RESET);
                    System.out.println();
                }
            }
        }
        System.out.println("Data Barang sekarang: ");
        System.out.println("------------------------------------------------------");
        System.out.println("Nama Barang \t\tHarga \t\t\tStok \t");

        for(int i = 0; i < barang.length; i++){
            if(barang[i] != null){
                System.out.print(barang[i]+"\t\t\t\t"+harga[i]+"\t\t\t"+stok[i]);
                System.out.println();
            }
        }
        System.out.print("Apakah anda ingin memimih menu lain?(y/t) ");
        char kembali = sc.next().charAt(0);
        if (kembali == 'Y' || kembali == 'y'){
            menu();
        }
    }

    public static void barangRusak(){
        System.out.print("Masukkan nama barang: ");
        String cari = sc.next();
        int hasil = 0;
        int key = 0;
        for (int i = 0; i < barang.length; i++){
            if (cari.equalsIgnoreCase(barang[i])){
                hasil = 1;
                key = i;
                break;
            }else {
                continue;
            }
        }
        if (hasil == 1){
            System.out.println("Stok barang saat ini: " + stok[key]);
            System.out.print("Masukkan Jumlah Barang Rusak: ");
            int jumlah = sc.nextInt();
            if (jumlah > 0 && jumlah <= stok[key]){
                stok[key] -= jumlah;
                System.out.println(GREEN+"Input berhasil!"+RESET);
                System.out.println();
            }else{
                System.out.println(RED+"Angka yang anda masukkan tidak valid!"+RESET);
                System.out.println();
            }
        }
        System.out.println("Data Barang sekarang: ");
        System.out.println("------------------------------------------------------");
        System.out.println("Nama Barang \t\tHarga \t\t\tStok \t");

        for(int i = 0; i < barang.length; i++){
            System.out.print(barang[i]+"\t\t\t\t"+harga[i]+"\t\t\t"+stok[i]);
            System.out.println();
        }
        System.out.print("Apakah anda ingin memimih menu lain?(y/t) ");
        char kembali = sc.next().charAt(0);
        if (kembali == 'Y' || kembali == 'y'){
            menu();
        }
    }

    public static void laporan(){
        System.out.println("Pilih Menu: ");
        System.out.println("1. Barang Masuk");
        System.out.println("2. Barang Keluar");
        System.out.println("3. Barang Rusak");
        int angka = sc.nextInt();
        switch (angka) {
            case 1:
                lapMasuk();
                break;
            case 2:
                lapKeluar();
                break;
            case 3:
                lapRusak();
                break;
            default:
                break;
        }
    }

    public static void lapMasuk(){
        for(int i = 0; i < laporMasuk.length; i++){
            if(laporMasuk[i] != null){
                System.out.println("Laporan ke-"+(i+1));
                System.out.println(laporMasuk[i]);
            }
        }
        System.out.print("Apakah anda ingin memimih menu lain?(y/t) ");
        char kembali = sc.next().charAt(0);
        if (kembali == 'Y' || kembali == 'y'){
            menu();
        }
    }

    public static void lapKeluar(){
        
    }

    public static void lapRusak(){

    }
}
