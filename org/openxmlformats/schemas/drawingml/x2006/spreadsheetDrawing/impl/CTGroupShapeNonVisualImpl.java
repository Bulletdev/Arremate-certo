package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGroupDrawingShapeProps;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShapeNonVisual;

public class CTGroupShapeNonVisualImpl extends XmlComplexContentImpl implements CTGroupShapeNonVisual {
  private static final b CNVPR$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "cNvPr");
  
  private static final b CNVGRPSPPR$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "cNvGrpSpPr");
  
  public CTGroupShapeNonVisualImpl(SchemaType paramSchemaType) {
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
  
  public CTNonVisualGroupDrawingShapeProps getCNvGrpSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTNonVisualGroupDrawingShapeProps cTNonVisualGroupDrawingShapeProps = null;
      cTNonVisualGroupDrawingShapeProps = (CTNonVisualGroupDrawingShapeProps)get_store().find_element_user(CNVGRPSPPR$2, 0);
      if (cTNonVisualGroupDrawingShapeProps == null)
        return null; 
      return cTNonVisualGroupDrawingShapeProps;
    } 
  }
  
  public void setCNvGrpSpPr(CTNonVisualGroupDrawingShapeProps paramCTNonVisualGroupDrawingShapeProps) {
    synchronized (monitor()) {
      check_orphaned();
      CTNonVisualGroupDrawingShapeProps cTNonVisualGroupDrawingShapeProps = null;
      cTNonVisualGroupDrawingShapeProps = (CTNonVisualGroupDrawingShapeProps)get_store().find_element_user(CNVGRPSPPR$2, 0);
      if (cTNonVisualGroupDrawingShapeProps == null)
        cTNonVisualGroupDrawingShapeProps = (CTNonVisualGroupDrawingShapeProps)get_store().add_element_user(CNVGRPSPPR$2); 
      cTNonVisualGroupDrawingShapeProps.set((XmlObject)paramCTNonVisualGroupDrawingShapeProps);
    } 
  }
  
  public CTNonVisualGroupDrawingShapeProps addNewCNvGrpSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTNonVisualGroupDrawingShapeProps cTNonVisualGroupDrawingShapeProps = null;
      cTNonVisualGroupDrawingShapeProps = (CTNonVisualGroupDrawingShapeProps)get_store().add_element_user(CNVGRPSPPR$2);
      return cTNonVisualGroupDrawingShapeProps;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\spreadsheetDrawing\impl\CTGroupShapeNonVisualImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */