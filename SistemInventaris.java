package Project;

import java.util.Scanner;

public class SistemInventaris {
    public static void main(String[] args) {
        login();
    }

    public static void login(){
        Scanner input = new Scanner(System.in);
        String username[] = {"iga", "firman", "satria","surya"};
        int password[] = {111, 222, 333, 444};

        System.out.println("=================================");
        System.out.println("      LOGIN SISTEM INVENTARIS    ");
        System.out.println("=================================");
        System.out.print("Masukkan Username: ");
        String user = input.nextLine();
        System.out.print("Masukkan Password: ");
        int pass = input.nextInt();
        int login = 0;
        for (int i = 0; i < username.length; i++){
            if (user.equalsIgnoreCase(username[i]) && pass == password[i]){
                login = 1;
            }else {
                continue;
            }
        }
        if (login == 1){
            System.out.println();
            System.out.println("Login Berhasil");
            System.out.println();
            menu();
        }else {
            System.out.println("Login Gagal");
        }
    }

    public static void menu(){
        Scanner input = new Scanner(System.in);
        int angka;

        System.out.println("=================================================");
        System.out.println("Silakan Pilih Menu: ");
        System.out.println("1. Input Data Barang");
        System.out.println("2. Update Data Barang");
        System.out.println("3. Input Barang Masuk");
        System.out.println("4. Input Barang Keluar (Terjual)");
        System.out.println("5. Input Barang Rusak");
        System.out.println("6. Laporan");
        System.out.println("=================================================");
        angka = input.nextInt();

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
        Scanner sc = new Scanner (System.in);

        System.out.println("=================================================");
        System.out.println("                Input Data Barang              ");
        System.out.println("=================================================");
        System.out.print("Jumlah Barang : ");
        int n = sc.nextInt();

        String barang[][] = new String[n][3];

        for(int i= 0; i<n; i++){
            System.out.println("");
            System.out.println("Data Barang ke "+(i+1));

            for(int j=0;j<3;j++){
                if (j == 0)
                    System.out.print("Nama Barang   : ");
                else if (j == 1)
                    System.out.print("Harga         : ");
                else
                    System.out.print("Stok          : ");

                System.out.print("");
                barang[i][j] = sc.next();
            }
        }

        System.out.println("Data Barang yang dimasukan");
        System.out.println("------------------------------------------------------");
        System.out.println("Nama Barang \t\tHarga \t\t\tStok \t");

        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                System.out.print(barang[i][j]+"\t\t\t");
            }
            System.out.println();
        }
    }
    public static void barangKeluar(){
        Scanner sc = new Scanner(System.in);
        String[] barang = {"minyak", "beras", "susu", "roti", "snack"};
        int[] harga = {15000, 10000, 5000, 2500, 2000};
        int[] stok = {85, 40, 56, 112, 666};

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
            System.out.print("Masukkan Jumlah Barang Keluar: ");
            int jumlah = sc.nextInt();
            int stokBaru = stok[key] - jumlah;
            stok[key] = stokBaru;
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
    public static void updateBarang(){
        Scanner sc = new Scanner(System.in);
        String[] barang = {"minyak", "beras", "susu", "roti", "snack"};
        int[] harga = {15000, 10000, 5000, 2500, 2000};
        int[] stok = {85, 40, 56, 112, 666};

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
            System.out.println("Nama Barang: " + barang[key]);
            System.out.println("Harga: " + harga[key]);
            System.out.println("Stok: " + stok[key]);
            System.out.print("Masukkan Nama Barang Baru: ");
            String namaBaru = sc.nextLine();
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
        Scanner sc = new Scanner(System.in);
        String[] barang = {"minyak", "beras", "susu", "roti", "snack"};
        int[] harga = {15000, 10000, 5000, 2500, 2000};
        int[] stok = {85, 40, 56, 112, 666};

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
            int stokBaru = stok[key] + jumlah;
            stok[key] = stokBaru;
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
    public static void barangRusak(){
        Scanner sc = new Scanner(System.in);
        String[] barang = {"minyak", "beras", "susu", "roti", "snack"};
        int[] harga = {15000, 10000, 5000, 2500, 2000};
        int[] stok = {85, 40, 56, 112, 666};

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
            System.out.print("Masukkan Jumlah Barang Rusak: ");
            int jumlah = sc.nextInt();
            int stokBaru = stok[key] - jumlah;
            stok[key] = stokBaru;
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
}
