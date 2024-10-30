package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrVal;
import org.openxmlformats.schemas.drawingml.x2006.chart.STXstring;

public class CTStrValImpl extends XmlComplexContentImpl implements CTStrVal {
  private static final b V$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "v");
  
  private static final b IDX$2 = new b("", "idx");
  
  public CTStrValImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public String getV() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(V$0, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetV() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_element_user(V$0, 0);
      return sTXstring;
    } 
  }
  
  public void setV(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(V$0, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(V$0); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetV(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_element_user(V$0, 0);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_element_user(V$0); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public long getIdx() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(IDX$2);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetIdx() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(IDX$2);
      return xmlUnsignedInt;
    } 
  }
  
  public void setIdx(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(IDX$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(IDX$2); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetIdx(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(IDX$2);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(IDX$2); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTStrValImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */