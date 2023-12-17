import java.util.Locale;
import java.util.Scanner;
import java.text.NumberFormat;

public class SistemInventaris {
    static Scanner sc = new Scanner(System.in);
    static String[] barang = new String[100];
    static int[] harga = new int[100];
    static int[] stok = new int[100];
    static String[] satuan = new String[100];
    static String laporMasuk[] = new String[100];
    static String laporKeluar[] = new String[100];
    static String laporRusak[] = new String[100];
    static int jmlKeluar[] = new int[100];
    static String RED = "\u001b[31m";
    static String GREEN = "\u001b[32m";
    static String RESET = "\u001b[0m";
    public static void main(String[] args) {
        barang[0] = "minyak"; barang[1] = "beras"; barang[2] = "susu"; barang[3] = "roti"; barang[4] = "snack";
        harga[0] = 15000; harga[1] = 10000; harga[2] = 5000; harga[3] = 2500; harga[4] = 2000;
        stok[0] = 85; stok[1] = 40; stok[2] = 56; stok[3] = 5; stok[4] = 666;
        satuan[0] = "liter"; satuan[1] = "karung"; satuan[2] = "botol"; satuan[3] = "pcs"; satuan[4] = "pcs";
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
        System.out.println("6. Search");
        System.out.println("7. Tampilkan Semua Data Barang");
        System.out.println("8. Laporan");
        System.out.println("=================================================");
        System.out.print("Pilih Menu: ");
        int angka = sc.nextInt();
        System.out.println();

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
            search();
            break;
            case 7 :
            tampilData();
            break;
            case 8 :
            laporan();
            break;

            default:
                System.out.println(RED+"Maaf, menu yang anda pilih tidak valid!"+RESET);
                System.out.println();
                menu();
        }
    }

    public static void inputBarang(){
        System.out.println("=================================================");
        System.out.println("                Input Data Barang              ");
        System.out.println("=================================================");
        System.out.print("Jumlah Barang : ");
        int n = sc.nextInt();
        int no = 0;
        for(int i = 5; i < (5 + n); i++){
            for(int j = 1; j <= n; j++){
                no = j;
                System.out.println("Barang ke-"+no);
                System.out.print("Masukkan Nama Barang: ");
                String brg = sc.nextLine();
                sc.nextLine();
                System.out.print("Masukkan Harga Barang: ");
                int hrg = sc.nextInt();
                System.out.print("Masukkan Stok Barang: ");
                int stk = sc.nextInt();
                System.out.print("Masukkan Satuan Barang: ");
                String stn = sc.nextLine();
                sc.nextLine();
                if(hrg > 0 && stk > 0){
                    barang[i] = brg;
                    harga[i] = hrg;
                    stok[i] = stk;
                    satuan[i] = stn;
                    System.out.println(GREEN+"Input Berhasil!"+RESET);
                }else{
                    System.out.println(RED+"Harga dan Stok tidak bisa kurang dari 0!"+RESET);
                }
            }
        }

        System.out.println("Data Barang sekarang: ");
        printTabel();

        System.out.print("Apakah anda ingin memimilih menu lain?(y/t) ");
        char kembali = sc.next().charAt(0);
        if (kembali == 'Y' || kembali == 'y'){
            menu();
        }
    }

    public static void updateBarang(){
        System.out.println("=================================================");
        System.out.println("                Update Data Barang              ");
        System.out.println("=================================================");
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
            System.out.println("Satuan: " + satuan[key]);
            System.out.print("Masukkan Nama Barang Baru: ");
            String namaBaru = sc.next();
            System.out.print("Masukkan Harga Barang Baru: ");
            int hargaBaru = sc.nextInt();
            System.out.print("Masukkan Stok Barang Baru: ");
            int stokBaru = sc.nextInt();
            System.out.print("Masukkan Satuan Barang Baru: ");
            String satuanBaru = sc.next();
            if(hargaBaru > 0 && stokBaru > 0){
                barang[key] = namaBaru;
                harga[key] = hargaBaru;
                stok [key] = stokBaru;
                satuan[key] = satuanBaru;
                System.out.println(GREEN+"Input berhasil!"+RESET);
                System.out.println();
            }else{
                System.out.println(RED+"Harga dan Stok tidak bisa kurang dari 0!"+RESET);
                System.out.println();
            }
        }else{
            System.out.println(RED+"Barang tidak ditemukan!"+RESET);
        }
        System.out.println("Data Barang sekarang: ");
        printTabel();

        System.out.print("Apakah anda ingin memimilih menu lain?(y/t) ");
        char kembali = sc.next().charAt(0);
        if (kembali == 'Y' || kembali == 'y'){
            menu();
        }
    }

    public static void barangMasuk(){
        System.out.println("=================================================");
        System.out.println("                Input Barang Masuk              ");
        System.out.println("=================================================");
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
            }else{
                System.out.println(RED+"Barang tidak ditemukan!"+RESET);
            }
        }
        System.out.println("Data Barang sekarang: ");
        printTabel();

        System.out.print("Apakah anda ingin memimilih menu lain?(y/t) ");
        char kembali = sc.next().charAt(0);
        if (kembali == 'Y' || kembali == 'y'){
            menu();
        }
    }
    
    public static void barangKeluar(){
        System.out.println("=================================================");
        System.out.println("                Input Barang Keluar              ");
        System.out.println("=================================================");
        System.out.print("Jumlah Barang Keluar: ");
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
                System.out.print("Masukkan Jumlah Barang Keluar: ");
                int jumlah = sc.nextInt();
                if (jumlah > 0 && jumlah < stok[key]){
                    stok[key] -= jumlah;
                    jmlKeluar[i] += jumlah;
                    System.out.print("Masukkan Tanggal(dd/mm/yyy): ");
                    String tanggal = sc.next();
                    laporKeluar[i] = "Tanggal: "+tanggal+"\nNama Barang: "+cari+"\nJumlah: "+jumlah;
                    System.out.println(GREEN+"Input berhasil!"+RESET);
                    System.out.println();
                }else{
                    System.out.println(RED+"Angka yang anda masukkan tidak valid!"+RESET);
                    System.out.println();
                }
            }else{
                System.out.println(RED+"Barang tidak ditemukan!"+RESET);
            }
        }
        System.out.println("Data Barang sekarang: ");
        printTabel();

        System.out.print("Apakah anda ingin memimilih menu lain?(y/t) ");
        char kembali = sc.next().charAt(0);
        if (kembali == 'Y' || kembali == 'y'){
            menu();
        }
    }

    public static void barangRusak(){
        System.out.println("=================================================");
        System.out.println("                Input Barang Rusak              ");
        System.out.println("=================================================");
        System.out.print("Jumlah Barang Rusak: ");
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
                System.out.print("Masukkan Jumlah Barang Rusak: ");
                int jumlah = sc.nextInt();
                if (jumlah > 0 && jumlah < stok[key]){
                    stok[key] -= jumlah;
                    System.out.print("Masukkan Tanggal(dd/mm/yyy): ");
                    String tanggal = sc.next();
                    laporRusak[i] = "Tanggal: "+tanggal+"\nNama Barang: "+cari+"\nJumlah: "+jumlah;
                    System.out.println(GREEN+"Input berhasil!"+RESET);
                    System.out.println();
                }else{
                    System.out.println(RED+"Angka yang anda masukkan tidak valid!"+RESET);
                    System.out.println();
                }
            }else{
                System.out.println(RED+"Barang tidak ditemukan!"+RESET);
            }
        }
        System.out.println("Data Barang sekarang: ");
        printTabel();
        
        System.out.print("Apakah anda ingin memimilih menu lain?(y/t) ");
        char kembali = sc.next().charAt(0);
        if (kembali == 'Y' || kembali == 'y'){
            menu();
        }
    }

    public static void search(){
        System.out.println("=================================================");
        System.out.println("                Search              ");
        System.out.println("=================================================");
        System.out.print("Masukkan nama barang yang dicari: ");
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
        if(hasil == 1){
            System.out.println("Barang yang dicari: ");
            System.out.println("=================================================================================================");
            System.out.println("|\tNama Barang\t|\tHarga\t\t|\tStok\t\t|\tSatuan\t\t|");
            System.out.println("=================================================================================================");
            NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));
            String hrg = format.format(harga[key]);
            System.out.print("|\t"+barang[key]+"\t\t|\t"+hrg+"\t|\t");
            if(stok[key] <= 5){
                System.out.print(RED+stok[key]+RESET);
            }
            else{
                System.out.print(stok[key]);
            }
            System.out.print("\t\t|\t"+satuan[key]+"\t\t|");
            System.out.println();
        System.out.println("=================================================================================================");
        System.out.println();
        }else{
            System.out.println(RED+"Barang tidak ditemukan!"+RESET);
        }
        System.out.print("Apakah anda ingin memimilih menu lain?(y/t) ");
        char kembali = sc.next().charAt(0);
        if (kembali == 'Y' || kembali == 'y'){
            menu();
        }
    }

    public static void tampilData(){
        System.out.println("=================================================");
        System.out.println("               Tampilkan Data Barang              ");
        System.out.println("=================================================");
        printTabel();

        System.out.print("Apakah anda ingin memimilih menu lain?(y/t) ");
        char kembali = sc.next().charAt(0);
        if (kembali == 'Y' || kembali == 'y'){
            menu();
        }
    }

    public static void laporan(){
        System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><>");
        System.out.println("Pilih Menu: ");
        System.out.println("1. Barang Masuk");
        System.out.println("2. Barang Keluar");
        System.out.println("3. Barang Rusak");
        System.out.println("4. Laporan Barang Sering Keluar");
        System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><>");
        System.out.print("Pilih Menu: ");
        int angka = sc.nextInt();
        System.out.println();
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
            case 4:
                lapSeringKeluar();
                break;
            default:
                break;
        }
    }

    public static void lapMasuk(){
        System.out.println("=================================================");
        System.out.println("                Laporan Barang Masuk              ");
        System.out.println("=================================================");
        for(int i = 0; i < laporMasuk.length; i++){
            if(laporMasuk[i] != null){
                System.out.println("Laporan ke-"+(i+1));
                System.out.println(laporMasuk[i]);
                System.out.println("-----------------------------------------------");
            }
        }
        System.out.println();
        System.out.print("Apakah anda ingin memimilih menu lain?(y/t) ");
        char kembali = sc.next().charAt(0);
        if (kembali == 'Y' || kembali == 'y'){
            menu();
        }
    }

    public static void lapKeluar(){
        System.out.println("=================================================");
        System.out.println("                Laporan Barang Keluar              ");
        System.out.println("=================================================");
        for(int i = 0; i < laporKeluar.length; i++){
            if(laporKeluar[i] != null){
                System.out.println("Laporan ke-"+(i+1));
                System.out.println(laporKeluar[i]);
                System.out.println("-----------------------------------------------");
            }
        }
        System.out.print("Apakah anda ingin memimilih menu lain?(y/t) ");
        char kembali = sc.next().charAt(0);
        if (kembali == 'Y' || kembali == 'y'){
            menu();
        }
    }

    public static void lapRusak(){
        System.out.println("=================================================");
        System.out.println("                Laporan Barang Rusak              ");
        System.out.println("=================================================");
        for(int i = 0; i < laporRusak.length; i++){
            if(laporRusak[i] != null){
                System.out.println("Laporan ke-"+(i+1));
                System.out.println(laporRusak[i]);
                System.out.println("-----------------------------------------------");
            }
        }
        System.out.print("Apakah anda ingin memimilih menu lain?(y/t) ");
        char kembali = sc.next().charAt(0);
        if (kembali == 'Y' || kembali == 'y'){
            menu();
        }
    }

    public static void lapSeringKeluar(){
        System.out.println("=================================================");
        System.out.println("           Laporan Barang Sering Keluar          ");
        System.out.println("=================================================");
        int highest = 0;
        int key = 0;
        for(int i=0; i<jmlKeluar.length; i++){
            if(jmlKeluar[i] > highest){
                highest = jmlKeluar[i];
                key = i; 
            }
        }
        System.out.println("Barang yang paling sering keluar / sering habis adalah "+GREEN+barang[key]+RESET+" dengan jumlah: "+jmlKeluar[key]);
        System.out.print("Apakah anda ingin memimilih menu lain?(y/t) ");
        char kembali = sc.next().charAt(0);
        if (kembali == 'Y' || kembali == 'y'){
            menu();
        }
    }

    public static void printTabel(){
        System.out.println("=================================================================================================");
        System.out.println("|\tNama Barang\t|\tHarga\t\t|\tStok\t\t|\tSatuan\t\t|");
        System.out.println("=================================================================================================");
        for(int i = 0; i < barang.length; i++){
            NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));
            String hrg = format.format(harga[i]);
            if(barang[i] != null){
                System.out.print("|\t"+barang[i]+"\t\t|\t"+hrg+"\t|\t");
                if(stok[i] <= 5){
                    System.out.print(RED+stok[i]+RESET);
                }
                else{
                    System.out.print(stok[i]);
                }
                System.out.print("\t\t|\t"+satuan[i]+"\t\t|");
                System.out.println();
            }
        }
        System.out.println("=================================================================================================");
        System.out.println();
    }
}
