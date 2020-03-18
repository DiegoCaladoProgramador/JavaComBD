package view;

import java.sql.Connection;
import java.util.ArrayList;

import dao.UsuarioDao;
import jdbc.ConexaoJdbc;
import model.Usuario;

public class Main {

	public static void main(String[] args) {
		UsuarioDao usuarioDao = new UsuarioDao();
		Usuario usuario = new Usuario();
		
		usuario.setNome("teste");
		usuario.setEmail("@teste");
		usuario.setSenha("***");
		usuarioDao.inserirUsuario(usuario);
		
		ArrayList<Usuario> listaUsuario = usuarioDao.listarTodosUsuarios();
		for(Usuario user: listaUsuario) {
			System.out.println(user.toString());
		}
	}

}
