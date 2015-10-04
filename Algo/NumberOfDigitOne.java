/* https://leetcode.com/problems/number-of-digit-one/ */
class NumberOfDigitOne
{
	public static void main(String args[])
	{
		NumberOfDigitOne solution = new NumberOfDigitOne();
		System.out.println(solution.countDigitOne(12));
	}

	public int countDigitOne(int n)
	{
  		//base case
  		if(n<1)
  			return 0;
  		//Find the number of digits minus 1 in n
  		int d = (int)Math.log10(n);
  		//System.out.println(d);
  		//Computing count of numbers from 0 tp 10^d-1
  		//count(10^d) = 9 * count(10^d-1) + 10^d-1
  		int count[] = new int[d+1];
  		count[0] = 0;
  		//count of numbers from 0 to 9 = 1
  		if(d>=1)
  			count[1] = 1;
  		//count of numbers from 0 to 99 = 19
  		//count of numbers from 0 to 999 = 271
  		for(int i=2;i<=d;i++)
  		{
  			count[i] = 9 * count[i-1] + (int)Math.ceil(Math.pow(10, i-1));
  		}
  		 // Computing 10^d
   		int p = (int)Math.ceil(Math.pow(10, d));
   		//System.out.println(p);
  		// Most significant digit (msd) of n,
   		// For 328, msd is 3 which can be obtained using 328/100
   		int msd = n/p;
   		System.out.println("n: "+ n+" d: "+d+ " p: "+p+" msd: "+msd);
   		// If MSD is 1. For example if n = 128, then count of
   		// numbers is sum of following.
   		// 1) Count of numbers from 1 to 99
   		// 2) Count of numbers from 100 to 128 which is 29.
   		if(msd == 1)
   		{
   			System.out.println(((p==1 && n%p==1)?1:n%p));
   			return msd * count[d] + ((p==1 && n%p==0)?1:n%p) + ((p==1 && n%p==0)?1:countDigitOne(n%p));
   		}
   		// IF MSD > 1. For example if n is 728, then count of
   		// numbers is sum of following.
   		// 1) Count of numbers from 1 to 99 and count of numbers
   		//    from 200 to 699, i.e., "a[2] * 6"
   		// 2) Count of numbers from 100 to 199, i.e. 100
   		// 3) Count of numbers from 700 to 728, recur for 28
   		//if(msd > 1)
   		return (msd-1) * count[d] + p + countDigitOne(n%p);

   		// IF MSD < 1. For example if n is 18, then count of
   		// numbers is sum of following.
   		// 1) Count of numbers from 0 to 28 a
   		// 2) recur for 8
   		//return (msd) * count[d]

	}
}
