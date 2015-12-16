package SceneRenderModule;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Vector;

import javax.swing.ImageIcon;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import DynamicObjectModule.Character;
import DynamicObjectModule.DOM_API;
import SceneDataModule.GameInfoSetting;

@RunWith(Parameterized.class)
public class MatchToImagesTest {
	
	private PanelDraw pd = new PanelDraw(new DOM_API());
	private int type;
	
	//Create this function to provide parameter
	@Parameters
	public static Collection Values() {
	 return Arrays.asList(new Object[] {0, 1, 2, 3, 4, 5, 6});
	}
	
	//Constructor to match the value and the parameter
	public MatchToImagesTest(int type) {
		 this.type = type;
	}

	@Test
	public void TestMatchToImages() throws Exception{
		PanelDraw PD = new PanelDraw(new DOM_API());
		Method M = PD.getClass().getDeclaredMethod("MatchToImages", int.class);
		M.setAccessible(true);
		
		ImageIcon icon = (ImageIcon) M.invoke(PD,type);
		
		switch(type){
		case 1:
			assertEquals(GameInfoSetting.pic1, icon);
			break;
		case 2:
			assertEquals(GameInfoSetting.pic2, icon);
			break;
		case 3:
			assertEquals(GameInfoSetting.pic3, icon);
			break;
		case 4:
			assertEquals(GameInfoSetting.pic4, icon);
			break;
		case 5:
			assertEquals(GameInfoSetting.pic5, icon);
			break;
		}
	}
	
}
