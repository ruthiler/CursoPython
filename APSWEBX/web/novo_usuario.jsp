<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/tbmenu.css">
<link rel="stylesheet" href="css/novo_agendamento.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Novo Usuario</title>
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
                        <h1> Digite os dados para cadastrar um novo usuario</h1>
                </div>
            <form class="form" action="CadastroUsuarioServlet">
                <fieldset class="total">
                    
                    <fieldset class="grupo">    
                        
                        <div class="campo">
                            <label>Novo Usuario:</label><br>
                            <input name="username" type="text" required="required" placeholder="Novo Usuario"/>
                        </div>
                        <div class="campo">
                            <label>Senha:</label><br>
                            <input name="senha" type="text"required="required" placeholder="Senha"/>
                        </div>
                        
                         <div class="administrador">
                            <input type="radio" value="1" name="nivel" id="campo-radio1" />
                            <label for="campo-radio1">Administrador</label>
                            <input type="radio" value="0" name="nivel" id="campo-radio2" />
                            <label for="campo-radio2">Usuario Comum</label>
                        </div>

                    </fieldset>
                    <fieldset class="grupo">
                        <div class="campobotao">
                            <button>Cadastrar Usuario</button>
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
