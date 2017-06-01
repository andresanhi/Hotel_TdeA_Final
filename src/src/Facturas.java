package src;

// @author Jhony_Angulo
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Facturas {

    public void generarFactura(String cliente, String doc, int cantHab, int descuento, int total, Integer[] reservas) {
        int ultFV = 0;
        try {
            Conexion con = new Conexion();
            Connection link = con.conectar();
            String SQL = "SELECT MAX(Numero_factura) as Numero_factura FROM tblfacturas";
            PreparedStatement pSQL = link.prepareStatement(SQL);
            ResultSet rs = pSQL.executeQuery();
            if (!rs.next()) {
                ultFV = Integer.parseInt(rs.getString("Numero_factura"));
            } else {
                ultFV = 1001;
            }
            try {
                String SQL2 = "INSERT INTO tblfacturas(idfacturas, Numero_factura, Cliente, Documento, Cantidad_habitaciones, Descuento, Totalfactura)"
                        + "VALUES (DEFAULT, ?,?,?,?,?,?)";
                PreparedStatement pSQL2 = link.prepareStatement(SQL2);
                pSQL2.setInt(1, ultFV);
                pSQL2.setString(2, cliente);
                pSQL2.setString(3, doc);
                pSQL2.setInt(4, cantHab);
                pSQL2.setInt(5, descuento);
                pSQL2.setInt(6, total);

                pSQL2.executeUpdate();
                pSQL2.close();
                JOptionPane.showMessageDialog(null, "Factura generada correctamente");
                try {
                    for (int i = 0; i < reservas.length; i++) {
                        String SQL3 = "UPDATE tblreservas SET numFactura = ? WHERE idreservas = ?";
                        PreparedStatement pSQL3 = link.prepareStatement(SQL3);
                        pSQL3.setInt(1, ultFV);
                        pSQL3.setInt(2, reservas[i]);

                        pSQL3.executeUpdate();
                        pSQL3.close();
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error actualizando reservas con la factura" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error guardando la factura" + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            link.close();
            pSQL.close();
            rs.close();
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(null, "Error consultando máximo Id de factura" + exc, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
