class Solution {
    public boolean isValid(String s) 
    {
        Stack<Character> st=new Stack<>();
        int n=s.length();
        for(char i:s.toCharArray())
        {
            if(i=='('||i=='{'||i=='[')
            st.push(i);
            else
            {
                if (st.isEmpty()) return false;
                char ch=st.pop();
                if((i==')'&& ch!='(')||(i=='}'&& ch!='{')||(i==']'&& ch!='['))
                return false;
            }
        }
        return st.isEmpty();
        
    }
}