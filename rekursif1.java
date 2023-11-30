package Project;

public class rekursif1 {
    static String namaBarang[] = {"minyak", "beras", "susu", "roti", "snack"};
    static int stok[] = {85, 40, 56, 112, 666};

    public static void main(String[] args) {
        tampilData();
        jumlahStok();
    }
    static void tampilData(){
        for (int i = 0; i < namaBarang.length; i++){
            System.out.println("=================================");
            System.out.println("Data Barang ke-"+(i+1)+": ");
            System.out.println("Nama Barang: " + namaBarang[i]);
            System.out.println("Stok: " + stok[i]);
            System.out.println("=================================");
            System.out.println();
        }
    }
    static void jumlahStok(){
        int hasil = 0;
        for (int i = 0; i < stok.length; i++){
            hasil += stok[i];
        }
        System.out.print("Jumlah Stok Barang: " + hasil);
    }
}
