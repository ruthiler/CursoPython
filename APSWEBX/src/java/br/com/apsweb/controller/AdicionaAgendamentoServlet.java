package br.com.apsweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.apsweb.bean.Agendamento;
import br.com.apsweb.dao.AgendamentoDAO;

public class AdicionaAgendamentoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
	
    	//Print para testes
    	System.out.println("Inserindo nova Agendamento");

    	//Cria um objeto usuario e seta os valor recebidos 
    	//de acordo com o form enviado pela pagina login.jsp
    	Agendamento novoAgendamento= new Agendamento();
		novoAgendamento.setNome(request.getParameter("nome"));
		novoAgendamento.setTelefone(request.getParameter("telefone"));
		novoAgendamento.setVeiculo(request.getParameter("veiculo"));
		novoAgendamento.setData(request.getParameter("data"));
		novoAgendamento.setHora(request.getParameter("hora"));
		
		
		AgendamentoDAO novoAgendaDao = new AgendamentoDAO();
		boolean confirma = novoAgendaDao.inserir(novoAgendamento);
		if (confirma) {
			request.setAttribute("mensagem", "Agendamento inserido com sucesso!");
			RequestDispatcher rd = request.getRequestDispatcher("novo_agendamento.jsp");
			rd.forward(request,response);
		}else {
			request.setAttribute("mensagem", "Agendamento não concluído, tente novamente!");
			RequestDispatcher rd = request.getRequestDispatcher("novo_agendamento.jsp");
			rd.forward(request,response);
		}
	}

}