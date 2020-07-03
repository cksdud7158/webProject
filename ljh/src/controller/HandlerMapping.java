package controller;

public class HandlerMapping {
	// singleTone
	private static HandlerMapping handler = new HandlerMapping();

	private HandlerMapping() {
	}

	public static HandlerMapping getInstance() {
		return handler;
	}

	// mapping controller, return controller to dispatcher
	public Controller createController(String command) {
		Controller controller = null;

		if (command.equals("login.do")) {
			controller = new LoginController();
			System.out.println("LoginController 컨트롤러 생성");

		} else if (command.equals("register.do")) {
			controller = new RegisterController();
			System.out.println("RegisteController 컨트롤러 생성");

		} else if (command.equals("updateUser.do")) {
			controller = new UpdateUserController();
			System.out.println("UpdateUserController 컨트롤러 생성");

		}else if (command.equals("updatePlayerInfo.do")) {
			controller = new updatePlayerInfoController();
			System.out.println("updatePlayerInfoController 컨트롤러 생성");

		}else if (command.equals("logout.do")) {
			controller = new LogoutController();
			System.out.println("LogoutController() 컨트롤러 생성");
		}else if (command.equals("makeVote.do")) {
			controller = new MakeVoteController();
			System.out.println("MakeVoteController() 컨트롤러 생성");
		}else if (command.equals("vote.do")) {
			controller = new VoteController();
			System.out.println("VoteController() 컨트롤러 생성");
		}else if (command.equals("voteBulletin.do")) {
		controller = new VoteBulletinController();
			System.out.println("VoteBulletinController 컨트롤러 생성");
	}else if (command.equals("myTeamList.do")) {
		controller = new myTeamListController();
		System.out.println("myTeamListControlle 컨트롤러 생성");
	}else if (command.equals("teamHome.do")) {
		controller = new teamHomeController();
		System.out.println("teamHomeControlle 컨트롤러 생성");
	}else if (command.equals("matchHistory.do")) {
		controller = new matchHistoryController();
		System.out.println("matchHistoryControlle 컨트롤러 생성");
	}else if(command.equals("showAllMember.do")) {
		controller = new showAllMemberController();
		System.out.println("showAllMember 컨트롤러 생성");
	}else if(command.equals("ToHome.do")) {
		controller = new ToHomeController();
		System.out.println("ToHome 컨트롤러 생성");
	}else if(command.equals("matchAndSquad.do")) {
		controller = new MatchAndSquadController();
		System.out.println("MatchAndSquadController 컨트롤러 생성");
	}else if(command.equals("matchResult.do")) {
		controller = new MatchResultController();
		System.out.println("matchResultController 컨트롤러 생성");
	}else if(command.equals("AllTeam.do")) {
        controller = new AllTeamController();
        System.out.println("AllTeam 컨트롤러 생성");
    }else if(command.equals("searchTeam.do")) {
        controller = new SearchTeamController();
        System.out.println("SearchTeam 컨트롤러 생성");
    }else if(command.equals("RequestToJoin.do")) {
        controller = new RequestToJoinController();
        System.out.println("RequestToJoin 컨트롤러 생성");
    }else if(command.equals("AllJoinRequest.do")) {
        controller = new AllJoinRequestController();
        System.out.println("AllJoinRequest 컨트롤러 생성");
    }else if(command.equals("AllowToJoin.do")) {
        controller = new AllowToJoinController();
        System.out.println("AllowToJoin 컨트롤러 생성");
    }else if(command.equals("RejectToJoin.do")) {
        controller = new RejectToJoinController();
        System.out.println("RejectToJoin 컨트롤러 생성");
    }else if(command.equals("createTeam.do")) {
		controller = new createTeamController();
		System.out.println("createTeam 컨트롤러 생성");
	}else if(command.equals("findMatch.do")) {
		controller = new FindMatchController();
		System.out.println("findMatchController 컨트롤러 생성");
	}else if(command.equals("requestToPlay.do")) {
			controller = new requestToPlayController();
			System.out.println("requestToPlayController 컨트롤러 생성");
		}
	
		return controller;
	}
}
