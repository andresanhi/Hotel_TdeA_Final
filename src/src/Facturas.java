package src;

// @author Jhony_Angulo
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Facturas {

    public void generarFactura(String cliente, String doc, int cantHab, int descuento, int total, Integer[] reservas) {
        int ultFV = 0;
        try {
            //Se crea cadena de conexión y sentencia SQL para consulta el máximo numero de factura almacenado en bdd, el autoincrement inica en 1000
            Conexion con = new Conexion();
            Connection link = con.conectar();
            String SQL = "SELECT MAX(Numero_factura) as Numero_factura FROM tblfacturas";
            PreparedStatement pSQL = link.prepareStatement(SQL);
            ResultSet rs = pSQL.executeQuery();
            ModeloTabla mt = new ModeloTabla();
            DefaultTableModel m = mt.generarModelo(rs);
            int can = m.getRowCount();
            if (can != 0) {
                //Si tiene máximo numero de reserva (la tabla tblreservas tiene datos) asigna éste a la variable ultFV
                ultFV = Integer.parseInt((String) m.getValueAt(0, 0)) + 1;

            } else {
                //Si no hay datos en la tabla será por defecto 1000
                ultFV = 1000;
            }
            try {
                //Se crea sentencia SQL para insertar en tblfacturas
                String SQL2 = "INSERT INTO tblfacturas(idfacturas, Numero_factura, Cliente, Documento, Cantidad_habitaciones, Descuento, Totalfactura)"
                        + "VALUES (DEFAULT, ?,?,?,?,?,?)";
                //Se compila sentencia y se setean variables.
                PreparedStatement pSQL2 = link.prepareStatement(SQL2);
                pSQL2.setInt(1, ultFV);
                pSQL2.setString(2, cliente);
                pSQL2.setString(3, doc);
                pSQL2.setInt(4, cantHab);
                pSQL2.setInt(5, descuento);
                pSQL2.setInt(6, total);

                //Se ejecuta sentencia
                pSQL2.executeUpdate();
                pSQL2.close();
                JOptionPane.showMessageDialog(null, "Factura generada correctamente"); for (int i = 0; i < reservas.length; i++) {
                        String SQL3 = "UPDATE tblreservas SET numFactura = ? WHERE idreservas = ?";
                        PreparedStatement pSQL3 = link.prepareStatement(SQL3);
                        pSQL3.setInt(1, ultFV);
                        pSQL3.setInt(2, reservas[i]);

                        //Se ejecuta sentencia SQL
                        pSQL3.executeUpdate();
                        pSQL3.close();
                    }

                try {
                    //Se crea sentencia SQL para actualizar el número de factura en la tabla de reservas.
                    for (int i = 0; i < reservas.length; i++) {
                        String SQL3 = "UPDATE tblreservas SET numFactura = ? WHERE idreservas = ?";
                        PreparedStatement pSQL3 = link.prepareStatement(SQL3);
                        pSQL3.setInt(1, ultFV);
                        pSQL3.setInt(2, reservas[i]);

                        //Se ejecuta sentencia SQL
                        pSQL3.executeUpdate();
                        pSQL3.close();
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error actualizando reservas con la factura" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
                }

                try {
                    //Se crea sentencia SQL para actualizar la cantidad de veces que el usuario ha estado en el hotel.
                    String SQL4 = "UPDATE tblclientes SET hospedaje = hospedaje+1 WHERE documento = ?";
                    //Se compila la sentencia SQL
                    PreparedStatement pSQL4 = link.prepareStatement(SQL4);
                    //Se setean las variables
                    pSQL4.setString(1, doc);
                    //Se ejecuta actualización
                    pSQL4.executeUpdate();

                    pSQL4.close();
                } catch (Exception exp) {
                    JOptionPane.showMessageDialog(null, "Error actualizando la cantidad de hospedajes " + exp, "ERROR", JOptionPane.ERROR_MESSAGE);
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
