package org.openxmlformats.schemas.officeDocument.x2006.customProperties;

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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTProperties extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctproperties2c18type");
  
  List<CTProperty> getPropertyList();
  
  CTProperty[] getPropertyArray();
  
  CTProperty getPropertyArray(int paramInt);
  
  int sizeOfPropertyArray();
  
  void setPropertyArray(CTProperty[] paramArrayOfCTProperty);
  
  void setPropertyArray(int paramInt, CTProperty paramCTProperty);
  
  CTProperty insertNewProperty(int paramInt);
  
  CTProperty addNewProperty();
  
  void removeProperty(int paramInt);
  
  public static final class Factory {
    public static CTProperties newInstance() {
      return (CTProperties)POIXMLTypeLoader.newInstance(CTProperties.type, null);
    }
    
    public static CTProperties newInstance(XmlOptions param1XmlOptions) {
      return (CTProperties)POIXMLTypeLoader.newInstance(CTProperties.type, param1XmlOptions);
    }
    
    public static CTProperties parse(String param1String) throws XmlException {
      return (CTProperties)POIXMLTypeLoader.parse(param1String, CTProperties.type, null);
    }
    
    public static CTProperties parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTProperties)POIXMLTypeLoader.parse(param1String, CTProperties.type, param1XmlOptions);
    }
    
    public static CTProperties parse(File param1File) throws XmlException, IOException {
      return (CTProperties)POIXMLTypeLoader.parse(param1File, CTProperties.type, null);
    }
    
    public static CTProperties parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTProperties)POIXMLTypeLoader.parse(param1File, CTProperties.type, param1XmlOptions);
    }
    
    public static CTProperties parse(URL param1URL) throws XmlException, IOException {
      return (CTProperties)POIXMLTypeLoader.parse(param1URL, CTProperties.type, null);
    }
    
    public static CTProperties parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTProperties)POIXMLTypeLoader.parse(param1URL, CTProperties.type, param1XmlOptions);
    }
    
    public static CTProperties parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTProperties)POIXMLTypeLoader.parse(param1InputStream, CTProperties.type, null);
    }
    
    public static CTProperties parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTProperties)POIXMLTypeLoader.parse(param1InputStream, CTProperties.type, param1XmlOptions);
    }
    
    public static CTProperties parse(Reader param1Reader) throws XmlException, IOException {
      return (CTProperties)POIXMLTypeLoader.parse(param1Reader, CTProperties.type, null);
    }
    
    public static CTProperties parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTProperties)POIXMLTypeLoader.parse(param1Reader, CTProperties.type, param1XmlOptions);
    }
    
    public static CTProperties parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTProperties.type, null);
    }
    
    public static CTProperties parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTProperties.type, param1XmlOptions);
    }
    
    public static CTProperties parse(Node param1Node) throws XmlException {
      return (CTProperties)POIXMLTypeLoader.parse(param1Node, CTProperties.type, null);
    }
    
    public static CTProperties parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTProperties)POIXMLTypeLoader.parse(param1Node, CTProperties.type, param1XmlOptions);
    }
    
    public static CTProperties parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTProperties.type, null);
    }
    
    public static CTProperties parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTProperties.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTProperties.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTProperties.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\officeDocument\x2006\customProperties\CTProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */