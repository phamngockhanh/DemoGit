<%-- 
    Document   : newjsp
    Created on : Jun 9, 2023, 10:26:59 PM
    Author     : Aver
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="setupCss.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <button  type="submit" class="btn btn-success btn-lg"
                 data-bs-toggle="modal" data-bs-target="#exampleModal${f.productId}">
            Order
        </button>


        <div class="modal fade" id="exampleModal${f.productId}" tabindex="-1"
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
                        Are you sure to delete this product?
                    </div>
                    <div class="modal-footer">
                        <form action="manageProductControll" method="post">
                            <input hidden type="search" value="${f.productId}" name="productId" hidden>
                            <button type="submit" class="btn btn-primary">Yes</button>
                            <button type="button" class="btn btn-secondary"
                                    data-bs-dismiss="modal">No</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
