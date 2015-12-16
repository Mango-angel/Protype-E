package DynamicObjectModule;

import SceneDataModule.*;

public class Character extends Thread implements GameInfoSetting, CharacterInterface{
	
		//Keep the character stay in the center of the screen
		private int ScreenX = GameAreaWidth/2;
		private int ScreenY = GameAreaHeight/2;
		private int step = 5;
		
		//Initialize fist postion of the character in the map
		protected static int posX = 2500;
		protected static int posY = 1000;
		
		//Character Offset
		protected static int offsetX = 2250;
		protected static int offsetY = 850;
		
		//Moving status Flag
		protected static boolean up = false;
		protected static boolean down = false;
		protected static boolean left = false;
		protected static boolean right = false;
		
		@Override
		public int getPosX(){
			return posX;
		}
		
		@Override
		public int getPosY(){
			return posY;
		}
		
		@Override
		public int getOffsetX(){
			return offsetX;
		}
		
		@Override
		public int getOffsetY(){
			return offsetY;
		}

		//Character's postion in the array of the Map
		@Override
		public int getI(){
			//PositionY < 0 ,assert
			assert posY - (CharacterSize/2) >= 0 : "Chacracter's postionY < 0.(LoadMapFromFile.java :32)"; 
			return (posY - (CharacterSize/2)) / BasicBlock.BlockSize;
		}

		@Override
		public int getJ(){
			//PositionX < 0 ,assert
			assert posX - (CharacterSize/2) >= 0 : "Chacracter's postionX < 0.(LoadMapFromFile.java :37)"; 
			return (posX - (CharacterSize/2)) / BasicBlock.BlockSize;
		}

		@Override
		//Character Move
		public String move(){
			if(up){
				if(getI() ==  1)
				{
					if(left){
						if(getJ() ==  2)
							return "Can't move to left, but up";
						
						posX = posX - step;
						assert posX >= 0 : "PosX < 0.(LoadMapFromFile.java :52)";
						
						offsetX = offsetX - step;
						assert offsetX >= 0 : "offsetX < 0.(LoadMapFromFile.java :53)";
						/*
						if(posX == 2500)
							System.out.println("offsetX = " + offsetX);
						else
							System.out.println("posX = " + posX + " offsetY = " + offsetY);
							*/
						return "up+left: "+step;
					}
					if(right){
						if(getJ() ==  47)
							return "Can't move to right, but right";
						posX = posX + step;
						offsetX = offsetX + step;
						/*
						if(posX == 2500)
							System.out.println("offsetX = " + offsetX);
						else
							System.out.println("posX = " + posX + " offsetY = " + offsetY);
							*/
						return "up+right: "+step;
					}
					return "Can't move to up";
				}
				posY = posY - step;            //Change character'postion in the map
				assert posY >= 0 : "posY < 0.(LoadMapFromFile.java :78)";
				
				offsetY = offsetY - step;      //Updata the offset 
				assert offsetY >= 0 : "offsetY < 0.(LoadMapFromFile.java :81)";
				/*
				if(posY == 1000)
					System.out.println("-->offsetY = " + offsetY);
				else
					System.out.println("posY = " + posY + " offsetY = " + offsetY);
					*/
				return "up: "+step;
			}
			if(down){
				if(getI() ==  18)
				{
					if(left){
						if(getJ() ==  2)
							return "Can't move to left, but down";
						posX = posX - step;
						assert posX >= 0 : "PosX < 0.(LoadMapFromFile.java :52)";
						
						offsetX = offsetX - step;
						assert offsetX >= 0 : "offsetX < 0.(LoadMapFromFile.java :53)";
						/*
						if(posX == 2500)
							System.out.println("offsetX = " + offsetX);
						else
							System.out.println("posX = " + posX + " offsetY = " + offsetY);
							*/
						return "down+left: "+step;
					}
					if(right){
						if(getJ() ==  47)
							return "Can't move to right, but down";
						posX = posX + step;
						offsetX = offsetX + step;
						/*
						if(posX == 2500)
							System.out.println("offsetX = " + offsetX);
						else
							System.out.println("posX = " + posX + " offsetY = " + offsetY);
							*/
					}
					return "down+right: "+step;
				}
				posY = posY + step;
				offsetY = offsetY + step;
				/*
				if(posY == 1000)
					System.out.println("offsetY = " + offsetY);
				else
					System.out.println("posY = " + posY + " offsetY = " + offsetY);
					*/
				return "down: "+step;
			}
			if(left){
				if(getJ() ==  2)
					return "Can't move to left";
				posX = posX - step;
				assert posX >= 0 : "PosX < 0.(LoadMapFromFile.java :52)";
				
				offsetX = offsetX - step;
				assert offsetX >= 0 : "offsetX < 0.(LoadMapFromFile.java :53)";
				/*
				if(posX == 2500)
					System.out.println("offsetX = " + offsetX);
				else
					System.out.println("posX = " + posX + " offsetY = " + offsetY);
					*/
				return "left: "+step;
			}
			if(right){
				if(getJ() ==  47)
					return "Can't move to right";
				posX = posX + step;
				offsetX = offsetX + step;
				/*
				if(posX == 2500)
					System.out.println("offsetX = " + offsetX);
				else
					System.out.println("posX = " + posX + " offsetY = " + offsetY);
					*/
				return "right: "+step;
			}
			//if(up||down||right||left)
			//	System.out.println("posX = " + posX + " posY = " + posY + " offsetX = " + offsetX + " offsetY = " + offsetY);	
			return "Error";
		}
		
		@Override
		public void run() {
			while(true){
				move();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
}
