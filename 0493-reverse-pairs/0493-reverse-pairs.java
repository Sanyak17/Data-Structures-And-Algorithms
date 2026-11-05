class Solution 
{
    static class SegTree
    {
        int n;
        int[] tree;
        public SegTree(int n)
        {
            this.n=n;
            tree=new int[4*n];
        }
        public int query(int idx,int L,int R,int ql,int qr)//remains same everywhere
        {
            if(L>qr||R<ql)//no
            return 0;
            if(ql<=L && R<=qr)//fuly
            {
                return tree[idx];
            }
            int mid=(L+R)/2;
            return query(2*idx+1,L,mid,ql,qr)+query(2*idx+2,mid+1,R,ql,qr);
        }
        public void update(int node,int L,int R,int idx)//idx is jiska count badhana   which node is processed from right
        {
            if(L==R)
            {
                tree[node]++;
                return;
            }
            int mid=(L+R)/2;
            if(idx<=mid)
            update(2*node+1,L,mid,idx);
            else
            update(2*node+2,mid+1,R,idx);
            tree[node]=tree[2*node+1]+tree[2*node+2];
        } 
    }
    public int reversePairs(int[] nums) 
    {
        int n=nums.length;
        TreeSet<Long> set=new TreeSet<>();
        for(int val:nums)
        {
            set.add(val*1L);
            set.add(2L*val);
        }
        List<Long> list=new ArrayList<>(set);
        HashMap<Long,Integer> map=new HashMap<>();
        int idx=0;
        for(int i=0;i<list.size();i++)
        {
            if(!map.containsKey(list.get(i)))
            map.put(list.get(i),idx++);
        }
        SegTree seg=new SegTree(idx);
        int ans=0;
        for(int j=0;j<n;j++)
        {
            //arr[i]>2*arr[j];
            int val=map.get((long)(nums[j]*2L));
            ans+=seg.query(0,0,idx-1,val+1,idx-1);
            seg.update(0,0,idx-1,map.get((long)nums[j]));
        }
        return ans;
    }

}