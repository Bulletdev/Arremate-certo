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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTTextCharacterProperties extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTextCharacterProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextcharacterproperties76c0type");
  
  CTLineProperties getLn();
  
  boolean isSetLn();
  
  void setLn(CTLineProperties paramCTLineProperties);
  
  CTLineProperties addNewLn();
  
  void unsetLn();
  
  CTNoFillProperties getNoFill();
  
  boolean isSetNoFill();
  
  void setNoFill(CTNoFillProperties paramCTNoFillProperties);
  
  CTNoFillProperties addNewNoFill();
  
  void unsetNoFill();
  
  CTSolidColorFillProperties getSolidFill();
  
  boolean isSetSolidFill();
  
  void setSolidFill(CTSolidColorFillProperties paramCTSolidColorFillProperties);
  
  CTSolidColorFillProperties addNewSolidFill();
  
  void unsetSolidFill();
  
  CTGradientFillProperties getGradFill();
  
  boolean isSetGradFill();
  
  void setGradFill(CTGradientFillProperties paramCTGradientFillProperties);
  
  CTGradientFillProperties addNewGradFill();
  
  void unsetGradFill();
  
  CTBlipFillProperties getBlipFill();
  
  boolean isSetBlipFill();
  
  void setBlipFill(CTBlipFillProperties paramCTBlipFillProperties);
  
  CTBlipFillProperties addNewBlipFill();
  
  void unsetBlipFill();
  
  CTPatternFillProperties getPattFill();
  
  boolean isSetPattFill();
  
  void setPattFill(CTPatternFillProperties paramCTPatternFillProperties);
  
  CTPatternFillProperties addNewPattFill();
  
  void unsetPattFill();
  
  CTGroupFillProperties getGrpFill();
  
  boolean isSetGrpFill();
  
  void setGrpFill(CTGroupFillProperties paramCTGroupFillProperties);
  
  CTGroupFillProperties addNewGrpFill();
  
  void unsetGrpFill();
  
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
  
  CTColor getHighlight();
  
  boolean isSetHighlight();
  
  void setHighlight(CTColor paramCTColor);
  
  CTColor addNewHighlight();
  
  void unsetHighlight();
  
  CTTextUnderlineLineFollowText getULnTx();
  
  boolean isSetULnTx();
  
  void setULnTx(CTTextUnderlineLineFollowText paramCTTextUnderlineLineFollowText);
  
  CTTextUnderlineLineFollowText addNewULnTx();
  
  void unsetULnTx();
  
  CTLineProperties getULn();
  
  boolean isSetULn();
  
  void setULn(CTLineProperties paramCTLineProperties);
  
  CTLineProperties addNewULn();
  
  void unsetULn();
  
  CTTextUnderlineFillFollowText getUFillTx();
  
  boolean isSetUFillTx();
  
  void setUFillTx(CTTextUnderlineFillFollowText paramCTTextUnderlineFillFollowText);
  
  CTTextUnderlineFillFollowText addNewUFillTx();
  
  void unsetUFillTx();
  
  CTTextUnderlineFillGroupWrapper getUFill();
  
  boolean isSetUFill();
  
  void setUFill(CTTextUnderlineFillGroupWrapper paramCTTextUnderlineFillGroupWrapper);
  
  CTTextUnderlineFillGroupWrapper addNewUFill();
  
  void unsetUFill();
  
  CTTextFont getLatin();
  
  boolean isSetLatin();
  
  void setLatin(CTTextFont paramCTTextFont);
  
  CTTextFont addNewLatin();
  
  void unsetLatin();
  
  CTTextFont getEa();
  
  boolean isSetEa();
  
  void setEa(CTTextFont paramCTTextFont);
  
  CTTextFont addNewEa();
  
  void unsetEa();
  
  CTTextFont getCs();
  
  boolean isSetCs();
  
  void setCs(CTTextFont paramCTTextFont);
  
  CTTextFont addNewCs();
  
  void unsetCs();
  
  CTTextFont getSym();
  
  boolean isSetSym();
  
  void setSym(CTTextFont paramCTTextFont);
  
  CTTextFont addNewSym();
  
  void unsetSym();
  
  CTHyperlink getHlinkClick();
  
  boolean isSetHlinkClick();
  
  void setHlinkClick(CTHyperlink paramCTHyperlink);
  
  CTHyperlink addNewHlinkClick();
  
  void unsetHlinkClick();
  
  CTHyperlink getHlinkMouseOver();
  
  boolean isSetHlinkMouseOver();
  
  void setHlinkMouseOver(CTHyperlink paramCTHyperlink);
  
  CTHyperlink addNewHlinkMouseOver();
  
  void unsetHlinkMouseOver();
  
  CTOfficeArtExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList);
  
  CTOfficeArtExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  boolean getKumimoji();
  
  XmlBoolean xgetKumimoji();
  
  boolean isSetKumimoji();
  
  void setKumimoji(boolean paramBoolean);
  
  void xsetKumimoji(XmlBoolean paramXmlBoolean);
  
  void unsetKumimoji();
  
  String getLang();
  
  STTextLanguageID xgetLang();
  
  boolean isSetLang();
  
  void setLang(String paramString);
  
  void xsetLang(STTextLanguageID paramSTTextLanguageID);
  
  void unsetLang();
  
  String getAltLang();
  
  STTextLanguageID xgetAltLang();
  
  boolean isSetAltLang();
  
  void setAltLang(String paramString);
  
  void xsetAltLang(STTextLanguageID paramSTTextLanguageID);
  
  void unsetAltLang();
  
  int getSz();
  
  STTextFontSize xgetSz();
  
  boolean isSetSz();
  
  void setSz(int paramInt);
  
  void xsetSz(STTextFontSize paramSTTextFontSize);
  
  void unsetSz();
  
  boolean getB();
  
  XmlBoolean xgetB();
  
  boolean isSetB();
  
  void setB(boolean paramBoolean);
  
  void xsetB(XmlBoolean paramXmlBoolean);
  
  void unsetB();
  
  boolean getI();
  
  XmlBoolean xgetI();
  
  boolean isSetI();
  
  void setI(boolean paramBoolean);
  
  void xsetI(XmlBoolean paramXmlBoolean);
  
  void unsetI();
  
  STTextUnderlineType.Enum getU();
  
  STTextUnderlineType xgetU();
  
  boolean isSetU();
  
  void setU(STTextUnderlineType.Enum paramEnum);
  
  void xsetU(STTextUnderlineType paramSTTextUnderlineType);
  
  void unsetU();
  
  STTextStrikeType.Enum getStrike();
  
  STTextStrikeType xgetStrike();
  
  boolean isSetStrike();
  
  void setStrike(STTextStrikeType.Enum paramEnum);
  
  void xsetStrike(STTextStrikeType paramSTTextStrikeType);
  
  void unsetStrike();
  
  int getKern();
  
  STTextNonNegativePoint xgetKern();
  
  boolean isSetKern();
  
  void setKern(int paramInt);
  
  void xsetKern(STTextNonNegativePoint paramSTTextNonNegativePoint);
  
  void unsetKern();
  
  STTextCapsType.Enum getCap();
  
  STTextCapsType xgetCap();
  
  boolean isSetCap();
  
  void setCap(STTextCapsType.Enum paramEnum);
  
  void xsetCap(STTextCapsType paramSTTextCapsType);
  
  void unsetCap();
  
  int getSpc();
  
  STTextPoint xgetSpc();
  
  boolean isSetSpc();
  
  void setSpc(int paramInt);
  
  void xsetSpc(STTextPoint paramSTTextPoint);
  
  void unsetSpc();
  
  boolean getNormalizeH();
  
  XmlBoolean xgetNormalizeH();
  
  boolean isSetNormalizeH();
  
  void setNormalizeH(boolean paramBoolean);
  
  void xsetNormalizeH(XmlBoolean paramXmlBoolean);
  
  void unsetNormalizeH();
  
  int getBaseline();
  
  STPercentage xgetBaseline();
  
  boolean isSetBaseline();
  
  void setBaseline(int paramInt);
  
  void xsetBaseline(STPercentage paramSTPercentage);
  
  void unsetBaseline();
  
  boolean getNoProof();
  
  XmlBoolean xgetNoProof();
  
  boolean isSetNoProof();
  
  void setNoProof(boolean paramBoolean);
  
  void xsetNoProof(XmlBoolean paramXmlBoolean);
  
  void unsetNoProof();
  
  boolean getDirty();
  
  XmlBoolean xgetDirty();
  
  boolean isSetDirty();
  
  void setDirty(boolean paramBoolean);
  
  void xsetDirty(XmlBoolean paramXmlBoolean);
  
  void unsetDirty();
  
  boolean getErr();
  
  XmlBoolean xgetErr();
  
  boolean isSetErr();
  
  void setErr(boolean paramBoolean);
  
  void xsetErr(XmlBoolean paramXmlBoolean);
  
  void unsetErr();
  
  boolean getSmtClean();
  
  XmlBoolean xgetSmtClean();
  
  boolean isSetSmtClean();
  
  void setSmtClean(boolean paramBoolean);
  
  void xsetSmtClean(XmlBoolean paramXmlBoolean);
  
  void unsetSmtClean();
  
  long getSmtId();
  
  XmlUnsignedInt xgetSmtId();
  
  boolean isSetSmtId();
  
  void setSmtId(long paramLong);
  
  void xsetSmtId(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetSmtId();
  
  String getBmk();
  
  XmlString xgetBmk();
  
  boolean isSetBmk();
  
  void setBmk(String paramString);
  
  void xsetBmk(XmlString paramXmlString);
  
  void unsetBmk();
  
  public static final class Factory {
    public static CTTextCharacterProperties newInstance() {
      return (CTTextCharacterProperties)POIXMLTypeLoader.newInstance(CTTextCharacterProperties.type, null);
    }
    
    public static CTTextCharacterProperties newInstance(XmlOptions param1XmlOptions) {
      return (CTTextCharacterProperties)POIXMLTypeLoader.newInstance(CTTextCharacterProperties.type, param1XmlOptions);
    }
    
    public static CTTextCharacterProperties parse(String param1String) throws XmlException {
      return (CTTextCharacterProperties)POIXMLTypeLoader.parse(param1String, CTTextCharacterProperties.type, null);
    }
    
    public static CTTextCharacterProperties parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextCharacterProperties)POIXMLTypeLoader.parse(param1String, CTTextCharacterProperties.type, param1XmlOptions);
    }
    
    public static CTTextCharacterProperties parse(File param1File) throws XmlException, IOException {
      return (CTTextCharacterProperties)POIXMLTypeLoader.parse(param1File, CTTextCharacterProperties.type, null);
    }
    
    public static CTTextCharacterProperties parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextCharacterProperties)POIXMLTypeLoader.parse(param1File, CTTextCharacterProperties.type, param1XmlOptions);
    }
    
    public static CTTextCharacterProperties parse(URL param1URL) throws XmlException, IOException {
      return (CTTextCharacterProperties)POIXMLTypeLoader.parse(param1URL, CTTextCharacterProperties.type, null);
    }
    
    public static CTTextCharacterProperties parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextCharacterProperties)POIXMLTypeLoader.parse(param1URL, CTTextCharacterProperties.type, param1XmlOptions);
    }
    
    public static CTTextCharacterProperties parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTextCharacterProperties)POIXMLTypeLoader.parse(param1InputStream, CTTextCharacterProperties.type, null);
    }
    
    public static CTTextCharacterProperties parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextCharacterProperties)POIXMLTypeLoader.parse(param1InputStream, CTTextCharacterProperties.type, param1XmlOptions);
    }
    
    public static CTTextCharacterProperties parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTextCharacterProperties)POIXMLTypeLoader.parse(param1Reader, CTTextCharacterProperties.type, null);
    }
    
    public static CTTextCharacterProperties parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextCharacterProperties)POIXMLTypeLoader.parse(param1Reader, CTTextCharacterProperties.type, param1XmlOptions);
    }
    
    public static CTTextCharacterProperties parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTextCharacterProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextCharacterProperties.type, null);
    }
    
    public static CTTextCharacterProperties parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextCharacterProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextCharacterProperties.type, param1XmlOptions);
    }
    
    public static CTTextCharacterProperties parse(Node param1Node) throws XmlException {
      return (CTTextCharacterProperties)POIXMLTypeLoader.parse(param1Node, CTTextCharacterProperties.type, null);
    }
    
    public static CTTextCharacterProperties parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextCharacterProperties)POIXMLTypeLoader.parse(param1Node, CTTextCharacterProperties.type, param1XmlOptions);
    }
    
    public static CTTextCharacterProperties parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTextCharacterProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextCharacterProperties.type, null);
    }
    
    public static CTTextCharacterProperties parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTextCharacterProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextCharacterProperties.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextCharacterProperties.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextCharacterProperties.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTTextCharacterProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */