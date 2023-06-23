
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
    <head>
        <!-- Basic -->
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <!-- Mobile Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <!-- Site Metas -->
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <link rel="shortcut icon" href="View/image/image.png" type="">

        <title>Forgot Password </title>

        <!-- bootstrap core css -->
        <link rel="stylesheet" type="text/css" href="view/css/bootstrap.css" />

        <!--owl slider stylesheet -->
        <link rel="stylesheet" type="text/css"
              href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />
        <!-- nice select  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css"
              integrity="sha512-CruCP+TD3yXzlvvijET8wV5WxxEh5H8P4cmz0RFbKK6FlZ2sYl3AEsKlLPHbniXKSrDdFewhbmBK5skbdsASbQ=="
              crossorigin="anonymous" />
        <!-- font awesome style -->
        <link href="view/css/font-awesome.min.css" rel="stylesheet" />

        <!-- Custom styles for this template -->
        <link href="view/css/style.css" rel="stylesheet" />
        <!-- responsive style -->
        <link href="view/css/responsive.css" rel="stylesheet" />

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <%@include  file="setupCss.jsp"%>
    </head>
    <body>
        <!-- Section: Design Block -->
        <%@include  file="header.jsp"%>
        
        <section class="vh-100" >
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col col-xl-10">
                    <div class="card" style="border-radius: 1rem;">
                        <div class="row g-0">
                            <div class="col-md-3 col-lg-3 d-none d-md-block">
                            </div>
                            <div class="col-md-6 col-lg-6 d-flex align-items-center">
                                <div class="card-body p-4 p-lg-5 text-black" id="logreg-forms">                                   
                                    <form method="post" action="forgotPasswordController">
                                    <div class="forgot text-center">
                                     <h2>Forgot your password?</h2>
                                      <p>Change your password in three easy steps. This will help you
                                          to secure your password!</p>
                                              <ol class="list-unstyled">
                                                   <li><span class="text-primary text-medium">1. </span>Enter
                                                    your email address and full name below.</li>
                                                    <li><span class="text-primary text-medium">2. </span>Our
                                                    system will send you an OTP to your email</li>
                                                    <li><span class="text-primary text-medium">3. </span>Enter the OTP on the 
                                                      next page</li>
                                              </ol>
                                    </div>
                                        <h2 class="fw-normal mb-3 pb-3 forgot text-center" style="letter-spacing: 1px; ">Forgot password</h2>
                                        <p class="text-success mb-4 forgot text-center">${mess}</p>
                                        <p class="text-danger mb-4 forgot text-center">${error}</p>
                                        <div class="form-outline mb-4 ">
                                            <label class="form-label" for="form3Example8 ">Full Name</label>
                                            <input type="text" id="form3Example8"
                                                   class="form-control form-control-lg" required="true" placeholder="Enter your full name" name="fullname"/>
                                        </div> 
                                        <div class="form-outline mb-4">
                                            <label class="form-label" for="form3Example8">Email address</label>
                                            <input type="email" id="form3Example8"
                                                   class="form-control form-control-lg"  required placeholder="Enter your email" name="email"/>
                                        </div>                                
                                        <div class="pt-1 mb-4">
                                            <button class="btn btn-dark btn-lg btn-block" type="submit">Retrieve</button>
                                        </div>

                                        <p class="mb-5 pb-lg-2" style="color: #393f81;">Don't have an account? <a
                                                href="register.jsp" style="color: #393f81;">Register here</a></p>
                                        <a href="#!" class="small text-muted">Terms of use.</a>
                                        <a href="#!" class="small text-muted">Privacy policy</a>
                                    </form>

                                </div>
                            </div>
                            <div class="col-md-3 col-lg-3 d-none d-md-block">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
<!--           <script>
            function toggleResetPswd(e) {
                e.preventDefault();
                $('#logreg-forms .form-signin').toggle(); // display:block or none
                $('#logreg-forms .form-reset').toggle(); // display:block or none
            }

            function toggleSignUp(e) {
                e.preventDefault();
                $('#logreg-forms .form-signin').toggle(); // display:block or none
                $('#logreg-forms .form-signup').toggle(); // display:block or none
            }

            $(() => {
                // Login Register Form
                $('#logreg-forms #forgot_pswd').click(toggleResetPswd);
                $('#logreg-forms #cancel_reset').click(toggleResetPswd);
                $('#logreg-forms #btn-signup').click(toggleSignUp);
                $('#logreg-forms #cancel_signup').click(toggleSignUp);
            })     
        </script>-->
        </section>
        <%@include file="footer.jsp" %>
        <!-- Section: Design Block -->
    </body>
</html>
