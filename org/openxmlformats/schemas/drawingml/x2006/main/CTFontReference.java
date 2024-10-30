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

public interface CTFontReference extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTFontReference.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctfontreferencef5adtype");
  
  CTScRgbColor getScrgbClr();
  
  boolean isSetScrgbClr();
  
  void setScrgbClr(CTScRgbColor paramCTScRgbColor);
  
  CTScRgbColor addNewScrgbClr();
  
  void unsetScrgbClr();
  
  CTSRgbColor getSrgbClr();
  
  boolean isSetSrgbClr();
  
  void setSrgbClr(CTSRgbColor paramCTSRgbColor);
  
  CTSRgbColor addNewSrgbClr();
  
  void unsetSrgbClr();
  
  CTHslColor getHslClr();
  
  boolean isSetHslClr();
  
  void setHslClr(CTHslColor paramCTHslColor);
  
  CTHslColor addNewHslClr();
  
  void unsetHslClr();
  
  CTSystemColor getSysClr();
  
  boolean isSetSysClr();
  
  void setSysClr(CTSystemColor paramCTSystemColor);
  
  CTSystemColor addNewSysClr();
  
  void unsetSysClr();
  
  CTSchemeColor getSchemeClr();
  
  boolean isSetSchemeClr();
  
  void setSchemeClr(CTSchemeColor paramCTSchemeColor);
  
  CTSchemeColor addNewSchemeClr();
  
  void unsetSchemeClr();
  
  CTPresetColor getPrstClr();
  
  boolean isSetPrstClr();
  
  void setPrstClr(CTPresetColor paramCTPresetColor);
  
  CTPresetColor addNewPrstClr();
  
  void unsetPrstClr();
  
  STFontCollectionIndex.Enum getIdx();
  
  STFontCollectionIndex xgetIdx();
  
  void setIdx(STFontCollectionIndex.Enum paramEnum);
  
  void xsetIdx(STFontCollectionIndex paramSTFontCollectionIndex);
  
  public static final class Factory {
    public static CTFontReference newInstance() {
      return (CTFontReference)POIXMLTypeLoader.newInstance(CTFontReference.type, null);
    }
    
    public static CTFontReference newInstance(XmlOptions param1XmlOptions) {
      return (CTFontReference)POIXMLTypeLoader.newInstance(CTFontReference.type, param1XmlOptions);
    }
    
    public static CTFontReference parse(String param1String) throws XmlException {
      return (CTFontReference)POIXMLTypeLoader.parse(param1String, CTFontReference.type, null);
    }
    
    public static CTFontReference parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFontReference)POIXMLTypeLoader.parse(param1String, CTFontReference.type, param1XmlOptions);
    }
    
    public static CTFontReference parse(File param1File) throws XmlException, IOException {
      return (CTFontReference)POIXMLTypeLoader.parse(param1File, CTFontReference.type, null);
    }
    
    public static CTFontReference parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFontReference)POIXMLTypeLoader.parse(param1File, CTFontReference.type, param1XmlOptions);
    }
    
    public static CTFontReference parse(URL param1URL) throws XmlException, IOException {
      return (CTFontReference)POIXMLTypeLoader.parse(param1URL, CTFontReference.type, null);
    }
    
    public static CTFontReference parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFontReference)POIXMLTypeLoader.parse(param1URL, CTFontReference.type, param1XmlOptions);
    }
    
    public static CTFontReference parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTFontReference)POIXMLTypeLoader.parse(param1InputStream, CTFontReference.type, null);
    }
    
    public static CTFontReference parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFontReference)POIXMLTypeLoader.parse(param1InputStream, CTFontReference.type, param1XmlOptions);
    }
    
    public static CTFontReference parse(Reader param1Reader) throws XmlException, IOException {
      return (CTFontReference)POIXMLTypeLoader.parse(param1Reader, CTFontReference.type, null);
    }
    
    public static CTFontReference parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFontReference)POIXMLTypeLoader.parse(param1Reader, CTFontReference.type, param1XmlOptions);
    }
    
    public static CTFontReference parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTFontReference)POIXMLTypeLoader.parse(param1XMLStreamReader, CTFontReference.type, null);
    }
    
    public static CTFontReference parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFontReference)POIXMLTypeLoader.parse(param1XMLStreamReader, CTFontReference.type, param1XmlOptions);
    }
    
    public static CTFontReference parse(Node param1Node) throws XmlException {
      return (CTFontReference)POIXMLTypeLoader.parse(param1Node, CTFontReference.type, null);
    }
    
    public static CTFontReference parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFontReference)POIXMLTypeLoader.parse(param1Node, CTFontReference.type, param1XmlOptions);
    }
    
    public static CTFontReference parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTFontReference)POIXMLTypeLoader.parse(param1XMLInputStream, CTFontReference.type, null);
    }
    
    public static CTFontReference parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTFontReference)POIXMLTypeLoader.parse(param1XMLInputStream, CTFontReference.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTFontReference.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTFontReference.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTFontReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */