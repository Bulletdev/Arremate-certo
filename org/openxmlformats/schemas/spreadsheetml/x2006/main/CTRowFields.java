package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTRowFields extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTRowFields.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctrowfields0312type");
  
  List<CTField> getFieldList();
  
  CTField[] getFieldArray();
  
  CTField getFieldArray(int paramInt);
  
  int sizeOfFieldArray();
  
  void setFieldArray(CTField[] paramArrayOfCTField);
  
  void setFieldArray(int paramInt, CTField paramCTField);
  
  CTField insertNewField(int paramInt);
  
  CTField addNewField();
  
  void removeField(int paramInt);
  
  long getCount();
  
  XmlUnsignedInt xgetCount();
  
  boolean isSetCount();
  
  void setCount(long paramLong);
  
  void xsetCount(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetCount();
  
  public static final class Factory {
    public static CTRowFields newInstance() {
      return (CTRowFields)POIXMLTypeLoader.newInstance(CTRowFields.type, null);
    }
    
    public static CTRowFields newInstance(XmlOptions param1XmlOptions) {
      return (CTRowFields)POIXMLTypeLoader.newInstance(CTRowFields.type, param1XmlOptions);
    }
    
    public static CTRowFields parse(String param1String) throws XmlException {
      return (CTRowFields)POIXMLTypeLoader.parse(param1String, CTRowFields.type, null);
    }
    
    public static CTRowFields parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRowFields)POIXMLTypeLoader.parse(param1String, CTRowFields.type, param1XmlOptions);
    }
    
    public static CTRowFields parse(File param1File) throws XmlException, IOException {
      return (CTRowFields)POIXMLTypeLoader.parse(param1File, CTRowFields.type, null);
    }
    
    public static CTRowFields parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRowFields)POIXMLTypeLoader.parse(param1File, CTRowFields.type, param1XmlOptions);
    }
    
    public static CTRowFields parse(URL param1URL) throws XmlException, IOException {
      return (CTRowFields)POIXMLTypeLoader.parse(param1URL, CTRowFields.type, null);
    }
    
    public static CTRowFields parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRowFields)POIXMLTypeLoader.parse(param1URL, CTRowFields.type, param1XmlOptions);
    }
    
    public static CTRowFields parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTRowFields)POIXMLTypeLoader.parse(param1InputStream, CTRowFields.type, null);
    }
    
    public static CTRowFields parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRowFields)POIXMLTypeLoader.parse(param1InputStream, CTRowFields.type, param1XmlOptions);
    }
    
    public static CTRowFields parse(Reader param1Reader) throws XmlException, IOException {
      return (CTRowFields)POIXMLTypeLoader.parse(param1Reader, CTRowFields.type, null);
    }
    
    public static CTRowFields parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRowFields)POIXMLTypeLoader.parse(param1Reader, CTRowFields.type, param1XmlOptions);
    }
    
    public static CTRowFields parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTRowFields)POIXMLTypeLoader.parse(param1XMLStreamReader, CTRowFields.type, null);
    }
    
    public static CTRowFields parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRowFields)POIXMLTypeLoader.parse(param1XMLStreamReader, CTRowFields.type, param1XmlOptions);
    }
    
    public static CTRowFields parse(Node param1Node) throws XmlException {
      return (CTRowFields)POIXMLTypeLoader.parse(param1Node, CTRowFields.type, null);
    }
    
    public static CTRowFields parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRowFields)POIXMLTypeLoader.parse(param1Node, CTRowFields.type, param1XmlOptions);
    }
    
    public static CTRowFields parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTRowFields)POIXMLTypeLoader.parse(param1XMLInputStream, CTRowFields.type, null);
    }
    
    public static CTRowFields parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTRowFields)POIXMLTypeLoader.parse(param1XMLInputStream, CTRowFields.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTRowFields.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTRowFields.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTRowFields.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */