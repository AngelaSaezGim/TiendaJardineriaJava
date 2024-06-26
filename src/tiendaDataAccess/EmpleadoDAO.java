/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiendaDataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tiendaObjetos.Cliente;
import tiendaObjetos.Empleado;

/**
 *
 * @author angsaegim
 */
public class EmpleadoDAO extends DataAccessObject {

    EmpleadoDAO(Connection cnt) {
        super(cnt);
    }

    protected List<Empleado> loadAllEmpleados() throws SQLException {

        List<Empleado> empleados = new ArrayList<>();
        try ( PreparedStatement stmt = cnt.prepareStatement("SELECT * FROM Empleados");  ResultSet result = stmt.executeQuery()) {

            while (result.next()) {
                Empleado empleado = readEmpleadosFromResultSet(result);
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            throw new SQLException("Error al cargar empleados: " + e.getMessage());
        }
        return empleados;
    }

    private static Empleado readEmpleadosFromResultSet(ResultSet rs) throws SQLException {
        Short codigoEmpleado = rs.getShort(EmpleadosTableColumns.COLUMN_EMPLEADO_CODIGO);
        String nombreEmpleado = rs.getString(EmpleadosTableColumns.COLUMN_EMPLEADO_NOMBRE);
        String puestoEmpleado = rs.getString(EmpleadosTableColumns.COLUMN_EMPLEADO_PUESTO);
        String apellido1 = rs.getString(EmpleadosTableColumns.COLUMN_EMPLEADO_APELLIDO1);
        String apellido2 = rs.getString(EmpleadosTableColumns.COLUMN_EMPLEADO_APELLIDO2);
        String email = rs.getString(EmpleadosTableColumns.COLUMN_EMPLEADO_EMAIL);
        String codigoOficina = rs.getString(EmpleadosTableColumns.COLUMN_EMPLEADO_CODIGO_OFICINA);
        Empleado empleado = new Empleado(codigoEmpleado, nombreEmpleado, puestoEmpleado, apellido1,apellido2,
        email,codigoOficina);
        return empleado;
    }
    
    protected List<Empleado> loadEmpleadosContaining(String content) throws SQLException {
        List<Empleado> empleados = new ArrayList<>();

        PreparedStatement stmt = cnt.prepareStatement("SELECT * FROM empleados WHERE CodigoEmpleado LIKE ?");
        stmt.setString(1, content);
        ResultSet result = stmt.executeQuery();

        while (result.next()) {
            empleados.add(readEmpleadosFromResultSet(result));
        }
        return empleados;
    }

    private class EmpleadosTableColumns {

        private final static String COLUMN_EMPLEADO_CODIGO = "CodigoEmpleado";
        private final static String COLUMN_EMPLEADO_NOMBRE = "Nombre";
        private final static String COLUMN_EMPLEADO_PUESTO = "Puesto";
        private final static String COLUMN_EMPLEADO_APELLIDO1 = "Apellido1";
        private final static String COLUMN_EMPLEADO_APELLIDO2 = "Apellido2";
        private final static String COLUMN_EMPLEADO_EMAIL = "Email";
        private final static String COLUMN_EMPLEADO_CODIGO_OFICINA = "CodigoOficina";

    }
}
