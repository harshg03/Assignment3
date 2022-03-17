
import java.util.StringTokenizer;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;
public class PoSTagger {
	public static void main(String[] args) {
		//getProperNoun("My name is Jeena");
	}
	public static String getProperNoun(String sample) {
		MaxentTagger tagger=new MaxentTagger("lib/english-left3words-distsim.tagger");
		//String tagged=tagger.tagString(sample);
		StringTokenizer st=new StringTokenizer(sample);
		while(st.hasMoreTokens()) {
			String t=st.nextToken();
			if(tagger.tagString(t).equals(t+"_NNP ")) {
				return t;
			}
		}
		return "";
		
	}
	

}
