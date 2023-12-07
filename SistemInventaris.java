import java.util.Arrays;
import java.util.Scanner;

public class SistemInventaris {
    static Scanner sc = new Scanner(System.in);
    static String[] barang = {"minyak", "beras", "susu", "roti", "snack"};
    static int[] harga = {15000, 10000, 5000, 2500, 2000};
    static int[] stok = {85, 40, 56, 112, 666};
    static String RED = "\u001b[31m";
    static String GREEN = "\u001b[32m";
    static String RESET = "\u001b[0m";
    public static void main(String[] args) {
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
        String newBarang[] = new String[5];
        int newHarga[] = new int[5];
        int newStok[] = new int[5];
        for(int i = 0; i < barang.length; i++){
            newBarang[i] = barang[i];
            newHarga[i] = harga[i];
            newStok[i] = stok[i];
        }
        String barang[] = Arrays.copyOf(newBarang, (newBarang.length + n));
        int harga[] = Arrays.copyOf(newHarga, (newHarga.length + n));
        int stok[] = Arrays.copyOf(newStok, (newStok.length + n));
        for(int i = 0; i < (barang.length); i++){
            if (barang[i] == null) {
                System.out.print("Masukkan Nama Barang: ");
                barang[i] = sc.next();
                System.out.print("Masukkan Harga Barang: ");
                harga[i] = sc.nextInt();
                System.out.print("Masukkan Stok Barang: ");
                stok[i] = sc.nextInt();
            }else{
                continue;
            }
        }

        System.out.println("Data Barang yang Dimasukkan: ");
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
        }
        System.out.println("Data Barang sekarang: ");
        System.out.println("------------------------------------------------------");
        System.out.println("Nama Barang \t\tHarga \t\t\tStok \t");

        for(int i = 0; i < barang.length; i++){
            System.out.print(barang[i]+"\t\t\t\t"+harga[i]+"\t\t\t"+stok[i]);
            System.out.println();
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
    }

    public static void barangMasuk(){
        System.out.print("Masukkan nama barang: ");
        String cari = sc.nextLine();
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
            System.out.print("Masukkan Jumlah Barang Masuk: ");
            int jumlah = sc.nextInt();
            if (jumlah > 0){
                stok[key] += jumlah;
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
    }
}
