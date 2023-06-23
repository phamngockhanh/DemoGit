
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="setupCss.jsp" %>
    </head>
    <body>
        <!--Header-->
        <%@include file="header.jsp" %>
        <!--Header-->


        <!-- food section -->
        <section class="bg-light">
            <div class="container pb-5">
                <div class="row">
                    <div class="col-lg-5 mt-5">
                        <div class="card mb-3">
                            <img class="card-img img-fluid" 
                                 src="View/image/${requestScope.product.image}" alt="Card image cap"
                                 style="height: 500px; width: auto"
                                 id="product-detail">
                        </div>
                        <div class="row">
                            <!--Start Carousel Wrapper-->

                            <!--End Carousel Wrapper-->

                        </div>
                    </div>
                    <!-- col end -->
                    <div class="col-lg-7 mt-5" >
                        <div class="card" style="height: 500px">
                            <div class="card-body">
                                <h1 class="h2">${requestScope.product.productName}</h1><br><br>
                                <ul class="list-inline">
                                    <li class="list-inline-item">
                                        <h6>Category:</h6>
                                    </li>
                                    <li class="list-inline-item">
                                        <p class="text-muted">
                                            <strong>${requestScope.product.category.categoryName}</strong>
                                        </p>
                                    </li>
                                </ul>
                                <ul class="list-inline">
                                    <li class="list-inline-item">
                                        <h6>Price:</h6>
                                    </li>
                                    <li class="list-inline-item">
                                        <p class="text-muted">
                                            <strong>${requestScope.product.price}</strong>
                                        </p>
                                    </li>
                                </ul>

                                <h6>Description:</h6>
                                <p>${requestScope.product.descript}</p>
                                <ul class="list-inline">                                
                                </ul> 
                                <form class="mt-5" action="buyController" method="post">
                                    <div class="row pb-3">
                                        <div class="col d-grid">
                                            <div class="col-md-12"><label class="labels">Quantity</label>
                                                <input type="number" required class="form-control"
                                                       name="num" value="1" min="0" max="20" >
                                            </div>
                                            <input hidden type="text" value="${requestScope.product.productId}" name="productId"/>
                                            <c:if test="${sessionScope.id != null}">
                                                <button type="submit" class="btn btn-success btn-lg">
                                                    Order
                                                </button>
                                            </c:if>
                                            <c:if test="${sessionScope.id == null}">
                                                <a href="loginController" class="btn btn-success btn-lg">
                                                    Login to order
                                                </a>
                                            </c:if>
                                        </div>
                                    </div>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <script type="text/javascript">
            function buy(id) {
                var m = document.f.num.value;
                document.f.action = "buy?id=" + id + "&num=" + m;
                document.f.submit();
            }
        </script>   

        <!-- end food section -->

        <%@include  file="footer.jsp"%>

    </body>
</html>
