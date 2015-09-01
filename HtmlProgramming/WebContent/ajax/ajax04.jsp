<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%String method = request.getMethod();%>

<%if(method.equals("GET")) {%>

<h4>GET request</h4>
<img src="../common/images/avata/2seirek_8.gif"/>

<%} else if(method.equals("POST")) {%>
<h4>POST request</h4>
<img src="../common/images/avata/2seirek_5.gif"/>
<%} %>