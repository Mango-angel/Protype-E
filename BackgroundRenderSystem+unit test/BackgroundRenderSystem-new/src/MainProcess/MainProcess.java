package MainProcess;

import javax.swing.JPanel;

import RenderThread.RenderThread_API;
import SceneDataModule.GameInfoSetting;
import SceneDataModule.SDM_API;
import SceneRenderModule.*;
import UserInterfaceModule.MainWindow;
import UserInterfaceModule.UIM_API;

public class MainProcess implements GameInfoSetting{
public static void main(String[] args) {
		
		boolean StartGame = false;
		
		
		/* 
		 * Use this sentence to start game
		 * Remove this sentence to enter Map Editor
		 */
		StartGame = true;  
		                      
		
		if(StartGame){
			SDM_API.LoadMap();
			
			MainWindow window = new MainWindow();
			window.GameInit();
			RenderThread_API.StartRenderThread();
		}
		else{
			SDM_API.CreatMapEditor();
		}
	}
}
