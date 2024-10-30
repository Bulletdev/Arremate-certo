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

public interface CTColFields extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTColFields.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcolfields9ab8type");
  
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
    public static CTColFields newInstance() {
      return (CTColFields)POIXMLTypeLoader.newInstance(CTColFields.type, null);
    }
    
    public static CTColFields newInstance(XmlOptions param1XmlOptions) {
      return (CTColFields)POIXMLTypeLoader.newInstance(CTColFields.type, param1XmlOptions);
    }
    
    public static CTColFields parse(String param1String) throws XmlException {
      return (CTColFields)POIXMLTypeLoader.parse(param1String, CTColFields.type, null);
    }
    
    public static CTColFields parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTColFields)POIXMLTypeLoader.parse(param1String, CTColFields.type, param1XmlOptions);
    }
    
    public static CTColFields parse(File param1File) throws XmlException, IOException {
      return (CTColFields)POIXMLTypeLoader.parse(param1File, CTColFields.type, null);
    }
    
    public static CTColFields parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTColFields)POIXMLTypeLoader.parse(param1File, CTColFields.type, param1XmlOptions);
    }
    
    public static CTColFields parse(URL param1URL) throws XmlException, IOException {
      return (CTColFields)POIXMLTypeLoader.parse(param1URL, CTColFields.type, null);
    }
    
    public static CTColFields parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTColFields)POIXMLTypeLoader.parse(param1URL, CTColFields.type, param1XmlOptions);
    }
    
    public static CTColFields parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTColFields)POIXMLTypeLoader.parse(param1InputStream, CTColFields.type, null);
    }
    
    public static CTColFields parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTColFields)POIXMLTypeLoader.parse(param1InputStream, CTColFields.type, param1XmlOptions);
    }
    
    public static CTColFields parse(Reader param1Reader) throws XmlException, IOException {
      return (CTColFields)POIXMLTypeLoader.parse(param1Reader, CTColFields.type, null);
    }
    
    public static CTColFields parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTColFields)POIXMLTypeLoader.parse(param1Reader, CTColFields.type, param1XmlOptions);
    }
    
    public static CTColFields parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTColFields)POIXMLTypeLoader.parse(param1XMLStreamReader, CTColFields.type, null);
    }
    
    public static CTColFields parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTColFields)POIXMLTypeLoader.parse(param1XMLStreamReader, CTColFields.type, param1XmlOptions);
    }
    
    public static CTColFields parse(Node param1Node) throws XmlException {
      return (CTColFields)POIXMLTypeLoader.parse(param1Node, CTColFields.type, null);
    }
    
    public static CTColFields parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTColFields)POIXMLTypeLoader.parse(param1Node, CTColFields.type, param1XmlOptions);
    }
    
    public static CTColFields parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTColFields)POIXMLTypeLoader.parse(param1XMLInputStream, CTColFields.type, null);
    }
    
    public static CTColFields parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTColFields)POIXMLTypeLoader.parse(param1XMLInputStream, CTColFields.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTColFields.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTColFields.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTColFields.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */