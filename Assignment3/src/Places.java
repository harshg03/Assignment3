import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import org.json.*;

public class Places {
	
	public static void main(String[] args) throws IOException, JSONException {
		System.out.println(findPlace("Kelowna"));
	}

	
	public static String findPlace(String location) throws IOException, JSONException {
		String yourApiKey = "Change to your api key";
        //can you use textsearch for more examples instead of one example from findplacefromtext
		String urlStr =  "https://maps.googleapis.com/maps/api/place/findplacefromtext/json?input=Mental%20Health%20Help%20" + location 
				+ "&inputtype=textquery&fields=formatted_address%2Cname%2Crating&key=" + yourApiKey;
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
        
        //Makes the response a valid json array
        int startIndex = myResponse.indexOf('[');
        int endIndex = myResponse.indexOf(']') + 1;
        String change = myResponse.substring(startIndex, endIndex);
        
        JSONArray jsonObject = new JSONArray(change.trim());
        //We can change this to an array to hold multiple examples
        String address = "";
        String name = "";
        String rating = "";
        
        for(int i = 0; i < jsonObject.length(); i++) {
            JSONObject objects = jsonObject.getJSONObject(i);
            address = objects.get("formatted_address").toString();
            name = objects.get("name").toString();
            rating = objects.get("rating").toString(); 
        }
        
        
        return "The " + name + "\n"  + "is our recommended mental health representative for you," + "\n"  +  "it is located on " + address + "\nand has a rating of " + rating;
	}
}
