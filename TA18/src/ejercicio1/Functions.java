package ejercicio1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

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
	
	// Crea tabla fabricantes
	public static void createTableFabricantes(String db, String name, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "CREATE TABLE " + name + ""
			+ "(codigo INT PRIMARY KEY AUTO_INCREMENT, nombre VARCHAR(100));";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Tabla creada con éxito!");
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla");
		}
	}
	
	// Inserta datos a fabricantes
	public static void insertDataFabricantes(String db, String table_name, String nombre, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "INSERT INTO " + table_name + "(nombre) VALUE("
				+ "\"" + nombre + "\");";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			
			System.out.println("Datos almacenados correctamente");
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}
	
	// Cambiar datos a fabricantes
	public static void updateDataFabricantes(String db, String table_name, String nombre, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "UPDATE " + table_name + " SET nombre = \"" + nombre + "\" WHERE codigo = 1;";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			
			System.out.println("Datos actualizados correctamente");
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error al actualizar");
		}
	}
	
	// Obtiene valores de fabricantes
	public static void getValuesFabricantes(String db, String table_name, Connection conexion) {
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
						);
			}
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error en la adquisición de datos");
		}
	}
	
	// Borra valores de fabricantes y articulos
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
	
	// Crea tabla articulos
	public static void createTableArticulos(String db, String name, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "CREATE TABLE " + name + ""
			+ "(codigo INT PRIMARY KEY AUTO_INCREMENT, nombre VARCHAR(100), precio INT, fabricante INT, FOREIGN KEY (fabricante) REFERENCES fabricantes(codigo) ON DELETE SET NULL ON UPDATE CASCADE);";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Tabla creada con éxito!");
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla");
		}
	}
	
	// Inserta datos a articulos
	public static void insertDataArticulos(String db, String table_name, String nombre, int precio, int fabricante, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "INSERT INTO " + table_name + "(nombre, precio, fabricante) VALUE("
				+ "\"" + nombre + "\", "
				+ "\"" + precio + "\", "
				+ "\"" + fabricante + "\");";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			
			System.out.println("Datos almacenados correctamente");
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}
	
	// Obtiene valores de articulos
	public static void getValuesArticulos(String db, String table_name, Connection conexion) {
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
						+ "Fabricante: " + resultSet.getString("fabricante") + " "
						);
			}
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error en la adquisición de datos");
		}
	}
}
