package de.tu_dortmund.vki.main;

import de.tu_dortmund.vki.modules.rechnerstrukturen.FloatLoop;
import de.tu_dortmund.vki.modules.dap1.DAP1_Uebung_03;
import de.tu_dortmund.vki.modules.dap1.DAP1_Uebung_03_plus;
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
//		manager.loadModule(new DAP1_Uebung_02());
//		manager.loadModule(new DAP1_Uebung_03());
//		manager.loadModule(new DAP1_Uebung_03_plus());
		manager.loadModule(new FloatLoop());


		manager.runAll();
	}
}
