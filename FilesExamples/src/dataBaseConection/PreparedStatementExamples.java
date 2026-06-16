package dataBaseConection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import hangMan.Player;

public class PreparedStatementExamples {

	public static void main(String[] args) throws SQLException {
		
		String url="jdbc:mysql://10.203.28.74:3306/PlayersDB";
		String user="root";
		String password="";//en XAMPP suele estar vacío
		
		ArrayList<Player> playerList=new ArrayList<Player>();
		
		Connection conn=DriverManager.getConnection(url, user, password);
		System.out.println("Sucessful Conexion");
		
//		ResultSet rs=stmt.executeQuery("SELECT * FROM Players WHERE name = '"+searchName+"'");
		String queryName="' OR '1'='1";
		String sql="SELECT * FROM Players WHERE name = ?";
		String puntuQuery="SELECT * FROM Players WHERE puntuation > ?";
		String update="UPDATE Players SET puntuation =? WHERE name = ?";
		
//		PreparedStatement prepStmt=conn.prepareStatement(sql);
		PreparedStatement updateStmt=conn.prepareStatement(update);
		updateStmt.setInt(1,0);
		updateStmt.setString(1, queryName);
//		ResultSet rs=prepStmt.executeQuery();
		updateStmt.execute();
		
//		while (rs.next()) {
//			int id=rs.getInt("id");
//			String name=rs.getString("name");
//			int puntuation=rs.getInt("puntuation");
//			
//			System.out.println(id+ "-" +name+"-"+puntuation);
//		}
		conn.close();
	}
}
