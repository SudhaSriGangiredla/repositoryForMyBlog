<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>HelloWorld page</title>
    <script type="text/javascript" src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script type="text/javascript">
    function beautify(tagName) {
		var val = $('textarea[name=' + tagName + ']').val();
		var jsonobj = JSON.parse(val);
		var x = JSON.stringify(jsonobj, null, 4); // Indented 4 spaces
		x = JSON.stringify(jsonobj, null, "\t");
		$('textarea[name=' + tagName + ']').val(x);
	}
    </script>
</head>
<body>
    <form:form action="restTester" method="post" name="inputBean" commandName="inputBean">
	    <table>
	    	<tr><td><input type="text"  name="url" size="100" value="${inputBean.url}"/></td></tr>
	    	<tr><td>
	    		<form:radiobutton path="requestMethod" value="GET" />GET 
	    		<form:radiobutton path="requestMethod" value="POST" />POST
	    		<form:radiobutton path="requestMethod" value="DELETE" />DELETE
	    		<form:radiobutton path="requestMethod" value="PUT" />PUT
			</td></tr>
			<tr>
				<td><textarea  name="jsonInput" cols="100" rows="10">${inputBean.jsonInput}</textarea></td>
				<td><input type="button" id="iButton" value="Beautify" onclick="beautify('jsonInput');"></td>
			</tr>
	    	<tr>
	    		<td><textarea  name="jsonOutput" cols="100" rows="10">${inputBean.jsonOutput}</textarea></td>
	    		<td><input type="button" id="oButton" value="Beautify" onclick="beautify('jsonOutput');"></td>
	    	</tr>
	    	<tr><td><input type="submit" value="Submit"></td></tr>
	    </table>
    </form:form>
    
    <br><br>
    <a href="jsonTester">Json Tester</a> </br>
    <a href="restTester">Webservice Tester</a>
</body>
</html>
