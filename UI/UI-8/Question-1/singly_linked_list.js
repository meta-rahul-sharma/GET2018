function Node(data) {
    this.data = data;
    this.next = null;
}

function LinkedList() {
    this.head = null; 
}

LinkedList.prototype.addElement = function(element) { 
    var node = new Node(element); 
    var current; 

    if (this.head == null) 
        this.head = node; 
    else { 
        current = this.head; 

        while (current.next) { 
            current = current.next; 
        } 

        current.next = node; 
    } 
};

LinkedList.prototype.deleteElement = function(element) { 
    var index = this.searchElement(element);
    if (index == -1) 
        return false; 
    else { 

        var current, previous, i = 0; 
        current = this.head; 
        previous = current; 

        if (index == 0) { 
            this.head = current.next; 
        } else { 
            while (i < index) { 
                i++; 
                previous = current; 
                current = current.next; 
            } 

            previous.next = current.next; 
        } 

        return true; 
    } 
};

LinkedList.prototype.searchElement = function(element) {
    var current = this.head; 
    var index = 0;
    var flag = false;

    while (current != null) { 
        if (current.data == element) { 
            flag = true;
            break; 
        }
        index++;
        current = current.next; 
    }
    if(flag)
        return index;
    else
        return -1; 
};

LinkedList.prototype.printList = function() { 
    var curr = this.head; 
    var str = ""; 
    while (curr) { 
        str = str + curr.data + " "; 
        curr = curr.next; 
    } 
    console.log('The list is....');
    console.log(str); 
}; 
