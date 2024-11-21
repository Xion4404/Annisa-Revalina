import java.util.Scanner;

// Kelas induk (superclass) Barang untuk menyimpan data dasar barang
class Barang {
    // Atribut privat untuk menyimpan informasi barang
    private String kodeBarang;
    private String namaBarang;
    private double hargaBarang;

    // Konstruktor untuk menginisialisasi atribut barang
    public Barang(String kodeBarang, String namaBarang, double hargaBarang) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
    }

    // Metode akses untuk kode barang
    public String getKodeBarang() {
        return kodeBarang;
    }

    // Metode akses untuk nama barang
    public String getNamaBarang() {
        return namaBarang;
    }

    // Metode akses untuk harga barang
    public double getHargaBarang() {
        return hargaBarang;
    }
}

// Kelas turunan (subclass) Transaksi yang mewarisi sifat dari kelas Barang
class Transaksi extends Barang { // Inheritance: Transaksi adalah turunan dari Barang
    private int jumlahBeli;

    // Konstruktor untuk inisialisasi objek Transaksi
    public Transaksi(String kodeBarang, String namaBarang, double hargaBarang, int jumlahBeli) {
        super(kodeBarang, namaBarang, hargaBarang); // Memanggil konstruktor dari kelas induk (Barang)
        this.jumlahBeli = jumlahBeli;
    }

    // Metode untuk menghitung total harga transaksi
    public double hitungTotal() {
        return getHargaBarang() * jumlahBeli; // Menggunakan metode dari kelas induk untuk mendapatkan harga barang
    }
}

// Kelas utama untuk menjalankan aplikasi
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Meminta input dari pengguna untuk data transaksi
            System.out.print("Masukkan No Faktur: ");
            String noFaktur = scanner.nextLine();

            System.out.print("Masukkan Kode Barang: ");
            String kodeBarang = scanner.nextLine();

            System.out.print("Masukkan Nama Barang: ");
            String namaBarang = scanner.nextLine();

            System.out.print("Masukkan Harga Barang: ");
            double hargaBarang = Double.parseDouble(scanner.nextLine()); // Mengonversi input string menjadi tipe double

            // Validasi untuk memastikan harga barang lebih dari 0
            if (hargaBarang <= 0) {
                throw new IllegalArgumentException("Harga barang harus lebih dari 0!"); // Exception handling jika harga tidak valid
            }

            System.out.print("Masukkan Jumlah Beli: ");
            int jumlahBeli = Integer.parseInt(scanner.nextLine()); // Mengonversi input string menjadi integer

            // Validasi untuk memastikan jumlah beli lebih dari 0
            if (jumlahBeli <= 0) {
                throw new IllegalArgumentException("Jumlah beli harus lebih dari 0!"); // Exception handling jika jumlah beli tidak valid
            }

            // Membuat objek Transaksi berdasarkan input
            Transaksi transaksi = new Transaksi(kodeBarang, namaBarang, hargaBarang, jumlahBeli);

            // Menampilkan detail transaksi
            System.out.println("\n--- Detail Transaksi ---");
            System.out.println("No Faktur: " + noFaktur);
            System.out.println("Kode Barang: " + transaksi.getKodeBarang());
            System.out.println("Nama Barang: " + transaksi.getNamaBarang());
            System.out.println("Harga Barang: Rp" + transaksi.getHargaBarang());
            System.out.println("Jumlah Beli: " + jumlahBeli);
            System.out.println("Total: Rp" + transaksi.hitungTotal());
        } catch (NumberFormatException e) {
            // Exception handling untuk menangani input yang bukan angka
            System.out.println("Error: Input harus berupa angka untuk harga barang atau jumlah beli!");
        } catch (IllegalArgumentException e) {
            // Exception handling jika nilai input tidak valid (contohnya harga atau jumlah beli tidak sesuai)
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            // Exception handling untuk kesalahan yang tidak diketahui
            System.out.println("Error: Terjadi kesalahan yang tidak diketahui.");
        } finally {
            // Menutup scanner untuk mencegah kebocoran sumber daya
            scanner.close();
        }
    }
}
