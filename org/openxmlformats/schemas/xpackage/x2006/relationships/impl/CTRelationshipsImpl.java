package org.openxmlformats.schemas.xpackage.x2006.relationships.impl;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationship;
import org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships;

public class CTRelationshipsImpl extends XmlComplexContentImpl implements CTRelationships {
  private static final b RELATIONSHIP$0 = new b("http://schemas.openxmlformats.org/package/2006/relationships", "Relationship");
  
  public CTRelationshipsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTRelationship> getRelationshipList() {
    synchronized (monitor()) {
      check_orphaned();
      final class RelationshipList extends AbstractList<CTRelationship> {
        public CTRelationship get(int param1Int) {
          return CTRelationshipsImpl.this.getRelationshipArray(param1Int);
        }
        
        public CTRelationship set(int param1Int, CTRelationship param1CTRelationship) {
          CTRelationship cTRelationship = CTRelationshipsImpl.this.getRelationshipArray(param1Int);
          CTRelationshipsImpl.this.setRelationshipArray(param1Int, param1CTRelationship);
          return cTRelationship;
        }
        
        public void add(int param1Int, CTRelationship param1CTRelationship) {
          CTRelationshipsImpl.this.insertNewRelationship(param1Int).set((XmlObject)param1CTRelationship);
        }
        
        public CTRelationship remove(int param1Int) {
          CTRelationship cTRelationship = CTRelationshipsImpl.this.getRelationshipArray(param1Int);
          CTRelationshipsImpl.this.removeRelationship(param1Int);
          return cTRelationship;
        }
        
        public int size() {
          return CTRelationshipsImpl.this.sizeOfRelationshipArray();
        }
      };
      return new RelationshipList();
    } 
  }
  
  public CTRelationship[] getRelationshipArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(RELATIONSHIP$0, arrayList);
      CTRelationship[] arrayOfCTRelationship = new CTRelationship[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTRelationship);
      return arrayOfCTRelationship;
    } 
  }
  
  public CTRelationship getRelationshipArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRelationship cTRelationship = null;
      cTRelationship = (CTRelationship)get_store().find_element_user(RELATIONSHIP$0, paramInt);
      if (cTRelationship == null)
        throw new IndexOutOfBoundsException(); 
      return cTRelationship;
    } 
  }
  
  public int sizeOfRelationshipArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(RELATIONSHIP$0);
    } 
  }
  
  public void setRelationshipArray(CTRelationship[] paramArrayOfCTRelationship) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTRelationship, RELATIONSHIP$0);
    } 
  }
  
  public void setRelationshipArray(int paramInt, CTRelationship paramCTRelationship) {
    synchronized (monitor()) {
      check_orphaned();
      CTRelationship cTRelationship = null;
      cTRelationship = (CTRelationship)get_store().find_element_user(RELATIONSHIP$0, paramInt);
      if (cTRelationship == null)
        throw new IndexOutOfBoundsException(); 
      cTRelationship.set((XmlObject)paramCTRelationship);
    } 
  }
  
  public CTRelationship insertNewRelationship(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRelationship cTRelationship = null;
      cTRelationship = (CTRelationship)get_store().insert_element_user(RELATIONSHIP$0, paramInt);
      return cTRelationship;
    } 
  }
  
  public CTRelationship addNewRelationship() {
    synchronized (monitor()) {
      check_orphaned();
      CTRelationship cTRelationship = null;
      cTRelationship = (CTRelationship)get_store().add_element_user(RELATIONSHIP$0);
      return cTRelationship;
    } 
  }
  
  public void removeRelationship(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(RELATIONSHIP$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\xpackage\x2006\relationships\impl\CTRelationshipsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */