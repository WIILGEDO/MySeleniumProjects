package pages;

public class Sportklub {

	private HomePage homePage;
	private TvProgramPage tvProgramPage;
	private SkForumPage skForumPage;
	private RegistrationPage registrationPage;
	
	public HomePage homePage() {
		if (homePage == null) {
			homePage = new HomePage();
		}
		return homePage;
	}

	public TvProgramPage tvProgramPage() {
		if (tvProgramPage == null) {
			tvProgramPage = new TvProgramPage();
		}
		return tvProgramPage;
	}
	public SkForumPage skForumPage() {
		if (skForumPage == null) {
			skForumPage = new SkForumPage();
		}
		return skForumPage;
	}
	public RegistrationPage registrationPage() {
		if (registrationPage == null) {
			registrationPage = new RegistrationPage();
		}
		return registrationPage;
	}
}
