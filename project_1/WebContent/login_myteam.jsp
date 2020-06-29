<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">
<title>Insert title here</title>

<!-- login.jsp에서 사용하는 CSS -->
  <!-- 1. Font -->
  <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet">
  
  <!-- 2. Bootstrap CSS -->
  <link href="assets/login/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  
  <!-- 3. Libraries CSS Files -->
  <link href="assets/login/lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="assets/login/lib/animate/animate.min.css" rel="stylesheet">
  <link href="assets/login/lib/ionicons/css/ionicons.min.css" rel="stylesheet">
  <link href="assets/login/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
  
  <!-- 4. main StyleSheet File -->
  <link href="assets/login/css/style.css" rel="stylesheet">


</head>
<body>
<section class="section_myteam section-t8" style="padding-top:40px;">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="title-wrap d-flex justify-content-between">
            <div class="title-box">
              <h2 class="title-a">My Teams</h2>
            </div>
            <div class="title-link">
              <a href="#">Show All
                <span class="ion-ios-arrow-forward"></span>
              </a>
            </div>
          </div>
        </div>
      </div>
      <div class="row">
      <c:forEach items="${tVo}" var="team">
        <div class="col-md-4">
          <div class="card-box-d">
            <div class="card-img-d" align="center">
            <a href="teamHome.do?teamId=${team.teamId}">
              <img src="${team.emblem}" alt="" class="img-d img-fluid" style="width:250px;height:250px;">
            </a>
            </div>
            <div class="card-overlay card-overlay-hover">
              <div class="card-header-d">
                <div class="card-title-d align-self-center">
                  <h3 class="title-d">
                    ${team.teamName}
                  </h3>
                </div>
              </div>
              <div class="card-body-d">
                <div class="info-agents color-a">
                  <p>
                    <strong>팀 랭킹 : </strong> &nbsp;${team.ti.ranking}위</p>
                  <p>
                    <strong>회원수 : </strong> &nbsp;${team.ti.memberNum}명</p>
                </div>
              </div>
              <div class="card-footer-d">
                <div class="socials-footer d-flex justify-content-center">
                  <ul class="list-inline">
                    <li class="list-inline-item">
                      <a href="#" class="link-one">
                        <i class="fa fa-facebook" aria-hidden="true"></i>
                      </a>
                    </li>
                    <li class="list-inline-item">
                      <a href="#" class="link-one">
                        <i class="fa fa-twitter" aria-hidden="true"></i>
                      </a>
                    </li>
                    <li class="list-inline-item">
                      <a href="#" class="link-one">
                        <i class="fa fa-instagram" aria-hidden="true"></i>
                      </a>
                    </li>
                    <li class="list-inline-item">
                      <a href="#" class="link-one">
                        <i class="fa fa-pinterest-p" aria-hidden="true"></i>
                      </a>
                    </li>
                    <li class="list-inline-item">
                      <a href="#" class="link-one">
                        <i class="fa fa-dribbble" aria-hidden="true"></i>
                      </a>
                    </li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
        </div>
        </c:forEach>
    </div>
    </div>
  </section>



</body>
</html>