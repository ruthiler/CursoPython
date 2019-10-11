<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/tbmenu.css">
<link rel="stylesheet" href="css/pesquisa.css">
<link rel="stylesheet" href="css/tbresultado.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Agendamentos</title>
</head>
<body>
    <div id="todo-site">
     <div id="menu" class="box-principal">
        <table class="tabelamenu" border="1">
            <caption>Menu Principal</caption>
            <tr>
                <td><a href="novo_agendamento.jsp"><button >Novo Agendamento</button></a></td>
                <td><a href="ListaAgendamentosServlet"><button>Listar Agendamentos</button></a></td>
                <td><a href="pesquisa.jsp"><button>Pesquisar</button></td>
                <td><a href="SairServlet"><button>Sair</button></td>
            </tr>
            <c:if test="${sessaoNivel==1}">
                <tr>
                    <td colspan="4"><a href="novo_usuario.jsp"><button>Cadastrar Novo Usuario</button></td>
                </tr>
            </c:if>
            <tr>
            	<td colspan="4"><i>Logado como: ${sessaoUsuario}</i></td>
            </tr>
        </table>
    </div>
    <div id="corpo" class="box-principal">
        <table class="tabelaresult" >
            <caption>Lista com todos os Agendamentos</caption>
            <tr>
            <thead>
                <th>Cod.</th>
                <th>Nome Cliente</th>
                <th>Telefone</th>
                <th>Veiculo</th>
                <th>Data</th>
                <th>Hora</th>
                <th>Status</th>
                <th>Concluir</th>
                <th>Alterar</th>
                <th>Excluir</th>
            </thead>
            </tr>
            <c:forEach var="agendamentoLista" items="${agendamentoLista}"> 
                <tr>
                    <td class="cod" nowrap="false">${agendamentoLista.cod}</td>
                    <td class="nome" nowrap="false">${agendamentoLista.nome}</td>
                    <td class="telefone" nowrap="false">${agendamentoLista.telefone}</td>
                    <td class="veiculo" nowrap="false">${agendamentoLista.veiculo}</td>
                    <td class="data" nowrap="false">${agendamentoLista.data}</td>
                    <td class="hora" nowrap="false">${agendamentoLista.hora}</td>
                    <td calss="status">
                    <c:if test="${agendamentoLista.status==0}">
                    	Pendente
                    </c:if>
                    <c:if test="${agendamentoLista.status==1}">
                    	Concluido
                    </c:if>  
                   	</td>
                   	<td class="concluir">
                   	 <c:if test="${agendamentoLista.status==1}">
                    	<img src="imagens/icones_flat/concluido.png" border="0" title="Concluido" width=45 height=50>
                    </c:if>
                    <c:if test="${agendamentoLista.status==0}">
                    	<a href="ConcluirAgendamentoServlet?cod=${agendamentoLista.cod}">
                    	<img src="imagens/icones_flat/nao_concluido.png" border="0" 
                    		title="Clique para concluir"   width=45 height=50>
                    	</a>
                    </c:if>
                    </td>
                    <td class="editar">
                 		<c:if test="${agendamentoLista.status==1}">
                    		<img src="imagens/icones_flat/editar_disable.png" 
                    			title="Agendamento concluido, nao pode ser editado" border="0" width=35 height=40>
                    	</c:if>
                    	<c:if test="${agendamentoLista.status==0}">
                    		<a href="altera_agendamento.jsp?cod=${agendamentoLista.cod}&nome=${agendamentoLista.nome}
                    			&telefone=${agendamentoLista.telefone}&veiculo=${agendamentoLista.veiculo}
                    			&data=${agendamentoLista.data}&hora=${agendamentoLista.hora}">
	                    	<img src="imagens/icones_flat/editar_verde.png" title="Clique para editar"border="0" width=45 height=50>
	                    	</a>
        	            </c:if>
        	            
                    </td>
					<td class="delete">
						<c:if test="${agendamentoLista.status==1}">
                    		<img src="imagens/icones_flat/delete_disable.png" title="Agendamento concluido, nao pode ser apagado" border="0" width=35 height=35>
                    	</c:if>
                    	<c:if test="${agendamentoLista.status==0}">
                    		<a href="ExcluirAgendamentoServlet?cod=${agendamentoLista.cod}">
	                    	<img src="imagens/icones_flat/delete_vermelho.png" title="Clique para apagar" border="0" width=35 height=35>
	                    	</a>
        	            </c:if>
					</td>
               </tr>
            </c:forEach>
        </table>
    </div>
     
</div>
</body>
</html>