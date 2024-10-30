package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPageSetup;
import org.openxmlformats.schemas.drawingml.x2006.chart.STPageSetupOrientation;

public class CTPageSetupImpl extends XmlComplexContentImpl implements CTPageSetup {
  private static final b PAPERSIZE$0 = new b("", "paperSize");
  
  private static final b FIRSTPAGENUMBER$2 = new b("", "firstPageNumber");
  
  private static final b ORIENTATION$4 = new b("", "orientation");
  
  private static final b BLACKANDWHITE$6 = new b("", "blackAndWhite");
  
  private static final b DRAFT$8 = new b("", "draft");
  
  private static final b USEFIRSTPAGENUMBER$10 = new b("", "useFirstPageNumber");
  
  private static final b HORIZONTALDPI$12 = new b("", "horizontalDpi");
  
  private static final b VERTICALDPI$14 = new b("", "verticalDpi");
  
  private static final b COPIES$16 = new b("", "copies");
  
  public CTPageSetupImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public long getPaperSize() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PAPERSIZE$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(PAPERSIZE$0); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetPaperSize() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(PAPERSIZE$0);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(PAPERSIZE$0); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetPaperSize() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PAPERSIZE$0) != null);
    } 
  }
  
  public void setPaperSize(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PAPERSIZE$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PAPERSIZE$0); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetPaperSize(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(PAPERSIZE$0);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(PAPERSIZE$0); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetPaperSize() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PAPERSIZE$0);
    } 
  }
  
  public long getFirstPageNumber() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FIRSTPAGENUMBER$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(FIRSTPAGENUMBER$2); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetFirstPageNumber() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(FIRSTPAGENUMBER$2);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(FIRSTPAGENUMBER$2); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetFirstPageNumber() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FIRSTPAGENUMBER$2) != null);
    } 
  }
  
  public void setFirstPageNumber(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FIRSTPAGENUMBER$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FIRSTPAGENUMBER$2); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetFirstPageNumber(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(FIRSTPAGENUMBER$2);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(FIRSTPAGENUMBER$2); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetFirstPageNumber() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FIRSTPAGENUMBER$2);
    } 
  }
  
  public STPageSetupOrientation.Enum getOrientation() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ORIENTATION$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ORIENTATION$4); 
      if (simpleValue == null)
        return null; 
      return (STPageSetupOrientation.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STPageSetupOrientation xgetOrientation() {
    synchronized (monitor()) {
      check_orphaned();
      STPageSetupOrientation sTPageSetupOrientation = null;
      sTPageSetupOrientation = (STPageSetupOrientation)get_store().find_attribute_user(ORIENTATION$4);
      if (sTPageSetupOrientation == null)
        sTPageSetupOrientation = (STPageSetupOrientation)get_default_attribute_value(ORIENTATION$4); 
      return sTPageSetupOrientation;
    } 
  }
  
  public boolean isSetOrientation() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ORIENTATION$4) != null);
    } 
  }
  
  public void setOrientation(STPageSetupOrientation.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ORIENTATION$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ORIENTATION$4); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetOrientation(STPageSetupOrientation paramSTPageSetupOrientation) {
    synchronized (monitor()) {
      check_orphaned();
      STPageSetupOrientation sTPageSetupOrientation = null;
      sTPageSetupOrientation = (STPageSetupOrientation)get_store().find_attribute_user(ORIENTATION$4);
      if (sTPageSetupOrientation == null)
        sTPageSetupOrientation = (STPageSetupOrientation)get_store().add_attribute_user(ORIENTATION$4); 
      sTPageSetupOrientation.set((XmlObject)paramSTPageSetupOrientation);
    } 
  }
  
  public void unsetOrientation() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ORIENTATION$4);
    } 
  }
  
  public boolean getBlackAndWhite() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BLACKANDWHITE$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(BLACKANDWHITE$6); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetBlackAndWhite() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(BLACKANDWHITE$6);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(BLACKANDWHITE$6); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetBlackAndWhite() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BLACKANDWHITE$6) != null);
    } 
  }
  
  public void setBlackAndWhite(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BLACKANDWHITE$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BLACKANDWHITE$6); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetBlackAndWhite(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(BLACKANDWHITE$6);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(BLACKANDWHITE$6); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetBlackAndWhite() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BLACKANDWHITE$6);
    } 
  }
  
  public boolean getDraft() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DRAFT$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(DRAFT$8); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetDraft() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DRAFT$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(DRAFT$8); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetDraft() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DRAFT$8) != null);
    } 
  }
  
  public void setDraft(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DRAFT$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DRAFT$8); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetDraft(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DRAFT$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(DRAFT$8); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetDraft() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DRAFT$8);
    } 
  }
  
  public boolean getUseFirstPageNumber() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(USEFIRSTPAGENUMBER$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(USEFIRSTPAGENUMBER$10); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetUseFirstPageNumber() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(USEFIRSTPAGENUMBER$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(USEFIRSTPAGENUMBER$10); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetUseFirstPageNumber() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(USEFIRSTPAGENUMBER$10) != null);
    } 
  }
  
  public void setUseFirstPageNumber(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(USEFIRSTPAGENUMBER$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(USEFIRSTPAGENUMBER$10); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetUseFirstPageNumber(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(USEFIRSTPAGENUMBER$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(USEFIRSTPAGENUMBER$10); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetUseFirstPageNumber() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(USEFIRSTPAGENUMBER$10);
    } 
  }
  
  public int getHorizontalDpi() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HORIZONTALDPI$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(HORIZONTALDPI$12); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public XmlInt xgetHorizontalDpi() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_attribute_user(HORIZONTALDPI$12);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_default_attribute_value(HORIZONTALDPI$12); 
      return xmlInt;
    } 
  }
  
  public boolean isSetHorizontalDpi() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HORIZONTALDPI$12) != null);
    } 
  }
  
  public void setHorizontalDpi(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HORIZONTALDPI$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HORIZONTALDPI$12); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetHorizontalDpi(XmlInt paramXmlInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_attribute_user(HORIZONTALDPI$12);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_store().add_attribute_user(HORIZONTALDPI$12); 
      xmlInt.set((XmlObject)paramXmlInt);
    } 
  }
  
  public void unsetHorizontalDpi() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HORIZONTALDPI$12);
    } 
  }
  
  public int getVerticalDpi() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VERTICALDPI$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(VERTICALDPI$14); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public XmlInt xgetVerticalDpi() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_attribute_user(VERTICALDPI$14);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_default_attribute_value(VERTICALDPI$14); 
      return xmlInt;
    } 
  }
  
  public boolean isSetVerticalDpi() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(VERTICALDPI$14) != null);
    } 
  }
  
  public void setVerticalDpi(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VERTICALDPI$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VERTICALDPI$14); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetVerticalDpi(XmlInt paramXmlInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_attribute_user(VERTICALDPI$14);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_store().add_attribute_user(VERTICALDPI$14); 
      xmlInt.set((XmlObject)paramXmlInt);
    } 
  }
  
  public void unsetVerticalDpi() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(VERTICALDPI$14);
    } 
  }
  
  public long getCopies() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COPIES$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(COPIES$16); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetCopies() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(COPIES$16);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(COPIES$16); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetCopies() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(COPIES$16) != null);
    } 
  }
  
  public void setCopies(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COPIES$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(COPIES$16); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetCopies(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(COPIES$16);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(COPIES$16); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetCopies() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(COPIES$16);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTPageSetupImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */