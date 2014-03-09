package viewPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageProducer;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.html.ImageView;

import Listener.ButtonNeuListener;
import Listener.DateiBeendenListener;

public class Mainframe extends JFrame {

	// private eigenschaften feslegen

	// menüleiste north
	private JMenuBar mnuBar;

	private JMenu mnuDatei;
	private JMenuItem mnuDateiBeenden;
	private JMenu mnuExtras;
	private JMenuItem mnuExtrasAbc;
	private JMenu mnuHilfe;
	private JMenuItem mnuHilfeUeber;

	// infobereich center und east
	private JPanel pnlLinks, pnlRechts, pnlRechtsUebersicht, pnlNorth, pnlButtons, pnlInfo, pnlSouth,
	pnlBeschriftungFormular, pnlBeschriftungInfobereich;

	// suchleiste east
	private JTextField txtSearchBar;

	// formular east
	private JLabel lblBuchmacher, lblBonus, lblProzent, lblWaehrung, lblArt,
			lblEWallet, lblPrepaid, lblSprache, lblWebsite, lblCopyright, lblLinksBuchmacher, lblLinksBonus, 
			lblLinksProzent, lblLinksWaehrung, lblLinksArt, lblLinksEWallet, lblLinksPrepaid, lblLinksSprache, 
			lblLinksWebsite, lblLinksLeerBuchmacher, lblLinksLeerBonus, 
			lblLinksLeerProzent, lblLinksLeerWaehrung, lblLinksLeerArt, lblLinksLeerEWallet, lblLinksLeerPrepaid,
			lblLinksLeerSprache, lblLinksLeerWebsite, lblBeschriftungFormular, lblBeschriftungInfobereich;
	
	private JTextField txtBuchmacher, txtBonus, txtProzent, txtWaehrung,
			txtArt, txtEWallet, txtPrepaid, txtSprache, txtWebsite;

	// butteonoptionen east
	private JButton btnNeu, btnSpeichern, btnSuchen, btnLoeschen,
			btnAlleBuchmacherAnzeigen;
	
	private ImagePanel pnlLogo;

	// GUI einstellungen
	public Mainframe() {

		setLocation(50, 50);
		setTitle("BookmakerOverview by Tran Quoc Thai");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout(30, 30));

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		createWidgets();
		addWidgets();

		getContentPane().add(pnlNorth, BorderLayout.NORTH);
		getContentPane().add(pnlLinks, BorderLayout.CENTER);
		getContentPane().add(pnlRechtsUebersicht, BorderLayout.EAST);
		getContentPane().add(pnlSouth, BorderLayout.SOUTH);
		
		btnNeu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				txtBuchmacher.setText("");
				txtBonus.setText("");
				txtProzent.setText("");
				txtWaehrung.setText("");
				txtArt.setText("");
				txtEWallet.setText("");
				txtPrepaid.setText("");
				txtSprache.setText("");
				txtWebsite.setText("");
			}
		});
		
		
		
		mnuDateiBeenden.addActionListener(new DateiBeendenListener());

		pack();
		setVisible(true);

	}

	// objekte hinzufügen bzw sichtbar machen
	private void addWidgets() {

		mnuBar.add(mnuDatei);
		mnuDatei.add(mnuDateiBeenden);
		
		mnuBar.add(mnuExtras);
		mnuExtras.add(mnuExtrasAbc);

		mnuBar.add(mnuHilfe);
		mnuHilfe.add(mnuHilfeUeber);
	
		
		pnlNorth.add(mnuBar);
		pnlNorth.add(txtSearchBar);
		
		pnlRechtsUebersicht.add(pnlBeschriftungFormular);
		pnlRechtsUebersicht.add(pnlRechts);
		pnlRechtsUebersicht.add(Box.createVerticalGlue());
		pnlRechtsUebersicht.add(pnlButtons);
		
		pnlRechtsUebersicht.setBorder(new LineBorder(Color.BLACK));

		
		pnlRechts.add(lblBuchmacher);
		pnlRechts.add(txtBuchmacher);
		pnlRechts.add(lblBonus);
		pnlRechts.add(txtBonus);
		pnlRechts.add(lblProzent);
		pnlRechts.add(txtProzent);
		pnlRechts.add(lblWaehrung);
		pnlRechts.add(txtWaehrung);
		pnlRechts.add(lblArt);
		pnlRechts.add(txtArt);
		pnlRechts.add(lblEWallet);
		pnlRechts.add(txtEWallet);
		pnlRechts.add(lblPrepaid);
		pnlRechts.add(txtPrepaid);
		pnlRechts.add(lblSprache);
		pnlRechts.add(txtSprache);
		pnlRechts.add(lblWebsite);
		pnlRechts.add(txtWebsite);
		
		

		pnlButtons.add(btnNeu);
		pnlButtons.add(btnSpeichern);
		pnlButtons.add(btnSuchen);
		pnlButtons.add(btnLoeschen);
		pnlButtons.add(btnAlleBuchmacherAnzeigen);
		
		pnlLinks.add(pnlBeschriftungInfobereich);
		
		pnlLinks.add(pnlInfo);
		pnlInfo.add(lblLinksBuchmacher);
		pnlInfo.add(lblLinksLeerBuchmacher);
		pnlInfo.add(lblLinksBonus);
		pnlInfo.add(lblLinksLeerBonus);
		pnlInfo.add(lblLinksProzent);
		pnlInfo.add(lblLinksLeerProzent);
		pnlInfo.add(lblLinksWaehrung);
		pnlInfo.add(lblLinksLeerWaehrung);
		pnlInfo.add(lblLinksArt);
		pnlInfo.add(lblLinksLeerArt);
		pnlInfo.add(lblLinksEWallet);
		pnlInfo.add(lblLinksLeerEWallet);
		pnlInfo.add(lblLinksPrepaid);
		pnlInfo.add(lblLinksLeerPrepaid);
		pnlInfo.add(lblLinksSprache);
		pnlInfo.add(lblLinksLeerSprache);
		pnlInfo.add(lblLinksWebsite);
		pnlInfo.add(lblLinksLeerWebsite);
		
		
		pnlLinks.add(pnlLogo);
		
		

	}

	// objekte definiert bzw erstellt
	private void createWidgets() {

		mnuBar = new JMenuBar();

		mnuDatei = new JMenu("Datei");
		mnuDateiBeenden = new JMenuItem("Beenden");
		
		mnuExtras = new JMenu("Extras");
		mnuExtrasAbc = new JMenuItem("Abc");

		mnuHilfe = new JMenu("Hilfe");
		mnuHilfeUeber = new JMenuItem("Über Buchmacher Verwaltung");

		pnlNorth = new JPanel();
		pnlNorth.setLayout(new GridLayout(2, 1));
		
		pnlLinks = new JPanel();
		pnlLinks.setLayout(new BoxLayout(pnlLinks, BoxLayout.PAGE_AXIS));
		
		pnlInfo = new JPanel(new GridLayout(0, 2));
		
		
		pnlLogo = new ImagePanel();
		
		
		pnlRechtsUebersicht = new JPanel();
		pnlRechtsUebersicht.setLayout(new BoxLayout(pnlRechtsUebersicht, BoxLayout.PAGE_AXIS));
		
		txtSearchBar = new JTextField("Suche...");
		
		pnlRechts = new JPanel();
		pnlRechts.setLayout(new GridLayout(0, 2));	
		pnlRechts.setBorder(new LineBorder(Color.RED));
		
		pnlButtons = new JPanel();
		pnlButtons.setLayout(new GridLayout(1, 5));
		pnlButtons.setBorder(new LineBorder(Color.BLUE));
		pnlButtons.setPreferredSize(new Dimension(500, 
				pnlButtons.getMinimumSize().height));


		lblBuchmacher = new JLabel("Buchmacher:");
		lblBonus = new JLabel("Bonus:");
		lblProzent = new JLabel("Prozent:");
		lblWaehrung = new JLabel("Währung:");
		lblArt = new JLabel("Art:");
		lblEWallet = new JLabel("E-Wallet:");
		lblPrepaid = new JLabel("Prepaid:");
		lblSprache = new JLabel("Sprache:");
		lblWebsite = new JLabel("Website:");
		lblCopyright = new JLabel(
				"\u00a9 Copyright by Tran Quoc Thai - All rights reserved");
		
		txtBuchmacher = new JTextField();
		txtBuchmacher.setPreferredSize(new Dimension(txtBuchmacher.getPreferredSize().width, txtBuchmacher.getMinimumSize().height));
		txtBonus = new JTextField();
		txtProzent = new JTextField();
		txtWaehrung = new JTextField();
		txtArt = new JTextField();
		txtEWallet = new JTextField();
		txtPrepaid = new JTextField();
		txtSprache = new JTextField();
		txtWebsite = new JTextField();

		btnNeu = new JButton("Neu");
		btnNeu.setPreferredSize(new Dimension(100,50));
		btnSpeichern = new JButton("Speichern");
		btnSpeichern.setPreferredSize(new Dimension(100, 50));
		btnSuchen = new JButton("Suchen");
		btnSuchen.setPreferredSize(new Dimension(100, 50));
		btnLoeschen = new JButton("Löschen");
		btnLoeschen.setPreferredSize(new Dimension(100, 50));
		btnAlleBuchmacherAnzeigen = new JButton("Alle Buchmacher anzeigen");
		btnAlleBuchmacherAnzeigen.setPreferredSize(new Dimension(100, 50));
		
		lblLinksBuchmacher = new JLabel("Buchmacher:");
		lblLinksLeerBuchmacher = new JLabel("sadasdadasd");
		lblLinksBonus = new JLabel("Bonus:");
		lblLinksLeerBonus = new JLabel("");
		lblLinksProzent = new JLabel("Prozent:");
		lblLinksWaehrung = new JLabel("Währung:");
		lblLinksArt = new JLabel("Art:");
		lblLinksEWallet = new JLabel("E-Wallet:");
		lblLinksPrepaid = new JLabel("Prepaid:");
		lblLinksSprache = new JLabel("Sprache:");
		lblLinksWebsite = new JLabel("Website:");
		
		
		
		lblLinksLeerProzent = new JLabel("");
		lblLinksLeerWaehrung = new JLabel("");
		lblLinksLeerArt = new JLabel("");
		lblLinksLeerEWallet = new JLabel("");
		lblLinksLeerPrepaid = new JLabel("");
		lblLinksLeerSprache = new JLabel("");
		lblLinksLeerWebsite = new JLabel("");
		
		lblBeschriftungFormular = new JLabel("Formular");
		lblBeschriftungFormular.setFont(new Font(lblBeschriftungFormular.getFont().getFontName(), Font.BOLD, 20));
		lblBeschriftungInfobereich = new JLabel("Infobereich");
		lblBeschriftungInfobereich.setFont(new Font(lblBeschriftungInfobereich.getFont().getFontName(), Font.BOLD, 20));
		
		pnlBeschriftungFormular = new JPanel();
		pnlBeschriftungFormular.add(lblBeschriftungFormular);
		pnlBeschriftungInfobereich = new JPanel();
		pnlBeschriftungInfobereich.add(lblBeschriftungInfobereich);
		
		pnlSouth = new JPanel();
		pnlSouth.add(lblCopyright);

	}

}
