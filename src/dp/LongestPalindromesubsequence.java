package dp;

public class LongestPalindromesubsequence {

	static StringBuilder sb= new StringBuilder();
	public static void main(String[] args) {
		String s= "GEEKSFORGEEKS";
		LongestPalindromesubsequence subSeq= new  LongestPalindromesubsequence();
		int maxLength = subSeq.findLongestPalindromeSubSeqRec(s, 0, s.length()-1);
		System.out.println(maxLength);
		System.out.println("************ LOOP ************");
		int maxLength1 = subSeq.finfLongestPalindromeSubSeq(s);
		System.out.println(maxLength1);
	}
	
	int findLongestPalindromeSubSeqRec(String s, int l, int r) {
		if(l== r) {
			sb.append(s.charAt(l));
			return 1;
		}
		if(l+1== r && s.charAt(l)== s.charAt(r)) {
			return 2;
		}
		
		if(s.charAt(l)== s.charAt(r)) {
			return (2+ findLongestPalindromeSubSeqRec(s, l+1, r-1));
		} else {
			return Math.max(findLongestPalindromeSubSeqRec(s, l+1, r), findLongestPalindromeSubSeqRec(s, l, r-1));
		}
		
	}
	
	int finfLongestPalindromeSubSeq(String s) {
		int length= s.length();
		int maxL[][]= new int[length][length];
		
		for(int i= 0;i< length;i++) {
			maxL[i][i]= 1;
		}
		
		for(int l= 2;l<=length;l++) {
			for(int i= 0;i<=length-l;i++) {
				int j= i+l-1;
				if(s.charAt(i)== s.charAt(j)) {
					if(l== 2) {
						maxL[i][j]= 2;
					} else {
						maxL[i][j]= 2+maxL[i+1][j-1]; 
					}
				} else {
					maxL[i][j]= Math.max(maxL[i+1][j], maxL[i][j-1]);
				}
			}
		}
		
		return maxL[0][length-1];
	}

}
