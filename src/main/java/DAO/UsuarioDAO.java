package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ConnectionDB;

import entity.RecuperarSenha;
import entity.Usuario;
import entity.UsuarioADM;
import entity.UsuarioEmpresa;

public class UsuarioDAO {

	Connection conn;
	private String tipoUsuario;

	public UsuarioDAO() throws SQLException {

		conn = ConnectionDB.getConnection();

	}

	public Usuario busca(String email) {

		Usuario u = buscarUsuarioPorEmail(email);

		if (u != null) {

			return u;
		}

		return null;
	}

	// " UPDATE ? SET senha = ? "
	// ps.setString(1, tipoUsuario)

	public boolean alterar(Usuario user) {

		String sql = "UPDATE " + tipoUsuario + " SET senha = ? WHERE email = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, user.getSenha());
			ps.setString(2, user.getEmail());

			return ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;
	}

	public Usuario buscarUsuarioPorEmail(String email) {

		String sql = "SELECT * FROM administrador " + " WHERE email = ?;";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				UsuarioADM adm = new UsuarioADM();

				adm.setId(rs.getInt("id"));
				adm.setNIF(rs.getString("NIF"));
				adm.setEmail(rs.getString("email"));
				adm.setNome(rs.getString("nome"));
				adm.setSenha(rs.getString("senha"));
				adm.setTelefone(rs.getString("telefone"));

				tipoUsuario = "administrador";

				return adm;
			} else {
				sql = "SELECT * FROM empresa " + " WHERE email = ?;";
				ps = conn.prepareStatement(sql);

				ps.setString(1, email);

				rs = ps.executeQuery();

				if (rs.next()) {

					UsuarioEmpresa emp = new UsuarioEmpresa();

					emp.setId(rs.getInt("id"));
					emp.setCNPJ(rs.getString("CNPJ"));
					emp.setEmail(rs.getString("email"));
					emp.setNome(rs.getString("nome"));
					emp.setSenha(rs.getString("senha"));
					emp.setTelefone(rs.getString("telefone"));

					tipoUsuario = "empresa";

					return emp;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean inserirCodigo(RecuperarSenha rec) {

		String sql = " INSERT INTO recuperarSenha (emailUsuario, codigo)" + " VALUES (?, ?) ";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, rec.getEmailUsuario());
			ps.setString(2, rec.getCodigo());

			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public RecuperarSenha verificaCodigo(String cod) {

		String sql = " SELECT rs.*, a.id as id_adm, em.id as id_emp FROM recuperarsenha rs "
				+ " LEFT JOIN administrador a ON (rs.emailUsuario = a.email) "
				+ " LEFT JOIN empresa em ON (rs.emailUsuario = em.email) " + " WHERE rs.codigo = ? ";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, cod);

			ResultSet rs = ps.executeQuery();

			RecuperarSenha samu = null;

			if (rs.next()) {

				samu = new RecuperarSenha();

				if (rs.getString("id_adm") != null) {
					tipoUsuario = "administrador";
				} else {
					tipoUsuario = "empresa";
				}

				samu.setCodigo(rs.getString("codigo"));
				samu.setId(rs.getInt("id"));
				samu.setEmailUsuario(rs.getString("emailUsuario"));

			}
			return samu;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public boolean deletaProtocolo(RecuperarSenha proto) {

		String sql = "DELETE * FROM recuperarSenha " + "WHERE id = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, proto.getId());

			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

}
