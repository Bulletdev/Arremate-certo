package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalReference;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalReferences;

public class CTExternalReferencesImpl extends XmlComplexContentImpl implements CTExternalReferences {
  private static final b EXTERNALREFERENCE$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "externalReference");
  
  public CTExternalReferencesImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTExternalReference> getExternalReferenceList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTExternalReference>)new ExternalReferenceList(this);
    } 
  }
  
  public CTExternalReference[] getExternalReferenceArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(EXTERNALREFERENCE$0, arrayList);
      CTExternalReference[] arrayOfCTExternalReference = new CTExternalReference[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTExternalReference);
      return arrayOfCTExternalReference;
    } 
  }
  
  public CTExternalReference getExternalReferenceArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTExternalReference cTExternalReference = null;
      cTExternalReference = (CTExternalReference)get_store().find_element_user(EXTERNALREFERENCE$0, paramInt);
      if (cTExternalReference == null)
        throw new IndexOutOfBoundsException(); 
      return cTExternalReference;
    } 
  }
  
  public int sizeOfExternalReferenceArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(EXTERNALREFERENCE$0);
    } 
  }
  
  public void setExternalReferenceArray(CTExternalReference[] paramArrayOfCTExternalReference) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTExternalReference, EXTERNALREFERENCE$0);
    } 
  }
  
  public void setExternalReferenceArray(int paramInt, CTExternalReference paramCTExternalReference) {
    synchronized (monitor()) {
      check_orphaned();
      CTExternalReference cTExternalReference = null;
      cTExternalReference = (CTExternalReference)get_store().find_element_user(EXTERNALREFERENCE$0, paramInt);
      if (cTExternalReference == null)
        throw new IndexOutOfBoundsException(); 
      cTExternalReference.set((XmlObject)paramCTExternalReference);
    } 
  }
  
  public CTExternalReference insertNewExternalReference(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTExternalReference cTExternalReference = null;
      cTExternalReference = (CTExternalReference)get_store().insert_element_user(EXTERNALREFERENCE$0, paramInt);
      return cTExternalReference;
    } 
  }
  
  public CTExternalReference addNewExternalReference() {
    synchronized (monitor()) {
      check_orphaned();
      CTExternalReference cTExternalReference = null;
      cTExternalReference = (CTExternalReference)get_store().add_element_user(EXTERNALREFERENCE$0);
      return cTExternalReference;
    } 
  }
  
  public void removeExternalReference(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTERNALREFERENCE$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTExternalReferencesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */