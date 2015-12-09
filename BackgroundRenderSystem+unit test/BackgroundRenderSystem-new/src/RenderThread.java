import javax.swing.JPanel;

class RenderThread extends Thread{
	JPanel panel;
	public RenderThread(JPanel panel) {
		this.panel = panel;
	}
	
	public void run() {
		while(true){
			panel.repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}