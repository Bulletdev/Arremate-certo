package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNoFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPatternFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextUnderlineFillFollowText;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextUnderlineFillGroupWrapper;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextUnderlineLineFollowText;
import org.openxmlformats.schemas.drawingml.x2006.main.STPercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextCapsType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextFontSize;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextLanguageID;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextNonNegativePoint;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextPoint;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextStrikeType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextUnderlineType;

public class CTTextCharacterPropertiesImpl extends XmlComplexContentImpl implements CTTextCharacterProperties {
  private static final b LN$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "ln");
  
  private static final b NOFILL$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "noFill");
  
  private static final b SOLIDFILL$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "solidFill");
  
  private static final b GRADFILL$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "gradFill");
  
  private static final b BLIPFILL$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "blipFill");
  
  private static final b PATTFILL$10 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "pattFill");
  
  private static final b GRPFILL$12 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "grpFill");
  
  private static final b EFFECTLST$14 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "effectLst");
  
  private static final b EFFECTDAG$16 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "effectDag");
  
  private static final b HIGHLIGHT$18 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "highlight");
  
  private static final b ULNTX$20 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "uLnTx");
  
  private static final b ULN$22 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "uLn");
  
  private static final b UFILLTX$24 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "uFillTx");
  
  private static final b UFILL$26 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "uFill");
  
  private static final b LATIN$28 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "latin");
  
  private static final b EA$30 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "ea");
  
  private static final b CS$32 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "cs");
  
  private static final b SYM$34 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "sym");
  
  private static final b HLINKCLICK$36 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "hlinkClick");
  
  private static final b HLINKMOUSEOVER$38 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "hlinkMouseOver");
  
  private static final b EXTLST$40 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
  
  private static final b KUMIMOJI$42 = new b("", "kumimoji");
  
  private static final b LANG$44 = new b("", "lang");
  
  private static final b ALTLANG$46 = new b("", "altLang");
  
  private static final b SZ$48 = new b("", "sz");
  
  private static final b B$50 = new b("", "b");
  
  private static final b I$52 = new b("", "i");
  
  private static final b U$54 = new b("", "u");
  
  private static final b STRIKE$56 = new b("", "strike");
  
  private static final b KERN$58 = new b("", "kern");
  
  private static final b CAP$60 = new b("", "cap");
  
  private static final b SPC$62 = new b("", "spc");
  
  private static final b NORMALIZEH$64 = new b("", "normalizeH");
  
  private static final b BASELINE$66 = new b("", "baseline");
  
  private static final b NOPROOF$68 = new b("", "noProof");
  
  private static final b DIRTY$70 = new b("", "dirty");
  
  private static final b ERR$72 = new b("", "err");
  
  private static final b SMTCLEAN$74 = new b("", "smtClean");
  
  private static final b SMTID$76 = new b("", "smtId");
  
  private static final b BMK$78 = new b("", "bmk");
  
  public CTTextCharacterPropertiesImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTLineProperties getLn() {
    synchronized (monitor()) {
      check_orphaned();
      CTLineProperties cTLineProperties = null;
      cTLineProperties = (CTLineProperties)get_store().find_element_user(LN$0, 0);
      if (cTLineProperties == null)
        return null; 
      return cTLineProperties;
    } 
  }
  
  public boolean isSetLn() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LN$0) != 0);
    } 
  }
  
  public void setLn(CTLineProperties paramCTLineProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTLineProperties cTLineProperties = null;
      cTLineProperties = (CTLineProperties)get_store().find_element_user(LN$0, 0);
      if (cTLineProperties == null)
        cTLineProperties = (CTLineProperties)get_store().add_element_user(LN$0); 
      cTLineProperties.set((XmlObject)paramCTLineProperties);
    } 
  }
  
  public CTLineProperties addNewLn() {
    synchronized (monitor()) {
      check_orphaned();
      CTLineProperties cTLineProperties = null;
      cTLineProperties = (CTLineProperties)get_store().add_element_user(LN$0);
      return cTLineProperties;
    } 
  }
  
  public void unsetLn() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LN$0, 0);
    } 
  }
  
  public CTNoFillProperties getNoFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTNoFillProperties cTNoFillProperties = null;
      cTNoFillProperties = (CTNoFillProperties)get_store().find_element_user(NOFILL$2, 0);
      if (cTNoFillProperties == null)
        return null; 
      return cTNoFillProperties;
    } 
  }
  
  public boolean isSetNoFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NOFILL$2) != 0);
    } 
  }
  
  public void setNoFill(CTNoFillProperties paramCTNoFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTNoFillProperties cTNoFillProperties = null;
      cTNoFillProperties = (CTNoFillProperties)get_store().find_element_user(NOFILL$2, 0);
      if (cTNoFillProperties == null)
        cTNoFillProperties = (CTNoFillProperties)get_store().add_element_user(NOFILL$2); 
      cTNoFillProperties.set((XmlObject)paramCTNoFillProperties);
    } 
  }
  
  public CTNoFillProperties addNewNoFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTNoFillProperties cTNoFillProperties = null;
      cTNoFillProperties = (CTNoFillProperties)get_store().add_element_user(NOFILL$2);
      return cTNoFillProperties;
    } 
  }
  
  public void unsetNoFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NOFILL$2, 0);
    } 
  }
  
  public CTSolidColorFillProperties getSolidFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTSolidColorFillProperties cTSolidColorFillProperties = null;
      cTSolidColorFillProperties = (CTSolidColorFillProperties)get_store().find_element_user(SOLIDFILL$4, 0);
      if (cTSolidColorFillProperties == null)
        return null; 
      return cTSolidColorFillProperties;
    } 
  }
  
  public boolean isSetSolidFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SOLIDFILL$4) != 0);
    } 
  }
  
  public void setSolidFill(CTSolidColorFillProperties paramCTSolidColorFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTSolidColorFillProperties cTSolidColorFillProperties = null;
      cTSolidColorFillProperties = (CTSolidColorFillProperties)get_store().find_element_user(SOLIDFILL$4, 0);
      if (cTSolidColorFillProperties == null)
        cTSolidColorFillProperties = (CTSolidColorFillProperties)get_store().add_element_user(SOLIDFILL$4); 
      cTSolidColorFillProperties.set((XmlObject)paramCTSolidColorFillProperties);
    } 
  }
  
  public CTSolidColorFillProperties addNewSolidFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTSolidColorFillProperties cTSolidColorFillProperties = null;
      cTSolidColorFillProperties = (CTSolidColorFillProperties)get_store().add_element_user(SOLIDFILL$4);
      return cTSolidColorFillProperties;
    } 
  }
  
  public void unsetSolidFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SOLIDFILL$4, 0);
    } 
  }
  
  public CTGradientFillProperties getGradFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTGradientFillProperties cTGradientFillProperties = null;
      cTGradientFillProperties = (CTGradientFillProperties)get_store().find_element_user(GRADFILL$6, 0);
      if (cTGradientFillProperties == null)
        return null; 
      return cTGradientFillProperties;
    } 
  }
  
  public boolean isSetGradFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(GRADFILL$6) != 0);
    } 
  }
  
  public void setGradFill(CTGradientFillProperties paramCTGradientFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTGradientFillProperties cTGradientFillProperties = null;
      cTGradientFillProperties = (CTGradientFillProperties)get_store().find_element_user(GRADFILL$6, 0);
      if (cTGradientFillProperties == null)
        cTGradientFillProperties = (CTGradientFillProperties)get_store().add_element_user(GRADFILL$6); 
      cTGradientFillProperties.set((XmlObject)paramCTGradientFillProperties);
    } 
  }
  
  public CTGradientFillProperties addNewGradFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTGradientFillProperties cTGradientFillProperties = null;
      cTGradientFillProperties = (CTGradientFillProperties)get_store().add_element_user(GRADFILL$6);
      return cTGradientFillProperties;
    } 
  }
  
  public void unsetGradFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GRADFILL$6, 0);
    } 
  }
  
  public CTBlipFillProperties getBlipFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTBlipFillProperties cTBlipFillProperties = null;
      cTBlipFillProperties = (CTBlipFillProperties)get_store().find_element_user(BLIPFILL$8, 0);
      if (cTBlipFillProperties == null)
        return null; 
      return cTBlipFillProperties;
    } 
  }
  
  public boolean isSetBlipFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BLIPFILL$8) != 0);
    } 
  }
  
  public void setBlipFill(CTBlipFillProperties paramCTBlipFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTBlipFillProperties cTBlipFillProperties = null;
      cTBlipFillProperties = (CTBlipFillProperties)get_store().find_element_user(BLIPFILL$8, 0);
      if (cTBlipFillProperties == null)
        cTBlipFillProperties = (CTBlipFillProperties)get_store().add_element_user(BLIPFILL$8); 
      cTBlipFillProperties.set((XmlObject)paramCTBlipFillProperties);
    } 
  }
  
  public CTBlipFillProperties addNewBlipFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTBlipFillProperties cTBlipFillProperties = null;
      cTBlipFillProperties = (CTBlipFillProperties)get_store().add_element_user(BLIPFILL$8);
      return cTBlipFillProperties;
    } 
  }
  
  public void unsetBlipFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BLIPFILL$8, 0);
    } 
  }
  
  public CTPatternFillProperties getPattFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTPatternFillProperties cTPatternFillProperties = null;
      cTPatternFillProperties = (CTPatternFillProperties)get_store().find_element_user(PATTFILL$10, 0);
      if (cTPatternFillProperties == null)
        return null; 
      return cTPatternFillProperties;
    } 
  }
  
  public boolean isSetPattFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PATTFILL$10) != 0);
    } 
  }
  
  public void setPattFill(CTPatternFillProperties paramCTPatternFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTPatternFillProperties cTPatternFillProperties = null;
      cTPatternFillProperties = (CTPatternFillProperties)get_store().find_element_user(PATTFILL$10, 0);
      if (cTPatternFillProperties == null)
        cTPatternFillProperties = (CTPatternFillProperties)get_store().add_element_user(PATTFILL$10); 
      cTPatternFillProperties.set((XmlObject)paramCTPatternFillProperties);
    } 
  }
  
  public CTPatternFillProperties addNewPattFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTPatternFillProperties cTPatternFillProperties = null;
      cTPatternFillProperties = (CTPatternFillProperties)get_store().add_element_user(PATTFILL$10);
      return cTPatternFillProperties;
    } 
  }
  
  public void unsetPattFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PATTFILL$10, 0);
    } 
  }
  
  public CTGroupFillProperties getGrpFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupFillProperties cTGroupFillProperties = null;
      cTGroupFillProperties = (CTGroupFillProperties)get_store().find_element_user(GRPFILL$12, 0);
      if (cTGroupFillProperties == null)
        return null; 
      return cTGroupFillProperties;
    } 
  }
  
  public boolean isSetGrpFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(GRPFILL$12) != 0);
    } 
  }
  
  public void setGrpFill(CTGroupFillProperties paramCTGroupFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupFillProperties cTGroupFillProperties = null;
      cTGroupFillProperties = (CTGroupFillProperties)get_store().find_element_user(GRPFILL$12, 0);
      if (cTGroupFillProperties == null)
        cTGroupFillProperties = (CTGroupFillProperties)get_store().add_element_user(GRPFILL$12); 
      cTGroupFillProperties.set((XmlObject)paramCTGroupFillProperties);
    } 
  }
  
  public CTGroupFillProperties addNewGrpFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupFillProperties cTGroupFillProperties = null;
      cTGroupFillProperties = (CTGroupFillProperties)get_store().add_element_user(GRPFILL$12);
      return cTGroupFillProperties;
    } 
  }
  
  public void unsetGrpFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GRPFILL$12, 0);
    } 
  }
  
  public CTEffectList getEffectLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectList cTEffectList = null;
      cTEffectList = (CTEffectList)get_store().find_element_user(EFFECTLST$14, 0);
      if (cTEffectList == null)
        return null; 
      return cTEffectList;
    } 
  }
  
  public boolean isSetEffectLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EFFECTLST$14) != 0);
    } 
  }
  
  public void setEffectLst(CTEffectList paramCTEffectList) {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectList cTEffectList = null;
      cTEffectList = (CTEffectList)get_store().find_element_user(EFFECTLST$14, 0);
      if (cTEffectList == null)
        cTEffectList = (CTEffectList)get_store().add_element_user(EFFECTLST$14); 
      cTEffectList.set((XmlObject)paramCTEffectList);
    } 
  }
  
  public CTEffectList addNewEffectLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectList cTEffectList = null;
      cTEffectList = (CTEffectList)get_store().add_element_user(EFFECTLST$14);
      return cTEffectList;
    } 
  }
  
  public void unsetEffectLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EFFECTLST$14, 0);
    } 
  }
  
  public CTEffectContainer getEffectDag() {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectContainer cTEffectContainer = null;
      cTEffectContainer = (CTEffectContainer)get_store().find_element_user(EFFECTDAG$16, 0);
      if (cTEffectContainer == null)
        return null; 
      return cTEffectContainer;
    } 
  }
  
  public boolean isSetEffectDag() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EFFECTDAG$16) != 0);
    } 
  }
  
  public void setEffectDag(CTEffectContainer paramCTEffectContainer) {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectContainer cTEffectContainer = null;
      cTEffectContainer = (CTEffectContainer)get_store().find_element_user(EFFECTDAG$16, 0);
      if (cTEffectContainer == null)
        cTEffectContainer = (CTEffectContainer)get_store().add_element_user(EFFECTDAG$16); 
      cTEffectContainer.set((XmlObject)paramCTEffectContainer);
    } 
  }
  
  public CTEffectContainer addNewEffectDag() {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectContainer cTEffectContainer = null;
      cTEffectContainer = (CTEffectContainer)get_store().add_element_user(EFFECTDAG$16);
      return cTEffectContainer;
    } 
  }
  
  public void unsetEffectDag() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EFFECTDAG$16, 0);
    } 
  }
  
  public CTColor getHighlight() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(HIGHLIGHT$18, 0);
      if (cTColor == null)
        return null; 
      return cTColor;
    } 
  }
  
  public boolean isSetHighlight() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(HIGHLIGHT$18) != 0);
    } 
  }
  
  public void setHighlight(CTColor paramCTColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(HIGHLIGHT$18, 0);
      if (cTColor == null)
        cTColor = (CTColor)get_store().add_element_user(HIGHLIGHT$18); 
      cTColor.set((XmlObject)paramCTColor);
    } 
  }
  
  public CTColor addNewHighlight() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().add_element_user(HIGHLIGHT$18);
      return cTColor;
    } 
  }
  
  public void unsetHighlight() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HIGHLIGHT$18, 0);
    } 
  }
  
  public CTTextUnderlineLineFollowText getULnTx() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextUnderlineLineFollowText cTTextUnderlineLineFollowText = null;
      cTTextUnderlineLineFollowText = (CTTextUnderlineLineFollowText)get_store().find_element_user(ULNTX$20, 0);
      if (cTTextUnderlineLineFollowText == null)
        return null; 
      return cTTextUnderlineLineFollowText;
    } 
  }
  
  public boolean isSetULnTx() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ULNTX$20) != 0);
    } 
  }
  
  public void setULnTx(CTTextUnderlineLineFollowText paramCTTextUnderlineLineFollowText) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextUnderlineLineFollowText cTTextUnderlineLineFollowText = null;
      cTTextUnderlineLineFollowText = (CTTextUnderlineLineFollowText)get_store().find_element_user(ULNTX$20, 0);
      if (cTTextUnderlineLineFollowText == null)
        cTTextUnderlineLineFollowText = (CTTextUnderlineLineFollowText)get_store().add_element_user(ULNTX$20); 
      cTTextUnderlineLineFollowText.set((XmlObject)paramCTTextUnderlineLineFollowText);
    } 
  }
  
  public CTTextUnderlineLineFollowText addNewULnTx() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextUnderlineLineFollowText cTTextUnderlineLineFollowText = null;
      cTTextUnderlineLineFollowText = (CTTextUnderlineLineFollowText)get_store().add_element_user(ULNTX$20);
      return cTTextUnderlineLineFollowText;
    } 
  }
  
  public void unsetULnTx() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ULNTX$20, 0);
    } 
  }
  
  public CTLineProperties getULn() {
    synchronized (monitor()) {
      check_orphaned();
      CTLineProperties cTLineProperties = null;
      cTLineProperties = (CTLineProperties)get_store().find_element_user(ULN$22, 0);
      if (cTLineProperties == null)
        return null; 
      return cTLineProperties;
    } 
  }
  
  public boolean isSetULn() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ULN$22) != 0);
    } 
  }
  
  public void setULn(CTLineProperties paramCTLineProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTLineProperties cTLineProperties = null;
      cTLineProperties = (CTLineProperties)get_store().find_element_user(ULN$22, 0);
      if (cTLineProperties == null)
        cTLineProperties = (CTLineProperties)get_store().add_element_user(ULN$22); 
      cTLineProperties.set((XmlObject)paramCTLineProperties);
    } 
  }
  
  public CTLineProperties addNewULn() {
    synchronized (monitor()) {
      check_orphaned();
      CTLineProperties cTLineProperties = null;
      cTLineProperties = (CTLineProperties)get_store().add_element_user(ULN$22);
      return cTLineProperties;
    } 
  }
  
  public void unsetULn() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ULN$22, 0);
    } 
  }
  
  public CTTextUnderlineFillFollowText getUFillTx() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextUnderlineFillFollowText cTTextUnderlineFillFollowText = null;
      cTTextUnderlineFillFollowText = (CTTextUnderlineFillFollowText)get_store().find_element_user(UFILLTX$24, 0);
      if (cTTextUnderlineFillFollowText == null)
        return null; 
      return cTTextUnderlineFillFollowText;
    } 
  }
  
  public boolean isSetUFillTx() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(UFILLTX$24) != 0);
    } 
  }
  
  public void setUFillTx(CTTextUnderlineFillFollowText paramCTTextUnderlineFillFollowText) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextUnderlineFillFollowText cTTextUnderlineFillFollowText = null;
      cTTextUnderlineFillFollowText = (CTTextUnderlineFillFollowText)get_store().find_element_user(UFILLTX$24, 0);
      if (cTTextUnderlineFillFollowText == null)
        cTTextUnderlineFillFollowText = (CTTextUnderlineFillFollowText)get_store().add_element_user(UFILLTX$24); 
      cTTextUnderlineFillFollowText.set((XmlObject)paramCTTextUnderlineFillFollowText);
    } 
  }
  
  public CTTextUnderlineFillFollowText addNewUFillTx() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextUnderlineFillFollowText cTTextUnderlineFillFollowText = null;
      cTTextUnderlineFillFollowText = (CTTextUnderlineFillFollowText)get_store().add_element_user(UFILLTX$24);
      return cTTextUnderlineFillFollowText;
    } 
  }
  
  public void unsetUFillTx() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(UFILLTX$24, 0);
    } 
  }
  
  public CTTextUnderlineFillGroupWrapper getUFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextUnderlineFillGroupWrapper cTTextUnderlineFillGroupWrapper = null;
      cTTextUnderlineFillGroupWrapper = (CTTextUnderlineFillGroupWrapper)get_store().find_element_user(UFILL$26, 0);
      if (cTTextUnderlineFillGroupWrapper == null)
        return null; 
      return cTTextUnderlineFillGroupWrapper;
    } 
  }
  
  public boolean isSetUFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(UFILL$26) != 0);
    } 
  }
  
  public void setUFill(CTTextUnderlineFillGroupWrapper paramCTTextUnderlineFillGroupWrapper) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextUnderlineFillGroupWrapper cTTextUnderlineFillGroupWrapper = null;
      cTTextUnderlineFillGroupWrapper = (CTTextUnderlineFillGroupWrapper)get_store().find_element_user(UFILL$26, 0);
      if (cTTextUnderlineFillGroupWrapper == null)
        cTTextUnderlineFillGroupWrapper = (CTTextUnderlineFillGroupWrapper)get_store().add_element_user(UFILL$26); 
      cTTextUnderlineFillGroupWrapper.set((XmlObject)paramCTTextUnderlineFillGroupWrapper);
    } 
  }
  
  public CTTextUnderlineFillGroupWrapper addNewUFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextUnderlineFillGroupWrapper cTTextUnderlineFillGroupWrapper = null;
      cTTextUnderlineFillGroupWrapper = (CTTextUnderlineFillGroupWrapper)get_store().add_element_user(UFILL$26);
      return cTTextUnderlineFillGroupWrapper;
    } 
  }
  
  public void unsetUFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(UFILL$26, 0);
    } 
  }
  
  public CTTextFont getLatin() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextFont cTTextFont = null;
      cTTextFont = (CTTextFont)get_store().find_element_user(LATIN$28, 0);
      if (cTTextFont == null)
        return null; 
      return cTTextFont;
    } 
  }
  
  public boolean isSetLatin() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LATIN$28) != 0);
    } 
  }
  
  public void setLatin(CTTextFont paramCTTextFont) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextFont cTTextFont = null;
      cTTextFont = (CTTextFont)get_store().find_element_user(LATIN$28, 0);
      if (cTTextFont == null)
        cTTextFont = (CTTextFont)get_store().add_element_user(LATIN$28); 
      cTTextFont.set((XmlObject)paramCTTextFont);
    } 
  }
  
  public CTTextFont addNewLatin() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextFont cTTextFont = null;
      cTTextFont = (CTTextFont)get_store().add_element_user(LATIN$28);
      return cTTextFont;
    } 
  }
  
  public void unsetLatin() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LATIN$28, 0);
    } 
  }
  
  public CTTextFont getEa() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextFont cTTextFont = null;
      cTTextFont = (CTTextFont)get_store().find_element_user(EA$30, 0);
      if (cTTextFont == null)
        return null; 
      return cTTextFont;
    } 
  }
  
  public boolean isSetEa() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EA$30) != 0);
    } 
  }
  
  public void setEa(CTTextFont paramCTTextFont) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextFont cTTextFont = null;
      cTTextFont = (CTTextFont)get_store().find_element_user(EA$30, 0);
      if (cTTextFont == null)
        cTTextFont = (CTTextFont)get_store().add_element_user(EA$30); 
      cTTextFont.set((XmlObject)paramCTTextFont);
    } 
  }
  
  public CTTextFont addNewEa() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextFont cTTextFont = null;
      cTTextFont = (CTTextFont)get_store().add_element_user(EA$30);
      return cTTextFont;
    } 
  }
  
  public void unsetEa() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EA$30, 0);
    } 
  }
  
  public CTTextFont getCs() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextFont cTTextFont = null;
      cTTextFont = (CTTextFont)get_store().find_element_user(CS$32, 0);
      if (cTTextFont == null)
        return null; 
      return cTTextFont;
    } 
  }
  
  public boolean isSetCs() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CS$32) != 0);
    } 
  }
  
  public void setCs(CTTextFont paramCTTextFont) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextFont cTTextFont = null;
      cTTextFont = (CTTextFont)get_store().find_element_user(CS$32, 0);
      if (cTTextFont == null)
        cTTextFont = (CTTextFont)get_store().add_element_user(CS$32); 
      cTTextFont.set((XmlObject)paramCTTextFont);
    } 
  }
  
  public CTTextFont addNewCs() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextFont cTTextFont = null;
      cTTextFont = (CTTextFont)get_store().add_element_user(CS$32);
      return cTTextFont;
    } 
  }
  
  public void unsetCs() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CS$32, 0);
    } 
  }
  
  public CTTextFont getSym() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextFont cTTextFont = null;
      cTTextFont = (CTTextFont)get_store().find_element_user(SYM$34, 0);
      if (cTTextFont == null)
        return null; 
      return cTTextFont;
    } 
  }
  
  public boolean isSetSym() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SYM$34) != 0);
    } 
  }
  
  public void setSym(CTTextFont paramCTTextFont) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextFont cTTextFont = null;
      cTTextFont = (CTTextFont)get_store().find_element_user(SYM$34, 0);
      if (cTTextFont == null)
        cTTextFont = (CTTextFont)get_store().add_element_user(SYM$34); 
      cTTextFont.set((XmlObject)paramCTTextFont);
    } 
  }
  
  public CTTextFont addNewSym() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextFont cTTextFont = null;
      cTTextFont = (CTTextFont)get_store().add_element_user(SYM$34);
      return cTTextFont;
    } 
  }
  
  public void unsetSym() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SYM$34, 0);
    } 
  }
  
  public CTHyperlink getHlinkClick() {
    synchronized (monitor()) {
      check_orphaned();
      CTHyperlink cTHyperlink = null;
      cTHyperlink = (CTHyperlink)get_store().find_element_user(HLINKCLICK$36, 0);
      if (cTHyperlink == null)
        return null; 
      return cTHyperlink;
    } 
  }
  
  public boolean isSetHlinkClick() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(HLINKCLICK$36) != 0);
    } 
  }
  
  public void setHlinkClick(CTHyperlink paramCTHyperlink) {
    synchronized (monitor()) {
      check_orphaned();
      CTHyperlink cTHyperlink = null;
      cTHyperlink = (CTHyperlink)get_store().find_element_user(HLINKCLICK$36, 0);
      if (cTHyperlink == null)
        cTHyperlink = (CTHyperlink)get_store().add_element_user(HLINKCLICK$36); 
      cTHyperlink.set((XmlObject)paramCTHyperlink);
    } 
  }
  
  public CTHyperlink addNewHlinkClick() {
    synchronized (monitor()) {
      check_orphaned();
      CTHyperlink cTHyperlink = null;
      cTHyperlink = (CTHyperlink)get_store().add_element_user(HLINKCLICK$36);
      return cTHyperlink;
    } 
  }
  
  public void unsetHlinkClick() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HLINKCLICK$36, 0);
    } 
  }
  
  public CTHyperlink getHlinkMouseOver() {
    synchronized (monitor()) {
      check_orphaned();
      CTHyperlink cTHyperlink = null;
      cTHyperlink = (CTHyperlink)get_store().find_element_user(HLINKMOUSEOVER$38, 0);
      if (cTHyperlink == null)
        return null; 
      return cTHyperlink;
    } 
  }
  
  public boolean isSetHlinkMouseOver() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(HLINKMOUSEOVER$38) != 0);
    } 
  }
  
  public void setHlinkMouseOver(CTHyperlink paramCTHyperlink) {
    synchronized (monitor()) {
      check_orphaned();
      CTHyperlink cTHyperlink = null;
      cTHyperlink = (CTHyperlink)get_store().find_element_user(HLINKMOUSEOVER$38, 0);
      if (cTHyperlink == null)
        cTHyperlink = (CTHyperlink)get_store().add_element_user(HLINKMOUSEOVER$38); 
      cTHyperlink.set((XmlObject)paramCTHyperlink);
    } 
  }
  
  public CTHyperlink addNewHlinkMouseOver() {
    synchronized (monitor()) {
      check_orphaned();
      CTHyperlink cTHyperlink = null;
      cTHyperlink = (CTHyperlink)get_store().add_element_user(HLINKMOUSEOVER$38);
      return cTHyperlink;
    } 
  }
  
  public void unsetHlinkMouseOver() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HLINKMOUSEOVER$38, 0);
    } 
  }
  
  public CTOfficeArtExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$40, 0);
      if (cTOfficeArtExtensionList == null)
        return null; 
      return cTOfficeArtExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$40) != 0);
    } 
  }
  
  public void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$40, 0);
      if (cTOfficeArtExtensionList == null)
        cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$40); 
      cTOfficeArtExtensionList.set((XmlObject)paramCTOfficeArtExtensionList);
    } 
  }
  
  public CTOfficeArtExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$40);
      return cTOfficeArtExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$40, 0);
    } 
  }
  
  public boolean getKumimoji() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(KUMIMOJI$42);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetKumimoji() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(KUMIMOJI$42);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetKumimoji() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(KUMIMOJI$42) != null);
    } 
  }
  
  public void setKumimoji(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(KUMIMOJI$42);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(KUMIMOJI$42); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetKumimoji(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(KUMIMOJI$42);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(KUMIMOJI$42); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetKumimoji() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(KUMIMOJI$42);
    } 
  }
  
  public String getLang() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LANG$44);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STTextLanguageID xgetLang() {
    synchronized (monitor()) {
      check_orphaned();
      STTextLanguageID sTTextLanguageID = null;
      sTTextLanguageID = (STTextLanguageID)get_store().find_attribute_user(LANG$44);
      return sTTextLanguageID;
    } 
  }
  
  public boolean isSetLang() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(LANG$44) != null);
    } 
  }
  
  public void setLang(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LANG$44);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(LANG$44); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetLang(STTextLanguageID paramSTTextLanguageID) {
    synchronized (monitor()) {
      check_orphaned();
      STTextLanguageID sTTextLanguageID = null;
      sTTextLanguageID = (STTextLanguageID)get_store().find_attribute_user(LANG$44);
      if (sTTextLanguageID == null)
        sTTextLanguageID = (STTextLanguageID)get_store().add_attribute_user(LANG$44); 
      sTTextLanguageID.set((XmlObject)paramSTTextLanguageID);
    } 
  }
  
  public void unsetLang() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(LANG$44);
    } 
  }
  
  public String getAltLang() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALTLANG$46);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STTextLanguageID xgetAltLang() {
    synchronized (monitor()) {
      check_orphaned();
      STTextLanguageID sTTextLanguageID = null;
      sTTextLanguageID = (STTextLanguageID)get_store().find_attribute_user(ALTLANG$46);
      return sTTextLanguageID;
    } 
  }
  
  public boolean isSetAltLang() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ALTLANG$46) != null);
    } 
  }
  
  public void setAltLang(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALTLANG$46);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ALTLANG$46); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetAltLang(STTextLanguageID paramSTTextLanguageID) {
    synchronized (monitor()) {
      check_orphaned();
      STTextLanguageID sTTextLanguageID = null;
      sTTextLanguageID = (STTextLanguageID)get_store().find_attribute_user(ALTLANG$46);
      if (sTTextLanguageID == null)
        sTTextLanguageID = (STTextLanguageID)get_store().add_attribute_user(ALTLANG$46); 
      sTTextLanguageID.set((XmlObject)paramSTTextLanguageID);
    } 
  }
  
  public void unsetAltLang() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ALTLANG$46);
    } 
  }
  
  public int getSz() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SZ$48);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STTextFontSize xgetSz() {
    synchronized (monitor()) {
      check_orphaned();
      STTextFontSize sTTextFontSize = null;
      sTTextFontSize = (STTextFontSize)get_store().find_attribute_user(SZ$48);
      return sTTextFontSize;
    } 
  }
  
  public boolean isSetSz() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SZ$48) != null);
    } 
  }
  
  public void setSz(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SZ$48);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SZ$48); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetSz(STTextFontSize paramSTTextFontSize) {
    synchronized (monitor()) {
      check_orphaned();
      STTextFontSize sTTextFontSize = null;
      sTTextFontSize = (STTextFontSize)get_store().find_attribute_user(SZ$48);
      if (sTTextFontSize == null)
        sTTextFontSize = (STTextFontSize)get_store().add_attribute_user(SZ$48); 
      sTTextFontSize.set((XmlObject)paramSTTextFontSize);
    } 
  }
  
  public void unsetSz() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SZ$48);
    } 
  }
  
  public boolean getB() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(B$50);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetB() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(B$50);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetB() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(B$50) != null);
    } 
  }
  
  public void setB(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(B$50);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(B$50); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetB(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(B$50);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(B$50); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetB() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(B$50);
    } 
  }
  
  public boolean getI() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(I$52);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetI() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(I$52);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetI() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(I$52) != null);
    } 
  }
  
  public void setI(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(I$52);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(I$52); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetI(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(I$52);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(I$52); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetI() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(I$52);
    } 
  }
  
  public STTextUnderlineType.Enum getU() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(U$54);
      if (simpleValue == null)
        return null; 
      return (STTextUnderlineType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTextUnderlineType xgetU() {
    synchronized (monitor()) {
      check_orphaned();
      STTextUnderlineType sTTextUnderlineType = null;
      sTTextUnderlineType = (STTextUnderlineType)get_store().find_attribute_user(U$54);
      return sTTextUnderlineType;
    } 
  }
  
  public boolean isSetU() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(U$54) != null);
    } 
  }
  
  public void setU(STTextUnderlineType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(U$54);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(U$54); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetU(STTextUnderlineType paramSTTextUnderlineType) {
    synchronized (monitor()) {
      check_orphaned();
      STTextUnderlineType sTTextUnderlineType = null;
      sTTextUnderlineType = (STTextUnderlineType)get_store().find_attribute_user(U$54);
      if (sTTextUnderlineType == null)
        sTTextUnderlineType = (STTextUnderlineType)get_store().add_attribute_user(U$54); 
      sTTextUnderlineType.set((XmlObject)paramSTTextUnderlineType);
    } 
  }
  
  public void unsetU() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(U$54);
    } 
  }
  
  public STTextStrikeType.Enum getStrike() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STRIKE$56);
      if (simpleValue == null)
        return null; 
      return (STTextStrikeType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTextStrikeType xgetStrike() {
    synchronized (monitor()) {
      check_orphaned();
      STTextStrikeType sTTextStrikeType = null;
      sTTextStrikeType = (STTextStrikeType)get_store().find_attribute_user(STRIKE$56);
      return sTTextStrikeType;
    } 
  }
  
  public boolean isSetStrike() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(STRIKE$56) != null);
    } 
  }
  
  public void setStrike(STTextStrikeType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STRIKE$56);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(STRIKE$56); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetStrike(STTextStrikeType paramSTTextStrikeType) {
    synchronized (monitor()) {
      check_orphaned();
      STTextStrikeType sTTextStrikeType = null;
      sTTextStrikeType = (STTextStrikeType)get_store().find_attribute_user(STRIKE$56);
      if (sTTextStrikeType == null)
        sTTextStrikeType = (STTextStrikeType)get_store().add_attribute_user(STRIKE$56); 
      sTTextStrikeType.set((XmlObject)paramSTTextStrikeType);
    } 
  }
  
  public void unsetStrike() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(STRIKE$56);
    } 
  }
  
  public int getKern() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(KERN$58);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STTextNonNegativePoint xgetKern() {
    synchronized (monitor()) {
      check_orphaned();
      STTextNonNegativePoint sTTextNonNegativePoint = null;
      sTTextNonNegativePoint = (STTextNonNegativePoint)get_store().find_attribute_user(KERN$58);
      return sTTextNonNegativePoint;
    } 
  }
  
  public boolean isSetKern() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(KERN$58) != null);
    } 
  }
  
  public void setKern(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(KERN$58);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(KERN$58); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetKern(STTextNonNegativePoint paramSTTextNonNegativePoint) {
    synchronized (monitor()) {
      check_orphaned();
      STTextNonNegativePoint sTTextNonNegativePoint = null;
      sTTextNonNegativePoint = (STTextNonNegativePoint)get_store().find_attribute_user(KERN$58);
      if (sTTextNonNegativePoint == null)
        sTTextNonNegativePoint = (STTextNonNegativePoint)get_store().add_attribute_user(KERN$58); 
      sTTextNonNegativePoint.set((XmlObject)paramSTTextNonNegativePoint);
    } 
  }
  
  public void unsetKern() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(KERN$58);
    } 
  }
  
  public STTextCapsType.Enum getCap() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CAP$60);
      if (simpleValue == null)
        return null; 
      return (STTextCapsType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTextCapsType xgetCap() {
    synchronized (monitor()) {
      check_orphaned();
      STTextCapsType sTTextCapsType = null;
      sTTextCapsType = (STTextCapsType)get_store().find_attribute_user(CAP$60);
      return sTTextCapsType;
    } 
  }
  
  public boolean isSetCap() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CAP$60) != null);
    } 
  }
  
  public void setCap(STTextCapsType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CAP$60);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CAP$60); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetCap(STTextCapsType paramSTTextCapsType) {
    synchronized (monitor()) {
      check_orphaned();
      STTextCapsType sTTextCapsType = null;
      sTTextCapsType = (STTextCapsType)get_store().find_attribute_user(CAP$60);
      if (sTTextCapsType == null)
        sTTextCapsType = (STTextCapsType)get_store().add_attribute_user(CAP$60); 
      sTTextCapsType.set((XmlObject)paramSTTextCapsType);
    } 
  }
  
  public void unsetCap() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CAP$60);
    } 
  }
  
  public int getSpc() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SPC$62);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STTextPoint xgetSpc() {
    synchronized (monitor()) {
      check_orphaned();
      STTextPoint sTTextPoint = null;
      sTTextPoint = (STTextPoint)get_store().find_attribute_user(SPC$62);
      return sTTextPoint;
    } 
  }
  
  public boolean isSetSpc() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SPC$62) != null);
    } 
  }
  
  public void setSpc(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SPC$62);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SPC$62); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetSpc(STTextPoint paramSTTextPoint) {
    synchronized (monitor()) {
      check_orphaned();
      STTextPoint sTTextPoint = null;
      sTTextPoint = (STTextPoint)get_store().find_attribute_user(SPC$62);
      if (sTTextPoint == null)
        sTTextPoint = (STTextPoint)get_store().add_attribute_user(SPC$62); 
      sTTextPoint.set((XmlObject)paramSTTextPoint);
    } 
  }
  
  public void unsetSpc() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SPC$62);
    } 
  }
  
  public boolean getNormalizeH() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NORMALIZEH$64);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetNormalizeH() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(NORMALIZEH$64);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetNormalizeH() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(NORMALIZEH$64) != null);
    } 
  }
  
  public void setNormalizeH(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NORMALIZEH$64);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NORMALIZEH$64); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetNormalizeH(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(NORMALIZEH$64);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(NORMALIZEH$64); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetNormalizeH() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(NORMALIZEH$64);
    } 
  }
  
  public int getBaseline() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BASELINE$66);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STPercentage xgetBaseline() {
    synchronized (monitor()) {
      check_orphaned();
      STPercentage sTPercentage = null;
      sTPercentage = (STPercentage)get_store().find_attribute_user(BASELINE$66);
      return sTPercentage;
    } 
  }
  
  public boolean isSetBaseline() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BASELINE$66) != null);
    } 
  }
  
  public void setBaseline(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BASELINE$66);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BASELINE$66); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetBaseline(STPercentage paramSTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      STPercentage sTPercentage = null;
      sTPercentage = (STPercentage)get_store().find_attribute_user(BASELINE$66);
      if (sTPercentage == null)
        sTPercentage = (STPercentage)get_store().add_attribute_user(BASELINE$66); 
      sTPercentage.set((XmlObject)paramSTPercentage);
    } 
  }
  
  public void unsetBaseline() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BASELINE$66);
    } 
  }
  
  public boolean getNoProof() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NOPROOF$68);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetNoProof() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(NOPROOF$68);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetNoProof() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(NOPROOF$68) != null);
    } 
  }
  
  public void setNoProof(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NOPROOF$68);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NOPROOF$68); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetNoProof(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(NOPROOF$68);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(NOPROOF$68); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetNoProof() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(NOPROOF$68);
    } 
  }
  
  public boolean getDirty() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DIRTY$70);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(DIRTY$70); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetDirty() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DIRTY$70);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(DIRTY$70); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetDirty() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DIRTY$70) != null);
    } 
  }
  
  public void setDirty(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DIRTY$70);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DIRTY$70); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetDirty(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DIRTY$70);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(DIRTY$70); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetDirty() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DIRTY$70);
    } 
  }
  
  public boolean getErr() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ERR$72);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ERR$72); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetErr() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ERR$72);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(ERR$72); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetErr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ERR$72) != null);
    } 
  }
  
  public void setErr(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ERR$72);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ERR$72); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetErr(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ERR$72);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(ERR$72); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetErr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ERR$72);
    } 
  }
  
  public boolean getSmtClean() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SMTCLEAN$74);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SMTCLEAN$74); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetSmtClean() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SMTCLEAN$74);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SMTCLEAN$74); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetSmtClean() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SMTCLEAN$74) != null);
    } 
  }
  
  public void setSmtClean(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SMTCLEAN$74);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SMTCLEAN$74); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetSmtClean(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SMTCLEAN$74);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SMTCLEAN$74); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetSmtClean() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SMTCLEAN$74);
    } 
  }
  
  public long getSmtId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SMTID$76);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SMTID$76); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetSmtId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(SMTID$76);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(SMTID$76); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetSmtId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SMTID$76) != null);
    } 
  }
  
  public void setSmtId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SMTID$76);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SMTID$76); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetSmtId(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(SMTID$76);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(SMTID$76); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetSmtId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SMTID$76);
    } 
  }
  
  public String getBmk() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BMK$78);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetBmk() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(BMK$78);
      return xmlString;
    } 
  }
  
  public boolean isSetBmk() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BMK$78) != null);
    } 
  }
  
  public void setBmk(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BMK$78);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BMK$78); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetBmk(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(BMK$78);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(BMK$78); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetBmk() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BMK$78);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTTextCharacterPropertiesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */