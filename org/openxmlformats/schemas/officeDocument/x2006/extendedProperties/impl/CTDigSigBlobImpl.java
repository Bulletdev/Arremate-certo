package org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTDigSigBlob;

public class CTDigSigBlobImpl extends XmlComplexContentImpl implements CTDigSigBlob {
  private static final b BLOB$0 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "blob");
  
  public CTDigSigBlobImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public byte[] getBlob() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(BLOB$0, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public XmlBase64Binary xgetBlob() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBase64Binary xmlBase64Binary = null;
      xmlBase64Binary = (XmlBase64Binary)get_store().find_element_user(BLOB$0, 0);
      return xmlBase64Binary;
    } 
  }
  
  public void setBlob(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(BLOB$0, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(BLOB$0); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetBlob(XmlBase64Binary paramXmlBase64Binary) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBase64Binary xmlBase64Binary = null;
      xmlBase64Binary = (XmlBase64Binary)get_store().find_element_user(BLOB$0, 0);
      if (xmlBase64Binary == null)
        xmlBase64Binary = (XmlBase64Binary)get_store().add_element_user(BLOB$0); 
      xmlBase64Binary.set((XmlObject)paramXmlBase64Binary);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\officeDocument\x2006\extendedProperties\impl\CTDigSigBlobImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */