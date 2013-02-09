package net.yummycode.jsfplate.domain;

import java.io.Serializable;

/**
 * The Class containing an item (country)
 * 
 * @author Francois Andry
 * @version 1.0
 */
 
public class CountryItem implements Serializable {

	private static final long serialVersionUID = 3012227298306961884L;

	private static long LARGE_GDP_IN_$M = 1000000;
	
	private String name;
	private String capital;
	private String languages;
	private long gdp;
	
	public CountryItem() {}

	public CountryItem(String name, String capital, String languages, String gdp) {
		super();
		this.name = name;
		this.capital = capital;
		this.languages = languages;
		this.gdp = Long.parseLong(gdp);
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

	public String getGdp() {
		return String.valueOf(gdp);
	}

	public void setGdp(String gdp) {
		this.gdp = Long.parseLong(gdp);
	}

	public boolean isLargeGdp() {
		return (gdp > LARGE_GDP_IN_$M);
	}
}
