import java.util.Random;
public class SlotMachineImpl {

	
	
	//private Board b;
	
	public SlotMachineImpl( ){


		//b = new Board();
	
	}
	
	
	
	
	public static void spin (Board b) {
		
		
		Random r = new Random();
		
		for (int i = 0; i < 3; ++i ) {
			
			for (int j = 0; j < 3; ++j) {
				
				int num = r.nextInt(1000000);
				num = num % 25;
				
				// Call the method that maps the virtual machine 
				// to the regular machine
				num = virtualSpin( num );
				
				b.board[i][j] = num;
			} // end inner for loop
		} // end outer for loop
	}  // end spin()
	
	private static int virtualSpin( int num ) 
	/*this function receives an integer from 0 - 24 
	 The number corresponds to a number on the reel.
     Odds:				   Odds of getting 3 in a row		   Payout:
     LUCKY7:    1 / 25     Odds of 3:  1 / 15,625   	       90% = $14,062.50
     BAR:       2 / 25     Odds of 3:  1 / 1,953  			   90% =  $1,758
     BARBAR:    2 / 25     Odds of 3:  1 / 1,953  			   90% =  $1,758
     BARBARBAR: 2 / 25     Odds of 3:  1 / 1,953               90% =  $1,758
     
     Any BAR Combo:   6 / 25 Odds of 3: 1 / 72.33			   90% = $65	 
     
     MELON:		3 / 25     Odds of 3:  1 / 578.7			   90% = $520
     GRAPE		3 / 25     Odds of 3:  1 / 578.7			   90% = $520
     STRAWBERRY 3 / 25     Odds of 3:  1 / 578.7			   90% = $520
     BANANA     3 / 25     Odds of 3:  1 / 578.7			   90% = $520
     
     Any Fruit Combo: 12/25 Odds of 3: 1 / 9				   90% = $8
     
     BLANK      5 / 25      Odds of getting 3  1 / 125
	*/
	{
		
		switch (num) {
		
		case 0: num = 0;  	// Corresponds to Lucky 7
				break;
		case 1: num = 1;	// Corresponds to BAR
				break;
		case 2: num = 1;    // Corresponds to BAR
				break;
		case 3: num = 2;	// Corresponds to BAR BAR
				break;
		case 4: num = 2;	// Corresponds to BAR BAR
				break;
		case 5: num = 3;	// Corresponds to BAR BAR BAR
				break;
		case 6: num = 3;	// Corresponds to BAR BAR BAR
				break;			
		case 7: num = 4;	// Corresponds to melon
				break;
		case 8: num = 4;	// Corresponds to melon
				break;				
		case 9: num = 4;	// Corresponds to melon
				break;	
		case 10: num = 5;	// Corresponds to grape
				break;	
		case 11: num = 5;	// Corresponds to grape
				break;
		case 12: num = 5;	// Corresponds to grape
				break;				
		case 13: num = 6;	// Corresponds to strawberry
				break;	
		case 14: num = 6;	// Corresponds to strawberry
				break;				
		case 15: num = 6;	// Corresponds to strawberry
				break;
		case 16: num = 7;	// Corresponds to banana
				break;
		case 17: num = 7;	// Corresponds to banana
				break;
		case 18: num = 7;	// Corresponds to banana
				break;				
		case 19: num = 8;	// Corresponds to BLANK
				break;
		case 20: num = 8;	// Corresponds to BLANK
				break;
		case 21: num = 8;	// Corresponds to BLANK
				break;
		case 22: num = 8;	// Corresponds to BLANK
				break;				
		case 23: num = 8;	// Corresponds to BLANK
				break;				
		case 24: num = 8;	// Corresponds to BLANK
				break;				
		}		
		
		return num;
	}
	
	
	

}  // end SlotMachineImpl.jav
