package DynamicObjectModule;

import java.awt.event.KeyEvent;
import java.util.Vector;

public class DOM_API {
	public static void KeyGetPressed(KeyEvent e, boolean IsPressed){
		if(IsPressed){
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
		else
		{
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
	
	public static Vector<Integer> GetVirtualCharacterXY(int ClintID){
		Vector pos = new Vector<Integer>();
		pos.add(Character.posX);
		pos.add(Character.posY);
		pos.add(Character.offsetX);
		pos.add(Character.offsetY);
		return pos;
	}
	
	public static Character CreateCharacterForThisClient(){
		Character character = new Character();
		return character;
	}

}
