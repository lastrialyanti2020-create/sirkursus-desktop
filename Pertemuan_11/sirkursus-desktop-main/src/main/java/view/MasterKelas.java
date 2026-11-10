package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MasterKelas extends JFrame {

    private JTextField txtKode, txtNama, txtKursus;
    private JTextField txtInstruktur, txtJadwal;
    private DefaultTableModel model;
    private JTable tabel;

    public MasterKelas() {
        setTitle("Master Data Kelas - SIKURSUS Desktop");
        setSize(900, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel judul = new JLabel(
                "MASTER DATA KELAS",
                SwingConstants.CENTER);
        judul.setFont(new Font("Segoe UI", Font.BOLD, 24));
        judul.setForeground(Color.WHITE);
        judul.setOpaque(true);
        judul.setBackground(new Color(40, 100, 190));
        judul.setPreferredSize(new Dimension(900, 70));
        add(judul, BorderLayout.NORTH);

        JPanel form = new JPanel(new GridLayout(6, 2, 10, 10));
        form.setBorder(
                BorderFactory.createEmptyBorder(25, 25, 20, 25));

        txtKode = new JTextField();
        txtNama = new JTextField();
        txtKursus = new JTextField();
        txtInstruktur = new JTextField();
        txtJadwal = new JTextField();

        form.add(new JLabel("Kode Kelas"));
        form.add(txtKode);

        form.add(new JLabel("Nama Kelas"));
        form.add(txtNama);

        form.add(new JLabel("Kursus"));
        form.add(txtKursus);

        form.add(new JLabel("Instruktur"));
        form.add(txtInstruktur);

        form.add(new JLabel("Jadwal"));
        form.add(txtJadwal);

        JButton btnSimpan = new JButton("Simpan");
        JButton btnReset = new JButton("Reset");

        form.add(btnSimpan);
        form.add(btnReset);

        model = new DefaultTableModel(
                new String[]{
                    "Kode", "Nama Kelas", "Kursus",
                    "Instruktur", "Jadwal"
                }, 0);

        tabel = new JTable(model);

        JPanel konten = new JPanel(new BorderLayout(10, 10));
        konten.add(form, BorderLayout.NORTH);
        konten.add(new JScrollPane(tabel), BorderLayout.CENTER);
        add(konten, BorderLayout.CENTER);

        btnSimpan.addActionListener(e -> {
            String kode = txtKode.getText().trim();
            String nama = txtNama.getText().trim();
            String kursus = txtKursus.getText().trim();
            String instruktur = txtInstruktur.getText().trim();
            String jadwal = txtJadwal.getText().trim();

            if (kode.isEmpty() || nama.isEmpty()
                    || kursus.isEmpty() || instruktur.isEmpty()
                    || jadwal.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Semua kolom wajib diisi!");
                return;
            }

            model.addRow(new Object[]{
                kode, nama, kursus, instruktur, jadwal
            });

            JOptionPane.showMessageDialog(this,
                    "Data kelas berhasil ditambahkan!");

            resetForm();
        });

        btnReset.addActionListener(e -> resetForm());
    }

    private void resetForm() {
        txtKode.setText("");
        txtNama.setText("");
        txtKursus.setText("");
        txtInstruktur.setText("");
        txtJadwal.setText("");
        txtKode.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new MasterKelas().setVisible(true));
    }
}