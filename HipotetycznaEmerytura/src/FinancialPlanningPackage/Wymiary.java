package FinancialPlanningPackage;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Wymiary
{
  Toolkit tk = Toolkit.getDefaultToolkit();
  Dimension screenSize = this.tk.getScreenSize();
  
  private int szerokoscR = this.screenSize.width;
  private int wysokoscR = this.screenSize.height;
  
  private double szerokoscRamki = this.szerokoscR / 2;
  private double wysokoscRamki = this.wysokoscR / 2;
  
  private int szerokoscRamkiINT = (int)this.szerokoscRamki;
  private int wysokoscRamkiINT = (int)this.wysokoscRamki;
  
  private double polozenieRamkiS = this.szerokoscR / 4;
  private double polozenieRamkiW = this.wysokoscR / 4;
  
  private int polozenieRamkiSINT = (int)this.polozenieRamkiS;
  private int polozenieRamkiWINT = (int)this.polozenieRamkiW;
  private double rozmiarCzcionki = this.szerokoscR / 150;
  
  private int rozmiarCzcionkiINT = (int)this.rozmiarCzcionki;
  private double wymiarLabelS = this.szerokoscR / 20;
  
  private int wymiarLabelSINT = (int)this.wymiarLabelS;
  private double wymiarLabelW = this.wysokoscR / 50;
  
  private int wymiarLabelWINT = (int)this.wymiarLabelW;
  private double szerokoscPaneluPL = this.szerokoscRamkiINT / 2;
  
  private int szerokoscPaneluPLINT = (int)this.szerokoscPaneluPL;
  private double wysokoscPaneluPL = this.wysokoscRamkiINT * 0.6666D;
  
  private int wysokoscPaneluPLINT = (int)this.wysokoscPaneluPL;
  private double wysokoscPaneluD = this.wysokoscRamkiINT * 0.3333D;
  
  private int wysokoscPaneluDINT = (int)this.wysokoscPaneluD;
  
  public int getSzerokoscRamkiINT()
  {
    return this.szerokoscRamkiINT;
  }
  
  public int getWysokoscRamkiINT()
  {
    return this.wysokoscRamkiINT;
  }
  
  public int getPolozenieRamkiSINT()
  {
    return this.polozenieRamkiSINT;
  }
  
  public int getPolozenieRamkiWINT()
  {
    return this.polozenieRamkiWINT;
  }
  
  public int getRozmiarCzcionkiINT()
  {
    return this.rozmiarCzcionkiINT;
  }
  
  public int getWymiarLabelSINT()
  {
    return this.wymiarLabelSINT;
  }
  
  public int getWymiarLabelWINT()
  {
    return this.wymiarLabelWINT;
  }
  
  public int getszerokoscPaneluPLINT()
  {
    return this.szerokoscPaneluPLINT;
  }
  
  public int getwysokoscPaneluPLINT()
  {
    return this.wysokoscPaneluPLINT;
  }
  
  public int getwysokoscPaneluDINT()
  {
    return this.wysokoscPaneluDINT;
  }
}