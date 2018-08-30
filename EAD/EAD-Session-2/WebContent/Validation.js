/**
 * Used for validation of sign up form
 */
function validateName(nameId) {
	var result = true;
	var name = document.getElementById(nameId).value;
	var alphabetCondition = /^([a-zA-Z]*)$/
	document.getElementById(nameId).style.border = "2px solid green";
	document.getElementById("firstNameMessanger").innerHTML = "";
	if (name.length < 3) {
		document.getElementById("firstNameMessanger").innerHTML = "Length should be greater than 2";
		document.getElementById(nameId).style.border = "2px solid red";
		result = false;
	} else if(!alphabetCondition.test(name)) {
		document.getElementById("firstNameMessanger").innerHTML = "Should Only contain Alphabet's";
		document.getElementById(nameId).style.border = "2px solid red";
	}
	return result;
}

function validateForm() {

}

function validateEmail(emailId) {
	var result = true;
	var email = document.getElementById(emailId).value;
	document.getElementById("emailMessanger").innerHTML = "";
	var atpos = email.indexOf("@");
	var dotpos = email.lastIndexOf(".");
	document.getElementById(emailId).style.border = "2px solid green";
	if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= email.length || email.length < 7) {
		document.getElementById("emailMessanger").innerHTML = "Not a valid e-mail address";
		document.getElementById(emailId).style.border = "2px solid red";
		result = false;
	}
	return result;
}

function validatePassword(passwordId) {
	var password = document.getElementById(passwordId).value;
	var result = false;
	document.getElementById("passwordMessanger").innerHTML = "";
	document.getElementById(passwordId).style.border = "2px solid red";
	if (password.length < 8) {
	    document.getElementById("passwordMessanger").innerHTML = "Your password must be at least 8 characters";
	} else if (password.search(/[a-z]/) < 0) {
		document.getElementById("passwordMessanger").innerHTML = "Your password must contain at least one lowercase letter.";
	} else if (password.search(/[A-Z]/) < 0) {
		document.getElementById("passwordMessanger").innerHTML = "Your password must contain at least one uppercase letter.";
	} else if (password.search(/[0-9]/) < 0) {
		document.getElementById("passwordMessanger").innerHTML = "Your password must contain at least one digit.";
	} else if(password.search(/[\!\@\#\$\%\^\&\*\(\)\_\+\.\,\;\:\-]/) < 0) {
		document.getElementById("passwordMessanger").innerHTML = "Your password must contain at least one special character.";
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
	document.getElementById("contactMessanger").innerHTML = "";
	document.getElementById(contactId).style.border = "2px solid red";
	if(!contactCondition.test(contact)) {
		document.getElementById("contactMessanger").innerHTML = "Your contact must contain digit only";
	} else if(contact.length < 9) {
		document.getElementById("contactMessanger").innerHTML = "Your contact must contain at least 8 numbers";
	} else {
		document.getElementById(contactId).style.border = "2px solid green";
		result = true;
	}
	return true;
}

function validateConfirmPassword(confirmPasswordId) {
	var confirmPassword = document.getElementById(confirmPasswordId).value;
	var result = true;
	document.getElementById("confirmMessanger").innerHTML = "";
	document.getElementById(confirmPasswordId).style.border = "2px solid green";
	if(confirmPassword != document.getElementById("password").value) {
		document.getElementById("confirmMessanger").innerHTML = "Password Do not Matches";
		document.getElementById(confirmPasswordId).style.border = "2px solid red";
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