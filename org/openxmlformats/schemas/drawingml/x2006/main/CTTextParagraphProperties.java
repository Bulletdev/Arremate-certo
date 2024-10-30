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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTTextParagraphProperties extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTextParagraphProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextparagraphpropertiesdd05type");
  
  CTTextSpacing getLnSpc();
  
  boolean isSetLnSpc();
  
  void setLnSpc(CTTextSpacing paramCTTextSpacing);
  
  CTTextSpacing addNewLnSpc();
  
  void unsetLnSpc();
  
  CTTextSpacing getSpcBef();
  
  boolean isSetSpcBef();
  
  void setSpcBef(CTTextSpacing paramCTTextSpacing);
  
  CTTextSpacing addNewSpcBef();
  
  void unsetSpcBef();
  
  CTTextSpacing getSpcAft();
  
  boolean isSetSpcAft();
  
  void setSpcAft(CTTextSpacing paramCTTextSpacing);
  
  CTTextSpacing addNewSpcAft();
  
  void unsetSpcAft();
  
  CTTextBulletColorFollowText getBuClrTx();
  
  boolean isSetBuClrTx();
  
  void setBuClrTx(CTTextBulletColorFollowText paramCTTextBulletColorFollowText);
  
  CTTextBulletColorFollowText addNewBuClrTx();
  
  void unsetBuClrTx();
  
  CTColor getBuClr();
  
  boolean isSetBuClr();
  
  void setBuClr(CTColor paramCTColor);
  
  CTColor addNewBuClr();
  
  void unsetBuClr();
  
  CTTextBulletSizeFollowText getBuSzTx();
  
  boolean isSetBuSzTx();
  
  void setBuSzTx(CTTextBulletSizeFollowText paramCTTextBulletSizeFollowText);
  
  CTTextBulletSizeFollowText addNewBuSzTx();
  
  void unsetBuSzTx();
  
  CTTextBulletSizePercent getBuSzPct();
  
  boolean isSetBuSzPct();
  
  void setBuSzPct(CTTextBulletSizePercent paramCTTextBulletSizePercent);
  
  CTTextBulletSizePercent addNewBuSzPct();
  
  void unsetBuSzPct();
  
  CTTextBulletSizePoint getBuSzPts();
  
  boolean isSetBuSzPts();
  
  void setBuSzPts(CTTextBulletSizePoint paramCTTextBulletSizePoint);
  
  CTTextBulletSizePoint addNewBuSzPts();
  
  void unsetBuSzPts();
  
  CTTextBulletTypefaceFollowText getBuFontTx();
  
  boolean isSetBuFontTx();
  
  void setBuFontTx(CTTextBulletTypefaceFollowText paramCTTextBulletTypefaceFollowText);
  
  CTTextBulletTypefaceFollowText addNewBuFontTx();
  
  void unsetBuFontTx();
  
  CTTextFont getBuFont();
  
  boolean isSetBuFont();
  
  void setBuFont(CTTextFont paramCTTextFont);
  
  CTTextFont addNewBuFont();
  
  void unsetBuFont();
  
  CTTextNoBullet getBuNone();
  
  boolean isSetBuNone();
  
  void setBuNone(CTTextNoBullet paramCTTextNoBullet);
  
  CTTextNoBullet addNewBuNone();
  
  void unsetBuNone();
  
  CTTextAutonumberBullet getBuAutoNum();
  
  boolean isSetBuAutoNum();
  
  void setBuAutoNum(CTTextAutonumberBullet paramCTTextAutonumberBullet);
  
  CTTextAutonumberBullet addNewBuAutoNum();
  
  void unsetBuAutoNum();
  
  CTTextCharBullet getBuChar();
  
  boolean isSetBuChar();
  
  void setBuChar(CTTextCharBullet paramCTTextCharBullet);
  
  CTTextCharBullet addNewBuChar();
  
  void unsetBuChar();
  
  CTTextBlipBullet getBuBlip();
  
  boolean isSetBuBlip();
  
  void setBuBlip(CTTextBlipBullet paramCTTextBlipBullet);
  
  CTTextBlipBullet addNewBuBlip();
  
  void unsetBuBlip();
  
  CTTextTabStopList getTabLst();
  
  boolean isSetTabLst();
  
  void setTabLst(CTTextTabStopList paramCTTextTabStopList);
  
  CTTextTabStopList addNewTabLst();
  
  void unsetTabLst();
  
  CTTextCharacterProperties getDefRPr();
  
  boolean isSetDefRPr();
  
  void setDefRPr(CTTextCharacterProperties paramCTTextCharacterProperties);
  
  CTTextCharacterProperties addNewDefRPr();
  
  void unsetDefRPr();
  
  CTOfficeArtExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList);
  
  CTOfficeArtExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  int getMarL();
  
  STTextMargin xgetMarL();
  
  boolean isSetMarL();
  
  void setMarL(int paramInt);
  
  void xsetMarL(STTextMargin paramSTTextMargin);
  
  void unsetMarL();
  
  int getMarR();
  
  STTextMargin xgetMarR();
  
  boolean isSetMarR();
  
  void setMarR(int paramInt);
  
  void xsetMarR(STTextMargin paramSTTextMargin);
  
  void unsetMarR();
  
  int getLvl();
  
  STTextIndentLevelType xgetLvl();
  
  boolean isSetLvl();
  
  void setLvl(int paramInt);
  
  void xsetLvl(STTextIndentLevelType paramSTTextIndentLevelType);
  
  void unsetLvl();
  
  int getIndent();
  
  STTextIndent xgetIndent();
  
  boolean isSetIndent();
  
  void setIndent(int paramInt);
  
  void xsetIndent(STTextIndent paramSTTextIndent);
  
  void unsetIndent();
  
  STTextAlignType.Enum getAlgn();
  
  STTextAlignType xgetAlgn();
  
  boolean isSetAlgn();
  
  void setAlgn(STTextAlignType.Enum paramEnum);
  
  void xsetAlgn(STTextAlignType paramSTTextAlignType);
  
  void unsetAlgn();
  
  int getDefTabSz();
  
  STCoordinate32 xgetDefTabSz();
  
  boolean isSetDefTabSz();
  
  void setDefTabSz(int paramInt);
  
  void xsetDefTabSz(STCoordinate32 paramSTCoordinate32);
  
  void unsetDefTabSz();
  
  boolean getRtl();
  
  XmlBoolean xgetRtl();
  
  boolean isSetRtl();
  
  void setRtl(boolean paramBoolean);
  
  void xsetRtl(XmlBoolean paramXmlBoolean);
  
  void unsetRtl();
  
  boolean getEaLnBrk();
  
  XmlBoolean xgetEaLnBrk();
  
  boolean isSetEaLnBrk();
  
  void setEaLnBrk(boolean paramBoolean);
  
  void xsetEaLnBrk(XmlBoolean paramXmlBoolean);
  
  void unsetEaLnBrk();
  
  STTextFontAlignType.Enum getFontAlgn();
  
  STTextFontAlignType xgetFontAlgn();
  
  boolean isSetFontAlgn();
  
  void setFontAlgn(STTextFontAlignType.Enum paramEnum);
  
  void xsetFontAlgn(STTextFontAlignType paramSTTextFontAlignType);
  
  void unsetFontAlgn();
  
  boolean getLatinLnBrk();
  
  XmlBoolean xgetLatinLnBrk();
  
  boolean isSetLatinLnBrk();
  
  void setLatinLnBrk(boolean paramBoolean);
  
  void xsetLatinLnBrk(XmlBoolean paramXmlBoolean);
  
  void unsetLatinLnBrk();
  
  boolean getHangingPunct();
  
  XmlBoolean xgetHangingPunct();
  
  boolean isSetHangingPunct();
  
  void setHangingPunct(boolean paramBoolean);
  
  void xsetHangingPunct(XmlBoolean paramXmlBoolean);
  
  void unsetHangingPunct();
  
  public static final class Factory {
    public static CTTextParagraphProperties newInstance() {
      return (CTTextParagraphProperties)POIXMLTypeLoader.newInstance(CTTextParagraphProperties.type, null);
    }
    
    public static CTTextParagraphProperties newInstance(XmlOptions param1XmlOptions) {
      return (CTTextParagraphProperties)POIXMLTypeLoader.newInstance(CTTextParagraphProperties.type, param1XmlOptions);
    }
    
    public static CTTextParagraphProperties parse(String param1String) throws XmlException {
      return (CTTextParagraphProperties)POIXMLTypeLoader.parse(param1String, CTTextParagraphProperties.type, null);
    }
    
    public static CTTextParagraphProperties parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextParagraphProperties)POIXMLTypeLoader.parse(param1String, CTTextParagraphProperties.type, param1XmlOptions);
    }
    
    public static CTTextParagraphProperties parse(File param1File) throws XmlException, IOException {
      return (CTTextParagraphProperties)POIXMLTypeLoader.parse(param1File, CTTextParagraphProperties.type, null);
    }
    
    public static CTTextParagraphProperties parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextParagraphProperties)POIXMLTypeLoader.parse(param1File, CTTextParagraphProperties.type, param1XmlOptions);
    }
    
    public static CTTextParagraphProperties parse(URL param1URL) throws XmlException, IOException {
      return (CTTextParagraphProperties)POIXMLTypeLoader.parse(param1URL, CTTextParagraphProperties.type, null);
    }
    
    public static CTTextParagraphProperties parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextParagraphProperties)POIXMLTypeLoader.parse(param1URL, CTTextParagraphProperties.type, param1XmlOptions);
    }
    
    public static CTTextParagraphProperties parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTextParagraphProperties)POIXMLTypeLoader.parse(param1InputStream, CTTextParagraphProperties.type, null);
    }
    
    public static CTTextParagraphProperties parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextParagraphProperties)POIXMLTypeLoader.parse(param1InputStream, CTTextParagraphProperties.type, param1XmlOptions);
    }
    
    public static CTTextParagraphProperties parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTextParagraphProperties)POIXMLTypeLoader.parse(param1Reader, CTTextParagraphProperties.type, null);
    }
    
    public static CTTextParagraphProperties parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextParagraphProperties)POIXMLTypeLoader.parse(param1Reader, CTTextParagraphProperties.type, param1XmlOptions);
    }
    
    public static CTTextParagraphProperties parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTextParagraphProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextParagraphProperties.type, null);
    }
    
    public static CTTextParagraphProperties parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextParagraphProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextParagraphProperties.type, param1XmlOptions);
    }
    
    public static CTTextParagraphProperties parse(Node param1Node) throws XmlException {
      return (CTTextParagraphProperties)POIXMLTypeLoader.parse(param1Node, CTTextParagraphProperties.type, null);
    }
    
    public static CTTextParagraphProperties parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextParagraphProperties)POIXMLTypeLoader.parse(param1Node, CTTextParagraphProperties.type, param1XmlOptions);
    }
    
    public static CTTextParagraphProperties parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTextParagraphProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextParagraphProperties.type, null);
    }
    
    public static CTTextParagraphProperties parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTextParagraphProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextParagraphProperties.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextParagraphProperties.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextParagraphProperties.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTTextParagraphProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */