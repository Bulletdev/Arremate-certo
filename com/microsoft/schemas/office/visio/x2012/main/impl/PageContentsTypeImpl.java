package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.ConnectsType;
import com.microsoft.schemas.office.visio.x2012.main.PageContentsType;
import com.microsoft.schemas.office.visio.x2012.main.ShapesType;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class PageContentsTypeImpl extends XmlComplexContentImpl implements PageContentsType {
  private static final b SHAPES$0 = new b("http://schemas.microsoft.com/office/visio/2012/main", "Shapes");
  
  private static final b CONNECTS$2 = new b("http://schemas.microsoft.com/office/visio/2012/main", "Connects");
  
  public PageContentsTypeImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public ShapesType getShapes() {
    synchronized (monitor()) {
      check_orphaned();
      ShapesType shapesType = null;
      shapesType = (ShapesType)get_store().find_element_user(SHAPES$0, 0);
      if (shapesType == null)
        return null; 
      return shapesType;
    } 
  }
  
  public boolean isSetShapes() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SHAPES$0) != 0);
    } 
  }
  
  public void setShapes(ShapesType paramShapesType) {
    synchronized (monitor()) {
      check_orphaned();
      ShapesType shapesType = null;
      shapesType = (ShapesType)get_store().find_element_user(SHAPES$0, 0);
      if (shapesType == null)
        shapesType = (ShapesType)get_store().add_element_user(SHAPES$0); 
      shapesType.set((XmlObject)paramShapesType);
    } 
  }
  
  public ShapesType addNewShapes() {
    synchronized (monitor()) {
      check_orphaned();
      ShapesType shapesType = null;
      shapesType = (ShapesType)get_store().add_element_user(SHAPES$0);
      return shapesType;
    } 
  }
  
  public void unsetShapes() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SHAPES$0, 0);
    } 
  }
  
  public ConnectsType getConnects() {
    synchronized (monitor()) {
      check_orphaned();
      ConnectsType connectsType = null;
      connectsType = (ConnectsType)get_store().find_element_user(CONNECTS$2, 0);
      if (connectsType == null)
        return null; 
      return connectsType;
    } 
  }
  
  public boolean isSetConnects() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CONNECTS$2) != 0);
    } 
  }
  
  public void setConnects(ConnectsType paramConnectsType) {
    synchronized (monitor()) {
      check_orphaned();
      ConnectsType connectsType = null;
      connectsType = (ConnectsType)get_store().find_element_user(CONNECTS$2, 0);
      if (connectsType == null)
        connectsType = (ConnectsType)get_store().add_element_user(CONNECTS$2); 
      connectsType.set((XmlObject)paramConnectsType);
    } 
  }
  
  public ConnectsType addNewConnects() {
    synchronized (monitor()) {
      check_orphaned();
      ConnectsType connectsType = null;
      connectsType = (ConnectsType)get_store().add_element_user(CONNECTS$2);
      return connectsType;
    } 
  }
  
  public void unsetConnects() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CONNECTS$2, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\impl\PageContentsTypeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */