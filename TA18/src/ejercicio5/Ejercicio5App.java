package ejercicio5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import ejercicio1.Ejercicio1App;

public class Ejercicio5App {
	
	// Conecta a MySQL
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection("jdbc:mysql://192.168.0.118:3306?useTimezone=true&serverTimezone=UTC","remote","i6eLeQ<L(X3E");
			System.out.println("Server Connected");
			Functions.createDB("ejercicio5_T18", conexion);
			
			Functions.createTableDespachos("ejercicio5_T18", "despachos", conexion);
			Functions.insertDataDespachos("ejercicio5_T18", "despachos", 5, conexion);
			Functions.insertDataDespachos("ejercicio5_T18", "despachos", 10, conexion);
			Functions.insertDataDespachos("ejercicio5_T18", "despachos", 15, conexion);
			Functions.updateDataDespachos("ejercicio5_T18", "despachos", 30, conexion);
			Functions.getValuesDespachos("ejercicio5_T18", "despachos", conexion);
			
			Functions.createTableDirectores("ejercicio5_T18", "directores", conexion);
			Functions.insertDataDirectoresJefes("ejercicio5_T18", "directores", "36719983", "Pepe Viyuela", 1, conexion);
			Functions.insertDataDirectoresNoJefes("ejercicio5_T18", "directores", "37589334", "Oscar Pérez", "36719983", 2, conexion);
			Functions.insertDataDirectoresNoJefes("ejercicio5_T18", "directores", "34451652", "Aitor Montero", "36719983", 3, conexion);
			Functions.getValuesDirectores("ejercicio5_T18", "directores", conexion);
			
			Functions.deleteValuesDespachos("ejercicio5_T18", "despachos", 3, conexion);
			Functions.deleteValuesDirectores("ejercicio5_T18", "directores", "34451652", conexion);
			
			Functions.closeConnection(conexion);
		}
		catch (SQLException | ClassNotFoundException ex) {
			System.out.print("No se ha podido conectar con mi base de datos");
			System.out.print(ex);
		}
	}
}
