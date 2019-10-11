package br.com.apsweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.apsweb.dao.AgendamentoDAO;

public class ExcluirAgendamentoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

        @Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
	
    	//Print para testes
    	System.out.println("Excluindo Agendamento");
    	boolean confirma = false;
    	int codigo = (Integer.parseInt(request.getParameter("cod")));
    	AgendamentoDAO excluirDao = new AgendamentoDAO();
	confirma=excluirDao.remover(codigo);
        
        request.setAttribute("mensagem", "Agendamento excluido com sucesso!");
	RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
	rd.forward(request,response);
		
		
	}

}


	