package org.openxmlformats.schemas.officeDocument.x2006.customProperties.impl;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperties;
import org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty;

public class CTPropertiesImpl extends XmlComplexContentImpl implements CTProperties {
  private static final b PROPERTY$0 = new b("http://schemas.openxmlformats.org/officeDocument/2006/custom-properties", "property");
  
  public CTPropertiesImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTProperty> getPropertyList() {
    synchronized (monitor()) {
      check_orphaned();
      final class PropertyList extends AbstractList<CTProperty> {
        public CTProperty get(int param1Int) {
          return CTPropertiesImpl.this.getPropertyArray(param1Int);
        }
        
        public CTProperty set(int param1Int, CTProperty param1CTProperty) {
          CTProperty cTProperty = CTPropertiesImpl.this.getPropertyArray(param1Int);
          CTPropertiesImpl.this.setPropertyArray(param1Int, param1CTProperty);
          return cTProperty;
        }
        
        public void add(int param1Int, CTProperty param1CTProperty) {
          CTPropertiesImpl.this.insertNewProperty(param1Int).set((XmlObject)param1CTProperty);
        }
        
        public CTProperty remove(int param1Int) {
          CTProperty cTProperty = CTPropertiesImpl.this.getPropertyArray(param1Int);
          CTPropertiesImpl.this.removeProperty(param1Int);
          return cTProperty;
        }
        
        public int size() {
          return CTPropertiesImpl.this.sizeOfPropertyArray();
        }
      };
      return new PropertyList();
    } 
  }
  
  public CTProperty[] getPropertyArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(PROPERTY$0, arrayList);
      CTProperty[] arrayOfCTProperty = new CTProperty[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTProperty);
      return arrayOfCTProperty;
    } 
  }
  
  public CTProperty getPropertyArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTProperty cTProperty = null;
      cTProperty = (CTProperty)get_store().find_element_user(PROPERTY$0, paramInt);
      if (cTProperty == null)
        throw new IndexOutOfBoundsException(); 
      return cTProperty;
    } 
  }
  
  public int sizeOfPropertyArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(PROPERTY$0);
    } 
  }
  
  public void setPropertyArray(CTProperty[] paramArrayOfCTProperty) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTProperty, PROPERTY$0);
    } 
  }
  
  public void setPropertyArray(int paramInt, CTProperty paramCTProperty) {
    synchronized (monitor()) {
      check_orphaned();
      CTProperty cTProperty = null;
      cTProperty = (CTProperty)get_store().find_element_user(PROPERTY$0, paramInt);
      if (cTProperty == null)
        throw new IndexOutOfBoundsException(); 
      cTProperty.set((XmlObject)paramCTProperty);
    } 
  }
  
  public CTProperty insertNewProperty(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTProperty cTProperty = null;
      cTProperty = (CTProperty)get_store().insert_element_user(PROPERTY$0, paramInt);
      return cTProperty;
    } 
  }
  
  public CTProperty addNewProperty() {
    synchronized (monitor()) {
      check_orphaned();
      CTProperty cTProperty = null;
      cTProperty = (CTProperty)get_store().add_element_user(PROPERTY$0);
      return cTProperty;
    } 
  }
  
  public void removeProperty(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PROPERTY$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\officeDocument\x2006\customProperties\impl\CTPropertiesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */