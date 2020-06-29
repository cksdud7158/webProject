<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Dashtreme Admin - Free Dashboard for Bootstrap 4 by
	Codervent</title>

<!-- loader-->
<link href="assets/css/pace.min.css" rel="stylesheet" />
<script src="assets/js/pace.min.js"></script>
<!--favicon-->
<link rel="icon" href="assets/images/favicon.ico" type="image/x-icon">
<!-- Vector CSS -->
<link href="assets/plugins/vectormap/jquery-jvectormap-2.0.2.css"
	rel="stylesheet" />
<!-- simplebar CSS-->
<link href="assets/plugins/simplebar/css/simplebar.css" rel="stylesheet" />
<!-- Bootstrap core CSS-->
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<!-- animate CSS-->
<link href="assets/css/animate.css" rel="stylesheet" type="text/css" />
<!-- Icons CSS-->
<link href="assets/css/icons.css" rel="stylesheet" type="text/css" />
<!-- Sidebar CSS-->
<link href="assets/css/sidebar-menu.css" rel="stylesheet" />
<!-- Custom Style-->
<link href="assets/css/appstyle.css" rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Bootstrap core JavaScript-->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/popper.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>

<!-- simplebar js -->
<script src="assets/plugins/simplebar/js/simplebar.js"></script>
<!-- sidebar-menu js -->
<script src="assets/js/sidebar-menu.js"></script>
<!-- loader scripts -->
<script src="assets/js/jquery.loading-indicator.js"></script>
<!-- Custom scripts -->
<script src="assets/js/app-script.js"></script>
<!-- Chart js -->

<script src="assets/plugins/Chart.js/Chart.min.js"></script>

<!-- Index js -->
<script src="assets/js/index.js"></script>

<style type="text/css">
select option {
	background-color: #02fd89;;
	color: #6820a3;
	font-weight: bold;
	
}
</style>
</head>

<body class="bg-theme bg-theme1">

	<!-- Start wrapper-->
	<div id="wrapper">

		<!--Start sidebar-wrapper-->
		<div id="sidebar-wrapper" data-simplebar=""
			data-simplebar-auto-hide="true">
			<div class="brand-logo">
				<a href="index.jsp"> <img src="ours/img/logo.png"
					class="logo-icon" alt="logo icon">
				</a>
			</div>
			<ul class="sidebar-menu do-nicescrol">
				<li class="sidebar-header"><b style="font-size: large">Menu</b></li>
				<li style="margin-left: 50px; margin-bottom: 5px;">반갑습니다. <span></span>님
				</li>
				<li><a href="index.jsp"> <i
						class="zmdi zmdi-view-dashboard"></i> <span>홈으로</span>
				</a></li>
			</ul>
		</div>
		<!--End sidebar-wrapper-->

		<!--Start topbar header-->
		<header class="topbar-nav">
			<nav class="navbar navbar-expand fixed-top">
				<ul class="navbar-nav mr-auto align-items-center">
					<li class="nav-item"><a class="nav-link toggle-menu"
						href="javascript:void();"> <i class="icon-menu menu-icon"></i>
					</a></li>
					<li class="nav-item">
						<form class="search-bar">
							<input type="text" class="form-control"
								placeholder="Enter keywords"> <a
								href="javascript:void();"><i class="icon-magnifier"></i></a>
						</form>
					</li>
				</ul>

				<ul class="navbar-nav align-items-center right-nav-link">
					<li class="nav-item dropdown-lg"><a
						class="nav-link dropdown-toggle dropdown-toggle-nocaret waves-effect"
						data-toggle="dropdown" href="javascript:void();"> <i
							class="fa fa-envelope-open-o"></i></a></li>
					<li class="nav-item dropdown-lg"><a
						class="nav-link dropdown-toggle dropdown-toggle-nocaret waves-effect"
						data-toggle="dropdown" href="javascript:void();"> <i
							class="fa fa-bell-o"></i></a></li>
					<li class="nav-item"><a
						class="nav-link dropdown-toggle dropdown-toggle-nocaret"
						data-toggle="dropdown" href="#"> <span class="user-profile"><img
								src="https://via.placeholder.com/110x110" class="img-circle"
								alt="user avatar"></span>
					</a>
						<ul class="dropdown-menu dropdown-menu-right">
							<li class="dropdown-item user-details"><a
								href="javaScript:void();">
									<div class="media">
										<div class="avatar">
											<img class="align-self-start mr-3"
												src="https://via.placeholder.com/110x110" alt="user avatar">
										</div>
										<div class="media-body">
											<h6 class="mt-2 user-title">Sarajhon Mccoy</h6>
											<p class="user-subtitle">mccoy@example.com</p>
										</div>
									</div>
							</a></li>
							<li class="dropdown-divider"></li>
							<li class="dropdown-item"><i class="icon-envelope mr-2"></i>
								Inbox</li>
							<li class="dropdown-divider"></li>
							<li class="dropdown-item"><i class="icon-wallet mr-2"></i>
								Account</li>
							<li class="dropdown-divider"></li>
							<li class="dropdown-item"><i class="icon-settings mr-2"></i>
								Setting</li>
							<li class="dropdown-divider"></li>
							<li class="dropdown-item"><i class="icon-power mr-2"></i>
								Logout</li>
						</ul></li>
				</ul>
			</nav>
		</header>
		<!--End topbar header-->

		<div class="clearfix"></div>

		<div class="content-wrapper">
			<div class="container-fluid">
				<form action="register.do" method="post">
					<!--enctype="multipart/form-data"  -->
					<div class="col-lg-12">
						<div class="card">
							<div class="card-body">
								<ul class="nav nav-tabs nav-tabs-primary top-icon nav-justified">
									<li class="nav-item"><a href="javascript:void();"
										data-target="#editUserInfo" data-toggle="pill"
										class="nav-link active"><i class="icon-note"></i> <span
											class="hidden-xs">기본정보</span></a></li>

									<li class="nav-item"><a href="javascript:void();"
										data-target="#editplayerInfo" data-toggle="pill"
										class="nav-link"><i class="icon-note"></i> <span
											class="hidden-xs">선수정보</span></a></li>
								</ul>
								<div class="tab-content p-3">
									<div class="tab-pane active" id="editUserInfo">
										<div class="form-group row">
											<label class="col-lg-3 col-form-label form-control-label">아이디</label>
											<div class="col-lg-9">
												<input type="text" name="userId" id="userId"
													class="form-control form-control-rounded"
													placeholder="아이디를 입력하세요.">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-lg-3 col-form-label form-control-label">비밀번호</label>
											<div class="col-lg-9">
												<input type="password" name="password" id="password"
													class="form-control form-control-rounded"
													placeholder="비밀번호를 입력하세요.">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-lg-3 col-form-label form-control-label">비밀번호
												확인</label>
											<div class="col-lg-9">
												<input type="password" name="passChcek" id="passChcek"
													class="form-control form-control-rounded"
													placeholder="비밀번호 확인하세요.">
											</div>
										</div>

										<div class="form-group row">
											<label class="col-lg-3 col-form-label form-control-label">이름</label>
											<div class="col-lg-9">
												<input type="text" name="name" id="name"
													class="form-control form-control-rounded"
													placeholder="이름을 입력하세요.">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-lg-3 col-form-label form-control-label">핸드폰번호</label>
											<div class="col-lg-9">
												<input type="text" name="phoneNum" id="phoneNum"
													class="form-control form-control-rounded"
													placeholder="-를 제외한 숫자만 기입해주세요.">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-lg-3 col-form-label form-control-label">사진</label>
											<div class="col-lg-9">
												<input name="photo" id="photo"
													class="form-control form-control-rounded" type="file"
													accept=".jpg, .jpeg, .png">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-lg-3 col-form-label form-control-label">주민등록번호</label>
											<div class="col-lg-9">
												<input type="text" name="ssn" id="ssn"
													class="form-control form-control-rounded"
													placeholder="주민등록번호를 입력해주세요.">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-lg-3 col-form-label form-control-label">별명</label>
											<div class="col-lg-9">
												<input type="text" name="nickName" id="nickName"
													class="form-control form-control-rounded"
													placeholder="Enter Your Email Address">
											</div>
										</div>

										<div class="form-group row">
											<label class="col-lg-3 col-form-label form-control-label">성별</label>
											<div class="col-lg-9">
												남<input type="radio" name="gender" id="genderM"
													class="form-control-rounded" value="m">&nbsp;&nbsp;
												여<input type="radio" name="gender" id="genderF"
													class="form-control-rounded" value="f">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-lg-3 col-form-label form-control-label">Email</label>
											<div class="col-lg-9">
												<input type="text" name="email" id="email"
													class="form-control form-control-rounded"
													placeholder="이메일을 입력해주세요.">
											</div>
										</div>

										<div class="form-group row">
											<label class="col-lg-3 col-form-label form-control-label">주소</label>
											<div class="col-lg-9">
												<input type="text" name="addr" id="addr"
													class="form-control form-control-rounded"
													placeholder="주소를 입력해주세요.">
											</div>
										</div>


										<div class="form-group row">
											<label class="col-lg-3 col-form-label form-control-label">favTeam1</label>
											<div class="col-lg-9">
												<input type="text" name="favTeam1" id="favTeam1"
													class="form-control form-control-rounded"
													placeholder="좋아하는 축구팀을 입력해주세요.">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-lg-3 col-form-label form-control-label">favTeam2</label>
											<div class="col-lg-9">
												<input type="text" name="favTeam2" id="favTeam2"
													class="form-control form-control-rounded"
													placeholder="좋아하는 축구팀을 입력해주세요.">
											</div>
										</div>

										<div class="form-group row">
											<label class="col-lg-3 col-form-label form-control-label">country</label>
											<div class="col-lg-9">
												<input type="text" name="country" id="country"
													class="form-control form-control-rounded"
													placeholder="국가를 입력해주세요.">
											</div>
										</div>
									</div>

									<div class="tab-pane" id="editplayerInfo">

										<div class="form-group row">
											<label class="col-lg-3 col-form-label form-control-label">포지션</label>
											<div class="col-lg-9">
												<select name="position"
											id="position">
											<option value="">포지션을 선택해 주세요.</option>
											<option>FW</option>
											<option>AMF</option>
											<option>LMF</option>
											<option>RMF</option>
											<option>CB</option>
											<option>RB</option>
											<option>LB</option>
											<option>GK</option>
										</select>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-lg-3 col-form-label form-control-label">주발</label>
											<div class="col-lg-9">
												<select name="mainFoot"
											id="mainFoot">
											<option value="">주발을 선택해 주세요.</option>
											<option>right</option>
											<option>left</option>
										</select>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-lg-3 col-form-label form-control-label">키</label>
											<div class="col-lg-9">
												<input type="text" name="height"
											id="height" class="form-control form-control-rounded"
											placeholder="키를 입력해주세요.">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-lg-3 col-form-label form-control-label">몸무게</label>
											<div class="col-lg-9">
												<input type="text"
											name="weight" id="weight"
											class="form-control form-control-rounded"
											placeholder="몸무게를 입력해주세요.">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-lg-3 col-form-label form-control-label">부상유무</label>
											<div class="col-lg-9">
												부상아님<input type="radio"
											name="injury" id="notInjury" class="form-control-rounded"
											value="0">&nbsp;&nbsp; 부상<input type="radio"
											name="injury" id="injury" class="form-control-rounded"
											value="1">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-lg-3 col-form-label form-control-label">정신력</label>
											<div class="col-lg-9">
											<input type="text"
											name="mental" id="mental"
											class="form-control form-control-rounded"
											placeholder="입력해주세요.">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-lg-3 col-form-label form-control-label">빠르기</label>
											<div class="col-lg-9">
											<input type="text"
											name="speed" id="speed"
											class="form-control form-control-rounded"
											placeholder="주소를 입력해주세요.">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-lg-3 col-form-label form-control-label">체격</label>
											<div class="col-lg-9">
												<input type="text"
											name="physical" id="physical"
											class="form-control form-control-rounded"
											placeholder="주소를 입력해주세요.">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-lg-3 col-form-label form-control-label">dribble</label>
											<div class="col-lg-9">
												<input type="text"
											name="dribble" id="dribble"
											class="form-control form-control-rounded"
											placeholder="주소를 입력해주세요.">
											</div>
										</div><div class="form-group row">
											<label class="col-lg-3 col-form-label form-control-label">pass</label>
											<div class="col-lg-9">
												<input type="text" name="pass"
											id="pass" class="form-control form-control-rounded"
											placeholder="주소를 입력해주세요.">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-lg-3 col-form-label form-control-label">defence</label>
											<div class="col-lg-9">
												<input type="text"
											name="defence" id="defence"
											class="form-control form-control-rounded"
											placeholder="주소를 입력해주세요.">
											</div>
										</div>
									
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="form-group row" style="text-align: right;">
						<label class="col-lg-3 col-form-label form-control-label"></label>
						<div class="col-lg-9">
							<input type="reset" class="btn btn-secondary" value="Cancel">
							<button type="submit" id="submitBtn" class="btn btn-light px-5">
											<i class="icon-lock"></i>회원가입</button>
						</div>
					</div>


				</form>
				<!--End Row-->
			</div>
			<!--start overlay-->
			<div class="overlay toggle-menu"></div>
			<!--end overlay-->
		</div>
		<!-- End container-fluid-->


	<!--End content-wrapper-->
	<!--Start Back To Top Button-->
	<a href="javaScript:void();" class="back-to-top"><i
		class="fa fa-angle-double-up"></i> </a>
	<!--End Back To Top Button-->
	<!--Start footer-->
	<footer class="footer">
		<div class="container">
			<div class="text-center">Copyright © 2020 football together</div>
		</div>
	</footer>
	<!--End footer-->

	</div>
</body>
</html>
