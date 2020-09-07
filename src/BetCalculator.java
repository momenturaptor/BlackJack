
public class BetCalculator 
{
	public int min;
	public  double multiplier;
	public BetCalculator(int mi, double mu)
	{
		min= mi;
		multiplier = mu;
	}
	public int getBet(int count)
	{
		if (count<1)
		{
			return min;
		}
		return (int) (min* Math.pow((double)count, multiplier));
	}

}
