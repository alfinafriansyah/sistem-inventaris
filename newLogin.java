package Project;

import java.util.Scanner;

public class newLogin {
    public static void main(String[] args) {
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
        int error = 0;
        for (int i = 0; i < username.length; i++){
            if (user.equalsIgnoreCase(username[i]) && pass == password[i]){
                login = 1;
            }else {
                continue;
            }
        }
        if (login == 1){
            System.out.println("Login Berhasil");
        }else {
            System.out.println("Login Gagal");
        }
    }
}
