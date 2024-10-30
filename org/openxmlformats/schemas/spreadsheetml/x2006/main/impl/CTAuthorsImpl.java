package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAuthors;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring;

public class CTAuthorsImpl extends XmlComplexContentImpl implements CTAuthors {
  private static final b AUTHOR$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "author");
  
  public CTAuthorsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<String> getAuthorList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<String>)new AuthorList(this);
    } 
  }
  
  public String[] getAuthorArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(AUTHOR$0, arrayList);
      String[] arrayOfString = new String[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfString[b1] = ((SimpleValue)arrayList.get(b1)).getStringValue();
        b1++;
      } 
      return arrayOfString;
    } 
  }
  
  public String getAuthorArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(AUTHOR$0, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getStringValue();
    } 
  }
  
  public List<STXstring> xgetAuthorList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STXstring>)new AuthorList(this);
    } 
  }
  
  public STXstring[] xgetAuthorArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(AUTHOR$0, arrayList);
      STXstring[] arrayOfSTXstring = new STXstring[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTXstring);
      return arrayOfSTXstring;
    } 
  }
  
  public STXstring xgetAuthorArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_element_user(AUTHOR$0, paramInt);
      if (sTXstring == null)
        throw new IndexOutOfBoundsException(); 
      return sTXstring;
    } 
  }
  
  public int sizeOfAuthorArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(AUTHOR$0);
    } 
  }
  
  public void setAuthorArray(String[] paramArrayOfString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfString, AUTHOR$0);
    } 
  }
  
  public void setAuthorArray(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(AUTHOR$0, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetAuthorArray(STXstring[] paramArrayOfSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTXstring, AUTHOR$0);
    } 
  }
  
  public void xsetAuthorArray(int paramInt, STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_element_user(AUTHOR$0, paramInt);
      if (sTXstring == null)
        throw new IndexOutOfBoundsException(); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void insertAuthor(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(AUTHOR$0, paramInt);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void addAuthor(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(AUTHOR$0);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public STXstring insertNewAuthor(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().insert_element_user(AUTHOR$0, paramInt);
      return sTXstring;
    } 
  }
  
  public STXstring addNewAuthor() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().add_element_user(AUTHOR$0);
      return sTXstring;
    } 
  }
  
  public void removeAuthor(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(AUTHOR$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTAuthorsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */