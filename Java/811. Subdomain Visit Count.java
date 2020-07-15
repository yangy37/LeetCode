class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> domainVsVisit= new HashMap();
        List<String> domains= new ArrayList();
        for(String s:cpdomains){
            int i = s.indexOf(' ');
            int count = Integer.parseInt(s.substring(0, i));
            String netAddr = s.substring(i + 1);
           domainVsVisit.put(netAddr,domainVsVisit.getOrDefault(netAddr,0)+count);
            while(!netAddr.isEmpty()){
                int index = netAddr.indexOf(".");
                if(index==-1){
                    break;
                }
                netAddr=netAddr.substring(index+1);
                domainVsVisit.put(netAddr,domainVsVisit.getOrDefault(netAddr,0)+count);
            }
        }
        for(Map.Entry<String,Integer> entry:domainVsVisit.entrySet()){
            domains.add(entry.getValue()+" "+entry.getKey());
        }
        return domains;
    }
}