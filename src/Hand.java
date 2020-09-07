import java.util.ArrayList;
public class Hand {
	public ArrayList hand = new ArrayList(2);
	public int aces= 0;
	public int sum = 0;
	
	public Hand()
	{
		
	}
	public Hand(Hand a)
	{
		hand = a.hand;
		aces= a.aces;
		sum = a.sum;
	}
	public void add(Deck d)
	{
		
		int card = d.deal();
		hand.add(card);
		//System.out.println(hand.size());
		if(card==11)
		{
			aces++;
		}
		sum+=card;
		/* for(int i = 0; i < hand.size(); i++)
		 {
			 //System.out.print((int)hand.get(i));
			 sum += (int)hand.get(i);
		 }*/
		 
	}
	public boolean checkforbust()
	{
		if (sum<=21)
		{
			return false;
		}
		if (aces>0)
		{
			sum -= 10;
			aces--;
			checkforbust();
		}
		return true;
	}
	public void showHand()
	{
		 for(int i = 0; i < hand.size(); i++)
		 {
			 System.out.print(hand.get(i)+" ");
		 }
		 System.out.print(sum);
		 System.out.println();
	}
	public void showOne()
	{
		//System.out.println(hand.get(0)+" ?");
	}
	public void vet(int i)
	{
		hand.clear();
		hand.add(i);
	}
	public void clear()
	{
		hand.clear();
	}
	public void reset()
	{
		aces = 0;
		sum = 0;
	}
}
