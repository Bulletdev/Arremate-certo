package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLevelText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STString;

public class CTLevelTextImpl extends XmlComplexContentImpl implements CTLevelText {
  private static final b VAL$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val");
  
  private static final b NULL$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "null");
  
  public CTLevelTextImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public String getVal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STString xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STString sTString = null;
      sTString = (STString)get_store().find_attribute_user(VAL$0);
      return sTString;
    } 
  }
  
  public boolean isSetVal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(VAL$0) != null);
    } 
  }
  
  public void setVal(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VAL$0); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetVal(STString paramSTString) {
    synchronized (monitor()) {
      check_orphaned();
      STString sTString = null;
      sTString = (STString)get_store().find_attribute_user(VAL$0);
      if (sTString == null)
        sTString = (STString)get_store().add_attribute_user(VAL$0); 
      sTString.set((XmlObject)paramSTString);
    } 
  }
  
  public void unsetVal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(VAL$0);
    } 
  }
  
  public STOnOff.Enum getNull() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NULL$2);
      if (simpleValue == null)
        return null; 
      return (STOnOff.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STOnOff xgetNull() {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(NULL$2);
      return sTOnOff;
    } 
  }
  
  public boolean isSetNull() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(NULL$2) != null);
    } 
  }
  
  public void setNull(STOnOff.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NULL$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NULL$2); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetNull(STOnOff paramSTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(NULL$2);
      if (sTOnOff == null)
        sTOnOff = (STOnOff)get_store().add_attribute_user(NULL$2); 
      sTOnOff.set((XmlObject)paramSTOnOff);
    } 
  }
  
  public void unsetNull() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(NULL$2);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTLevelTextImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */