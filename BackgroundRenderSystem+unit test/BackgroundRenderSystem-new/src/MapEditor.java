import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class MapEditor extends JFrame implements GameInfoSetting{

		JComboBox<ImageIcon> box;                                        //"Save" button
		static int Row, Col, count = 0;
		static BasicBlock [][] Scene;                                    //use to stored the map from file
		static ImageIcon[][] pics = new ImageIcon[RowNumber][ColNumber]; //save "pics" to a array
		static JPanel panel;

		public void MapEditorInit(){
			this.setTitle("Map Editor");
			this.setSize(2000, 1000);
			this.setDefaultCloseOperation(3);
			this.setLayout(new FlowLayout());
			
			//Load data to the Scene from file
			try{
				BufferedReader in = new BufferedReader(new FileReader(path));
				String str;
				
				str = in.readLine();
				Row = Integer.parseInt(str);
				str = in.readLine();
				Col = Integer.parseInt(str);
				
				//Initialize the Scene
				Scene = new BasicBlock[RowNumber][ColNumber];
				for(int i=0; i<Row; i++)
					for(int j=0; j<Col; j++)
						Scene[i][j] = new BasicBlock();
			
				while(Row-- > 0)
				{
					str=in.readLine();
					String [] data=str.split(" ");
					for(int j=0;j<Col;j++){
						Scene[count][j].type = Integer.parseInt(data[j]);
						if(Scene[count][j].type == 1)
							pics[count][j] = pic1;
						else if(Scene[count][j].type == 2)
							pics[count][j] = pic2;
						else if(Scene[count][j].type == 3)
							pics[count][j] = pic3;
						else if(Scene[count][j].type == 4)
							pics[count][j] = pic4;
						else if(Scene[count][j].type == 5)
							pics[count][j] = pic5;
					}
					count++;
					
				}

			}catch(Exception e){
				e.printStackTrace();
			}
			
			//create a panel
			panel = new MySetPanel();
			panel.setPreferredSize(new Dimension(MapWidth, MapHeight));
			JScrollPane jsp = new JScrollPane(panel);
			jsp.setPreferredSize(new Dimension(1750, 900));
			jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			
			//Choose images from the combo box
			box = new JComboBox<ImageIcon>();
			for(int i=0; i < images.length; i++){
				box.addItem(images[i]);
			}
			
			//"Save" button
			JButton save = new JButton("Save Map");
			save.setActionCommand("save");
			
			
			this.add(jsp);
			this.add(box);
			this.add(save);
			this.setVisible(true);
			
			//Add MouseListener for panel
			PanelListenner plis = new PanelListenner();
			panel.addMouseListener(plis);
			
			//Add ActionListener for Button
			Buttonlistenner blis = new Buttonlistenner();
			save.addActionListener(blis);
		}
		
		//OverWrite the mathon(paint)
		class MySetPanel extends JPanel{
			public void paint(Graphics g) {
				super.paint(g);
				for(int i=0; i < RowNumber; i++){
					for(int j=0; j < ColNumber; j++){
						if(pics[i][j]!=null){
							g.drawImage(pics[i][j].getImage(), j*BlockSize, i*BlockSize, BlockSize, BlockSize, null);
						}
					}
				}
			}
			
		}
		
		//Click the button to save the new map
		class Buttonlistenner implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("save")){
					try{
						BufferedWriter out=new BufferedWriter(new FileWriter(path));
						out.write(Integer.toString(RowNumber));
						out.newLine();
						out.write(Integer.toString(ColNumber));
						out.newLine();
						for(int i=0;i<RowNumber;i++){
							for(int j=0;j<ColNumber;j++){
								out.write((Integer.toString(Scene[i][j].type)+" "));
							}
							out.newLine();
						}
						out.flush();
						out.close();
					}
					catch (IOException expression){
	                          expression.printStackTrace();
	                  }
					
				}
			}
		}
		
		class PanelListenner extends MouseAdapter{
			public void mouseClicked(MouseEvent e) {
				
				//Find Mouse'postion in the map 
				int j = e.getX() / BlockSize;
				int i = e.getY() / BlockSize;
				
				//Get the image witch the user has been choosed
				ImageIcon image = (ImageIcon)box.getSelectedItem();
				
				int num =  Integer.parseInt(image.toString().substring(7, 8));
				
				//Uptata the array
				Scene[i][j].type = num;
				pics[i][j] = image;

				panel.repaint();
			}
			
		}
}
