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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTTrPr extends CTTrPrBase {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTrPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttrpr2848type");
  
  CTTrackChange getIns();
  
  boolean isSetIns();
  
  void setIns(CTTrackChange paramCTTrackChange);
  
  CTTrackChange addNewIns();
  
  void unsetIns();
  
  CTTrackChange getDel();
  
  boolean isSetDel();
  
  void setDel(CTTrackChange paramCTTrackChange);
  
  CTTrackChange addNewDel();
  
  void unsetDel();
  
  CTTrPrChange getTrPrChange();
  
  boolean isSetTrPrChange();
  
  void setTrPrChange(CTTrPrChange paramCTTrPrChange);
  
  CTTrPrChange addNewTrPrChange();
  
  void unsetTrPrChange();
  
  public static final class Factory {
    public static CTTrPr newInstance() {
      return (CTTrPr)POIXMLTypeLoader.newInstance(CTTrPr.type, null);
    }
    
    public static CTTrPr newInstance(XmlOptions param1XmlOptions) {
      return (CTTrPr)POIXMLTypeLoader.newInstance(CTTrPr.type, param1XmlOptions);
    }
    
    public static CTTrPr parse(String param1String) throws XmlException {
      return (CTTrPr)POIXMLTypeLoader.parse(param1String, CTTrPr.type, null);
    }
    
    public static CTTrPr parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTrPr)POIXMLTypeLoader.parse(param1String, CTTrPr.type, param1XmlOptions);
    }
    
    public static CTTrPr parse(File param1File) throws XmlException, IOException {
      return (CTTrPr)POIXMLTypeLoader.parse(param1File, CTTrPr.type, null);
    }
    
    public static CTTrPr parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTrPr)POIXMLTypeLoader.parse(param1File, CTTrPr.type, param1XmlOptions);
    }
    
    public static CTTrPr parse(URL param1URL) throws XmlException, IOException {
      return (CTTrPr)POIXMLTypeLoader.parse(param1URL, CTTrPr.type, null);
    }
    
    public static CTTrPr parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTrPr)POIXMLTypeLoader.parse(param1URL, CTTrPr.type, param1XmlOptions);
    }
    
    public static CTTrPr parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTrPr)POIXMLTypeLoader.parse(param1InputStream, CTTrPr.type, null);
    }
    
    public static CTTrPr parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTrPr)POIXMLTypeLoader.parse(param1InputStream, CTTrPr.type, param1XmlOptions);
    }
    
    public static CTTrPr parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTrPr)POIXMLTypeLoader.parse(param1Reader, CTTrPr.type, null);
    }
    
    public static CTTrPr parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTrPr)POIXMLTypeLoader.parse(param1Reader, CTTrPr.type, param1XmlOptions);
    }
    
    public static CTTrPr parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTrPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTrPr.type, null);
    }
    
    public static CTTrPr parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTrPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTrPr.type, param1XmlOptions);
    }
    
    public static CTTrPr parse(Node param1Node) throws XmlException {
      return (CTTrPr)POIXMLTypeLoader.parse(param1Node, CTTrPr.type, null);
    }
    
    public static CTTrPr parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTrPr)POIXMLTypeLoader.parse(param1Node, CTTrPr.type, param1XmlOptions);
    }
    
    public static CTTrPr parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTrPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTTrPr.type, null);
    }
    
    public static CTTrPr parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTrPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTTrPr.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTrPr.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTrPr.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTTrPr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */