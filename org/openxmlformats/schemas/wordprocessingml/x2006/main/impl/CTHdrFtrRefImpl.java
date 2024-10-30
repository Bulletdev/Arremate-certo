package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtrRef;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHdrFtr;

public class CTHdrFtrRefImpl extends CTRelImpl implements CTHdrFtrRef {
  private static final b TYPE$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "type");
  
  public CTHdrFtrRefImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STHdrFtr.Enum getType() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$0);
      if (simpleValue == null)
        return null; 
      return (STHdrFtr.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STHdrFtr xgetType() {
    synchronized (monitor()) {
      check_orphaned();
      STHdrFtr sTHdrFtr = null;
      sTHdrFtr = (STHdrFtr)get_store().find_attribute_user(TYPE$0);
      return sTHdrFtr;
    } 
  }
  
  public void setType(STHdrFtr.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TYPE$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetType(STHdrFtr paramSTHdrFtr) {
    synchronized (monitor()) {
      check_orphaned();
      STHdrFtr sTHdrFtr = null;
      sTHdrFtr = (STHdrFtr)get_store().find_attribute_user(TYPE$0);
      if (sTHdrFtr == null)
        sTHdrFtr = (STHdrFtr)get_store().add_attribute_user(TYPE$0); 
      sTHdrFtr.set((XmlObject)paramSTHdrFtr);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTHdrFtrRefImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */