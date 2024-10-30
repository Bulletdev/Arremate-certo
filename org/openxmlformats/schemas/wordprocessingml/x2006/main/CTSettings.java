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
import org.openxmlformats.schemas.officeDocument.x2006.math.CTMathPr;
import org.openxmlformats.schemas.schemaLibrary.x2006.main.CTSchemaLibrary;
import org.w3c.dom.Node;

public interface CTSettings extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSettings.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsettingsd6a5type");
  
  CTWriteProtection getWriteProtection();
  
  boolean isSetWriteProtection();
  
  void setWriteProtection(CTWriteProtection paramCTWriteProtection);
  
  CTWriteProtection addNewWriteProtection();
  
  void unsetWriteProtection();
  
  CTView getView();
  
  boolean isSetView();
  
  void setView(CTView paramCTView);
  
  CTView addNewView();
  
  void unsetView();
  
  CTZoom getZoom();
  
  boolean isSetZoom();
  
  void setZoom(CTZoom paramCTZoom);
  
  CTZoom addNewZoom();
  
  void unsetZoom();
  
  CTOnOff getRemovePersonalInformation();
  
  boolean isSetRemovePersonalInformation();
  
  void setRemovePersonalInformation(CTOnOff paramCTOnOff);
  
  CTOnOff addNewRemovePersonalInformation();
  
  void unsetRemovePersonalInformation();
  
  CTOnOff getRemoveDateAndTime();
  
  boolean isSetRemoveDateAndTime();
  
  void setRemoveDateAndTime(CTOnOff paramCTOnOff);
  
  CTOnOff addNewRemoveDateAndTime();
  
  void unsetRemoveDateAndTime();
  
  CTOnOff getDoNotDisplayPageBoundaries();
  
  boolean isSetDoNotDisplayPageBoundaries();
  
  void setDoNotDisplayPageBoundaries(CTOnOff paramCTOnOff);
  
  CTOnOff addNewDoNotDisplayPageBoundaries();
  
  void unsetDoNotDisplayPageBoundaries();
  
  CTOnOff getDisplayBackgroundShape();
  
  boolean isSetDisplayBackgroundShape();
  
  void setDisplayBackgroundShape(CTOnOff paramCTOnOff);
  
  CTOnOff addNewDisplayBackgroundShape();
  
  void unsetDisplayBackgroundShape();
  
  CTOnOff getPrintPostScriptOverText();
  
  boolean isSetPrintPostScriptOverText();
  
  void setPrintPostScriptOverText(CTOnOff paramCTOnOff);
  
  CTOnOff addNewPrintPostScriptOverText();
  
  void unsetPrintPostScriptOverText();
  
  CTOnOff getPrintFractionalCharacterWidth();
  
  boolean isSetPrintFractionalCharacterWidth();
  
  void setPrintFractionalCharacterWidth(CTOnOff paramCTOnOff);
  
  CTOnOff addNewPrintFractionalCharacterWidth();
  
  void unsetPrintFractionalCharacterWidth();
  
  CTOnOff getPrintFormsData();
  
  boolean isSetPrintFormsData();
  
  void setPrintFormsData(CTOnOff paramCTOnOff);
  
  CTOnOff addNewPrintFormsData();
  
  void unsetPrintFormsData();
  
  CTOnOff getEmbedTrueTypeFonts();
  
  boolean isSetEmbedTrueTypeFonts();
  
  void setEmbedTrueTypeFonts(CTOnOff paramCTOnOff);
  
  CTOnOff addNewEmbedTrueTypeFonts();
  
  void unsetEmbedTrueTypeFonts();
  
  CTOnOff getEmbedSystemFonts();
  
  boolean isSetEmbedSystemFonts();
  
  void setEmbedSystemFonts(CTOnOff paramCTOnOff);
  
  CTOnOff addNewEmbedSystemFonts();
  
  void unsetEmbedSystemFonts();
  
  CTOnOff getSaveSubsetFonts();
  
  boolean isSetSaveSubsetFonts();
  
  void setSaveSubsetFonts(CTOnOff paramCTOnOff);
  
  CTOnOff addNewSaveSubsetFonts();
  
  void unsetSaveSubsetFonts();
  
  CTOnOff getSaveFormsData();
  
  boolean isSetSaveFormsData();
  
  void setSaveFormsData(CTOnOff paramCTOnOff);
  
  CTOnOff addNewSaveFormsData();
  
  void unsetSaveFormsData();
  
  CTOnOff getMirrorMargins();
  
  boolean isSetMirrorMargins();
  
  void setMirrorMargins(CTOnOff paramCTOnOff);
  
  CTOnOff addNewMirrorMargins();
  
  void unsetMirrorMargins();
  
  CTOnOff getAlignBordersAndEdges();
  
  boolean isSetAlignBordersAndEdges();
  
  void setAlignBordersAndEdges(CTOnOff paramCTOnOff);
  
  CTOnOff addNewAlignBordersAndEdges();
  
  void unsetAlignBordersAndEdges();
  
  CTOnOff getBordersDoNotSurroundHeader();
  
  boolean isSetBordersDoNotSurroundHeader();
  
  void setBordersDoNotSurroundHeader(CTOnOff paramCTOnOff);
  
  CTOnOff addNewBordersDoNotSurroundHeader();
  
  void unsetBordersDoNotSurroundHeader();
  
  CTOnOff getBordersDoNotSurroundFooter();
  
  boolean isSetBordersDoNotSurroundFooter();
  
  void setBordersDoNotSurroundFooter(CTOnOff paramCTOnOff);
  
  CTOnOff addNewBordersDoNotSurroundFooter();
  
  void unsetBordersDoNotSurroundFooter();
  
  CTOnOff getGutterAtTop();
  
  boolean isSetGutterAtTop();
  
  void setGutterAtTop(CTOnOff paramCTOnOff);
  
  CTOnOff addNewGutterAtTop();
  
  void unsetGutterAtTop();
  
  CTOnOff getHideSpellingErrors();
  
  boolean isSetHideSpellingErrors();
  
  void setHideSpellingErrors(CTOnOff paramCTOnOff);
  
  CTOnOff addNewHideSpellingErrors();
  
  void unsetHideSpellingErrors();
  
  CTOnOff getHideGrammaticalErrors();
  
  boolean isSetHideGrammaticalErrors();
  
  void setHideGrammaticalErrors(CTOnOff paramCTOnOff);
  
  CTOnOff addNewHideGrammaticalErrors();
  
  void unsetHideGrammaticalErrors();
  
  List<CTWritingStyle> getActiveWritingStyleList();
  
  CTWritingStyle[] getActiveWritingStyleArray();
  
  CTWritingStyle getActiveWritingStyleArray(int paramInt);
  
  int sizeOfActiveWritingStyleArray();
  
  void setActiveWritingStyleArray(CTWritingStyle[] paramArrayOfCTWritingStyle);
  
  void setActiveWritingStyleArray(int paramInt, CTWritingStyle paramCTWritingStyle);
  
  CTWritingStyle insertNewActiveWritingStyle(int paramInt);
  
  CTWritingStyle addNewActiveWritingStyle();
  
  void removeActiveWritingStyle(int paramInt);
  
  CTProof getProofState();
  
  boolean isSetProofState();
  
  void setProofState(CTProof paramCTProof);
  
  CTProof addNewProofState();
  
  void unsetProofState();
  
  CTOnOff getFormsDesign();
  
  boolean isSetFormsDesign();
  
  void setFormsDesign(CTOnOff paramCTOnOff);
  
  CTOnOff addNewFormsDesign();
  
  void unsetFormsDesign();
  
  CTRel getAttachedTemplate();
  
  boolean isSetAttachedTemplate();
  
  void setAttachedTemplate(CTRel paramCTRel);
  
  CTRel addNewAttachedTemplate();
  
  void unsetAttachedTemplate();
  
  CTOnOff getLinkStyles();
  
  boolean isSetLinkStyles();
  
  void setLinkStyles(CTOnOff paramCTOnOff);
  
  CTOnOff addNewLinkStyles();
  
  void unsetLinkStyles();
  
  CTShortHexNumber getStylePaneFormatFilter();
  
  boolean isSetStylePaneFormatFilter();
  
  void setStylePaneFormatFilter(CTShortHexNumber paramCTShortHexNumber);
  
  CTShortHexNumber addNewStylePaneFormatFilter();
  
  void unsetStylePaneFormatFilter();
  
  CTShortHexNumber getStylePaneSortMethod();
  
  boolean isSetStylePaneSortMethod();
  
  void setStylePaneSortMethod(CTShortHexNumber paramCTShortHexNumber);
  
  CTShortHexNumber addNewStylePaneSortMethod();
  
  void unsetStylePaneSortMethod();
  
  CTDocType getDocumentType();
  
  boolean isSetDocumentType();
  
  void setDocumentType(CTDocType paramCTDocType);
  
  CTDocType addNewDocumentType();
  
  void unsetDocumentType();
  
  CTMailMerge getMailMerge();
  
  boolean isSetMailMerge();
  
  void setMailMerge(CTMailMerge paramCTMailMerge);
  
  CTMailMerge addNewMailMerge();
  
  void unsetMailMerge();
  
  CTTrackChangesView getRevisionView();
  
  boolean isSetRevisionView();
  
  void setRevisionView(CTTrackChangesView paramCTTrackChangesView);
  
  CTTrackChangesView addNewRevisionView();
  
  void unsetRevisionView();
  
  CTOnOff getTrackRevisions();
  
  boolean isSetTrackRevisions();
  
  void setTrackRevisions(CTOnOff paramCTOnOff);
  
  CTOnOff addNewTrackRevisions();
  
  void unsetTrackRevisions();
  
  CTOnOff getDoNotTrackMoves();
  
  boolean isSetDoNotTrackMoves();
  
  void setDoNotTrackMoves(CTOnOff paramCTOnOff);
  
  CTOnOff addNewDoNotTrackMoves();
  
  void unsetDoNotTrackMoves();
  
  CTOnOff getDoNotTrackFormatting();
  
  boolean isSetDoNotTrackFormatting();
  
  void setDoNotTrackFormatting(CTOnOff paramCTOnOff);
  
  CTOnOff addNewDoNotTrackFormatting();
  
  void unsetDoNotTrackFormatting();
  
  CTDocProtect getDocumentProtection();
  
  boolean isSetDocumentProtection();
  
  void setDocumentProtection(CTDocProtect paramCTDocProtect);
  
  CTDocProtect addNewDocumentProtection();
  
  void unsetDocumentProtection();
  
  CTOnOff getAutoFormatOverride();
  
  boolean isSetAutoFormatOverride();
  
  void setAutoFormatOverride(CTOnOff paramCTOnOff);
  
  CTOnOff addNewAutoFormatOverride();
  
  void unsetAutoFormatOverride();
  
  CTOnOff getStyleLockTheme();
  
  boolean isSetStyleLockTheme();
  
  void setStyleLockTheme(CTOnOff paramCTOnOff);
  
  CTOnOff addNewStyleLockTheme();
  
  void unsetStyleLockTheme();
  
  CTOnOff getStyleLockQFSet();
  
  boolean isSetStyleLockQFSet();
  
  void setStyleLockQFSet(CTOnOff paramCTOnOff);
  
  CTOnOff addNewStyleLockQFSet();
  
  void unsetStyleLockQFSet();
  
  CTTwipsMeasure getDefaultTabStop();
  
  boolean isSetDefaultTabStop();
  
  void setDefaultTabStop(CTTwipsMeasure paramCTTwipsMeasure);
  
  CTTwipsMeasure addNewDefaultTabStop();
  
  void unsetDefaultTabStop();
  
  CTOnOff getAutoHyphenation();
  
  boolean isSetAutoHyphenation();
  
  void setAutoHyphenation(CTOnOff paramCTOnOff);
  
  CTOnOff addNewAutoHyphenation();
  
  void unsetAutoHyphenation();
  
  CTDecimalNumber getConsecutiveHyphenLimit();
  
  boolean isSetConsecutiveHyphenLimit();
  
  void setConsecutiveHyphenLimit(CTDecimalNumber paramCTDecimalNumber);
  
  CTDecimalNumber addNewConsecutiveHyphenLimit();
  
  void unsetConsecutiveHyphenLimit();
  
  CTTwipsMeasure getHyphenationZone();
  
  boolean isSetHyphenationZone();
  
  void setHyphenationZone(CTTwipsMeasure paramCTTwipsMeasure);
  
  CTTwipsMeasure addNewHyphenationZone();
  
  void unsetHyphenationZone();
  
  CTOnOff getDoNotHyphenateCaps();
  
  boolean isSetDoNotHyphenateCaps();
  
  void setDoNotHyphenateCaps(CTOnOff paramCTOnOff);
  
  CTOnOff addNewDoNotHyphenateCaps();
  
  void unsetDoNotHyphenateCaps();
  
  CTOnOff getShowEnvelope();
  
  boolean isSetShowEnvelope();
  
  void setShowEnvelope(CTOnOff paramCTOnOff);
  
  CTOnOff addNewShowEnvelope();
  
  void unsetShowEnvelope();
  
  CTDecimalNumber getSummaryLength();
  
  boolean isSetSummaryLength();
  
  void setSummaryLength(CTDecimalNumber paramCTDecimalNumber);
  
  CTDecimalNumber addNewSummaryLength();
  
  void unsetSummaryLength();
  
  CTString getClickAndTypeStyle();
  
  boolean isSetClickAndTypeStyle();
  
  void setClickAndTypeStyle(CTString paramCTString);
  
  CTString addNewClickAndTypeStyle();
  
  void unsetClickAndTypeStyle();
  
  CTString getDefaultTableStyle();
  
  boolean isSetDefaultTableStyle();
  
  void setDefaultTableStyle(CTString paramCTString);
  
  CTString addNewDefaultTableStyle();
  
  void unsetDefaultTableStyle();
  
  CTOnOff getEvenAndOddHeaders();
  
  boolean isSetEvenAndOddHeaders();
  
  void setEvenAndOddHeaders(CTOnOff paramCTOnOff);
  
  CTOnOff addNewEvenAndOddHeaders();
  
  void unsetEvenAndOddHeaders();
  
  CTOnOff getBookFoldRevPrinting();
  
  boolean isSetBookFoldRevPrinting();
  
  void setBookFoldRevPrinting(CTOnOff paramCTOnOff);
  
  CTOnOff addNewBookFoldRevPrinting();
  
  void unsetBookFoldRevPrinting();
  
  CTOnOff getBookFoldPrinting();
  
  boolean isSetBookFoldPrinting();
  
  void setBookFoldPrinting(CTOnOff paramCTOnOff);
  
  CTOnOff addNewBookFoldPrinting();
  
  void unsetBookFoldPrinting();
  
  CTDecimalNumber getBookFoldPrintingSheets();
  
  boolean isSetBookFoldPrintingSheets();
  
  void setBookFoldPrintingSheets(CTDecimalNumber paramCTDecimalNumber);
  
  CTDecimalNumber addNewBookFoldPrintingSheets();
  
  void unsetBookFoldPrintingSheets();
  
  CTTwipsMeasure getDrawingGridHorizontalSpacing();
  
  boolean isSetDrawingGridHorizontalSpacing();
  
  void setDrawingGridHorizontalSpacing(CTTwipsMeasure paramCTTwipsMeasure);
  
  CTTwipsMeasure addNewDrawingGridHorizontalSpacing();
  
  void unsetDrawingGridHorizontalSpacing();
  
  CTTwipsMeasure getDrawingGridVerticalSpacing();
  
  boolean isSetDrawingGridVerticalSpacing();
  
  void setDrawingGridVerticalSpacing(CTTwipsMeasure paramCTTwipsMeasure);
  
  CTTwipsMeasure addNewDrawingGridVerticalSpacing();
  
  void unsetDrawingGridVerticalSpacing();
  
  CTDecimalNumber getDisplayHorizontalDrawingGridEvery();
  
  boolean isSetDisplayHorizontalDrawingGridEvery();
  
  void setDisplayHorizontalDrawingGridEvery(CTDecimalNumber paramCTDecimalNumber);
  
  CTDecimalNumber addNewDisplayHorizontalDrawingGridEvery();
  
  void unsetDisplayHorizontalDrawingGridEvery();
  
  CTDecimalNumber getDisplayVerticalDrawingGridEvery();
  
  boolean isSetDisplayVerticalDrawingGridEvery();
  
  void setDisplayVerticalDrawingGridEvery(CTDecimalNumber paramCTDecimalNumber);
  
  CTDecimalNumber addNewDisplayVerticalDrawingGridEvery();
  
  void unsetDisplayVerticalDrawingGridEvery();
  
  CTOnOff getDoNotUseMarginsForDrawingGridOrigin();
  
  boolean isSetDoNotUseMarginsForDrawingGridOrigin();
  
  void setDoNotUseMarginsForDrawingGridOrigin(CTOnOff paramCTOnOff);
  
  CTOnOff addNewDoNotUseMarginsForDrawingGridOrigin();
  
  void unsetDoNotUseMarginsForDrawingGridOrigin();
  
  CTTwipsMeasure getDrawingGridHorizontalOrigin();
  
  boolean isSetDrawingGridHorizontalOrigin();
  
  void setDrawingGridHorizontalOrigin(CTTwipsMeasure paramCTTwipsMeasure);
  
  CTTwipsMeasure addNewDrawingGridHorizontalOrigin();
  
  void unsetDrawingGridHorizontalOrigin();
  
  CTTwipsMeasure getDrawingGridVerticalOrigin();
  
  boolean isSetDrawingGridVerticalOrigin();
  
  void setDrawingGridVerticalOrigin(CTTwipsMeasure paramCTTwipsMeasure);
  
  CTTwipsMeasure addNewDrawingGridVerticalOrigin();
  
  void unsetDrawingGridVerticalOrigin();
  
  CTOnOff getDoNotShadeFormData();
  
  boolean isSetDoNotShadeFormData();
  
  void setDoNotShadeFormData(CTOnOff paramCTOnOff);
  
  CTOnOff addNewDoNotShadeFormData();
  
  void unsetDoNotShadeFormData();
  
  CTOnOff getNoPunctuationKerning();
  
  boolean isSetNoPunctuationKerning();
  
  void setNoPunctuationKerning(CTOnOff paramCTOnOff);
  
  CTOnOff addNewNoPunctuationKerning();
  
  void unsetNoPunctuationKerning();
  
  CTCharacterSpacing getCharacterSpacingControl();
  
  boolean isSetCharacterSpacingControl();
  
  void setCharacterSpacingControl(CTCharacterSpacing paramCTCharacterSpacing);
  
  CTCharacterSpacing addNewCharacterSpacingControl();
  
  void unsetCharacterSpacingControl();
  
  CTOnOff getPrintTwoOnOne();
  
  boolean isSetPrintTwoOnOne();
  
  void setPrintTwoOnOne(CTOnOff paramCTOnOff);
  
  CTOnOff addNewPrintTwoOnOne();
  
  void unsetPrintTwoOnOne();
  
  CTOnOff getStrictFirstAndLastChars();
  
  boolean isSetStrictFirstAndLastChars();
  
  void setStrictFirstAndLastChars(CTOnOff paramCTOnOff);
  
  CTOnOff addNewStrictFirstAndLastChars();
  
  void unsetStrictFirstAndLastChars();
  
  CTKinsoku getNoLineBreaksAfter();
  
  boolean isSetNoLineBreaksAfter();
  
  void setNoLineBreaksAfter(CTKinsoku paramCTKinsoku);
  
  CTKinsoku addNewNoLineBreaksAfter();
  
  void unsetNoLineBreaksAfter();
  
  CTKinsoku getNoLineBreaksBefore();
  
  boolean isSetNoLineBreaksBefore();
  
  void setNoLineBreaksBefore(CTKinsoku paramCTKinsoku);
  
  CTKinsoku addNewNoLineBreaksBefore();
  
  void unsetNoLineBreaksBefore();
  
  CTOnOff getSavePreviewPicture();
  
  boolean isSetSavePreviewPicture();
  
  void setSavePreviewPicture(CTOnOff paramCTOnOff);
  
  CTOnOff addNewSavePreviewPicture();
  
  void unsetSavePreviewPicture();
  
  CTOnOff getDoNotValidateAgainstSchema();
  
  boolean isSetDoNotValidateAgainstSchema();
  
  void setDoNotValidateAgainstSchema(CTOnOff paramCTOnOff);
  
  CTOnOff addNewDoNotValidateAgainstSchema();
  
  void unsetDoNotValidateAgainstSchema();
  
  CTOnOff getSaveInvalidXml();
  
  boolean isSetSaveInvalidXml();
  
  void setSaveInvalidXml(CTOnOff paramCTOnOff);
  
  CTOnOff addNewSaveInvalidXml();
  
  void unsetSaveInvalidXml();
  
  CTOnOff getIgnoreMixedContent();
  
  boolean isSetIgnoreMixedContent();
  
  void setIgnoreMixedContent(CTOnOff paramCTOnOff);
  
  CTOnOff addNewIgnoreMixedContent();
  
  void unsetIgnoreMixedContent();
  
  CTOnOff getAlwaysShowPlaceholderText();
  
  boolean isSetAlwaysShowPlaceholderText();
  
  void setAlwaysShowPlaceholderText(CTOnOff paramCTOnOff);
  
  CTOnOff addNewAlwaysShowPlaceholderText();
  
  void unsetAlwaysShowPlaceholderText();
  
  CTOnOff getDoNotDemarcateInvalidXml();
  
  boolean isSetDoNotDemarcateInvalidXml();
  
  void setDoNotDemarcateInvalidXml(CTOnOff paramCTOnOff);
  
  CTOnOff addNewDoNotDemarcateInvalidXml();
  
  void unsetDoNotDemarcateInvalidXml();
  
  CTOnOff getSaveXmlDataOnly();
  
  boolean isSetSaveXmlDataOnly();
  
  void setSaveXmlDataOnly(CTOnOff paramCTOnOff);
  
  CTOnOff addNewSaveXmlDataOnly();
  
  void unsetSaveXmlDataOnly();
  
  CTOnOff getUseXSLTWhenSaving();
  
  boolean isSetUseXSLTWhenSaving();
  
  void setUseXSLTWhenSaving(CTOnOff paramCTOnOff);
  
  CTOnOff addNewUseXSLTWhenSaving();
  
  void unsetUseXSLTWhenSaving();
  
  CTSaveThroughXslt getSaveThroughXslt();
  
  boolean isSetSaveThroughXslt();
  
  void setSaveThroughXslt(CTSaveThroughXslt paramCTSaveThroughXslt);
  
  CTSaveThroughXslt addNewSaveThroughXslt();
  
  void unsetSaveThroughXslt();
  
  CTOnOff getShowXMLTags();
  
  boolean isSetShowXMLTags();
  
  void setShowXMLTags(CTOnOff paramCTOnOff);
  
  CTOnOff addNewShowXMLTags();
  
  void unsetShowXMLTags();
  
  CTOnOff getAlwaysMergeEmptyNamespace();
  
  boolean isSetAlwaysMergeEmptyNamespace();
  
  void setAlwaysMergeEmptyNamespace(CTOnOff paramCTOnOff);
  
  CTOnOff addNewAlwaysMergeEmptyNamespace();
  
  void unsetAlwaysMergeEmptyNamespace();
  
  CTOnOff getUpdateFields();
  
  boolean isSetUpdateFields();
  
  void setUpdateFields(CTOnOff paramCTOnOff);
  
  CTOnOff addNewUpdateFields();
  
  void unsetUpdateFields();
  
  CTShapeDefaults getHdrShapeDefaults();
  
  boolean isSetHdrShapeDefaults();
  
  void setHdrShapeDefaults(CTShapeDefaults paramCTShapeDefaults);
  
  CTShapeDefaults addNewHdrShapeDefaults();
  
  void unsetHdrShapeDefaults();
  
  CTFtnDocProps getFootnotePr();
  
  boolean isSetFootnotePr();
  
  void setFootnotePr(CTFtnDocProps paramCTFtnDocProps);
  
  CTFtnDocProps addNewFootnotePr();
  
  void unsetFootnotePr();
  
  CTEdnDocProps getEndnotePr();
  
  boolean isSetEndnotePr();
  
  void setEndnotePr(CTEdnDocProps paramCTEdnDocProps);
  
  CTEdnDocProps addNewEndnotePr();
  
  void unsetEndnotePr();
  
  CTCompat getCompat();
  
  boolean isSetCompat();
  
  void setCompat(CTCompat paramCTCompat);
  
  CTCompat addNewCompat();
  
  void unsetCompat();
  
  CTDocVars getDocVars();
  
  boolean isSetDocVars();
  
  void setDocVars(CTDocVars paramCTDocVars);
  
  CTDocVars addNewDocVars();
  
  void unsetDocVars();
  
  CTDocRsids getRsids();
  
  boolean isSetRsids();
  
  void setRsids(CTDocRsids paramCTDocRsids);
  
  CTDocRsids addNewRsids();
  
  void unsetRsids();
  
  CTMathPr getMathPr();
  
  boolean isSetMathPr();
  
  void setMathPr(CTMathPr paramCTMathPr);
  
  CTMathPr addNewMathPr();
  
  void unsetMathPr();
  
  CTOnOff getUiCompat97To2003();
  
  boolean isSetUiCompat97To2003();
  
  void setUiCompat97To2003(CTOnOff paramCTOnOff);
  
  CTOnOff addNewUiCompat97To2003();
  
  void unsetUiCompat97To2003();
  
  List<CTString> getAttachedSchemaList();
  
  CTString[] getAttachedSchemaArray();
  
  CTString getAttachedSchemaArray(int paramInt);
  
  int sizeOfAttachedSchemaArray();
  
  void setAttachedSchemaArray(CTString[] paramArrayOfCTString);
  
  void setAttachedSchemaArray(int paramInt, CTString paramCTString);
  
  CTString insertNewAttachedSchema(int paramInt);
  
  CTString addNewAttachedSchema();
  
  void removeAttachedSchema(int paramInt);
  
  CTLanguage getThemeFontLang();
  
  boolean isSetThemeFontLang();
  
  void setThemeFontLang(CTLanguage paramCTLanguage);
  
  CTLanguage addNewThemeFontLang();
  
  void unsetThemeFontLang();
  
  CTColorSchemeMapping getClrSchemeMapping();
  
  boolean isSetClrSchemeMapping();
  
  void setClrSchemeMapping(CTColorSchemeMapping paramCTColorSchemeMapping);
  
  CTColorSchemeMapping addNewClrSchemeMapping();
  
  void unsetClrSchemeMapping();
  
  CTOnOff getDoNotIncludeSubdocsInStats();
  
  boolean isSetDoNotIncludeSubdocsInStats();
  
  void setDoNotIncludeSubdocsInStats(CTOnOff paramCTOnOff);
  
  CTOnOff addNewDoNotIncludeSubdocsInStats();
  
  void unsetDoNotIncludeSubdocsInStats();
  
  CTOnOff getDoNotAutoCompressPictures();
  
  boolean isSetDoNotAutoCompressPictures();
  
  void setDoNotAutoCompressPictures(CTOnOff paramCTOnOff);
  
  CTOnOff addNewDoNotAutoCompressPictures();
  
  void unsetDoNotAutoCompressPictures();
  
  CTEmpty getForceUpgrade();
  
  boolean isSetForceUpgrade();
  
  void setForceUpgrade(CTEmpty paramCTEmpty);
  
  CTEmpty addNewForceUpgrade();
  
  void unsetForceUpgrade();
  
  CTCaptions getCaptions();
  
  boolean isSetCaptions();
  
  void setCaptions(CTCaptions paramCTCaptions);
  
  CTCaptions addNewCaptions();
  
  void unsetCaptions();
  
  CTReadingModeInkLockDown getReadModeInkLockDown();
  
  boolean isSetReadModeInkLockDown();
  
  void setReadModeInkLockDown(CTReadingModeInkLockDown paramCTReadingModeInkLockDown);
  
  CTReadingModeInkLockDown addNewReadModeInkLockDown();
  
  void unsetReadModeInkLockDown();
  
  List<CTSmartTagType> getSmartTagTypeList();
  
  CTSmartTagType[] getSmartTagTypeArray();
  
  CTSmartTagType getSmartTagTypeArray(int paramInt);
  
  int sizeOfSmartTagTypeArray();
  
  void setSmartTagTypeArray(CTSmartTagType[] paramArrayOfCTSmartTagType);
  
  void setSmartTagTypeArray(int paramInt, CTSmartTagType paramCTSmartTagType);
  
  CTSmartTagType insertNewSmartTagType(int paramInt);
  
  CTSmartTagType addNewSmartTagType();
  
  void removeSmartTagType(int paramInt);
  
  CTSchemaLibrary getSchemaLibrary();
  
  boolean isSetSchemaLibrary();
  
  void setSchemaLibrary(CTSchemaLibrary paramCTSchemaLibrary);
  
  CTSchemaLibrary addNewSchemaLibrary();
  
  void unsetSchemaLibrary();
  
  CTShapeDefaults getShapeDefaults();
  
  boolean isSetShapeDefaults();
  
  void setShapeDefaults(CTShapeDefaults paramCTShapeDefaults);
  
  CTShapeDefaults addNewShapeDefaults();
  
  void unsetShapeDefaults();
  
  CTOnOff getDoNotEmbedSmartTags();
  
  boolean isSetDoNotEmbedSmartTags();
  
  void setDoNotEmbedSmartTags(CTOnOff paramCTOnOff);
  
  CTOnOff addNewDoNotEmbedSmartTags();
  
  void unsetDoNotEmbedSmartTags();
  
  CTString getDecimalSymbol();
  
  boolean isSetDecimalSymbol();
  
  void setDecimalSymbol(CTString paramCTString);
  
  CTString addNewDecimalSymbol();
  
  void unsetDecimalSymbol();
  
  CTString getListSeparator();
  
  boolean isSetListSeparator();
  
  void setListSeparator(CTString paramCTString);
  
  CTString addNewListSeparator();
  
  void unsetListSeparator();
  
  public static final class Factory {
    public static CTSettings newInstance() {
      return (CTSettings)POIXMLTypeLoader.newInstance(CTSettings.type, null);
    }
    
    public static CTSettings newInstance(XmlOptions param1XmlOptions) {
      return (CTSettings)POIXMLTypeLoader.newInstance(CTSettings.type, param1XmlOptions);
    }
    
    public static CTSettings parse(String param1String) throws XmlException {
      return (CTSettings)POIXMLTypeLoader.parse(param1String, CTSettings.type, null);
    }
    
    public static CTSettings parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSettings)POIXMLTypeLoader.parse(param1String, CTSettings.type, param1XmlOptions);
    }
    
    public static CTSettings parse(File param1File) throws XmlException, IOException {
      return (CTSettings)POIXMLTypeLoader.parse(param1File, CTSettings.type, null);
    }
    
    public static CTSettings parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSettings)POIXMLTypeLoader.parse(param1File, CTSettings.type, param1XmlOptions);
    }
    
    public static CTSettings parse(URL param1URL) throws XmlException, IOException {
      return (CTSettings)POIXMLTypeLoader.parse(param1URL, CTSettings.type, null);
    }
    
    public static CTSettings parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSettings)POIXMLTypeLoader.parse(param1URL, CTSettings.type, param1XmlOptions);
    }
    
    public static CTSettings parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSettings)POIXMLTypeLoader.parse(param1InputStream, CTSettings.type, null);
    }
    
    public static CTSettings parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSettings)POIXMLTypeLoader.parse(param1InputStream, CTSettings.type, param1XmlOptions);
    }
    
    public static CTSettings parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSettings)POIXMLTypeLoader.parse(param1Reader, CTSettings.type, null);
    }
    
    public static CTSettings parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSettings)POIXMLTypeLoader.parse(param1Reader, CTSettings.type, param1XmlOptions);
    }
    
    public static CTSettings parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSettings)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSettings.type, null);
    }
    
    public static CTSettings parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSettings)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSettings.type, param1XmlOptions);
    }
    
    public static CTSettings parse(Node param1Node) throws XmlException {
      return (CTSettings)POIXMLTypeLoader.parse(param1Node, CTSettings.type, null);
    }
    
    public static CTSettings parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSettings)POIXMLTypeLoader.parse(param1Node, CTSettings.type, param1XmlOptions);
    }
    
    public static CTSettings parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSettings)POIXMLTypeLoader.parse(param1XMLInputStream, CTSettings.type, null);
    }
    
    public static CTSettings parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSettings)POIXMLTypeLoader.parse(param1XMLInputStream, CTSettings.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSettings.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSettings.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */