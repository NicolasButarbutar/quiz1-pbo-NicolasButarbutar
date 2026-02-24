package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

// NAMA : Nicolas J Grace Butarbutar
// NIM  : 12S24038

public class solution {

    public static void main(String[] args) {
        // Method main ini dapat digunakan sebagai pintu masuk utama.
        // Anda bisa memanggil method static dari masing-masing soal di sini.
        System.out.println("File solution.java berhasil dimuat.");
    }

    // ======================================================
    // ====================== SOAL 1 ========================
    // ======================================================
    // SISTEM KASIR RESTORAN

    static class Menu {
        private String kode;
        private String nama;
        private double harga;

        public Menu(String kode, String nama, double harga) {
            this.kode = kode;
            this.nama = nama;
            this.harga = harga;
        }

        public String getNama() { return nama; }
        public double getHarga() { return harga; }
    }

    static class Order {
        private Menu menu;
        private int porsi;

        public Order(Menu menu, int porsi) {
            this.menu = menu;
            this.porsi = porsi;
        }

        public int getPorsi() { return porsi; }
        public double getSubTotal() { return porsi * menu.getHarga(); }
        public Menu getMenu() { return menu; }
    }

    static class Restoran {
        private Map<String, Menu> daftarMenu;

        public Restoran() {
            daftarMenu = new HashMap<>();
            inisialisasiMenu();
        }

        private void inisialisasiMenu() {
            daftarMenu.put("NGS", new Menu("NGS", "Nasi Goreng Spesial", 15000));
            daftarMenu.put("AP", new Menu("AP", "Ayam Penyet", 20000));
            daftarMenu.put("SA", new Menu("SA", "Sate Ayam (10 Tusuk)", 25000));
            daftarMenu.put("BU", new Menu("BU", "Bakso Urat", 18000));
            daftarMenu.put("MAP", new Menu("MAP", "Mie Ayam Pangsit", 15000));
            daftarMenu.put("GG", new Menu("GG", "Gado-Gado", 15000));
            daftarMenu.put("SAM", new Menu("SAM", "Soto Ayam", 17000));
            daftarMenu.put("RD", new Menu("RD", "Rendang Daging", 25000));
            daftarMenu.put("IB", new Menu("IB", "Ikan Bakar", 35000));
            daftarMenu.put("NUK", new Menu("NUK", "Nasi Uduk Komplit", 20000));
        }

        public Menu cariMenu(String kode) {
            return daftarMenu.get(kode.toUpperCase());
        }
    }

    static class Transaksi {
        private List<Order> daftarPesanan = new ArrayList<>();

        public void tambahPesanan(Order order) {
            daftarPesanan.add(order);
        }

        public double hitungTotal() {
            double total = 0;
            for (Order order : daftarPesanan) {
                total += order.getSubTotal();
            }
            return total;
        }

        public void cetakStruk() {
            System.out.println("\nMenu                Porsi   Harga   Total");
            System.out.println("======================================================");
            for (Order order : daftarPesanan) {
                System.out.printf("%-19s %-7d %-7.0f %-10.0f\n", 
                    order.getMenu().getNama(), order.getPorsi(), 
                    order.getMenu().getHarga(), order.getSubTotal());
            }
            System.out.println("======================================================");
            System.out.printf("Total Pembayaran                    %.0f\n", hitungTotal());
        }
    }

    // ======================================================
    // ====================== SOAL 2 ========================
    // ======================================================
    // PENGELOLAAN NILAI SISWA (MODEL RAK)

    public static class Siswa {
        private int nilai;
        private char jenisKelamin;

        public Siswa(int nilai, char jenisKelamin) {
            this.nilai = nilai;
            this.jenisKelamin = jenisKelamin;
        }

        public int getNilai() { return nilai; }
        public char getJenisKelamin() { return jenisKelamin; }
    }

    public static class RakNilai {
        private Siswa[] deretSiswa;

        public RakNilai(int kapasitas) {
            this.deretSiswa = new Siswa[kapasitas];
        }

        public void tambahSiswa(int index, int nilai, char jenisKelamin) {
            this.deretSiswa[index] = new Siswa(nilai, jenisKelamin);
        }

        public int hitungTotalBerdasarkanGender(char targetGender) {
            int total = 0;
            for (Siswa s : deretSiswa) {
                if (s != null && s.getJenisKelamin() == targetGender) {
                    total += s.getNilai();
                }
            }
            return total;
        }
    }

    // ======================================================
    // ====================== SOAL 3 ========================
    // ======================================================
    // SISTEM OPERASIONAL LAUNDRY DEL

    static class LaundryBag {
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

        public void tampilkanFormatBaris() {
            System.out.printf("| %-18s | %-15s | %-6d pcs | %-8s | %-8s |\n", 
                namaMahasiswa, asrama, jumlahPakaian, hariPenjemputan, hariPengantaran);
        }
        
        // Getter tambahan untuk keperluan statistik jika diperlukan
        public int getJumlahPakaian() { return jumlahPakaian; }
    }
}