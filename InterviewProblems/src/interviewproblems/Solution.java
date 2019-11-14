package interviewproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
	
	
    public static List<String> funWithAnagrams(List<String> s) {
    // Write your code here
    	Set<String> dontRemove = new HashSet<String>();
        Set<String> removeMe = new HashSet<String>();
        for (String s1 : s) {
            char temp1[] = s1.toCharArray();
            Arrays.sort(temp1);
            String sort1 = new String(temp1);
            for (String s2 : s) {
            	if (s1.equalsIgnoreCase(s2)) continue;
            	else {
	                // sort both strings
	                char temp2[] = s2.toCharArray();
	                Arrays.sort(temp2);
	                String sort2 = new String(temp2);
	                // compare sorted strings
	                if (!dontRemove.contains(s1) && !dontRemove.contains(s2) && sort1.equalsIgnoreCase(sort2)) {
	//                	System.out.println("sort1 " + sort1 + " \n" + "sort2 " + sort2 );
	                    removeMe.add(s2);
	                    System.out.println("remove " + s2);
	                    dontRemove.add(s1);
	                    System.out.println("dontRemove " + s1);
	                }
            	}
            }
        }
        for (String s3 : removeMe) {
        	System.out.println("remove : " + s3);
            s.remove(s3);
        }
        System.out.println("" + s);
        return s;
    }
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("code");
		list.add("aaagmnrs");
		list.add("anagrams");
		list.add("doce");
		
		funWithAnagrams(list);
	}
}
