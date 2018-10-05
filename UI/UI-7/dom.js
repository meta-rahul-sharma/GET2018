function removeIfChildExist() {
    var form = document.getElementById("form");
    var childCount = form.childElementCount;
    
    if(childCount > 9) {
        form.removeChild(form.children[7]);
        form.removeChild(form.children[7]);
    }
    
}

function selectedState() {
    
    removeIfChildExist();
    
    var selectBox = document.getElementById("state");
    var selectedValue = selectBox.options[selectBox.selectedIndex].value;
    
    if(selectedValue === "rajasthan") {
        addDescriptor();
        addWebSiteName();
    } else if(selectedValue === "haryana") {
        addZipCode();
        addHosting();
    } else if(selectedValue === "maharastra") {
        addDescriptor();
        addZipCode();
    }
}


function addWebSiteName() {
    var x = document.createElement("div"),
     y = document.createElement("div");
    x.setAttribute("class", "signUpFormRow");
    y.setAttribute("class", "signUpTag");

    var label = document.createElement("label");
    var labelText = document.createTextNode("Website or domain name");
    x.appendChild(y);
    label.appendChild(labelText);
    y.appendChild(label);

    var z = document.createElement("div"),
    icon = document.createElement("i"),
    urlBox = document.createElement("input"),
    span = document.createElement("span");
    icon.setAttribute("class", "fa fa-globe singUpIcon");
    urlBox.setAttribute("type", "text");
    urlBox.setAttribute("id", "domainName");
    span.setAttribute("id", "urlSpan");
    urlBox.setAttribute("onblur", "isUrl(id, 'urlSpan')");
    z.setAttribute("class", "signUpIconAndContent");
    x.appendChild(z);
    z.appendChild(icon);
    z.appendChild(urlBox);
    z.appendChild(span);
    document.getElementById('form').insertBefore(x, document.getElementById('form').children[7]);
}

function addDescriptor() {
    var x = document.createElement("div"),
     y = document.createElement("div");
    x.setAttribute("class", "signUpFormRow");
    y.setAttribute("class", "signUpTag");

    var label = document.createElement("label");
    var labelText = document.createTextNode("Project Description");
    x.appendChild(y);
    label.appendChild(labelText);
    y.appendChild(label);

    var z = document.createElement("div"),
    icon = document.createElement("i"),
    descriptionBox = document.createElement("textarea");
    descriptionBox.setAttribute("id", "description");
    icon.setAttribute("class", "fa fa-pencil singUpIcon");
    
    z.setAttribute("class", "signUpIconAndContent");
    x.appendChild(z);
    z.appendChild(icon);
    z.appendChild(descriptionBox);
    document.getElementById('form').insertBefore(x, document.getElementById('form').children[7]);
}

function addZipCode() {
    var x = document.createElement("div"),
     y = document.createElement("div");
    x.setAttribute("class", "signUpFormRow");
    y.setAttribute("class", "signUpTag");

    var label = document.createElement("label");
    var labelText = document.createTextNode("Zip Code");
    x.appendChild(y);
    label.appendChild(labelText);
    y.appendChild(label);

    var z = document.createElement("div"),
    icon = document.createElement("i"),
    zipBox = document.createElement("input"),
    span = document.createElement("span");
    icon.setAttribute("class", "fa fa-home singUpIcon");
    zipBox.setAttribute("type", "text");
    zipBox.setAttribute("id", "zipcode");
    zipBox.setAttribute("onkeypress", "return isNumber(event)");
    zipBox.setAttribute("maxlength", "6");
    span.setAttribute("id", "urlSpan");
    z.setAttribute("class", "signUpIconAndContent");
    x.appendChild(z);
    z.appendChild(icon);
    z.appendChild(zipBox);
    z.appendChild(span);
    document.getElementById('form').insertBefore(x, document.getElementById('form').children[7]);
}

function addHosting() {
    var x = document.createElement("div"),
     y = document.createElement("div");
    x.setAttribute("class", "signUpFormRow");
    y.setAttribute("class", "signUpTag");

    var label = document.createElement("label");
    var labelText = document.createTextNode("Website or domain name");
    x.appendChild(y);
    label.appendChild(labelText);
    y.appendChild(label);

    var z = document.createElement("div"),
    radioYes = document.createElement("input"),
    radioNo = document.createElement("input"),
    spanYes = document.createElement("span"),
    spanNo =  document.createElement("span"),
    breakElement = document.createElement("br");
    radioYes.setAttribute("type", "radio");
    radioNo.setAttribute("type", "radio");
    radioYes.setAttribute("id", "hosting");
    radioNo.setAttribute("id", "hosting");
    radioYes.setAttribute("name", "hosting");
    radioNo.setAttribute("name", "hosting");
    spanYes.textContent = "Yes";
    spanNo.textContent = "No";
    z.setAttribute("class", "signUpIconAndContent");
    x.appendChild(z);
    z.appendChild(radioYes);
    z.appendChild(spanYes);
    z.appendChild(breakElement);
    z.appendChild(radioNo);
    z.appendChild(spanNo);
    document.getElementById('form').insertBefore(x, document.getElementById('form').children[7]);
}

function validateSignUpForm() {
	var result = true,
    errorMessage = "",
    removalbalChildFirst = document.getElementById('form').children[7],
    removalbalChildSecond = document.getElementById('form').children[8];
    
	if(!validateName("firstName", "firstNameSpan")) {
        errorMessage = "firstName : Name Details Invalid\n";
        result = false;
    }
    if(!validateName("lastName", "lastNameSpan") ) {
        errorMessage = errorMessage + "lastName : Name Details Invalid\n";
        result = false;
    }
    if(!validateEmail("email", "emailSpan")) {
        errorMessage = errorMessage + "email : Email Details are Incorrect\n";  
        result = false;
    }
    if(!validateName("city", "citySpan") ) {
        errorMessage = errorMessage + "city : city Details Invalid\n";
        result = false;
    }
    
    var selectBox = document.getElementById("state");
    var selectedValue = selectBox.options[selectBox.selectedIndex].value;
    
    if(selectedValue === "rajasthan") {
        if(!isUrl("domainName", "urlSpan")) {
         errorMessage = errorMessage + "url : url Details Incorrect\n";
        }   
    } 
    
    if(result) {
        alert("Successfully Submitted");
        storeFormOnLocal();
    } else {
        alert(errorMessage);    
    }
    
	return result;
}

function storeFormOnLocal() {
    var firstName = document.getElementById("firstName");
    localStorage.setItem("firstName", firstName.value);
    
    var lastName = document.getElementById("lastName");
    localStorage.setItem("lastName", lastName.value);
    
    var email = document.getElementById("email");
    localStorage.setItem("email", email.value);
    
    var phoneNumber = document.getElementById("phoneNumber");
    localStorage.setItem("phoneNumber", phoneNumber.value);
    
    var address = document.getElementById("address");
    localStorage.setItem("address", address.value);
    
    var city = document.getElementById("city");
    localStorage.setItem("city", city.value);
    
    var state = document.getElementById("state");
    localStorage.setItem("state", state.value);
    
    if(state.value === "rajasthan") {
        var domainName = document.getElementById("domainName");
    localStorage.setItem("domainName", domainName.value);
        
        var description = document.getElementById("description");
    localStorage.setItem("description", description.value);
        
    } else if(state.value === "haryana") {
        var zipcode = document.getElementById("zipcode");
    localStorage.setItem("zipcode", zipcode.value);
        
        var hosting = document.getElementById("hosting");
    localStorage.setItem("hosting", hosting.value);
        
    } else if(state.value === "maharastra") {
        var zipcode = document.getElementById("zipcode");
    localStorage.setItem("zipcode", zipcode.value);
        
        var hosting = document.getElementById("hosting");
    localStorage.setItem("hosting", hosting.value);
    
    }
}

function fetchLocalStroageDetails() {
    debugger;
    var archive = [],
        keys = Object.keys(localStorage),
        i = 0, key;

    for (; key = keys[i]; i++) {
        archive.push( key + '=' + localStorage.getItem(key));
        
        if(localStorage.getItem(key) != null && localStorage.getItem(key) != "") {
        
            var x = document.createElement("div"),
             y = document.createElement("div");
            x.setAttribute("class", "signUpFormRow");
            y.setAttribute("class", "signUpTag");
            var label = document.createElement("p");
            label.textContent = key;
            x.appendChild(y);
            y.appendChild(label);

            var z = document.createElement("div"),
            zipBox = document.createElement("p");
            zipBox.textContent = localStorage.getItem(key);
            z.setAttribute("class", "signUpIconAndContent");
            x.appendChild(z);
            z.appendChild(zipBox);
            document.getElementById('formDetails').appendChild(x);
        }
    }

    return archive;
}