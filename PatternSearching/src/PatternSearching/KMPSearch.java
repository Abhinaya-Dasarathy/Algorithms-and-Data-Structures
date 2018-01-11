package PatternSearching;

public class KMPSearch {
//Based on the concept of longest proper prefix which is also a suffix
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
				//String text = "AABAACAADAABAABA";
				//String pattern = "AABA";
				String text = "AABA";
				String pattern = "AABA";
				//String text = "AAAABA";
				//String pattern = "AABA";
				KMPsearch(pattern,text);
				
	}
			public static int[] computeLPS(String pat,int m){
				int[] lps = new int[m];
				
				int length = 0;
				int index = 1;
				lps[0]=0; //first index lps will always be 0
				
				while(index< m){
					if(pat.charAt(index)==pat.charAt(length)){
						length++;
						lps[index]=length;
						index++;
					}
					else
					{
						if(length!=0){
							length =lps[length-1];
						}
						else{//length is 0
							lps[index]=length;
							index++;
						}
					}
				}
					
				return lps;	
			}
			/* Best Case: O(n) Worst case : O(n)*/
			public static void KMPsearch(String pat, String txt){
				
				int n = txt.length();
				int m= pat.length();
				int[] lps = computeLPS(pat,m);//this array contains longest possible proper prefix for pat[0..i] which is also a suffix
				int i=0;int j=0;
				while(i<n){
					if(txt.charAt(i)==pat.charAt(j)){
						
						i++;
						j++;
					}
					if(j==m)
					{	System.out.println("Pattern found at index:" + (i-j));
						j=lps[j-1];
					}
					else if(i<n && pat.charAt(j)!=txt.charAt(i)){
						if(j!=0)
							j=lps[j-1];
						else
							i++;
					}
				}				
			}
}
