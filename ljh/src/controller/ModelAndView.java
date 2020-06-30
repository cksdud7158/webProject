package controller;

public class ModelAndView {
	// an object that returns path(string type) and isRedirect(boolean type)
	
	private String path;
	private boolean isRedirect;
	
	public ModelAndView(String path) {
		this.path = path;
	}
	public ModelAndView(String path, boolean isRedirect) {
		this.path = path;
		this.isRedirect = isRedirect;
	}
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
}
