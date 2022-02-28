package RestAssuredTesting.payload;

import org.apache.commons.lang3.StringUtils;

import kong.unirest.json.JSONObject;

public class Post {
	
	private int userId;
	private int id;
	private String title;
	private String body; 
	
	 public Post() {
	    }

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
public boolean compare(JSONObject obj1) {
	
	return title.equals(obj1.get("title"))&&StringUtils.normalizeSpace(body).equals(StringUtils.normalizeSpace(obj1.get("body").toString()))&&userId==(int)(obj1.get("userId"));
	
}
	
}
