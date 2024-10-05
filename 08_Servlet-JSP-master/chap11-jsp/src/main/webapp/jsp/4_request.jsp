<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>request</title>
</head>
<body>
    <h1>==== 주문하기 ====</h1>
    <form action="<%= request.getContextPath() %>/menu/order" method="post">
        <select id="menu" name="menuName">
            <option value="hamburger">햄버거</option>
            <option value="blacknoodle">짜장면</option>
            <option value="rednoodle">불닭볶음면</option>
            <option value="gukbab">순대국밥</option>
        </select>
        <input type="number" min="0" maxlength="100" step="1" name="amount">
        <button type="submit">선택 완료 및 주문</button>
    </form>

</body>
</html>
