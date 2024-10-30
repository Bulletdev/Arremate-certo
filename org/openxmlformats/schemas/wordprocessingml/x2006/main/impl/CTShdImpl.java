package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHexColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STThemeColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STUcharHexNumber;

public class CTShdImpl extends XmlComplexContentImpl implements CTShd {
  private static final b VAL$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val");
  
  private static final b COLOR$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "color");
  
  private static final b THEMECOLOR$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "themeColor");
  
  private static final b THEMETINT$6 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "themeTint");
  
  private static final b THEMESHADE$8 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "themeShade");
  
  private static final b FILL$10 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "fill");
  
  private static final b THEMEFILL$12 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "themeFill");
  
  private static final b THEMEFILLTINT$14 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "themeFillTint");
  
  private static final b THEMEFILLSHADE$16 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "themeFillShade");
  
  public CTShdImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STShd.Enum getVal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        return null; 
      return (STShd.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STShd xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STShd sTShd = null;
      sTShd = (STShd)get_store().find_attribute_user(VAL$0);
      return sTShd;
    } 
  }
  
  public void setVal(STShd.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VAL$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetVal(STShd paramSTShd) {
    synchronized (monitor()) {
      check_orphaned();
      STShd sTShd = null;
      sTShd = (STShd)get_store().find_attribute_user(VAL$0);
      if (sTShd == null)
        sTShd = (STShd)get_store().add_attribute_user(VAL$0); 
      sTShd.set((XmlObject)paramSTShd);
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
  
  public Object getFill() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FILL$10);
      if (simpleValue == null)
        return null; 
      return simpleValue.getObjectValue();
    } 
  }
  
  public STHexColor xgetFill() {
    synchronized (monitor()) {
      check_orphaned();
      STHexColor sTHexColor = null;
      sTHexColor = (STHexColor)get_store().find_attribute_user(FILL$10);
      return sTHexColor;
    } 
  }
  
  public boolean isSetFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FILL$10) != null);
    } 
  }
  
  public void setFill(Object paramObject) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FILL$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FILL$10); 
      simpleValue.setObjectValue(paramObject);
    } 
  }
  
  public void xsetFill(STHexColor paramSTHexColor) {
    synchronized (monitor()) {
      check_orphaned();
      STHexColor sTHexColor = null;
      sTHexColor = (STHexColor)get_store().find_attribute_user(FILL$10);
      if (sTHexColor == null)
        sTHexColor = (STHexColor)get_store().add_attribute_user(FILL$10); 
      sTHexColor.set((XmlObject)paramSTHexColor);
    } 
  }
  
  public void unsetFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FILL$10);
    } 
  }
  
  public STThemeColor.Enum getThemeFill() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(THEMEFILL$12);
      if (simpleValue == null)
        return null; 
      return (STThemeColor.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STThemeColor xgetThemeFill() {
    synchronized (monitor()) {
      check_orphaned();
      STThemeColor sTThemeColor = null;
      sTThemeColor = (STThemeColor)get_store().find_attribute_user(THEMEFILL$12);
      return sTThemeColor;
    } 
  }
  
  public boolean isSetThemeFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(THEMEFILL$12) != null);
    } 
  }
  
  public void setThemeFill(STThemeColor.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(THEMEFILL$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(THEMEFILL$12); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetThemeFill(STThemeColor paramSTThemeColor) {
    synchronized (monitor()) {
      check_orphaned();
      STThemeColor sTThemeColor = null;
      sTThemeColor = (STThemeColor)get_store().find_attribute_user(THEMEFILL$12);
      if (sTThemeColor == null)
        sTThemeColor = (STThemeColor)get_store().add_attribute_user(THEMEFILL$12); 
      sTThemeColor.set((XmlObject)paramSTThemeColor);
    } 
  }
  
  public void unsetThemeFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(THEMEFILL$12);
    } 
  }
  
  public byte[] getThemeFillTint() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(THEMEFILLTINT$14);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public STUcharHexNumber xgetThemeFillTint() {
    synchronized (monitor()) {
      check_orphaned();
      STUcharHexNumber sTUcharHexNumber = null;
      sTUcharHexNumber = (STUcharHexNumber)get_store().find_attribute_user(THEMEFILLTINT$14);
      return sTUcharHexNumber;
    } 
  }
  
  public boolean isSetThemeFillTint() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(THEMEFILLTINT$14) != null);
    } 
  }
  
  public void setThemeFillTint(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(THEMEFILLTINT$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(THEMEFILLTINT$14); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetThemeFillTint(STUcharHexNumber paramSTUcharHexNumber) {
    synchronized (monitor()) {
      check_orphaned();
      STUcharHexNumber sTUcharHexNumber = null;
      sTUcharHexNumber = (STUcharHexNumber)get_store().find_attribute_user(THEMEFILLTINT$14);
      if (sTUcharHexNumber == null)
        sTUcharHexNumber = (STUcharHexNumber)get_store().add_attribute_user(THEMEFILLTINT$14); 
      sTUcharHexNumber.set((XmlObject)paramSTUcharHexNumber);
    } 
  }
  
  public void unsetThemeFillTint() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(THEMEFILLTINT$14);
    } 
  }
  
  public byte[] getThemeFillShade() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(THEMEFILLSHADE$16);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public STUcharHexNumber xgetThemeFillShade() {
    synchronized (monitor()) {
      check_orphaned();
      STUcharHexNumber sTUcharHexNumber = null;
      sTUcharHexNumber = (STUcharHexNumber)get_store().find_attribute_user(THEMEFILLSHADE$16);
      return sTUcharHexNumber;
    } 
  }
  
  public boolean isSetThemeFillShade() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(THEMEFILLSHADE$16) != null);
    } 
  }
  
  public void setThemeFillShade(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(THEMEFILLSHADE$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(THEMEFILLSHADE$16); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetThemeFillShade(STUcharHexNumber paramSTUcharHexNumber) {
    synchronized (monitor()) {
      check_orphaned();
      STUcharHexNumber sTUcharHexNumber = null;
      sTUcharHexNumber = (STUcharHexNumber)get_store().find_attribute_user(THEMEFILLSHADE$16);
      if (sTUcharHexNumber == null)
        sTUcharHexNumber = (STUcharHexNumber)get_store().add_attribute_user(THEMEFILLSHADE$16); 
      sTUcharHexNumber.set((XmlObject)paramSTUcharHexNumber);
    } 
  }
  
  public void unsetThemeFillShade() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(THEMEFILLSHADE$16);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTShdImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */