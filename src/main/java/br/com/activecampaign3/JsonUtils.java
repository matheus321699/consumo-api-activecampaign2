package br.com.activecampaign3;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.JsonArray;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JsonUtils {

	public static JsonArray getJsonArrayOrEmpty(JSONObject jsonObject) {

		
		for (String key : JSONObject.getNames(jsonObject)) {
			JSONArray jsonArray = new JSONArray();
		    jsonArray.put(jsonObject.getJSONObject(key));
		}
/*       
        if (jsonElement instanceof JsonArray) {
        	JsonArray  jarray =  new JsonArray(jsonElement.getAsJsonArray());
        	return jarray;
        }
*/

        return null;
	}

}

/*
	if (jelement instanceof JsonObject) {
		return JsonObject  jobject = new JsonObject(jelement.getAsJsonObject());
	} else if (jelement instanceof JsonArray) {
		return JsonArray  jarray =  new JsonArray(jelement.getAsJsonArray());
	}

*/