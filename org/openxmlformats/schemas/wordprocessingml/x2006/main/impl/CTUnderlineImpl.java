package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHexColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STThemeColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STUcharHexNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STUnderline;

public class CTUnderlineImpl extends XmlComplexContentImpl implements CTUnderline {
  private static final b VAL$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val");
  
  private static final b COLOR$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "color");
  
  private static final b THEMECOLOR$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "themeColor");
  
  private static final b THEMETINT$6 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "themeTint");
  
  private static final b THEMESHADE$8 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "themeShade");
  
  public CTUnderlineImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STUnderline.Enum getVal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        return null; 
      return (STUnderline.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STUnderline xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STUnderline sTUnderline = null;
      sTUnderline = (STUnderline)get_store().find_attribute_user(VAL$0);
      return sTUnderline;
    } 
  }
  
  public boolean isSetVal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(VAL$0) != null);
    } 
  }
  
  public void setVal(STUnderline.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VAL$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetVal(STUnderline paramSTUnderline) {
    synchronized (monitor()) {
      check_orphaned();
      STUnderline sTUnderline = null;
      sTUnderline = (STUnderline)get_store().find_attribute_user(VAL$0);
      if (sTUnderline == null)
        sTUnderline = (STUnderline)get_store().add_attribute_user(VAL$0); 
      sTUnderline.set((XmlObject)paramSTUnderline);
    } 
  }
  
  public void unsetVal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(VAL$0);
    } 
  }
  
  public Object getColor() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COLOR$2);
      if (simpleValue == null)
        return null; 
      return simpleValue.getObjectValue();
    } 
  }
  
  public STHexColor xgetColor() {
    synchronized (monitor()) {
      check_orphaned();
      STHexColor sTHexColor = null;
      sTHexColor = (STHexColor)get_store().find_attribute_user(COLOR$2);
      return sTHexColor;
    } 
  }
  
  public boolean isSetColor() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(COLOR$2) != null);
    } 
  }
  
  public void setColor(Object paramObject) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COLOR$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(COLOR$2); 
      simpleValue.setObjectValue(paramObject);
    } 
  }
  
  public void xsetColor(STHexColor paramSTHexColor) {
    synchronized (monitor()) {
      check_orphaned();
      STHexColor sTHexColor = null;
      sTHexColor = (STHexColor)get_store().find_attribute_user(COLOR$2);
      if (sTHexColor == null)
        sTHexColor = (STHexColor)get_store().add_attribute_user(COLOR$2); 
      sTHexColor.set((XmlObject)paramSTHexColor);
    } 
  }
  
  public void unsetColor() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(COLOR$2);
    } 
  }
  
  public STThemeColor.Enum getThemeColor() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(THEMECOLOR$4);
      if (simpleValue == null)
        return null; 
      return (STThemeColor.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STThemeColor xgetThemeColor() {
    synchronized (monitor()) {
      check_orphaned();
      STThemeColor sTThemeColor = null;
      sTThemeColor = (STThemeColor)get_store().find_attribute_user(THEMECOLOR$4);
      return sTThemeColor;
    } 
  }
  
  public boolean isSetThemeColor() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(THEMECOLOR$4) != null);
    } 
  }
  
  public void setThemeColor(STThemeColor.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(THEMECOLOR$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(THEMECOLOR$4); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetThemeColor(STThemeColor paramSTThemeColor) {
    synchronized (monitor()) {
      check_orphaned();
      STThemeColor sTThemeColor = null;
      sTThemeColor = (STThemeColor)get_store().find_attribute_user(THEMECOLOR$4);
      if (sTThemeColor == null)
        sTThemeColor = (STThemeColor)get_store().add_attribute_user(THEMECOLOR$4); 
      sTThemeColor.set((XmlObject)paramSTThemeColor);
    } 
  }
  
  public void unsetThemeColor() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(THEMECOLOR$4);
    } 
  }
  
  public byte[] getThemeTint() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(THEMETINT$6);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public STUcharHexNumber xgetThemeTint() {
    synchronized (monitor()) {
      check_orphaned();
      STUcharHexNumber sTUcharHexNumber = null;
      sTUcharHexNumber = (STUcharHexNumber)get_store().find_attribute_user(THEMETINT$6);
      return sTUcharHexNumber;
    } 
  }
  
  public boolean isSetThemeTint() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(THEMETINT$6) != null);
    } 
  }
  
  public void setThemeTint(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(THEMETINT$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(THEMETINT$6); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetThemeTint(STUcharHexNumber paramSTUcharHexNumber) {
    synchronized (monitor()) {
      check_orphaned();
      STUcharHexNumber sTUcharHexNumber = null;
      sTUcharHexNumber = (STUcharHexNumber)get_store().find_attribute_user(THEMETINT$6);
      if (sTUcharHexNumber == null)
        sTUcharHexNumber = (STUcharHexNumber)get_store().add_attribute_user(THEMETINT$6); 
      sTUcharHexNumber.set((XmlObject)paramSTUcharHexNumber);
    } 
  }
  
  public void unsetThemeTint() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(THEMETINT$6);
    } 
  }
  
  public byte[] getThemeShade() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(THEMESHADE$8);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public STUcharHexNumber xgetThemeShade() {
    synchronized (monitor()) {
      check_orphaned();
      STUcharHexNumber sTUcharHexNumber = null;
      sTUcharHexNumber = (STUcharHexNumber)get_store().find_attribute_user(THEMESHADE$8);
      return sTUcharHexNumber;
    } 
  }
  
  public boolean isSetThemeShade() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(THEMESHADE$8) != null);
    } 
  }
  
  public void setThemeShade(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(THEMESHADE$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(THEMESHADE$8); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetThemeShade(STUcharHexNumber paramSTUcharHexNumber) {
    synchronized (monitor()) {
      check_orphaned();
      STUcharHexNumber sTUcharHexNumber = null;
      sTUcharHexNumber = (STUcharHexNumber)get_store().find_attribute_user(THEMESHADE$8);
      if (sTUcharHexNumber == null)
        sTUcharHexNumber = (STUcharHexNumber)get_store().add_attribute_user(THEMESHADE$8); 
      sTUcharHexNumber.set((XmlObject)paramSTUcharHexNumber);
    } 
  }
  
  public void unsetThemeShade() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(THEMESHADE$8);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTUnderlineImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */