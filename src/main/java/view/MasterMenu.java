package view;

import java.awt.Component;
import javax.swing.JOptionPane;

public final class MasterMenu {

    private MasterMenu() {
    }

    public static void tampilkan(Component parent) {
        String[] pilihan = {"Peserta", "Kursus", "Kelas", "Instruktur"};

        int p = JOptionPane.showOptionDialog(
                parent,
                "Pilih data master yang akan dibuka:",
                "Master Data",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, pilihan, pilihan[0]);

        switch (p) {
            case 0: new MasterPeserta().setVisible(true); break;
            case 1: new MasterKursus().setVisible(true); break;
            case 2: new MasterKelas().setVisible(true); break;
            case 3: new MasterInstruktur().setVisible(true); break;
            default: break;
        }
    }
}