package org.openxmlformats.schemas.xpackage.x2006.relationships.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships;
import org.openxmlformats.schemas.xpackage.x2006.relationships.RelationshipsDocument;

public class RelationshipsDocumentImpl extends XmlComplexContentImpl implements RelationshipsDocument {
  private static final b RELATIONSHIPS$0 = new b("http://schemas.openxmlformats.org/package/2006/relationships", "Relationships");
  
  public RelationshipsDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTRelationships getRelationships() {
    synchronized (monitor()) {
      check_orphaned();
      CTRelationships cTRelationships = null;
      cTRelationships = (CTRelationships)get_store().find_element_user(RELATIONSHIPS$0, 0);
      if (cTRelationships == null)
        return null; 
      return cTRelationships;
    } 
  }
  
  public void setRelationships(CTRelationships paramCTRelationships) {
    synchronized (monitor()) {
      check_orphaned();
      CTRelationships cTRelationships = null;
      cTRelationships = (CTRelationships)get_store().find_element_user(RELATIONSHIPS$0, 0);
      if (cTRelationships == null)
        cTRelationships = (CTRelationships)get_store().add_element_user(RELATIONSHIPS$0); 
      cTRelationships.set((XmlObject)paramCTRelationships);
    } 
  }
  
  public CTRelationships addNewRelationships() {
    synchronized (monitor()) {
      check_orphaned();
      CTRelationships cTRelationships = null;
      cTRelationships = (CTRelationships)get_store().add_element_user(RELATIONSHIPS$0);
      return cTRelationships;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\xpackage\x2006\relationships\impl\RelationshipsDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */