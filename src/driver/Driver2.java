// Nama : Nicolas J Grace Butarbutar
// NIM : 12S24038
 
import java.util.Scanner;

public class Driver2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan Jumlah total data (N): ");
        int n = scanner.nextInt();
        
        RakNilai rak = new RakNilai(n);
        
        System.out.println("Masukkan data siswa (Nilai dan Jenis Kelamin [L/P]):");
        for (int i = 0; i < n; i++) {
            System.out.print("Data ke-" + (i+1) + " - Nilai: ");
            int nilai = scanner.nextInt();
            System.out.print("Data ke-" + (i+1) + " - Jenis Kelamin (L/P): ");
            char jk = scanner.next().toUpperCase().charAt(0);
            
            // Menyimpan objek Siswa ke dalam rak
            rak.tambahSiswa(i, nilai, jk);
        }
        
        System.out.println("\nPilihan Kelompok Berdasarkan Jenis Kelamin:");
        System.out.println("L = Laki-laki (Julius, Wilson)");
        System.out.println("P = Perempuan (Yohana, Indah)");
        System.out.print("Masukkan Kode Kelompok (L/P): ");
        char targetGender = scanner.next().toUpperCase().charAt(0);
        
        int total = rak.hitungTotalBerdasarkanGender(targetGender);
        
        System.out.println("------------------------------------");
        System.out.println("Total nilai untuk kelompok " + targetGender + " adalah: " + total);
        System.out.println("------------------------------------");
        
        scanner.close();
    }
}

// Class baru untuk merepresentasikan entitas "Siswa"
class Siswa {
    private int nilai;
    private char jenisKelamin;

    public Siswa(int nilai, char jenisKelamin) {
        this.nilai = nilai;
        this.jenisKelamin = jenisKelamin;
    }

    // Getter untuk mengambil data nilai
    public int getNilai() {
        return nilai;
    }

    // Getter untuk mengambil data jenis kelamin
    public char getJenisKelamin() {
        return jenisKelamin;
    }
}

// Class RakNilai sekarang menyimpan Objek Siswa, bukan lagi angka biasa
class RakNilai {
    // Array of Objects (Menyimpan kumpulan objek Siswa)
    private Siswa[] deretSiswa;

    public RakNilai(int n) {
        deretSiswa = new Siswa[n];
    }

    // Method untuk memasukkan objek Siswa ke dalam array
    public void tambahSiswa(int index, int nilai, char jenisKelamin) {
        // Membuat objek Siswa baru dan memasukkannya ke rak
        deretSiswa[index] = new Siswa(nilai, jenisKelamin);
    }

    // Method perhitungan berdasarkan jenis kelamin
    public int hitungTotalBerdasarkanGender(char targetGender) {
        int total = 0;
        for (int i = 0; i < deretSiswa.length; i++) {
            // Memeriksa jenis kelamin dari setiap objek Siswa
            if (deretSiswa[i].getJenisKelamin() == targetGender) {
                total += deretSiswa[i].getNilai(); 
            }
        }
        return total;
    }
}