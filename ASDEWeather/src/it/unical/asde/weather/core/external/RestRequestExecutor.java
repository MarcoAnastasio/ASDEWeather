package it.unical.asde.weather.core.external;

import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * this class is used to generalize the method of executing request,
 * so eatch class that need to submit a request to an external service 
 * and expect a jason as response can extends this class
 * @author Marco
 *
 */
public abstract class RestRequestExecutor {

	private static final JSONParser jsonParser=new JSONParser();
	
	protected JSONObject executeRestRequestAndReturnJSONObject(String url){
		InputStream input=null;
		JSONObject responseObject =null;
		try {
			input=new URL(url).openStream();
			String inputString = IOUtils.toString(new URL(url),"UTF-8");
			System.out.println(inputString);
			responseObject =(JSONObject) jsonParser.parse(inputString);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				input.close();								
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		return responseObject;
	}
	
	
}
