
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.border.Border;
import javax.swing.*;

import java.awt.event.*;

import java.util.ArrayList;
import java.util.Stack;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Iterator;
import java.io.*;
import java.util.*;
public class GUI extends JFrame {

	private JMenuBar menuBar;
	private JTextField commandField;
	private JPanel inventory1;
	private JTextArea textarea1;
	private JPanel mainPanel;
	private JButton east1, north1, south1, west1, take1, teleport1, explore1, leave1, lietuviu1, help1, english1,
	back1,mudding1,moonshine1, eat1 ;
	
	private Parser parser;
        private Room currentRoom;
        Room pacificOcean, atlanticOcean, indianOcean, europe, america, australia, asia, africa, explore, dive, fight, diversion, divePacific, diveAtlantic, climbIce, diveUnder, exploreAmerica,
        mud, moonshine, eat, exploreEurope, drink, france, exploreAsia, bathroom, wall, exploreAustralia, box, erwin, exploreAfrica, desert, egypt, exploreIndia, boat, shiny, home,
        antarctica, atlantis, golden, teleport, ramusis, atlantas, indijos, europa, amerika, australija, azija, afrika, aplankyti, nerti, kovoti,  diversija, nertiRamusis, nertiAtlanta, liptiLeda, nertiPo, aplankytiAmerika,
        purvas, naminuke, valgyti, aplankytiEuropa, gerti, prancuzija, aplankytiAzija, tuoletas, siena, aplankytiAustralija, boksuoti, irvinas, aplankytiAfrika, dykuma, egiptas, aplankytiIndija, laivas, blizgus, namai,
        antarktida, atlantida, auksinis, teleportuoti;
        private int top;
        private Player player;
        private Artifact cookie;
        private int turns;
        private Room charging;
        private static boolean english = false;
        private Command command;
	 
	public GUI()
	{

		this.setTitle("GUI");
		this.setSize(600,500);
		
		generateMenu();
		this.setJMenuBar(menuBar);

		JPanel contentPane = new JPanel(null);
		contentPane.setPreferredSize(new Dimension(600,500));
		contentPane.setBackground(new Color(192,192,192));

		commandField = new JTextField();
		commandField.setBounds(5,385,110,35);
		commandField.setBackground(new Color(255,255,255));
		commandField.setForeground(new Color(0,0,0));
		commandField.setEnabled(true);
		commandField.setFont(new Font("sansserif",0,12));
		commandField.setText("");
		commandField.setVisible(true);
		
		mainPanel = new JPanel(null);
		mainPanel.setBorder(BorderFactory.createEtchedBorder(1));
		mainPanel.setBounds(5,15,590,300);
		mainPanel.setBackground(new Color(214,217,223));
		mainPanel.setForeground(new Color(0,0,0));
		mainPanel.setEnabled(true);
		mainPanel.setFont(new Font("sansserif",0,12));
		mainPanel.setVisible(true);
		
		textarea1 = new JTextArea();
		textarea1.setBounds(5,5,585,150);
		textarea1.setBackground(new Color(255,255,255));
		textarea1.setForeground(new Color(0,0,0));
		textarea1.setEnabled(true);
		textarea1.setFont(new Font("sansserif",0,12));
		textarea1.setText("");
		textarea1.setBorder(BorderFactory.createBevelBorder(1));
		textarea1.setVisible(false);
		
		mainPanel.add(textarea1);
		
		inventory1 = new JPanel(null);
		inventory1.setBorder(BorderFactory.createEtchedBorder(1));
		inventory1.setBounds(5,320,350,50);
		inventory1.setBackground(new Color(214,217,223));
		inventory1.setForeground(new Color(0,0,0));
		inventory1.setEnabled(true);
		inventory1.setFont(new Font("sansserif",0,12));
		inventory1.setVisible(true);
		
		help1 = new JButton();
		help1.setBounds(5,460,110,35);
		help1.setBackground(new Color(214,217,223));
		help1.setForeground(new Color(0,0,0));
		help1.setEnabled(true);
		help1.setFont(new Font("sansserif",0,12));
		help1.setText("Help/Pagalba");
		help1.setVisible(true);
		help1.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent evt) 
			{
			    help1(evt);
			}
		}
		);

		english1 = new JButton();
		english1.setBounds(150,135,110,35);
		english1.setBackground(new Color(214,217,223));
		english1.setForeground(new Color(0,0,0));
		english1.setEnabled(true);
		english1.setFont(new Font("sansserif",0,12));
		english1.setText("English");
		english1.setVisible(true);
		english1.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent evt) 
			{
			    english1(evt);
			}
		}
		);

		lietuviu1 = new JButton();
		lietuviu1.setBounds(330,135,110,35);
		lietuviu1.setBackground(new Color(214,217,223));
		lietuviu1.setForeground(new Color(0,0,0));
		lietuviu1.setEnabled(true);
		lietuviu1.setFont(new Font("sansserif",0,12));
		lietuviu1.setText("Lietuvių");
		lietuviu1.setVisible(true);
		lietuviu1.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent evt) 
			{
			    lietuviu1(evt);
			}
		}
		);

		north1 = new JButton();
		north1.setBounds(390,350,110,35);
		north1.setBackground(new Color(214,217,223));
		north1.setForeground(new Color(0,0,0));
		north1.setEnabled(true);
		north1.setFont(new Font("sansserif",0,12));
		north1.setText("North/Šiaurė");
		north1.setVisible(true);
		north1.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent evt) 
			{
			    north1(evt);
			}
		}
		);

		east1 = new JButton();
		east1.setBounds(460,385,110,35);
		east1.setBackground(new Color(214,217,223));
		east1.setForeground(new Color(0,0,0));
		east1.setEnabled(true);
		east1.setFont(new Font("sansserif",0,12));
		east1.setText("East/Rytai");
		east1.setVisible(true);
		east1.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent evt) 
			{
			    east1(evt);
			}
		}
		);
		
		eat1 = new JButton();
		eat1.setBounds(460,385,110,35);
		eat1.setBackground(new Color(214,217,223));
		eat1.setForeground(new Color(0,0,0));
		eat1.setEnabled(true);
		eat1.setFont(new Font("sansserif",0,12));
		eat1.setText("Option 3");
		eat1.setVisible(false);
		eat1.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent evt) 
			{
			    eat1(evt);
			}
		}
		);
		
		south1 = new JButton();
		south1.setBounds(390,420,110,35);
		south1.setBackground(new Color(214,217,223));
		south1.setForeground(new Color(0,0,0));
		south1.setEnabled(true);
		south1.setFont(new Font("sansserif",0,12));
		south1.setText("South/Pietūs");
		south1.setVisible(true);
		south1.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent evt) 
			{
			    south1(evt);
			}
		}
		);
		
		moonshine1 = new JButton();
		moonshine1.setBounds(390,420,110,35);
		moonshine1.setBackground(new Color(214,217,223));
		moonshine1.setForeground(new Color(0,0,0));
		moonshine1.setEnabled(true);
		moonshine1.setFont(new Font("sansserif",0,12));
		moonshine1.setText("Option 2");
		moonshine1.setVisible(false);
		moonshine1.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent evt) 
			{
			    moonshine1(evt);
			}
		}
		);
		
		west1 = new JButton();
		west1.setBounds(330,385,110,35);
		west1.setBackground(new Color(214,217,223));
		west1.setForeground(new Color(0,0,0));
		west1.setEnabled(true);
		west1.setFont(new Font("sansserif",0,12));
		west1.setText("West/Vakarai");
		west1.setVisible(true);
		west1.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent evt) 
			{
			    west1(evt);
			}
		}
		);
		
		mudding1 = new JButton();
		mudding1.setBounds(330,385,110,35);
		mudding1.setBackground(new Color(214,217,223));
		mudding1.setForeground(new Color(0,0,0));
		mudding1.setEnabled(true);
		mudding1.setFont(new Font("sansserif",0,12));
		mudding1.setText("Option 1");
		mudding1.setVisible(false);
		mudding1.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent evt) 
			{
			    mudding1(evt);
			}
		}
		);
		
		back1 = new JButton();
		back1.setBounds(460,460,110,35);
		back1.setBackground(new Color(214,217,223));
		back1.setForeground(new Color(0,0,0));
		back1.setEnabled(true);
		back1.setFont(new Font("sansserif",0,12));
		back1.setText("Back/Atgal");
		back1.setVisible(true);
		back1.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent evt) 
			{
			    back1(evt);
			}
		}
		);
		
		leave1 = new JButton();
		leave1.setBounds(330,460,110,35);
		leave1.setBackground(new Color(214,217,223));
		leave1.setForeground(new Color(0,0,0));
		leave1.setEnabled(true);
		leave1.setFont(new Font("sansserif",0,12));
		leave1.setText("Leave/Iseiti");
		leave1.setVisible(true);
		leave1.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent evt) 
			{
			    leave1(evt);
			}
		}
		);
		
		explore1 = new JButton();
		explore1.setBounds(330,460,110,35);
		explore1.setBackground(new Color(214,217,223));
		explore1.setForeground(new Color(0,0,0));
		explore1.setEnabled(true);
		explore1.setFont(new Font("sansserif",0,12));
		explore1.setText("Explore/Aplankyti");
		explore1.setVisible(false);
		explore1.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent evt) 
			{
			    explore1(evt);
			}
		}
		);

		take1 = new JButton();
		take1.setBounds(130,385,110,35);
		take1.setBackground(new Color(214,217,223));
		take1.setForeground(new Color(0,0,0));
		take1.setEnabled(true);
		take1.setFont(new Font("sansserif",0,12));
		take1.setText("Take/Paimti");
		take1.setVisible(true);
		take1.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent evt) 
			{
			    take1(evt);
			}
		}
		);

		teleport1 = new JButton();
		teleport1.setBounds(130,460,110,35);
		teleport1.setBackground(new Color(214,217,223));
		teleport1.setForeground(new Color(0,0,0));
		teleport1.setEnabled(true);
		teleport1.setFont(new Font("sansserif",0,12));
		teleport1.setText("Teleport/Teleportuoti");
		teleport1.setVisible(true);
		teleport1.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent evt) 
			{
			    teleport1(evt);
			}
		}
		);

		contentPane.add(commandField);
		
		mainPanel.add(english1);
		mainPanel.add(lietuviu1);
		
		contentPane.add(help1);
		contentPane.add(inventory1);
		contentPane.add(mainPanel);
		
		contentPane.add(leave1);
		contentPane.add(explore1);
		contentPane.add(north1);
		contentPane.add(east1);
		contentPane.add(south1);
		contentPane.add(west1);
		contentPane.add(back1);
		contentPane.add(teleport1);
		
		contentPane.add(take1);
		contentPane.add(mudding1);
		contentPane.add(moonshine1);
		contentPane.add(eat1);

		this.add(contentPane);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
		
		createRooms();
                parser = new Parser();
                turns = 30;
	}
	
	private void printTextOnPanel (ActionEvent evt) 
	{
	    
	}
	
	private void leave1 (MouseEvent evt) 
	{
	    command = new Command("go", "leave");
	    leave1.setVisible(false);
	    explore1.setVisible(true);
	    processCommand(command);
	}
	
	private void explore1 (MouseEvent evt) 
	{
	    command = new Command("go", "explore");
	    
	    processCommand(command);
	    west1.setVisible(false);
	    south1.setVisible(false);
	    east1.setVisible(false);
	    explore1.setVisible(false);
	    north1.setVisible(false);
	    moonshine1.setVisible(true);
	    eat1.setVisible(true);
	    mudding1.setVisible(true);
	}
	
	private void north1 (MouseEvent evt) 
	{
	    command = new Command("go", "north");
	    
	    processCommand(command);
	}
	
	private void mudding1 (MouseEvent evt) 
	{
	    if (player.getCurrentRoom() == exploreAmerica)
	    {
	        
	        command = new Command("go", "mudding");
	    
	        processCommand(command);
	    }
	    if (player.getCurrentRoom() == diveAtlantic)
	    {
	        
	        command = new Command("go", "climb");
	    
	        processCommand(command);
	    }
	}
	
	private void moonshine1 (MouseEvent evt) 
	{
	   if (player.getCurrentRoom() == exploreAmerica)
	    {
	        
	        command = new Command("go", "moonshine");
	    
	        processCommand(command);
	    }
	    if (player.getCurrentRoom() == diveAtlantic)
	    {
	        
	        command = new Command("go", "dive");
	    
	        processCommand(command);
	    }
	}
	
	private void eat1 (MouseEvent evt) 
	{
	   if (player.getCurrentRoom() == exploreAmerica)
	    {
	        
	        command = new Command("go", "eat");
	    
	        processCommand(command);
	    }
	   if (player.getCurrentRoom() == diveAtlantic)
	    {
	        
	        command = new Command("go", "swim");
	    
	        processCommand(command);
	    }
	}
	
	private void east1 (MouseEvent evt) 
	{
	    command = new Command("go", "east");
	    
	    processCommand(command);
	}
	
	private void south1 (MouseEvent evt) 
	{
	    command = new Command("go", "south");
	    
	    processCommand(command);
	}
	
	private void west1 (MouseEvent evt) 
	{
	    command = new Command("go", "west");
	    
	    processCommand(command);
	}
	
	private void english1 (MouseEvent evt) 
	{
		player = new Player("Default");
                player.setStarting(home);
                english = true;
                printWelcome();
                english1.setVisible(false);
                lietuviu1.setVisible(false);
                textarea1.setVisible(true);
	}
	
	private void lietuviu1 (MouseEvent evt) 
	{
		player = new Player("Paprastas");
                player.setStarting(namai);
                english = false;
                printLabas();
                english1.setVisible(false);
                lietuviu1.setVisible(false);
                textarea1.setVisible(true);
	}
	
	private void help1 (MouseEvent evt) 
	{
	    printHelp();
	    look();
	}

	private void back1 (MouseEvent evt) 
	{
	    if (english == true)
	    {
	        command = new Command("back", null);
	    }
	    else
	    {
	        command = new Command("atgal", null);
	    }
	    processCommand(command);
	    if(player.getCurrentRoom() == atlanticOcean||player.getCurrentRoom() == pacificOcean||player.getCurrentRoom() == indianOcean
	    ||player.getCurrentRoom() == europe||player.getCurrentRoom() == america||player.getCurrentRoom() == australia||player.getCurrentRoom() == asia
	    ||player.getCurrentRoom() == africa)
	    {
	        west1.setVisible(true);
	        south1.setVisible(true);
	        east1.setVisible(true);
	        explore1.setVisible(true);
	        north1.setVisible(true);
	        moonshine1.setVisible(false);
	        eat1.setVisible(false);
	        mudding1.setVisible(false);
	    }
	}

	private void take1 (MouseEvent evt) 
	{
		//grabArtifact();
                System.out.println();
                System.out.println("So far in you inventory you have " + player.seeInventory() );
	}

	private void teleport1 (MouseEvent evt) {
	    
	}

	public void generateMenu()
	{
		menuBar = new JMenuBar();

		JMenu game = new JMenu("Game");
		JMenu help = new JMenu("Help");

		JMenuItem newgame = new JMenuItem("New Game   ");
		JMenuItem exit = new JMenuItem("Exit   ");
		JMenuItem about = new JMenuItem("About   ");


		game.add(newgame);
		game.add(exit);
		help.add(about);

		menuBar.add(game);
		menuBar.add(help);
	}
	
	private void createRooms()
        {
            
            home = new Room (" home where you have your safe with precious artifacts", 0);
            namai = new Room (" namuose kur yra tavo seifas su tavo visais nuostabiais artifaktais", 0);
            
            pacificOcean = new Room("in Pacific Ocean", 0);
            ramusis = new Room ("Ramiajame Vandenyne", 0);
            
            atlanticOcean = new Room("in Atlantic Ocean", 0);
            atlantas = new Room ("Atlanto Vandenyne", 0);
            
            indianOcean = new Room("in Indian Ocean", 0);
            indijos = new Room ("Indijos Vandenyne", 0);
            
            america = new Room("in America", 0);
            amerika = new Room ("Amerikoje", 0);
            
            europe = new Room("in Europe", 0);
            europa = new Room ("Europoje", 0);
            
            australia = new Room("in Australia", 0);
            australija = new Room (" Australijoje", 0);
            
            asia = new Room("in Asia", 0);
            azija = new Room ("Azijoje", 0);
            
            africa = new Room("in Africa", 0);
            afrika = new Room ("Afrikoje", 0);
            
            explore = new Room("exploring the continent", 0);
            aplankyti = new Room ("žemyne", 0);
            
            divePacific = new Room("in a beautifull world of Ocean, so much to see!" +"\n" + "Watch out there's a shark next to the artifact, what do you do? ", 0);
            nertiRamusis = new Room("panėres po vandeniu, tiek daug grožio aplink!" +"\n" + " Atsargiai, ryklys prie artifakto kurio tu ieškai, ka tu darysi? ", 0);
            
            fight = new Room("in heaven." +"\n" + " Are you crazy to fight shark?! R.I.P.", 0);
            kovoti = new Room("rojuje." +"\n" + " Tu išprotejas kovoti su rykliu?! Ilsėkis ramybėje",0);
            
            diversion = new Room("alive." +"\n" + " That leftover chicken from lunch worked great as diversion!", 0);
            diversija = new Room("gyvas." +"\n" + " Vištienos likučiai kuriuos pasiemei nuo pietų padėjo!", 0);
            
            diveAtlantic = new Room("in a chilly dark cold water, why the hell you would come here?!" +"\n" + " That ice berg looks familliar!", 0);
            nertiAtlanta = new Room ("šaltame tamsiame vandenyje, kam tu čia atvykai?!" +"\n" + " Tas ledynas kazkur matytas!", 0);
            
            climbIce = new Room("on top of the Ice Berg," +"\n" + " there's nothing here," +"\n" + " but you know that there was enough space for Jack on that door!", 0);
            liptiLeda = new Room("ant ledyno viršaus," +"\n" + " čia nieko nėra," +"\n" + " bet tu vistiek žinai kad ten buvo pylna vietos Jakui ant tų durų!", 0);
            
            diveUnder = new Room("near Titanic," +"\n" + " now let's grab a piece of this sad history", 0);
            nertiPo = new Room("prie Titaniko," +"\n" + " dabar paimk gabalėli liudnos istorijos", 0);
            
            exploreAmerica = new Room("exploring the great continent", 0);
            aplankytiAmerika = new Room ("didžiajame žemyne", 0);
            
            mud = new Room ("enjoying baths of mud while driving your side-by-side!", 0);
            purvas = new Room ("kažkokiam purvyne su savo bagiu!", 0);
            
            moonshine = new Room ("too drunk buddy! You better stop drinking!", 0);
            naminuke = new Room ("prisigeres, juk sakiau negerti!", 0);
            
            eat = new Room ("hungry, but you lucked out," +"\n" + " there is In-n-Out franchise here!", 0);
            valgyti = new Room ("išalkes, bet tau pasisekė, netoli yra žymus In-n-Out restoranas!", 0);
            
            exploreEurope = new Room(" exploring old continent!", 0);
            aplankytiEuropa = new Room("senajame žemyne!", 0);
            
            drink = new Room("drinking with Russians.", 0);
            gerti = new Room("esi išprotėjas ir pradejai gerti su Rusais, sekmės.", 0);
            
            france = new Room("in France," +"\n" + " and it contains an artifact you were searching.", 0);
            prancuzija = new Room("Prancuzijoje," +"\n" + " tau pasisekė šį kartą, radai artifaktą.", 0);
            
            exploreAsia = new Room("exploring Asia," +"\n" + " so much to see on so much little time!", 0);
            aplankytiAzija = new Room("lankai Azijos žemyną." +"\n" + " Tiek daug pamatyti ir tiek mažai laiko!", 0);
            
            bathroom = new Room ("in the bathroom, all that traveling," +"\n" + " but no time for bathroom break." +"\n" + " Besides told you not to eat that rice," +"\n" + " because you will be sitting here for a while", 0);
            tuoletas = new Room("tuolete," +"\n" + " visos šios kelionės," +"\n" + " ir visai nera laiko nueiti į tuoletą." +"\n" + " Be to sakiau nevalgyti tų ryžių.", 0);
            
            wall = new Room ("visiting the Great Wall of China!", 0);
            siena = new Room("prie Kinijos Didžiosios sienos!", 0);
            
            exploreAustralia = new Room("exploring the beutiful but dangerous continent of" +"\n" + " Australia!", 0);
            aplankytiAustralija = new Room("Australijoje, toks gražus žemynas, bet taip pat toks pavojingas!", 0);
            
            box = new Room("in the fight with Kangaroo........." +"\n" + "Well atleast you had a nice nap " +"\n" + "and you are rested after that Kangaroo knocked you out", 0);
            boksuoti = new Room("ringe su Kengūra......." +"\n" + "Nu bent jau pamiegojai ramiai " +"\n" + "po to kai Kengūra tave išjungė!", 0);
            
            erwin = new Room("in the wildernes of Australia! " +"\n" + "Look what you found though!", 0);
            irvinas = new Room("Australijos laukynuose! " +"\n" + "Žiurėk kas ten.", 0);
            
            exploreAfrica = new Room("exploring great continent of Africa!", 0);
            aplankytiAfrika = new Room("milžiniškajame Afrikos žemyne!", 0);
            
            desert = new Room("in a middle of desert! " +"\n" + "It is freaking hot here. " +"\n" + "Why would you come here?! " +"\n" + "You might die! Oh wait......", 0);
            dykuma = new Room("viduryje dykumos. " +"\n" + "Nesuvokiamai karšta. " +"\n" + "Kaip tu čia sumastei atvykti. " +"\n" + "Gali būti kad mirsi. O žėk kas ten.......", 0);
            
            egypt = new Room("in Egypt, " +"\n" + "and you got attacked by mummy, " +"\n" + "now you are dead.....Come to Egypt they said....." +"\n" + "It will be fun they said!", 0);
            egiptas = new Room("Egipte, " +"\n" + "tave užpuolė mumija ir nužudė....." +"\n" + "Atvaryk į Egiptą jie sakė......." +"\n" + "Bus smagu, jie sakė!", 0);
            
            exploreIndia = new Room( "exploring Indian Ocean!", 0);
            aplankytiIndija = new Room("Indijos vandenyne!", 0);
            
            boat = new Room("exploring this sunken ship with British Empire logo, " +"\n" + "so that is where all the tea came from to England", 0);
            laivas = new Room("kažkokiame nuskendusiame laive su Didžiosios Britanijos emblema, " +"\n" + "tai va iš kur arbata atkeliavo į Anglija!", 0);
            
            shiny = new Room ("seeing something shiny down there, " +"\n" + "once you aproach closer " +"\n" + "you see that it is something that you were searching!", 0);
            blizgus = new Room("vandenyje ir matai kažka blizgaus, " +"\n" + "kai priartejei arčiau " +"\n" + "pamatei kad ten artifaktas kurio jau senai ieškojai savo kolekcijai!", 0);
            
            antarctica = new Room ("in Antarctica, " +"\n" + "you just froze into cartoonish cube, " +"\n" + "you are trapped, good job!!!", 0);
            antarktida = new Room("Antarktidoje, " +"\n" + "sušalai į kubą, šaunuolis, " +"\n" + "istrygai!", 0);
            
            golden = new Room ("near some golden city, " +"\n" + "but there is locked gate in front of it. " +"\n" + "Do you have key to open the gate? " +"\n" + "If you do type 'open gate' to see what's behind it!", 0);
            auksinis = new Room("prie kažkokio auksinio miesto, " +"\n" + "bet neina prie jo priartėt nes prieš tave yra užrakinti vartai. " +"\n" + "Ar turi raktą atrakinti šiuos vartus? " +"\n" + "Jei turi raktą parašyk 'atidaryti vartus' kad pamatytum kas ten per miestas!", 0);
            
            atlantis = new Room ("in lost city of Atlantis", 0);
            atlantida = new Room("dingusiame Atlantidos mieste", 0);
            
            teleport = new Room ("in some weird room, " +"\n" + "with a sign 'Do not press the button!' ......" +"\n" + "and ofcourse you pressed it........ " +"\n" + "well good luck......", 1);
            teleportuoti = new Room("kažkokiam keistam kambaryje, " +"\n" + "su ženklu 'Nespausk to mygtuko!'....." +"\n" + "ir žinoma tu paspaudei........." +"\n" + "sekmės.......", 1);
            
            // initialise room exits
            home.setExits("leave", america); //english version starts in america
            
            
            namai.setExits("iseiti", europa); //lithuanian version starts in europe
            
            
            pacificOcean.setExits("east", america);
            pacificOcean.setExits("south", australia);
            pacificOcean.setExits("west", asia);
            pacificOcean.setExits("explore", divePacific);
            divePacific.setExits("diversion", diversion);
            divePacific.setExits("fight", fight);
            diversion.setExits("continue", pacificOcean);
            diversion.addArtifact("kamikaze", "a recipe to a famous kamikaze drink!", 1);
            divePacific.setExits("cave", teleport);
            
            ramusis.setExits("rytus", amerika);
            ramusis.setExits("pietus", australija);
            ramusis.setExits("vakarus", azija);
            ramusis.setExits("lankyti", nertiRamusis);
            nertiRamusis.setExits("diversija", diversija);
            nertiRamusis.setExits("kovoti", kovoti);
            diversija.setExits("toliau", ramusis);
            diversija.addArtifact("kamikadze", "receptą, populiariam kamikazes gėrimui!",1);
            nertiRamusis.setExits("uolan", teleportuoti);
            
            atlanticOcean.setExits("east", europe);
            atlanticOcean.setExits("west", america);
            atlanticOcean.setExits("explore", diveAtlantic);
            diveAtlantic.setExits("climb", climbIce);
            diveAtlantic.setExits("dive", diveUnder);
            diveAtlantic.setExits("swim", golden);
            diveUnder.setExits("continue", atlanticOcean);
            diveUnder.addArtifact("titanic", "a piece of Titanic ship!", 5);
            golden.setExits("gate", atlantis);
            
            atlantas.setExits("rytus", europa);
            atlantas.setExits("vakarus", amerika);
            atlantas.setExits("lankyti", nertiAtlanta);
            nertiAtlanta.setExits("lipti", liptiLeda);
            nertiAtlanta.setExits("plaukiant", auksinis);
            nertiAtlanta.setExits("neriant", nertiPo);
            nertiPo.setExits("toliau", atlantas);
            nertiPo.addArtifact("titanikas", "gabalelį Titaniko laivo!", 5);
            auksinis.setExits("vartus", atlantida);
            
            america.setExits("east", atlanticOcean);
            america.setExits("west", pacificOcean);
            america.setExits("explore", exploreAmerica);
            america.setExits("south", antarctica);
            exploreAmerica.setExits("mudding", mud);
            exploreAmerica.setExits("moonshine", moonshine);
            moonshine.addArtifact("magic", "edible magic cookie which increases your capacity to carry stuff!", 2);
            exploreAmerica.setExits("eat", eat);
            moonshine.setExits("continue", exploreAmerica);
            eat.setExits("continue", america);
            eat.addArtifact("burger", "delicious In-n-Out Burger!", 3);
            
            
            amerika.setExits("rytus", atlantas);
            amerika.setExits("vakarus", ramusis);
            amerika.setExits("lankyti", aplankytiAmerika);
            amerika.setExits("pietus", antarktida);
            aplankytiAmerika.setExits("murzintis", purvas);
            aplankytiAmerika.setExits("prigerti", naminuke);
            naminuke.addArtifact("magija", "magišką sausainį, jį suvalgius tavo inventoriaus dydis padvigubėja!", 2);
            aplankytiAmerika.setExits("valgyti", valgyti);
            naminuke.setExits("toliau", aplankytiAmerika);
            valgyti.setExits("toliau", amerika);
            valgyti.addArtifact("burgeri", "skanų In-n-Out burgeriuką!", 3);
            
            europe.setExits("east", asia);
            europe.setExits("south", africa);
            europe.setExits("west", atlanticOcean);
            europe.setExits("explore", exploreEurope);
            exploreEurope.setExits("russia", drink);
            drink.addArtifact("key","golden key with Atlantis written on it!", 0);
            exploreEurope.setExits("france", france);
            drink.setExits("continue", europe);
            france.setExits("continue", europe);
            france.addArtifact("napoleon","lost Napoleon's high heels!", 3);
            
            europa.setExits("rytus", azija);
            europa.setExits("pietus", afrika);
            europa.setExits("vakarus", atlantas);
            europa.setExits("lankyti", aplankytiEuropa);
            aplankytiEuropa.setExits("rusijon", gerti);
            aplankytiEuropa.setExits("prancuzijon", prancuzija);
            prancuzija.setExits("toliau", europa);
            prancuzija.addArtifact("batus", "prarastus Napoleono aukštakulniai", 3);
            gerti.addArtifact("rakta", "auksini rakta su užrašu Atlantida!", 0);
            gerti.setExits("toliau", europa);
            
            asia.setExits("east", pacificOcean);
            asia.setExits("south", indianOcean);
            asia.setExits("west", europe);
            asia.setExits("explore", exploreAsia);
            exploreAsia.setExits("bathroom",bathroom);
            exploreAsia.setExits("wall", wall);
            wall.setExits("continue", asia);
            wall.addArtifact("made", "a cheap Chinese stuff with some strange writing on it which Translates to " + 
            "\"Made in China\"!", 2);
            
            azija.setExits("rytus", ramusis);
            azija.setExits("pietus", indijos);
            azija.setExits("vakarus", europa);
            azija.setExits("lankyti", aplankytiAzija);
            aplankytiAzija.setExits("tuoleta", tuoletas);
            aplankytiAzija.setExits("prie-sienos", siena);
            siena.setExits("toliau", azija);
            siena.addArtifact("padisofke", "kažkokį pigų šūdą su kažkokiom nesamonėm parašytom ant šono.....vetimas "+
            "\"Pagaminta Kinijoje\"",2);
            
            australia.setExits("north", asia);
            australia.setExits("east", pacificOcean);
            australia.setExits("west", indianOcean);
            australia.setExits("explore", exploreAustralia);
            exploreAustralia.setExits("box", box);
            exploreAustralia.setExits("swamps", erwin);
            erwin.setExits("continue", australia);
            erwin.addArtifact("steve", "Steve Erwin. Mate take a look at that croc!", 7);
            
            australija.setExits("siaure", azija);
            australija.setExits("rytus", ramusis);
            australija.setExits("vakarus", indijos);
            australija.setExits("lankyti", aplankytiAustralija);
            aplankytiAustralija.setExits("boksuotis", boksuoti);
            aplankytiAustralija.setExits("per-pelkes", irvinas);
            irvinas.setExits("toliau", australija);
            irvinas.addArtifact("styva", "Styva Irvina. Pažėk kas per krokodilas ten žmogau!", 7);
            
            africa.setExits("north", europe);
            africa.setExits("east", indianOcean);
            africa.setExits("west", atlanticOcean);
            africa.setExits("explore", exploreAfrica);
            exploreAfrica.setExits("desert", desert);
            exploreAfrica.setExits("egypt", egypt);
            desert.setExits("continue", africa);
            desert.addArtifact("oasis", " Oasis, atleast now you might surivive!", 10); 
            
            afrika.setExits("siaure", europa);
            afrika.setExits("rytus", indijos);
            afrika.setExits("vakarus", atlantas);
            afrika.setExits("lankyti", aplankytiAfrika);
            aplankytiAfrika.setExits("per-dykuma", dykuma);
            aplankytiAfrika.setExits("egiptan", egiptas);
            dykuma.setExits("toliau", afrika);
            dykuma.addArtifact("oaze", "Oazę, bent jau dabar tavo šancai išgyventi didesni!", 10);
            
            indianOcean.setExits("north", asia);
            indianOcean.setExits("east", australia);
            indianOcean.setExits("west", africa);
            indianOcean.setExits("dive", exploreIndia);
            exploreIndia.setExits("boat", boat);
            exploreIndia.setExits("shiny", shiny);
            shiny.setExits("continue", indianOcean);
            shiny.addArtifact("ghandi", "lost Ghandi's glasses", 2);
            
            indijos.setExits("siaure", azija);
            indijos.setExits("rytus", australija);
            indijos.setExits("vakarus", afrika);
            indijos.setExits("po-vandeniu", aplankytiIndija);
            aplankytiIndija.setExits("laivan", laivas);
            aplankytiIndija.setExits("prie-blizgucio", blizgus);
            blizgus.setExits("toliau", indijos);
            blizgus.addArtifact("akinukus", "prarastus Gandžio akinius", 2);
            
            
            
            
        }

        /**
         *  Main play routine.  Loops until end of play,
         *  creates new player with default name.
         */
        public void play() 
        {            
            BufferedWriter bw = null;
            chooseLanguage();
            
            FileWriter doc; 
            ArrayList userInput = new ArrayList();
            // Enter the main command loop.  Here we repeatedly read commands and
            // execute them until the game is over.
                    
            boolean finished = false;
            while (! finished) {
                
                Command command = parser.getCommand();
                
                
                
                if(command.hasSecondWord() == false)
                {
                    userInput.add(command.getCommandWord());
                }
                else if(command.hasSecondWord() == true)
                {
                    userInput.add(command.getCommandWord() + " " + command.getSecondWord());
                }
                else
                {
                    userInput.add(command.getSecondWord());
                }
                finished = processCommand(command);
                if(turns == 0)
                {
                    terminate();
                }
                
            }
            if(finished == true)
            {
                for (int j = 0; j < userInput.size(); j++)
                {
                    System.out.println(userInput.get(j));
                }
                try
                {
                    doc = new FileWriter("UserInputs.txt");
                    for (int i = 0; i<userInput.size(); i++)
                    {
                        bw.write(userInput.get(i).toString() + "\n");
                    }
                    doc.close();
                    
                }
                catch(IOException e)
                {
                    System.err.println("Error: " + e );
                }
                
            }
            System.out.println("Thank you for playing.  Good bye.");
        
        
        }
            /**
         * Given a command, process (that is: execute) the command.
         * @param command The command to be processed.
         * @return true If the command ends the game, false otherwise.
         */
        private boolean processCommand(Command command) 
        {
                boolean wantToQuit = false;
                String commandWord = command.getCommandWord();
                textarea1.setText(null);
                if (english == true)
                {
                        if(command.isUnknown()) {
                            System.out.println("I don't know what you mean...");
                            return false;
                        }
    
            
                        if (commandWord.equals("help")) {
                            printHelp();
                        }
                        else if (commandWord.equals("go")) {
                            if (player.getCurrentRoom() != golden)
                            {   
                                if (player.getCurrentRoom() != antarctica)
                                {
                    
                    
                                    if (turns > 0)
                                    {
                                        --turns;
                                        goRoom(command);
                                    }
                                    else 
                                    {
                                        --turns;
                                    }
                
                                }
                                else 
                                {
                                    System.out.println("You are trapped, you cannot go back!");
                                }
                            }
                        }
                        else if (commandWord.equals("quit")) {
                            wantToQuit = quit(command);
                        }
                        else if (commandWord.equals("look")) {
                            look();
                        }
                        else if (commandWord.equals("grab")) {
                            //grabArtifact(command);
                            System.out.println();
                            System.out.println("So far in you inventory you have " + player.seeInventory() );
                        }
                        else if (commandWord.equals("drop")) {
                            dropArtifact (command);
                            System.out.println();
                            System.out.println("Your inventory still contains " + player.seeInventory());
                        }
                        else if (commandWord.equals("back")) {
                            if (player.getCurrentRoom() != antarctica)
                            {
                
                                if (turns > 0)
                                {
                        
                                    --turns;
                                    player.goBack();
                                    System.out.println("You are " + player.getCurrentRoom().getDescription());
                                    look();
                    
                                }
                                else
                                {
                                    --turns;
                                }
                            }
                            else
                            {
                                System.out.println("You are trapped, you cannot go back!");
                            }
                        }
                        else if (commandWord.equals("eat")) {
                            eatCookie(command);
                        }
                        else if (commandWord.equals("save")) {
                            charge();
                        }
                        else if (commandWord.equals("load")) {
                            fire();
                        }
                        else if (commandWord.equals("open")) {
                            openGate(command);
                        }
                }
           
                //Lithuanian
                else 
                {
                    if(command.isUnknown()) {
                            System.out.println("Nesuprantu ką tu turi omenyje...");
                            
                            look();
                            return false;
                    }
    
            
                    if (commandWord.equals("pagalba")) {
                            printHelp();
                        }
                        else if (commandWord.equals("keliauti")) {
                        if (player.getCurrentRoom() != auksinis)
                        {
                            if (player.getCurrentRoom() != antarktida)
                            {
                    
                    
                                if (turns > 0)
                                {
                                    --turns;
                                    goRoom(command);
                                }
                                else 
                                {
                                    --turns;
                                }
                
                            }
                            else 
                            {
                                System.out.println("Tu įstriges, negali pajudėt");
                            }
                        }
                    }
                    else if (commandWord.equals("baigti")) {
                        wantToQuit = quit(command);
                    }
                    else if (commandWord.equals("ziureti")) {
                        look();
                    }
                    else if (commandWord.equals("paimti")) {
                        //grabArtifact(command);
                        System.out.println();
                        System.out.println("Kurpinei tu turi " + player.seeInventory() );
                    }
                    else if (commandWord.equals("padeti")) {
                        dropArtifact (command);
                        System.out.println();
                        System.out.println("Tavo kuprinei vis dar turi " + player.seeInventory());
                    }
                    else if (commandWord.equals("atgal")) {
                        if (player.getCurrentRoom() != antarktida)
                        {
                
                            if (turns > 0)
                            {
                        
                                --turns;
                                player.goBack();
                                System.out.println("Tu esi " + player.getCurrentRoom().getDescription());
                                look();
                    
                            }
                            else
                            {
                                --turns;
                            }
                        }
                        else
                        {
                            System.out.println("Tu įstriges, negali pajudėt!");
                        }
                    }
                    else if (commandWord.equals("valgyti")) {
                        eatCookie(command);
                    }
                    else if (commandWord.equals("ikrauti")) {
                        charge();
                    }
                    else if (commandWord.equals("iskrauti")) {
                        fire();
                    }
                    else if (commandWord.equals("atidaryti")) {
                        openGate(command);
                    }
                }
                if (commandWord.equals("english")) {
                    player = new Player("Default");
                    player.setStarting(home);
                    english = true;
                    printWelcome();
                    
                }
                else if (commandWord.equals("lietuviu")) {
                    player = new Player("Paprastas");
                    player.setStarting(namai);
                    english = false;
                    printLabas();
                    
                }
           
    
                return wantToQuit;
        }
        
        /**
         * Print out the opening message for the player.
         */
        private void chooseLanguage()
        {
            System.out.println("I see you are really really bored in order to start this game on your free time!");
            System.out.println();
            System.out.println("Choose your language");
            System.out.println("Type english for English!");
            System.out.println("Irašyk lietuviu kad žaisti Lietuviškai!");
            
        }
    
        /**
         * Print out the opening message for the player.
         */
        private void printWelcome()
        {
            textarea1.append(
            "*********************************************************"+"\n");
            textarea1.append("*************Welcome to the World of Zuul!***************"+"\n");
            textarea1.append("World of Zuul is a new, incredibly boring adventure game."+"\n");
            textarea1.append("*************Type 'help' if you need help.***************"+"\n");
            textarea1.append("---------------------------------------------------------"+"\n");
            textarea1.append("You have "+ turns + " turns to complete the task! Good Luck!"+"\n");
            textarea1.append("You are " + player.getCurrentRoom().getDescription()+"\n");
            look();
            english = true;
        }
        
        private void printLabas()
        {
            System.out.println("*********************************************************");
            System.out.println("*************Sveiki atvyke į Zuul žaidimą!****************");
            System.out.println("*****Zuulo pasaulis yra kito lygio neidomus žaidimas******");
            System.out.println("********Įrašyk 'pagalba' jeigu reikia pagalbos.***********");
            System.out.println("---------------------------------------------------------");
            System.out.println("Tau liko "+ turns + " ėjimų užbaigti žaidimą. Sekmės");
            System.out.println("Tu esi " + player.getCurrentRoom().getDescription());
            look();
            System.out.println();
            english = false;
        }
        
        /**
         * This method checks if there is an artifact in the room, and if there is artifact, it gives artifacts description,
         * if artifact name is magic , it gives different system out print than for the rest of artifacts.
         */
        private void artifactsInRoom()
        {
            ArrayList<String> artifacts = new ArrayList<>();
            artifacts = player.getCurrentRoom().artifactDescriptions();
            if(english==true)
            {
                for (String artifact : artifacts)
                {
                
                    for (Artifact cookie : player.getCurrentRoom().getArtifactList())
                    {
                        if (cookie.getArtifactName().equals("magic"))
                        {
                            System.out.println(artifact + " In order to eat this artifact type 'eat " + player.getCurrentRoom().artifactNames() + " ' without []") ;
                        }
                       
                        else
                        {
                            System.out.println(artifact + " In order to grab this artifact type 'grab " + player.getCurrentRoom().artifactNames() + " ' without []") ;
                        }
                    }
                
                }
            }
            else
            {
                for (String artifact : artifacts)
                {
                
                    for (Artifact cookie : player.getCurrentRoom().getArtifactList())
                    {
                        if (cookie.getArtifactName().equals("magija"))
                        {
                            System.out.println(artifact + "Kad suvalgytum šitą artifaktą irašyk 'valgyti " + player.getCurrentRoom().artifactNames() + " ' be []") ;
                        }
                       
                        else
                        {
                            System.out.println(artifact + "Kad paimtum šitą artifaktą irašyk 'paimti " + player.getCurrentRoom().artifactNames() + " ' be []") ;
                        }
                    }
                
                }
            }
        }
        
        /**
         * Method to save your game only,when method is called it gives message that it worked.
         * 
         */
        private void charge()
        {
            if(english == true)
            {
                
                    charging = currentRoom;
                    System.out.println("You succesfully saved your game, when you get in trouble just load your game by typing 'load' and you will get back to previous save");
                
               
            }
            else
            {
                
                
                    charging = currentRoom;
                    System.out.println("Tu sekmyngai išsaugojai savo žaidimą, kai noresi ikrauti prėjusi išsaugojimą, parašyk 'uzkrauti'");
                
               
            }
        }
        
        /**
         * This method checks does the player has beamer in his inventory, and if he does m player can fire it and it will 
         * send the player to the room where he charged the beamer.
         */
        private void fire()
        {
            if(english == true)
            {
                System.out.println("You succesfully loaded your previous save!");
                currentRoom = charging;
                
                System.out.println("You are " + player.getCurrentRoom().getDescription());
                look();
            }
            else
            {
                System.out.println("Tu sėkmyngai įkrovei praėjusi išsaugojimą!");
                currentRoom = charging;
            
                System.out.println("Tu esi " + player.getCurrentRoom().getDescription());
                look();
            
                
            }
        }
    
        /**
         * Print out some help information.
         * Here we print some stupid, cryptic message and a list of the 
         * command words.
         */
        private void printHelp() 
        {
            if(english == true)
            {
                textarea1.setText(null);
                textarea1.append("You wanderer who is searching for special artifacts"+"\n");
                textarea1.append("around the world."+"\n");
                look();
            }
            else
            {
                textarea1.setText(null);
                textarea1.append("Tu esi išprotėjas žmogus kuris ieškai artifaktų savo kolekcijai"+"\n");
                textarea1.append("aplink pasaulį."+"\n");
                look();
            }
        }
        
        /**
         * This method checks the rooms description, and gives directions where player can move, as well
         * if theres artifacts in the room it will print them.
         */
        private void look()
        {
            if(english == true)//English version
            {
                if (player.getCurrentRoom().getLongDescription().isEmpty())
                {
                   textarea1.append( player.getCurrentRoom().getLongDescription());
                }
                else 
                {
                    textarea1.append("Directions you can go: " + player.getCurrentRoom().getLongDescription());
                }
                if (player.getCurrentRoom().artifacts())
                {
                    textarea1.append("\n");
                    artifactsInRoom();
                }
            }
            else//Lithuanian version
            {
                if (player.getCurrentRoom().getLongDescription().isEmpty())
                {
                    textarea1.append(player.getCurrentRoom().getLongDescription());
                }
                else 
                {
                    textarea1.append("Pusės į kurias tu gali keliauti: " + player.getCurrentRoom().getLongDescription());
                }
                if (player.getCurrentRoom().artifacts())
                {
                    textarea1.append("\n");
                    artifactsInRoom();
                }
            }
        }
        
        
        /** 
         * Try to go in one direction. If there is an exit, enter
         * the new room and give how many turns left, otherwise print an error message. 
         */
        private void goRoom(Command command) 
        {
            if(english == true)
            {
                if(!command.hasSecondWord()) {
                    // if there is no second word, we don't know where to go...
                    textarea1.append("Go where?" +"\n");
                    return;
                }
    
                String direction = command.getSecondWord();
    
                // Try to leave current room.
                Room nextRoom = player.getCurrentRoom().getExit(direction);
          
                if (nextRoom == null) {
                    textarea1.append(command.getSecondWord() +  " is not a direction"+"\n");
                }
                else if (command.getSecondWord().equals("home"))
                {
                    nextRoom = home;
                    textarea1.append("You have " + turns + " turns left!"+"\n");
                }
                else {
                    player.setRoom(nextRoom);
                    textarea1.append("You have " + turns + " turns left!"+"\n");
                    textarea1.append(" You are " + player.getCurrentRoom().getDescription()+"\n");
                    look();
                
                }    
            }
            else
            {
                if(!command.hasSecondWord()) {
                    // if there is no second word, we don't know where to go...
                    textarea1.append("Kur eiti?" );
                    return;
                }
    
                String direction = command.getSecondWord();
    
                // Try to leave current room.
                Room nextRoom = player.getCurrentRoom().getExit(direction);
          
                if (nextRoom == null) {
                    textarea1.append(command.getSecondWord() +  " nėra pusė"+"\n");
                }
                else if (command.getSecondWord().equals("namai"))
                {
                    nextRoom = namai;
                    textarea1.append("Tau liko " + turns + " ėjimai!"+"\n");
                }
                else {
                    player.setRoom(nextRoom);
                    textarea1.append("Tau liko " + turns + " ėjimai!"+"\n");
                    textarea1.append("Tu esi " + player.getCurrentRoom().getDescription()+"\n");
                    look();
                
                } 
            }
        }
        
        /**
         * This method is for particular room only, for golden, whichs is atlantis gate,
         * if you have the key, you can open the gate and enter next room. 
         * @param command is instance of class Command
         */
        private void openGate(Command command)
        {
            if(english == true)
            {
                
                String direction = command.getSecondWord();
    
                Room nextRoom = player.getCurrentRoom().getExit(direction);
                if (command.getSecondWord().equals("gate"))    
                {
                    if (player.getKey() == true)
                    {
                        if (player.getCurrentRoom() == golden)
                        {
                            nextRoom = atlantis;
                            player.setRoom(nextRoom);
                            textarea1.append(" You are " + player.getCurrentRoom().getDescription()+"\n") ;
                
                            textarea1.append("You have " + turns + " turns left!");
            
                        }
                    }
                }
                else
                {
                    textarea1.append("I told you already, "+"\n"+"you need a key to open the gate. "+"\n"+"Are you listening to me!?");
                }
            }
            else 
            {
                  if(!command.hasSecondWord()) {
                    // if there is no second word, we don't know where to go...
                    textarea1.append("Atidaryti ką?" );
                    return;
                }
                String direction = command.getSecondWord();
    
                // Try to leave current room.
                Room nextRoom = player.getCurrentRoom().getExit(direction);
                if (command.getSecondWord().equals("vartus"))    
                {
                    if (player.getKey() == true)
                    {
                        if (player.getCurrentRoom() == auksinis)
                        {
                            nextRoom = atlantida;
                            player.setRoom(nextRoom);
                            textarea1.append("Tu esi " + player.getCurrentRoom().getDescription()+"\n") ;
                
                            textarea1.append("Tau liko " + turns + " ėjimai!");
            
                        }
                    }
                }
                else
                {
                    textarea1.append("Juk jau sakiau tau,"+"\n"+"jog turi turėti raktą kad atidarytum vartus!?");
                }
            }
        }
        
        /**
         * This method is for command eat, if player finds magic cookie in the room, then he is allowed to eat it for boost. 
         * @param command is instance of class Command.
         */
        private void eatCookie(Command command)
        {
            if (english == true)//English version
            {
                if(!command.hasSecondWord()) {
                    // if there is no second word, we don't know where to go...
                    textarea1.append("Eat what?");
                    return;
                }
            
                boolean found = false;
                String artifactName = command.getSecondWord();
    
                for (Artifact artifact : player.getCurrentRoom().getArtifactList())
                {
                    if (artifact.getArtifactName().equals(artifactName))
                    {
                        if (!(artifact.getWeight() == -1))
                        {
                            if (player.eatArtifact(artifact))
                            {
                                player.getCurrentRoom().removeArtifact(artifactName);
                                textarea1.append("You have succesfully ate an artifact "+"\n"+"your Carry Weight now is increased "+"\n");
                                textarea1.append("Type 'go continue' to go back exploring");
                                found = true;
                            }
                        }
                    }
            
                }
            }
            else //Lithuanian version
            {
                 if(!command.hasSecondWord()) {
                    // if there is no second word, we don't know where to go...
                    textarea1.append("Valgyti ką?");
                    return;
                }
            
                boolean found = false;
                String artifactName = command.getSecondWord();
    
                for (Artifact artifact : player.getCurrentRoom().getArtifactList())
                {
                    if (artifact.getArtifactName().equals(artifactName))
                    {
                        if (!(artifact.getWeight() == -1))
                        {
                            if (player.eatArtifact(artifact))
                            {
                                player.getCurrentRoom().removeArtifact(artifactName);
                                textarea1.append("Tu sėkmyngai suvalgei sausainį, "+"\n"+"tavo inventoriaus dydis padidėjo dvigubai"+"\n");
                                textarea1.append("Spausk toliau jog toliau testum savo žaidimą");
                                found = true;
                            }
                        }
                    }
            
                }
            }
        }
        
        /**
         * This method is used to grab artifacts in the rooms. If there is no artifact, this method will not work,
         * and it will give error message.
         * @param command is instance of class Command.
         */
        private void grabArtifact(Command command ) 
        {
            if(english == true)//English version
            {
                if(!command.hasSecondWord()) {
                    // if there is no second word, we don't know where to go...
                    textarea1.append("Grab what?");
                    return;
                }
            
                boolean found = false;
                String artifactName = command.getSecondWord();
    
                for (Artifact artifact : player.getCurrentRoom().getArtifactList())
                {
                    if (artifact.getArtifactName().equals(artifactName))
                    {
                        if (!(artifact.getWeight() == -1))
                        {
                            if (player.grabArtifact(artifact))
                            {
                                player.getCurrentRoom().removeArtifact(artifactName);
                                textarea1.append("You have succesfully grabbed an artifact"+"\n");
                                textarea1.append("Press continue to go back exploring");
                                found = true;
                                player.getKey();
                            
                            }
                            else 
                            {
                                textarea1.append("Your inventory is full, "+"\n"+"you need atleast " + artifact.getWeight() + " free space "+"\n"+"in order to grab this artifact." );
                                found = true;
                            }
                        }
                        else
                        {
                            textarea1.append("You fail to pick it up");
                            found = true;
                        }
                    }
                }
                if (!(found))
                {
                    textarea1.append(command.getSecondWord() + " is not in this room");
                }
            }
            else//Lithuanian version
            {
                if(!command.hasSecondWord()) {
                    // if there is no second word, we don't know where to go...
                    textarea1.append("Ką paimti?");
                    return;
                }
            
                boolean found = false;
                String artifactName = command.getSecondWord();
    
                for (Artifact artifact : player.getCurrentRoom().getArtifactList())
                {
                    if (artifact.getArtifactName().equals(artifactName))
                    {
                        if (!(artifact.getWeight() == -1))
                        {
                            if (player.grabArtifact(artifact))
                            {
                                player.getCurrentRoom().removeArtifact(artifactName);
                                textarea1.append("Tu sėkmyngai paimei artifaktą"+"\n");
                                textarea1.append("Įrašyk 'keliauti toliau' jog toliau testum savo žaidimą"+"\n");
                                found = true;
                                player.getKey();
                            
                            }
                            else 
                            {
                                textarea1.append("Tavo inventorius pylnas, "+"\n"+"jog galėtum paimti šį artifaktą, "+"\n"+"tau reikia turėti mažziausiai " + artifact.getWeight() + " laisvo vietos" );
                                found = true;
                            }
                        }
                        else
                        {
                            textarea1.append("Tau nepavyko paimti");
                            found = true;
                        }
                    }
                }
                if (!(found))
                {
                    textarea1.append(command.getSecondWord() + " nėra šiame kambaryje");
                }
            }
        }
        
        /**
         *Checks is the version of the game is english or Lithuanian
         *@return english for boolean
         */
        public static boolean english()
        {
            return english;
        }
        
        /**
         * This method is to drop afound artifacts from your inventory. If player does not have that artifact, message will come up.
         * @param command is instance of class Command
         */
        private void dropArtifact(Command command) 
        {
            if(english==true)
            {
                if(!command.hasSecondWord()) {
                    // if there is no second word, we don't know where to go...
                    textarea1.append("Drop what?");
                    return;
                }
            
            
                String artifactName = command.getSecondWord();
    
                if (player.findArtifact(artifactName)) {
                    player.getCurrentRoom().placeArtifact(player.dropArtifact(artifactName));
                }
                else {
                    textarea1.append("The player does not have that item");
                }
            }
            else 
            {
                 if(!command.hasSecondWord()) {
                    // if there is no second word, we don't know where to go...
                    textarea1.append("Padėti ką?");
                    return;
                }
            
            
                String artifactName = command.getSecondWord();
    
                if (player.findArtifact(artifactName)) {
                    player.getCurrentRoom().placeArtifact(player.dropArtifact(artifactName));
                }
                else {
                    textarea1.append("Tu neturi to artifakto.");
                }
            }
        }
        
        /** 
         * "Quit" was entered. Check the rest of the command to see
         * whether we really quit the game.
         * @return true, if this command quits the game, false otherwise.
         */
        private boolean quit(Command command) 
        {
            if (english==true)
            {
                if(command.hasSecondWord()) {
                    textarea1.append("Quit what?");
                    return false;
                }
                else {
                    return true;  // signal that we want to quit
                }
            }
            else
            {
                  if(command.hasSecondWord()) {
                    textarea1.append("Baigti ką?");
                    return false;
                }
                else {
                    return true;  // signal that we want to quit
                }
            }
        }
        
        /**
         * This method prints out whole inventory for the person.
         */
        private void printInventory()
        {
            System.out.println(player.seeInventory());
        }
        
        /**
         * This method terminates whole terminal if player runs out of the moves.
         */
        private  void terminate()
        {
           if(english==true)
           {
                textarea1.append("You ran out of turns! GAME OVER!");
                System.exit(0);
           }
           else
           {
               textarea1.append("Tavo ėjimai pasibaigė! ŽAIDIMO PABAIGA!");
                System.exit(0);
           }
        }
        
        public void appendText(String string)
        {
            textarea1.append(string);
        }
    
    	 public static void main(String[] args){
    		System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
    		javax.swing.SwingUtilities.invokeLater(new Runnable() {
    			public void run() {
    				new GUI();
    			}
    		});
    	}

}