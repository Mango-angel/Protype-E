package RenderThread;

import SceneRenderModule.PanelDraw;
import SceneRenderModule.SRM_API;

class RenderThread extends Thread{
	PanelDraw panel;
	public RenderThread(PanelDraw panel) {
		
		//Check Panel Received correctly
		assert panel != null : "Panel is null.(RenderThread.java :11)";
		
		this.panel = panel;
	}
	
	public void run() {
		while(true){
			//RenderScene by SRM
			SRM_API.RenderScene(panel);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
