package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomRect;
import org.openxmlformats.schemas.drawingml.x2006.main.STAdjCoordinate;

public class CTGeomRectImpl extends XmlComplexContentImpl implements CTGeomRect {
  private static final b L$0 = new b("", "l");
  
  private static final b T$2 = new b("", "t");
  
  private static final b R$4 = new b("", "r");
  
  private static final b B$6 = new b("", "b");
  
  public CTGeomRectImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public Object getL() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(L$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getObjectValue();
    } 
  }
  
  public STAdjCoordinate xgetL() {
    synchronized (monitor()) {
      check_orphaned();
      STAdjCoordinate sTAdjCoordinate = null;
      sTAdjCoordinate = (STAdjCoordinate)get_store().find_attribute_user(L$0);
      return sTAdjCoordinate;
    } 
  }
  
  public void setL(Object paramObject) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(L$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(L$0); 
      simpleValue.setObjectValue(paramObject);
    } 
  }
  
  public void xsetL(STAdjCoordinate paramSTAdjCoordinate) {
    synchronized (monitor()) {
      check_orphaned();
      STAdjCoordinate sTAdjCoordinate = null;
      sTAdjCoordinate = (STAdjCoordinate)get_store().find_attribute_user(L$0);
      if (sTAdjCoordinate == null)
        sTAdjCoordinate = (STAdjCoordinate)get_store().add_attribute_user(L$0); 
      sTAdjCoordinate.set((XmlObject)paramSTAdjCoordinate);
    } 
  }
  
  public Object getT() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(T$2);
      if (simpleValue == null)
        return null; 
      return simpleValue.getObjectValue();
    } 
  }
  
  public STAdjCoordinate xgetT() {
    synchronized (monitor()) {
      check_orphaned();
      STAdjCoordinate sTAdjCoordinate = null;
      sTAdjCoordinate = (STAdjCoordinate)get_store().find_attribute_user(T$2);
      return sTAdjCoordinate;
    } 
  }
  
  public void setT(Object paramObject) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(T$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(T$2); 
      simpleValue.setObjectValue(paramObject);
    } 
  }
  
  public void xsetT(STAdjCoordinate paramSTAdjCoordinate) {
    synchronized (monitor()) {
      check_orphaned();
      STAdjCoordinate sTAdjCoordinate = null;
      sTAdjCoordinate = (STAdjCoordinate)get_store().find_attribute_user(T$2);
      if (sTAdjCoordinate == null)
        sTAdjCoordinate = (STAdjCoordinate)get_store().add_attribute_user(T$2); 
      sTAdjCoordinate.set((XmlObject)paramSTAdjCoordinate);
    } 
  }
  
  public Object getR() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(R$4);
      if (simpleValue == null)
        return null; 
      return simpleValue.getObjectValue();
    } 
  }
  
  public STAdjCoordinate xgetR() {
    synchronized (monitor()) {
      check_orphaned();
      STAdjCoordinate sTAdjCoordinate = null;
      sTAdjCoordinate = (STAdjCoordinate)get_store().find_attribute_user(R$4);
      return sTAdjCoordinate;
    } 
  }
  
  public void setR(Object paramObject) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(R$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(R$4); 
      simpleValue.setObjectValue(paramObject);
    } 
  }
  
  public void xsetR(STAdjCoordinate paramSTAdjCoordinate) {
    synchronized (monitor()) {
      check_orphaned();
      STAdjCoordinate sTAdjCoordinate = null;
      sTAdjCoordinate = (STAdjCoordinate)get_store().find_attribute_user(R$4);
      if (sTAdjCoordinate == null)
        sTAdjCoordinate = (STAdjCoordinate)get_store().add_attribute_user(R$4); 
      sTAdjCoordinate.set((XmlObject)paramSTAdjCoordinate);
    } 
  }
  
  public Object getB() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(B$6);
      if (simpleValue == null)
        return null; 
      return simpleValue.getObjectValue();
    } 
  }
  
  public STAdjCoordinate xgetB() {
    synchronized (monitor()) {
      check_orphaned();
      STAdjCoordinate sTAdjCoordinate = null;
      sTAdjCoordinate = (STAdjCoordinate)get_store().find_attribute_user(B$6);
      return sTAdjCoordinate;
    } 
  }
  
  public void setB(Object paramObject) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(B$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(B$6); 
      simpleValue.setObjectValue(paramObject);
    } 
  }
  
  public void xsetB(STAdjCoordinate paramSTAdjCoordinate) {
    synchronized (monitor()) {
      check_orphaned();
      STAdjCoordinate sTAdjCoordinate = null;
      sTAdjCoordinate = (STAdjCoordinate)get_store().find_attribute_user(B$6);
      if (sTAdjCoordinate == null)
        sTAdjCoordinate = (STAdjCoordinate)get_store().add_attribute_user(B$6); 
      sTAdjCoordinate.set((XmlObject)paramSTAdjCoordinate);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTGeomRectImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */