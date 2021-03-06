document.addEventListener("DOMContentLoaded", function(event) {
	// TODO: Anything you want to do when the page is loaded?
	document.getElementById("startTransactionButton").addEventListener("click", startTransactionClick());
	document.getElementById("viewProductButton").addEventListener("click", viewProductClick());
	document.getElementById("createEmployeeButton").addEventListener("click", createEmployeeClick());
	document.getElementById("salesReportButton").addEventListener("click", salesReportClick());
	document.getElementById("cashierReportButton").addEventListener("click", casheerReportClick());
});

function startTransactionClick() {
	displayError("Functionality has not yet been implemented.");
}

function viewProductClick() {
	window.location.assign("/productListing/");
}

function createEmployeeClick() {
	window.location.assign("/employeeDetail/");
}

function salesReportClick() {
	displayError("Functionality has not yet been implemented.");
}

function casheerReportClick() {
	displayError("Functionality has not yet been implemented.");
}