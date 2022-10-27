package ejercicio7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import ejercicio1.Ejercicio1App;

public class Ejercicio7App {

	// Conecta a MySQL
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection("jdbc:mysql://192.168.0.118:3306?useTimezone=true&serverTimezone=UTC","remote","i6eLeQ<L(X3E");
			System.out.println("Server Connected");
			Functions.createDB("ejercicio7_T18", conexion);
			
			Functions.createTableCientificos("ejercicio7_T18", "cientificos", conexion);
			Functions.insertDataCientificos("ejercicio7_T18", "cientificos", "34526174", "Pepe Viyuela", conexion);
			Functions.insertDataCientificos("ejercicio7_T18", "cientificos", "46571834", "Juan Antonio", conexion);
			Functions.insertDataCientificos("ejercicio7_T18", "cientificos", "53726186", "Maria Rispa", conexion);
			Functions.updateDataCientificos("ejercicio7_T18", "cientificos", "Investigador diferente", conexion);
			Functions.getValuesCientificos("ejercicio7_T18", "cientificos", conexion);
			
			Functions.createTableProyecto("ejercicio7_T18", "proyecto", conexion);
			Functions.insertDataProyecto("ejercicio7_T18", "proyecto", "1111", "Proyecto 1", 10, conexion);
			Functions.insertDataProyecto("ejercicio7_T18", "proyecto", "2222", "Proyecto 2", 20, conexion);
			Functions.insertDataProyecto("ejercicio7_T18", "proyecto", "3333", "Proyecto 3", 30, conexion);
			Functions.getValuesProyecto("ejercicio7_T18", "proyecto", conexion);
			
			Functions.createTableAsignadoA("ejercicio7_T18", "asignado_a", conexion);
			Functions.insertDataAsignadoA("ejercicio7_T18", "asignado_a", "34526174", "1111", conexion);
			Functions.insertDataAsignadoA("ejercicio7_T18", "asignado_a", "46571834", "2222", conexion);
			Functions.insertDataAsignadoA("ejercicio7_T18", "asignado_a", "53726186", "3333", conexion);
			Functions.getValuesAsignadoA("ejercicio7_T18", "asignado_a", conexion);
			
			Functions.deleteValuesCientificos("ejercicio7_T18", "cientificos", "53726186", conexion);
			Functions.deleteValuesProyecto("ejercicio7_T18", "proyecto", "3333", conexion);
			Functions.deleteValuesAsignadoA("ejercicio7_T18", "asignado_a", "53726186", "3333", conexion);
			
			Functions.closeConnection(conexion);
		}
		catch (SQLException | ClassNotFoundException ex) {
			System.out.print("No se ha podido conectar con mi base de datos");
			System.out.print(ex);
		}
	}
}
