package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlByte;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont;
import org.openxmlformats.schemas.drawingml.x2006.main.STPanose;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextTypeface;

public class CTTextFontImpl extends XmlComplexContentImpl implements CTTextFont {
  private static final b TYPEFACE$0 = new b("", "typeface");
  
  private static final b PANOSE$2 = new b("", "panose");
  
  private static final b PITCHFAMILY$4 = new b("", "pitchFamily");
  
  private static final b CHARSET$6 = new b("", "charset");
  
  public CTTextFontImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public String getTypeface() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPEFACE$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STTextTypeface xgetTypeface() {
    synchronized (monitor()) {
      check_orphaned();
      STTextTypeface sTTextTypeface = null;
      sTTextTypeface = (STTextTypeface)get_store().find_attribute_user(TYPEFACE$0);
      return sTTextTypeface;
    } 
  }
  
  public boolean isSetTypeface() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TYPEFACE$0) != null);
    } 
  }
  
  public void setTypeface(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPEFACE$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TYPEFACE$0); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetTypeface(STTextTypeface paramSTTextTypeface) {
    synchronized (monitor()) {
      check_orphaned();
      STTextTypeface sTTextTypeface = null;
      sTTextTypeface = (STTextTypeface)get_store().find_attribute_user(TYPEFACE$0);
      if (sTTextTypeface == null)
        sTTextTypeface = (STTextTypeface)get_store().add_attribute_user(TYPEFACE$0); 
      sTTextTypeface.set((XmlObject)paramSTTextTypeface);
    } 
  }
  
  public void unsetTypeface() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TYPEFACE$0);
    } 
  }
  
  public byte[] getPanose() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PANOSE$2);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public STPanose xgetPanose() {
    synchronized (monitor()) {
      check_orphaned();
      STPanose sTPanose = null;
      sTPanose = (STPanose)get_store().find_attribute_user(PANOSE$2);
      return sTPanose;
    } 
  }
  
  public boolean isSetPanose() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PANOSE$2) != null);
    } 
  }
  
  public void setPanose(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PANOSE$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PANOSE$2); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetPanose(STPanose paramSTPanose) {
    synchronized (monitor()) {
      check_orphaned();
      STPanose sTPanose = null;
      sTPanose = (STPanose)get_store().find_attribute_user(PANOSE$2);
      if (sTPanose == null)
        sTPanose = (STPanose)get_store().add_attribute_user(PANOSE$2); 
      sTPanose.set((XmlObject)paramSTPanose);
    } 
  }
  
  public void unsetPanose() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PANOSE$2);
    } 
  }
  
  public byte getPitchFamily() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PITCHFAMILY$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(PITCHFAMILY$4); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getByteValue();
    } 
  }
  
  public XmlByte xgetPitchFamily() {
    synchronized (monitor()) {
      check_orphaned();
      XmlByte xmlByte = null;
      xmlByte = (XmlByte)get_store().find_attribute_user(PITCHFAMILY$4);
      if (xmlByte == null)
        xmlByte = (XmlByte)get_default_attribute_value(PITCHFAMILY$4); 
      return xmlByte;
    } 
  }
  
  public boolean isSetPitchFamily() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PITCHFAMILY$4) != null);
    } 
  }
  
  public void setPitchFamily(byte paramByte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PITCHFAMILY$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PITCHFAMILY$4); 
      simpleValue.setByteValue(paramByte);
    } 
  }
  
  public void xsetPitchFamily(XmlByte paramXmlByte) {
    synchronized (monitor()) {
      check_orphaned();
      XmlByte xmlByte = null;
      xmlByte = (XmlByte)get_store().find_attribute_user(PITCHFAMILY$4);
      if (xmlByte == null)
        xmlByte = (XmlByte)get_store().add_attribute_user(PITCHFAMILY$4); 
      xmlByte.set((XmlObject)paramXmlByte);
    } 
  }
  
  public void unsetPitchFamily() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PITCHFAMILY$4);
    } 
  }
  
  public byte getCharset() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CHARSET$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(CHARSET$6); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getByteValue();
    } 
  }
  
  public XmlByte xgetCharset() {
    synchronized (monitor()) {
      check_orphaned();
      XmlByte xmlByte = null;
      xmlByte = (XmlByte)get_store().find_attribute_user(CHARSET$6);
      if (xmlByte == null)
        xmlByte = (XmlByte)get_default_attribute_value(CHARSET$6); 
      return xmlByte;
    } 
  }
  
  public boolean isSetCharset() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CHARSET$6) != null);
    } 
  }
  
  public void setCharset(byte paramByte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CHARSET$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CHARSET$6); 
      simpleValue.setByteValue(paramByte);
    } 
  }
  
  public void xsetCharset(XmlByte paramXmlByte) {
    synchronized (monitor()) {
      check_orphaned();
      XmlByte xmlByte = null;
      xmlByte = (XmlByte)get_store().find_attribute_user(CHARSET$6);
      if (xmlByte == null)
        xmlByte = (XmlByte)get_store().add_attribute_user(CHARSET$6); 
      xmlByte.set((XmlObject)paramXmlByte);
    } 
  }
  
  public void unsetCharset() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CHARSET$6);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTTextFontImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */