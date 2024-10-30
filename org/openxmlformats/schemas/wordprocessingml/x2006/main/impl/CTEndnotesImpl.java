package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEndnotes;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdn;

public class CTEndnotesImpl extends XmlComplexContentImpl implements CTEndnotes {
  private static final b ENDNOTE$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "endnote");
  
  public CTEndnotesImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTFtnEdn> getEndnoteList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTFtnEdn>)new EndnoteList(this);
    } 
  }
  
  public CTFtnEdn[] getEndnoteArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ENDNOTE$0, arrayList);
      CTFtnEdn[] arrayOfCTFtnEdn = new CTFtnEdn[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTFtnEdn);
      return arrayOfCTFtnEdn;
    } 
  }
  
  public CTFtnEdn getEndnoteArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFtnEdn cTFtnEdn = null;
      cTFtnEdn = (CTFtnEdn)get_store().find_element_user(ENDNOTE$0, paramInt);
      if (cTFtnEdn == null)
        throw new IndexOutOfBoundsException(); 
      return cTFtnEdn;
    } 
  }
  
  public int sizeOfEndnoteArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ENDNOTE$0);
    } 
  }
  
  public void setEndnoteArray(CTFtnEdn[] paramArrayOfCTFtnEdn) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTFtnEdn, ENDNOTE$0);
    } 
  }
  
  public void setEndnoteArray(int paramInt, CTFtnEdn paramCTFtnEdn) {
    synchronized (monitor()) {
      check_orphaned();
      CTFtnEdn cTFtnEdn = null;
      cTFtnEdn = (CTFtnEdn)get_store().find_element_user(ENDNOTE$0, paramInt);
      if (cTFtnEdn == null)
        throw new IndexOutOfBoundsException(); 
      cTFtnEdn.set((XmlObject)paramCTFtnEdn);
    } 
  }
  
  public CTFtnEdn insertNewEndnote(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFtnEdn cTFtnEdn = null;
      cTFtnEdn = (CTFtnEdn)get_store().insert_element_user(ENDNOTE$0, paramInt);
      return cTFtnEdn;
    } 
  }
  
  public CTFtnEdn addNewEndnote() {
    synchronized (monitor()) {
      check_orphaned();
      CTFtnEdn cTFtnEdn = null;
      cTFtnEdn = (CTFtnEdn)get_store().add_element_user(ENDNOTE$0);
      return cTFtnEdn;
    } 
  }
  
  public void removeEndnote(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ENDNOTE$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTEndnotesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */