package de.tu_dortmund.vki.main;

import de.tu_dortmund.vki.modules.DAP1_Uebung_01;
import de.tu_dortmund.vki.modules.DAP1_Uebung_02;
import de.tu_dortmund.vki.modules.DemoModule;
import de.tu_dortmund.vki.modules.Uebung1;
import de.tu_dortmund.vki.modules.Uebung2;
import de.tu_dortmund.vki.utils.VkiModuleManager;

public class Main {
	public static void main(String[] args) {
		// Setup VKI Module Manager
		
		VkiModuleManager manager = new VkiModuleManager();
		manager.enableAuthors();
		
		// Load your modules here
		
//		manager.loadModule(new DemoModule());
//		manager.loadModule(new Uebung1());
//		manager.loadModule(new Uebung2());
//		manager.loadModule(new DAP1_Uebung_01());
		manager.loadModule(new DAP1_Uebung_02());

		
		manager.runAll();
	}
}
