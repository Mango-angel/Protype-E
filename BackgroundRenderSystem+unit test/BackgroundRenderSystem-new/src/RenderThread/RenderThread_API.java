package RenderThread;

import DynamicObjectModule.*;
import SceneRenderModule.PanelDraw;
import UserInterfaceModule.MainWindow;

public class RenderThread_API {
	public static void StartRenderThread(){
		
		//start a Character thread
		DOM_API.CreateCharacterForThisClient().start();

		//start the Render thread
		RenderThread renderthread = new RenderThread();
		renderthread.start();
	}
}
