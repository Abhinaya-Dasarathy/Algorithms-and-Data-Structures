package PatternSearching;

public class RabinKarpSearch {
//based on the concept of hashing functions
	/*hash( txt[s+1 .. s+m] ) = ( d ( hash( txt[s .. s+m-1]) – txt[s]*h ) + txt[s + m] ) mod q

			hash( txt[s .. s+m-1] ) : Hash value at shift s.
			hash( txt[s+1 .. s+m] ) : Hash value at next shift (or shift s+1)
			d: Number of characters in the alphabet
			q: A prime number
			h: d^(m-1) mod q
			*/
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String text = "AABAACAADAABAABA";
		//String pattern = "AABA";
		String text = "AABA";
		String pattern = "AABA";
		//String text = "AAAABA";
		//String pattern = "AABA";
		rabinKarpSearch(pattern,text);
	}
	/* Time complexity O(n+m) best case and O(mn) worst case*/
	public static void rabinKarpSearch(String pat, String txt){
		int n= txt.length();
		int m=pat.length();
		int q=119; //any prime number; give a little bigger number because when u do the mod q, if it is smaller, it is going to take time
		int hash_p=0;
		int hash_t =0; //hash values for pattern and text
		int h=0;
		final int d = 256; //d = num of chars in alphabet
		int j;
		//calculate h in formula
		for(int i=0;i<m;i++){
			h = (h*d)%q;
		}
		System.out.println("h:" + h);
		//calculate hash value in pattern
		for(int i =0 ; i< m;i++){
			hash_p= (d*hash_p + pat.charAt(i)) % q;
		}
		//calculate hash value for first window in text
		for(int i =0 ; i< m;i++){
			hash_t= (d*hash_t + txt.charAt(i)) % q;
		}
		///debug msg
		System.out.println("hash_p:" + hash_p + " hash_t:" + hash_t);
		int i=0;
	
		while(i<=n-m){
			System.out.println("naive search logic");
			if(hash_p==hash_t)//if hash values are same, compare character by character
			{
				
				for(j=0;j<m;j++){
					if(txt.charAt(i+j)!= pat.charAt(j))
							break;
					}
				System.out.println(j);
				if(j==m)
					System.out.println("Pattern found at index: " + i);
			}
			//now update the hash value for text. hash value for pattern remains the same.
			if(i<n-m){
				hash_t= (d*(hash_t-txt.charAt(i)*h)+ txt.charAt(i+m)) %q;
				if(hash_t<0)
					hash_t+=q;
			}
			i++;
		}
		
		
	}
	
	

}
