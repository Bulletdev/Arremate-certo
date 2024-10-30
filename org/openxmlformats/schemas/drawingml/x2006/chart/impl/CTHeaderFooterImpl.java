package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTHeaderFooter;
import org.openxmlformats.schemas.drawingml.x2006.chart.STXstring;

public class CTHeaderFooterImpl extends XmlComplexContentImpl implements CTHeaderFooter {
  private static final b ODDHEADER$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "oddHeader");
  
  private static final b ODDFOOTER$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "oddFooter");
  
  private static final b EVENHEADER$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "evenHeader");
  
  private static final b EVENFOOTER$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "evenFooter");
  
  private static final b FIRSTHEADER$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "firstHeader");
  
  private static final b FIRSTFOOTER$10 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "firstFooter");
  
  private static final b ALIGNWITHMARGINS$12 = new b("", "alignWithMargins");
  
  private static final b DIFFERENTODDEVEN$14 = new b("", "differentOddEven");
  
  private static final b DIFFERENTFIRST$16 = new b("", "differentFirst");
  
  public CTHeaderFooterImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public String getOddHeader() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(ODDHEADER$0, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetOddHeader() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_element_user(ODDHEADER$0, 0);
      return sTXstring;
    } 
  }
  
  public boolean isSetOddHeader() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ODDHEADER$0) != 0);
    } 
  }
  
  public void setOddHeader(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(ODDHEADER$0, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(ODDHEADER$0); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetOddHeader(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_element_user(ODDHEADER$0, 0);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_element_user(ODDHEADER$0); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetOddHeader() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ODDHEADER$0, 0);
    } 
  }
  
  public String getOddFooter() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(ODDFOOTER$2, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetOddFooter() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_element_user(ODDFOOTER$2, 0);
      return sTXstring;
    } 
  }
  
  public boolean isSetOddFooter() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ODDFOOTER$2) != 0);
    } 
  }
  
  public void setOddFooter(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(ODDFOOTER$2, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(ODDFOOTER$2); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetOddFooter(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_element_user(ODDFOOTER$2, 0);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_element_user(ODDFOOTER$2); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetOddFooter() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ODDFOOTER$2, 0);
    } 
  }
  
  public String getEvenHeader() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(EVENHEADER$4, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetEvenHeader() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_element_user(EVENHEADER$4, 0);
      return sTXstring;
    } 
  }
  
  public boolean isSetEvenHeader() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EVENHEADER$4) != 0);
    } 
  }
  
  public void setEvenHeader(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(EVENHEADER$4, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(EVENHEADER$4); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetEvenHeader(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_element_user(EVENHEADER$4, 0);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_element_user(EVENHEADER$4); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetEvenHeader() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EVENHEADER$4, 0);
    } 
  }
  
  public String getEvenFooter() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(EVENFOOTER$6, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetEvenFooter() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_element_user(EVENFOOTER$6, 0);
      return sTXstring;
    } 
  }
  
  public boolean isSetEvenFooter() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EVENFOOTER$6) != 0);
    } 
  }
  
  public void setEvenFooter(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(EVENFOOTER$6, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(EVENFOOTER$6); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetEvenFooter(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_element_user(EVENFOOTER$6, 0);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_element_user(EVENFOOTER$6); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetEvenFooter() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EVENFOOTER$6, 0);
    } 
  }
  
  public String getFirstHeader() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(FIRSTHEADER$8, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetFirstHeader() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_element_user(FIRSTHEADER$8, 0);
      return sTXstring;
    } 
  }
  
  public boolean isSetFirstHeader() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FIRSTHEADER$8) != 0);
    } 
  }
  
  public void setFirstHeader(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(FIRSTHEADER$8, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(FIRSTHEADER$8); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetFirstHeader(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_element_user(FIRSTHEADER$8, 0);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_element_user(FIRSTHEADER$8); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetFirstHeader() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FIRSTHEADER$8, 0);
    } 
  }
  
  public String getFirstFooter() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(FIRSTFOOTER$10, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetFirstFooter() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_element_user(FIRSTFOOTER$10, 0);
      return sTXstring;
    } 
  }
  
  public boolean isSetFirstFooter() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FIRSTFOOTER$10) != 0);
    } 
  }
  
  public void setFirstFooter(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(FIRSTFOOTER$10, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(FIRSTFOOTER$10); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetFirstFooter(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_element_user(FIRSTFOOTER$10, 0);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_element_user(FIRSTFOOTER$10); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetFirstFooter() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FIRSTFOOTER$10, 0);
    } 
  }
  
  public boolean getAlignWithMargins() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALIGNWITHMARGINS$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ALIGNWITHMARGINS$12); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetAlignWithMargins() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ALIGNWITHMARGINS$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(ALIGNWITHMARGINS$12); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetAlignWithMargins() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ALIGNWITHMARGINS$12) != null);
    } 
  }
  
  public void setAlignWithMargins(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALIGNWITHMARGINS$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ALIGNWITHMARGINS$12); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetAlignWithMargins(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ALIGNWITHMARGINS$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(ALIGNWITHMARGINS$12); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetAlignWithMargins() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ALIGNWITHMARGINS$12);
    } 
  }
  
  public boolean getDifferentOddEven() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DIFFERENTODDEVEN$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(DIFFERENTODDEVEN$14); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetDifferentOddEven() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DIFFERENTODDEVEN$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(DIFFERENTODDEVEN$14); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetDifferentOddEven() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DIFFERENTODDEVEN$14) != null);
    } 
  }
  
  public void setDifferentOddEven(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DIFFERENTODDEVEN$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DIFFERENTODDEVEN$14); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetDifferentOddEven(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DIFFERENTODDEVEN$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(DIFFERENTODDEVEN$14); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetDifferentOddEven() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DIFFERENTODDEVEN$14);
    } 
  }
  
  public boolean getDifferentFirst() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DIFFERENTFIRST$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(DIFFERENTFIRST$16); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetDifferentFirst() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DIFFERENTFIRST$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(DIFFERENTFIRST$16); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetDifferentFirst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DIFFERENTFIRST$16) != null);
    } 
  }
  
  public void setDifferentFirst(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DIFFERENTFIRST$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DIFFERENTFIRST$16); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetDifferentFirst(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DIFFERENTFIRST$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(DIFFERENTFIRST$16); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetDifferentFirst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DIFFERENTFIRST$16);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTHeaderFooterImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */