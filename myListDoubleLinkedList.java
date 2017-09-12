
public class myListDoubleLinkedList<T> implements myList<T>{

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------

	private myNode<T> head;
	private myNode<T> tail;
	private int num_items;
	
	//-------------------------------------------------------------------
	// Basic Operation --> Create an empty myList: my_create_empty
	//-------------------------------------------------------------------
	//public myList my_create_empty(){}

	public myListDoubleLinkedList(){
		head = new myNode<>(null);
		tail = new myNode<>(null);
		head.setRight(tail);
		tail.setLeft(head);
		num_items = 0;
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Get number of integers in myList: my_get_length
	//-------------------------------------------------------------------	
	public int my_get_length(){
		return this.num_items;
	}
	
	//-------------------------------------------------------------------
	// Basic Operation --> Get integer of myList at a concrete index: my_get_element
	//-------------------------------------------------------------------
	public T my_get_element(int index) throws myException{
		
		myNode<T> current = null;
		int length = this.my_get_length();
		
		if(length - index < index) {
			current = this.tail;
			for(int i =length ; i > index; i--) {
				current = current.getLeft();
			}
		}
		else {
			current = this.head;
			for(int i = -1; i < index;i++) {
				current = current.getRight();
			}
		}
		
		
		return current.getInfo();

	}
	//-------------------------------------------------------------------
	// Basic Operation --> Add integer to myList at a concrete index: my_add_element 
	//-------------------------------------------------------------------
	public void my_add_element(int index, T element){
			myNode<T> current = null;
			myNode<T> left = null;
			myNode<T> right = null;
			
			if((this.my_get_length() + 1) - index < index) {
				current = this.tail;
				for(int i = (my_get_length() + 1); i >= index; i--) {
					if(i-1 == index) {
						right = current;
						left = right.getLeft();
					}
					if( i == index) {
						myNode<T> n = new myNode<>(element);
						n.setRight(right);
						n.setLeft(left);
						left.setRight(n);
						right.setLeft(n);
					}
					current = current.getLeft();
				}
			}
			else {
				current = this.head;
				for(int i = -1; i <= index; i++) {
					if(i+1 == index) {
						left = current;
						right = left.getRight();
					}
					if( i == index) {
						myNode<T> p = new myNode<>(element);
						p.setRight(right);
						right.setLeft(p);
						p.setLeft(left);
						
						left.setRight(p);
						
					}
					current = current.getRight();
				}
			}
			this.num_items++;
}
	
	//-------------------------------------------------------------------
	// Basic Operation --> Remove index of myList: my_remove_element 
	//-------------------------------------------------------------------	
	public void my_remove_element(int index){
		myNode<T> current = null;
		myNode<T> right = null;
		myNode<T> left = null;
		
		if((this.my_get_length() + 1) - index < index) {
			current = this.tail;
			for(int i = my_get_length(); i >= index; i--) {
				if(i-1 == index) {
					right = current;
					left = right.getLeft().getLeft();
				}
				
				if( i ==index) {
					
					right.setLeft(left);
					left.setRight(right);
				}
				current = current.getLeft();
			}
		} else {
			
				current = this.head;
			for(int i = -1; i <= index; i++) {
				if(i+1 == index) {
					left = current;
					right = left.getRight().getRight();
				}
				if(i == index) {
					left.setRight(right);
					right.setLeft(left);
				}
				current = current.getRight();
			}	
		}
		this.num_items--;
	}


	
}
