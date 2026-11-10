
package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import config.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import config.PasswordUtil;

public class LoginPage extends JFrame {

    private JTextField txtUsername;
    private JPasswordField txtPassword;

    public LoginPage() {
        setTitle("Login - SIKURSUS Desktop");
        setSize(480, 430);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(248, 249, 252));
        panel.setBorder(new EmptyBorder(35, 55, 35, 55));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel judul = new JLabel("SIKURSUS DESKTOP");
        judul.setFont(new Font("Segoe UI", Font.BOLD, 25));
        judul.setForeground(new Color(35, 75, 145));
        judul.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subjudul = new JLabel("Silakan login ke akun Anda");
        subjudul.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        subjudul.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setAlignmentX(Component.LEFT_ALIGNMENT);

        txtUsername = new JTextField();
        txtUsername.setMaximumSize(new Dimension(370, 38));

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setAlignmentX(Component.LEFT_ALIGNMENT);

        txtPassword = new JPasswordField();
        txtPassword.setMaximumSize(new Dimension(370, 38));

        JButton btnLogin = new JButton("LOGIN");
        btnLogin.setBackground(new Color(35, 100, 190));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnLogin.setFocusPainted(false);
        btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnLogin.setMaximumSize(new Dimension(370, 42));

        btnLogin.addActionListener(e -> {
            String username = txtUsername.getText().trim();
            char[] password = txtPassword.getPassword();

            if (username.isEmpty() || password.length == 0) {
                JOptionPane.showMessageDialog(this,
                    "Username dan password wajib diisi!");
            } else {
    try (Connection conn = Database.getConnection();
         PreparedStatement ps = conn.prepareStatement(
             "SELECT password, role FROM users WHERE username = ?")) {

        ps.setString(1, username);

        try (ResultSet rs = ps.executeQuery()) {
           if (rs.next()) {
    String storedHash = rs.getString("password");

    try {
        if (PasswordUtil.verifyPassword(password, storedHash)) {
            String role = rs.getString("role");

            JOptionPane.showMessageDialog(this,
                "Login berhasil! Role: " + role);
            if ("ADMIN".equals(role)) {
    new DashboardAdmin().setVisible(true);
    dispose();
}else if ("OPERATOR".equals(role)) {
    new DashboardOperator().setVisible(true);
    dispose();
}
        } else {
            JOptionPane.showMessageDialog(this,
                "Password salah!");
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this,
            "Verifikasi password gagal: " + ex.getMessage());
    }
}
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this,
            "Koneksi database gagal: " + ex.getMessage());
    }
}

            java.util.Arrays.fill(password, '\0');
        });

        panel.add(judul);
        panel.add(Box.createVerticalStrut(8));
        panel.add(subjudul);
        panel.add(Box.createVerticalStrut(35));
        panel.add(lblUsername);
        panel.add(Box.createVerticalStrut(7));
        panel.add(txtUsername);
        panel.add(Box.createVerticalStrut(18));
        panel.add(lblPassword);
        panel.add(Box.createVerticalStrut(7));
        panel.add(txtPassword);
        panel.add(Box.createVerticalStrut(25));
        panel.add(btnLogin);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginPage().setVisible(true);
        });
    }
}
