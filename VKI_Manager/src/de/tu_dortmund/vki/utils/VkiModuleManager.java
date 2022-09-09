package de.tu_dortmund.vki.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.tu_dortmund.vki.utils.exceptions.ModuleNotFoundException;


public class VkiModuleManager {
	List<VkiModule> loadedModules = new ArrayList<VkiModule>();
	private boolean enableDate = true;
	private boolean enableVersions = true;
	private boolean enableAuthors = false;
	private boolean enableLastEditDate = false;
	private boolean enableModuleSources = false;
	
	public void loadModule(VkiModule mod) {
		this.loadedModules.add(mod);
	}
	
	public void unloadModule(VkiModule mod) throws ModuleNotFoundException {
		if(!this.loadedModules.contains(mod)) {
			throw new ModuleNotFoundException("The module was not found in the loaded modules and can't be removed");
		}
		
		this.loadedModules.remove(mod);
	}
	
	public void runAll() {
		this.sayThankYou();
		
		int i = 0;
		for (VkiModule current : loadedModules) {
			printGeneralModuleInfo(current);
			System.out.print("\n");
			
			System.out.println("##### Module Output for module " + current.getModuleName() + ": \n");
			current.runModule();
			if(!(loadedModules.size() - 1 == i))
				System.out.println("\n\n");
			i++;
		}
	}
	
	// -- Private Helper Methods --
	
	private void printGeneralModuleInfo(VkiModule mod) {
		System.out.println("----- General Module Info | Module: " + mod.getModuleName() +" ------\n");
		System.out.println("Module name: " + mod.getModuleName());
		if(enableDate) {
			System.out.println("Created at: " + mod.getModuleDate());			
		}
		if(enableVersions) {
			System.out.println("Version: " + mod.getModuleVersion());
		}
		if(enableAuthors) {
			System.out.println("Authors: " + Arrays.toString(mod.getModuleAuthors()));
		}
		if(enableLastEditDate) {
			System.out.println("Last edited at: " + mod.getModuleLastEditDate());
		}
		if(enableModuleSources) {
			URLSource[] sources = mod.getModuleSources();
			int i = 0;
			
			for(URLSource source : sources) {
				System.out.println("Source " + (i + 1) + ": " + Arrays.toString(source.getSourceInfos()));
				i++;
			}
		}
	}
	
	private void sayThankYou() {
		System.out.println("|---------- Thank you, for using VKI Module Manager :)! ----------|\n");
	}
	
	// -- Getters / Setters --
	
	public void enableDate() {
		this.enableDate = true;
	}
	
	public void disableDate() {
		this.enableDate = false;
	}
	
	public void enableAuthors() {
		this.enableAuthors = true;
	}
	
	public void disableAuthors() {
		this.enableAuthors = false;
	}
	
	public void enableLastEditDate() {
		this.enableLastEditDate = true;
	}
	
	public void disableLastEditDate() {
		this.enableLastEditDate = false;
	}
	
	public void enableVersions() {
		this.enableVersions = true;
	}
	
	public void disableVersions() {
		this.enableVersions = false;
	}
	
	public void enableModuleSources() {
		this.enableModuleSources = true;
	}
	
	public void disableModuleSources() {
		this.enableModuleSources = false;
	}
}
