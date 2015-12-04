package com.ecoRecycle.ui.rcm;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.ecoRecycle.model.Rcm;
import com.ecoRecycle.model.Rmos;
import com.ecoRecycle.service.ItemManager;
import com.ecoRecycle.service.RcmService;
import com.ecoRecycle.service.ReloadTransactionService;
import com.ecoRecycle.service.RmosManager;
import com.ecoRecycle.service.RmosService;
import com.ecoRecycle.service.StatusManager;
import com.ecoRecycle.service.UnloadTransactionService;
import com.ecoRecycle.ui.RmosUI;


public class RcmUIManager extends JFrame implements Observer
{
	
	private JPanel rcmChooserPanel = new JPanel();
	private JPanel rcmPanel = new JPanel();
	private JComboBox<String> rcmComboBox;
	
	private RcmService rcmService = new RcmService();
	private StatusManager statusManager;
	private ItemManager itemManager;

	private UnloadTransactionService uservice;
	private ReloadTransactionService rservice;
	private RmosManager rmosManager;


	/**
	* Create the application.
	*/
	public RcmUIManager(StatusManager statusManager, ItemManager itemManager, UnloadTransactionService uservice, ReloadTransactionService rservice, RmosManager rmosManager) 
	{
		super("RCM");
		this.statusManager = statusManager;
		this.itemManager = itemManager;
		this.rmosManager = rmosManager;
		
		this.uservice = uservice;
		this.rservice = rservice;
		
		this.rmosManager.addObserver(this);
		
		initialize();


	}

	/**
	* Initialize the contents of the frame.
	*/
	private void initialize() 
	{
			
			
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			this.setSize(new Dimension(screenSize.width/2 - 20, screenSize.height));
			setLocation(screenSize.width/2 + 10, 0);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			this.addComponents();
			
			this.setVisible(true);
			
	}
	
	private void addComponents() {
		Container contentPane = this.getContentPane();
		contentPane.removeAll();
		prepareRcmChooserPanel();
		if(rcmComboBox.getSelectedItem() != null)
			prepareRcmPanel(rcmComboBox.getSelectedItem().toString());
		else
			rcmPanel.removeAll();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(rcmChooserPanel, BorderLayout.NORTH);
		contentPane.add(rcmPanel, BorderLayout.SOUTH);
		
		
	}
	
	private void prepareRcmChooserPanel() {
		rcmChooserPanel.removeAll();
		
		rcmChooserPanel.setLayout(new BorderLayout());
		rcmChooserPanel.setPreferredSize(new Dimension(0, 70));
		
		TitledBorder border = new TitledBorder("CHOOSE RCM");
		border.setTitleFont(new Font("TimesNewRoman", Font.BOLD, 18));
		rcmChooserPanel.setBorder(border);
		
		JLabel rmosLabel = new JLabel("Choose Rcm:");
		rcmComboBox = new JComboBox<String>();
		
		//Set<Rcm> rcmList = new RcmService().getAllRcms();
		List<Rcm> rcmList = rmosManager.getAllRcms();
		Collections.sort(rcmList, new Comparator<Rcm>(){
		       public int compare(Rcm o1, Rcm o2) {
		           return o1.getName().compareTo(o2.getName());
		        }
		    });
		
		for(Rcm rcm : rcmList) {
			rcmComboBox.addItem(rcm.getName());
		}
		
		//rcmComboBox.setSelectedItem("rcm256");
		
		rcmComboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				JComboBox comboBox = (JComboBox) event.getSource();
				Object item = event.getItem();
				if (event.getStateChange() == ItemEvent.SELECTED) {
					prepareRcmPanel(item.toString());
				}				
			}
        });
		
		JPanel rcmChooserInnerPanel = new JPanel();
		rcmChooserInnerPanel.add(rmosLabel);
		rcmChooserInnerPanel.add(rcmComboBox);
		
		rcmChooserPanel.add(rcmChooserInnerPanel, BorderLayout.WEST);
		
		rcmChooserPanel.revalidate();
		rcmChooserPanel.repaint();
	}
	
	private void prepareRcmPanel(String rcmName) {
		rcmPanel.removeAll();
        System.out.println("Switching to Rcm:" + rcmName);
		rcmPanel.add(new RcmUI(rcmName, this, statusManager, itemManager, uservice, rservice));
		
//		TitledBorder border = new TitledBorder("RMOS SPECIFIC PANEL");
//		border.setTitleFont(new Font("TimesNewRoman", Font.BOLD, 18));
//		rmosPanel.setBorder(border);
		
		rcmPanel.setPreferredSize(new Dimension(0, 875));
		
		this.revalidate();
		this.repaint();
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("In RCM UI update....");
		//prepareRcmChooserPanel();
		addComponents();
		this.revalidate();
		this.repaint();
	}
	

}
