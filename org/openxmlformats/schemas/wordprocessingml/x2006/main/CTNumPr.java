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

public interface CTNumPr extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTNumPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctnumpr16aatype");
  
  CTDecimalNumber getIlvl();
  
  boolean isSetIlvl();
  
  void setIlvl(CTDecimalNumber paramCTDecimalNumber);
  
  CTDecimalNumber addNewIlvl();
  
  void unsetIlvl();
  
  CTDecimalNumber getNumId();
  
  boolean isSetNumId();
  
  void setNumId(CTDecimalNumber paramCTDecimalNumber);
  
  CTDecimalNumber addNewNumId();
  
  void unsetNumId();
  
  CTTrackChangeNumbering getNumberingChange();
  
  boolean isSetNumberingChange();
  
  void setNumberingChange(CTTrackChangeNumbering paramCTTrackChangeNumbering);
  
  CTTrackChangeNumbering addNewNumberingChange();
  
  void unsetNumberingChange();
  
  CTTrackChange getIns();
  
  boolean isSetIns();
  
  void setIns(CTTrackChange paramCTTrackChange);
  
  CTTrackChange addNewIns();
  
  void unsetIns();
  
  public static final class Factory {
    public static CTNumPr newInstance() {
      return (CTNumPr)POIXMLTypeLoader.newInstance(CTNumPr.type, null);
    }
    
    public static CTNumPr newInstance(XmlOptions param1XmlOptions) {
      return (CTNumPr)POIXMLTypeLoader.newInstance(CTNumPr.type, param1XmlOptions);
    }
    
    public static CTNumPr parse(String param1String) throws XmlException {
      return (CTNumPr)POIXMLTypeLoader.parse(param1String, CTNumPr.type, null);
    }
    
    public static CTNumPr parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNumPr)POIXMLTypeLoader.parse(param1String, CTNumPr.type, param1XmlOptions);
    }
    
    public static CTNumPr parse(File param1File) throws XmlException, IOException {
      return (CTNumPr)POIXMLTypeLoader.parse(param1File, CTNumPr.type, null);
    }
    
    public static CTNumPr parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNumPr)POIXMLTypeLoader.parse(param1File, CTNumPr.type, param1XmlOptions);
    }
    
    public static CTNumPr parse(URL param1URL) throws XmlException, IOException {
      return (CTNumPr)POIXMLTypeLoader.parse(param1URL, CTNumPr.type, null);
    }
    
    public static CTNumPr parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNumPr)POIXMLTypeLoader.parse(param1URL, CTNumPr.type, param1XmlOptions);
    }
    
    public static CTNumPr parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTNumPr)POIXMLTypeLoader.parse(param1InputStream, CTNumPr.type, null);
    }
    
    public static CTNumPr parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNumPr)POIXMLTypeLoader.parse(param1InputStream, CTNumPr.type, param1XmlOptions);
    }
    
    public static CTNumPr parse(Reader param1Reader) throws XmlException, IOException {
      return (CTNumPr)POIXMLTypeLoader.parse(param1Reader, CTNumPr.type, null);
    }
    
    public static CTNumPr parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNumPr)POIXMLTypeLoader.parse(param1Reader, CTNumPr.type, param1XmlOptions);
    }
    
    public static CTNumPr parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTNumPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNumPr.type, null);
    }
    
    public static CTNumPr parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNumPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNumPr.type, param1XmlOptions);
    }
    
    public static CTNumPr parse(Node param1Node) throws XmlException {
      return (CTNumPr)POIXMLTypeLoader.parse(param1Node, CTNumPr.type, null);
    }
    
    public static CTNumPr parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNumPr)POIXMLTypeLoader.parse(param1Node, CTNumPr.type, param1XmlOptions);
    }
    
    public static CTNumPr parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTNumPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTNumPr.type, null);
    }
    
    public static CTNumPr parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTNumPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTNumPr.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNumPr.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNumPr.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTNumPr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */