package org.openxmlformats.schemas.drawingml.x2006.picture.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.picture.CTPicture;
import org.openxmlformats.schemas.drawingml.x2006.picture.CTPictureNonVisual;

public class CTPictureImpl extends XmlComplexContentImpl implements CTPicture {
  private static final b NVPICPR$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/picture", "nvPicPr");
  
  private static final b BLIPFILL$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/picture", "blipFill");
  
  private static final b SPPR$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/picture", "spPr");
  
  public CTPictureImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTPictureNonVisual getNvPicPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTPictureNonVisual cTPictureNonVisual = null;
      cTPictureNonVisual = (CTPictureNonVisual)get_store().find_element_user(NVPICPR$0, 0);
      if (cTPictureNonVisual == null)
        return null; 
      return cTPictureNonVisual;
    } 
  }
  
  public void setNvPicPr(CTPictureNonVisual paramCTPictureNonVisual) {
    synchronized (monitor()) {
      check_orphaned();
      CTPictureNonVisual cTPictureNonVisual = null;
      cTPictureNonVisual = (CTPictureNonVisual)get_store().find_element_user(NVPICPR$0, 0);
      if (cTPictureNonVisual == null)
        cTPictureNonVisual = (CTPictureNonVisual)get_store().add_element_user(NVPICPR$0); 
      cTPictureNonVisual.set((XmlObject)paramCTPictureNonVisual);
    } 
  }
  
  public CTPictureNonVisual addNewNvPicPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTPictureNonVisual cTPictureNonVisual = null;
      cTPictureNonVisual = (CTPictureNonVisual)get_store().add_element_user(NVPICPR$0);
      return cTPictureNonVisual;
    } 
  }
  
  public CTBlipFillProperties getBlipFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTBlipFillProperties cTBlipFillProperties = null;
      cTBlipFillProperties = (CTBlipFillProperties)get_store().find_element_user(BLIPFILL$2, 0);
      if (cTBlipFillProperties == null)
        return null; 
      return cTBlipFillProperties;
    } 
  }
  
  public void setBlipFill(CTBlipFillProperties paramCTBlipFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTBlipFillProperties cTBlipFillProperties = null;
      cTBlipFillProperties = (CTBlipFillProperties)get_store().find_element_user(BLIPFILL$2, 0);
      if (cTBlipFillProperties == null)
        cTBlipFillProperties = (CTBlipFillProperties)get_store().add_element_user(BLIPFILL$2); 
      cTBlipFillProperties.set((XmlObject)paramCTBlipFillProperties);
    } 
  }
  
  public CTBlipFillProperties addNewBlipFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTBlipFillProperties cTBlipFillProperties = null;
      cTBlipFillProperties = (CTBlipFillProperties)get_store().add_element_user(BLIPFILL$2);
      return cTBlipFillProperties;
    } 
  }
  
  public CTShapeProperties getSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeProperties cTShapeProperties = null;
      cTShapeProperties = (CTShapeProperties)get_store().find_element_user(SPPR$4, 0);
      if (cTShapeProperties == null)
        return null; 
      return cTShapeProperties;
    } 
  }
  
  public void setSpPr(CTShapeProperties paramCTShapeProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeProperties cTShapeProperties = null;
      cTShapeProperties = (CTShapeProperties)get_store().find_element_user(SPPR$4, 0);
      if (cTShapeProperties == null)
        cTShapeProperties = (CTShapeProperties)get_store().add_element_user(SPPR$4); 
      cTShapeProperties.set((XmlObject)paramCTShapeProperties);
    } 
  }
  
  public CTShapeProperties addNewSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeProperties cTShapeProperties = null;
      cTShapeProperties = (CTShapeProperties)get_store().add_element_user(SPPR$4);
      return cTShapeProperties;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\picture\impl\CTPictureImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */