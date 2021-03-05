document.addEventListener("DOMContentLoaded", function(event) {
	// TODO: Anything you want to do when the page is loaded?
	const FormEmployeeID = document.getElementById("ID");
	FormEmployeeID.focus();
	FormEmployeeID.select();
});

function validateForm() {
	const FormEmployeeID = document.getElementById("ID").value;
	const FormEmployeePass = document.getElementById("Pass").value;
	var Validated;
	if(isNaN(FormEmployeeID) || FormEmployeeID <= 0) {
		Validated = false;
	}
	else if(FormEmployeePass == "" || FormEmployeePass == null) {
		Validated = false;
	}
	else {
		Validated = true;
	}
	return Validated;
}
