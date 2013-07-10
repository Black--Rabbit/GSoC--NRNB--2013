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
		  System.out.println("You clicked the button");
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
	  String[] columnNames = {"Col A", "Col B", "Col C", "Col D", "Col E"};
	  Object[][] data = {
	      {"K", "S", "Snow", new Integer(5), new Boolean(false)},
	      {"J", "D", "Row", new Integer(3), new Boolean(true)},
	      {"S", "B", "Kite", new Integer(2), new Boolean(false)},
	      {"J", "W", "Speed", new Integer(20), new Boolean(true)},
	      {"J", "B", "Pool", new Integer(10), new Boolean(false)}
	  };

	public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        /*
         * JTable uses this method to determine the default renderer/
         * editor for each cell.  If we didn't implement this method,
         * then the last column would contain text ("true"/"false"),
         * rather than a check box.
         */
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
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
