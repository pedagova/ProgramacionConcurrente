package parte2;

public class Increase extends Operator{
	
	public Increase(Capsule _c) {
		super(_c);
	}

	@Override
	public void run() {
		c.execIn();
	}
	
}
