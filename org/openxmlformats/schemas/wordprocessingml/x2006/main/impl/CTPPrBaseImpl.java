package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCnf;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFramePr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabs;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextAlignment;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextDirection;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextboxTightWrap;

public class CTPPrBaseImpl extends XmlComplexContentImpl implements CTPPrBase {
  private static final b PSTYLE$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pStyle");
  
  private static final b KEEPNEXT$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "keepNext");
  
  private static final b KEEPLINES$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "keepLines");
  
  private static final b PAGEBREAKBEFORE$6 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pageBreakBefore");
  
  private static final b FRAMEPR$8 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "framePr");
  
  private static final b WIDOWCONTROL$10 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "widowControl");
  
  private static final b NUMPR$12 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "numPr");
  
  private static final b SUPPRESSLINENUMBERS$14 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "suppressLineNumbers");
  
  private static final b PBDR$16 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pBdr");
  
  private static final b SHD$18 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "shd");
  
  private static final b TABS$20 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tabs");
  
  private static final b SUPPRESSAUTOHYPHENS$22 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "suppressAutoHyphens");
  
  private static final b KINSOKU$24 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "kinsoku");
  
  private static final b WORDWRAP$26 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "wordWrap");
  
  private static final b OVERFLOWPUNCT$28 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "overflowPunct");
  
  private static final b TOPLINEPUNCT$30 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "topLinePunct");
  
  private static final b AUTOSPACEDE$32 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "autoSpaceDE");
  
  private static final b AUTOSPACEDN$34 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "autoSpaceDN");
  
  private static final b BIDI$36 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bidi");
  
  private static final b ADJUSTRIGHTIND$38 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "adjustRightInd");
  
  private static final b SNAPTOGRID$40 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "snapToGrid");
  
  private static final b SPACING$42 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "spacing");
  
  private static final b IND$44 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ind");
  
  private static final b CONTEXTUALSPACING$46 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "contextualSpacing");
  
  private static final b MIRRORINDENTS$48 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "mirrorIndents");
  
  private static final b SUPPRESSOVERLAP$50 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "suppressOverlap");
  
  private static final b JC$52 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "jc");
  
  private static final b TEXTDIRECTION$54 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "textDirection");
  
  private static final b TEXTALIGNMENT$56 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "textAlignment");
  
  private static final b TEXTBOXTIGHTWRAP$58 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "textboxTightWrap");
  
  private static final b OUTLINELVL$60 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "outlineLvl");
  
  private static final b DIVID$62 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "divId");
  
  private static final b CNFSTYLE$64 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cnfStyle");
  
  public CTPPrBaseImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTString getPStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(PSTYLE$0, 0);
      if (cTString == null)
        return null; 
      return cTString;
    } 
  }
  
  public boolean isSetPStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PSTYLE$0) != 0);
    } 
  }
  
  public void setPStyle(CTString paramCTString) {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(PSTYLE$0, 0);
      if (cTString == null)
        cTString = (CTString)get_store().add_element_user(PSTYLE$0); 
      cTString.set((XmlObject)paramCTString);
    } 
  }
  
  public CTString addNewPStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().add_element_user(PSTYLE$0);
      return cTString;
    } 
  }
  
  public void unsetPStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PSTYLE$0, 0);
    } 
  }
  
  public CTOnOff getKeepNext() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(KEEPNEXT$2, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetKeepNext() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(KEEPNEXT$2) != 0);
    } 
  }
  
  public void setKeepNext(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(KEEPNEXT$2, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(KEEPNEXT$2); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewKeepNext() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(KEEPNEXT$2);
      return cTOnOff;
    } 
  }
  
  public void unsetKeepNext() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(KEEPNEXT$2, 0);
    } 
  }
  
  public CTOnOff getKeepLines() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(KEEPLINES$4, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetKeepLines() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(KEEPLINES$4) != 0);
    } 
  }
  
  public void setKeepLines(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(KEEPLINES$4, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(KEEPLINES$4); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewKeepLines() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(KEEPLINES$4);
      return cTOnOff;
    } 
  }
  
  public void unsetKeepLines() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(KEEPLINES$4, 0);
    } 
  }
  
  public CTOnOff getPageBreakBefore() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(PAGEBREAKBEFORE$6, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetPageBreakBefore() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PAGEBREAKBEFORE$6) != 0);
    } 
  }
  
  public void setPageBreakBefore(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(PAGEBREAKBEFORE$6, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(PAGEBREAKBEFORE$6); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewPageBreakBefore() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(PAGEBREAKBEFORE$6);
      return cTOnOff;
    } 
  }
  
  public void unsetPageBreakBefore() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PAGEBREAKBEFORE$6, 0);
    } 
  }
  
  public CTFramePr getFramePr() {
    synchronized (monitor()) {
      check_orphaned();
      CTFramePr cTFramePr = null;
      cTFramePr = (CTFramePr)get_store().find_element_user(FRAMEPR$8, 0);
      if (cTFramePr == null)
        return null; 
      return cTFramePr;
    } 
  }
  
  public boolean isSetFramePr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FRAMEPR$8) != 0);
    } 
  }
  
  public void setFramePr(CTFramePr paramCTFramePr) {
    synchronized (monitor()) {
      check_orphaned();
      CTFramePr cTFramePr = null;
      cTFramePr = (CTFramePr)get_store().find_element_user(FRAMEPR$8, 0);
      if (cTFramePr == null)
        cTFramePr = (CTFramePr)get_store().add_element_user(FRAMEPR$8); 
      cTFramePr.set((XmlObject)paramCTFramePr);
    } 
  }
  
  public CTFramePr addNewFramePr() {
    synchronized (monitor()) {
      check_orphaned();
      CTFramePr cTFramePr = null;
      cTFramePr = (CTFramePr)get_store().add_element_user(FRAMEPR$8);
      return cTFramePr;
    } 
  }
  
  public void unsetFramePr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FRAMEPR$8, 0);
    } 
  }
  
  public CTOnOff getWidowControl() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(WIDOWCONTROL$10, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetWidowControl() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(WIDOWCONTROL$10) != 0);
    } 
  }
  
  public void setWidowControl(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(WIDOWCONTROL$10, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(WIDOWCONTROL$10); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewWidowControl() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(WIDOWCONTROL$10);
      return cTOnOff;
    } 
  }
  
  public void unsetWidowControl() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(WIDOWCONTROL$10, 0);
    } 
  }
  
  public CTNumPr getNumPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTNumPr cTNumPr = null;
      cTNumPr = (CTNumPr)get_store().find_element_user(NUMPR$12, 0);
      if (cTNumPr == null)
        return null; 
      return cTNumPr;
    } 
  }
  
  public boolean isSetNumPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NUMPR$12) != 0);
    } 
  }
  
  public void setNumPr(CTNumPr paramCTNumPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTNumPr cTNumPr = null;
      cTNumPr = (CTNumPr)get_store().find_element_user(NUMPR$12, 0);
      if (cTNumPr == null)
        cTNumPr = (CTNumPr)get_store().add_element_user(NUMPR$12); 
      cTNumPr.set((XmlObject)paramCTNumPr);
    } 
  }
  
  public CTNumPr addNewNumPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTNumPr cTNumPr = null;
      cTNumPr = (CTNumPr)get_store().add_element_user(NUMPR$12);
      return cTNumPr;
    } 
  }
  
  public void unsetNumPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NUMPR$12, 0);
    } 
  }
  
  public CTOnOff getSuppressLineNumbers() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SUPPRESSLINENUMBERS$14, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetSuppressLineNumbers() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SUPPRESSLINENUMBERS$14) != 0);
    } 
  }
  
  public void setSuppressLineNumbers(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SUPPRESSLINENUMBERS$14, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(SUPPRESSLINENUMBERS$14); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewSuppressLineNumbers() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(SUPPRESSLINENUMBERS$14);
      return cTOnOff;
    } 
  }
  
  public void unsetSuppressLineNumbers() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SUPPRESSLINENUMBERS$14, 0);
    } 
  }
  
  public CTPBdr getPBdr() {
    synchronized (monitor()) {
      check_orphaned();
      CTPBdr cTPBdr = null;
      cTPBdr = (CTPBdr)get_store().find_element_user(PBDR$16, 0);
      if (cTPBdr == null)
        return null; 
      return cTPBdr;
    } 
  }
  
  public boolean isSetPBdr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PBDR$16) != 0);
    } 
  }
  
  public void setPBdr(CTPBdr paramCTPBdr) {
    synchronized (monitor()) {
      check_orphaned();
      CTPBdr cTPBdr = null;
      cTPBdr = (CTPBdr)get_store().find_element_user(PBDR$16, 0);
      if (cTPBdr == null)
        cTPBdr = (CTPBdr)get_store().add_element_user(PBDR$16); 
      cTPBdr.set((XmlObject)paramCTPBdr);
    } 
  }
  
  public CTPBdr addNewPBdr() {
    synchronized (monitor()) {
      check_orphaned();
      CTPBdr cTPBdr = null;
      cTPBdr = (CTPBdr)get_store().add_element_user(PBDR$16);
      return cTPBdr;
    } 
  }
  
  public void unsetPBdr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PBDR$16, 0);
    } 
  }
  
  public CTShd getShd() {
    synchronized (monitor()) {
      check_orphaned();
      CTShd cTShd = null;
      cTShd = (CTShd)get_store().find_element_user(SHD$18, 0);
      if (cTShd == null)
        return null; 
      return cTShd;
    } 
  }
  
  public boolean isSetShd() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SHD$18) != 0);
    } 
  }
  
  public void setShd(CTShd paramCTShd) {
    synchronized (monitor()) {
      check_orphaned();
      CTShd cTShd = null;
      cTShd = (CTShd)get_store().find_element_user(SHD$18, 0);
      if (cTShd == null)
        cTShd = (CTShd)get_store().add_element_user(SHD$18); 
      cTShd.set((XmlObject)paramCTShd);
    } 
  }
  
  public CTShd addNewShd() {
    synchronized (monitor()) {
      check_orphaned();
      CTShd cTShd = null;
      cTShd = (CTShd)get_store().add_element_user(SHD$18);
      return cTShd;
    } 
  }
  
  public void unsetShd() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SHD$18, 0);
    } 
  }
  
  public CTTabs getTabs() {
    synchronized (monitor()) {
      check_orphaned();
      CTTabs cTTabs = null;
      cTTabs = (CTTabs)get_store().find_element_user(TABS$20, 0);
      if (cTTabs == null)
        return null; 
      return cTTabs;
    } 
  }
  
  public boolean isSetTabs() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TABS$20) != 0);
    } 
  }
  
  public void setTabs(CTTabs paramCTTabs) {
    synchronized (monitor()) {
      check_orphaned();
      CTTabs cTTabs = null;
      cTTabs = (CTTabs)get_store().find_element_user(TABS$20, 0);
      if (cTTabs == null)
        cTTabs = (CTTabs)get_store().add_element_user(TABS$20); 
      cTTabs.set((XmlObject)paramCTTabs);
    } 
  }
  
  public CTTabs addNewTabs() {
    synchronized (monitor()) {
      check_orphaned();
      CTTabs cTTabs = null;
      cTTabs = (CTTabs)get_store().add_element_user(TABS$20);
      return cTTabs;
    } 
  }
  
  public void unsetTabs() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TABS$20, 0);
    } 
  }
  
  public CTOnOff getSuppressAutoHyphens() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SUPPRESSAUTOHYPHENS$22, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetSuppressAutoHyphens() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SUPPRESSAUTOHYPHENS$22) != 0);
    } 
  }
  
  public void setSuppressAutoHyphens(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SUPPRESSAUTOHYPHENS$22, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(SUPPRESSAUTOHYPHENS$22); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewSuppressAutoHyphens() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(SUPPRESSAUTOHYPHENS$22);
      return cTOnOff;
    } 
  }
  
  public void unsetSuppressAutoHyphens() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SUPPRESSAUTOHYPHENS$22, 0);
    } 
  }
  
  public CTOnOff getKinsoku() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(KINSOKU$24, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetKinsoku() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(KINSOKU$24) != 0);
    } 
  }
  
  public void setKinsoku(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(KINSOKU$24, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(KINSOKU$24); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewKinsoku() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(KINSOKU$24);
      return cTOnOff;
    } 
  }
  
  public void unsetKinsoku() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(KINSOKU$24, 0);
    } 
  }
  
  public CTOnOff getWordWrap() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(WORDWRAP$26, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetWordWrap() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(WORDWRAP$26) != 0);
    } 
  }
  
  public void setWordWrap(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(WORDWRAP$26, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(WORDWRAP$26); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewWordWrap() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(WORDWRAP$26);
      return cTOnOff;
    } 
  }
  
  public void unsetWordWrap() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(WORDWRAP$26, 0);
    } 
  }
  
  public CTOnOff getOverflowPunct() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(OVERFLOWPUNCT$28, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetOverflowPunct() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(OVERFLOWPUNCT$28) != 0);
    } 
  }
  
  public void setOverflowPunct(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(OVERFLOWPUNCT$28, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(OVERFLOWPUNCT$28); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewOverflowPunct() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(OVERFLOWPUNCT$28);
      return cTOnOff;
    } 
  }
  
  public void unsetOverflowPunct() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(OVERFLOWPUNCT$28, 0);
    } 
  }
  
  public CTOnOff getTopLinePunct() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(TOPLINEPUNCT$30, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetTopLinePunct() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TOPLINEPUNCT$30) != 0);
    } 
  }
  
  public void setTopLinePunct(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(TOPLINEPUNCT$30, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(TOPLINEPUNCT$30); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewTopLinePunct() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(TOPLINEPUNCT$30);
      return cTOnOff;
    } 
  }
  
  public void unsetTopLinePunct() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TOPLINEPUNCT$30, 0);
    } 
  }
  
  public CTOnOff getAutoSpaceDE() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(AUTOSPACEDE$32, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetAutoSpaceDE() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(AUTOSPACEDE$32) != 0);
    } 
  }
  
  public void setAutoSpaceDE(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(AUTOSPACEDE$32, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(AUTOSPACEDE$32); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewAutoSpaceDE() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(AUTOSPACEDE$32);
      return cTOnOff;
    } 
  }
  
  public void unsetAutoSpaceDE() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(AUTOSPACEDE$32, 0);
    } 
  }
  
  public CTOnOff getAutoSpaceDN() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(AUTOSPACEDN$34, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetAutoSpaceDN() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(AUTOSPACEDN$34) != 0);
    } 
  }
  
  public void setAutoSpaceDN(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(AUTOSPACEDN$34, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(AUTOSPACEDN$34); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewAutoSpaceDN() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(AUTOSPACEDN$34);
      return cTOnOff;
    } 
  }
  
  public void unsetAutoSpaceDN() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(AUTOSPACEDN$34, 0);
    } 
  }
  
  public CTOnOff getBidi() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(BIDI$36, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetBidi() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BIDI$36) != 0);
    } 
  }
  
  public void setBidi(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(BIDI$36, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(BIDI$36); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewBidi() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(BIDI$36);
      return cTOnOff;
    } 
  }
  
  public void unsetBidi() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BIDI$36, 0);
    } 
  }
  
  public CTOnOff getAdjustRightInd() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(ADJUSTRIGHTIND$38, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetAdjustRightInd() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ADJUSTRIGHTIND$38) != 0);
    } 
  }
  
  public void setAdjustRightInd(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(ADJUSTRIGHTIND$38, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(ADJUSTRIGHTIND$38); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewAdjustRightInd() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(ADJUSTRIGHTIND$38);
      return cTOnOff;
    } 
  }
  
  public void unsetAdjustRightInd() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ADJUSTRIGHTIND$38, 0);
    } 
  }
  
  public CTOnOff getSnapToGrid() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SNAPTOGRID$40, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetSnapToGrid() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SNAPTOGRID$40) != 0);
    } 
  }
  
  public void setSnapToGrid(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SNAPTOGRID$40, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(SNAPTOGRID$40); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewSnapToGrid() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(SNAPTOGRID$40);
      return cTOnOff;
    } 
  }
  
  public void unsetSnapToGrid() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SNAPTOGRID$40, 0);
    } 
  }
  
  public CTSpacing getSpacing() {
    synchronized (monitor()) {
      check_orphaned();
      CTSpacing cTSpacing = null;
      cTSpacing = (CTSpacing)get_store().find_element_user(SPACING$42, 0);
      if (cTSpacing == null)
        return null; 
      return cTSpacing;
    } 
  }
  
  public boolean isSetSpacing() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SPACING$42) != 0);
    } 
  }
  
  public void setSpacing(CTSpacing paramCTSpacing) {
    synchronized (monitor()) {
      check_orphaned();
      CTSpacing cTSpacing = null;
      cTSpacing = (CTSpacing)get_store().find_element_user(SPACING$42, 0);
      if (cTSpacing == null)
        cTSpacing = (CTSpacing)get_store().add_element_user(SPACING$42); 
      cTSpacing.set((XmlObject)paramCTSpacing);
    } 
  }
  
  public CTSpacing addNewSpacing() {
    synchronized (monitor()) {
      check_orphaned();
      CTSpacing cTSpacing = null;
      cTSpacing = (CTSpacing)get_store().add_element_user(SPACING$42);
      return cTSpacing;
    } 
  }
  
  public void unsetSpacing() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SPACING$42, 0);
    } 
  }
  
  public CTInd getInd() {
    synchronized (monitor()) {
      check_orphaned();
      CTInd cTInd = null;
      cTInd = (CTInd)get_store().find_element_user(IND$44, 0);
      if (cTInd == null)
        return null; 
      return cTInd;
    } 
  }
  
  public boolean isSetInd() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(IND$44) != 0);
    } 
  }
  
  public void setInd(CTInd paramCTInd) {
    synchronized (monitor()) {
      check_orphaned();
      CTInd cTInd = null;
      cTInd = (CTInd)get_store().find_element_user(IND$44, 0);
      if (cTInd == null)
        cTInd = (CTInd)get_store().add_element_user(IND$44); 
      cTInd.set((XmlObject)paramCTInd);
    } 
  }
  
  public CTInd addNewInd() {
    synchronized (monitor()) {
      check_orphaned();
      CTInd cTInd = null;
      cTInd = (CTInd)get_store().add_element_user(IND$44);
      return cTInd;
    } 
  }
  
  public void unsetInd() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(IND$44, 0);
    } 
  }
  
  public CTOnOff getContextualSpacing() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(CONTEXTUALSPACING$46, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetContextualSpacing() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CONTEXTUALSPACING$46) != 0);
    } 
  }
  
  public void setContextualSpacing(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(CONTEXTUALSPACING$46, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(CONTEXTUALSPACING$46); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewContextualSpacing() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(CONTEXTUALSPACING$46);
      return cTOnOff;
    } 
  }
  
  public void unsetContextualSpacing() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CONTEXTUALSPACING$46, 0);
    } 
  }
  
  public CTOnOff getMirrorIndents() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(MIRRORINDENTS$48, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetMirrorIndents() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(MIRRORINDENTS$48) != 0);
    } 
  }
  
  public void setMirrorIndents(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(MIRRORINDENTS$48, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(MIRRORINDENTS$48); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewMirrorIndents() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(MIRRORINDENTS$48);
      return cTOnOff;
    } 
  }
  
  public void unsetMirrorIndents() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MIRRORINDENTS$48, 0);
    } 
  }
  
  public CTOnOff getSuppressOverlap() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SUPPRESSOVERLAP$50, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetSuppressOverlap() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SUPPRESSOVERLAP$50) != 0);
    } 
  }
  
  public void setSuppressOverlap(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SUPPRESSOVERLAP$50, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(SUPPRESSOVERLAP$50); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewSuppressOverlap() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(SUPPRESSOVERLAP$50);
      return cTOnOff;
    } 
  }
  
  public void unsetSuppressOverlap() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SUPPRESSOVERLAP$50, 0);
    } 
  }
  
  public CTJc getJc() {
    synchronized (monitor()) {
      check_orphaned();
      CTJc cTJc = null;
      cTJc = (CTJc)get_store().find_element_user(JC$52, 0);
      if (cTJc == null)
        return null; 
      return cTJc;
    } 
  }
  
  public boolean isSetJc() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(JC$52) != 0);
    } 
  }
  
  public void setJc(CTJc paramCTJc) {
    synchronized (monitor()) {
      check_orphaned();
      CTJc cTJc = null;
      cTJc = (CTJc)get_store().find_element_user(JC$52, 0);
      if (cTJc == null)
        cTJc = (CTJc)get_store().add_element_user(JC$52); 
      cTJc.set((XmlObject)paramCTJc);
    } 
  }
  
  public CTJc addNewJc() {
    synchronized (monitor()) {
      check_orphaned();
      CTJc cTJc = null;
      cTJc = (CTJc)get_store().add_element_user(JC$52);
      return cTJc;
    } 
  }
  
  public void unsetJc() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(JC$52, 0);
    } 
  }
  
  public CTTextDirection getTextDirection() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextDirection cTTextDirection = null;
      cTTextDirection = (CTTextDirection)get_store().find_element_user(TEXTDIRECTION$54, 0);
      if (cTTextDirection == null)
        return null; 
      return cTTextDirection;
    } 
  }
  
  public boolean isSetTextDirection() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TEXTDIRECTION$54) != 0);
    } 
  }
  
  public void setTextDirection(CTTextDirection paramCTTextDirection) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextDirection cTTextDirection = null;
      cTTextDirection = (CTTextDirection)get_store().find_element_user(TEXTDIRECTION$54, 0);
      if (cTTextDirection == null)
        cTTextDirection = (CTTextDirection)get_store().add_element_user(TEXTDIRECTION$54); 
      cTTextDirection.set((XmlObject)paramCTTextDirection);
    } 
  }
  
  public CTTextDirection addNewTextDirection() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextDirection cTTextDirection = null;
      cTTextDirection = (CTTextDirection)get_store().add_element_user(TEXTDIRECTION$54);
      return cTTextDirection;
    } 
  }
  
  public void unsetTextDirection() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TEXTDIRECTION$54, 0);
    } 
  }
  
  public CTTextAlignment getTextAlignment() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextAlignment cTTextAlignment = null;
      cTTextAlignment = (CTTextAlignment)get_store().find_element_user(TEXTALIGNMENT$56, 0);
      if (cTTextAlignment == null)
        return null; 
      return cTTextAlignment;
    } 
  }
  
  public boolean isSetTextAlignment() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TEXTALIGNMENT$56) != 0);
    } 
  }
  
  public void setTextAlignment(CTTextAlignment paramCTTextAlignment) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextAlignment cTTextAlignment = null;
      cTTextAlignment = (CTTextAlignment)get_store().find_element_user(TEXTALIGNMENT$56, 0);
      if (cTTextAlignment == null)
        cTTextAlignment = (CTTextAlignment)get_store().add_element_user(TEXTALIGNMENT$56); 
      cTTextAlignment.set((XmlObject)paramCTTextAlignment);
    } 
  }
  
  public CTTextAlignment addNewTextAlignment() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextAlignment cTTextAlignment = null;
      cTTextAlignment = (CTTextAlignment)get_store().add_element_user(TEXTALIGNMENT$56);
      return cTTextAlignment;
    } 
  }
  
  public void unsetTextAlignment() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TEXTALIGNMENT$56, 0);
    } 
  }
  
  public CTTextboxTightWrap getTextboxTightWrap() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextboxTightWrap cTTextboxTightWrap = null;
      cTTextboxTightWrap = (CTTextboxTightWrap)get_store().find_element_user(TEXTBOXTIGHTWRAP$58, 0);
      if (cTTextboxTightWrap == null)
        return null; 
      return cTTextboxTightWrap;
    } 
  }
  
  public boolean isSetTextboxTightWrap() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TEXTBOXTIGHTWRAP$58) != 0);
    } 
  }
  
  public void setTextboxTightWrap(CTTextboxTightWrap paramCTTextboxTightWrap) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextboxTightWrap cTTextboxTightWrap = null;
      cTTextboxTightWrap = (CTTextboxTightWrap)get_store().find_element_user(TEXTBOXTIGHTWRAP$58, 0);
      if (cTTextboxTightWrap == null)
        cTTextboxTightWrap = (CTTextboxTightWrap)get_store().add_element_user(TEXTBOXTIGHTWRAP$58); 
      cTTextboxTightWrap.set((XmlObject)paramCTTextboxTightWrap);
    } 
  }
  
  public CTTextboxTightWrap addNewTextboxTightWrap() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextboxTightWrap cTTextboxTightWrap = null;
      cTTextboxTightWrap = (CTTextboxTightWrap)get_store().add_element_user(TEXTBOXTIGHTWRAP$58);
      return cTTextboxTightWrap;
    } 
  }
  
  public void unsetTextboxTightWrap() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TEXTBOXTIGHTWRAP$58, 0);
    } 
  }
  
  public CTDecimalNumber getOutlineLvl() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(OUTLINELVL$60, 0);
      if (cTDecimalNumber == null)
        return null; 
      return cTDecimalNumber;
    } 
  }
  
  public boolean isSetOutlineLvl() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(OUTLINELVL$60) != 0);
    } 
  }
  
  public void setOutlineLvl(CTDecimalNumber paramCTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(OUTLINELVL$60, 0);
      if (cTDecimalNumber == null)
        cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(OUTLINELVL$60); 
      cTDecimalNumber.set((XmlObject)paramCTDecimalNumber);
    } 
  }
  
  public CTDecimalNumber addNewOutlineLvl() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(OUTLINELVL$60);
      return cTDecimalNumber;
    } 
  }
  
  public void unsetOutlineLvl() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(OUTLINELVL$60, 0);
    } 
  }
  
  public CTDecimalNumber getDivId() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(DIVID$62, 0);
      if (cTDecimalNumber == null)
        return null; 
      return cTDecimalNumber;
    } 
  }
  
  public boolean isSetDivId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DIVID$62) != 0);
    } 
  }
  
  public void setDivId(CTDecimalNumber paramCTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(DIVID$62, 0);
      if (cTDecimalNumber == null)
        cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(DIVID$62); 
      cTDecimalNumber.set((XmlObject)paramCTDecimalNumber);
    } 
  }
  
  public CTDecimalNumber addNewDivId() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(DIVID$62);
      return cTDecimalNumber;
    } 
  }
  
  public void unsetDivId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DIVID$62, 0);
    } 
  }
  
  public CTCnf getCnfStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTCnf cTCnf = null;
      cTCnf = (CTCnf)get_store().find_element_user(CNFSTYLE$64, 0);
      if (cTCnf == null)
        return null; 
      return cTCnf;
    } 
  }
  
  public boolean isSetCnfStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CNFSTYLE$64) != 0);
    } 
  }
  
  public void setCnfStyle(CTCnf paramCTCnf) {
    synchronized (monitor()) {
      check_orphaned();
      CTCnf cTCnf = null;
      cTCnf = (CTCnf)get_store().find_element_user(CNFSTYLE$64, 0);
      if (cTCnf == null)
        cTCnf = (CTCnf)get_store().add_element_user(CNFSTYLE$64); 
      cTCnf.set((XmlObject)paramCTCnf);
    } 
  }
  
  public CTCnf addNewCnfStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTCnf cTCnf = null;
      cTCnf = (CTCnf)get_store().add_element_user(CNFSTYLE$64);
      return cTCnf;
    } 
  }
  
  public void unsetCnfStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CNFSTYLE$64, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTPPrBaseImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */