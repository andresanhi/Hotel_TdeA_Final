package src;
// @author Jhony_Angulo

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.table.DefaultTableModel;

public class ModeloTabla {

    public DefaultTableModel generarModelo(ResultSet res) {
        //Se crea variable a retornar
        DefaultTableModel DateTableModel = null;
        try {
            //Se aprovecha la clase ResultSetMetaData para convertir el resultset en una tablemodel, aquí se obtienen los metadatos
            ResultSetMetaData metaDatos = res.getMetaData();
            //Se extrae el número de columnas de la tabla
            int numCol = metaDatos.getColumnCount();
            res.last();
            int numFilas = res.getRow();
            //Se crea un array para las etiquetas
            Object[] columnas = new Object[numCol];
            //Se obtienen los nombres de cada columna
            for (int i = 0; i < numCol; i++) {
                columnas[i] = metaDatos.getColumnLabel(i + 1);
            }
            DateTableModel.setColumnIdentifiers(columnas);
            //Se llena la tabla con filas.
            while (res.next()) {
                //Se crea un Array para cada fila
                Object fila[] = new Object[numCol];
                for (int i = 0; i < numFilas; i++) {
                    fila[i] = res.getObject(i + 1);
                    DateTableModel.addRow(fila);
                }
            }
        } catch (Exception e) {
        }
        return (DateTableModel);
    }

}
