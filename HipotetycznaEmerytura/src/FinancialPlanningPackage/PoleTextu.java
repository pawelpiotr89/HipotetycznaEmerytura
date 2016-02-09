package FinancialPlanningPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFormattedTextField;

public class PoleTextu
  extends JFormattedTextField
{
  Wymiary wymiary = new Wymiary();
  
  public PoleTextu()
  {
    setForeground(Color.BLACK);
    setBackground(Color.WHITE);
    setEditable(true);
    setEnabled(true);
    setFont(new Font("Verdana", 0, this.wymiary.getRozmiarCzcionkiINT()));
    setPreferredSize(new Dimension(this.wymiary.getWymiarLabelSINT(), this.wymiary.getWymiarLabelWINT()));
    setMaximumSize(getPreferredSize());
  }
}