package Project;

import java.util.Scanner;

public class NestedLoopKaryawan {
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        
        System.out.print("Jumlah Karyawan : ");
        int n = sc.nextInt();
        
        String karyawan[][] = new String[n][3];

        for(int i= 0; i<n; i++){
            System.out.println("");
            System.out.println("Data Karyawan ke "+(i+1));

            for(int j=0;j<3;j++){      
                if (j == 0)
                    System.out.print("Nama Karyawan : ");
                else if (j == 1)
                    System.out.print("Alamat        : ");
                else
                    System.out.print("Umur          : ");
                
                System.out.print("");
                karyawan[i][j] = sc.next();
            }
        }

        System.out.println("Data Karyawan yang dimasukan");
        System.out.println("------------------------------------------------------");
        System.out.println("Nama Karyawan   \t Alamat \t\t Umur \t");
        
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                System.out.print(karyawan[i][j]+"\t\t\t");
            }
        System.out.println();
        }
    }
}
