
public class KOGame {
	static Hand dealer = new Hand();
	static Hand player = new Hand();
	static Hand splitHand = new Hand();
	static boolean split= false;
	static boolean dub = false;
	static int bet;
	static Deck d;
	static int decks;
	static double chips;
	static double chipsf;
	//static BetCalculator calc;
	static int count;
	static int icount;
	static int min;
	static int max;
	static double multi;
	static int handCount;
	static int plusCount;
	static int aggression;
	
	//static boolean BJ;
	
	public KOGame(double money, int decks, int min, int max, double multiplier, int a)
	{
		//BetCalculator calc = new BetCalculator(min, multiplier);
		chips = money;
		chipsf = chips;
		this.decks = decks;
		d = new Deck(decks);
		icount = 4- (4*decks);
		count = icount;
		this.min= min;
		this.max= max;
		multi=multiplier;
		aggression=a;
		//System.out.println(getBet(count));
	}
	//public static void main(String[] args)
	public boolean playGame()
	{
		//Game test = new Game(money, decks, min, max, multiplier);
		d.shuffle();
		//d.force();
		count = icount;
		chips = chipsf;
		
		while (chips>min-1 && chips<2*chipsf)
		{
			//System.out.println("Count: "+ count);
			//System.out.println("Chips: " +chips);
			//System.out.println("Bet: "+getBet(count));
		startHand(getBet(count));
		handCount++;
		if (count+aggression>1)
		{
			plusCount++;
		}
		
		playHand();
		resolveHand();
			if(d.getIndex()>decks*39)
			{
				//System.out.println("shuffle: "+ d.getIndex());
			d.shuffle();
			count = icount;
			}
		//System.out.println("Chips: "+ chips);
		
		}
	
		if (chips<min)
		{
			return false;
		}
		return true;
	}
	public static int getBet(int count)
	{
		if (count+aggression<1)
		{
			bet=min;
			return min;
		}
		int x = (int) (min* Math.pow((double)(count+aggression), multi));
		if (x>max)
		{
			bet=max;
			return max;
		}
		bet = x;
		return x;
	}
	public static void startHand(int b)
	{
		bet = b;
		chips-=bet;
		player.add(d);
		dealer.add(d);
		player.add(d);
		dealer.add(d);
	}
	public static void playHand()
	{
		
		int tc = (int) dealer.hand.get(0);
		
		split = checkSplit(tc);
		if (split)
		{
			chips -= bet;
			player.vet(player.sum/2);
			
			player.sum = player.sum/2; 
			
			player.add(d);
		
			//System.out.println("SPLIT");
			dub= true;
		}
		
		
		playerTurn(tc);
		dealerTurn();
		//dealer.showHand();
		//player.showHand();
		//System.out.println();
		
	}
	public static void playerTurn(int tc)
	{
		while(player.sum<9)
		{
			player.add(d);
		}
		if (player.sum==9 )
		{
			if (player.hand.size()==2 && tc>2 && tc<7 && !dub)
			{
				chips-=bet;
				dub=true;
				player.add(d);
				return;
			}
			else
			{
				player.add(d);
			}
		}
		if (player.sum==10)
			if(player.hand.size()==2 && tc<10 &&!dub)
			{
				chips-=bet;
				dub=true;
				player.add(d);
				return;
			}
			else
			{
				player.add(d);
			}
		if(player.sum==11)
		{
			if(player.hand.size()==2 && tc<11&&!dub)
			{
				chips-=bet;
				dub=true;
				player.add(d);
				if(player.sum>21)
				{
					player.sum -= 10;
				}
				return;
			}
			else
			{
				player.add(d);
			}
		}
		if(player.sum==12)
		{
			if(tc>3 && tc<7)
			{
				return;
			}
			else
			{
				player.add(d);
			}
		}
		if(player.sum==13)
		{
			if (player.hand.size()==2 &&  player.aces==1&& tc<7 && tc>4&&!dub )
			{
				chips-=bet;
				dub=true;
				player.add(d);
				if(player.sum>21)
				{
					player.sum -= 10;
				}
				return;
			}
			if (tc<7&& player.aces==0)
			{
				return;
			}
			else
			{
				player.add(d);
			}
		}
		if(player.sum==14)
		{
			if (player.hand.size()==2 &&player.aces==1&& tc<7 && tc>4&&!dub)
			{
				chips-=bet;
				dub=true;
				player.add(d);
				if(player.sum>21)
				{
					player.sum -= 10;
				}
				return;
			}
			if (tc<7&& player.aces==0)
			{
				return;
			}
			else
			{
				player.add(d);
			}
		}
		if(player.sum==15)
		{
			if (player.hand.size()==2 &&player.aces==1&& tc<7 && tc>3&&!dub)
			{
				chips-=bet;
				dub=true;
				player.add(d);
				if(player.sum>21)
				{
					player.sum -= 10;
				}
				return;
			}
			if (tc<7 && player.aces==0)
			{
				return;
			}
			else
			{
				player.add(d);
			}
		}
		if(player.sum==16)
		{
			if (player.hand.size()==2 &&player.aces==1&& tc<7 && tc>3&&!dub)
			{
				chips-=bet;
				dub=true;
				player.add(d);
				if(player.sum>21)
				{
					player.sum -= 10;
				}
				return;
			}
			if (tc<7 && player.aces==0)
			{
				return;
			}
			else
			{
				player.add(d);
			}
		}
		if(player.sum==17)
		{
			if(player.aces==0)
			{
				return;
			}
			if (player.hand.size()==2 && tc>2 && tc<7&&!dub)
			{
				chips-=bet;
				dub=true;
				player.add(d);
				if(player.sum>21)
				{
					player.sum -= 10;
				}
				return;
			}
			else
			{
				player.add(d);
			}
				
		}
		if(player.sum==18)
		{
			if(player.aces==0)
			{
				return;
			}
			if(tc<7 && player.hand.size()==2&&!dub)
			{
				chips-=bet;
				dub=true;
				player.add(d);
				if(player.sum>21)
				{
					player.sum -= 10;
				}
				return;
			}
			if(tc<9)
			{
				return;
			}
			else
			{
				player.add(d);
			}
		}
		
		
		if(player.sum>21)
		{
			if (player.aces>0)
			{
				player.aces--;
				player.sum-=10;
				playerTurn(tc);
			}
			else {
				return;
			}
		}
	}
	public static void dealerTurn()
	{
		while (dealer.sum<17)
		{
			dealer.add(d);
		}
		if(dealer.sum>21&& dealer.aces>0)
		{
			dealer.aces--;
			dealer.sum-=10;
			dealerTurn();
		}
			
	}
	public static void resolveHand()
	{
		if(checkBlackjack(player))
		{
			
			if(checkBlackjack(dealer))
			{
				if (dub)
				{
					chips+=2*bet;
				}
				else {
				chips += bet;
				}
				
			}
			else
			{
				if (dub)
				{
					//System.out.println(chips);
					chips+=5*bet;
				}
				else {
				chips += 2.5 * bet;
				}
			}
			
		}
		else if (player.sum<22 && !checkBlackjack(dealer))
		{
			if (dealer.sum>21 || player.sum>dealer.sum)
			{
				if (dub)
				{
					chips+=4*bet;
				}
				else
				{
				chips+= 2*bet;
				}
			}
			if (dealer.sum==player.sum)
			{
				chips+= bet;
			}
		}
		dub=false;
		//System.out.println("handsize: " + player.hand.size());
		for(int i = 0; i < player.hand.size(); i++)
		 {
			 int x = (int) player.hand.get(i);
			if (x>9)
			{
				count--;
			}
			if (x<8)
			{
				count++;
			}
		 }
	//	if (!split)
		//{
			for(int i = 0; i < dealer.hand.size(); i++)
			 {
				 int x = (int) dealer.hand.get(i);
				if (x>9)
				{
					count--;
				}
				if (x<8)
				{
					count++;
				}
			 }
		//}
		/*if(split)
		{
			split= false;
			player.showHand();
			player = splitHand;
			//player.reset();//not correct
			//chips-=bet;
			playerTurn((int)dealer.hand.get(0));
			//player.showHand();
			resolveHand();
		}*/
		 
		player.reset();
		dealer.reset();
		dealer.clear();
		player.clear();
		
	}
	public static boolean checkSplit(int tc)
	{
		if (player.hand.get(0)!=player.hand.get(1))
		{
			return false;
		}
		if (player.sum==20)
		{
			return false;
		}
		if (player.sum==22)
		{
			return true;
		}
		
		if (player.sum==18)
		{
			if (tc==7 || tc>9)
			{
				return false;
			}
			return true;
		}
		if (player.sum==16)
		{
			return true;
		}
		if (player.sum==14)
		{
			if (tc>7)
			{
				return false;
			}
			return true;
		}
		if (player.sum==12)
		{
			if (tc>6)
			{
				return false;
			}
			return true;
		}
		if (player.sum==10)
		{
			return false;
		}
		if (player.sum==8)
		{
			if (tc==5 || tc==6)
			{
				return true;
			}
			return false;
		}
		else
		{
			if (tc>7)
			{
				return false;
			}
			return true;
		}
	}
	public static boolean checkBlackjack(Hand h)
	{
		if (h.sum==21 && h.hand.size()==2)
		{
			return true;
		}
		return false;
	}
	
}
//doubling after split is problematic
