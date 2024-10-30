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
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetFormatPr;

public class CTSheetFormatPrImpl extends XmlComplexContentImpl implements CTSheetFormatPr {
  private static final b BASECOLWIDTH$0 = new b("", "baseColWidth");
  
  private static final b DEFAULTCOLWIDTH$2 = new b("", "defaultColWidth");
  
  private static final b DEFAULTROWHEIGHT$4 = new b("", "defaultRowHeight");
  
  private static final b CUSTOMHEIGHT$6 = new b("", "customHeight");
  
  private static final b ZEROHEIGHT$8 = new b("", "zeroHeight");
  
  private static final b THICKTOP$10 = new b("", "thickTop");
  
  private static final b THICKBOTTOM$12 = new b("", "thickBottom");
  
  private static final b OUTLINELEVELROW$14 = new b("", "outlineLevelRow");
  
  private static final b OUTLINELEVELCOL$16 = new b("", "outlineLevelCol");
  
  public CTSheetFormatPrImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public long getBaseColWidth() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BASECOLWIDTH$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(BASECOLWIDTH$0); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetBaseColWidth() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(BASECOLWIDTH$0);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(BASECOLWIDTH$0); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetBaseColWidth() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BASECOLWIDTH$0) != null);
    } 
  }
  
  public void setBaseColWidth(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BASECOLWIDTH$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BASECOLWIDTH$0); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetBaseColWidth(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(BASECOLWIDTH$0);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(BASECOLWIDTH$0); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetBaseColWidth() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BASECOLWIDTH$0);
    } 
  }
  
  public double getDefaultColWidth() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEFAULTCOLWIDTH$2);
      if (simpleValue == null)
        return 0.0D; 
      return simpleValue.getDoubleValue();
    } 
  }
  
  public XmlDouble xgetDefaultColWidth() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(DEFAULTCOLWIDTH$2);
      return xmlDouble;
    } 
  }
  
  public boolean isSetDefaultColWidth() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DEFAULTCOLWIDTH$2) != null);
    } 
  }
  
  public void setDefaultColWidth(double paramDouble) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEFAULTCOLWIDTH$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DEFAULTCOLWIDTH$2); 
      simpleValue.setDoubleValue(paramDouble);
    } 
  }
  
  public void xsetDefaultColWidth(XmlDouble paramXmlDouble) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(DEFAULTCOLWIDTH$2);
      if (xmlDouble == null)
        xmlDouble = (XmlDouble)get_store().add_attribute_user(DEFAULTCOLWIDTH$2); 
      xmlDouble.set((XmlObject)paramXmlDouble);
    } 
  }
  
  public void unsetDefaultColWidth() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DEFAULTCOLWIDTH$2);
    } 
  }
  
  public double getDefaultRowHeight() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEFAULTROWHEIGHT$4);
      if (simpleValue == null)
        return 0.0D; 
      return simpleValue.getDoubleValue();
    } 
  }
  
  public XmlDouble xgetDefaultRowHeight() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(DEFAULTROWHEIGHT$4);
      return xmlDouble;
    } 
  }
  
  public void setDefaultRowHeight(double paramDouble) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEFAULTROWHEIGHT$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DEFAULTROWHEIGHT$4); 
      simpleValue.setDoubleValue(paramDouble);
    } 
  }
  
  public void xsetDefaultRowHeight(XmlDouble paramXmlDouble) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(DEFAULTROWHEIGHT$4);
      if (xmlDouble == null)
        xmlDouble = (XmlDouble)get_store().add_attribute_user(DEFAULTROWHEIGHT$4); 
      xmlDouble.set((XmlObject)paramXmlDouble);
    } 
  }
  
  public boolean getCustomHeight() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CUSTOMHEIGHT$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(CUSTOMHEIGHT$6); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetCustomHeight() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(CUSTOMHEIGHT$6);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(CUSTOMHEIGHT$6); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetCustomHeight() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CUSTOMHEIGHT$6) != null);
    } 
  }
  
  public void setCustomHeight(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CUSTOMHEIGHT$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CUSTOMHEIGHT$6); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetCustomHeight(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(CUSTOMHEIGHT$6);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(CUSTOMHEIGHT$6); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetCustomHeight() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CUSTOMHEIGHT$6);
    } 
  }
  
  public boolean getZeroHeight() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ZEROHEIGHT$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ZEROHEIGHT$8); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetZeroHeight() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ZEROHEIGHT$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(ZEROHEIGHT$8); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetZeroHeight() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ZEROHEIGHT$8) != null);
    } 
  }
  
  public void setZeroHeight(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ZEROHEIGHT$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ZEROHEIGHT$8); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetZeroHeight(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ZEROHEIGHT$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(ZEROHEIGHT$8); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetZeroHeight() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ZEROHEIGHT$8);
    } 
  }
  
  public boolean getThickTop() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(THICKTOP$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(THICKTOP$10); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetThickTop() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(THICKTOP$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(THICKTOP$10); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetThickTop() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(THICKTOP$10) != null);
    } 
  }
  
  public void setThickTop(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(THICKTOP$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(THICKTOP$10); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetThickTop(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(THICKTOP$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(THICKTOP$10); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetThickTop() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(THICKTOP$10);
    } 
  }
  
  public boolean getThickBottom() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(THICKBOTTOM$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(THICKBOTTOM$12); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetThickBottom() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(THICKBOTTOM$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(THICKBOTTOM$12); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetThickBottom() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(THICKBOTTOM$12) != null);
    } 
  }
  
  public void setThickBottom(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(THICKBOTTOM$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(THICKBOTTOM$12); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetThickBottom(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(THICKBOTTOM$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(THICKBOTTOM$12); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetThickBottom() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(THICKBOTTOM$12);
    } 
  }
  
  public short getOutlineLevelRow() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OUTLINELEVELROW$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(OUTLINELEVELROW$14); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getShortValue();
    } 
  }
  
  public XmlUnsignedByte xgetOutlineLevelRow() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedByte xmlUnsignedByte = null;
      xmlUnsignedByte = (XmlUnsignedByte)get_store().find_attribute_user(OUTLINELEVELROW$14);
      if (xmlUnsignedByte == null)
        xmlUnsignedByte = (XmlUnsignedByte)get_default_attribute_value(OUTLINELEVELROW$14); 
      return xmlUnsignedByte;
    } 
  }
  
  public boolean isSetOutlineLevelRow() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(OUTLINELEVELROW$14) != null);
    } 
  }
  
  public void setOutlineLevelRow(short paramShort) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OUTLINELEVELROW$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(OUTLINELEVELROW$14); 
      simpleValue.setShortValue(paramShort);
    } 
  }
  
  public void xsetOutlineLevelRow(XmlUnsignedByte paramXmlUnsignedByte) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedByte xmlUnsignedByte = null;
      xmlUnsignedByte = (XmlUnsignedByte)get_store().find_attribute_user(OUTLINELEVELROW$14);
      if (xmlUnsignedByte == null)
        xmlUnsignedByte = (XmlUnsignedByte)get_store().add_attribute_user(OUTLINELEVELROW$14); 
      xmlUnsignedByte.set((XmlObject)paramXmlUnsignedByte);
    } 
  }
  
  public void unsetOutlineLevelRow() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(OUTLINELEVELROW$14);
    } 
  }
  
  public short getOutlineLevelCol() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OUTLINELEVELCOL$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(OUTLINELEVELCOL$16); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getShortValue();
    } 
  }
  
  public XmlUnsignedByte xgetOutlineLevelCol() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedByte xmlUnsignedByte = null;
      xmlUnsignedByte = (XmlUnsignedByte)get_store().find_attribute_user(OUTLINELEVELCOL$16);
      if (xmlUnsignedByte == null)
        xmlUnsignedByte = (XmlUnsignedByte)get_default_attribute_value(OUTLINELEVELCOL$16); 
      return xmlUnsignedByte;
    } 
  }
  
  public boolean isSetOutlineLevelCol() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(OUTLINELEVELCOL$16) != null);
    } 
  }
  
  public void setOutlineLevelCol(short paramShort) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OUTLINELEVELCOL$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(OUTLINELEVELCOL$16); 
      simpleValue.setShortValue(paramShort);
    } 
  }
  
  public void xsetOutlineLevelCol(XmlUnsignedByte paramXmlUnsignedByte) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedByte xmlUnsignedByte = null;
      xmlUnsignedByte = (XmlUnsignedByte)get_store().find_attribute_user(OUTLINELEVELCOL$16);
      if (xmlUnsignedByte == null)
        xmlUnsignedByte = (XmlUnsignedByte)get_store().add_attribute_user(OUTLINELEVELCOL$16); 
      xmlUnsignedByte.set((XmlObject)paramXmlUnsignedByte);
    } 
  }
  
  public void unsetOutlineLevelCol() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(OUTLINELEVELCOL$16);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTSheetFormatPrImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */