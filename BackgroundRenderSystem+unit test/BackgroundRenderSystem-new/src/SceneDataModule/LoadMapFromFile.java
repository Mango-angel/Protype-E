package SceneDataModule;

import java.io.*;

class LoadMapFromFile implements GameInfoSetting{
		static int Row, Col, count = 0;
		public static BasicBlock [][] Scene;
		
		//Load map from file according to the path 
		public static void readfile(String path){
			try{
				BufferedReader in = new BufferedReader(new FileReader(path));
				String str;
				
				str = in.readLine();
				Row = Integer.parseInt(str);
				str = in.readLine();
				Col = Integer.parseInt(str);
				
				//Initialized the Scene(stored the data of map)
				Scene = new BasicBlock[20][50];
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
				e.printStackTrace();
			}
		}
}
