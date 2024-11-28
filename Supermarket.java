import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Supermarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Login section
        System.out.println("+-----------------------------------------------------+");
        System.out.println("                     Log in");
        System.out.println("+-----------------------------------------------------+");

        // Simulasi login dengan data yang sudah ditentukan
        String storedUsername = "Annisa";
        String storedPassword = "******";
        String storedCaptcha = "12345";

        // Input login dari user
        boolean loginSuccessful = false;
        while (!loginSuccessful) {
            System.out.print("Username : ");
            String username = scanner.nextLine().trim();

            System.out.print("Password  : ");
            String password = scanner.nextLine().trim();

            System.out.print("Captcha    : ");
            String captcha = scanner.nextLine().trim();

            // Validasi login
            if (username.equals(storedUsername) && password.equals(storedPassword)
                    && captcha.equalsIgnoreCase(storedCaptcha)) {
                loginSuccessful = true;
                System.out.println("Login berhasil!");
            } else {
                System.out.println("Login gagal, silakan coba lagi.\n");
            }
        }

        System.out.println("+-----------------------------------------------------+");
        System.out.println("  Selamat Datang di IndoApril!");

        // Menampilkan waktu sekarang
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        System.out.println("  Tanggal dan Waktu : " + dateFormat.format(now));
        System.out.println("+-----------------------------------------------------+");

        // Input transaksi
        System.out.print("No. Faktur      : ");
        String noFaktur = scanner.nextLine().trim();

        System.out.print("Kode Barang  : ");
        String kodeBarang = scanner.nextLine().toUpperCase().trim();

        System.out.print("Nama Barang : ");
        String namaBarang = scanner.nextLine().trim();

        double hargaBarang = 0;
        while (true) {
            System.out.print("Harga Barang : ");
            try {
                hargaBarang = Double.parseDouble(scanner.nextLine().trim());
                if (hargaBarang > 0) {
                    break;
                } else {
                    System.out.println("Harga barang harus lebih besar dari nol.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka yang valid untuk harga barang.");
            }
        }

        int jumlahBeli = 0;
        while (true) {
            System.out.print("Jumlah Beli     : ");
            try {
                jumlahBeli = Integer.parseInt(scanner.nextLine().trim());
                if (jumlahBeli > 0) {
                    break;
                } else {
                    System.out.println("Jumlah beli harus lebih besar dari nol.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka yang valid untuk jumlah beli.");
            }
        }

        // Menghitung total
        double total = hargaBarang * jumlahBeli;

        // Menampilkan data transaksi
        System.out.println("+-----------------------------------------------------+");
        System.out.println("No. Faktur      : " + noFaktur);
        System.out.println("Kode Barang  : " + kodeBarang);
        System.out.println("Nama Barang : " + namaBarang);
        System.out.printf("Harga Barang : Rp %.2f%n", hargaBarang);
        System.out.println("Jumlah Beli     : " + jumlahBeli);
        System.out.printf("TOTAL             : Rp %.2f%n", total);
        System.out.println("+-----------------------------------------------------+");

        // Input nama kasir
        System.out.print("Kasir : ");
        String namaKasir = scanner.nextLine().trim();

        // Menampilkan kasir
        System.out.println("+-----------------------------------------------------+");
        System.out.println("Kasir : " + namaKasir.toUpperCase());
        System.out.println("+-----------------------------------------------------+");
        System.out.println("Terima kasih sudah berbelanja di IndoApril!");

        scanner.close();
    }
}
