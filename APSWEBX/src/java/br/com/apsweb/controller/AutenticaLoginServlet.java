package br.com.apsweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.apsweb.bean.Usuario;
import br.com.apsweb.dao.UsuarioDAO;
import javax.servlet.http.HttpSession;


public class AutenticaLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

        @Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
	
    	//Print para testes
    	System.out.println("Autenticando");

    	//Cria um objeto usuario e seta os valor recebidos 
    	//de acordo com o form enviado pela pagina login.jsp
    	Usuario usuario= new Usuario();
		usuario.setUsername(request.getParameter("username"));
		usuario.setSenha(request.getParameter("senha"));
		
		UsuarioDAO udao = new UsuarioDAO();
		Usuario usuarioVerificado = new Usuario();
		usuarioVerificado = udao.login(usuario);
		if (usuarioVerificado != null) {
                    HttpSession sessao = request.getSession();
                    sessao.setAttribute("sessaoUsuario", usuarioVerificado.getUsername());
                    sessao.setAttribute("sessaoNivel", usuarioVerificado.getNivel());
                    System.out.println(usuarioVerificado.getUsername());
                    RequestDispatcher rd = request.getRequestDispatcher("novo_agendamento.jsp");
                    rd.forward(request,response);
		}else {
                    request.setAttribute("mensagem", "Usuário/Senha Inválido");
                    request.setAttribute("naoLogado", true);
                    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                    rd.forward(request,response);
		}
	}

}