package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtension;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;

public class CTOfficeArtExtensionListImpl extends XmlComplexContentImpl implements CTOfficeArtExtensionList {
  private static final b EXT$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "ext");
  
  public CTOfficeArtExtensionListImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTOfficeArtExtension> getExtList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTOfficeArtExtension>)new ExtList(this);
    } 
  }
  
  public CTOfficeArtExtension[] getExtArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(EXT$0, arrayList);
      CTOfficeArtExtension[] arrayOfCTOfficeArtExtension = new CTOfficeArtExtension[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTOfficeArtExtension);
      return arrayOfCTOfficeArtExtension;
    } 
  }
  
  public CTOfficeArtExtension getExtArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtension cTOfficeArtExtension = null;
      cTOfficeArtExtension = (CTOfficeArtExtension)get_store().find_element_user(EXT$0, paramInt);
      if (cTOfficeArtExtension == null)
        throw new IndexOutOfBoundsException(); 
      return cTOfficeArtExtension;
    } 
  }
  
  public int sizeOfExtArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(EXT$0);
    } 
  }
  
  public void setExtArray(CTOfficeArtExtension[] paramArrayOfCTOfficeArtExtension) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTOfficeArtExtension, EXT$0);
    } 
  }
  
  public void setExtArray(int paramInt, CTOfficeArtExtension paramCTOfficeArtExtension) {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtension cTOfficeArtExtension = null;
      cTOfficeArtExtension = (CTOfficeArtExtension)get_store().find_element_user(EXT$0, paramInt);
      if (cTOfficeArtExtension == null)
        throw new IndexOutOfBoundsException(); 
      cTOfficeArtExtension.set((XmlObject)paramCTOfficeArtExtension);
    } 
  }
  
  public CTOfficeArtExtension insertNewExt(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtension cTOfficeArtExtension = null;
      cTOfficeArtExtension = (CTOfficeArtExtension)get_store().insert_element_user(EXT$0, paramInt);
      return cTOfficeArtExtension;
    } 
  }
  
  public CTOfficeArtExtension addNewExt() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtension cTOfficeArtExtension = null;
      cTOfficeArtExtension = (CTOfficeArtExtension)get_store().add_element_user(EXT$0);
      return cTOfficeArtExtension;
    } 
  }
  
  public void removeExt(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXT$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTOfficeArtExtensionListImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */