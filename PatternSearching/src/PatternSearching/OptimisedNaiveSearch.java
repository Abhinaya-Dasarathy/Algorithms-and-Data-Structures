package PatternSearching;

public class OptimisedNaiveSearch {
// Optimizing the naive search when all characters are different -slide by j logic
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
				optimisednaiveSearch(pattern,text);
				

			}
			
	public static void optimisednaiveSearch(String pat, String txt){
		
		int n = txt.length();
		int m= pat.length();
		int i=0;
		while(i<=n-m){ //n-m because if n=16 and m=4 , we can stop searching after m=12 , it wont fit the pattern
			int j;
			for(j=0;j<m;j++){
			if(txt.charAt(i+j)!= pat.charAt(j)){
				break;
			 }
			}
			if(j==m)
				{System.out.println("Pattern found at index: " + i);
				i=i+m;
				}
			else if(j==0)
				i++;
			else
				i=i+j; //slide by j
			
		}
	}

}
