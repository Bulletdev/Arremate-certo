package org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector;
import org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTVectorVariant;

public class CTVectorVariantImpl extends XmlComplexContentImpl implements CTVectorVariant {
  private static final b VECTOR$0 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "vector");
  
  public CTVectorVariantImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTVector getVector() {
    synchronized (monitor()) {
      check_orphaned();
      CTVector cTVector = null;
      cTVector = (CTVector)get_store().find_element_user(VECTOR$0, 0);
      if (cTVector == null)
        return null; 
      return cTVector;
    } 
  }
  
  public void setVector(CTVector paramCTVector) {
    synchronized (monitor()) {
      check_orphaned();
      CTVector cTVector = null;
      cTVector = (CTVector)get_store().find_element_user(VECTOR$0, 0);
      if (cTVector == null)
        cTVector = (CTVector)get_store().add_element_user(VECTOR$0); 
      cTVector.set((XmlObject)paramCTVector);
    } 
  }
  
  public CTVector addNewVector() {
    synchronized (monitor()) {
      check_orphaned();
      CTVector cTVector = null;
      cTVector = (CTVector)get_store().add_element_user(VECTOR$0);
      return cTVector;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\officeDocument\x2006\extendedProperties\impl\CTVectorVariantImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */