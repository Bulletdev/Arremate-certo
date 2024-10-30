package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ChartsheetDocument;

public class ChartsheetDocumentImpl extends XmlComplexContentImpl implements ChartsheetDocument {
  private static final b CHARTSHEET$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "chartsheet");
  
  public ChartsheetDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTChartsheet getChartsheet() {
    synchronized (monitor()) {
      check_orphaned();
      CTChartsheet cTChartsheet = null;
      cTChartsheet = (CTChartsheet)get_store().find_element_user(CHARTSHEET$0, 0);
      if (cTChartsheet == null)
        return null; 
      return cTChartsheet;
    } 
  }
  
  public void setChartsheet(CTChartsheet paramCTChartsheet) {
    synchronized (monitor()) {
      check_orphaned();
      CTChartsheet cTChartsheet = null;
      cTChartsheet = (CTChartsheet)get_store().find_element_user(CHARTSHEET$0, 0);
      if (cTChartsheet == null)
        cTChartsheet = (CTChartsheet)get_store().add_element_user(CHARTSHEET$0); 
      cTChartsheet.set((XmlObject)paramCTChartsheet);
    } 
  }
  
  public CTChartsheet addNewChartsheet() {
    synchronized (monitor()) {
      check_orphaned();
      CTChartsheet cTChartsheet = null;
      cTChartsheet = (CTChartsheet)get_store().add_element_user(CHARTSHEET$0);
      return cTChartsheet;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\ChartsheetDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */