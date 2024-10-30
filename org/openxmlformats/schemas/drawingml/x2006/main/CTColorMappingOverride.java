package org.openxmlformats.schemas.drawingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
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

public interface CTColorMappingOverride extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTColorMappingOverride.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcolormappingoverridea2b2type");
  
  CTEmptyElement getMasterClrMapping();
  
  boolean isSetMasterClrMapping();
  
  void setMasterClrMapping(CTEmptyElement paramCTEmptyElement);
  
  CTEmptyElement addNewMasterClrMapping();
  
  void unsetMasterClrMapping();
  
  CTColorMapping getOverrideClrMapping();
  
  boolean isSetOverrideClrMapping();
  
  void setOverrideClrMapping(CTColorMapping paramCTColorMapping);
  
  CTColorMapping addNewOverrideClrMapping();
  
  void unsetOverrideClrMapping();
  
  public static final class Factory {
    public static CTColorMappingOverride newInstance() {
      return (CTColorMappingOverride)POIXMLTypeLoader.newInstance(CTColorMappingOverride.type, null);
    }
    
    public static CTColorMappingOverride newInstance(XmlOptions param1XmlOptions) {
      return (CTColorMappingOverride)POIXMLTypeLoader.newInstance(CTColorMappingOverride.type, param1XmlOptions);
    }
    
    public static CTColorMappingOverride parse(String param1String) throws XmlException {
      return (CTColorMappingOverride)POIXMLTypeLoader.parse(param1String, CTColorMappingOverride.type, null);
    }
    
    public static CTColorMappingOverride parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTColorMappingOverride)POIXMLTypeLoader.parse(param1String, CTColorMappingOverride.type, param1XmlOptions);
    }
    
    public static CTColorMappingOverride parse(File param1File) throws XmlException, IOException {
      return (CTColorMappingOverride)POIXMLTypeLoader.parse(param1File, CTColorMappingOverride.type, null);
    }
    
    public static CTColorMappingOverride parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTColorMappingOverride)POIXMLTypeLoader.parse(param1File, CTColorMappingOverride.type, param1XmlOptions);
    }
    
    public static CTColorMappingOverride parse(URL param1URL) throws XmlException, IOException {
      return (CTColorMappingOverride)POIXMLTypeLoader.parse(param1URL, CTColorMappingOverride.type, null);
    }
    
    public static CTColorMappingOverride parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTColorMappingOverride)POIXMLTypeLoader.parse(param1URL, CTColorMappingOverride.type, param1XmlOptions);
    }
    
    public static CTColorMappingOverride parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTColorMappingOverride)POIXMLTypeLoader.parse(param1InputStream, CTColorMappingOverride.type, null);
    }
    
    public static CTColorMappingOverride parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTColorMappingOverride)POIXMLTypeLoader.parse(param1InputStream, CTColorMappingOverride.type, param1XmlOptions);
    }
    
    public static CTColorMappingOverride parse(Reader param1Reader) throws XmlException, IOException {
      return (CTColorMappingOverride)POIXMLTypeLoader.parse(param1Reader, CTColorMappingOverride.type, null);
    }
    
    public static CTColorMappingOverride parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTColorMappingOverride)POIXMLTypeLoader.parse(param1Reader, CTColorMappingOverride.type, param1XmlOptions);
    }
    
    public static CTColorMappingOverride parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTColorMappingOverride)POIXMLTypeLoader.parse(param1XMLStreamReader, CTColorMappingOverride.type, null);
    }
    
    public static CTColorMappingOverride parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTColorMappingOverride)POIXMLTypeLoader.parse(param1XMLStreamReader, CTColorMappingOverride.type, param1XmlOptions);
    }
    
    public static CTColorMappingOverride parse(Node param1Node) throws XmlException {
      return (CTColorMappingOverride)POIXMLTypeLoader.parse(param1Node, CTColorMappingOverride.type, null);
    }
    
    public static CTColorMappingOverride parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTColorMappingOverride)POIXMLTypeLoader.parse(param1Node, CTColorMappingOverride.type, param1XmlOptions);
    }
    
    public static CTColorMappingOverride parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTColorMappingOverride)POIXMLTypeLoader.parse(param1XMLInputStream, CTColorMappingOverride.type, null);
    }
    
    public static CTColorMappingOverride parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTColorMappingOverride)POIXMLTypeLoader.parse(param1XMLInputStream, CTColorMappingOverride.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTColorMappingOverride.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTColorMappingOverride.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTColorMappingOverride.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */