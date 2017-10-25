package simplestesterestservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import simplestesterestservice.model.Paciente;

public class PacienteDAO {

	private Connection connection;

	public PacienteDAO() {
		this.connection = new FabricaDeConexao().pegaConexao();
	}
	
	public List<Paciente> listaTodaTabelaPaciente() {
		
		 String sql = "select * from paciente"; 
		 
		  try {
			  
		  List<Paciente> listaComPacientes = new ArrayList<Paciente>();
		  
		  PreparedStatement ps = this.connection.prepareStatement(sql);
		  
		  ResultSet rs = ps.executeQuery();
		 
		  while ( rs.next() ) {
			 
			  Paciente paciente = new Paciente();
			  		   paciente.setNome(rs.getString(1));
			  		   paciente.setRg(rs.getString(2));
			  		   paciente.setCpf(rs.getString(3));
				     
		  listaComPacientes.add(paciente);
		  }
		 
		  rs.close();
		  ps.close();
		  return listaComPacientes;
		  } 
		  catch (SQLException e) {
			  throw new RuntimeException(e);
		  }
	}


	
	
}
