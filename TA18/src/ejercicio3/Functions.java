package ejercicio3;

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
	
	// Crea tabla almacenes
	public static void createTableAlmacenes(String db, String name, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "CREATE TABLE " + name + ""
			+ "(codigo INT PRIMARY KEY AUTO_INCREMENT, lugar VARCHAR(100), capacidad INT);";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Tabla creada con éxito!");
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla");
		}
	}
	
	// Inserta datos a almacenes
	public static void insertDataAlmacenes(String db, String table_name, String lugar, int capacidad, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "INSERT INTO " + table_name + "(lugar, capacidad) VALUE("
				+ "\"" + lugar + "\", "
				+ "\"" + capacidad + "\");";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			
			System.out.println("Datos almacenados correctamente");
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}
	
	// Cambiar datos a almacenes
	public static void updateDataAlmacenes(String db, String table_name, String lugar, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "UPDATE " + table_name + " SET lugar = \"" + lugar + "\" WHERE codigo = 1;";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			
			System.out.println("Datos actulizados correctamente");
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error al actualizar");
		}
	}
	
	// Obtiene valores de almacenes
	public static void getValuesAlmacenes(String db, String table_name, Connection conexion) {
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
						+ "Lugar: " + resultSet.getString("lugar") + " "
						+ "Capacidad: " + resultSet.getString("capacidad") + " "
						);
			}
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error en la adquisición de datos");
		}
	}
	
	// Borra valores de almacenes
	public static void deleteValuesAlmacenes(String db, String table_name, int codigo, Connection conexion) {
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
	
	// Crea tabla cajas
	public static void createTableCajas(String db, String name, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "CREATE TABLE " + name + ""
			+ "(numreferencia VARCHAR(5) PRIMARY KEY, contenido VARCHAR(100), valor INT, almacen INT, FOREIGN KEY (almacen) REFERENCES almacenes(codigo) ON DELETE SET NULL ON UPDATE CASCADE);";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Tabla creada con éxito!");
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla");
		}
	}
	
	// Inserta datos a cajas
	public static void insertDataCajas(String db, String table_name, String numreferencia, String contenido, int valor, int almacen, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "INSERT INTO " + table_name + "(numreferencia, contenido, valor, almacen) VALUE("
				+ "\"" + numreferencia + "\", "
				+ "\"" + contenido + "\", "
				+ "\"" + valor + "\", "
				+ "\"" + almacen + "\");";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			
			System.out.println("Datos almacenados correctamente");
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}
	
	// Obtiene valores de cajas
	public static void getValuesCajas(String db, String table_name, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "SELECT * FROM " + table_name;
			Statement st = conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);
			
			while (resultSet.next()) {
				System.out.println("NumReferencia: " + resultSet.getString("numreferencia") + " "
						+ "Contenido: " + resultSet.getString("contenido") + " "
						+ "Valor: " + resultSet.getString("valor") + " "
						+ "Almacen: " + resultSet.getString("almacen") + " "
						);
			}
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error en la adquisición de datos");
		}
	}
	
	// Borra valores de cajas
	public static void deleteValuesCajas(String db, String table_name, String numreferencia, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			String Query = "DELETE FROM " + table_name + " WHERE numreferencia = \"" + numreferencia + "\"";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");
		}
	}
}
