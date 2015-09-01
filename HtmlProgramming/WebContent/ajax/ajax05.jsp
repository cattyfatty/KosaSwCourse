<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	String id = request.getParameter("mid");
	String pw = request.getParameter("mpw");
	
	if(id.equals("fall")) {
		if(pw.equals("12345")) {%>
			success
		<%
		} else {%>
			wrong_pw
<%
		}
	} else {
%>
		wrong_id
<%	
	}
%>