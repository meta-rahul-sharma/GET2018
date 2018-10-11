function Node(data) {
   this.data = data;
   this.next = null;
}

function Queue() {
   this.front = null;
   this.rear = null;
}

Queue.prototype.enqueue = function(value) {
   var node = new Node(value);

   if (this.rear == null) {
       this.front = node;
       this.rear = node;
    }
    else {
        this.rear.next = node;
        this.rear = node;
    }
};

Queue.prototype.dequeue = function() {
   var failureMessage = 'Failure: Underflow exception.',
       deletedNode;
   
   if (this.front == null) {
       throw new Error(failureMessage);
   } else {
       if (this.front == this.rear) {
           this.rear = null;
       }
       deletedNode = this.front;
       this.front = this.front.next;
   }
   return deletedNode;
   
};

Queue.prototype.print = function() {
   var currentNode = this.front;
   
  while(currentNode) {
      console.log(currentNode.data);
      currentNode = currentNode.next;
  }
}