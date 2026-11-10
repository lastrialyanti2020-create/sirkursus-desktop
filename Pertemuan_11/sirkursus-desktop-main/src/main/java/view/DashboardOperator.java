package view;

import javax.swing.*;
import java.awt.*;

public class DashboardOperator extends JFrame {

    public DashboardOperator() {
        setTitle("Dashboard OPERATOR - SIKURSUS Desktop");
        setSize(900, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Judul dashboard
        JLabel judul = new JLabel(
                "DASHBOARD OPERATOR - SIKURSUS DESKTOP",
                SwingConstants.CENTER);
        judul.setFont(new Font("Segoe UI", Font.BOLD, 22));
        judul.setForeground(Color.WHITE);
        judul.setOpaque(true);
        judul.setBackground(new Color(35, 100, 190));
        judul.setPreferredSize(new Dimension(900, 80));
        add(judul, BorderLayout.NORTH);

        // Menu dashboard
        JPanel menu = new JPanel(new GridLayout(3, 1, 10, 10));
        menu.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 20));
        menu.setBackground(new Color(240, 243, 248));

        JButton btnMaster = new JButton("MASTER DATA");
        JButton btnTransaksi = new JButton("TRANSAKSI");
        JButton btnLogout = new JButton("LOGOUT");

        menu.add(btnMaster);
        menu.add(btnTransaksi);
        menu.add(btnLogout);

        add(menu, BorderLayout.WEST);

        // Area utama
        JLabel welcome = new JLabel(
                "Selamat Datang, OPERATOR!",
                SwingConstants.CENTER);
        welcome.setFont(new Font("Segoe UI", Font.BOLD, 26));
        add(welcome, BorderLayout.CENTER);
        
        // Membuka Master Data Peserta
btnMaster.addActionListener(e -> {
    new MasterPeserta().setVisible(true);
});

        // Tombol Logout
        btnLogout.addActionListener(e -> {
            dispose();
            new LoginPage().setVisible(true);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new DashboardOperator().setVisible(true));
    }
}