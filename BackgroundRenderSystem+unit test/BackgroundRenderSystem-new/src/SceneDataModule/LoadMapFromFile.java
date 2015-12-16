package SceneDataModule;

import java.io.*;
import java.lang.reflect.Method;
import java.util.Vector;

import SceneDataModule.GameInfoSetting.BasicBlock;

public class LoadMapFromFile implements GameInfoSetting, LoadMapFromFileInterface{
		private static BufferedReader in;
		private static String str;
		private static BasicBlock[][] Scene;
		
		@Override
		public BasicBlock[][] GetScene(){
			return Scene;
		}
		
		//Initialized the Scene(stored the data of map)
		@Override
		public BasicBlock[][] InitScene(String path) throws FileNotFoundException{
			//BasicBlock [][] Scene;
			int Row = GetMapSize(path).get(0);
			int Col = GetMapSize(path).get(1);
			Scene = new BasicBlock[RowNumber][ColNumber];
			for(int i=0; i<Row; i++)
				for(int j=0; j<Col; j++)
					Scene[i][j] = new BasicBlock();
			return Scene;
		}
		
		//Get the size of the map from the file
		@Override
		public Vector<Integer> GetMapSize(String path) throws FileNotFoundException{
			Vector<Integer> size= new Vector<Integer>();
			int Row;
			int Col;
			try{
				in = new BufferedReader(new FileReader(path));
				str = in.readLine();
				assert str.length() != 0 : "Read Row from the file of map failed.(LoadMapFromFile.java :16)";
				Row = Integer.parseInt(str);
				assert Row == RowNumber : "Map data(Row) from file does not match the info of 'GameInfoSeting.java'.(LoadMapFromFile.java :17)";
				
				str = in.readLine();
				assert str != null : "Read Col from the file of map failed.(LoadMapFromFile.java :19)";
				Col = Integer.parseInt(str);
				assert Row == RowNumber : "Map data(Col) from file does not match the info of 'GameInfoSeting.java'.(LoadMapFromFile.java :22)";
			}catch(Exception e){
				throw new FileNotFoundException("Failed to load map from the path: '" + path + "'");
			}
			size.add(Row);
			size.add(Col);
			return size;
		}
		
		//Get data of the Map From file
		@Override
		public BasicBlock[][] GetMapDataFromFile(Vector<Integer> size, BasicBlock [][] Scene) throws FileNotFoundException{
			
			//Check Size
			assert size != null;
			assert size.get(0) == GameInfoSetting.RowNumber;
			assert size.get(1) == GameInfoSetting.ColNumber;
					
			int Row = size.get(0);
			int Col = size.get(1);
			int count = 0;
			
			//load data of map to the Initialized Scene
			assert Scene != null;
			assert Scene.length == GameInfoSetting.RowNumber;
			assert Scene[0].length == GameInfoSetting.ColNumber;
			try{
				while(Row-- > 0)
				{
					str=in.readLine();
					String [] data=str.split(" ");
					for(int j=0;j<Col;j++){
						Scene[count][j].type = Integer.parseInt(data[j]);
					}
					count++;
					
				}
			}catch(Exception e){
				throw new FileNotFoundException("Failed to load map from the path: '" + path + "'");
			}
			return Scene;
		}
		
		//Load map from file according to the path 
		public static BasicBlock[][] readfile(String path) {
			assert path.length() != 0 : "Path of the map is not found.(LoadMapFromFile.java :11)";
			//BasicBlock [][] Scene = null;
			Vector<Integer> size = null;
			//Test for file exit or not
			//File file = new File(path);
			//assert file.exists() : "File not found from the path: \""+ path + "\"";
			
			LoadMapFromFile LF = new LoadMapFromFile();

			try {
				//Initialize the Scene
				Method M = LF.getClass().getDeclaredMethod("InitScene", String.class);
				M.setAccessible(true);
				Scene = (BasicBlock[][]) M.invoke(LF, path);
				
				//Get Size of the map
				M = LF.getClass().getDeclaredMethod("GetMapSize", String.class);
				M.setAccessible(true);
				size = (Vector<Integer>) M.invoke(LF, path);
				
				//Load the data of the map according the size of the map
				M = LF.getClass().getDeclaredMethod("GetMapDataFromFile", Vector.class, BasicBlock[][].class);
				M.setAccessible(true);
				M.invoke(LF, size, Scene);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Scene;
		}
}
