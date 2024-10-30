package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObjectData;

public class CTGraphicalObjectImpl extends XmlComplexContentImpl implements CTGraphicalObject {
  private static final b GRAPHICDATA$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "graphicData");
  
  public CTGraphicalObjectImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTGraphicalObjectData getGraphicData() {
    synchronized (monitor()) {
      check_orphaned();
      CTGraphicalObjectData cTGraphicalObjectData = null;
      cTGraphicalObjectData = (CTGraphicalObjectData)get_store().find_element_user(GRAPHICDATA$0, 0);
      if (cTGraphicalObjectData == null)
        return null; 
      return cTGraphicalObjectData;
    } 
  }
  
  public void setGraphicData(CTGraphicalObjectData paramCTGraphicalObjectData) {
    synchronized (monitor()) {
      check_orphaned();
      CTGraphicalObjectData cTGraphicalObjectData = null;
      cTGraphicalObjectData = (CTGraphicalObjectData)get_store().find_element_user(GRAPHICDATA$0, 0);
      if (cTGraphicalObjectData == null)
        cTGraphicalObjectData = (CTGraphicalObjectData)get_store().add_element_user(GRAPHICDATA$0); 
      cTGraphicalObjectData.set((XmlObject)paramCTGraphicalObjectData);
    } 
  }
  
  public CTGraphicalObjectData addNewGraphicData() {
    synchronized (monitor()) {
      check_orphaned();
      CTGraphicalObjectData cTGraphicalObjectData = null;
      cTGraphicalObjectData = (CTGraphicalObjectData)get_store().add_element_user(GRAPHICDATA$0);
      return cTGraphicalObjectData;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTGraphicalObjectImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */