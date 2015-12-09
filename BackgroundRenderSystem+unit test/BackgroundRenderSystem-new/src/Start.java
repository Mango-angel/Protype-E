public class Start implements GameInfoSetting{
	
	public static void main(String[] args) {
		
		boolean StartGame = false;
		
		
		/* 
		 * Use this sentence to start game
		 * Remove this sentence to enter Map Editor
		 */
		StartGame = true;  
		                      
		
		if(StartGame){
			LoadMapFromFile.readfile(path);
			FrameForGame frame = new FrameForGame();
			frame.GameInit();
		}
		else{
			MapEditor mapEdit = new MapEditor();
			mapEdit.MapEditorInit();
		}
	}
	
}
