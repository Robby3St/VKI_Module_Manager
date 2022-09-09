package de.tu_dortmund.vki.utils;

public abstract class VkiModule {
	private String MODULE_NAME;
	private String MODULE_VERSION;
	private String MODULE_DATE;
	private String MODULE_LAST_EDIT_DATE;
	private String[] MODULE_AUTHORS;
	private URLSource[] MODULE_SOURCES;
	
	
	// Methods
	
	public abstract void runModule();
	
	
	// -- Getters --
	
	public String getModuleName() {
		return MODULE_NAME;
	}
	public String getModuleVersion() {
		return MODULE_VERSION;
	}
	public String getModuleDate() {
		return MODULE_DATE;
	}
	public String getModuleLastEditDate() {
		return MODULE_LAST_EDIT_DATE;
	}
	public String[] getModuleAuthors() {
		return MODULE_AUTHORS;
	}
	public URLSource[] getModuleSources() {
		return MODULE_SOURCES;
	}


	public void setModuleName(String moduleName) {
		MODULE_NAME = moduleName;
	}


	public void setModuleVersion(String moduleVersion) {
		MODULE_VERSION = moduleVersion;
	}


	public void setModuleDate(String moduleDate) {
		MODULE_DATE = moduleDate;
	}


	public void setModuleLastEditDate(String moduleLastEditDate) {
		MODULE_LAST_EDIT_DATE = moduleLastEditDate;
	}


	public void setModuleAuthors(String[] moduleAuthors) {
		MODULE_AUTHORS = moduleAuthors;
	}


	public void setModuleSources(URLSource[] moduleSources) {
		MODULE_SOURCES = moduleSources;
	}
}
