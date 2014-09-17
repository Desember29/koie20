package pages;
import javax.swing.*;

import org.openstreetmap.gui.jmapviewer.*;

import com.alee.laf.WebLookAndFeel;

import java.awt.*;
import java.awt.event.*;
public class pageHub extends JFrame{
	
		JTabbedPane contentPanel = new JTabbedPane();
		JPanel kartPane = new JPanel();
		JPanel reservePane = new JPanel();
		
		
		public pageHub() {
			getContentPane().add(contentPanel);
			contentPanel.add("Reserver",reservePane);
			contentPanel.add("Kart",kartPane);
			this.setSize(600, 500);
			mapPane();
		}
		public void mapPane(){
			JMapViewer mapPanel = new JMapViewer(); 
			mapPanel.setBounds(10, 11, 400, 400);
			double lat = 63.13;
			double lon = 10.43;
			mapPanel.setDisplayPositionByLatLon(lat, lon, 8);
			kartPane.setLayout(null);
			kartPane.add(mapPanel);
			//double[][] koie_cords = koie.core.dbJDBC.getKoieCords();
			double[][] koie_cords = {{lat,lon}};
			for (double[] k: koie_cords){
				mapPanel.addMapMarker(new MapMarkerDot(k[0],k[1]));
			}
			mapPanel.repaint();
		}
}
