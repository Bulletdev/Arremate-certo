package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextAutonumberBullet;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBlipBullet;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBulletColorFollowText;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBulletSizeFollowText;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBulletSizePercent;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBulletSizePoint;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBulletTypefaceFollowText;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharBullet;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextNoBullet;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacing;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList;
import org.openxmlformats.schemas.drawingml.x2006.main.STCoordinate32;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAlignType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextFontAlignType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextIndent;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextIndentLevelType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextMargin;

public class CTTextParagraphPropertiesImpl extends XmlComplexContentImpl implements CTTextParagraphProperties {
  private static final b LNSPC$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "lnSpc");
  
  private static final b SPCBEF$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "spcBef");
  
  private static final b SPCAFT$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "spcAft");
  
  private static final b BUCLRTX$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "buClrTx");
  
  private static final b BUCLR$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "buClr");
  
  private static final b BUSZTX$10 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "buSzTx");
  
  private static final b BUSZPCT$12 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "buSzPct");
  
  private static final b BUSZPTS$14 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "buSzPts");
  
  private static final b BUFONTTX$16 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "buFontTx");
  
  private static final b BUFONT$18 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "buFont");
  
  private static final b BUNONE$20 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "buNone");
  
  private static final b BUAUTONUM$22 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "buAutoNum");
  
  private static final b BUCHAR$24 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "buChar");
  
  private static final b BUBLIP$26 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "buBlip");
  
  private static final b TABLST$28 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "tabLst");
  
  private static final b DEFRPR$30 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "defRPr");
  
  private static final b EXTLST$32 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
  
  private static final b MARL$34 = new b("", "marL");
  
  private static final b MARR$36 = new b("", "marR");
  
  private static final b LVL$38 = new b("", "lvl");
  
  private static final b INDENT$40 = new b("", "indent");
  
  private static final b ALGN$42 = new b("", "algn");
  
  private static final b DEFTABSZ$44 = new b("", "defTabSz");
  
  private static final b RTL$46 = new b("", "rtl");
  
  private static final b EALNBRK$48 = new b("", "eaLnBrk");
  
  private static final b FONTALGN$50 = new b("", "fontAlgn");
  
  private static final b LATINLNBRK$52 = new b("", "latinLnBrk");
  
  private static final b HANGINGPUNCT$54 = new b("", "hangingPunct");
  
  public CTTextParagraphPropertiesImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTTextSpacing getLnSpc() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextSpacing cTTextSpacing = null;
      cTTextSpacing = (CTTextSpacing)get_store().find_element_user(LNSPC$0, 0);
      if (cTTextSpacing == null)
        return null; 
      return cTTextSpacing;
    } 
  }
  
  public boolean isSetLnSpc() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LNSPC$0) != 0);
    } 
  }
  
  public void setLnSpc(CTTextSpacing paramCTTextSpacing) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextSpacing cTTextSpacing = null;
      cTTextSpacing = (CTTextSpacing)get_store().find_element_user(LNSPC$0, 0);
      if (cTTextSpacing == null)
        cTTextSpacing = (CTTextSpacing)get_store().add_element_user(LNSPC$0); 
      cTTextSpacing.set((XmlObject)paramCTTextSpacing);
    } 
  }
  
  public CTTextSpacing addNewLnSpc() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextSpacing cTTextSpacing = null;
      cTTextSpacing = (CTTextSpacing)get_store().add_element_user(LNSPC$0);
      return cTTextSpacing;
    } 
  }
  
  public void unsetLnSpc() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LNSPC$0, 0);
    } 
  }
  
  public CTTextSpacing getSpcBef() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextSpacing cTTextSpacing = null;
      cTTextSpacing = (CTTextSpacing)get_store().find_element_user(SPCBEF$2, 0);
      if (cTTextSpacing == null)
        return null; 
      return cTTextSpacing;
    } 
  }
  
  public boolean isSetSpcBef() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SPCBEF$2) != 0);
    } 
  }
  
  public void setSpcBef(CTTextSpacing paramCTTextSpacing) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextSpacing cTTextSpacing = null;
      cTTextSpacing = (CTTextSpacing)get_store().find_element_user(SPCBEF$2, 0);
      if (cTTextSpacing == null)
        cTTextSpacing = (CTTextSpacing)get_store().add_element_user(SPCBEF$2); 
      cTTextSpacing.set((XmlObject)paramCTTextSpacing);
    } 
  }
  
  public CTTextSpacing addNewSpcBef() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextSpacing cTTextSpacing = null;
      cTTextSpacing = (CTTextSpacing)get_store().add_element_user(SPCBEF$2);
      return cTTextSpacing;
    } 
  }
  
  public void unsetSpcBef() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SPCBEF$2, 0);
    } 
  }
  
  public CTTextSpacing getSpcAft() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextSpacing cTTextSpacing = null;
      cTTextSpacing = (CTTextSpacing)get_store().find_element_user(SPCAFT$4, 0);
      if (cTTextSpacing == null)
        return null; 
      return cTTextSpacing;
    } 
  }
  
  public boolean isSetSpcAft() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SPCAFT$4) != 0);
    } 
  }
  
  public void setSpcAft(CTTextSpacing paramCTTextSpacing) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextSpacing cTTextSpacing = null;
      cTTextSpacing = (CTTextSpacing)get_store().find_element_user(SPCAFT$4, 0);
      if (cTTextSpacing == null)
        cTTextSpacing = (CTTextSpacing)get_store().add_element_user(SPCAFT$4); 
      cTTextSpacing.set((XmlObject)paramCTTextSpacing);
    } 
  }
  
  public CTTextSpacing addNewSpcAft() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextSpacing cTTextSpacing = null;
      cTTextSpacing = (CTTextSpacing)get_store().add_element_user(SPCAFT$4);
      return cTTextSpacing;
    } 
  }
  
  public void unsetSpcAft() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SPCAFT$4, 0);
    } 
  }
  
  public CTTextBulletColorFollowText getBuClrTx() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBulletColorFollowText cTTextBulletColorFollowText = null;
      cTTextBulletColorFollowText = (CTTextBulletColorFollowText)get_store().find_element_user(BUCLRTX$6, 0);
      if (cTTextBulletColorFollowText == null)
        return null; 
      return cTTextBulletColorFollowText;
    } 
  }
  
  public boolean isSetBuClrTx() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BUCLRTX$6) != 0);
    } 
  }
  
  public void setBuClrTx(CTTextBulletColorFollowText paramCTTextBulletColorFollowText) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBulletColorFollowText cTTextBulletColorFollowText = null;
      cTTextBulletColorFollowText = (CTTextBulletColorFollowText)get_store().find_element_user(BUCLRTX$6, 0);
      if (cTTextBulletColorFollowText == null)
        cTTextBulletColorFollowText = (CTTextBulletColorFollowText)get_store().add_element_user(BUCLRTX$6); 
      cTTextBulletColorFollowText.set((XmlObject)paramCTTextBulletColorFollowText);
    } 
  }
  
  public CTTextBulletColorFollowText addNewBuClrTx() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBulletColorFollowText cTTextBulletColorFollowText = null;
      cTTextBulletColorFollowText = (CTTextBulletColorFollowText)get_store().add_element_user(BUCLRTX$6);
      return cTTextBulletColorFollowText;
    } 
  }
  
  public void unsetBuClrTx() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BUCLRTX$6, 0);
    } 
  }
  
  public CTColor getBuClr() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(BUCLR$8, 0);
      if (cTColor == null)
        return null; 
      return cTColor;
    } 
  }
  
  public boolean isSetBuClr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BUCLR$8) != 0);
    } 
  }
  
  public void setBuClr(CTColor paramCTColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(BUCLR$8, 0);
      if (cTColor == null)
        cTColor = (CTColor)get_store().add_element_user(BUCLR$8); 
      cTColor.set((XmlObject)paramCTColor);
    } 
  }
  
  public CTColor addNewBuClr() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().add_element_user(BUCLR$8);
      return cTColor;
    } 
  }
  
  public void unsetBuClr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BUCLR$8, 0);
    } 
  }
  
  public CTTextBulletSizeFollowText getBuSzTx() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBulletSizeFollowText cTTextBulletSizeFollowText = null;
      cTTextBulletSizeFollowText = (CTTextBulletSizeFollowText)get_store().find_element_user(BUSZTX$10, 0);
      if (cTTextBulletSizeFollowText == null)
        return null; 
      return cTTextBulletSizeFollowText;
    } 
  }
  
  public boolean isSetBuSzTx() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BUSZTX$10) != 0);
    } 
  }
  
  public void setBuSzTx(CTTextBulletSizeFollowText paramCTTextBulletSizeFollowText) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBulletSizeFollowText cTTextBulletSizeFollowText = null;
      cTTextBulletSizeFollowText = (CTTextBulletSizeFollowText)get_store().find_element_user(BUSZTX$10, 0);
      if (cTTextBulletSizeFollowText == null)
        cTTextBulletSizeFollowText = (CTTextBulletSizeFollowText)get_store().add_element_user(BUSZTX$10); 
      cTTextBulletSizeFollowText.set((XmlObject)paramCTTextBulletSizeFollowText);
    } 
  }
  
  public CTTextBulletSizeFollowText addNewBuSzTx() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBulletSizeFollowText cTTextBulletSizeFollowText = null;
      cTTextBulletSizeFollowText = (CTTextBulletSizeFollowText)get_store().add_element_user(BUSZTX$10);
      return cTTextBulletSizeFollowText;
    } 
  }
  
  public void unsetBuSzTx() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BUSZTX$10, 0);
    } 
  }
  
  public CTTextBulletSizePercent getBuSzPct() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBulletSizePercent cTTextBulletSizePercent = null;
      cTTextBulletSizePercent = (CTTextBulletSizePercent)get_store().find_element_user(BUSZPCT$12, 0);
      if (cTTextBulletSizePercent == null)
        return null; 
      return cTTextBulletSizePercent;
    } 
  }
  
  public boolean isSetBuSzPct() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BUSZPCT$12) != 0);
    } 
  }
  
  public void setBuSzPct(CTTextBulletSizePercent paramCTTextBulletSizePercent) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBulletSizePercent cTTextBulletSizePercent = null;
      cTTextBulletSizePercent = (CTTextBulletSizePercent)get_store().find_element_user(BUSZPCT$12, 0);
      if (cTTextBulletSizePercent == null)
        cTTextBulletSizePercent = (CTTextBulletSizePercent)get_store().add_element_user(BUSZPCT$12); 
      cTTextBulletSizePercent.set((XmlObject)paramCTTextBulletSizePercent);
    } 
  }
  
  public CTTextBulletSizePercent addNewBuSzPct() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBulletSizePercent cTTextBulletSizePercent = null;
      cTTextBulletSizePercent = (CTTextBulletSizePercent)get_store().add_element_user(BUSZPCT$12);
      return cTTextBulletSizePercent;
    } 
  }
  
  public void unsetBuSzPct() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BUSZPCT$12, 0);
    } 
  }
  
  public CTTextBulletSizePoint getBuSzPts() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBulletSizePoint cTTextBulletSizePoint = null;
      cTTextBulletSizePoint = (CTTextBulletSizePoint)get_store().find_element_user(BUSZPTS$14, 0);
      if (cTTextBulletSizePoint == null)
        return null; 
      return cTTextBulletSizePoint;
    } 
  }
  
  public boolean isSetBuSzPts() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BUSZPTS$14) != 0);
    } 
  }
  
  public void setBuSzPts(CTTextBulletSizePoint paramCTTextBulletSizePoint) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBulletSizePoint cTTextBulletSizePoint = null;
      cTTextBulletSizePoint = (CTTextBulletSizePoint)get_store().find_element_user(BUSZPTS$14, 0);
      if (cTTextBulletSizePoint == null)
        cTTextBulletSizePoint = (CTTextBulletSizePoint)get_store().add_element_user(BUSZPTS$14); 
      cTTextBulletSizePoint.set((XmlObject)paramCTTextBulletSizePoint);
    } 
  }
  
  public CTTextBulletSizePoint addNewBuSzPts() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBulletSizePoint cTTextBulletSizePoint = null;
      cTTextBulletSizePoint = (CTTextBulletSizePoint)get_store().add_element_user(BUSZPTS$14);
      return cTTextBulletSizePoint;
    } 
  }
  
  public void unsetBuSzPts() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BUSZPTS$14, 0);
    } 
  }
  
  public CTTextBulletTypefaceFollowText getBuFontTx() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBulletTypefaceFollowText cTTextBulletTypefaceFollowText = null;
      cTTextBulletTypefaceFollowText = (CTTextBulletTypefaceFollowText)get_store().find_element_user(BUFONTTX$16, 0);
      if (cTTextBulletTypefaceFollowText == null)
        return null; 
      return cTTextBulletTypefaceFollowText;
    } 
  }
  
  public boolean isSetBuFontTx() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BUFONTTX$16) != 0);
    } 
  }
  
  public void setBuFontTx(CTTextBulletTypefaceFollowText paramCTTextBulletTypefaceFollowText) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBulletTypefaceFollowText cTTextBulletTypefaceFollowText = null;
      cTTextBulletTypefaceFollowText = (CTTextBulletTypefaceFollowText)get_store().find_element_user(BUFONTTX$16, 0);
      if (cTTextBulletTypefaceFollowText == null)
        cTTextBulletTypefaceFollowText = (CTTextBulletTypefaceFollowText)get_store().add_element_user(BUFONTTX$16); 
      cTTextBulletTypefaceFollowText.set((XmlObject)paramCTTextBulletTypefaceFollowText);
    } 
  }
  
  public CTTextBulletTypefaceFollowText addNewBuFontTx() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBulletTypefaceFollowText cTTextBulletTypefaceFollowText = null;
      cTTextBulletTypefaceFollowText = (CTTextBulletTypefaceFollowText)get_store().add_element_user(BUFONTTX$16);
      return cTTextBulletTypefaceFollowText;
    } 
  }
  
  public void unsetBuFontTx() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BUFONTTX$16, 0);
    } 
  }
  
  public CTTextFont getBuFont() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextFont cTTextFont = null;
      cTTextFont = (CTTextFont)get_store().find_element_user(BUFONT$18, 0);
      if (cTTextFont == null)
        return null; 
      return cTTextFont;
    } 
  }
  
  public boolean isSetBuFont() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BUFONT$18) != 0);
    } 
  }
  
  public void setBuFont(CTTextFont paramCTTextFont) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextFont cTTextFont = null;
      cTTextFont = (CTTextFont)get_store().find_element_user(BUFONT$18, 0);
      if (cTTextFont == null)
        cTTextFont = (CTTextFont)get_store().add_element_user(BUFONT$18); 
      cTTextFont.set((XmlObject)paramCTTextFont);
    } 
  }
  
  public CTTextFont addNewBuFont() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextFont cTTextFont = null;
      cTTextFont = (CTTextFont)get_store().add_element_user(BUFONT$18);
      return cTTextFont;
    } 
  }
  
  public void unsetBuFont() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BUFONT$18, 0);
    } 
  }
  
  public CTTextNoBullet getBuNone() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextNoBullet cTTextNoBullet = null;
      cTTextNoBullet = (CTTextNoBullet)get_store().find_element_user(BUNONE$20, 0);
      if (cTTextNoBullet == null)
        return null; 
      return cTTextNoBullet;
    } 
  }
  
  public boolean isSetBuNone() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BUNONE$20) != 0);
    } 
  }
  
  public void setBuNone(CTTextNoBullet paramCTTextNoBullet) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextNoBullet cTTextNoBullet = null;
      cTTextNoBullet = (CTTextNoBullet)get_store().find_element_user(BUNONE$20, 0);
      if (cTTextNoBullet == null)
        cTTextNoBullet = (CTTextNoBullet)get_store().add_element_user(BUNONE$20); 
      cTTextNoBullet.set((XmlObject)paramCTTextNoBullet);
    } 
  }
  
  public CTTextNoBullet addNewBuNone() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextNoBullet cTTextNoBullet = null;
      cTTextNoBullet = (CTTextNoBullet)get_store().add_element_user(BUNONE$20);
      return cTTextNoBullet;
    } 
  }
  
  public void unsetBuNone() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BUNONE$20, 0);
    } 
  }
  
  public CTTextAutonumberBullet getBuAutoNum() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextAutonumberBullet cTTextAutonumberBullet = null;
      cTTextAutonumberBullet = (CTTextAutonumberBullet)get_store().find_element_user(BUAUTONUM$22, 0);
      if (cTTextAutonumberBullet == null)
        return null; 
      return cTTextAutonumberBullet;
    } 
  }
  
  public boolean isSetBuAutoNum() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BUAUTONUM$22) != 0);
    } 
  }
  
  public void setBuAutoNum(CTTextAutonumberBullet paramCTTextAutonumberBullet) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextAutonumberBullet cTTextAutonumberBullet = null;
      cTTextAutonumberBullet = (CTTextAutonumberBullet)get_store().find_element_user(BUAUTONUM$22, 0);
      if (cTTextAutonumberBullet == null)
        cTTextAutonumberBullet = (CTTextAutonumberBullet)get_store().add_element_user(BUAUTONUM$22); 
      cTTextAutonumberBullet.set((XmlObject)paramCTTextAutonumberBullet);
    } 
  }
  
  public CTTextAutonumberBullet addNewBuAutoNum() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextAutonumberBullet cTTextAutonumberBullet = null;
      cTTextAutonumberBullet = (CTTextAutonumberBullet)get_store().add_element_user(BUAUTONUM$22);
      return cTTextAutonumberBullet;
    } 
  }
  
  public void unsetBuAutoNum() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BUAUTONUM$22, 0);
    } 
  }
  
  public CTTextCharBullet getBuChar() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextCharBullet cTTextCharBullet = null;
      cTTextCharBullet = (CTTextCharBullet)get_store().find_element_user(BUCHAR$24, 0);
      if (cTTextCharBullet == null)
        return null; 
      return cTTextCharBullet;
    } 
  }
  
  public boolean isSetBuChar() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BUCHAR$24) != 0);
    } 
  }
  
  public void setBuChar(CTTextCharBullet paramCTTextCharBullet) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextCharBullet cTTextCharBullet = null;
      cTTextCharBullet = (CTTextCharBullet)get_store().find_element_user(BUCHAR$24, 0);
      if (cTTextCharBullet == null)
        cTTextCharBullet = (CTTextCharBullet)get_store().add_element_user(BUCHAR$24); 
      cTTextCharBullet.set((XmlObject)paramCTTextCharBullet);
    } 
  }
  
  public CTTextCharBullet addNewBuChar() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextCharBullet cTTextCharBullet = null;
      cTTextCharBullet = (CTTextCharBullet)get_store().add_element_user(BUCHAR$24);
      return cTTextCharBullet;
    } 
  }
  
  public void unsetBuChar() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BUCHAR$24, 0);
    } 
  }
  
  public CTTextBlipBullet getBuBlip() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBlipBullet cTTextBlipBullet = null;
      cTTextBlipBullet = (CTTextBlipBullet)get_store().find_element_user(BUBLIP$26, 0);
      if (cTTextBlipBullet == null)
        return null; 
      return cTTextBlipBullet;
    } 
  }
  
  public boolean isSetBuBlip() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BUBLIP$26) != 0);
    } 
  }
  
  public void setBuBlip(CTTextBlipBullet paramCTTextBlipBullet) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBlipBullet cTTextBlipBullet = null;
      cTTextBlipBullet = (CTTextBlipBullet)get_store().find_element_user(BUBLIP$26, 0);
      if (cTTextBlipBullet == null)
        cTTextBlipBullet = (CTTextBlipBullet)get_store().add_element_user(BUBLIP$26); 
      cTTextBlipBullet.set((XmlObject)paramCTTextBlipBullet);
    } 
  }
  
  public CTTextBlipBullet addNewBuBlip() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBlipBullet cTTextBlipBullet = null;
      cTTextBlipBullet = (CTTextBlipBullet)get_store().add_element_user(BUBLIP$26);
      return cTTextBlipBullet;
    } 
  }
  
  public void unsetBuBlip() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BUBLIP$26, 0);
    } 
  }
  
  public CTTextTabStopList getTabLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextTabStopList cTTextTabStopList = null;
      cTTextTabStopList = (CTTextTabStopList)get_store().find_element_user(TABLST$28, 0);
      if (cTTextTabStopList == null)
        return null; 
      return cTTextTabStopList;
    } 
  }
  
  public boolean isSetTabLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TABLST$28) != 0);
    } 
  }
  
  public void setTabLst(CTTextTabStopList paramCTTextTabStopList) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextTabStopList cTTextTabStopList = null;
      cTTextTabStopList = (CTTextTabStopList)get_store().find_element_user(TABLST$28, 0);
      if (cTTextTabStopList == null)
        cTTextTabStopList = (CTTextTabStopList)get_store().add_element_user(TABLST$28); 
      cTTextTabStopList.set((XmlObject)paramCTTextTabStopList);
    } 
  }
  
  public CTTextTabStopList addNewTabLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextTabStopList cTTextTabStopList = null;
      cTTextTabStopList = (CTTextTabStopList)get_store().add_element_user(TABLST$28);
      return cTTextTabStopList;
    } 
  }
  
  public void unsetTabLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TABLST$28, 0);
    } 
  }
  
  public CTTextCharacterProperties getDefRPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextCharacterProperties cTTextCharacterProperties = null;
      cTTextCharacterProperties = (CTTextCharacterProperties)get_store().find_element_user(DEFRPR$30, 0);
      if (cTTextCharacterProperties == null)
        return null; 
      return cTTextCharacterProperties;
    } 
  }
  
  public boolean isSetDefRPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DEFRPR$30) != 0);
    } 
  }
  
  public void setDefRPr(CTTextCharacterProperties paramCTTextCharacterProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextCharacterProperties cTTextCharacterProperties = null;
      cTTextCharacterProperties = (CTTextCharacterProperties)get_store().find_element_user(DEFRPR$30, 0);
      if (cTTextCharacterProperties == null)
        cTTextCharacterProperties = (CTTextCharacterProperties)get_store().add_element_user(DEFRPR$30); 
      cTTextCharacterProperties.set((XmlObject)paramCTTextCharacterProperties);
    } 
  }
  
  public CTTextCharacterProperties addNewDefRPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextCharacterProperties cTTextCharacterProperties = null;
      cTTextCharacterProperties = (CTTextCharacterProperties)get_store().add_element_user(DEFRPR$30);
      return cTTextCharacterProperties;
    } 
  }
  
  public void unsetDefRPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DEFRPR$30, 0);
    } 
  }
  
  public CTOfficeArtExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$32, 0);
      if (cTOfficeArtExtensionList == null)
        return null; 
      return cTOfficeArtExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$32) != 0);
    } 
  }
  
  public void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$32, 0);
      if (cTOfficeArtExtensionList == null)
        cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$32); 
      cTOfficeArtExtensionList.set((XmlObject)paramCTOfficeArtExtensionList);
    } 
  }
  
  public CTOfficeArtExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$32);
      return cTOfficeArtExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$32, 0);
    } 
  }
  
  public int getMarL() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MARL$34);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STTextMargin xgetMarL() {
    synchronized (monitor()) {
      check_orphaned();
      STTextMargin sTTextMargin = null;
      sTTextMargin = (STTextMargin)get_store().find_attribute_user(MARL$34);
      return sTTextMargin;
    } 
  }
  
  public boolean isSetMarL() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MARL$34) != null);
    } 
  }
  
  public void setMarL(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MARL$34);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MARL$34); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetMarL(STTextMargin paramSTTextMargin) {
    synchronized (monitor()) {
      check_orphaned();
      STTextMargin sTTextMargin = null;
      sTTextMargin = (STTextMargin)get_store().find_attribute_user(MARL$34);
      if (sTTextMargin == null)
        sTTextMargin = (STTextMargin)get_store().add_attribute_user(MARL$34); 
      sTTextMargin.set((XmlObject)paramSTTextMargin);
    } 
  }
  
  public void unsetMarL() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MARL$34);
    } 
  }
  
  public int getMarR() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MARR$36);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STTextMargin xgetMarR() {
    synchronized (monitor()) {
      check_orphaned();
      STTextMargin sTTextMargin = null;
      sTTextMargin = (STTextMargin)get_store().find_attribute_user(MARR$36);
      return sTTextMargin;
    } 
  }
  
  public boolean isSetMarR() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MARR$36) != null);
    } 
  }
  
  public void setMarR(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MARR$36);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MARR$36); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetMarR(STTextMargin paramSTTextMargin) {
    synchronized (monitor()) {
      check_orphaned();
      STTextMargin sTTextMargin = null;
      sTTextMargin = (STTextMargin)get_store().find_attribute_user(MARR$36);
      if (sTTextMargin == null)
        sTTextMargin = (STTextMargin)get_store().add_attribute_user(MARR$36); 
      sTTextMargin.set((XmlObject)paramSTTextMargin);
    } 
  }
  
  public void unsetMarR() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MARR$36);
    } 
  }
  
  public int getLvl() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LVL$38);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STTextIndentLevelType xgetLvl() {
    synchronized (monitor()) {
      check_orphaned();
      STTextIndentLevelType sTTextIndentLevelType = null;
      sTTextIndentLevelType = (STTextIndentLevelType)get_store().find_attribute_user(LVL$38);
      return sTTextIndentLevelType;
    } 
  }
  
  public boolean isSetLvl() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(LVL$38) != null);
    } 
  }
  
  public void setLvl(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LVL$38);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(LVL$38); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetLvl(STTextIndentLevelType paramSTTextIndentLevelType) {
    synchronized (monitor()) {
      check_orphaned();
      STTextIndentLevelType sTTextIndentLevelType = null;
      sTTextIndentLevelType = (STTextIndentLevelType)get_store().find_attribute_user(LVL$38);
      if (sTTextIndentLevelType == null)
        sTTextIndentLevelType = (STTextIndentLevelType)get_store().add_attribute_user(LVL$38); 
      sTTextIndentLevelType.set((XmlObject)paramSTTextIndentLevelType);
    } 
  }
  
  public void unsetLvl() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(LVL$38);
    } 
  }
  
  public int getIndent() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INDENT$40);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STTextIndent xgetIndent() {
    synchronized (monitor()) {
      check_orphaned();
      STTextIndent sTTextIndent = null;
      sTTextIndent = (STTextIndent)get_store().find_attribute_user(INDENT$40);
      return sTTextIndent;
    } 
  }
  
  public boolean isSetIndent() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(INDENT$40) != null);
    } 
  }
  
  public void setIndent(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INDENT$40);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(INDENT$40); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetIndent(STTextIndent paramSTTextIndent) {
    synchronized (monitor()) {
      check_orphaned();
      STTextIndent sTTextIndent = null;
      sTTextIndent = (STTextIndent)get_store().find_attribute_user(INDENT$40);
      if (sTTextIndent == null)
        sTTextIndent = (STTextIndent)get_store().add_attribute_user(INDENT$40); 
      sTTextIndent.set((XmlObject)paramSTTextIndent);
    } 
  }
  
  public void unsetIndent() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(INDENT$40);
    } 
  }
  
  public STTextAlignType.Enum getAlgn() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALGN$42);
      if (simpleValue == null)
        return null; 
      return (STTextAlignType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTextAlignType xgetAlgn() {
    synchronized (monitor()) {
      check_orphaned();
      STTextAlignType sTTextAlignType = null;
      sTTextAlignType = (STTextAlignType)get_store().find_attribute_user(ALGN$42);
      return sTTextAlignType;
    } 
  }
  
  public boolean isSetAlgn() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ALGN$42) != null);
    } 
  }
  
  public void setAlgn(STTextAlignType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALGN$42);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ALGN$42); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetAlgn(STTextAlignType paramSTTextAlignType) {
    synchronized (monitor()) {
      check_orphaned();
      STTextAlignType sTTextAlignType = null;
      sTTextAlignType = (STTextAlignType)get_store().find_attribute_user(ALGN$42);
      if (sTTextAlignType == null)
        sTTextAlignType = (STTextAlignType)get_store().add_attribute_user(ALGN$42); 
      sTTextAlignType.set((XmlObject)paramSTTextAlignType);
    } 
  }
  
  public void unsetAlgn() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ALGN$42);
    } 
  }
  
  public int getDefTabSz() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEFTABSZ$44);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STCoordinate32 xgetDefTabSz() {
    synchronized (monitor()) {
      check_orphaned();
      STCoordinate32 sTCoordinate32 = null;
      sTCoordinate32 = (STCoordinate32)get_store().find_attribute_user(DEFTABSZ$44);
      return sTCoordinate32;
    } 
  }
  
  public boolean isSetDefTabSz() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DEFTABSZ$44) != null);
    } 
  }
  
  public void setDefTabSz(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEFTABSZ$44);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DEFTABSZ$44); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetDefTabSz(STCoordinate32 paramSTCoordinate32) {
    synchronized (monitor()) {
      check_orphaned();
      STCoordinate32 sTCoordinate32 = null;
      sTCoordinate32 = (STCoordinate32)get_store().find_attribute_user(DEFTABSZ$44);
      if (sTCoordinate32 == null)
        sTCoordinate32 = (STCoordinate32)get_store().add_attribute_user(DEFTABSZ$44); 
      sTCoordinate32.set((XmlObject)paramSTCoordinate32);
    } 
  }
  
  public void unsetDefTabSz() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DEFTABSZ$44);
    } 
  }
  
  public boolean getRtl() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RTL$46);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetRtl() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(RTL$46);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetRtl() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(RTL$46) != null);
    } 
  }
  
  public void setRtl(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RTL$46);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(RTL$46); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetRtl(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(RTL$46);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(RTL$46); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetRtl() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(RTL$46);
    } 
  }
  
  public boolean getEaLnBrk() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(EALNBRK$48);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetEaLnBrk() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(EALNBRK$48);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetEaLnBrk() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(EALNBRK$48) != null);
    } 
  }
  
  public void setEaLnBrk(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(EALNBRK$48);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(EALNBRK$48); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetEaLnBrk(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(EALNBRK$48);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(EALNBRK$48); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetEaLnBrk() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(EALNBRK$48);
    } 
  }
  
  public STTextFontAlignType.Enum getFontAlgn() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FONTALGN$50);
      if (simpleValue == null)
        return null; 
      return (STTextFontAlignType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTextFontAlignType xgetFontAlgn() {
    synchronized (monitor()) {
      check_orphaned();
      STTextFontAlignType sTTextFontAlignType = null;
      sTTextFontAlignType = (STTextFontAlignType)get_store().find_attribute_user(FONTALGN$50);
      return sTTextFontAlignType;
    } 
  }
  
  public boolean isSetFontAlgn() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FONTALGN$50) != null);
    } 
  }
  
  public void setFontAlgn(STTextFontAlignType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FONTALGN$50);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FONTALGN$50); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetFontAlgn(STTextFontAlignType paramSTTextFontAlignType) {
    synchronized (monitor()) {
      check_orphaned();
      STTextFontAlignType sTTextFontAlignType = null;
      sTTextFontAlignType = (STTextFontAlignType)get_store().find_attribute_user(FONTALGN$50);
      if (sTTextFontAlignType == null)
        sTTextFontAlignType = (STTextFontAlignType)get_store().add_attribute_user(FONTALGN$50); 
      sTTextFontAlignType.set((XmlObject)paramSTTextFontAlignType);
    } 
  }
  
  public void unsetFontAlgn() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FONTALGN$50);
    } 
  }
  
  public boolean getLatinLnBrk() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LATINLNBRK$52);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetLatinLnBrk() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(LATINLNBRK$52);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetLatinLnBrk() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(LATINLNBRK$52) != null);
    } 
  }
  
  public void setLatinLnBrk(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LATINLNBRK$52);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(LATINLNBRK$52); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetLatinLnBrk(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(LATINLNBRK$52);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(LATINLNBRK$52); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetLatinLnBrk() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(LATINLNBRK$52);
    } 
  }
  
  public boolean getHangingPunct() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HANGINGPUNCT$54);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetHangingPunct() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(HANGINGPUNCT$54);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetHangingPunct() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HANGINGPUNCT$54) != null);
    } 
  }
  
  public void setHangingPunct(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HANGINGPUNCT$54);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HANGINGPUNCT$54); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetHangingPunct(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(HANGINGPUNCT$54);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(HANGINGPUNCT$54); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetHangingPunct() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HANGINGPUNCT$54);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTTextParagraphPropertiesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */