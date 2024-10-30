package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTItem extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTItem.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctitemc69ctype");
  
  String getN();
  
  STXstring xgetN();
  
  boolean isSetN();
  
  void setN(String paramString);
  
  void xsetN(STXstring paramSTXstring);
  
  void unsetN();
  
  STItemType.Enum getT();
  
  STItemType xgetT();
  
  boolean isSetT();
  
  void setT(STItemType.Enum paramEnum);
  
  void xsetT(STItemType paramSTItemType);
  
  void unsetT();
  
  boolean getH();
  
  XmlBoolean xgetH();
  
  boolean isSetH();
  
  void setH(boolean paramBoolean);
  
  void xsetH(XmlBoolean paramXmlBoolean);
  
  void unsetH();
  
  boolean getS();
  
  XmlBoolean xgetS();
  
  boolean isSetS();
  
  void setS(boolean paramBoolean);
  
  void xsetS(XmlBoolean paramXmlBoolean);
  
  void unsetS();
  
  boolean getSd();
  
  XmlBoolean xgetSd();
  
  boolean isSetSd();
  
  void setSd(boolean paramBoolean);
  
  void xsetSd(XmlBoolean paramXmlBoolean);
  
  void unsetSd();
  
  boolean getF();
  
  XmlBoolean xgetF();
  
  boolean isSetF();
  
  void setF(boolean paramBoolean);
  
  void xsetF(XmlBoolean paramXmlBoolean);
  
  void unsetF();
  
  boolean getM();
  
  XmlBoolean xgetM();
  
  boolean isSetM();
  
  void setM(boolean paramBoolean);
  
  void xsetM(XmlBoolean paramXmlBoolean);
  
  void unsetM();
  
  boolean getC();
  
  XmlBoolean xgetC();
  
  boolean isSetC();
  
  void setC(boolean paramBoolean);
  
  void xsetC(XmlBoolean paramXmlBoolean);
  
  void unsetC();
  
  long getX();
  
  XmlUnsignedInt xgetX();
  
  boolean isSetX();
  
  void setX(long paramLong);
  
  void xsetX(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetX();
  
  boolean getD();
  
  XmlBoolean xgetD();
  
  boolean isSetD();
  
  void setD(boolean paramBoolean);
  
  void xsetD(XmlBoolean paramXmlBoolean);
  
  void unsetD();
  
  boolean getE();
  
  XmlBoolean xgetE();
  
  boolean isSetE();
  
  void setE(boolean paramBoolean);
  
  void xsetE(XmlBoolean paramXmlBoolean);
  
  void unsetE();
  
  public static final class Factory {
    public static CTItem newInstance() {
      return (CTItem)POIXMLTypeLoader.newInstance(CTItem.type, null);
    }
    
    public static CTItem newInstance(XmlOptions param1XmlOptions) {
      return (CTItem)POIXMLTypeLoader.newInstance(CTItem.type, param1XmlOptions);
    }
    
    public static CTItem parse(String param1String) throws XmlException {
      return (CTItem)POIXMLTypeLoader.parse(param1String, CTItem.type, null);
    }
    
    public static CTItem parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTItem)POIXMLTypeLoader.parse(param1String, CTItem.type, param1XmlOptions);
    }
    
    public static CTItem parse(File param1File) throws XmlException, IOException {
      return (CTItem)POIXMLTypeLoader.parse(param1File, CTItem.type, null);
    }
    
    public static CTItem parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTItem)POIXMLTypeLoader.parse(param1File, CTItem.type, param1XmlOptions);
    }
    
    public static CTItem parse(URL param1URL) throws XmlException, IOException {
      return (CTItem)POIXMLTypeLoader.parse(param1URL, CTItem.type, null);
    }
    
    public static CTItem parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTItem)POIXMLTypeLoader.parse(param1URL, CTItem.type, param1XmlOptions);
    }
    
    public static CTItem parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTItem)POIXMLTypeLoader.parse(param1InputStream, CTItem.type, null);
    }
    
    public static CTItem parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTItem)POIXMLTypeLoader.parse(param1InputStream, CTItem.type, param1XmlOptions);
    }
    
    public static CTItem parse(Reader param1Reader) throws XmlException, IOException {
      return (CTItem)POIXMLTypeLoader.parse(param1Reader, CTItem.type, null);
    }
    
    public static CTItem parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTItem)POIXMLTypeLoader.parse(param1Reader, CTItem.type, param1XmlOptions);
    }
    
    public static CTItem parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTItem)POIXMLTypeLoader.parse(param1XMLStreamReader, CTItem.type, null);
    }
    
    public static CTItem parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTItem)POIXMLTypeLoader.parse(param1XMLStreamReader, CTItem.type, param1XmlOptions);
    }
    
    public static CTItem parse(Node param1Node) throws XmlException {
      return (CTItem)POIXMLTypeLoader.parse(param1Node, CTItem.type, null);
    }
    
    public static CTItem parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTItem)POIXMLTypeLoader.parse(param1Node, CTItem.type, param1XmlOptions);
    }
    
    public static CTItem parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTItem)POIXMLTypeLoader.parse(param1XMLInputStream, CTItem.type, null);
    }
    
    public static CTItem parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTItem)POIXMLTypeLoader.parse(param1XMLInputStream, CTItem.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTItem.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTItem.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */