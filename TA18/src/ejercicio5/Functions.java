package ejercicio5;

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
	
	// Crea tabla despachos
	public static void createTableDespachos(String db, String name, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "CREATE TABLE " + name + ""
			+ "(numero INT PRIMARY KEY AUTO_INCREMENT, capacidad INT);";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Tabla creada con éxito!");
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla");
		}
	}
	
	// Inserta datos a despachos
	public static void insertDataDespachos(String db, String table_name, int capacidad, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "INSERT INTO " + table_name + "(capacidad) VALUE("
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
	
	// Cambia datos a despachos
	public static void updateDataDespachos(String db, String table_name, int capacidad, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "UPDATE " + table_name + " SET capacidad = \"" + capacidad + "\" WHERE numero = 1;";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			
			System.out.println("Datos actualizados correctamente");
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error al actualizar");
		}
	}
	
	// Obtiene valores de despachos
	public static void getValuesDespachos(String db, String table_name, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "SELECT * FROM " + table_name;
			Statement st = conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);
			
			while (resultSet.next()) {
				System.out.println("Numero: " + resultSet.getString("numero") + " "
						+ "Capacidad: " + resultSet.getString("capacidad") + " "
						);
			}
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error en la adquisición de datos");
		}
	}
	
	// Borra valores de despachos
	public static void deleteValuesDespachos(String db, String table_name, int numero, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			String Query = "DELETE FROM " + table_name + " WHERE numero = \"" + numero + "\"";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");
		}
	}
	
	// Crea tabla directores
	public static void createTableDirectores(String db, String name, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "CREATE TABLE " + name + ""
			+ "(dni VARCHAR(8) PRIMARY KEY, nomapels VARCHAR(255), dnijefe VARCHAR(8), despacho INT, FOREIGN KEY (dnijefe) REFERENCES directores(dni) ON DELETE SET NULL ON UPDATE CASCADE, FOREIGN KEY (despacho) REFERENCES despachos(numero) ON DELETE SET NULL ON UPDATE CASCADE);";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Tabla creada con éxito!");
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla");
		}
	}
	
	// Inserta datos a directores no jefes
	public static void insertDataDirectoresNoJefes(String db, String table_name, String dni, String nomapels, String dnijefe, int despacho, Connection conexion) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "INSERT INTO " + table_name + "(dni, nomapels, dnijefe, despacho) VALUE("
				+ "\"" + dni + "\", "
				+ "\"" + nomapels + "\", "
				+ "\"" + dnijefe + "\", "
				+ "\"" + despacho + "\");";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			
			System.out.println("Datos almacenados correctamente");
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}
	
	// Inserta datos a directores no jefes
		public static void insertDataDirectoresJefes(String db, String table_name, String dni, String nomapels, int despacho, Connection conexion) {
			try {
				String Querydb = "USE " + db + ";";
				Statement stdb = conexion.createStatement();
				stdb.executeUpdate(Querydb);
				
				String Query = "INSERT INTO " + table_name + "(dni, nomapels, despacho) VALUE("
					+ "\"" + dni + "\", "
					+ "\"" + nomapels + "\", "
					+ "\"" + despacho + "\");";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Datos almacenados correctamente");
			}
			catch (SQLException ex) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}
		}
	
	// Obtiene valores de directores
	public static void getValuesDirectores(String db, String table_name, Connection conexion) {
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
						+ "DNIJefe: " + resultSet.getString("dnijefe") + " "
						+ "DNIJefe: " + resultSet.getString("despacho") + " "
						);
			}
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error en la adquisición de datos");
		}
	}
	
	// Borra valores de directores
	public static void deleteValuesDirectores(String db, String table_name, String dni, Connection conexion) {
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
}
