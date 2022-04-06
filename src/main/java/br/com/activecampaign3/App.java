package br.com.activecampaign3;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.json.JSONObject;

import dto.DAO;
import entity.Users;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	
        System.out.println( "Hello World!" );
        
//		ActiveCampaignConnection.getStart("https://codetec.api-us1.com/api/3/users");
		Map<String, String> queryParams = new HashMap<String, String>();
		
		int size = 10;
		
//		int start = ActiveCampaignConnection.getStart(page, size);
	    queryParams.put("start", String.valueOf(10));
		queryParams.put("limit", String.valueOf(size));
	
		// Conexão e envio de requisição com verbo Get, recebendo os dados do Json
	    String response =  ActiveCampaignConnection.get("", queryParams);
   	    System.out.println();
   	    System.out.println(response);
	    System.out.println("----------------------");
	    
	    System.out.println();

	    /*
	     *  Mapeando Json Object para uma lista Lista, setando os objetos e salvando
	     *  na lista
	     */
	    JSONObject obj=null;        	
        obj= new JSONObject(response.toString());      
        List<Object> listaUsuarios = ApiActivityMapper.fromArrayList(obj);
        
        // Percorrendo a lista
        for(Object usuario : listaUsuarios) {
        	
            System.out.println(((Users) usuario)); 
            System.out.println();
        }

// --------------------------------------------------------------------------------------------------        
        
        /*
         * Utilizando um DAO genérico para fazer conexão com o banco de dados e persistir
         * os dados dos usuários através da lista usuários 
         */
        DAO<Users> dao = new DAO<>(Users.class);
        dao.incluirTodosAtomico(listaUsuarios);
        
/*       
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("activecampaign");
        EntityManager em = emf.createEntityManager();
        
        em.close();
        emf.close();
        
*/
    }
}
