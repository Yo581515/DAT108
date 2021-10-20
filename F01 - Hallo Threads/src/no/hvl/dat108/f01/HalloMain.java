package no.hvl.dat108.f01;

public class HalloMain {

	public static void main(String[] args) throws InterruptedException {
		
/*
 * Det er to hovedmåter (extends Thread og implements Runnable) 
 * og 5 varianter i hvordan man kan opprette en tråd.
 */
		
// #1	Thread t = new MinTraad();
		
// #2	Thread t = new Thread() {
//			@Override
//			public void run() {
//				System.out.println("Hallo fra anonym Thread");
//			}
//		};
		
// #3	Thread t = new Thread(new MinRunnable());
		
// #4	Thread t = new Thread(new Runnable(){
//			@Override
//			public void run() {
//				System.out.println("Hallo fra anonym Runnable");
//			}
//		});
		
// #5
		Thread t = new Thread(() 
				-> System.out.println("Hallo fra lambda-Runnable"));

		t.start();
		
// ...

//Starte mange tråder		
		for (int i=0; i<10; i++) {
			Thread tt = new Thread(() -> System.out.println(
					"Hallo fra tråd " + Thread.currentThread().getName()), "" + i);
			tt.start();
		}
		
		Thread.sleep(8);
		
		System.out.println("Hallo fra main");
	}

}
