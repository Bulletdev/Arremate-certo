package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.ShapeSheetType;
import com.microsoft.schemas.office.visio.x2012.main.ShapesType;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class ShapesTypeImpl extends XmlComplexContentImpl implements ShapesType {
  private static final b SHAPE$0 = new b("http://schemas.microsoft.com/office/visio/2012/main", "Shape");
  
  public ShapesTypeImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<ShapeSheetType> getShapeList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<ShapeSheetType>)new ShapeList(this);
    } 
  }
  
  public ShapeSheetType[] getShapeArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SHAPE$0, arrayList);
      ShapeSheetType[] arrayOfShapeSheetType = new ShapeSheetType[arrayList.size()];
      arrayList.toArray((Object[])arrayOfShapeSheetType);
      return arrayOfShapeSheetType;
    } 
  }
  
  public ShapeSheetType getShapeArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      ShapeSheetType shapeSheetType = null;
      shapeSheetType = (ShapeSheetType)get_store().find_element_user(SHAPE$0, paramInt);
      if (shapeSheetType == null)
        throw new IndexOutOfBoundsException(); 
      return shapeSheetType;
    } 
  }
  
  public int sizeOfShapeArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SHAPE$0);
    } 
  }
  
  public void setShapeArray(ShapeSheetType[] paramArrayOfShapeSheetType) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfShapeSheetType, SHAPE$0);
    } 
  }
  
  public void setShapeArray(int paramInt, ShapeSheetType paramShapeSheetType) {
    synchronized (monitor()) {
      check_orphaned();
      ShapeSheetType shapeSheetType = null;
      shapeSheetType = (ShapeSheetType)get_store().find_element_user(SHAPE$0, paramInt);
      if (shapeSheetType == null)
        throw new IndexOutOfBoundsException(); 
      shapeSheetType.set((XmlObject)paramShapeSheetType);
    } 
  }
  
  public ShapeSheetType insertNewShape(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      ShapeSheetType shapeSheetType = null;
      shapeSheetType = (ShapeSheetType)get_store().insert_element_user(SHAPE$0, paramInt);
      return shapeSheetType;
    } 
  }
  
  public ShapeSheetType addNewShape() {
    synchronized (monitor()) {
      check_orphaned();
      ShapeSheetType shapeSheetType = null;
      shapeSheetType = (ShapeSheetType)get_store().add_element_user(SHAPE$0);
      return shapeSheetType;
    } 
  }
  
  public void removeShape(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SHAPE$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\impl\ShapesTypeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */