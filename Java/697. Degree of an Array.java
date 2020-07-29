class Solution {
public:
    int findShortestSubArray(vector<int>& n) {
        if(n.size()==0 || n.size()==1) return n.size();
        map<int,vector<int>>mp;
        for(int i=0;i<n.size();i++){
            if(mp.count(n[i])){
                mp[n[i]][0]++;
                mp[n[i]].pop_back();
                mp[n[i]].push_back(i);
            }else{
                mp[n[i]].push_back(1);
                mp[n[i]].push_back(i);
                mp[n[i]].push_back(i);
            }
        }
        map<int,vector<int>>mymap;
        auto it=mp.begin();
        while(it!=mp.end()){
            mymap[it->second[0]].push_back(it->second[2] -  it->second[1]+1);
            it++;
        }
        auto x=mymap.rbegin();
        int ans=INT_MAX;
        for(int i=0;i<x->second.size();i++){
            ans=min(ans,x->second[i]);
        }
        return ans;
    }
};