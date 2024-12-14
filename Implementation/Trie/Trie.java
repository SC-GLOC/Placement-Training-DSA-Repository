public class Trie {


    TrieNode root;

    public Trie() {
       root=new TrieNode();
       System.out.println("The Trie Has Been Created");
      
    }


    // Insertion in Trie - TC -O(M), SC- O(M)


    public void insert(String word)
    {
        TrieNode currNode =root;

        for(int i=0;i<word.length();i++){

            char ch = word.charAt(i);

            TrieNode node = currNode.children.get(ch);

            if(node==null){
                node = new TrieNode();
                currNode.children.put(ch, node);
            }

            currNode=node;
        }

        currNode.endOfString=true;
        System.out.println("Word "+word+" Successfully Inserted In Trie");
    }

    public boolean search(String word){

        TrieNode currNode=root;

        for(int i=0;i<word.length();i++)
        {
            char ch = word.charAt(i);

            if(currNode.children.get(ch)==null)
            return false;

            currNode=currNode.children.get(ch);
        }

        if(currNode.endOfString)
        System.out.println("The Word "+word+" Exists In Trie");
        else
        System.out.println("The Word "+word+" Doesnt Exists In Trie");

        return currNode.endOfString;
    }

    private boolean delete(TrieNode parentNode, String word, int index) {
        char ch = word.charAt(index);
        TrieNode currentNode = parentNode.children.get(ch);
        boolean canThisNodeBeDeleted;
  
        if (currentNode.children.size() > 1) {
          delete(currentNode, word, index+1);
          return false;
        }
        if (index == word.length() -1) {
          if (currentNode.children.size()>=1) {
            currentNode.endOfString = false;
            return false;
          } else {
            parentNode.children.remove(ch);
            return true;
          }
        }
        if (currentNode.endOfString == true) {
          delete(currentNode, word, index+1);
          return false;
        }
        canThisNodeBeDeleted = delete(currentNode, word, index+1);
        if (canThisNodeBeDeleted == true) {
          parentNode.children.remove(ch);
          return true;
        } else {
          return false;
        }
      }
  
      public void delete(String word) {
        if (search(word) == true) {
          delete(root, word, 0);
        }
      }



    
    
}
