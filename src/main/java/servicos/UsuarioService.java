package servicos;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import DAO.UsuarioDAO;
import entity.Usuario;

@Path("/ws/usuario")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioService {

	private UsuarioDAO usuarioDAO;

	public UsuarioService() {
		try {
			usuarioDAO = new UsuarioDAO();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@GET
	@Path("/{email}")
	public Usuario busca(@PathParam("email") String email) {
		return usuarioDAO.busca(email);
	}

}
