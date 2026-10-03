package app;

import java.util.ArrayList;
import model.Orang;
import model.Peserta;
import model.Instruktur;

public class DemoInheritance {
    public static void main(String[] args) {
        ArrayList<Orang> daftarOrang = new ArrayList<>();

        // Memasukkan 3 Peserta ke dalam list (menggunakan datamu sebagai salah satu object)
        daftarOrang.add(new Peserta(1, "Orang", "081234567890", "2924000", "Informatika"));
        daftarOrang.add(new Peserta(2, "Rafi Akbar", "081298765432", "252002", "Informatika"));
        daftarOrang.add(new Peserta(3, "Alya Rahma", "081234567891", "252001", "Informatika"));

        // Memasukkan 2 Instruktur ke dalam list
        daftarOrang.add(new Instruktur(101, "Dina Pratama", "081211110001", "Java Desktop"));
        daftarOrang.add(new Instruktur(102, "Rizal Maulana", "081211110002", "Data Science"));

        System.out.println("=== DATA SIKURSUS ===");
        // Menampilkan seluruh informasi object melalui loop
        for (Orang orang : daftarOrang) {
            System.out.println(orang.getInfo());
        }

        System.out.println("\n=== UJI PERUBAHAN DATA (SETTER PARENT) ===");
        // Mengubah nama object pertama menggunakan setter dari class Orang
        Orang orangPertama = daftarOrang.get(0);
        orangPertama.setNama("Orang. (Updated)");
        
        // Membuktikan bahwa field parent tetap dapat diubah melalui method parent
        System.out.println(orangPertama.getInfo());
    }
}