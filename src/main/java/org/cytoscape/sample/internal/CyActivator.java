package org.cytoscape.sample.internal;

import org.cytoscape.application.swing.CySwingApplication;

import org.cytoscape.sample.internal.MyCytoPanel;
import org.cytoscape.sample.internal.Sample02;

import org.cytoscape.application.swing.CytoPanelComponent;
import org.cytoscape.application.swing.CyAction;

import org.osgi.framework.BundleContext;

import org.cytoscape.service.util.AbstractCyActivator;

import java.util.Properties;

import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyNetworkManager;
import org.cytoscape.model.CyNetworkTableManager;
import org.cytoscape.model.CyNode;
import org.cytoscape.model.CyTableManager;
import org.cytoscape.service.util.CyServiceRegistrar;



public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {

		CySwingApplication cytoscapeDesktopService = getService(bc,CySwingApplication.class);
		CyApplicationManager cyApplicationManagerServiceRef = getService(bc,CyApplicationManager.class);
		CyNetworkTableManager cyNetworkTableManagerServiceRef = getService(bc,CyNetworkTableManager.class);

		CyTable nodeTable = new cyNetworkTableManager.getTable(currentNetwork, CyNode.class, CyNetwork.DEFAULT_ATTRS);

		CyNetwork currentNetwork = new CyApplicationManager.getCurrentNetwork();

		MyCytoPanel myCytoPanel = new MyCytoPanel();
		Sample02 sample02Action = new Sample02(cytoscapeDesktopService,myCytoPanel);
		
		registerService(bc,myCytoPanel,CytoPanelComponent.class, new Properties());
		registerService(bc,sample02Action,CyAction.class, new Properties());
		

	}
}

