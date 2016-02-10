package FinancialPlanningPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.NumberFormat;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class RamkaProgramu{
	
  JFrame ramka = new JFrame();
  
  Wymiary wymiary = new Wymiary();
  
  JPanel panelGlowny = new JPanel();
  JPanel panelBoczny = new JPanel();
  JPanel panelDolny = new JPanel();
  JButton przycisk = new JButton();
  
  JRadioButton kobieta = new JRadioButton();
  JRadioButton mezczyzna = new JRadioButton();
  JRadioButton ofeTak = new JRadioButton();
  JRadioButton ofeNie = new JRadioButton();
  
  ButtonGroup grupaPlec = new ButtonGroup();
  ButtonGroup grupaOFE = new ButtonGroup();
  
  OpisPola plec = new OpisPola();
  OpisPola opisWieku = new OpisPola();
  OpisPola opisPensji = new OpisPola();
  OpisPola opisWiekuEmer = new OpisPola();
  OpisPola opisPracy = new OpisPola();
  OpisPola opisSPensji = new OpisPola();
  OpisPola opisOFE = new OpisPola();
  OpisPola opisPodsumowania1 = new OpisPola();
  OpisPola opisPodsumowania2 = new OpisPola();
  OpisPola opisPodsumowania3 = new OpisPola();
  OpisPola opisPodsumowania4 = new OpisPola();
  OpisPola opisPodsumowania5 = new OpisPola();
  
  PoleTextu poleWieku = new PoleTextu();
  PoleTextu polePensji = new PoleTextu();
  PoleTextu poleWiekuEmer = new PoleTextu();
  PoleTextu polePracy = new PoleTextu();
  PoleTextu poleSPensji = new PoleTextu();
  
  JTextField podsumowanie = new JTextField();
  
  Border lewa;
  Border prawa;
  Border dolna;
  TitledBorder lewa1;
  TitledBorder prawa1;
  TitledBorder dolna1;
  
  InputData inputData = new InputData();
  NumberFormat nf = NumberFormat.getNumberInstance();
  
  boolean plecKM = false;
  boolean wiek = false;
  boolean pensja = false;
  boolean wiekEmer = false;
  boolean sPensja = false;
  boolean lataPracy = false;
  
  final int progRocznyS = 85300;
  final double skladkaZUS = 0.1222D;
  final double skladkaSubkonto = 0.073D;
  final double skladkaSubkontoPomniejszone = 0.0438D;
  final double skladkaOFE = 0.0292D;
  final int progRocznyN = 121650;
  final double wzrostPensji = 0.015D;
  final int miesiace = 12;
  
  double wynik = 0.0D;
  double staraSkladkaZUS = 0.0D;
  double nowaSkladkaZUS = 0.0D;
  double staraSkladkaSubkonto = 0.0D;
  double nowaSkladkaSubkonto = 0.0D;
  double staraSkladkaOFE = 0.0D;
  double nowaSkladkaOFE = 0.0D;
  double roczneWynagrodzenieS = 0.0D;
  double roczneWynagrodzenieN = 0.0D;
  
  int staz = 0;
  
  final double dalszeTrwanieZycia = 18.2D;
  final double rocznyWzrostZycia = 0.2D;
  double kapital = 0.0D;
  double miesiaceEmerytury = 0.0D;
  double prognozowanaEmerytura = 0.0D;
  double prognozowanaEmeryturaNetto = 0.0D;
  double zrewaloryzowanaNowaSkladkaZUS = 0.0D;
  double zrewaloryzowanaNowaSkladkaSubkonto = 0.0D;
  double zrewaloryzowanaNowaSkladkaOFE = 0.0D;
  
  final double stareRoczneOprocentowanieZUS = 0.045D;
  final double stareRoczneOprocentowanieSubkonto = 0.055D;
  final double stareRoczneOprocentowanieOFE = 0.065D;
  final double noweRoczneOprocentowanieZUS = 0.035D;
  final double noweRoczneOprocentowanieSubkonto = 0.045D;
  final double noweRoczneOprocentowanieOFE = 0.055D;
  
  int x = 0;
  URL url = RamkaProgramu.class.getResource("icon.png");
  
  public RamkaProgramu()
  {
    ramka.setAlwaysOnTop(false);
    ramka.setDefaultCloseOperation(3);
    ramka.setResizable(false);
    ramka.setTitle("Symulacja_Hipotetycznej_Emerytury_v1.0.0");
    ramka.setIconImage(new ImageIcon(url).getImage());
    ramka.setPreferredSize(new Dimension(wymiary.getSzerokoscRamkiINT(), wymiary.getWysokoscRamkiINT()));
    ramka.setLocation(wymiary.getPolozenieRamkiSINT(), wymiary.getPolozenieRamkiWINT());
    ramka.setLayout(new BorderLayout());
    
    lewa = BorderFactory.createEtchedBorder(1);
    lewa1 = BorderFactory.createTitledBorder(lewa, "Informacje obowiązkowe");
    lewa1.setTitleJustification(2);
    
    prawa = BorderFactory.createEtchedBorder(1);
    prawa1 = BorderFactory.createTitledBorder(prawa, "Informacje dodatkowe");
    prawa1.setTitleJustification(2);
    
    dolna = BorderFactory.createEtchedBorder(1);
    dolna1 = BorderFactory.createTitledBorder(prawa, "Zasady działania i podsumowanie");
    dolna1.setTitleJustification(2);
    
    panelGlowny.setPreferredSize(new Dimension(wymiary.getszerokoscPaneluPLINT(), wymiary.getwysokoscPaneluPLINT()));
    panelGlowny.setLayout(new BoxLayout(panelGlowny, 1));
    panelGlowny.setBorder(lewa1);
    
    panelBoczny.setPreferredSize(new Dimension(wymiary.getszerokoscPaneluPLINT(), wymiary.getwysokoscPaneluPLINT()));
    panelBoczny.setLayout(new BoxLayout(panelBoczny, 1));
    panelBoczny.setBorder(prawa1);
    
    panelDolny.setPreferredSize(new Dimension(wymiary.getSzerokoscRamkiINT(), wymiary.getwysokoscPaneluDINT()));
    panelDolny.setLayout(new BoxLayout(panelDolny, 1));
    panelDolny.setBorder(dolna1);
    
    plec.setText("Wybierz swoją płeć:");
    plec.setToolTipText("Rodzaj płci pozwoli wyliczyć możliwy wiek przejścia na emeryturę.");
    plec.setAlignmentX(0.0F);
    
    opisWieku.setText("Podaj swój aktualny wiek w latach:");
    opisWieku.setToolTipText("Aktualny wiek pozwala wyliczyć liczbe lat pracujących i składkowych itp.");
    opisWieku.setAlignmentX(0.0F);
    
    opisPensji.setText("Podaj wysokość swojej miesięcznej pensji BRUTTO w PLN:");
    opisPensji.setToolTipText("Wysokość pensji jest podstawą do wyliczenia twoich finansów.");
    opisPensji.setAlignmentX(0.0F);
    
    opisWiekuEmer.setText("Podaj planowany wiek przejścia na emeryturę:");
    opisWiekuEmer.setToolTipText("Wiek przejścia na emeryturę pozwala wyliczyć liczbe lat pracujących i składkowych itp.");
    opisWiekuEmer.setAlignmentX(0.0F);
    
    opisPracy.setText("Podaj liczbę lat pracy do dnia dzisiejszego od 1 stycznia 1999 roku:");
    opisPracy.setToolTipText("Lata dotychczasowej pracy pozwalają wyliczyć liczbe lat pracujących i składkowych itp.");
    opisPracy.setAlignmentX(0.0F);
    
    opisSPensji.setText("Podaj uśrednioną wysokość dotychczasowej miesięcznej pensji BRUTTO w PLN:");
    opisSPensji.setToolTipText("Wysokość pensji jest podstawą do wyliczenia twoich finansów.");
    opisSPensji.setAlignmentX(0.0F);
    
    opisOFE.setText("Czy odprowadzasz część swoich składek do OFE?");
    opisOFE.setToolTipText("Jeżli nie wysyłałeś informacji do ZUS wybierz 'Nie'.");
    opisOFE.setAlignmentX(0.0F);
    
    opisPodsumowania1.setText("Program przedstawia wysokość hipotetycznej 'pełnej' emerytury z uwzględnieniem uśrednionych wartości dla wszystkich wskaźników.");
    opisPodsumowania1.setAlignmentX(0.0F);
    opisPodsumowania2.setText("Przeznaczony dla osób, które swoją pracę zaczęły po 1 stycznia 1999 roku na podstawie umowy o pracę i nie zaliczają się do uprzywilejowanych grup społecznych.");
    opisPodsumowania2.setAlignmentX(0.0F);
    opisPodsumowania3.setText("Opiera się na zasadch powrotu do wcześniejszego progu przejścia na emeryturę (Kobiety - 60 lat, Mężczyźni - 65 lat), nadchodzącej nowelizacji ustawy.");
    opisPodsumowania3.setAlignmentX(0.0F);
    opisPodsumowania4.setText("Wyniki symulacji należy przyjąć z dużą dozą ostrożności, gdyż jak każda symulacja na wiele lat naprzód jest obarczona znacznym marginesem błędu.");
    opisPodsumowania4.setAlignmentX(0.0F);
    opisPodsumowania5.setText("Niemniej jednak wiedza o przybliźonej prognozowanej wilekości emerytury pozwoli lepiej przygotować się na przyszłość.");
    opisPodsumowania5.setAlignmentX(0.0F);
    
    podsumowanie.setEditable(false);
    podsumowanie.setAlignmentX(0.0F);
    podsumowanie.setPreferredSize(new Dimension(wymiary.getSzerokoscRamkiINT(), wymiary.getWymiarLabelWINT()));
    podsumowanie.setBackground(Color.WHITE);
    podsumowanie.setFont(new Font("Verdana", 1, wymiary.getRozmiarCzcionkiINT()));
    podsumowanie.setForeground(Color.BLACK);
    podsumowanie.setText("Wprowadź poprawne dane w puste pola.");
    
    poleWieku.setToolTipText("Liczba pełnych lat od 16.");
    poleWieku.setAlignmentX(0.5F);
    
    polePensji.setToolTipText("Wartość pensji w zaokrągleniu do pełnych jedności.");
    polePensji.setAlignmentX(0.5F);
    
    poleWiekuEmer.setToolTipText("Liczba pełnych lat >= 60 dla Kobiet lub >= 65 dla Mężczyzn oraz wyższy od aktualnego wieku.");
    poleWiekuEmer.setAlignmentX(0.5F);
    
    polePracy.setToolTipText("Liczba pełnych lat (nie więcej niż 16 lat).");
    polePracy.setAlignmentX(0.5F);
    
    poleSPensji.setToolTipText("Wartość pensji w zaokrągleniu do pełnych jedności.");
    poleSPensji.setAlignmentX(0.5F);
    
    ofeTak.setMnemonic(66);
    ofeTak.setSelected(false);
    ofeTak.setEnabled(true);
    ofeTak.setBorder(null);
    ofeTak.setBorderPainted(false);
    ofeTak.setOpaque(false);
    ofeTak.setForeground(Color.BLACK);
    ofeTak.setFont(new Font("SanSerif", 0, wymiary.getRozmiarCzcionkiINT()));
    ofeTak.setText("Tak");
    
    ofeNie.setMnemonic(66);
    ofeNie.setSelected(true);
    ofeNie.setEnabled(true);
    ofeNie.setBorder(null);
    ofeNie.setBorderPainted(false);
    ofeNie.setOpaque(false);
    ofeNie.setForeground(Color.BLACK);
    ofeNie.setFont(new Font("SanSerif", 0, wymiary.getRozmiarCzcionkiINT()));
    ofeNie.setText("Nie");
    
    kobieta.setMnemonic(66);
    kobieta.setSelected(false);
    kobieta.setEnabled(true);
    kobieta.setBorder(null);
    kobieta.setBorderPainted(false);
    kobieta.setOpaque(false);
    kobieta.setForeground(Color.BLACK);
    kobieta.setFont(new Font("SanSerif", 0, wymiary.getRozmiarCzcionkiINT()));
    kobieta.setText("Kobieta");
    
    mezczyzna.setMnemonic(66);
    mezczyzna.setSelected(false);
    mezczyzna.setEnabled(true);
    mezczyzna.setBorder(null);
    mezczyzna.setBorderPainted(false);
    mezczyzna.setOpaque(false);
    mezczyzna.setForeground(Color.BLACK);
    mezczyzna.setFont(new Font("SanSerif", 0, wymiary.getRozmiarCzcionkiINT()));
    mezczyzna.setText("Mężczyzna");
    
    przycisk.setFont(new Font("SanSerif", 1, wymiary.getRozmiarCzcionkiINT()));
    przycisk.setForeground(Color.BLACK);
    przycisk.setText("Przelicz");
    przycisk.setAlignmentX(0.0F);
    
    grupaPlec.add(kobieta);
    grupaPlec.add(mezczyzna);
    
    grupaOFE.add(ofeTak);
    grupaOFE.add(ofeNie);
    
    panelGlowny.add(plec);
    panelGlowny.add(kobieta);
    panelGlowny.add(mezczyzna);
    panelGlowny.add(Box.createRigidArea(new Dimension(1, 5)));
    panelGlowny.add(opisWieku);
    panelGlowny.add(poleWieku);
    panelGlowny.add(Box.createRigidArea(new Dimension(1, 5)));
    panelGlowny.add(opisPensji);
    panelGlowny.add(polePensji);
    panelGlowny.add(Box.createRigidArea(new Dimension(1, 5)));
    panelGlowny.add(opisWiekuEmer);
    panelGlowny.add(poleWiekuEmer);
    panelGlowny.add(Box.createRigidArea(new Dimension(1, 5)));
    panelGlowny.add(opisPracy);
    panelGlowny.add(polePracy);
    panelGlowny.add(Box.createRigidArea(new Dimension(1, 5)));
    panelGlowny.add(opisSPensji);
    panelGlowny.add(poleSPensji);
    panelGlowny.add(Box.createRigidArea(new Dimension(1, 5)));
    panelGlowny.add(przycisk);
    
    panelBoczny.add(Box.createRigidArea(new Dimension(1, 5)));
    panelBoczny.add(opisOFE);
    panelBoczny.add(Box.createRigidArea(new Dimension(1, 5)));
    panelBoczny.add(ofeTak);
    panelBoczny.add(ofeNie);
    
    panelDolny.add(Box.createRigidArea(new Dimension(1, 5)));
    panelDolny.add(opisPodsumowania1);
    panelDolny.add(opisPodsumowania2);
    panelDolny.add(opisPodsumowania3);
    panelDolny.add(opisPodsumowania4);
    panelDolny.add(opisPodsumowania5);
    panelDolny.add(Box.createRigidArea(new Dimension(1, 25)));
    panelDolny.add(podsumowanie);
    panelDolny.add(Box.createRigidArea(new Dimension(1, 25)));
    
    ramka.add(panelGlowny, "West");
    ramka.add(panelBoczny, "East");
    ramka.add(panelDolny, "South");
    
    ramka.pack();
    ramka.setVisible(true);
    
    przycisk.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        inputData.setAktualnyWiekString(poleWieku.getText());
        inputData.setAktualnaPensjaString(polePensji.getText());
        inputData.setWiekEmerytalnyString(poleWiekuEmer.getText());
        inputData.setLataPracyString(polePracy.getText());
        inputData.setStaraPensjaString(poleSPensji.getText());
        
        if (inputData.getAktualnyWiekString().matches("^[0-9]+$"))
        {
          inputData.setAktualnyWiek(Integer.parseInt(inputData.getAktualnyWiekString()));
          
          if (inputData.getAktualnyWiek() >= 16)
          {
            wiek = true;
          }
          else if (inputData.getAktualnyWiek() > 99)
          {
            podsumowanie.setForeground(Color.RED);
            podsumowanie.setText("Wprowadź poprawne dane w polu aktualny wiek.");
            wiek = false;
          }
        }
        else
        {
          podsumowanie.setForeground(Color.RED);
          podsumowanie.setText("Wprowadź poprawne dane w polu aktualny wiek.");
          wiek = false;
        }
        
        if (inputData.getAktualnaPensjaString().matches("^[0-9]+$"))
        {
          inputData.setAktualnaPensja(Integer.parseInt(inputData.getAktualnaPensjaString()));
          pensja = true;
        }
        else
        {
          podsumowanie.setForeground(Color.RED);
          podsumowanie.setText("Wprowadź poprawne dane w polu aktualna pensja.");
          pensja = false;
        }
        
        if (inputData.getWiekEmerytalnyString().matches("^[0-9]+$"))
        {
          inputData.setWiekEmerytalny(Integer.parseInt(inputData.getWiekEmerytalnyString()));
        }
        else
        {
          podsumowanie.setForeground(Color.RED);
          podsumowanie.setText("Wprowadź poprawne dane w polu wiek emerytalny.");
          wiekEmer = false;
        }
        
        if (inputData.getLataPracyString().matches("^[0-9]+$"))
        {
          inputData.setLataPracy(Integer.parseInt(inputData.getLataPracyString()));
          
          if ((inputData.getLataPracy() >= 17) || (inputData.getLataPracy() > inputData.getAktualnyWiek() - 16))
          {
            lataPracy = false;
            podsumowanie.setForeground(Color.RED);
            podsumowanie.setText("Wprowadź poprawne dane w polu lata pracy.");
          }
          else
          {
            lataPracy = true;
          }
        }
        else
        {
          podsumowanie.setForeground(Color.RED);
          podsumowanie.setText("Wprowadź poprawne dane w polu lata pracy.");
          lataPracy = false;
        }
        
        if (inputData.getStaraPensjaString().matches("^[0-9]+$"))
        {
          inputData.setStaraPensja(Integer.parseInt(inputData.getStaraPensjaString()));
          sPensja = true;
        }
        else
        {
          podsumowanie.setForeground(Color.RED);
          podsumowanie.setText("Wprowadź poprawne dane w polu poprzedniej uœrednionej pensji.");
          sPensja = false;
        }
        
        if ((kobieta.isSelected()) && (!mezczyzna.isSelected()))
        {
          plecKM = true;
          
          if ((inputData.getWiekEmerytalny() >= 60) && (inputData.getWiekEmerytalny() < 100) && (inputData.getWiekEmerytalny() >= inputData.getAktualnyWiek()))
          {
            wiekEmer = true;
          }
          else
          {
            wiekEmer = false;
            podsumowanie.setForeground(Color.RED);
            podsumowanie.setText("Wprowadź poprawne dane w polu wiek emerytalny.");
          }
        }
        else if ((!kobieta.isSelected()) && (mezczyzna.isSelected()))
        {
          plecKM = true;
          
          if ((inputData.getWiekEmerytalny() >= 65) && (inputData.getWiekEmerytalny() < 100) && (inputData.getWiekEmerytalny() > inputData.getAktualnyWiek()))
          {
            wiekEmer = true;
          }
          else
          {
            wiekEmer = false;
            podsumowanie.setForeground(Color.RED);
            podsumowanie.setText("Wprowadź poprawne dane w polu wiek emerytalny.");
          }
        }
        else if ((!kobieta.isSelected()) && (!mezczyzna.isSelected()))
        {
          podsumowanie.setForeground(Color.RED);
          podsumowanie.setText("Wybierz swoją płeć.");
          plecKM = false;
        }
        
        if ((plecKM) && (wiek) && (pensja) && (wiekEmer) && (lataPracy) && (sPensja)) {
        	
          if (ofeNie.isSelected())
          {
            wyliczenieEmeryturyBezOFE();
            podsumowanie.setForeground(Color.BLACK);
            podsumowanie.setText("Twoja prognozowana, hipotetyczna, miesięczna emerytura BRUTTO wyniesie w przybliżeniu " + prognozowanaEmerytura + " zł (NETTO " + prognozowanaEmeryturaNetto + " zł).");
          }
          else if (ofeTak.isSelected())
          {
            wyliczenieEmeryturyZOFE();
            podsumowanie.setForeground(Color.BLACK);
            podsumowanie.setText("Twoja prognozowana, hipotetyczna, miesięczna emerytura BRUTTO wyniesie w przybliżeniu " + prognozowanaEmerytura + " zł (NETTO " + prognozowanaEmeryturaNetto + " zł).");
          }
        }
      }
    });
  }
  
  public void wyliczenieEmeryturyBezOFE()
  
  {
    roczneWynagrodzenieS = (inputData.getLataPracy() * miesiace * inputData.getStaraPensja());
    
    if (roczneWynagrodzenieS > 85300.0D)
    {
      staraSkladkaZUS = 10423.66D;
      staraSkladkaSubkonto = 6226.9D;
    }
    else
    {
      staraSkladkaZUS = (roczneWynagrodzenieS * 0.1222D);
      staraSkladkaSubkonto = (roczneWynagrodzenieS * 0.073D);
    }
    
    for (x = 0; x < inputData.getLataPracy(); x ++)
    {
      staraSkladkaZUS += staraSkladkaZUS * 0.045D;
      staraSkladkaSubkonto += staraSkladkaSubkonto * 0.055D;
    }
    staz = (inputData.getWiekEmerytalny() - inputData.getAktualnyWiek());
    
    roczneWynagrodzenieN = (inputData.getAktualnaPensja() * miesiace);
    zrewaloryzowanaNowaSkladkaZUS = staraSkladkaZUS;
    zrewaloryzowanaNowaSkladkaSubkonto = staraSkladkaSubkonto;
    
    for (x = 0; x < staz; x ++)
    {
      nowaSkladkaZUS = (roczneWynagrodzenieN * 0.1222D);
      zrewaloryzowanaNowaSkladkaZUS = (zrewaloryzowanaNowaSkladkaZUS + nowaSkladkaZUS + zrewaloryzowanaNowaSkladkaZUS * 0.035D);
      
      nowaSkladkaSubkonto = (roczneWynagrodzenieN * 0.073D);
      zrewaloryzowanaNowaSkladkaSubkonto = (zrewaloryzowanaNowaSkladkaSubkonto + nowaSkladkaSubkonto + zrewaloryzowanaNowaSkladkaSubkonto * 0.045D);
      
      roczneWynagrodzenieN += roczneWynagrodzenieN * 0.015D;
    }
    kapital = (zrewaloryzowanaNowaSkladkaZUS + zrewaloryzowanaNowaSkladkaSubkonto);
    
    miesiaceEmerytury = ((staz + staz * 0.2D) * miesiace);
    
    prognozowanaEmerytura = Math.round(kapital / miesiaceEmerytury);
    
    prognozowanaEmeryturaNetto = (prognozowanaEmerytura - prognozowanaEmerytura * 0.09D - (prognozowanaEmerytura * 0.18D - 46.3D - prognozowanaEmerytura * 0.0775D));
    prognozowanaEmeryturaNetto = Math.round(prognozowanaEmeryturaNetto);
  }
  
  public void wyliczenieEmeryturyZOFE()
  {
    roczneWynagrodzenieS = (inputData.getLataPracy() * miesiace * inputData.getStaraPensja());
    
    if (roczneWynagrodzenieS > 85300.0D)
    {
      staraSkladkaZUS = 10423.66D;
      staraSkladkaSubkonto = 3736.14D;
      staraSkladkaOFE = 2490.76D;
    }
    else
    {
      staraSkladkaZUS = (roczneWynagrodzenieS * 0.1222D);
      staraSkladkaSubkonto = (roczneWynagrodzenieS * 0.0438D);
      staraSkladkaOFE = (roczneWynagrodzenieS * 0.0292D);
    }
    
    for (x = 0; x < inputData.getLataPracy(); x ++)
    {
      staraSkladkaZUS += staraSkladkaZUS * 0.045D;
      staraSkladkaSubkonto += staraSkladkaSubkonto * 0.055D;
      staraSkladkaOFE += staraSkladkaOFE * 0.065D;
    }
    
    staz = (inputData.getWiekEmerytalny() - inputData.getAktualnyWiek());
    
    roczneWynagrodzenieN = (inputData.getAktualnaPensja() * miesiace);
    zrewaloryzowanaNowaSkladkaZUS = staraSkladkaZUS;
    zrewaloryzowanaNowaSkladkaSubkonto = staraSkladkaSubkonto;
    zrewaloryzowanaNowaSkladkaOFE = staraSkladkaOFE;
    
    for (x = 0; x < staz; x ++)
    {
      nowaSkladkaZUS = (roczneWynagrodzenieN * 0.1222D);
      zrewaloryzowanaNowaSkladkaZUS = (zrewaloryzowanaNowaSkladkaZUS + nowaSkladkaZUS + zrewaloryzowanaNowaSkladkaZUS * 0.035D);
      
      nowaSkladkaSubkonto = (roczneWynagrodzenieN * 0.073D);
      zrewaloryzowanaNowaSkladkaSubkonto = (zrewaloryzowanaNowaSkladkaSubkonto + nowaSkladkaSubkonto + zrewaloryzowanaNowaSkladkaSubkonto * 0.045D);
      
      nowaSkladkaOFE = (roczneWynagrodzenieN * 0.0292D);
      zrewaloryzowanaNowaSkladkaOFE = (zrewaloryzowanaNowaSkladkaOFE + nowaSkladkaOFE + zrewaloryzowanaNowaSkladkaOFE * 0.055D);
      
      roczneWynagrodzenieN += roczneWynagrodzenieN * 0.015D;
    }
    
    kapital = (zrewaloryzowanaNowaSkladkaZUS + zrewaloryzowanaNowaSkladkaSubkonto + zrewaloryzowanaNowaSkladkaOFE);
    
    miesiaceEmerytury = ((staz + staz * 0.2D) * miesiace);
    
    prognozowanaEmerytura = Math.round(kapital / miesiaceEmerytury);
    
    prognozowanaEmeryturaNetto = (prognozowanaEmerytura - prognozowanaEmerytura * 0.09D - (prognozowanaEmerytura * 0.18D - 46.3D - prognozowanaEmerytura * 0.0775D));
    prognozowanaEmeryturaNetto = Math.round(prognozowanaEmeryturaNetto);
  }
}
