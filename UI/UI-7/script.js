function validateName(nameId, spanId) {
	var result = true;
	var name = document.getElementById(nameId).value;
	var alphabetCondition = /^([a-zA-Z]*)$/
	document.getElementById(nameId).style.border = "2px solid green";
	document.getElementById(spanId).innerHTML = "";
	if (name.length < 3 || !alphabetCondition.test(name)) {
		document.getElementById(spanId).innerHTML = "only alphabet's and length > 2";
		document.getElementById(nameId).style.border = "2px solid red";
		result = false;
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
	if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= email.length || email.length < 6) {
		document.getElementById(spanId).innerHTML = "*@*.** needed so Invalid";
		document.getElementById(emailId).style.border = "2px solid red";
		result = false;
	}
	return result;
}

function validateContact(contactId, spanId) {
	var contact = document.getElementById(contactId).value;
	var contactCondition = /^([0-9]*)$/
	var result = false;
	document.getElementById(spanId).innerHTML = "";
	document.getElementById(contactId).style.border = "2px solid red";
	if(contact.length != 10) {
		document.getElementById(spanId).innerHTML = "must contain  10 numbers";
	} else {
		document.getElementById(contactId).style.border = "2px solid green";
		result = true;
	}
	return true;
}

function isUrl(urlId, spanId)
{
    var isUrl = true;
    var urlValue = document.getElementById(urlId).value;
    document.getElementById(spanId).innerHTML = "";
    document.getElementById(urlId).style.border = "2px solid green";
    regexp =  /^(?:(?:https?|ftp):\/\/)?(?:(?!(?:10|127)(?:\.\d{1,3}){3})(?!(?:169\.254|192\.168)(?:\.\d{1,3}){2})(?!172\.(?:1[6-9]|2\d|3[0-1])(?:\.\d{1,3}){2})(?:[1-9]\d?|1\d\d|2[01]\d|22[0-3])(?:\.(?:1?\d{1,2}|2[0-4]\d|25[0-5])){2}(?:\.(?:[1-9]\d?|1\d\d|2[0-4]\d|25[0-4]))|(?:(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)(?:\.(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)*(?:\.(?:[a-z\u00a1-\uffff]{2,})))(?::\d{2,5})?(?:\/\S*)?$/;
    if (!regexp.test(urlValue))
    {   
        document.getElementById(spanId).innerHTML = "Url is Incorrect";
		document.getElementById(urlId).style.border = "2px solid red";
        isUrl = false;
    }
    return isUrl;
}

function validateSignUpForm() {
	var result = false;
	if(validateName("firstName", "firstSpan") && validateName("lastName", "lastSpan") && validateEmail("email", "emailSpan") && validateContact("contact", "contactSpan")) {
		result = true;
	}
	return result;
}

function isNumber(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        return false;
    }
    return true;
}