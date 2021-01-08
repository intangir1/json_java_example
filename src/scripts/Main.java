package scripts;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {
	
    final static String KEY_NAME = "name";
    final static String KEY_LEVEL = "jokerlevel";
    final static String KEY_PERSONAS = "personasarray";
    final static String KEY_BESTGIRL = "bestgirl";
	
	
	private static void Just_create_file() {
		try {
		      File myObj = new File("SaveFiles.txt");	// mozhno dat' polniy link. by default - v samom proekte (tam gde src, bin)
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		} catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
	
	
	private static void Create_and_write_file() {
		try {
		      FileWriter myWriter = new FileWriter("SaveFiles.txt");
		      myWriter.write("Files in Java might be tricky, but it is fun enough!");
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	@SuppressWarnings("unchecked")
	private static JSONArray Create_personas(int i) {
		JSONArray personas = new JSONArray();
		
		if(i == 0){
			personas.add(new Persona(91, "Messiah").ToJson());
			personas.add(new Persona(92, "IzanagiNoOkami").ToJson());
			personas.add(new Persona(93, "Satanael").ToJson());
		} else{
			personas.add(new Persona(1, "JackFrost").ToJson());
			personas.add(new Persona(2, "PyroJack").ToJson());
		}
		
		return personas;
	}
	
	
	@SuppressWarnings("unchecked")
	private static void Create_json_array() {
		JSONArray save_files = new JSONArray();
//		JSONObject place_and_savefile = new JSONObject();
		JSONObject save_file_details = new JSONObject();

       // detali fayla
        save_file_details.put(KEY_NAME, "eVgen");
        save_file_details.put(KEY_LEVEL, 99);
        save_file_details.put(KEY_BESTGIRL, "Makoto");
        save_file_details.put(KEY_PERSONAS, Create_personas(0));
       
        // sohranenie v yacheyku 1
//        place_and_savefile.put(1, save_file_details);
        
        // v obshiy spisok
//        save_files.add(place_and_savefile);
        save_files.add(save_file_details);
        
//        place_and_savefile = new JSONObject();
        save_file_details = new JSONObject();
        save_file_details.put(KEY_NAME, "raVa");
        save_file_details.put(KEY_LEVEL, -2);
        save_file_details.put(KEY_BESTGIRL, "Shamil");
        save_file_details.put(KEY_PERSONAS, Create_personas(1));
        
//        place_and_savefile.put(2, save_file_details);
         
        save_files.add(save_file_details);
        
        
  
//        place_and_savefile = new JSONObject();
//        place_and_savefile.put(3, null);
        save_files.add(null);
        
        
        try (FileWriter file = new FileWriter("saves.json")) {
        	 
            file.write(save_files.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
        
	}
	
	
	@SuppressWarnings("unchecked")
	private static void Load_file() {
		
		
		
		
		//JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader("saves.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray savesList = (JSONArray) obj;
         //   System.out.println(savesList);
            
    		System.out.println("Choose file to load");
    		Scanner scn = new Scanner(System.in);
    		int num = scn.nextInt();
             
            //Iterate over saves array
            //employeeList.forEach( save -> parseSaveObject( (JSONObject) save ) );
    		
    		if(savesList.get(num - 1) == null){
    			System.out.println("Nothing!");
    		} else{
    			JSONObject save_file = (JSONObject) savesList.get(num-1);
    			String name = (String) save_file.get(KEY_NAME);
    			System.out.println(name);
    		}
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        
	}
	
	
//	private static void parseSaveObject(JSONObject save) 
//    {
//        //Get employee object within list
//        JSONObject save_file = (JSONObject) employee.get("employee");
//         
//        //Get employee first name
//        String firstName = (String) employeeObject.get("firstName");    
//        System.out.println(firstName);
//         
//        //Get employee last name
//        String lastName = (String) employeeObject.get("lastName");  
//        System.out.println(lastName);
//         
//        //Get employee website name
//        String website = (String) employeeObject.get("website");    
//        System.out.println(website);
//    }
	


	public static void main(String[] args) {
		
	//	Just_create_file();
	//	Create_and_write_file();
	//	Create_json_array();
	//	Load_file();
		
	}
}
