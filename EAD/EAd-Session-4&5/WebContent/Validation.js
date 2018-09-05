/**
 * Used for validation of sign up form and login form
 */
function validateName(nameId, spanId) {
	var result = true;
	var name = document.getElementById(nameId).value;
	var alphabetCondition = /^([a-zA-Z]*)$/
	document.getElementById(nameId).style.border = "2px solid green";
	document.getElementById(spanId).innerHTML = "";
	if (name.length < 3) {
		document.getElementById(spanId).innerHTML = "Length should be greater than 2";
		document.getElementById(nameId).style.border = "2px solid red";
		result = false;
	} else if(!alphabetCondition.test(name)) {
		document.getElementById(spanId).innerHTML = "Should Only contain Alphabet's";
		document.getElementById(nameId).style.border = "2px solid red";
	}
	return result;
}

function validateEmail(emailId, spanId) {
	var result = true;
	var email = document.getElementById(emailId).value;
	document.getElementById(spanId).innerHTML = "";
	var atpos = email.indexOf("@");
	var dotpos = email.lastIndexOf(".");
	document.getElementById(emailId).style.border = "2px solid green";
	if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= email.length || email.length < 7) {
		document.getElementById(spanId).innerHTML = "Not a valid e-mail address";
		document.getElementById(emailId).style.border = "2px solid red";
		result = false;
	}
	return result;
}

function validatePassword(passwordId, spanId) {
	var password = document.getElementById(passwordId).value;
	var result = false;
	document.getElementById(spanId).innerHTML = "";
	document.getElementById(passwordId).style.border = "2px solid red";
	if (password.length < 8) {
	    document.getElementById(spanId).innerHTML = "Your password must be at least 8 characters";
	} else if (password.search(/[a-z]/) < 0) {
		document.getElementById(spanId).innerHTML = "Your password must contain at least one lowercase letter.";
	} else if (password.search(/[A-Z]/) < 0) {
		document.getElementById(spanId).innerHTML = "Your password must contain at least one uppercase letter.";
	} else if (password.search(/[0-9]/) < 0) {
		document.getElementById(spanId).innerHTML = "Your password must contain at least one digit.";
	} else if(password.search(/[\!\@\#\$\%\^\&\*\(\)\_\+\.\,\;\:\-]/) < 0) {
		document.getElementById(spanId).innerHTML = "Your password must contain at least one special character.";
	} else {
		document.getElementById(passwordId).style.border = "2px solid green";
		result = true;
	}
	
	if(document.getElementById("confirmPassword").value != "") {
		validateConfirmPassword("confirmPassword", "confirmSpan");
	}
	
	return result;
}

function validateContact(contactId, spanId) {
	var contact = document.getElementById(contactId).value;
	var contactCondition = /^([0-9]*)$/
	var result = false;
	document.getElementById(spanId).innerHTML = "";
	document.getElementById(contactId).style.border = "2px solid red";
	if(!contactCondition.test(contact)) {
		document.getElementById(spanId).innerHTML = "Your contact must contain digit only";
	} else if(contact.length < 9) {
		document.getElementById(spanId).innerHTML = "Your contact must contain at least 8 numbers";
	} else {
		document.getElementById(contactId).style.border = "2px solid green";
		result = true;
	}
	return true;
}

function validateDate(dateId, spanId){
    var date = document.getElementById(dateId).value;
    var today = new Date();
    var dob = new Date(date);
    var result = true;
	
	document.getElementById(spanId).innerHTML = "";
	document.getElementById(dateId).style.border = "2px solid green";
    if (date.value == '') {
        document.getElementById(dateId).style.border = "2px solid red";
        document.getElementById(spanId).innerHTML = "Please enter the Date..!!";
        result = false;
    } else if (dob >= today) {
        document.getElementById(dateId).style.border = "2px solid red";
        document.getElementById(spanId).innerHTML = "Current or future date is not allowed";
        result = false;
    }
	return result;
}

function validateConfirmPassword(confirmPasswordId, spanId) {
	var confirmPassword = document.getElementById(confirmPasswordId).value;
	var result = true;
	document.getElementById(spanId).innerHTML = "";
	document.getElementById(confirmPasswordId).style.border = "2px solid green";
	if(confirmPassword != document.getElementById("password").value) {
		document.getElementById(spanId).innerHTML = "Password Do not Matches";
		document.getElementById(confirmPasswordId).style.border = "2px solid red";
		result = false;
	}
	return result;
}

function validateSignUpForm() {
	var result = false;
	if(validateName("firstName", "firstSpan") && validateName("lastName", "lastSpan") && validateEmail("email", "emailSpan") &&
			validatePassword("password", "passwordSpan") && validateConfirmPassword("confirmPassword", "confirmSpan") && validateContact("contact", "contactSpan")) {
		result = true;
	}
	return result;
}

function validateLoginForm() {
	var result = false;
	
	if(validateEmail("loginEmail", "loginEmailSpan") && validatePassword("loginPassword", "loginPasswordSpan")) {
		result = true;
	}
	return result;
}