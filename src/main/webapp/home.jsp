<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.Collections" %>
    <%@ page import="java.util.Collection" %>
    <%@ page import="org.springframework.security.core.GrantedAuthority" %>
    <%@ page import="org.springframework.security.core.authority.SimpleGrantedAuthority" %>
    <%@ page import="org.springframework.security.core.userdetails.UserDetails" %>
    <%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 Welcome Aliens...
 
 <%
	@SuppressWarnings("unchecked")
 Collection<? extends GrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
 
 %>
 
 <%=
 authorities
 %>

</body>
</html>