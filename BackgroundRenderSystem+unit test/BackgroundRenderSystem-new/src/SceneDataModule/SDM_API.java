package SceneDataModule;

import java.io.FileNotFoundException;

import SceneDataModule.GameInfoSetting.*;

public class SDM_API {
	
	//load map
	public static void LoadMap(){
		try {
			LoadMapFromFile.readfile(GameInfoSetting.path);
		} catch (FileNotFoundException  e) {
			System.out.println(e);
			e.printStackTrace();
		}
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
		if(LoadMapFromFile.Scene != null)
			return LoadMapFromFile.Scene;
		return null;
	}
	
	
}

