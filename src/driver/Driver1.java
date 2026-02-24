// NAMA : Nicolas J Grace Butarbutar
// NIM : 12S24038

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// --- PINDAHKAN KELAS DRIVER1 KE PALING ATAS ---
public class Driver1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restoran restoran = new Restoran();
        Transaksi transaksi = new Transaksi();

        while (true) {
            // Cek apakah ada input lagi
            if (!scanner.hasNextLine()) break;
            
            String kodeInput = scanner.nextLine().trim();
            
            if (kodeInput.equalsIgnoreCase("END")) {
                break;
            }

            Menu menuDipilih = restoran.cariMenu(kodeInput);
            
            if (menuDipilih != null) {
                if (scanner.hasNextLine()) {
                    String porsiStr = scanner.nextLine().trim();
                    // Validasi agar tidak error jika input porsi kosong
                    if (!porsiStr.isEmpty()) {
                        int porsiButet = Integer.parseInt(porsiStr);
                        Order pesananBaru = new Order(menuDipilih, porsiButet);
                        transaksi.tambahPesanan(pesananBaru);
                    }
                }
            } else {
                // Opsional: Print error jika menu tidak ditemukan
                // System.out.println("Menu tidak ditemukan");
            }
        }

        transaksi.cetakStruk();
        scanner.close();
    }
}

// --- KELAS LAINNYA DI BAWAHNYA ---

class Menu {
    private String kode;
    private String nama;
    private double harga;

    public Menu(String kode, String nama, double harga) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
    }

    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public double getHarga() { return harga; }
}

class Order {
    private Menu menu;
    private int porsiButet;

    public Order(Menu menu, int porsiButet) {
        this.menu = menu;
        this.porsiButet = porsiButet;
    }

    public int getTotalPorsi() {
        return porsiButet * 3;
    }

    public double getSubTotal() {
        return getTotalPorsi() * menu.getHarga();
    }

    public Menu getMenu() { return menu; }
}

class Restoran {
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

class Transaksi {
    private List<Order> daftarPesanan;

    public Transaksi() {
        daftarPesanan = new ArrayList<>();
    }

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
        System.out.println(""); // Baris kosong awal
        System.out.println("Menu                Porsi   Harga   Total");
        System.out.println("======================================================");
        
        for (Order order : daftarPesanan) {
            System.out.printf("%-19s %-7d %-7.0f %-10.0f\n", 
                order.getMenu().getNama(), 
                order.getTotalPorsi(), 
                order.getMenu().getHarga(), 
                order.getSubTotal());
        }
        
        System.out.println("======================================================");
        double totalPembayaran = hitungTotal();
        System.out.printf("Total Pembayaran                    %.0f\n", totalPembayaran);
        
        cekKupon(totalPembayaran);
    }

    private void cekKupon(double total) {
        String kupon = "";
        if (total >= 500000) kupon = "Kupon Hitam (Diskon 25%)";
        else if (total >= 400000) kupon = "Kupon Hijau (Diskon 20%)";
        else if (total >= 300000) kupon = "Kupon Merah (Diskon 15%)";
        else if (total >= 200000) kupon = "Kupon Kuning (Diskon 10%)";
        else if (total >= 100000) kupon = "Kupon Biru (Diskon 5%)";

        if (!kupon.isEmpty()) {
            System.out.println("\nSelamat! Anda mendapatkan " + kupon);
        }
    }
}