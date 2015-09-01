<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
List<String> titles = new ArrayList<String>();
List<String> images = new ArrayList<String>();

for(int i = 1; i < 11; i++) {
	titles.add("title: " + i);
	images.add("miniroombg" + i + ".gif");
}

int adNo = new Random().nextInt(10);
%>
<div style="">
	<span style="display: block; height: 30px;"><%=titles.get(adNo) %></span>
	<img style="width:100%; height: 150px;" src="../common/images/miniroombg/<%=images.get(adNo)%>"/>
</div>