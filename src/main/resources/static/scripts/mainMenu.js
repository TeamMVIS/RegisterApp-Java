document.addEventListener("DOMContentLoaded", function(event) {
	getStartTransactionActionElement().addEventListener("click", startTransactionClick());
	getViewProductsActionElement().addEventListener("click", ()=>{window.location.assign("/productListing");});
	getCreateActionElement().addEventListener("click", ()=>{window.location.assign("/employeeDetail");});
	document.getElementById("logoutImage").addEventListener("click",()=>{window.location.assign("/");});
	getProductSalesReportActionElement().addEventListener("click", salesReportClick());
	getCashierSalesReportActionElement().addEventListener("click", cashierReportClick());
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

function cashierReportClick() {
	displayError("Functionality has not yet been implemented.");
}

function getViewProductsActionElement() {
	return document.getElementById("viewProductButton");
}

function getCreateActionElement() {
	return document.getElementById("createEmployeeButton");
}

function getStartTransactionActionElement() {
	return document.getElementById("startTransactionButton");
}

function getProductSalesReportActionElement() {
	return document.getElementById("productSalesReportButton");
}

function getCashierSalesReportActionElement() {
	return document.getElementById("cashierSalesReportButton");
}