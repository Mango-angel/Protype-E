package SceneRenderModule;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.util.Vector;
import SceneDataModule.GameInfoSetting;
import SceneDataModule.SDM_API;
import SceneDataModule.GameInfoSetting.BasicBlock;
import DynamicObjectModule.*;

class arround{
	private int x;
	private int y;
	
	public int GetX(){return x;}
	public int GetY(){return y;}
	
	public arround(int _x, int _y){
		x = _x;
		y = _y;
	}
}

public class PanelDraw extends JPanel implements GameInfoSetting, PanelDrawInterface {
	
	private static DOM_API DOM = null;
	
	public PanelDraw(DOM_API DOM){
		this.DOM = DOM;
	}
	
	//Get MapData Form SDM
	private static BasicBlock [][] Scene = SDM_API.GetMapData();
	
	
	//Calculate the blocks' location whitch arrounds the character
	private Vector<arround> GetArrounds(){
		Vector<arround> arrounds = new Vector<arround>();
		arround arr = new arround(0,0);
		for(int i = getI()-2; i <= getI()+2; i++){
			for(int j = getJ()-3; j <= getJ()+3; j++){
				if(i>=0 && j>=0 && i<Scene.length && j<Scene[0].length)
				{
					arrounds.add(new arround(i,j));
					//System.out.println(i);
					//System.out.println(j);
				}
			}
		}
		return arrounds;
	}
	
	//Character's postion in the array of the Map
	@Override
	public int getI(){
		Vector<Integer> pos = DOM.GetVirtualCharacterXY(1);
		if(pos.get(1) < 0)
			return 0;
		if(pos.get(1) > GameInfoSetting.MapHeight)
			return GameInfoSetting.RowNumber;
		return (pos.get(1) - (CharacterSize/2)) / BasicBlock.BlockSize;
	}

	@Override
	public int getJ(){
		Vector<Integer> pos = DOM.GetVirtualCharacterXY(1);
		if(pos.get(0) < 0)
			return 0;
		if(pos.get(0) > GameInfoSetting.MapWidth)
			return GameInfoSetting.ColNumber;
		return (pos.get(0) - (CharacterSize/2)) / BasicBlock.BlockSize;
	}

	public void paint(Graphics g) {
		super.paint(g);
		GetArrounds();
		//检查Scene是否从SDM正确获取到地图数据
		assert Scene!= null;
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
							   ((GameAreaWidth/2)-BasicBlock.BlockSize/2)+((j-getJ())*BasicBlock.BlockSize)-((DOM.GetVirtualCharacterXY(1)).get(2) % BasicBlock.BlockSize), 
							   ((GameAreaHeight/2)-BasicBlock.BlockSize/2)+((i-getI())*BasicBlock.BlockSize)-((DOM.GetVirtualCharacterXY(1)).get(3) % BasicBlock.BlockSize), 
							   BasicBlock.BlockSize, 
							   BasicBlock.BlockSize, 
							   null);
				}
			}
		}
		g.fillOval((GameAreaWidth/2)-CharacterSize/4, (GameAreaHeight/2)-CharacterSize/4, CharacterSize/2, CharacterSize/2);
	}
	
	
	
	//Match the images according the array of Map
	@Override
	public ImageIcon MatchToImages(int num){
		assert num > 0;
		assert num < 6;
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
