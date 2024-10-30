package org.openxmlformats.schemas.drawingml.x2006.chart;

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

public interface CTPrintSettings extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPrintSettings.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctprintsettings61b6type");
  
  CTHeaderFooter getHeaderFooter();
  
  boolean isSetHeaderFooter();
  
  void setHeaderFooter(CTHeaderFooter paramCTHeaderFooter);
  
  CTHeaderFooter addNewHeaderFooter();
  
  void unsetHeaderFooter();
  
  CTPageMargins getPageMargins();
  
  boolean isSetPageMargins();
  
  void setPageMargins(CTPageMargins paramCTPageMargins);
  
  CTPageMargins addNewPageMargins();
  
  void unsetPageMargins();
  
  CTPageSetup getPageSetup();
  
  boolean isSetPageSetup();
  
  void setPageSetup(CTPageSetup paramCTPageSetup);
  
  CTPageSetup addNewPageSetup();
  
  void unsetPageSetup();
  
  CTRelId getLegacyDrawingHF();
  
  boolean isSetLegacyDrawingHF();
  
  void setLegacyDrawingHF(CTRelId paramCTRelId);
  
  CTRelId addNewLegacyDrawingHF();
  
  void unsetLegacyDrawingHF();
  
  public static final class Factory {
    public static CTPrintSettings newInstance() {
      return (CTPrintSettings)POIXMLTypeLoader.newInstance(CTPrintSettings.type, null);
    }
    
    public static CTPrintSettings newInstance(XmlOptions param1XmlOptions) {
      return (CTPrintSettings)POIXMLTypeLoader.newInstance(CTPrintSettings.type, param1XmlOptions);
    }
    
    public static CTPrintSettings parse(String param1String) throws XmlException {
      return (CTPrintSettings)POIXMLTypeLoader.parse(param1String, CTPrintSettings.type, null);
    }
    
    public static CTPrintSettings parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPrintSettings)POIXMLTypeLoader.parse(param1String, CTPrintSettings.type, param1XmlOptions);
    }
    
    public static CTPrintSettings parse(File param1File) throws XmlException, IOException {
      return (CTPrintSettings)POIXMLTypeLoader.parse(param1File, CTPrintSettings.type, null);
    }
    
    public static CTPrintSettings parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPrintSettings)POIXMLTypeLoader.parse(param1File, CTPrintSettings.type, param1XmlOptions);
    }
    
    public static CTPrintSettings parse(URL param1URL) throws XmlException, IOException {
      return (CTPrintSettings)POIXMLTypeLoader.parse(param1URL, CTPrintSettings.type, null);
    }
    
    public static CTPrintSettings parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPrintSettings)POIXMLTypeLoader.parse(param1URL, CTPrintSettings.type, param1XmlOptions);
    }
    
    public static CTPrintSettings parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPrintSettings)POIXMLTypeLoader.parse(param1InputStream, CTPrintSettings.type, null);
    }
    
    public static CTPrintSettings parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPrintSettings)POIXMLTypeLoader.parse(param1InputStream, CTPrintSettings.type, param1XmlOptions);
    }
    
    public static CTPrintSettings parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPrintSettings)POIXMLTypeLoader.parse(param1Reader, CTPrintSettings.type, null);
    }
    
    public static CTPrintSettings parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPrintSettings)POIXMLTypeLoader.parse(param1Reader, CTPrintSettings.type, param1XmlOptions);
    }
    
    public static CTPrintSettings parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPrintSettings)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPrintSettings.type, null);
    }
    
    public static CTPrintSettings parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPrintSettings)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPrintSettings.type, param1XmlOptions);
    }
    
    public static CTPrintSettings parse(Node param1Node) throws XmlException {
      return (CTPrintSettings)POIXMLTypeLoader.parse(param1Node, CTPrintSettings.type, null);
    }
    
    public static CTPrintSettings parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPrintSettings)POIXMLTypeLoader.parse(param1Node, CTPrintSettings.type, param1XmlOptions);
    }
    
    public static CTPrintSettings parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPrintSettings)POIXMLTypeLoader.parse(param1XMLInputStream, CTPrintSettings.type, null);
    }
    
    public static CTPrintSettings parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPrintSettings)POIXMLTypeLoader.parse(param1XMLInputStream, CTPrintSettings.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPrintSettings.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPrintSettings.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTPrintSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */