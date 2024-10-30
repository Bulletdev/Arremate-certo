package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHeaderFooter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring;

public class CTHeaderFooterImpl extends XmlComplexContentImpl implements CTHeaderFooter {
  private static final b ODDHEADER$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "oddHeader");
  
  private static final b ODDFOOTER$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "oddFooter");
  
  private static final b EVENHEADER$4 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "evenHeader");
  
  private static final b EVENFOOTER$6 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "evenFooter");
  
  private static final b FIRSTHEADER$8 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "firstHeader");
  
  private static final b FIRSTFOOTER$10 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "firstFooter");
  
  private static final b DIFFERENTODDEVEN$12 = new b("", "differentOddEven");
  
  private static final b DIFFERENTFIRST$14 = new b("", "differentFirst");
  
  private static final b SCALEWITHDOC$16 = new b("", "scaleWithDoc");
  
  private static final b ALIGNWITHMARGINS$18 = new b("", "alignWithMargins");
  
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
  
  public boolean getDifferentOddEven() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DIFFERENTODDEVEN$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(DIFFERENTODDEVEN$12); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetDifferentOddEven() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DIFFERENTODDEVEN$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(DIFFERENTODDEVEN$12); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetDifferentOddEven() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DIFFERENTODDEVEN$12) != null);
    } 
  }
  
  public void setDifferentOddEven(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DIFFERENTODDEVEN$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DIFFERENTODDEVEN$12); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetDifferentOddEven(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DIFFERENTODDEVEN$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(DIFFERENTODDEVEN$12); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetDifferentOddEven() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DIFFERENTODDEVEN$12);
    } 
  }
  
  public boolean getDifferentFirst() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DIFFERENTFIRST$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(DIFFERENTFIRST$14); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetDifferentFirst() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DIFFERENTFIRST$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(DIFFERENTFIRST$14); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetDifferentFirst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DIFFERENTFIRST$14) != null);
    } 
  }
  
  public void setDifferentFirst(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DIFFERENTFIRST$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DIFFERENTFIRST$14); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetDifferentFirst(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DIFFERENTFIRST$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(DIFFERENTFIRST$14); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetDifferentFirst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DIFFERENTFIRST$14);
    } 
  }
  
  public boolean getScaleWithDoc() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SCALEWITHDOC$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SCALEWITHDOC$16); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetScaleWithDoc() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SCALEWITHDOC$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SCALEWITHDOC$16); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetScaleWithDoc() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SCALEWITHDOC$16) != null);
    } 
  }
  
  public void setScaleWithDoc(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SCALEWITHDOC$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SCALEWITHDOC$16); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetScaleWithDoc(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SCALEWITHDOC$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SCALEWITHDOC$16); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetScaleWithDoc() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SCALEWITHDOC$16);
    } 
  }
  
  public boolean getAlignWithMargins() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALIGNWITHMARGINS$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ALIGNWITHMARGINS$18); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetAlignWithMargins() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ALIGNWITHMARGINS$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(ALIGNWITHMARGINS$18); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetAlignWithMargins() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ALIGNWITHMARGINS$18) != null);
    } 
  }
  
  public void setAlignWithMargins(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALIGNWITHMARGINS$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ALIGNWITHMARGINS$18); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetAlignWithMargins(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ALIGNWITHMARGINS$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(ALIGNWITHMARGINS$18); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetAlignWithMargins() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ALIGNWITHMARGINS$18);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTHeaderFooterImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */