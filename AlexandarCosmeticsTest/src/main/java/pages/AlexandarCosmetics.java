package pages;

public class AlexandarCosmetics {
	
	private HomePage homePage;
	private LogInPage logInPage;
	
	public HomePage homePage(){
	if (homePage == null){
		homePage = new HomePage();
	}
	return homePage;
	}	
	public LogInPage logInPage() {
	if(logInPage == null) {
		logInPage = new LogInPage();			
	}
	return logInPage;
	}
}