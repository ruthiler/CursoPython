<link rel="stylesheet" type="text/css" href="css/login.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
</head>
<body>
<div class="login-page">
  <div class="box-login">
    <p class="titulo">APS Desenvolvimento WEB</p>
  </div>
  <div class="box-login">
    <p class="titulo">AGENDAMENTO DE CLIENTES</p>
    <p class="titulo">OFICINA SOFTCAR</p>
  </div>	
  <div class="form">
    <form class="login-form" action="AutenticaLoginServlet" method="post">
      <input type="text" autofocus required="required" placeholder="usuario" name="username"/>
   	  <input type="password" required="required" autocomplete="off" placeholder="senha" name="senha"/>
	  <button>Entrar</button>
      <c:if test="${naoLogado}">
    	<p class="message">${mensagem}</p>
      </c:if>
    </form>
  </div>
</div>
</body>
</html>

