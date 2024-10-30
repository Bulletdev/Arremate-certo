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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTStyleMatrix extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTStyleMatrix.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctstylematrix1903type");
  
  CTFillStyleList getFillStyleLst();
  
  void setFillStyleLst(CTFillStyleList paramCTFillStyleList);
  
  CTFillStyleList addNewFillStyleLst();
  
  CTLineStyleList getLnStyleLst();
  
  void setLnStyleLst(CTLineStyleList paramCTLineStyleList);
  
  CTLineStyleList addNewLnStyleLst();
  
  CTEffectStyleList getEffectStyleLst();
  
  void setEffectStyleLst(CTEffectStyleList paramCTEffectStyleList);
  
  CTEffectStyleList addNewEffectStyleLst();
  
  CTBackgroundFillStyleList getBgFillStyleLst();
  
  void setBgFillStyleLst(CTBackgroundFillStyleList paramCTBackgroundFillStyleList);
  
  CTBackgroundFillStyleList addNewBgFillStyleLst();
  
  String getName();
  
  XmlString xgetName();
  
  boolean isSetName();
  
  void setName(String paramString);
  
  void xsetName(XmlString paramXmlString);
  
  void unsetName();
  
  public static final class Factory {
    public static CTStyleMatrix newInstance() {
      return (CTStyleMatrix)POIXMLTypeLoader.newInstance(CTStyleMatrix.type, null);
    }
    
    public static CTStyleMatrix newInstance(XmlOptions param1XmlOptions) {
      return (CTStyleMatrix)POIXMLTypeLoader.newInstance(CTStyleMatrix.type, param1XmlOptions);
    }
    
    public static CTStyleMatrix parse(String param1String) throws XmlException {
      return (CTStyleMatrix)POIXMLTypeLoader.parse(param1String, CTStyleMatrix.type, null);
    }
    
    public static CTStyleMatrix parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTStyleMatrix)POIXMLTypeLoader.parse(param1String, CTStyleMatrix.type, param1XmlOptions);
    }
    
    public static CTStyleMatrix parse(File param1File) throws XmlException, IOException {
      return (CTStyleMatrix)POIXMLTypeLoader.parse(param1File, CTStyleMatrix.type, null);
    }
    
    public static CTStyleMatrix parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStyleMatrix)POIXMLTypeLoader.parse(param1File, CTStyleMatrix.type, param1XmlOptions);
    }
    
    public static CTStyleMatrix parse(URL param1URL) throws XmlException, IOException {
      return (CTStyleMatrix)POIXMLTypeLoader.parse(param1URL, CTStyleMatrix.type, null);
    }
    
    public static CTStyleMatrix parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStyleMatrix)POIXMLTypeLoader.parse(param1URL, CTStyleMatrix.type, param1XmlOptions);
    }
    
    public static CTStyleMatrix parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTStyleMatrix)POIXMLTypeLoader.parse(param1InputStream, CTStyleMatrix.type, null);
    }
    
    public static CTStyleMatrix parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStyleMatrix)POIXMLTypeLoader.parse(param1InputStream, CTStyleMatrix.type, param1XmlOptions);
    }
    
    public static CTStyleMatrix parse(Reader param1Reader) throws XmlException, IOException {
      return (CTStyleMatrix)POIXMLTypeLoader.parse(param1Reader, CTStyleMatrix.type, null);
    }
    
    public static CTStyleMatrix parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStyleMatrix)POIXMLTypeLoader.parse(param1Reader, CTStyleMatrix.type, param1XmlOptions);
    }
    
    public static CTStyleMatrix parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTStyleMatrix)POIXMLTypeLoader.parse(param1XMLStreamReader, CTStyleMatrix.type, null);
    }
    
    public static CTStyleMatrix parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTStyleMatrix)POIXMLTypeLoader.parse(param1XMLStreamReader, CTStyleMatrix.type, param1XmlOptions);
    }
    
    public static CTStyleMatrix parse(Node param1Node) throws XmlException {
      return (CTStyleMatrix)POIXMLTypeLoader.parse(param1Node, CTStyleMatrix.type, null);
    }
    
    public static CTStyleMatrix parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTStyleMatrix)POIXMLTypeLoader.parse(param1Node, CTStyleMatrix.type, param1XmlOptions);
    }
    
    public static CTStyleMatrix parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTStyleMatrix)POIXMLTypeLoader.parse(param1XMLInputStream, CTStyleMatrix.type, null);
    }
    
    public static CTStyleMatrix parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTStyleMatrix)POIXMLTypeLoader.parse(param1XMLInputStream, CTStyleMatrix.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTStyleMatrix.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTStyleMatrix.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTStyleMatrix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */