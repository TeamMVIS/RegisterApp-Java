package edu.uark.registerapp.controllers;

public abstract class BaseController {
	protected String buildInitialQueryParameter(
		final String name,
		final String value
	) {

		return this.buildQueryParameter(name, value, true);
	}

	protected String buildAdditionalQueryParameter(
		final String name,
		final String value
	) {
		//comment
		return this.buildQueryParameter(name, value, false);
	}

	// Helper methods
	private String buildQueryParameter(
		final String name,
		final String value,
		final boolean isInitial
	) {
		//Comment
		//Comment 2
		return (isInitial ? "?" : "&")
			.concat(name)
			.concat("=")
			.concat(value);
	}
}
