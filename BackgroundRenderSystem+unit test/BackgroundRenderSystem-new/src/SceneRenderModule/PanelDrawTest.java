package SceneRenderModule;

import static org.junit.Assert.*;

import java.awt.Graphics;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Vector;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import DynamicObjectModule.DOM_API;

public class PanelDrawTest {

	//Test the Return value from getI()
	@Test
	public void TestGetIValue() throws Exception{
		PanelDraw PD = new PanelDraw(new DOM_API());
		Method M = PD.getClass().getDeclaredMethod("getI");
		M.setAccessible(true);
		assertEquals(9, M.invoke(PD));
	}
	
	//Test the Return value from getJ()
	@Test
	public void TestGetJValue() throws Exception{
		PanelDraw PD = new PanelDraw(new DOM_API());
		Method M = PD.getClass().getDeclaredMethod("getJ");
		M.setAccessible(true);
		assertEquals(24, M.invoke(PD));
	}
	
	//Test whitch blocks will be painted by Paint()
	@Test
	public void TestGetArrounds() throws Exception{
		Vector<arround> compare = new Vector<arround>();
		for(int i = 7; i <= 11; i++)
			for(int j = 21; j <= 27; j++){
				compare.add(new arround(i,j));
				
				}
	
		PanelDraw PD = new PanelDraw(new DOM_API());
		Method M = PD.getClass().getDeclaredMethod("GetArrounds");
		M.setAccessible(true);
		Vector<arround> arrounds =  (Vector<arround>) M.invoke(PD);
		
		for(int i = 0; i < 35; i++){
			assertEquals(compare.get(i).GetX(), arrounds.get(i).GetX());
			assertEquals(compare.get(i).GetY(), arrounds.get(i).GetY());
		}
			
	}
}
