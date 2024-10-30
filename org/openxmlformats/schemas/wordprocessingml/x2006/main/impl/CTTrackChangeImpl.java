package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.Calendar;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDateTime;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STString;

public class CTTrackChangeImpl extends CTMarkupImpl implements CTTrackChange {
  private static final b AUTHOR$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "author");
  
  private static final b DATE$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "date");
  
  public CTTrackChangeImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public String getAuthor() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(AUTHOR$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STString xgetAuthor() {
    synchronized (monitor()) {
      check_orphaned();
      STString sTString = null;
      sTString = (STString)get_store().find_attribute_user(AUTHOR$0);
      return sTString;
    } 
  }
  
  public void setAuthor(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(AUTHOR$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(AUTHOR$0); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetAuthor(STString paramSTString) {
    synchronized (monitor()) {
      check_orphaned();
      STString sTString = null;
      sTString = (STString)get_store().find_attribute_user(AUTHOR$0);
      if (sTString == null)
        sTString = (STString)get_store().add_attribute_user(AUTHOR$0); 
      sTString.set((XmlObject)paramSTString);
    } 
  }
  
  public Calendar getDate() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DATE$2);
      if (simpleValue == null)
        return null; 
      return simpleValue.getCalendarValue();
    } 
  }
  
  public STDateTime xgetDate() {
    synchronized (monitor()) {
      check_orphaned();
      STDateTime sTDateTime = null;
      sTDateTime = (STDateTime)get_store().find_attribute_user(DATE$2);
      return sTDateTime;
    } 
  }
  
  public boolean isSetDate() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DATE$2) != null);
    } 
  }
  
  public void setDate(Calendar paramCalendar) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DATE$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DATE$2); 
      simpleValue.setCalendarValue(paramCalendar);
    } 
  }
  
  public void xsetDate(STDateTime paramSTDateTime) {
    synchronized (monitor()) {
      check_orphaned();
      STDateTime sTDateTime = null;
      sTDateTime = (STDateTime)get_store().find_attribute_user(DATE$2);
      if (sTDateTime == null)
        sTDateTime = (STDateTime)get_store().add_attribute_user(DATE$2); 
      sTDateTime.set((XmlObject)paramSTDateTime);
    } 
  }
  
  public void unsetDate() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DATE$2);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTTrackChangeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */