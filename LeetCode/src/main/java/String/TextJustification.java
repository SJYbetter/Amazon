import java.util.ArrayList;
import java.util.List;
//compute one line need how many words
//for each line need how many spaces between each word
//still need add extra spaces because cannot insert evenly spaces 26  5+1 5 5 5 5
//if last line we don't need to add extra space
public class TextJustification {
    public static List<String> fullJustify(String words1, int L) {
    	String[] words = words1.split(" "); 
        List<String> lines = new ArrayList<String>();
        int index = 0;
        while (index < words.length) {
            //count：该行所有单词累计总长度
            int count = words[index].length();
            //last:该行最后一个词的index
            int last = index + 1;
            while (last < words.length) {
                //out of bound
                if (words[last].length() + count + 1 > L) break;
                //plus one for the space, if its a perfect fit it will fit
                count += 1 + words[last].length();
                last ++;
            }
            StringBuilder builder = new StringBuilder();
            //append该行第一个单词
            builder.append(words[index]);
            //这一行除去第一个已经append的单词，共剩下几个词语：diff 个：从index到last-1
            int diff = last - index - 1;
            //if last line or number of words in the line is 1, left-justified
            //最后一行：每个单词中间一个空格， 剩余补上空白
            if (last == words.length || diff == 0) {
                for (int i = index+1; i < last; i++) {
                    builder.append(" ");
                    builder.append(words[i]);
                }
                //put remaining space
                //for (int i = builder.length(); i < L; i++) {
                    //builder.append(" ");
                //}
            } else {
                //not last line：middle justified
                //这一行总space的个数：（长度-累计单词总长度）
                //每个单词后面space的个数：（长度-累计单词总长度）/单词个数
                //r为需要平均分配到中间的空格总数(可能不能均分，所以需要平均插入前面可以插入的那几个）
                int spaces = (L- count) / diff;
                int r = (L - count) % diff;
                for (int i = index+1; i < last; i++) {
                	//add same number of space after each word
                    for(int k=spaces; k > 0; k--) {
                        builder.append(" ");
                    }
                    //add one space for each word
                    if(r > 0) {
                        builder.append(" ");
                        r--;
                    }
                    //计算了count里面了 这个space
                    builder.append(" ");
                    builder.append(words[i]);
                }
            }
            lines.add(builder.toString());
            System.out.println(builder.toString());
            System.out.println(builder.toString().length());
            index = last;
        }
        return lines;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ss = "This is some sample text, just enough for the justify function to have a few lines to work with to show what it is supposed to do.";
		List<String> ans = fullJustify(ss, 25);
		String s = "bbbbbbbaaaaaa";
		String s1 = s.substring(0,8);
		
	

	}

}
