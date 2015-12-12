package SceneDataModule;

import java.io.*;

class LoadMapFromFile implements GameInfoSetting{
		static int Row, Col, count = 0;
		static BasicBlock [][] Scene;
		static BufferedReader in;
		static String str;
		
		//Load map from file according to the path 
		public static BasicBlock[][] readfile(String path) throws FileNotFoundException {
			assert path.length() != 0 : "Path of the map is not found.(LoadMapFromFile.java :11)";
			
			//Test for file exit or not
			File file = new File(path);
			assert file.exists() : "File not found from the path: \""+ path + "\"";
			 

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
				
				//Initialized the Scene(stored the data of map)
				Scene = new BasicBlock[RowNumber][ColNumber];
				for(int i=0; i<Row; i++)
					for(int j=0; j<Col; j++)
						Scene[i][j] = new BasicBlock();
				
				//load data of map to the Initialized Scene
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
				//e.printStackTrace();
			}
			return Scene;
		}
}
