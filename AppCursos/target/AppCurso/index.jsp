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
<section>
	<h1 class="text-center">Cursos para programadores</h1>
	<p class="text-center">Programas de especialización para desarrollo de aplicaciones</p>
	<div class="text-center">
		<img alt="" src="https://tecnologia-innovadora.com/wp-content/uploads/2022/02/que-hacer-para-convertirse-en-ingeniero-en-sistemas-desarrollador-de-sistemas-computacionales-programacion-informatica.gif">
	</div>
</section>
</body>
</html>