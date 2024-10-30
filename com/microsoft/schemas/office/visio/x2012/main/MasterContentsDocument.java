package com.microsoft.schemas.office.visio.x2012.main;

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

public interface MasterContentsDocument extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(MasterContentsDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("mastercontentscb9edoctype");
  
  PageContentsType getMasterContents();
  
  void setMasterContents(PageContentsType paramPageContentsType);
  
  PageContentsType addNewMasterContents();
  
  public static final class Factory {
    public static MasterContentsDocument newInstance() {
      return (MasterContentsDocument)POIXMLTypeLoader.newInstance(MasterContentsDocument.type, null);
    }
    
    public static MasterContentsDocument newInstance(XmlOptions param1XmlOptions) {
      return (MasterContentsDocument)POIXMLTypeLoader.newInstance(MasterContentsDocument.type, param1XmlOptions);
    }
    
    public static MasterContentsDocument parse(String param1String) throws XmlException {
      return (MasterContentsDocument)POIXMLTypeLoader.parse(param1String, MasterContentsDocument.type, null);
    }
    
    public static MasterContentsDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (MasterContentsDocument)POIXMLTypeLoader.parse(param1String, MasterContentsDocument.type, param1XmlOptions);
    }
    
    public static MasterContentsDocument parse(File param1File) throws XmlException, IOException {
      return (MasterContentsDocument)POIXMLTypeLoader.parse(param1File, MasterContentsDocument.type, null);
    }
    
    public static MasterContentsDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (MasterContentsDocument)POIXMLTypeLoader.parse(param1File, MasterContentsDocument.type, param1XmlOptions);
    }
    
    public static MasterContentsDocument parse(URL param1URL) throws XmlException, IOException {
      return (MasterContentsDocument)POIXMLTypeLoader.parse(param1URL, MasterContentsDocument.type, null);
    }
    
    public static MasterContentsDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (MasterContentsDocument)POIXMLTypeLoader.parse(param1URL, MasterContentsDocument.type, param1XmlOptions);
    }
    
    public static MasterContentsDocument parse(InputStream param1InputStream) throws XmlException, IOException {
      return (MasterContentsDocument)POIXMLTypeLoader.parse(param1InputStream, MasterContentsDocument.type, null);
    }
    
    public static MasterContentsDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (MasterContentsDocument)POIXMLTypeLoader.parse(param1InputStream, MasterContentsDocument.type, param1XmlOptions);
    }
    
    public static MasterContentsDocument parse(Reader param1Reader) throws XmlException, IOException {
      return (MasterContentsDocument)POIXMLTypeLoader.parse(param1Reader, MasterContentsDocument.type, null);
    }
    
    public static MasterContentsDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (MasterContentsDocument)POIXMLTypeLoader.parse(param1Reader, MasterContentsDocument.type, param1XmlOptions);
    }
    
    public static MasterContentsDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (MasterContentsDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, MasterContentsDocument.type, null);
    }
    
    public static MasterContentsDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (MasterContentsDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, MasterContentsDocument.type, param1XmlOptions);
    }
    
    public static MasterContentsDocument parse(Node param1Node) throws XmlException {
      return (MasterContentsDocument)POIXMLTypeLoader.parse(param1Node, MasterContentsDocument.type, null);
    }
    
    public static MasterContentsDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (MasterContentsDocument)POIXMLTypeLoader.parse(param1Node, MasterContentsDocument.type, param1XmlOptions);
    }
    
    public static MasterContentsDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (MasterContentsDocument)POIXMLTypeLoader.parse(param1XMLInputStream, MasterContentsDocument.type, null);
    }
    
    public static MasterContentsDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (MasterContentsDocument)POIXMLTypeLoader.parse(param1XMLInputStream, MasterContentsDocument.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, MasterContentsDocument.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, MasterContentsDocument.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\MasterContentsDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */