package Project;

import java.util.Scanner;

public class NestedLoopBarang {
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        
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
