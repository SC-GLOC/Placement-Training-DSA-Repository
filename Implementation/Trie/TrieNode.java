
import java.util.HashMap;
import java.util.Map;

public class TrieNode{


    boolean endOfString;
    Map<Character,TrieNode> children;

    public TrieNode() {
        
        this.endOfString=false;
        children = new HashMap<>();
    }

    
}