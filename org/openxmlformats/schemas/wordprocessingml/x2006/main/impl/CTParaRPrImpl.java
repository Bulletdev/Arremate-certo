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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSignedHpsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSignedTwipsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextEffect;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextScale;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalAlignRun;

public class CTParaRPrImpl extends XmlComplexContentImpl implements CTParaRPr {
  private static final b INS$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ins");
  
  private static final b DEL$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "del");
  
  private static final b MOVEFROM$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFrom");
  
  private static final b MOVETO$6 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveTo");
  
  private static final b RSTYLE$8 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rStyle");
  
  private static final b RFONTS$10 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rFonts");
  
  private static final b B$12 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "b");
  
  private static final b BCS$14 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bCs");
  
  private static final b I$16 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "i");
  
  private static final b ICS$18 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "iCs");
  
  private static final b CAPS$20 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "caps");
  
  private static final b SMALLCAPS$22 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "smallCaps");
  
  private static final b STRIKE$24 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "strike");
  
  private static final b DSTRIKE$26 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "dstrike");
  
  private static final b OUTLINE$28 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "outline");
  
  private static final b SHADOW$30 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "shadow");
  
  private static final b EMBOSS$32 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "emboss");
  
  private static final b IMPRINT$34 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "imprint");
  
  private static final b NOPROOF$36 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "noProof");
  
  private static final b SNAPTOGRID$38 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "snapToGrid");
  
  private static final b VANISH$40 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "vanish");
  
  private static final b WEBHIDDEN$42 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "webHidden");
  
  private static final b COLOR$44 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "color");
  
  private static final b SPACING$46 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "spacing");
  
  private static final b W$48 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "w");
  
  private static final b KERN$50 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "kern");
  
  private static final b POSITION$52 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "position");
  
  private static final b SZ$54 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sz");
  
  private static final b SZCS$56 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "szCs");
  
  private static final b HIGHLIGHT$58 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "highlight");
  
  private static final b U$60 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "u");
  
  private static final b EFFECT$62 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "effect");
  
  private static final b BDR$64 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bdr");
  
  private static final b SHD$66 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "shd");
  
  private static final b FITTEXT$68 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "fitText");
  
  private static final b VERTALIGN$70 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "vertAlign");
  
  private static final b RTL$72 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rtl");
  
  private static final b CS$74 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cs");
  
  private static final b EM$76 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "em");
  
  private static final b LANG$78 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lang");
  
  private static final b EASTASIANLAYOUT$80 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "eastAsianLayout");
  
  private static final b SPECVANISH$82 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "specVanish");
  
  private static final b OMATH$84 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "oMath");
  
  private static final b RPRCHANGE$86 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rPrChange");
  
  public CTParaRPrImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTTrackChange getIns() {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().find_element_user(INS$0, 0);
      if (cTTrackChange == null)
        return null; 
      return cTTrackChange;
    } 
  }
  
  public boolean isSetIns() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(INS$0) != 0);
    } 
  }
  
  public void setIns(CTTrackChange paramCTTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().find_element_user(INS$0, 0);
      if (cTTrackChange == null)
        cTTrackChange = (CTTrackChange)get_store().add_element_user(INS$0); 
      cTTrackChange.set((XmlObject)paramCTTrackChange);
    } 
  }
  
  public CTTrackChange addNewIns() {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().add_element_user(INS$0);
      return cTTrackChange;
    } 
  }
  
  public void unsetIns() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(INS$0, 0);
    } 
  }
  
  public CTTrackChange getDel() {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().find_element_user(DEL$2, 0);
      if (cTTrackChange == null)
        return null; 
      return cTTrackChange;
    } 
  }
  
  public boolean isSetDel() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DEL$2) != 0);
    } 
  }
  
  public void setDel(CTTrackChange paramCTTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().find_element_user(DEL$2, 0);
      if (cTTrackChange == null)
        cTTrackChange = (CTTrackChange)get_store().add_element_user(DEL$2); 
      cTTrackChange.set((XmlObject)paramCTTrackChange);
    } 
  }
  
  public CTTrackChange addNewDel() {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().add_element_user(DEL$2);
      return cTTrackChange;
    } 
  }
  
  public void unsetDel() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DEL$2, 0);
    } 
  }
  
  public CTTrackChange getMoveFrom() {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().find_element_user(MOVEFROM$4, 0);
      if (cTTrackChange == null)
        return null; 
      return cTTrackChange;
    } 
  }
  
  public boolean isSetMoveFrom() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(MOVEFROM$4) != 0);
    } 
  }
  
  public void setMoveFrom(CTTrackChange paramCTTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().find_element_user(MOVEFROM$4, 0);
      if (cTTrackChange == null)
        cTTrackChange = (CTTrackChange)get_store().add_element_user(MOVEFROM$4); 
      cTTrackChange.set((XmlObject)paramCTTrackChange);
    } 
  }
  
  public CTTrackChange addNewMoveFrom() {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().add_element_user(MOVEFROM$4);
      return cTTrackChange;
    } 
  }
  
  public void unsetMoveFrom() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MOVEFROM$4, 0);
    } 
  }
  
  public CTTrackChange getMoveTo() {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().find_element_user(MOVETO$6, 0);
      if (cTTrackChange == null)
        return null; 
      return cTTrackChange;
    } 
  }
  
  public boolean isSetMoveTo() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(MOVETO$6) != 0);
    } 
  }
  
  public void setMoveTo(CTTrackChange paramCTTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().find_element_user(MOVETO$6, 0);
      if (cTTrackChange == null)
        cTTrackChange = (CTTrackChange)get_store().add_element_user(MOVETO$6); 
      cTTrackChange.set((XmlObject)paramCTTrackChange);
    } 
  }
  
  public CTTrackChange addNewMoveTo() {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().add_element_user(MOVETO$6);
      return cTTrackChange;
    } 
  }
  
  public void unsetMoveTo() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MOVETO$6, 0);
    } 
  }
  
  public CTString getRStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(RSTYLE$8, 0);
      if (cTString == null)
        return null; 
      return cTString;
    } 
  }
  
  public boolean isSetRStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(RSTYLE$8) != 0);
    } 
  }
  
  public void setRStyle(CTString paramCTString) {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(RSTYLE$8, 0);
      if (cTString == null)
        cTString = (CTString)get_store().add_element_user(RSTYLE$8); 
      cTString.set((XmlObject)paramCTString);
    } 
  }
  
  public CTString addNewRStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().add_element_user(RSTYLE$8);
      return cTString;
    } 
  }
  
  public void unsetRStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(RSTYLE$8, 0);
    } 
  }
  
  public CTFonts getRFonts() {
    synchronized (monitor()) {
      check_orphaned();
      CTFonts cTFonts = null;
      cTFonts = (CTFonts)get_store().find_element_user(RFONTS$10, 0);
      if (cTFonts == null)
        return null; 
      return cTFonts;
    } 
  }
  
  public boolean isSetRFonts() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(RFONTS$10) != 0);
    } 
  }
  
  public void setRFonts(CTFonts paramCTFonts) {
    synchronized (monitor()) {
      check_orphaned();
      CTFonts cTFonts = null;
      cTFonts = (CTFonts)get_store().find_element_user(RFONTS$10, 0);
      if (cTFonts == null)
        cTFonts = (CTFonts)get_store().add_element_user(RFONTS$10); 
      cTFonts.set((XmlObject)paramCTFonts);
    } 
  }
  
  public CTFonts addNewRFonts() {
    synchronized (monitor()) {
      check_orphaned();
      CTFonts cTFonts = null;
      cTFonts = (CTFonts)get_store().add_element_user(RFONTS$10);
      return cTFonts;
    } 
  }
  
  public void unsetRFonts() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(RFONTS$10, 0);
    } 
  }
  
  public CTOnOff getB() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(B$12, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetB() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(B$12) != 0);
    } 
  }
  
  public void setB(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(B$12, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(B$12); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewB() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(B$12);
      return cTOnOff;
    } 
  }
  
  public void unsetB() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(B$12, 0);
    } 
  }
  
  public CTOnOff getBCs() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(BCS$14, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetBCs() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BCS$14) != 0);
    } 
  }
  
  public void setBCs(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(BCS$14, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(BCS$14); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewBCs() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(BCS$14);
      return cTOnOff;
    } 
  }
  
  public void unsetBCs() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BCS$14, 0);
    } 
  }
  
  public CTOnOff getI() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(I$16, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetI() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(I$16) != 0);
    } 
  }
  
  public void setI(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(I$16, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(I$16); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewI() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(I$16);
      return cTOnOff;
    } 
  }
  
  public void unsetI() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(I$16, 0);
    } 
  }
  
  public CTOnOff getICs() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(ICS$18, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetICs() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ICS$18) != 0);
    } 
  }
  
  public void setICs(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(ICS$18, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(ICS$18); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewICs() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(ICS$18);
      return cTOnOff;
    } 
  }
  
  public void unsetICs() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ICS$18, 0);
    } 
  }
  
  public CTOnOff getCaps() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(CAPS$20, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetCaps() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CAPS$20) != 0);
    } 
  }
  
  public void setCaps(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(CAPS$20, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(CAPS$20); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewCaps() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(CAPS$20);
      return cTOnOff;
    } 
  }
  
  public void unsetCaps() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CAPS$20, 0);
    } 
  }
  
  public CTOnOff getSmallCaps() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SMALLCAPS$22, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetSmallCaps() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SMALLCAPS$22) != 0);
    } 
  }
  
  public void setSmallCaps(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SMALLCAPS$22, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(SMALLCAPS$22); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewSmallCaps() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(SMALLCAPS$22);
      return cTOnOff;
    } 
  }
  
  public void unsetSmallCaps() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SMALLCAPS$22, 0);
    } 
  }
  
  public CTOnOff getStrike() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(STRIKE$24, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetStrike() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(STRIKE$24) != 0);
    } 
  }
  
  public void setStrike(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(STRIKE$24, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(STRIKE$24); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewStrike() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(STRIKE$24);
      return cTOnOff;
    } 
  }
  
  public void unsetStrike() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(STRIKE$24, 0);
    } 
  }
  
  public CTOnOff getDstrike() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(DSTRIKE$26, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetDstrike() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DSTRIKE$26) != 0);
    } 
  }
  
  public void setDstrike(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(DSTRIKE$26, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(DSTRIKE$26); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewDstrike() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(DSTRIKE$26);
      return cTOnOff;
    } 
  }
  
  public void unsetDstrike() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DSTRIKE$26, 0);
    } 
  }
  
  public CTOnOff getOutline() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(OUTLINE$28, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetOutline() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(OUTLINE$28) != 0);
    } 
  }
  
  public void setOutline(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(OUTLINE$28, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(OUTLINE$28); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewOutline() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(OUTLINE$28);
      return cTOnOff;
    } 
  }
  
  public void unsetOutline() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(OUTLINE$28, 0);
    } 
  }
  
  public CTOnOff getShadow() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SHADOW$30, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetShadow() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SHADOW$30) != 0);
    } 
  }
  
  public void setShadow(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SHADOW$30, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(SHADOW$30); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewShadow() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(SHADOW$30);
      return cTOnOff;
    } 
  }
  
  public void unsetShadow() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SHADOW$30, 0);
    } 
  }
  
  public CTOnOff getEmboss() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(EMBOSS$32, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetEmboss() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EMBOSS$32) != 0);
    } 
  }
  
  public void setEmboss(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(EMBOSS$32, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(EMBOSS$32); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewEmboss() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(EMBOSS$32);
      return cTOnOff;
    } 
  }
  
  public void unsetEmboss() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EMBOSS$32, 0);
    } 
  }
  
  public CTOnOff getImprint() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(IMPRINT$34, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetImprint() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(IMPRINT$34) != 0);
    } 
  }
  
  public void setImprint(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(IMPRINT$34, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(IMPRINT$34); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewImprint() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(IMPRINT$34);
      return cTOnOff;
    } 
  }
  
  public void unsetImprint() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(IMPRINT$34, 0);
    } 
  }
  
  public CTOnOff getNoProof() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(NOPROOF$36, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetNoProof() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NOPROOF$36) != 0);
    } 
  }
  
  public void setNoProof(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(NOPROOF$36, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(NOPROOF$36); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewNoProof() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(NOPROOF$36);
      return cTOnOff;
    } 
  }
  
  public void unsetNoProof() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NOPROOF$36, 0);
    } 
  }
  
  public CTOnOff getSnapToGrid() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SNAPTOGRID$38, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetSnapToGrid() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SNAPTOGRID$38) != 0);
    } 
  }
  
  public void setSnapToGrid(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SNAPTOGRID$38, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(SNAPTOGRID$38); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewSnapToGrid() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(SNAPTOGRID$38);
      return cTOnOff;
    } 
  }
  
  public void unsetSnapToGrid() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SNAPTOGRID$38, 0);
    } 
  }
  
  public CTOnOff getVanish() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(VANISH$40, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetVanish() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(VANISH$40) != 0);
    } 
  }
  
  public void setVanish(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(VANISH$40, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(VANISH$40); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewVanish() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(VANISH$40);
      return cTOnOff;
    } 
  }
  
  public void unsetVanish() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(VANISH$40, 0);
    } 
  }
  
  public CTOnOff getWebHidden() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(WEBHIDDEN$42, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetWebHidden() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(WEBHIDDEN$42) != 0);
    } 
  }
  
  public void setWebHidden(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(WEBHIDDEN$42, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(WEBHIDDEN$42); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewWebHidden() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(WEBHIDDEN$42);
      return cTOnOff;
    } 
  }
  
  public void unsetWebHidden() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(WEBHIDDEN$42, 0);
    } 
  }
  
  public CTColor getColor() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(COLOR$44, 0);
      if (cTColor == null)
        return null; 
      return cTColor;
    } 
  }
  
  public boolean isSetColor() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(COLOR$44) != 0);
    } 
  }
  
  public void setColor(CTColor paramCTColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(COLOR$44, 0);
      if (cTColor == null)
        cTColor = (CTColor)get_store().add_element_user(COLOR$44); 
      cTColor.set((XmlObject)paramCTColor);
    } 
  }
  
  public CTColor addNewColor() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().add_element_user(COLOR$44);
      return cTColor;
    } 
  }
  
  public void unsetColor() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(COLOR$44, 0);
    } 
  }
  
  public CTSignedTwipsMeasure getSpacing() {
    synchronized (monitor()) {
      check_orphaned();
      CTSignedTwipsMeasure cTSignedTwipsMeasure = null;
      cTSignedTwipsMeasure = (CTSignedTwipsMeasure)get_store().find_element_user(SPACING$46, 0);
      if (cTSignedTwipsMeasure == null)
        return null; 
      return cTSignedTwipsMeasure;
    } 
  }
  
  public boolean isSetSpacing() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SPACING$46) != 0);
    } 
  }
  
  public void setSpacing(CTSignedTwipsMeasure paramCTSignedTwipsMeasure) {
    synchronized (monitor()) {
      check_orphaned();
      CTSignedTwipsMeasure cTSignedTwipsMeasure = null;
      cTSignedTwipsMeasure = (CTSignedTwipsMeasure)get_store().find_element_user(SPACING$46, 0);
      if (cTSignedTwipsMeasure == null)
        cTSignedTwipsMeasure = (CTSignedTwipsMeasure)get_store().add_element_user(SPACING$46); 
      cTSignedTwipsMeasure.set((XmlObject)paramCTSignedTwipsMeasure);
    } 
  }
  
  public CTSignedTwipsMeasure addNewSpacing() {
    synchronized (monitor()) {
      check_orphaned();
      CTSignedTwipsMeasure cTSignedTwipsMeasure = null;
      cTSignedTwipsMeasure = (CTSignedTwipsMeasure)get_store().add_element_user(SPACING$46);
      return cTSignedTwipsMeasure;
    } 
  }
  
  public void unsetSpacing() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SPACING$46, 0);
    } 
  }
  
  public CTTextScale getW() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextScale cTTextScale = null;
      cTTextScale = (CTTextScale)get_store().find_element_user(W$48, 0);
      if (cTTextScale == null)
        return null; 
      return cTTextScale;
    } 
  }
  
  public boolean isSetW() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(W$48) != 0);
    } 
  }
  
  public void setW(CTTextScale paramCTTextScale) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextScale cTTextScale = null;
      cTTextScale = (CTTextScale)get_store().find_element_user(W$48, 0);
      if (cTTextScale == null)
        cTTextScale = (CTTextScale)get_store().add_element_user(W$48); 
      cTTextScale.set((XmlObject)paramCTTextScale);
    } 
  }
  
  public CTTextScale addNewW() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextScale cTTextScale = null;
      cTTextScale = (CTTextScale)get_store().add_element_user(W$48);
      return cTTextScale;
    } 
  }
  
  public void unsetW() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(W$48, 0);
    } 
  }
  
  public CTHpsMeasure getKern() {
    synchronized (monitor()) {
      check_orphaned();
      CTHpsMeasure cTHpsMeasure = null;
      cTHpsMeasure = (CTHpsMeasure)get_store().find_element_user(KERN$50, 0);
      if (cTHpsMeasure == null)
        return null; 
      return cTHpsMeasure;
    } 
  }
  
  public boolean isSetKern() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(KERN$50) != 0);
    } 
  }
  
  public void setKern(CTHpsMeasure paramCTHpsMeasure) {
    synchronized (monitor()) {
      check_orphaned();
      CTHpsMeasure cTHpsMeasure = null;
      cTHpsMeasure = (CTHpsMeasure)get_store().find_element_user(KERN$50, 0);
      if (cTHpsMeasure == null)
        cTHpsMeasure = (CTHpsMeasure)get_store().add_element_user(KERN$50); 
      cTHpsMeasure.set((XmlObject)paramCTHpsMeasure);
    } 
  }
  
  public CTHpsMeasure addNewKern() {
    synchronized (monitor()) {
      check_orphaned();
      CTHpsMeasure cTHpsMeasure = null;
      cTHpsMeasure = (CTHpsMeasure)get_store().add_element_user(KERN$50);
      return cTHpsMeasure;
    } 
  }
  
  public void unsetKern() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(KERN$50, 0);
    } 
  }
  
  public CTSignedHpsMeasure getPosition() {
    synchronized (monitor()) {
      check_orphaned();
      CTSignedHpsMeasure cTSignedHpsMeasure = null;
      cTSignedHpsMeasure = (CTSignedHpsMeasure)get_store().find_element_user(POSITION$52, 0);
      if (cTSignedHpsMeasure == null)
        return null; 
      return cTSignedHpsMeasure;
    } 
  }
  
  public boolean isSetPosition() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(POSITION$52) != 0);
    } 
  }
  
  public void setPosition(CTSignedHpsMeasure paramCTSignedHpsMeasure) {
    synchronized (monitor()) {
      check_orphaned();
      CTSignedHpsMeasure cTSignedHpsMeasure = null;
      cTSignedHpsMeasure = (CTSignedHpsMeasure)get_store().find_element_user(POSITION$52, 0);
      if (cTSignedHpsMeasure == null)
        cTSignedHpsMeasure = (CTSignedHpsMeasure)get_store().add_element_user(POSITION$52); 
      cTSignedHpsMeasure.set((XmlObject)paramCTSignedHpsMeasure);
    } 
  }
  
  public CTSignedHpsMeasure addNewPosition() {
    synchronized (monitor()) {
      check_orphaned();
      CTSignedHpsMeasure cTSignedHpsMeasure = null;
      cTSignedHpsMeasure = (CTSignedHpsMeasure)get_store().add_element_user(POSITION$52);
      return cTSignedHpsMeasure;
    } 
  }
  
  public void unsetPosition() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(POSITION$52, 0);
    } 
  }
  
  public CTHpsMeasure getSz() {
    synchronized (monitor()) {
      check_orphaned();
      CTHpsMeasure cTHpsMeasure = null;
      cTHpsMeasure = (CTHpsMeasure)get_store().find_element_user(SZ$54, 0);
      if (cTHpsMeasure == null)
        return null; 
      return cTHpsMeasure;
    } 
  }
  
  public boolean isSetSz() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SZ$54) != 0);
    } 
  }
  
  public void setSz(CTHpsMeasure paramCTHpsMeasure) {
    synchronized (monitor()) {
      check_orphaned();
      CTHpsMeasure cTHpsMeasure = null;
      cTHpsMeasure = (CTHpsMeasure)get_store().find_element_user(SZ$54, 0);
      if (cTHpsMeasure == null)
        cTHpsMeasure = (CTHpsMeasure)get_store().add_element_user(SZ$54); 
      cTHpsMeasure.set((XmlObject)paramCTHpsMeasure);
    } 
  }
  
  public CTHpsMeasure addNewSz() {
    synchronized (monitor()) {
      check_orphaned();
      CTHpsMeasure cTHpsMeasure = null;
      cTHpsMeasure = (CTHpsMeasure)get_store().add_element_user(SZ$54);
      return cTHpsMeasure;
    } 
  }
  
  public void unsetSz() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SZ$54, 0);
    } 
  }
  
  public CTHpsMeasure getSzCs() {
    synchronized (monitor()) {
      check_orphaned();
      CTHpsMeasure cTHpsMeasure = null;
      cTHpsMeasure = (CTHpsMeasure)get_store().find_element_user(SZCS$56, 0);
      if (cTHpsMeasure == null)
        return null; 
      return cTHpsMeasure;
    } 
  }
  
  public boolean isSetSzCs() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SZCS$56) != 0);
    } 
  }
  
  public void setSzCs(CTHpsMeasure paramCTHpsMeasure) {
    synchronized (monitor()) {
      check_orphaned();
      CTHpsMeasure cTHpsMeasure = null;
      cTHpsMeasure = (CTHpsMeasure)get_store().find_element_user(SZCS$56, 0);
      if (cTHpsMeasure == null)
        cTHpsMeasure = (CTHpsMeasure)get_store().add_element_user(SZCS$56); 
      cTHpsMeasure.set((XmlObject)paramCTHpsMeasure);
    } 
  }
  
  public CTHpsMeasure addNewSzCs() {
    synchronized (monitor()) {
      check_orphaned();
      CTHpsMeasure cTHpsMeasure = null;
      cTHpsMeasure = (CTHpsMeasure)get_store().add_element_user(SZCS$56);
      return cTHpsMeasure;
    } 
  }
  
  public void unsetSzCs() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SZCS$56, 0);
    } 
  }
  
  public CTHighlight getHighlight() {
    synchronized (monitor()) {
      check_orphaned();
      CTHighlight cTHighlight = null;
      cTHighlight = (CTHighlight)get_store().find_element_user(HIGHLIGHT$58, 0);
      if (cTHighlight == null)
        return null; 
      return cTHighlight;
    } 
  }
  
  public boolean isSetHighlight() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(HIGHLIGHT$58) != 0);
    } 
  }
  
  public void setHighlight(CTHighlight paramCTHighlight) {
    synchronized (monitor()) {
      check_orphaned();
      CTHighlight cTHighlight = null;
      cTHighlight = (CTHighlight)get_store().find_element_user(HIGHLIGHT$58, 0);
      if (cTHighlight == null)
        cTHighlight = (CTHighlight)get_store().add_element_user(HIGHLIGHT$58); 
      cTHighlight.set((XmlObject)paramCTHighlight);
    } 
  }
  
  public CTHighlight addNewHighlight() {
    synchronized (monitor()) {
      check_orphaned();
      CTHighlight cTHighlight = null;
      cTHighlight = (CTHighlight)get_store().add_element_user(HIGHLIGHT$58);
      return cTHighlight;
    } 
  }
  
  public void unsetHighlight() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HIGHLIGHT$58, 0);
    } 
  }
  
  public CTUnderline getU() {
    synchronized (monitor()) {
      check_orphaned();
      CTUnderline cTUnderline = null;
      cTUnderline = (CTUnderline)get_store().find_element_user(U$60, 0);
      if (cTUnderline == null)
        return null; 
      return cTUnderline;
    } 
  }
  
  public boolean isSetU() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(U$60) != 0);
    } 
  }
  
  public void setU(CTUnderline paramCTUnderline) {
    synchronized (monitor()) {
      check_orphaned();
      CTUnderline cTUnderline = null;
      cTUnderline = (CTUnderline)get_store().find_element_user(U$60, 0);
      if (cTUnderline == null)
        cTUnderline = (CTUnderline)get_store().add_element_user(U$60); 
      cTUnderline.set((XmlObject)paramCTUnderline);
    } 
  }
  
  public CTUnderline addNewU() {
    synchronized (monitor()) {
      check_orphaned();
      CTUnderline cTUnderline = null;
      cTUnderline = (CTUnderline)get_store().add_element_user(U$60);
      return cTUnderline;
    } 
  }
  
  public void unsetU() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(U$60, 0);
    } 
  }
  
  public CTTextEffect getEffect() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextEffect cTTextEffect = null;
      cTTextEffect = (CTTextEffect)get_store().find_element_user(EFFECT$62, 0);
      if (cTTextEffect == null)
        return null; 
      return cTTextEffect;
    } 
  }
  
  public boolean isSetEffect() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EFFECT$62) != 0);
    } 
  }
  
  public void setEffect(CTTextEffect paramCTTextEffect) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextEffect cTTextEffect = null;
      cTTextEffect = (CTTextEffect)get_store().find_element_user(EFFECT$62, 0);
      if (cTTextEffect == null)
        cTTextEffect = (CTTextEffect)get_store().add_element_user(EFFECT$62); 
      cTTextEffect.set((XmlObject)paramCTTextEffect);
    } 
  }
  
  public CTTextEffect addNewEffect() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextEffect cTTextEffect = null;
      cTTextEffect = (CTTextEffect)get_store().add_element_user(EFFECT$62);
      return cTTextEffect;
    } 
  }
  
  public void unsetEffect() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EFFECT$62, 0);
    } 
  }
  
  public CTBorder getBdr() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().find_element_user(BDR$64, 0);
      if (cTBorder == null)
        return null; 
      return cTBorder;
    } 
  }
  
  public boolean isSetBdr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BDR$64) != 0);
    } 
  }
  
  public void setBdr(CTBorder paramCTBorder) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().find_element_user(BDR$64, 0);
      if (cTBorder == null)
        cTBorder = (CTBorder)get_store().add_element_user(BDR$64); 
      cTBorder.set((XmlObject)paramCTBorder);
    } 
  }
  
  public CTBorder addNewBdr() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().add_element_user(BDR$64);
      return cTBorder;
    } 
  }
  
  public void unsetBdr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BDR$64, 0);
    } 
  }
  
  public CTShd getShd() {
    synchronized (monitor()) {
      check_orphaned();
      CTShd cTShd = null;
      cTShd = (CTShd)get_store().find_element_user(SHD$66, 0);
      if (cTShd == null)
        return null; 
      return cTShd;
    } 
  }
  
  public boolean isSetShd() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SHD$66) != 0);
    } 
  }
  
  public void setShd(CTShd paramCTShd) {
    synchronized (monitor()) {
      check_orphaned();
      CTShd cTShd = null;
      cTShd = (CTShd)get_store().find_element_user(SHD$66, 0);
      if (cTShd == null)
        cTShd = (CTShd)get_store().add_element_user(SHD$66); 
      cTShd.set((XmlObject)paramCTShd);
    } 
  }
  
  public CTShd addNewShd() {
    synchronized (monitor()) {
      check_orphaned();
      CTShd cTShd = null;
      cTShd = (CTShd)get_store().add_element_user(SHD$66);
      return cTShd;
    } 
  }
  
  public void unsetShd() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SHD$66, 0);
    } 
  }
  
  public CTFitText getFitText() {
    synchronized (monitor()) {
      check_orphaned();
      CTFitText cTFitText = null;
      cTFitText = (CTFitText)get_store().find_element_user(FITTEXT$68, 0);
      if (cTFitText == null)
        return null; 
      return cTFitText;
    } 
  }
  
  public boolean isSetFitText() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FITTEXT$68) != 0);
    } 
  }
  
  public void setFitText(CTFitText paramCTFitText) {
    synchronized (monitor()) {
      check_orphaned();
      CTFitText cTFitText = null;
      cTFitText = (CTFitText)get_store().find_element_user(FITTEXT$68, 0);
      if (cTFitText == null)
        cTFitText = (CTFitText)get_store().add_element_user(FITTEXT$68); 
      cTFitText.set((XmlObject)paramCTFitText);
    } 
  }
  
  public CTFitText addNewFitText() {
    synchronized (monitor()) {
      check_orphaned();
      CTFitText cTFitText = null;
      cTFitText = (CTFitText)get_store().add_element_user(FITTEXT$68);
      return cTFitText;
    } 
  }
  
  public void unsetFitText() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FITTEXT$68, 0);
    } 
  }
  
  public CTVerticalAlignRun getVertAlign() {
    synchronized (monitor()) {
      check_orphaned();
      CTVerticalAlignRun cTVerticalAlignRun = null;
      cTVerticalAlignRun = (CTVerticalAlignRun)get_store().find_element_user(VERTALIGN$70, 0);
      if (cTVerticalAlignRun == null)
        return null; 
      return cTVerticalAlignRun;
    } 
  }
  
  public boolean isSetVertAlign() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(VERTALIGN$70) != 0);
    } 
  }
  
  public void setVertAlign(CTVerticalAlignRun paramCTVerticalAlignRun) {
    synchronized (monitor()) {
      check_orphaned();
      CTVerticalAlignRun cTVerticalAlignRun = null;
      cTVerticalAlignRun = (CTVerticalAlignRun)get_store().find_element_user(VERTALIGN$70, 0);
      if (cTVerticalAlignRun == null)
        cTVerticalAlignRun = (CTVerticalAlignRun)get_store().add_element_user(VERTALIGN$70); 
      cTVerticalAlignRun.set((XmlObject)paramCTVerticalAlignRun);
    } 
  }
  
  public CTVerticalAlignRun addNewVertAlign() {
    synchronized (monitor()) {
      check_orphaned();
      CTVerticalAlignRun cTVerticalAlignRun = null;
      cTVerticalAlignRun = (CTVerticalAlignRun)get_store().add_element_user(VERTALIGN$70);
      return cTVerticalAlignRun;
    } 
  }
  
  public void unsetVertAlign() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(VERTALIGN$70, 0);
    } 
  }
  
  public CTOnOff getRtl() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(RTL$72, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetRtl() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(RTL$72) != 0);
    } 
  }
  
  public void setRtl(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(RTL$72, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(RTL$72); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewRtl() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(RTL$72);
      return cTOnOff;
    } 
  }
  
  public void unsetRtl() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(RTL$72, 0);
    } 
  }
  
  public CTOnOff getCs() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(CS$74, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetCs() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CS$74) != 0);
    } 
  }
  
  public void setCs(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(CS$74, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(CS$74); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewCs() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(CS$74);
      return cTOnOff;
    } 
  }
  
  public void unsetCs() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CS$74, 0);
    } 
  }
  
  public CTEm getEm() {
    synchronized (monitor()) {
      check_orphaned();
      CTEm cTEm = null;
      cTEm = (CTEm)get_store().find_element_user(EM$76, 0);
      if (cTEm == null)
        return null; 
      return cTEm;
    } 
  }
  
  public boolean isSetEm() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EM$76) != 0);
    } 
  }
  
  public void setEm(CTEm paramCTEm) {
    synchronized (monitor()) {
      check_orphaned();
      CTEm cTEm = null;
      cTEm = (CTEm)get_store().find_element_user(EM$76, 0);
      if (cTEm == null)
        cTEm = (CTEm)get_store().add_element_user(EM$76); 
      cTEm.set((XmlObject)paramCTEm);
    } 
  }
  
  public CTEm addNewEm() {
    synchronized (monitor()) {
      check_orphaned();
      CTEm cTEm = null;
      cTEm = (CTEm)get_store().add_element_user(EM$76);
      return cTEm;
    } 
  }
  
  public void unsetEm() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EM$76, 0);
    } 
  }
  
  public CTLanguage getLang() {
    synchronized (monitor()) {
      check_orphaned();
      CTLanguage cTLanguage = null;
      cTLanguage = (CTLanguage)get_store().find_element_user(LANG$78, 0);
      if (cTLanguage == null)
        return null; 
      return cTLanguage;
    } 
  }
  
  public boolean isSetLang() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LANG$78) != 0);
    } 
  }
  
  public void setLang(CTLanguage paramCTLanguage) {
    synchronized (monitor()) {
      check_orphaned();
      CTLanguage cTLanguage = null;
      cTLanguage = (CTLanguage)get_store().find_element_user(LANG$78, 0);
      if (cTLanguage == null)
        cTLanguage = (CTLanguage)get_store().add_element_user(LANG$78); 
      cTLanguage.set((XmlObject)paramCTLanguage);
    } 
  }
  
  public CTLanguage addNewLang() {
    synchronized (monitor()) {
      check_orphaned();
      CTLanguage cTLanguage = null;
      cTLanguage = (CTLanguage)get_store().add_element_user(LANG$78);
      return cTLanguage;
    } 
  }
  
  public void unsetLang() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LANG$78, 0);
    } 
  }
  
  public CTEastAsianLayout getEastAsianLayout() {
    synchronized (monitor()) {
      check_orphaned();
      CTEastAsianLayout cTEastAsianLayout = null;
      cTEastAsianLayout = (CTEastAsianLayout)get_store().find_element_user(EASTASIANLAYOUT$80, 0);
      if (cTEastAsianLayout == null)
        return null; 
      return cTEastAsianLayout;
    } 
  }
  
  public boolean isSetEastAsianLayout() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EASTASIANLAYOUT$80) != 0);
    } 
  }
  
  public void setEastAsianLayout(CTEastAsianLayout paramCTEastAsianLayout) {
    synchronized (monitor()) {
      check_orphaned();
      CTEastAsianLayout cTEastAsianLayout = null;
      cTEastAsianLayout = (CTEastAsianLayout)get_store().find_element_user(EASTASIANLAYOUT$80, 0);
      if (cTEastAsianLayout == null)
        cTEastAsianLayout = (CTEastAsianLayout)get_store().add_element_user(EASTASIANLAYOUT$80); 
      cTEastAsianLayout.set((XmlObject)paramCTEastAsianLayout);
    } 
  }
  
  public CTEastAsianLayout addNewEastAsianLayout() {
    synchronized (monitor()) {
      check_orphaned();
      CTEastAsianLayout cTEastAsianLayout = null;
      cTEastAsianLayout = (CTEastAsianLayout)get_store().add_element_user(EASTASIANLAYOUT$80);
      return cTEastAsianLayout;
    } 
  }
  
  public void unsetEastAsianLayout() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EASTASIANLAYOUT$80, 0);
    } 
  }
  
  public CTOnOff getSpecVanish() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SPECVANISH$82, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetSpecVanish() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SPECVANISH$82) != 0);
    } 
  }
  
  public void setSpecVanish(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SPECVANISH$82, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(SPECVANISH$82); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewSpecVanish() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(SPECVANISH$82);
      return cTOnOff;
    } 
  }
  
  public void unsetSpecVanish() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SPECVANISH$82, 0);
    } 
  }
  
  public CTOnOff getOMath() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(OMATH$84, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetOMath() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(OMATH$84) != 0);
    } 
  }
  
  public void setOMath(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(OMATH$84, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(OMATH$84); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewOMath() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(OMATH$84);
      return cTOnOff;
    } 
  }
  
  public void unsetOMath() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(OMATH$84, 0);
    } 
  }
  
  public CTParaRPrChange getRPrChange() {
    synchronized (monitor()) {
      check_orphaned();
      CTParaRPrChange cTParaRPrChange = null;
      cTParaRPrChange = (CTParaRPrChange)get_store().find_element_user(RPRCHANGE$86, 0);
      if (cTParaRPrChange == null)
        return null; 
      return cTParaRPrChange;
    } 
  }
  
  public boolean isSetRPrChange() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(RPRCHANGE$86) != 0);
    } 
  }
  
  public void setRPrChange(CTParaRPrChange paramCTParaRPrChange) {
    synchronized (monitor()) {
      check_orphaned();
      CTParaRPrChange cTParaRPrChange = null;
      cTParaRPrChange = (CTParaRPrChange)get_store().find_element_user(RPRCHANGE$86, 0);
      if (cTParaRPrChange == null)
        cTParaRPrChange = (CTParaRPrChange)get_store().add_element_user(RPRCHANGE$86); 
      cTParaRPrChange.set((XmlObject)paramCTParaRPrChange);
    } 
  }
  
  public CTParaRPrChange addNewRPrChange() {
    synchronized (monitor()) {
      check_orphaned();
      CTParaRPrChange cTParaRPrChange = null;
      cTParaRPrChange = (CTParaRPrChange)get_store().add_element_user(RPRCHANGE$86);
      return cTParaRPrChange;
    } 
  }
  
  public void unsetRPrChange() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(RPRCHANGE$86, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTParaRPrImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */