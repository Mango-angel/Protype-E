public class Character extends Thread implements GameInfoSetting{
	
		//Keep the character stay in the center of the screen
		static int ScreenX = GameAreaWidth/2;
		static int ScreenY = GameAreaHeight/2;
		
		//Initialize fist postion of the character in the map
		static int posX = 2500;
		static int posY = 1000;
		
		//Character Offset
		static int offsetX = 2250;
		static int offsetY = 850;

		static int step = 5;
		
		//Moving status Flag
		static boolean up = false;
		static boolean down = false;
		static boolean left = false;
		static boolean right = false;
		
		//Character's postion in the array of the Map
		public static int getI(){
			return (posY - (CharacterSize/2)) / BasicBlock.BlockSize;
		}

		public static int getJ(){
			return (posX - (CharacterSize/2)) / BasicBlock.BlockSize;
		}

		//Character Move
		public void move(){
			if(up){
				if(getI() ==  1)
				{
					if(left){
						if(getJ() ==  2)
							return;
						posX = posX - step;
						offsetX = offsetX - step;
						/*
						if(posX == 2500)
							System.out.println("offsetX = " + offsetX);
						else
							System.out.println("posX = " + posX + " offsetY = " + offsetY);
							*/
					}
					if(right){
						if(getJ() ==  47)
							return;
						posX = posX + step;
						offsetX = offsetX + step;
						/*
						if(posX == 2500)
							System.out.println("offsetX = " + offsetX);
						else
							System.out.println("posX = " + posX + " offsetY = " + offsetY);
							*/
					}
					return;
				}
				posY = posY - step;            //Change character'postion in the map
				offsetY = offsetY - step;      //Updata the offset 
				/*
				if(posY == 1000)
					System.out.println("-->offsetY = " + offsetY);
				else
					System.out.println("posY = " + posY + " offsetY = " + offsetY);
					*/
			}
			if(down){
				if(getI() ==  18)
				{
					if(left){
						if(getJ() ==  2)
							return;
						posX = posX - step;
						offsetX = offsetX - step;
						/*
						if(posX == 2500)
							System.out.println("offsetX = " + offsetX);
						else
							System.out.println("posX = " + posX + " offsetY = " + offsetY);
							*/
					}
					if(right){
						if(getJ() ==  47)
							return;
						posX = posX + step;
						offsetX = offsetX + step;
						/*
						if(posX == 2500)
							System.out.println("offsetX = " + offsetX);
						else
							System.out.println("posX = " + posX + " offsetY = " + offsetY);
							*/
					}
					return;
				}
				posY = posY + step;
				offsetY = offsetY + step;
				/*
				if(posY == 1000)
					System.out.println("offsetY = " + offsetY);
				else
					System.out.println("posY = " + posY + " offsetY = " + offsetY);
					*/
			}
			if(left){
				if(getJ() ==  2)
					return;
				posX = posX - step;
				offsetX = offsetX - step;
				/*
				if(posX == 2500)
					System.out.println("offsetX = " + offsetX);
				else
					System.out.println("posX = " + posX + " offsetY = " + offsetY);
					*/
			}
			if(right){
				if(getJ() ==  47)
					return;
				posX = posX + step;
				offsetX = offsetX + step;
				/*
				if(posX == 2500)
					System.out.println("offsetX = " + offsetX);
				else
					System.out.println("posX = " + posX + " offsetY = " + offsetY);
					*/
			}
		}
		
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
