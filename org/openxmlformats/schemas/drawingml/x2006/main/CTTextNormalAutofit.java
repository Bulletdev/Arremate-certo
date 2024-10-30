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

public interface CTTextNormalAutofit extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTextNormalAutofit.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextnormalautofitbbdftype");
  
  int getFontScale();
  
  STTextFontScalePercent xgetFontScale();
  
  boolean isSetFontScale();
  
  void setFontScale(int paramInt);
  
  void xsetFontScale(STTextFontScalePercent paramSTTextFontScalePercent);
  
  void unsetFontScale();
  
  int getLnSpcReduction();
  
  STTextSpacingPercent xgetLnSpcReduction();
  
  boolean isSetLnSpcReduction();
  
  void setLnSpcReduction(int paramInt);
  
  void xsetLnSpcReduction(STTextSpacingPercent paramSTTextSpacingPercent);
  
  void unsetLnSpcReduction();
  
  public static final class Factory {
    public static CTTextNormalAutofit newInstance() {
      return (CTTextNormalAutofit)POIXMLTypeLoader.newInstance(CTTextNormalAutofit.type, null);
    }
    
    public static CTTextNormalAutofit newInstance(XmlOptions param1XmlOptions) {
      return (CTTextNormalAutofit)POIXMLTypeLoader.newInstance(CTTextNormalAutofit.type, param1XmlOptions);
    }
    
    public static CTTextNormalAutofit parse(String param1String) throws XmlException {
      return (CTTextNormalAutofit)POIXMLTypeLoader.parse(param1String, CTTextNormalAutofit.type, null);
    }
    
    public static CTTextNormalAutofit parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextNormalAutofit)POIXMLTypeLoader.parse(param1String, CTTextNormalAutofit.type, param1XmlOptions);
    }
    
    public static CTTextNormalAutofit parse(File param1File) throws XmlException, IOException {
      return (CTTextNormalAutofit)POIXMLTypeLoader.parse(param1File, CTTextNormalAutofit.type, null);
    }
    
    public static CTTextNormalAutofit parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextNormalAutofit)POIXMLTypeLoader.parse(param1File, CTTextNormalAutofit.type, param1XmlOptions);
    }
    
    public static CTTextNormalAutofit parse(URL param1URL) throws XmlException, IOException {
      return (CTTextNormalAutofit)POIXMLTypeLoader.parse(param1URL, CTTextNormalAutofit.type, null);
    }
    
    public static CTTextNormalAutofit parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextNormalAutofit)POIXMLTypeLoader.parse(param1URL, CTTextNormalAutofit.type, param1XmlOptions);
    }
    
    public static CTTextNormalAutofit parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTextNormalAutofit)POIXMLTypeLoader.parse(param1InputStream, CTTextNormalAutofit.type, null);
    }
    
    public static CTTextNormalAutofit parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextNormalAutofit)POIXMLTypeLoader.parse(param1InputStream, CTTextNormalAutofit.type, param1XmlOptions);
    }
    
    public static CTTextNormalAutofit parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTextNormalAutofit)POIXMLTypeLoader.parse(param1Reader, CTTextNormalAutofit.type, null);
    }
    
    public static CTTextNormalAutofit parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextNormalAutofit)POIXMLTypeLoader.parse(param1Reader, CTTextNormalAutofit.type, param1XmlOptions);
    }
    
    public static CTTextNormalAutofit parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTextNormalAutofit)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextNormalAutofit.type, null);
    }
    
    public static CTTextNormalAutofit parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextNormalAutofit)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextNormalAutofit.type, param1XmlOptions);
    }
    
    public static CTTextNormalAutofit parse(Node param1Node) throws XmlException {
      return (CTTextNormalAutofit)POIXMLTypeLoader.parse(param1Node, CTTextNormalAutofit.type, null);
    }
    
    public static CTTextNormalAutofit parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextNormalAutofit)POIXMLTypeLoader.parse(param1Node, CTTextNormalAutofit.type, param1XmlOptions);
    }
    
    public static CTTextNormalAutofit parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTextNormalAutofit)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextNormalAutofit.type, null);
    }
    
    public static CTTextNormalAutofit parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTextNormalAutofit)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextNormalAutofit.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextNormalAutofit.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextNormalAutofit.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTTextNormalAutofit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */