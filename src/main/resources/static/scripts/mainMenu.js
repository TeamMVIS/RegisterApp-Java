document.addEventListener("DOMContentLoaded", function(event) {
	// TODO: Anything you want to do when the page is loaded?
	document.getElementById("startTransactionButton").addEventListener("click", startTransactionClick());
	document.getElementById("viewProductButton").addEventListener("click", viewProductClick());
	document.getElementById("createEmployeeButton").addEventListener("click", createEmployeeClick());
	document.getElementById("salesReportButton").addEventListener("click", salesReportClick());
	document.getElementById("casheerReportButton").addEventListener("click", casheerReportClick());
});

function startTransactionClick() {
	clearError();

	displayError("Functionality has not yet been implemented.");
}

function viewProductClick() {
	clearError();

	location.assign("/productListing/");
}

function createEmployeeClick() {
	clearError();
	
	location.assign("/employeeDetail/");
}

function salesReportClick() {
	clearError();

	displayError("Functionality has not yet been implemented.");
}

function casheerReportClick() {
	clearError();

	displayError("Functionality has not yet been implemented.");
}

function clearError() {
	const errorMessageContainerElement = getErrorMessageContainerElement();

	if ((errorMessageContainerElement == null)
		|| errorMessageContainerElement.classList.contains("hidden")) {

		return;
	}

	errorMessageContainerElement.classList.add("hidden");

	const errorMessageDisplayElement = getErrorMessageDisplayElement();

	if (errorMessageDisplayElement != null) {
		errorMessageDisplayElement.innerHTML = "";
	}
}

function displayError(errorMessage) {
	if ((errorMessage == null) || (errorMessage === "")) {
		return;
	}

	const errorMessageDisplayElement = getErrorMessageDisplayElement();
	const errorMessageContainerElement = getErrorMessageContainerElement();

	if ((errorMessageContainerElement == null)
		|| (errorMessageDisplayElement == null)) {

		return;
	}

	errorMessageDisplayElement.innerHTML = errorMessage;
	if (errorMessageContainerElement.classList.contains("hidden")) {
		errorMessageContainerElement.classList.remove("hidden");
	}
}