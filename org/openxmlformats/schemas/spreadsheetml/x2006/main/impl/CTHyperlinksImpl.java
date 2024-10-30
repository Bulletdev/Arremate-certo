package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlinks;

public class CTHyperlinksImpl extends XmlComplexContentImpl implements CTHyperlinks {
  private static final b HYPERLINK$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "hyperlink");
  
  public CTHyperlinksImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTHyperlink> getHyperlinkList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTHyperlink>)new HyperlinkList(this);
    } 
  }
  
  public CTHyperlink[] getHyperlinkArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(HYPERLINK$0, arrayList);
      CTHyperlink[] arrayOfCTHyperlink = new CTHyperlink[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTHyperlink);
      return arrayOfCTHyperlink;
    } 
  }
  
  public CTHyperlink getHyperlinkArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTHyperlink cTHyperlink = null;
      cTHyperlink = (CTHyperlink)get_store().find_element_user(HYPERLINK$0, paramInt);
      if (cTHyperlink == null)
        throw new IndexOutOfBoundsException(); 
      return cTHyperlink;
    } 
  }
  
  public int sizeOfHyperlinkArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(HYPERLINK$0);
    } 
  }
  
  public void setHyperlinkArray(CTHyperlink[] paramArrayOfCTHyperlink) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTHyperlink, HYPERLINK$0);
    } 
  }
  
  public void setHyperlinkArray(int paramInt, CTHyperlink paramCTHyperlink) {
    synchronized (monitor()) {
      check_orphaned();
      CTHyperlink cTHyperlink = null;
      cTHyperlink = (CTHyperlink)get_store().find_element_user(HYPERLINK$0, paramInt);
      if (cTHyperlink == null)
        throw new IndexOutOfBoundsException(); 
      cTHyperlink.set((XmlObject)paramCTHyperlink);
    } 
  }
  
  public CTHyperlink insertNewHyperlink(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTHyperlink cTHyperlink = null;
      cTHyperlink = (CTHyperlink)get_store().insert_element_user(HYPERLINK$0, paramInt);
      return cTHyperlink;
    } 
  }
  
  public CTHyperlink addNewHyperlink() {
    synchronized (monitor()) {
      check_orphaned();
      CTHyperlink cTHyperlink = null;
      cTHyperlink = (CTHyperlink)get_store().add_element_user(HYPERLINK$0);
      return cTHyperlink;
    } 
  }
  
  public void removeHyperlink(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HYPERLINK$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTHyperlinksImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */