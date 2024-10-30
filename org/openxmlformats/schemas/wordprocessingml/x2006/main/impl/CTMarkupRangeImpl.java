package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkupRange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDisplacedByCustomXml;

public class CTMarkupRangeImpl extends CTMarkupImpl implements CTMarkupRange {
  private static final b DISPLACEDBYCUSTOMXML$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "displacedByCustomXml");
  
  public CTMarkupRangeImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STDisplacedByCustomXml.Enum getDisplacedByCustomXml() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DISPLACEDBYCUSTOMXML$0);
      if (simpleValue == null)
        return null; 
      return (STDisplacedByCustomXml.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STDisplacedByCustomXml xgetDisplacedByCustomXml() {
    synchronized (monitor()) {
      check_orphaned();
      STDisplacedByCustomXml sTDisplacedByCustomXml = null;
      sTDisplacedByCustomXml = (STDisplacedByCustomXml)get_store().find_attribute_user(DISPLACEDBYCUSTOMXML$0);
      return sTDisplacedByCustomXml;
    } 
  }
  
  public boolean isSetDisplacedByCustomXml() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DISPLACEDBYCUSTOMXML$0) != null);
    } 
  }
  
  public void setDisplacedByCustomXml(STDisplacedByCustomXml.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DISPLACEDBYCUSTOMXML$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DISPLACEDBYCUSTOMXML$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetDisplacedByCustomXml(STDisplacedByCustomXml paramSTDisplacedByCustomXml) {
    synchronized (monitor()) {
      check_orphaned();
      STDisplacedByCustomXml sTDisplacedByCustomXml = null;
      sTDisplacedByCustomXml = (STDisplacedByCustomXml)get_store().find_attribute_user(DISPLACEDBYCUSTOMXML$0);
      if (sTDisplacedByCustomXml == null)
        sTDisplacedByCustomXml = (STDisplacedByCustomXml)get_store().add_attribute_user(DISPLACEDBYCUSTOMXML$0); 
      sTDisplacedByCustomXml.set((XmlObject)paramSTDisplacedByCustomXml);
    } 
  }
  
  public void unsetDisplacedByCustomXml() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DISPLACEDBYCUSTOMXML$0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTMarkupRangeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */