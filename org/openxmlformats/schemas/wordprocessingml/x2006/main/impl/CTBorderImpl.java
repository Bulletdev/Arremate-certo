package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.math.BigInteger;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STEighthPointMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHexColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STPointMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STThemeColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STUcharHexNumber;

public class CTBorderImpl extends XmlComplexContentImpl implements CTBorder {
  private static final b VAL$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val");
  
  private static final b COLOR$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "color");
  
  private static final b THEMECOLOR$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "themeColor");
  
  private static final b THEMETINT$6 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "themeTint");
  
  private static final b THEMESHADE$8 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "themeShade");
  
  private static final b SZ$10 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sz");
  
  private static final b SPACE$12 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "space");
  
  private static final b SHADOW$14 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "shadow");
  
  private static final b FRAME$16 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "frame");
  
  public CTBorderImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STBorder.Enum getVal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        return null; 
      return (STBorder.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STBorder xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STBorder sTBorder = null;
      sTBorder = (STBorder)get_store().find_attribute_user(VAL$0);
      return sTBorder;
    } 
  }
  
  public void setVal(STBorder.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VAL$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetVal(STBorder paramSTBorder) {
    synchronized (monitor()) {
      check_orphaned();
      STBorder sTBorder = null;
      sTBorder = (STBorder)get_store().find_attribute_user(VAL$0);
      if (sTBorder == null)
        sTBorder = (STBorder)get_store().add_attribute_user(VAL$0); 
      sTBorder.set((XmlObject)paramSTBorder);
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
  
  public BigInteger getSz() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SZ$10);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public STEighthPointMeasure xgetSz() {
    synchronized (monitor()) {
      check_orphaned();
      STEighthPointMeasure sTEighthPointMeasure = null;
      sTEighthPointMeasure = (STEighthPointMeasure)get_store().find_attribute_user(SZ$10);
      return sTEighthPointMeasure;
    } 
  }
  
  public boolean isSetSz() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SZ$10) != null);
    } 
  }
  
  public void setSz(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SZ$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SZ$10); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetSz(STEighthPointMeasure paramSTEighthPointMeasure) {
    synchronized (monitor()) {
      check_orphaned();
      STEighthPointMeasure sTEighthPointMeasure = null;
      sTEighthPointMeasure = (STEighthPointMeasure)get_store().find_attribute_user(SZ$10);
      if (sTEighthPointMeasure == null)
        sTEighthPointMeasure = (STEighthPointMeasure)get_store().add_attribute_user(SZ$10); 
      sTEighthPointMeasure.set((XmlObject)paramSTEighthPointMeasure);
    } 
  }
  
  public void unsetSz() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SZ$10);
    } 
  }
  
  public BigInteger getSpace() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SPACE$12);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public STPointMeasure xgetSpace() {
    synchronized (monitor()) {
      check_orphaned();
      STPointMeasure sTPointMeasure = null;
      sTPointMeasure = (STPointMeasure)get_store().find_attribute_user(SPACE$12);
      return sTPointMeasure;
    } 
  }
  
  public boolean isSetSpace() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SPACE$12) != null);
    } 
  }
  
  public void setSpace(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SPACE$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SPACE$12); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetSpace(STPointMeasure paramSTPointMeasure) {
    synchronized (monitor()) {
      check_orphaned();
      STPointMeasure sTPointMeasure = null;
      sTPointMeasure = (STPointMeasure)get_store().find_attribute_user(SPACE$12);
      if (sTPointMeasure == null)
        sTPointMeasure = (STPointMeasure)get_store().add_attribute_user(SPACE$12); 
      sTPointMeasure.set((XmlObject)paramSTPointMeasure);
    } 
  }
  
  public void unsetSpace() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SPACE$12);
    } 
  }
  
  public STOnOff.Enum getShadow() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHADOW$14);
      if (simpleValue == null)
        return null; 
      return (STOnOff.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STOnOff xgetShadow() {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(SHADOW$14);
      return sTOnOff;
    } 
  }
  
  public boolean isSetShadow() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHADOW$14) != null);
    } 
  }
  
  public void setShadow(STOnOff.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHADOW$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHADOW$14); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetShadow(STOnOff paramSTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(SHADOW$14);
      if (sTOnOff == null)
        sTOnOff = (STOnOff)get_store().add_attribute_user(SHADOW$14); 
      sTOnOff.set((XmlObject)paramSTOnOff);
    } 
  }
  
  public void unsetShadow() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHADOW$14);
    } 
  }
  
  public STOnOff.Enum getFrame() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FRAME$16);
      if (simpleValue == null)
        return null; 
      return (STOnOff.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STOnOff xgetFrame() {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(FRAME$16);
      return sTOnOff;
    } 
  }
  
  public boolean isSetFrame() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FRAME$16) != null);
    } 
  }
  
  public void setFrame(STOnOff.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FRAME$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FRAME$16); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetFrame(STOnOff paramSTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(FRAME$16);
      if (sTOnOff == null)
        sTOnOff = (STOnOff)get_store().add_attribute_user(FRAME$16); 
      sTOnOff.set((XmlObject)paramSTOnOff);
    } 
  }
  
  public void unsetFrame() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FRAME$16);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTBorderImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */