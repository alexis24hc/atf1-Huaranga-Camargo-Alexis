<%@page import="java.util.List" %>
<%@page import="proyecto.model.Asignatura" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cursos de programación</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Cursos Pro</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="cursoController?accion=listar">Cursos</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Servicios</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Contactos</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
			<%
				Asignatura curso=(Asignatura)request.getSession().getAttribute("asignatura");
			%>
<section class="container">
	<h1 class="text-center">Actualizar asignatura</h1>
	<form action="cursoController?accion=actualizar" method="post">
		<div class="form-group">
			<div>
				<label for="codigo">Código</label>
				<input type="text" class="form-control" id="codigo" name="codigo" value="<%=curso.getCodigo()%>" readonly>
				<input type="hidden" class="form-control" id="codigo" name="codigo" value="<%=curso.getCodigo()%>">
			</div>
			<div>
				<label for="nombre">Nombre</label>
				<input type="text" class="form-control" id="nombre" name="nombre" value="<%=curso.getNombre()%>" >
			</div>
			<div>
				<label for="horas">Horas</label>
				<input type="number" class="form-control" id="horas" name="horas" value="<%=curso.getHoras()%>">
			</div>
			<div>
				<label for="tipo">Tipo de curso</label>
				<input type="text" class="form-control" id="tipo" name="tipo" value="<%=curso.getTipo()%>">
			</div>
			<div>
				<label for="creditos">Créditos</label>
				<input type="number" class="form-control" id="creditos" name="creditos" value="<%=curso.getCreditos()%>">
			</div>
			<div>
				<input type="submit" class="btn btn-primary" value="Actualizar">
			</div>
		</div>
	</form>
</section>
</body>
</html>