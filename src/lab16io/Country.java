package lab16io;

public class Country {
	String name;
	int pop;
	double gdp;
	
	public double getGdp() {
		return gdp;
	}

	public void setGdp(double gdp) {
		this.gdp = gdp;
	}

	Country() {
	}

	Country(String name, int pop, double gdp) {
	this.name = name;
	this.pop = pop;
	this.gdp = gdp;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPop() {
		return pop;
	}
	public void setPop(int pop) {
		this.pop = pop;
	}

	@Override
	public String toString() {
		return "Country: "  + name + ". Population: Approx. " + pop + " people. Gross Demostic Product: $" + gdp + ".";
	}
}
