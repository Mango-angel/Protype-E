package MainProcess;

import java.lang.reflect.Method;

import javax.swing.JPanel;

import RenderThread.RenderThread_API;
import SceneDataModule.GameInfoSetting;
import SceneDataModule.SDM_API;
import SceneRenderModule.*;
import UserInterfaceModule.MainWindow;
import UserInterfaceModule.UIM_API;

public class MainProcess implements GameInfoSetting, MainProcessInterface{
	
	@Override
	public void Call_SDM_ToLoadMap(){
		SDM_API.LoadMap();
	}
	
	@Override
	public void Call_RenderThread_ToStartRender(){
		RenderThread_API.StartRenderThread();
	}
	
	public static void main(String[] args) throws Exception {
		
		boolean StartGame = false;
		/* 
		 * Use this sentence to start game
		 * Remove this sentence to enter Map Editor
		 */
		StartGame = true;  
		                      
		MainProcess MP = new MainProcess();
		
		if(StartGame){
			//Load map
			Method M = MP.getClass().getDeclaredMethod("Call_SDM_ToLoadMap");
			M.setAccessible(true);
			//Call_SDM_ToLoadMap();
			M.invoke(MP);
			
			//Create a Window
			MainWindow window = new MainWindow();
			//Initialize the game
			window.GameInit();
			
			//Start the Render Thread
			M = MP.getClass().getDeclaredMethod("Call_RenderThread_ToStartRender");
			M.setAccessible(true);
			M.invoke(MP);
		}
		else{
			//Create a MapEditor
			SDM_API.CreatMapEditor();
		}
	}
}
