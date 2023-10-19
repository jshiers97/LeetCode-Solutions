class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> res=new ArrayList<>();
        for(int i=0; i<searchWord.length(); i++){
            String sub=searchWord.substring(0, i+1);
            List<String> insert=new ArrayList<>(); 
            for(String str: products){
                if(str.length() <=i){
                    continue;
                }
                String prodSub=str.substring(0, i+1);
                if(prodSub.equals(sub)){
                    insert.add(str);
                    if(insert.size()==3){
                        break;
                    }
                }
            }
            res.add(insert); 
        }
        return res;
    }
}