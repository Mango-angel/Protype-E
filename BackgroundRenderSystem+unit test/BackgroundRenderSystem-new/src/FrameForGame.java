import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class FrameForGame extends JFrame implements GameInfoSetting{
	
		public FrameForGame() {}

		public void GameInit(){
			this.setTitle("Background Render System");
			this.setSize(FrameWidth, FrameHeight);
			this.setLayout(new FlowLayout());
			this.setDefaultCloseOperation(3);
			
			JPanel panel = new Panel();
			panel.setPreferredSize(new Dimension(GameAreaWidth, GameAreaHeight));
			panel.setBackground(Color.black);

			this.add(panel);
			this.setVisible(true);
			
			//Setup Keyboard Listenner for the Jpanel
			PanelListenner plisenner = new PanelListenner();
			this.addKeyListener(plisenner);
			
			//start a Character thread
			Character character = new Character();
			character.start();
			
			//start a thread for refreshing
			RenderThread renderthread = new RenderThread(panel);
			renderthread.start();
			
		}
		
		class PanelListenner extends KeyAdapter{
			//When the Key was pressed, set the moving status is true
			public void keyPressed(KeyEvent e){
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					Character.up = true;
					break;
				case KeyEvent.VK_DOWN:
					Character.down = true;
					break;
				case KeyEvent.VK_LEFT:
					Character.left = true;
					break;
				case KeyEvent.VK_RIGHT:
					Character.right = true;
					break;

				default:
					break;
				}
			}
			//When the Key was released, Reset the moving status is false
			public void keyReleased(KeyEvent e){
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					Character.up = false;
					break;
				case KeyEvent.VK_DOWN:
					Character.down = false;
					break;
				case KeyEvent.VK_LEFT:
					Character.left = false;
					break;
				case KeyEvent.VK_RIGHT:
					Character.right = false;
					break;

				default:
					break;
				}
			}
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

		//overWrite the function(run())
		class Panel extends JPanel{

			public void paint(Graphics g) {
				super.paint(g);
				for(int i = Character.getI()-2; i <= Character.getI()+2; i++){
					for(int j = Character.getJ()-3; j <= Character.getJ()+3; j++){
						if(i>=0 && j>=0 && i<LoadMapFromFile.Scene.length && j<LoadMapFromFile.Scene[0].length){
							ImageIcon icon = MatchToImages(LoadMapFromFile.Scene[i][j].type);
							/*
							 * ¡ö ¡ö|¡ö ¡ö ¡ö  
							 * ¡ö ¡ö|¡õ ¡ö ¡ö
							 * ¡ö ¡ö|¡ö ¡ö ¡ö
							 * 
							 * ¡ö ¡ö ¡ö|¡ö ¡ö ¡ö
							 * ¡ö ¡ö ¡ö|¡ö ¡ö ¡ö
							 * ¡ö ¡ö ¡ö|¡ö ¡ö ¡ö
							 * ¡ö ¡ö ¡ö|¡ö ¡ö ¡ö
							 * 
							 */
							g.drawImage(icon.getImage(), 
									   (Character.ScreenX-BasicBlock.BlockSize/2)+((j-Character.getJ())*BasicBlock.BlockSize)-(Character.offsetX % BasicBlock.BlockSize), 
									   (Character.ScreenY-BasicBlock.BlockSize/2)+((i-Character.getI())*BasicBlock.BlockSize)-(Character.offsetY % BasicBlock.BlockSize), 
									   BasicBlock.BlockSize, 
									   BasicBlock.BlockSize, 
									   null);
						}
					}
				}
				g.fillOval(Character.ScreenX-CharacterSize/4, Character.ScreenY-CharacterSize/4, CharacterSize/2, CharacterSize/2);

			} 
		}
		
		public void update(Graphics g){

		     Image DbBuffer=createImage(getWidth(),getHeight());
		     Graphics GraImage=DbBuffer.getGraphics();
		     paint(GraImage);
		     GraImage.dispose();
		     g.drawImage(DbBuffer,0,0,null);
		}
		
		
}
