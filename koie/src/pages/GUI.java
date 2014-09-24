package pages;

import koie.core.Core;  // For � bruke denne har jeg m�tte lagt begge prosjektene i hver sin Build Path, noe som f�rer til en s�kalt Circular Dependency Error.
						// * Dette betyr kanskje at vi m� spleise prosjektene for at det skal virke -Sindre

public class GUI {

	private Core CoreClass; 		// All kommunikasjon med resten av programmet skjer med denne. -Sindre
									
	private PageHub pageHub;
	private IniPage iniPage;
	
	private boolean userIsAdmin;
	
	public GUI(Core CoreClass) { // GUI() tar i mot all informasjon som er n�dvendig ved start for hvert GUI-element -Sindre
		this.CoreClass = CoreClass;
		pageHub = new PageHub();
		}
		
	public boolean login(String email) {
		if (CoreClass.login(email)) {
			userIsAdmin = CoreClass.isAdmin;
			return true;
		}
		
		return false;
	}
}

