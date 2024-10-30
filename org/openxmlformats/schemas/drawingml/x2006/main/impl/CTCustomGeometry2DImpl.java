package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSiteList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuideList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomRect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DList;

public class CTCustomGeometry2DImpl extends XmlComplexContentImpl implements CTCustomGeometry2D {
  private static final b AVLST$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "avLst");
  
  private static final b GDLST$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "gdLst");
  
  private static final b AHLST$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "ahLst");
  
  private static final b CXNLST$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "cxnLst");
  
  private static final b RECT$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "rect");
  
  private static final b PATHLST$10 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "pathLst");
  
  public CTCustomGeometry2DImpl(SchemaType paramSchemaType) {
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
  
  public CTGeomGuideList getGdLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTGeomGuideList cTGeomGuideList = null;
      cTGeomGuideList = (CTGeomGuideList)get_store().find_element_user(GDLST$2, 0);
      if (cTGeomGuideList == null)
        return null; 
      return cTGeomGuideList;
    } 
  }
  
  public boolean isSetGdLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(GDLST$2) != 0);
    } 
  }
  
  public void setGdLst(CTGeomGuideList paramCTGeomGuideList) {
    synchronized (monitor()) {
      check_orphaned();
      CTGeomGuideList cTGeomGuideList = null;
      cTGeomGuideList = (CTGeomGuideList)get_store().find_element_user(GDLST$2, 0);
      if (cTGeomGuideList == null)
        cTGeomGuideList = (CTGeomGuideList)get_store().add_element_user(GDLST$2); 
      cTGeomGuideList.set((XmlObject)paramCTGeomGuideList);
    } 
  }
  
  public CTGeomGuideList addNewGdLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTGeomGuideList cTGeomGuideList = null;
      cTGeomGuideList = (CTGeomGuideList)get_store().add_element_user(GDLST$2);
      return cTGeomGuideList;
    } 
  }
  
  public void unsetGdLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GDLST$2, 0);
    } 
  }
  
  public CTAdjustHandleList getAhLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTAdjustHandleList cTAdjustHandleList = null;
      cTAdjustHandleList = (CTAdjustHandleList)get_store().find_element_user(AHLST$4, 0);
      if (cTAdjustHandleList == null)
        return null; 
      return cTAdjustHandleList;
    } 
  }
  
  public boolean isSetAhLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(AHLST$4) != 0);
    } 
  }
  
  public void setAhLst(CTAdjustHandleList paramCTAdjustHandleList) {
    synchronized (monitor()) {
      check_orphaned();
      CTAdjustHandleList cTAdjustHandleList = null;
      cTAdjustHandleList = (CTAdjustHandleList)get_store().find_element_user(AHLST$4, 0);
      if (cTAdjustHandleList == null)
        cTAdjustHandleList = (CTAdjustHandleList)get_store().add_element_user(AHLST$4); 
      cTAdjustHandleList.set((XmlObject)paramCTAdjustHandleList);
    } 
  }
  
  public CTAdjustHandleList addNewAhLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTAdjustHandleList cTAdjustHandleList = null;
      cTAdjustHandleList = (CTAdjustHandleList)get_store().add_element_user(AHLST$4);
      return cTAdjustHandleList;
    } 
  }
  
  public void unsetAhLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(AHLST$4, 0);
    } 
  }
  
  public CTConnectionSiteList getCxnLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTConnectionSiteList cTConnectionSiteList = null;
      cTConnectionSiteList = (CTConnectionSiteList)get_store().find_element_user(CXNLST$6, 0);
      if (cTConnectionSiteList == null)
        return null; 
      return cTConnectionSiteList;
    } 
  }
  
  public boolean isSetCxnLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CXNLST$6) != 0);
    } 
  }
  
  public void setCxnLst(CTConnectionSiteList paramCTConnectionSiteList) {
    synchronized (monitor()) {
      check_orphaned();
      CTConnectionSiteList cTConnectionSiteList = null;
      cTConnectionSiteList = (CTConnectionSiteList)get_store().find_element_user(CXNLST$6, 0);
      if (cTConnectionSiteList == null)
        cTConnectionSiteList = (CTConnectionSiteList)get_store().add_element_user(CXNLST$6); 
      cTConnectionSiteList.set((XmlObject)paramCTConnectionSiteList);
    } 
  }
  
  public CTConnectionSiteList addNewCxnLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTConnectionSiteList cTConnectionSiteList = null;
      cTConnectionSiteList = (CTConnectionSiteList)get_store().add_element_user(CXNLST$6);
      return cTConnectionSiteList;
    } 
  }
  
  public void unsetCxnLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CXNLST$6, 0);
    } 
  }
  
  public CTGeomRect getRect() {
    synchronized (monitor()) {
      check_orphaned();
      CTGeomRect cTGeomRect = null;
      cTGeomRect = (CTGeomRect)get_store().find_element_user(RECT$8, 0);
      if (cTGeomRect == null)
        return null; 
      return cTGeomRect;
    } 
  }
  
  public boolean isSetRect() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(RECT$8) != 0);
    } 
  }
  
  public void setRect(CTGeomRect paramCTGeomRect) {
    synchronized (monitor()) {
      check_orphaned();
      CTGeomRect cTGeomRect = null;
      cTGeomRect = (CTGeomRect)get_store().find_element_user(RECT$8, 0);
      if (cTGeomRect == null)
        cTGeomRect = (CTGeomRect)get_store().add_element_user(RECT$8); 
      cTGeomRect.set((XmlObject)paramCTGeomRect);
    } 
  }
  
  public CTGeomRect addNewRect() {
    synchronized (monitor()) {
      check_orphaned();
      CTGeomRect cTGeomRect = null;
      cTGeomRect = (CTGeomRect)get_store().add_element_user(RECT$8);
      return cTGeomRect;
    } 
  }
  
  public void unsetRect() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(RECT$8, 0);
    } 
  }
  
  public CTPath2DList getPathLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTPath2DList cTPath2DList = null;
      cTPath2DList = (CTPath2DList)get_store().find_element_user(PATHLST$10, 0);
      if (cTPath2DList == null)
        return null; 
      return cTPath2DList;
    } 
  }
  
  public void setPathLst(CTPath2DList paramCTPath2DList) {
    synchronized (monitor()) {
      check_orphaned();
      CTPath2DList cTPath2DList = null;
      cTPath2DList = (CTPath2DList)get_store().find_element_user(PATHLST$10, 0);
      if (cTPath2DList == null)
        cTPath2DList = (CTPath2DList)get_store().add_element_user(PATHLST$10); 
      cTPath2DList.set((XmlObject)paramCTPath2DList);
    } 
  }
  
  public CTPath2DList addNewPathLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTPath2DList cTPath2DList = null;
      cTPath2DList = (CTPath2DList)get_store().add_element_user(PATHLST$10);
      return cTPath2DList;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTCustomGeometry2DImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */