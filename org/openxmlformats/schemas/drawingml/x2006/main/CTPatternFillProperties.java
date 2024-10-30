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

public interface CTPatternFillProperties extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPatternFillProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpatternfillproperties3637type");
  
  CTColor getFgClr();
  
  boolean isSetFgClr();
  
  void setFgClr(CTColor paramCTColor);
  
  CTColor addNewFgClr();
  
  void unsetFgClr();
  
  CTColor getBgClr();
  
  boolean isSetBgClr();
  
  void setBgClr(CTColor paramCTColor);
  
  CTColor addNewBgClr();
  
  void unsetBgClr();
  
  STPresetPatternVal.Enum getPrst();
  
  STPresetPatternVal xgetPrst();
  
  boolean isSetPrst();
  
  void setPrst(STPresetPatternVal.Enum paramEnum);
  
  void xsetPrst(STPresetPatternVal paramSTPresetPatternVal);
  
  void unsetPrst();
  
  public static final class Factory {
    public static CTPatternFillProperties newInstance() {
      return (CTPatternFillProperties)POIXMLTypeLoader.newInstance(CTPatternFillProperties.type, null);
    }
    
    public static CTPatternFillProperties newInstance(XmlOptions param1XmlOptions) {
      return (CTPatternFillProperties)POIXMLTypeLoader.newInstance(CTPatternFillProperties.type, param1XmlOptions);
    }
    
    public static CTPatternFillProperties parse(String param1String) throws XmlException {
      return (CTPatternFillProperties)POIXMLTypeLoader.parse(param1String, CTPatternFillProperties.type, null);
    }
    
    public static CTPatternFillProperties parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPatternFillProperties)POIXMLTypeLoader.parse(param1String, CTPatternFillProperties.type, param1XmlOptions);
    }
    
    public static CTPatternFillProperties parse(File param1File) throws XmlException, IOException {
      return (CTPatternFillProperties)POIXMLTypeLoader.parse(param1File, CTPatternFillProperties.type, null);
    }
    
    public static CTPatternFillProperties parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPatternFillProperties)POIXMLTypeLoader.parse(param1File, CTPatternFillProperties.type, param1XmlOptions);
    }
    
    public static CTPatternFillProperties parse(URL param1URL) throws XmlException, IOException {
      return (CTPatternFillProperties)POIXMLTypeLoader.parse(param1URL, CTPatternFillProperties.type, null);
    }
    
    public static CTPatternFillProperties parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPatternFillProperties)POIXMLTypeLoader.parse(param1URL, CTPatternFillProperties.type, param1XmlOptions);
    }
    
    public static CTPatternFillProperties parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPatternFillProperties)POIXMLTypeLoader.parse(param1InputStream, CTPatternFillProperties.type, null);
    }
    
    public static CTPatternFillProperties parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPatternFillProperties)POIXMLTypeLoader.parse(param1InputStream, CTPatternFillProperties.type, param1XmlOptions);
    }
    
    public static CTPatternFillProperties parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPatternFillProperties)POIXMLTypeLoader.parse(param1Reader, CTPatternFillProperties.type, null);
    }
    
    public static CTPatternFillProperties parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPatternFillProperties)POIXMLTypeLoader.parse(param1Reader, CTPatternFillProperties.type, param1XmlOptions);
    }
    
    public static CTPatternFillProperties parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPatternFillProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPatternFillProperties.type, null);
    }
    
    public static CTPatternFillProperties parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPatternFillProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPatternFillProperties.type, param1XmlOptions);
    }
    
    public static CTPatternFillProperties parse(Node param1Node) throws XmlException {
      return (CTPatternFillProperties)POIXMLTypeLoader.parse(param1Node, CTPatternFillProperties.type, null);
    }
    
    public static CTPatternFillProperties parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPatternFillProperties)POIXMLTypeLoader.parse(param1Node, CTPatternFillProperties.type, param1XmlOptions);
    }
    
    public static CTPatternFillProperties parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPatternFillProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTPatternFillProperties.type, null);
    }
    
    public static CTPatternFillProperties parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPatternFillProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTPatternFillProperties.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPatternFillProperties.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPatternFillProperties.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTPatternFillProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */