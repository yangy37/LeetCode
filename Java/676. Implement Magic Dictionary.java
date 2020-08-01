class MagicDictionary {
    Trie root;
    /** Initialize your data structure here. */
    public MagicDictionary() 
    {
        root = new Trie('.', false);
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) 
    {
        for (String word:dict)
        {
            addWord(word.toCharArray(), 0, root);
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) 
    {
        return searchWord(word.toCharArray(), 0, root, 0);
    }
    
    public void addWord(char[] word, int i, Trie root){
        if (i<word.length){
            if (root.children.get(word[i])==null) root.children.put(word[i], new Trie(word[i], i==word.length-1));
            addWord(word, i+1, root.children.get(word[i]));
        }
    }
    
    public boolean searchWord(char[]word, int i, Trie root, int diff)
    {
        if (diff<=1)
        {
            if (i==word.length) return root.finish && diff==1;
            else if (i<word.length)
            {
                for (char x:root.children.keySet())
                {
                    if (searchWord(word, i+1, root.children.get(x), diff + ((x==word[i]?0:1)))) return true;
                }
                return false;
            } 
            else return false;
        }
        else return false;
    }
}


class Trie {
    char c;
    Map<Character, Trie>children;
    boolean finish;
    public Trie(char c, boolean finish)
    {
        this.c = c;
        this.children = new HashMap<>();
        this.finish = finish;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */