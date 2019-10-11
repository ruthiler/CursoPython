package br.com.apsweb.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.apsweb.bean.Agendamento;
import br.com.apsweb.dao.AgendamentoDAO;

public class ListaAgendamentosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
        protected void service(HttpServletRequest request,
			HttpServletResponse response)
			throws IOException, ServletException {
		
		//Esse servlet retorna uma lista com todos os Agendamentos cadastrado
		//Print para testes
    		System.out.println("Buscando Agendamentos");
		
		List<Agendamento> agendamentoLista = new ArrayList<Agendamento>();
		// grave nessa conexão!!!
		AgendamentoDAO dao = new AgendamentoDAO();
		agendamentoLista = dao.listar();
		request.setAttribute("agendamentoLista", agendamentoLista);
		RequestDispatcher rd = request.getRequestDispatcher("lista.jsp");
		rd.forward(request,response);
      
	}

}