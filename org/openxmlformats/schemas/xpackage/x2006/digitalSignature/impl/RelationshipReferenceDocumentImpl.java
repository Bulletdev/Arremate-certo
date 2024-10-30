package org.openxmlformats.schemas.xpackage.x2006.digitalSignature.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.xpackage.x2006.digitalSignature.CTRelationshipReference;
import org.openxmlformats.schemas.xpackage.x2006.digitalSignature.RelationshipReferenceDocument;

public class RelationshipReferenceDocumentImpl extends XmlComplexContentImpl implements RelationshipReferenceDocument {
  private static final b RELATIONSHIPREFERENCE$0 = new b("http://schemas.openxmlformats.org/package/2006/digital-signature", "RelationshipReference");
  
  public RelationshipReferenceDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTRelationshipReference getRelationshipReference() {
    synchronized (monitor()) {
      check_orphaned();
      CTRelationshipReference cTRelationshipReference = null;
      cTRelationshipReference = (CTRelationshipReference)get_store().find_element_user(RELATIONSHIPREFERENCE$0, 0);
      if (cTRelationshipReference == null)
        return null; 
      return cTRelationshipReference;
    } 
  }
  
  public void setRelationshipReference(CTRelationshipReference paramCTRelationshipReference) {
    synchronized (monitor()) {
      check_orphaned();
      CTRelationshipReference cTRelationshipReference = null;
      cTRelationshipReference = (CTRelationshipReference)get_store().find_element_user(RELATIONSHIPREFERENCE$0, 0);
      if (cTRelationshipReference == null)
        cTRelationshipReference = (CTRelationshipReference)get_store().add_element_user(RELATIONSHIPREFERENCE$0); 
      cTRelationshipReference.set((XmlObject)paramCTRelationshipReference);
    } 
  }
  
  public CTRelationshipReference addNewRelationshipReference() {
    synchronized (monitor()) {
      check_orphaned();
      CTRelationshipReference cTRelationshipReference = null;
      cTRelationshipReference = (CTRelationshipReference)get_store().add_element_user(RELATIONSHIPREFERENCE$0);
      return cTRelationshipReference;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\xpackage\x2006\digitalSignature\impl\RelationshipReferenceDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */