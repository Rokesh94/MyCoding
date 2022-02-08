<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
<style>
h1 {
	text-align: center;
}
</style>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
<%
	if(session.getAttribute("username")==null){
		response.sendRedirect("Login.jsp");
		
	}


%>
Welcome ${username}
	<div class="container">
		<div class="jumbotron">
			<div class="card">
				<div class="card-header">Employee Registration done!</div>
				<div class="card-body">

					<h5 class="card-title">Number of users available below:</h5>

					<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col">id</th>
								<th scope="col">First</th>
								<th scope="col">Last</th>
								<th scope="col">UserName</th>
								<th scope="col">Address</th>
								<th scope="col">Contact</th>
								<th scope="col">Action</th>
							</tr>
						</thead>
						<tbody>

							<%
							try {

								String url = "jdbc:mysql://localhost:3306/Employee";
								String user = "root";
								String pass = "Anuesh3120";

								String Sql = "Select * from empl";
								Class.forName("com.mysql.jdbc.Driver");
								Connection con = DriverManager.getConnection(url, user, pass);
								Statement stmt = con.createStatement();

								//PreparedStatement st= con.prepareStatement();
								ResultSet rs = stmt.executeQuery(Sql);
								while (rs.next()) {
							%>

							<tr>
							
								<td>
									<%
									out.println(rs.getInt("id"));
									%>
								</td>
								<td>
									<%
									out.println(rs.getString("FirstName"));
									%>
								</td>
								<td>
									<%
									out.println(rs.getString("LastName"));
									%>
								</td>
								<td>
									<%
									out.println(rs.getString("UserName"));
									%>
								</td>
								<td>
									<%
									out.println(rs.getString("Address"));
									%>
								</td>
								<td>
									<%
									out.println(rs.getInt("Contact"));
									%>
								</td>
								<td>
								<a href= "Edit.jsp" class= "btn btn-warning"
								
								<%
									out.println(rs.getInt("id"));
									%>
									
								>Edit</a>
									
								</td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
					<%


}
catch(Exception e)
{
e.printStackTrace();
}

%>

<form action="logout" method= "get">

<button class="btn btn-primary btn-lg btn-block" type="submit" value="logout">Logout</button>
</form>
				</div>

			</div>

		</div>

	</div>


</body>
</html>