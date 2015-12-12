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
			//Load map
			SDM_API.LoadMap();
			//Create a Window
			MainWindow window = new MainWindow();
			//Initialize the game
			window.GameInit();
			//Start the Render Thread
			RenderThread_API.StartRenderThread();
		}
		else{
			//Create a MapEditor
			SDM_API.CreatMapEditor();
		}
	}
}
