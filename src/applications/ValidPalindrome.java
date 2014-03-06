package applications;

public class ValidPalindrome {
	// public boolean isPalindrome(String s) {
	// if(s.length()==0)
	// return true;

	// s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
	// return checkPalindrome(s);
	// }
    
    public boolean isPalindrome(String s) {
        if(s.length()==0)
            return true;
        
        s= normalize(s);  
        return checkPalindrome(s);
    }
    
    private String normalize(String s){
        
        StringBuilder sb = new StringBuilder();
        char tmp;
        for(int i = 0; i<s.length();i++){
            tmp = s.charAt(i);
            if((tmp<'a'||tmp>'z')&&(tmp<'A'||tmp>'Z')&&(tmp<'0'||tmp>'9')){
                continue;
            }
            if((tmp<='Z'&&tmp>='A'))//lower case
                tmp = (char)(tmp-'A'+'a');
            sb.append(tmp);
        }
        return sb.toString();
    }
    
    private boolean checkPalindrome(String s){
        int len = s.length();
        for(int i = 0;i<len/2;i++){
            if(s.charAt(i)!=s.charAt(len-1-i))
                return false;
        }
        return true;
    }
}
