package scripts;

import org.json.simple.JSONObject;

public class Persona {
	private int level;
	private String name;
	
	public Persona(){
		
	}
	
	public Persona(int _level, String _name){
		this.level = _level;
		this.name = _name;
	}
	
	
	@SuppressWarnings("unchecked")
	public JSONObject ToJson(){
		JSONObject json = new JSONObject();
		json.put("name", this.name);
		json.put("level", this.level);
		return json;
	}
}
