package parte2;

import java.util.ArrayList;

public class Main{
	final static int NI = 80000;
	final static int ND = 80000;
	
	Capsule c ;
	
	public Main(Capsule _c) {
		c = _c;
	}
	
	public static void main(String[] args) {
		
		ArrayList<Operator> threads = new ArrayList<>();
		Capsule	c = new Capsule();
		
		for(int i = 0; i < NI; i++){
			threads.add(new Increase(c));
			threads.get(i).start();
		}
		for(int i = 0; i < ND; i++){
			threads.add(new Decrease(c));
			threads.get(NI + i).start();
		}
		
		for(Thread t : threads){
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("valor: " + c.getN());
		
	}
}
