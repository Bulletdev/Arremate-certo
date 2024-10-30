package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DClose;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DCubicBezierTo;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DLineTo;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DMoveTo;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DQuadBezierTo;
import org.openxmlformats.schemas.drawingml.x2006.main.STPathFillMode;
import org.openxmlformats.schemas.drawingml.x2006.main.STPositiveCoordinate;

public class CTPath2DImpl extends XmlComplexContentImpl implements CTPath2D {
  private static final b CLOSE$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "close");
  
  private static final b MOVETO$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "moveTo");
  
  private static final b LNTO$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "lnTo");
  
  private static final b ARCTO$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "arcTo");
  
  private static final b QUADBEZTO$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "quadBezTo");
  
  private static final b CUBICBEZTO$10 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "cubicBezTo");
  
  private static final b W$12 = new b("", "w");
  
  private static final b H$14 = new b("", "h");
  
  private static final b FILL$16 = new b("", "fill");
  
  private static final b STROKE$18 = new b("", "stroke");
  
  private static final b EXTRUSIONOK$20 = new b("", "extrusionOk");
  
  public CTPath2DImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTPath2DClose> getCloseList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPath2DClose>)new CloseList(this);
    } 
  }
  
  public CTPath2DClose[] getCloseArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CLOSE$0, arrayList);
      CTPath2DClose[] arrayOfCTPath2DClose = new CTPath2DClose[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPath2DClose);
      return arrayOfCTPath2DClose;
    } 
  }
  
  public CTPath2DClose getCloseArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPath2DClose cTPath2DClose = null;
      cTPath2DClose = (CTPath2DClose)get_store().find_element_user(CLOSE$0, paramInt);
      if (cTPath2DClose == null)
        throw new IndexOutOfBoundsException(); 
      return cTPath2DClose;
    } 
  }
  
  public int sizeOfCloseArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CLOSE$0);
    } 
  }
  
  public void setCloseArray(CTPath2DClose[] paramArrayOfCTPath2DClose) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPath2DClose, CLOSE$0);
    } 
  }
  
  public void setCloseArray(int paramInt, CTPath2DClose paramCTPath2DClose) {
    synchronized (monitor()) {
      check_orphaned();
      CTPath2DClose cTPath2DClose = null;
      cTPath2DClose = (CTPath2DClose)get_store().find_element_user(CLOSE$0, paramInt);
      if (cTPath2DClose == null)
        throw new IndexOutOfBoundsException(); 
      cTPath2DClose.set((XmlObject)paramCTPath2DClose);
    } 
  }
  
  public CTPath2DClose insertNewClose(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPath2DClose cTPath2DClose = null;
      cTPath2DClose = (CTPath2DClose)get_store().insert_element_user(CLOSE$0, paramInt);
      return cTPath2DClose;
    } 
  }
  
  public CTPath2DClose addNewClose() {
    synchronized (monitor()) {
      check_orphaned();
      CTPath2DClose cTPath2DClose = null;
      cTPath2DClose = (CTPath2DClose)get_store().add_element_user(CLOSE$0);
      return cTPath2DClose;
    } 
  }
  
  public void removeClose(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CLOSE$0, paramInt);
    } 
  }
  
  public List<CTPath2DMoveTo> getMoveToList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPath2DMoveTo>)new MoveToList(this);
    } 
  }
  
  public CTPath2DMoveTo[] getMoveToArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(MOVETO$2, arrayList);
      CTPath2DMoveTo[] arrayOfCTPath2DMoveTo = new CTPath2DMoveTo[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPath2DMoveTo);
      return arrayOfCTPath2DMoveTo;
    } 
  }
  
  public CTPath2DMoveTo getMoveToArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPath2DMoveTo cTPath2DMoveTo = null;
      cTPath2DMoveTo = (CTPath2DMoveTo)get_store().find_element_user(MOVETO$2, paramInt);
      if (cTPath2DMoveTo == null)
        throw new IndexOutOfBoundsException(); 
      return cTPath2DMoveTo;
    } 
  }
  
  public int sizeOfMoveToArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(MOVETO$2);
    } 
  }
  
  public void setMoveToArray(CTPath2DMoveTo[] paramArrayOfCTPath2DMoveTo) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPath2DMoveTo, MOVETO$2);
    } 
  }
  
  public void setMoveToArray(int paramInt, CTPath2DMoveTo paramCTPath2DMoveTo) {
    synchronized (monitor()) {
      check_orphaned();
      CTPath2DMoveTo cTPath2DMoveTo = null;
      cTPath2DMoveTo = (CTPath2DMoveTo)get_store().find_element_user(MOVETO$2, paramInt);
      if (cTPath2DMoveTo == null)
        throw new IndexOutOfBoundsException(); 
      cTPath2DMoveTo.set((XmlObject)paramCTPath2DMoveTo);
    } 
  }
  
  public CTPath2DMoveTo insertNewMoveTo(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPath2DMoveTo cTPath2DMoveTo = null;
      cTPath2DMoveTo = (CTPath2DMoveTo)get_store().insert_element_user(MOVETO$2, paramInt);
      return cTPath2DMoveTo;
    } 
  }
  
  public CTPath2DMoveTo addNewMoveTo() {
    synchronized (monitor()) {
      check_orphaned();
      CTPath2DMoveTo cTPath2DMoveTo = null;
      cTPath2DMoveTo = (CTPath2DMoveTo)get_store().add_element_user(MOVETO$2);
      return cTPath2DMoveTo;
    } 
  }
  
  public void removeMoveTo(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MOVETO$2, paramInt);
    } 
  }
  
  public List<CTPath2DLineTo> getLnToList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPath2DLineTo>)new LnToList(this);
    } 
  }
  
  public CTPath2DLineTo[] getLnToArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(LNTO$4, arrayList);
      CTPath2DLineTo[] arrayOfCTPath2DLineTo = new CTPath2DLineTo[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPath2DLineTo);
      return arrayOfCTPath2DLineTo;
    } 
  }
  
  public CTPath2DLineTo getLnToArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPath2DLineTo cTPath2DLineTo = null;
      cTPath2DLineTo = (CTPath2DLineTo)get_store().find_element_user(LNTO$4, paramInt);
      if (cTPath2DLineTo == null)
        throw new IndexOutOfBoundsException(); 
      return cTPath2DLineTo;
    } 
  }
  
  public int sizeOfLnToArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(LNTO$4);
    } 
  }
  
  public void setLnToArray(CTPath2DLineTo[] paramArrayOfCTPath2DLineTo) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPath2DLineTo, LNTO$4);
    } 
  }
  
  public void setLnToArray(int paramInt, CTPath2DLineTo paramCTPath2DLineTo) {
    synchronized (monitor()) {
      check_orphaned();
      CTPath2DLineTo cTPath2DLineTo = null;
      cTPath2DLineTo = (CTPath2DLineTo)get_store().find_element_user(LNTO$4, paramInt);
      if (cTPath2DLineTo == null)
        throw new IndexOutOfBoundsException(); 
      cTPath2DLineTo.set((XmlObject)paramCTPath2DLineTo);
    } 
  }
  
  public CTPath2DLineTo insertNewLnTo(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPath2DLineTo cTPath2DLineTo = null;
      cTPath2DLineTo = (CTPath2DLineTo)get_store().insert_element_user(LNTO$4, paramInt);
      return cTPath2DLineTo;
    } 
  }
  
  public CTPath2DLineTo addNewLnTo() {
    synchronized (monitor()) {
      check_orphaned();
      CTPath2DLineTo cTPath2DLineTo = null;
      cTPath2DLineTo = (CTPath2DLineTo)get_store().add_element_user(LNTO$4);
      return cTPath2DLineTo;
    } 
  }
  
  public void removeLnTo(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LNTO$4, paramInt);
    } 
  }
  
  public List<CTPath2DArcTo> getArcToList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPath2DArcTo>)new ArcToList(this);
    } 
  }
  
  public CTPath2DArcTo[] getArcToArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ARCTO$6, arrayList);
      CTPath2DArcTo[] arrayOfCTPath2DArcTo = new CTPath2DArcTo[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPath2DArcTo);
      return arrayOfCTPath2DArcTo;
    } 
  }
  
  public CTPath2DArcTo getArcToArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPath2DArcTo cTPath2DArcTo = null;
      cTPath2DArcTo = (CTPath2DArcTo)get_store().find_element_user(ARCTO$6, paramInt);
      if (cTPath2DArcTo == null)
        throw new IndexOutOfBoundsException(); 
      return cTPath2DArcTo;
    } 
  }
  
  public int sizeOfArcToArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ARCTO$6);
    } 
  }
  
  public void setArcToArray(CTPath2DArcTo[] paramArrayOfCTPath2DArcTo) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPath2DArcTo, ARCTO$6);
    } 
  }
  
  public void setArcToArray(int paramInt, CTPath2DArcTo paramCTPath2DArcTo) {
    synchronized (monitor()) {
      check_orphaned();
      CTPath2DArcTo cTPath2DArcTo = null;
      cTPath2DArcTo = (CTPath2DArcTo)get_store().find_element_user(ARCTO$6, paramInt);
      if (cTPath2DArcTo == null)
        throw new IndexOutOfBoundsException(); 
      cTPath2DArcTo.set((XmlObject)paramCTPath2DArcTo);
    } 
  }
  
  public CTPath2DArcTo insertNewArcTo(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPath2DArcTo cTPath2DArcTo = null;
      cTPath2DArcTo = (CTPath2DArcTo)get_store().insert_element_user(ARCTO$6, paramInt);
      return cTPath2DArcTo;
    } 
  }
  
  public CTPath2DArcTo addNewArcTo() {
    synchronized (monitor()) {
      check_orphaned();
      CTPath2DArcTo cTPath2DArcTo = null;
      cTPath2DArcTo = (CTPath2DArcTo)get_store().add_element_user(ARCTO$6);
      return cTPath2DArcTo;
    } 
  }
  
  public void removeArcTo(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ARCTO$6, paramInt);
    } 
  }
  
  public List<CTPath2DQuadBezierTo> getQuadBezToList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPath2DQuadBezierTo>)new QuadBezToList(this);
    } 
  }
  
  public CTPath2DQuadBezierTo[] getQuadBezToArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(QUADBEZTO$8, arrayList);
      CTPath2DQuadBezierTo[] arrayOfCTPath2DQuadBezierTo = new CTPath2DQuadBezierTo[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPath2DQuadBezierTo);
      return arrayOfCTPath2DQuadBezierTo;
    } 
  }
  
  public CTPath2DQuadBezierTo getQuadBezToArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPath2DQuadBezierTo cTPath2DQuadBezierTo = null;
      cTPath2DQuadBezierTo = (CTPath2DQuadBezierTo)get_store().find_element_user(QUADBEZTO$8, paramInt);
      if (cTPath2DQuadBezierTo == null)
        throw new IndexOutOfBoundsException(); 
      return cTPath2DQuadBezierTo;
    } 
  }
  
  public int sizeOfQuadBezToArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(QUADBEZTO$8);
    } 
  }
  
  public void setQuadBezToArray(CTPath2DQuadBezierTo[] paramArrayOfCTPath2DQuadBezierTo) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPath2DQuadBezierTo, QUADBEZTO$8);
    } 
  }
  
  public void setQuadBezToArray(int paramInt, CTPath2DQuadBezierTo paramCTPath2DQuadBezierTo) {
    synchronized (monitor()) {
      check_orphaned();
      CTPath2DQuadBezierTo cTPath2DQuadBezierTo = null;
      cTPath2DQuadBezierTo = (CTPath2DQuadBezierTo)get_store().find_element_user(QUADBEZTO$8, paramInt);
      if (cTPath2DQuadBezierTo == null)
        throw new IndexOutOfBoundsException(); 
      cTPath2DQuadBezierTo.set((XmlObject)paramCTPath2DQuadBezierTo);
    } 
  }
  
  public CTPath2DQuadBezierTo insertNewQuadBezTo(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPath2DQuadBezierTo cTPath2DQuadBezierTo = null;
      cTPath2DQuadBezierTo = (CTPath2DQuadBezierTo)get_store().insert_element_user(QUADBEZTO$8, paramInt);
      return cTPath2DQuadBezierTo;
    } 
  }
  
  public CTPath2DQuadBezierTo addNewQuadBezTo() {
    synchronized (monitor()) {
      check_orphaned();
      CTPath2DQuadBezierTo cTPath2DQuadBezierTo = null;
      cTPath2DQuadBezierTo = (CTPath2DQuadBezierTo)get_store().add_element_user(QUADBEZTO$8);
      return cTPath2DQuadBezierTo;
    } 
  }
  
  public void removeQuadBezTo(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(QUADBEZTO$8, paramInt);
    } 
  }
  
  public List<CTPath2DCubicBezierTo> getCubicBezToList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPath2DCubicBezierTo>)new CubicBezToList(this);
    } 
  }
  
  public CTPath2DCubicBezierTo[] getCubicBezToArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CUBICBEZTO$10, arrayList);
      CTPath2DCubicBezierTo[] arrayOfCTPath2DCubicBezierTo = new CTPath2DCubicBezierTo[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPath2DCubicBezierTo);
      return arrayOfCTPath2DCubicBezierTo;
    } 
  }
  
  public CTPath2DCubicBezierTo getCubicBezToArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPath2DCubicBezierTo cTPath2DCubicBezierTo = null;
      cTPath2DCubicBezierTo = (CTPath2DCubicBezierTo)get_store().find_element_user(CUBICBEZTO$10, paramInt);
      if (cTPath2DCubicBezierTo == null)
        throw new IndexOutOfBoundsException(); 
      return cTPath2DCubicBezierTo;
    } 
  }
  
  public int sizeOfCubicBezToArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CUBICBEZTO$10);
    } 
  }
  
  public void setCubicBezToArray(CTPath2DCubicBezierTo[] paramArrayOfCTPath2DCubicBezierTo) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPath2DCubicBezierTo, CUBICBEZTO$10);
    } 
  }
  
  public void setCubicBezToArray(int paramInt, CTPath2DCubicBezierTo paramCTPath2DCubicBezierTo) {
    synchronized (monitor()) {
      check_orphaned();
      CTPath2DCubicBezierTo cTPath2DCubicBezierTo = null;
      cTPath2DCubicBezierTo = (CTPath2DCubicBezierTo)get_store().find_element_user(CUBICBEZTO$10, paramInt);
      if (cTPath2DCubicBezierTo == null)
        throw new IndexOutOfBoundsException(); 
      cTPath2DCubicBezierTo.set((XmlObject)paramCTPath2DCubicBezierTo);
    } 
  }
  
  public CTPath2DCubicBezierTo insertNewCubicBezTo(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPath2DCubicBezierTo cTPath2DCubicBezierTo = null;
      cTPath2DCubicBezierTo = (CTPath2DCubicBezierTo)get_store().insert_element_user(CUBICBEZTO$10, paramInt);
      return cTPath2DCubicBezierTo;
    } 
  }
  
  public CTPath2DCubicBezierTo addNewCubicBezTo() {
    synchronized (monitor()) {
      check_orphaned();
      CTPath2DCubicBezierTo cTPath2DCubicBezierTo = null;
      cTPath2DCubicBezierTo = (CTPath2DCubicBezierTo)get_store().add_element_user(CUBICBEZTO$10);
      return cTPath2DCubicBezierTo;
    } 
  }
  
  public void removeCubicBezTo(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CUBICBEZTO$10, paramInt);
    } 
  }
  
  public long getW() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(W$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(W$12); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STPositiveCoordinate xgetW() {
    synchronized (monitor()) {
      check_orphaned();
      STPositiveCoordinate sTPositiveCoordinate = null;
      sTPositiveCoordinate = (STPositiveCoordinate)get_store().find_attribute_user(W$12);
      if (sTPositiveCoordinate == null)
        sTPositiveCoordinate = (STPositiveCoordinate)get_default_attribute_value(W$12); 
      return sTPositiveCoordinate;
    } 
  }
  
  public boolean isSetW() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(W$12) != null);
    } 
  }
  
  public void setW(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(W$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(W$12); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetW(STPositiveCoordinate paramSTPositiveCoordinate) {
    synchronized (monitor()) {
      check_orphaned();
      STPositiveCoordinate sTPositiveCoordinate = null;
      sTPositiveCoordinate = (STPositiveCoordinate)get_store().find_attribute_user(W$12);
      if (sTPositiveCoordinate == null)
        sTPositiveCoordinate = (STPositiveCoordinate)get_store().add_attribute_user(W$12); 
      sTPositiveCoordinate.set((XmlObject)paramSTPositiveCoordinate);
    } 
  }
  
  public void unsetW() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(W$12);
    } 
  }
  
  public long getH() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(H$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(H$14); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STPositiveCoordinate xgetH() {
    synchronized (monitor()) {
      check_orphaned();
      STPositiveCoordinate sTPositiveCoordinate = null;
      sTPositiveCoordinate = (STPositiveCoordinate)get_store().find_attribute_user(H$14);
      if (sTPositiveCoordinate == null)
        sTPositiveCoordinate = (STPositiveCoordinate)get_default_attribute_value(H$14); 
      return sTPositiveCoordinate;
    } 
  }
  
  public boolean isSetH() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(H$14) != null);
    } 
  }
  
  public void setH(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(H$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(H$14); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetH(STPositiveCoordinate paramSTPositiveCoordinate) {
    synchronized (monitor()) {
      check_orphaned();
      STPositiveCoordinate sTPositiveCoordinate = null;
      sTPositiveCoordinate = (STPositiveCoordinate)get_store().find_attribute_user(H$14);
      if (sTPositiveCoordinate == null)
        sTPositiveCoordinate = (STPositiveCoordinate)get_store().add_attribute_user(H$14); 
      sTPositiveCoordinate.set((XmlObject)paramSTPositiveCoordinate);
    } 
  }
  
  public void unsetH() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(H$14);
    } 
  }
  
  public STPathFillMode.Enum getFill() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FILL$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(FILL$16); 
      if (simpleValue == null)
        return null; 
      return (STPathFillMode.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STPathFillMode xgetFill() {
    synchronized (monitor()) {
      check_orphaned();
      STPathFillMode sTPathFillMode = null;
      sTPathFillMode = (STPathFillMode)get_store().find_attribute_user(FILL$16);
      if (sTPathFillMode == null)
        sTPathFillMode = (STPathFillMode)get_default_attribute_value(FILL$16); 
      return sTPathFillMode;
    } 
  }
  
  public boolean isSetFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FILL$16) != null);
    } 
  }
  
  public void setFill(STPathFillMode.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FILL$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FILL$16); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetFill(STPathFillMode paramSTPathFillMode) {
    synchronized (monitor()) {
      check_orphaned();
      STPathFillMode sTPathFillMode = null;
      sTPathFillMode = (STPathFillMode)get_store().find_attribute_user(FILL$16);
      if (sTPathFillMode == null)
        sTPathFillMode = (STPathFillMode)get_store().add_attribute_user(FILL$16); 
      sTPathFillMode.set((XmlObject)paramSTPathFillMode);
    } 
  }
  
  public void unsetFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FILL$16);
    } 
  }
  
  public boolean getStroke() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STROKE$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(STROKE$18); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetStroke() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(STROKE$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(STROKE$18); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetStroke() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(STROKE$18) != null);
    } 
  }
  
  public void setStroke(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STROKE$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(STROKE$18); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetStroke(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(STROKE$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(STROKE$18); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetStroke() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(STROKE$18);
    } 
  }
  
  public boolean getExtrusionOk() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(EXTRUSIONOK$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(EXTRUSIONOK$20); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetExtrusionOk() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(EXTRUSIONOK$20);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(EXTRUSIONOK$20); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetExtrusionOk() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(EXTRUSIONOK$20) != null);
    } 
  }
  
  public void setExtrusionOk(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(EXTRUSIONOK$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(EXTRUSIONOK$20); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetExtrusionOk(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(EXTRUSIONOK$20);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(EXTRUSIONOK$20); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetExtrusionOk() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(EXTRUSIONOK$20);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTPath2DImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */