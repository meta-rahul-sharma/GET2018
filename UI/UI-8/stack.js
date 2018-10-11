function Node(data) {
    this.data = data;
    this.next = null;
}

function Stack() {
    this.head = null;
}

Stack.prototype.push = function(data) 
{
    var node = new Node(data);
   
    if(this.head == null) {
        this.head = node;
    } else {
        var current = this.head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = node;
    }
};

Stack.prototype.pop = function() 
{
   var failureMessage = 'Failure: Underflow exception.';
   
   if (this.head == null) {
       throw new Error(failureMessage);
   } else {
       var current = this.head;
       var beforeCurrent = null;
       while(current.next != null) {
            beforeCurrent = current;
            current = current.next;
       }
       deletedNode = current;
       if(this.head.next != null) {
            beforeCurrent.next = null;
       } else {
            this.head = null;
       }
   }
   return deletedNode;
};

Stack.prototype.peek = function()
{
    var current = this.head;
    while(current.next != null) {
       current = current.next;
    }
    return current.data;
}

Stack.prototype.isEmpty = function() 
{
   if(this.head == null) { 
       return true;
   }
   else {
       return false;
   }
};

Stack.prototype.showStackElements = function()
{
    var failureMessage = 'Failure: Underflow exception.';
   
    if (this.head == null) {
        throw new Error(failureMessage);
    } else {
        var current = this.head;
        while(current.next != null) {
            console.log(current.data);
            current = current.next;
        }
        console.log(current.data);
   }
}