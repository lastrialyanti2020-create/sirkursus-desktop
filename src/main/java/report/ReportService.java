package report;

import config.Database;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public final class ReportService {

    private static final String JASPER_PATH = "/report/laporan_peserta.jasper";
    private static final String JRXML_PATH  = "/report/laporan_peserta.jrxml";

    private ReportService() {
    }

    public static void tampilkanLaporanPeserta() {
        try (Connection conn = Database.getConnection()) {
            JasperPrint print = isiLaporan(conn);
            // false = menutup viewer TIDAK menutup seluruh aplikasi
            JasperViewer.viewReport(print, false);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    null,
                    "Gagal membuka laporan: " + e.getMessage(),
                    "Laporan Peserta",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private static JasperPrint isiLaporan(Connection conn) throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();

        // 1) Utama: file .jasper hasil compile
        try (InputStream in = ReportService.class.getResourceAsStream(JASPER_PATH)) {
            if (in != null) {
                try {
                    return JasperFillManager.fillReport(in, params, conn);
                } catch (JRException ex) {
                    System.err.println("Gagal pakai .jasper, coba compile dari .jrxml: "
                            + ex.getMessage());
                }
            }
        }

        // 2) Cadangan: compile langsung dari .jrxml
        try (InputStream in = ReportService.class.getResourceAsStream(JRXML_PATH)) {
            if (in == null) {
                throw new IllegalStateException(
                        "laporan_peserta.jasper / .jrxml tidak ditemukan di "
                        + "src/main/resources/report/");
            }
            JasperReport report = JasperCompileManager.compileReport(in);
            return JasperFillManager.fillReport(report, params, conn);
        }
    }
}