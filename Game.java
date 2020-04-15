import java.util.ArrayList;
import java.util.Stack;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Iterator;
import java.io.*;
import java.util.*;
/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. Grabs artifacts. Explores and etc.
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser, creates player and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Donatas Vasauskas
 * @version 2019.12.11-01
 */

public class Game 
{
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
    
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        turns = 30;
    }
  
    /**
     * Create all the rooms and link their exits together, add the artifacts to the rooms. 
     */
    private void createRooms()
    {
        //ramusis, atlantas, indijos, europa, amerika, australija, azija, afrika, aplankyti, nerti, diversija, nertiRamusis, nertiAtlanta, liptiLeda, nertiPo, aplankytiAmerika,
    //purvas, naminuke, valgyti, aplankytiEuropa, gerti, prancuzija, aplankytiAzija, tuoletas, siena, aplankytiAustralija, boksuoti, irvinas, aplankytiAfrika, dykuma, egiptas, aplankytiIndija, laivas, blizgus, namai,
    //antarktida, atlantida, auksinis, teleportuoti;
        // create the rooms
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
        
        divePacific = new Room("in a beautifull world of Ocean, so much to see! Watch out there's a shark next to the artifact, what do you do? ", 0);
        nertiRamusis = new Room("panėres po vandeniu, tiek daug grožio aplink! Atsargiai, ryklys prie artifakto kurio tu ieškai, ka tu darysi? ", 0);
        
        fight = new Room("in heaven. Are you crazy to fight shark?! R.I.P.", 0);
        kovoti = new Room("rojuje. Tu išprotejas kovoti su rykliu?! Ilsėkis ramybėje",0);
        
        diversion = new Room("alive. That leftover chicken from lunch worked great as diversion!", 0);
        diversija = new Room("gyvas. Vištienos likučiai kuriuos pasiemei nuo pietų padėjo!", 0);
        
        diveAtlantic = new Room("in a chilly dark cold water, why the hell you would come here?! That ice berg looks familliar!", 0);
        nertiAtlanta = new Room ("šaltame tamsiame vandenyje, kam tu čia atvykai?! Tas ledynas kazkur matytas!", 0);
        
        climbIce = new Room("on top of the Ice Berg, there's nothing here, but you know that there was enough space for Jack on that door!", 0);
        liptiLeda = new Room("ant ledyno viršaus, čia nieko nėraw, bet tu vistiek žinai kad ten buvo pylna vietos Jakui ant tų durų!", 0);
        
        diveUnder = new Room("near Titanic, now let's grab a piece of this sad history", 0);
        nertiPo = new Room("prie Titaniko, dabar paimk gabalėli liudnos istorijos", 0);
        
        exploreAmerica = new Room("exploring the great continent", 0);
        aplankytiAmerika = new Room ("didžiajame žemyne", 0);
        
        mud = new Room ("enjoying baths of mud while driving your side-by-side!", 0);
        purvas = new Room ("kažkokiam purvyne su savo bagiu!", 0);
        
        moonshine = new Room ("too drunk buddy! You better stop drinking!", 0);
        naminuke = new Room ("prisigeres, juk sakiau negerti!", 0);
        
        eat = new Room ("hungry, but you lucked out, there is In-n-Out franchise here!", 0);
        valgyti = new Room ("išalkes, bet tau pasisekė, netoli yra žymus In-n-Out restoranas!", 0);
        
        exploreEurope = new Room(" exploring old continent!", 0);
        aplankytiEuropa = new Room("senajame žemyne!", 0);
        
        drink = new Room("drinking with Russians.", 0);
        gerti = new Room("esi išprotėjas ir pradejai gerti su Rusais, sekmės.", 0);
        
        france = new Room("in France, and it contains an artifact you were searching.", 0);
        prancuzija = new Room("Prancuzijoje, tau pasisekė šį kartą, radai artifaktą.", 0);
        
        exploreAsia = new Room("exploring Asia, so much to see on so much little time!", 0);
        aplankytiAzija = new Room("lankai Azijos žemyną. Tiek daug pamatyti ir tiek mažai laiko!", 0);
        
        bathroom = new Room ("in the bathroom, all that traveling, but no time for bathroom break. Besides told you not to eat that rice, because you will be sitting here for a while", 0);
        tuoletas = new Room("tuolete, visos šios kelionės, ir visai nera laiko nueiti į tuoletą. Be to sakiau nevalgyti tų ryžių.", 0);
        
        wall = new Room ("visiting the Great Wall of China!", 0);
        siena = new Room("prie Kinijos Didžiosios sienos!", 0);
        
        exploreAustralia = new Room("exploring the beutiful but dangerous continent of Australia!", 0);
        aplankytiAustralija = new Room("Australijoje, toks gražus žemynas, bet taip pat toks pavojingas!", 0);
        
        box = new Room("in the fight with Kangaroo.........Well atleast you had a nice nap and you are rested after that Kangaroo knocked you out", 0);
        boksuoti = new Room("ringe su Kengūra.......Nu bent jau pamiegojai ramiai po to kai Kengūra tave išjungė!", 0);
        
        erwin = new Room("in the wildernes of Australia! Look what you found though!", 0);
        irvinas = new Room("Australijos laukynuose! Žiurėk kas ten.", 0);
        
        exploreAfrica = new Room("exploring great continent of Africa!", 0);
        aplankytiAfrika = new Room("milžiniškajame Afrikos žemyne!", 0);
        
        desert = new Room("in a middle of desert! It is freaking hot here. Why would you come here?! You might die! Oh wait......", 0);
        dykuma = new Room("viduryje dykumos. Nesuvokiamai karšta. Kaip tu čia sumastei atvykti. Gali būti kad mirsi. O žėk kas ten.......", 0);
        
        egypt = new Room("in Egypt, and you got attacked by mummy, now you are dead.....Come to Egypt they said.....It will be fun they said!", 0);
        egiptas = new Room("Egipte, tave užpuolė mumija ir nužudė.....Atvaryk į Egiptą jie sakė.......Bus smagu, jie sakė!", 0);
        
        exploreIndia = new Room( "exploring Indian Ocean!", 0);
        aplankytiIndija = new Room("Indijos vandenyne!", 0);
        
        boat = new Room("exploring this sunken ship with British Empire logo, so that is where all the tea came from to England", 0);
        laivas = new Room("kažkokiame nuskendusiame laive su Didžiosios Britanijos emblema, tai va iš kur arbata atkeliavo į Anglija!", 0);
        
        shiny = new Room ("seeing something shiny down there, once you aproach closer you see that it is something that you were searching!", 0);
        blizgus = new Room("vandenyje ir matai kažka blizgaus, kai priartejei arčiau pamatei kad ten artifaktas kurio jau senai ieškojai savo kolekcijai!", 0);
        
        antarctica = new Room ("in Antarctica, you just froze into cartoonish cube, you are trapped, good job!!!", 0);
        antarktida = new Room("Antarktidoje, sušalai į kubą, šaunuolis, istrygai!", 0);
        
        golden = new Room ("near some golden city, but there is locked gate in front of it. Do you have key to open the gate? If you do type 'open gate' to see what's behind it!", 0);
        auksinis = new Room("prie kažkokio auksinio miesto, bet neina prie jo priartėt nes prieš tave yra užrakinti vartai. Ar turi raktą atrakinti šiuos vartus? Jei turi raktą parašyk 'atidaryti vartus' kad pamatytum kas ten per miestas!", 0);
        
        atlantis = new Room ("in lost city of Atlantis", 0);
        atlantida = new Room("dingusiame Atlantidos mieste", 0);
        
        teleport = new Room ("in some weird room, with a sign 'Do not press the button!' ......and ofcourse you pressed it........ well good luck......", 1);
        teleportuoti = new Room("kažkokiam keistam kambaryje, su ženklu 'Nespausk to mygtuko!'.....ir žinoma tu paspaudei.........sekmės.......", 1);
        
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
            System.out.print('\u000C');
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
                        grabArtifact(command);
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
                    grabArtifact(command);
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
        
        System.out.println("*********************************************************");
        System.out.println("*************Welcome to the World of Zuul!***************");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("*************Type 'help' if you need help.***************");
        System.out.println("---------------------------------------------------------");
        System.out.println("You have "+ turns + " turns to complete the task! Good Luck!");
        System.out.println("You are " + player.getCurrentRoom().getDescription());
        look();
        System.out.println();
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
            System.out.println("You wanderer who is searching for special artifacts");
            System.out.println("around the world.");
            System.out.println();
            System.out.println("Your command words are:");
            System.out.println(parser.showCommands());
        }
        else
        {
            System.out.println("Tu esi išprotėjas žmogus kuris ieškai artifaktų savo kolekcijai");
            System.out.println("aplink pasaulį.");
            System.out.println();
            System.out.println("Tavo komandos yra:");
            System.out.println(parser.showCommands());
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
                System.out.println( player.getCurrentRoom().getLongDescription());
            }
            else 
            {
                System.out.println("Directions you can go: " + player.getCurrentRoom().getLongDescription());
            }
            if (player.getCurrentRoom().artifacts())
            {
                System.out.println("");
                artifactsInRoom();
            }
        }
        else//Lithuanian version
        {
            if (player.getCurrentRoom().getLongDescription().isEmpty())
            {
                System.out.println( player.getCurrentRoom().getLongDescription());
            }
            else 
            {
                System.out.println("Pusės į kurias tu gali keliauti: " + player.getCurrentRoom().getLongDescription());
            }
            if (player.getCurrentRoom().artifacts())
            {
                System.out.println("");
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
                System.out.println("Go where?" );
                return;
            }

            String direction = command.getSecondWord();

            // Try to leave current room.
            Room nextRoom = player.getCurrentRoom().getExit(direction);
      
            if (nextRoom == null) {
                System.out.println(command.getSecondWord() +  " is not a direction");
            }
            else if (command.getSecondWord().equals("home"))
            {
                nextRoom = home;
                System.out.println("You have " + turns + " turns left!");
            }
            else {
                player.setRoom(nextRoom);
                System.out.println("You have " + turns + " turns left!");
                System.out.println(" You are " + player.getCurrentRoom().getDescription());
                look();
            
            }    
        }
        else
        {
            if(!command.hasSecondWord()) {
                // if there is no second word, we don't know where to go...
                System.out.println("Kur eiti?" );
                return;
            }

            String direction = command.getSecondWord();

            // Try to leave current room.
            Room nextRoom = player.getCurrentRoom().getExit(direction);
      
            if (nextRoom == null) {
                System.out.println(command.getSecondWord() +  " nėra pusė");
            }
            else if (command.getSecondWord().equals("namai"))
            {
                nextRoom = namai;
                System.out.println("Tau liko " + turns + " ėjimai!");
            }
            else {
                player.setRoom(nextRoom);
                System.out.println("Tau liko " + turns + " ėjimai!");
                System.out.println("Tu esi " + player.getCurrentRoom().getDescription());
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
            if(!command.hasSecondWord()) {
                // if there is no second word, we don't know where to go...
                System.out.println("Open what?" );
                return;
            }
            String direction = command.getSecondWord();

            // Try to leave current room.
            Room nextRoom = player.getCurrentRoom().getExit(direction);
            if (command.getSecondWord().equals("gate"))    
            {
                if (player.getKey() == true)
                {
                    if (player.getCurrentRoom() == golden)
                    {
                        nextRoom = atlantis;
                        player.setRoom(nextRoom);
                        System.out.println(" You are " + player.getCurrentRoom().getDescription()) ;
            
                        System.out.println("You have " + turns + " turns left!");
        
                    }
                }
            }
            else
            {
                System.out.println("I told you already, you need a key to open the gate. Are you listening to me!?");
            }
        }
        else 
        {
              if(!command.hasSecondWord()) {
                // if there is no second word, we don't know where to go...
                System.out.println("Atidaryti ką?" );
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
                        System.out.println("Tu esi " + player.getCurrentRoom().getDescription()) ;
            
                        System.out.println("Tau liko " + turns + " ėjimai!");
        
                    }
                }
            }
            else
            {
                System.out.println("Juk jau sakiau tau, jog turi turėti raktą kad atidarytum vartus!?");
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
                System.out.println("Eat what?");
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
                            System.out.println("You have succesfully ate an artifact your Carry Weight now is increased ");
                            System.out.println("Type 'go continue' to go back exploring");
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
                System.out.println("Valgyti ką?");
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
                            System.out.println("Tu sėkmyngai suvalgei sausainį, tavo inventoriaus dydis padidėjo dvigubai");
                            System.out.println("Įrašyk 'keliauti toliau' jog toliau testum savo žaidimą");
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
    private void grabArtifact(Command command) 
    {
        if(english == true)//English version
        {
            if(!command.hasSecondWord()) {
                // if there is no second word, we don't know where to go...
                System.out.println("Grab what?");
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
                            System.out.println("You have succesfully grabbed an artifact");
                            System.out.println("Type 'go continue' to go back exploring");
                            found = true;
                            player.getKey();
                        
                        }
                        else 
                        {
                            System.out.print("Your inventory is full, you need atleast " + artifact.getWeight() + " free space in order to grab this artifact." );
                            found = true;
                        }
                    }
                    else
                    {
                        System.out.println("You fail to pick it up");
                        found = true;
                    }
                }
            }
            if (!(found))
            {
                System.out.println(command.getSecondWord() + " is not in this room");
            }
        }
        else//Lithuanian version
        {
            if(!command.hasSecondWord()) {
                // if there is no second word, we don't know where to go...
                System.out.println("Ką paimti?");
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
                            System.out.println("Tu sėkmyngai paimei artifaktą");
                            System.out.println("Įrašyk 'keliauti toliau' jog toliau testum savo žaidimą");
                            found = true;
                            player.getKey();
                        
                        }
                        else 
                        {
                            System.out.print("Tavo inventorius pylnas, jog galėtum paimti šį artifaktą, tau reikia turėti mažziausiai " + artifact.getWeight() + " laisvo vietos" );
                            found = true;
                        }
                    }
                    else
                    {
                        System.out.println("Tau nepavyko paimti");
                        found = true;
                    }
                }
            }
            if (!(found))
            {
                System.out.println(command.getSecondWord() + " nėra šiame kambaryje");
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
                System.out.println("Drop what?");
                return;
            }
        
        
            String artifactName = command.getSecondWord();

            if (player.findArtifact(artifactName)) {
                player.getCurrentRoom().placeArtifact(player.dropArtifact(artifactName));
            }
            else {
                System.out.print("The player does not have that item");
            }
        }
        else 
        {
             if(!command.hasSecondWord()) {
                // if there is no second word, we don't know where to go...
                System.out.println("Padėti ką?");
                return;
            }
        
        
            String artifactName = command.getSecondWord();

            if (player.findArtifact(artifactName)) {
                player.getCurrentRoom().placeArtifact(player.dropArtifact(artifactName));
            }
            else {
                System.out.print("Tu neturi to artifakto.");
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
                System.out.println("Quit what?");
                return false;
            }
            else {
                return true;  // signal that we want to quit
            }
        }
        else
        {
              if(command.hasSecondWord()) {
                System.out.println("Baigti ką?");
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
            System.out.println("You ran out of turns! GAME OVER!");
            System.exit(0);
       }
       else
       {
           System.out.println("Tavo ėjimai pasibaigė! ŽAIDIMO PABAIGA!");
            System.exit(0);
       }
    }
}
