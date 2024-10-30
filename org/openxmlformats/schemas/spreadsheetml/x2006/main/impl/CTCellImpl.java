package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellFormula;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellRef;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring;

public class CTCellImpl extends XmlComplexContentImpl implements CTCell {
  private static final b F$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "f");
  
  private static final b V$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "v");
  
  private static final b IS$4 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "is");
  
  private static final b EXTLST$6 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
  
  private static final b R$8 = new b("", "r");
  
  private static final b S$10 = new b("", "s");
  
  private static final b T$12 = new b("", "t");
  
  private static final b CM$14 = new b("", "cm");
  
  private static final b VM$16 = new b("", "vm");
  
  private static final b PH$18 = new b("", "ph");
  
  public CTCellImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTCellFormula getF() {
    synchronized (monitor()) {
      check_orphaned();
      CTCellFormula cTCellFormula = null;
      cTCellFormula = (CTCellFormula)get_store().find_element_user(F$0, 0);
      if (cTCellFormula == null)
        return null; 
      return cTCellFormula;
    } 
  }
  
  public boolean isSetF() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(F$0) != 0);
    } 
  }
  
  public void setF(CTCellFormula paramCTCellFormula) {
    synchronized (monitor()) {
      check_orphaned();
      CTCellFormula cTCellFormula = null;
      cTCellFormula = (CTCellFormula)get_store().find_element_user(F$0, 0);
      if (cTCellFormula == null)
        cTCellFormula = (CTCellFormula)get_store().add_element_user(F$0); 
      cTCellFormula.set((XmlObject)paramCTCellFormula);
    } 
  }
  
  public CTCellFormula addNewF() {
    synchronized (monitor()) {
      check_orphaned();
      CTCellFormula cTCellFormula = null;
      cTCellFormula = (CTCellFormula)get_store().add_element_user(F$0);
      return cTCellFormula;
    } 
  }
  
  public void unsetF() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(F$0, 0);
    } 
  }
  
  public String getV() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(V$2, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetV() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_element_user(V$2, 0);
      return sTXstring;
    } 
  }
  
  public boolean isSetV() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(V$2) != 0);
    } 
  }
  
  public void setV(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(V$2, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(V$2); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetV(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_element_user(V$2, 0);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_element_user(V$2); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetV() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(V$2, 0);
    } 
  }
  
  public CTRst getIs() {
    synchronized (monitor()) {
      check_orphaned();
      CTRst cTRst = null;
      cTRst = (CTRst)get_store().find_element_user(IS$4, 0);
      if (cTRst == null)
        return null; 
      return cTRst;
    } 
  }
  
  public boolean isSetIs() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(IS$4) != 0);
    } 
  }
  
  public void setIs(CTRst paramCTRst) {
    synchronized (monitor()) {
      check_orphaned();
      CTRst cTRst = null;
      cTRst = (CTRst)get_store().find_element_user(IS$4, 0);
      if (cTRst == null)
        cTRst = (CTRst)get_store().add_element_user(IS$4); 
      cTRst.set((XmlObject)paramCTRst);
    } 
  }
  
  public CTRst addNewIs() {
    synchronized (monitor()) {
      check_orphaned();
      CTRst cTRst = null;
      cTRst = (CTRst)get_store().add_element_user(IS$4);
      return cTRst;
    } 
  }
  
  public void unsetIs() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(IS$4, 0);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$6, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$6) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$6, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$6); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$6);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$6, 0);
    } 
  }
  
  public String getR() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(R$8);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STCellRef xgetR() {
    synchronized (monitor()) {
      check_orphaned();
      STCellRef sTCellRef = null;
      sTCellRef = (STCellRef)get_store().find_attribute_user(R$8);
      return sTCellRef;
    } 
  }
  
  public boolean isSetR() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(R$8) != null);
    } 
  }
  
  public void setR(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(R$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(R$8); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetR(STCellRef paramSTCellRef) {
    synchronized (monitor()) {
      check_orphaned();
      STCellRef sTCellRef = null;
      sTCellRef = (STCellRef)get_store().find_attribute_user(R$8);
      if (sTCellRef == null)
        sTCellRef = (STCellRef)get_store().add_attribute_user(R$8); 
      sTCellRef.set((XmlObject)paramSTCellRef);
    } 
  }
  
  public void unsetR() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(R$8);
    } 
  }
  
  public long getS() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(S$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(S$10); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetS() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(S$10);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(S$10); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetS() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(S$10) != null);
    } 
  }
  
  public void setS(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(S$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(S$10); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetS(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(S$10);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(S$10); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetS() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(S$10);
    } 
  }
  
  public STCellType.Enum getT() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(T$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(T$12); 
      if (simpleValue == null)
        return null; 
      return (STCellType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STCellType xgetT() {
    synchronized (monitor()) {
      check_orphaned();
      STCellType sTCellType = null;
      sTCellType = (STCellType)get_store().find_attribute_user(T$12);
      if (sTCellType == null)
        sTCellType = (STCellType)get_default_attribute_value(T$12); 
      return sTCellType;
    } 
  }
  
  public boolean isSetT() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(T$12) != null);
    } 
  }
  
  public void setT(STCellType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(T$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(T$12); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetT(STCellType paramSTCellType) {
    synchronized (monitor()) {
      check_orphaned();
      STCellType sTCellType = null;
      sTCellType = (STCellType)get_store().find_attribute_user(T$12);
      if (sTCellType == null)
        sTCellType = (STCellType)get_store().add_attribute_user(T$12); 
      sTCellType.set((XmlObject)paramSTCellType);
    } 
  }
  
  public void unsetT() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(T$12);
    } 
  }
  
  public long getCm() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CM$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(CM$14); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetCm() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(CM$14);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(CM$14); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetCm() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CM$14) != null);
    } 
  }
  
  public void setCm(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CM$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CM$14); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetCm(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(CM$14);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(CM$14); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetCm() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CM$14);
    } 
  }
  
  public long getVm() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VM$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(VM$16); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetVm() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(VM$16);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(VM$16); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetVm() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(VM$16) != null);
    } 
  }
  
  public void setVm(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VM$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VM$16); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetVm(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(VM$16);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(VM$16); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetVm() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(VM$16);
    } 
  }
  
  public boolean getPh() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PH$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(PH$18); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetPh() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PH$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(PH$18); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetPh() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PH$18) != null);
    } 
  }
  
  public void setPh(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PH$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PH$18); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetPh(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PH$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(PH$18); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetPh() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PH$18);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTCellImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */