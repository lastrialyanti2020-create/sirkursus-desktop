package app;

import javax.swing.SwingUtilities;
import view.LoginPage;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginPage().setVisible(true));
    }
}