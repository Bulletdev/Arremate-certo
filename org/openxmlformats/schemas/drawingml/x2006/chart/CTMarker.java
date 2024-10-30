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
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.w3c.dom.Node;

public interface CTMarker extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTMarker.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctmarkera682type");
  
  CTMarkerStyle getSymbol();
  
  boolean isSetSymbol();
  
  void setSymbol(CTMarkerStyle paramCTMarkerStyle);
  
  CTMarkerStyle addNewSymbol();
  
  void unsetSymbol();
  
  CTMarkerSize getSize();
  
  boolean isSetSize();
  
  void setSize(CTMarkerSize paramCTMarkerSize);
  
  CTMarkerSize addNewSize();
  
  void unsetSize();
  
  CTShapeProperties getSpPr();
  
  boolean isSetSpPr();
  
  void setSpPr(CTShapeProperties paramCTShapeProperties);
  
  CTShapeProperties addNewSpPr();
  
  void unsetSpPr();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTMarker newInstance() {
      return (CTMarker)POIXMLTypeLoader.newInstance(CTMarker.type, null);
    }
    
    public static CTMarker newInstance(XmlOptions param1XmlOptions) {
      return (CTMarker)POIXMLTypeLoader.newInstance(CTMarker.type, param1XmlOptions);
    }
    
    public static CTMarker parse(String param1String) throws XmlException {
      return (CTMarker)POIXMLTypeLoader.parse(param1String, CTMarker.type, null);
    }
    
    public static CTMarker parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTMarker)POIXMLTypeLoader.parse(param1String, CTMarker.type, param1XmlOptions);
    }
    
    public static CTMarker parse(File param1File) throws XmlException, IOException {
      return (CTMarker)POIXMLTypeLoader.parse(param1File, CTMarker.type, null);
    }
    
    public static CTMarker parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTMarker)POIXMLTypeLoader.parse(param1File, CTMarker.type, param1XmlOptions);
    }
    
    public static CTMarker parse(URL param1URL) throws XmlException, IOException {
      return (CTMarker)POIXMLTypeLoader.parse(param1URL, CTMarker.type, null);
    }
    
    public static CTMarker parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTMarker)POIXMLTypeLoader.parse(param1URL, CTMarker.type, param1XmlOptions);
    }
    
    public static CTMarker parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTMarker)POIXMLTypeLoader.parse(param1InputStream, CTMarker.type, null);
    }
    
    public static CTMarker parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTMarker)POIXMLTypeLoader.parse(param1InputStream, CTMarker.type, param1XmlOptions);
    }
    
    public static CTMarker parse(Reader param1Reader) throws XmlException, IOException {
      return (CTMarker)POIXMLTypeLoader.parse(param1Reader, CTMarker.type, null);
    }
    
    public static CTMarker parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTMarker)POIXMLTypeLoader.parse(param1Reader, CTMarker.type, param1XmlOptions);
    }
    
    public static CTMarker parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTMarker)POIXMLTypeLoader.parse(param1XMLStreamReader, CTMarker.type, null);
    }
    
    public static CTMarker parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTMarker)POIXMLTypeLoader.parse(param1XMLStreamReader, CTMarker.type, param1XmlOptions);
    }
    
    public static CTMarker parse(Node param1Node) throws XmlException {
      return (CTMarker)POIXMLTypeLoader.parse(param1Node, CTMarker.type, null);
    }
    
    public static CTMarker parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTMarker)POIXMLTypeLoader.parse(param1Node, CTMarker.type, param1XmlOptions);
    }
    
    public static CTMarker parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTMarker)POIXMLTypeLoader.parse(param1XMLInputStream, CTMarker.type, null);
    }
    
    public static CTMarker parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTMarker)POIXMLTypeLoader.parse(param1XMLInputStream, CTMarker.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTMarker.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTMarker.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTMarker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */