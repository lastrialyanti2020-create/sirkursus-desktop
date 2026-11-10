/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihan;

public class latihanmenghitungluasdankelilingbidangdatar {
    public static void main(String[] args){
        String namaBidang = "Persegi Panjang";
        double panjang = 15.0;
        double lebar = 8.0;

        // Rumus Luas dan Keliling
        double luas = panjang * lebar;
        double keliling = 2 * (panjang + lebar);

        // Menampilkan Hasil
        System.out.println("=== Perhitungan Bidang Datar ===");
        System.out.println("Bidang Datar : " + namaBidang);
        System.out.println("Panjang      : " + panjang + " cm");
        System.out.println("Lebar        : " + lebar + " cm");
        System.out.println("Luas         : " + luas + " cm persegi");
        System.out.println("Keliling     : " + keliling + " cm");
    }
}
