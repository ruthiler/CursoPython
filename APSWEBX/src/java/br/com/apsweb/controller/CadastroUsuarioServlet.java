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

public class CadastroUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

        @Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
	
    	//Print para testes
    	System.out.println("Inserindo nova Usuario");

    	//Cria um objeto usuario e seta os valor recebidos 
    	//de acordo com o form enviado pela pagina login.jsp
    	Usuario novoUsuario= new Usuario();
	novoUsuario.setUsername(request.getParameter("username"));
	novoUsuario.setSenha(request.getParameter("senha"));
        novoUsuario.setNivel(Integer.parseInt(request.getParameter("nivel")));

        UsuarioDAO novoUsuarioDao = new UsuarioDAO();
        boolean verifica = novoUsuarioDao.verificaUsername(novoUsuario.getUsername());
        
        if (!verifica){
            novoUsuarioDao.inserir(novoUsuario);
            request.setAttribute("mensagem", "Novo usuario cadastrado com sucesso!");
            RequestDispatcher rd = request.getRequestDispatcher("novo_usuario.jsp");
            rd.forward(request,response);
           
        } else{
            request.setAttribute("mensagem", "ERRO NO CADASTRO, Escolha outro nome de usario");
            RequestDispatcher rd = request.getRequestDispatcher("novo_usuario.jsp");
            rd.forward(request,response);
        
        }
	
        
        
        
	}

}