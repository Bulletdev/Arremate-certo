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

public interface CTManualLayout extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTManualLayout.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctmanuallayout872ctype");
  
  CTLayoutTarget getLayoutTarget();
  
  boolean isSetLayoutTarget();
  
  void setLayoutTarget(CTLayoutTarget paramCTLayoutTarget);
  
  CTLayoutTarget addNewLayoutTarget();
  
  void unsetLayoutTarget();
  
  CTLayoutMode getXMode();
  
  boolean isSetXMode();
  
  void setXMode(CTLayoutMode paramCTLayoutMode);
  
  CTLayoutMode addNewXMode();
  
  void unsetXMode();
  
  CTLayoutMode getYMode();
  
  boolean isSetYMode();
  
  void setYMode(CTLayoutMode paramCTLayoutMode);
  
  CTLayoutMode addNewYMode();
  
  void unsetYMode();
  
  CTLayoutMode getWMode();
  
  boolean isSetWMode();
  
  void setWMode(CTLayoutMode paramCTLayoutMode);
  
  CTLayoutMode addNewWMode();
  
  void unsetWMode();
  
  CTLayoutMode getHMode();
  
  boolean isSetHMode();
  
  void setHMode(CTLayoutMode paramCTLayoutMode);
  
  CTLayoutMode addNewHMode();
  
  void unsetHMode();
  
  CTDouble getX();
  
  boolean isSetX();
  
  void setX(CTDouble paramCTDouble);
  
  CTDouble addNewX();
  
  void unsetX();
  
  CTDouble getY();
  
  boolean isSetY();
  
  void setY(CTDouble paramCTDouble);
  
  CTDouble addNewY();
  
  void unsetY();
  
  CTDouble getW();
  
  boolean isSetW();
  
  void setW(CTDouble paramCTDouble);
  
  CTDouble addNewW();
  
  void unsetW();
  
  CTDouble getH();
  
  boolean isSetH();
  
  void setH(CTDouble paramCTDouble);
  
  CTDouble addNewH();
  
  void unsetH();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTManualLayout newInstance() {
      return (CTManualLayout)POIXMLTypeLoader.newInstance(CTManualLayout.type, null);
    }
    
    public static CTManualLayout newInstance(XmlOptions param1XmlOptions) {
      return (CTManualLayout)POIXMLTypeLoader.newInstance(CTManualLayout.type, param1XmlOptions);
    }
    
    public static CTManualLayout parse(String param1String) throws XmlException {
      return (CTManualLayout)POIXMLTypeLoader.parse(param1String, CTManualLayout.type, null);
    }
    
    public static CTManualLayout parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTManualLayout)POIXMLTypeLoader.parse(param1String, CTManualLayout.type, param1XmlOptions);
    }
    
    public static CTManualLayout parse(File param1File) throws XmlException, IOException {
      return (CTManualLayout)POIXMLTypeLoader.parse(param1File, CTManualLayout.type, null);
    }
    
    public static CTManualLayout parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTManualLayout)POIXMLTypeLoader.parse(param1File, CTManualLayout.type, param1XmlOptions);
    }
    
    public static CTManualLayout parse(URL param1URL) throws XmlException, IOException {
      return (CTManualLayout)POIXMLTypeLoader.parse(param1URL, CTManualLayout.type, null);
    }
    
    public static CTManualLayout parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTManualLayout)POIXMLTypeLoader.parse(param1URL, CTManualLayout.type, param1XmlOptions);
    }
    
    public static CTManualLayout parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTManualLayout)POIXMLTypeLoader.parse(param1InputStream, CTManualLayout.type, null);
    }
    
    public static CTManualLayout parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTManualLayout)POIXMLTypeLoader.parse(param1InputStream, CTManualLayout.type, param1XmlOptions);
    }
    
    public static CTManualLayout parse(Reader param1Reader) throws XmlException, IOException {
      return (CTManualLayout)POIXMLTypeLoader.parse(param1Reader, CTManualLayout.type, null);
    }
    
    public static CTManualLayout parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTManualLayout)POIXMLTypeLoader.parse(param1Reader, CTManualLayout.type, param1XmlOptions);
    }
    
    public static CTManualLayout parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTManualLayout)POIXMLTypeLoader.parse(param1XMLStreamReader, CTManualLayout.type, null);
    }
    
    public static CTManualLayout parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTManualLayout)POIXMLTypeLoader.parse(param1XMLStreamReader, CTManualLayout.type, param1XmlOptions);
    }
    
    public static CTManualLayout parse(Node param1Node) throws XmlException {
      return (CTManualLayout)POIXMLTypeLoader.parse(param1Node, CTManualLayout.type, null);
    }
    
    public static CTManualLayout parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTManualLayout)POIXMLTypeLoader.parse(param1Node, CTManualLayout.type, param1XmlOptions);
    }
    
    public static CTManualLayout parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTManualLayout)POIXMLTypeLoader.parse(param1XMLInputStream, CTManualLayout.type, null);
    }
    
    public static CTManualLayout parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTManualLayout)POIXMLTypeLoader.parse(param1XMLInputStream, CTManualLayout.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTManualLayout.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTManualLayout.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTManualLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */