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

import br.com.apsweb.bean.Agendamento;
import br.com.apsweb.dao.AgendamentoDAO;

public class BuscaNomeAgendamentoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
        @Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

	
    	//Print para testes
    	System.out.println("Pesquisando Agendamento por nome");
    	System.out.println(request.getParameter("busca"));
    	  	
        String nomeBusca = request.getParameter("busca");
    	List<Agendamento> pesquisaNome = new ArrayList<Agendamento>();
		// grave nessa conexão!!!
		AgendamentoDAO pesquisaNomeDao = new AgendamentoDAO();
		pesquisaNome = pesquisaNomeDao.buscarNome(nomeBusca);
		if(pesquisaNome != null) {
			request.setAttribute("agendamentoLista", pesquisaNome);
			RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
			rd.forward(request,response);
		} else {
			request.setAttribute("mensagem", "A busca nao encontrou nenhum resultado");
			RequestDispatcher rd = request.getRequestDispatcher("pesquisa.jsp");
			rd.forward(request,response);
		}
	}

}












