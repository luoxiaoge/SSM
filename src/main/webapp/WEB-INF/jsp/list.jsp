<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>test Jsp</title>
</head>
<body>
    <c:out value="${list}" ></c:out>
     <table id="booktable" border="1"  style="border-collapse: collapse">
         <tr align="center">
             <td>ID</td>
             <td>booName</td>
             <td>Number</td>
         </tr>
       <c:forEach  items="${list}" var="item">
         <tr>
            <td>${item.bookId}</td>
             <td>${item.name}</td>
             <td>${item.number}</td>
         </tr>
         </c:forEach>
     </table>


</body>
</html>
