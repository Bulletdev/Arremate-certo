package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.CellType;
import com.microsoft.schemas.office.visio.x2012.main.RefByType;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class CellTypeImpl extends XmlComplexContentImpl implements CellType {
  private static final b REFBY$0 = new b("http://schemas.microsoft.com/office/visio/2012/main", "RefBy");
  
  private static final b N$2 = new b("", "N");
  
  private static final b U$4 = new b("", "U");
  
  private static final b E$6 = new b("", "E");
  
  private static final b F$8 = new b("", "F");
  
  private static final b V$10 = new b("", "V");
  
  public CellTypeImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<RefByType> getRefByList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<RefByType>)new RefByList(this);
    } 
  }
  
  public RefByType[] getRefByArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(REFBY$0, arrayList);
      RefByType[] arrayOfRefByType = new RefByType[arrayList.size()];
      arrayList.toArray((Object[])arrayOfRefByType);
      return arrayOfRefByType;
    } 
  }
  
  public RefByType getRefByArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      RefByType refByType = null;
      refByType = (RefByType)get_store().find_element_user(REFBY$0, paramInt);
      if (refByType == null)
        throw new IndexOutOfBoundsException(); 
      return refByType;
    } 
  }
  
  public int sizeOfRefByArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(REFBY$0);
    } 
  }
  
  public void setRefByArray(RefByType[] paramArrayOfRefByType) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfRefByType, REFBY$0);
    } 
  }
  
  public void setRefByArray(int paramInt, RefByType paramRefByType) {
    synchronized (monitor()) {
      check_orphaned();
      RefByType refByType = null;
      refByType = (RefByType)get_store().find_element_user(REFBY$0, paramInt);
      if (refByType == null)
        throw new IndexOutOfBoundsException(); 
      refByType.set((XmlObject)paramRefByType);
    } 
  }
  
  public RefByType insertNewRefBy(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      RefByType refByType = null;
      refByType = (RefByType)get_store().insert_element_user(REFBY$0, paramInt);
      return refByType;
    } 
  }
  
  public RefByType addNewRefBy() {
    synchronized (monitor()) {
      check_orphaned();
      RefByType refByType = null;
      refByType = (RefByType)get_store().add_element_user(REFBY$0);
      return refByType;
    } 
  }
  
  public void removeRefBy(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(REFBY$0, paramInt);
    } 
  }
  
  public String getN() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(N$2);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetN() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(N$2);
      return xmlString;
    } 
  }
  
  public void setN(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(N$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(N$2); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetN(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(N$2);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(N$2); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public String getU() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(U$4);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetU() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(U$4);
      return xmlString;
    } 
  }
  
  public boolean isSetU() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(U$4) != null);
    } 
  }
  
  public void setU(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(U$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(U$4); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetU(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(U$4);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(U$4); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetU() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(U$4);
    } 
  }
  
  public String getE() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(E$6);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetE() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(E$6);
      return xmlString;
    } 
  }
  
  public boolean isSetE() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(E$6) != null);
    } 
  }
  
  public void setE(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(E$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(E$6); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetE(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(E$6);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(E$6); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetE() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(E$6);
    } 
  }
  
  public String getF() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(F$8);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetF() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(F$8);
      return xmlString;
    } 
  }
  
  public boolean isSetF() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(F$8) != null);
    } 
  }
  
  public void setF(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(F$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(F$8); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetF(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(F$8);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(F$8); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetF() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(F$8);
    } 
  }
  
  public String getV() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(V$10);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetV() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(V$10);
      return xmlString;
    } 
  }
  
  public boolean isSetV() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(V$10) != null);
    } 
  }
  
  public void setV(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(V$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(V$10); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetV(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(V$10);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(V$10); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetV() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(V$10);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\impl\CellTypeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */