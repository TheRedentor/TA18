package ejercicio4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import ejercicio1.Ejercicio1App;

public class Ejercicio4App {
	
	// Conecta a MySQL
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection("jdbc:mysql://192.168.0.118:3306?useTimezone=true&serverTimezone=UTC","remote","i6eLeQ<L(X3E");
			System.out.println("Server Connected");
			//Functions.createDB("ejercicio4_T18", conexion);
			
			//Functions.createTablePeliculas("ejercicio4_T18", "peliculas", conexion);
			//Functions.insertDataPeliculas("ejercicio4_T18", "peliculas", "Pelicula 1", 13, conexion);
			//Functions.insertDataPeliculas("ejercicio4_T18", "peliculas", "Pelicula 2", 16, conexion);
			//Functions.insertDataPeliculas("ejercicio4_T18", "peliculas", "Pelicula 3", 13, conexion);
			Functions.updateDataPeliculas("ejercicio4_T18", "peliculas", "Pelicula diferente", conexion);
			Functions.getValuesPeliculas("ejercicio4_T18", "peliculas", conexion);
			
			//Functions.createTableSalas("ejercicio4_T18", "salas", conexion);
			//Functions.insertDataSalas("ejercicio4_T18", "salas", "Sala 1", 1, conexion);
			//Functions.insertDataSalas("ejercicio4_T18", "salas", "Sala 2", 2, conexion);
			//Functions.insertDataSalas("ejercicio4_T18", "salas", "Sala 3", 3, conexion);
			//Functions.getValuesSalas("ejercicio4_T18", "salas", conexion);
			
			//Functions.deleteValues("ejercicio4_T18", "peliculas", 3, conexion);
			//Functions.deleteValues("ejercicio4_T18", "salas", 3, conexion);
			
			Functions.closeConnection(conexion);
		}
		catch (SQLException | ClassNotFoundException ex) {
			System.out.print("No se ha podido conectar con mi base de datos");
			System.out.print(ex);
		}
	}
}
