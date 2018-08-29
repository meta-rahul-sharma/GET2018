/**
 * Used for validation of sign up form
 */
function validateName(nameId) {
	var result = true;
	var name = document.getElementById(nameId).value;
	document.getElementById(nameId).style.border = "2px solid green";
	if (name.length < 3) {
		alert(name + " length should be greater than 2");
		document.getElementById(nameId).style.border = "2px solid red";
		result = false;
	}
	return result;
}

function validateForm() {

}

function validateEmail(emailId) {
	var result = true;
	var email = document.getElementById(emailId).value;
	var atpos = email.indexOf("@");
	var dotpos = email.lastIndexOf(".");
	document.getElementById(emailId).style.border = "2px solid green";
	if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= email.length || email.length < 7) {
		alert("Not a valid e-mail address");
		document.getElementById(emailId).style.border = "2px solid red";
		result = false;
	}
	return result;
}

function validatePassword(passwordId) {
	var password = document.getElementById(passwordId).value;
	var result = false;
	document.getElementById(passwordId).style.border = "2px solid red";
	if (password.length < 8) {
	    alert("Your password must be at least 8 characters")
	} else if (password.search(/[a-z]/) < 0) {
		alert("Your password must contain at least one lowercase letter.");
	} else if (password.search(/[A-Z]/) < 0) {
		alert("Your password must contain at least one uppercase letter.");
	} else if (password.search(/[0-9]/) < 0) {
		alert("Your password must contain at least one digit.");
	} else if(password.search(/[\!\@\#\$\%\^\&\*\(\)\_\+\.\,\;\:\-]/) < 0) {
		alert("Your password must contain at least one special character.");
	} else {
		document.getElementById(passwordId).style.border = "2px solid green";
		result = true;
	}
	return result;
}

function validateContact(contactId) {
	var contact = document.getElementById(contactId).value;
	var contactCondition = /^([0-9]*)$/
	var result = false;
	document.getElementById(contactId).style.border = "2px solid red";
	if(!contactCondition.test(contact)) {
		alert("Your contact must contain digit only");
	} else if(contact.length < 9) {
		alert("Your contact must contain at least 8 numbers");
	} else {
		document.getElementById(contactId).style.border = "2px solid green";
		result = true;
	}
	return true;
}

function validateConfirmPassword(confirmPasswordId) {
	var confirmPassword = document.getElementById(confirmPasswordId).value;
	var result = true;
	document.getElementById(confirmPasswordId).style.border = "2px solid red";
	if(confirmPassword == document.getElementById("password").value) {
		alert("Password Do not Matches");
		document.getElementById(confirmPasswordId).style.border = "2px solid green";
		result = false;
	}
	return result;
}

function validateSignUpForm() {
	var result = false;
	if(validateName("firstName") && validateName("lastName") && validateEmail("email") &&
			validatePassword("password") && validateConfirmPassword("confirmPassword") && validateContact("contact")) {
		result = true;
	}
	return result;
}

function validateLoginForm() {
	var result = false;
	
	if(validateEmail("loginEmail") && validatePassword("loginPassword")) {
		result = true;
	}
	return result;
}