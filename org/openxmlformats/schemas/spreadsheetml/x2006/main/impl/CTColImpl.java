package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedByte;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCol;

public class CTColImpl extends XmlComplexContentImpl implements CTCol {
  private static final b MIN$0 = new b("", "min");
  
  private static final b MAX$2 = new b("", "max");
  
  private static final b WIDTH$4 = new b("", "width");
  
  private static final b STYLE$6 = new b("", "style");
  
  private static final b HIDDEN$8 = new b("", "hidden");
  
  private static final b BESTFIT$10 = new b("", "bestFit");
  
  private static final b CUSTOMWIDTH$12 = new b("", "customWidth");
  
  private static final b PHONETIC$14 = new b("", "phonetic");
  
  private static final b OUTLINELEVEL$16 = new b("", "outlineLevel");
  
  private static final b COLLAPSED$18 = new b("", "collapsed");
  
  public CTColImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public long getMin() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MIN$0);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetMin() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(MIN$0);
      return xmlUnsignedInt;
    } 
  }
  
  public void setMin(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MIN$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MIN$0); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetMin(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(MIN$0);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(MIN$0); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public long getMax() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MAX$2);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetMax() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(MAX$2);
      return xmlUnsignedInt;
    } 
  }
  
  public void setMax(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MAX$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MAX$2); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetMax(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(MAX$2);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(MAX$2); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public double getWidth() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(WIDTH$4);
      if (simpleValue == null)
        return 0.0D; 
      return simpleValue.getDoubleValue();
    } 
  }
  
  public XmlDouble xgetWidth() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(WIDTH$4);
      return xmlDouble;
    } 
  }
  
  public boolean isSetWidth() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(WIDTH$4) != null);
    } 
  }
  
  public void setWidth(double paramDouble) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(WIDTH$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(WIDTH$4); 
      simpleValue.setDoubleValue(paramDouble);
    } 
  }
  
  public void xsetWidth(XmlDouble paramXmlDouble) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(WIDTH$4);
      if (xmlDouble == null)
        xmlDouble = (XmlDouble)get_store().add_attribute_user(WIDTH$4); 
      xmlDouble.set((XmlObject)paramXmlDouble);
    } 
  }
  
  public void unsetWidth() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(WIDTH$4);
    } 
  }
  
  public long getStyle() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STYLE$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(STYLE$6); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetStyle() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(STYLE$6);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(STYLE$6); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(STYLE$6) != null);
    } 
  }
  
  public void setStyle(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STYLE$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(STYLE$6); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetStyle(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(STYLE$6);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(STYLE$6); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(STYLE$6);
    } 
  }
  
  public boolean getHidden() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HIDDEN$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(HIDDEN$8); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetHidden() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(HIDDEN$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(HIDDEN$8); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetHidden() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HIDDEN$8) != null);
    } 
  }
  
  public void setHidden(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HIDDEN$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HIDDEN$8); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetHidden(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(HIDDEN$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(HIDDEN$8); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetHidden() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HIDDEN$8);
    } 
  }
  
  public boolean getBestFit() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BESTFIT$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(BESTFIT$10); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetBestFit() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(BESTFIT$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(BESTFIT$10); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetBestFit() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BESTFIT$10) != null);
    } 
  }
  
  public void setBestFit(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BESTFIT$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BESTFIT$10); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetBestFit(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(BESTFIT$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(BESTFIT$10); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetBestFit() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BESTFIT$10);
    } 
  }
  
  public boolean getCustomWidth() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CUSTOMWIDTH$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(CUSTOMWIDTH$12); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetCustomWidth() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(CUSTOMWIDTH$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(CUSTOMWIDTH$12); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetCustomWidth() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CUSTOMWIDTH$12) != null);
    } 
  }
  
  public void setCustomWidth(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CUSTOMWIDTH$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CUSTOMWIDTH$12); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetCustomWidth(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(CUSTOMWIDTH$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(CUSTOMWIDTH$12); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetCustomWidth() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CUSTOMWIDTH$12);
    } 
  }
  
  public boolean getPhonetic() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PHONETIC$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(PHONETIC$14); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetPhonetic() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PHONETIC$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(PHONETIC$14); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetPhonetic() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PHONETIC$14) != null);
    } 
  }
  
  public void setPhonetic(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PHONETIC$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PHONETIC$14); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetPhonetic(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PHONETIC$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(PHONETIC$14); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetPhonetic() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PHONETIC$14);
    } 
  }
  
  public short getOutlineLevel() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OUTLINELEVEL$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(OUTLINELEVEL$16); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getShortValue();
    } 
  }
  
  public XmlUnsignedByte xgetOutlineLevel() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedByte xmlUnsignedByte = null;
      xmlUnsignedByte = (XmlUnsignedByte)get_store().find_attribute_user(OUTLINELEVEL$16);
      if (xmlUnsignedByte == null)
        xmlUnsignedByte = (XmlUnsignedByte)get_default_attribute_value(OUTLINELEVEL$16); 
      return xmlUnsignedByte;
    } 
  }
  
  public boolean isSetOutlineLevel() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(OUTLINELEVEL$16) != null);
    } 
  }
  
  public void setOutlineLevel(short paramShort) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OUTLINELEVEL$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(OUTLINELEVEL$16); 
      simpleValue.setShortValue(paramShort);
    } 
  }
  
  public void xsetOutlineLevel(XmlUnsignedByte paramXmlUnsignedByte) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedByte xmlUnsignedByte = null;
      xmlUnsignedByte = (XmlUnsignedByte)get_store().find_attribute_user(OUTLINELEVEL$16);
      if (xmlUnsignedByte == null)
        xmlUnsignedByte = (XmlUnsignedByte)get_store().add_attribute_user(OUTLINELEVEL$16); 
      xmlUnsignedByte.set((XmlObject)paramXmlUnsignedByte);
    } 
  }
  
  public void unsetOutlineLevel() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(OUTLINELEVEL$16);
    } 
  }
  
  public boolean getCollapsed() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COLLAPSED$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(COLLAPSED$18); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetCollapsed() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(COLLAPSED$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(COLLAPSED$18); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetCollapsed() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(COLLAPSED$18) != null);
    } 
  }
  
  public void setCollapsed(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COLLAPSED$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(COLLAPSED$18); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetCollapsed(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(COLLAPSED$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(COLLAPSED$18); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetCollapsed() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(COLLAPSED$18);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTColImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */