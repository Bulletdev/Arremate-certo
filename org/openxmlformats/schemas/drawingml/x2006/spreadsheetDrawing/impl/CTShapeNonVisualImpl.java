package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingShapeProps;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShapeNonVisual;

public class CTShapeNonVisualImpl extends XmlComplexContentImpl implements CTShapeNonVisual {
  private static final b CNVPR$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "cNvPr");
  
  private static final b CNVSPPR$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "cNvSpPr");
  
  public CTShapeNonVisualImpl(SchemaType paramSchemaType) {
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
  
  public CTNonVisualDrawingShapeProps getCNvSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTNonVisualDrawingShapeProps cTNonVisualDrawingShapeProps = null;
      cTNonVisualDrawingShapeProps = (CTNonVisualDrawingShapeProps)get_store().find_element_user(CNVSPPR$2, 0);
      if (cTNonVisualDrawingShapeProps == null)
        return null; 
      return cTNonVisualDrawingShapeProps;
    } 
  }
  
  public void setCNvSpPr(CTNonVisualDrawingShapeProps paramCTNonVisualDrawingShapeProps) {
    synchronized (monitor()) {
      check_orphaned();
      CTNonVisualDrawingShapeProps cTNonVisualDrawingShapeProps = null;
      cTNonVisualDrawingShapeProps = (CTNonVisualDrawingShapeProps)get_store().find_element_user(CNVSPPR$2, 0);
      if (cTNonVisualDrawingShapeProps == null)
        cTNonVisualDrawingShapeProps = (CTNonVisualDrawingShapeProps)get_store().add_element_user(CNVSPPR$2); 
      cTNonVisualDrawingShapeProps.set((XmlObject)paramCTNonVisualDrawingShapeProps);
    } 
  }
  
  public CTNonVisualDrawingShapeProps addNewCNvSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTNonVisualDrawingShapeProps cTNonVisualDrawingShapeProps = null;
      cTNonVisualDrawingShapeProps = (CTNonVisualDrawingShapeProps)get_store().add_element_user(CNVSPPR$2);
      return cTNonVisualDrawingShapeProps;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\spreadsheetDrawing\impl\CTShapeNonVisualImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */