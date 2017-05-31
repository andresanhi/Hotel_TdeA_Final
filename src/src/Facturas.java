package src;

// @author Jhony_Angulo
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Facturas {

    public void generarFactura(String cliente, String doc, int numHab, int noches, int canAcom, String tipoHab, int precio, int total) {
        int ultFV = 0;
        try {
            Conexion con = new Conexion();
            Connection link = con.conectar();
            String SQL = "SELECT MAX(idfacturas) as IdFactura FROM tblfacturas";
            PreparedStatement pSQL = link.prepareStatement(SQL);
            ResultSet rs = pSQL.executeQuery();
            ultFV = rs.getInt("Idfactura");

            try {
                String SQL2 = "INSERT INTO tblfacturas(idfacturas, Numero_factura, Cliente, Documento, Numero_Habitaciones, Cantidad_noches, Cantidad_personas, Tipo_habitacion, PrecioXnoche, Totalfactura)"
                        + "VALUES (DEFAULT)";
                PreparedStatement pSQL2 = link.prepareStatement(SQL2);
                
                pSQL2.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error guardando la factura" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
            }

            link.close();
            rs.close();
            pSQL.close();
        } catch (Exception e) {
        }

    }

}
