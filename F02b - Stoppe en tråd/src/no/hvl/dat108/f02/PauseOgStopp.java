package no.hvl.dat108.f02;

public class PauseOgStopp {

	public static void main(String[] args) throws InterruptedException {
		
		MinTraad t = new MinTraad("Hei-tråd");
		t.start();
		
		Thread.sleep(5000);
		
		t.stopp();
	}
}
