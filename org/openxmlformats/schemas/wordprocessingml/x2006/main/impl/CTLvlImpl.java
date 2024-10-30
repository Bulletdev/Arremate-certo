package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.math.BigInteger;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLevelSuffix;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLevelText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvlLegacy;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumFmt;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STLongHexNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;

public class CTLvlImpl extends XmlComplexContentImpl implements CTLvl {
  private static final b START$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "start");
  
  private static final b NUMFMT$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "numFmt");
  
  private static final b LVLRESTART$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lvlRestart");
  
  private static final b PSTYLE$6 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pStyle");
  
  private static final b ISLGL$8 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "isLgl");
  
  private static final b SUFF$10 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "suff");
  
  private static final b LVLTEXT$12 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lvlText");
  
  private static final b LVLPICBULLETID$14 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lvlPicBulletId");
  
  private static final b LEGACY$16 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "legacy");
  
  private static final b LVLJC$18 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lvlJc");
  
  private static final b PPR$20 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pPr");
  
  private static final b RPR$22 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rPr");
  
  private static final b ILVL$24 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ilvl");
  
  private static final b TPLC$26 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tplc");
  
  private static final b TENTATIVE$28 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tentative");
  
  public CTLvlImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTDecimalNumber getStart() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(START$0, 0);
      if (cTDecimalNumber == null)
        return null; 
      return cTDecimalNumber;
    } 
  }
  
  public boolean isSetStart() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(START$0) != 0);
    } 
  }
  
  public void setStart(CTDecimalNumber paramCTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(START$0, 0);
      if (cTDecimalNumber == null)
        cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(START$0); 
      cTDecimalNumber.set((XmlObject)paramCTDecimalNumber);
    } 
  }
  
  public CTDecimalNumber addNewStart() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(START$0);
      return cTDecimalNumber;
    } 
  }
  
  public void unsetStart() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(START$0, 0);
    } 
  }
  
  public CTNumFmt getNumFmt() {
    synchronized (monitor()) {
      check_orphaned();
      CTNumFmt cTNumFmt = null;
      cTNumFmt = (CTNumFmt)get_store().find_element_user(NUMFMT$2, 0);
      if (cTNumFmt == null)
        return null; 
      return cTNumFmt;
    } 
  }
  
  public boolean isSetNumFmt() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NUMFMT$2) != 0);
    } 
  }
  
  public void setNumFmt(CTNumFmt paramCTNumFmt) {
    synchronized (monitor()) {
      check_orphaned();
      CTNumFmt cTNumFmt = null;
      cTNumFmt = (CTNumFmt)get_store().find_element_user(NUMFMT$2, 0);
      if (cTNumFmt == null)
        cTNumFmt = (CTNumFmt)get_store().add_element_user(NUMFMT$2); 
      cTNumFmt.set((XmlObject)paramCTNumFmt);
    } 
  }
  
  public CTNumFmt addNewNumFmt() {
    synchronized (monitor()) {
      check_orphaned();
      CTNumFmt cTNumFmt = null;
      cTNumFmt = (CTNumFmt)get_store().add_element_user(NUMFMT$2);
      return cTNumFmt;
    } 
  }
  
  public void unsetNumFmt() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NUMFMT$2, 0);
    } 
  }
  
  public CTDecimalNumber getLvlRestart() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(LVLRESTART$4, 0);
      if (cTDecimalNumber == null)
        return null; 
      return cTDecimalNumber;
    } 
  }
  
  public boolean isSetLvlRestart() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LVLRESTART$4) != 0);
    } 
  }
  
  public void setLvlRestart(CTDecimalNumber paramCTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(LVLRESTART$4, 0);
      if (cTDecimalNumber == null)
        cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(LVLRESTART$4); 
      cTDecimalNumber.set((XmlObject)paramCTDecimalNumber);
    } 
  }
  
  public CTDecimalNumber addNewLvlRestart() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(LVLRESTART$4);
      return cTDecimalNumber;
    } 
  }
  
  public void unsetLvlRestart() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LVLRESTART$4, 0);
    } 
  }
  
  public CTString getPStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(PSTYLE$6, 0);
      if (cTString == null)
        return null; 
      return cTString;
    } 
  }
  
  public boolean isSetPStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PSTYLE$6) != 0);
    } 
  }
  
  public void setPStyle(CTString paramCTString) {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(PSTYLE$6, 0);
      if (cTString == null)
        cTString = (CTString)get_store().add_element_user(PSTYLE$6); 
      cTString.set((XmlObject)paramCTString);
    } 
  }
  
  public CTString addNewPStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().add_element_user(PSTYLE$6);
      return cTString;
    } 
  }
  
  public void unsetPStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PSTYLE$6, 0);
    } 
  }
  
  public CTOnOff getIsLgl() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(ISLGL$8, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetIsLgl() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ISLGL$8) != 0);
    } 
  }
  
  public void setIsLgl(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(ISLGL$8, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(ISLGL$8); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewIsLgl() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(ISLGL$8);
      return cTOnOff;
    } 
  }
  
  public void unsetIsLgl() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ISLGL$8, 0);
    } 
  }
  
  public CTLevelSuffix getSuff() {
    synchronized (monitor()) {
      check_orphaned();
      CTLevelSuffix cTLevelSuffix = null;
      cTLevelSuffix = (CTLevelSuffix)get_store().find_element_user(SUFF$10, 0);
      if (cTLevelSuffix == null)
        return null; 
      return cTLevelSuffix;
    } 
  }
  
  public boolean isSetSuff() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SUFF$10) != 0);
    } 
  }
  
  public void setSuff(CTLevelSuffix paramCTLevelSuffix) {
    synchronized (monitor()) {
      check_orphaned();
      CTLevelSuffix cTLevelSuffix = null;
      cTLevelSuffix = (CTLevelSuffix)get_store().find_element_user(SUFF$10, 0);
      if (cTLevelSuffix == null)
        cTLevelSuffix = (CTLevelSuffix)get_store().add_element_user(SUFF$10); 
      cTLevelSuffix.set((XmlObject)paramCTLevelSuffix);
    } 
  }
  
  public CTLevelSuffix addNewSuff() {
    synchronized (monitor()) {
      check_orphaned();
      CTLevelSuffix cTLevelSuffix = null;
      cTLevelSuffix = (CTLevelSuffix)get_store().add_element_user(SUFF$10);
      return cTLevelSuffix;
    } 
  }
  
  public void unsetSuff() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SUFF$10, 0);
    } 
  }
  
  public CTLevelText getLvlText() {
    synchronized (monitor()) {
      check_orphaned();
      CTLevelText cTLevelText = null;
      cTLevelText = (CTLevelText)get_store().find_element_user(LVLTEXT$12, 0);
      if (cTLevelText == null)
        return null; 
      return cTLevelText;
    } 
  }
  
  public boolean isSetLvlText() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LVLTEXT$12) != 0);
    } 
  }
  
  public void setLvlText(CTLevelText paramCTLevelText) {
    synchronized (monitor()) {
      check_orphaned();
      CTLevelText cTLevelText = null;
      cTLevelText = (CTLevelText)get_store().find_element_user(LVLTEXT$12, 0);
      if (cTLevelText == null)
        cTLevelText = (CTLevelText)get_store().add_element_user(LVLTEXT$12); 
      cTLevelText.set((XmlObject)paramCTLevelText);
    } 
  }
  
  public CTLevelText addNewLvlText() {
    synchronized (monitor()) {
      check_orphaned();
      CTLevelText cTLevelText = null;
      cTLevelText = (CTLevelText)get_store().add_element_user(LVLTEXT$12);
      return cTLevelText;
    } 
  }
  
  public void unsetLvlText() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LVLTEXT$12, 0);
    } 
  }
  
  public CTDecimalNumber getLvlPicBulletId() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(LVLPICBULLETID$14, 0);
      if (cTDecimalNumber == null)
        return null; 
      return cTDecimalNumber;
    } 
  }
  
  public boolean isSetLvlPicBulletId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LVLPICBULLETID$14) != 0);
    } 
  }
  
  public void setLvlPicBulletId(CTDecimalNumber paramCTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(LVLPICBULLETID$14, 0);
      if (cTDecimalNumber == null)
        cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(LVLPICBULLETID$14); 
      cTDecimalNumber.set((XmlObject)paramCTDecimalNumber);
    } 
  }
  
  public CTDecimalNumber addNewLvlPicBulletId() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(LVLPICBULLETID$14);
      return cTDecimalNumber;
    } 
  }
  
  public void unsetLvlPicBulletId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LVLPICBULLETID$14, 0);
    } 
  }
  
  public CTLvlLegacy getLegacy() {
    synchronized (monitor()) {
      check_orphaned();
      CTLvlLegacy cTLvlLegacy = null;
      cTLvlLegacy = (CTLvlLegacy)get_store().find_element_user(LEGACY$16, 0);
      if (cTLvlLegacy == null)
        return null; 
      return cTLvlLegacy;
    } 
  }
  
  public boolean isSetLegacy() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LEGACY$16) != 0);
    } 
  }
  
  public void setLegacy(CTLvlLegacy paramCTLvlLegacy) {
    synchronized (monitor()) {
      check_orphaned();
      CTLvlLegacy cTLvlLegacy = null;
      cTLvlLegacy = (CTLvlLegacy)get_store().find_element_user(LEGACY$16, 0);
      if (cTLvlLegacy == null)
        cTLvlLegacy = (CTLvlLegacy)get_store().add_element_user(LEGACY$16); 
      cTLvlLegacy.set((XmlObject)paramCTLvlLegacy);
    } 
  }
  
  public CTLvlLegacy addNewLegacy() {
    synchronized (monitor()) {
      check_orphaned();
      CTLvlLegacy cTLvlLegacy = null;
      cTLvlLegacy = (CTLvlLegacy)get_store().add_element_user(LEGACY$16);
      return cTLvlLegacy;
    } 
  }
  
  public void unsetLegacy() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LEGACY$16, 0);
    } 
  }
  
  public CTJc getLvlJc() {
    synchronized (monitor()) {
      check_orphaned();
      CTJc cTJc = null;
      cTJc = (CTJc)get_store().find_element_user(LVLJC$18, 0);
      if (cTJc == null)
        return null; 
      return cTJc;
    } 
  }
  
  public boolean isSetLvlJc() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LVLJC$18) != 0);
    } 
  }
  
  public void setLvlJc(CTJc paramCTJc) {
    synchronized (monitor()) {
      check_orphaned();
      CTJc cTJc = null;
      cTJc = (CTJc)get_store().find_element_user(LVLJC$18, 0);
      if (cTJc == null)
        cTJc = (CTJc)get_store().add_element_user(LVLJC$18); 
      cTJc.set((XmlObject)paramCTJc);
    } 
  }
  
  public CTJc addNewLvlJc() {
    synchronized (monitor()) {
      check_orphaned();
      CTJc cTJc = null;
      cTJc = (CTJc)get_store().add_element_user(LVLJC$18);
      return cTJc;
    } 
  }
  
  public void unsetLvlJc() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LVLJC$18, 0);
    } 
  }
  
  public CTPPr getPPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTPPr cTPPr = null;
      cTPPr = (CTPPr)get_store().find_element_user(PPR$20, 0);
      if (cTPPr == null)
        return null; 
      return cTPPr;
    } 
  }
  
  public boolean isSetPPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PPR$20) != 0);
    } 
  }
  
  public void setPPr(CTPPr paramCTPPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTPPr cTPPr = null;
      cTPPr = (CTPPr)get_store().find_element_user(PPR$20, 0);
      if (cTPPr == null)
        cTPPr = (CTPPr)get_store().add_element_user(PPR$20); 
      cTPPr.set((XmlObject)paramCTPPr);
    } 
  }
  
  public CTPPr addNewPPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTPPr cTPPr = null;
      cTPPr = (CTPPr)get_store().add_element_user(PPR$20);
      return cTPPr;
    } 
  }
  
  public void unsetPPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PPR$20, 0);
    } 
  }
  
  public CTRPr getRPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTRPr cTRPr = null;
      cTRPr = (CTRPr)get_store().find_element_user(RPR$22, 0);
      if (cTRPr == null)
        return null; 
      return cTRPr;
    } 
  }
  
  public boolean isSetRPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(RPR$22) != 0);
    } 
  }
  
  public void setRPr(CTRPr paramCTRPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTRPr cTRPr = null;
      cTRPr = (CTRPr)get_store().find_element_user(RPR$22, 0);
      if (cTRPr == null)
        cTRPr = (CTRPr)get_store().add_element_user(RPR$22); 
      cTRPr.set((XmlObject)paramCTRPr);
    } 
  }
  
  public CTRPr addNewRPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTRPr cTRPr = null;
      cTRPr = (CTRPr)get_store().add_element_user(RPR$22);
      return cTRPr;
    } 
  }
  
  public void unsetRPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(RPR$22, 0);
    } 
  }
  
  public BigInteger getIlvl() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ILVL$24);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public STDecimalNumber xgetIlvl() {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(ILVL$24);
      return sTDecimalNumber;
    } 
  }
  
  public void setIlvl(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ILVL$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ILVL$24); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetIlvl(STDecimalNumber paramSTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(ILVL$24);
      if (sTDecimalNumber == null)
        sTDecimalNumber = (STDecimalNumber)get_store().add_attribute_user(ILVL$24); 
      sTDecimalNumber.set((XmlObject)paramSTDecimalNumber);
    } 
  }
  
  public byte[] getTplc() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TPLC$26);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public STLongHexNumber xgetTplc() {
    synchronized (monitor()) {
      check_orphaned();
      STLongHexNumber sTLongHexNumber = null;
      sTLongHexNumber = (STLongHexNumber)get_store().find_attribute_user(TPLC$26);
      return sTLongHexNumber;
    } 
  }
  
  public boolean isSetTplc() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TPLC$26) != null);
    } 
  }
  
  public void setTplc(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TPLC$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TPLC$26); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetTplc(STLongHexNumber paramSTLongHexNumber) {
    synchronized (monitor()) {
      check_orphaned();
      STLongHexNumber sTLongHexNumber = null;
      sTLongHexNumber = (STLongHexNumber)get_store().find_attribute_user(TPLC$26);
      if (sTLongHexNumber == null)
        sTLongHexNumber = (STLongHexNumber)get_store().add_attribute_user(TPLC$26); 
      sTLongHexNumber.set((XmlObject)paramSTLongHexNumber);
    } 
  }
  
  public void unsetTplc() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TPLC$26);
    } 
  }
  
  public STOnOff.Enum getTentative() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TENTATIVE$28);
      if (simpleValue == null)
        return null; 
      return (STOnOff.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STOnOff xgetTentative() {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(TENTATIVE$28);
      return sTOnOff;
    } 
  }
  
  public boolean isSetTentative() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TENTATIVE$28) != null);
    } 
  }
  
  public void setTentative(STOnOff.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TENTATIVE$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TENTATIVE$28); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetTentative(STOnOff paramSTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(TENTATIVE$28);
      if (sTOnOff == null)
        sTOnOff = (STOnOff)get_store().add_attribute_user(TENTATIVE$28); 
      sTOnOff.set((XmlObject)paramSTOnOff);
    } 
  }
  
  public void unsetTentative() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TENTATIVE$28);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTLvlImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */