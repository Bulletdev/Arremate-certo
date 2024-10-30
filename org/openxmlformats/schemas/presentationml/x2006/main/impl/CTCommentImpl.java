package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import java.util.Calendar;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.presentationml.x2006.main.CTComment;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify;
import org.openxmlformats.schemas.presentationml.x2006.main.STIndex;

public class CTCommentImpl extends XmlComplexContentImpl implements CTComment {
  private static final b POS$0 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "pos");
  
  private static final b TEXT$2 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "text");
  
  private static final b EXTLST$4 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst");
  
  private static final b AUTHORID$6 = new b("", "authorId");
  
  private static final b DT$8 = new b("", "dt");
  
  private static final b IDX$10 = new b("", "idx");
  
  public CTCommentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTPoint2D getPos() {
    synchronized (monitor()) {
      check_orphaned();
      CTPoint2D cTPoint2D = null;
      cTPoint2D = (CTPoint2D)get_store().find_element_user(POS$0, 0);
      if (cTPoint2D == null)
        return null; 
      return cTPoint2D;
    } 
  }
  
  public void setPos(CTPoint2D paramCTPoint2D) {
    synchronized (monitor()) {
      check_orphaned();
      CTPoint2D cTPoint2D = null;
      cTPoint2D = (CTPoint2D)get_store().find_element_user(POS$0, 0);
      if (cTPoint2D == null)
        cTPoint2D = (CTPoint2D)get_store().add_element_user(POS$0); 
      cTPoint2D.set((XmlObject)paramCTPoint2D);
    } 
  }
  
  public CTPoint2D addNewPos() {
    synchronized (monitor()) {
      check_orphaned();
      CTPoint2D cTPoint2D = null;
      cTPoint2D = (CTPoint2D)get_store().add_element_user(POS$0);
      return cTPoint2D;
    } 
  }
  
  public String getText() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(TEXT$2, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetText() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(TEXT$2, 0);
      return xmlString;
    } 
  }
  
  public void setText(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(TEXT$2, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(TEXT$2); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetText(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(TEXT$2, 0);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_element_user(TEXT$2); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public CTExtensionListModify getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionListModify cTExtensionListModify = null;
      cTExtensionListModify = (CTExtensionListModify)get_store().find_element_user(EXTLST$4, 0);
      if (cTExtensionListModify == null)
        return null; 
      return cTExtensionListModify;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$4) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionListModify paramCTExtensionListModify) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionListModify cTExtensionListModify = null;
      cTExtensionListModify = (CTExtensionListModify)get_store().find_element_user(EXTLST$4, 0);
      if (cTExtensionListModify == null)
        cTExtensionListModify = (CTExtensionListModify)get_store().add_element_user(EXTLST$4); 
      cTExtensionListModify.set((XmlObject)paramCTExtensionListModify);
    } 
  }
  
  public CTExtensionListModify addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionListModify cTExtensionListModify = null;
      cTExtensionListModify = (CTExtensionListModify)get_store().add_element_user(EXTLST$4);
      return cTExtensionListModify;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$4, 0);
    } 
  }
  
  public long getAuthorId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(AUTHORID$6);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetAuthorId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(AUTHORID$6);
      return xmlUnsignedInt;
    } 
  }
  
  public void setAuthorId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(AUTHORID$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(AUTHORID$6); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetAuthorId(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(AUTHORID$6);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(AUTHORID$6); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public Calendar getDt() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DT$8);
      if (simpleValue == null)
        return null; 
      return simpleValue.getCalendarValue();
    } 
  }
  
  public XmlDateTime xgetDt() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDateTime xmlDateTime = null;
      xmlDateTime = (XmlDateTime)get_store().find_attribute_user(DT$8);
      return xmlDateTime;
    } 
  }
  
  public boolean isSetDt() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DT$8) != null);
    } 
  }
  
  public void setDt(Calendar paramCalendar) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DT$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DT$8); 
      simpleValue.setCalendarValue(paramCalendar);
    } 
  }
  
  public void xsetDt(XmlDateTime paramXmlDateTime) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDateTime xmlDateTime = null;
      xmlDateTime = (XmlDateTime)get_store().find_attribute_user(DT$8);
      if (xmlDateTime == null)
        xmlDateTime = (XmlDateTime)get_store().add_attribute_user(DT$8); 
      xmlDateTime.set((XmlObject)paramXmlDateTime);
    } 
  }
  
  public void unsetDt() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DT$8);
    } 
  }
  
  public long getIdx() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(IDX$10);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STIndex xgetIdx() {
    synchronized (monitor()) {
      check_orphaned();
      STIndex sTIndex = null;
      sTIndex = (STIndex)get_store().find_attribute_user(IDX$10);
      return sTIndex;
    } 
  }
  
  public void setIdx(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(IDX$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(IDX$10); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetIdx(STIndex paramSTIndex) {
    synchronized (monitor()) {
      check_orphaned();
      STIndex sTIndex = null;
      sTIndex = (STIndex)get_store().find_attribute_user(IDX$10);
      if (sTIndex == null)
        sTIndex = (STIndex)get_store().add_attribute_user(IDX$10); 
      sTIndex.set((XmlObject)paramSTIndex);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\impl\CTCommentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */