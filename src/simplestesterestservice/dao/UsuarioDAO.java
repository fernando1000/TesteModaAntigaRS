package simplestesterestservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import simplestesterestservice.model.Usuario;

public class UsuarioDAO {
	
	private Connection connection;
	
	public UsuarioDAO() {
			this.connection = new FabricaDeConexao().pegaConexao();		
	}
	
	 public void insere(Usuario Usuario) {
	 
		 String sql = "insert into Usuario (usuario, senha) values (?,?)";
	
		 try {
	 
		 PreparedStatement ps = connection.prepareStatement(sql);
	
		 				   ps.setString(    1, Usuario.getUsuario()   );
		 				   ps.setString( 2, Usuario.getSenha()     );
		 				   
		 				   ps.execute();
		 				   ps.close();
		 				   
		
		System.out.println("ação efetuada!");

		
		} 
	 	catch (SQLException e) {
	 		throw new RuntimeException(e);
	 	}
	 }
	 
	 public List<Usuario> listaTodaTabelaUsuario() {
		  
		  String sql = "select * from Usuario"; 
		 
		  try {
			  
		  List<Usuario> Usuarios = new ArrayList<Usuario>();
		  
		  PreparedStatement ps = this.connection.prepareStatement(sql);
		  
		  ResultSet rs = ps.executeQuery();
		 
		  while ( rs.next() ) {
			 
		  Usuario Usuario = new Usuario();
		  
		  		  Usuario.setUsuario(   rs.getString(1)   );
		  		  Usuario.setSenha(     rs.getString(2)  );
		  		
		  Usuarios.add(Usuario);
		  }
		 
		  rs.close();
		  ps.close();
		  
		  return Usuarios;
		  } 
		  catch (SQLException e) {
			  throw new RuntimeException(e);
		  }
	 }

	 public Usuario devolveUsuario(String usuario, String senha) {
		
		 String sql = "SELECT * FROM usuario where usuario ='"+usuario+"' and senha ='"+senha+"'";
			
		 try {
			PreparedStatement ps = connection.prepareStatement(sql);
		
			ResultSet rs = ps.executeQuery();
			
			Usuario Usuario = null;
			
			while( rs.next() ){
		
					Usuario = new Usuario();
					Usuario.setUsuario(   rs.getString(1)   );
		  		  	Usuario.setSenha(     rs.getString(2)  );
			}
  		    
  		  rs.close();
		  ps.close();
		  return Usuario;
		 
		 } 
		 catch (SQLException e) {
			e.printStackTrace();
		 }
		return null;		
	}
	  
	 public void atualiza(Usuario Usuario) {
		 
		  String sql = "update Usuario set senha=? where usuario=?";
		  
		  try {
		  PreparedStatement ps = connection.prepareStatement(sql);
		  
		  					ps.setString( 1, Usuario.getSenha());
		  					ps.setString( 2, Usuario.getUsuario());					
		  					  
		  					ps.execute();
		  					ps.close();
		  					
		  
		  					System.out.println("ação efetuada!");

		  } 
		  catch (SQLException e) {
			  throw new RuntimeException(e);
		  }
	}
	 
	 
	 
	 public void deleta(Usuario Usuario) {
		 
		  String sql = "delete from Usuario where Usuario=?";
		 
		  try {
		  PreparedStatement ps = connection.prepareStatement(sql);
		  
		  					ps.setString( 1, Usuario.getUsuario() );
		 
		  					ps.execute();
		  					ps.close();
		  					
		  
			System.out.println("ação efetuada!");

		  }
		  catch (SQLException e) {
			  throw new RuntimeException(e);
		  }
	}
	 
	 
	 
}