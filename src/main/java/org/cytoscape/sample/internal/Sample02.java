package org.cytoscape.sample.internal;

import java.awt.event.ActionEvent;

import org.cytoscape.application.swing.AbstractCyAction;
import org.cytoscape.application.swing.CySwingApplication;
import org.cytoscape.application.swing.CytoPanel;
import org.cytoscape.application.swing.CytoPanelName;
import org.cytoscape.application.swing.CytoPanelState;


public class Sample02 extends AbstractCyAction {

	private CySwingApplication desktopApp;
	private final CytoPanel cytoPanelSouth;
	private MyCytoPanel myCytoPanel;

	
	public Sample02(CySwingApplication desktopApp,
			MyCytoPanel myCytoPanel){
		// Add a menu item -- Apps->sample02
		super("Panel Demo");
		setPreferredMenu("Apps");

		this.desktopApp = desktopApp;
		
		//Note: myCytoPanel is bean we defined and registered as a service
		this.cytoPanelSouth = this.desktopApp.getCytoPanel(CytoPanelName.SOUTH);
		this.myCytoPanel = myCytoPanel;
	}
	
	public void actionPerformed(ActionEvent e) {
		// If the state of the cytoPanelWest is HIDE, show it
		if (cytoPanelSouth.getState() == CytoPanelState.HIDE) {
			cytoPanelSouth.setState(CytoPanelState.DOCK);
		}	

		// Select my panel
		int index = cytoPanelSouth.indexOfComponent(myCytoPanel);
		if (index == -1) {
			return;
		}
		cytoPanelSouth.setSelectedIndex(index);
	}
