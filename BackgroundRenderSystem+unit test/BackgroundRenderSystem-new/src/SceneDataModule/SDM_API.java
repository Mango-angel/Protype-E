package SceneDataModule;

import java.io.FileNotFoundException;

import SceneDataModule.GameInfoSetting.*;

public class SDM_API {
	
	//load map
	public static void LoadMap(){
		LoadMapFromFile.readfile(GameInfoSetting.path);
	}
	
	//create a map editor
	public static MapEditor CreatMapEditor()
	{
		MapEditor Editor = new MapEditor();
		Editor.MapEditorInit();
		return Editor;
	}
	
	//call by SRM
	//provide map data
	public static BasicBlock [][] GetMapData(){
		return LoadMapFromFile.readfile(GameInfoSetting.path);
	}
	
	
}

