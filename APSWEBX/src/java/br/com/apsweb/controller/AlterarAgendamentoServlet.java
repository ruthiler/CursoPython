package br.com.apsweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.apsweb.bean.Agendamento;
import br.com.apsweb.dao.AgendamentoDAO;

public class AlterarAgendamentoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

        @Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
	
    	//Print para testes
    	System.out.println("Alterando Agendamento");
    	System.out.println(request.getParameter("cod"));
    	System.out.println(request.getParameter("nome"));
    	//Cria um objeto usuario e seta os valor recebidos 
    	//de acordo com o form enviado pela pagina login.jsp
    	Agendamento alteraAgendamento= new Agendamento();
    	alteraAgendamento.setCod(Integer.parseInt(request.getParameter("cod")));
		alteraAgendamento.setNome(request.getParameter("nome"));
		alteraAgendamento.setTelefone(request.getParameter("telefone"));
		alteraAgendamento.setVeiculo(request.getParameter("veiculo"));
		alteraAgendamento.setData(request.getParameter("data"));
		alteraAgendamento.setHora(request.getParameter("hora"));
		
		System.out.println(alteraAgendamento.getCod());
		System.out.println(alteraAgendamento.getNome());
		
		
		AgendamentoDAO novoAgendaDao = new AgendamentoDAO();
		boolean confirma = novoAgendaDao.alterar(alteraAgendamento);
		if (confirma) {
			request.setAttribute("mensagem", "Alterado com sucesso!");
			RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
			rd.forward(request,response);
		}else {
			request.setAttribute("mensagem", "Alteração não concluído, tente novamente!");
			request.setAttribute("param", alteraAgendamento);
			RequestDispatcher rd = request.getRequestDispatcher("altera_agendamento.jsp");
			rd.forward(request,response);
		}
	}

}