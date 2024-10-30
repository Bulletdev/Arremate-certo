package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSym;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShortHexNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STString;

public class CTSymImpl extends XmlComplexContentImpl implements CTSym {
  private static final b FONT$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "font");
  
  private static final b CHAR$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "char");
  
  public CTSymImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public String getFont() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FONT$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STString xgetFont() {
    synchronized (monitor()) {
      check_orphaned();
      STString sTString = null;
      sTString = (STString)get_store().find_attribute_user(FONT$0);
      return sTString;
    } 
  }
  
  public boolean isSetFont() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FONT$0) != null);
    } 
  }
  
  public void setFont(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FONT$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FONT$0); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetFont(STString paramSTString) {
    synchronized (monitor()) {
      check_orphaned();
      STString sTString = null;
      sTString = (STString)get_store().find_attribute_user(FONT$0);
      if (sTString == null)
        sTString = (STString)get_store().add_attribute_user(FONT$0); 
      sTString.set((XmlObject)paramSTString);
    } 
  }
  
  public void unsetFont() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FONT$0);
    } 
  }
  
  public byte[] getChar() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CHAR$2);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public STShortHexNumber xgetChar() {
    synchronized (monitor()) {
      check_orphaned();
      STShortHexNumber sTShortHexNumber = null;
      sTShortHexNumber = (STShortHexNumber)get_store().find_attribute_user(CHAR$2);
      return sTShortHexNumber;
    } 
  }
  
  public boolean isSetChar() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CHAR$2) != null);
    } 
  }
  
  public void setChar(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CHAR$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CHAR$2); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetChar(STShortHexNumber paramSTShortHexNumber) {
    synchronized (monitor()) {
      check_orphaned();
      STShortHexNumber sTShortHexNumber = null;
      sTShortHexNumber = (STShortHexNumber)get_store().find_attribute_user(CHAR$2);
      if (sTShortHexNumber == null)
        sTShortHexNumber = (STShortHexNumber)get_store().add_attribute_user(CHAR$2); 
      sTShortHexNumber.set((XmlObject)paramSTShortHexNumber);
    } 
  }
  
  public void unsetChar() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CHAR$2);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTSymImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */