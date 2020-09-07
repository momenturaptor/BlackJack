import java.util.Random;

public class Deck {
	int decks;
	int index = 0;
	static int[] deck = new int[0];
	//public static Counter counter;
	public Deck(int x)
	{
		decks= x;
		
		for (int i=0; i<4*decks; i++)
		{
			int[] set ={11, 2 ,3 ,4, 5, 6, 7, 8, 9,10, 10,10,10};
			int aLen = deck.length;
		    int bLen = set.length;

		   
		   int[] temp = new int[aLen+bLen];
		   System.arraycopy(deck, 0, temp, 0, aLen);
		   System.arraycopy(set, 0, temp, aLen, bLen);
		    deck = temp;
		}
		//Counter counter = new Counter(x);
	}
	public void force()
	{
		deck[0]= 11;
		deck[1]= 6;
		deck[2]=11;
		deck[3]=7;
		deck[4]=10;
		deck[5]=9;
		deck[6]=10;
	}
	public void shuffle()
	{
		Random rand = new Random();
		
		for (int i = 0; i < deck.length; i++) {
			int randomIndexToSwap = rand.nextInt(deck.length);
			int temp = deck[randomIndexToSwap];
			deck[randomIndexToSwap] = deck[i];
			deck[i] = temp;
			
			
		}
		index= 0;
		//System.out.println("shuffle");
		
	}
	/*public Counter getCounter()
	{
		return counter;
	}
	/*public static void main(String[] args)
	{
		Deck two = new Deck(2); 
		two.shuffle();
		
		
	}*/
	public int getSize()
	{
		return deck.length;
	}
	public int deal()
	{
		
		int x = deck[index];
		index++;
		/*if(x<8)
		{
			counter.increment();
		}
		if(x>9)
		{
			counter.decrement();
		}
		*/
		return x;
		
	}
	public int getIndex()
	{
		return index;
	}
	
}
