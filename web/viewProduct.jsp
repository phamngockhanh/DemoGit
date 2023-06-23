<%-- 
    Document   : updateFilm
    Created on : Mar 4, 2023, 12:32:13 PM
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
                    <form action="" method="post" enctype="multipart/form-data">
                        <div class="p-3 py-5">
                            <div class="d-flex justify-content-between align-items-center mb-3">
                                <h4 class="text-right">Product</h4>
                            </div>
                            <div class="row mt-3">
                                <div class="col-md-12">
                                    <label class="labels">ProductID</label>
                                    <input type="text" readonly class="form-control" 
                                           placeholder="ID" value="${product.productId}" name="productId">
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">Name</label>
                                    <input type="text" readonly class="form-control" 
                                           placeholder="Product name" value="${product.productName}" name="name">
                                </div>
                                <div class="col-md-12"><label class="labels">Price</label>
                                    <input type="number" readonly class="form-control"
                                           placeholder="Price" value="${product.price}" name="price" min="0">
                                </div>
                                <div class="col-md-12"><label class="labels">Image</label>
                                    <div class="text-center">
                                        <img src="View/image/${product.image}" style="width: 100%; height: auto" class="rounded" alt="...">
                                    </div>
                                </div>
                                <div class="col-md-12"><label class="labels">Category</label>
                                    <input type="text" readonly class="form-control" 
                                           placeholder="category" value="${product.category.categoryName}" name="category">
                                </div>

                                <div class="col-md-12">
                                    <label class="labels">Description</label>
                                    <textarea class="form-control" readonly name="description" rows="5" wrap="hard">${product.descript}</textarea>
                                </div>
                              
                            </div>
                            <div class="mt-5 text-center">
                                <a class="btn btn-primary" href="updateProductController?productId=${product.productId}">
                                    Update
                                </a>

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
