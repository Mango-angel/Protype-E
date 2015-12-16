package SceneRenderModule;
import javax.swing.JPanel;

import UserInterfaceModule.MainWindow;

public class SRM_API {
	
	//Call by Render Theard
	//Call this function to repain the panel
	public static void RenderScene(){
		MainWindow.GetPanel().repaint();
	}
	
}
