package SceneDataModule;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Vector;

import org.junit.Test;

import SceneDataModule.GameInfoSetting.BasicBlock;

public class LoadMapFromFileTest {
	private LoadMapFromFile loadmapfromfile = new LoadMapFromFile();
	private BasicBlock [][] Scene;
	

	//Test the data load from the file whether match the 'GameInfoSetting' or not
	@Test
	public void MapMatchSetting() {
		Scene = loadmapfromfile.readfile(GameInfoSetting.path);
		assertNotNull(Scene);
		assertEquals(GameInfoSetting.RowNumber, Scene.length);
		assertEquals(GameInfoSetting.ColNumber, Scene[0].length);
	}
	
	//Test for inputing a illegal path for Initialize the Scene
	@Test(expected=FileNotFoundException.class)
	public void IllegalFilePathForInitScene() throws Exception{
		loadmapfromfile.InitScene("123");
	}
	
	//Test for inputing a illegal path for GetMapSize()
	@Test(expected=FileNotFoundException.class)
	public void IllegalFilePathForGetMapSize() throws Exception{
		loadmapfromfile.GetMapSize("123");
	}
	
	//Test for GetMapDataFromFile(), check data formation
	@Test(expected=FileNotFoundException.class)
	public void IllegalFilePathForGetMapDataFromFile() throws Exception{
		Vector<Integer> size = new Vector<Integer>();
		size.add(GameInfoSetting.RowNumber);
		size.add(GameInfoSetting.ColNumber);
		Scene = new BasicBlock[size.get(0)][size.get(1)];
		
		for(int i=0; i<size.get(0); i++)
			for(int j=0; j<size.get(1); j++)
				Scene[i][j] = new BasicBlock();
		BasicBlock[][] s = loadmapfromfile.GetMapDataFromFile(size, Scene);
		assertNotNull(s);
		assertEquals((int)size.get(0), s.length);
		assertEquals((int)size.get(1), s[0].length);
	}
	
	//Test for checking the format of the size witch loading from the file 
	//Format shoule be the same to GameInfoSetting
	@Test
	public void FormatGetMapSize() throws Exception {
		LoadMapFromFile LF = new LoadMapFromFile();
		Method M = LF.getClass().getDeclaredMethod("GetMapSize", String.class); 
		M.setAccessible(true);
		Vector<Integer> size = (Vector<Integer>) M.invoke(LF, GameInfoSetting.path);
		
		assertEquals(GameInfoSetting.RowNumber, (int)size.get(0));
		assertEquals(GameInfoSetting.ColNumber, (int)size.get(1));
	}


}
