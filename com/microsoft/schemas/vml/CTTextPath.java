package com.microsoft.schemas.vml;

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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTTextPath extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTextPath.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextpath14f0type");
  
  String getId();
  
  XmlString xgetId();
  
  boolean isSetId();
  
  void setId(String paramString);
  
  void xsetId(XmlString paramXmlString);
  
  void unsetId();
  
  String getStyle();
  
  XmlString xgetStyle();
  
  boolean isSetStyle();
  
  void setStyle(String paramString);
  
  void xsetStyle(XmlString paramXmlString);
  
  void unsetStyle();
  
  STTrueFalse.Enum getOn();
  
  STTrueFalse xgetOn();
  
  boolean isSetOn();
  
  void setOn(STTrueFalse.Enum paramEnum);
  
  void xsetOn(STTrueFalse paramSTTrueFalse);
  
  void unsetOn();
  
  STTrueFalse.Enum getFitshape();
  
  STTrueFalse xgetFitshape();
  
  boolean isSetFitshape();
  
  void setFitshape(STTrueFalse.Enum paramEnum);
  
  void xsetFitshape(STTrueFalse paramSTTrueFalse);
  
  void unsetFitshape();
  
  STTrueFalse.Enum getFitpath();
  
  STTrueFalse xgetFitpath();
  
  boolean isSetFitpath();
  
  void setFitpath(STTrueFalse.Enum paramEnum);
  
  void xsetFitpath(STTrueFalse paramSTTrueFalse);
  
  void unsetFitpath();
  
  STTrueFalse.Enum getTrim();
  
  STTrueFalse xgetTrim();
  
  boolean isSetTrim();
  
  void setTrim(STTrueFalse.Enum paramEnum);
  
  void xsetTrim(STTrueFalse paramSTTrueFalse);
  
  void unsetTrim();
  
  STTrueFalse.Enum getXscale();
  
  STTrueFalse xgetXscale();
  
  boolean isSetXscale();
  
  void setXscale(STTrueFalse.Enum paramEnum);
  
  void xsetXscale(STTrueFalse paramSTTrueFalse);
  
  void unsetXscale();
  
  String getString();
  
  XmlString xgetString();
  
  boolean isSetString();
  
  void setString(String paramString);
  
  void xsetString(XmlString paramXmlString);
  
  void unsetString();
  
  public static final class Factory {
    public static CTTextPath newInstance() {
      return (CTTextPath)POIXMLTypeLoader.newInstance(CTTextPath.type, null);
    }
    
    public static CTTextPath newInstance(XmlOptions param1XmlOptions) {
      return (CTTextPath)POIXMLTypeLoader.newInstance(CTTextPath.type, param1XmlOptions);
    }
    
    public static CTTextPath parse(String param1String) throws XmlException {
      return (CTTextPath)POIXMLTypeLoader.parse(param1String, CTTextPath.type, null);
    }
    
    public static CTTextPath parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextPath)POIXMLTypeLoader.parse(param1String, CTTextPath.type, param1XmlOptions);
    }
    
    public static CTTextPath parse(File param1File) throws XmlException, IOException {
      return (CTTextPath)POIXMLTypeLoader.parse(param1File, CTTextPath.type, null);
    }
    
    public static CTTextPath parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextPath)POIXMLTypeLoader.parse(param1File, CTTextPath.type, param1XmlOptions);
    }
    
    public static CTTextPath parse(URL param1URL) throws XmlException, IOException {
      return (CTTextPath)POIXMLTypeLoader.parse(param1URL, CTTextPath.type, null);
    }
    
    public static CTTextPath parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextPath)POIXMLTypeLoader.parse(param1URL, CTTextPath.type, param1XmlOptions);
    }
    
    public static CTTextPath parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTextPath)POIXMLTypeLoader.parse(param1InputStream, CTTextPath.type, null);
    }
    
    public static CTTextPath parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextPath)POIXMLTypeLoader.parse(param1InputStream, CTTextPath.type, param1XmlOptions);
    }
    
    public static CTTextPath parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTextPath)POIXMLTypeLoader.parse(param1Reader, CTTextPath.type, null);
    }
    
    public static CTTextPath parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextPath)POIXMLTypeLoader.parse(param1Reader, CTTextPath.type, param1XmlOptions);
    }
    
    public static CTTextPath parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTextPath)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextPath.type, null);
    }
    
    public static CTTextPath parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextPath)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextPath.type, param1XmlOptions);
    }
    
    public static CTTextPath parse(Node param1Node) throws XmlException {
      return (CTTextPath)POIXMLTypeLoader.parse(param1Node, CTTextPath.type, null);
    }
    
    public static CTTextPath parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextPath)POIXMLTypeLoader.parse(param1Node, CTTextPath.type, param1XmlOptions);
    }
    
    public static CTTextPath parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTextPath)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextPath.type, null);
    }
    
    public static CTTextPath parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTextPath)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextPath.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextPath.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextPath.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\vml\CTTextPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */