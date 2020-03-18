package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.ConexaoJdbc;
import model.Telefone;
import model.Usuario;

public class TelefoneDao {
	private final String SQL_INSERE_TELEFONE = "INSERT INTO \"PUBLIC\".\"TELEFONE\"(\"DDD\", \"NUMERO\", \"TIPO\", \"ID_USUARIO\", ) VALUES (?, ?, ?, ?);";
	private final String SQL_ALTERA_TELEFONE = "UPDATE TELEFONE SET DDD=?, NUMERO=?, TIPO=?, WHERE ID_TELEFONE=?;";
	private final String SQL_EXCLUI_TELEFONE = "DELETE FROM TELEFONE WHERE ID_TELEFONE=?";
	private final String SQL_SELECIONA_TELEFONE = "SELECT * FROM TELEFONE";
	
	private PreparedStatement pst = null;
	
	public boolean inserirTelefone(Telefone telefone) {
		boolean ret = false;
		Connection conexao = ConexaoJdbc.Conectar();
		try {
			pst = conexao.prepareStatement(SQL_INSERE_TELEFONE);
			pst.setLong(1, telefone.getDdd());
			pst.setString(2, telefone.getNumero());
			pst.setString(3, telefone.getTipo());
			ret = pst.execute();
			pst.close();
			ConexaoJdbc.fecharConexao();
		} catch(SQLException e) {
			System.out.println("erro ao executar o statment "+e.toString());
		}
		return ret;
	}
	
	public ArrayList<Telefone> listarTodosTelefones(){
		ArrayList<Telefone> listaDeTelefone = new ArrayList<Telefone>();
		Connection conexao = ConexaoJdbc.Conectar();
		Telefone telefone;
		try {
			pst = conexao.prepareStatement(SQL_SELECIONA_TELEFONE);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				telefone = new Telefone();
				telefone.setId(rs.getInt("ID_Telefon"));
				telefone.setDdd(rs.getInt("DDD"));
				telefone.setNumero(rs.getString("NUMERO"));
				listaDeTelefone.add(telefone);
			}
			rs.close();
			pst.close();
			ConexaoJdbc.fecharConexao();
		}catch (SQLException e) {
			System.out.println("Erro ao executar o Statement "+ e.toString());
		}
		return listaDeTelefone;
	}
	
	public boolean alterarUsuario(Telefone telefone) {
		boolean ret = false;
		Connection conexao = ConexaoJdbc.Conectar();
		try {
			pst = conexao.prepareStatement(SQL_ALTERA_TELEFONE);
			pst.setInt(1, telefone.getDdd());
			pst.setString(2, telefone.getNumero());
			pst.setString(3, telefone.getTipo());
			pst.setInt(4, telefone.getId());
			ret = pst.execute();
			pst.close();
			ConexaoJdbc.fecharConexao();
		}catch(SQLException e) {
			System.out.println("erro ao executar o statment "+e.toString());
		}
		return ret;
	}
	
	public boolean excluirTelefone(Telefone telefone) {
		boolean ret = false;
		Connection conexao = ConexaoJdbc.Conectar();
		try {
			pst = conexao.prepareStatement(SQL_EXCLUI_TELEFONE);
			pst.setInt(1, telefone.getId());
			ret = pst.execute();
			pst.close();
			ConexaoJdbc.fecharConexao();
		}catch (SQLException e) {
			System.out.println("Erro ao executar o Statment "+ e.toString());
		}
		return ret;
	}


}
