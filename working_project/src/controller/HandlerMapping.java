package controller;

public class HandlerMapping {
	//singleTone
	private static HandlerMapping handler = new HandlerMapping();
	private HandlerMapping() {}
	public static HandlerMapping getInstance() {
		return handler;
	}
	
	// mapping controller, return controller to dispatcher
	public Controller createController(String command) {
		Controller controller = null;
		
		if(command.equals("login.do")) {
			controller = new LoginController();
			System.out.println("LoginController 컨트롤러 생성");

		}
		
		return controller;
	}
}
