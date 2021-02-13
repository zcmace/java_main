package java_main;
public class mianClass {
	public static void main(String[] args) {
		myLinkedList <Integer> listOne = new  myLinkedList <Integer>();
		
		listOne.addFront(2);
		listOne.addEnd(3);
		listOne.addEnd(4);
		listOne.addFront(1);
		System.out.println("listOne: "+listOne);
		myLinkedList <Integer> listTwo = new  myLinkedList <Integer>();
		listTwo.addFront(2);
		listTwo.addEnd(3);
    	listTwo.addEnd(4);
		listTwo.addFront(1);
		System.out.println("listTwo: "+listTwo);
		listOne.removeEnd();
		System.out.println("listOne after removing last: "+listOne);
		listOne.concatenateList(listTwo);
		System.out.println("listOne after concatenate with listTwo: "+listOne);
		
		if(listOne.search(1))
			System.out.println("Found 1 in the list. ");
		else System.out.println("No 1 in the list. ");
		if(listOne.search(6))
			System.out.println("Found 6 in the list. ");
		else System.out.println("No 6 in the list. ");
		
 
		
		System.out.println("Middle element of "+ listOne +" is "+listOne.middleElement());
		listOne.addFront(5);
		listOne.addEnd(8);
		System.out.println("New List after inserting"+ listOne);
		System.out.println("Middle element of "+ listOne +" is "+listOne.middleElement());
		}


}
