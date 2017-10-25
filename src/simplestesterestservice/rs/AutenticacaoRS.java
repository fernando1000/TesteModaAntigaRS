package simplestesterestservice.rs;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import simplestesterestservice.dao.PacienteDAO;
import simplestesterestservice.dao.UsuarioDAO;
import simplestesterestservice.model.Usuario;

@Path("Autenticacao")
public class AutenticacaoRS {

	private PacienteDAO pacienteDAO = new PacienteDAO();
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/Login/{usuario}/{senha}")
	public String devolveListaDeUsuarios(@PathParam("usuario") String usuario, @PathParam("senha") String senha) {

		StringBuilder stringBuilder = new StringBuilder();

		Usuario usuarioEncontrado = usuarioDAO.devolveUsuario(usuario, senha);

		if (usuarioEncontrado == null) {

			stringBuilder.append("null");
		} else {
			stringBuilder.append(pacienteDAO.listaTodaTabelaPaciente());
		}
		return stringBuilder.toString();		
	}
	
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/Teste")
	public String teste(){
		
		String dataAtualFormatada = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault()).format(new Date());

		return "Servidor OK "+dataAtualFormatada;		
	}
	
}
