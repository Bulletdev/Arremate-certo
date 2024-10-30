package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRElt;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring;

public class CTREltImpl extends XmlComplexContentImpl implements CTRElt {
  private static final b RPR$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "rPr");
  
  private static final b T$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "t");
  
  public CTREltImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTRPrElt getRPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTRPrElt cTRPrElt = null;
      cTRPrElt = (CTRPrElt)get_store().find_element_user(RPR$0, 0);
      if (cTRPrElt == null)
        return null; 
      return cTRPrElt;
    } 
  }
  
  public boolean isSetRPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(RPR$0) != 0);
    } 
  }
  
  public void setRPr(CTRPrElt paramCTRPrElt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRPrElt cTRPrElt = null;
      cTRPrElt = (CTRPrElt)get_store().find_element_user(RPR$0, 0);
      if (cTRPrElt == null)
        cTRPrElt = (CTRPrElt)get_store().add_element_user(RPR$0); 
      cTRPrElt.set((XmlObject)paramCTRPrElt);
    } 
  }
  
  public CTRPrElt addNewRPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTRPrElt cTRPrElt = null;
      cTRPrElt = (CTRPrElt)get_store().add_element_user(RPR$0);
      return cTRPrElt;
    } 
  }
  
  public void unsetRPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(RPR$0, 0);
    } 
  }
  
  public String getT() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(T$2, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetT() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_element_user(T$2, 0);
      return sTXstring;
    } 
  }
  
  public void setT(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(T$2, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(T$2); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetT(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_element_user(T$2, 0);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_element_user(T$2); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTREltImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */