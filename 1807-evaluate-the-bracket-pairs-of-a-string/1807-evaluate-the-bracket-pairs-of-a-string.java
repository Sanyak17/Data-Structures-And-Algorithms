class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
       Map<String,String> map=new HashMap<>();
       for(int i=0;i<knowledge.size();i++)
       {
        List<String> item=knowledge.get(i);
        map.put(item.get(0),item.get(1));
       } 
       StringBuilder sb=new StringBuilder();
       for(int i=0;i<s.length();i++)
       {
        if(s.charAt(i)!='('&& s.charAt(i)!=')')
        {
            sb.append(s.charAt(i));
        }
        else if(s.charAt(i)=='(')
        {
            int j=i+1;
            StringBuilder key=new StringBuilder();
            while(s.charAt(j)!=')')
            {
                key.append(s.charAt(j));
                j++;
                i++;
            }
            String val=map.get(key.toString());
            if(val==null)
            sb.append("?");
            else
            sb.append(val);
        }
       }
       return sb.toString();
    }
}