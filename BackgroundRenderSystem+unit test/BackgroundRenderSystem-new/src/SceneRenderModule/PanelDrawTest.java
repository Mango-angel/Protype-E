package SceneRenderModule;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Vector;

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

/*
class Stub_DOM extends DOM_API{
	public static Vector<Integer> GetVirtualCharacterXY(int ClintID){
		Vector pos = new Vector<Integer>();
		pos.add(Character.posX);
		pos.add(Character.posY);
		pos.add(Character.offsetX);
		pos.add(Character.offsetY); 
		return pos;
	}
}
*/
//@RunWith(Parameterized.class)
class Stub_PanelDraw extends PanelDraw{
	private static int x;
	private static int y;
	
	/*
	@Parameters  
    public static Collection data() {
        return Arrays.asList(new Object[][]{{5, 9},{8, 7},{3, 6}});
    }
 	*/
	
	private static int getI(){
		return 10;
	}
	
	private static int getJ(){
		return 10;
	}
}

//@RunWith(Parameterized.class)
public class PanelDrawTest {
	
	PanelDraw pd = new PanelDraw();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals(5, pd.FindBlocksToDraw().length);
	}

}
