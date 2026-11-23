package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MasterInstruktur extends JFrame {

    private final JTextField txtKode = new JTextField();
    private final JTextField txtNama = new JTextField();
    private final JTextField txtKeahlian = new JTextField();
    private final JTextField txtNoHp = new JTextField();
    private final DefaultTableModel model = new DefaultTableModel(
            new String[]{"Kode", "Nama Instruktur", "Keahlian", "Nomor HP"}, 0);

    public MasterInstruktur() {
        setTitle("Master Data Instruktur - SIKURSUS Desktop");
        setSize(900, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel judul = new JLabel("MASTER DATA INSTRUKTUR", SwingConstants.CENTER);
        judul.setFont(new Font("Segoe UI", Font.BOLD, 24));
        judul.setForeground(Color.WHITE);
        judul.setOpaque(true);
        judul.setBackground(new Color(40, 100, 190));
        judul.setPreferredSize(new Dimension(900, 70));
        add(judul, BorderLayout.NORTH);

        JPanel form = new JPanel(new GridLayout(5, 2, 10, 10));
        form.setBorder(BorderFactory.createEmptyBorder(25, 25, 20, 25));
        form.add(new JLabel("Kode Instruktur")); form.add(txtKode);
        form.add(new JLabel("Nama Instruktur")); form.add(txtNama);
        form.add(new JLabel("Keahlian"));        form.add(txtKeahlian);
        form.add(new JLabel("Nomor HP"));        form.add(txtNoHp);

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
            String keahlian = txtKeahlian.getText().trim();
            String noHp = txtNoHp.getText().trim();

            if (kode.isEmpty() || nama.isEmpty() || keahlian.isEmpty() || noHp.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua kolom wajib diisi!");
                return;
            }
            model.addRow(new Object[]{kode, nama, keahlian, noHp});
            JOptionPane.showMessageDialog(this, "Data instruktur berhasil ditambahkan!");
            resetForm();
        });
        btnReset.addActionListener(e -> resetForm());
    }

    private void resetForm() {
        txtKode.setText("");
        txtNama.setText("");
        txtKeahlian.setText("");
        txtNoHp.setText("");
        txtKode.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MasterInstruktur().setVisible(true));
    }
}