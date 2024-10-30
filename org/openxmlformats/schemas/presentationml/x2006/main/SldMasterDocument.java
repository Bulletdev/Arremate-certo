package org.openxmlformats.schemas.presentationml.x2006.main;

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

public interface SldMasterDocument extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(SldMasterDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sldmaster5156doctype");
  
  CTSlideMaster getSldMaster();
  
  void setSldMaster(CTSlideMaster paramCTSlideMaster);
  
  CTSlideMaster addNewSldMaster();
  
  public static final class Factory {
    public static SldMasterDocument newInstance() {
      return (SldMasterDocument)POIXMLTypeLoader.newInstance(SldMasterDocument.type, null);
    }
    
    public static SldMasterDocument newInstance(XmlOptions param1XmlOptions) {
      return (SldMasterDocument)POIXMLTypeLoader.newInstance(SldMasterDocument.type, param1XmlOptions);
    }
    
    public static SldMasterDocument parse(String param1String) throws XmlException {
      return (SldMasterDocument)POIXMLTypeLoader.parse(param1String, SldMasterDocument.type, null);
    }
    
    public static SldMasterDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (SldMasterDocument)POIXMLTypeLoader.parse(param1String, SldMasterDocument.type, param1XmlOptions);
    }
    
    public static SldMasterDocument parse(File param1File) throws XmlException, IOException {
      return (SldMasterDocument)POIXMLTypeLoader.parse(param1File, SldMasterDocument.type, null);
    }
    
    public static SldMasterDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SldMasterDocument)POIXMLTypeLoader.parse(param1File, SldMasterDocument.type, param1XmlOptions);
    }
    
    public static SldMasterDocument parse(URL param1URL) throws XmlException, IOException {
      return (SldMasterDocument)POIXMLTypeLoader.parse(param1URL, SldMasterDocument.type, null);
    }
    
    public static SldMasterDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SldMasterDocument)POIXMLTypeLoader.parse(param1URL, SldMasterDocument.type, param1XmlOptions);
    }
    
    public static SldMasterDocument parse(InputStream param1InputStream) throws XmlException, IOException {
      return (SldMasterDocument)POIXMLTypeLoader.parse(param1InputStream, SldMasterDocument.type, null);
    }
    
    public static SldMasterDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SldMasterDocument)POIXMLTypeLoader.parse(param1InputStream, SldMasterDocument.type, param1XmlOptions);
    }
    
    public static SldMasterDocument parse(Reader param1Reader) throws XmlException, IOException {
      return (SldMasterDocument)POIXMLTypeLoader.parse(param1Reader, SldMasterDocument.type, null);
    }
    
    public static SldMasterDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SldMasterDocument)POIXMLTypeLoader.parse(param1Reader, SldMasterDocument.type, param1XmlOptions);
    }
    
    public static SldMasterDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (SldMasterDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, SldMasterDocument.type, null);
    }
    
    public static SldMasterDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (SldMasterDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, SldMasterDocument.type, param1XmlOptions);
    }
    
    public static SldMasterDocument parse(Node param1Node) throws XmlException {
      return (SldMasterDocument)POIXMLTypeLoader.parse(param1Node, SldMasterDocument.type, null);
    }
    
    public static SldMasterDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (SldMasterDocument)POIXMLTypeLoader.parse(param1Node, SldMasterDocument.type, param1XmlOptions);
    }
    
    public static SldMasterDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (SldMasterDocument)POIXMLTypeLoader.parse(param1XMLInputStream, SldMasterDocument.type, null);
    }
    
    public static SldMasterDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (SldMasterDocument)POIXMLTypeLoader.parse(param1XMLInputStream, SldMasterDocument.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, SldMasterDocument.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, SldMasterDocument.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\SldMasterDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */