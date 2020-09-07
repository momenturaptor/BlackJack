
public class Counter {
	public int count;
	private int c;
	public Counter(int decks)
	{
		
		count = 4- (4*decks);
		c = count;
	}
	public void increment()
	{
		count++;
	}
	public void decrement()
	{
		count--;
	}
	public void reset()
	{
		count= c;
	}
	public int getCount()
	{
		return count;
	}
	/*public static void main(String[] args)
	{
		Counter c = new Counter(4);
		System.out.println(c.getCount());
		c.increment();
		System.out.println(c.getCount());
		c.reset();
		System.out.println(c.getCount());
	}*/
}
