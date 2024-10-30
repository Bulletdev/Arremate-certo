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

public interface CTGradientStop extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTGradientStop.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctgradientstopc7edtype");
  
  CTScRgbColor getScrgbClr();
  
  boolean isSetScrgbClr();
  
  void setScrgbClr(CTScRgbColor paramCTScRgbColor);
  
  CTScRgbColor addNewScrgbClr();
  
  void unsetScrgbClr();
  
  CTSRgbColor getSrgbClr();
  
  boolean isSetSrgbClr();
  
  void setSrgbClr(CTSRgbColor paramCTSRgbColor);
  
  CTSRgbColor addNewSrgbClr();
  
  void unsetSrgbClr();
  
  CTHslColor getHslClr();
  
  boolean isSetHslClr();
  
  void setHslClr(CTHslColor paramCTHslColor);
  
  CTHslColor addNewHslClr();
  
  void unsetHslClr();
  
  CTSystemColor getSysClr();
  
  boolean isSetSysClr();
  
  void setSysClr(CTSystemColor paramCTSystemColor);
  
  CTSystemColor addNewSysClr();
  
  void unsetSysClr();
  
  CTSchemeColor getSchemeClr();
  
  boolean isSetSchemeClr();
  
  void setSchemeClr(CTSchemeColor paramCTSchemeColor);
  
  CTSchemeColor addNewSchemeClr();
  
  void unsetSchemeClr();
  
  CTPresetColor getPrstClr();
  
  boolean isSetPrstClr();
  
  void setPrstClr(CTPresetColor paramCTPresetColor);
  
  CTPresetColor addNewPrstClr();
  
  void unsetPrstClr();
  
  int getPos();
  
  STPositiveFixedPercentage xgetPos();
  
  void setPos(int paramInt);
  
  void xsetPos(STPositiveFixedPercentage paramSTPositiveFixedPercentage);
  
  public static final class Factory {
    public static CTGradientStop newInstance() {
      return (CTGradientStop)POIXMLTypeLoader.newInstance(CTGradientStop.type, null);
    }
    
    public static CTGradientStop newInstance(XmlOptions param1XmlOptions) {
      return (CTGradientStop)POIXMLTypeLoader.newInstance(CTGradientStop.type, param1XmlOptions);
    }
    
    public static CTGradientStop parse(String param1String) throws XmlException {
      return (CTGradientStop)POIXMLTypeLoader.parse(param1String, CTGradientStop.type, null);
    }
    
    public static CTGradientStop parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGradientStop)POIXMLTypeLoader.parse(param1String, CTGradientStop.type, param1XmlOptions);
    }
    
    public static CTGradientStop parse(File param1File) throws XmlException, IOException {
      return (CTGradientStop)POIXMLTypeLoader.parse(param1File, CTGradientStop.type, null);
    }
    
    public static CTGradientStop parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGradientStop)POIXMLTypeLoader.parse(param1File, CTGradientStop.type, param1XmlOptions);
    }
    
    public static CTGradientStop parse(URL param1URL) throws XmlException, IOException {
      return (CTGradientStop)POIXMLTypeLoader.parse(param1URL, CTGradientStop.type, null);
    }
    
    public static CTGradientStop parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGradientStop)POIXMLTypeLoader.parse(param1URL, CTGradientStop.type, param1XmlOptions);
    }
    
    public static CTGradientStop parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTGradientStop)POIXMLTypeLoader.parse(param1InputStream, CTGradientStop.type, null);
    }
    
    public static CTGradientStop parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGradientStop)POIXMLTypeLoader.parse(param1InputStream, CTGradientStop.type, param1XmlOptions);
    }
    
    public static CTGradientStop parse(Reader param1Reader) throws XmlException, IOException {
      return (CTGradientStop)POIXMLTypeLoader.parse(param1Reader, CTGradientStop.type, null);
    }
    
    public static CTGradientStop parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGradientStop)POIXMLTypeLoader.parse(param1Reader, CTGradientStop.type, param1XmlOptions);
    }
    
    public static CTGradientStop parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTGradientStop)POIXMLTypeLoader.parse(param1XMLStreamReader, CTGradientStop.type, null);
    }
    
    public static CTGradientStop parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGradientStop)POIXMLTypeLoader.parse(param1XMLStreamReader, CTGradientStop.type, param1XmlOptions);
    }
    
    public static CTGradientStop parse(Node param1Node) throws XmlException {
      return (CTGradientStop)POIXMLTypeLoader.parse(param1Node, CTGradientStop.type, null);
    }
    
    public static CTGradientStop parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGradientStop)POIXMLTypeLoader.parse(param1Node, CTGradientStop.type, param1XmlOptions);
    }
    
    public static CTGradientStop parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTGradientStop)POIXMLTypeLoader.parse(param1XMLInputStream, CTGradientStop.type, null);
    }
    
    public static CTGradientStop parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTGradientStop)POIXMLTypeLoader.parse(param1XMLInputStream, CTGradientStop.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTGradientStop.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTGradientStop.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTGradientStop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */