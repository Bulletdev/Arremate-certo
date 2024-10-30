package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.StyleSheetType;
import com.microsoft.schemas.office.visio.x2012.main.StyleSheetsType;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class StyleSheetsTypeImpl extends XmlComplexContentImpl implements StyleSheetsType {
  private static final b STYLESHEET$0 = new b("http://schemas.microsoft.com/office/visio/2012/main", "StyleSheet");
  
  public StyleSheetsTypeImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<StyleSheetType> getStyleSheetList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<StyleSheetType>)new StyleSheetList(this);
    } 
  }
  
  public StyleSheetType[] getStyleSheetArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(STYLESHEET$0, arrayList);
      StyleSheetType[] arrayOfStyleSheetType = new StyleSheetType[arrayList.size()];
      arrayList.toArray((Object[])arrayOfStyleSheetType);
      return arrayOfStyleSheetType;
    } 
  }
  
  public StyleSheetType getStyleSheetArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      StyleSheetType styleSheetType = null;
      styleSheetType = (StyleSheetType)get_store().find_element_user(STYLESHEET$0, paramInt);
      if (styleSheetType == null)
        throw new IndexOutOfBoundsException(); 
      return styleSheetType;
    } 
  }
  
  public int sizeOfStyleSheetArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(STYLESHEET$0);
    } 
  }
  
  public void setStyleSheetArray(StyleSheetType[] paramArrayOfStyleSheetType) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfStyleSheetType, STYLESHEET$0);
    } 
  }
  
  public void setStyleSheetArray(int paramInt, StyleSheetType paramStyleSheetType) {
    synchronized (monitor()) {
      check_orphaned();
      StyleSheetType styleSheetType = null;
      styleSheetType = (StyleSheetType)get_store().find_element_user(STYLESHEET$0, paramInt);
      if (styleSheetType == null)
        throw new IndexOutOfBoundsException(); 
      styleSheetType.set((XmlObject)paramStyleSheetType);
    } 
  }
  
  public StyleSheetType insertNewStyleSheet(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      StyleSheetType styleSheetType = null;
      styleSheetType = (StyleSheetType)get_store().insert_element_user(STYLESHEET$0, paramInt);
      return styleSheetType;
    } 
  }
  
  public StyleSheetType addNewStyleSheet() {
    synchronized (monitor()) {
      check_orphaned();
      StyleSheetType styleSheetType = null;
      styleSheetType = (StyleSheetType)get_store().add_element_user(STYLESHEET$0);
      return styleSheetType;
    } 
  }
  
  public void removeStyleSheet(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(STYLESHEET$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\impl\StyleSheetsTypeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */