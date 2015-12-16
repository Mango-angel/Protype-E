package SceneDataModule;

import java.io.FileNotFoundException;
import java.util.Vector;

import SceneDataModule.GameInfoSetting.BasicBlock;

interface LoadMapFromFileInterface {
	BasicBlock[][] InitScene(String path) throws FileNotFoundException;
	Vector<Integer> GetMapSize(String path) throws FileNotFoundException;
	BasicBlock[][] GetMapDataFromFile(Vector<Integer> size, BasicBlock [][] Scene) throws FileNotFoundException;
	BasicBlock[][] GetScene();
}
