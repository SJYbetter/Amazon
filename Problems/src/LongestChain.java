static int longest_chain(String[] w) {

if (null == w || w.length == 0) return 0;

//Index words by length. Key: length, value: set of words with given length
//Use TreeMap so that the keys are sorted
TreeMap> wordsByLength = new TreeMap>();

for (int i = 0; i < w.length; ++i) { int wordLen = w.length(); Set wordsOfLen = wordsByLength.get(wordLen);
if (null == wordsOfLen) {
wordsOfLen = new HashSet();
wordsByLength.put(wordLen, wordsOfLen);
}
wordsOfLen.add(w);
}

int longest = 1;

//process the longest word first (using descendingMap)
for (Map.Entry> entry : wordsByLength.descendingMap().entrySet()) {
Set wordsOfLen = entry.getValue();
for (String word : wordsOfLen) {
int chainLenOfTheWord = getChainLenOfTheWord(word, wordsByLength);
longest = Math.max(longest, chainLenOfTheWord);
}
}

return longest;
}

//Make recursive calls.Remove visited (shorter) words for performance
static private int getChainLenOfTheWord(String word, Map> wordsByLength) {

if (1 == word.length()) return 1;//base case

int chainLenOfTheWord = 1;
for (int i = 0; i < word.length(); ++i) { StringBuilder sb = new StringBuilder(word); sb.deleteCharAt(i);//delete char at i String shorter = sb.toString(); Set wordsOfLen = wordsByLength.get(shorter.length());
if (null != wordsOfLen) {
if (wordsOfLen.remove(shorter)) { // remove it, no need to visit it again
int chainLenOfTheShorter = getChainLenOfTheWord(shorter, wordsByLength);
chainLenOfTheWord = Math.max(chainLenOfTheWord, chainLenOfTheShorter + 1);
}
}
}

return chainLenOfTheWord;
}
