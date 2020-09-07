import java.util.Scanner;

public class Simulator {
	
	public static void main(String[] args) {
		//System.out.print("\033[H\033[2J");
		System.out.flush();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Blackjack simulator");
		
		System.out.println("Enter number of decks in play: ");
		int decks = sc.nextInt();
		System.out.println("Enter bankroll: ");
		double bankroll = sc.nextDouble();
		System.out.println("Enter minimum bet: ");
		int min = sc.nextInt();
		System.out.println("Enter maximum bet:");
		int max = sc.nextInt();
		System.out.println("Enter spread multiplier (or enter -1 to calculate optimal betting spread): ");
		double multi = sc.nextDouble();
		System.out.println("Counting Method (press 1 for High-Low, 2 for KO): ");
		int method = sc.nextInt();
		System.out.println("Annotated Mode (press 1 for yes, 2 for no): ");
		int annotate = sc.nextInt();
		if(annotate==1)
		{
			multi=1;
		}
	if(annotate!=1)
	{
		if (method==1)
		{	
			if (multi<0)
			{
				getBetSpreadHL(bankroll, decks, min, max);
			}
			else 
			{
				simulateHL(bankroll, decks, min, max, multi);
			}
		}
		if (method==2)
		{	
			if (multi<0)
			{
				getBetSpreadKO(bankroll, decks, min, max);
			}
			else 
			{
				simulateKO(bankroll, decks, min, max, multi);
			}
		}
	}
	else
	{
		if (method==1)
		{	
			if (multi<0)
			{
				getBetSpreadHLA(bankroll, decks, min, max);
			}
			else 
			{
				simulateHLA(bankroll, decks, min, max, multi);
			}
		}
		if (method==2)
		{	
			if (multi<0)
			{
				getBetSpreadKOA(bankroll, decks, min, max);
			}
			else 
			{
				simulateKOA(bankroll, decks, min, max, multi);
			}
		}
	}

	}
	public static void simulateKO(double chips, int decks, int min, int max, double multi)
	{

		
		long hand = 0;
		int games = 1000;
		if (chips/min>500)
		{
			games = 300;
		}
		double wr = 0;
		
		
		KOGame x = new KOGame(chips, decks, min, max, multi, 0);
		int win = 0;
			for (int i =0; i<games; i++)
			{
			if(x.playGame())
			{
				win++;
			}
			
			//plus+=x.plusCount;
			hand += x.handCount;
			
			}
			
				wr=(double)win/games;
				
			
			System.out.println("Hands simulated: "+hand);
			System.out.println("Winrate: "+wr);
			
	
		
		
	}
	public static void simulateKOA(double chips, int decks, int min, int max, double multi)
	{

		
		long hand = 0;
		int games = 1;
		
		
		
		
		KOGameA x = new KOGameA(chips, decks, min, max, multi, 0);
		int win = 0;
			for (int i =0; i<games; i++)
			{
			if(x.playGame())
			{
				win++;
			}
			
			//plus+=x.plusCount;
			hand += x.handCount;
			if (hand>999)
			{
				return;
			}
			}
			
				//wr=(double)win/games;
				
			
			System.out.println("Hands simulated: "+hand);
			//System.out.println("Winrate: "+wr);
			
	
		
		
	}
	public static void getBetSpreadKO(double chips, int decks, int min, int max)
	{
		long hand = 0;
		int games = 300;
		
		double wr = 0;
		double a = 0;
		for (double g =.2; g<2.1; g+=.2)
		{
		KOGame x = new KOGame(chips, decks, min, max, g, 0);
		int win = 0;
			for (int i =0; i<games; i++)
			{
			if(x.playGame())
			{
				win++;
			}
			
			//plus+=x.plusCount;
			hand += x.handCount;
			
			}
			System.out.println(g + " " + (double)win/games);
			if ((double)win/games>wr)
			{
				wr=(double)win/games;
				a = g;
			}
		}
		System.out.println("Hands simulated: " +hand);
		System.out.println("Optimal Multiplier" +a);
		System.out.println("Win rate: " +wr);
		System.out.println("Bet Spread- Count/Bet");
		for (int j = 1; j<7; j++)
		{
			int b = (int)((double)min*Math.pow(j,a));
			if (b>max)
			{
			b=max;
			}
			System.out.println(j+"/"+b);
		}
		
		
	}
	public static void getBetSpreadKOA(double chips, int decks, int min, int max)
	{
		long hand = 0;
		int games = 100;
		
		double wr = 0;
		double a = 0;
		for (double g =.2; g<2.1; g+=.2)
		{
		KOGameA x = new KOGameA(chips, decks, min, max, g, 0);
		int win = 0;
			for (int i =0; i<games; i++)
			{
			if(x.playGame())
			{
				win++;
			}
			
			//plus+=x.plusCount;
			hand += x.handCount;
			
			}
			System.out.println(g + " " + (double)win/games);
			if ((double)win/games>wr)
			{
				wr=(double)win/games;
				a = g;
			}
		}
		System.out.println("Hands simulated: " +hand);
		System.out.println("Optimal Multiplier" +a);
		System.out.println("Win rate: " +wr);
		System.out.println("Bet Spread- Count/Bet");
		for (int j = 1; j<7; j++)
		{
			int b = (int)((double)min*Math.pow(j,a));
			if (b>max)
			{
			b=max;
			}
			System.out.println(j+"/"+b);
		}
		
		
	}
	public static void simulateHL(double chips, int decks, int min, int max, double multi)
	{

		
		long hand = 0;
		int games = 1;
		if (chips/min>500)
		{
			games = 300;
		}
		double wr = 0;
		
		
		HLGame x = new HLGame(chips, decks, min, max, multi, 0);
		int win = 0;
			for (int i =0; i<games; i++)
			{
			if(x.playGame())
			{
				win++;
			}
			
			//plus+=x.plusCount;
			hand += x.handCount;
			
			}
			
				wr=(double)win/games;
				
			
			System.out.println("Hands simulated: "+hand);
			System.out.println("Winrate: "+wr);
			
	
		
		
	}
	public static void getBetSpreadHL(double chips, int decks, int min, int max)
	{
		long hand = 0;
		int games = 300;
		
		double wr = 0;
		double a = 0;
		for (double g =.2; g<2.1; g+=.2)
		{
		HLGame x = new HLGame(chips, decks, min, max, g, 0);
		int win = 0;
			for (int i =0; i<games; i++)
			{
			if(x.playGame())
			{
				win++;
			}
			
			//plus+=x.plusCount;
			hand += x.handCount;
			
			}
			System.out.println(g + " " + (double)win/games);
			if ((double)win/games>wr)
			{
				wr=(double)win/games;
				a = g;
			}
		}
		System.out.println("Hands simulated: " +hand);
		System.out.println("Optimal Multiplier" +a);
		System.out.println("Win rate: " +wr);
		System.out.println("Bet Spread- Count/Bet");
		for (int j = 1; j<7; j++)
		{
			int b = (int)((double)min*Math.pow(j,a));
			if (b>max)
			{
			b=max;
			}
			System.out.println(j+"/"+b);
		}
		
		
	}
	public static void getBetSpreadHLA(double chips, int decks, int min, int max)
	{
		long hand = 0;
		int games = 300;
		
		double wr = 0;
		double a = 0;
		for (double g =.2; g<2.1; g+=.2)
		{
		HLGameA x = new HLGameA(chips, decks, min, max, g, 0);
		int win = 0;
			for (int i =0; i<games; i++)
			{
			if(x.playGame())
			{
				win++;
			}
			
			//plus+=x.plusCount;
			hand += x.handCount;
			
			}
			System.out.println(g + " " + (double)win/games);
			if ((double)win/games>wr)
			{
				wr=(double)win/games;
				a = g;
			}
		}
		System.out.println("Hands simulated: " +hand);
		System.out.println("Optimal Multiplier" +a);
		System.out.println("Win rate: " +wr);
		System.out.println("Bet Spread- Count/Bet");
		for (int j = 1; j<7; j++)
		{
			int b = (int)((double)min*Math.pow(j,a));
			if (b>max)
			{
			b=max;
			}
			System.out.println(j+"/"+b);
		}
		
		
	}
	public static void simulateHLA(double chips, int decks, int min, int max, double multi)
	{

		
		int hand = 0;
		int games = 1;
		
		double wr = 0;
		
		
		HLGameA x = new HLGameA(chips, decks, min, max, multi, 0);
		int win = 0;
			for (int i =0; i<games; i++)
			{
			if(x.playGame())
			{
				win++;
			}
			
			//plus+=x.plusCount;
			hand += x.handCount;
			if(hand>999)
			{
				return;
			}
				
			
			}
			
				wr=(double)win/games;
				
			
			System.out.println("Hands simulated: "+hand);
			System.out.println("Winrate: "+wr);
			
	
		
		
	}
	//
}
