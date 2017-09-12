import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class dbManagement {

	//--------------------------------------------------
	// Attribute
	//--------------------------------------------------
	
	myList<myPlayer> players;
	
	//--------------------------------------------------
	// Constructor
	//--------------------------------------------------
	public dbManagement(int mode){

		if(mode == 1){
			players = new myListArrayList<myPlayer>();
			
		}
		if(mode == 2){
			players = new myListLinkedList<myPlayer>();
		}
		else if(mode == 3){
			players = new myListDoubleLinkedList<myPlayer>();
		}
	}
	
	//-------------------------------------------------------------------
	// 1. Problem Specific Operation --> Load a MyList from file: load_file
	//-------------------------------------------------------------------
	public void load_file(String s){				
		try {
			//1. We create the file variable
			File my_file = new File(s);
			Scanner sc = new Scanner(my_file);


			//2. We empty the list
			int size = players.my_get_length();
			for (int i = 0; i < size; i++){
				players.my_remove_element(0);
			}
			//3. We fill MyList with the content of the file
			int count = 0;
			while (sc.hasNext()){
				myPlayer player = new myPlayer(sc.next(), sc.nextInt());
				players.my_add_element(count, player);
				count = count + 1;
			}
			
			//4. We close the scanner
			sc.close();

			System.out.println("Load Operation Completed");
		} 
		catch (Exception e) {
			System.out.println("Sorry but there is no such file");
		}	
	}

	//-------------------------------------------------------------------
	// 2. Problem Specific Operation --> Display MyFile content: show_elements
	//-------------------------------------------------------------------
	public void show_elements(){
		System.out.println("Number of players in the database : " +players.my_get_length());
		
		for(int i =0; i < players.my_get_length(); i++){
			
			players.my_get_element(i).print_info();
			
		}
	}
	
	//-------------------------------------------------------------------
	// 3. Problem Specific Operation --> Check if element is in MyList: find_element
	//-------------------------------------------------------------------
	public int find_element(String s){
		System.out.println("Number of players in the database : " + players.my_get_length());
		
		for(int i =0; i < players.my_get_length(); i++){
			
			players.my_get_element(i).print_info();
			
		}
		
		return 0;

	}

	//-------------------------------------------------------------------
	// 4. Problem Specific Operation --> Show info of element in MyList: show_info
	//-------------------------------------------------------------------
	public void show_info(String s){

		for(int x =0; x < players.my_get_length(); x++){
			if(s.equals(players.my_get_element(x).get_name())){
				System.out.println("Player found at index : " +x);
				players.my_get_element(x).print_info();
				break;
			}
		
			else if(x == players.my_get_length() -1 ){
			System.out.println("Player is not in the list.");
				break;
			}
			
		}
		
	}
	
	//-------------------------------------------------------------------
	// 5. Problem Specific Operation --> Add new element to MyList: add_by_keyboard
	//-------------------------------------------------------------------
	public void add(String s, int i){
		myPlayer player = new myPlayer(s,i);
		int x = players.my_get_length();
		players.my_add_element(x, player);
	}

	//-------------------------------------------------------------------
	// 6. Problem Specific Operation --> Update element of MyList: update
	//-------------------------------------------------------------------
	public void update(String s, int g){
		for(int x =0; x < players.my_get_length(); x++){
			if(s.equals(players.my_get_element(x).get_name())){
				System.out.println("Player found at index : " +x);
				players.my_get_element(x).set_goals(g);
				break;
			}
			else if(x == players.my_get_length() -1 ){
				System.out.println("Player not found in the index.");
			}
		}
	}
	
	//-------------------------------------------------------------------
	// 7. Problem Specific Operation --> Remove element of MyList: remove_element
	//-------------------------------------------------------------------
	public void remove(String s){

		for(int x =0; x < players.my_get_length(); x++){
			if(s.equals(players.my_get_element(x).get_name())){
				System.out.println("Player found at index : " +x);
				players.my_remove_element(x);
				System.out.println("Player " +s + " removed.");
				break;
			}
			else if(x == players.my_get_length() -1 ){
				System.out.println("Player not found in the index.");
			}
		}
		
	}
	
	//-------------------------------------------------------------------
	// 8. Problem Specific Operation --> sort elements of MyList: bubble_sort
	//-------------------------------------------------------------------
	public void bubble_sort(){

		for (int i = 0; i < players.my_get_length(); i++)
			for (int j = 0; j < ((players.my_get_length() - 1) - i); j++)
			if (players.my_get_element(j+1).smaller(players.my_get_element(j)) == false) {
					players.my_add_element(j+2,players.my_get_element(j));
					players.my_remove_element(j);					
				}
		
	}
	
	//-------------------------------------------------------------------
	// 9. Problem Specific Operation --> Write a MyList to file: write_file
	//-------------------------------------------------------------------
	public void write_file(String s){

		File file = new File (s);
		try {
			PrintWriter pw = new PrintWriter("database.txt");
			for(int x =0; x < players.my_get_length();x++)
			{
			pw.println (players.my_get_element(x).get_name() + " " + players.my_get_element(x).get_goals());
			}
			pw.close ();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}		
	
}
