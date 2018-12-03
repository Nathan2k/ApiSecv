package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.ConnectionDB;

import entity.UsuarioADM;
import entity.UsuarioEmpresa;
import utils.Replace;

public class UsuarioEmpresaDAO {

	Connection conn;

	public UsuarioEmpresaDAO() {
		try {
			conn = ConnectionDB.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public UsuarioEmpresa buscarEmpresa(String cnpj, String senha) throws SQLException { // perguntar sobre a senha

		String sql = "SELECT * FROM empresa " + "WHERE CNPJ = ? AND senha = ?;"; // perguntar se falta alguma coisa

		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, cnpj);
		ps.setString(2, senha);

		ResultSet rs = ps.executeQuery(); // perguntar como tirar o java.sql.resultset
		UsuarioEmpresa emp = null;
		if (rs.next()) {
			emp = new UsuarioEmpresa();

			emp.setId(rs.getInt("id"));// perguntar se o ID é igual a variavel q esta no banco
			emp.setBairro(rs.getString("bairro"));
			emp.setCidade(rs.getString("cidade"));
			emp.setRua(rs.getString("rua"));
			emp.setSenha(rs.getString("senha"));
			emp.setNome(rs.getString("nome"));
			emp.setCNPJ(rs.getString("CNPJ"));
			emp.setEmail(rs.getString("email"));
			emp.setRepresentante(rs.getString("representante"));
			emp.setTelefone(rs.getString("telefone"));

		}
		return emp;

	}

	// ---------------------------------------------------------------------------------------------

	public boolean inserirEmpresa(UsuarioEmpresa emp) {

		// PERGUNTAR SE TEM QUE COLOCAR O ID TAMBEM ALI NO INSERT INTO

		String sql = " INSERT INTO empresa (senha, nome, CNPJ, cidade, "
				+ " bairro, rua, email, telefone, representante)" + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, emp.getSenha());
			ps.setString(2, emp.getNome());
			ps.setString(3, Replace.format(emp.getCNPJ()));
			ps.setString(4, emp.getCidade());
			ps.setString(5, emp.getBairro());
			ps.setString(6, emp.getRua());
			ps.setString(7, emp.getEmail());
			ps.setString(8, emp.getTelefone());
			ps.setString(9, emp.getRepresentante());

			System.out.println(ps.toString());
			if (ps.executeUpdate() == 1) {
				System.out.println("Usuário empresa cadastrado ");
			} else {
				System.out.println("Problemas ao cadastrar usuário empresa");
				return false;
			}

			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	// ---------------------------------------------------------------------------------------------

	public List<UsuarioEmpresa> listarTodos() {

		List<UsuarioEmpresa> list = new ArrayList<>();

		String sql = " SELECT * FROM empresa; ";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				UsuarioEmpresa ue = new UsuarioEmpresa();

				ue.setId(rs.getInt("id"));
				ue.setBairro(rs.getString("bairro"));
				ue.setCidade(rs.getString("cidade"));
				ue.setRua(rs.getString("rua"));
				ue.setSenha(rs.getString("senha"));
				ue.setNome(rs.getString("nome"));
				ue.setCNPJ(rs.getString("cnpj"));
				ue.setEmail(rs.getString("email"));
				ue.setRepresentante(rs.getString("representante"));
				ue.setTelefone(rs.getString("telefone"));

				list.add(ue);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	// ---------------------------------------------------------------------------------------------

	public boolean alterar(UsuarioEmpresa emp) {

		String sql = "UPDATE empresa SET nome = ?, senha = ?, representante = ?, telefone = ?, " // perguntar se tem q
																									// passar o CNPJ no
																									// update
				+ "email = ?, rua = ?, bairro = ?, cidade = ? WHERE id = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, emp.getNome());
			ps.setString(2, emp.getSenha());
			ps.setString(3, emp.getRepresentante());
			ps.setString(4, emp.getTelefone());
			ps.setString(5, emp.getEmail());
			ps.setString(6, emp.getRua());
			ps.setString(7, emp.getBairro());
			ps.setString(8, emp.getCidade());
			ps.setInt(9, emp.getId());

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

	// ---------------------------------------------------------------------------------------------

	public UsuarioEmpresa buscarEmpresa(String email) throws SQLException { // perguntar sobre a senha

		String sql = "SELECT * FROM empresa " + "WHERE email = ?;"; // perguntar se falta alguma coisa

		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, email);

		ResultSet rs = ps.executeQuery(); // perguntar como tirar o java.sql.resultset
		UsuarioEmpresa emp = null;
		if (rs.next()) {
			emp = new UsuarioEmpresa();

			emp.setId(rs.getInt("id"));// perguntar se o ID é igual a variavel q esta no banco
			emp.setBairro(rs.getString("bairro"));
			emp.setCidade(rs.getString("cidade"));
			emp.setRua(rs.getString("rua"));
			emp.setSenha(rs.getString("senha"));
			emp.setNome(rs.getString("nome"));
			emp.setCNPJ(rs.getString("CNPJ"));
			emp.setEmail(rs.getString("email"));
			emp.setRepresentante(rs.getString("representante"));
			emp.setTelefone(rs.getString("telefone"));

		}
		return emp;
	}

	// ---------------------------------------------------------------------------------------------

	public UsuarioEmpresa buscaCnpj(String cnpj) throws SQLException { // perguntar sobre a senha

		String sql = "SELECT * FROM empresa " + "WHERE CNPJ = ?;"; // perguntar se falta alguma coisa

		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, Replace.format(cnpj));

		ResultSet rs = ps.executeQuery(); // perguntar como tirar o java.sql.resultset
		UsuarioEmpresa emp = null;
		if (rs.next()) {
			emp = new UsuarioEmpresa();

			emp.setId(rs.getInt("id"));// perguntar se o ID é igual a variavel q esta no banco
			emp.setBairro(rs.getString("bairro"));
			emp.setCidade(rs.getString("cidade"));
			emp.setRua(rs.getString("rua"));
			emp.setSenha(rs.getString("senha"));
			emp.setNome(rs.getString("nome"));
			emp.setCNPJ(rs.getString("CNPJ"));
			emp.setEmail(rs.getString("email"));
			emp.setRepresentante(rs.getString("representante"));
			emp.setTelefone(rs.getString("telefone"));

		}
		return emp;
	}

	// ---------------------------------------------------------------------------------------------

	public boolean deletar(UsuarioEmpresa emp) throws SQLException {

		String sql = "DELETE FROM empresa WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, emp.getId());

		System.out.println(ps.toString());
		return ps.executeUpdate() > 0;
	}

}
