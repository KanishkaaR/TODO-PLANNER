<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>TODO PLANNER</title>
  <meta content="" name="description">
  <meta content="" name="keywords">
  <!-- Favicons -->
  <link href="${pageContext.request.contextPath}/homepage/assets/img/favicon.png" rel="icon">
  <link href="${pageContext.request.contextPath}/homepage/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <link href="${pageContext.request.contextPath}/homepage/assets/vendor/aos/aos.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/homepage/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/homepage/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/homepage/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/homepage/assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/homepage/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/homepage/assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="${pageContext.request.contextPath}/homepage/assets/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: Gp - v4.6.0
  * Template URL: https://bootstrapmade.com/gp-free-multipurpose-html-bootstrap-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>

  <!-- ======= Header ======= -->
  <header id="header" class="fixed-top ">
    <div class="container d-flex align-items-center justify-content-lg-between">

      <h1 class="logo me-auto me-lg-0"><a href="index.html">TODO PLANNER<span> <img src="assets/img/favicon.png" class="img-fluid" alt=""></span></a></h1>
      <!-- Uncomment below if you prefer to use an image logo -->
      <!-- <a href="index.html" class="logo me-auto me-lg-0"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

      <nav id="navbar" class="navbar order-last order-lg-0">
        <ul>
          <li><a class="nav-link scrollto active" href="#hero">Home</a></li>
          <li><a class="nav-link scrollto" href="#about">About</a></li>
          
          <li><a class="nav-link scrollto" href="#contact">Contact</a></li>
          
        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->

      <a class="get-started-btn" style="margin-left:10px;padding:5px;" id="loginBtn" onclick="document.getElementById('loginModal').style.display='block'">Login</a>
      <a class="get-started-btn" id="signupBtn" style="margin-left:10px;padding:5px;" onclick="document.getElementById('signupModal').style.display='block'">Signup</a>
		<div class="container">
        <!-- <button class="w3-button w3-black" onclick="document.getElementById('id01').style.display='block'" style="margin-left: 150px;">Add event</button> -->
        <div id="loginModal" class="w3-modal">
            <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px">
        
              <div class="w3-center"><br>
                <span onclick="document.getElementById('loginModal').style.display='none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
                <h4>Login</h4>
              </div>
        
              <form class="w3-container" id="loginForm">
                <div class="w3-section">
                  <label><b>User name</b></label>
                  <input class="w3-input w3-border w3-margin-bottom" id="loginUsername" type="text" placeholder="Enter user name" name="loginUsername" required>
                  <br><br>
                   <label><b>Password</b></label>
                  <input class="w3-input w3-border w3-margin-bottom" id="loginPsw" type="text" placeholder="Enter password" name="loginPsw" required>
                  <br><br>
                  
                  <input class="w3-button w3-block w3-dark-grey w3-section w3-padding" type="button" id="loginSubmitBtn" value="Login">
                </div>
            </form>
            </div>
          </div>
          
          <div class="container">
        <!-- <button class="w3-button w3-black" onclick="document.getElementById('id01').style.display='block'" style="margin-left: 150px;">Add event</button> -->
        <div id="signupModal" class="w3-modal">
            <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px">
        
              <div class="w3-center"><br>
                <span onclick="document.getElementById('signupModal').style.display='none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
                <h4>Sign up</h4>
              </div>
        
              <form class="w3-container" id="signupForm">
                <div class="w3-section">
                  <label><b>User name</b></label>
                  <input class="w3-input w3-border w3-margin-bottom" id="signupUsername" type="text" placeholder="Enter user name" name="signupUsername" required>
                  <br><br>
                   <label><b>Password</b></label>
                  <input class="w3-input w3-border w3-margin-bottom" id="signupPsw" type="text" placeholder="Enter password" name="signupPsw" required>
                  <br><br>
                  
                  <input class="w3-button w3-block w3-dark-grey w3-section w3-padding" type="button" id="signupSubmitBtn" value="Signup">
                </div>
            </form>
            </div>
          </div>
    </div>
  </header><!-- End Header -->

  <!-- ======= Hero Section ======= -->
  <section id="hero" class="d-flex align-items-center justify-content-center">
    <div class="container" data-aos="fade-up">

      <div class="row justify-content-center" data-aos="fade-up" data-aos-delay="150">
        <div class="col-xl-6 col-lg-8">
          <h1>Your busy life deserves this<span>.</span></h1>
          <h2>TODO planner helps millions of people save time and do the things that really matter.</h2>
        </div>
      </div>

      <div class="row gy-4 mt-5 justify-content-center" data-aos="zoom-in" data-aos-delay="250">
        <div class="col-xl-2 col-md-4">
          <div class="icon-box">
            <i class="ri-check-line"></i>
            <h3><a href="">Todo</a></h3>
          </div>
        </div>
        <div class="col-xl-2 col-md-4">
          <div class="icon-box">
            <i class="ri-calendar-2-fill"></i>
            <h3><a href="">Custom</a></h3>
          </div>
        </div>
        <div class="col-xl-2 col-md-4">
          <div class="icon-box">
            <i class="ri-alarm-fill"></i>
            <h3><a href="">Calender</a></h3>
          </div>
        </div> 
      </div>

    </div>
  </section><!-- End Hero -->

  <main id="main">

    <!-- ======= About Section ======= -->
    <section id="about" class="about">
      <div class="container" data-aos="fade-up">

        <div class="row">
          <div class="col-lg-6 order-1 order-lg-2" data-aos="fade-left" data-aos-delay="100">
            <img src="assets/img/about.jpg" class="img-fluid" alt="">
          </div>
          <div class="col-lg-6 pt-4 pt-lg-0 order-2 order-lg-1 content" data-aos="fade-right" data-aos-delay="100">
            <br><h3>The best way to organise your life.</h3>
            <p class="fst-italic">
              
            </p>
            <ul><h5>
              <li><i class="ri-check-double-line"></i>Organize all your to-do's in lists and projects. .</li><br>
              <li><i class="ri-check-double-line"></i> Color tag them to set priorities and categories. </li><br>
			  <li><i class="ri-check-double-line"></i> Boost your productivity with notes, subtasks and attachments.</li><br>
			  <li><i class="ri-check-double-line"></i> Set due dates to keep track of your progress. .</li><br>
              </h5> 
            </ul>
            
          </div>
        </div>

      </div>
    </section><!-- End About Section -->

    

    <!-- ======= Features Section ======= -->
    <section id="features" class="features">
      <div class="container" data-aos="fade-up">

        <div class="row">
          <div class="image col-lg-6" style='background-image: url("assets/img/features.jpg");' data-aos="fade-right"></div>
          <div class="col-lg-6" data-aos="fade-left" data-aos-delay="100">
            <div class="icon-box mt-5 mt-lg-0" data-aos="zoom-in" data-aos-delay="150">
              <i class="bx bx-receipt"></i>
              <h4>Eat deadlines for breakfast</h4>
              <p>Your work day consists of meetings and action items. Having a combined view accessible from your browser is the best way to stay productive. </p>
            </div>
            <div class="icon-box mt-5" data-aos="zoom-in" data-aos-delay="150">
              <i class="bx bx-cube-alt"></i>
              <h4>Run your day care-free</h4>
              <p> Create reminders with natural language and never forget a thing.Easily add reminders to make sure nothing important slips away.</p>
            </div>
            <div class="icon-box mt-5" data-aos="zoom-in" data-aos-delay="150">
              <i class="bx bx-images"></i>
              <h4>Plan your day in seconds.</h4>
              <p>Don’t let your tasks overwhelm you. With our ultimate daily planner, you can quickly run through your daily to-do’s and prioritize them so you’re focused only on the things that matter.</p>
            </div>
            <div class="icon-box mt-5" data-aos="zoom-in" data-aos-delay="150">
              <i class="bx bx-shield"></i>
              <h4>Never miss a thing</h4>
              <p>Control your day, week and month with calendar events and tasks in a single view. It's the best way to manage your time and achieve your ambitious goals.</p>
            </div>
          </div>
        </div>

      </div>
    </section><!-- End Features Section -->

   
    <!-- ======= Cta Section ======= -->
    <section id="cta" class="cta">
      <div class="container" data-aos="zoom-in">

        <div class="text-center">
          <h3>TODO planner is the secret weapon of successful people</h3>
          <p> Wherever you are, take your to do list with you.</p>
          <a class="cta-btn" href="#">Call To Action</a>
        </div>

      </div>
    </section><!-- End Cta Section -->

   

    <!-- ======= Contact Section ======= -->
    <section id="contact" class="contact">
      <div class="container" data-aos="fade-up">

        <div class="section-title">
          <h2>Contact</h2>
          <p>Contact Us</p>
        </div>

        <div>
          <iframe style="border:0; width: 100%; height: 270px;" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3887.3880941403404!2d80.23325751464563!3d13.010939990830087!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3a52679f0d20f797%3A0x59f9f10c66e02a19!2sCollege%20of%20Engineering%2C%20Guindy!5e0!3m2!1sen!2sin!4v1636907252361!5m2!1sen!2sin" frameborder="0" allowfullscreen></iframe>
        </div>

        <div class="row mt-5">

          <div class="col-lg-4">
            <div class="info">
              <div class="address">
                <i class="bi bi-geo-alt"></i>
                <h4>Location:</h4>
                <p>12, Sardar Patel Rd, Anna University, Guindy, Chennai, Tamil Nadu 600025</p>
              </div>

              <div class="email">
                <i class="bi bi-envelope"></i>
                <h4>Email:</h4>
                <p>todo@gmail.com</p>
              </div>

              <div class="phone">
                <i class="bi bi-phone"></i>
                <h4>Call:</h4>
                <p>+91 9876543210</p>
              </div>

            </div>

          </div>

          <div class="col-lg-8 mt-5 mt-lg-0">

            <form action="forms/contact.php" method="post" role="form" class="php-email-form">
              <div class="row">
                <div class="col-md-6 form-group">
                  <input type="text" name="name" class="form-control" id="name" placeholder="Your Name" required>
                </div>
                <div class="col-md-6 form-group mt-3 mt-md-0">
                  <input type="email" class="form-control" name="email" id="email" placeholder="Your Email" required>
                </div>
              </div>
              <div class="form-group mt-3">
                <input type="text" class="form-control" name="subject" id="subject" placeholder="Subject" required>
              </div>
              <div class="form-group mt-3">
                <textarea class="form-control" name="message" rows="5" placeholder="Message" required></textarea>
              </div>
              <div class="my-3">
                <div class="loading">Loading</div>
                <div class="error-message"></div>
                <div class="sent-message">Your message has been sent. Thank you!</div>
              </div>
              <div class="text-center"><button type="submit">Send Message</button></div>
            </form>

          </div>

        </div>

      </div>
    </section><!-- End Contact Section -->

  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
  <footer id="footer">
    

    <div class="container">
      <div class="copyright">
        &copy; Copyright <strong><span>TODO</span></strong>. All Rights Reserved
      </div>
      <div class="credits">
        <!-- All the links in the footer should remain intact. -->
        <!-- You can delete the links only if you purchased the pro version. -->
        <!-- Licensing information: https://bootstrapmade.com/license/ -->
        <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/gp-free-multipurpose-html-bootstrap-template/ -->
        Designed by <a href="https://bootstrapmade.com/">CEGIANS</a>
      </div>
    </div>
  </footer><!-- End Footer -->

  <div id="preloader"></div>
  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- Vendor JS Files -->
  <script src="${pageContext.request.contextPath}/homepage/assets/vendor/aos/aos.js"></script>
  
  <script src="${pageContext.request.contextPath}/homepage/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="${pageContext.request.contextPath}/homepage/assets/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="${pageContext.request.contextPath}/homepage/assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="${pageContext.request.contextPath}/homepage/assets/vendor/php-email-form/validate.js"></script>
  <script src="${pageContext.request.contextPath}/homepage/assets/vendor/purecounter/purecounter.js"></script>
  <script src="${pageContext.request.contextPath}/homepage/assets/vendor/swiper/swiper-bundle.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <!-- Template Main JS File -->
  <script src="${pageContext.request.contextPath}/homepage/assets/js/main.js"></script>

</body>

</html>