package Project;

import java.util.Scanner;

public class FungsiKel1_03 {
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
        System.out.println("4. Input Barang Keluar");
        System.out.println("5. Laporan");
        System.out.println("=================================================");
        angka = input.nextInt();

        switch (angka) {
            case 1 :
            inputBarang();
            break;
            case 2 :
            System.out.println("Selamat datang di menu Update Data Barang!");
            break;
            case 3 :
            System.out.println("Selamat datang di menu Input Barang Masuk!");
            break;
            case 4 :
            System.out.println("Selamat datang di menu Input Barang Keluar!");
            break;
            case 5 :
            System.out.println("Selamat datang di menu Laporan!");
            break;

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
}
