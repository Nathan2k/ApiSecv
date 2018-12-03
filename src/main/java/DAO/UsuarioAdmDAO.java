package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ConnectionDB;

import entity.UsuarioADM;

public class UsuarioAdmDAO {

	Connection conn;

	public UsuarioAdmDAO() {
		try {
			conn = ConnectionDB.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public UsuarioADM buscarADM(String nif, String senha) {

		String sql = "SELECT * FROM administrador " + "WHERE NIF = ? AND senha = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, nif);
			ps.setString(2, senha);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				UsuarioADM adm = new UsuarioADM();

				adm.setId(rs.getInt("id"));
				adm.setNIF(rs.getString("NIF"));
				adm.setEmail(rs.getString("email"));
				adm.setNome(rs.getString("nome"));
				adm.setSenha(rs.getString("senha"));
				adm.setTelefone(rs.getString("telefone"));

				return adm;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// ---------------------------------------------------------------------------------------------------

	public boolean inserirADM(UsuarioADM adm) {

		// PERGUNTAR SE TEM QUE COLOCAR O ID TAMBEM ALI NO INSERT INTO

		String sql = " INSERT INTO administrador (NIF, email, nome, senha, " + " telefone)"
				+ " VALUES (?, ?, ?, ?, ?) ";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, adm.getNIF());
			ps.setString(2, adm.getEmail());
			ps.setString(3, adm.getNome());
			ps.setString(4, adm.getSenha());
			ps.setString(5, adm.getTelefone());

			if (ps.executeUpdate() == 1) {
				System.out.println("Usuário adm cadastrado ");
			} else {
				System.out.println("Problemas ao cadastrar usuário adm");
			}
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	// ---------------------------------------------------------------------------------------------------

	public UsuarioADM buscarADM(String nif) {

		String sql = "SELECT * FROM administrador " + "WHERE NIF = ?;";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, nif);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				UsuarioADM adm = new UsuarioADM();

				adm.setId(rs.getInt("id"));
				adm.setNIF(rs.getString("NIF"));
				adm.setEmail(rs.getString("email"));
				adm.setNome(rs.getString("nome"));
				adm.setSenha(rs.getString("senha"));
				adm.setTelefone(rs.getString("telefone"));

				return adm;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// ---------------------------------------------------------------------------------------------------

	public UsuarioADM buscarEmailADM(String email) {

		String sql = "SELECT * FROM administrador " + "WHERE email = ?;";

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

				return adm;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// ---------------------------------------------------------------------------------------------------

	public boolean mudarADM(UsuarioADM uAdm) {

		String sql = "UPDATE administrador SET nome = ?, email = ?, telefone = ?, NIF = ? " // perguntar se tem q
																							// passar o CNPJ no //
																							// update
				+ " WHERE id = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, uAdm.getNome());
			ps.setString(2, uAdm.getEmail());
			ps.setString(3, uAdm.getTelefone());
			ps.setString(4, uAdm.getNIF());
			ps.setInt(5, uAdm.getId());

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

}
