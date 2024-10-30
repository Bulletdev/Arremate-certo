package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmt;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts;

public class CTNumFmtsImpl extends XmlComplexContentImpl implements CTNumFmts {
  private static final b NUMFMT$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "numFmt");
  
  private static final b COUNT$2 = new b("", "count");
  
  public CTNumFmtsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTNumFmt> getNumFmtList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTNumFmt>)new NumFmtList(this);
    } 
  }
  
  public CTNumFmt[] getNumFmtArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(NUMFMT$0, arrayList);
      CTNumFmt[] arrayOfCTNumFmt = new CTNumFmt[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTNumFmt);
      return arrayOfCTNumFmt;
    } 
  }
  
  public CTNumFmt getNumFmtArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTNumFmt cTNumFmt = null;
      cTNumFmt = (CTNumFmt)get_store().find_element_user(NUMFMT$0, paramInt);
      if (cTNumFmt == null)
        throw new IndexOutOfBoundsException(); 
      return cTNumFmt;
    } 
  }
  
  public int sizeOfNumFmtArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(NUMFMT$0);
    } 
  }
  
  public void setNumFmtArray(CTNumFmt[] paramArrayOfCTNumFmt) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTNumFmt, NUMFMT$0);
    } 
  }
  
  public void setNumFmtArray(int paramInt, CTNumFmt paramCTNumFmt) {
    synchronized (monitor()) {
      check_orphaned();
      CTNumFmt cTNumFmt = null;
      cTNumFmt = (CTNumFmt)get_store().find_element_user(NUMFMT$0, paramInt);
      if (cTNumFmt == null)
        throw new IndexOutOfBoundsException(); 
      cTNumFmt.set((XmlObject)paramCTNumFmt);
    } 
  }
  
  public CTNumFmt insertNewNumFmt(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTNumFmt cTNumFmt = null;
      cTNumFmt = (CTNumFmt)get_store().insert_element_user(NUMFMT$0, paramInt);
      return cTNumFmt;
    } 
  }
  
  public CTNumFmt addNewNumFmt() {
    synchronized (monitor()) {
      check_orphaned();
      CTNumFmt cTNumFmt = null;
      cTNumFmt = (CTNumFmt)get_store().add_element_user(NUMFMT$0);
      return cTNumFmt;
    } 
  }
  
  public void removeNumFmt(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NUMFMT$0, paramInt);
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTNumFmtsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */