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
		
		if(command.equals("")) {
			System.out.println("컨트롤러 생성");
			// controller = 
		}
		
		return controller;
	}
}
