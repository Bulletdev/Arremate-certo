package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTConnection;
import org.openxmlformats.schemas.drawingml.x2006.main.STDrawingElementId;

public class CTConnectionImpl extends XmlComplexContentImpl implements CTConnection {
  private static final b ID$0 = new b("", "id");
  
  private static final b IDX$2 = new b("", "idx");
  
  public CTConnectionImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public long getId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$0);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STDrawingElementId xgetId() {
    synchronized (monitor()) {
      check_orphaned();
      STDrawingElementId sTDrawingElementId = null;
      sTDrawingElementId = (STDrawingElementId)get_store().find_attribute_user(ID$0);
      return sTDrawingElementId;
    } 
  }
  
  public void setId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ID$0); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetId(STDrawingElementId paramSTDrawingElementId) {
    synchronized (monitor()) {
      check_orphaned();
      STDrawingElementId sTDrawingElementId = null;
      sTDrawingElementId = (STDrawingElementId)get_store().find_attribute_user(ID$0);
      if (sTDrawingElementId == null)
        sTDrawingElementId = (STDrawingElementId)get_store().add_attribute_user(ID$0); 
      sTDrawingElementId.set((XmlObject)paramSTDrawingElementId);
    } 
  }
  
  public long getIdx() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(IDX$2);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetIdx() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(IDX$2);
      return xmlUnsignedInt;
    } 
  }
  
  public void setIdx(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(IDX$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(IDX$2); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetIdx(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(IDX$2);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(IDX$2); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTConnectionImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */