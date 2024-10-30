package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles;

public class CTStylesImpl extends XmlComplexContentImpl implements CTStyles {
  private static final b DOCDEFAULTS$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "docDefaults");
  
  private static final b LATENTSTYLES$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "latentStyles");
  
  private static final b STYLE$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "style");
  
  public CTStylesImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTDocDefaults getDocDefaults() {
    synchronized (monitor()) {
      check_orphaned();
      CTDocDefaults cTDocDefaults = null;
      cTDocDefaults = (CTDocDefaults)get_store().find_element_user(DOCDEFAULTS$0, 0);
      if (cTDocDefaults == null)
        return null; 
      return cTDocDefaults;
    } 
  }
  
  public boolean isSetDocDefaults() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DOCDEFAULTS$0) != 0);
    } 
  }
  
  public void setDocDefaults(CTDocDefaults paramCTDocDefaults) {
    synchronized (monitor()) {
      check_orphaned();
      CTDocDefaults cTDocDefaults = null;
      cTDocDefaults = (CTDocDefaults)get_store().find_element_user(DOCDEFAULTS$0, 0);
      if (cTDocDefaults == null)
        cTDocDefaults = (CTDocDefaults)get_store().add_element_user(DOCDEFAULTS$0); 
      cTDocDefaults.set((XmlObject)paramCTDocDefaults);
    } 
  }
  
  public CTDocDefaults addNewDocDefaults() {
    synchronized (monitor()) {
      check_orphaned();
      CTDocDefaults cTDocDefaults = null;
      cTDocDefaults = (CTDocDefaults)get_store().add_element_user(DOCDEFAULTS$0);
      return cTDocDefaults;
    } 
  }
  
  public void unsetDocDefaults() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DOCDEFAULTS$0, 0);
    } 
  }
  
  public CTLatentStyles getLatentStyles() {
    synchronized (monitor()) {
      check_orphaned();
      CTLatentStyles cTLatentStyles = null;
      cTLatentStyles = (CTLatentStyles)get_store().find_element_user(LATENTSTYLES$2, 0);
      if (cTLatentStyles == null)
        return null; 
      return cTLatentStyles;
    } 
  }
  
  public boolean isSetLatentStyles() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LATENTSTYLES$2) != 0);
    } 
  }
  
  public void setLatentStyles(CTLatentStyles paramCTLatentStyles) {
    synchronized (monitor()) {
      check_orphaned();
      CTLatentStyles cTLatentStyles = null;
      cTLatentStyles = (CTLatentStyles)get_store().find_element_user(LATENTSTYLES$2, 0);
      if (cTLatentStyles == null)
        cTLatentStyles = (CTLatentStyles)get_store().add_element_user(LATENTSTYLES$2); 
      cTLatentStyles.set((XmlObject)paramCTLatentStyles);
    } 
  }
  
  public CTLatentStyles addNewLatentStyles() {
    synchronized (monitor()) {
      check_orphaned();
      CTLatentStyles cTLatentStyles = null;
      cTLatentStyles = (CTLatentStyles)get_store().add_element_user(LATENTSTYLES$2);
      return cTLatentStyles;
    } 
  }
  
  public void unsetLatentStyles() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LATENTSTYLES$2, 0);
    } 
  }
  
  public List<CTStyle> getStyleList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTStyle>)new StyleList(this);
    } 
  }
  
  public CTStyle[] getStyleArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(STYLE$4, arrayList);
      CTStyle[] arrayOfCTStyle = new CTStyle[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTStyle);
      return arrayOfCTStyle;
    } 
  }
  
  public CTStyle getStyleArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTStyle cTStyle = null;
      cTStyle = (CTStyle)get_store().find_element_user(STYLE$4, paramInt);
      if (cTStyle == null)
        throw new IndexOutOfBoundsException(); 
      return cTStyle;
    } 
  }
  
  public int sizeOfStyleArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(STYLE$4);
    } 
  }
  
  public void setStyleArray(CTStyle[] paramArrayOfCTStyle) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTStyle, STYLE$4);
    } 
  }
  
  public void setStyleArray(int paramInt, CTStyle paramCTStyle) {
    synchronized (monitor()) {
      check_orphaned();
      CTStyle cTStyle = null;
      cTStyle = (CTStyle)get_store().find_element_user(STYLE$4, paramInt);
      if (cTStyle == null)
        throw new IndexOutOfBoundsException(); 
      cTStyle.set((XmlObject)paramCTStyle);
    } 
  }
  
  public CTStyle insertNewStyle(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTStyle cTStyle = null;
      cTStyle = (CTStyle)get_store().insert_element_user(STYLE$4, paramInt);
      return cTStyle;
    } 
  }
  
  public CTStyle addNewStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTStyle cTStyle = null;
      cTStyle = (CTStyle)get_store().add_element_user(STYLE$4);
      return cTStyle;
    } 
  }
  
  public void removeStyle(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(STYLE$4, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTStylesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */