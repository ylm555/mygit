<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
 <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>无标题文档</title>
</head>

<body>
 <form action="saveRole_Rights.do" name="userForm" method="post" >
  		<input type="hidden" name="roleId" value="${role.id }" >
		<table width="80%" border="0" cellspacing="2" height="708" align="center" style="font-size:13px" >
		<tr><td height="48"><br>
		  <h3>分配权限</h3></td></tr>
			<tr>
				<th height="39" bgcolor="d3eaef" class="STYLE10">角色名</th>
				<td bgcolor="f6f6fd"  class="STYLE19">
					${role.rolename }
					<span id="exts" style="color:red"></span>			  </td>
				
					<th  bgcolor="d3eaef" class="STYLE10">状态</th>
				    <td bgcolor="f6f6fd" >
					${role.state==0?'正常':'已删除' }</td>
			</tr>
			<tr>
				<th bgcolor="d3eaef" class="STYLE10">权限</th>
				<td colspan="5" bgcolor="f6f6fd"  class="STYLE19">
						<c:forEach var="rights" items="${rightsList }">
						<div>
							&nbsp;&nbsp;&nbsp;
							${rights.rightsname }
							<input name="rightsId"   
							 type="checkbox" value="${rights.id }" onclick="selectAll('1')">						
					</div>	
					<c:forEach var="secondRights" items="${rights.subRightsList }">
					<div>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							${secondRights.rightsname }
							<input name="rightsId"   
							 type="checkbox" value="${secondRights.id }" onclick="selectAll('1')">						
					</div>
					<c:forEach var="thirdRights" items="${secondRights.subRightsList }">
					<div>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							${thirdRights.rightsname }
							<input name="rightsId"   
							 type="checkbox" value="${thirdRights.id }" onclick="selectAll('1')">						
					</div>
					</c:forEach>
					</c:forEach>
					</c:forEach>
				 
					
					
</td>
			</tr>
			<tr><td colspan="6"><div class="button_bar" style="text-align:right">
			<button type="submit" class="common_button" id="sav">保    存</button>
		</div></td></tr>
   </table>
		
</form>	

</body>
</html>
