package Test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import mockit.Expectations;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import DynamicObjectModule.DOM_API;
import MainProcess.MainProcess;
import SceneDataModule.GameInfoSetting;
import SceneDataModule.GameInfoSetting.BasicBlock;
import SceneDataModule.LoadMapFromFile;


public class ModuleTestForSDM {
	
	private static MainProcess MP = new MainProcess();

	@Before
	public void setUp() throws Exception {
		Method M = MP.getClass().getDeclaredMethod("Call_SDM_ToLoadMap");
		M.setAccessible(true);
		M.invoke(MP);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPicIsNullAfter_LoadMap_WasCalled() throws Exception {
		
	    assertNotNull(GameInfoSetting.pic1);
	    assertNotNull(GameInfoSetting.pic2);
	    assertNotNull(GameInfoSetting.pic3);
	    assertNotNull(GameInfoSetting.pic4);
	    assertNotNull(GameInfoSetting.pic5);
	    
	}
	
	@Test
	public void testMapDataIsNullAfter_LoadMap_WasCalled() throws Exception {
		LoadMapFromFile LF = new LoadMapFromFile();
		Method M = LF.getClass().getDeclaredMethod("GetScene");
		M.setAccessible(true);
		BasicBlock[][] s = (BasicBlock[][]) M.invoke(LF);
	    assertNotNull(s);
	    for(int i = 0; i < GameInfoSetting.RowNumber; i++){
	    	System.out.println();
	    	for(int j = 0; j < GameInfoSetting.ColNumber; j++)
	    		System.out.print(s[i][j].type+" ");
	    }
	}
	
	@Test
	public void testMapDataFormationAfter_LoadMap_WasCalled() throws Exception {
		LoadMapFromFile LF = new LoadMapFromFile();
		Method M = LF.getClass().getDeclaredMethod("GetScene");
		M.setAccessible(true);
		BasicBlock[][] s = (BasicBlock[][]) M.invoke(LF);
		assertEquals(GameInfoSetting.RowNumber, s.length);
		assertEquals(GameInfoSetting.ColNumber, s[0].length);
	}
	
	

}
