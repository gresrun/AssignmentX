import java.util.Random;
public class SlotMachineImpl {
	
	public SlotMachineImpl( ){

	}

	public static void spin (Board b) {
		Random r = new Random();
		for (int i = 0; i < 3; ++i ) {
			
			for (int j = 0; j < 3; ++j) {
				
				int num = r.nextInt(1000000);
				num = num % 31;
				
				// Call the method that maps the virtual machine 
				// to the regular machine
				num = virtualSpin( num );
				String tempString = getToken( num );
				
				b.board[i][j] = num;
				b.boardTokens[i][j] = tempString;
				
			} // end inner for loop
		} // end outer for loop
	}  // end spin()
	
	private static int virtualSpin( int num ) 
	/* This function receives an integer from 0 - 30 
	* The number corresponds to a number on the reel, 0 - 8.
	* Odds:				    Odds of getting 3 in a row		  				 Payout:
	* LUCKY7:    2 / 31     Odds of 3:  8 / 29,791   	1 / 3723    		 90% =  $3,352
	* BAR:       3 / 31     Odds of 3:  27 / 29,791  	1 / 1103			 90% =  $993
	* BARBAR:    3 / 31     Odds of 3:  27 / 29,791  	1 / 1103             90% =  $993
	* BARBARBAR: 3 / 31     Odds of 3:  27 / 29,791  	1 / 1103             90% =  $993
	* Any BAR:   9 / 31     Odds of 3: 729 / 29,791		1 / 40.86	   		 90% =  $36	 
	* MELON:	 4 / 31     Odds of 3:  64 / 29,791		1 / 465.48	   		 90% = $418
	* GRAPE		 4 / 31     Odds of 3:  64 / 29,791		1 / 465.48	   		 90% = $418
	* STRAWBERRY 4 / 31     Odds of 3:  64 / 29,791		1 / 465.48	   		 90% = $418
	* BANANA     4 / 31     Odds of 3:  64 / 29,791		1 / 465.48	   		 90% = $418
	* Any Fruit: 16/31      Odds of 3: 4096 / 29,791	1 / 7.27			 90% = $6.5
	* BLANK      4 / 31     Odds of getting 3  64 / 29,791
	*/
	{
		
		switch (num) {
		
		case 0: num = 0;  	// Corresponds to Lucky 7
				break;
		case 1: num = 0;	// Corresponds to Lucky 7
				break;
		case 2: num = 1;    // Corresponds to BAR
				break;
		case 3: num = 1;	// Corresponds to BAR
				break;
		case 4: num = 1;	// Corresponds to BAR
				break;
		case 5: num = 2;	// Corresponds to BAR BAR
				break;
		case 6: num = 2;	// Corresponds to BAR BAR
				break;			
		case 7: num = 2;	// Corresponds to BAR BAR
				break;
		case 8: num = 3;	// Corresponds to BAR BAR BAR
				break;				
		case 9: num = 3;	// Corresponds to BAR BAR BAR
				break;	
		case 10: num = 3;	// Corresponds to BAR BAR BAR
				break;	
		case 11: num = 4;	// Corresponds to MELON
				break;
		case 12: num = 4;	// Corresponds to MELON
				break;				
		case 13: num = 4;	// Corresponds to MELON
				break;	
		case 14: num = 4;	// Corresponds to MELON
				break;				
		case 15: num = 5;	// Corresponds to GRAPE
				break;
		case 16: num = 5;	// Corresponds to GRAPE
				break;
		case 17: num = 5;	// Corresponds to GRAPE
				break;
		case 18: num = 5;	// Corresponds to GRAPE
				break;				
		case 19: num = 6;	// Corresponds to BERRY
				break;
		case 20: num = 6;	// Corresponds to BERRY
				break;
		case 21: num = 6;	// Corresponds to BERRY
				break;
		case 22: num = 6;	// Corresponds to BERRY
				break;				
		case 23: num = 7;	// Corresponds to BANANA
				break;				
		case 24: num = 7;	// Corresponds to BANANA
				break;	
		case 25: num = 7;	// Corresponds to BANANA
				break;
		case 26: num = 7;	// Corresponds to BANANA
				break;
		case 27: num = 8;	// Corresponds to BLANK
				break;				
		case 28: num = 8;	// Corresponds to BLANK
				break;
		case 29: num = 8;	// Corresponds to BLANK
				break;
		case 30: num = 8;	// Corresponds to BLANK
				break;
		}		
		return num;
	}
	private static String getToken( int num ) {
		
		String tempString = "";
		switch (num) {
		case 0: tempString = "LUCKY7";  	// Corresponds to Lucky 7
				break;
		case 1: tempString = "BAR";			// Corresponds to BAR
				break;
		case 2: tempString = "BARBAR";    	// Corresponds to BARBAR
				break;
		case 3: tempString = "BARBARBAR";	// Corresponds to BARBARBAR
				break;
		case 4: tempString = "MELON";		// Corresponds to MELON
				break;
		case 5: tempString = "GRAPE";		// Corresponds to GRAPE
				break;
		case 6: tempString = "BERRY";		// Corresponds to BERRY
				break;			
		case 7: tempString = "BANANA";		// Corresponds to BANANA
				break;
		case 8: tempString = "BLANK";		// Corresponds to BLANK
				break;				
		}
		return tempString;
	}
	
	public static boolean isWinner(int x, int y, int z )
	/* This function receives three integers from board[][] and determines
	 * whether a particular row or set of three integers is a winner.
	 * For example, we might call isWinner and check the center row in the following way:
	 * isWinner(board[1][0], board[1][1], board[1][2]);
	 * This will check the center row for a winning combination of integers
     */
	
	{
		/*
		We might want to implement a lookup table here where the three digits 
		correspond to a certain pay out (or pay out level.)  
		000 corresponds to payout level 1.
		111, 222, 333 correspond to payout level 2.   If we have each set of 
		winning numbers correspond to a payout level, then we can adjust the payout
		in another structure or switch statement without having to change the underlying 
		data structure.
		
		We might want this function to return an integer that corresponds to the 
		payout level.  Then we can run that integer through a switch statement
		to return the $$.
		
		Winning Combinations							
		Lucky 7s: 		  					0 0 0		
		BAR  BAR  BAR:  					1 1 1		
		BARBAR BARBAR BARBAR 				2 2 2		
		BARBARBAR BARBARBAR BARABARBAR 		3 3 3
		MELON MELON MELON					4 4 4	
		GRAPE GRAPE GRAPE					5 5 5
		BERRY BERRY BERRY					6 6 6
		BANANA BANANA BANANA				7 7 7
		
		BAR Combos  	(3 ^ 3) - 3	= 24 combos	{ 1 1 2, 1 1 3, 1 2 1, 1 2 2, 1 2 3, 1 3 1, 1 3 2, 1 3 3,
								       			  2 1 1, 2 1 2, 2 1 3, 2 2 1, 2 2 3, 2 3 1, 2 3 2, 2 3 3,
									   			  3 1 1, 3 1 2, 3 1 3, 3 2 1, 3 2 2, 3 2 3, 3 3 1, 3 3 2 }
		 
		Fruit Combos (3 ^ 4) - 3 = 78 combos  {  There's got to be an easier way to do this }
		*/
		
		return false;
	}
	
	
	private int getPayout( int payoutLevel ) 
   /* There are 10 payout levels
	* This function allows us to edit the payout amounts
	* quickly
	* 1 - Lucky7 Lucky7 Lucky7
	* 2 - BAR  BAR  BAR
	* 3 - BARBAR BARBAR BARBAR
	* 4 - BARBARBAR BARBARBAR BARABARBAR
	* 5 - Any 3 BARs
	* 6 - MELON MELON MELON
	* 7 - GRAPE GRAPE GRAPE
	* 8 - BERRY BERRY BERRY
	* 9 - BANANA BANANA BANANA
	* 10 - Any 3 Fruits
	* 
    * 		   Odds of 3        	 Payout:
    * LUCKY7:    1 / 3723    		 90% =  $3,352
    * BAR:       1 / 1103			 90% =  $993
    * BARBAR:    1 / 1103            90% =  $993
    * BARBARBAR: 1 / 1103            90% =  $993
    * Any BAR:   1 / 40.86	   		 90% =  $36	 
    * MELON:	 1 / 465.48	   		 90% = $418
    * GRAPE		 1 / 465.48	   		 90% = $418
    * STRAWBERRY 1 / 465.48	   		 90% = $418
    * BANANA     1 / 465.48	   		 90% = $418
    * Any Fruit  1 / 7.27			 90% = $6.5
	*/
	{
		int payout = 0;
		switch ( payoutLevel ) 
		{
			case 1:	payout = 3000;
				break;
			case 2: payout = 1000;
				break;
			case 3:	payout = 1000;
				break;
			case 4: payout = 1000;
				break;		
			case 5:	payout = 35;
				break;
			case 6: payout = 400;
				break;		
			case 7:	payout = 400;
				break;
			case 8: payout = 400;
				break;
			case 9:	payout = 400;
				break;
			case 10: payout = 5;
				break;		
		}
		return payout;
	}
}  // end SlotMachineImpl.jav
