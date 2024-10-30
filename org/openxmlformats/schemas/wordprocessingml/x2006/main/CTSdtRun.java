package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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

public interface CTSdtRun extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSdtRun.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsdtrun5c60type");
  
  CTSdtPr getSdtPr();
  
  boolean isSetSdtPr();
  
  void setSdtPr(CTSdtPr paramCTSdtPr);
  
  CTSdtPr addNewSdtPr();
  
  void unsetSdtPr();
  
  CTSdtEndPr getSdtEndPr();
  
  boolean isSetSdtEndPr();
  
  void setSdtEndPr(CTSdtEndPr paramCTSdtEndPr);
  
  CTSdtEndPr addNewSdtEndPr();
  
  void unsetSdtEndPr();
  
  CTSdtContentRun getSdtContent();
  
  boolean isSetSdtContent();
  
  void setSdtContent(CTSdtContentRun paramCTSdtContentRun);
  
  CTSdtContentRun addNewSdtContent();
  
  void unsetSdtContent();
  
  public static final class Factory {
    public static CTSdtRun newInstance() {
      return (CTSdtRun)POIXMLTypeLoader.newInstance(CTSdtRun.type, null);
    }
    
    public static CTSdtRun newInstance(XmlOptions param1XmlOptions) {
      return (CTSdtRun)POIXMLTypeLoader.newInstance(CTSdtRun.type, param1XmlOptions);
    }
    
    public static CTSdtRun parse(String param1String) throws XmlException {
      return (CTSdtRun)POIXMLTypeLoader.parse(param1String, CTSdtRun.type, null);
    }
    
    public static CTSdtRun parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSdtRun)POIXMLTypeLoader.parse(param1String, CTSdtRun.type, param1XmlOptions);
    }
    
    public static CTSdtRun parse(File param1File) throws XmlException, IOException {
      return (CTSdtRun)POIXMLTypeLoader.parse(param1File, CTSdtRun.type, null);
    }
    
    public static CTSdtRun parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSdtRun)POIXMLTypeLoader.parse(param1File, CTSdtRun.type, param1XmlOptions);
    }
    
    public static CTSdtRun parse(URL param1URL) throws XmlException, IOException {
      return (CTSdtRun)POIXMLTypeLoader.parse(param1URL, CTSdtRun.type, null);
    }
    
    public static CTSdtRun parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSdtRun)POIXMLTypeLoader.parse(param1URL, CTSdtRun.type, param1XmlOptions);
    }
    
    public static CTSdtRun parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSdtRun)POIXMLTypeLoader.parse(param1InputStream, CTSdtRun.type, null);
    }
    
    public static CTSdtRun parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSdtRun)POIXMLTypeLoader.parse(param1InputStream, CTSdtRun.type, param1XmlOptions);
    }
    
    public static CTSdtRun parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSdtRun)POIXMLTypeLoader.parse(param1Reader, CTSdtRun.type, null);
    }
    
    public static CTSdtRun parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSdtRun)POIXMLTypeLoader.parse(param1Reader, CTSdtRun.type, param1XmlOptions);
    }
    
    public static CTSdtRun parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSdtRun)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSdtRun.type, null);
    }
    
    public static CTSdtRun parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSdtRun)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSdtRun.type, param1XmlOptions);
    }
    
    public static CTSdtRun parse(Node param1Node) throws XmlException {
      return (CTSdtRun)POIXMLTypeLoader.parse(param1Node, CTSdtRun.type, null);
    }
    
    public static CTSdtRun parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSdtRun)POIXMLTypeLoader.parse(param1Node, CTSdtRun.type, param1XmlOptions);
    }
    
    public static CTSdtRun parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSdtRun)POIXMLTypeLoader.parse(param1XMLInputStream, CTSdtRun.type, null);
    }
    
    public static CTSdtRun parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSdtRun)POIXMLTypeLoader.parse(param1XMLInputStream, CTSdtRun.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSdtRun.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSdtRun.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTSdtRun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */