package de.tu_dortmund.vki.utils.exceptions;

public class ModuleNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public ModuleNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
