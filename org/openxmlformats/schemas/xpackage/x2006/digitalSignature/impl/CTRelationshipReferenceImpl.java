package org.openxmlformats.schemas.xpackage.x2006.digitalSignature.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.JavaStringHolderEx;
import org.openxmlformats.schemas.xpackage.x2006.digitalSignature.CTRelationshipReference;

public class CTRelationshipReferenceImpl extends JavaStringHolderEx implements CTRelationshipReference {
  private static final b SOURCEID$0 = new b("", "SourceId");
  
  public CTRelationshipReferenceImpl(SchemaType paramSchemaType) {
    super(paramSchemaType, true);
  }
  
  protected CTRelationshipReferenceImpl(SchemaType paramSchemaType, boolean paramBoolean) {
    super(paramSchemaType, paramBoolean);
  }
  
  public String getSourceId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SOURCEID$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetSourceId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(SOURCEID$0);
      return xmlString;
    } 
  }
  
  public void setSourceId(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SOURCEID$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SOURCEID$0); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetSourceId(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(SOURCEID$0);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(SOURCEID$0); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\xpackage\x2006\digitalSignature\impl\CTRelationshipReferenceImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */