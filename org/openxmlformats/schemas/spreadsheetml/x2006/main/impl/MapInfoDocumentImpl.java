package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMapInfo;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.MapInfoDocument;

public class MapInfoDocumentImpl extends XmlComplexContentImpl implements MapInfoDocument {
  private static final b MAPINFO$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "MapInfo");
  
  public MapInfoDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTMapInfo getMapInfo() {
    synchronized (monitor()) {
      check_orphaned();
      CTMapInfo cTMapInfo = null;
      cTMapInfo = (CTMapInfo)get_store().find_element_user(MAPINFO$0, 0);
      if (cTMapInfo == null)
        return null; 
      return cTMapInfo;
    } 
  }
  
  public void setMapInfo(CTMapInfo paramCTMapInfo) {
    synchronized (monitor()) {
      check_orphaned();
      CTMapInfo cTMapInfo = null;
      cTMapInfo = (CTMapInfo)get_store().find_element_user(MAPINFO$0, 0);
      if (cTMapInfo == null)
        cTMapInfo = (CTMapInfo)get_store().add_element_user(MAPINFO$0); 
      cTMapInfo.set((XmlObject)paramCTMapInfo);
    } 
  }
  
  public CTMapInfo addNewMapInfo() {
    synchronized (monitor()) {
      check_orphaned();
      CTMapInfo cTMapInfo = null;
      cTMapInfo = (CTMapInfo)get_store().add_element_user(MAPINFO$0);
      return cTMapInfo;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\MapInfoDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */