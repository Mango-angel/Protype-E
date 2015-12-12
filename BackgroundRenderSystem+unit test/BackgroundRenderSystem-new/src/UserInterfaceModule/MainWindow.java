package UserInterfaceModule;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import SceneDataModule.*;
import DynamicObjectModule.*;
import SceneRenderModule.*;

public class MainWindow extends JFrame implements GameInfoSetting {
	public MainWindow() {}
	
	static PanelDraw panel;
	
	public static PanelDraw GetPanel(){
		return panel;
	}

	public void GameInit(){
		this.setTitle("Background Render System");
		this.setSize(FrameWidth, FrameHeight);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(3);
		
		//Create Panel for Drawing
		panel = new PanelDraw();

		panel.setPreferredSize(new Dimension(GameAreaWidth, GameAreaHeight));
		panel.setBackground(Color.black);

		this.add(panel);
		this.setVisible(true);
		
		//Setup Keyboard Listenner for the Jpanel
		PanelListenner plisenner = new PanelListenner();
		this.addKeyListener(plisenner);
		
		

	}
	
	
	
	class PanelListenner extends KeyAdapter{
		//When the Key was pressed, set the moving status is true
		public void keyPressed(KeyEvent e){
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				DOM_API.KeyGetPressed(e, true);
				break;
			case KeyEvent.VK_DOWN:
				DOM_API.KeyGetPressed(e, true);
				break;
			case KeyEvent.VK_LEFT:
				DOM_API.KeyGetPressed(e, true);
				break;
			case KeyEvent.VK_RIGHT:
				DOM_API.KeyGetPressed(e, true);
				break;

			default:
				break;
			}
		}
		//When the Key was released, Reset the moving status is false
		public void keyReleased(KeyEvent e){
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				DOM_API.KeyGetPressed(e, false);
				break;
			case KeyEvent.VK_DOWN:
				DOM_API.KeyGetPressed(e, false);
				break;
			case KeyEvent.VK_LEFT:
				DOM_API.KeyGetPressed(e, false);
				break;
			case KeyEvent.VK_RIGHT:
				DOM_API.KeyGetPressed(e, false);
				break;

			default:
				break;
			}
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
