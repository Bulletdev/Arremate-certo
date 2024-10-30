package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHexColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STThemeColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STUcharHexNumber;

public class CTColorImpl extends XmlComplexContentImpl implements CTColor {
  private static final b VAL$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val");
  
  private static final b THEMECOLOR$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "themeColor");
  
  private static final b THEMETINT$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "themeTint");
  
  private static final b THEMESHADE$6 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "themeShade");
  
  public CTColorImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public Object getVal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getObjectValue();
    } 
  }
  
  public STHexColor xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STHexColor sTHexColor = null;
      sTHexColor = (STHexColor)get_store().find_attribute_user(VAL$0);
      return sTHexColor;
    } 
  }
  
  public void setVal(Object paramObject) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VAL$0); 
      simpleValue.setObjectValue(paramObject);
    } 
  }
  
  public void xsetVal(STHexColor paramSTHexColor) {
    synchronized (monitor()) {
      check_orphaned();
      STHexColor sTHexColor = null;
      sTHexColor = (STHexColor)get_store().find_attribute_user(VAL$0);
      if (sTHexColor == null)
        sTHexColor = (STHexColor)get_store().add_attribute_user(VAL$0); 
      sTHexColor.set((XmlObject)paramSTHexColor);
    } 
  }
  
  public STThemeColor.Enum getThemeColor() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(THEMECOLOR$2);
      if (simpleValue == null)
        return null; 
      return (STThemeColor.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STThemeColor xgetThemeColor() {
    synchronized (monitor()) {
      check_orphaned();
      STThemeColor sTThemeColor = null;
      sTThemeColor = (STThemeColor)get_store().find_attribute_user(THEMECOLOR$2);
      return sTThemeColor;
    } 
  }
  
  public boolean isSetThemeColor() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(THEMECOLOR$2) != null);
    } 
  }
  
  public void setThemeColor(STThemeColor.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(THEMECOLOR$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(THEMECOLOR$2); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetThemeColor(STThemeColor paramSTThemeColor) {
    synchronized (monitor()) {
      check_orphaned();
      STThemeColor sTThemeColor = null;
      sTThemeColor = (STThemeColor)get_store().find_attribute_user(THEMECOLOR$2);
      if (sTThemeColor == null)
        sTThemeColor = (STThemeColor)get_store().add_attribute_user(THEMECOLOR$2); 
      sTThemeColor.set((XmlObject)paramSTThemeColor);
    } 
  }
  
  public void unsetThemeColor() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(THEMECOLOR$2);
    } 
  }
  
  public byte[] getThemeTint() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(THEMETINT$4);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public STUcharHexNumber xgetThemeTint() {
    synchronized (monitor()) {
      check_orphaned();
      STUcharHexNumber sTUcharHexNumber = null;
      sTUcharHexNumber = (STUcharHexNumber)get_store().find_attribute_user(THEMETINT$4);
      return sTUcharHexNumber;
    } 
  }
  
  public boolean isSetThemeTint() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(THEMETINT$4) != null);
    } 
  }
  
  public void setThemeTint(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(THEMETINT$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(THEMETINT$4); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetThemeTint(STUcharHexNumber paramSTUcharHexNumber) {
    synchronized (monitor()) {
      check_orphaned();
      STUcharHexNumber sTUcharHexNumber = null;
      sTUcharHexNumber = (STUcharHexNumber)get_store().find_attribute_user(THEMETINT$4);
      if (sTUcharHexNumber == null)
        sTUcharHexNumber = (STUcharHexNumber)get_store().add_attribute_user(THEMETINT$4); 
      sTUcharHexNumber.set((XmlObject)paramSTUcharHexNumber);
    } 
  }
  
  public void unsetThemeTint() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(THEMETINT$4);
    } 
  }
  
  public byte[] getThemeShade() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(THEMESHADE$6);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public STUcharHexNumber xgetThemeShade() {
    synchronized (monitor()) {
      check_orphaned();
      STUcharHexNumber sTUcharHexNumber = null;
      sTUcharHexNumber = (STUcharHexNumber)get_store().find_attribute_user(THEMESHADE$6);
      return sTUcharHexNumber;
    } 
  }
  
  public boolean isSetThemeShade() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(THEMESHADE$6) != null);
    } 
  }
  
  public void setThemeShade(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(THEMESHADE$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(THEMESHADE$6); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetThemeShade(STUcharHexNumber paramSTUcharHexNumber) {
    synchronized (monitor()) {
      check_orphaned();
      STUcharHexNumber sTUcharHexNumber = null;
      sTUcharHexNumber = (STUcharHexNumber)get_store().find_attribute_user(THEMESHADE$6);
      if (sTUcharHexNumber == null)
        sTUcharHexNumber = (STUcharHexNumber)get_store().add_attribute_user(THEMESHADE$6); 
      sTUcharHexNumber.set((XmlObject)paramSTUcharHexNumber);
    } 
  }
  
  public void unsetThemeShade() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(THEMESHADE$6);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTColorImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */