<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Сервлет для вычислений</title>
</head>
<body>
<h3 align="center">
    <a href="${pageContext.servletContext.contextPath}/calc?x=2&y=3&op=plus">Сложить 2 и 3</a>
</h3>
<br>
<br>
<br>
<h3 align="center">
<a href="${pageContext.servletContext.contextPath}/calc?x=2&y=3&op=minus">Вычесть 3 из 2</a>
</h3>

<form method="POST" action="${pageContext.servletContext.contextPath}/calc_post" accept-charset="UTF-8">
    <div>
        <input name="number1" type="text" autofocus="true" />
        <input name="number2" type="text" />

        <h4>Please choose the operation for calculating</h4>
        <br>
        <select name="oper">
            <option value="no" hidden>Choose</option>
            <optgroup label="operation">
                <option value="minus">-</option>
                <option value="plus">+</option>
            </optgroup>
        </select>

        <div align="center">
            <button type="submit">Calculate</button>
        </div>
    </div>
</form>

<br>
<br>
<br>

<div align="center">
    <form method="POST" action="${contextPath}/vote">
        <h4>Please choose the your favorite sport and vote!</h4>

        <select name="by">
            <option value="no" hidden>Choose</option>
            <optgroup label="by_sport">
                <c:forEach items="${sport}" var="sp" varStatus="status">
                    <option value="${sp}">${sp}</option>
                </c:forEach>
            </optgroup>
        </select>
        <br>
        <div align="center">
            <button type="submit">Vote!</button>
        </div>
    </form>
</div>

</body>
</html>