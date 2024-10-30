package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
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

public interface CTLvl extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTLvl.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctlvlf630type");
  
  CTDecimalNumber getStart();
  
  boolean isSetStart();
  
  void setStart(CTDecimalNumber paramCTDecimalNumber);
  
  CTDecimalNumber addNewStart();
  
  void unsetStart();
  
  CTNumFmt getNumFmt();
  
  boolean isSetNumFmt();
  
  void setNumFmt(CTNumFmt paramCTNumFmt);
  
  CTNumFmt addNewNumFmt();
  
  void unsetNumFmt();
  
  CTDecimalNumber getLvlRestart();
  
  boolean isSetLvlRestart();
  
  void setLvlRestart(CTDecimalNumber paramCTDecimalNumber);
  
  CTDecimalNumber addNewLvlRestart();
  
  void unsetLvlRestart();
  
  CTString getPStyle();
  
  boolean isSetPStyle();
  
  void setPStyle(CTString paramCTString);
  
  CTString addNewPStyle();
  
  void unsetPStyle();
  
  CTOnOff getIsLgl();
  
  boolean isSetIsLgl();
  
  void setIsLgl(CTOnOff paramCTOnOff);
  
  CTOnOff addNewIsLgl();
  
  void unsetIsLgl();
  
  CTLevelSuffix getSuff();
  
  boolean isSetSuff();
  
  void setSuff(CTLevelSuffix paramCTLevelSuffix);
  
  CTLevelSuffix addNewSuff();
  
  void unsetSuff();
  
  CTLevelText getLvlText();
  
  boolean isSetLvlText();
  
  void setLvlText(CTLevelText paramCTLevelText);
  
  CTLevelText addNewLvlText();
  
  void unsetLvlText();
  
  CTDecimalNumber getLvlPicBulletId();
  
  boolean isSetLvlPicBulletId();
  
  void setLvlPicBulletId(CTDecimalNumber paramCTDecimalNumber);
  
  CTDecimalNumber addNewLvlPicBulletId();
  
  void unsetLvlPicBulletId();
  
  CTLvlLegacy getLegacy();
  
  boolean isSetLegacy();
  
  void setLegacy(CTLvlLegacy paramCTLvlLegacy);
  
  CTLvlLegacy addNewLegacy();
  
  void unsetLegacy();
  
  CTJc getLvlJc();
  
  boolean isSetLvlJc();
  
  void setLvlJc(CTJc paramCTJc);
  
  CTJc addNewLvlJc();
  
  void unsetLvlJc();
  
  CTPPr getPPr();
  
  boolean isSetPPr();
  
  void setPPr(CTPPr paramCTPPr);
  
  CTPPr addNewPPr();
  
  void unsetPPr();
  
  CTRPr getRPr();
  
  boolean isSetRPr();
  
  void setRPr(CTRPr paramCTRPr);
  
  CTRPr addNewRPr();
  
  void unsetRPr();
  
  BigInteger getIlvl();
  
  STDecimalNumber xgetIlvl();
  
  void setIlvl(BigInteger paramBigInteger);
  
  void xsetIlvl(STDecimalNumber paramSTDecimalNumber);
  
  byte[] getTplc();
  
  STLongHexNumber xgetTplc();
  
  boolean isSetTplc();
  
  void setTplc(byte[] paramArrayOfbyte);
  
  void xsetTplc(STLongHexNumber paramSTLongHexNumber);
  
  void unsetTplc();
  
  STOnOff.Enum getTentative();
  
  STOnOff xgetTentative();
  
  boolean isSetTentative();
  
  void setTentative(STOnOff.Enum paramEnum);
  
  void xsetTentative(STOnOff paramSTOnOff);
  
  void unsetTentative();
  
  public static final class Factory {
    public static CTLvl newInstance() {
      return (CTLvl)POIXMLTypeLoader.newInstance(CTLvl.type, null);
    }
    
    public static CTLvl newInstance(XmlOptions param1XmlOptions) {
      return (CTLvl)POIXMLTypeLoader.newInstance(CTLvl.type, param1XmlOptions);
    }
    
    public static CTLvl parse(String param1String) throws XmlException {
      return (CTLvl)POIXMLTypeLoader.parse(param1String, CTLvl.type, null);
    }
    
    public static CTLvl parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLvl)POIXMLTypeLoader.parse(param1String, CTLvl.type, param1XmlOptions);
    }
    
    public static CTLvl parse(File param1File) throws XmlException, IOException {
      return (CTLvl)POIXMLTypeLoader.parse(param1File, CTLvl.type, null);
    }
    
    public static CTLvl parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLvl)POIXMLTypeLoader.parse(param1File, CTLvl.type, param1XmlOptions);
    }
    
    public static CTLvl parse(URL param1URL) throws XmlException, IOException {
      return (CTLvl)POIXMLTypeLoader.parse(param1URL, CTLvl.type, null);
    }
    
    public static CTLvl parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLvl)POIXMLTypeLoader.parse(param1URL, CTLvl.type, param1XmlOptions);
    }
    
    public static CTLvl parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTLvl)POIXMLTypeLoader.parse(param1InputStream, CTLvl.type, null);
    }
    
    public static CTLvl parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLvl)POIXMLTypeLoader.parse(param1InputStream, CTLvl.type, param1XmlOptions);
    }
    
    public static CTLvl parse(Reader param1Reader) throws XmlException, IOException {
      return (CTLvl)POIXMLTypeLoader.parse(param1Reader, CTLvl.type, null);
    }
    
    public static CTLvl parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLvl)POIXMLTypeLoader.parse(param1Reader, CTLvl.type, param1XmlOptions);
    }
    
    public static CTLvl parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTLvl)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLvl.type, null);
    }
    
    public static CTLvl parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLvl)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLvl.type, param1XmlOptions);
    }
    
    public static CTLvl parse(Node param1Node) throws XmlException {
      return (CTLvl)POIXMLTypeLoader.parse(param1Node, CTLvl.type, null);
    }
    
    public static CTLvl parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLvl)POIXMLTypeLoader.parse(param1Node, CTLvl.type, param1XmlOptions);
    }
    
    public static CTLvl parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTLvl)POIXMLTypeLoader.parse(param1XMLInputStream, CTLvl.type, null);
    }
    
    public static CTLvl parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTLvl)POIXMLTypeLoader.parse(param1XMLInputStream, CTLvl.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLvl.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLvl.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTLvl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */