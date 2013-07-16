package org.cytoscape.sample.internal;

import org.cytoscape.application.swing.CySwingApplication;

import org.cytoscape.sample.internal.MyCytoPanel;
import org.cytoscape.sample.internal.Sample02;

import org.cytoscape.application.swing.CytoPanelComponent;
import org.cytoscape.application.swing.CyAction;

import org.osgi.framework.BundleContext;

import org.cytoscape.service.util.AbstractCyActivator;

import java.util.Properties;



import java.util.*;
import org.cytoscape.model.*;
import javax.swing.event.TableModelEvent;
import org.cytoscape.browser.internal.util.TableBrowserUtil;
import org.cytoscape.model.CyIdentifiable;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyTable;
import org.cytoscape.model.CyTableManager;



public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {

		CySwingApplication cytoscapeDesktopService = getService(bc,CySwingApplication.class);

		CyNetwork currentNetwork = CyApplicationManager.getCurrentNetwork();
		CyTable nodeTable = CyNetworkTableManager.getTable(currentNetwork, CyNode.class, CyNetwork.DEFAULT_ATTRS);
		
		MyCytoPanel myCytoPanel = new MyCytoPanel();
		Sample02 sample02Action = new Sample02(cytoscapeDesktopService,myCytoPanel);
		
		registerService(bc,myCytoPanel,CytoPanelComponent.class, new Properties());
		registerService(bc,sample02Action,CyAction.class, new Properties());

		

	}
}
