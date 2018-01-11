package PatternSearching;

public class PatternAnagramSearch {
//to search a pattern as well as its anagrams in a text
	//usign hash values
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
				patternAnagramSearch(pattern,text);
	}
	public static boolean isSame(int[] a, int[] b){
		for(int i=0;i<256;i++){
			if(a[i]!=b[i])
				return false;
		}
		return true;
	}
	//Time : O(n)
	public static void patternAnagramSearch(String pat, String txt){
	// TODO Auto-generated method stub
		int[] hash_p = new int[256];//for every chara cter in ASCII
		int[] hash_t= new int[256];
		int n= txt.length();
		int m= pat.length();
		//count the frequency of characters  in pattern
		for(int i=0;i<m;i++){
			hash_p[pat.charAt(i)]++;
		}
		//count the frequency of characters  in first window of len m in text
		for(int i=0;i<m;i++){
			hash_t[txt.charAt(i)]++;
		}
		
		for(int i=m;i<n;i++){
			if(isSame(hash_p,hash_t)){
				System.out.println("Pattern found at index:" + (i-m));
			}
			hash_t[txt.charAt(i)]++; // add next character
			hash_t[txt.charAt(i-m)]--;//remove first character
			
		}
		//last window not covered in the loop..explicit check required
		if(isSame(hash_p,hash_t)){
			System.out.println("Pattern found at index:" + (n-m));
		}

	}
}
