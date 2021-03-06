document.addEventListener("DOMContentLoaded", function(event) {
	// TODO: Anything you want to do when the page is loaded?
	const employeeIdEditElement = getEmployeeIdEditElement();
	employeeIdEditElement.focus();
	employeeIdEditElement.select();
});

function validateForm() {
	const employeeIdEditElement = getEmployeeIdEditElement();
	const FormEmployeePass = getPasswordEditElement();
	var Validated = true;
	if(isNaN(Number(employeeIdEditElement.value)) || (Number(employeeIdEditElement.value) <= 0)){
		displayError("Please enter a valid employee Id.");
		employeeIdEditElement.focus();
		employeeIdEditElement.select();

		Validated = false;
	}
	
	if(FormEmployeePass.value.trim() === "" || FormEmployeePass == null) {
		displayError("Please enter a password.");
		FormEmployeePass.focus();
		FormEmployeePass.select();

		Validated = false;
	}
	
	return Validated;
}

function getPasswordEditElement(){
	return document.getElementById("password");
}

function getEmployeeIdEditElement(){
	return document.getElementById("employeeId");
}
