package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGroupDrawingShapeProps;
import org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShapeNonVisual;

public class CTGroupShapeNonVisualImpl extends XmlComplexContentImpl implements CTGroupShapeNonVisual {
  private static final b CNVPR$0 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "cNvPr");
  
  private static final b CNVGRPSPPR$2 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "cNvGrpSpPr");
  
  private static final b NVPR$4 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "nvPr");
  
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
  
  public CTApplicationNonVisualDrawingProps getNvPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTApplicationNonVisualDrawingProps cTApplicationNonVisualDrawingProps = null;
      cTApplicationNonVisualDrawingProps = (CTApplicationNonVisualDrawingProps)get_store().find_element_user(NVPR$4, 0);
      if (cTApplicationNonVisualDrawingProps == null)
        return null; 
      return cTApplicationNonVisualDrawingProps;
    } 
  }
  
  public void setNvPr(CTApplicationNonVisualDrawingProps paramCTApplicationNonVisualDrawingProps) {
    synchronized (monitor()) {
      check_orphaned();
      CTApplicationNonVisualDrawingProps cTApplicationNonVisualDrawingProps = null;
      cTApplicationNonVisualDrawingProps = (CTApplicationNonVisualDrawingProps)get_store().find_element_user(NVPR$4, 0);
      if (cTApplicationNonVisualDrawingProps == null)
        cTApplicationNonVisualDrawingProps = (CTApplicationNonVisualDrawingProps)get_store().add_element_user(NVPR$4); 
      cTApplicationNonVisualDrawingProps.set((XmlObject)paramCTApplicationNonVisualDrawingProps);
    } 
  }
  
  public CTApplicationNonVisualDrawingProps addNewNvPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTApplicationNonVisualDrawingProps cTApplicationNonVisualDrawingProps = null;
      cTApplicationNonVisualDrawingProps = (CTApplicationNonVisualDrawingProps)get_store().add_element_user(NVPR$4);
      return cTApplicationNonVisualDrawingProps;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\impl\CTGroupShapeNonVisualImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */