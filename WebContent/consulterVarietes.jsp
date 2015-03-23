<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="fr.noixcoop.nuceus.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	MetierVarietes metier = new MetierVarietes();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="style/bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
<title>Nuceus 0.1</title>
</head>
<body>

	<h1 class="form-signing-heading">Liste des variétés de Noix</h1>
	<hr>
	<%
		List<Variete> varietes = metier.consulter();
		String aoc = "";
	%>
	<table style="border-collapse:collapse" class="table table-striped">
		<thead>
			<tr>
				<th>Libellé</th>
				<th>AOC</th>
			</tr>
		</thead>
		<tbody>
			<%
				for(Variete variete : varietes){
			%>
			<tr>
				<td><%= variete.getLibelle() %></td>
				<% 
				boolean varieteBool = variete.isAoc();
				if(varieteBool)
					{ 
						aoc = "Oui";
					}
				else{ 
						aoc = "Non";
					}
				%>
				<td><%= aoc %></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>