package com.ecoRecycle.ui;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ecoRecycle.model.Rmos;

public class RcmManagerPanel extends JPanel{
	private Rmos rmos;
	private JPanel displayPanel;
	
	public RcmManagerPanel(Rmos rmos) {
		this.rmos = rmos;
		
		// observe all rcms
		
		this.addComponents();
	}
	
	private void addComponents() {
		this.add(getControlPanel());
		this.add(getDisplayPanel());
	}
	
	private JPanel getControlPanel() {
		JPanel controlPanel = new JPanel();
		
		TitledBorder border = new TitledBorder("CONTROL PANEL");
		border.setTitleFont(new Font("TimesNewRoman", Font.BOLD, 8));
		controlPanel.setBorder(border);
		
		controlPanel.setPreferredSize(new Dimension(595, 50));
		
		JRadioButton viewRcmButton = new JRadioButton("View RCM");
		viewRcmButton.setSelected(true);
		
		JRadioButton addRcmButton = new JRadioButton("Add RCM");
		
		JRadioButton removeRcmButton = new JRadioButton("Remove RCM");
		
		JRadioButton manageRcmButton = new JRadioButton("Manage RCM");
		
		JRadioButton manageItemButton = new JRadioButton("Manage Items");
		
		ButtonGroup group = new ButtonGroup();
	    group.add(viewRcmButton);
	    group.add(addRcmButton);
	    group.add(removeRcmButton);
	    group.add(manageRcmButton);
	    group.add(manageItemButton);
	    
	    viewRcmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				viewRcmButtonHandler();
				
			}
		});
	    
	    addRcmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addRcmButtonHandler();
				
			}
		});
	    
	    removeRcmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				removeRcmButtonHandler();
				
			}
		});
	    
	    manageRcmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				manageRcmButtonHandler();
				
			}
		});

		
	    manageItemButton.addActionListener(new ActionListener() {
	
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		manageItemButtonHandler();
		
	    	}
	    });
	    controlPanel.add(viewRcmButton);
	    controlPanel.add(addRcmButton);
	    controlPanel.add(removeRcmButton);
	    controlPanel.add(manageRcmButton);
	    controlPanel.add(manageItemButton);
	    
		return controlPanel;
	}
	
	
	
	private JPanel getDisplayPanel() {
		displayPanel = new JPanel();
		
		displayPanel.setPreferredSize(new Dimension(595, 460));
		viewRcmButtonHandler();
		
		return displayPanel;
	}
	
	private void viewRcmButtonHandler() {
		System.out.println("You chose View!!");
		
		TitledBorder border = new TitledBorder("VIEW RCM");
		border.setTitleFont(new Font("TimesNewRoman", Font.BOLD, 8));
		displayPanel.setBorder(border);
		
		displayPanel.removeAll();
		displayPanel.add(new ViewRcmPanel(rmos));
		displayPanel.revalidate();
		displayPanel.repaint();
	}
	
	private void addRcmButtonHandler() {
		System.out.println("You chose add!!");
		
		TitledBorder border = new TitledBorder("ADD RCM");
		border.setTitleFont(new Font("TimesNewRoman", Font.BOLD, 8));
		displayPanel.setBorder(border);
		
		displayPanel.removeAll();
		displayPanel.add(new AddRcmPanel(rmos));
		displayPanel.revalidate();
		displayPanel.repaint();
	}
	
	private void removeRcmButtonHandler() {
		System.out.println("You chose remove!!");
		
		TitledBorder border = new TitledBorder("REMOVE RCM");
		border.setTitleFont(new Font("TimesNewRoman", Font.BOLD, 8));
		displayPanel.setBorder(border);
		
		displayPanel.removeAll();
		displayPanel.add(new RemoveRcmPanel(rmos));
		displayPanel.revalidate();
		displayPanel.repaint();
	}
	
	private void manageRcmButtonHandler() {
		System.out.println("You chose manage rcm!!");
		
		TitledBorder border = new TitledBorder("MANAGE RCM");
		border.setTitleFont(new Font("TimesNewRoman", Font.BOLD, 8));
		displayPanel.setBorder(border);
		
		displayPanel.removeAll();
		displayPanel.add(new ManageRcmPanel(rmos));
		displayPanel.revalidate();
		displayPanel.repaint();
	}
	
	private void manageItemButtonHandler() {
		System.out.println("You chose manage Item!!");
		
		TitledBorder border = new TitledBorder("MANAGE ITEM");
		border.setTitleFont(new Font("TimesNewRoman", Font.BOLD, 8));
		displayPanel.setBorder(border);
		
		displayPanel.removeAll();
		displayPanel.add(new ManageItemPanel(rmos));
		displayPanel.revalidate();
		displayPanel.repaint();
	}

}