function Node(data) {
    this.data = data;
    this.next = null;
	this.previous = null;
}
 function DoublyLinkedList() {
    this.size = 0;
    this.head = null;
	this.tail = null;
}
 DoublyLinkedList.prototype.add = function(value) {
    var node = new Node(value);
 
    if (this.head) {
        this.tail.next = node;
		node.previous = this.tail;
		this.tail = node;
    } else {
		this.head = node;
		this.tail = node;
	}
	
    this.size++; 
    return node;
};
 DoublyLinkedList.prototype.printList = function() {
	var currentNode = this.head; 
    var str = ""; 
    while (currentNode) { 
        str += currentNode.data + " "; 
        currentNode = currentNode.next; 
    } 
    console.log(str);
}
 DoublyLinkedList.prototype.remove = function(position) {
    var currentNode = this.head,
    count = 1,
    message = 'Failure: non-existent node in this list.',
    beforeNodeToDelete = null,
	afterNodeToDelete = null,
    nodeToDelete = null;
 
    if (this.size === 0 || position < 0 || position > this.size) {
        throw new Error(message);
    }
    else {
        if (position === 1) {
        this.head = currentNode.next;
		
		if(!this.head) {
			this.tail = null;
		} else {
			this.head.previous = null;
		}
    } else if (position == this.size) {
		this.tail = this.tail.previous;
		this.tail.next = null;
	} else {
		while (count < position) {
			currentNode = currentNode.next;
			count++;
		}
		
		beforeNodeToDelete = currentNode.previous;
		afterNodeToDelete = currentNode.next;
		
		beforeNodeToDelete.next = afterNodeToDelete;
		afterNodeToDelete.previous = beforeNodeToDelete;
		nodeToDelete = currentNode;
		currentNode = null;
	}
 	this.size--;
    }    
}; 