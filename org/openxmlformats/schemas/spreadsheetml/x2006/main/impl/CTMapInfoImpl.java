package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMap;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMapInfo;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSchema;

public class CTMapInfoImpl extends XmlComplexContentImpl implements CTMapInfo {
  private static final b SCHEMA$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "Schema");
  
  private static final b MAP$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "Map");
  
  private static final b SELECTIONNAMESPACES$4 = new b("", "SelectionNamespaces");
  
  public CTMapInfoImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTSchema> getSchemaList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTSchema>)new SchemaList(this);
    } 
  }
  
  public CTSchema[] getSchemaArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SCHEMA$0, arrayList);
      CTSchema[] arrayOfCTSchema = new CTSchema[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTSchema);
      return arrayOfCTSchema;
    } 
  }
  
  public CTSchema getSchemaArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSchema cTSchema = null;
      cTSchema = (CTSchema)get_store().find_element_user(SCHEMA$0, paramInt);
      if (cTSchema == null)
        throw new IndexOutOfBoundsException(); 
      return cTSchema;
    } 
  }
  
  public int sizeOfSchemaArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SCHEMA$0);
    } 
  }
  
  public void setSchemaArray(CTSchema[] paramArrayOfCTSchema) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTSchema, SCHEMA$0);
    } 
  }
  
  public void setSchemaArray(int paramInt, CTSchema paramCTSchema) {
    synchronized (monitor()) {
      check_orphaned();
      CTSchema cTSchema = null;
      cTSchema = (CTSchema)get_store().find_element_user(SCHEMA$0, paramInt);
      if (cTSchema == null)
        throw new IndexOutOfBoundsException(); 
      cTSchema.set((XmlObject)paramCTSchema);
    } 
  }
  
  public CTSchema insertNewSchema(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSchema cTSchema = null;
      cTSchema = (CTSchema)get_store().insert_element_user(SCHEMA$0, paramInt);
      return cTSchema;
    } 
  }
  
  public CTSchema addNewSchema() {
    synchronized (monitor()) {
      check_orphaned();
      CTSchema cTSchema = null;
      cTSchema = (CTSchema)get_store().add_element_user(SCHEMA$0);
      return cTSchema;
    } 
  }
  
  public void removeSchema(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SCHEMA$0, paramInt);
    } 
  }
  
  public List<CTMap> getMapList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTMap>)new MapList(this);
    } 
  }
  
  public CTMap[] getMapArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(MAP$2, arrayList);
      CTMap[] arrayOfCTMap = new CTMap[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTMap);
      return arrayOfCTMap;
    } 
  }
  
  public CTMap getMapArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMap cTMap = null;
      cTMap = (CTMap)get_store().find_element_user(MAP$2, paramInt);
      if (cTMap == null)
        throw new IndexOutOfBoundsException(); 
      return cTMap;
    } 
  }
  
  public int sizeOfMapArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(MAP$2);
    } 
  }
  
  public void setMapArray(CTMap[] paramArrayOfCTMap) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTMap, MAP$2);
    } 
  }
  
  public void setMapArray(int paramInt, CTMap paramCTMap) {
    synchronized (monitor()) {
      check_orphaned();
      CTMap cTMap = null;
      cTMap = (CTMap)get_store().find_element_user(MAP$2, paramInt);
      if (cTMap == null)
        throw new IndexOutOfBoundsException(); 
      cTMap.set((XmlObject)paramCTMap);
    } 
  }
  
  public CTMap insertNewMap(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMap cTMap = null;
      cTMap = (CTMap)get_store().insert_element_user(MAP$2, paramInt);
      return cTMap;
    } 
  }
  
  public CTMap addNewMap() {
    synchronized (monitor()) {
      check_orphaned();
      CTMap cTMap = null;
      cTMap = (CTMap)get_store().add_element_user(MAP$2);
      return cTMap;
    } 
  }
  
  public void removeMap(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MAP$2, paramInt);
    } 
  }
  
  public String getSelectionNamespaces() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SELECTIONNAMESPACES$4);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetSelectionNamespaces() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(SELECTIONNAMESPACES$4);
      return xmlString;
    } 
  }
  
  public void setSelectionNamespaces(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SELECTIONNAMESPACES$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SELECTIONNAMESPACES$4); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetSelectionNamespaces(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(SELECTIONNAMESPACES$4);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(SELECTIONNAMESPACES$4); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTMapInfoImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */