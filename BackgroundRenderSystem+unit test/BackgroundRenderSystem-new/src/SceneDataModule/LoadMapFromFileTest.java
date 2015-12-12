package SceneDataModule;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import SceneDataModule.GameInfoSetting.BasicBlock;

public class LoadMapFromFileTest {
	LoadMapFromFile loadmapfromfile = new LoadMapFromFile();
	BasicBlock [][] Scene;

	//Test the data load from the file whether match the 'GameInfoSetting' or not
	@Test
	public void MapMatchSetting() {
		try {
			Scene = loadmapfromfile.readfile(GameInfoSetting.path);
		} catch (FileNotFoundException  e) {
			System.out.println(e);
			fail();
			e.printStackTrace();
		}
		assertEquals(GameInfoSetting.RowNumber, Scene.length);
		assertEquals(GameInfoSetting.ColNumber, Scene[0].length);
	}
	
	//Test for inputing a illegal path of map and whether assertion or not
	@Test(expected=AssertionError.class)
	public void IllegalFilePathAsssertion(){
		try {
			loadmapfromfile.readfile("123");
		} catch (FileNotFoundException  e) {
			e.printStackTrace();
		}
	}
	
	

}
