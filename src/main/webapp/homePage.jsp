<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 4/9/21
  Time: 7:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gigmate home</title>
</head>
<body>
    <h2>Welcome to Gigmate!</h2>
    <div id="bands">
        <table>
            <thead>
                <th>Name</th>
                <th>Location</th>
                <th>Genera</th>
            </thead>
            <tbody>
                <c:forEach var="band" items="${bands}">
                    <tr>
                        <td>${band.name}</td>
                        <td>${band.location}</td>
                        <td>${band.genera}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <div id="venues">
        <table>
            <thead>
            <th>Name</th>
            <th>Location</th>
            <th>Stage Type</th>
            </thead>
            <tbody>
            <c:forEach var="venue" items="${venues}">
                <tr>
                    <td>${venue.name}</td>
                    <td>${venue.location}</td>
                    <td>${venue.stageType}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
