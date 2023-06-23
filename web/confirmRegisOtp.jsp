
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="setupCss.jsp" %>
        <style>
            .card-registration .select-input.form-control[readonly]:not([disabled]) {
                font-size: 1rem;
                line-height: 2.15;
                padding-left: .75em;
                padding-right: .75em;
            }

            .card-registration .select-arrow {
                top: 13px;
            }

            .formR{
                border-radius: 30px; 
            }

            .register{
                background-image: url("../View/image/image.jpg");
            }


        </style>
    </head>
    <body>
        <!--header-->
        <%@include file="header.jsp" %>
        <!--header-->

        <!-- Section: Design Block -->
        <section class="">
            <div class="container py-5 h-100 ">
                <div class="row d-flex justify-content-center align-items-center h-100" >
                    <div class="col-xl-3 d-none d-xl-block">

                    </div>
                    <div class="col-xl-6" style="padding: 15px;color: white !important;">
                        <form action="validateRegisController" method="post" >
                            <div class="card-body p-md-1 text-black">
                                <h2 class="mb-5 text-uppercase" >registration form</h2>

                                <div class="form-outline mb-4 mr-3">
                                    <label class="form-label"  for="form3Example8">Full Name</label>
                                    <input type="text" readonly id="form3Example8" class="form-control form-control-lg"
                                            placeholder="" name="name" value="${name}"/>
                                    
                                </div>

                                <div class="form-outline mb-4 mr-3">
                                    <label class="form-label" readonly for="form3Example8">Email</label>
                                    <input type="email" readonly id="form3Example8" class="form-control form-control-lg" 
                                            placeholder="" name="email" value="${email}"/>
                                    
                                </div>

                                <div class="row">
                                    <div class="col-md-6 mb-4 ">
                                        <label class="form-label" readonly for="form3Example1m1">Password</label>
                                        <div class="form-outline" style="width: 92%;">
                                            <input type="password" readonly id="form3Example1m1 "  placeholder=""
                                                   class="form-control form-control-lg"  name = "pass" value="${pass}"/>
                                            
                                        </div>
                                    </div>
                                    <div class="col-md-6 mb-4">
                                        <label class="form-label" readonly for="form3Example1n1">Confirm Password</label>
                                        <div class="form-outline" style="width: 92%;">
                                            <input type="password" readonly id="form3Example1n1"  placeholder=""
                                                   class="form-control form-control-lg" name = "repass" value="${repass}" />
                                            
                                        </div>
                                    </div>
                                </div>

                                <div class="form-outline mb-4  mr-3">
                                    <label class="form-label"  for="form3Example90">Phone</label>
                                    <input type="text" readonly id="form3Example90" class="form-control form-control-lg"
                                            placeholder="" pattern="(84|0[3|5|7|8|9])+([0-9]{8})\b" name="phone" value="${phone}" />
                                    
                                </div>

                                <div class="form-outline mb-4  mr-3">
                                    <label class="form-label"  for="form3Example8">Address</label>
                                    <input type="text"  readonly id="form3Example8" class="form-control form-control-lg" 
                                            placeholder="" name="address" value="${address}"/>
                                    
                                </div>

                                <div class="d-md-flex justify-content-start align-items-center mb-4 py-2">

                                    <h6 class="mb-0 me-4">Gender: </h6>

                                    <div class="form-check form-check-inline mb-0 me-4 ">
                                        <label class="form-check-label"  for="femaleGender">Female</label>
                                        <input class="form-check-input m-sm-1" type="radio" readonly
                                               id="femaleGender" value="${gender}" name = "gender"/>
                                        
                                    </div>

                                    <div class="form-check form-check-inline mb-0 me-4">
                                        <label class="form-check-label"  for="maleGender">Male</label>
                                        <input class="form-check-input m-sm-1" checked type="radio" readonly
                                               id="maleGender" value="${gender}" name = "gender" />
                                        
                                    </div>
                                </div>
                                        <p class="text-success mb-4 forgot text-center">${mess}</p>
                                        <p class="text-danger mb-4 forgot text-center">${error}</p>
                                        <%
		  			if(request.getAttribute("message")!=null)
		  			{
		  				out.print("<p class='text-danger ml-1'>"+request.getAttribute("message")+"</p>");
		  			}
                                         %>
                                        <div class="form-outline mb-4 ">
                                            <label class="form-label text-center" for="form3Example8 ">Enter Otp</label>
                                            <input type="text" id="form3Example8"
                                                   class="form-control form-control-lg" required="true" placeholder="Enter otp" name="otp"/>
                                        </div> 

                                <div class="d-flex justify-content-center mr-5">
                                    <button type="submit" class="btn btn-warning btn-lg ms-3 text-center" style="border-radius: 10px">Submit form</button>
                                </div>
                                <p class="mb-5 pb-lg-2 text-center" style="color: #393f81;"> Do you already have an account ? <a
                                        href="loginController" style="color: #393f81;">Login here</a></p>
                            </div>
                        </form>
                    </div>
                    <div class="col-xl-3 d-none d-xl-block">
                    </div>
                </div>
            </div>
        </section>
        <!-- Section: Design Block -->

        <!--footer-->
        <%@include file="footer.jsp" %>
        <!--footer-->
    </body>
</html>
