package RenderThread;

import SceneRenderModule.PanelDraw;
import SceneRenderModule.SRM_API;

class RenderThread extends Thread{
	public RenderThread() {}
	
	public void run() {
		while(true){
			//RenderScene by SRM
			SRM_API.RenderScene();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
