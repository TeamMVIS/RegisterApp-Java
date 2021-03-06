document.addEventListener("DOMContentLoaded", function(event) {
	// TODO: Anything you want to do when the page is loaded?
	const FormEmployeeID = getEmployeeIdEditElement();
	FormEmployeeID.focus();
	FormEmployeeID.select();
});

function validateForm() {
	const FormEmployeeID = getEmployeeIdEditElement().value;
	const FormEmployeePass = getPasswordEditElement().value;
	var Validated = true;
	if(isNaN(Number(FormEmployeeID)) || (Number(FormEmployeeID) <= 0)){
		displayError("Please enter a valid employee Id.");
		FormEmployeeID.focus();
		FormEmployeeID.select();

		Validated = false;
	}
	
	if(FormEmployeePass.trim() == "" || FormEmployeePass == null) {
		displayError("Please enter a password.");
		FormEmployeePass.focus();
		FormEmployeePass.select();

		Validated = false;
	}
	
	return Validated;
}

function getPasswordEditElement(){
	return document.getElementById("Pass");
}

function getEmployeeIdEditElement(){
	return document.getElementById("ID");
}
