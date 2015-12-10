package SceneRenderModule;
import SceneDataModule.*;

class Start implements GameInfoSetting{
	
	public static void main(String[] args) {
		
		boolean StartGame = false;
		
		
		/* 
		 * Use this sentence to start game
		 * Remove this sentence to enter Map Editor
		 */
		StartGame = true;  
		                      
		
		if(StartGame){
			SDM_API.LoadMap();
			FrameForGame frame = new FrameForGame();
			frame.GameInit();
		}
		else{
			SDM_API.CreatMapEditor();
		}
	}
	
}
