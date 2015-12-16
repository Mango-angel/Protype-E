package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import SceneDataModule.LoadMapFromFileTest;
import SceneRenderModule.MatchToImagesTest;
import SceneRenderModule.PanelDrawTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({LoadMapFromFileTest.class, MatchToImagesTest.class, PanelDrawTest.class, 
					 ModuleTestForSDM.class,    ModuleTestForSRM.class})
public class SuiteTestCases {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
