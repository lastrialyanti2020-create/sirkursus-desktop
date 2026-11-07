/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihan;
public class latihanterarah {
   public static void main(String[] args) {
        String kode = "JAVA-BSC";
        String nama = "Java Desktop Fundamental";
        double biaya = 3_500_000;
        double biayaRegistrasi = 500_000;
        boolean aktif = true;
        double totalSebelumDiskon = biaya;

        double diskon;
        if (totalSebelumDiskon >= 3_500_000) {
            diskon = 0.15; // Diskon 15%
        } else if (totalSebelumDiskon >= 1_500_000) {
            diskon = 0.10; // Diskon 10%
        } else if (totalSebelumDiskon >= 1_000_000) {
            diskon = 0.05; // Diskon 5%
        } else {
            diskon = 0.0;  // Tidak dapat diskon jika di bawah 1 juta
        }
        double potongan = totalSebelumDiskon * diskon;
        double total = totalSebelumDiskon - potongan + biayaRegistrasi;
        String status;
        if (total >= 750_000) {
            status = "MAHAL";
        } else {
            status = "TERJANGKAU";
        }
        
        System.out.println("Kode              : " + kode);
        System.out.println("Kursus            : " + nama);
        System.out.println("Aktif             : " + aktif);
        System.out.printf("Biaya Kursus      : Rp%,.0f%n", biaya);
        System.out.printf("Diskon            : %.0f%%%n", diskon * 100);
        System.out.printf("Potongan Diskon   : Rp%,.0f%n", potongan);
        System.out.printf("Biaya Registrasi  : Rp%,.0f%n", biayaRegistrasi);
        System.out.printf("Total Pembayaran  : Rp%,.0f%n", total);
        System.out.println("Status            : " + status);
    }
}
