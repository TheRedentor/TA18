package ejercicio6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import ejercicio1.Ejercicio1App;

public class Ejercicio6App {
	
	// Conecta a MySQL
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection("jdbc:mysql://192.168.0.118:3306?useTimezone=true&serverTimezone=UTC","remote","i6eLeQ<L(X3E");
			System.out.println("Server Connected");
			Functions.createDB("ejercicio6_T18", conexion);
			
			Functions.createTablePiezas("ejercicio6_T18", "piezas", conexion);
			Functions.insertDataPiezas("ejercicio6_T18", "piezas", "Pieza 1", conexion);
			Functions.insertDataPiezas("ejercicio6_T18", "piezas", "Pieza 2", conexion);
			Functions.insertDataPiezas("ejercicio6_T18", "piezas", "Pieza 3", conexion);
			Functions.updateDataPiezas("ejercicio6_T18", "piezas", "Pieza diferente", conexion);
			Functions.getValuesPiezas("ejercicio6_T18", "piezas", conexion);
			
			Functions.createTableProveedores("ejercicio6_T18", "proveedores", conexion);
			Functions.insertDataProveedores("ejercicio6_T18", "proveedores", "1111", "Proveedor 1", conexion);
			Functions.insertDataProveedores("ejercicio6_T18", "proveedores", "2222", "Proveedor 2", conexion);
			Functions.insertDataProveedores("ejercicio6_T18", "proveedores", "3333", "Proveedor 3", conexion);
			Functions.getValuesProveedores("ejercicio6_T18", "proveedores", conexion);
			
			Functions.createTableSuministra("ejercicio6_T18", "suministra", conexion);
			Functions.insertDataSuministra("ejercicio6_T18", "suministra", 1, "1111", 13, conexion);
			Functions.insertDataSuministra("ejercicio6_T18", "suministra", 2, "2222", 7, conexion);
			Functions.insertDataSuministra("ejercicio6_T18", "suministra", 3, "3333", 6, conexion);
			Functions.getValuesSuministra("ejercicio6_T18", "suministra", conexion);
			
			Functions.deleteValuesPiezas("ejercicio6_T18", "piezas", 3, conexion);
			Functions.deleteValuesProveedores("ejercicio6_T18", "proveedores", "3333", conexion);
			Functions.deleteValuesSuministra("ejercicio6_T18", "suministra", 3, "3333", conexion);
			
			Functions.closeConnection(conexion);
		}
		catch (SQLException | ClassNotFoundException ex) {
			System.out.print("No se ha podido conectar con mi base de datos");
			System.out.print(ex);
		}
	}
}
