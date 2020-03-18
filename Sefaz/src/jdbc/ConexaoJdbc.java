package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoJdbc {
	private static final String DIVERCLASS = "org.hsqldb.jdbcDriver";
	private static Connection conexao = null;
	private static String usuario = "SA";
	private static String senha = "";
	private static String PathBase = "C:\\Sefaz\\Sefaz\\base\\Sefaz";
	private static final String URL = "jdbc:hsqldb:file:" + PathBase + ";shutdown=true;hsqldb.write_delay=false; ";
	
	public static Connection Conectar(){
		if(conexao == null) {
			try {
				Class.forName(DIVERCLASS);
				//estabelecendo conexão
				conexao = DriverManager.getConnection(URL, usuario, senha);
			}catch (SQLException e) {
					// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
			}
		}
		
		return conexao;
		
	}
	
	public static void fecharConexao() {
		try {
			conexao.close();
			conexao=null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}