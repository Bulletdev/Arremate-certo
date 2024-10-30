package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing;

public class CTDrawingImpl extends XmlComplexContentImpl implements CTDrawing {
  private static final b ANCHOR$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "anchor");
  
  private static final b INLINE$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "inline");
  
  public CTDrawingImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTAnchor> getAnchorList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTAnchor>)new AnchorList(this);
    } 
  }
  
  public CTAnchor[] getAnchorArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ANCHOR$0, arrayList);
      CTAnchor[] arrayOfCTAnchor = new CTAnchor[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTAnchor);
      return arrayOfCTAnchor;
    } 
  }
  
  public CTAnchor getAnchorArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTAnchor cTAnchor = null;
      cTAnchor = (CTAnchor)get_store().find_element_user(ANCHOR$0, paramInt);
      if (cTAnchor == null)
        throw new IndexOutOfBoundsException(); 
      return cTAnchor;
    } 
  }
  
  public int sizeOfAnchorArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ANCHOR$0);
    } 
  }
  
  public void setAnchorArray(CTAnchor[] paramArrayOfCTAnchor) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTAnchor, ANCHOR$0);
    } 
  }
  
  public void setAnchorArray(int paramInt, CTAnchor paramCTAnchor) {
    synchronized (monitor()) {
      check_orphaned();
      CTAnchor cTAnchor = null;
      cTAnchor = (CTAnchor)get_store().find_element_user(ANCHOR$0, paramInt);
      if (cTAnchor == null)
        throw new IndexOutOfBoundsException(); 
      cTAnchor.set((XmlObject)paramCTAnchor);
    } 
  }
  
  public CTAnchor insertNewAnchor(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTAnchor cTAnchor = null;
      cTAnchor = (CTAnchor)get_store().insert_element_user(ANCHOR$0, paramInt);
      return cTAnchor;
    } 
  }
  
  public CTAnchor addNewAnchor() {
    synchronized (monitor()) {
      check_orphaned();
      CTAnchor cTAnchor = null;
      cTAnchor = (CTAnchor)get_store().add_element_user(ANCHOR$0);
      return cTAnchor;
    } 
  }
  
  public void removeAnchor(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ANCHOR$0, paramInt);
    } 
  }
  
  public List<CTInline> getInlineList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTInline>)new InlineList(this);
    } 
  }
  
  public CTInline[] getInlineArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(INLINE$2, arrayList);
      CTInline[] arrayOfCTInline = new CTInline[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTInline);
      return arrayOfCTInline;
    } 
  }
  
  public CTInline getInlineArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTInline cTInline = null;
      cTInline = (CTInline)get_store().find_element_user(INLINE$2, paramInt);
      if (cTInline == null)
        throw new IndexOutOfBoundsException(); 
      return cTInline;
    } 
  }
  
  public int sizeOfInlineArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(INLINE$2);
    } 
  }
  
  public void setInlineArray(CTInline[] paramArrayOfCTInline) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTInline, INLINE$2);
    } 
  }
  
  public void setInlineArray(int paramInt, CTInline paramCTInline) {
    synchronized (monitor()) {
      check_orphaned();
      CTInline cTInline = null;
      cTInline = (CTInline)get_store().find_element_user(INLINE$2, paramInt);
      if (cTInline == null)
        throw new IndexOutOfBoundsException(); 
      cTInline.set((XmlObject)paramCTInline);
    } 
  }
  
  public CTInline insertNewInline(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTInline cTInline = null;
      cTInline = (CTInline)get_store().insert_element_user(INLINE$2, paramInt);
      return cTInline;
    } 
  }
  
  public CTInline addNewInline() {
    synchronized (monitor()) {
      check_orphaned();
      CTInline cTInline = null;
      cTInline = (CTInline)get_store().add_element_user(INLINE$2);
      return cTInline;
    } 
  }
  
  public void removeInline(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(INLINE$2, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTDrawingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */