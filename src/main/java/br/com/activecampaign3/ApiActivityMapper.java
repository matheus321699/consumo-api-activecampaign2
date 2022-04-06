package br.com.activecampaign3;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



import entity.Users;

public class ApiActivityMapper {

	// // Mapear para lista de usuários
	public static List<Object> fromArrayList(JSONObject obj) {
		
		List<Object> listaUsuarios = new ArrayList<Object>();
		
		try{
    	
//	        obj=new JSONObject(response.toString());
//	        System.out.println(obj.toString());
	        JSONArray jArray = obj.getJSONArray("users");
	        for(int i = 0; i < jArray.length(); i++){
	        	JSONObject o = jArray.getJSONObject(i);
	        	
	        	Integer id = o.getInt("id");
	        	String username = o.getString("username");
	        	String firstName = o.getString("firstName");
	        	String lastName = o.getString("lastName");
	        	String email = o.getString("email");
	        	String phone = o.getString("phone");
	        	String signature = o.getString("signature");
	        	String lang = o.getString("lang");
	        	String localZoneid = o.getString("localZoneid");

	            
	        	listaUsuarios.add(new Users(id, username, firstName, lastName, email, phone, signature, lang, localZoneid));
	        	
//	            Users usuarios = new Users();
//	            usuarios.setUsername(nome);
	
//	            System.out.println(usuarios);
	            
//	            System.out.println(o.toString());
	        	
	        }
        	return listaUsuarios;

	        
    	}catch(JSONException e){
    		e.printStackTrace();
    	}
		
		return null;
	}

}
