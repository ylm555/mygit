<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
 <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>My JSP 'index.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
 
		<link rel="StyleSheet" href="css/dtree.css" type="text/css" />
		<script type="text/javascript" src="js/dtree.js">
</script>

		<script>
function check() {
	alert("��û��ָ��Ȩ��");
	return false;
}
</script>

	</head>

	<body>
 
		<div class="dtree" id="tree">
			<script type="text/javascript">

d = new dTree('d');


<c:forEach items="${rightsList}" var="rights">
d.add('${rights.id}', '${rights.parent_id}','${rights.rightsname}', '${rights.url}', '${rights.rightsname}', 'mainFrame', '',
		'', '', '0');
</c:forEach>


document.getElementById("tree").innerHTML = d;
</script>
		</div>



	</body>
</html>
