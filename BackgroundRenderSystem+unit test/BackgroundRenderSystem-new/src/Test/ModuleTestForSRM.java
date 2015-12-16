package Test;

import static org.junit.Assert.*;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import DynamicObjectModule.DOM_API;
import SceneRenderModule.PanelDraw;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import mockit.Verifications;


@RunWith(Parameterized.class)
public class ModuleTestForSRM {
	
	@Mocked
	DOM_API DOM;
	
	//Data Parameters
	private Vector<Integer> pos;
	private int resultX;
	private int resultY;
	
	//Create this function to provide parameter
	@Parameters
	public static Collection Values() {
		//Normal Test Data
		Vector<Integer> p1 = new Vector<Integer>(); p1.add(345);p1.add(245);p1.add(95);p1.add(95);         //Top-Left
		Vector<Integer> p2 = new Vector<Integer>(); p2.add(4750);p2.add(245);p2.add(4500);p2.add(95);      //Top-Right
		Vector<Integer> p3 = new Vector<Integer>(); p3.add(345);p3.add(1850);p3.add(95);p3.add(1700);      //Bottom-Left
		Vector<Integer> p4 = new Vector<Integer>(); p4.add(4750);p4.add(1850);p4.add(4500);p4.add(1700);   //Bottom-Right
		Vector<Integer> p5 = new Vector<Integer>(); p5.add(2500);p5.add(1000);p5.add(2250);p5.add(850);    //Center
		//Illegal Test Data
		Vector<Integer> p6 = new Vector<Integer>(); p6.add(-2500);p6.add(-1000);p6.add(0);p6.add(0);       //posX & posY < 0
		Vector<Integer> p7 = new Vector<Integer>(); p7.add(-2500);p7.add(1000);p7.add(0);p7.add(0);        //posX < 0
		Vector<Integer> p8 = new Vector<Integer>(); p8.add(2500);p8.add(-1000);p8.add(0);p8.add(0);        //posY < 0
		Vector<Integer> p9 = new Vector<Integer>(); p9.add(0);p9.add(0);p9.add(0);p9.add(0);               //posX & posY < 0
		Vector<Integer> p10 = new Vector<Integer>(); p10.add(6000);p10.add(1000);p10.add(0);p10.add(0);    //posX over 
		Vector<Integer> p11 = new Vector<Integer>(); p11.add(2500);p11.add(3000);p11.add(0);p11.add(0);    //posY over
		Vector<Integer> p12 = new Vector<Integer>(); p12.add(6000);p12.add(3000);p12.add(0);p12.add(0);    //posX & posY over
		
		
	 return Arrays.asList(
			 new Object[][]{
				 {2, 1, p1},{47, 1, p2},{2, 18, p3},{47, 18, p4},{24, 9,  p5},
				 {0, 0, p6},{ 0, 9, p7},{24, 0, p8},{ 0,  0, p9},{50, 9, p10},{24, 20, p11},{50, 20, p12} 
			 	}
			 );
	}
	
	//Constructor to match the value and the parameter
	public ModuleTestForSRM(int resultX, int resultY, Vector<Integer> pos) {
		 this.pos = pos;
		 this.resultX = resultX;
		 this.resultY = resultY;
	}
	
	@Before
	public void setUp() throws Exception {
		//Expectations
		new NonStrictExpectations() {
	        {  
	        	DOM.GetVirtualCharacterXY(1);  
	            returns(pos);  
	        }  
	    };  
	}
	
	@After
	public void tearDown() throws Exception {
		//Verifications
		new Verifications() {
	        {  
	            DOM.GetVirtualCharacterXY(1);  
	            times = 1;  
	        }  
	    }; 
	}
	
	@Test
	public void testgetI() throws Exception {
		PanelDraw PD = new PanelDraw(DOM);
	    
	    //Invocation
	    Method M = PD.getClass().getDeclaredMethod("getI"); 
		M.setAccessible(true);	
		
		assertEquals(resultY, M.invoke(PD));
		
	}
	
	@Test
	public void testgetJ() throws Exception {
		PanelDraw PD = new PanelDraw(DOM);
	     
	    //Invocation
	    Method M = PD.getClass().getDeclaredMethod("getJ"); 
		M.setAccessible(true);	
		
		assertEquals(resultX, M.invoke(PD));
	
	}
	

}
