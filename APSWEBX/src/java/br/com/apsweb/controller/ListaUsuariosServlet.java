package br.com.apsweb.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.apsweb.bean.Usuario;
import br.com.apsweb.dao.UsuarioDAO;

public class ListaUsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
        @Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response)
			throws IOException, ServletException {
		
		//Esse servlet retorna uma lista com todos os Usuarios/Senhas cadastrado
		//Print para testes
    	System.out.println("Buscando C");
		
		List<Usuario> usuarioLista = new ArrayList<Usuario>();
		// grave nessa conexão!!!
		UsuarioDAO dao = new UsuarioDAO();
		usuarioLista = dao.listar();
		request.setAttribute("usuarioLista", usuarioLista);
		RequestDispatcher rd = request.getRequestDispatcher("listaBusca.jsp");
		rd.forward(request,response);
      
	}

}