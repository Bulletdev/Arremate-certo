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

public interface CTFillProperties extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTFillProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctfillproperties2371type");
  
  CTNoFillProperties getNoFill();
  
  boolean isSetNoFill();
  
  void setNoFill(CTNoFillProperties paramCTNoFillProperties);
  
  CTNoFillProperties addNewNoFill();
  
  void unsetNoFill();
  
  CTSolidColorFillProperties getSolidFill();
  
  boolean isSetSolidFill();
  
  void setSolidFill(CTSolidColorFillProperties paramCTSolidColorFillProperties);
  
  CTSolidColorFillProperties addNewSolidFill();
  
  void unsetSolidFill();
  
  CTGradientFillProperties getGradFill();
  
  boolean isSetGradFill();
  
  void setGradFill(CTGradientFillProperties paramCTGradientFillProperties);
  
  CTGradientFillProperties addNewGradFill();
  
  void unsetGradFill();
  
  CTBlipFillProperties getBlipFill();
  
  boolean isSetBlipFill();
  
  void setBlipFill(CTBlipFillProperties paramCTBlipFillProperties);
  
  CTBlipFillProperties addNewBlipFill();
  
  void unsetBlipFill();
  
  CTPatternFillProperties getPattFill();
  
  boolean isSetPattFill();
  
  void setPattFill(CTPatternFillProperties paramCTPatternFillProperties);
  
  CTPatternFillProperties addNewPattFill();
  
  void unsetPattFill();
  
  CTGroupFillProperties getGrpFill();
  
  boolean isSetGrpFill();
  
  void setGrpFill(CTGroupFillProperties paramCTGroupFillProperties);
  
  CTGroupFillProperties addNewGrpFill();
  
  void unsetGrpFill();
  
  public static final class Factory {
    public static CTFillProperties newInstance() {
      return (CTFillProperties)POIXMLTypeLoader.newInstance(CTFillProperties.type, null);
    }
    
    public static CTFillProperties newInstance(XmlOptions param1XmlOptions) {
      return (CTFillProperties)POIXMLTypeLoader.newInstance(CTFillProperties.type, param1XmlOptions);
    }
    
    public static CTFillProperties parse(String param1String) throws XmlException {
      return (CTFillProperties)POIXMLTypeLoader.parse(param1String, CTFillProperties.type, null);
    }
    
    public static CTFillProperties parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFillProperties)POIXMLTypeLoader.parse(param1String, CTFillProperties.type, param1XmlOptions);
    }
    
    public static CTFillProperties parse(File param1File) throws XmlException, IOException {
      return (CTFillProperties)POIXMLTypeLoader.parse(param1File, CTFillProperties.type, null);
    }
    
    public static CTFillProperties parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFillProperties)POIXMLTypeLoader.parse(param1File, CTFillProperties.type, param1XmlOptions);
    }
    
    public static CTFillProperties parse(URL param1URL) throws XmlException, IOException {
      return (CTFillProperties)POIXMLTypeLoader.parse(param1URL, CTFillProperties.type, null);
    }
    
    public static CTFillProperties parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFillProperties)POIXMLTypeLoader.parse(param1URL, CTFillProperties.type, param1XmlOptions);
    }
    
    public static CTFillProperties parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTFillProperties)POIXMLTypeLoader.parse(param1InputStream, CTFillProperties.type, null);
    }
    
    public static CTFillProperties parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFillProperties)POIXMLTypeLoader.parse(param1InputStream, CTFillProperties.type, param1XmlOptions);
    }
    
    public static CTFillProperties parse(Reader param1Reader) throws XmlException, IOException {
      return (CTFillProperties)POIXMLTypeLoader.parse(param1Reader, CTFillProperties.type, null);
    }
    
    public static CTFillProperties parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFillProperties)POIXMLTypeLoader.parse(param1Reader, CTFillProperties.type, param1XmlOptions);
    }
    
    public static CTFillProperties parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTFillProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTFillProperties.type, null);
    }
    
    public static CTFillProperties parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFillProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTFillProperties.type, param1XmlOptions);
    }
    
    public static CTFillProperties parse(Node param1Node) throws XmlException {
      return (CTFillProperties)POIXMLTypeLoader.parse(param1Node, CTFillProperties.type, null);
    }
    
    public static CTFillProperties parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFillProperties)POIXMLTypeLoader.parse(param1Node, CTFillProperties.type, param1XmlOptions);
    }
    
    public static CTFillProperties parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTFillProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTFillProperties.type, null);
    }
    
    public static CTFillProperties parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTFillProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTFillProperties.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTFillProperties.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTFillProperties.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTFillProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */