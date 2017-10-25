package simplestesterestservice.teste;

import java.util.List;

import simplestesterestservice.dao.PacienteDAO;
import simplestesterestservice.dao.UsuarioDAO;
import simplestesterestservice.model.Paciente;
import simplestesterestservice.model.Usuario;

public class Testes {

	public static void main(String[] args){
		
		PacienteDAO dao = new PacienteDAO();

		/*
		System.out.println(dao.listaTodaTabelaPaciente());
		
		for (Paciente pda : dao.listaTodaTabelaPaciente()) {

			System.out.println(pda);
			
		}
		 
		 */
	
		
		
		/*
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		Usuario user = new Usuario();
		user.setUsuario("teste");
		user.setSenha("6667777777");
		
		//usuarioDAO.insere(user);
		
		if(usuarioDAO.devolveUsuario("teste", "6667777777") == null){
	
			System.out.println("nulo");
			
		}else{
			System.out.println("achou");
			
		}
		
		for(Usuario u : usuarioDAO.listaTodaTabelaUsuario()){
			
			System.out.println(u.getUsuario() + u.getSenha());
		}
		 */
		
		//usuarioDAO.atualiza(user);
		//usuarioDAO.deleta(user);
	
		
		
		/*
		String listaComPacientes = dao.listaTodaTabelaPaciente().toString();
		String listaSemColchetes1 = listaComPacientes.replace("[", "");
		String listaSemColchetes2 = listaSemColchetes1.replace("]", "");
		
		for(String paciente : listaSemColchetes2.split(",")){
			
			for(String atributo :paciente.split(";")){
	
				String[] chaveValor = atributo.split(":");
					
				System.out.println("chave: "+chaveValor[0] +" valor: "+chaveValor[1]);			
			}
			
			System.out.println("########################");
			
		}
		 */
		
		
		
		
		String listaComPacientes = "[NOME:Adriana;RG:040404;CPF:44444, NOME:Jose;RG:01010101;CPF:1111111, NOME:Luciano;RG:02020202;CPF:2222222, NOME:Rodrigo;RG:030303032;CPF:333333]";
		String listaSemColchetes1 = listaComPacientes.replace("[", "");
		String listaSemColchetes2 = listaSemColchetes1.replace("]", "");
		
		for(String paciente : listaSemColchetes2.split(",")){
			
			Paciente pacient = new Paciente();
			
			for(String atributo :paciente.split(";")){
	
				String atributoSemEspacos = atributo.replaceAll("^\\s+", "");
				
				String[] chaveValor = atributoSemEspacos.split(":");
					
				String chave = chaveValor[0];
				String valor = chaveValor[1];
				
				if(chave.equalsIgnoreCase("nome")){
					
					pacient.setNome(valor);
				}
				if(chave.equalsIgnoreCase("rg")){
				
					pacient.setRg(valor);
				}				
				if(chave.equalsIgnoreCase("cpf")){
				
					pacient.setCpf(valor);
				}
			
			}			
			
			System.out.println("nome: "+pacient.getNome() +" rg: "+pacient.getRg() +" cpf: "+pacient.getCpf());

			
		}
		
		
		
		
		
		
	}
	
	

	
}
