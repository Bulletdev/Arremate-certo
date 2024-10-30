package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmt;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STNumFmtId;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring;

public class CTNumFmtImpl extends XmlComplexContentImpl implements CTNumFmt {
  private static final b NUMFMTID$0 = new b("", "numFmtId");
  
  private static final b FORMATCODE$2 = new b("", "formatCode");
  
  public CTNumFmtImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public long getNumFmtId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NUMFMTID$0);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STNumFmtId xgetNumFmtId() {
    synchronized (monitor()) {
      check_orphaned();
      STNumFmtId sTNumFmtId = null;
      sTNumFmtId = (STNumFmtId)get_store().find_attribute_user(NUMFMTID$0);
      return sTNumFmtId;
    } 
  }
  
  public void setNumFmtId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NUMFMTID$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NUMFMTID$0); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetNumFmtId(STNumFmtId paramSTNumFmtId) {
    synchronized (monitor()) {
      check_orphaned();
      STNumFmtId sTNumFmtId = null;
      sTNumFmtId = (STNumFmtId)get_store().find_attribute_user(NUMFMTID$0);
      if (sTNumFmtId == null)
        sTNumFmtId = (STNumFmtId)get_store().add_attribute_user(NUMFMTID$0); 
      sTNumFmtId.set((XmlObject)paramSTNumFmtId);
    } 
  }
  
  public String getFormatCode() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FORMATCODE$2);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetFormatCode() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(FORMATCODE$2);
      return sTXstring;
    } 
  }
  
  public void setFormatCode(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FORMATCODE$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FORMATCODE$2); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetFormatCode(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(FORMATCODE$2);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(FORMATCODE$2); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTNumFmtImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */