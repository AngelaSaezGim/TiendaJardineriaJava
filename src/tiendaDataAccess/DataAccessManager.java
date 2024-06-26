/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiendaDataAccess;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.List;
import java.util.Properties;
import java.util.ArrayList;

import static tiendaDataAccess.Constants.*;
import tiendaObjetos.Empleado;
import tiendaObjetos.Producto;
import tiendaObjetos.Cliente;

/**
 *
 * @author angsaegim
 */
public class DataAccessManager implements AutoCloseable {

    /**
     * ************************ PARTE ESTÁTICA ****************************
     */
    private static String dataBaseUser = DEFAULT_DATA_BASE__USER;
    private static String dataBasePwd = DEFAULT_DATA_BASE__PWD;
    private static String dataBaseURL = DEFAULT_DATA_BASE__URL;

    private static DataAccessManager singleton;

    // Instanciamos un único objeto DataAccessManager - SINGLETON
    private DataAccessManager() {

    }

    /**
     * Los métodos de acceso a datos se pueden ejecutar con el objeto devuelto
     * por esta función
     *
     * @return el mánager de acceso a datos con todas las sentencias embebidas
     */
    public static DataAccessManager getInstance() {
        if (singleton == null) {
            loadDataBaseParams();
            singleton = new DataAccessManager();
            try {
                singleton.cnx = createConnection();
                singleton.clientesDAO = new ClienteDAO(singleton.cnx);
                singleton.empleadosDAO = new EmpleadoDAO(singleton.cnx);
                singleton.productosDAO = new ProductoDAO(singleton.cnx);
            } catch (Exception e) {
                singleton = null;
                throw new RuntimeException(e);
            }

        }
        return singleton;
    }

    /**
     * Para saber si la inicialización del objeto singleton ha funcionado con
     * éxito
     *
     * @return
     */
    public static boolean connectionEnabled() {
        return singleton != null;
    }

    /**
     * Carga las credenciales y URL de acceso a datos de un fichero de
     * configuración situado en {@link Constants#DB_CONFIG__FILE_NAME} . En caso
     * de IOException, se usan las credenciales por defecto
     */
    private static void loadDataBaseParams() {

        Properties pDataBaseConfiguration = null;
        FileReader dbReaderStream = null;
        try {
            dbReaderStream = new FileReader(DB_CONFIG__FILE_NAME);
            pDataBaseConfiguration = new Properties();
            pDataBaseConfiguration.load(dbReaderStream);
        } catch (IOException e) {
            System.out.println("Error en la carga de la configuración de la base de datos. Se sigue adelante con la ejecución por defecto. " + e.getMessage());

        } finally {
            try {
                if (dbReaderStream != null) {
                    dbReaderStream.close();
                }
            } catch (IOException ioe) {
                System.out.println("Error al cerrar el flujo de lectura del fichero de configuración. Se ignora el error. " + ioe.getMessage());
            }
        }
        //si se han cargado las properties, se asignan a las propiedades estáticas de los parámetros configurados
        if (pDataBaseConfiguration != null) {
            if (pDataBaseConfiguration.getProperty(DB_CONFIG__USER_PROPERTY) != null) {
                dataBaseUser = pDataBaseConfiguration.getProperty(DB_CONFIG__USER_PROPERTY);
            }
            if (pDataBaseConfiguration.getProperty(DB_CONFIG__PWD_PROPERTY) != null) {
                dataBasePwd = pDataBaseConfiguration.getProperty(DB_CONFIG__PWD_PROPERTY);
            }
            if (pDataBaseConfiguration.getProperty(DB_CONFIG__URL_PROPERTY) != null) {
                dataBaseURL = pDataBaseConfiguration.getProperty(DB_CONFIG__URL_PROPERTY);
            }
        }
    }

    /**
     * ************************ PARTE DINÁMICA ****************************
     */
    //para conectar y ejecutar las SQL en la bbdd
    private Connection cnx;

    private EmpleadoDAO empleadosDAO;
    private ClienteDAO clientesDAO;
    private ProductoDAO productosDAO;

    private static Connection createConnection() {

        try {
            Class.forName(MYSQL_DB_DRIVER__CLASS_NAME);
            Connection cnt = DriverManager.getConnection(dataBaseURL, dataBaseUser, dataBasePwd);
            cnt.setAutoCommit(true);
            return cnt;
        } catch (ClassNotFoundException cnfe) {
            System.out.println("No se ha encontrado el driver. Revise la carpeta lib en busca del driver jdbc de MySQL. " + cnfe.getMessage());
            return null;
        } catch (SQLException sqle) {
            StringBuilder sb = new StringBuilder()
                    .append("Existe un problema de conexión a la base de datos. ")
                    .append("Revise: \n")
                    .append("\t- Que tiene levantado el servidor de MySQL.\n")
                    .append("\t- Que la base de datos Jardineri está instalada.\n")
                    .append("\t- Que la configuración del fichero resources/db.properties es corecta.\n")
                    .append("Error: ")
                    .append(sqle.getMessage());
            System.out.println(sb.toString());
            return null;
        }

    }

    @Override
    public void close() {
        try {
            if (cnx != null && !cnx.isClosed()) {
                cnx.close();
                cnx = null;
                empleadosDAO = null;
                clientesDAO = null;
                productosDAO = null;
            }
        } catch (SQLException sqe) {
            System.out.println("Error al cerrar la conexión a datos. " + sqe.getMessage());
        } finally {
            singleton = null;
        }
    }

    /* FUNCIONES CON DATOS */
 /*VER TODOS LOS..*/
    // AREGLAR LO DE CONTENT - VARIABLES MAS DESCRIPTIVAS 
    public List<Cliente> loadAllClientes() throws SQLException {

        return this.clientesDAO.loadAllClientes();
    }

    public List<Empleado> loadAllEmpleados() throws SQLException {
        return this.empleadosDAO.loadAllEmpleados();

    }

    public List<Producto> loadAllProductos() throws SQLException {
        return this.productosDAO.loadAllProductos();

    }

    public Cliente loadClientesByCode(String content) throws SQLException {
        if (content == null || content.length() == 0) {
            throw new IllegalArgumentException("Debe indicar el filtro de búsqueda");
        }

        return this.clientesDAO.loadClientesByCode(content);
    }

    public List<Empleado> loadEmpleadosContaining(String content) throws SQLException {
        if (content == null || content.length() == 0) {
            throw new IllegalArgumentException("Debe indicar el filtro de búsqueda");
        }

        return this.empleadosDAO.loadEmpleadosContaining(content);
    }

    public List<Producto> loadProductosContaining(String content) throws SQLException {
        if (content == null || content.length() == 0) {
            throw new IllegalArgumentException("Debe indicar el filtro de búsqueda");
        }

        return this.productosDAO.loadProductosContaining(content);
    }

    public int deleteClient(String content) throws SQLException {
        if (content == null || content.length() == 0) {
            throw new IllegalArgumentException("Debe indicar el filtro de búsqueda");
        }

        return this.clientesDAO.deleteClient(content);
    }

    public int insertarCliente(Cliente cliente) throws SQLException {
        return this.clientesDAO.insertClient(cliente);
    }

    public int updateClient(String codigoCliente, Cliente clienteActualizar) throws SQLException {
        if (codigoCliente == null || clienteActualizar == null) {
            throw new IllegalArgumentException("El código del cliente y el cliente a actualizar no deben ser nulos.");
        }
        return this.clientesDAO.updateClient(codigoCliente, clienteActualizar);
    }
    
    // Lista con los codigos de clientes
    public List<String> obtenerCodigosClientes() throws SQLException {
    List<Cliente> clientes = loadAllClientes();
    List<String> codigosClientes = new ArrayList<>();
    for (Cliente cliente : clientes) {
        codigosClientes.add(Integer.toString(cliente.getCodigoCliente()));
    }
    return codigosClientes;
}

}
