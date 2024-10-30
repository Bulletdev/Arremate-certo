package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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

public interface CTColorScale extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTColorScale.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcolorscale1a70type");
  
  List<CTCfvo> getCfvoList();
  
  CTCfvo[] getCfvoArray();
  
  CTCfvo getCfvoArray(int paramInt);
  
  int sizeOfCfvoArray();
  
  void setCfvoArray(CTCfvo[] paramArrayOfCTCfvo);
  
  void setCfvoArray(int paramInt, CTCfvo paramCTCfvo);
  
  CTCfvo insertNewCfvo(int paramInt);
  
  CTCfvo addNewCfvo();
  
  void removeCfvo(int paramInt);
  
  List<CTColor> getColorList();
  
  CTColor[] getColorArray();
  
  CTColor getColorArray(int paramInt);
  
  int sizeOfColorArray();
  
  void setColorArray(CTColor[] paramArrayOfCTColor);
  
  void setColorArray(int paramInt, CTColor paramCTColor);
  
  CTColor insertNewColor(int paramInt);
  
  CTColor addNewColor();
  
  void removeColor(int paramInt);
  
  public static final class Factory {
    public static CTColorScale newInstance() {
      return (CTColorScale)POIXMLTypeLoader.newInstance(CTColorScale.type, null);
    }
    
    public static CTColorScale newInstance(XmlOptions param1XmlOptions) {
      return (CTColorScale)POIXMLTypeLoader.newInstance(CTColorScale.type, param1XmlOptions);
    }
    
    public static CTColorScale parse(String param1String) throws XmlException {
      return (CTColorScale)POIXMLTypeLoader.parse(param1String, CTColorScale.type, null);
    }
    
    public static CTColorScale parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTColorScale)POIXMLTypeLoader.parse(param1String, CTColorScale.type, param1XmlOptions);
    }
    
    public static CTColorScale parse(File param1File) throws XmlException, IOException {
      return (CTColorScale)POIXMLTypeLoader.parse(param1File, CTColorScale.type, null);
    }
    
    public static CTColorScale parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTColorScale)POIXMLTypeLoader.parse(param1File, CTColorScale.type, param1XmlOptions);
    }
    
    public static CTColorScale parse(URL param1URL) throws XmlException, IOException {
      return (CTColorScale)POIXMLTypeLoader.parse(param1URL, CTColorScale.type, null);
    }
    
    public static CTColorScale parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTColorScale)POIXMLTypeLoader.parse(param1URL, CTColorScale.type, param1XmlOptions);
    }
    
    public static CTColorScale parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTColorScale)POIXMLTypeLoader.parse(param1InputStream, CTColorScale.type, null);
    }
    
    public static CTColorScale parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTColorScale)POIXMLTypeLoader.parse(param1InputStream, CTColorScale.type, param1XmlOptions);
    }
    
    public static CTColorScale parse(Reader param1Reader) throws XmlException, IOException {
      return (CTColorScale)POIXMLTypeLoader.parse(param1Reader, CTColorScale.type, null);
    }
    
    public static CTColorScale parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTColorScale)POIXMLTypeLoader.parse(param1Reader, CTColorScale.type, param1XmlOptions);
    }
    
    public static CTColorScale parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTColorScale)POIXMLTypeLoader.parse(param1XMLStreamReader, CTColorScale.type, null);
    }
    
    public static CTColorScale parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTColorScale)POIXMLTypeLoader.parse(param1XMLStreamReader, CTColorScale.type, param1XmlOptions);
    }
    
    public static CTColorScale parse(Node param1Node) throws XmlException {
      return (CTColorScale)POIXMLTypeLoader.parse(param1Node, CTColorScale.type, null);
    }
    
    public static CTColorScale parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTColorScale)POIXMLTypeLoader.parse(param1Node, CTColorScale.type, param1XmlOptions);
    }
    
    public static CTColorScale parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTColorScale)POIXMLTypeLoader.parse(param1XMLInputStream, CTColorScale.type, null);
    }
    
    public static CTColorScale parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTColorScale)POIXMLTypeLoader.parse(param1XMLInputStream, CTColorScale.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTColorScale.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTColorScale.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTColorScale.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */