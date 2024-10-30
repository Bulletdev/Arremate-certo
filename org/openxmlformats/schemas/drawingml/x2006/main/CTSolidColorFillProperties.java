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

public interface CTSolidColorFillProperties extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSolidColorFillProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsolidcolorfillproperties9cc9type");
  
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
  
  public static final class Factory {
    public static CTSolidColorFillProperties newInstance() {
      return (CTSolidColorFillProperties)POIXMLTypeLoader.newInstance(CTSolidColorFillProperties.type, null);
    }
    
    public static CTSolidColorFillProperties newInstance(XmlOptions param1XmlOptions) {
      return (CTSolidColorFillProperties)POIXMLTypeLoader.newInstance(CTSolidColorFillProperties.type, param1XmlOptions);
    }
    
    public static CTSolidColorFillProperties parse(String param1String) throws XmlException {
      return (CTSolidColorFillProperties)POIXMLTypeLoader.parse(param1String, CTSolidColorFillProperties.type, null);
    }
    
    public static CTSolidColorFillProperties parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSolidColorFillProperties)POIXMLTypeLoader.parse(param1String, CTSolidColorFillProperties.type, param1XmlOptions);
    }
    
    public static CTSolidColorFillProperties parse(File param1File) throws XmlException, IOException {
      return (CTSolidColorFillProperties)POIXMLTypeLoader.parse(param1File, CTSolidColorFillProperties.type, null);
    }
    
    public static CTSolidColorFillProperties parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSolidColorFillProperties)POIXMLTypeLoader.parse(param1File, CTSolidColorFillProperties.type, param1XmlOptions);
    }
    
    public static CTSolidColorFillProperties parse(URL param1URL) throws XmlException, IOException {
      return (CTSolidColorFillProperties)POIXMLTypeLoader.parse(param1URL, CTSolidColorFillProperties.type, null);
    }
    
    public static CTSolidColorFillProperties parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSolidColorFillProperties)POIXMLTypeLoader.parse(param1URL, CTSolidColorFillProperties.type, param1XmlOptions);
    }
    
    public static CTSolidColorFillProperties parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSolidColorFillProperties)POIXMLTypeLoader.parse(param1InputStream, CTSolidColorFillProperties.type, null);
    }
    
    public static CTSolidColorFillProperties parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSolidColorFillProperties)POIXMLTypeLoader.parse(param1InputStream, CTSolidColorFillProperties.type, param1XmlOptions);
    }
    
    public static CTSolidColorFillProperties parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSolidColorFillProperties)POIXMLTypeLoader.parse(param1Reader, CTSolidColorFillProperties.type, null);
    }
    
    public static CTSolidColorFillProperties parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSolidColorFillProperties)POIXMLTypeLoader.parse(param1Reader, CTSolidColorFillProperties.type, param1XmlOptions);
    }
    
    public static CTSolidColorFillProperties parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSolidColorFillProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSolidColorFillProperties.type, null);
    }
    
    public static CTSolidColorFillProperties parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSolidColorFillProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSolidColorFillProperties.type, param1XmlOptions);
    }
    
    public static CTSolidColorFillProperties parse(Node param1Node) throws XmlException {
      return (CTSolidColorFillProperties)POIXMLTypeLoader.parse(param1Node, CTSolidColorFillProperties.type, null);
    }
    
    public static CTSolidColorFillProperties parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSolidColorFillProperties)POIXMLTypeLoader.parse(param1Node, CTSolidColorFillProperties.type, param1XmlOptions);
    }
    
    public static CTSolidColorFillProperties parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSolidColorFillProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTSolidColorFillProperties.type, null);
    }
    
    public static CTSolidColorFillProperties parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSolidColorFillProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTSolidColorFillProperties.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSolidColorFillProperties.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSolidColorFillProperties.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTSolidColorFillProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */