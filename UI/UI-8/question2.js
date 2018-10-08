function removeConsecutiveRepeatingString(inputString) {
    var i = 0;
    while(i < inputString.length - 1) {
        var n = 0;
        var j = i;
        while(inputString.charAt(j) == inputString.charAt(j + 1)) {
            n++;
            j++;
        }
            
        if(n > 0) {
            inputString = inputString.substring(0, i) + inputString.substring(i + n + 1, inputString.length);
            console.log(inputString);
            i = -1;
        }

        i++;
    }
    
    return inputString;
}