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
   
</div>
</body>
</html>