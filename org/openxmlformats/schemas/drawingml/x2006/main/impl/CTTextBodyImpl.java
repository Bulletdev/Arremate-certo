package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;

public class CTTextBodyImpl extends XmlComplexContentImpl implements CTTextBody {
  private static final b BODYPR$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "bodyPr");
  
  private static final b LSTSTYLE$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "lstStyle");
  
  private static final b P$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "p");
  
  public CTTextBodyImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTTextBodyProperties getBodyPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBodyProperties cTTextBodyProperties = null;
      cTTextBodyProperties = (CTTextBodyProperties)get_store().find_element_user(BODYPR$0, 0);
      if (cTTextBodyProperties == null)
        return null; 
      return cTTextBodyProperties;
    } 
  }
  
  public void setBodyPr(CTTextBodyProperties paramCTTextBodyProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBodyProperties cTTextBodyProperties = null;
      cTTextBodyProperties = (CTTextBodyProperties)get_store().find_element_user(BODYPR$0, 0);
      if (cTTextBodyProperties == null)
        cTTextBodyProperties = (CTTextBodyProperties)get_store().add_element_user(BODYPR$0); 
      cTTextBodyProperties.set((XmlObject)paramCTTextBodyProperties);
    } 
  }
  
  public CTTextBodyProperties addNewBodyPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBodyProperties cTTextBodyProperties = null;
      cTTextBodyProperties = (CTTextBodyProperties)get_store().add_element_user(BODYPR$0);
      return cTTextBodyProperties;
    } 
  }
  
  public CTTextListStyle getLstStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextListStyle cTTextListStyle = null;
      cTTextListStyle = (CTTextListStyle)get_store().find_element_user(LSTSTYLE$2, 0);
      if (cTTextListStyle == null)
        return null; 
      return cTTextListStyle;
    } 
  }
  
  public boolean isSetLstStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LSTSTYLE$2) != 0);
    } 
  }
  
  public void setLstStyle(CTTextListStyle paramCTTextListStyle) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextListStyle cTTextListStyle = null;
      cTTextListStyle = (CTTextListStyle)get_store().find_element_user(LSTSTYLE$2, 0);
      if (cTTextListStyle == null)
        cTTextListStyle = (CTTextListStyle)get_store().add_element_user(LSTSTYLE$2); 
      cTTextListStyle.set((XmlObject)paramCTTextListStyle);
    } 
  }
  
  public CTTextListStyle addNewLstStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextListStyle cTTextListStyle = null;
      cTTextListStyle = (CTTextListStyle)get_store().add_element_user(LSTSTYLE$2);
      return cTTextListStyle;
    } 
  }
  
  public void unsetLstStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LSTSTYLE$2, 0);
    } 
  }
  
  public List<CTTextParagraph> getPList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTTextParagraph>)new PList(this);
    } 
  }
  
  public CTTextParagraph[] getPArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(P$4, arrayList);
      CTTextParagraph[] arrayOfCTTextParagraph = new CTTextParagraph[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTTextParagraph);
      return arrayOfCTTextParagraph;
    } 
  }
  
  public CTTextParagraph getPArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraph cTTextParagraph = null;
      cTTextParagraph = (CTTextParagraph)get_store().find_element_user(P$4, paramInt);
      if (cTTextParagraph == null)
        throw new IndexOutOfBoundsException(); 
      return cTTextParagraph;
    } 
  }
  
  public int sizeOfPArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(P$4);
    } 
  }
  
  public void setPArray(CTTextParagraph[] paramArrayOfCTTextParagraph) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTTextParagraph, P$4);
    } 
  }
  
  public void setPArray(int paramInt, CTTextParagraph paramCTTextParagraph) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraph cTTextParagraph = null;
      cTTextParagraph = (CTTextParagraph)get_store().find_element_user(P$4, paramInt);
      if (cTTextParagraph == null)
        throw new IndexOutOfBoundsException(); 
      cTTextParagraph.set((XmlObject)paramCTTextParagraph);
    } 
  }
  
  public CTTextParagraph insertNewP(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraph cTTextParagraph = null;
      cTTextParagraph = (CTTextParagraph)get_store().insert_element_user(P$4, paramInt);
      return cTTextParagraph;
    } 
  }
  
  public CTTextParagraph addNewP() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraph cTTextParagraph = null;
      cTTextParagraph = (CTTextParagraph)get_store().add_element_user(P$4);
      return cTTextParagraph;
    } 
  }
  
  public void removeP(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(P$4, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTTextBodyImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */