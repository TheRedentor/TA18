package ejercicio8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import ejercicio1.Ejercicio1App;

public class Ejercicio8App {
	
	// Conecta a MySQL
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection("jdbc:mysql://192.168.0.118:3306?useTimezone=true&serverTimezone=UTC","remote","i6eLeQ<L(X3E");
			System.out.println("Server Connected");
			Functions.createDB("ejercicio8_T18", conexion);
			
			Functions.createTableProductos("ejercicio8_T18", "productos", conexion);
			Functions.insertDataProductos("ejercicio8_T18", "productos", "Producto 1", 3, conexion);
			Functions.insertDataProductos("ejercicio8_T18", "productos", "Producto 2", 5, conexion);
			Functions.insertDataProductos("ejercicio8_T18", "productos", "Producto 3", 7, conexion);
			Functions.updateDataProductos("ejercicio8_T18", "productos", "Producto diferente", conexion);
			Functions.getValuesProductos("ejercicio8_T18", "productos", conexion);
			
			Functions.createTableMaquinasRegistradoras("ejercicio8_T18", "maquinas_registradoras", conexion);
			Functions.insertDataMaquinasRegistradoras("ejercicio8_T18", "maquinas_registradoras", 1, conexion);
			Functions.insertDataMaquinasRegistradoras("ejercicio8_T18", "maquinas_registradoras", 2, conexion);
			Functions.insertDataMaquinasRegistradoras("ejercicio8_T18", "maquinas_registradoras", 3, conexion);
			Functions.getValuesMaquinasRegistradoras("ejercicio8_T18", "maquinas_registradoras", conexion);
			
			Functions.createTableCajeros("ejercicio8_T18", "cajeros", conexion);
			Functions.insertDataCajeros("ejercicio8_T18", "cajeros", "Cajero 1", conexion);
			Functions.insertDataCajeros("ejercicio8_T18", "cajeros", "Cajero 2", conexion);
			Functions.insertDataCajeros("ejercicio8_T18", "cajeros", "Cajero 3", conexion);
			Functions.getValuesCajeros("ejercicio8_T18", "cajeros", conexion);
			
			Functions.createTableVenta("ejercicio8_T18", "venta", conexion);
			Functions.insertDataVenta("ejercicio8_T18", "venta", 1, 1, 1, conexion);
			Functions.insertDataVenta("ejercicio8_T18", "venta", 2, 2, 2, conexion);
			Functions.insertDataVenta("ejercicio8_T18", "venta", 3, 3, 3, conexion);
			Functions.getValuesVenta("ejercicio8_T18", "venta", conexion);
			
			Functions.deleteValues("ejercicio8_T18", "productos", 3, conexion);
			Functions.deleteValues("ejercicio8_T18", "maquinas_registradoras", 3, conexion);
			Functions.deleteValues("ejercicio8_T18", "cajeros", 3, conexion);
			Functions.deleteValuesVenta("ejercicio8_T18", "venta", 3, 3, 3, conexion);
			
			Functions.closeConnection(conexion);
		}
		catch (SQLException | ClassNotFoundException ex) {
			System.out.print("No se ha podido conectar con mi base de datos");
			System.out.print(ex);
		}
	}	
}
