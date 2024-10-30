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

public interface CTH extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTH.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cth4cbctype");
  
  String getPosition();
  
  XmlString xgetPosition();
  
  boolean isSetPosition();
  
  void setPosition(String paramString);
  
  void xsetPosition(XmlString paramXmlString);
  
  void unsetPosition();
  
  String getPolar();
  
  XmlString xgetPolar();
  
  boolean isSetPolar();
  
  void setPolar(String paramString);
  
  void xsetPolar(XmlString paramXmlString);
  
  void unsetPolar();
  
  String getMap();
  
  XmlString xgetMap();
  
  boolean isSetMap();
  
  void setMap(String paramString);
  
  void xsetMap(XmlString paramXmlString);
  
  void unsetMap();
  
  STTrueFalse.Enum getInvx();
  
  STTrueFalse xgetInvx();
  
  boolean isSetInvx();
  
  void setInvx(STTrueFalse.Enum paramEnum);
  
  void xsetInvx(STTrueFalse paramSTTrueFalse);
  
  void unsetInvx();
  
  STTrueFalse.Enum getInvy();
  
  STTrueFalse xgetInvy();
  
  boolean isSetInvy();
  
  void setInvy(STTrueFalse.Enum paramEnum);
  
  void xsetInvy(STTrueFalse paramSTTrueFalse);
  
  void unsetInvy();
  
  STTrueFalseBlank$Enum getSwitch();
  
  STTrueFalseBlank xgetSwitch();
  
  boolean isSetSwitch();
  
  void setSwitch(STTrueFalseBlank$Enum paramSTTrueFalseBlank$Enum);
  
  void xsetSwitch(STTrueFalseBlank paramSTTrueFalseBlank);
  
  void unsetSwitch();
  
  String getXrange();
  
  XmlString xgetXrange();
  
  boolean isSetXrange();
  
  void setXrange(String paramString);
  
  void xsetXrange(XmlString paramXmlString);
  
  void unsetXrange();
  
  String getYrange();
  
  XmlString xgetYrange();
  
  boolean isSetYrange();
  
  void setYrange(String paramString);
  
  void xsetYrange(XmlString paramXmlString);
  
  void unsetYrange();
  
  String getRadiusrange();
  
  XmlString xgetRadiusrange();
  
  boolean isSetRadiusrange();
  
  void setRadiusrange(String paramString);
  
  void xsetRadiusrange(XmlString paramXmlString);
  
  void unsetRadiusrange();
  
  public static final class Factory {
    public static CTH newInstance() {
      return (CTH)POIXMLTypeLoader.newInstance(CTH.type, null);
    }
    
    public static CTH newInstance(XmlOptions param1XmlOptions) {
      return (CTH)POIXMLTypeLoader.newInstance(CTH.type, param1XmlOptions);
    }
    
    public static CTH parse(String param1String) throws XmlException {
      return (CTH)POIXMLTypeLoader.parse(param1String, CTH.type, null);
    }
    
    public static CTH parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTH)POIXMLTypeLoader.parse(param1String, CTH.type, param1XmlOptions);
    }
    
    public static CTH parse(File param1File) throws XmlException, IOException {
      return (CTH)POIXMLTypeLoader.parse(param1File, CTH.type, null);
    }
    
    public static CTH parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTH)POIXMLTypeLoader.parse(param1File, CTH.type, param1XmlOptions);
    }
    
    public static CTH parse(URL param1URL) throws XmlException, IOException {
      return (CTH)POIXMLTypeLoader.parse(param1URL, CTH.type, null);
    }
    
    public static CTH parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTH)POIXMLTypeLoader.parse(param1URL, CTH.type, param1XmlOptions);
    }
    
    public static CTH parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTH)POIXMLTypeLoader.parse(param1InputStream, CTH.type, null);
    }
    
    public static CTH parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTH)POIXMLTypeLoader.parse(param1InputStream, CTH.type, param1XmlOptions);
    }
    
    public static CTH parse(Reader param1Reader) throws XmlException, IOException {
      return (CTH)POIXMLTypeLoader.parse(param1Reader, CTH.type, null);
    }
    
    public static CTH parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTH)POIXMLTypeLoader.parse(param1Reader, CTH.type, param1XmlOptions);
    }
    
    public static CTH parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTH)POIXMLTypeLoader.parse(param1XMLStreamReader, CTH.type, null);
    }
    
    public static CTH parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTH)POIXMLTypeLoader.parse(param1XMLStreamReader, CTH.type, param1XmlOptions);
    }
    
    public static CTH parse(Node param1Node) throws XmlException {
      return (CTH)POIXMLTypeLoader.parse(param1Node, CTH.type, null);
    }
    
    public static CTH parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTH)POIXMLTypeLoader.parse(param1Node, CTH.type, param1XmlOptions);
    }
    
    public static CTH parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTH)POIXMLTypeLoader.parse(param1XMLInputStream, CTH.type, null);
    }
    
    public static CTH parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTH)POIXMLTypeLoader.parse(param1XMLInputStream, CTH.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTH.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTH.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\vml\CTH.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */