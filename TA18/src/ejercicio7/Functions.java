package ejercicio7;

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
	
	// Crea tabla cientificos
	public static void createTableCientificos(String db, String name, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "CREATE TABLE " + name + ""
			+ "(dni VARCHAR(8) PRIMARY KEY, nomapels VARCHAR(255));";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Tabla creada con éxito!");
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla");
		}
	}
	
	// Inserta datos a cientificos
	public static void insertDataCientificos(String db, String table_name, String dni, String nomapels, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "INSERT INTO " + table_name + "(dni, nomapels) VALUE("
				+ "\"" + dni + "\", "
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
	
	// Cambia datos a cientificos
	public static void updateDataCientificos(String db, String table_name, String nomapels, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "UPDATE " + table_name + " SET nomapels = \"" + nomapels + "\" WHERE dni = '34526174';";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			
			System.out.println("Datos actulizados correctamente");
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error al actualizar");
		}
	}
	
	// Obtiene valores de cientificos
	public static void getValuesCientificos(String db, String table_name, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "SELECT * FROM " + table_name;
			Statement st = conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);
			
			while (resultSet.next()) {
				System.out.println("DNI: " + resultSet.getString("dni") + " "
						+ "NomApels: " + resultSet.getString("nomapels") + " "
						);
			}
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error en la adquisición de datos");
		}
	}
	
	// Borra valores de cientificos
	public static void deleteValuesCientificos(String db, String table_name, String dni, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			String Query = "DELETE FROM " + table_name + " WHERE dni = \"" + dni + "\"";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");
		}
	}
	
	// Crea tabla proyecto
	public static void createTableProyecto(String db, String name, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "CREATE TABLE " + name + ""
			+ "(id VARCHAR(4) PRIMARY KEY, nombre VARCHAR(255), horas INT);";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Tabla creada con éxito!");
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla");
		}
	}
	
	// Inserta datos a proyecto
	public static void insertDataProyecto(String db, String table_name, String id, String nombre, int horas, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "INSERT INTO " + table_name + "(id, nombre, horas) VALUE("
				+ "\"" + id + "\", "
				+ "\"" + nombre + "\", "
				+ "\"" + horas + "\");";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			
			System.out.println("Datos almacenados correctamente");
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}
	
	// Obtiene valores de proyecto
	public static void getValuesProyecto(String db, String table_name, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "SELECT * FROM " + table_name;
			Statement st = conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);
			
			while (resultSet.next()) {
				System.out.println("ID: " + resultSet.getString("id") + " "
						+ "Nombre: " + resultSet.getString("nombre") + " "
						+ "Horas: " + resultSet.getString("horas") + " "
						);
			}
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error en la adquisición de datos");
		}
	}
	
	// Borra valores de proyecto
	public static void deleteValuesProyecto(String db, String table_name, String id, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			String Query = "DELETE FROM " + table_name + " WHERE id = \"" + id + "\"";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");
		}
	}
	
	// Crea tabla asignado_a
	public static void createTableAsignadoA(String db, String name, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "CREATE TABLE " + name + ""
			+ "(cientifico VARCHAR(8), proyecto VARCHAR(4), PRIMARY KEY (cientifico, proyecto), FOREIGN KEY (cientifico) REFERENCES cientificos(dni) ON DELETE CASCADE ON UPDATE CASCADE, FOREIGN KEY (proyecto) REFERENCES proyecto(id) ON DELETE CASCADE ON UPDATE CASCADE);";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Tabla creada con éxito!");
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla");
		}
	}
	
	// Inserta datos a asignado_a
	public static void insertDataAsignadoA(String db, String table_name, String cientifico, String proyecto, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "INSERT INTO " + table_name + "(cientifico, proyecto) VALUE("
				+ "\"" + cientifico + "\", "
				+ "\"" + proyecto + "\");";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			
			System.out.println("Datos almacenados correctamente");
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}
	
	// Obtiene valores de asignado_a
	public static void getValuesAsignadoA(String db, String table_name, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "SELECT * FROM " + table_name;
			Statement st = conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);
			
			while (resultSet.next()) {
				System.out.println("Cientifico: " + resultSet.getString("cientifico") + " "
						+ "Proyecto: " + resultSet.getString("proyecto") + " "
						);
			}
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error en la adquisición de datos");
		}
	}
	
	// Borra valores de asignado_a
	public static void deleteValuesAsignadoA(String db, String table_name, String cientifico, String proyecto, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			String Query = "DELETE FROM " + table_name + " WHERE cientifico = \"" + cientifico + "\" AND proyecto = \"" + proyecto + "\"";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");
		}
	}
}
