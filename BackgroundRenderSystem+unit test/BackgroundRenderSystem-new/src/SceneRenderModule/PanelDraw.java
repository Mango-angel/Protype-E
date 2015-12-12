package SceneRenderModule;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.util.Vector;
import SceneDataModule.GameInfoSetting;
import SceneDataModule.SDM_API;
import SceneDataModule.GameInfoSetting.BasicBlock;
import DynamicObjectModule.*;

public class PanelDraw extends JPanel implements GameInfoSetting{
	
	//Get MapData Form SDM
	BasicBlock [][] Scene = SDM_API.GetMapData();
	
	//Test
	int[][] FindBlocksToDraw(){
		int blocks[][] = new int[5][3];
		for(int i = getI()-2; i <= getI()+2; i++){
			for(int j = getJ()-3; j <= getJ()+3; j++){
				if(i>=0 && j>=0 && i<Scene.length && j<Scene[0].length)
					blocks[i][j] = Scene[i][j].type;
			}
		}
		return blocks;
	}

	public void paint(Graphics g) {
		super.paint(g);
		
		//检查Scene是否从SDM正确获取到地图数据
		assert Scene.length == GameInfoSetting.RowNumber : "Get data of map from SDM is failed.(PanelDraw.java :32)";
		assert Scene[0].length == GameInfoSetting.ColNumber : "Get data of map from SDM is failed.(PanelDraw.java :32)";
		
		for(int i = getI()-2; i <= getI()+2; i++){
			for(int j = getJ()-3; j <= getJ()+3; j++){
				if(i>=0 && j>=0 && i<Scene.length && j<Scene[0].length){
					ImageIcon icon = MatchToImages(Scene[i][j].type);
					
					//When Images failed to match, assert
					assert icon != null : "Match the data of map to the Image is failed.(PanelDraw.java :41)";
					/*
					 * ■ ■|■ ■ ■  
					 * ■ ■|□ ■ ■
					 * ■ ■|■ ■ ■
					 * 
					 * ■ ■ ■|■ ■ ■
					 * ■ ■ ■|■ ■ ■
					 * ■ ■ ■|■ ■ ■
					 * ■ ■ ■|■ ■ ■
					 * 
					 */
					
					//When Offset < 0, assert
					assert DOM_API.GetVirtualCharacterXY(1).get(2) >= 0 : "OffsetX < 0.(PanelDraw.java :53)";
					assert DOM_API.GetVirtualCharacterXY(1).get(3) >= 0 : "OffsetY < 0.(PanelDraw.java :53)";
					g.drawImage(icon.getImage(), 
							   ((GameAreaWidth/2)-BasicBlock.BlockSize/2)+((j-getJ())*BasicBlock.BlockSize)-((DOM_API.GetVirtualCharacterXY(1)).get(2) % BasicBlock.BlockSize), 
							   ((GameAreaHeight/2)-BasicBlock.BlockSize/2)+((i-getI())*BasicBlock.BlockSize)-((DOM_API.GetVirtualCharacterXY(1)).get(3) % BasicBlock.BlockSize), 
							   BasicBlock.BlockSize, 
							   BasicBlock.BlockSize, 
							   null);
				}
			}
		}
		g.fillOval((GameAreaWidth/2)-CharacterSize/4, (GameAreaHeight/2)-CharacterSize/4, CharacterSize/2, CharacterSize/2);
	}
	
	//Character's postion in the array of the Map
	private static int getI(){
		return ((DOM_API.GetVirtualCharacterXY(1)).get(1) - (CharacterSize/2)) / BasicBlock.BlockSize;
	}

	private static int getJ(){
		return ((DOM_API.GetVirtualCharacterXY(1)).get(0) - (CharacterSize/2)) / BasicBlock.BlockSize;
	}
	
	//Match the images according the array of Map
		static ImageIcon MatchToImages(int num){
			if(num == 1){
				return pic1;
			}else if(num == 2){
				return pic2;
			}else if(num == 3){
				return pic3;
			}else if(num == 4){
				return pic4;
			}else if(num == 5){
				return pic5;
			}
			return null;
		}
	
}
