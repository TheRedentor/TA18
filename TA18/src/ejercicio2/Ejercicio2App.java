package ejercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import ejercicio1.Ejercicio1App;

public class Ejercicio2App {

	// Conecta a MySQL
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection("jdbc:mysql://192.168.0.118:3306?useTimezone=true&serverTimezone=UTC","remote","i6eLeQ<L(X3E");
			System.out.println("Server Connected");
			Functions.createDB("ejercicio2_T18", conexion);
			
			Functions.createTableDepartamentos("ejercicio2_T18", "departamentos", conexion);
			Functions.insertDataDepartamentos("ejercicio2_T18", "departamentos", "IT", 10000, conexion);
			Functions.insertDataDepartamentos("ejercicio2_T18", "departamentos", "Accounting", 25000, conexion);
			Functions.insertDataDepartamentos("ejercicio2_T18", "departamentos", "Human Resources", 30000, conexion);
			Functions.updateDataDepartamentos("ejercicio2_T18", "departamentos", "Departamento diferente", conexion);
			Functions.getValuesDepartamentos("ejercicio2_T18", "departamentos", conexion);
			
			Functions.createTableEmpleados("ejercicio2_T18", "empleados", conexion);
			Functions.insertDataEmpleados("ejercicio2_T18", "empleados", "34562819", "Pepe", "Viyuela", 1, conexion);
			Functions.insertDataEmpleados("ejercicio2_T18", "empleados", "54637286", "Maria", "Rispa", 2, conexion);
			Functions.insertDataEmpleados("ejercicio2_T18", "empleados", "45621787", "Liam", "Nelson", 3, conexion);
			Functions.getValuesEmpleados("ejercicio2_T18", "empleados", conexion);
			
			Functions.deleteValuesDepartamentos("ejercicio2_T18", "departamentos", 3, conexion);
			Functions.deleteValuesEmpleados("ejercicio2_T18", "empleados", "45621787", conexion);
			
			Functions.closeConnection(conexion);
		}
		catch (SQLException | ClassNotFoundException ex) {
			System.out.print("No se ha podido conectar con mi base de datos");
			System.out.print(ex);
		}
	}

}
