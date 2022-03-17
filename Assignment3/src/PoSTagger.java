
import java.util.StringTokenizer;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;
public class PoSTagger {
	public static void main(String[] args) {
		//System.out.println(
		//		getProperNoun("my name is Atmaza"));
	}
	public static String getProperNoun(String sample) {
		MaxentTagger tagger=new MaxentTagger("lib/english-left3words-distsim.tagger");
		//String tagged=tagger.tagString(sample);
		StringTokenizer st=new StringTokenizer(sample);
		while(st.hasMoreTokens()) {
			String t=st.nextToken();
			if(tagger.tagString(t).equals(t+"_NNP ")) {
				return t.substring(0,1).toUpperCase()+t.substring(1);
			}
		}
		return "";
		
	}
	

}
