package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnectorNonVisual;

public class CTConnectorNonVisualImpl extends XmlComplexContentImpl implements CTConnectorNonVisual {
  private static final b CNVPR$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "cNvPr");
  
  private static final b CNVCXNSPPR$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "cNvCxnSpPr");
  
  public CTConnectorNonVisualImpl(SchemaType paramSchemaType) {
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
  
  public CTNonVisualConnectorProperties getCNvCxnSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTNonVisualConnectorProperties cTNonVisualConnectorProperties = null;
      cTNonVisualConnectorProperties = (CTNonVisualConnectorProperties)get_store().find_element_user(CNVCXNSPPR$2, 0);
      if (cTNonVisualConnectorProperties == null)
        return null; 
      return cTNonVisualConnectorProperties;
    } 
  }
  
  public void setCNvCxnSpPr(CTNonVisualConnectorProperties paramCTNonVisualConnectorProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTNonVisualConnectorProperties cTNonVisualConnectorProperties = null;
      cTNonVisualConnectorProperties = (CTNonVisualConnectorProperties)get_store().find_element_user(CNVCXNSPPR$2, 0);
      if (cTNonVisualConnectorProperties == null)
        cTNonVisualConnectorProperties = (CTNonVisualConnectorProperties)get_store().add_element_user(CNVCXNSPPR$2); 
      cTNonVisualConnectorProperties.set((XmlObject)paramCTNonVisualConnectorProperties);
    } 
  }
  
  public CTNonVisualConnectorProperties addNewCNvCxnSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTNonVisualConnectorProperties cTNonVisualConnectorProperties = null;
      cTNonVisualConnectorProperties = (CTNonVisualConnectorProperties)get_store().add_element_user(CNVCXNSPPR$2);
      return cTNonVisualConnectorProperties;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\spreadsheetDrawing\impl\CTConnectorNonVisualImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */