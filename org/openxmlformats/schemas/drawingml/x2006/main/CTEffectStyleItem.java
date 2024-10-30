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

public interface CTEffectStyleItem extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTEffectStyleItem.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cteffectstyleitem05c4type");
  
  CTEffectList getEffectLst();
  
  boolean isSetEffectLst();
  
  void setEffectLst(CTEffectList paramCTEffectList);
  
  CTEffectList addNewEffectLst();
  
  void unsetEffectLst();
  
  CTEffectContainer getEffectDag();
  
  boolean isSetEffectDag();
  
  void setEffectDag(CTEffectContainer paramCTEffectContainer);
  
  CTEffectContainer addNewEffectDag();
  
  void unsetEffectDag();
  
  CTScene3D getScene3D();
  
  boolean isSetScene3D();
  
  void setScene3D(CTScene3D paramCTScene3D);
  
  CTScene3D addNewScene3D();
  
  void unsetScene3D();
  
  CTShape3D getSp3D();
  
  boolean isSetSp3D();
  
  void setSp3D(CTShape3D paramCTShape3D);
  
  CTShape3D addNewSp3D();
  
  void unsetSp3D();
  
  public static final class Factory {
    public static CTEffectStyleItem newInstance() {
      return (CTEffectStyleItem)POIXMLTypeLoader.newInstance(CTEffectStyleItem.type, null);
    }
    
    public static CTEffectStyleItem newInstance(XmlOptions param1XmlOptions) {
      return (CTEffectStyleItem)POIXMLTypeLoader.newInstance(CTEffectStyleItem.type, param1XmlOptions);
    }
    
    public static CTEffectStyleItem parse(String param1String) throws XmlException {
      return (CTEffectStyleItem)POIXMLTypeLoader.parse(param1String, CTEffectStyleItem.type, null);
    }
    
    public static CTEffectStyleItem parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTEffectStyleItem)POIXMLTypeLoader.parse(param1String, CTEffectStyleItem.type, param1XmlOptions);
    }
    
    public static CTEffectStyleItem parse(File param1File) throws XmlException, IOException {
      return (CTEffectStyleItem)POIXMLTypeLoader.parse(param1File, CTEffectStyleItem.type, null);
    }
    
    public static CTEffectStyleItem parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTEffectStyleItem)POIXMLTypeLoader.parse(param1File, CTEffectStyleItem.type, param1XmlOptions);
    }
    
    public static CTEffectStyleItem parse(URL param1URL) throws XmlException, IOException {
      return (CTEffectStyleItem)POIXMLTypeLoader.parse(param1URL, CTEffectStyleItem.type, null);
    }
    
    public static CTEffectStyleItem parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTEffectStyleItem)POIXMLTypeLoader.parse(param1URL, CTEffectStyleItem.type, param1XmlOptions);
    }
    
    public static CTEffectStyleItem parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTEffectStyleItem)POIXMLTypeLoader.parse(param1InputStream, CTEffectStyleItem.type, null);
    }
    
    public static CTEffectStyleItem parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTEffectStyleItem)POIXMLTypeLoader.parse(param1InputStream, CTEffectStyleItem.type, param1XmlOptions);
    }
    
    public static CTEffectStyleItem parse(Reader param1Reader) throws XmlException, IOException {
      return (CTEffectStyleItem)POIXMLTypeLoader.parse(param1Reader, CTEffectStyleItem.type, null);
    }
    
    public static CTEffectStyleItem parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTEffectStyleItem)POIXMLTypeLoader.parse(param1Reader, CTEffectStyleItem.type, param1XmlOptions);
    }
    
    public static CTEffectStyleItem parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTEffectStyleItem)POIXMLTypeLoader.parse(param1XMLStreamReader, CTEffectStyleItem.type, null);
    }
    
    public static CTEffectStyleItem parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTEffectStyleItem)POIXMLTypeLoader.parse(param1XMLStreamReader, CTEffectStyleItem.type, param1XmlOptions);
    }
    
    public static CTEffectStyleItem parse(Node param1Node) throws XmlException {
      return (CTEffectStyleItem)POIXMLTypeLoader.parse(param1Node, CTEffectStyleItem.type, null);
    }
    
    public static CTEffectStyleItem parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTEffectStyleItem)POIXMLTypeLoader.parse(param1Node, CTEffectStyleItem.type, param1XmlOptions);
    }
    
    public static CTEffectStyleItem parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTEffectStyleItem)POIXMLTypeLoader.parse(param1XMLInputStream, CTEffectStyleItem.type, null);
    }
    
    public static CTEffectStyleItem parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTEffectStyleItem)POIXMLTypeLoader.parse(param1XMLInputStream, CTEffectStyleItem.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTEffectStyleItem.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTEffectStyleItem.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTEffectStyleItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */