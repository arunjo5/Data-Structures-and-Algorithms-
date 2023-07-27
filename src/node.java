import java.util.Scanner;

class node{
	private node yes;
	private node no;
	private String question;
	private String object;


	//Constructor sets question to blank
	public node(){
		question = "";
		object = "";
	}

	public boolean hasChildren(){
		if(yes == null && no == null){
			return false;
		}
		else return true;
	}

	public boolean hasQuestion(){
		return !question.equals("");
	}
	

	//Prints question and returns the answer if has question otherwise it asks if it is the object
	public String ask(Scanner sc){
		if(hasQuestion()){
			System.out.println(question);
		}
		else System.out.println("Is it a " + object);
		return sc.nextLine();
	}

	//getYes() returns the node in the yes variable
	public node getYes(){
		return yes;
	}

	//getNo() returns the node in the no variable
	public node getNo(){
		return no;
	}

	//hasObject returns true if this node doesnt have an object and false if it does
	public boolean hasObject(){
		return !object.equals("");
	}


	public void makeNewNode(Scanner sc){
		System.out.println("What is the Object you are thinking of?");
		String obj = sc.nextLine();
		System.out.println("What is a question that seperates it?");
		String ques = sc.nextLine();
		System.out.println("What is the answer to that question for this object?");
		String ans = sc.nextLine();
		question = ques;
		yes = new node();
		no = new node();

		if(ans.equals("yes")){
			yes.object = obj;
			no.object = object;
		}
		else{
			no.object = obj;
			yes.object = object;
		}
		object = "";
	}
}

