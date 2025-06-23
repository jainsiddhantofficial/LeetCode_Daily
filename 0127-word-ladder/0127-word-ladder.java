class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q  = new LinkedList<>();
        Set <String> st = new HashSet<>(wordList);
        q.add(new Pair (beginWord,1));
        st.remove(beginWord);
        while(!q.isEmpty()){
            Pair current = q.poll();
            String word = current.first;
            int  step = current.second;

            if(word.equals(endWord)) return step; 


            for(int i = 0 ; i < word.length() ; i++){
                for (char j = 'a' ; j <= 'z' ; j++){
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = j;
                    String replacedWord = new String(replacedCharArray);


                    if(st.contains(replacedWord)){
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord, step+1));

                    }
                }
            }
        

        }
        return 0;
    }
    class Pair{
        String first ;
        int second ;
        Pair(String first , int second){
            this.first = first;
            this.second = second ;
        }
    }
}