package ejercicio9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import ejercicio1.Ejercicio1App;

public class Ejercicio9App {
	
	// Conecta a MySQL
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection("jdbc:mysql://192.168.0.118:3306?useTimezone=true&serverTimezone=UTC","remote","i6eLeQ<L(X3E");
			System.out.println("Server Connected");
			Functions.createDB("ejercicio9_T18", conexion);
			
			Functions.createTableFacultad("ejercicio9_T18", "facultad", conexion);
			Functions.insertDataFacultad("ejercicio9_T18", "facultad", "Facultad 1", conexion);
			Functions.insertDataFacultad("ejercicio9_T18", "facultad", "Facultad 2", conexion);
			Functions.insertDataFacultad("ejercicio9_T18", "facultad", "Facultad 3", conexion);
			Functions.updateDataFacultad("ejercicio9_T18", "facultad", "Facultad diferente", conexion);
			Functions.getValuesFacultad("ejercicio9_T18", "facultad", conexion);
			
			Functions.createTableInvestigadores("ejercicio9_T18", "investigadores", conexion);
			Functions.insertDataInvestigadores("ejercicio9_T18", "investigadores", "34526178", "Investigador 1", 1, conexion);
			Functions.insertDataInvestigadores("ejercicio9_T18", "investigadores", "35647182", "Investigador 2", 2, conexion);
			Functions.insertDataInvestigadores("ejercicio9_T18", "investigadores", "36647255", "Investigador 3", 3, conexion);
			Functions.getValuesInvestigadores("ejercicio9_T18", "investigadores", conexion);
			
			Functions.createTableEquipos("ejercicio9_T18", "equipos", conexion);
			Functions.insertDataEquipos("ejercicio9_T18", "equipos", "1111", "Equipo 1", 1, conexion);
			Functions.insertDataEquipos("ejercicio9_T18", "equipos", "2222", "Equipo 2", 2, conexion);
			Functions.insertDataEquipos("ejercicio9_T18", "equipos", "3333", "Equipo 3", 3, conexion);
			Functions.getValuesEquipos("ejercicio9_T18", "equipos", conexion);
			
			Functions.createTableReserva("ejercicio9_T18", "reserva", conexion);
			Functions.insertDataReserva("ejercicio9_T18", "reserva", "34526178", "1111", "2008-11-11 13:23:44", "2012-11-11 13:23:44", conexion);
			Functions.insertDataReserva("ejercicio9_T18", "reserva", "35647182", "2222", "2008-11-11 13:23:44", "2012-11-11 13:23:44", conexion);
			Functions.insertDataReserva("ejercicio9_T18", "reserva", "36647255", "3333", "2008-11-11 13:23:44", "2012-11-11 13:23:44", conexion);
			Functions.getValuesReserva("ejercicio9_T18", "reserva", conexion);
			
			Functions.deleteValuesFacultad("ejercicio9_T18", "facultad", 3, conexion);
			Functions.deleteValuesInvestigadores("ejercicio9_T18", "investigadores", "36647255", conexion);
			Functions.deleteValuesEquipos("ejercicio9_T18", "equipos", "3333", conexion);
			Functions.deleteValuesReserva("ejercicio9_T18", "reserva", "36647255", "3333", conexion);
			
			Functions.closeConnection(conexion);
		}
		catch (SQLException | ClassNotFoundException ex) {
			System.out.print("No se ha podido conectar con mi base de datos");
			System.out.print(ex);
		}
	}
}
