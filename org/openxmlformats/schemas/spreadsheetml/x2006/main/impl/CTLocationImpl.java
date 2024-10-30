package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTLocation;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STRef;

public class CTLocationImpl extends XmlComplexContentImpl implements CTLocation {
  private static final b REF$0 = new b("", "ref");
  
  private static final b FIRSTHEADERROW$2 = new b("", "firstHeaderRow");
  
  private static final b FIRSTDATAROW$4 = new b("", "firstDataRow");
  
  private static final b FIRSTDATACOL$6 = new b("", "firstDataCol");
  
  private static final b ROWPAGECOUNT$8 = new b("", "rowPageCount");
  
  private static final b COLPAGECOUNT$10 = new b("", "colPageCount");
  
  public CTLocationImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public String getRef() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(REF$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STRef xgetRef() {
    synchronized (monitor()) {
      check_orphaned();
      STRef sTRef = null;
      sTRef = (STRef)get_store().find_attribute_user(REF$0);
      return sTRef;
    } 
  }
  
  public void setRef(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(REF$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(REF$0); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetRef(STRef paramSTRef) {
    synchronized (monitor()) {
      check_orphaned();
      STRef sTRef = null;
      sTRef = (STRef)get_store().find_attribute_user(REF$0);
      if (sTRef == null)
        sTRef = (STRef)get_store().add_attribute_user(REF$0); 
      sTRef.set((XmlObject)paramSTRef);
    } 
  }
  
  public long getFirstHeaderRow() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FIRSTHEADERROW$2);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetFirstHeaderRow() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(FIRSTHEADERROW$2);
      return xmlUnsignedInt;
    } 
  }
  
  public void setFirstHeaderRow(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FIRSTHEADERROW$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FIRSTHEADERROW$2); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetFirstHeaderRow(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(FIRSTHEADERROW$2);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(FIRSTHEADERROW$2); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public long getFirstDataRow() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FIRSTDATAROW$4);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetFirstDataRow() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(FIRSTDATAROW$4);
      return xmlUnsignedInt;
    } 
  }
  
  public void setFirstDataRow(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FIRSTDATAROW$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FIRSTDATAROW$4); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetFirstDataRow(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(FIRSTDATAROW$4);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(FIRSTDATAROW$4); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public long getFirstDataCol() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FIRSTDATACOL$6);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetFirstDataCol() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(FIRSTDATACOL$6);
      return xmlUnsignedInt;
    } 
  }
  
  public void setFirstDataCol(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FIRSTDATACOL$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FIRSTDATACOL$6); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetFirstDataCol(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(FIRSTDATACOL$6);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(FIRSTDATACOL$6); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public long getRowPageCount() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ROWPAGECOUNT$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ROWPAGECOUNT$8); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetRowPageCount() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ROWPAGECOUNT$8);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(ROWPAGECOUNT$8); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetRowPageCount() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ROWPAGECOUNT$8) != null);
    } 
  }
  
  public void setRowPageCount(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ROWPAGECOUNT$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ROWPAGECOUNT$8); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetRowPageCount(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ROWPAGECOUNT$8);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(ROWPAGECOUNT$8); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetRowPageCount() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ROWPAGECOUNT$8);
    } 
  }
  
  public long getColPageCount() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COLPAGECOUNT$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(COLPAGECOUNT$10); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetColPageCount() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(COLPAGECOUNT$10);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(COLPAGECOUNT$10); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetColPageCount() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(COLPAGECOUNT$10) != null);
    } 
  }
  
  public void setColPageCount(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COLPAGECOUNT$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(COLPAGECOUNT$10); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetColPageCount(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(COLPAGECOUNT$10);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(COLPAGECOUNT$10); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetColPageCount() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(COLPAGECOUNT$10);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTLocationImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */