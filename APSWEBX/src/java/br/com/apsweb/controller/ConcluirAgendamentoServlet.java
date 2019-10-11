package br.com.apsweb.controller;

import br.com.apsweb.bean.Agendamento;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.apsweb.dao.AgendamentoDAO;
import java.util.ArrayList;
import java.util.List;

public class ConcluirAgendamentoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

        @Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
	
    	//Print para testes
    	System.out.println("Concluindo Agendamento");
    	boolean confirma = false;
    	System.out.println(request.getParameter("cod"));
    	int codigo = (Integer.parseInt(request.getParameter("cod")));
    	AgendamentoDAO concluirDao = new AgendamentoDAO();
	confirma=concluirDao.concluir(codigo);
	
        List<Agendamento> agendamentoLista = new ArrayList<Agendamento>();
	// grave nessa conexão!!!
	AgendamentoDAO dao = new AgendamentoDAO();
	agendamentoLista = dao.listar();
	request.setAttribute("agendamentoLista", agendamentoLista);
	RequestDispatcher rd = request.getRequestDispatcher("lista.jsp");
	rd.forward(request,response);
        }
	
}


	