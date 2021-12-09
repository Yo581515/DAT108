package waitnotify;

public class Main {

	private static String melding;

	public static void main(String[] args) {

		Object objectLock = new Object();

		Thread printlnTraad = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (objectLock) {
					while (melding == null) {
						try {
							objectLock.wait();
						} catch (InterruptedException e) {
						}
					}
				}
				System.out.println(melding);
			}
		});

		Thread giVerdiTraad = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (objectLock) {
					melding = "Hallo";
					objectLock.notifyAll();
				}
			}
		});

		printlnTraad.start();
		giVerdiTraad.start();
	}

}
