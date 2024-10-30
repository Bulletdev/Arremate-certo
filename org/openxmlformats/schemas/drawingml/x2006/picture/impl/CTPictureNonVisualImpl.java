package org.openxmlformats.schemas.drawingml.x2006.picture.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualPictureProperties;
import org.openxmlformats.schemas.drawingml.x2006.picture.CTPictureNonVisual;

public class CTPictureNonVisualImpl extends XmlComplexContentImpl implements CTPictureNonVisual {
  private static final b CNVPR$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/picture", "cNvPr");
  
  private static final b CNVPICPR$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/picture", "cNvPicPr");
  
  public CTPictureNonVisualImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTNonVisualDrawingProps getCNvPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTNonVisualDrawingProps cTNonVisualDrawingProps = null;
      cTNonVisualDrawingProps = (CTNonVisualDrawingProps)get_store().find_element_user(CNVPR$0, 0);
      if (cTNonVisualDrawingProps == null)
        return null; 
      return cTNonVisualDrawingProps;
    } 
  }
  
  public void setCNvPr(CTNonVisualDrawingProps paramCTNonVisualDrawingProps) {
    synchronized (monitor()) {
      check_orphaned();
      CTNonVisualDrawingProps cTNonVisualDrawingProps = null;
      cTNonVisualDrawingProps = (CTNonVisualDrawingProps)get_store().find_element_user(CNVPR$0, 0);
      if (cTNonVisualDrawingProps == null)
        cTNonVisualDrawingProps = (CTNonVisualDrawingProps)get_store().add_element_user(CNVPR$0); 
      cTNonVisualDrawingProps.set((XmlObject)paramCTNonVisualDrawingProps);
    } 
  }
  
  public CTNonVisualDrawingProps addNewCNvPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTNonVisualDrawingProps cTNonVisualDrawingProps = null;
      cTNonVisualDrawingProps = (CTNonVisualDrawingProps)get_store().add_element_user(CNVPR$0);
      return cTNonVisualDrawingProps;
    } 
  }
  
  public CTNonVisualPictureProperties getCNvPicPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTNonVisualPictureProperties cTNonVisualPictureProperties = null;
      cTNonVisualPictureProperties = (CTNonVisualPictureProperties)get_store().find_element_user(CNVPICPR$2, 0);
      if (cTNonVisualPictureProperties == null)
        return null; 
      return cTNonVisualPictureProperties;
    } 
  }
  
  public void setCNvPicPr(CTNonVisualPictureProperties paramCTNonVisualPictureProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTNonVisualPictureProperties cTNonVisualPictureProperties = null;
      cTNonVisualPictureProperties = (CTNonVisualPictureProperties)get_store().find_element_user(CNVPICPR$2, 0);
      if (cTNonVisualPictureProperties == null)
        cTNonVisualPictureProperties = (CTNonVisualPictureProperties)get_store().add_element_user(CNVPICPR$2); 
      cTNonVisualPictureProperties.set((XmlObject)paramCTNonVisualPictureProperties);
    } 
  }
  
  public CTNonVisualPictureProperties addNewCNvPicPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTNonVisualPictureProperties cTNonVisualPictureProperties = null;
      cTNonVisualPictureProperties = (CTNonVisualPictureProperties)get_store().add_element_user(CNVPICPR$2);
      return cTNonVisualPictureProperties;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\picture\impl\CTPictureNonVisualImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */