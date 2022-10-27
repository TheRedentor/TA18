package ejercicio8;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import ejercicio1.Ejercicio1App;

public class Functions {
	// Finaliza conexión a MySQL
	public static void closeConnection(Connection conexion) {
		try {
			conexion.close();
			JOptionPane.showMessageDialog(null, "Se ha finalizado la conexión con el servidor");
		}
		catch (SQLException ex) {
			Logger.getLogger(Ejercicio1App.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	// Crea base de datos
	public static void createDB(String name, Connection conexion) {
		try {
			String Query = "CREATE DATABASE " + name;
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			JOptionPane.showMessageDialog(null, "Se ha creado la base de datos " + name + " de forma exitosa");
		}
		catch (SQLException ex) {
			Logger.getLogger(Ejercicio1App.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	// Crea tabla productos
	public static void createTableProductos(String db, String name, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "CREATE TABLE " + name + ""
			+ "(codigo INT PRIMARY KEY AUTO_INCREMENT, nombre VARCHAR(100), precio INT);";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Tabla creada con éxito!");
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla");
		}
	}
	
	// Inserta datos a productos
	public static void insertDataProductos(String db, String table_name, String nombre, int precio, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "INSERT INTO " + table_name + "(nombre, precio) VALUE("
				+ "\"" + nombre + "\", "
				+ "\"" + precio + "\");";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			
			System.out.println("Datos almacenados correctamente");
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}
	
	// Inserta datos a productos
	public static void updateDataProductos(String db, String table_name, String nombre, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "UPDATE " + table_name + " SET nombre = \"" + nombre + "\" WHERE codigo = 1;";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			
			System.out.println("Datos almacenados correctamente");
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}
	
	// Obtiene valores de productos
	public static void getValuesProductos(String db, String table_name, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "SELECT * FROM " + table_name;
			Statement st = conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);
			
			while (resultSet.next()) {
				System.out.println("Codigo: " + resultSet.getString("codigo") + " "
						+ "Nombre: " + resultSet.getString("nombre") + " "
						+ "Precio: " + resultSet.getString("precio") + " "
						);
			}
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error en la adquisición de datos");
		}
	}
	
	// Borra valores de productos, maquinas registradoras y cajeros
	public static void deleteValues(String db, String table_name, int codigo, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			String Query = "DELETE FROM " + table_name + " WHERE codigo = \"" + codigo + "\"";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");
		}
	}
	
	// Crea tabla maquinas registradoras
	public static void createTableMaquinasRegistradoras(String db, String name, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "CREATE TABLE " + name + ""
			+ "(codigo INT PRIMARY KEY AUTO_INCREMENT, piso INT);";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Tabla creada con éxito!");
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla");
		}
	}
	
	// Inserta datos a maquinas registradoras
	public static void insertDataMaquinasRegistradoras(String db, String table_name, int piso, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "INSERT INTO " + table_name + "(piso) VALUE("
				+ "\"" + piso + "\");";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			
			System.out.println("Datos almacenados correctamente");
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}
	
	// Obtiene valores de maquinas registradoras
	public static void getValuesMaquinasRegistradoras(String db, String table_name, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "SELECT * FROM " + table_name;
			Statement st = conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);
			
			while (resultSet.next()) {
				System.out.println("Codigo: " + resultSet.getString("codigo") + " "
						+ "Piso: " + resultSet.getString("piso") + " "
						);
			}
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error en la adquisición de datos");
		}
	}
	
	// Crea tabla cajeros
	public static void createTableCajeros(String db, String name, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "CREATE TABLE " + name + ""
			+ "(codigo INT PRIMARY KEY AUTO_INCREMENT, nomapels VARCHAR(255));";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Tabla creada con éxito!");
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla");
		}
	}
	
	// Inserta datos a cajeros
	public static void insertDataCajeros(String db, String table_name, String nomapels, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "INSERT INTO " + table_name + "(nomapels) VALUE("
				+ "\"" + nomapels + "\");";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			
			System.out.println("Datos almacenados correctamente");
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}
	
	// Obtiene valores de cajeros
	public static void getValuesCajeros(String db, String table_name, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "SELECT * FROM " + table_name;
			Statement st = conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);
			
			while (resultSet.next()) {
				System.out.println("Codigo: " + resultSet.getString("codigo") + " "
						+ "NomApels: " + resultSet.getString("nomapels") + " "
						);
			}
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error en la adquisición de datos");
		}
	}
	
	// Crea tabla venta
	public static void createTableVenta(String db, String name, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "CREATE TABLE " + name + ""
			+ "(cajero INT, maquina INT, producto INT, PRIMARY KEY (cajero, maquina, producto), FOREIGN KEY (cajero) REFERENCES cajeros(codigo) ON DELETE CASCADE ON UPDATE CASCADE, FOREIGN KEY (maquina) REFERENCES maquinas_registradoras(codigo) ON DELETE CASCADE ON UPDATE CASCADE, FOREIGN KEY (producto) REFERENCES productos(codigo) ON DELETE CASCADE ON UPDATE CASCADE);";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Tabla creada con éxito!");
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla");
		}
	}
	
	// Inserta datos a venta
	public static void insertDataVenta(String db, String table_name, int cajero, int maquina, int producto, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "INSERT INTO " + table_name + "(cajero, maquina, producto) VALUE("
				+ "\"" + cajero + "\", "
				+ "\"" + maquina + "\", "
				+ "\"" + producto + "\");";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			
			System.out.println("Datos almacenados correctamente");
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}
	
	// Obtiene valores de venta
	public static void getValuesVenta(String db, String table_name, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "SELECT * FROM " + table_name;
			Statement st = conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);
			
			while (resultSet.next()) {
				System.out.println("Cajero: " + resultSet.getString("cajero") + " "
						+ "Maquina: " + resultSet.getString("maquina") + " "
						+ "Producto: " + resultSet.getString("producto") + " "
						);
			}
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error en la adquisición de datos");
		}
	}
	
	// Borra valores de venta
	public static void deleteValuesVenta(String db, String table_name, int cajero, int maquina, int producto, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			String Query = "DELETE FROM " + table_name + " WHERE cajero = \"" + cajero + "\" AND maquina = \"" + maquina + "\" AND producto = \"" + producto +"\"";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");
		}
	}
}
