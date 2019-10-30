package ieee.template.selector.vo;

public class TemplateJwtResponse {

	private String jwttoken;

	public TemplateJwtResponse(String token) {
		this.jwttoken = token;
	}

	public String getJwttoken() {
		return jwttoken;
	}

	public void setJwttoken(String jwttoken) {
		this.jwttoken = jwttoken;
	}

}
