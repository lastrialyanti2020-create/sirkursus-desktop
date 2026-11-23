package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MasterKursus extends JFrame {

    private final JTextField txtKode = new JTextField();
    private final JTextField txtNama = new JTextField();
    private final JTextField txtDurasi = new JTextField();
    private final JTextField txtBiaya = new JTextField();
    private final DefaultTableModel model = new DefaultTableModel(
            new String[]{"Kode", "Nama Kursus", "Durasi", "Biaya"}, 0);

    public MasterKursus() {
        setTitle("Master Data Kursus - SIKURSUS Desktop");
        setSize(900, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel judul = new JLabel("MASTER DATA KURSUS", SwingConstants.CENTER);
        judul.setFont(new Font("Segoe UI", Font.BOLD, 24));
        judul.setForeground(Color.WHITE);
        judul.setOpaque(true);
        judul.setBackground(new Color(40, 100, 190));
        judul.setPreferredSize(new Dimension(900, 70));
        add(judul, BorderLayout.NORTH);

        JPanel form = new JPanel(new GridLayout(5, 2, 10, 10));
        form.setBorder(BorderFactory.createEmptyBorder(25, 25, 20, 25));
        form.add(new JLabel("Kode Kursus")); form.add(txtKode);
        form.add(new JLabel("Nama Kursus")); form.add(txtNama);
        form.add(new JLabel("Durasi"));      form.add(txtDurasi);
        form.add(new JLabel("Biaya"));       form.add(txtBiaya);

        JButton btnSimpan = new JButton("Simpan");
        JButton btnReset = new JButton("Reset");
        form.add(btnSimpan);
        form.add(btnReset);

        JPanel konten = new JPanel(new BorderLayout(10, 10));
        konten.add(form, BorderLayout.NORTH);
        konten.add(new JScrollPane(new JTable(model)), BorderLayout.CENTER);
        add(konten, BorderLayout.CENTER);

        btnSimpan.addActionListener(e -> {
            String kode = txtKode.getText().trim();
            String nama = txtNama.getText().trim();
            String durasi = txtDurasi.getText().trim();
            String biaya = txtBiaya.getText().trim();

            if (kode.isEmpty() || nama.isEmpty() || durasi.isEmpty() || biaya.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua kolom wajib diisi!");
                return;
            }
            model.addRow(new Object[]{kode, nama, durasi, biaya});
            JOptionPane.showMessageDialog(this, "Data kursus berhasil ditambahkan!");
            resetForm();
        });
        btnReset.addActionListener(e -> resetForm());
    }

    private void resetForm() {
        txtKode.setText("");
        txtNama.setText("");
        txtDurasi.setText("");
        txtBiaya.setText("");
        txtKode.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MasterKursus().setVisible(true));
    }
}