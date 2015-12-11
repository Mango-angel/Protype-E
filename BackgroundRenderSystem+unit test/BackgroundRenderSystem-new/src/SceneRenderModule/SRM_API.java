package SceneRenderModule;
import javax.swing.JPanel;

public class SRM_API {
	
	//Call by Render Theard
	//Call this function to repain the panel
	public static void RenderScene(JPanel panel){
		panel.repaint();
	}
	
}
