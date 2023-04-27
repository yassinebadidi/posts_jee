<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>The Blog | Post List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>

<c:import url="header.jsp"></c:import>

<div class="container">
    <h1>Posts</h1>

    <div class="row row-cols-1 row-cols-md-2 row-cols-lg-4 g-3 align-content-center">
        <c:forEach var="p" items="${posts}">
            <div class="col">
                <div class="card">
                    <img src="${p.pictureUrl}" class="card-img-top" alt="${p.title}">
                    <div class="card-body">
                        <h5 class="card-title">${p.title}</h5>
                        <p class="card-text">${p.content}</p>
                        <fmt:parseDate value="${p.createdAt}" pattern="yyyy-MM-dd'T'HH:mm" var="postDate" type="date"/>
                        <p class="card-text"><fmt:formatDate pattern="dd MMMM yyyy hh:mm" value="${postDate}"/></p>
                        <p class="card-text">${p.category.name}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>


</body>
</html>
