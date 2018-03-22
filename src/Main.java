import java.util.*;
public class Main {
	public static final int SIZE=3;
	public static Competitors[] cdetails=new Competitors[SIZE];
	public  static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		greeting();
		menu();
	}
	/**
     * This method is used to get needed details and store them in the object array
     * OPTION 1
     */
	public static void enterdetails(){
		for(int i=0;i<SIZE;i++){
			Competitors details = new Competitors();
			System.out.println("DETAILS OF THE NEW COMPETITOR");
			//enter competitor ID
			System.out.println("____________________________________________________");
			System.out.println("Enter competitor ID");
			System.out.println("____________________________________________________");
			details.setId(dataValidation());
			while(details.getId()<=0){
				System.out.println("ID should be a positive integer and it cannot be null");
				details.setId(dataValidation());
			}
			//enter competitor Name
			System.out.println("Enter competitor name");
			System.out.println("____________________________________________________");
			details.setName(sc.next());
			//enter competitor Age
			System.out.println("Enter competitor age");
			System.out.println("____________________________________________________");
			details.setAge(dataValidation());
			while(details.getAge()<=3 || details.getAge()>=100){
				System.out.println("Enter a valid age ");
				details.setAge(dataValidation());
			}
			//enter competitor Coins
			System.out.println("Enter competitor coins");
			System.out.println("____________________________________________________");
			details.setCoins(dataValidation());
			while(details.getCoins()<0){
				System.out.println("Coin value should be a positive value");
				details.setCoins(dataValidation());
			}
			//enter competitor Score
			System.out.println("Enter competitor score");
			System.out.println("____________________________________________________");
			details.setScore(dataValidation());
			while(details.getScore()<0){
				System.out.println("Score should be a positive value");
				details.setScore(dataValidation());
			}
			//enter competitor Distance
			System.out.println("Enter competitor distance");
			System.out.println("____________________________________________________");
			details.setDistance(dataValidation()); 
			while(details.getDistance()<0){
				System.out.println("Distance should be a positive value");
				details.setDistance(dataValidation());
			}
			cdetails[i]=details;
			
		}
			
		}
	/**
	 * This method is used to find the competitor with the highest Score
	 */
	
	public static void  maxScore(){
		Competitors maxScore = new Competitors();
		maxScore=cdetails[0];
		for (Competitors a:cdetails){
			if (maxScore.getScore() < a.getScore())
				maxScore= a;
				
			}
		System.out.println("________________________________________________________________________________");
		System.out.println("____________________________HIGHEST SCORE______________________________________");
		selectPri(maxScore);
		
	}
	/**
	 * This method is used to find the competitor with the highest Coins
	 */
	
	public static void maxCoins(){
		Competitors maxCoins= new Competitors();
		maxCoins=cdetails[0];
		for (Competitors j: cdetails){
			if(maxCoins.getCoins()<j.getCoins()){
				maxCoins=j;
			}
		}
			
		System.out.println("________________________________________________________________________________");
		System.out.println("____________________________HIGHEST COINS_______________________________________");
		selectPri(maxCoins);
	}
	/**
	 * This method is used to find the competitor with the highest Score
	 */
	
	public static void maxDistance(){
		Competitors maxDistance=new Competitors();
		maxDistance=cdetails[0];
		for (Competitors q: cdetails){
			if(maxDistance.getDistance()<q.getDistance()){
				maxDistance=q;
			}
		}
	
		System.out.println("________________________________________________________________________________");
		System.out.println("____________________________HIGHEST DISTANCE____________________________________");
		selectPri(maxDistance);
		}
	/**
	 * This method is used to print all the details of the competitors
	 */

	public static void printAll(){
		for(Competitors h : cdetails){ 
			
			System.out.println("_____________________________________________________________________________");
			System.out.println("Name : " + h.getName());
			System.out.println("ID : " + h.getId());
			System.out.println("Age : " + h.getAge());
			System.out.println("Score : " + h.getScore());
			System.out.println("Coins : " + h.getCoins());
			System.out.println("Distance : " + h.getDistance());
			System.out.println("_____________________________________________________________________________");
			
		}
	}
	/**
	 * This method is used to print his/her details by entering the competitor ID
	 */
	public static void selectAny(){
		System.out.println("Enter the ID ");
		int input=sc.nextInt();
		Competitors selectA=null;
		for(Competitors i:cdetails){
				if(input==i.getId()){
					selectA=i;
					selectPri(selectA);
					break;
				}
				
				
		}
		if(selectA==null){
			System.out.println("Invalid ID");
		}
		/**
		 * This method is used to $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
		 */
		
	}
	public static void selectPri(Competitors selectA){
		System.out.println("Name :"+selectA.getName());
		System.out.println("ID :"+selectA.getId());
		System.out.println("Age :"+selectA.getAge());
		System.out.println("Score :"+selectA.getScore());
		System.out.println("Coins :"+selectA.getCoins());
		System.out.println("Distance :"+selectA.getDistance());
	}
	/*
	 * This method is used to display the menu and select the options
	 */
	public static void menu(){
		System.out.println("     -------------------------------------------------------");
		System.out.println("--------------------------MENU-------------------------------------");
		System.out.println("\t Enter \"1\" -Enter details"
				+ "\n \t Enter \"2\" -To Display all details"
				+ "\n \t Enter \"3\" -To Display the details of a selected competitor"
				+ "\n \t Enter \"4\" -To Display the three winners"
				+ "\n \t Enter \"5\" -To Display a winner out three winners");
		System.out.println("------------------Enter the option number-------------------------");
		
		do{
		
		int select=sc.nextInt();
		
		switch(select){
		case 1://enter details
			enterdetails();
			break;
		case 2://display all details
			printAll();
			break;
		case 3://display the details of selected competitor
			selectAny();
			break;
		case 4://display the three winners
			maxScore();
			maxCoins();
			maxDistance();
			break;
		case 5://display one winner out of three winners
			menuthree();
			break;
		default:
			System.out.println("Enter a valid number");
			break;
		}
		System.out.println("     --------------------------------------------");
		System.out.println("-----------------------MENU---------------------------");
		System.out.println("\t Enter \"2\" - Display all details"
				+ "\n \t Enter \"3\" - Display the details of a selected competitor"
				+ "\n \t Enter \"4\" - Display the three winners"
				+ "\n \t Enter \"5\" - Display a winner out three winners");
		System.out.println("-----------Enter the option number---------------------");
		}while(sc.hasNextInt());
	
}
	/**
	 * This method is used to display the menu of displaying the all the three winners according to 
	 *  the users demand
	 */
	public static void menuthree(){
		System.out.println("------------------------------------------------------");
		System.out.println("\n \t Enter \"1\" - Competitor with highest Score");
		System.out.println("\n \t Enter \"2\" - Competitor with highest Coins");
		System.out.println("\n \t Enter \"3\" - Competitor with highest Distance");
		System.out.println("------------Enter the option number---------------------");
		int selectagain=sc.nextInt();
		switch(selectagain){
		case 1:
			//System.out.println("Competitor with the highest Score");
			maxScore();
			break;
		case 2:
			//System.out.println("Competitor with the highest Coins");
			maxCoins();
			break;
		case 3:
			//System.out.println("Competitor with the highest Distance");
			maxDistance();
			break;
		default:
			System.out.println("Invalid option number");
			break;
		}
	
	}
	/*
	 * This method is used to validate data
	 * It will display an error message when an integer is not input where  a integer should be input
	 * @return return the value contain in "num" variable
	 */
	
	 public static int dataValidation() {
	        boolean foundint = false;
	        int num = 0;
	        while (foundint == false) {
	            String input = sc.next();
	            try {
	                num = Integer.parseInt(input);
	                foundint = true;
	            } catch (NumberFormatException i) {
	                System.out.println("Input a number,not  :" + input);
	            }

	        }
	        return num;
	    }
	 /**
	  * This method is used to display the greeting
	  */
	 public static void greeting(){
	        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
	        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
	        System.out.println("%%%%%%                              *********                                        %%%%%%%");
	        System.out.println("%%%%%%                            *  WELCOME   *                                     %%%%%%%");
	        System.out.println("%%%%%%                         *        TO        *                                  %%%%%%%");
	        System.out.println("%%%%%%                      *        PP01 CW01      *                                %%%%%%%");
	        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
	        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
	    }
	/* public static int ageValidation(){
		 int age=sc.nextInt();
		 if(age<=0 || age>=100){
			 while(age<=0 || age>=100){
			 System.out.println("Enter an valid age "+age+"is not valid");
			 age=sc.nextInt();
			 }
		 }
		 else{
			 dataValidation();
		 }
		 return age;
	 }*/
	
}
