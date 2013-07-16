package org.cytoscape.sample.internal;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JPanel;
import org.cytoscape.application.swing.CytoPanelComponent;
import org.cytoscape.application.swing.CytoPanelName;
import javax.swing.JLabel;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.AbstractTableModel;




import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import org.cytoscape.browser.internal.util.TableBrowserUtil;
import org.cytoscape.model.CyColumn;
import org.cytoscape.model.CyIdentifiable;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyRow;
import org.cytoscape.model.CyTable;
import org.cytoscape.model.CyTableManager;
import org.cytoscape.model.events.RowsCreatedEvent;
import org.cytoscape.model.events.RowsCreatedListener;

public class MyCytoPanel extends JPanel implements CytoPanelComponent {
	
	private static final long serialVersionUID = 8292806967891823933L;


	public MyCytoPanel() {
	      BoxLayout boxLayout = new BoxLayout( this , BoxLayout.Y_AXIS );
	      this.setLayout(boxLayout);
	      //JLabel lbXYZ = new JLabel("This is my Filter Table for Panel Demo");

	      JButton button = new JButton("Demo Button");
	      button.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e)
	      {
		  //Execute when button is pressed
		  CyNetwork currentNetwork = CyApplicationManager.getCurrentNetwork();
		  CyTable nodeTable = CyNetworkTableManager.getTable(currentNetwork, CyNode.class, CyNetwork.DEFAULT_ATTRS);
		  
	      }
	      });

	      JScrollPane scrollpanebig = new JScrollPane(this);
	      this.add(button);
	      final JTable table = new JTable(new MytableModel());
	      JScrollPane scrollPane = new JScrollPane(table);
	      this.add(scrollPane);
	      //this.add(lbXYZ);
	      this.setVisible(true);
	}
public class MytableModel extends AbstractTableModel {
	  String[] columnNames = {"Shared Name", "Name", "AverageShortestPathLength", "ClusteringCoefficient", "ClosenessCentrality", "IsSingleNode", "PartnerOfMultiEdgedNodePairs", "SelfLoops", "Eccentricity", "Stress", "Degree", "BetweenessCentrality", "NeighborhoodConnectivity", "NumberOfDirectedEdges", "NumberOfUndirectedEdges", "Radiality", "TopologicalCoefficient", "gal4RGexp", "gal80Rsig", "gal80Rexp", "COMMON", "gal4RGsig", "gal1RGexp", "gal1RGsig"};

	  //getting the number of rows in the current working node table
	  int rowcount = nodeTable.getRowCount();
	  // declaring the object for JTable data, providing the fixed columns and obtained rows
	  Object[][] data = new Object[rowcount][24];
	  /*
	    Operating one by one on CyColumns [1]
	    get the class type of the current working column [2]
	    then obtain the values of the current working column in a list [3]
	    then add those values column wise to the Jtable created [4]
	  */
	  for(int i = 0; i < 24; i++){
	  
	    CyColumn currentWorkingColumn = nodeTable.getColumn(columnNames[i]);//[1]
	    Class<?> columnClassType = currentWorkingColumn.getType();//[2]
	    List<columnClassType> currentWorkingColumnValues = currentWorkingColumn.getValues(columnClassType);//[3]
	    //[4]
	    for(int j=0;j<rowcount;j++){
	      data[j][i] = currentWorkingColumnValues[j];
	    }
	    
	  }	

}

	public Component getComponent() {
		return this;
	}


	public CytoPanelName getCytoPanelName() {
		return CytoPanelName.SOUTH;
	}


	public String getTitle() {
		return "FilterTable";
	}


	public Icon getIcon() {
		return null;
	}
}
