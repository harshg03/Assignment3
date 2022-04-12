import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


public class Translator {

	public static void main(String[] args) throws IOException {
		
		String text = "Bonjour je m'appelle Robert";
		
		System.out.println(translate("fr", "en", text));
	}
	
	private static String translate(String current, String to, String text) throws IOException {
		
        String urlStr =  "Your google script link with api" +
                "?q=" + URLEncoder.encode(text, "UTF-8") +
                "&target=" + to +
                "&source=" + current;
        URL url = new URL(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        String myResponse = response.toString();
        char[] myArray = myResponse.toCharArray();
        String actualResponse = "";
        for(int i = 0; i < myArray.length - 1; i++) {
        	if(myArray[i] != '"')
        		actualResponse += myArray[i];
        }
        
        return actualResponse;
	}
}
