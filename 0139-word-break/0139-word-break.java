import java.util.*;

class Solution {
    // Ab hum 2 array pass kar rahe hain: visited aur dp
    public boolean ans(String s, List<String> wordDict, boolean[] visited, boolean[] dp, int idx) {
        // Base case: agar string poori cross ho gayi
        if (idx == s.length()) return true;
        
        // Sabse pehla sawal: Kya main yahan pehle aa chuka hoon?
        if (visited[idx] == true) {
            // Agar haan, toh jo bhi result yahan se mila tha, wahi wapas de do
            // Chahe wo true ho ya false, humein dubara loop chalane ki zaroorat nahi
            return dp[idx];
        }
        
        // Agar yahan nahi aaye the, toh ab hum ise mark kar dete hain
        visited[idx] = true;
        
        // Ab normal tarike se combinations try karte hain
        for (int end = idx + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(idx, end)) && ans(s, wordDict, visited, dp, end)) {
                // Agar successful rasta mila, toh memoize kar do true aur return karo
                return dp[idx] =true;
            }
        }
        
        // Agar saare combinations check kiye aur kuch nahi mila, 
        // toh false set kar do (kyunki primitive boolean default hi false hota hai, 
        // toh explicitly set na karein toh bhi theek hai, par logic clear karne ke liye theek hai)
        
        return dp[idx] =  false;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        // Do arrays banayenge
        boolean[] visited = new boolean[s.length() + 1];
        boolean[] dp = new boolean[s.length() + 1];
        
        return ans(s, wordDict, visited, dp, 0);
    }
}