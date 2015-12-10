package SceneDataModule;

import SceneDataModule.GameInfoSetting.*;

public class SDM_API {
	
	public static void LoadMap(){
		LoadMapFromFile.readfile(GameInfoSetting.path);
	}
	
	public static MapEditor CreatMapEditor()
	{
		MapEditor Editor = new MapEditor();
		Editor.MapEditorInit();
		return Editor;
	}
	
	
	public static BasicBlock [][] GetMapData(){
		if(LoadMapFromFile.Scene != null)
			return LoadMapFromFile.Scene;
		return null;
	}
	
	
}

