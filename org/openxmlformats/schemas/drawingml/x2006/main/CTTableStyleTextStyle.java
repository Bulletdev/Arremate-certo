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

public interface CTTableStyleTextStyle extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTableStyleTextStyle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttablestyletextstylec932type");
  
  CTFontCollection getFont();
  
  boolean isSetFont();
  
  void setFont(CTFontCollection paramCTFontCollection);
  
  CTFontCollection addNewFont();
  
  void unsetFont();
  
  CTFontReference getFontRef();
  
  boolean isSetFontRef();
  
  void setFontRef(CTFontReference paramCTFontReference);
  
  CTFontReference addNewFontRef();
  
  void unsetFontRef();
  
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
  
  CTOfficeArtExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList);
  
  CTOfficeArtExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  STOnOffStyleType.Enum getB();
  
  STOnOffStyleType xgetB();
  
  boolean isSetB();
  
  void setB(STOnOffStyleType.Enum paramEnum);
  
  void xsetB(STOnOffStyleType paramSTOnOffStyleType);
  
  void unsetB();
  
  STOnOffStyleType.Enum getI();
  
  STOnOffStyleType xgetI();
  
  boolean isSetI();
  
  void setI(STOnOffStyleType.Enum paramEnum);
  
  void xsetI(STOnOffStyleType paramSTOnOffStyleType);
  
  void unsetI();
  
  public static final class Factory {
    public static CTTableStyleTextStyle newInstance() {
      return (CTTableStyleTextStyle)POIXMLTypeLoader.newInstance(CTTableStyleTextStyle.type, null);
    }
    
    public static CTTableStyleTextStyle newInstance(XmlOptions param1XmlOptions) {
      return (CTTableStyleTextStyle)POIXMLTypeLoader.newInstance(CTTableStyleTextStyle.type, param1XmlOptions);
    }
    
    public static CTTableStyleTextStyle parse(String param1String) throws XmlException {
      return (CTTableStyleTextStyle)POIXMLTypeLoader.parse(param1String, CTTableStyleTextStyle.type, null);
    }
    
    public static CTTableStyleTextStyle parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableStyleTextStyle)POIXMLTypeLoader.parse(param1String, CTTableStyleTextStyle.type, param1XmlOptions);
    }
    
    public static CTTableStyleTextStyle parse(File param1File) throws XmlException, IOException {
      return (CTTableStyleTextStyle)POIXMLTypeLoader.parse(param1File, CTTableStyleTextStyle.type, null);
    }
    
    public static CTTableStyleTextStyle parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableStyleTextStyle)POIXMLTypeLoader.parse(param1File, CTTableStyleTextStyle.type, param1XmlOptions);
    }
    
    public static CTTableStyleTextStyle parse(URL param1URL) throws XmlException, IOException {
      return (CTTableStyleTextStyle)POIXMLTypeLoader.parse(param1URL, CTTableStyleTextStyle.type, null);
    }
    
    public static CTTableStyleTextStyle parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableStyleTextStyle)POIXMLTypeLoader.parse(param1URL, CTTableStyleTextStyle.type, param1XmlOptions);
    }
    
    public static CTTableStyleTextStyle parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTableStyleTextStyle)POIXMLTypeLoader.parse(param1InputStream, CTTableStyleTextStyle.type, null);
    }
    
    public static CTTableStyleTextStyle parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableStyleTextStyle)POIXMLTypeLoader.parse(param1InputStream, CTTableStyleTextStyle.type, param1XmlOptions);
    }
    
    public static CTTableStyleTextStyle parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTableStyleTextStyle)POIXMLTypeLoader.parse(param1Reader, CTTableStyleTextStyle.type, null);
    }
    
    public static CTTableStyleTextStyle parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableStyleTextStyle)POIXMLTypeLoader.parse(param1Reader, CTTableStyleTextStyle.type, param1XmlOptions);
    }
    
    public static CTTableStyleTextStyle parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTableStyleTextStyle)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTableStyleTextStyle.type, null);
    }
    
    public static CTTableStyleTextStyle parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableStyleTextStyle)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTableStyleTextStyle.type, param1XmlOptions);
    }
    
    public static CTTableStyleTextStyle parse(Node param1Node) throws XmlException {
      return (CTTableStyleTextStyle)POIXMLTypeLoader.parse(param1Node, CTTableStyleTextStyle.type, null);
    }
    
    public static CTTableStyleTextStyle parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableStyleTextStyle)POIXMLTypeLoader.parse(param1Node, CTTableStyleTextStyle.type, param1XmlOptions);
    }
    
    public static CTTableStyleTextStyle parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTableStyleTextStyle)POIXMLTypeLoader.parse(param1XMLInputStream, CTTableStyleTextStyle.type, null);
    }
    
    public static CTTableStyleTextStyle parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTableStyleTextStyle)POIXMLTypeLoader.parse(param1XMLInputStream, CTTableStyleTextStyle.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTableStyleTextStyle.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTableStyleTextStyle.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTTableStyleTextStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */