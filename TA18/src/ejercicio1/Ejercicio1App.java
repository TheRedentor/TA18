package ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class Ejercicio1App {
	
	// Conecta a MySQL
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection("jdbc:mysql://192.168.0.118:3306?useTimezone=true&serverTimezone=UTC","remote","i6eLeQ<L(X3E");
			System.out.println("Server Connected");
			Functions.createDB("ejercicio1_T18", conexion);
			
			Functions.createTableFabricantes("ejercicio1_T18", "fabricantes", conexion);
			Functions.insertDataFabricantes("ejercicio1_T18", "fabricantes", "Sony", conexion);
			Functions.insertDataFabricantes("ejercicio1_T18", "fabricantes", "Creative Labs", conexion);
			Functions.insertDataFabricantes("ejercicio1_T18", "fabricantes", "Hewlett-Packard", conexion);
			Functions.updateDataFabricantes("ejercicio1_T18", "fabricantes", "Fabricante diferente", conexion);
			Functions.getValuesFabricantes("ejercicio1_T18", "fabricantes", conexion);
			Functions.deleteValues("ejercicio1_T18", "fabricantes", 5, conexion);
			
			Functions.createTableArticulos("ejercicio1_T18", "articulos", conexion);
			Functions.insertDataArticulos("ejercicio1_T18", "articulos", "Auriculares", 20, 1, conexion);
			Functions.insertDataArticulos("ejercicio1_T18", "articulos", "Ordenador", 1200, 2, conexion);
			Functions.insertDataArticulos("ejercicio1_T18", "articulos", "Cascos", 40, 1, conexion);
			Functions.getValuesArticulos("ejercicio1_T18", "articulos", conexion);
			Functions.deleteValues("ejercicio1_T18", "articulos", 3, conexion);
			
			Functions.closeConnection(conexion);
		}
		catch (SQLException | ClassNotFoundException ex) {
			System.out.print("No se ha podido conectar con mi base de datos");
			System.out.print(ex);
		}
	}
	
}
