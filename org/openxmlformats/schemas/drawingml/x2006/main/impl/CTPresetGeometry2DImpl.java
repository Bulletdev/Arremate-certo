package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuideList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;

public class CTPresetGeometry2DImpl extends XmlComplexContentImpl implements CTPresetGeometry2D {
  private static final b AVLST$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "avLst");
  
  private static final b PRST$2 = new b("", "prst");
  
  public CTPresetGeometry2DImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTGeomGuideList getAvLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTGeomGuideList cTGeomGuideList = null;
      cTGeomGuideList = (CTGeomGuideList)get_store().find_element_user(AVLST$0, 0);
      if (cTGeomGuideList == null)
        return null; 
      return cTGeomGuideList;
    } 
  }
  
  public boolean isSetAvLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(AVLST$0) != 0);
    } 
  }
  
  public void setAvLst(CTGeomGuideList paramCTGeomGuideList) {
    synchronized (monitor()) {
      check_orphaned();
      CTGeomGuideList cTGeomGuideList = null;
      cTGeomGuideList = (CTGeomGuideList)get_store().find_element_user(AVLST$0, 0);
      if (cTGeomGuideList == null)
        cTGeomGuideList = (CTGeomGuideList)get_store().add_element_user(AVLST$0); 
      cTGeomGuideList.set((XmlObject)paramCTGeomGuideList);
    } 
  }
  
  public CTGeomGuideList addNewAvLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTGeomGuideList cTGeomGuideList = null;
      cTGeomGuideList = (CTGeomGuideList)get_store().add_element_user(AVLST$0);
      return cTGeomGuideList;
    } 
  }
  
  public void unsetAvLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(AVLST$0, 0);
    } 
  }
  
  public STShapeType.Enum getPrst() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PRST$2);
      if (simpleValue == null)
        return null; 
      return (STShapeType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STShapeType xgetPrst() {
    synchronized (monitor()) {
      check_orphaned();
      STShapeType sTShapeType = null;
      sTShapeType = (STShapeType)get_store().find_attribute_user(PRST$2);
      return sTShapeType;
    } 
  }
  
  public void setPrst(STShapeType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PRST$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PRST$2); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetPrst(STShapeType paramSTShapeType) {
    synchronized (monitor()) {
      check_orphaned();
      STShapeType sTShapeType = null;
      sTShapeType = (STShapeType)get_store().find_attribute_user(PRST$2);
      if (sTShapeType == null)
        sTShapeType = (STShapeType)get_store().add_attribute_user(PRST$2); 
      sTShapeType.set((XmlObject)paramSTShapeType);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTPresetGeometry2DImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */