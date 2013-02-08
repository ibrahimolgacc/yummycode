package net.yummycode.jsfplate.domain;

import java.io.Serializable;
 
public class CountryItem implements Serializable {

	private static final long serialVersionUID = 3012227298306961884L;

	private String name;
	private String capital;
	private String languages;
	
	public CountryItem() {}

	public CountryItem(String name, String capital, String languages) {
		super();
		this.name = name;
		this.capital = capital;
		this.languages = languages;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCapital() {
		return capital;
	}
	
	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}
	
}
