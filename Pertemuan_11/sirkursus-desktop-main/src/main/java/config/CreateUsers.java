package config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Scanner;

public class CreateUsers {

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in);
             Connection conn = Database.getConnection()) {

            buatAkun(conn, input, "admin", "ADMIN");
            buatAkun(conn, input, "operator", "OPERATOR");

            System.out.println("Proses pembuatan akun selesai.");

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private static void buatAkun(
            Connection conn, Scanner input,
            String username, String role) throws Exception {

        String cekSql =
                "SELECT id FROM users WHERE username = ?";

        try (PreparedStatement cek =
                conn.prepareStatement(cekSql)) {

            cek.setString(1, username);

            try (ResultSet rs = cek.executeQuery()) {
                if (rs.next()) {
                    System.out.println(
                        "Akun " + username + " sudah ada.");
                    return;
                }
            }
        }

        System.out.print(
            "Masukkan password untuk " + username + ": ");

        char[] password = input.nextLine().toCharArray();

        try {
            if (password.length < 8) {
                System.out.println(
                    "Password minimal 8 karakter. Akun tidak dibuat.");
                return;
            }

            String hash = PasswordUtil.hashPassword(password);

            String sql = "INSERT INTO users "
                    + "(username, password, role) VALUES (?, ?, ?)";

            try (PreparedStatement ps =
                    conn.prepareStatement(sql)) {

                ps.setString(1, username);
                ps.setString(2, hash);
                ps.setString(3, role);

                ps.executeUpdate();

                System.out.println(
                    "Akun " + username + " berhasil dibuat!");
            }

        } finally {
            Arrays.fill(password, '\0');
        }
    }
}