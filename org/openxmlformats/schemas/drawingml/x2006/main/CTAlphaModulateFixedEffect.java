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

public interface CTAlphaModulateFixedEffect extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTAlphaModulateFixedEffect.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctalphamodulatefixedeffect9769type");
  
  int getAmt();
  
  STPositivePercentage xgetAmt();
  
  boolean isSetAmt();
  
  void setAmt(int paramInt);
  
  void xsetAmt(STPositivePercentage paramSTPositivePercentage);
  
  void unsetAmt();
  
  public static final class Factory {
    public static CTAlphaModulateFixedEffect newInstance() {
      return (CTAlphaModulateFixedEffect)POIXMLTypeLoader.newInstance(CTAlphaModulateFixedEffect.type, null);
    }
    
    public static CTAlphaModulateFixedEffect newInstance(XmlOptions param1XmlOptions) {
      return (CTAlphaModulateFixedEffect)POIXMLTypeLoader.newInstance(CTAlphaModulateFixedEffect.type, param1XmlOptions);
    }
    
    public static CTAlphaModulateFixedEffect parse(String param1String) throws XmlException {
      return (CTAlphaModulateFixedEffect)POIXMLTypeLoader.parse(param1String, CTAlphaModulateFixedEffect.type, null);
    }
    
    public static CTAlphaModulateFixedEffect parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTAlphaModulateFixedEffect)POIXMLTypeLoader.parse(param1String, CTAlphaModulateFixedEffect.type, param1XmlOptions);
    }
    
    public static CTAlphaModulateFixedEffect parse(File param1File) throws XmlException, IOException {
      return (CTAlphaModulateFixedEffect)POIXMLTypeLoader.parse(param1File, CTAlphaModulateFixedEffect.type, null);
    }
    
    public static CTAlphaModulateFixedEffect parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTAlphaModulateFixedEffect)POIXMLTypeLoader.parse(param1File, CTAlphaModulateFixedEffect.type, param1XmlOptions);
    }
    
    public static CTAlphaModulateFixedEffect parse(URL param1URL) throws XmlException, IOException {
      return (CTAlphaModulateFixedEffect)POIXMLTypeLoader.parse(param1URL, CTAlphaModulateFixedEffect.type, null);
    }
    
    public static CTAlphaModulateFixedEffect parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTAlphaModulateFixedEffect)POIXMLTypeLoader.parse(param1URL, CTAlphaModulateFixedEffect.type, param1XmlOptions);
    }
    
    public static CTAlphaModulateFixedEffect parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTAlphaModulateFixedEffect)POIXMLTypeLoader.parse(param1InputStream, CTAlphaModulateFixedEffect.type, null);
    }
    
    public static CTAlphaModulateFixedEffect parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTAlphaModulateFixedEffect)POIXMLTypeLoader.parse(param1InputStream, CTAlphaModulateFixedEffect.type, param1XmlOptions);
    }
    
    public static CTAlphaModulateFixedEffect parse(Reader param1Reader) throws XmlException, IOException {
      return (CTAlphaModulateFixedEffect)POIXMLTypeLoader.parse(param1Reader, CTAlphaModulateFixedEffect.type, null);
    }
    
    public static CTAlphaModulateFixedEffect parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTAlphaModulateFixedEffect)POIXMLTypeLoader.parse(param1Reader, CTAlphaModulateFixedEffect.type, param1XmlOptions);
    }
    
    public static CTAlphaModulateFixedEffect parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTAlphaModulateFixedEffect)POIXMLTypeLoader.parse(param1XMLStreamReader, CTAlphaModulateFixedEffect.type, null);
    }
    
    public static CTAlphaModulateFixedEffect parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTAlphaModulateFixedEffect)POIXMLTypeLoader.parse(param1XMLStreamReader, CTAlphaModulateFixedEffect.type, param1XmlOptions);
    }
    
    public static CTAlphaModulateFixedEffect parse(Node param1Node) throws XmlException {
      return (CTAlphaModulateFixedEffect)POIXMLTypeLoader.parse(param1Node, CTAlphaModulateFixedEffect.type, null);
    }
    
    public static CTAlphaModulateFixedEffect parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTAlphaModulateFixedEffect)POIXMLTypeLoader.parse(param1Node, CTAlphaModulateFixedEffect.type, param1XmlOptions);
    }
    
    public static CTAlphaModulateFixedEffect parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTAlphaModulateFixedEffect)POIXMLTypeLoader.parse(param1XMLInputStream, CTAlphaModulateFixedEffect.type, null);
    }
    
    public static CTAlphaModulateFixedEffect parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTAlphaModulateFixedEffect)POIXMLTypeLoader.parse(param1XMLInputStream, CTAlphaModulateFixedEffect.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTAlphaModulateFixedEffect.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTAlphaModulateFixedEffect.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTAlphaModulateFixedEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */