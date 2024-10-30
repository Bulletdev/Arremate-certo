package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.STPercentage;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCustomShowList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTHandoutMasterIdList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTKinsoku;
import org.openxmlformats.schemas.presentationml.x2006.main.CTModifyVerifier;
import org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMasterIdList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPhotoAlbum;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideSize;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSmartTags;
import org.openxmlformats.schemas.presentationml.x2006.main.STBookmarkIdSeed;

public class CTPresentationImpl extends XmlComplexContentImpl implements CTPresentation {
  private static final b SLDMASTERIDLST$0 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "sldMasterIdLst");
  
  private static final b NOTESMASTERIDLST$2 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "notesMasterIdLst");
  
  private static final b HANDOUTMASTERIDLST$4 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "handoutMasterIdLst");
  
  private static final b SLDIDLST$6 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "sldIdLst");
  
  private static final b SLDSZ$8 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "sldSz");
  
  private static final b NOTESSZ$10 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "notesSz");
  
  private static final b SMARTTAGS$12 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "smartTags");
  
  private static final b EMBEDDEDFONTLST$14 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "embeddedFontLst");
  
  private static final b CUSTSHOWLST$16 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "custShowLst");
  
  private static final b PHOTOALBUM$18 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "photoAlbum");
  
  private static final b CUSTDATALST$20 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "custDataLst");
  
  private static final b KINSOKU$22 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "kinsoku");
  
  private static final b DEFAULTTEXTSTYLE$24 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "defaultTextStyle");
  
  private static final b MODIFYVERIFIER$26 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "modifyVerifier");
  
  private static final b EXTLST$28 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst");
  
  private static final b SERVERZOOM$30 = new b("", "serverZoom");
  
  private static final b FIRSTSLIDENUM$32 = new b("", "firstSlideNum");
  
  private static final b SHOWSPECIALPLSONTITLESLD$34 = new b("", "showSpecialPlsOnTitleSld");
  
  private static final b RTL$36 = new b("", "rtl");
  
  private static final b REMOVEPERSONALINFOONSAVE$38 = new b("", "removePersonalInfoOnSave");
  
  private static final b COMPATMODE$40 = new b("", "compatMode");
  
  private static final b STRICTFIRSTANDLASTCHARS$42 = new b("", "strictFirstAndLastChars");
  
  private static final b EMBEDTRUETYPEFONTS$44 = new b("", "embedTrueTypeFonts");
  
  private static final b SAVESUBSETFONTS$46 = new b("", "saveSubsetFonts");
  
  private static final b AUTOCOMPRESSPICTURES$48 = new b("", "autoCompressPictures");
  
  private static final b BOOKMARKIDSEED$50 = new b("", "bookmarkIdSeed");
  
  public CTPresentationImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTSlideMasterIdList getSldMasterIdLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideMasterIdList cTSlideMasterIdList = null;
      cTSlideMasterIdList = (CTSlideMasterIdList)get_store().find_element_user(SLDMASTERIDLST$0, 0);
      if (cTSlideMasterIdList == null)
        return null; 
      return cTSlideMasterIdList;
    } 
  }
  
  public boolean isSetSldMasterIdLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SLDMASTERIDLST$0) != 0);
    } 
  }
  
  public void setSldMasterIdLst(CTSlideMasterIdList paramCTSlideMasterIdList) {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideMasterIdList cTSlideMasterIdList = null;
      cTSlideMasterIdList = (CTSlideMasterIdList)get_store().find_element_user(SLDMASTERIDLST$0, 0);
      if (cTSlideMasterIdList == null)
        cTSlideMasterIdList = (CTSlideMasterIdList)get_store().add_element_user(SLDMASTERIDLST$0); 
      cTSlideMasterIdList.set((XmlObject)paramCTSlideMasterIdList);
    } 
  }
  
  public CTSlideMasterIdList addNewSldMasterIdLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideMasterIdList cTSlideMasterIdList = null;
      cTSlideMasterIdList = (CTSlideMasterIdList)get_store().add_element_user(SLDMASTERIDLST$0);
      return cTSlideMasterIdList;
    } 
  }
  
  public void unsetSldMasterIdLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SLDMASTERIDLST$0, 0);
    } 
  }
  
  public CTNotesMasterIdList getNotesMasterIdLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTNotesMasterIdList cTNotesMasterIdList = null;
      cTNotesMasterIdList = (CTNotesMasterIdList)get_store().find_element_user(NOTESMASTERIDLST$2, 0);
      if (cTNotesMasterIdList == null)
        return null; 
      return cTNotesMasterIdList;
    } 
  }
  
  public boolean isSetNotesMasterIdLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NOTESMASTERIDLST$2) != 0);
    } 
  }
  
  public void setNotesMasterIdLst(CTNotesMasterIdList paramCTNotesMasterIdList) {
    synchronized (monitor()) {
      check_orphaned();
      CTNotesMasterIdList cTNotesMasterIdList = null;
      cTNotesMasterIdList = (CTNotesMasterIdList)get_store().find_element_user(NOTESMASTERIDLST$2, 0);
      if (cTNotesMasterIdList == null)
        cTNotesMasterIdList = (CTNotesMasterIdList)get_store().add_element_user(NOTESMASTERIDLST$2); 
      cTNotesMasterIdList.set((XmlObject)paramCTNotesMasterIdList);
    } 
  }
  
  public CTNotesMasterIdList addNewNotesMasterIdLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTNotesMasterIdList cTNotesMasterIdList = null;
      cTNotesMasterIdList = (CTNotesMasterIdList)get_store().add_element_user(NOTESMASTERIDLST$2);
      return cTNotesMasterIdList;
    } 
  }
  
  public void unsetNotesMasterIdLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NOTESMASTERIDLST$2, 0);
    } 
  }
  
  public CTHandoutMasterIdList getHandoutMasterIdLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTHandoutMasterIdList cTHandoutMasterIdList = null;
      cTHandoutMasterIdList = (CTHandoutMasterIdList)get_store().find_element_user(HANDOUTMASTERIDLST$4, 0);
      if (cTHandoutMasterIdList == null)
        return null; 
      return cTHandoutMasterIdList;
    } 
  }
  
  public boolean isSetHandoutMasterIdLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(HANDOUTMASTERIDLST$4) != 0);
    } 
  }
  
  public void setHandoutMasterIdLst(CTHandoutMasterIdList paramCTHandoutMasterIdList) {
    synchronized (monitor()) {
      check_orphaned();
      CTHandoutMasterIdList cTHandoutMasterIdList = null;
      cTHandoutMasterIdList = (CTHandoutMasterIdList)get_store().find_element_user(HANDOUTMASTERIDLST$4, 0);
      if (cTHandoutMasterIdList == null)
        cTHandoutMasterIdList = (CTHandoutMasterIdList)get_store().add_element_user(HANDOUTMASTERIDLST$4); 
      cTHandoutMasterIdList.set((XmlObject)paramCTHandoutMasterIdList);
    } 
  }
  
  public CTHandoutMasterIdList addNewHandoutMasterIdLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTHandoutMasterIdList cTHandoutMasterIdList = null;
      cTHandoutMasterIdList = (CTHandoutMasterIdList)get_store().add_element_user(HANDOUTMASTERIDLST$4);
      return cTHandoutMasterIdList;
    } 
  }
  
  public void unsetHandoutMasterIdLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HANDOUTMASTERIDLST$4, 0);
    } 
  }
  
  public CTSlideIdList getSldIdLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideIdList cTSlideIdList = null;
      cTSlideIdList = (CTSlideIdList)get_store().find_element_user(SLDIDLST$6, 0);
      if (cTSlideIdList == null)
        return null; 
      return cTSlideIdList;
    } 
  }
  
  public boolean isSetSldIdLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SLDIDLST$6) != 0);
    } 
  }
  
  public void setSldIdLst(CTSlideIdList paramCTSlideIdList) {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideIdList cTSlideIdList = null;
      cTSlideIdList = (CTSlideIdList)get_store().find_element_user(SLDIDLST$6, 0);
      if (cTSlideIdList == null)
        cTSlideIdList = (CTSlideIdList)get_store().add_element_user(SLDIDLST$6); 
      cTSlideIdList.set((XmlObject)paramCTSlideIdList);
    } 
  }
  
  public CTSlideIdList addNewSldIdLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideIdList cTSlideIdList = null;
      cTSlideIdList = (CTSlideIdList)get_store().add_element_user(SLDIDLST$6);
      return cTSlideIdList;
    } 
  }
  
  public void unsetSldIdLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SLDIDLST$6, 0);
    } 
  }
  
  public CTSlideSize getSldSz() {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideSize cTSlideSize = null;
      cTSlideSize = (CTSlideSize)get_store().find_element_user(SLDSZ$8, 0);
      if (cTSlideSize == null)
        return null; 
      return cTSlideSize;
    } 
  }
  
  public boolean isSetSldSz() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SLDSZ$8) != 0);
    } 
  }
  
  public void setSldSz(CTSlideSize paramCTSlideSize) {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideSize cTSlideSize = null;
      cTSlideSize = (CTSlideSize)get_store().find_element_user(SLDSZ$8, 0);
      if (cTSlideSize == null)
        cTSlideSize = (CTSlideSize)get_store().add_element_user(SLDSZ$8); 
      cTSlideSize.set((XmlObject)paramCTSlideSize);
    } 
  }
  
  public CTSlideSize addNewSldSz() {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideSize cTSlideSize = null;
      cTSlideSize = (CTSlideSize)get_store().add_element_user(SLDSZ$8);
      return cTSlideSize;
    } 
  }
  
  public void unsetSldSz() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SLDSZ$8, 0);
    } 
  }
  
  public CTPositiveSize2D getNotesSz() {
    synchronized (monitor()) {
      check_orphaned();
      CTPositiveSize2D cTPositiveSize2D = null;
      cTPositiveSize2D = (CTPositiveSize2D)get_store().find_element_user(NOTESSZ$10, 0);
      if (cTPositiveSize2D == null)
        return null; 
      return cTPositiveSize2D;
    } 
  }
  
  public void setNotesSz(CTPositiveSize2D paramCTPositiveSize2D) {
    synchronized (monitor()) {
      check_orphaned();
      CTPositiveSize2D cTPositiveSize2D = null;
      cTPositiveSize2D = (CTPositiveSize2D)get_store().find_element_user(NOTESSZ$10, 0);
      if (cTPositiveSize2D == null)
        cTPositiveSize2D = (CTPositiveSize2D)get_store().add_element_user(NOTESSZ$10); 
      cTPositiveSize2D.set((XmlObject)paramCTPositiveSize2D);
    } 
  }
  
  public CTPositiveSize2D addNewNotesSz() {
    synchronized (monitor()) {
      check_orphaned();
      CTPositiveSize2D cTPositiveSize2D = null;
      cTPositiveSize2D = (CTPositiveSize2D)get_store().add_element_user(NOTESSZ$10);
      return cTPositiveSize2D;
    } 
  }
  
  public CTSmartTags getSmartTags() {
    synchronized (monitor()) {
      check_orphaned();
      CTSmartTags cTSmartTags = null;
      cTSmartTags = (CTSmartTags)get_store().find_element_user(SMARTTAGS$12, 0);
      if (cTSmartTags == null)
        return null; 
      return cTSmartTags;
    } 
  }
  
  public boolean isSetSmartTags() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SMARTTAGS$12) != 0);
    } 
  }
  
  public void setSmartTags(CTSmartTags paramCTSmartTags) {
    synchronized (monitor()) {
      check_orphaned();
      CTSmartTags cTSmartTags = null;
      cTSmartTags = (CTSmartTags)get_store().find_element_user(SMARTTAGS$12, 0);
      if (cTSmartTags == null)
        cTSmartTags = (CTSmartTags)get_store().add_element_user(SMARTTAGS$12); 
      cTSmartTags.set((XmlObject)paramCTSmartTags);
    } 
  }
  
  public CTSmartTags addNewSmartTags() {
    synchronized (monitor()) {
      check_orphaned();
      CTSmartTags cTSmartTags = null;
      cTSmartTags = (CTSmartTags)get_store().add_element_user(SMARTTAGS$12);
      return cTSmartTags;
    } 
  }
  
  public void unsetSmartTags() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SMARTTAGS$12, 0);
    } 
  }
  
  public CTEmbeddedFontList getEmbeddedFontLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTEmbeddedFontList cTEmbeddedFontList = null;
      cTEmbeddedFontList = (CTEmbeddedFontList)get_store().find_element_user(EMBEDDEDFONTLST$14, 0);
      if (cTEmbeddedFontList == null)
        return null; 
      return cTEmbeddedFontList;
    } 
  }
  
  public boolean isSetEmbeddedFontLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EMBEDDEDFONTLST$14) != 0);
    } 
  }
  
  public void setEmbeddedFontLst(CTEmbeddedFontList paramCTEmbeddedFontList) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmbeddedFontList cTEmbeddedFontList = null;
      cTEmbeddedFontList = (CTEmbeddedFontList)get_store().find_element_user(EMBEDDEDFONTLST$14, 0);
      if (cTEmbeddedFontList == null)
        cTEmbeddedFontList = (CTEmbeddedFontList)get_store().add_element_user(EMBEDDEDFONTLST$14); 
      cTEmbeddedFontList.set((XmlObject)paramCTEmbeddedFontList);
    } 
  }
  
  public CTEmbeddedFontList addNewEmbeddedFontLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTEmbeddedFontList cTEmbeddedFontList = null;
      cTEmbeddedFontList = (CTEmbeddedFontList)get_store().add_element_user(EMBEDDEDFONTLST$14);
      return cTEmbeddedFontList;
    } 
  }
  
  public void unsetEmbeddedFontLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EMBEDDEDFONTLST$14, 0);
    } 
  }
  
  public CTCustomShowList getCustShowLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomShowList cTCustomShowList = null;
      cTCustomShowList = (CTCustomShowList)get_store().find_element_user(CUSTSHOWLST$16, 0);
      if (cTCustomShowList == null)
        return null; 
      return cTCustomShowList;
    } 
  }
  
  public boolean isSetCustShowLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CUSTSHOWLST$16) != 0);
    } 
  }
  
  public void setCustShowLst(CTCustomShowList paramCTCustomShowList) {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomShowList cTCustomShowList = null;
      cTCustomShowList = (CTCustomShowList)get_store().find_element_user(CUSTSHOWLST$16, 0);
      if (cTCustomShowList == null)
        cTCustomShowList = (CTCustomShowList)get_store().add_element_user(CUSTSHOWLST$16); 
      cTCustomShowList.set((XmlObject)paramCTCustomShowList);
    } 
  }
  
  public CTCustomShowList addNewCustShowLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomShowList cTCustomShowList = null;
      cTCustomShowList = (CTCustomShowList)get_store().add_element_user(CUSTSHOWLST$16);
      return cTCustomShowList;
    } 
  }
  
  public void unsetCustShowLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CUSTSHOWLST$16, 0);
    } 
  }
  
  public CTPhotoAlbum getPhotoAlbum() {
    synchronized (monitor()) {
      check_orphaned();
      CTPhotoAlbum cTPhotoAlbum = null;
      cTPhotoAlbum = (CTPhotoAlbum)get_store().find_element_user(PHOTOALBUM$18, 0);
      if (cTPhotoAlbum == null)
        return null; 
      return cTPhotoAlbum;
    } 
  }
  
  public boolean isSetPhotoAlbum() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PHOTOALBUM$18) != 0);
    } 
  }
  
  public void setPhotoAlbum(CTPhotoAlbum paramCTPhotoAlbum) {
    synchronized (monitor()) {
      check_orphaned();
      CTPhotoAlbum cTPhotoAlbum = null;
      cTPhotoAlbum = (CTPhotoAlbum)get_store().find_element_user(PHOTOALBUM$18, 0);
      if (cTPhotoAlbum == null)
        cTPhotoAlbum = (CTPhotoAlbum)get_store().add_element_user(PHOTOALBUM$18); 
      cTPhotoAlbum.set((XmlObject)paramCTPhotoAlbum);
    } 
  }
  
  public CTPhotoAlbum addNewPhotoAlbum() {
    synchronized (monitor()) {
      check_orphaned();
      CTPhotoAlbum cTPhotoAlbum = null;
      cTPhotoAlbum = (CTPhotoAlbum)get_store().add_element_user(PHOTOALBUM$18);
      return cTPhotoAlbum;
    } 
  }
  
  public void unsetPhotoAlbum() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PHOTOALBUM$18, 0);
    } 
  }
  
  public CTCustomerDataList getCustDataLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomerDataList cTCustomerDataList = null;
      cTCustomerDataList = (CTCustomerDataList)get_store().find_element_user(CUSTDATALST$20, 0);
      if (cTCustomerDataList == null)
        return null; 
      return cTCustomerDataList;
    } 
  }
  
  public boolean isSetCustDataLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CUSTDATALST$20) != 0);
    } 
  }
  
  public void setCustDataLst(CTCustomerDataList paramCTCustomerDataList) {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomerDataList cTCustomerDataList = null;
      cTCustomerDataList = (CTCustomerDataList)get_store().find_element_user(CUSTDATALST$20, 0);
      if (cTCustomerDataList == null)
        cTCustomerDataList = (CTCustomerDataList)get_store().add_element_user(CUSTDATALST$20); 
      cTCustomerDataList.set((XmlObject)paramCTCustomerDataList);
    } 
  }
  
  public CTCustomerDataList addNewCustDataLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomerDataList cTCustomerDataList = null;
      cTCustomerDataList = (CTCustomerDataList)get_store().add_element_user(CUSTDATALST$20);
      return cTCustomerDataList;
    } 
  }
  
  public void unsetCustDataLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CUSTDATALST$20, 0);
    } 
  }
  
  public CTKinsoku getKinsoku() {
    synchronized (monitor()) {
      check_orphaned();
      CTKinsoku cTKinsoku = null;
      cTKinsoku = (CTKinsoku)get_store().find_element_user(KINSOKU$22, 0);
      if (cTKinsoku == null)
        return null; 
      return cTKinsoku;
    } 
  }
  
  public boolean isSetKinsoku() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(KINSOKU$22) != 0);
    } 
  }
  
  public void setKinsoku(CTKinsoku paramCTKinsoku) {
    synchronized (monitor()) {
      check_orphaned();
      CTKinsoku cTKinsoku = null;
      cTKinsoku = (CTKinsoku)get_store().find_element_user(KINSOKU$22, 0);
      if (cTKinsoku == null)
        cTKinsoku = (CTKinsoku)get_store().add_element_user(KINSOKU$22); 
      cTKinsoku.set((XmlObject)paramCTKinsoku);
    } 
  }
  
  public CTKinsoku addNewKinsoku() {
    synchronized (monitor()) {
      check_orphaned();
      CTKinsoku cTKinsoku = null;
      cTKinsoku = (CTKinsoku)get_store().add_element_user(KINSOKU$22);
      return cTKinsoku;
    } 
  }
  
  public void unsetKinsoku() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(KINSOKU$22, 0);
    } 
  }
  
  public CTTextListStyle getDefaultTextStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextListStyle cTTextListStyle = null;
      cTTextListStyle = (CTTextListStyle)get_store().find_element_user(DEFAULTTEXTSTYLE$24, 0);
      if (cTTextListStyle == null)
        return null; 
      return cTTextListStyle;
    } 
  }
  
  public boolean isSetDefaultTextStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DEFAULTTEXTSTYLE$24) != 0);
    } 
  }
  
  public void setDefaultTextStyle(CTTextListStyle paramCTTextListStyle) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextListStyle cTTextListStyle = null;
      cTTextListStyle = (CTTextListStyle)get_store().find_element_user(DEFAULTTEXTSTYLE$24, 0);
      if (cTTextListStyle == null)
        cTTextListStyle = (CTTextListStyle)get_store().add_element_user(DEFAULTTEXTSTYLE$24); 
      cTTextListStyle.set((XmlObject)paramCTTextListStyle);
    } 
  }
  
  public CTTextListStyle addNewDefaultTextStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextListStyle cTTextListStyle = null;
      cTTextListStyle = (CTTextListStyle)get_store().add_element_user(DEFAULTTEXTSTYLE$24);
      return cTTextListStyle;
    } 
  }
  
  public void unsetDefaultTextStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DEFAULTTEXTSTYLE$24, 0);
    } 
  }
  
  public CTModifyVerifier getModifyVerifier() {
    synchronized (monitor()) {
      check_orphaned();
      CTModifyVerifier cTModifyVerifier = null;
      cTModifyVerifier = (CTModifyVerifier)get_store().find_element_user(MODIFYVERIFIER$26, 0);
      if (cTModifyVerifier == null)
        return null; 
      return cTModifyVerifier;
    } 
  }
  
  public boolean isSetModifyVerifier() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(MODIFYVERIFIER$26) != 0);
    } 
  }
  
  public void setModifyVerifier(CTModifyVerifier paramCTModifyVerifier) {
    synchronized (monitor()) {
      check_orphaned();
      CTModifyVerifier cTModifyVerifier = null;
      cTModifyVerifier = (CTModifyVerifier)get_store().find_element_user(MODIFYVERIFIER$26, 0);
      if (cTModifyVerifier == null)
        cTModifyVerifier = (CTModifyVerifier)get_store().add_element_user(MODIFYVERIFIER$26); 
      cTModifyVerifier.set((XmlObject)paramCTModifyVerifier);
    } 
  }
  
  public CTModifyVerifier addNewModifyVerifier() {
    synchronized (monitor()) {
      check_orphaned();
      CTModifyVerifier cTModifyVerifier = null;
      cTModifyVerifier = (CTModifyVerifier)get_store().add_element_user(MODIFYVERIFIER$26);
      return cTModifyVerifier;
    } 
  }
  
  public void unsetModifyVerifier() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MODIFYVERIFIER$26, 0);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$28, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$28) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$28, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$28); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$28);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$28, 0);
    } 
  }
  
  public int getServerZoom() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SERVERZOOM$30);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SERVERZOOM$30); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STPercentage xgetServerZoom() {
    synchronized (monitor()) {
      check_orphaned();
      STPercentage sTPercentage = null;
      sTPercentage = (STPercentage)get_store().find_attribute_user(SERVERZOOM$30);
      if (sTPercentage == null)
        sTPercentage = (STPercentage)get_default_attribute_value(SERVERZOOM$30); 
      return sTPercentage;
    } 
  }
  
  public boolean isSetServerZoom() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SERVERZOOM$30) != null);
    } 
  }
  
  public void setServerZoom(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SERVERZOOM$30);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SERVERZOOM$30); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetServerZoom(STPercentage paramSTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      STPercentage sTPercentage = null;
      sTPercentage = (STPercentage)get_store().find_attribute_user(SERVERZOOM$30);
      if (sTPercentage == null)
        sTPercentage = (STPercentage)get_store().add_attribute_user(SERVERZOOM$30); 
      sTPercentage.set((XmlObject)paramSTPercentage);
    } 
  }
  
  public void unsetServerZoom() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SERVERZOOM$30);
    } 
  }
  
  public int getFirstSlideNum() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FIRSTSLIDENUM$32);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(FIRSTSLIDENUM$32); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public XmlInt xgetFirstSlideNum() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_attribute_user(FIRSTSLIDENUM$32);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_default_attribute_value(FIRSTSLIDENUM$32); 
      return xmlInt;
    } 
  }
  
  public boolean isSetFirstSlideNum() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FIRSTSLIDENUM$32) != null);
    } 
  }
  
  public void setFirstSlideNum(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FIRSTSLIDENUM$32);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FIRSTSLIDENUM$32); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetFirstSlideNum(XmlInt paramXmlInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_attribute_user(FIRSTSLIDENUM$32);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_store().add_attribute_user(FIRSTSLIDENUM$32); 
      xmlInt.set((XmlObject)paramXmlInt);
    } 
  }
  
  public void unsetFirstSlideNum() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FIRSTSLIDENUM$32);
    } 
  }
  
  public boolean getShowSpecialPlsOnTitleSld() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWSPECIALPLSONTITLESLD$34);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWSPECIALPLSONTITLESLD$34); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowSpecialPlsOnTitleSld() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWSPECIALPLSONTITLESLD$34);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWSPECIALPLSONTITLESLD$34); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowSpecialPlsOnTitleSld() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWSPECIALPLSONTITLESLD$34) != null);
    } 
  }
  
  public void setShowSpecialPlsOnTitleSld(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWSPECIALPLSONTITLESLD$34);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWSPECIALPLSONTITLESLD$34); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowSpecialPlsOnTitleSld(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWSPECIALPLSONTITLESLD$34);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWSPECIALPLSONTITLESLD$34); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowSpecialPlsOnTitleSld() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWSPECIALPLSONTITLESLD$34);
    } 
  }
  
  public boolean getRtl() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RTL$36);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(RTL$36); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetRtl() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(RTL$36);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(RTL$36); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetRtl() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(RTL$36) != null);
    } 
  }
  
  public void setRtl(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RTL$36);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(RTL$36); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetRtl(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(RTL$36);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(RTL$36); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetRtl() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(RTL$36);
    } 
  }
  
  public boolean getRemovePersonalInfoOnSave() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(REMOVEPERSONALINFOONSAVE$38);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(REMOVEPERSONALINFOONSAVE$38); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetRemovePersonalInfoOnSave() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(REMOVEPERSONALINFOONSAVE$38);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(REMOVEPERSONALINFOONSAVE$38); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetRemovePersonalInfoOnSave() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(REMOVEPERSONALINFOONSAVE$38) != null);
    } 
  }
  
  public void setRemovePersonalInfoOnSave(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(REMOVEPERSONALINFOONSAVE$38);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(REMOVEPERSONALINFOONSAVE$38); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetRemovePersonalInfoOnSave(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(REMOVEPERSONALINFOONSAVE$38);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(REMOVEPERSONALINFOONSAVE$38); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetRemovePersonalInfoOnSave() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(REMOVEPERSONALINFOONSAVE$38);
    } 
  }
  
  public boolean getCompatMode() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COMPATMODE$40);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(COMPATMODE$40); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetCompatMode() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(COMPATMODE$40);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(COMPATMODE$40); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetCompatMode() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(COMPATMODE$40) != null);
    } 
  }
  
  public void setCompatMode(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COMPATMODE$40);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(COMPATMODE$40); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetCompatMode(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(COMPATMODE$40);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(COMPATMODE$40); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetCompatMode() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(COMPATMODE$40);
    } 
  }
  
  public boolean getStrictFirstAndLastChars() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STRICTFIRSTANDLASTCHARS$42);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(STRICTFIRSTANDLASTCHARS$42); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetStrictFirstAndLastChars() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(STRICTFIRSTANDLASTCHARS$42);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(STRICTFIRSTANDLASTCHARS$42); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetStrictFirstAndLastChars() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(STRICTFIRSTANDLASTCHARS$42) != null);
    } 
  }
  
  public void setStrictFirstAndLastChars(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STRICTFIRSTANDLASTCHARS$42);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(STRICTFIRSTANDLASTCHARS$42); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetStrictFirstAndLastChars(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(STRICTFIRSTANDLASTCHARS$42);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(STRICTFIRSTANDLASTCHARS$42); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetStrictFirstAndLastChars() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(STRICTFIRSTANDLASTCHARS$42);
    } 
  }
  
  public boolean getEmbedTrueTypeFonts() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(EMBEDTRUETYPEFONTS$44);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(EMBEDTRUETYPEFONTS$44); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetEmbedTrueTypeFonts() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(EMBEDTRUETYPEFONTS$44);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(EMBEDTRUETYPEFONTS$44); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetEmbedTrueTypeFonts() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(EMBEDTRUETYPEFONTS$44) != null);
    } 
  }
  
  public void setEmbedTrueTypeFonts(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(EMBEDTRUETYPEFONTS$44);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(EMBEDTRUETYPEFONTS$44); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetEmbedTrueTypeFonts(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(EMBEDTRUETYPEFONTS$44);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(EMBEDTRUETYPEFONTS$44); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetEmbedTrueTypeFonts() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(EMBEDTRUETYPEFONTS$44);
    } 
  }
  
  public boolean getSaveSubsetFonts() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SAVESUBSETFONTS$46);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SAVESUBSETFONTS$46); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetSaveSubsetFonts() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SAVESUBSETFONTS$46);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SAVESUBSETFONTS$46); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetSaveSubsetFonts() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SAVESUBSETFONTS$46) != null);
    } 
  }
  
  public void setSaveSubsetFonts(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SAVESUBSETFONTS$46);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SAVESUBSETFONTS$46); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetSaveSubsetFonts(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SAVESUBSETFONTS$46);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SAVESUBSETFONTS$46); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetSaveSubsetFonts() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SAVESUBSETFONTS$46);
    } 
  }
  
  public boolean getAutoCompressPictures() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(AUTOCOMPRESSPICTURES$48);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(AUTOCOMPRESSPICTURES$48); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetAutoCompressPictures() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(AUTOCOMPRESSPICTURES$48);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(AUTOCOMPRESSPICTURES$48); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetAutoCompressPictures() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(AUTOCOMPRESSPICTURES$48) != null);
    } 
  }
  
  public void setAutoCompressPictures(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(AUTOCOMPRESSPICTURES$48);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(AUTOCOMPRESSPICTURES$48); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetAutoCompressPictures(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(AUTOCOMPRESSPICTURES$48);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(AUTOCOMPRESSPICTURES$48); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetAutoCompressPictures() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(AUTOCOMPRESSPICTURES$48);
    } 
  }
  
  public long getBookmarkIdSeed() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BOOKMARKIDSEED$50);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(BOOKMARKIDSEED$50); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STBookmarkIdSeed xgetBookmarkIdSeed() {
    synchronized (monitor()) {
      check_orphaned();
      STBookmarkIdSeed sTBookmarkIdSeed = null;
      sTBookmarkIdSeed = (STBookmarkIdSeed)get_store().find_attribute_user(BOOKMARKIDSEED$50);
      if (sTBookmarkIdSeed == null)
        sTBookmarkIdSeed = (STBookmarkIdSeed)get_default_attribute_value(BOOKMARKIDSEED$50); 
      return sTBookmarkIdSeed;
    } 
  }
  
  public boolean isSetBookmarkIdSeed() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BOOKMARKIDSEED$50) != null);
    } 
  }
  
  public void setBookmarkIdSeed(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BOOKMARKIDSEED$50);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BOOKMARKIDSEED$50); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetBookmarkIdSeed(STBookmarkIdSeed paramSTBookmarkIdSeed) {
    synchronized (monitor()) {
      check_orphaned();
      STBookmarkIdSeed sTBookmarkIdSeed = null;
      sTBookmarkIdSeed = (STBookmarkIdSeed)get_store().find_attribute_user(BOOKMARKIDSEED$50);
      if (sTBookmarkIdSeed == null)
        sTBookmarkIdSeed = (STBookmarkIdSeed)get_store().add_attribute_user(BOOKMARKIDSEED$50); 
      sTBookmarkIdSeed.set((XmlObject)paramSTBookmarkIdSeed);
    } 
  }
  
  public void unsetBookmarkIdSeed() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BOOKMARKIDSEED$50);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\impl\CTPresentationImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */