package FinancialPlanningPackage;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class OpisPola
  extends JLabel
{
  Wymiary wymiary = new Wymiary();
  
  public OpisPola()
  {
    setOpaque(false);
    setBorder(null);
    setForeground(Color.BLACK);
    setFont(new Font("SanSerif", 1, this.wymiary.getRozmiarCzcionkiINT()));
  }
}
