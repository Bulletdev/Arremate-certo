package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEastAsianLayout;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEm;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFitText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHighlight;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHpsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLanguage;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPrChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSignedHpsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSignedTwipsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextEffect;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextScale;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalAlignRun;

public class CTRPrImpl extends XmlComplexContentImpl implements CTRPr {
  private static final b RSTYLE$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rStyle");
  
  private static final b RFONTS$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rFonts");
  
  private static final b B$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "b");
  
  private static final b BCS$6 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bCs");
  
  private static final b I$8 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "i");
  
  private static final b ICS$10 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "iCs");
  
  private static final b CAPS$12 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "caps");
  
  private static final b SMALLCAPS$14 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "smallCaps");
  
  private static final b STRIKE$16 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "strike");
  
  private static final b DSTRIKE$18 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "dstrike");
  
  private static final b OUTLINE$20 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "outline");
  
  private static final b SHADOW$22 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "shadow");
  
  private static final b EMBOSS$24 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "emboss");
  
  private static final b IMPRINT$26 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "imprint");
  
  private static final b NOPROOF$28 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "noProof");
  
  private static final b SNAPTOGRID$30 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "snapToGrid");
  
  private static final b VANISH$32 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "vanish");
  
  private static final b WEBHIDDEN$34 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "webHidden");
  
  private static final b COLOR$36 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "color");
  
  private static final b SPACING$38 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "spacing");
  
  private static final b W$40 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "w");
  
  private static final b KERN$42 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "kern");
  
  private static final b POSITION$44 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "position");
  
  private static final b SZ$46 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sz");
  
  private static final b SZCS$48 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "szCs");
  
  private static final b HIGHLIGHT$50 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "highlight");
  
  private static final b U$52 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "u");
  
  private static final b EFFECT$54 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "effect");
  
  private static final b BDR$56 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bdr");
  
  private static final b SHD$58 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "shd");
  
  private static final b FITTEXT$60 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "fitText");
  
  private static final b VERTALIGN$62 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "vertAlign");
  
  private static final b RTL$64 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rtl");
  
  private static final b CS$66 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cs");
  
  private static final b EM$68 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "em");
  
  private static final b LANG$70 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lang");
  
  private static final b EASTASIANLAYOUT$72 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "eastAsianLayout");
  
  private static final b SPECVANISH$74 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "specVanish");
  
  private static final b OMATH$76 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "oMath");
  
  private static final b RPRCHANGE$78 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rPrChange");
  
  public CTRPrImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTString getRStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(RSTYLE$0, 0);
      if (cTString == null)
        return null; 
      return cTString;
    } 
  }
  
  public boolean isSetRStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(RSTYLE$0) != 0);
    } 
  }
  
  public void setRStyle(CTString paramCTString) {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(RSTYLE$0, 0);
      if (cTString == null)
        cTString = (CTString)get_store().add_element_user(RSTYLE$0); 
      cTString.set((XmlObject)paramCTString);
    } 
  }
  
  public CTString addNewRStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().add_element_user(RSTYLE$0);
      return cTString;
    } 
  }
  
  public void unsetRStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(RSTYLE$0, 0);
    } 
  }
  
  public CTFonts getRFonts() {
    synchronized (monitor()) {
      check_orphaned();
      CTFonts cTFonts = null;
      cTFonts = (CTFonts)get_store().find_element_user(RFONTS$2, 0);
      if (cTFonts == null)
        return null; 
      return cTFonts;
    } 
  }
  
  public boolean isSetRFonts() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(RFONTS$2) != 0);
    } 
  }
  
  public void setRFonts(CTFonts paramCTFonts) {
    synchronized (monitor()) {
      check_orphaned();
      CTFonts cTFonts = null;
      cTFonts = (CTFonts)get_store().find_element_user(RFONTS$2, 0);
      if (cTFonts == null)
        cTFonts = (CTFonts)get_store().add_element_user(RFONTS$2); 
      cTFonts.set((XmlObject)paramCTFonts);
    } 
  }
  
  public CTFonts addNewRFonts() {
    synchronized (monitor()) {
      check_orphaned();
      CTFonts cTFonts = null;
      cTFonts = (CTFonts)get_store().add_element_user(RFONTS$2);
      return cTFonts;
    } 
  }
  
  public void unsetRFonts() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(RFONTS$2, 0);
    } 
  }
  
  public CTOnOff getB() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(B$4, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetB() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(B$4) != 0);
    } 
  }
  
  public void setB(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(B$4, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(B$4); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewB() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(B$4);
      return cTOnOff;
    } 
  }
  
  public void unsetB() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(B$4, 0);
    } 
  }
  
  public CTOnOff getBCs() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(BCS$6, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetBCs() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BCS$6) != 0);
    } 
  }
  
  public void setBCs(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(BCS$6, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(BCS$6); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewBCs() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(BCS$6);
      return cTOnOff;
    } 
  }
  
  public void unsetBCs() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BCS$6, 0);
    } 
  }
  
  public CTOnOff getI() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(I$8, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetI() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(I$8) != 0);
    } 
  }
  
  public void setI(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(I$8, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(I$8); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewI() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(I$8);
      return cTOnOff;
    } 
  }
  
  public void unsetI() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(I$8, 0);
    } 
  }
  
  public CTOnOff getICs() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(ICS$10, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetICs() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ICS$10) != 0);
    } 
  }
  
  public void setICs(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(ICS$10, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(ICS$10); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewICs() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(ICS$10);
      return cTOnOff;
    } 
  }
  
  public void unsetICs() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ICS$10, 0);
    } 
  }
  
  public CTOnOff getCaps() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(CAPS$12, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetCaps() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CAPS$12) != 0);
    } 
  }
  
  public void setCaps(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(CAPS$12, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(CAPS$12); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewCaps() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(CAPS$12);
      return cTOnOff;
    } 
  }
  
  public void unsetCaps() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CAPS$12, 0);
    } 
  }
  
  public CTOnOff getSmallCaps() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SMALLCAPS$14, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetSmallCaps() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SMALLCAPS$14) != 0);
    } 
  }
  
  public void setSmallCaps(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SMALLCAPS$14, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(SMALLCAPS$14); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewSmallCaps() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(SMALLCAPS$14);
      return cTOnOff;
    } 
  }
  
  public void unsetSmallCaps() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SMALLCAPS$14, 0);
    } 
  }
  
  public CTOnOff getStrike() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(STRIKE$16, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetStrike() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(STRIKE$16) != 0);
    } 
  }
  
  public void setStrike(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(STRIKE$16, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(STRIKE$16); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewStrike() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(STRIKE$16);
      return cTOnOff;
    } 
  }
  
  public void unsetStrike() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(STRIKE$16, 0);
    } 
  }
  
  public CTOnOff getDstrike() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(DSTRIKE$18, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetDstrike() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DSTRIKE$18) != 0);
    } 
  }
  
  public void setDstrike(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(DSTRIKE$18, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(DSTRIKE$18); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewDstrike() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(DSTRIKE$18);
      return cTOnOff;
    } 
  }
  
  public void unsetDstrike() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DSTRIKE$18, 0);
    } 
  }
  
  public CTOnOff getOutline() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(OUTLINE$20, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetOutline() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(OUTLINE$20) != 0);
    } 
  }
  
  public void setOutline(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(OUTLINE$20, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(OUTLINE$20); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewOutline() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(OUTLINE$20);
      return cTOnOff;
    } 
  }
  
  public void unsetOutline() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(OUTLINE$20, 0);
    } 
  }
  
  public CTOnOff getShadow() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SHADOW$22, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetShadow() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SHADOW$22) != 0);
    } 
  }
  
  public void setShadow(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SHADOW$22, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(SHADOW$22); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewShadow() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(SHADOW$22);
      return cTOnOff;
    } 
  }
  
  public void unsetShadow() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SHADOW$22, 0);
    } 
  }
  
  public CTOnOff getEmboss() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(EMBOSS$24, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetEmboss() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EMBOSS$24) != 0);
    } 
  }
  
  public void setEmboss(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(EMBOSS$24, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(EMBOSS$24); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewEmboss() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(EMBOSS$24);
      return cTOnOff;
    } 
  }
  
  public void unsetEmboss() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EMBOSS$24, 0);
    } 
  }
  
  public CTOnOff getImprint() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(IMPRINT$26, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetImprint() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(IMPRINT$26) != 0);
    } 
  }
  
  public void setImprint(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(IMPRINT$26, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(IMPRINT$26); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewImprint() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(IMPRINT$26);
      return cTOnOff;
    } 
  }
  
  public void unsetImprint() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(IMPRINT$26, 0);
    } 
  }
  
  public CTOnOff getNoProof() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(NOPROOF$28, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetNoProof() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NOPROOF$28) != 0);
    } 
  }
  
  public void setNoProof(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(NOPROOF$28, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(NOPROOF$28); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewNoProof() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(NOPROOF$28);
      return cTOnOff;
    } 
  }
  
  public void unsetNoProof() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NOPROOF$28, 0);
    } 
  }
  
  public CTOnOff getSnapToGrid() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SNAPTOGRID$30, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetSnapToGrid() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SNAPTOGRID$30) != 0);
    } 
  }
  
  public void setSnapToGrid(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SNAPTOGRID$30, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(SNAPTOGRID$30); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewSnapToGrid() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(SNAPTOGRID$30);
      return cTOnOff;
    } 
  }
  
  public void unsetSnapToGrid() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SNAPTOGRID$30, 0);
    } 
  }
  
  public CTOnOff getVanish() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(VANISH$32, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetVanish() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(VANISH$32) != 0);
    } 
  }
  
  public void setVanish(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(VANISH$32, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(VANISH$32); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewVanish() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(VANISH$32);
      return cTOnOff;
    } 
  }
  
  public void unsetVanish() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(VANISH$32, 0);
    } 
  }
  
  public CTOnOff getWebHidden() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(WEBHIDDEN$34, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetWebHidden() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(WEBHIDDEN$34) != 0);
    } 
  }
  
  public void setWebHidden(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(WEBHIDDEN$34, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(WEBHIDDEN$34); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewWebHidden() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(WEBHIDDEN$34);
      return cTOnOff;
    } 
  }
  
  public void unsetWebHidden() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(WEBHIDDEN$34, 0);
    } 
  }
  
  public CTColor getColor() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(COLOR$36, 0);
      if (cTColor == null)
        return null; 
      return cTColor;
    } 
  }
  
  public boolean isSetColor() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(COLOR$36) != 0);
    } 
  }
  
  public void setColor(CTColor paramCTColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(COLOR$36, 0);
      if (cTColor == null)
        cTColor = (CTColor)get_store().add_element_user(COLOR$36); 
      cTColor.set((XmlObject)paramCTColor);
    } 
  }
  
  public CTColor addNewColor() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().add_element_user(COLOR$36);
      return cTColor;
    } 
  }
  
  public void unsetColor() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(COLOR$36, 0);
    } 
  }
  
  public CTSignedTwipsMeasure getSpacing() {
    synchronized (monitor()) {
      check_orphaned();
      CTSignedTwipsMeasure cTSignedTwipsMeasure = null;
      cTSignedTwipsMeasure = (CTSignedTwipsMeasure)get_store().find_element_user(SPACING$38, 0);
      if (cTSignedTwipsMeasure == null)
        return null; 
      return cTSignedTwipsMeasure;
    } 
  }
  
  public boolean isSetSpacing() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SPACING$38) != 0);
    } 
  }
  
  public void setSpacing(CTSignedTwipsMeasure paramCTSignedTwipsMeasure) {
    synchronized (monitor()) {
      check_orphaned();
      CTSignedTwipsMeasure cTSignedTwipsMeasure = null;
      cTSignedTwipsMeasure = (CTSignedTwipsMeasure)get_store().find_element_user(SPACING$38, 0);
      if (cTSignedTwipsMeasure == null)
        cTSignedTwipsMeasure = (CTSignedTwipsMeasure)get_store().add_element_user(SPACING$38); 
      cTSignedTwipsMeasure.set((XmlObject)paramCTSignedTwipsMeasure);
    } 
  }
  
  public CTSignedTwipsMeasure addNewSpacing() {
    synchronized (monitor()) {
      check_orphaned();
      CTSignedTwipsMeasure cTSignedTwipsMeasure = null;
      cTSignedTwipsMeasure = (CTSignedTwipsMeasure)get_store().add_element_user(SPACING$38);
      return cTSignedTwipsMeasure;
    } 
  }
  
  public void unsetSpacing() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SPACING$38, 0);
    } 
  }
  
  public CTTextScale getW() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextScale cTTextScale = null;
      cTTextScale = (CTTextScale)get_store().find_element_user(W$40, 0);
      if (cTTextScale == null)
        return null; 
      return cTTextScale;
    } 
  }
  
  public boolean isSetW() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(W$40) != 0);
    } 
  }
  
  public void setW(CTTextScale paramCTTextScale) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextScale cTTextScale = null;
      cTTextScale = (CTTextScale)get_store().find_element_user(W$40, 0);
      if (cTTextScale == null)
        cTTextScale = (CTTextScale)get_store().add_element_user(W$40); 
      cTTextScale.set((XmlObject)paramCTTextScale);
    } 
  }
  
  public CTTextScale addNewW() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextScale cTTextScale = null;
      cTTextScale = (CTTextScale)get_store().add_element_user(W$40);
      return cTTextScale;
    } 
  }
  
  public void unsetW() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(W$40, 0);
    } 
  }
  
  public CTHpsMeasure getKern() {
    synchronized (monitor()) {
      check_orphaned();
      CTHpsMeasure cTHpsMeasure = null;
      cTHpsMeasure = (CTHpsMeasure)get_store().find_element_user(KERN$42, 0);
      if (cTHpsMeasure == null)
        return null; 
      return cTHpsMeasure;
    } 
  }
  
  public boolean isSetKern() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(KERN$42) != 0);
    } 
  }
  
  public void setKern(CTHpsMeasure paramCTHpsMeasure) {
    synchronized (monitor()) {
      check_orphaned();
      CTHpsMeasure cTHpsMeasure = null;
      cTHpsMeasure = (CTHpsMeasure)get_store().find_element_user(KERN$42, 0);
      if (cTHpsMeasure == null)
        cTHpsMeasure = (CTHpsMeasure)get_store().add_element_user(KERN$42); 
      cTHpsMeasure.set((XmlObject)paramCTHpsMeasure);
    } 
  }
  
  public CTHpsMeasure addNewKern() {
    synchronized (monitor()) {
      check_orphaned();
      CTHpsMeasure cTHpsMeasure = null;
      cTHpsMeasure = (CTHpsMeasure)get_store().add_element_user(KERN$42);
      return cTHpsMeasure;
    } 
  }
  
  public void unsetKern() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(KERN$42, 0);
    } 
  }
  
  public CTSignedHpsMeasure getPosition() {
    synchronized (monitor()) {
      check_orphaned();
      CTSignedHpsMeasure cTSignedHpsMeasure = null;
      cTSignedHpsMeasure = (CTSignedHpsMeasure)get_store().find_element_user(POSITION$44, 0);
      if (cTSignedHpsMeasure == null)
        return null; 
      return cTSignedHpsMeasure;
    } 
  }
  
  public boolean isSetPosition() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(POSITION$44) != 0);
    } 
  }
  
  public void setPosition(CTSignedHpsMeasure paramCTSignedHpsMeasure) {
    synchronized (monitor()) {
      check_orphaned();
      CTSignedHpsMeasure cTSignedHpsMeasure = null;
      cTSignedHpsMeasure = (CTSignedHpsMeasure)get_store().find_element_user(POSITION$44, 0);
      if (cTSignedHpsMeasure == null)
        cTSignedHpsMeasure = (CTSignedHpsMeasure)get_store().add_element_user(POSITION$44); 
      cTSignedHpsMeasure.set((XmlObject)paramCTSignedHpsMeasure);
    } 
  }
  
  public CTSignedHpsMeasure addNewPosition() {
    synchronized (monitor()) {
      check_orphaned();
      CTSignedHpsMeasure cTSignedHpsMeasure = null;
      cTSignedHpsMeasure = (CTSignedHpsMeasure)get_store().add_element_user(POSITION$44);
      return cTSignedHpsMeasure;
    } 
  }
  
  public void unsetPosition() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(POSITION$44, 0);
    } 
  }
  
  public CTHpsMeasure getSz() {
    synchronized (monitor()) {
      check_orphaned();
      CTHpsMeasure cTHpsMeasure = null;
      cTHpsMeasure = (CTHpsMeasure)get_store().find_element_user(SZ$46, 0);
      if (cTHpsMeasure == null)
        return null; 
      return cTHpsMeasure;
    } 
  }
  
  public boolean isSetSz() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SZ$46) != 0);
    } 
  }
  
  public void setSz(CTHpsMeasure paramCTHpsMeasure) {
    synchronized (monitor()) {
      check_orphaned();
      CTHpsMeasure cTHpsMeasure = null;
      cTHpsMeasure = (CTHpsMeasure)get_store().find_element_user(SZ$46, 0);
      if (cTHpsMeasure == null)
        cTHpsMeasure = (CTHpsMeasure)get_store().add_element_user(SZ$46); 
      cTHpsMeasure.set((XmlObject)paramCTHpsMeasure);
    } 
  }
  
  public CTHpsMeasure addNewSz() {
    synchronized (monitor()) {
      check_orphaned();
      CTHpsMeasure cTHpsMeasure = null;
      cTHpsMeasure = (CTHpsMeasure)get_store().add_element_user(SZ$46);
      return cTHpsMeasure;
    } 
  }
  
  public void unsetSz() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SZ$46, 0);
    } 
  }
  
  public CTHpsMeasure getSzCs() {
    synchronized (monitor()) {
      check_orphaned();
      CTHpsMeasure cTHpsMeasure = null;
      cTHpsMeasure = (CTHpsMeasure)get_store().find_element_user(SZCS$48, 0);
      if (cTHpsMeasure == null)
        return null; 
      return cTHpsMeasure;
    } 
  }
  
  public boolean isSetSzCs() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SZCS$48) != 0);
    } 
  }
  
  public void setSzCs(CTHpsMeasure paramCTHpsMeasure) {
    synchronized (monitor()) {
      check_orphaned();
      CTHpsMeasure cTHpsMeasure = null;
      cTHpsMeasure = (CTHpsMeasure)get_store().find_element_user(SZCS$48, 0);
      if (cTHpsMeasure == null)
        cTHpsMeasure = (CTHpsMeasure)get_store().add_element_user(SZCS$48); 
      cTHpsMeasure.set((XmlObject)paramCTHpsMeasure);
    } 
  }
  
  public CTHpsMeasure addNewSzCs() {
    synchronized (monitor()) {
      check_orphaned();
      CTHpsMeasure cTHpsMeasure = null;
      cTHpsMeasure = (CTHpsMeasure)get_store().add_element_user(SZCS$48);
      return cTHpsMeasure;
    } 
  }
  
  public void unsetSzCs() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SZCS$48, 0);
    } 
  }
  
  public CTHighlight getHighlight() {
    synchronized (monitor()) {
      check_orphaned();
      CTHighlight cTHighlight = null;
      cTHighlight = (CTHighlight)get_store().find_element_user(HIGHLIGHT$50, 0);
      if (cTHighlight == null)
        return null; 
      return cTHighlight;
    } 
  }
  
  public boolean isSetHighlight() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(HIGHLIGHT$50) != 0);
    } 
  }
  
  public void setHighlight(CTHighlight paramCTHighlight) {
    synchronized (monitor()) {
      check_orphaned();
      CTHighlight cTHighlight = null;
      cTHighlight = (CTHighlight)get_store().find_element_user(HIGHLIGHT$50, 0);
      if (cTHighlight == null)
        cTHighlight = (CTHighlight)get_store().add_element_user(HIGHLIGHT$50); 
      cTHighlight.set((XmlObject)paramCTHighlight);
    } 
  }
  
  public CTHighlight addNewHighlight() {
    synchronized (monitor()) {
      check_orphaned();
      CTHighlight cTHighlight = null;
      cTHighlight = (CTHighlight)get_store().add_element_user(HIGHLIGHT$50);
      return cTHighlight;
    } 
  }
  
  public void unsetHighlight() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HIGHLIGHT$50, 0);
    } 
  }
  
  public CTUnderline getU() {
    synchronized (monitor()) {
      check_orphaned();
      CTUnderline cTUnderline = null;
      cTUnderline = (CTUnderline)get_store().find_element_user(U$52, 0);
      if (cTUnderline == null)
        return null; 
      return cTUnderline;
    } 
  }
  
  public boolean isSetU() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(U$52) != 0);
    } 
  }
  
  public void setU(CTUnderline paramCTUnderline) {
    synchronized (monitor()) {
      check_orphaned();
      CTUnderline cTUnderline = null;
      cTUnderline = (CTUnderline)get_store().find_element_user(U$52, 0);
      if (cTUnderline == null)
        cTUnderline = (CTUnderline)get_store().add_element_user(U$52); 
      cTUnderline.set((XmlObject)paramCTUnderline);
    } 
  }
  
  public CTUnderline addNewU() {
    synchronized (monitor()) {
      check_orphaned();
      CTUnderline cTUnderline = null;
      cTUnderline = (CTUnderline)get_store().add_element_user(U$52);
      return cTUnderline;
    } 
  }
  
  public void unsetU() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(U$52, 0);
    } 
  }
  
  public CTTextEffect getEffect() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextEffect cTTextEffect = null;
      cTTextEffect = (CTTextEffect)get_store().find_element_user(EFFECT$54, 0);
      if (cTTextEffect == null)
        return null; 
      return cTTextEffect;
    } 
  }
  
  public boolean isSetEffect() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EFFECT$54) != 0);
    } 
  }
  
  public void setEffect(CTTextEffect paramCTTextEffect) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextEffect cTTextEffect = null;
      cTTextEffect = (CTTextEffect)get_store().find_element_user(EFFECT$54, 0);
      if (cTTextEffect == null)
        cTTextEffect = (CTTextEffect)get_store().add_element_user(EFFECT$54); 
      cTTextEffect.set((XmlObject)paramCTTextEffect);
    } 
  }
  
  public CTTextEffect addNewEffect() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextEffect cTTextEffect = null;
      cTTextEffect = (CTTextEffect)get_store().add_element_user(EFFECT$54);
      return cTTextEffect;
    } 
  }
  
  public void unsetEffect() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EFFECT$54, 0);
    } 
  }
  
  public CTBorder getBdr() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().find_element_user(BDR$56, 0);
      if (cTBorder == null)
        return null; 
      return cTBorder;
    } 
  }
  
  public boolean isSetBdr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BDR$56) != 0);
    } 
  }
  
  public void setBdr(CTBorder paramCTBorder) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().find_element_user(BDR$56, 0);
      if (cTBorder == null)
        cTBorder = (CTBorder)get_store().add_element_user(BDR$56); 
      cTBorder.set((XmlObject)paramCTBorder);
    } 
  }
  
  public CTBorder addNewBdr() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().add_element_user(BDR$56);
      return cTBorder;
    } 
  }
  
  public void unsetBdr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BDR$56, 0);
    } 
  }
  
  public CTShd getShd() {
    synchronized (monitor()) {
      check_orphaned();
      CTShd cTShd = null;
      cTShd = (CTShd)get_store().find_element_user(SHD$58, 0);
      if (cTShd == null)
        return null; 
      return cTShd;
    } 
  }
  
  public boolean isSetShd() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SHD$58) != 0);
    } 
  }
  
  public void setShd(CTShd paramCTShd) {
    synchronized (monitor()) {
      check_orphaned();
      CTShd cTShd = null;
      cTShd = (CTShd)get_store().find_element_user(SHD$58, 0);
      if (cTShd == null)
        cTShd = (CTShd)get_store().add_element_user(SHD$58); 
      cTShd.set((XmlObject)paramCTShd);
    } 
  }
  
  public CTShd addNewShd() {
    synchronized (monitor()) {
      check_orphaned();
      CTShd cTShd = null;
      cTShd = (CTShd)get_store().add_element_user(SHD$58);
      return cTShd;
    } 
  }
  
  public void unsetShd() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SHD$58, 0);
    } 
  }
  
  public CTFitText getFitText() {
    synchronized (monitor()) {
      check_orphaned();
      CTFitText cTFitText = null;
      cTFitText = (CTFitText)get_store().find_element_user(FITTEXT$60, 0);
      if (cTFitText == null)
        return null; 
      return cTFitText;
    } 
  }
  
  public boolean isSetFitText() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FITTEXT$60) != 0);
    } 
  }
  
  public void setFitText(CTFitText paramCTFitText) {
    synchronized (monitor()) {
      check_orphaned();
      CTFitText cTFitText = null;
      cTFitText = (CTFitText)get_store().find_element_user(FITTEXT$60, 0);
      if (cTFitText == null)
        cTFitText = (CTFitText)get_store().add_element_user(FITTEXT$60); 
      cTFitText.set((XmlObject)paramCTFitText);
    } 
  }
  
  public CTFitText addNewFitText() {
    synchronized (monitor()) {
      check_orphaned();
      CTFitText cTFitText = null;
      cTFitText = (CTFitText)get_store().add_element_user(FITTEXT$60);
      return cTFitText;
    } 
  }
  
  public void unsetFitText() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FITTEXT$60, 0);
    } 
  }
  
  public CTVerticalAlignRun getVertAlign() {
    synchronized (monitor()) {
      check_orphaned();
      CTVerticalAlignRun cTVerticalAlignRun = null;
      cTVerticalAlignRun = (CTVerticalAlignRun)get_store().find_element_user(VERTALIGN$62, 0);
      if (cTVerticalAlignRun == null)
        return null; 
      return cTVerticalAlignRun;
    } 
  }
  
  public boolean isSetVertAlign() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(VERTALIGN$62) != 0);
    } 
  }
  
  public void setVertAlign(CTVerticalAlignRun paramCTVerticalAlignRun) {
    synchronized (monitor()) {
      check_orphaned();
      CTVerticalAlignRun cTVerticalAlignRun = null;
      cTVerticalAlignRun = (CTVerticalAlignRun)get_store().find_element_user(VERTALIGN$62, 0);
      if (cTVerticalAlignRun == null)
        cTVerticalAlignRun = (CTVerticalAlignRun)get_store().add_element_user(VERTALIGN$62); 
      cTVerticalAlignRun.set((XmlObject)paramCTVerticalAlignRun);
    } 
  }
  
  public CTVerticalAlignRun addNewVertAlign() {
    synchronized (monitor()) {
      check_orphaned();
      CTVerticalAlignRun cTVerticalAlignRun = null;
      cTVerticalAlignRun = (CTVerticalAlignRun)get_store().add_element_user(VERTALIGN$62);
      return cTVerticalAlignRun;
    } 
  }
  
  public void unsetVertAlign() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(VERTALIGN$62, 0);
    } 
  }
  
  public CTOnOff getRtl() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(RTL$64, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetRtl() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(RTL$64) != 0);
    } 
  }
  
  public void setRtl(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(RTL$64, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(RTL$64); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewRtl() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(RTL$64);
      return cTOnOff;
    } 
  }
  
  public void unsetRtl() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(RTL$64, 0);
    } 
  }
  
  public CTOnOff getCs() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(CS$66, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetCs() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CS$66) != 0);
    } 
  }
  
  public void setCs(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(CS$66, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(CS$66); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewCs() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(CS$66);
      return cTOnOff;
    } 
  }
  
  public void unsetCs() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CS$66, 0);
    } 
  }
  
  public CTEm getEm() {
    synchronized (monitor()) {
      check_orphaned();
      CTEm cTEm = null;
      cTEm = (CTEm)get_store().find_element_user(EM$68, 0);
      if (cTEm == null)
        return null; 
      return cTEm;
    } 
  }
  
  public boolean isSetEm() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EM$68) != 0);
    } 
  }
  
  public void setEm(CTEm paramCTEm) {
    synchronized (monitor()) {
      check_orphaned();
      CTEm cTEm = null;
      cTEm = (CTEm)get_store().find_element_user(EM$68, 0);
      if (cTEm == null)
        cTEm = (CTEm)get_store().add_element_user(EM$68); 
      cTEm.set((XmlObject)paramCTEm);
    } 
  }
  
  public CTEm addNewEm() {
    synchronized (monitor()) {
      check_orphaned();
      CTEm cTEm = null;
      cTEm = (CTEm)get_store().add_element_user(EM$68);
      return cTEm;
    } 
  }
  
  public void unsetEm() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EM$68, 0);
    } 
  }
  
  public CTLanguage getLang() {
    synchronized (monitor()) {
      check_orphaned();
      CTLanguage cTLanguage = null;
      cTLanguage = (CTLanguage)get_store().find_element_user(LANG$70, 0);
      if (cTLanguage == null)
        return null; 
      return cTLanguage;
    } 
  }
  
  public boolean isSetLang() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LANG$70) != 0);
    } 
  }
  
  public void setLang(CTLanguage paramCTLanguage) {
    synchronized (monitor()) {
      check_orphaned();
      CTLanguage cTLanguage = null;
      cTLanguage = (CTLanguage)get_store().find_element_user(LANG$70, 0);
      if (cTLanguage == null)
        cTLanguage = (CTLanguage)get_store().add_element_user(LANG$70); 
      cTLanguage.set((XmlObject)paramCTLanguage);
    } 
  }
  
  public CTLanguage addNewLang() {
    synchronized (monitor()) {
      check_orphaned();
      CTLanguage cTLanguage = null;
      cTLanguage = (CTLanguage)get_store().add_element_user(LANG$70);
      return cTLanguage;
    } 
  }
  
  public void unsetLang() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LANG$70, 0);
    } 
  }
  
  public CTEastAsianLayout getEastAsianLayout() {
    synchronized (monitor()) {
      check_orphaned();
      CTEastAsianLayout cTEastAsianLayout = null;
      cTEastAsianLayout = (CTEastAsianLayout)get_store().find_element_user(EASTASIANLAYOUT$72, 0);
      if (cTEastAsianLayout == null)
        return null; 
      return cTEastAsianLayout;
    } 
  }
  
  public boolean isSetEastAsianLayout() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EASTASIANLAYOUT$72) != 0);
    } 
  }
  
  public void setEastAsianLayout(CTEastAsianLayout paramCTEastAsianLayout) {
    synchronized (monitor()) {
      check_orphaned();
      CTEastAsianLayout cTEastAsianLayout = null;
      cTEastAsianLayout = (CTEastAsianLayout)get_store().find_element_user(EASTASIANLAYOUT$72, 0);
      if (cTEastAsianLayout == null)
        cTEastAsianLayout = (CTEastAsianLayout)get_store().add_element_user(EASTASIANLAYOUT$72); 
      cTEastAsianLayout.set((XmlObject)paramCTEastAsianLayout);
    } 
  }
  
  public CTEastAsianLayout addNewEastAsianLayout() {
    synchronized (monitor()) {
      check_orphaned();
      CTEastAsianLayout cTEastAsianLayout = null;
      cTEastAsianLayout = (CTEastAsianLayout)get_store().add_element_user(EASTASIANLAYOUT$72);
      return cTEastAsianLayout;
    } 
  }
  
  public void unsetEastAsianLayout() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EASTASIANLAYOUT$72, 0);
    } 
  }
  
  public CTOnOff getSpecVanish() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SPECVANISH$74, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetSpecVanish() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SPECVANISH$74) != 0);
    } 
  }
  
  public void setSpecVanish(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SPECVANISH$74, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(SPECVANISH$74); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewSpecVanish() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(SPECVANISH$74);
      return cTOnOff;
    } 
  }
  
  public void unsetSpecVanish() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SPECVANISH$74, 0);
    } 
  }
  
  public CTOnOff getOMath() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(OMATH$76, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetOMath() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(OMATH$76) != 0);
    } 
  }
  
  public void setOMath(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(OMATH$76, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(OMATH$76); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewOMath() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(OMATH$76);
      return cTOnOff;
    } 
  }
  
  public void unsetOMath() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(OMATH$76, 0);
    } 
  }
  
  public CTRPrChange getRPrChange() {
    synchronized (monitor()) {
      check_orphaned();
      CTRPrChange cTRPrChange = null;
      cTRPrChange = (CTRPrChange)get_store().find_element_user(RPRCHANGE$78, 0);
      if (cTRPrChange == null)
        return null; 
      return cTRPrChange;
    } 
  }
  
  public boolean isSetRPrChange() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(RPRCHANGE$78) != 0);
    } 
  }
  
  public void setRPrChange(CTRPrChange paramCTRPrChange) {
    synchronized (monitor()) {
      check_orphaned();
      CTRPrChange cTRPrChange = null;
      cTRPrChange = (CTRPrChange)get_store().find_element_user(RPRCHANGE$78, 0);
      if (cTRPrChange == null)
        cTRPrChange = (CTRPrChange)get_store().add_element_user(RPRCHANGE$78); 
      cTRPrChange.set((XmlObject)paramCTRPrChange);
    } 
  }
  
  public CTRPrChange addNewRPrChange() {
    synchronized (monitor()) {
      check_orphaned();
      CTRPrChange cTRPrChange = null;
      cTRPrChange = (CTRPrChange)get_store().add_element_user(RPRCHANGE$78);
      return cTRPrChange;
    } 
  }
  
  public void unsetRPrChange() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(RPRCHANGE$78, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTRPrImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */