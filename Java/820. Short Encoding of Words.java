class Solution {
	public int minimumLengthEncoding(String[] words) {
		int l=words.length;
		int i,j;

		for(i=0;i<l;i++) { // You can use Collections.sort() or Arrays.sort() also
			for(j=0;j<l-i-1;j++) {
				if(words[j+1].length()>words[j].length()) {
					int l1=words[j+1].length();
					int l2=words[j].length();
					String y=words[j+1].substring(l1-l2,l1);
					if(y.equals(words[j])) {
						words[j]=words[j+1];
						words[j+1]=y;
					}
				}
			}
		}
		
		String h="";

		for(i=0;i<l;i++) {
			String s=words[i];
			int len=h.length();
			if(h.length()>=s.length()) {
				String u=h.substring(len-s.length(),len);
				if(u.equals(s)) { }
				else {
					if(h.contains(s)) {
						int p=h.indexOf(s);
						if(p+s.length()<h.length() && h.charAt(p+s.length())=='#') {   
						}
						else
							h=h+'#'+s;
					}
					else
					h=h+'#'+s;
				}
			}
			else {
			  
				h=h+'#'+s;
			}
		}    
		return h.length();
	}
}