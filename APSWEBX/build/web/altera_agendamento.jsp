<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/tbmenu.css">
<link rel="stylesheet" href="css/novo_agendamento.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Novo Agendamento</title>
</head>
<body>
    <div id="todo-site">
    <div id="menu" class="box-principal">
        <table class="tabelamenu" border="1">
            <caption><h1>Menu Principal</h1></caption>
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
            
    <div class="box-principal">
                <div >
                        <h1> Digite os dados do cliente para realizar um no Agendamento</h1>
                </div>
            <form class="form" action="AlterarAgendamentoServlet">
                <fieldset class="total">
                	<fieldset class="grupo">
                		<div class="campo">
                        	<input name="cod" type="text" value="${param.cod}"/>
                            
                        </div>
                	</fieldset>
                    <fieldset class="grupo">    
                        <div class="campo">
                        	<label>Nome:</label><br>
                            <input name ="nome" size="43px" type="text" required="required" 
                            	placeholder="Nome Completo" value="${param.nome}"/>
                        </div>
                        <div class="campo">
                            <label>Telefone:</label><br>
                            <input name="telefone" size="11" type="text" maxlength="11" required="required"
                            	placeholder="(XX) X XXXX-XXXX" value="${param.telefone}"/>
                        </div>
                        <div class="campo">
                            <label>Veiculo:</label><br>
                            <input name="veiculo" type="text" maxlength="25" required="required" 
                            	placeholder="Veiculo" value="${param.veiculo}"/>
                        </div>
                        <div class="campo">
                            <label>Data Agendamento:</label><br>
                            <input name="data" size="5px"required="required" type="date"
                            	value="${param.data}"/>
                        </div>
                        <div class="grupo">
                            <label>Horário:</label><br>
                            <input name="hora" required="required" type="time" 
                            	value="${param.hora}"/>
                        </div>
                    </fieldset>
                    <fieldset class="grupo">
                        <div class="campobotao">
                            <button>Confirmar Alteracao</button>
                        </div>
                        <div class="campobotao">
					        ${mensagem}<br>
				        </div>
	                </fieldset>
                </fieldset>
            </form>

    </div>
    </div>
</body>
</html>
