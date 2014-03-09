package viewPackage;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel  extends JPanel{
	
	private BufferedImage image;

    public ImagePanel() {
       try {           
    	   //TODO NICHT VERGESSEN!! PFAD ANPASSEN!!!
          image = ImageIO.read(new File("C:\\Users\\cashmachines\\Desktop\\JavaEngineer\\eclipse_standard\\projekte\\BookmakerOverview\\Bilder\\bwin.jpg"));
       } catch (IOException ex) {
            System.out.println("Bild nicht gefunden oder nicht lesbar");
       }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 250, 0, 500, 300, null); // see javadoc for more info on the parameters    
        
    }

}
