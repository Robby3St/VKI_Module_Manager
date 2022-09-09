package de.tu_dortmund.vki.main;

import de.tu_dortmund.vki.modules.DemoModule;
import de.tu_dortmund.vki.modules.Uebung1;
import de.tu_dortmund.vki.utils.VkiModuleManager;

public class Main {
	public static void main(String[] args) {
		// Setup VKI Module Manager
		
		VkiModuleManager manager = new VkiModuleManager();
		manager.enableAuthors();
		
		// Load your modules here
		
		manager.loadModule(new DemoModule());
		manager.loadModule(new Uebung1());
		
		manager.runAll();
	}
}
