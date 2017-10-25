package simplestesterestservice.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaDeConexao {

	public Connection pegaConexao(){
		 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 	
		 return DriverManager.getConnection("jdbc:mysql://172.16.4.151:3306/conta_sim", "root", "root");
		 
		 } 
		 catch (Exception e) {
		 throw new RuntimeException(e);
		 }
	 }
}
