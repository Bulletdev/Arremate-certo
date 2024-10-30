package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DList;

public class CTPath2DListImpl extends XmlComplexContentImpl implements CTPath2DList {
  private static final b PATH$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "path");
  
  public CTPath2DListImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTPath2D> getPathList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPath2D>)new PathList(this);
    } 
  }
  
  public CTPath2D[] getPathArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(PATH$0, arrayList);
      CTPath2D[] arrayOfCTPath2D = new CTPath2D[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPath2D);
      return arrayOfCTPath2D;
    } 
  }
  
  public CTPath2D getPathArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPath2D cTPath2D = null;
      cTPath2D = (CTPath2D)get_store().find_element_user(PATH$0, paramInt);
      if (cTPath2D == null)
        throw new IndexOutOfBoundsException(); 
      return cTPath2D;
    } 
  }
  
  public int sizeOfPathArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(PATH$0);
    } 
  }
  
  public void setPathArray(CTPath2D[] paramArrayOfCTPath2D) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPath2D, PATH$0);
    } 
  }
  
  public void setPathArray(int paramInt, CTPath2D paramCTPath2D) {
    synchronized (monitor()) {
      check_orphaned();
      CTPath2D cTPath2D = null;
      cTPath2D = (CTPath2D)get_store().find_element_user(PATH$0, paramInt);
      if (cTPath2D == null)
        throw new IndexOutOfBoundsException(); 
      cTPath2D.set((XmlObject)paramCTPath2D);
    } 
  }
  
  public CTPath2D insertNewPath(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPath2D cTPath2D = null;
      cTPath2D = (CTPath2D)get_store().insert_element_user(PATH$0, paramInt);
      return cTPath2D;
    } 
  }
  
  public CTPath2D addNewPath() {
    synchronized (monitor()) {
      check_orphaned();
      CTPath2D cTPath2D = null;
      cTPath2D = (CTPath2D)get_store().add_element_user(PATH$0);
      return cTPath2D;
    } 
  }
  
  public void removePath(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PATH$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTPath2DListImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */