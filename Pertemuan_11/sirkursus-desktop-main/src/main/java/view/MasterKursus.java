package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MasterKursus extends JFrame {

    private JTextField txtKode, txtNama, txtDurasi, txtBiaya;
    private JTable tabel;
    private DefaultTableModel model;

    public MasterKursus() {
        setTitle("Master Data Kursus - SIKURSUS Desktop");
        setSize(850, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JLabel judul = new JLabel("MASTER DATA KURSUS",
                SwingConstants.CENTER);
        judul.setFont(new Font("Segoe UI", Font.BOLD, 22));
        judul.setForeground(Color.WHITE);
        judul.setOpaque(true);
        judul.setBackground(new Color(35, 100, 190));
        judul.setPreferredSize(new Dimension(850, 65));
        add(judul, BorderLayout.NORTH);

        JPanel form = new JPanel(new GridLayout(5, 2, 10, 10));
        form.setBorder(BorderFactory.createEmptyBorder(20, 25, 10, 25));

        txtKode = new JTextField();
        txtNama = new JTextField();
        txtDurasi = new JTextField();
        txtBiaya = new JTextField();

        form.add(new JLabel("Kode Kursus"));
        form.add(txtKode);
        form.add(new JLabel("Nama Kursus"));
        form.add(txtNama);
        form.add(new JLabel("Durasi"));
        form.add(txtDurasi);
        form.add(new JLabel("Biaya"));
        form.add(txtBiaya);

        JButton btnSimpan = new JButton("Simpan");
        JButton btnReset = new JButton("Reset");
        form.add(btnSimpan);
        form.add(btnReset);

        model = new DefaultTableModel(
                new String[]{"Kode", "Nama Kursus", "Durasi", "Biaya"}, 0);
        tabel = new JTable(model);

       JPanel konten = new JPanel(new BorderLayout(10, 10));
konten.add(form, BorderLayout.NORTH);
konten.add(new JScrollPane(tabel), BorderLayout.CENTER);

add(konten, BorderLayout.CENTER);

        btnSimpan.addActionListener(e -> {
            String kode = txtKode.getText().trim();
            String nama = txtNama.getText().trim();
            String durasi = txtDurasi.getText().trim();
            String biaya = txtBiaya.getText().trim();

            if (kode.isEmpty() || nama.isEmpty()
                    || durasi.isEmpty() || biaya.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Semua kolom wajib diisi!");
                return;
            }

            model.addRow(new Object[]{kode, nama, durasi, biaya});
            JOptionPane.showMessageDialog(this,
                    "Data kursus berhasil ditambahkan ke tabel!");

            txtKode.setText("");
            txtNama.setText("");
            txtDurasi.setText("");
            txtBiaya.setText("");
        });

        btnReset.addActionListener(e -> {
            txtKode.setText("");
            txtNama.setText("");
            txtDurasi.setText("");
            txtBiaya.setText("");
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new MasterKursus().setVisible(true));
    }
}