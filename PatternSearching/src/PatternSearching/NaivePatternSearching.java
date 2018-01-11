package PatternSearching;

public class NaivePatternSearching {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String text = "AABAACAADAABAABA";
		//String pattern = "AABA";
		//String text = "AABA";
		//String pattern = "AABA";
		String text = "AAAABA";
		String pattern = "AABA";
		naiveSearch(pattern,text);
		

	}
	/* Best Case: O(n) Worst case : O(m*(n-m+1))*/
	public static void naiveSearch(String pat, String txt){
		
		int n = txt.length();
		int m= pat.length();
		
		for (int i=0;i<=n-m;i++){ //n-m because if n=16 and m=4 , we can stop searching after m=12 , it wont fit the pattern
			int j;
			for(j=0;j<m;j++){
			if(txt.charAt(i+j)!= pat.charAt(j)){
				break;
			 }
			}
			if(j==m)
				System.out.println("Pattern found at index: " + i);
			
		}
	}

}
