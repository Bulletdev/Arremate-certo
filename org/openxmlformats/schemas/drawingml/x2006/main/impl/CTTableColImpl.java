package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableCol;
import org.openxmlformats.schemas.drawingml.x2006.main.STCoordinate;

public class CTTableColImpl extends XmlComplexContentImpl implements CTTableCol {
  private static final b EXTLST$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
  
  private static final b W$2 = new b("", "w");
  
  public CTTableColImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTOfficeArtExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$0, 0);
      if (cTOfficeArtExtensionList == null)
        return null; 
      return cTOfficeArtExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$0) != 0);
    } 
  }
  
  public void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$0, 0);
      if (cTOfficeArtExtensionList == null)
        cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$0); 
      cTOfficeArtExtensionList.set((XmlObject)paramCTOfficeArtExtensionList);
    } 
  }
  
  public CTOfficeArtExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$0);
      return cTOfficeArtExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$0, 0);
    } 
  }
  
  public long getW() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(W$2);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STCoordinate xgetW() {
    synchronized (monitor()) {
      check_orphaned();
      STCoordinate sTCoordinate = null;
      sTCoordinate = (STCoordinate)get_store().find_attribute_user(W$2);
      return sTCoordinate;
    } 
  }
  
  public void setW(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(W$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(W$2); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetW(STCoordinate paramSTCoordinate) {
    synchronized (monitor()) {
      check_orphaned();
      STCoordinate sTCoordinate = null;
      sTCoordinate = (STCoordinate)get_store().find_attribute_user(W$2);
      if (sTCoordinate == null)
        sTCoordinate = (STCoordinate)get_store().add_attribute_user(W$2); 
      sTCoordinate.set((XmlObject)paramSTCoordinate);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTTableColImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */