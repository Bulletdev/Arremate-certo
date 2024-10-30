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

public interface CTShadow extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTShadow.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctshadowdfdetype");
  
  String getId();
  
  XmlString xgetId();
  
  boolean isSetId();
  
  void setId(String paramString);
  
  void xsetId(XmlString paramXmlString);
  
  void unsetId();
  
  STTrueFalse.Enum getOn();
  
  STTrueFalse xgetOn();
  
  boolean isSetOn();
  
  void setOn(STTrueFalse.Enum paramEnum);
  
  void xsetOn(STTrueFalse paramSTTrueFalse);
  
  void unsetOn();
  
  STShadowType$Enum getType();
  
  STShadowType xgetType();
  
  boolean isSetType();
  
  void setType(STShadowType$Enum paramSTShadowType$Enum);
  
  void xsetType(STShadowType paramSTShadowType);
  
  void unsetType();
  
  STTrueFalse.Enum getObscured();
  
  STTrueFalse xgetObscured();
  
  boolean isSetObscured();
  
  void setObscured(STTrueFalse.Enum paramEnum);
  
  void xsetObscured(STTrueFalse paramSTTrueFalse);
  
  void unsetObscured();
  
  String getColor();
  
  STColorType xgetColor();
  
  boolean isSetColor();
  
  void setColor(String paramString);
  
  void xsetColor(STColorType paramSTColorType);
  
  void unsetColor();
  
  String getOpacity();
  
  XmlString xgetOpacity();
  
  boolean isSetOpacity();
  
  void setOpacity(String paramString);
  
  void xsetOpacity(XmlString paramXmlString);
  
  void unsetOpacity();
  
  String getOffset();
  
  XmlString xgetOffset();
  
  boolean isSetOffset();
  
  void setOffset(String paramString);
  
  void xsetOffset(XmlString paramXmlString);
  
  void unsetOffset();
  
  String getColor2();
  
  STColorType xgetColor2();
  
  boolean isSetColor2();
  
  void setColor2(String paramString);
  
  void xsetColor2(STColorType paramSTColorType);
  
  void unsetColor2();
  
  String getOffset2();
  
  XmlString xgetOffset2();
  
  boolean isSetOffset2();
  
  void setOffset2(String paramString);
  
  void xsetOffset2(XmlString paramXmlString);
  
  void unsetOffset2();
  
  String getOrigin();
  
  XmlString xgetOrigin();
  
  boolean isSetOrigin();
  
  void setOrigin(String paramString);
  
  void xsetOrigin(XmlString paramXmlString);
  
  void unsetOrigin();
  
  String getMatrix();
  
  XmlString xgetMatrix();
  
  boolean isSetMatrix();
  
  void setMatrix(String paramString);
  
  void xsetMatrix(XmlString paramXmlString);
  
  void unsetMatrix();
  
  public static final class Factory {
    public static CTShadow newInstance() {
      return (CTShadow)POIXMLTypeLoader.newInstance(CTShadow.type, null);
    }
    
    public static CTShadow newInstance(XmlOptions param1XmlOptions) {
      return (CTShadow)POIXMLTypeLoader.newInstance(CTShadow.type, param1XmlOptions);
    }
    
    public static CTShadow parse(String param1String) throws XmlException {
      return (CTShadow)POIXMLTypeLoader.parse(param1String, CTShadow.type, null);
    }
    
    public static CTShadow parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTShadow)POIXMLTypeLoader.parse(param1String, CTShadow.type, param1XmlOptions);
    }
    
    public static CTShadow parse(File param1File) throws XmlException, IOException {
      return (CTShadow)POIXMLTypeLoader.parse(param1File, CTShadow.type, null);
    }
    
    public static CTShadow parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTShadow)POIXMLTypeLoader.parse(param1File, CTShadow.type, param1XmlOptions);
    }
    
    public static CTShadow parse(URL param1URL) throws XmlException, IOException {
      return (CTShadow)POIXMLTypeLoader.parse(param1URL, CTShadow.type, null);
    }
    
    public static CTShadow parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTShadow)POIXMLTypeLoader.parse(param1URL, CTShadow.type, param1XmlOptions);
    }
    
    public static CTShadow parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTShadow)POIXMLTypeLoader.parse(param1InputStream, CTShadow.type, null);
    }
    
    public static CTShadow parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTShadow)POIXMLTypeLoader.parse(param1InputStream, CTShadow.type, param1XmlOptions);
    }
    
    public static CTShadow parse(Reader param1Reader) throws XmlException, IOException {
      return (CTShadow)POIXMLTypeLoader.parse(param1Reader, CTShadow.type, null);
    }
    
    public static CTShadow parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTShadow)POIXMLTypeLoader.parse(param1Reader, CTShadow.type, param1XmlOptions);
    }
    
    public static CTShadow parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTShadow)POIXMLTypeLoader.parse(param1XMLStreamReader, CTShadow.type, null);
    }
    
    public static CTShadow parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTShadow)POIXMLTypeLoader.parse(param1XMLStreamReader, CTShadow.type, param1XmlOptions);
    }
    
    public static CTShadow parse(Node param1Node) throws XmlException {
      return (CTShadow)POIXMLTypeLoader.parse(param1Node, CTShadow.type, null);
    }
    
    public static CTShadow parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTShadow)POIXMLTypeLoader.parse(param1Node, CTShadow.type, param1XmlOptions);
    }
    
    public static CTShadow parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTShadow)POIXMLTypeLoader.parse(param1XMLInputStream, CTShadow.type, null);
    }
    
    public static CTShadow parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTShadow)POIXMLTypeLoader.parse(param1XMLInputStream, CTShadow.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTShadow.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTShadow.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\vml\CTShadow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */