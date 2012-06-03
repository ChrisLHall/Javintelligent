package net.sajasabie.Javintelligent;

public class JIUpdater implements Runnable{

	private boolean running;
	private static Thread clockThread;
	private long lastUpdateTime;
	
	private final int MILLIS_PER_UPDATE = 33;
	
	
	public JIUpdater() {
		running = true;
		this.lastUpdateTime = System.currentTimeMillis();
		clockThread = new Thread(this);
		clockThread.start();
	}
	
	@Override
	public void run() {
		//run until destroy() sets running to false
		while(running) {
			long currentTime = System.currentTimeMillis();
			if(currentTime - this.lastUpdateTime >= MILLIS_PER_UPDATE) {
				JIApplication.updateAll(currentTime - this.lastUpdateTime);
				this.lastUpdateTime = currentTime;
			}
		}
	}
	
	public void destroy() {
		//set the program to quit running
		running = false;
		//nullify the thread
		clockThread = null;
	}
}
