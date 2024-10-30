package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFootnotes;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdn;

public class CTFootnotesImpl extends XmlComplexContentImpl implements CTFootnotes {
  private static final b FOOTNOTE$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "footnote");
  
  public CTFootnotesImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTFtnEdn> getFootnoteList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTFtnEdn>)new FootnoteList(this);
    } 
  }
  
  public CTFtnEdn[] getFootnoteArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(FOOTNOTE$0, arrayList);
      CTFtnEdn[] arrayOfCTFtnEdn = new CTFtnEdn[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTFtnEdn);
      return arrayOfCTFtnEdn;
    } 
  }
  
  public CTFtnEdn getFootnoteArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFtnEdn cTFtnEdn = null;
      cTFtnEdn = (CTFtnEdn)get_store().find_element_user(FOOTNOTE$0, paramInt);
      if (cTFtnEdn == null)
        throw new IndexOutOfBoundsException(); 
      return cTFtnEdn;
    } 
  }
  
  public int sizeOfFootnoteArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(FOOTNOTE$0);
    } 
  }
  
  public void setFootnoteArray(CTFtnEdn[] paramArrayOfCTFtnEdn) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTFtnEdn, FOOTNOTE$0);
    } 
  }
  
  public void setFootnoteArray(int paramInt, CTFtnEdn paramCTFtnEdn) {
    synchronized (monitor()) {
      check_orphaned();
      CTFtnEdn cTFtnEdn = null;
      cTFtnEdn = (CTFtnEdn)get_store().find_element_user(FOOTNOTE$0, paramInt);
      if (cTFtnEdn == null)
        throw new IndexOutOfBoundsException(); 
      cTFtnEdn.set((XmlObject)paramCTFtnEdn);
    } 
  }
  
  public CTFtnEdn insertNewFootnote(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFtnEdn cTFtnEdn = null;
      cTFtnEdn = (CTFtnEdn)get_store().insert_element_user(FOOTNOTE$0, paramInt);
      return cTFtnEdn;
    } 
  }
  
  public CTFtnEdn addNewFootnote() {
    synchronized (monitor()) {
      check_orphaned();
      CTFtnEdn cTFtnEdn = null;
      cTFtnEdn = (CTFtnEdn)get_store().add_element_user(FOOTNOTE$0);
      return cTFtnEdn;
    } 
  }
  
  public void removeFootnote(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FOOTNOTE$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTFootnotesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */