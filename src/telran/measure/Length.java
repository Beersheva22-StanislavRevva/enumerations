package telran.measure;

import java.util.Comparator;

public class Length implements Comparable<Length>{
	float amount;
	private LengthUnit lengthUnit;
	public Length(float amount, LengthUnit lengthUnit) {
		this.amount = amount;
		this.lengthUnit = lengthUnit;
	}
	@Override
	/**
	 * equals two Length objects according to LengthUnit and amount
	 * 10m == 10000mm
	 */
	public boolean equals(Object obj) {
		return compareTo((Length)obj) == 0;
	}

	@Override
	/**
	 * 
	 * @param o
	 * @return < 0 "this" object less than "o" object,
	 *  > 0 "this" object greater than "o" object,
	 *  == 0 "this" object equals "o" object,
	 */
	public int compareTo(Length o) {
		Length l = LengthUnit.M.between(this, o);
		int res;
		if (l.amount < 0 && l.amount < -1) {
			res = -1; 
		} if (l.amount > 0 && l.amount < 1) {
			res = 1;
			}else res = (int)l.amount;
		return res;
	}
	/**
	 * 
	 * @param unit
	 * @return new Length object with a given LengthUnit
	 * example, convert(LengthUnit.M) returns Length in meters 
	 */
	public Length convert(LengthUnit unit) {
		Length res = new Length (0f,unit);
		res.amount = this.amount / res.lengthUnit.value * this.lengthUnit.value;
		return res;
	}
	@Override
	/**
	 * returns string with amount and length unit pinned to amount with no space
	 * Example: 20.0M (string expression of Length object presenting 20 meters)
	 */
	public String toString() {
		String res = String.valueOf(this.amount) + String.valueOf(this.lengthUnit);
		return res;
	}

	public float getAmount() {
		return amount;
	}

	public LengthUnit getUnit() {
		return lengthUnit;
	}
	
	
}