class Solution(object):
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        res=[]
        words=sorted(words)
        for i in range(len(sorted(words))-1,-1,-1):
            w=words[i][:-1]
            while w:
                if w in words:
                    w=w[:-1]
                else:
                    break
            if not w:
                res.append(words[i])
        dic={k:len(k) for k in res}
        return sorted(sorted(dic), key=dic.get, reverse=True)[0]