package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTProofErr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STProofErr;

public class CTProofErrImpl extends XmlComplexContentImpl implements CTProofErr {
  private static final b TYPE$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "type");
  
  public CTProofErrImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STProofErr.Enum getType() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$0);
      if (simpleValue == null)
        return null; 
      return (STProofErr.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STProofErr xgetType() {
    synchronized (monitor()) {
      check_orphaned();
      STProofErr sTProofErr = null;
      sTProofErr = (STProofErr)get_store().find_attribute_user(TYPE$0);
      return sTProofErr;
    } 
  }
  
  public void setType(STProofErr.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TYPE$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetType(STProofErr paramSTProofErr) {
    synchronized (monitor()) {
      check_orphaned();
      STProofErr sTProofErr = null;
      sTProofErr = (STProofErr)get_store().find_attribute_user(TYPE$0);
      if (sTProofErr == null)
        sTProofErr = (STProofErr)get_store().add_attribute_user(TYPE$0); 
      sTProofErr.set((XmlObject)paramSTProofErr);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTProofErrImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */