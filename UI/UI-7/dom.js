function removeIfChildExist() {
    var form = document.getElementById("form");
    var childCount = form.childElementCount;
    
    if(childCount > 9) {
        form.removeChild(form.children[8]);
        form.removeChild(form.children[8]);
    }
    
}

function selectedState() {
    
    removeIfChildExist();
    
    var selectBox = document.getElementById("state");
    var selectedValue = selectBox.options[selectBox.selectedIndex].value;
    
    if(selectedValue === "rajasthan") {
        addWebSiteName();
        addDescriptor();
    } else if(selectedValue === "haryana") {
        addZipCode();
        /*addHosting();*/
    } else if(selectedValue === "maharastra") {
        
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
    document.getElementById('form').appendChild(x);
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
    icon.setAttribute("class", "fa fa-pencil singUpIcon");
    
    z.setAttribute("class", "signUpIconAndContent");
    x.appendChild(z);
    z.appendChild(icon);
    z.appendChild(descriptionBox);
    document.getElementById('form').appendChild(x);
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
    document.getElementById('form').appendChild(x);
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
    icon = document.createElement("i"),
    urlBox = document.createElement("input"),
    span = document.createElement("span");
    icon.setAttribute("class", "fa fa-globe singUpIcon");
    urlBox.setAttribute("type", "text");
    urlBox.setAttribute("id", "hosting");
    span.setAttribute("id", "urlSpan");
    urlBox.setAttribute("onblur", "isUrl(id, 'urlSpan')");
    z.setAttribute("class", "signUpIconAndContent");
    x.appendChild(z);
    z.appendChild(icon);
    z.appendChild(urlBox);
    z.appendChild(span);
    document.getElementById('form').appendChild(x);
}