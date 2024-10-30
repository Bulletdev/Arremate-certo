package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
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

public interface CTStyle extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTStyle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctstyle41c1type");
  
  CTString getName();
  
  boolean isSetName();
  
  void setName(CTString paramCTString);
  
  CTString addNewName();
  
  void unsetName();
  
  CTString getAliases();
  
  boolean isSetAliases();
  
  void setAliases(CTString paramCTString);
  
  CTString addNewAliases();
  
  void unsetAliases();
  
  CTString getBasedOn();
  
  boolean isSetBasedOn();
  
  void setBasedOn(CTString paramCTString);
  
  CTString addNewBasedOn();
  
  void unsetBasedOn();
  
  CTString getNext();
  
  boolean isSetNext();
  
  void setNext(CTString paramCTString);
  
  CTString addNewNext();
  
  void unsetNext();
  
  CTString getLink();
  
  boolean isSetLink();
  
  void setLink(CTString paramCTString);
  
  CTString addNewLink();
  
  void unsetLink();
  
  CTOnOff getAutoRedefine();
  
  boolean isSetAutoRedefine();
  
  void setAutoRedefine(CTOnOff paramCTOnOff);
  
  CTOnOff addNewAutoRedefine();
  
  void unsetAutoRedefine();
  
  CTOnOff getHidden();
  
  boolean isSetHidden();
  
  void setHidden(CTOnOff paramCTOnOff);
  
  CTOnOff addNewHidden();
  
  void unsetHidden();
  
  CTDecimalNumber getUiPriority();
  
  boolean isSetUiPriority();
  
  void setUiPriority(CTDecimalNumber paramCTDecimalNumber);
  
  CTDecimalNumber addNewUiPriority();
  
  void unsetUiPriority();
  
  CTOnOff getSemiHidden();
  
  boolean isSetSemiHidden();
  
  void setSemiHidden(CTOnOff paramCTOnOff);
  
  CTOnOff addNewSemiHidden();
  
  void unsetSemiHidden();
  
  CTOnOff getUnhideWhenUsed();
  
  boolean isSetUnhideWhenUsed();
  
  void setUnhideWhenUsed(CTOnOff paramCTOnOff);
  
  CTOnOff addNewUnhideWhenUsed();
  
  void unsetUnhideWhenUsed();
  
  CTOnOff getQFormat();
  
  boolean isSetQFormat();
  
  void setQFormat(CTOnOff paramCTOnOff);
  
  CTOnOff addNewQFormat();
  
  void unsetQFormat();
  
  CTOnOff getLocked();
  
  boolean isSetLocked();
  
  void setLocked(CTOnOff paramCTOnOff);
  
  CTOnOff addNewLocked();
  
  void unsetLocked();
  
  CTOnOff getPersonal();
  
  boolean isSetPersonal();
  
  void setPersonal(CTOnOff paramCTOnOff);
  
  CTOnOff addNewPersonal();
  
  void unsetPersonal();
  
  CTOnOff getPersonalCompose();
  
  boolean isSetPersonalCompose();
  
  void setPersonalCompose(CTOnOff paramCTOnOff);
  
  CTOnOff addNewPersonalCompose();
  
  void unsetPersonalCompose();
  
  CTOnOff getPersonalReply();
  
  boolean isSetPersonalReply();
  
  void setPersonalReply(CTOnOff paramCTOnOff);
  
  CTOnOff addNewPersonalReply();
  
  void unsetPersonalReply();
  
  CTLongHexNumber getRsid();
  
  boolean isSetRsid();
  
  void setRsid(CTLongHexNumber paramCTLongHexNumber);
  
  CTLongHexNumber addNewRsid();
  
  void unsetRsid();
  
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
  
  CTTblPrBase getTblPr();
  
  boolean isSetTblPr();
  
  void setTblPr(CTTblPrBase paramCTTblPrBase);
  
  CTTblPrBase addNewTblPr();
  
  void unsetTblPr();
  
  CTTrPr getTrPr();
  
  boolean isSetTrPr();
  
  void setTrPr(CTTrPr paramCTTrPr);
  
  CTTrPr addNewTrPr();
  
  void unsetTrPr();
  
  CTTcPr getTcPr();
  
  boolean isSetTcPr();
  
  void setTcPr(CTTcPr paramCTTcPr);
  
  CTTcPr addNewTcPr();
  
  void unsetTcPr();
  
  List<CTTblStylePr> getTblStylePrList();
  
  CTTblStylePr[] getTblStylePrArray();
  
  CTTblStylePr getTblStylePrArray(int paramInt);
  
  int sizeOfTblStylePrArray();
  
  void setTblStylePrArray(CTTblStylePr[] paramArrayOfCTTblStylePr);
  
  void setTblStylePrArray(int paramInt, CTTblStylePr paramCTTblStylePr);
  
  CTTblStylePr insertNewTblStylePr(int paramInt);
  
  CTTblStylePr addNewTblStylePr();
  
  void removeTblStylePr(int paramInt);
  
  STStyleType.Enum getType();
  
  STStyleType xgetType();
  
  boolean isSetType();
  
  void setType(STStyleType.Enum paramEnum);
  
  void xsetType(STStyleType paramSTStyleType);
  
  void unsetType();
  
  String getStyleId();
  
  STString xgetStyleId();
  
  boolean isSetStyleId();
  
  void setStyleId(String paramString);
  
  void xsetStyleId(STString paramSTString);
  
  void unsetStyleId();
  
  STOnOff.Enum getDefault();
  
  STOnOff xgetDefault();
  
  boolean isSetDefault();
  
  void setDefault(STOnOff.Enum paramEnum);
  
  void xsetDefault(STOnOff paramSTOnOff);
  
  void unsetDefault();
  
  STOnOff.Enum getCustomStyle();
  
  STOnOff xgetCustomStyle();
  
  boolean isSetCustomStyle();
  
  void setCustomStyle(STOnOff.Enum paramEnum);
  
  void xsetCustomStyle(STOnOff paramSTOnOff);
  
  void unsetCustomStyle();
  
  public static final class Factory {
    public static CTStyle newInstance() {
      return (CTStyle)POIXMLTypeLoader.newInstance(CTStyle.type, null);
    }
    
    public static CTStyle newInstance(XmlOptions param1XmlOptions) {
      return (CTStyle)POIXMLTypeLoader.newInstance(CTStyle.type, param1XmlOptions);
    }
    
    public static CTStyle parse(String param1String) throws XmlException {
      return (CTStyle)POIXMLTypeLoader.parse(param1String, CTStyle.type, null);
    }
    
    public static CTStyle parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTStyle)POIXMLTypeLoader.parse(param1String, CTStyle.type, param1XmlOptions);
    }
    
    public static CTStyle parse(File param1File) throws XmlException, IOException {
      return (CTStyle)POIXMLTypeLoader.parse(param1File, CTStyle.type, null);
    }
    
    public static CTStyle parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStyle)POIXMLTypeLoader.parse(param1File, CTStyle.type, param1XmlOptions);
    }
    
    public static CTStyle parse(URL param1URL) throws XmlException, IOException {
      return (CTStyle)POIXMLTypeLoader.parse(param1URL, CTStyle.type, null);
    }
    
    public static CTStyle parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStyle)POIXMLTypeLoader.parse(param1URL, CTStyle.type, param1XmlOptions);
    }
    
    public static CTStyle parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTStyle)POIXMLTypeLoader.parse(param1InputStream, CTStyle.type, null);
    }
    
    public static CTStyle parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStyle)POIXMLTypeLoader.parse(param1InputStream, CTStyle.type, param1XmlOptions);
    }
    
    public static CTStyle parse(Reader param1Reader) throws XmlException, IOException {
      return (CTStyle)POIXMLTypeLoader.parse(param1Reader, CTStyle.type, null);
    }
    
    public static CTStyle parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStyle)POIXMLTypeLoader.parse(param1Reader, CTStyle.type, param1XmlOptions);
    }
    
    public static CTStyle parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTStyle)POIXMLTypeLoader.parse(param1XMLStreamReader, CTStyle.type, null);
    }
    
    public static CTStyle parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTStyle)POIXMLTypeLoader.parse(param1XMLStreamReader, CTStyle.type, param1XmlOptions);
    }
    
    public static CTStyle parse(Node param1Node) throws XmlException {
      return (CTStyle)POIXMLTypeLoader.parse(param1Node, CTStyle.type, null);
    }
    
    public static CTStyle parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTStyle)POIXMLTypeLoader.parse(param1Node, CTStyle.type, param1XmlOptions);
    }
    
    public static CTStyle parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTStyle)POIXMLTypeLoader.parse(param1XMLInputStream, CTStyle.type, null);
    }
    
    public static CTStyle parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTStyle)POIXMLTypeLoader.parse(param1XMLInputStream, CTStyle.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTStyle.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTStyle.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */