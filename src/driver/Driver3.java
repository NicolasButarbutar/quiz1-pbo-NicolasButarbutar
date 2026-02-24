// Nama : Nicolas J Grace Butarbutar
// NIM : 12S24038

import java.util.Scanner;
import java.util.LinkedList; // Untuk menyimpan antrean pesanan
import java.util.Queue;

// 1. CLASS UTAMA (Eksekutor)
public class Driver3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Menggunakan Queue (Antrean) untuk menyimpan data pesanan
        Queue<LaundryBag> antreanLaundry = new LinkedList<>();
        
        System.out.println("========================================");
        System.out.println("   SELAMAT DATANG DI SISTEM LAUNDRY DEL ");
        System.out.println("========================================\n");

        boolean lanjut = true;
        // FITUR 1: LOOPING (Perulangan agar bisa input banyak data)
        while (lanjut) {
            System.out.println("--- INPUT DATA PESANAN BARU ---");
            
            System.out.print("Nama Mahasiswa : ");
            String nama = input.nextLine();

            System.out.print("Asrama         : ");
            String asrama = input.nextLine();

            // FITUR 3: VALIDASI INPUT (Jumlah pakaian tidak boleh <= 0)
            int jumlah = 0;
            while (true) {
                System.out.print("Jumlah Pakaian : ");
                jumlah = input.nextInt();
                if (jumlah > 0) break;
                System.out.println("[!] Error: Jumlah pakaian minimal 1 potong.");
            }
            input.nextLine(); // Membersihkan buffer

            System.out.print("Hari Penjemputan: ");
            String jemput = input.nextLine();

            System.out.print("Hari Pengantaran: ");
            String antar = input.nextLine();

            // FITUR 2: MENYIMPAN KE STRUKTUR DATA (Queue)
            LaundryBag pesanan = new LaundryBag(nama, asrama, jumlah, jemput, antar);
            antreanLaundry.add(pesanan);

            System.out.print("\nTambah pesanan lagi? (y/n): ");
            String pilihan = input.nextLine();
            if (pilihan.equalsIgnoreCase("n")) {
                lanjut = false;
            }
            System.out.println();
        }

        // MENAMPILKAN SEMUA ANTREAN YANG SUDAH TERDAFTAR
        System.out.println("\n--- DAFTAR SELURUH ANTREAN LAUNDRY ---");
        int nomor = 1;
        for (LaundryBag lb : antreanLaundry) {
            System.out.print("No. " + nomor + " ");
            lb.tampilkanData();
            nomor++;
        }

        System.out.println("Terima kasih. Sistem Operasional Laundry Del Selesai.");
        input.close();
    }
}

// 2. CLASS BLUEPRINT (Model Data)
class LaundryBag {
    private String namaMahasiswa;
    private String asrama;
    private int jumlahPakaian;
    private String hariPenjemputan;
    private String hariPengantaran;

    public LaundryBag(String namaMahasiswa, String asrama, int jumlahPakaian, 
                      String hariPenjemputan, String hariPengantaran) {
        this.namaMahasiswa = namaMahasiswa;
        this.asrama = asrama;
        this.jumlahPakaian = jumlahPakaian;
        this.hariPenjemputan = hariPenjemputan;
        this.hariPengantaran = hariPengantaran;
    }

    public void tampilkanData() {
        System.out.println("[" + namaMahasiswa + " | " + asrama + " | " + 
                           jumlahPakaian + " pcs | Jemput: " + hariPenjemputan + 
                           " | Antar: " + hariPengantaran + "]");
    }
}