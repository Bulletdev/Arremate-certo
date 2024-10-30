package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFontReference;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference;

public class CTShapeStyleImpl extends XmlComplexContentImpl implements CTShapeStyle {
  private static final b LNREF$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "lnRef");
  
  private static final b FILLREF$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "fillRef");
  
  private static final b EFFECTREF$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "effectRef");
  
  private static final b FONTREF$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "fontRef");
  
  public CTShapeStyleImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTStyleMatrixReference getLnRef() {
    synchronized (monitor()) {
      check_orphaned();
      CTStyleMatrixReference cTStyleMatrixReference = null;
      cTStyleMatrixReference = (CTStyleMatrixReference)get_store().find_element_user(LNREF$0, 0);
      if (cTStyleMatrixReference == null)
        return null; 
      return cTStyleMatrixReference;
    } 
  }
  
  public void setLnRef(CTStyleMatrixReference paramCTStyleMatrixReference) {
    synchronized (monitor()) {
      check_orphaned();
      CTStyleMatrixReference cTStyleMatrixReference = null;
      cTStyleMatrixReference = (CTStyleMatrixReference)get_store().find_element_user(LNREF$0, 0);
      if (cTStyleMatrixReference == null)
        cTStyleMatrixReference = (CTStyleMatrixReference)get_store().add_element_user(LNREF$0); 
      cTStyleMatrixReference.set((XmlObject)paramCTStyleMatrixReference);
    } 
  }
  
  public CTStyleMatrixReference addNewLnRef() {
    synchronized (monitor()) {
      check_orphaned();
      CTStyleMatrixReference cTStyleMatrixReference = null;
      cTStyleMatrixReference = (CTStyleMatrixReference)get_store().add_element_user(LNREF$0);
      return cTStyleMatrixReference;
    } 
  }
  
  public CTStyleMatrixReference getFillRef() {
    synchronized (monitor()) {
      check_orphaned();
      CTStyleMatrixReference cTStyleMatrixReference = null;
      cTStyleMatrixReference = (CTStyleMatrixReference)get_store().find_element_user(FILLREF$2, 0);
      if (cTStyleMatrixReference == null)
        return null; 
      return cTStyleMatrixReference;
    } 
  }
  
  public void setFillRef(CTStyleMatrixReference paramCTStyleMatrixReference) {
    synchronized (monitor()) {
      check_orphaned();
      CTStyleMatrixReference cTStyleMatrixReference = null;
      cTStyleMatrixReference = (CTStyleMatrixReference)get_store().find_element_user(FILLREF$2, 0);
      if (cTStyleMatrixReference == null)
        cTStyleMatrixReference = (CTStyleMatrixReference)get_store().add_element_user(FILLREF$2); 
      cTStyleMatrixReference.set((XmlObject)paramCTStyleMatrixReference);
    } 
  }
  
  public CTStyleMatrixReference addNewFillRef() {
    synchronized (monitor()) {
      check_orphaned();
      CTStyleMatrixReference cTStyleMatrixReference = null;
      cTStyleMatrixReference = (CTStyleMatrixReference)get_store().add_element_user(FILLREF$2);
      return cTStyleMatrixReference;
    } 
  }
  
  public CTStyleMatrixReference getEffectRef() {
    synchronized (monitor()) {
      check_orphaned();
      CTStyleMatrixReference cTStyleMatrixReference = null;
      cTStyleMatrixReference = (CTStyleMatrixReference)get_store().find_element_user(EFFECTREF$4, 0);
      if (cTStyleMatrixReference == null)
        return null; 
      return cTStyleMatrixReference;
    } 
  }
  
  public void setEffectRef(CTStyleMatrixReference paramCTStyleMatrixReference) {
    synchronized (monitor()) {
      check_orphaned();
      CTStyleMatrixReference cTStyleMatrixReference = null;
      cTStyleMatrixReference = (CTStyleMatrixReference)get_store().find_element_user(EFFECTREF$4, 0);
      if (cTStyleMatrixReference == null)
        cTStyleMatrixReference = (CTStyleMatrixReference)get_store().add_element_user(EFFECTREF$4); 
      cTStyleMatrixReference.set((XmlObject)paramCTStyleMatrixReference);
    } 
  }
  
  public CTStyleMatrixReference addNewEffectRef() {
    synchronized (monitor()) {
      check_orphaned();
      CTStyleMatrixReference cTStyleMatrixReference = null;
      cTStyleMatrixReference = (CTStyleMatrixReference)get_store().add_element_user(EFFECTREF$4);
      return cTStyleMatrixReference;
    } 
  }
  
  public CTFontReference getFontRef() {
    synchronized (monitor()) {
      check_orphaned();
      CTFontReference cTFontReference = null;
      cTFontReference = (CTFontReference)get_store().find_element_user(FONTREF$6, 0);
      if (cTFontReference == null)
        return null; 
      return cTFontReference;
    } 
  }
  
  public void setFontRef(CTFontReference paramCTFontReference) {
    synchronized (monitor()) {
      check_orphaned();
      CTFontReference cTFontReference = null;
      cTFontReference = (CTFontReference)get_store().find_element_user(FONTREF$6, 0);
      if (cTFontReference == null)
        cTFontReference = (CTFontReference)get_store().add_element_user(FONTREF$6); 
      cTFontReference.set((XmlObject)paramCTFontReference);
    } 
  }
  
  public CTFontReference addNewFontRef() {
    synchronized (monitor()) {
      check_orphaned();
      CTFontReference cTFontReference = null;
      cTFontReference = (CTFontReference)get_store().add_element_user(FONTREF$6);
      return cTFontReference;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTShapeStyleImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */