package hiquanta.rxjava;

import java.util.List;



public class Students {
	private String name;
	List<Courses> coures;

	public List<Courses> getCoures() {
		return coures;
	}

	public void setCoures(List<Courses> coures) {
		this.coures = coures;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
