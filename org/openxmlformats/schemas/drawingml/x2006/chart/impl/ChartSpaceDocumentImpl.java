package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChartSpace;
import org.openxmlformats.schemas.drawingml.x2006.chart.ChartSpaceDocument;

public class ChartSpaceDocumentImpl extends XmlComplexContentImpl implements ChartSpaceDocument {
  private static final b CHARTSPACE$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "chartSpace");
  
  public ChartSpaceDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTChartSpace getChartSpace() {
    synchronized (monitor()) {
      check_orphaned();
      CTChartSpace cTChartSpace = null;
      cTChartSpace = (CTChartSpace)get_store().find_element_user(CHARTSPACE$0, 0);
      if (cTChartSpace == null)
        return null; 
      return cTChartSpace;
    } 
  }
  
  public void setChartSpace(CTChartSpace paramCTChartSpace) {
    synchronized (monitor()) {
      check_orphaned();
      CTChartSpace cTChartSpace = null;
      cTChartSpace = (CTChartSpace)get_store().find_element_user(CHARTSPACE$0, 0);
      if (cTChartSpace == null)
        cTChartSpace = (CTChartSpace)get_store().add_element_user(CHARTSPACE$0); 
      cTChartSpace.set((XmlObject)paramCTChartSpace);
    } 
  }
  
  public CTChartSpace addNewChartSpace() {
    synchronized (monitor()) {
      check_orphaned();
      CTChartSpace cTChartSpace = null;
      cTChartSpace = (CTChartSpace)get_store().add_element_user(CHARTSPACE$0);
      return cTChartSpace;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\ChartSpaceDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */