package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts;

public class CTFontsImpl extends XmlComplexContentImpl implements CTFonts {
  private static final b FONT$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "font");
  
  private static final b COUNT$2 = new b("", "count");
  
  public CTFontsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTFont> getFontList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTFont>)new FontList(this);
    } 
  }
  
  public CTFont[] getFontArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(FONT$0, arrayList);
      CTFont[] arrayOfCTFont = new CTFont[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTFont);
      return arrayOfCTFont;
    } 
  }
  
  public CTFont getFontArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFont cTFont = null;
      cTFont = (CTFont)get_store().find_element_user(FONT$0, paramInt);
      if (cTFont == null)
        throw new IndexOutOfBoundsException(); 
      return cTFont;
    } 
  }
  
  public int sizeOfFontArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(FONT$0);
    } 
  }
  
  public void setFontArray(CTFont[] paramArrayOfCTFont) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTFont, FONT$0);
    } 
  }
  
  public void setFontArray(int paramInt, CTFont paramCTFont) {
    synchronized (monitor()) {
      check_orphaned();
      CTFont cTFont = null;
      cTFont = (CTFont)get_store().find_element_user(FONT$0, paramInt);
      if (cTFont == null)
        throw new IndexOutOfBoundsException(); 
      cTFont.set((XmlObject)paramCTFont);
    } 
  }
  
  public CTFont insertNewFont(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFont cTFont = null;
      cTFont = (CTFont)get_store().insert_element_user(FONT$0, paramInt);
      return cTFont;
    } 
  }
  
  public CTFont addNewFont() {
    synchronized (monitor()) {
      check_orphaned();
      CTFont cTFont = null;
      cTFont = (CTFont)get_store().add_element_user(FONT$0);
      return cTFont;
    } 
  }
  
  public void removeFont(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FONT$0, paramInt);
    } 
  }
  
  public long getCount() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COUNT$2);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetCount() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(COUNT$2);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetCount() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(COUNT$2) != null);
    } 
  }
  
  public void setCount(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COUNT$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(COUNT$2); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetCount(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(COUNT$2);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(COUNT$2); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetCount() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(COUNT$2);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTFontsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */