package ejercicio3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import ejercicio1.Ejercicio1App;

public class Ejercicio3App {

	// Conecta a MySQL
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection("jdbc:mysql://192.168.0.118:3306?useTimezone=true&serverTimezone=UTC","remote","i6eLeQ<L(X3E");
			System.out.println("Server Connected");
			Functions.createDB("ejercicio3_T18", conexion);
			
			Functions.createTableAlmacenes("ejercicio3_T18", "almacenes", conexion);
			Functions.insertDataAlmacenes("ejercicio3_T18", "almacenes", "IT", 10000, conexion);
			Functions.insertDataAlmacenes("ejercicio3_T18", "almacenes", "Accounting", 25000, conexion);
			Functions.insertDataAlmacenes("ejercicio3_T18", "almacenes", "Human Resources", 30000, conexion);
			Functions.updateDataAlmacenes("ejercicio3_T18", "almacenes", "Lugar diferente", conexion);
			Functions.getValuesAlmacenes("ejercicio3_T18", "almacenes", conexion);
			
			Functions.createTableCajas("ejercicio3_T18", "cajas", conexion);
			Functions.insertDataCajas("ejercicio3_T18", "cajas", "0MN7", "Rocks", 180, 1, conexion);
			Functions.insertDataCajas("ejercicio3_T18", "cajas", "4RT3", "Scissors", 190, 2, conexion);
			Functions.insertDataCajas("ejercicio3_T18", "cajas", "8JN6", "Papers", 75, 3, conexion);
			Functions.getValuesCajas("ejercicio3_T18", "cajas", conexion);
			
			Functions.deleteValuesAlmacenes("ejercicio3_T18", "almacenes", 3, conexion);
			Functions.deleteValuesCajas("ejercicio3_T18", "cajas", "8JN6", conexion);
			
			Functions.closeConnection(conexion);
		}
		catch (SQLException | ClassNotFoundException ex) {
			System.out.print("No se ha podido conectar con mi base de datos");
			System.out.print(ex);
		}
	}

}
