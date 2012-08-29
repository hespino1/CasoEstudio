package co.edu.eafit.carritocompras.data;

import java.math.BigDecimal;
import java.util.List;

public class Customer {

	private String code;
	private String name;
	private int points;
	private List<Purchase> purchases;

	public Customer(String code, String name) {
		super();
		this.code = code;
		this.name = name;
		this.points = 0;
	}
	
	public int pointsCalculate(BigDecimal totalPrice) {

		int pointHelp = 1000;
		BigDecimal pointHelp1 = new BigDecimal(pointHelp);
		BigDecimal totalPoints = new BigDecimal(0);
        
		totalPoints = pointHelp1.divide(totalPrice);

		points = totalPoints.intValueExact();
		setPoints(points);
		return points;
	}
	
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	public String getCode() {
		return code;
	}

	public List<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
