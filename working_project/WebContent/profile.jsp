<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
  <link href="assets/css/pace.min.css" rel="stylesheet"/>
  <script src="assets/js/pace.min.js"></script>
  <!--favicon-->
  <link rel="icon" href="assets/images/favicon.ico" type="image/x-icon">
  <!-- simplebar CSS-->
  <link href="assets/plugins/simplebar/css/simplebar.css" rel="stylesheet"/>
  <!-- Bootstrap core CSS-->
  <link href="assets/css/bootstrap.min.css" rel="stylesheet"/>
  <!-- animate CSS-->
  <link href="assets/css/animate.css" rel="stylesheet" type="text/css"/>
  <!-- Icons CSS-->
  <link href="assets/css/icons.css" rel="stylesheet" type="text/css"/>
  <!-- Sidebar CSS-->
  <link href="assets/css/sidebar-menu.css" rel="stylesheet"/>
  <!-- Custom Style-->
  <link href="assets/css/app-style.css" rel="stylesheet"/>

  <!-- Bootstrap core JavaScript-->
  <script src="assets/js/jquery.min.js"></script>
  <script src="assets/js/popper.min.js"></script>
  <script src="assets/js/bootstrap.min.js"></script>
	
  <!-- simplebar js -->
  <script src="assets/plugins/simplebar/js/simplebar.js"></script>
  <!-- sidebar-menu js -->
  <script src="assets/js/sidebar-menu.js"></script>
  
  <!-- Custom scripts -->
  <script src="assets/js/app-script.js"></script>

<style type="text/css">
select option {
	background-color: #02fd89;;
	color: #6820a3;
	font-weight: bold;
}
</style>
<script>//나이뿌려주는.....
	var age;
	var birthDay;
	var today = new Date();
	var year = today.getFullYear(); // 년도
	var temp;
	$(function() {
		temp = year.toString().substring(2,4);
			birthyear = '${uVo.ssn}';
			birthyear = birthyear.substring(0,2);
			if(Number(birthyear)<Number(temp)){
				temp = '20'+birthyear;
			}else{
				temp = '19'+birthyear;	
			}
			$('#age').text(eval(year-temp));
	});
</script>
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
				<li><a href="login.jsp"> <i
						class="zmdi zmdi-view-dashboard"></i> <span>홈으로</span>
				</a></li>
				<li><a href="profile.jsp"> <i class="zmdi zmdi-folder-star"></i>
						<span>내정보</span>
				</a></li>
				<li><a href="userSchedule.jsp"> <i
						class="zmdi zmdi-calendar-check"></i> <span>나의 일정</span>
				</a></li>
				<li><a href="userSetting.jsp"> <i
						class="icon-settings mr-2"></i> <span>설정</span>
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
							<li class="dropdown-item"><a href="logout.do"><i
									class="icon-power mr-2"></i> Logout</a></li>
						</ul></li>
				</ul>
			</nav>
		</header>
		<!--End topbar header-->

		<div class="clearfix"></div>

		<div class="content-wrapper">
			<div class="container-fluid">

				<div class="row mt-3">
					<div class="col-lg-4">
						<div class="card profile-card-2">
							<div class="card-img-block">
								<img class="img-fluid" src="https://via.placeholder.com/800x500"
									alt="Card image cap">
							</div>
							<div class="card-body pt-5">
								<img src="https://via.placeholder.com/110x110"
									alt="profile-image" class="profile">
								<h5 class="card-title">Mark Stern</h5>
								<p class="card-text">Some quick example text to build on the
									card title and make up the bulk of the card's content.</p>
								<div class="icon-block">
									<a href="javascript:void();"><i
										class="fa fa-facebook bg-facebook text-white"></i></a> <a
										href="javascript:void();"> <i
										class="fa fa-twitter bg-twitter text-white"></i></a> <a
										href="javascript:void();"> <i
										class="fa fa-google-plus bg-google-plus text-white"></i></a>
								</div>
							</div>

							<div class="card-body border-top border-light">
								<div class="media align-items-center">
									<div>
										<img src="assets/images/timeline/html5.svg" class="skill-img"
											alt="skill img">
									</div>
									<div class="media-body text-left ml-3">
										<div class="progress-wrapper">
											<p>
												HTML5 <span class="float-right">65%</span>
											</p>
											<div class="progress" style="height: 5px;">
												<div class="progress-bar" style="width: 65%"></div>
											</div>
										</div>
									</div>
								</div>
								<hr>
								<div class="media align-items-center">
									<div>
										<img src="assets/images/timeline/bootstrap-4.svg"
											class="skill-img" alt="skill img">
									</div>
									<div class="media-body text-left ml-3">
										<div class="progress-wrapper">
											<p>
												Bootstrap 4 <span class="float-right">50%</span>
											</p>
											<div class="progress" style="height: 5px;">
												<div class="progress-bar" style="width: 50%"></div>
											</div>
										</div>
									</div>
								</div>
								<hr>
								<div class="media align-items-center">
									<div>
										<img src="assets/images/timeline/angular-icon.svg"
											class="skill-img" alt="skill img">
									</div>
									<div class="media-body text-left ml-3">
										<div class="progress-wrapper">
											<p>
												AngularJS <span class="float-right">70%</span>
											</p>
											<div class="progress" style="height: 5px;">
												<div class="progress-bar" style="width: 70%"></div>
											</div>
										</div>
									</div>
								</div>
								<hr>
								<div class="media align-items-center">
									<div>
										<img src="assets/images/timeline/react.svg" class="skill-img"
											alt="skill img">
									</div>
									<div class="media-body text-left ml-3">
										<div class="progress-wrapper">
											<p>
												React JS <span class="float-right">35%</span>
											</p>
											<div class="progress" style="height: 5px;">
												<div class="progress-bar" style="width: 35%"></div>
											</div>
										</div>
									</div>
								</div>

							</div>
						</div>

					</div>

					<div class="col-lg-8">
						<div class="card">
							<div class="card-body">
								<ul class="nav nav-tabs nav-tabs-primary top-icon nav-justified">
									<li class="nav-item"><a href="javascript:void();"
										data-target="#profile" data-toggle="pill"
										class="nav-link active"><i class="icon-user"></i> <span
											class="hidden-xs">프로필</span></a></li>
									<li class="nav-item"><a href="javascript:void();"
										data-target="#editUserInfo" data-toggle="pill"
										class="nav-link"><i class="icon-note"></i> <span
											class="hidden-xs">기본정보수정</span></a></li>
									<li class="nav-item"><a href="javascript:void();"
										data-target="#editplayerInfo" data-toggle="pill"
										class="nav-link"><i class="icon-note"></i> <span
											class="hidden-xs">선수정보수정</span></a></li>
								</ul>
								<div class="tab-content p-3">
									<div class="tab-pane active" id="profile">
										<h5 class="mb-3">선수정보</h5>
										<div class="row">
											<div class="col-md-6">
												<h6>이름 : ${uVo.name}</h6>
												<h6>국적/지역: ${uVo.country}/${uVo.addr}</h6>

												<h6>나이: <span id="age"></span></h6>
												
												<p>Indie music, skiing and hiking. I love the great
													outdoors.</p>
											</div>
											<div class="col-md-6">
												<h6>Recent badges</h6>
												<a href="javascript:void();"
													class="badge badge-dark badge-pill">html5</a> <a
													href="javascript:void();"
													class="badge badge-dark badge-pill">react</a> <a
													href="javascript:void();"
													class="badge badge-dark badge-pill">codeply</a> <a
													href="javascript:void();"
													class="badge badge-dark badge-pill">angularjs</a> <a
													href="javascript:void();"
													class="badge badge-dark badge-pill">css3</a> <a
													href="javascript:void();"
													class="badge badge-dark badge-pill">jquery</a> <a
													href="javascript:void();"
													class="badge badge-dark badge-pill">bootstrap</a> <a
													href="javascript:void();"
													class="badge badge-dark badge-pill">responsive-design</a>
												<hr>
												<span class="badge badge-primary"><i
													class="fa fa-user"></i> 900 Followers</span> <span
													class="badge badge-success"><i class="fa fa-cog"></i>
													43 Forks</span> <span class="badge badge-danger"><i
													class="fa fa-eye"></i> 245 Views</span>
											</div>
											<div class="col-md-12">
												<h5 class="mt-2 mb-3">
													<span class="fa fa-clock-o ion-clock float-right"></span>
													Recent Activity
												</h5>
												<div class="table-responsive">
													<table class="table table-hover table-striped">
														<tbody>
															<tr>
																<td><strong>Abby</strong> joined ACME Project Team
																	in <strong>`Collaboration`</strong></td>
															</tr>
															<tr>
																<td><strong>Gary</strong> deleted My Board1 in <strong>`Discussions`</strong>
																</td>
															</tr>
															<tr>
																<td><strong>Kensington</strong> deleted MyBoard3 in
																	<strong>`Discussions`</strong></td>
															</tr>
															<tr>
																<td><strong>John</strong> deleted My Board1 in <strong>`Discussions`</strong>
																</td>
															</tr>
															<tr>
																<td><strong>Skell</strong> deleted his post Look at
																	Why this is.. in <strong>`Discussions`</strong></td>
															</tr>
														</tbody>
													</table>
												</div>
											</div>
										</div>
										<!--/row-->
									</div>
									<div class="tab-pane" id="editUserInfo">
										<form action="updateUser.do">
											<div class="form-group row">
												<label class="col-lg-3 col-form-label form-control-label">아이디</label>
												<div class="col-lg-9">
													<input type="text" name="userId" id="userId"
														class="form-control form-control-rounded"
														value="${uVo.userId}" readonly="readonly">
												</div>
											</div>
											<div class="form-group row">
												<label class="col-lg-3 col-form-label form-control-label">비밀번호</label>
												<div class="col-lg-9">
													<input type="password" name="password" id="password"
														class="form-control form-control-rounded"
														placeholder="기존의 비밀번호를 입력해주세요.">
												</div>
											</div>
											<div class="form-group row">
												<label class="col-lg-3 col-form-label form-control-label">새
													비밀번호</label>
												<div class="col-lg-9">
													<input type="password" name="passChcek" id="passChcek"
														class="form-control form-control-rounded"
														placeholder="새 비밀번호를 입력해주세요.">
												</div>
											</div>

											<div class="form-group row">
												<label class="col-lg-3 col-form-label form-control-label">이름</label>
												<div class="col-lg-9">
													<input type="text" name="name" id="name"
														class="form-control form-control-rounded"
														value="${uVo.name}" readonly="readonly">
												</div>
											</div>
											<div class="form-group row">
												<label class="col-lg-3 col-form-label form-control-label">핸드폰번호</label>
												<div class="col-lg-9">
													<input type="text" name="phoneNum" id="phoneNum"
														class="form-control form-control-rounded"
														value="${uVo.phoneNum}">
												</div>
											</div>
											<div class="form-group row">
												<label class="col-lg-3 col-form-label form-control-label">사진</label>
												<div class="col-lg-9">
													<input name="photo" id="photo"
														class="form-control form-control-rounded" type="file"
														accept=".jpg, .jpeg, .png" value="${uVo.photo}">
												</div>
											</div>
											<div class="form-group row">
												<label class="col-lg-3 col-form-label form-control-label">주민등록번호</label>
												<div class="col-lg-9">
													<input type="text" name="ssn" id="ssn"
														class="form-control form-control-rounded"
														value="${uVo.ssn}" readonly="readonly">
												</div>
											</div>
											<div class="form-group row">
												<label class="col-lg-3 col-form-label form-control-label">별명</label>
												<div class="col-lg-9">
													<input type="text" name="nickName" id="nickName"
														class="form-control form-control-rounded"
														value="${uVo.nickName}">
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
														value="${uVo.email}">
												</div>
											</div>

											<div class="form-group row">
												<label class="col-lg-3 col-form-label form-control-label">주소</label>
												<div class="col-lg-9">
													<input type="text" name="addr" id="addr"
														class="form-control form-control-rounded"
														value="${uVo.addr}">
												</div>
											</div>


											<div class="form-group row">
												<label class="col-lg-3 col-form-label form-control-label">좋아하는
													팀1</label>
												<div class="col-lg-9">
													<input type="text" name="favTeam1" id="favTeam1"
														class="form-control form-control-rounded"
														value="${uVo.favTeam1}">
												</div>
											</div>
											<div class="form-group row">
												<label class="col-lg-3 col-form-label form-control-label">좋아하는
													팀2</label>
												<div class="col-lg-9">
													<input type="text" name="favTeam2" id="favTeam2"
														class="form-control form-control-rounded"
														value="${uVo.favTeam2}">
												</div>
											</div>

											<div class="form-group row">
												<label class="col-lg-3 col-form-label form-control-label">국가</label>
												<div class="col-lg-9">
													<input type="text" name="country" id="country"
														class="form-control form-control-rounded"
														value="${uVo.favTeam2}" readonly="readonly">
												</div>
											</div>
											<div class="form-group row">
												<label class="col-lg-3 col-form-label form-control-label"></label>
												<div class="col-lg-9">
													<input type="reset" id="userChangeReset"
														class="btn btn-secondary" value="취소하기"> <input
														type="submit" id="userChangeSubmit"
														class="btn btn-primary" value="수정하기">
												</div>
											</div>
										</form>
									</div>
									<div class="tab-pane" id="editplayerInfo">
										<form action="updatePlayerInfo.do">
											<div class="form-group row">
												<label class="col-lg-3 col-form-label form-control-label">포지션</label>
												<div class="col-lg-9">
													<select name="position" id="position">
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
													<select name="mainFoot" id="mainFoot">
														<option value="">주발을 선택해 주세요.</option>
														<option>right</option>
														<option>left</option>
													</select>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-lg-3 col-form-label form-control-label">키</label>
												<div class="col-lg-9">
													<input type="text" name="height" id="height"
														class="form-control form-control-rounded"
														value="${uVo.pVo.height}">
												</div>
											</div>
											<div class="form-group row">
												<label class="col-lg-3 col-form-label form-control-label">몸무게</label>
												<div class="col-lg-9">
													<input type="text" name="weight" id="weight"
														class="form-control form-control-rounded"
														value="${uVo.pVo.weight}">
												</div>
											</div>
											<div class="form-group row">
												<label class="col-lg-3 col-form-label form-control-label">부상유무</label>
												<div class="col-lg-9">
													부상아님<input type="radio" name="injury" id="notInjury"
														class="form-control-rounded" value="0">&nbsp;&nbsp;
													부상<input type="radio" name="injury" id="injury"
														class="form-control-rounded" value="1">
												</div>
											</div>
											<div class="form-group row">
												<label class="col-lg-3 col-form-label form-control-label">정신력</label>
												<div class="col-lg-9">
													<input type="text" name="mental" id="mental"
														class="form-control form-control-rounded"
														value="${uVo.pVo.mental}">
												</div>
											</div>
											<div class="form-group row">
												<label class="col-lg-3 col-form-label form-control-label">빠르기</label>
												<div class="col-lg-9">
													<input type="text" name="speed" id="speed"
														class="form-control form-control-rounded"
														value="${uVo.pVo.speed}">
												</div>
											</div>
											<div class="form-group row">
												<label class="col-lg-3 col-form-label form-control-label">physical</label>
												<div class="col-lg-9">
													<input type="text" name="physical" id="physical"
														class="form-control form-control-rounded"
														value="${uVo.pVo.physical}">
												</div>
											</div>
											<div class="form-group row">
												<label class="col-lg-3 col-form-label form-control-label">dribble</label>
												<div class="col-lg-9">
													<input type="text" name="dribble" id="dribble"
														class="form-control form-control-rounded"
														value="${uVo.pVo.dribble}">
												</div>
											</div>
											<div class="form-group row">
												<label class="col-lg-3 col-form-label form-control-label">pass</label>
												<div class="col-lg-9">
													<input type="text" name="pass" id="pass"
														class="form-control form-control-rounded"
														value="${uVo.pVo.pass}">
												</div>
											</div>
											<div class="form-group row">
												<label class="col-lg-3 col-form-label form-control-label">defence</label>
												<div class="col-lg-9">
													<input type="text" name="defence" id="defence"
														class="form-control form-control-rounded"
														value="${uVo.pVo.defence}">
												</div>
											</div>
											<div class="form-group row">
												<label class="col-lg-3 col-form-label form-control-label"></label>
												<div class="col-lg-9">
													<input type="reset" id="playerInfoChageReset"
														class="btn btn-secondary" value="취소하기"> <input
														type="submit" id="playerInfoChangeSubmit"
														class="btn btn-primary" value="수정하기">
												</div>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>

				<!--start overlay-->
				<div class="overlay toggle-menu"></div>
				<!--end overlay-->

			</div>
			<!-- End container-fluid-->
		</div>
		<!--End content-wrapper-->
		<!--Start Back To Top Button-->
		<a href="javaScript:void();" class="back-to-top"><i
			class="fa fa-angle-double-up"></i> </a>
		<!--End Back To Top Button-->
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
	<!--End wrapper-->
</body>
</html>
