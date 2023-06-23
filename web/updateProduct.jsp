<%-- 
    Document   : updateFilm
    Created on : Mar 2, 2023, 12:32:13 PM
    Author     : Asus
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>

        <!-- bootstrap core css -->
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    </head>

    <body>
        <%@include file="admin_header.jsp"%>
        <!-- Section: Design Block -->
        <div class="container rounded bg-white mt-5 mb-5">
            <div class="row d-flex justify-content-center">
                <div class="col-md-6 border">
                    <form action="updateProductController" method="post" enctype="multipart/form-data">
                        <div class="p-3 py-5">
                            <div class="d-flex justify-content-between align-items-center mb-3">
                                <h4 class="text-right">Update Product</h4>
                            </div>
                            <div class="row mt-3">
                                <div class="col-md-12">
                                    <label class="labels">Product ID</label>
                                    <input type="text" readonly class="form-control" 
                                           placeholder="title" value="${product.productId}" name="productId">
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">Product name</label>
                                    <input type="text" required class="form-control" 
                                           placeholder="title" value="${product.productName}" name="productName">
                                </div>
                                <div class="col-md-12"><label class="labels">Price</label>
                                    <input type="number" required class="form-control"
                                           placeholder="Price" value="${product.price}" name="price" min="0">
                                </div>
                                <div class="col-md-12"><label class="labels">Thumbnail</label>
                                    <input type="file" class="form-control" 
                                           placeholder="Choose File"  name="file">
                                </div>

                                <div class="col-md-12"><label class="labels">Category</label>
                                    <select name="category" class="form-control">
                                        <c:forEach items="${requestScope.category}" var="g">
                                            <option value="${g.categoryId}" <c:if test="${product.category.categoryId == g.categoryId}">selected</c:if> >${g.categoryName} </option>
                                        </c:forEach>
                                    </select>
                                </div>
                                
                                <div class="col-md-12">
                                    <label class="labels">Status</label>
                                    <select name="status" class="form-control">
                                        <option value = "1" 
                                                <c:if test="${requestScope.productStatus}">
                                                    selected
                                                </c:if>>
                                            True
                                        </option>
                                        <option value = "0" 
                                                <c:if test="${!requestScope.productStatus}">
                                                    selected
                                                </c:if>>
                                            False
                                        </option>
                                    </select>
                                </div>

                                <div class="col-md-12">
                                    <label class="labels">Description</label>
                                    <textarea class="form-control" required name="descript" rows="5" wrap="hard">${product.descript}</textarea>
                                </div>
<!--                                <div class="col-md-12"><label class="labels">Slide</label>
                                    <input type="file" class="form-control" placeholder="Choose File" name="slide">
                                </div>-->
                            </div>
                            <div class="mt-5 text-center">
                                <button class="btn btn-primary profile-button" type="submit">Save Change</button>
                            </div>
                        </div>
                    </form>

                </div>

            </div>
        </div>
        <%@include file="admin_footer.jsp" %>
        <!-- Section: Design Block -->
    </body>

</html>
