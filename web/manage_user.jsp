<%-- 
    Document   : managa_product
    Created on : Mar 1, 2023 9:17:24 PM
    Author     : Asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id ="a" class="Model.Product" scope ="request"></jsp:useBean>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Manage User</title>

            <!-- bootstrap core css -->
            <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
                  integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        </head>
        <body>
        <%@include file="admin_header.jsp" %>
        <!-- Section: Design Block -->
        <section class="py-1">
            <!-- style="background-color: white"-->
            <div class="container d-flex " style="min-height: 800px;">

                <div class="col-md-12">
                    <h3 class="mt-5">Manage user</h3>
                    <c:set var="page" value="${param.page}" scope="session"/>
                    <c:if test="${page<=0}">
                        <c:set var="page" value="1" scope="session"/>
                    </c:if>
                    <c:if test="${page==null}">
                        <c:set var="page" value="1" scope="session"/>
                    </c:if>
                    <c:if test="${not empty page}">
                        <c:set var="page" value="${page}" scope="session"/>
                    </c:if>
                    <c:if test="${page>=49}">
                        <c:set var="page" value="${49}" scope="session"/>
                    </c:if>        
                    <table class="table col-3 table-bordered" style="height: 100px">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Name</th>
                                <th scope="col">Gender</th>
                                <th scope="col">Phone</th>
                                <th scope="col">Address</th>
                                <th scope="col">Role</th>
                                <th scope="col">Edit</th>
                                <th scope="col">Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${user}" var="f">
                                <tr style="height: 60px">
                                    <th scope="row">${f.id}</th>
                                    <th scope="row">${f.fullname}</a></th>
                                    <th scope="row">
                                        <c:if test="${f.gender}">Male</c:if>
                                        <c:if test="${!f.gender}">Female</c:if>
                                        </th>
                                        <th scope="row">${f.phone}</th>
                                    <th scope="row">${f.address}</th>
                                    <th scope="row">${f.role}</th>
                            <th scope="row">
                                <a style="margin-left: 10px" href="updateUserController?id=${f.id}"><i class="fa fa-solid fa-pencil"></i></a>
                            </th>
                            <th scope="row">
                                <button class="btn btn-link" type="button" class="btn btn-primary"
                                        data-bs-toggle="modal" data-bs-target="#exampleModal${f.id}"><i
                                        class="fa fa-solid fa-trash mb-1"></i>
                                </button>
                            </th>

                            </tr>

                            <div class="modal fade" id="exampleModal${f.id}" tabindex="-1"
                                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel"><i class="bi bi-trash-fill"></i>
                                                Delete</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                    aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            Are you sure to delete this user?
                                        </div>
                                        <div class="modal-footer">
                                            <form action="managerUserControll" method="post">
                                                <input hidden type="search" value="${f.id}" name="id" hidden>
                                                <button type="submit" class="btn btn-primary">Yes</button>
                                                <button type="button" class="btn btn-secondary"
                                                        data-bs-dismiss="modal">No</button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </c:forEach>                      
                        </tbody>
                    </table>
                    <div class="d-flex justify-content-center">
                        <nav aria-label="Page navigation example">
                            <ul class="pagination">
                                <c:forEach begin="1" end="${requestScope.total}" step="1" var="i">
                                    <li class="page-item <c:if test="${i == requestScope.page}"> active </c:if> " >
                                        <a class="page-link" href="managerUserControll?page=${i}&fullname=${fullname}&id=${id}">
                                            ${i}
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </nav>
                    </div>
                </div>

            </div>
        </section>
        <%@include file="admin_footer.jsp" %>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Section: Design Block -->
    </body>

</html>
