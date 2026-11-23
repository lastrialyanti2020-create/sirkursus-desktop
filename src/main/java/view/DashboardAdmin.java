package view;

import javax.swing.*;
import java.awt.*;

public class DashboardAdmin extends JFrame {

    public DashboardAdmin() {
        setTitle("Dashboard ADMIN - SIKURSUS Desktop");
        setSize(900, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel judul = new JLabel(
                "DASHBOARD ADMIN - SIKURSUS DESKTOP",
                SwingConstants.CENTER);
        judul.setFont(new Font("Segoe UI", Font.BOLD, 22));
        judul.setForeground(Color.WHITE);
        judul.setOpaque(true);
        judul.setBackground(new Color(35, 100, 190));
        judul.setPreferredSize(new Dimension(900, 80));
        add(judul, BorderLayout.NORTH);

        JPanel menu = new JPanel(new GridLayout(4, 1, 10, 10));
        menu.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 20));
        menu.setBackground(new Color(240, 243, 248));

        JButton btnMaster = new JButton("MASTER DATA");
        JButton btnTransaksi = new JButton("TRANSAKSI");
        JButton btnLaporan = new JButton("LAPORAN");
        JButton btnLogout = new JButton("LOGOUT");

        menu.add(btnMaster);
        menu.add(btnTransaksi);
        menu.add(btnLaporan);
        menu.add(btnLogout);
        add(menu, BorderLayout.WEST);

        JLabel welcome = new JLabel("Selamat Datang, ADMIN!", SwingConstants.CENTER);
        welcome.setFont(new Font("Segoe UI", Font.BOLD, 26));
        add(welcome, BorderLayout.CENTER);

        btnMaster.addActionListener(e -> MasterMenu.tampilkan(this));
        btnTransaksi.addActionListener(e -> new FormPendaftaranKursus().setVisible(true));

        // Laporan Peserta (JasperReports)
        btnLaporan.addActionListener(e -> report.ReportService.tampilkanLaporanPeserta());

        btnLogout.addActionListener(e -> {
            dispose();
            new LoginPage().setVisible(true);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DashboardAdmin().setVisible(true));
    }
}