<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Super Market</title>
</head>
<body>

<h1>Super Market</h1>
<p>Vijesh 	Jabez</p>
${name}

<form action="/saveData">

   	<label>input name:</label>
   <input type="text" name="name"><br>
  	<label>input address:</label>
   <input type="text" name="address"><br>
   <input type= "submit" value="save">
  	</form>

</body>
</html>