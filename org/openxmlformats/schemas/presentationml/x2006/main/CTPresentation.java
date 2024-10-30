package org.openxmlformats.schemas.presentationml.x2006.main;

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
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.STPercentage;
import org.w3c.dom.Node;

public interface CTPresentation extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPresentation.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpresentation56cbtype");
  
  CTSlideMasterIdList getSldMasterIdLst();
  
  boolean isSetSldMasterIdLst();
  
  void setSldMasterIdLst(CTSlideMasterIdList paramCTSlideMasterIdList);
  
  CTSlideMasterIdList addNewSldMasterIdLst();
  
  void unsetSldMasterIdLst();
  
  CTNotesMasterIdList getNotesMasterIdLst();
  
  boolean isSetNotesMasterIdLst();
  
  void setNotesMasterIdLst(CTNotesMasterIdList paramCTNotesMasterIdList);
  
  CTNotesMasterIdList addNewNotesMasterIdLst();
  
  void unsetNotesMasterIdLst();
  
  CTHandoutMasterIdList getHandoutMasterIdLst();
  
  boolean isSetHandoutMasterIdLst();
  
  void setHandoutMasterIdLst(CTHandoutMasterIdList paramCTHandoutMasterIdList);
  
  CTHandoutMasterIdList addNewHandoutMasterIdLst();
  
  void unsetHandoutMasterIdLst();
  
  CTSlideIdList getSldIdLst();
  
  boolean isSetSldIdLst();
  
  void setSldIdLst(CTSlideIdList paramCTSlideIdList);
  
  CTSlideIdList addNewSldIdLst();
  
  void unsetSldIdLst();
  
  CTSlideSize getSldSz();
  
  boolean isSetSldSz();
  
  void setSldSz(CTSlideSize paramCTSlideSize);
  
  CTSlideSize addNewSldSz();
  
  void unsetSldSz();
  
  CTPositiveSize2D getNotesSz();
  
  void setNotesSz(CTPositiveSize2D paramCTPositiveSize2D);
  
  CTPositiveSize2D addNewNotesSz();
  
  CTSmartTags getSmartTags();
  
  boolean isSetSmartTags();
  
  void setSmartTags(CTSmartTags paramCTSmartTags);
  
  CTSmartTags addNewSmartTags();
  
  void unsetSmartTags();
  
  CTEmbeddedFontList getEmbeddedFontLst();
  
  boolean isSetEmbeddedFontLst();
  
  void setEmbeddedFontLst(CTEmbeddedFontList paramCTEmbeddedFontList);
  
  CTEmbeddedFontList addNewEmbeddedFontLst();
  
  void unsetEmbeddedFontLst();
  
  CTCustomShowList getCustShowLst();
  
  boolean isSetCustShowLst();
  
  void setCustShowLst(CTCustomShowList paramCTCustomShowList);
  
  CTCustomShowList addNewCustShowLst();
  
  void unsetCustShowLst();
  
  CTPhotoAlbum getPhotoAlbum();
  
  boolean isSetPhotoAlbum();
  
  void setPhotoAlbum(CTPhotoAlbum paramCTPhotoAlbum);
  
  CTPhotoAlbum addNewPhotoAlbum();
  
  void unsetPhotoAlbum();
  
  CTCustomerDataList getCustDataLst();
  
  boolean isSetCustDataLst();
  
  void setCustDataLst(CTCustomerDataList paramCTCustomerDataList);
  
  CTCustomerDataList addNewCustDataLst();
  
  void unsetCustDataLst();
  
  CTKinsoku getKinsoku();
  
  boolean isSetKinsoku();
  
  void setKinsoku(CTKinsoku paramCTKinsoku);
  
  CTKinsoku addNewKinsoku();
  
  void unsetKinsoku();
  
  CTTextListStyle getDefaultTextStyle();
  
  boolean isSetDefaultTextStyle();
  
  void setDefaultTextStyle(CTTextListStyle paramCTTextListStyle);
  
  CTTextListStyle addNewDefaultTextStyle();
  
  void unsetDefaultTextStyle();
  
  CTModifyVerifier getModifyVerifier();
  
  boolean isSetModifyVerifier();
  
  void setModifyVerifier(CTModifyVerifier paramCTModifyVerifier);
  
  CTModifyVerifier addNewModifyVerifier();
  
  void unsetModifyVerifier();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  int getServerZoom();
  
  STPercentage xgetServerZoom();
  
  boolean isSetServerZoom();
  
  void setServerZoom(int paramInt);
  
  void xsetServerZoom(STPercentage paramSTPercentage);
  
  void unsetServerZoom();
  
  int getFirstSlideNum();
  
  XmlInt xgetFirstSlideNum();
  
  boolean isSetFirstSlideNum();
  
  void setFirstSlideNum(int paramInt);
  
  void xsetFirstSlideNum(XmlInt paramXmlInt);
  
  void unsetFirstSlideNum();
  
  boolean getShowSpecialPlsOnTitleSld();
  
  XmlBoolean xgetShowSpecialPlsOnTitleSld();
  
  boolean isSetShowSpecialPlsOnTitleSld();
  
  void setShowSpecialPlsOnTitleSld(boolean paramBoolean);
  
  void xsetShowSpecialPlsOnTitleSld(XmlBoolean paramXmlBoolean);
  
  void unsetShowSpecialPlsOnTitleSld();
  
  boolean getRtl();
  
  XmlBoolean xgetRtl();
  
  boolean isSetRtl();
  
  void setRtl(boolean paramBoolean);
  
  void xsetRtl(XmlBoolean paramXmlBoolean);
  
  void unsetRtl();
  
  boolean getRemovePersonalInfoOnSave();
  
  XmlBoolean xgetRemovePersonalInfoOnSave();
  
  boolean isSetRemovePersonalInfoOnSave();
  
  void setRemovePersonalInfoOnSave(boolean paramBoolean);
  
  void xsetRemovePersonalInfoOnSave(XmlBoolean paramXmlBoolean);
  
  void unsetRemovePersonalInfoOnSave();
  
  boolean getCompatMode();
  
  XmlBoolean xgetCompatMode();
  
  boolean isSetCompatMode();
  
  void setCompatMode(boolean paramBoolean);
  
  void xsetCompatMode(XmlBoolean paramXmlBoolean);
  
  void unsetCompatMode();
  
  boolean getStrictFirstAndLastChars();
  
  XmlBoolean xgetStrictFirstAndLastChars();
  
  boolean isSetStrictFirstAndLastChars();
  
  void setStrictFirstAndLastChars(boolean paramBoolean);
  
  void xsetStrictFirstAndLastChars(XmlBoolean paramXmlBoolean);
  
  void unsetStrictFirstAndLastChars();
  
  boolean getEmbedTrueTypeFonts();
  
  XmlBoolean xgetEmbedTrueTypeFonts();
  
  boolean isSetEmbedTrueTypeFonts();
  
  void setEmbedTrueTypeFonts(boolean paramBoolean);
  
  void xsetEmbedTrueTypeFonts(XmlBoolean paramXmlBoolean);
  
  void unsetEmbedTrueTypeFonts();
  
  boolean getSaveSubsetFonts();
  
  XmlBoolean xgetSaveSubsetFonts();
  
  boolean isSetSaveSubsetFonts();
  
  void setSaveSubsetFonts(boolean paramBoolean);
  
  void xsetSaveSubsetFonts(XmlBoolean paramXmlBoolean);
  
  void unsetSaveSubsetFonts();
  
  boolean getAutoCompressPictures();
  
  XmlBoolean xgetAutoCompressPictures();
  
  boolean isSetAutoCompressPictures();
  
  void setAutoCompressPictures(boolean paramBoolean);
  
  void xsetAutoCompressPictures(XmlBoolean paramXmlBoolean);
  
  void unsetAutoCompressPictures();
  
  long getBookmarkIdSeed();
  
  STBookmarkIdSeed xgetBookmarkIdSeed();
  
  boolean isSetBookmarkIdSeed();
  
  void setBookmarkIdSeed(long paramLong);
  
  void xsetBookmarkIdSeed(STBookmarkIdSeed paramSTBookmarkIdSeed);
  
  void unsetBookmarkIdSeed();
  
  public static final class Factory {
    public static CTPresentation newInstance() {
      return (CTPresentation)POIXMLTypeLoader.newInstance(CTPresentation.type, null);
    }
    
    public static CTPresentation newInstance(XmlOptions param1XmlOptions) {
      return (CTPresentation)POIXMLTypeLoader.newInstance(CTPresentation.type, param1XmlOptions);
    }
    
    public static CTPresentation parse(String param1String) throws XmlException {
      return (CTPresentation)POIXMLTypeLoader.parse(param1String, CTPresentation.type, null);
    }
    
    public static CTPresentation parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPresentation)POIXMLTypeLoader.parse(param1String, CTPresentation.type, param1XmlOptions);
    }
    
    public static CTPresentation parse(File param1File) throws XmlException, IOException {
      return (CTPresentation)POIXMLTypeLoader.parse(param1File, CTPresentation.type, null);
    }
    
    public static CTPresentation parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPresentation)POIXMLTypeLoader.parse(param1File, CTPresentation.type, param1XmlOptions);
    }
    
    public static CTPresentation parse(URL param1URL) throws XmlException, IOException {
      return (CTPresentation)POIXMLTypeLoader.parse(param1URL, CTPresentation.type, null);
    }
    
    public static CTPresentation parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPresentation)POIXMLTypeLoader.parse(param1URL, CTPresentation.type, param1XmlOptions);
    }
    
    public static CTPresentation parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPresentation)POIXMLTypeLoader.parse(param1InputStream, CTPresentation.type, null);
    }
    
    public static CTPresentation parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPresentation)POIXMLTypeLoader.parse(param1InputStream, CTPresentation.type, param1XmlOptions);
    }
    
    public static CTPresentation parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPresentation)POIXMLTypeLoader.parse(param1Reader, CTPresentation.type, null);
    }
    
    public static CTPresentation parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPresentation)POIXMLTypeLoader.parse(param1Reader, CTPresentation.type, param1XmlOptions);
    }
    
    public static CTPresentation parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPresentation)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPresentation.type, null);
    }
    
    public static CTPresentation parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPresentation)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPresentation.type, param1XmlOptions);
    }
    
    public static CTPresentation parse(Node param1Node) throws XmlException {
      return (CTPresentation)POIXMLTypeLoader.parse(param1Node, CTPresentation.type, null);
    }
    
    public static CTPresentation parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPresentation)POIXMLTypeLoader.parse(param1Node, CTPresentation.type, param1XmlOptions);
    }
    
    public static CTPresentation parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPresentation)POIXMLTypeLoader.parse(param1XMLInputStream, CTPresentation.type, null);
    }
    
    public static CTPresentation parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPresentation)POIXMLTypeLoader.parse(param1XMLInputStream, CTPresentation.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPresentation.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPresentation.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\CTPresentation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */