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
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTCalcCell extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTCalcCell.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcalccellb960type");
  
  String getR();
  
  STCellRef xgetR();
  
  void setR(String paramString);
  
  void xsetR(STCellRef paramSTCellRef);
  
  int getI();
  
  XmlInt xgetI();
  
  boolean isSetI();
  
  void setI(int paramInt);
  
  void xsetI(XmlInt paramXmlInt);
  
  void unsetI();
  
  boolean getS();
  
  XmlBoolean xgetS();
  
  boolean isSetS();
  
  void setS(boolean paramBoolean);
  
  void xsetS(XmlBoolean paramXmlBoolean);
  
  void unsetS();
  
  boolean getL();
  
  XmlBoolean xgetL();
  
  boolean isSetL();
  
  void setL(boolean paramBoolean);
  
  void xsetL(XmlBoolean paramXmlBoolean);
  
  void unsetL();
  
  boolean getT();
  
  XmlBoolean xgetT();
  
  boolean isSetT();
  
  void setT(boolean paramBoolean);
  
  void xsetT(XmlBoolean paramXmlBoolean);
  
  void unsetT();
  
  boolean getA();
  
  XmlBoolean xgetA();
  
  boolean isSetA();
  
  void setA(boolean paramBoolean);
  
  void xsetA(XmlBoolean paramXmlBoolean);
  
  void unsetA();
  
  public static final class Factory {
    public static CTCalcCell newInstance() {
      return (CTCalcCell)POIXMLTypeLoader.newInstance(CTCalcCell.type, null);
    }
    
    public static CTCalcCell newInstance(XmlOptions param1XmlOptions) {
      return (CTCalcCell)POIXMLTypeLoader.newInstance(CTCalcCell.type, param1XmlOptions);
    }
    
    public static CTCalcCell parse(String param1String) throws XmlException {
      return (CTCalcCell)POIXMLTypeLoader.parse(param1String, CTCalcCell.type, null);
    }
    
    public static CTCalcCell parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCalcCell)POIXMLTypeLoader.parse(param1String, CTCalcCell.type, param1XmlOptions);
    }
    
    public static CTCalcCell parse(File param1File) throws XmlException, IOException {
      return (CTCalcCell)POIXMLTypeLoader.parse(param1File, CTCalcCell.type, null);
    }
    
    public static CTCalcCell parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCalcCell)POIXMLTypeLoader.parse(param1File, CTCalcCell.type, param1XmlOptions);
    }
    
    public static CTCalcCell parse(URL param1URL) throws XmlException, IOException {
      return (CTCalcCell)POIXMLTypeLoader.parse(param1URL, CTCalcCell.type, null);
    }
    
    public static CTCalcCell parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCalcCell)POIXMLTypeLoader.parse(param1URL, CTCalcCell.type, param1XmlOptions);
    }
    
    public static CTCalcCell parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTCalcCell)POIXMLTypeLoader.parse(param1InputStream, CTCalcCell.type, null);
    }
    
    public static CTCalcCell parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCalcCell)POIXMLTypeLoader.parse(param1InputStream, CTCalcCell.type, param1XmlOptions);
    }
    
    public static CTCalcCell parse(Reader param1Reader) throws XmlException, IOException {
      return (CTCalcCell)POIXMLTypeLoader.parse(param1Reader, CTCalcCell.type, null);
    }
    
    public static CTCalcCell parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCalcCell)POIXMLTypeLoader.parse(param1Reader, CTCalcCell.type, param1XmlOptions);
    }
    
    public static CTCalcCell parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTCalcCell)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCalcCell.type, null);
    }
    
    public static CTCalcCell parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCalcCell)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCalcCell.type, param1XmlOptions);
    }
    
    public static CTCalcCell parse(Node param1Node) throws XmlException {
      return (CTCalcCell)POIXMLTypeLoader.parse(param1Node, CTCalcCell.type, null);
    }
    
    public static CTCalcCell parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCalcCell)POIXMLTypeLoader.parse(param1Node, CTCalcCell.type, param1XmlOptions);
    }
    
    public static CTCalcCell parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTCalcCell)POIXMLTypeLoader.parse(param1XMLInputStream, CTCalcCell.type, null);
    }
    
    public static CTCalcCell parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTCalcCell)POIXMLTypeLoader.parse(param1XMLInputStream, CTCalcCell.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCalcCell.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCalcCell.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTCalcCell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */