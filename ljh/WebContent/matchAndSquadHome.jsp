<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>FootBallTogether - 매치&선발</title>

<!-- loader-->
<link href="assets/css/pace.min.css" rel="stylesheet" />
<script src="assets/js/pace.min.js"></script>
<!--favicon-->
<link rel="icon" href="assets/images/favicon.ico" type="image/x-icon">

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
<link href="assets/css/app-style.css" rel="stylesheet" />
<link href="assets/css/app-style.css" rel="stylesheet" />

<!-- Bootstrap core JavaScript-->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/popper.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>

<!-- simplebar js -->
<script src="assets/plugins/simplebar/js/simplebar.js"></script>
<!-- sidebar-menu js -->
<script src="assets/js/sidebar-menu.js"></script>
<!-- <!-- loader scripts -->
<!--<script src="assets/js/jquery.loading-indicator.js"></script> -->
<!-- Custom scripts -->
<script src="assets/js/app-script.js"></script>
<!-- Chart js -->

<script src="assets/plugins/Chart.js/Chart.min.js"></script>


<script type="text/javascript">
/* var dueDate =""; 
var voteNum =0 ;
var totalNum =0;
var attNum =0;
var noAttNum = 0;
var bDay;
//투표 마감 날짜와 현재 날짜 대비 투표가 마감되어야만 매치가 나옵니다.
$(function(){
	alert(1);
	dueDate = '${vVo.dueDate}';
	bDay = calculateDate();

	// alert($('#a').html());
  });//

  function calculateDate() {
	    // Date 객체 만들기
	    var now = new Date();
	    var startDate = new Date(dueDate);
	    // 날짜 차이 계산
	    var betweenDays = (now.getTime() - startDate.getTime()) / 1000 / 60 / 60 / 24;
		return betweenDays;
	  }
  
  var playDate="";
  $(function(){
	  playDate = '${vVo.mVo.schedule}';
		
		var bDay2 = calculateDate2();
			  // Date 객체 만들기


	  });//
	  
	  function calculateDate2() {
		  var now2 = new Date();
		    var startDate2 = new Date(playDate);
		    // 날짜 차이 계산
		    var betweenDays2 = (now2.getTime() - startDate2.getTime()) / 1000 / 60 / 60 / 24;
			return betweenDays2;
		  } */
	  
  //투표 결과 입력
  $(function(){
		//투표한사람
		voteNum = ${fn:length(vVo.vrVoList)};
		$('#voteNum').text(voteNum);
		//회원 총 명수
		totalNum = ${fn:length(tVo.tmvList)};
		$('#totalNum').text(totalNum);
		// 참석 투표수
		attNum = ${voteResultCount};
		$('#attNum').text(attNum);
		//불참 투표수
		noAttNum = (voteNum -attNum);
		$('#noAttNum').text(noAttNum);
	});//ready
	  var participationIndex=0;
	  var totalAbilityIndex=0;
 $(function(){
 	$('#participationIndex').on('keyup', function(){
 		participationIndex = $(this).val();
 		if(participationIndex>10){
 			alert("10보다 작은 값을 넣어주시기 바랍니다.");
 			$(this).val("");
 			$(this).focus();
 			
 		
 		}else{
 	 		totalAbilityIndex=10-participationIndex;
 	 	 	$('#totalAbilityIndex').val(totalAbilityIndex);
	
 		}
 	});
 	$('#totalAbilityIndex').on('keyup', function(){
 		totalAbilityIndex = $(this).val();
 		if(totalAbilityIndex>10){
 			alert("10보다 작은 값을 넣어주시기 바랍니다.");
 			$(this).val("");
 			$(this).focus();
 		
 		}else{
 			participationIndex=10-totalAbilityIndex;
 	 	 	$('#participationIndex').val(participationIndex);
	
 		}
 	});//onchange	 
 });//ready
var stadiumType;
var pPlayerNum;
var pPlayerNumPlusOne;
 $(function(){
	stadiumType = '${tVo.sVo.stadiumType}'.split(':');
	pPlayerNum = Number(stadiumType[0]);
	pPlayerNumPlusOne=pPlayerNum+1;


 })//
</script>



</head>
<c:set var="manager" value="${tVo.tmvList[0].manager}" />


<body class="bg-theme bg-theme1">

	<!-- Start wrapper-->
	<div id="wrapper">
		<!--Start sidebar-wrapper-->
		<div id="sidebar-wrapper" data-simplebar=""
			data-simplebar-auto-hide="true">
			<div class="brand-logo">
				<a href="login.jsp"> <img src="ours/img/logo.png"
					class="logo-icon" alt="logo icon">
				</a>
			</div>
			<ul class="sidebar-menu do-nicescrol">
				<li class="sidebar-header"><b style="font-size: large">Menu</b></li>
				<li style="margin-left: 50px; margin-bottom: 5px;">반갑습니다. <span><strong>${uVo.name}</strong></span>님
				</li>


				<!-- 매니저 / 일반회원인지에 따라 왼쪽 메뉴가 다르게 보여야 함 -->
				<li><a href="ToHome.do"> <i
						class="zmdi zmdi-view-dashboard"></i><span>홈으로</span>
				</a></li>
				<li><a href="showAllMember.do?teamId=${tVo.teamId}"> <i
						class="zmdi zmdi-accounts"></i> <span>멤버 보기</span>
				</a></li>
				<li><a href="matchHistory.do?teamId=${tVo.teamId}"> <i
						class="zmdi zmdi-file-text"></i> <span>전적 조회</span>
				</a></li>
				<li><a href="voteBulletin.do"> <i
						class="zmdi zmdi-check-square"></i><span>투표하기</span>
				</a></li>
				<li><a href="matchAndSquad.do" target="_blank"> <i
						class="icon-settings mr-2"></i> <span>매치</span>
				</a></li>
				<c:choose>
					<c:when test="${manager=='1'}">
						<li><a href="findMatch.jsp"> <i
								class="zmdi zmdi-search-for"></i> <span>매치 찾기</span>
						</a></li>
						<li><a href="AllJoinRequest.do" target="_blank"> <i
								class="zmdi zmdi-account-circle"></i> <span>가입신청 리스트</span>
						</a></li>
						<li><a href="makeVote.do"> <i
								class="zmdi zmdi-check-square"></i> <span>투표 만들기</span>
						</a></li>
						<li><a href="teamSetting.do" target="_blank"> <i
								class="icon-settings mr-2"></i> <span>팀 설정</span>
						</a></li>

					</c:when>
				</c:choose>
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
											<h6 class="mt-2 user-title">${uVo.name}</h6>
											<p class="user-subtitle">${uVo.email}</p>
										</div>
									</div>
							</a></li>
							<li class="dropdown-divider"></li>
							<li class="dropdown-item"><a href="logout.do"><i
									class="icon-power mr-2"></i>Logout</a></li>
						</ul></li>
				</ul>
			</nav>
		</header>
		<!--End topbar header-->

		<div class="clearfix"></div>
		<div class="content-wrapper">
			<c:choose>
				<c:when test="${time>'0'}">

					<div class="row">
						<div class="col-lg-12">
							<div class="card">
								<div class="card-body">
									<ul
										class="nav nav-tabs nav-tabs-primary top-icon nav-justified">
										<li class="nav-item"><a href="javascript:void();"
											data-target="#matchInfo" data-toggle="pill"
											class="nav-link active"><i class="icon-note"></i> <span
												class="hidden-xs">경기정보 및 투표정보</span></a></li>
									</ul>
									<div class="tab-content p-3">
										<div class="tab-pane active" id="matchInfo">

											<div class="form-group row">
												<label class="col-lg-3 col-form-label form-control-label">작성자</label>
												<div class="col-lg-9">
													<div name="stadiumName" id="stadiumName"
														class="form-control">${vVo.writer}</div>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-lg-3 col-form-label form-control-label">경기일</label>
												<div class="col-lg-9">
													<div name="schedule" id="schedule" class="form-control">${vVo.mVo.schedule}
													</div>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-lg-3 col-form-label form-control-label">경기장</label>
												<div class="col-lg-9">
													<div name="stadiumName" id="stadiumName"
														class="form-control">${tVo.sVo.stadiumName}</div>
												</div>
											</div>

											<div class="form-group row">
												<label class="col-lg-3 col-form-label form-control-label">경기장
													주소</label>
												<div class="col-lg-9">
													<div name="stadiumAddr" id="stadiumAddr"
														class="form-control">${tVo.sVo.stadiumAddr}</div>
												</div>
											</div>

											<div class="form-group row">
												<label class="col-lg-3 col-form-label form-control-label">경기타입</label>
												<div class="col-lg-9">
													<div name="stadiumType" id="stadiumType"
														class="form-control">${tVo.sVo.stadiumType}</div>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-lg-3 col-form-label form-control-label">매치상대</label>
												<div class="col-lg-9">
													<div name="away" id="away" class="form-control">${aTVo.teamName}
													</div>
												</div>
											</div>

											<div class="form-group row"
												style="border-top: 2px solid #14abef">
												<div class="col-lg-2" style="margin-top: 10px"></div>
												<div class="col-lg-2" style="margin-top: 10px"></div>
												<div class="col-lg-2" style="margin-top: 10px">
													<div name="dueDate" id="dueDate" class="form-control"
														style="background-color: rgb(175, 171, 171, 0.5)">
														총인원:&nbsp;&nbsp;<span id="totalNum"></span>
													</div>
												</div>
												<div class="col-lg-2" style="margin-top: 10px">
													<div name="dueDate" id="dueDate" class="form-control"
														style="background-color: rgb(175, 171, 171, 0.5)">
														투표인원:&nbsp;&nbsp;<span id="voteNum"></span>
													</div>
												</div>
												<div class="col-lg-2" style="margin-top: 10px">
													<div name="dueDate" id="dueDate" class="form-control"
														style="background-color: rgb(175, 171, 171, 0.5)">
														참석인원:&nbsp;&nbsp;<span id="attNum"></span>
													</div>
												</div>
												<div class="col-lg-2" style="margin-top: 10px">
													<div name="dueDate" id="dueDate" class="form-control"
														style="background-color: rgb(175, 171, 171, 0.5)">
														불참인원:&nbsp;&nbsp;<span id="noAttNum"></span>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<br>
					<c:choose>
						<c:when test="${playTime>'0'}">
							<h2 style="text-align: center">경기결과입니다.</h2>
							<div class="col-lg-12">
								<div class="card">
									<div class="card-body">
										<ul
											class="nav nav-tabs nav-tabs-primary top-icon nav-justified">
											<li class="nav-item"><a href="javascript:void();"
												data-target="#editUserInfo" data-toggle="pill"
												class="nav-link active"><i class="icon-note"></i> <span
													class="hidden-xs">경기결과</span></a></li>
										</ul>
										<form action="matchResult.do" method="post">
											<div class="tab-content p-3">
												<div class="tab-pane active" id="editUserInfo">
													<div class="form-group row">
														<label class="col-lg-3 col-form-label form-control-label">홈팀
															점수</label>
														<div class="col-lg-9">
															<input type="text" name="homeScore" id="homeScore"
																class="form-control form-control-rounded" value="">
														</div>
													</div>

													<div class="form-group row">
														<label class="col-lg-3 col-form-label form-control-label">어웨이팀
															점수</label>
														<div class="col-lg-9">
															<input type="text" name="awayScore" id="awayScore"
																class="form-control form-control-rounded" value="">
														</div>
													</div>
												</div>
											</div>
											<div class="tab-content p-3">
												<div class="tab-pane active" id="editUserInfo">
													<div class="form-group row">
														<label class="col-lg-3 col-form-label form-control-label">홈팀
															에게준 매너점수</label>
														<div class="col-lg-9">
															<input type="text" name="toHomeMannerScore"
																id="toHomeMannerScore"
																class="form-control form-control-rounded"
																value="${vVo.mVo.mrVo.toHomeMannerScore}"
																readonly="readonly">
														</div>
													</div>

													<div class="form-group row">
														<label class="col-lg-3 col-form-label form-control-label">어웨이팀
															에게 준 매너점수</label>
														<div class="col-lg-9">
															<input type="text" name="toAwayMannerScore"
																id="toAwayMannerScore"
																class="form-control form-control-rounded" value="">
														</div>
													</div>
												</div>
											</div>
											<div class="form-group row" style="text-align: right;">
												<label class="col-lg-3 col-form-label form-control-label"></label>
												<div class="col-lg-9">
													<input type="reset" class="btn btn-secondary"
														value="Cancel">
													<button type="submit" id="submitBtn"
														class="btn btn-light px-5">
														<i class="icon-lock"></i>경기결과 기입
													</button>
												</div>
											</div>
										</form>
									</div>
								</div>
							</div>
						</c:when>
						<c:when test="${playTime<'0'}">
							<div class="row" style="text-align: center; background-color: rgba(0, 0, 0, .2); box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1)">
								<h5  style="margin:20px auto">팀 참여도와 선수 능력치에 따라서 선발 라인업을 추천해드립니다.</h5>
							</div>
							<div class="row" style="background-color: rgba(0, 0, 0, .2); box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1)">
								<div class="col-lg-6"></div>
								<div class="col-lg-6">


									<form action="matchAndSquad.do" method="post">
										<div class="form-group row">
											<div class="col-lg-3"></div>
										</div>
										<div class="form-group row">
											<div class="col-lg-3">팀 참여도</div>
											<div class="col-lg-9">
												<input type="text" id="participationIndex"
													name="participationIndex" class="form-control" value="${participationIndex}">
											</div>
										</div>
										<div class="form-group row">
											<div class="col-lg-3">선수 능력치</div>
											<div class="col-lg-9">
												<input type="text" id="totalAbilityIndex"
													name="totalAbilityIndex" class="form-control" value="${totalAbilityIndex}">
											</div>
										</div>

										<div class="form-group row">
											<div class="col-lg-6"></div>
											<div class="col-lg-6" style="text-align: right">
												<input type="reset" id="playerInfoChageReset"
													class="btn btn-secondary" value="취소하기"> <input
													type="submit" id="playerInfoChangeSubmit"
													class="btn btn-primary" value="추천스쿼드">
											</div>


										</div>
									</form>

								</div>
							</div>
							<br>
							<div class="row">
								<div class="col-lg-6">
									<div class="card">
										<div class="card-body">
											<h5 class="card-title" align="center" style="font-size: 20px">추천
												선발명단</h5>
											<div class="table-responsive">
												<table class="table table-hover">
													<thead>
														<tr>
															<th scope="col" style="font-size: 15px;">No.</th>
															<th scope="col" style="font-size: 15px;">이름</th>
															<th scope="col" style="font-size: 15px;">ID</th>
															<th scope="col" style="font-size: 15px;">가중치점수</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach items="${auList}" var="au" varStatus="status">
															<c:choose>
																<c:when test="${status.count == pPlayerNum}">
																	<tr>
																		<th scope="row"
																			style="text-align:center; background-repeat: no-repeat;
	background-size : cover; background-image: url('ours/${au.photo}'); "><div
																				style="background-color: rgb(175, 171, 171, 0.7)">${status.count}</div></th>
																		<td>${au.name}</td>
																		<td>${au.userId}</td>
																		<td>${au.pVo.total}</td>
																	</tr>
													</tbody>

												</table>
											</div>
										</div>
									</div>
								</div>
						</c:when>

						<c:when test="${status.count == pPlayerNumPlusOne}">
							<div class="col-lg-6">
								<div class="card"
									style="background-color: rgba(0, 0, 0, .1); box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1)">
									<div class="card-body">
										<h5 class="card-title" align="center" style="font-size: 20px">후보
											명단</h5>
										<div class="table-responsive">
											<table class="table table-hover">
												<thead>
													<tr>
														<th scope="col" style="font-size: 15px;">No.</th>
														<th scope="col" style="font-size: 15px;">이름</th>
														<th scope="col" style="font-size: 15px;">ID</th>
														<th scope="col" style="font-size: 15px;">가중치점수</th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<th scope="row"
															style="text-align:center; background-repeat: no-repeat;
	background-size : cover; background-image: url('ours/${au.photo}'); "><div
																style="background-color: rgb(175, 171, 171, 0.7)">${status.count}</div></th>
														<td>${au.name}</td>
														<td>${au.userId}</td>
														<td>${au.pVo.total}</td>
													</tr>
													</c:when>

													<c:when test="${status.last}">
														<tr>
															<th scope="row"
																style="text-align:center; background-repeat: no-repeat;
	background-size : cover; background-image: url('ours/${au.photo}'); "><div
																	style="background-color: rgb(175, 171, 171, 0.7)">${status.count}</div></th>
															<td>${au.name}</td>
															<td>${au.userId}</td>
															<td>${au.pVo.total}</td>
														</tr>
												</tbody>

											</table>
										</div>
									</div>
								</div>
							</div>
		</div>

		</c:when>

		<c:otherwise>
			<tr>
				<th scope="row"
					style="text-align:center; background-repeat: no-repeat;
	background-size : cover; background-image: url('ours/${au.photo}'); "><div
						style="background-color: rgb(175, 171, 171, 0.7)">${status.count}</div></th>
				<td>${au.name}</td>
				<td>${au.userId}</td>
				<td>${au.pVo.total}</td>
			</tr>
		</c:otherwise>



		</c:choose>

		</c:forEach>

		</c:when>
		</c:choose>

		</c:when>

		<c:otherwise>
			<div class="jumbotron">
				<h1>현재 가능한 경기가 없습니다.</h1>
			</div>
		</c:otherwise>
		</c:choose>
	</div>

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
	<!--End wrapper-->



</body>
</html>
