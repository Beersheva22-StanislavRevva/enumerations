package telran.measure;

public enum LengthUnit {
MM(1), CM(10), IN(25.4f), M(1000),KM(1_000_000);
	float value;
	LengthUnit(float value) {
		this.value = value;
	}
	public Length between(Length l1, Length l2) {
		//returns Length object as length between l1 and l2 in "this" units
		//Example: LengthUnit.M.between (new Length(200, LengthUnit.CM), new Length(1, LengthUnit.M))
		//returns Length(1, LengthUnit.M)
		Length res = l1.convert(this);
		Length res2 = l2.convert(this);
		res.amount = res.getAmount() - res2.getAmount(); 
		return res;
	}
	public float getValue() {
		return value;	
	}
	
	
	
}