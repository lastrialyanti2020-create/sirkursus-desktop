package LATIHAN;

public class latihan2 {

    public static void main(String[] args) {

        String kode = "JAVA-BSC";
        String nama = "Java Desktop Fundamental";

        // Biaya
        double biaya = 2_120_000;
        double registrasi = 500_000;

        // Total sebelum diskon
        double totalSebelumDiskon = biaya + registrasi;

        // Diskon
        double diskon;

        if (totalSebelumDiskon >= 600_000) {
            diskon = 0.10;
        } else {
            diskon = 0.05;
        }

        // Perhitungan
        double potongan = totalSebelumDiskon * diskon;
        double total = totalSebelumDiskon - potongan;

        // Status
        String status;

        if (total >= 600_000) {
            status = "MAHAL";
        } else {
            status = "TERJANGKAU";
        }

        // Menampilkan hasil
        System.out.println("======================================");
        System.out.println("          DATA KURSUS JAVA");
        System.out.println("======================================");

        System.out.println("Kode                 : " + kode);
        System.out.println("Kursus               : " + nama);
        System.out.printf("Biaya Kursus         : Rp%,.0f%n", biaya);
        System.out.printf("Biaya Registrasi     : Rp%,.0f%n", registrasi);
        System.out.printf("Total Sebelum Diskon : Rp%,.0f%n",
                totalSebelumDiskon);
        System.out.printf("Diskon               : %.0f%%%n",
                diskon * 100);
        System.out.printf("Potongan             : Rp%,.0f%n",
                potongan);
        System.out.printf("Total Bayar          : Rp%,.0f%n",
                total);
        System.out.println("Status               : " + status);

        System.out.println("======================================");
    }
}