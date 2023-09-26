package Project;

import java.util.Scanner;

public class login {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int username = 123;
        int password = 123;
        System.out.println("Masukkan Username dan Password");
        System.out.print("Username    : ");
        int user = input.nextInt();
        System.out.print("Password    : ");
        int pw = input.nextInt();
        if (user == username && pw == password){
            System.out.println("Selamat Datang!");
        }else{
            System.out.println("Username atau Password yang anda masukkan salah");
        }
    }
}
