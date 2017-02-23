package parte1;

import java.util.ArrayList;

public class Main extends Thread{

	public static final int N = 1000000000;
	private int time;
	private int id;
	public Main(int _time, int _id) {
		time = _time;
		id = _id;
	}
	@Override
	public void run(){
		System.err.println(id);
		try {
			sleep(0, time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("fin proceso: " +  id);
	}
	
	public static void main(String[] args) {
		ArrayList<Thread> threads = new ArrayList<>();
		
		for(int i = 0; i < N; i++){
			threads.add(new Main(10, i));
			threads.get(i).start();
		}
		
		for(Thread t : threads){
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("fin");
	}
}
