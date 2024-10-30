package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChangeNumbering;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STFldCharType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;

public class CTFldCharImpl extends XmlComplexContentImpl implements CTFldChar {
  private static final b FLDDATA$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "fldData");
  
  private static final b FFDATA$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ffData");
  
  private static final b NUMBERINGCHANGE$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "numberingChange");
  
  private static final b FLDCHARTYPE$6 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "fldCharType");
  
  private static final b FLDLOCK$8 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "fldLock");
  
  private static final b DIRTY$10 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "dirty");
  
  public CTFldCharImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTText getFldData() {
    synchronized (monitor()) {
      check_orphaned();
      CTText cTText = null;
      cTText = (CTText)get_store().find_element_user(FLDDATA$0, 0);
      if (cTText == null)
        return null; 
      return cTText;
    } 
  }
  
  public boolean isSetFldData() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FLDDATA$0) != 0);
    } 
  }
  
  public void setFldData(CTText paramCTText) {
    synchronized (monitor()) {
      check_orphaned();
      CTText cTText = null;
      cTText = (CTText)get_store().find_element_user(FLDDATA$0, 0);
      if (cTText == null)
        cTText = (CTText)get_store().add_element_user(FLDDATA$0); 
      cTText.set((XmlObject)paramCTText);
    } 
  }
  
  public CTText addNewFldData() {
    synchronized (monitor()) {
      check_orphaned();
      CTText cTText = null;
      cTText = (CTText)get_store().add_element_user(FLDDATA$0);
      return cTText;
    } 
  }
  
  public void unsetFldData() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FLDDATA$0, 0);
    } 
  }
  
  public CTFFData getFfData() {
    synchronized (monitor()) {
      check_orphaned();
      CTFFData cTFFData = null;
      cTFFData = (CTFFData)get_store().find_element_user(FFDATA$2, 0);
      if (cTFFData == null)
        return null; 
      return cTFFData;
    } 
  }
  
  public boolean isSetFfData() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FFDATA$2) != 0);
    } 
  }
  
  public void setFfData(CTFFData paramCTFFData) {
    synchronized (monitor()) {
      check_orphaned();
      CTFFData cTFFData = null;
      cTFFData = (CTFFData)get_store().find_element_user(FFDATA$2, 0);
      if (cTFFData == null)
        cTFFData = (CTFFData)get_store().add_element_user(FFDATA$2); 
      cTFFData.set((XmlObject)paramCTFFData);
    } 
  }
  
  public CTFFData addNewFfData() {
    synchronized (monitor()) {
      check_orphaned();
      CTFFData cTFFData = null;
      cTFFData = (CTFFData)get_store().add_element_user(FFDATA$2);
      return cTFFData;
    } 
  }
  
  public void unsetFfData() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FFDATA$2, 0);
    } 
  }
  
  public CTTrackChangeNumbering getNumberingChange() {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChangeNumbering cTTrackChangeNumbering = null;
      cTTrackChangeNumbering = (CTTrackChangeNumbering)get_store().find_element_user(NUMBERINGCHANGE$4, 0);
      if (cTTrackChangeNumbering == null)
        return null; 
      return cTTrackChangeNumbering;
    } 
  }
  
  public boolean isSetNumberingChange() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NUMBERINGCHANGE$4) != 0);
    } 
  }
  
  public void setNumberingChange(CTTrackChangeNumbering paramCTTrackChangeNumbering) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChangeNumbering cTTrackChangeNumbering = null;
      cTTrackChangeNumbering = (CTTrackChangeNumbering)get_store().find_element_user(NUMBERINGCHANGE$4, 0);
      if (cTTrackChangeNumbering == null)
        cTTrackChangeNumbering = (CTTrackChangeNumbering)get_store().add_element_user(NUMBERINGCHANGE$4); 
      cTTrackChangeNumbering.set((XmlObject)paramCTTrackChangeNumbering);
    } 
  }
  
  public CTTrackChangeNumbering addNewNumberingChange() {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChangeNumbering cTTrackChangeNumbering = null;
      cTTrackChangeNumbering = (CTTrackChangeNumbering)get_store().add_element_user(NUMBERINGCHANGE$4);
      return cTTrackChangeNumbering;
    } 
  }
  
  public void unsetNumberingChange() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NUMBERINGCHANGE$4, 0);
    } 
  }
  
  public STFldCharType.Enum getFldCharType() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FLDCHARTYPE$6);
      if (simpleValue == null)
        return null; 
      return (STFldCharType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STFldCharType xgetFldCharType() {
    synchronized (monitor()) {
      check_orphaned();
      STFldCharType sTFldCharType = null;
      sTFldCharType = (STFldCharType)get_store().find_attribute_user(FLDCHARTYPE$6);
      return sTFldCharType;
    } 
  }
  
  public void setFldCharType(STFldCharType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FLDCHARTYPE$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FLDCHARTYPE$6); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetFldCharType(STFldCharType paramSTFldCharType) {
    synchronized (monitor()) {
      check_orphaned();
      STFldCharType sTFldCharType = null;
      sTFldCharType = (STFldCharType)get_store().find_attribute_user(FLDCHARTYPE$6);
      if (sTFldCharType == null)
        sTFldCharType = (STFldCharType)get_store().add_attribute_user(FLDCHARTYPE$6); 
      sTFldCharType.set((XmlObject)paramSTFldCharType);
    } 
  }
  
  public STOnOff.Enum getFldLock() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FLDLOCK$8);
      if (simpleValue == null)
        return null; 
      return (STOnOff.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STOnOff xgetFldLock() {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(FLDLOCK$8);
      return sTOnOff;
    } 
  }
  
  public boolean isSetFldLock() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FLDLOCK$8) != null);
    } 
  }
  
  public void setFldLock(STOnOff.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FLDLOCK$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FLDLOCK$8); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetFldLock(STOnOff paramSTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(FLDLOCK$8);
      if (sTOnOff == null)
        sTOnOff = (STOnOff)get_store().add_attribute_user(FLDLOCK$8); 
      sTOnOff.set((XmlObject)paramSTOnOff);
    } 
  }
  
  public void unsetFldLock() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FLDLOCK$8);
    } 
  }
  
  public STOnOff.Enum getDirty() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DIRTY$10);
      if (simpleValue == null)
        return null; 
      return (STOnOff.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STOnOff xgetDirty() {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(DIRTY$10);
      return sTOnOff;
    } 
  }
  
  public boolean isSetDirty() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DIRTY$10) != null);
    } 
  }
  
  public void setDirty(STOnOff.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DIRTY$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DIRTY$10); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetDirty(STOnOff paramSTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(DIRTY$10);
      if (sTOnOff == null)
        sTOnOff = (STOnOff)get_store().add_attribute_user(DIRTY$10); 
      sTOnOff.set((XmlObject)paramSTOnOff);
    } 
  }
  
  public void unsetDirty() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DIRTY$10);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTFldCharImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */