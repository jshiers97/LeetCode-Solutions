public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if(strs.size()==0){
            return "";
        }
        StringBuilder str=new StringBuilder();
        for(String s: strs){
            str.append(s);
            str.append("ã");
        }
        str.deleteCharAt(str.length()-1);
        return str.toString(); 
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> output=new ArrayList<>();
        if(s.length()==0){
            
            output.add("");
            return output; 
        }
        String[] strs=s.split("ã", -1);
        
        for(String str: strs){
            output.add(str); 
        }
        return output; 
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));