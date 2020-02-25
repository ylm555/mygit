<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
 <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">utf-8" />
<title>无标题文档</title>
</head>

<body>
 <form name="userForm" method="post" >
  		
		<table width="80%" border="0" cellspacing="2" height="166" align="center" style="font-size:13px" >
		<tr><td height="48"><br>
		  <h3>编辑用户</h3></td></tr>
			<tr>
				<th bgcolor="d3eaef" class="STYLE10">用户名</th>
				<td bgcolor="f6f6fd"  class="STYLE19">
					<input type="text" name="users.usrName" value="admin" >
					<span id="exts" style="color:red"></span>
			  </td>
				<th  bgcolor="d3eaef" class="STYLE10">密码</th>
				<td bgcolor="f6f6fd" >
					<input type="password" name="users.usrPassword" value="***" >			
			  </td>
			</tr>
			<tr>
				<th bgcolor="d3eaef" class="STYLE10">角色</th>
				<td bgcolor="f6f6fd"  class="STYLE19">
					<select><option>经理</option></select>				</td>
				<th bgcolor="d3eaef" class="STYLE10">状态</th>
				<td bgcolor="f6f6fd"  >
					正常
					  <input type="hidden" name="users.usrFlag" value="1">
			  </td>
			</tr>
			<tr><td colspan="4"><div class="button_bar" style="text-align:right">
			<button type="submit" class="common_button" id="sav">保    存</button>
		</div></td></tr>
   </table>
		
</form>	

</body>
</html>
