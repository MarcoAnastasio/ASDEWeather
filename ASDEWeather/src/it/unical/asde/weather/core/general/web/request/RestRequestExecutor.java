package it.unical.asde.weather.core.general.web.request;

import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class RestRequestExecutor {

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
