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
<section class="container">
	<div>
		<a class="btn btn-primary" href="cursoController?accion=insertar">Nuevo Curso</a>
	</div>
	<h1 class="text-center">Cursos de programación</h1>
	<div class="table-responsive">
		<table class="table">
			<thead>
				<tr class="info">
					<th>Código</th>
					<th>Nombre</th>
					<th>Horas</th>
					<th>Tipo</th>
					<th>Creditos</th>
					<th colspan="2">Acción</th>
				</tr>
			<thead>
			<tbody>
				<!-- Recorrer la lista que proviene de controller -->
				<%
				List<Asignatura> listaCursos=(List)request.getSession().getAttribute("asignaturas");
				for(Asignatura asig: listaCursos){
				%>
				<tr>
					<td><%=asig.getCodigo()%></td>
					<td><%=asig.getNombre()%></td>
					<td><%=asig.getHoras()%></td>
					<td><%=asig.getTipo()%></td>
					<td><%=asig.getCreditos()%></td>
					<td><a class="btn btn-success" href="cursoController?accion=editar&codigo=<%=asig.getCodigo()%>">Editar</a></td>
					<td><a class="btn btn-danger" href="cursoController?accion=eliminar&codigo=<%=asig.getCodigo()%>">Eliminar</a></td>
				</tr>
				<%}%>
			</tbody>
		</table>
	</div>
</section>
</body>
</html>