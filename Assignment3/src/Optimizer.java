import java.util.Properties;

import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.pipeline.*;
public class Optimizer {
	
	public static void main(String[] args) {
		String text="happy going leaving";
		System.out.println(getOptimized(text));
	}
	public static String getOptimized(String s) {
		String result="";
		Properties props = new Properties();
		props.setProperty("annotators", "tokenize,ssplit,pos,lemma");
	    // build pipeline
	    StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
	    // create a document object
	    CoreDocument document = pipeline.processToCoreDocument(s);
	    for (CoreLabel tok : document.tokens()) {
	    	result=result+tok.lemma()+" ";
	        //System.out.println(tok.word()+ tok.lemma());
	      }
		return result;
		
	}

}
