package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalDefinedName;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring;

public class CTExternalDefinedNameImpl extends XmlComplexContentImpl implements CTExternalDefinedName {
  private static final b NAME$0 = new b("", "name");
  
  private static final b REFERSTO$2 = new b("", "refersTo");
  
  private static final b SHEETID$4 = new b("", "sheetId");
  
  public CTExternalDefinedNameImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public String getName() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetName() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(NAME$0);
      return sTXstring;
    } 
  }
  
  public void setName(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NAME$0); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetName(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(NAME$0);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(NAME$0); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public String getRefersTo() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(REFERSTO$2);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetRefersTo() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(REFERSTO$2);
      return sTXstring;
    } 
  }
  
  public boolean isSetRefersTo() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(REFERSTO$2) != null);
    } 
  }
  
  public void setRefersTo(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(REFERSTO$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(REFERSTO$2); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetRefersTo(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(REFERSTO$2);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(REFERSTO$2); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetRefersTo() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(REFERSTO$2);
    } 
  }
  
  public long getSheetId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHEETID$4);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetSheetId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(SHEETID$4);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetSheetId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHEETID$4) != null);
    } 
  }
  
  public void setSheetId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHEETID$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHEETID$4); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetSheetId(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(SHEETID$4);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(SHEETID$4); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetSheetId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHEETID$4);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTExternalDefinedNameImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */