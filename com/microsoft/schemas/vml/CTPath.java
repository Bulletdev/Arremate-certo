package com.microsoft.schemas.vml;

import com.microsoft.schemas.office.office.STConnectType;
import com.microsoft.schemas.office.office.STTrueFalse;
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

public interface CTPath extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPath.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpath5963type");
  
  String getId();
  
  XmlString xgetId();
  
  boolean isSetId();
  
  void setId(String paramString);
  
  void xsetId(XmlString paramXmlString);
  
  void unsetId();
  
  String getV();
  
  XmlString xgetV();
  
  boolean isSetV();
  
  void setV(String paramString);
  
  void xsetV(XmlString paramXmlString);
  
  void unsetV();
  
  String getLimo();
  
  XmlString xgetLimo();
  
  boolean isSetLimo();
  
  void setLimo(String paramString);
  
  void xsetLimo(XmlString paramXmlString);
  
  void unsetLimo();
  
  String getTextboxrect();
  
  XmlString xgetTextboxrect();
  
  boolean isSetTextboxrect();
  
  void setTextboxrect(String paramString);
  
  void xsetTextboxrect(XmlString paramXmlString);
  
  void unsetTextboxrect();
  
  STTrueFalse.Enum getFillok();
  
  STTrueFalse xgetFillok();
  
  boolean isSetFillok();
  
  void setFillok(STTrueFalse.Enum paramEnum);
  
  void xsetFillok(STTrueFalse paramSTTrueFalse);
  
  void unsetFillok();
  
  STTrueFalse.Enum getStrokeok();
  
  STTrueFalse xgetStrokeok();
  
  boolean isSetStrokeok();
  
  void setStrokeok(STTrueFalse.Enum paramEnum);
  
  void xsetStrokeok(STTrueFalse paramSTTrueFalse);
  
  void unsetStrokeok();
  
  STTrueFalse.Enum getShadowok();
  
  STTrueFalse xgetShadowok();
  
  boolean isSetShadowok();
  
  void setShadowok(STTrueFalse.Enum paramEnum);
  
  void xsetShadowok(STTrueFalse paramSTTrueFalse);
  
  void unsetShadowok();
  
  STTrueFalse.Enum getArrowok();
  
  STTrueFalse xgetArrowok();
  
  boolean isSetArrowok();
  
  void setArrowok(STTrueFalse.Enum paramEnum);
  
  void xsetArrowok(STTrueFalse paramSTTrueFalse);
  
  void unsetArrowok();
  
  STTrueFalse.Enum getGradientshapeok();
  
  STTrueFalse xgetGradientshapeok();
  
  boolean isSetGradientshapeok();
  
  void setGradientshapeok(STTrueFalse.Enum paramEnum);
  
  void xsetGradientshapeok(STTrueFalse paramSTTrueFalse);
  
  void unsetGradientshapeok();
  
  STTrueFalse.Enum getTextpathok();
  
  STTrueFalse xgetTextpathok();
  
  boolean isSetTextpathok();
  
  void setTextpathok(STTrueFalse.Enum paramEnum);
  
  void xsetTextpathok(STTrueFalse paramSTTrueFalse);
  
  void unsetTextpathok();
  
  STTrueFalse.Enum getInsetpenok();
  
  STTrueFalse xgetInsetpenok();
  
  boolean isSetInsetpenok();
  
  void setInsetpenok(STTrueFalse.Enum paramEnum);
  
  void xsetInsetpenok(STTrueFalse paramSTTrueFalse);
  
  void unsetInsetpenok();
  
  STConnectType.Enum getConnecttype();
  
  STConnectType xgetConnecttype();
  
  boolean isSetConnecttype();
  
  void setConnecttype(STConnectType.Enum paramEnum);
  
  void xsetConnecttype(STConnectType paramSTConnectType);
  
  void unsetConnecttype();
  
  String getConnectlocs();
  
  XmlString xgetConnectlocs();
  
  boolean isSetConnectlocs();
  
  void setConnectlocs(String paramString);
  
  void xsetConnectlocs(XmlString paramXmlString);
  
  void unsetConnectlocs();
  
  String getConnectangles();
  
  XmlString xgetConnectangles();
  
  boolean isSetConnectangles();
  
  void setConnectangles(String paramString);
  
  void xsetConnectangles(XmlString paramXmlString);
  
  void unsetConnectangles();
  
  STTrueFalse.Enum getExtrusionok();
  
  STTrueFalse xgetExtrusionok();
  
  boolean isSetExtrusionok();
  
  void setExtrusionok(STTrueFalse.Enum paramEnum);
  
  void xsetExtrusionok(STTrueFalse paramSTTrueFalse);
  
  void unsetExtrusionok();
  
  public static final class Factory {
    public static CTPath newInstance() {
      return (CTPath)POIXMLTypeLoader.newInstance(CTPath.type, null);
    }
    
    public static CTPath newInstance(XmlOptions param1XmlOptions) {
      return (CTPath)POIXMLTypeLoader.newInstance(CTPath.type, param1XmlOptions);
    }
    
    public static CTPath parse(String param1String) throws XmlException {
      return (CTPath)POIXMLTypeLoader.parse(param1String, CTPath.type, null);
    }
    
    public static CTPath parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPath)POIXMLTypeLoader.parse(param1String, CTPath.type, param1XmlOptions);
    }
    
    public static CTPath parse(File param1File) throws XmlException, IOException {
      return (CTPath)POIXMLTypeLoader.parse(param1File, CTPath.type, null);
    }
    
    public static CTPath parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPath)POIXMLTypeLoader.parse(param1File, CTPath.type, param1XmlOptions);
    }
    
    public static CTPath parse(URL param1URL) throws XmlException, IOException {
      return (CTPath)POIXMLTypeLoader.parse(param1URL, CTPath.type, null);
    }
    
    public static CTPath parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPath)POIXMLTypeLoader.parse(param1URL, CTPath.type, param1XmlOptions);
    }
    
    public static CTPath parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPath)POIXMLTypeLoader.parse(param1InputStream, CTPath.type, null);
    }
    
    public static CTPath parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPath)POIXMLTypeLoader.parse(param1InputStream, CTPath.type, param1XmlOptions);
    }
    
    public static CTPath parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPath)POIXMLTypeLoader.parse(param1Reader, CTPath.type, null);
    }
    
    public static CTPath parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPath)POIXMLTypeLoader.parse(param1Reader, CTPath.type, param1XmlOptions);
    }
    
    public static CTPath parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPath)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPath.type, null);
    }
    
    public static CTPath parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPath)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPath.type, param1XmlOptions);
    }
    
    public static CTPath parse(Node param1Node) throws XmlException {
      return (CTPath)POIXMLTypeLoader.parse(param1Node, CTPath.type, null);
    }
    
    public static CTPath parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPath)POIXMLTypeLoader.parse(param1Node, CTPath.type, param1XmlOptions);
    }
    
    public static CTPath parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPath)POIXMLTypeLoader.parse(param1XMLInputStream, CTPath.type, null);
    }
    
    public static CTPath parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPath)POIXMLTypeLoader.parse(param1XMLInputStream, CTPath.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPath.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPath.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\vml\CTPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */