import javax.swing.ImageIcon;

public interface GameInfoSetting {
	
	/*Define of the Bolcks:
	 *
	 * type 1: �ݵ�
	 * type 2���ذ�
	 * type 3: ����
	 * type 4���߽���
	 * type 5������
	 * 
	 */
	class BasicBlock{
		int type;
		static int BlockSize = 100;
	}
	
	String path = "./maps/map-1.txt";
	
	//Define the Size of Windows
	int FrameWidth = 550;
	int FrameHeight = 350;
	
	//Define the Size of gameArea
	int GameAreaWidth = 500;
	int GameAreaHeight = 300;
	
	//Define the Size of Picture 
	int BlockSize = 100;
	int CharacterSize = 100;
	
	//Size of map
	int MapWidth = 5000;
	int MapHeight= 2000;
	
	//Number of Row/Col
	int RowNumber = MapHeight/BlockSize;
	int ColNumber = MapWidth/BlockSize;
	
	//Load pictures
	ImageIcon pic1 = new ImageIcon("images/1.png");
	ImageIcon pic2 = new ImageIcon("images/2.png");
	ImageIcon pic3 = new ImageIcon("images/3.png");
	ImageIcon pic4 = new ImageIcon("images/4.png");
	ImageIcon pic5 = new ImageIcon("images/5.png");
	
	ImageIcon[] images = {pic1, pic2, pic3, pic4 ,pic5}; 

}
