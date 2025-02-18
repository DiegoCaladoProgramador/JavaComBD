package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.ConexaoJdbc;
import model.Usuario;

public class UsuarioDao {
	private final String SQL_INSERE_USUARIO = "INSERT INTO \"PUBLIC\".\"USUARIO\"(\"NOME\", \"EMAIL\", \"SENHA\" ) VALUES (?, ?, ?);";
	private final String SQL_ALTERA_USUARIO = "UPDATE USUARIO SET NOME=?, EMAIL=?, SENHA=?, WHERE ID=?;";
	private final String SQL_EXCLUI_USUARIO = "DELETE FROM USUARIO WHERE ID=?";
	private final String SQL_SELECIONA_USUARIO = "SELECT * FROM USUARIO";
	
	
	private PreparedStatement pst = null;
	
	public boolean inserirUsuario(Usuario usuario) {
		boolean ret = false;
		Connection conexao = ConexaoJdbc.Conectar();
		try {
			pst = conexao.prepareStatement(SQL_INSERE_USUARIO);
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getEmail());
			pst.setString(3, usuario.getSenha());
			ret = pst.execute();
			pst.close();
			ConexaoJdbc.fecharConexao();
		} catch(SQLException e) {
			System.out.println("erro ao executar o statment "+e.toString());
		}
		return ret;
	}
	
	public ArrayList<Usuario> listarTodosUsuarios(){
		ArrayList<Usuario> listaDeUsuario = new ArrayList<Usuario>();
		Connection conexao = ConexaoJdbc.Conectar();
		Usuario usuario;
		try {
			pst = conexao.prepareStatement(SQL_SELECIONA_USUARIO);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("ID_USUARIO"));
				usuario.setNome(rs.getString("Nome"));
				usuario.setEmail(rs.getString("EMAIL"));
				listaDeUsuario.add(usuario);
			}
			rs.close();
			pst.close();
			ConexaoJdbc.fecharConexao();
		}catch (SQLException e) {
			System.out.println("Erro ao executar o Statement "+ e.toString());
		}
		return listaDeUsuario;
	}
	
	public boolean alterarUsuario(Usuario usuario) {
		boolean ret = false;
		Connection conexao = ConexaoJdbc.Conectar();
		try {
			pst = conexao.prepareStatement(SQL_ALTERA_USUARIO);
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getEmail());
			pst.setString(3, usuario.getSenha());
			pst.setInt(4, usuario.getId());
			ret = pst.execute();
			pst.close();
			ConexaoJdbc.fecharConexao();
		}catch(SQLException e) {
			System.out.println("erro ao executar o statment "+e.toString());
		}
		return ret;
	}
	
	public boolean excluirUsuario(Usuario usuario) {
		boolean ret = false;
		Connection conexao = ConexaoJdbc.Conectar();
		try {
			pst = conexao.prepareStatement(SQL_EXCLUI_USUARIO);
			pst.setInt(1, usuario.getId());
			ret = pst.execute();
			pst.close();
			ConexaoJdbc.fecharConexao();
		}catch (SQLException e) {
			System.out.println("Erro ao executar o Statment "+ e.toString());
		}
		return ret;
	}

}
