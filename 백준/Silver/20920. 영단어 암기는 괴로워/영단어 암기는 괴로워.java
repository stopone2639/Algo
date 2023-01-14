
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 */
public class Main {
    private static class Word implements Comparable<Word>{
        public String word;
        public Integer length;
        public Integer fre;

        public Word(String word, Integer length, Integer fre){
            this.word = word;
            this.length = length;
            this.fre = fre;
        }

        @Override
        public int compareTo(Word word) {
            if(this.fre == word.fre){
                if(this.length == word.length){
                    return this.word.compareTo(word.word);
                } else{
                    return word.length - this.length;
                }
            }
            return word.fre - this.fre;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken()); //글자 갯수
        int M = Integer.parseInt(st.nextToken()); //글자 길이 제한
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++){
            String word = br.readLine();
            if(word.length() >= M){
                if(map.containsKey(word)){
                    map.put(word, map.get(word) + 1);
                } else{
                    map.put(word, 1);
                }
            }
        }
        TreeSet<Word> set = new TreeSet<>();
//        List<Word> list = new ArrayList<>();
        Iterator<String> iter = map.keySet().iterator();
        while (iter.hasNext()){
            String key = iter.next();
            Integer value = map.get(key);
//            list.add(new Word(key, key.length(), value));
            set.add(new Word(key, key.length(), value));
        }
        Iterator<Word> iterWord = set.iterator();
        while (iterWord.hasNext()){
            Word word = iterWord.next();
            sb.append(word.word).append("\n");
        }
//        Collections.sort(list);
//        for (Word word: list) {
//            sb.append(word.word).append("\n");
//        }
        System.out.println(sb);
    }
}
