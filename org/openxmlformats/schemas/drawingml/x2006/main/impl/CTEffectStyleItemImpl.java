package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleItem;
import org.openxmlformats.schemas.drawingml.x2006.main.CTScene3D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D;

public class CTEffectStyleItemImpl extends XmlComplexContentImpl implements CTEffectStyleItem {
  private static final b EFFECTLST$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "effectLst");
  
  private static final b EFFECTDAG$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "effectDag");
  
  private static final b SCENE3D$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "scene3d");
  
  private static final b SP3D$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "sp3d");
  
  public CTEffectStyleItemImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTEffectList getEffectLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectList cTEffectList = null;
      cTEffectList = (CTEffectList)get_store().find_element_user(EFFECTLST$0, 0);
      if (cTEffectList == null)
        return null; 
      return cTEffectList;
    } 
  }
  
  public boolean isSetEffectLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EFFECTLST$0) != 0);
    } 
  }
  
  public void setEffectLst(CTEffectList paramCTEffectList) {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectList cTEffectList = null;
      cTEffectList = (CTEffectList)get_store().find_element_user(EFFECTLST$0, 0);
      if (cTEffectList == null)
        cTEffectList = (CTEffectList)get_store().add_element_user(EFFECTLST$0); 
      cTEffectList.set((XmlObject)paramCTEffectList);
    } 
  }
  
  public CTEffectList addNewEffectLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectList cTEffectList = null;
      cTEffectList = (CTEffectList)get_store().add_element_user(EFFECTLST$0);
      return cTEffectList;
    } 
  }
  
  public void unsetEffectLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EFFECTLST$0, 0);
    } 
  }
  
  public CTEffectContainer getEffectDag() {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectContainer cTEffectContainer = null;
      cTEffectContainer = (CTEffectContainer)get_store().find_element_user(EFFECTDAG$2, 0);
      if (cTEffectContainer == null)
        return null; 
      return cTEffectContainer;
    } 
  }
  
  public boolean isSetEffectDag() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EFFECTDAG$2) != 0);
    } 
  }
  
  public void setEffectDag(CTEffectContainer paramCTEffectContainer) {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectContainer cTEffectContainer = null;
      cTEffectContainer = (CTEffectContainer)get_store().find_element_user(EFFECTDAG$2, 0);
      if (cTEffectContainer == null)
        cTEffectContainer = (CTEffectContainer)get_store().add_element_user(EFFECTDAG$2); 
      cTEffectContainer.set((XmlObject)paramCTEffectContainer);
    } 
  }
  
  public CTEffectContainer addNewEffectDag() {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectContainer cTEffectContainer = null;
      cTEffectContainer = (CTEffectContainer)get_store().add_element_user(EFFECTDAG$2);
      return cTEffectContainer;
    } 
  }
  
  public void unsetEffectDag() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EFFECTDAG$2, 0);
    } 
  }
  
  public CTScene3D getScene3D() {
    synchronized (monitor()) {
      check_orphaned();
      CTScene3D cTScene3D = null;
      cTScene3D = (CTScene3D)get_store().find_element_user(SCENE3D$4, 0);
      if (cTScene3D == null)
        return null; 
      return cTScene3D;
    } 
  }
  
  public boolean isSetScene3D() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SCENE3D$4) != 0);
    } 
  }
  
  public void setScene3D(CTScene3D paramCTScene3D) {
    synchronized (monitor()) {
      check_orphaned();
      CTScene3D cTScene3D = null;
      cTScene3D = (CTScene3D)get_store().find_element_user(SCENE3D$4, 0);
      if (cTScene3D == null)
        cTScene3D = (CTScene3D)get_store().add_element_user(SCENE3D$4); 
      cTScene3D.set((XmlObject)paramCTScene3D);
    } 
  }
  
  public CTScene3D addNewScene3D() {
    synchronized (monitor()) {
      check_orphaned();
      CTScene3D cTScene3D = null;
      cTScene3D = (CTScene3D)get_store().add_element_user(SCENE3D$4);
      return cTScene3D;
    } 
  }
  
  public void unsetScene3D() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SCENE3D$4, 0);
    } 
  }
  
  public CTShape3D getSp3D() {
    synchronized (monitor()) {
      check_orphaned();
      CTShape3D cTShape3D = null;
      cTShape3D = (CTShape3D)get_store().find_element_user(SP3D$6, 0);
      if (cTShape3D == null)
        return null; 
      return cTShape3D;
    } 
  }
  
  public boolean isSetSp3D() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SP3D$6) != 0);
    } 
  }
  
  public void setSp3D(CTShape3D paramCTShape3D) {
    synchronized (monitor()) {
      check_orphaned();
      CTShape3D cTShape3D = null;
      cTShape3D = (CTShape3D)get_store().find_element_user(SP3D$6, 0);
      if (cTShape3D == null)
        cTShape3D = (CTShape3D)get_store().add_element_user(SP3D$6); 
      cTShape3D.set((XmlObject)paramCTShape3D);
    } 
  }
  
  public CTShape3D addNewSp3D() {
    synchronized (monitor()) {
      check_orphaned();
      CTShape3D cTShape3D = null;
      cTShape3D = (CTShape3D)get_store().add_element_user(SP3D$6);
      return cTShape3D;
    } 
  }
  
  public void unsetSp3D() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SP3D$6, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTEffectStyleItemImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */