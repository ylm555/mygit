<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>无标题文档</title>
<script type="text/javascript" src="js/jquery.js"></script>
</head>

<body>
 <form name="userForm" method="post" >
  		
		<table width="80%" border="0" cellspacing="2" height="166" align="center" style="font-size:13px" >
		<tr><td height="48"><br>
		  <h3>分配角色</h3></td></tr>
			<tr>
				<th bgcolor="d3eaef" class="STYLE10">用户名</th>
				<td bgcolor="f6f6fd"  class="STYLE19">
					${user.username }
					<span id="exts" style="color:red"></span>
			  </td>
				<th  bgcolor="d3eaef" class="STYLE10">密码</th>
				<td bgcolor="f6f6fd" >
					${user.password }		
			  </td>
			</tr>
			<tr>
				<th bgcolor="d3eaef" class="STYLE10">角色</th>
				<td bgcolor="f6f6fd"  class="STYLE19">
					<select id="roleId">
					<c:forEach items="${roleList}" var="role">
					<option value="${role.id }">${role.rolename }</option>
					 </c:forEach>
					</select>			</td>
				<th bgcolor="d3eaef" class="STYLE10">状态</th>
				<td bgcolor="f6f6fd"  >
					${user.state==0?'正常':'已删除' }
					  <input type="hidden" name="users.usrFlag" value="1">
			  </td>
			 
			</tr>
			<tr><td colspan="4"><div class="button_bar" style="text-align:right">
			<button type="button" onclick="updateUserRole(${user.id})" class="common_button" id="sav">保    存</button>
		</div></td></tr>
   </table>
		
</form>	
<script type="text/javascript">
 function updateUserRole(id){
	 var roleId =$("#roleId").val();
	 alert(roleId);
	 $.ajax({
		 type:"post",
		 url:"updateUserRole.do",
		 data:{"id":id,"roleId":roleId},
		 success:function(msg){
			 alert(msg);
		 }
		 
	 })
 }
</script>

</body>
</html>
