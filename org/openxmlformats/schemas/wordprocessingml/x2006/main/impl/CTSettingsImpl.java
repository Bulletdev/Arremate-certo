package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTMathPr;
import org.openxmlformats.schemas.schemaLibrary.x2006.main.CTSchemaLibrary;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCaptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCharacterSpacing;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColorSchemeMapping;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCompat;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocRsids;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocVars;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEdnDocProps;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEmpty;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnDocProps;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTKinsoku;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLanguage;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMailMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTProof;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTReadingModeInkLockDown;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRel;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSaveThroughXslt;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShapeDefaults;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShortHexNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChangesView;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTwipsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTView;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTWriteProtection;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTWritingStyle;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTZoom;

public class CTSettingsImpl extends XmlComplexContentImpl implements CTSettings {
  private static final b WRITEPROTECTION$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "writeProtection");
  
  private static final b VIEW$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "view");
  
  private static final b ZOOM$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "zoom");
  
  private static final b REMOVEPERSONALINFORMATION$6 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "removePersonalInformation");
  
  private static final b REMOVEDATEANDTIME$8 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "removeDateAndTime");
  
  private static final b DONOTDISPLAYPAGEBOUNDARIES$10 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "doNotDisplayPageBoundaries");
  
  private static final b DISPLAYBACKGROUNDSHAPE$12 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "displayBackgroundShape");
  
  private static final b PRINTPOSTSCRIPTOVERTEXT$14 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "printPostScriptOverText");
  
  private static final b PRINTFRACTIONALCHARACTERWIDTH$16 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "printFractionalCharacterWidth");
  
  private static final b PRINTFORMSDATA$18 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "printFormsData");
  
  private static final b EMBEDTRUETYPEFONTS$20 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "embedTrueTypeFonts");
  
  private static final b EMBEDSYSTEMFONTS$22 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "embedSystemFonts");
  
  private static final b SAVESUBSETFONTS$24 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "saveSubsetFonts");
  
  private static final b SAVEFORMSDATA$26 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "saveFormsData");
  
  private static final b MIRRORMARGINS$28 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "mirrorMargins");
  
  private static final b ALIGNBORDERSANDEDGES$30 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "alignBordersAndEdges");
  
  private static final b BORDERSDONOTSURROUNDHEADER$32 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bordersDoNotSurroundHeader");
  
  private static final b BORDERSDONOTSURROUNDFOOTER$34 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bordersDoNotSurroundFooter");
  
  private static final b GUTTERATTOP$36 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "gutterAtTop");
  
  private static final b HIDESPELLINGERRORS$38 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hideSpellingErrors");
  
  private static final b HIDEGRAMMATICALERRORS$40 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hideGrammaticalErrors");
  
  private static final b ACTIVEWRITINGSTYLE$42 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "activeWritingStyle");
  
  private static final b PROOFSTATE$44 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "proofState");
  
  private static final b FORMSDESIGN$46 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "formsDesign");
  
  private static final b ATTACHEDTEMPLATE$48 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "attachedTemplate");
  
  private static final b LINKSTYLES$50 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "linkStyles");
  
  private static final b STYLEPANEFORMATFILTER$52 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "stylePaneFormatFilter");
  
  private static final b STYLEPANESORTMETHOD$54 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "stylePaneSortMethod");
  
  private static final b DOCUMENTTYPE$56 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "documentType");
  
  private static final b MAILMERGE$58 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "mailMerge");
  
  private static final b REVISIONVIEW$60 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "revisionView");
  
  private static final b TRACKREVISIONS$62 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "trackRevisions");
  
  private static final b DONOTTRACKMOVES$64 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "doNotTrackMoves");
  
  private static final b DONOTTRACKFORMATTING$66 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "doNotTrackFormatting");
  
  private static final b DOCUMENTPROTECTION$68 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "documentProtection");
  
  private static final b AUTOFORMATOVERRIDE$70 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "autoFormatOverride");
  
  private static final b STYLELOCKTHEME$72 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "styleLockTheme");
  
  private static final b STYLELOCKQFSET$74 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "styleLockQFSet");
  
  private static final b DEFAULTTABSTOP$76 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "defaultTabStop");
  
  private static final b AUTOHYPHENATION$78 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "autoHyphenation");
  
  private static final b CONSECUTIVEHYPHENLIMIT$80 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "consecutiveHyphenLimit");
  
  private static final b HYPHENATIONZONE$82 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hyphenationZone");
  
  private static final b DONOTHYPHENATECAPS$84 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "doNotHyphenateCaps");
  
  private static final b SHOWENVELOPE$86 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "showEnvelope");
  
  private static final b SUMMARYLENGTH$88 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "summaryLength");
  
  private static final b CLICKANDTYPESTYLE$90 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "clickAndTypeStyle");
  
  private static final b DEFAULTTABLESTYLE$92 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "defaultTableStyle");
  
  private static final b EVENANDODDHEADERS$94 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "evenAndOddHeaders");
  
  private static final b BOOKFOLDREVPRINTING$96 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bookFoldRevPrinting");
  
  private static final b BOOKFOLDPRINTING$98 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bookFoldPrinting");
  
  private static final b BOOKFOLDPRINTINGSHEETS$100 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bookFoldPrintingSheets");
  
  private static final b DRAWINGGRIDHORIZONTALSPACING$102 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "drawingGridHorizontalSpacing");
  
  private static final b DRAWINGGRIDVERTICALSPACING$104 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "drawingGridVerticalSpacing");
  
  private static final b DISPLAYHORIZONTALDRAWINGGRIDEVERY$106 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "displayHorizontalDrawingGridEvery");
  
  private static final b DISPLAYVERTICALDRAWINGGRIDEVERY$108 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "displayVerticalDrawingGridEvery");
  
  private static final b DONOTUSEMARGINSFORDRAWINGGRIDORIGIN$110 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "doNotUseMarginsForDrawingGridOrigin");
  
  private static final b DRAWINGGRIDHORIZONTALORIGIN$112 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "drawingGridHorizontalOrigin");
  
  private static final b DRAWINGGRIDVERTICALORIGIN$114 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "drawingGridVerticalOrigin");
  
  private static final b DONOTSHADEFORMDATA$116 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "doNotShadeFormData");
  
  private static final b NOPUNCTUATIONKERNING$118 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "noPunctuationKerning");
  
  private static final b CHARACTERSPACINGCONTROL$120 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "characterSpacingControl");
  
  private static final b PRINTTWOONONE$122 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "printTwoOnOne");
  
  private static final b STRICTFIRSTANDLASTCHARS$124 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "strictFirstAndLastChars");
  
  private static final b NOLINEBREAKSAFTER$126 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "noLineBreaksAfter");
  
  private static final b NOLINEBREAKSBEFORE$128 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "noLineBreaksBefore");
  
  private static final b SAVEPREVIEWPICTURE$130 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "savePreviewPicture");
  
  private static final b DONOTVALIDATEAGAINSTSCHEMA$132 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "doNotValidateAgainstSchema");
  
  private static final b SAVEINVALIDXML$134 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "saveInvalidXml");
  
  private static final b IGNOREMIXEDCONTENT$136 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ignoreMixedContent");
  
  private static final b ALWAYSSHOWPLACEHOLDERTEXT$138 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "alwaysShowPlaceholderText");
  
  private static final b DONOTDEMARCATEINVALIDXML$140 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "doNotDemarcateInvalidXml");
  
  private static final b SAVEXMLDATAONLY$142 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "saveXmlDataOnly");
  
  private static final b USEXSLTWHENSAVING$144 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "useXSLTWhenSaving");
  
  private static final b SAVETHROUGHXSLT$146 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "saveThroughXslt");
  
  private static final b SHOWXMLTAGS$148 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "showXMLTags");
  
  private static final b ALWAYSMERGEEMPTYNAMESPACE$150 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "alwaysMergeEmptyNamespace");
  
  private static final b UPDATEFIELDS$152 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "updateFields");
  
  private static final b HDRSHAPEDEFAULTS$154 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hdrShapeDefaults");
  
  private static final b FOOTNOTEPR$156 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "footnotePr");
  
  private static final b ENDNOTEPR$158 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "endnotePr");
  
  private static final b COMPAT$160 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "compat");
  
  private static final b DOCVARS$162 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "docVars");
  
  private static final b RSIDS$164 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rsids");
  
  private static final b MATHPR$166 = new b("http://schemas.openxmlformats.org/officeDocument/2006/math", "mathPr");
  
  private static final b UICOMPAT97TO2003$168 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "uiCompat97To2003");
  
  private static final b ATTACHEDSCHEMA$170 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "attachedSchema");
  
  private static final b THEMEFONTLANG$172 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "themeFontLang");
  
  private static final b CLRSCHEMEMAPPING$174 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "clrSchemeMapping");
  
  private static final b DONOTINCLUDESUBDOCSINSTATS$176 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "doNotIncludeSubdocsInStats");
  
  private static final b DONOTAUTOCOMPRESSPICTURES$178 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "doNotAutoCompressPictures");
  
  private static final b FORCEUPGRADE$180 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "forceUpgrade");
  
  private static final b CAPTIONS$182 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "captions");
  
  private static final b READMODEINKLOCKDOWN$184 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "readModeInkLockDown");
  
  private static final b SMARTTAGTYPE$186 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "smartTagType");
  
  private static final b SCHEMALIBRARY$188 = new b("http://schemas.openxmlformats.org/schemaLibrary/2006/main", "schemaLibrary");
  
  private static final b SHAPEDEFAULTS$190 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "shapeDefaults");
  
  private static final b DONOTEMBEDSMARTTAGS$192 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "doNotEmbedSmartTags");
  
  private static final b DECIMALSYMBOL$194 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "decimalSymbol");
  
  private static final b LISTSEPARATOR$196 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "listSeparator");
  
  public CTSettingsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTWriteProtection getWriteProtection() {
    synchronized (monitor()) {
      check_orphaned();
      CTWriteProtection cTWriteProtection = null;
      cTWriteProtection = (CTWriteProtection)get_store().find_element_user(WRITEPROTECTION$0, 0);
      if (cTWriteProtection == null)
        return null; 
      return cTWriteProtection;
    } 
  }
  
  public boolean isSetWriteProtection() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(WRITEPROTECTION$0) != 0);
    } 
  }
  
  public void setWriteProtection(CTWriteProtection paramCTWriteProtection) {
    synchronized (monitor()) {
      check_orphaned();
      CTWriteProtection cTWriteProtection = null;
      cTWriteProtection = (CTWriteProtection)get_store().find_element_user(WRITEPROTECTION$0, 0);
      if (cTWriteProtection == null)
        cTWriteProtection = (CTWriteProtection)get_store().add_element_user(WRITEPROTECTION$0); 
      cTWriteProtection.set((XmlObject)paramCTWriteProtection);
    } 
  }
  
  public CTWriteProtection addNewWriteProtection() {
    synchronized (monitor()) {
      check_orphaned();
      CTWriteProtection cTWriteProtection = null;
      cTWriteProtection = (CTWriteProtection)get_store().add_element_user(WRITEPROTECTION$0);
      return cTWriteProtection;
    } 
  }
  
  public void unsetWriteProtection() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(WRITEPROTECTION$0, 0);
    } 
  }
  
  public CTView getView() {
    synchronized (monitor()) {
      check_orphaned();
      CTView cTView = null;
      cTView = (CTView)get_store().find_element_user(VIEW$2, 0);
      if (cTView == null)
        return null; 
      return cTView;
    } 
  }
  
  public boolean isSetView() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(VIEW$2) != 0);
    } 
  }
  
  public void setView(CTView paramCTView) {
    synchronized (monitor()) {
      check_orphaned();
      CTView cTView = null;
      cTView = (CTView)get_store().find_element_user(VIEW$2, 0);
      if (cTView == null)
        cTView = (CTView)get_store().add_element_user(VIEW$2); 
      cTView.set((XmlObject)paramCTView);
    } 
  }
  
  public CTView addNewView() {
    synchronized (monitor()) {
      check_orphaned();
      CTView cTView = null;
      cTView = (CTView)get_store().add_element_user(VIEW$2);
      return cTView;
    } 
  }
  
  public void unsetView() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(VIEW$2, 0);
    } 
  }
  
  public CTZoom getZoom() {
    synchronized (monitor()) {
      check_orphaned();
      CTZoom cTZoom = null;
      cTZoom = (CTZoom)get_store().find_element_user(ZOOM$4, 0);
      if (cTZoom == null)
        return null; 
      return cTZoom;
    } 
  }
  
  public boolean isSetZoom() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ZOOM$4) != 0);
    } 
  }
  
  public void setZoom(CTZoom paramCTZoom) {
    synchronized (monitor()) {
      check_orphaned();
      CTZoom cTZoom = null;
      cTZoom = (CTZoom)get_store().find_element_user(ZOOM$4, 0);
      if (cTZoom == null)
        cTZoom = (CTZoom)get_store().add_element_user(ZOOM$4); 
      cTZoom.set((XmlObject)paramCTZoom);
    } 
  }
  
  public CTZoom addNewZoom() {
    synchronized (monitor()) {
      check_orphaned();
      CTZoom cTZoom = null;
      cTZoom = (CTZoom)get_store().add_element_user(ZOOM$4);
      return cTZoom;
    } 
  }
  
  public void unsetZoom() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ZOOM$4, 0);
    } 
  }
  
  public CTOnOff getRemovePersonalInformation() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(REMOVEPERSONALINFORMATION$6, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetRemovePersonalInformation() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(REMOVEPERSONALINFORMATION$6) != 0);
    } 
  }
  
  public void setRemovePersonalInformation(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(REMOVEPERSONALINFORMATION$6, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(REMOVEPERSONALINFORMATION$6); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewRemovePersonalInformation() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(REMOVEPERSONALINFORMATION$6);
      return cTOnOff;
    } 
  }
  
  public void unsetRemovePersonalInformation() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(REMOVEPERSONALINFORMATION$6, 0);
    } 
  }
  
  public CTOnOff getRemoveDateAndTime() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(REMOVEDATEANDTIME$8, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetRemoveDateAndTime() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(REMOVEDATEANDTIME$8) != 0);
    } 
  }
  
  public void setRemoveDateAndTime(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(REMOVEDATEANDTIME$8, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(REMOVEDATEANDTIME$8); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewRemoveDateAndTime() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(REMOVEDATEANDTIME$8);
      return cTOnOff;
    } 
  }
  
  public void unsetRemoveDateAndTime() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(REMOVEDATEANDTIME$8, 0);
    } 
  }
  
  public CTOnOff getDoNotDisplayPageBoundaries() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(DONOTDISPLAYPAGEBOUNDARIES$10, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetDoNotDisplayPageBoundaries() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DONOTDISPLAYPAGEBOUNDARIES$10) != 0);
    } 
  }
  
  public void setDoNotDisplayPageBoundaries(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(DONOTDISPLAYPAGEBOUNDARIES$10, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(DONOTDISPLAYPAGEBOUNDARIES$10); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewDoNotDisplayPageBoundaries() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(DONOTDISPLAYPAGEBOUNDARIES$10);
      return cTOnOff;
    } 
  }
  
  public void unsetDoNotDisplayPageBoundaries() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DONOTDISPLAYPAGEBOUNDARIES$10, 0);
    } 
  }
  
  public CTOnOff getDisplayBackgroundShape() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(DISPLAYBACKGROUNDSHAPE$12, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetDisplayBackgroundShape() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DISPLAYBACKGROUNDSHAPE$12) != 0);
    } 
  }
  
  public void setDisplayBackgroundShape(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(DISPLAYBACKGROUNDSHAPE$12, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(DISPLAYBACKGROUNDSHAPE$12); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewDisplayBackgroundShape() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(DISPLAYBACKGROUNDSHAPE$12);
      return cTOnOff;
    } 
  }
  
  public void unsetDisplayBackgroundShape() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DISPLAYBACKGROUNDSHAPE$12, 0);
    } 
  }
  
  public CTOnOff getPrintPostScriptOverText() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(PRINTPOSTSCRIPTOVERTEXT$14, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetPrintPostScriptOverText() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PRINTPOSTSCRIPTOVERTEXT$14) != 0);
    } 
  }
  
  public void setPrintPostScriptOverText(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(PRINTPOSTSCRIPTOVERTEXT$14, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(PRINTPOSTSCRIPTOVERTEXT$14); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewPrintPostScriptOverText() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(PRINTPOSTSCRIPTOVERTEXT$14);
      return cTOnOff;
    } 
  }
  
  public void unsetPrintPostScriptOverText() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PRINTPOSTSCRIPTOVERTEXT$14, 0);
    } 
  }
  
  public CTOnOff getPrintFractionalCharacterWidth() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(PRINTFRACTIONALCHARACTERWIDTH$16, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetPrintFractionalCharacterWidth() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PRINTFRACTIONALCHARACTERWIDTH$16) != 0);
    } 
  }
  
  public void setPrintFractionalCharacterWidth(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(PRINTFRACTIONALCHARACTERWIDTH$16, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(PRINTFRACTIONALCHARACTERWIDTH$16); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewPrintFractionalCharacterWidth() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(PRINTFRACTIONALCHARACTERWIDTH$16);
      return cTOnOff;
    } 
  }
  
  public void unsetPrintFractionalCharacterWidth() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PRINTFRACTIONALCHARACTERWIDTH$16, 0);
    } 
  }
  
  public CTOnOff getPrintFormsData() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(PRINTFORMSDATA$18, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetPrintFormsData() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PRINTFORMSDATA$18) != 0);
    } 
  }
  
  public void setPrintFormsData(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(PRINTFORMSDATA$18, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(PRINTFORMSDATA$18); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewPrintFormsData() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(PRINTFORMSDATA$18);
      return cTOnOff;
    } 
  }
  
  public void unsetPrintFormsData() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PRINTFORMSDATA$18, 0);
    } 
  }
  
  public CTOnOff getEmbedTrueTypeFonts() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(EMBEDTRUETYPEFONTS$20, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetEmbedTrueTypeFonts() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EMBEDTRUETYPEFONTS$20) != 0);
    } 
  }
  
  public void setEmbedTrueTypeFonts(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(EMBEDTRUETYPEFONTS$20, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(EMBEDTRUETYPEFONTS$20); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewEmbedTrueTypeFonts() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(EMBEDTRUETYPEFONTS$20);
      return cTOnOff;
    } 
  }
  
  public void unsetEmbedTrueTypeFonts() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EMBEDTRUETYPEFONTS$20, 0);
    } 
  }
  
  public CTOnOff getEmbedSystemFonts() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(EMBEDSYSTEMFONTS$22, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetEmbedSystemFonts() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EMBEDSYSTEMFONTS$22) != 0);
    } 
  }
  
  public void setEmbedSystemFonts(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(EMBEDSYSTEMFONTS$22, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(EMBEDSYSTEMFONTS$22); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewEmbedSystemFonts() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(EMBEDSYSTEMFONTS$22);
      return cTOnOff;
    } 
  }
  
  public void unsetEmbedSystemFonts() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EMBEDSYSTEMFONTS$22, 0);
    } 
  }
  
  public CTOnOff getSaveSubsetFonts() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SAVESUBSETFONTS$24, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetSaveSubsetFonts() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SAVESUBSETFONTS$24) != 0);
    } 
  }
  
  public void setSaveSubsetFonts(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SAVESUBSETFONTS$24, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(SAVESUBSETFONTS$24); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewSaveSubsetFonts() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(SAVESUBSETFONTS$24);
      return cTOnOff;
    } 
  }
  
  public void unsetSaveSubsetFonts() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SAVESUBSETFONTS$24, 0);
    } 
  }
  
  public CTOnOff getSaveFormsData() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SAVEFORMSDATA$26, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetSaveFormsData() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SAVEFORMSDATA$26) != 0);
    } 
  }
  
  public void setSaveFormsData(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SAVEFORMSDATA$26, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(SAVEFORMSDATA$26); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewSaveFormsData() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(SAVEFORMSDATA$26);
      return cTOnOff;
    } 
  }
  
  public void unsetSaveFormsData() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SAVEFORMSDATA$26, 0);
    } 
  }
  
  public CTOnOff getMirrorMargins() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(MIRRORMARGINS$28, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetMirrorMargins() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(MIRRORMARGINS$28) != 0);
    } 
  }
  
  public void setMirrorMargins(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(MIRRORMARGINS$28, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(MIRRORMARGINS$28); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewMirrorMargins() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(MIRRORMARGINS$28);
      return cTOnOff;
    } 
  }
  
  public void unsetMirrorMargins() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MIRRORMARGINS$28, 0);
    } 
  }
  
  public CTOnOff getAlignBordersAndEdges() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(ALIGNBORDERSANDEDGES$30, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetAlignBordersAndEdges() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ALIGNBORDERSANDEDGES$30) != 0);
    } 
  }
  
  public void setAlignBordersAndEdges(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(ALIGNBORDERSANDEDGES$30, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(ALIGNBORDERSANDEDGES$30); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewAlignBordersAndEdges() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(ALIGNBORDERSANDEDGES$30);
      return cTOnOff;
    } 
  }
  
  public void unsetAlignBordersAndEdges() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ALIGNBORDERSANDEDGES$30, 0);
    } 
  }
  
  public CTOnOff getBordersDoNotSurroundHeader() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(BORDERSDONOTSURROUNDHEADER$32, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetBordersDoNotSurroundHeader() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BORDERSDONOTSURROUNDHEADER$32) != 0);
    } 
  }
  
  public void setBordersDoNotSurroundHeader(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(BORDERSDONOTSURROUNDHEADER$32, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(BORDERSDONOTSURROUNDHEADER$32); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewBordersDoNotSurroundHeader() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(BORDERSDONOTSURROUNDHEADER$32);
      return cTOnOff;
    } 
  }
  
  public void unsetBordersDoNotSurroundHeader() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BORDERSDONOTSURROUNDHEADER$32, 0);
    } 
  }
  
  public CTOnOff getBordersDoNotSurroundFooter() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(BORDERSDONOTSURROUNDFOOTER$34, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetBordersDoNotSurroundFooter() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BORDERSDONOTSURROUNDFOOTER$34) != 0);
    } 
  }
  
  public void setBordersDoNotSurroundFooter(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(BORDERSDONOTSURROUNDFOOTER$34, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(BORDERSDONOTSURROUNDFOOTER$34); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewBordersDoNotSurroundFooter() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(BORDERSDONOTSURROUNDFOOTER$34);
      return cTOnOff;
    } 
  }
  
  public void unsetBordersDoNotSurroundFooter() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BORDERSDONOTSURROUNDFOOTER$34, 0);
    } 
  }
  
  public CTOnOff getGutterAtTop() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(GUTTERATTOP$36, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetGutterAtTop() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(GUTTERATTOP$36) != 0);
    } 
  }
  
  public void setGutterAtTop(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(GUTTERATTOP$36, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(GUTTERATTOP$36); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewGutterAtTop() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(GUTTERATTOP$36);
      return cTOnOff;
    } 
  }
  
  public void unsetGutterAtTop() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GUTTERATTOP$36, 0);
    } 
  }
  
  public CTOnOff getHideSpellingErrors() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(HIDESPELLINGERRORS$38, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetHideSpellingErrors() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(HIDESPELLINGERRORS$38) != 0);
    } 
  }
  
  public void setHideSpellingErrors(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(HIDESPELLINGERRORS$38, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(HIDESPELLINGERRORS$38); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewHideSpellingErrors() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(HIDESPELLINGERRORS$38);
      return cTOnOff;
    } 
  }
  
  public void unsetHideSpellingErrors() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HIDESPELLINGERRORS$38, 0);
    } 
  }
  
  public CTOnOff getHideGrammaticalErrors() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(HIDEGRAMMATICALERRORS$40, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetHideGrammaticalErrors() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(HIDEGRAMMATICALERRORS$40) != 0);
    } 
  }
  
  public void setHideGrammaticalErrors(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(HIDEGRAMMATICALERRORS$40, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(HIDEGRAMMATICALERRORS$40); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewHideGrammaticalErrors() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(HIDEGRAMMATICALERRORS$40);
      return cTOnOff;
    } 
  }
  
  public void unsetHideGrammaticalErrors() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HIDEGRAMMATICALERRORS$40, 0);
    } 
  }
  
  public List<CTWritingStyle> getActiveWritingStyleList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTWritingStyle>)new ActiveWritingStyleList(this);
    } 
  }
  
  public CTWritingStyle[] getActiveWritingStyleArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ACTIVEWRITINGSTYLE$42, arrayList);
      CTWritingStyle[] arrayOfCTWritingStyle = new CTWritingStyle[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTWritingStyle);
      return arrayOfCTWritingStyle;
    } 
  }
  
  public CTWritingStyle getActiveWritingStyleArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTWritingStyle cTWritingStyle = null;
      cTWritingStyle = (CTWritingStyle)get_store().find_element_user(ACTIVEWRITINGSTYLE$42, paramInt);
      if (cTWritingStyle == null)
        throw new IndexOutOfBoundsException(); 
      return cTWritingStyle;
    } 
  }
  
  public int sizeOfActiveWritingStyleArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ACTIVEWRITINGSTYLE$42);
    } 
  }
  
  public void setActiveWritingStyleArray(CTWritingStyle[] paramArrayOfCTWritingStyle) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTWritingStyle, ACTIVEWRITINGSTYLE$42);
    } 
  }
  
  public void setActiveWritingStyleArray(int paramInt, CTWritingStyle paramCTWritingStyle) {
    synchronized (monitor()) {
      check_orphaned();
      CTWritingStyle cTWritingStyle = null;
      cTWritingStyle = (CTWritingStyle)get_store().find_element_user(ACTIVEWRITINGSTYLE$42, paramInt);
      if (cTWritingStyle == null)
        throw new IndexOutOfBoundsException(); 
      cTWritingStyle.set((XmlObject)paramCTWritingStyle);
    } 
  }
  
  public CTWritingStyle insertNewActiveWritingStyle(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTWritingStyle cTWritingStyle = null;
      cTWritingStyle = (CTWritingStyle)get_store().insert_element_user(ACTIVEWRITINGSTYLE$42, paramInt);
      return cTWritingStyle;
    } 
  }
  
  public CTWritingStyle addNewActiveWritingStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTWritingStyle cTWritingStyle = null;
      cTWritingStyle = (CTWritingStyle)get_store().add_element_user(ACTIVEWRITINGSTYLE$42);
      return cTWritingStyle;
    } 
  }
  
  public void removeActiveWritingStyle(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ACTIVEWRITINGSTYLE$42, paramInt);
    } 
  }
  
  public CTProof getProofState() {
    synchronized (monitor()) {
      check_orphaned();
      CTProof cTProof = null;
      cTProof = (CTProof)get_store().find_element_user(PROOFSTATE$44, 0);
      if (cTProof == null)
        return null; 
      return cTProof;
    } 
  }
  
  public boolean isSetProofState() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PROOFSTATE$44) != 0);
    } 
  }
  
  public void setProofState(CTProof paramCTProof) {
    synchronized (monitor()) {
      check_orphaned();
      CTProof cTProof = null;
      cTProof = (CTProof)get_store().find_element_user(PROOFSTATE$44, 0);
      if (cTProof == null)
        cTProof = (CTProof)get_store().add_element_user(PROOFSTATE$44); 
      cTProof.set((XmlObject)paramCTProof);
    } 
  }
  
  public CTProof addNewProofState() {
    synchronized (monitor()) {
      check_orphaned();
      CTProof cTProof = null;
      cTProof = (CTProof)get_store().add_element_user(PROOFSTATE$44);
      return cTProof;
    } 
  }
  
  public void unsetProofState() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PROOFSTATE$44, 0);
    } 
  }
  
  public CTOnOff getFormsDesign() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(FORMSDESIGN$46, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetFormsDesign() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FORMSDESIGN$46) != 0);
    } 
  }
  
  public void setFormsDesign(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(FORMSDESIGN$46, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(FORMSDESIGN$46); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewFormsDesign() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(FORMSDESIGN$46);
      return cTOnOff;
    } 
  }
  
  public void unsetFormsDesign() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FORMSDESIGN$46, 0);
    } 
  }
  
  public CTRel getAttachedTemplate() {
    synchronized (monitor()) {
      check_orphaned();
      CTRel cTRel = null;
      cTRel = (CTRel)get_store().find_element_user(ATTACHEDTEMPLATE$48, 0);
      if (cTRel == null)
        return null; 
      return cTRel;
    } 
  }
  
  public boolean isSetAttachedTemplate() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ATTACHEDTEMPLATE$48) != 0);
    } 
  }
  
  public void setAttachedTemplate(CTRel paramCTRel) {
    synchronized (monitor()) {
      check_orphaned();
      CTRel cTRel = null;
      cTRel = (CTRel)get_store().find_element_user(ATTACHEDTEMPLATE$48, 0);
      if (cTRel == null)
        cTRel = (CTRel)get_store().add_element_user(ATTACHEDTEMPLATE$48); 
      cTRel.set((XmlObject)paramCTRel);
    } 
  }
  
  public CTRel addNewAttachedTemplate() {
    synchronized (monitor()) {
      check_orphaned();
      CTRel cTRel = null;
      cTRel = (CTRel)get_store().add_element_user(ATTACHEDTEMPLATE$48);
      return cTRel;
    } 
  }
  
  public void unsetAttachedTemplate() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ATTACHEDTEMPLATE$48, 0);
    } 
  }
  
  public CTOnOff getLinkStyles() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(LINKSTYLES$50, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetLinkStyles() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LINKSTYLES$50) != 0);
    } 
  }
  
  public void setLinkStyles(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(LINKSTYLES$50, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(LINKSTYLES$50); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewLinkStyles() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(LINKSTYLES$50);
      return cTOnOff;
    } 
  }
  
  public void unsetLinkStyles() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LINKSTYLES$50, 0);
    } 
  }
  
  public CTShortHexNumber getStylePaneFormatFilter() {
    synchronized (monitor()) {
      check_orphaned();
      CTShortHexNumber cTShortHexNumber = null;
      cTShortHexNumber = (CTShortHexNumber)get_store().find_element_user(STYLEPANEFORMATFILTER$52, 0);
      if (cTShortHexNumber == null)
        return null; 
      return cTShortHexNumber;
    } 
  }
  
  public boolean isSetStylePaneFormatFilter() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(STYLEPANEFORMATFILTER$52) != 0);
    } 
  }
  
  public void setStylePaneFormatFilter(CTShortHexNumber paramCTShortHexNumber) {
    synchronized (monitor()) {
      check_orphaned();
      CTShortHexNumber cTShortHexNumber = null;
      cTShortHexNumber = (CTShortHexNumber)get_store().find_element_user(STYLEPANEFORMATFILTER$52, 0);
      if (cTShortHexNumber == null)
        cTShortHexNumber = (CTShortHexNumber)get_store().add_element_user(STYLEPANEFORMATFILTER$52); 
      cTShortHexNumber.set((XmlObject)paramCTShortHexNumber);
    } 
  }
  
  public CTShortHexNumber addNewStylePaneFormatFilter() {
    synchronized (monitor()) {
      check_orphaned();
      CTShortHexNumber cTShortHexNumber = null;
      cTShortHexNumber = (CTShortHexNumber)get_store().add_element_user(STYLEPANEFORMATFILTER$52);
      return cTShortHexNumber;
    } 
  }
  
  public void unsetStylePaneFormatFilter() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(STYLEPANEFORMATFILTER$52, 0);
    } 
  }
  
  public CTShortHexNumber getStylePaneSortMethod() {
    synchronized (monitor()) {
      check_orphaned();
      CTShortHexNumber cTShortHexNumber = null;
      cTShortHexNumber = (CTShortHexNumber)get_store().find_element_user(STYLEPANESORTMETHOD$54, 0);
      if (cTShortHexNumber == null)
        return null; 
      return cTShortHexNumber;
    } 
  }
  
  public boolean isSetStylePaneSortMethod() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(STYLEPANESORTMETHOD$54) != 0);
    } 
  }
  
  public void setStylePaneSortMethod(CTShortHexNumber paramCTShortHexNumber) {
    synchronized (monitor()) {
      check_orphaned();
      CTShortHexNumber cTShortHexNumber = null;
      cTShortHexNumber = (CTShortHexNumber)get_store().find_element_user(STYLEPANESORTMETHOD$54, 0);
      if (cTShortHexNumber == null)
        cTShortHexNumber = (CTShortHexNumber)get_store().add_element_user(STYLEPANESORTMETHOD$54); 
      cTShortHexNumber.set((XmlObject)paramCTShortHexNumber);
    } 
  }
  
  public CTShortHexNumber addNewStylePaneSortMethod() {
    synchronized (monitor()) {
      check_orphaned();
      CTShortHexNumber cTShortHexNumber = null;
      cTShortHexNumber = (CTShortHexNumber)get_store().add_element_user(STYLEPANESORTMETHOD$54);
      return cTShortHexNumber;
    } 
  }
  
  public void unsetStylePaneSortMethod() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(STYLEPANESORTMETHOD$54, 0);
    } 
  }
  
  public CTDocType getDocumentType() {
    synchronized (monitor()) {
      check_orphaned();
      CTDocType cTDocType = null;
      cTDocType = (CTDocType)get_store().find_element_user(DOCUMENTTYPE$56, 0);
      if (cTDocType == null)
        return null; 
      return cTDocType;
    } 
  }
  
  public boolean isSetDocumentType() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DOCUMENTTYPE$56) != 0);
    } 
  }
  
  public void setDocumentType(CTDocType paramCTDocType) {
    synchronized (monitor()) {
      check_orphaned();
      CTDocType cTDocType = null;
      cTDocType = (CTDocType)get_store().find_element_user(DOCUMENTTYPE$56, 0);
      if (cTDocType == null)
        cTDocType = (CTDocType)get_store().add_element_user(DOCUMENTTYPE$56); 
      cTDocType.set((XmlObject)paramCTDocType);
    } 
  }
  
  public CTDocType addNewDocumentType() {
    synchronized (monitor()) {
      check_orphaned();
      CTDocType cTDocType = null;
      cTDocType = (CTDocType)get_store().add_element_user(DOCUMENTTYPE$56);
      return cTDocType;
    } 
  }
  
  public void unsetDocumentType() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DOCUMENTTYPE$56, 0);
    } 
  }
  
  public CTMailMerge getMailMerge() {
    synchronized (monitor()) {
      check_orphaned();
      CTMailMerge cTMailMerge = null;
      cTMailMerge = (CTMailMerge)get_store().find_element_user(MAILMERGE$58, 0);
      if (cTMailMerge == null)
        return null; 
      return cTMailMerge;
    } 
  }
  
  public boolean isSetMailMerge() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(MAILMERGE$58) != 0);
    } 
  }
  
  public void setMailMerge(CTMailMerge paramCTMailMerge) {
    synchronized (monitor()) {
      check_orphaned();
      CTMailMerge cTMailMerge = null;
      cTMailMerge = (CTMailMerge)get_store().find_element_user(MAILMERGE$58, 0);
      if (cTMailMerge == null)
        cTMailMerge = (CTMailMerge)get_store().add_element_user(MAILMERGE$58); 
      cTMailMerge.set((XmlObject)paramCTMailMerge);
    } 
  }
  
  public CTMailMerge addNewMailMerge() {
    synchronized (monitor()) {
      check_orphaned();
      CTMailMerge cTMailMerge = null;
      cTMailMerge = (CTMailMerge)get_store().add_element_user(MAILMERGE$58);
      return cTMailMerge;
    } 
  }
  
  public void unsetMailMerge() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MAILMERGE$58, 0);
    } 
  }
  
  public CTTrackChangesView getRevisionView() {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChangesView cTTrackChangesView = null;
      cTTrackChangesView = (CTTrackChangesView)get_store().find_element_user(REVISIONVIEW$60, 0);
      if (cTTrackChangesView == null)
        return null; 
      return cTTrackChangesView;
    } 
  }
  
  public boolean isSetRevisionView() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(REVISIONVIEW$60) != 0);
    } 
  }
  
  public void setRevisionView(CTTrackChangesView paramCTTrackChangesView) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChangesView cTTrackChangesView = null;
      cTTrackChangesView = (CTTrackChangesView)get_store().find_element_user(REVISIONVIEW$60, 0);
      if (cTTrackChangesView == null)
        cTTrackChangesView = (CTTrackChangesView)get_store().add_element_user(REVISIONVIEW$60); 
      cTTrackChangesView.set((XmlObject)paramCTTrackChangesView);
    } 
  }
  
  public CTTrackChangesView addNewRevisionView() {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChangesView cTTrackChangesView = null;
      cTTrackChangesView = (CTTrackChangesView)get_store().add_element_user(REVISIONVIEW$60);
      return cTTrackChangesView;
    } 
  }
  
  public void unsetRevisionView() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(REVISIONVIEW$60, 0);
    } 
  }
  
  public CTOnOff getTrackRevisions() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(TRACKREVISIONS$62, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetTrackRevisions() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TRACKREVISIONS$62) != 0);
    } 
  }
  
  public void setTrackRevisions(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(TRACKREVISIONS$62, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(TRACKREVISIONS$62); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewTrackRevisions() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(TRACKREVISIONS$62);
      return cTOnOff;
    } 
  }
  
  public void unsetTrackRevisions() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TRACKREVISIONS$62, 0);
    } 
  }
  
  public CTOnOff getDoNotTrackMoves() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(DONOTTRACKMOVES$64, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetDoNotTrackMoves() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DONOTTRACKMOVES$64) != 0);
    } 
  }
  
  public void setDoNotTrackMoves(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(DONOTTRACKMOVES$64, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(DONOTTRACKMOVES$64); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewDoNotTrackMoves() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(DONOTTRACKMOVES$64);
      return cTOnOff;
    } 
  }
  
  public void unsetDoNotTrackMoves() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DONOTTRACKMOVES$64, 0);
    } 
  }
  
  public CTOnOff getDoNotTrackFormatting() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(DONOTTRACKFORMATTING$66, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetDoNotTrackFormatting() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DONOTTRACKFORMATTING$66) != 0);
    } 
  }
  
  public void setDoNotTrackFormatting(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(DONOTTRACKFORMATTING$66, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(DONOTTRACKFORMATTING$66); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewDoNotTrackFormatting() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(DONOTTRACKFORMATTING$66);
      return cTOnOff;
    } 
  }
  
  public void unsetDoNotTrackFormatting() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DONOTTRACKFORMATTING$66, 0);
    } 
  }
  
  public CTDocProtect getDocumentProtection() {
    synchronized (monitor()) {
      check_orphaned();
      CTDocProtect cTDocProtect = null;
      cTDocProtect = (CTDocProtect)get_store().find_element_user(DOCUMENTPROTECTION$68, 0);
      if (cTDocProtect == null)
        return null; 
      return cTDocProtect;
    } 
  }
  
  public boolean isSetDocumentProtection() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DOCUMENTPROTECTION$68) != 0);
    } 
  }
  
  public void setDocumentProtection(CTDocProtect paramCTDocProtect) {
    synchronized (monitor()) {
      check_orphaned();
      CTDocProtect cTDocProtect = null;
      cTDocProtect = (CTDocProtect)get_store().find_element_user(DOCUMENTPROTECTION$68, 0);
      if (cTDocProtect == null)
        cTDocProtect = (CTDocProtect)get_store().add_element_user(DOCUMENTPROTECTION$68); 
      cTDocProtect.set((XmlObject)paramCTDocProtect);
    } 
  }
  
  public CTDocProtect addNewDocumentProtection() {
    synchronized (monitor()) {
      check_orphaned();
      CTDocProtect cTDocProtect = null;
      cTDocProtect = (CTDocProtect)get_store().add_element_user(DOCUMENTPROTECTION$68);
      return cTDocProtect;
    } 
  }
  
  public void unsetDocumentProtection() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DOCUMENTPROTECTION$68, 0);
    } 
  }
  
  public CTOnOff getAutoFormatOverride() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(AUTOFORMATOVERRIDE$70, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetAutoFormatOverride() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(AUTOFORMATOVERRIDE$70) != 0);
    } 
  }
  
  public void setAutoFormatOverride(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(AUTOFORMATOVERRIDE$70, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(AUTOFORMATOVERRIDE$70); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewAutoFormatOverride() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(AUTOFORMATOVERRIDE$70);
      return cTOnOff;
    } 
  }
  
  public void unsetAutoFormatOverride() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(AUTOFORMATOVERRIDE$70, 0);
    } 
  }
  
  public CTOnOff getStyleLockTheme() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(STYLELOCKTHEME$72, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetStyleLockTheme() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(STYLELOCKTHEME$72) != 0);
    } 
  }
  
  public void setStyleLockTheme(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(STYLELOCKTHEME$72, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(STYLELOCKTHEME$72); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewStyleLockTheme() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(STYLELOCKTHEME$72);
      return cTOnOff;
    } 
  }
  
  public void unsetStyleLockTheme() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(STYLELOCKTHEME$72, 0);
    } 
  }
  
  public CTOnOff getStyleLockQFSet() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(STYLELOCKQFSET$74, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetStyleLockQFSet() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(STYLELOCKQFSET$74) != 0);
    } 
  }
  
  public void setStyleLockQFSet(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(STYLELOCKQFSET$74, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(STYLELOCKQFSET$74); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewStyleLockQFSet() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(STYLELOCKQFSET$74);
      return cTOnOff;
    } 
  }
  
  public void unsetStyleLockQFSet() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(STYLELOCKQFSET$74, 0);
    } 
  }
  
  public CTTwipsMeasure getDefaultTabStop() {
    synchronized (monitor()) {
      check_orphaned();
      CTTwipsMeasure cTTwipsMeasure = null;
      cTTwipsMeasure = (CTTwipsMeasure)get_store().find_element_user(DEFAULTTABSTOP$76, 0);
      if (cTTwipsMeasure == null)
        return null; 
      return cTTwipsMeasure;
    } 
  }
  
  public boolean isSetDefaultTabStop() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DEFAULTTABSTOP$76) != 0);
    } 
  }
  
  public void setDefaultTabStop(CTTwipsMeasure paramCTTwipsMeasure) {
    synchronized (monitor()) {
      check_orphaned();
      CTTwipsMeasure cTTwipsMeasure = null;
      cTTwipsMeasure = (CTTwipsMeasure)get_store().find_element_user(DEFAULTTABSTOP$76, 0);
      if (cTTwipsMeasure == null)
        cTTwipsMeasure = (CTTwipsMeasure)get_store().add_element_user(DEFAULTTABSTOP$76); 
      cTTwipsMeasure.set((XmlObject)paramCTTwipsMeasure);
    } 
  }
  
  public CTTwipsMeasure addNewDefaultTabStop() {
    synchronized (monitor()) {
      check_orphaned();
      CTTwipsMeasure cTTwipsMeasure = null;
      cTTwipsMeasure = (CTTwipsMeasure)get_store().add_element_user(DEFAULTTABSTOP$76);
      return cTTwipsMeasure;
    } 
  }
  
  public void unsetDefaultTabStop() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DEFAULTTABSTOP$76, 0);
    } 
  }
  
  public CTOnOff getAutoHyphenation() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(AUTOHYPHENATION$78, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetAutoHyphenation() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(AUTOHYPHENATION$78) != 0);
    } 
  }
  
  public void setAutoHyphenation(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(AUTOHYPHENATION$78, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(AUTOHYPHENATION$78); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewAutoHyphenation() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(AUTOHYPHENATION$78);
      return cTOnOff;
    } 
  }
  
  public void unsetAutoHyphenation() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(AUTOHYPHENATION$78, 0);
    } 
  }
  
  public CTDecimalNumber getConsecutiveHyphenLimit() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(CONSECUTIVEHYPHENLIMIT$80, 0);
      if (cTDecimalNumber == null)
        return null; 
      return cTDecimalNumber;
    } 
  }
  
  public boolean isSetConsecutiveHyphenLimit() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CONSECUTIVEHYPHENLIMIT$80) != 0);
    } 
  }
  
  public void setConsecutiveHyphenLimit(CTDecimalNumber paramCTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(CONSECUTIVEHYPHENLIMIT$80, 0);
      if (cTDecimalNumber == null)
        cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(CONSECUTIVEHYPHENLIMIT$80); 
      cTDecimalNumber.set((XmlObject)paramCTDecimalNumber);
    } 
  }
  
  public CTDecimalNumber addNewConsecutiveHyphenLimit() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(CONSECUTIVEHYPHENLIMIT$80);
      return cTDecimalNumber;
    } 
  }
  
  public void unsetConsecutiveHyphenLimit() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CONSECUTIVEHYPHENLIMIT$80, 0);
    } 
  }
  
  public CTTwipsMeasure getHyphenationZone() {
    synchronized (monitor()) {
      check_orphaned();
      CTTwipsMeasure cTTwipsMeasure = null;
      cTTwipsMeasure = (CTTwipsMeasure)get_store().find_element_user(HYPHENATIONZONE$82, 0);
      if (cTTwipsMeasure == null)
        return null; 
      return cTTwipsMeasure;
    } 
  }
  
  public boolean isSetHyphenationZone() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(HYPHENATIONZONE$82) != 0);
    } 
  }
  
  public void setHyphenationZone(CTTwipsMeasure paramCTTwipsMeasure) {
    synchronized (monitor()) {
      check_orphaned();
      CTTwipsMeasure cTTwipsMeasure = null;
      cTTwipsMeasure = (CTTwipsMeasure)get_store().find_element_user(HYPHENATIONZONE$82, 0);
      if (cTTwipsMeasure == null)
        cTTwipsMeasure = (CTTwipsMeasure)get_store().add_element_user(HYPHENATIONZONE$82); 
      cTTwipsMeasure.set((XmlObject)paramCTTwipsMeasure);
    } 
  }
  
  public CTTwipsMeasure addNewHyphenationZone() {
    synchronized (monitor()) {
      check_orphaned();
      CTTwipsMeasure cTTwipsMeasure = null;
      cTTwipsMeasure = (CTTwipsMeasure)get_store().add_element_user(HYPHENATIONZONE$82);
      return cTTwipsMeasure;
    } 
  }
  
  public void unsetHyphenationZone() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HYPHENATIONZONE$82, 0);
    } 
  }
  
  public CTOnOff getDoNotHyphenateCaps() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(DONOTHYPHENATECAPS$84, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetDoNotHyphenateCaps() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DONOTHYPHENATECAPS$84) != 0);
    } 
  }
  
  public void setDoNotHyphenateCaps(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(DONOTHYPHENATECAPS$84, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(DONOTHYPHENATECAPS$84); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewDoNotHyphenateCaps() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(DONOTHYPHENATECAPS$84);
      return cTOnOff;
    } 
  }
  
  public void unsetDoNotHyphenateCaps() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DONOTHYPHENATECAPS$84, 0);
    } 
  }
  
  public CTOnOff getShowEnvelope() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SHOWENVELOPE$86, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetShowEnvelope() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SHOWENVELOPE$86) != 0);
    } 
  }
  
  public void setShowEnvelope(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SHOWENVELOPE$86, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(SHOWENVELOPE$86); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewShowEnvelope() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(SHOWENVELOPE$86);
      return cTOnOff;
    } 
  }
  
  public void unsetShowEnvelope() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SHOWENVELOPE$86, 0);
    } 
  }
  
  public CTDecimalNumber getSummaryLength() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(SUMMARYLENGTH$88, 0);
      if (cTDecimalNumber == null)
        return null; 
      return cTDecimalNumber;
    } 
  }
  
  public boolean isSetSummaryLength() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SUMMARYLENGTH$88) != 0);
    } 
  }
  
  public void setSummaryLength(CTDecimalNumber paramCTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(SUMMARYLENGTH$88, 0);
      if (cTDecimalNumber == null)
        cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(SUMMARYLENGTH$88); 
      cTDecimalNumber.set((XmlObject)paramCTDecimalNumber);
    } 
  }
  
  public CTDecimalNumber addNewSummaryLength() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(SUMMARYLENGTH$88);
      return cTDecimalNumber;
    } 
  }
  
  public void unsetSummaryLength() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SUMMARYLENGTH$88, 0);
    } 
  }
  
  public CTString getClickAndTypeStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(CLICKANDTYPESTYLE$90, 0);
      if (cTString == null)
        return null; 
      return cTString;
    } 
  }
  
  public boolean isSetClickAndTypeStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CLICKANDTYPESTYLE$90) != 0);
    } 
  }
  
  public void setClickAndTypeStyle(CTString paramCTString) {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(CLICKANDTYPESTYLE$90, 0);
      if (cTString == null)
        cTString = (CTString)get_store().add_element_user(CLICKANDTYPESTYLE$90); 
      cTString.set((XmlObject)paramCTString);
    } 
  }
  
  public CTString addNewClickAndTypeStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().add_element_user(CLICKANDTYPESTYLE$90);
      return cTString;
    } 
  }
  
  public void unsetClickAndTypeStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CLICKANDTYPESTYLE$90, 0);
    } 
  }
  
  public CTString getDefaultTableStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(DEFAULTTABLESTYLE$92, 0);
      if (cTString == null)
        return null; 
      return cTString;
    } 
  }
  
  public boolean isSetDefaultTableStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DEFAULTTABLESTYLE$92) != 0);
    } 
  }
  
  public void setDefaultTableStyle(CTString paramCTString) {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(DEFAULTTABLESTYLE$92, 0);
      if (cTString == null)
        cTString = (CTString)get_store().add_element_user(DEFAULTTABLESTYLE$92); 
      cTString.set((XmlObject)paramCTString);
    } 
  }
  
  public CTString addNewDefaultTableStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().add_element_user(DEFAULTTABLESTYLE$92);
      return cTString;
    } 
  }
  
  public void unsetDefaultTableStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DEFAULTTABLESTYLE$92, 0);
    } 
  }
  
  public CTOnOff getEvenAndOddHeaders() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(EVENANDODDHEADERS$94, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetEvenAndOddHeaders() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EVENANDODDHEADERS$94) != 0);
    } 
  }
  
  public void setEvenAndOddHeaders(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(EVENANDODDHEADERS$94, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(EVENANDODDHEADERS$94); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewEvenAndOddHeaders() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(EVENANDODDHEADERS$94);
      return cTOnOff;
    } 
  }
  
  public void unsetEvenAndOddHeaders() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EVENANDODDHEADERS$94, 0);
    } 
  }
  
  public CTOnOff getBookFoldRevPrinting() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(BOOKFOLDREVPRINTING$96, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetBookFoldRevPrinting() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BOOKFOLDREVPRINTING$96) != 0);
    } 
  }
  
  public void setBookFoldRevPrinting(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(BOOKFOLDREVPRINTING$96, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(BOOKFOLDREVPRINTING$96); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewBookFoldRevPrinting() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(BOOKFOLDREVPRINTING$96);
      return cTOnOff;
    } 
  }
  
  public void unsetBookFoldRevPrinting() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BOOKFOLDREVPRINTING$96, 0);
    } 
  }
  
  public CTOnOff getBookFoldPrinting() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(BOOKFOLDPRINTING$98, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetBookFoldPrinting() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BOOKFOLDPRINTING$98) != 0);
    } 
  }
  
  public void setBookFoldPrinting(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(BOOKFOLDPRINTING$98, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(BOOKFOLDPRINTING$98); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewBookFoldPrinting() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(BOOKFOLDPRINTING$98);
      return cTOnOff;
    } 
  }
  
  public void unsetBookFoldPrinting() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BOOKFOLDPRINTING$98, 0);
    } 
  }
  
  public CTDecimalNumber getBookFoldPrintingSheets() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(BOOKFOLDPRINTINGSHEETS$100, 0);
      if (cTDecimalNumber == null)
        return null; 
      return cTDecimalNumber;
    } 
  }
  
  public boolean isSetBookFoldPrintingSheets() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BOOKFOLDPRINTINGSHEETS$100) != 0);
    } 
  }
  
  public void setBookFoldPrintingSheets(CTDecimalNumber paramCTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(BOOKFOLDPRINTINGSHEETS$100, 0);
      if (cTDecimalNumber == null)
        cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(BOOKFOLDPRINTINGSHEETS$100); 
      cTDecimalNumber.set((XmlObject)paramCTDecimalNumber);
    } 
  }
  
  public CTDecimalNumber addNewBookFoldPrintingSheets() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(BOOKFOLDPRINTINGSHEETS$100);
      return cTDecimalNumber;
    } 
  }
  
  public void unsetBookFoldPrintingSheets() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BOOKFOLDPRINTINGSHEETS$100, 0);
    } 
  }
  
  public CTTwipsMeasure getDrawingGridHorizontalSpacing() {
    synchronized (monitor()) {
      check_orphaned();
      CTTwipsMeasure cTTwipsMeasure = null;
      cTTwipsMeasure = (CTTwipsMeasure)get_store().find_element_user(DRAWINGGRIDHORIZONTALSPACING$102, 0);
      if (cTTwipsMeasure == null)
        return null; 
      return cTTwipsMeasure;
    } 
  }
  
  public boolean isSetDrawingGridHorizontalSpacing() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DRAWINGGRIDHORIZONTALSPACING$102) != 0);
    } 
  }
  
  public void setDrawingGridHorizontalSpacing(CTTwipsMeasure paramCTTwipsMeasure) {
    synchronized (monitor()) {
      check_orphaned();
      CTTwipsMeasure cTTwipsMeasure = null;
      cTTwipsMeasure = (CTTwipsMeasure)get_store().find_element_user(DRAWINGGRIDHORIZONTALSPACING$102, 0);
      if (cTTwipsMeasure == null)
        cTTwipsMeasure = (CTTwipsMeasure)get_store().add_element_user(DRAWINGGRIDHORIZONTALSPACING$102); 
      cTTwipsMeasure.set((XmlObject)paramCTTwipsMeasure);
    } 
  }
  
  public CTTwipsMeasure addNewDrawingGridHorizontalSpacing() {
    synchronized (monitor()) {
      check_orphaned();
      CTTwipsMeasure cTTwipsMeasure = null;
      cTTwipsMeasure = (CTTwipsMeasure)get_store().add_element_user(DRAWINGGRIDHORIZONTALSPACING$102);
      return cTTwipsMeasure;
    } 
  }
  
  public void unsetDrawingGridHorizontalSpacing() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DRAWINGGRIDHORIZONTALSPACING$102, 0);
    } 
  }
  
  public CTTwipsMeasure getDrawingGridVerticalSpacing() {
    synchronized (monitor()) {
      check_orphaned();
      CTTwipsMeasure cTTwipsMeasure = null;
      cTTwipsMeasure = (CTTwipsMeasure)get_store().find_element_user(DRAWINGGRIDVERTICALSPACING$104, 0);
      if (cTTwipsMeasure == null)
        return null; 
      return cTTwipsMeasure;
    } 
  }
  
  public boolean isSetDrawingGridVerticalSpacing() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DRAWINGGRIDVERTICALSPACING$104) != 0);
    } 
  }
  
  public void setDrawingGridVerticalSpacing(CTTwipsMeasure paramCTTwipsMeasure) {
    synchronized (monitor()) {
      check_orphaned();
      CTTwipsMeasure cTTwipsMeasure = null;
      cTTwipsMeasure = (CTTwipsMeasure)get_store().find_element_user(DRAWINGGRIDVERTICALSPACING$104, 0);
      if (cTTwipsMeasure == null)
        cTTwipsMeasure = (CTTwipsMeasure)get_store().add_element_user(DRAWINGGRIDVERTICALSPACING$104); 
      cTTwipsMeasure.set((XmlObject)paramCTTwipsMeasure);
    } 
  }
  
  public CTTwipsMeasure addNewDrawingGridVerticalSpacing() {
    synchronized (monitor()) {
      check_orphaned();
      CTTwipsMeasure cTTwipsMeasure = null;
      cTTwipsMeasure = (CTTwipsMeasure)get_store().add_element_user(DRAWINGGRIDVERTICALSPACING$104);
      return cTTwipsMeasure;
    } 
  }
  
  public void unsetDrawingGridVerticalSpacing() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DRAWINGGRIDVERTICALSPACING$104, 0);
    } 
  }
  
  public CTDecimalNumber getDisplayHorizontalDrawingGridEvery() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(DISPLAYHORIZONTALDRAWINGGRIDEVERY$106, 0);
      if (cTDecimalNumber == null)
        return null; 
      return cTDecimalNumber;
    } 
  }
  
  public boolean isSetDisplayHorizontalDrawingGridEvery() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DISPLAYHORIZONTALDRAWINGGRIDEVERY$106) != 0);
    } 
  }
  
  public void setDisplayHorizontalDrawingGridEvery(CTDecimalNumber paramCTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(DISPLAYHORIZONTALDRAWINGGRIDEVERY$106, 0);
      if (cTDecimalNumber == null)
        cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(DISPLAYHORIZONTALDRAWINGGRIDEVERY$106); 
      cTDecimalNumber.set((XmlObject)paramCTDecimalNumber);
    } 
  }
  
  public CTDecimalNumber addNewDisplayHorizontalDrawingGridEvery() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(DISPLAYHORIZONTALDRAWINGGRIDEVERY$106);
      return cTDecimalNumber;
    } 
  }
  
  public void unsetDisplayHorizontalDrawingGridEvery() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DISPLAYHORIZONTALDRAWINGGRIDEVERY$106, 0);
    } 
  }
  
  public CTDecimalNumber getDisplayVerticalDrawingGridEvery() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(DISPLAYVERTICALDRAWINGGRIDEVERY$108, 0);
      if (cTDecimalNumber == null)
        return null; 
      return cTDecimalNumber;
    } 
  }
  
  public boolean isSetDisplayVerticalDrawingGridEvery() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DISPLAYVERTICALDRAWINGGRIDEVERY$108) != 0);
    } 
  }
  
  public void setDisplayVerticalDrawingGridEvery(CTDecimalNumber paramCTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(DISPLAYVERTICALDRAWINGGRIDEVERY$108, 0);
      if (cTDecimalNumber == null)
        cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(DISPLAYVERTICALDRAWINGGRIDEVERY$108); 
      cTDecimalNumber.set((XmlObject)paramCTDecimalNumber);
    } 
  }
  
  public CTDecimalNumber addNewDisplayVerticalDrawingGridEvery() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(DISPLAYVERTICALDRAWINGGRIDEVERY$108);
      return cTDecimalNumber;
    } 
  }
  
  public void unsetDisplayVerticalDrawingGridEvery() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DISPLAYVERTICALDRAWINGGRIDEVERY$108, 0);
    } 
  }
  
  public CTOnOff getDoNotUseMarginsForDrawingGridOrigin() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(DONOTUSEMARGINSFORDRAWINGGRIDORIGIN$110, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetDoNotUseMarginsForDrawingGridOrigin() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DONOTUSEMARGINSFORDRAWINGGRIDORIGIN$110) != 0);
    } 
  }
  
  public void setDoNotUseMarginsForDrawingGridOrigin(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(DONOTUSEMARGINSFORDRAWINGGRIDORIGIN$110, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(DONOTUSEMARGINSFORDRAWINGGRIDORIGIN$110); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewDoNotUseMarginsForDrawingGridOrigin() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(DONOTUSEMARGINSFORDRAWINGGRIDORIGIN$110);
      return cTOnOff;
    } 
  }
  
  public void unsetDoNotUseMarginsForDrawingGridOrigin() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DONOTUSEMARGINSFORDRAWINGGRIDORIGIN$110, 0);
    } 
  }
  
  public CTTwipsMeasure getDrawingGridHorizontalOrigin() {
    synchronized (monitor()) {
      check_orphaned();
      CTTwipsMeasure cTTwipsMeasure = null;
      cTTwipsMeasure = (CTTwipsMeasure)get_store().find_element_user(DRAWINGGRIDHORIZONTALORIGIN$112, 0);
      if (cTTwipsMeasure == null)
        return null; 
      return cTTwipsMeasure;
    } 
  }
  
  public boolean isSetDrawingGridHorizontalOrigin() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DRAWINGGRIDHORIZONTALORIGIN$112) != 0);
    } 
  }
  
  public void setDrawingGridHorizontalOrigin(CTTwipsMeasure paramCTTwipsMeasure) {
    synchronized (monitor()) {
      check_orphaned();
      CTTwipsMeasure cTTwipsMeasure = null;
      cTTwipsMeasure = (CTTwipsMeasure)get_store().find_element_user(DRAWINGGRIDHORIZONTALORIGIN$112, 0);
      if (cTTwipsMeasure == null)
        cTTwipsMeasure = (CTTwipsMeasure)get_store().add_element_user(DRAWINGGRIDHORIZONTALORIGIN$112); 
      cTTwipsMeasure.set((XmlObject)paramCTTwipsMeasure);
    } 
  }
  
  public CTTwipsMeasure addNewDrawingGridHorizontalOrigin() {
    synchronized (monitor()) {
      check_orphaned();
      CTTwipsMeasure cTTwipsMeasure = null;
      cTTwipsMeasure = (CTTwipsMeasure)get_store().add_element_user(DRAWINGGRIDHORIZONTALORIGIN$112);
      return cTTwipsMeasure;
    } 
  }
  
  public void unsetDrawingGridHorizontalOrigin() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DRAWINGGRIDHORIZONTALORIGIN$112, 0);
    } 
  }
  
  public CTTwipsMeasure getDrawingGridVerticalOrigin() {
    synchronized (monitor()) {
      check_orphaned();
      CTTwipsMeasure cTTwipsMeasure = null;
      cTTwipsMeasure = (CTTwipsMeasure)get_store().find_element_user(DRAWINGGRIDVERTICALORIGIN$114, 0);
      if (cTTwipsMeasure == null)
        return null; 
      return cTTwipsMeasure;
    } 
  }
  
  public boolean isSetDrawingGridVerticalOrigin() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DRAWINGGRIDVERTICALORIGIN$114) != 0);
    } 
  }
  
  public void setDrawingGridVerticalOrigin(CTTwipsMeasure paramCTTwipsMeasure) {
    synchronized (monitor()) {
      check_orphaned();
      CTTwipsMeasure cTTwipsMeasure = null;
      cTTwipsMeasure = (CTTwipsMeasure)get_store().find_element_user(DRAWINGGRIDVERTICALORIGIN$114, 0);
      if (cTTwipsMeasure == null)
        cTTwipsMeasure = (CTTwipsMeasure)get_store().add_element_user(DRAWINGGRIDVERTICALORIGIN$114); 
      cTTwipsMeasure.set((XmlObject)paramCTTwipsMeasure);
    } 
  }
  
  public CTTwipsMeasure addNewDrawingGridVerticalOrigin() {
    synchronized (monitor()) {
      check_orphaned();
      CTTwipsMeasure cTTwipsMeasure = null;
      cTTwipsMeasure = (CTTwipsMeasure)get_store().add_element_user(DRAWINGGRIDVERTICALORIGIN$114);
      return cTTwipsMeasure;
    } 
  }
  
  public void unsetDrawingGridVerticalOrigin() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DRAWINGGRIDVERTICALORIGIN$114, 0);
    } 
  }
  
  public CTOnOff getDoNotShadeFormData() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(DONOTSHADEFORMDATA$116, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetDoNotShadeFormData() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DONOTSHADEFORMDATA$116) != 0);
    } 
  }
  
  public void setDoNotShadeFormData(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(DONOTSHADEFORMDATA$116, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(DONOTSHADEFORMDATA$116); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewDoNotShadeFormData() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(DONOTSHADEFORMDATA$116);
      return cTOnOff;
    } 
  }
  
  public void unsetDoNotShadeFormData() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DONOTSHADEFORMDATA$116, 0);
    } 
  }
  
  public CTOnOff getNoPunctuationKerning() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(NOPUNCTUATIONKERNING$118, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetNoPunctuationKerning() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NOPUNCTUATIONKERNING$118) != 0);
    } 
  }
  
  public void setNoPunctuationKerning(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(NOPUNCTUATIONKERNING$118, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(NOPUNCTUATIONKERNING$118); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewNoPunctuationKerning() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(NOPUNCTUATIONKERNING$118);
      return cTOnOff;
    } 
  }
  
  public void unsetNoPunctuationKerning() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NOPUNCTUATIONKERNING$118, 0);
    } 
  }
  
  public CTCharacterSpacing getCharacterSpacingControl() {
    synchronized (monitor()) {
      check_orphaned();
      CTCharacterSpacing cTCharacterSpacing = null;
      cTCharacterSpacing = (CTCharacterSpacing)get_store().find_element_user(CHARACTERSPACINGCONTROL$120, 0);
      if (cTCharacterSpacing == null)
        return null; 
      return cTCharacterSpacing;
    } 
  }
  
  public boolean isSetCharacterSpacingControl() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CHARACTERSPACINGCONTROL$120) != 0);
    } 
  }
  
  public void setCharacterSpacingControl(CTCharacterSpacing paramCTCharacterSpacing) {
    synchronized (monitor()) {
      check_orphaned();
      CTCharacterSpacing cTCharacterSpacing = null;
      cTCharacterSpacing = (CTCharacterSpacing)get_store().find_element_user(CHARACTERSPACINGCONTROL$120, 0);
      if (cTCharacterSpacing == null)
        cTCharacterSpacing = (CTCharacterSpacing)get_store().add_element_user(CHARACTERSPACINGCONTROL$120); 
      cTCharacterSpacing.set((XmlObject)paramCTCharacterSpacing);
    } 
  }
  
  public CTCharacterSpacing addNewCharacterSpacingControl() {
    synchronized (monitor()) {
      check_orphaned();
      CTCharacterSpacing cTCharacterSpacing = null;
      cTCharacterSpacing = (CTCharacterSpacing)get_store().add_element_user(CHARACTERSPACINGCONTROL$120);
      return cTCharacterSpacing;
    } 
  }
  
  public void unsetCharacterSpacingControl() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CHARACTERSPACINGCONTROL$120, 0);
    } 
  }
  
  public CTOnOff getPrintTwoOnOne() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(PRINTTWOONONE$122, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetPrintTwoOnOne() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PRINTTWOONONE$122) != 0);
    } 
  }
  
  public void setPrintTwoOnOne(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(PRINTTWOONONE$122, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(PRINTTWOONONE$122); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewPrintTwoOnOne() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(PRINTTWOONONE$122);
      return cTOnOff;
    } 
  }
  
  public void unsetPrintTwoOnOne() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PRINTTWOONONE$122, 0);
    } 
  }
  
  public CTOnOff getStrictFirstAndLastChars() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(STRICTFIRSTANDLASTCHARS$124, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetStrictFirstAndLastChars() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(STRICTFIRSTANDLASTCHARS$124) != 0);
    } 
  }
  
  public void setStrictFirstAndLastChars(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(STRICTFIRSTANDLASTCHARS$124, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(STRICTFIRSTANDLASTCHARS$124); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewStrictFirstAndLastChars() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(STRICTFIRSTANDLASTCHARS$124);
      return cTOnOff;
    } 
  }
  
  public void unsetStrictFirstAndLastChars() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(STRICTFIRSTANDLASTCHARS$124, 0);
    } 
  }
  
  public CTKinsoku getNoLineBreaksAfter() {
    synchronized (monitor()) {
      check_orphaned();
      CTKinsoku cTKinsoku = null;
      cTKinsoku = (CTKinsoku)get_store().find_element_user(NOLINEBREAKSAFTER$126, 0);
      if (cTKinsoku == null)
        return null; 
      return cTKinsoku;
    } 
  }
  
  public boolean isSetNoLineBreaksAfter() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NOLINEBREAKSAFTER$126) != 0);
    } 
  }
  
  public void setNoLineBreaksAfter(CTKinsoku paramCTKinsoku) {
    synchronized (monitor()) {
      check_orphaned();
      CTKinsoku cTKinsoku = null;
      cTKinsoku = (CTKinsoku)get_store().find_element_user(NOLINEBREAKSAFTER$126, 0);
      if (cTKinsoku == null)
        cTKinsoku = (CTKinsoku)get_store().add_element_user(NOLINEBREAKSAFTER$126); 
      cTKinsoku.set((XmlObject)paramCTKinsoku);
    } 
  }
  
  public CTKinsoku addNewNoLineBreaksAfter() {
    synchronized (monitor()) {
      check_orphaned();
      CTKinsoku cTKinsoku = null;
      cTKinsoku = (CTKinsoku)get_store().add_element_user(NOLINEBREAKSAFTER$126);
      return cTKinsoku;
    } 
  }
  
  public void unsetNoLineBreaksAfter() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NOLINEBREAKSAFTER$126, 0);
    } 
  }
  
  public CTKinsoku getNoLineBreaksBefore() {
    synchronized (monitor()) {
      check_orphaned();
      CTKinsoku cTKinsoku = null;
      cTKinsoku = (CTKinsoku)get_store().find_element_user(NOLINEBREAKSBEFORE$128, 0);
      if (cTKinsoku == null)
        return null; 
      return cTKinsoku;
    } 
  }
  
  public boolean isSetNoLineBreaksBefore() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NOLINEBREAKSBEFORE$128) != 0);
    } 
  }
  
  public void setNoLineBreaksBefore(CTKinsoku paramCTKinsoku) {
    synchronized (monitor()) {
      check_orphaned();
      CTKinsoku cTKinsoku = null;
      cTKinsoku = (CTKinsoku)get_store().find_element_user(NOLINEBREAKSBEFORE$128, 0);
      if (cTKinsoku == null)
        cTKinsoku = (CTKinsoku)get_store().add_element_user(NOLINEBREAKSBEFORE$128); 
      cTKinsoku.set((XmlObject)paramCTKinsoku);
    } 
  }
  
  public CTKinsoku addNewNoLineBreaksBefore() {
    synchronized (monitor()) {
      check_orphaned();
      CTKinsoku cTKinsoku = null;
      cTKinsoku = (CTKinsoku)get_store().add_element_user(NOLINEBREAKSBEFORE$128);
      return cTKinsoku;
    } 
  }
  
  public void unsetNoLineBreaksBefore() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NOLINEBREAKSBEFORE$128, 0);
    } 
  }
  
  public CTOnOff getSavePreviewPicture() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SAVEPREVIEWPICTURE$130, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetSavePreviewPicture() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SAVEPREVIEWPICTURE$130) != 0);
    } 
  }
  
  public void setSavePreviewPicture(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SAVEPREVIEWPICTURE$130, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(SAVEPREVIEWPICTURE$130); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewSavePreviewPicture() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(SAVEPREVIEWPICTURE$130);
      return cTOnOff;
    } 
  }
  
  public void unsetSavePreviewPicture() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SAVEPREVIEWPICTURE$130, 0);
    } 
  }
  
  public CTOnOff getDoNotValidateAgainstSchema() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(DONOTVALIDATEAGAINSTSCHEMA$132, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetDoNotValidateAgainstSchema() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DONOTVALIDATEAGAINSTSCHEMA$132) != 0);
    } 
  }
  
  public void setDoNotValidateAgainstSchema(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(DONOTVALIDATEAGAINSTSCHEMA$132, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(DONOTVALIDATEAGAINSTSCHEMA$132); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewDoNotValidateAgainstSchema() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(DONOTVALIDATEAGAINSTSCHEMA$132);
      return cTOnOff;
    } 
  }
  
  public void unsetDoNotValidateAgainstSchema() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DONOTVALIDATEAGAINSTSCHEMA$132, 0);
    } 
  }
  
  public CTOnOff getSaveInvalidXml() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SAVEINVALIDXML$134, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetSaveInvalidXml() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SAVEINVALIDXML$134) != 0);
    } 
  }
  
  public void setSaveInvalidXml(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SAVEINVALIDXML$134, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(SAVEINVALIDXML$134); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewSaveInvalidXml() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(SAVEINVALIDXML$134);
      return cTOnOff;
    } 
  }
  
  public void unsetSaveInvalidXml() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SAVEINVALIDXML$134, 0);
    } 
  }
  
  public CTOnOff getIgnoreMixedContent() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(IGNOREMIXEDCONTENT$136, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetIgnoreMixedContent() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(IGNOREMIXEDCONTENT$136) != 0);
    } 
  }
  
  public void setIgnoreMixedContent(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(IGNOREMIXEDCONTENT$136, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(IGNOREMIXEDCONTENT$136); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewIgnoreMixedContent() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(IGNOREMIXEDCONTENT$136);
      return cTOnOff;
    } 
  }
  
  public void unsetIgnoreMixedContent() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(IGNOREMIXEDCONTENT$136, 0);
    } 
  }
  
  public CTOnOff getAlwaysShowPlaceholderText() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(ALWAYSSHOWPLACEHOLDERTEXT$138, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetAlwaysShowPlaceholderText() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ALWAYSSHOWPLACEHOLDERTEXT$138) != 0);
    } 
  }
  
  public void setAlwaysShowPlaceholderText(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(ALWAYSSHOWPLACEHOLDERTEXT$138, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(ALWAYSSHOWPLACEHOLDERTEXT$138); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewAlwaysShowPlaceholderText() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(ALWAYSSHOWPLACEHOLDERTEXT$138);
      return cTOnOff;
    } 
  }
  
  public void unsetAlwaysShowPlaceholderText() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ALWAYSSHOWPLACEHOLDERTEXT$138, 0);
    } 
  }
  
  public CTOnOff getDoNotDemarcateInvalidXml() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(DONOTDEMARCATEINVALIDXML$140, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetDoNotDemarcateInvalidXml() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DONOTDEMARCATEINVALIDXML$140) != 0);
    } 
  }
  
  public void setDoNotDemarcateInvalidXml(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(DONOTDEMARCATEINVALIDXML$140, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(DONOTDEMARCATEINVALIDXML$140); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewDoNotDemarcateInvalidXml() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(DONOTDEMARCATEINVALIDXML$140);
      return cTOnOff;
    } 
  }
  
  public void unsetDoNotDemarcateInvalidXml() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DONOTDEMARCATEINVALIDXML$140, 0);
    } 
  }
  
  public CTOnOff getSaveXmlDataOnly() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SAVEXMLDATAONLY$142, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetSaveXmlDataOnly() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SAVEXMLDATAONLY$142) != 0);
    } 
  }
  
  public void setSaveXmlDataOnly(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SAVEXMLDATAONLY$142, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(SAVEXMLDATAONLY$142); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewSaveXmlDataOnly() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(SAVEXMLDATAONLY$142);
      return cTOnOff;
    } 
  }
  
  public void unsetSaveXmlDataOnly() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SAVEXMLDATAONLY$142, 0);
    } 
  }
  
  public CTOnOff getUseXSLTWhenSaving() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(USEXSLTWHENSAVING$144, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetUseXSLTWhenSaving() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(USEXSLTWHENSAVING$144) != 0);
    } 
  }
  
  public void setUseXSLTWhenSaving(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(USEXSLTWHENSAVING$144, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(USEXSLTWHENSAVING$144); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewUseXSLTWhenSaving() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(USEXSLTWHENSAVING$144);
      return cTOnOff;
    } 
  }
  
  public void unsetUseXSLTWhenSaving() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(USEXSLTWHENSAVING$144, 0);
    } 
  }
  
  public CTSaveThroughXslt getSaveThroughXslt() {
    synchronized (monitor()) {
      check_orphaned();
      CTSaveThroughXslt cTSaveThroughXslt = null;
      cTSaveThroughXslt = (CTSaveThroughXslt)get_store().find_element_user(SAVETHROUGHXSLT$146, 0);
      if (cTSaveThroughXslt == null)
        return null; 
      return cTSaveThroughXslt;
    } 
  }
  
  public boolean isSetSaveThroughXslt() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SAVETHROUGHXSLT$146) != 0);
    } 
  }
  
  public void setSaveThroughXslt(CTSaveThroughXslt paramCTSaveThroughXslt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSaveThroughXslt cTSaveThroughXslt = null;
      cTSaveThroughXslt = (CTSaveThroughXslt)get_store().find_element_user(SAVETHROUGHXSLT$146, 0);
      if (cTSaveThroughXslt == null)
        cTSaveThroughXslt = (CTSaveThroughXslt)get_store().add_element_user(SAVETHROUGHXSLT$146); 
      cTSaveThroughXslt.set((XmlObject)paramCTSaveThroughXslt);
    } 
  }
  
  public CTSaveThroughXslt addNewSaveThroughXslt() {
    synchronized (monitor()) {
      check_orphaned();
      CTSaveThroughXslt cTSaveThroughXslt = null;
      cTSaveThroughXslt = (CTSaveThroughXslt)get_store().add_element_user(SAVETHROUGHXSLT$146);
      return cTSaveThroughXslt;
    } 
  }
  
  public void unsetSaveThroughXslt() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SAVETHROUGHXSLT$146, 0);
    } 
  }
  
  public CTOnOff getShowXMLTags() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SHOWXMLTAGS$148, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetShowXMLTags() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SHOWXMLTAGS$148) != 0);
    } 
  }
  
  public void setShowXMLTags(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SHOWXMLTAGS$148, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(SHOWXMLTAGS$148); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewShowXMLTags() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(SHOWXMLTAGS$148);
      return cTOnOff;
    } 
  }
  
  public void unsetShowXMLTags() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SHOWXMLTAGS$148, 0);
    } 
  }
  
  public CTOnOff getAlwaysMergeEmptyNamespace() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(ALWAYSMERGEEMPTYNAMESPACE$150, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetAlwaysMergeEmptyNamespace() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ALWAYSMERGEEMPTYNAMESPACE$150) != 0);
    } 
  }
  
  public void setAlwaysMergeEmptyNamespace(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(ALWAYSMERGEEMPTYNAMESPACE$150, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(ALWAYSMERGEEMPTYNAMESPACE$150); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewAlwaysMergeEmptyNamespace() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(ALWAYSMERGEEMPTYNAMESPACE$150);
      return cTOnOff;
    } 
  }
  
  public void unsetAlwaysMergeEmptyNamespace() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ALWAYSMERGEEMPTYNAMESPACE$150, 0);
    } 
  }
  
  public CTOnOff getUpdateFields() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(UPDATEFIELDS$152, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetUpdateFields() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(UPDATEFIELDS$152) != 0);
    } 
  }
  
  public void setUpdateFields(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(UPDATEFIELDS$152, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(UPDATEFIELDS$152); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewUpdateFields() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(UPDATEFIELDS$152);
      return cTOnOff;
    } 
  }
  
  public void unsetUpdateFields() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(UPDATEFIELDS$152, 0);
    } 
  }
  
  public CTShapeDefaults getHdrShapeDefaults() {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeDefaults cTShapeDefaults = null;
      cTShapeDefaults = (CTShapeDefaults)get_store().find_element_user(HDRSHAPEDEFAULTS$154, 0);
      if (cTShapeDefaults == null)
        return null; 
      return cTShapeDefaults;
    } 
  }
  
  public boolean isSetHdrShapeDefaults() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(HDRSHAPEDEFAULTS$154) != 0);
    } 
  }
  
  public void setHdrShapeDefaults(CTShapeDefaults paramCTShapeDefaults) {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeDefaults cTShapeDefaults = null;
      cTShapeDefaults = (CTShapeDefaults)get_store().find_element_user(HDRSHAPEDEFAULTS$154, 0);
      if (cTShapeDefaults == null)
        cTShapeDefaults = (CTShapeDefaults)get_store().add_element_user(HDRSHAPEDEFAULTS$154); 
      cTShapeDefaults.set((XmlObject)paramCTShapeDefaults);
    } 
  }
  
  public CTShapeDefaults addNewHdrShapeDefaults() {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeDefaults cTShapeDefaults = null;
      cTShapeDefaults = (CTShapeDefaults)get_store().add_element_user(HDRSHAPEDEFAULTS$154);
      return cTShapeDefaults;
    } 
  }
  
  public void unsetHdrShapeDefaults() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HDRSHAPEDEFAULTS$154, 0);
    } 
  }
  
  public CTFtnDocProps getFootnotePr() {
    synchronized (monitor()) {
      check_orphaned();
      CTFtnDocProps cTFtnDocProps = null;
      cTFtnDocProps = (CTFtnDocProps)get_store().find_element_user(FOOTNOTEPR$156, 0);
      if (cTFtnDocProps == null)
        return null; 
      return cTFtnDocProps;
    } 
  }
  
  public boolean isSetFootnotePr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FOOTNOTEPR$156) != 0);
    } 
  }
  
  public void setFootnotePr(CTFtnDocProps paramCTFtnDocProps) {
    synchronized (monitor()) {
      check_orphaned();
      CTFtnDocProps cTFtnDocProps = null;
      cTFtnDocProps = (CTFtnDocProps)get_store().find_element_user(FOOTNOTEPR$156, 0);
      if (cTFtnDocProps == null)
        cTFtnDocProps = (CTFtnDocProps)get_store().add_element_user(FOOTNOTEPR$156); 
      cTFtnDocProps.set((XmlObject)paramCTFtnDocProps);
    } 
  }
  
  public CTFtnDocProps addNewFootnotePr() {
    synchronized (monitor()) {
      check_orphaned();
      CTFtnDocProps cTFtnDocProps = null;
      cTFtnDocProps = (CTFtnDocProps)get_store().add_element_user(FOOTNOTEPR$156);
      return cTFtnDocProps;
    } 
  }
  
  public void unsetFootnotePr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FOOTNOTEPR$156, 0);
    } 
  }
  
  public CTEdnDocProps getEndnotePr() {
    synchronized (monitor()) {
      check_orphaned();
      CTEdnDocProps cTEdnDocProps = null;
      cTEdnDocProps = (CTEdnDocProps)get_store().find_element_user(ENDNOTEPR$158, 0);
      if (cTEdnDocProps == null)
        return null; 
      return cTEdnDocProps;
    } 
  }
  
  public boolean isSetEndnotePr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ENDNOTEPR$158) != 0);
    } 
  }
  
  public void setEndnotePr(CTEdnDocProps paramCTEdnDocProps) {
    synchronized (monitor()) {
      check_orphaned();
      CTEdnDocProps cTEdnDocProps = null;
      cTEdnDocProps = (CTEdnDocProps)get_store().find_element_user(ENDNOTEPR$158, 0);
      if (cTEdnDocProps == null)
        cTEdnDocProps = (CTEdnDocProps)get_store().add_element_user(ENDNOTEPR$158); 
      cTEdnDocProps.set((XmlObject)paramCTEdnDocProps);
    } 
  }
  
  public CTEdnDocProps addNewEndnotePr() {
    synchronized (monitor()) {
      check_orphaned();
      CTEdnDocProps cTEdnDocProps = null;
      cTEdnDocProps = (CTEdnDocProps)get_store().add_element_user(ENDNOTEPR$158);
      return cTEdnDocProps;
    } 
  }
  
  public void unsetEndnotePr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ENDNOTEPR$158, 0);
    } 
  }
  
  public CTCompat getCompat() {
    synchronized (monitor()) {
      check_orphaned();
      CTCompat cTCompat = null;
      cTCompat = (CTCompat)get_store().find_element_user(COMPAT$160, 0);
      if (cTCompat == null)
        return null; 
      return cTCompat;
    } 
  }
  
  public boolean isSetCompat() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(COMPAT$160) != 0);
    } 
  }
  
  public void setCompat(CTCompat paramCTCompat) {
    synchronized (monitor()) {
      check_orphaned();
      CTCompat cTCompat = null;
      cTCompat = (CTCompat)get_store().find_element_user(COMPAT$160, 0);
      if (cTCompat == null)
        cTCompat = (CTCompat)get_store().add_element_user(COMPAT$160); 
      cTCompat.set((XmlObject)paramCTCompat);
    } 
  }
  
  public CTCompat addNewCompat() {
    synchronized (monitor()) {
      check_orphaned();
      CTCompat cTCompat = null;
      cTCompat = (CTCompat)get_store().add_element_user(COMPAT$160);
      return cTCompat;
    } 
  }
  
  public void unsetCompat() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(COMPAT$160, 0);
    } 
  }
  
  public CTDocVars getDocVars() {
    synchronized (monitor()) {
      check_orphaned();
      CTDocVars cTDocVars = null;
      cTDocVars = (CTDocVars)get_store().find_element_user(DOCVARS$162, 0);
      if (cTDocVars == null)
        return null; 
      return cTDocVars;
    } 
  }
  
  public boolean isSetDocVars() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DOCVARS$162) != 0);
    } 
  }
  
  public void setDocVars(CTDocVars paramCTDocVars) {
    synchronized (monitor()) {
      check_orphaned();
      CTDocVars cTDocVars = null;
      cTDocVars = (CTDocVars)get_store().find_element_user(DOCVARS$162, 0);
      if (cTDocVars == null)
        cTDocVars = (CTDocVars)get_store().add_element_user(DOCVARS$162); 
      cTDocVars.set((XmlObject)paramCTDocVars);
    } 
  }
  
  public CTDocVars addNewDocVars() {
    synchronized (monitor()) {
      check_orphaned();
      CTDocVars cTDocVars = null;
      cTDocVars = (CTDocVars)get_store().add_element_user(DOCVARS$162);
      return cTDocVars;
    } 
  }
  
  public void unsetDocVars() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DOCVARS$162, 0);
    } 
  }
  
  public CTDocRsids getRsids() {
    synchronized (monitor()) {
      check_orphaned();
      CTDocRsids cTDocRsids = null;
      cTDocRsids = (CTDocRsids)get_store().find_element_user(RSIDS$164, 0);
      if (cTDocRsids == null)
        return null; 
      return cTDocRsids;
    } 
  }
  
  public boolean isSetRsids() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(RSIDS$164) != 0);
    } 
  }
  
  public void setRsids(CTDocRsids paramCTDocRsids) {
    synchronized (monitor()) {
      check_orphaned();
      CTDocRsids cTDocRsids = null;
      cTDocRsids = (CTDocRsids)get_store().find_element_user(RSIDS$164, 0);
      if (cTDocRsids == null)
        cTDocRsids = (CTDocRsids)get_store().add_element_user(RSIDS$164); 
      cTDocRsids.set((XmlObject)paramCTDocRsids);
    } 
  }
  
  public CTDocRsids addNewRsids() {
    synchronized (monitor()) {
      check_orphaned();
      CTDocRsids cTDocRsids = null;
      cTDocRsids = (CTDocRsids)get_store().add_element_user(RSIDS$164);
      return cTDocRsids;
    } 
  }
  
  public void unsetRsids() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(RSIDS$164, 0);
    } 
  }
  
  public CTMathPr getMathPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTMathPr cTMathPr = null;
      cTMathPr = (CTMathPr)get_store().find_element_user(MATHPR$166, 0);
      if (cTMathPr == null)
        return null; 
      return cTMathPr;
    } 
  }
  
  public boolean isSetMathPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(MATHPR$166) != 0);
    } 
  }
  
  public void setMathPr(CTMathPr paramCTMathPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTMathPr cTMathPr = null;
      cTMathPr = (CTMathPr)get_store().find_element_user(MATHPR$166, 0);
      if (cTMathPr == null)
        cTMathPr = (CTMathPr)get_store().add_element_user(MATHPR$166); 
      cTMathPr.set((XmlObject)paramCTMathPr);
    } 
  }
  
  public CTMathPr addNewMathPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTMathPr cTMathPr = null;
      cTMathPr = (CTMathPr)get_store().add_element_user(MATHPR$166);
      return cTMathPr;
    } 
  }
  
  public void unsetMathPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MATHPR$166, 0);
    } 
  }
  
  public CTOnOff getUiCompat97To2003() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(UICOMPAT97TO2003$168, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetUiCompat97To2003() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(UICOMPAT97TO2003$168) != 0);
    } 
  }
  
  public void setUiCompat97To2003(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(UICOMPAT97TO2003$168, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(UICOMPAT97TO2003$168); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewUiCompat97To2003() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(UICOMPAT97TO2003$168);
      return cTOnOff;
    } 
  }
  
  public void unsetUiCompat97To2003() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(UICOMPAT97TO2003$168, 0);
    } 
  }
  
  public List<CTString> getAttachedSchemaList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTString>)new AttachedSchemaList(this);
    } 
  }
  
  public CTString[] getAttachedSchemaArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ATTACHEDSCHEMA$170, arrayList);
      CTString[] arrayOfCTString = new CTString[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTString);
      return arrayOfCTString;
    } 
  }
  
  public CTString getAttachedSchemaArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(ATTACHEDSCHEMA$170, paramInt);
      if (cTString == null)
        throw new IndexOutOfBoundsException(); 
      return cTString;
    } 
  }
  
  public int sizeOfAttachedSchemaArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ATTACHEDSCHEMA$170);
    } 
  }
  
  public void setAttachedSchemaArray(CTString[] paramArrayOfCTString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTString, ATTACHEDSCHEMA$170);
    } 
  }
  
  public void setAttachedSchemaArray(int paramInt, CTString paramCTString) {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(ATTACHEDSCHEMA$170, paramInt);
      if (cTString == null)
        throw new IndexOutOfBoundsException(); 
      cTString.set((XmlObject)paramCTString);
    } 
  }
  
  public CTString insertNewAttachedSchema(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().insert_element_user(ATTACHEDSCHEMA$170, paramInt);
      return cTString;
    } 
  }
  
  public CTString addNewAttachedSchema() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().add_element_user(ATTACHEDSCHEMA$170);
      return cTString;
    } 
  }
  
  public void removeAttachedSchema(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ATTACHEDSCHEMA$170, paramInt);
    } 
  }
  
  public CTLanguage getThemeFontLang() {
    synchronized (monitor()) {
      check_orphaned();
      CTLanguage cTLanguage = null;
      cTLanguage = (CTLanguage)get_store().find_element_user(THEMEFONTLANG$172, 0);
      if (cTLanguage == null)
        return null; 
      return cTLanguage;
    } 
  }
  
  public boolean isSetThemeFontLang() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(THEMEFONTLANG$172) != 0);
    } 
  }
  
  public void setThemeFontLang(CTLanguage paramCTLanguage) {
    synchronized (monitor()) {
      check_orphaned();
      CTLanguage cTLanguage = null;
      cTLanguage = (CTLanguage)get_store().find_element_user(THEMEFONTLANG$172, 0);
      if (cTLanguage == null)
        cTLanguage = (CTLanguage)get_store().add_element_user(THEMEFONTLANG$172); 
      cTLanguage.set((XmlObject)paramCTLanguage);
    } 
  }
  
  public CTLanguage addNewThemeFontLang() {
    synchronized (monitor()) {
      check_orphaned();
      CTLanguage cTLanguage = null;
      cTLanguage = (CTLanguage)get_store().add_element_user(THEMEFONTLANG$172);
      return cTLanguage;
    } 
  }
  
  public void unsetThemeFontLang() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(THEMEFONTLANG$172, 0);
    } 
  }
  
  public CTColorSchemeMapping getClrSchemeMapping() {
    synchronized (monitor()) {
      check_orphaned();
      CTColorSchemeMapping cTColorSchemeMapping = null;
      cTColorSchemeMapping = (CTColorSchemeMapping)get_store().find_element_user(CLRSCHEMEMAPPING$174, 0);
      if (cTColorSchemeMapping == null)
        return null; 
      return cTColorSchemeMapping;
    } 
  }
  
  public boolean isSetClrSchemeMapping() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CLRSCHEMEMAPPING$174) != 0);
    } 
  }
  
  public void setClrSchemeMapping(CTColorSchemeMapping paramCTColorSchemeMapping) {
    synchronized (monitor()) {
      check_orphaned();
      CTColorSchemeMapping cTColorSchemeMapping = null;
      cTColorSchemeMapping = (CTColorSchemeMapping)get_store().find_element_user(CLRSCHEMEMAPPING$174, 0);
      if (cTColorSchemeMapping == null)
        cTColorSchemeMapping = (CTColorSchemeMapping)get_store().add_element_user(CLRSCHEMEMAPPING$174); 
      cTColorSchemeMapping.set((XmlObject)paramCTColorSchemeMapping);
    } 
  }
  
  public CTColorSchemeMapping addNewClrSchemeMapping() {
    synchronized (monitor()) {
      check_orphaned();
      CTColorSchemeMapping cTColorSchemeMapping = null;
      cTColorSchemeMapping = (CTColorSchemeMapping)get_store().add_element_user(CLRSCHEMEMAPPING$174);
      return cTColorSchemeMapping;
    } 
  }
  
  public void unsetClrSchemeMapping() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CLRSCHEMEMAPPING$174, 0);
    } 
  }
  
  public CTOnOff getDoNotIncludeSubdocsInStats() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(DONOTINCLUDESUBDOCSINSTATS$176, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetDoNotIncludeSubdocsInStats() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DONOTINCLUDESUBDOCSINSTATS$176) != 0);
    } 
  }
  
  public void setDoNotIncludeSubdocsInStats(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(DONOTINCLUDESUBDOCSINSTATS$176, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(DONOTINCLUDESUBDOCSINSTATS$176); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewDoNotIncludeSubdocsInStats() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(DONOTINCLUDESUBDOCSINSTATS$176);
      return cTOnOff;
    } 
  }
  
  public void unsetDoNotIncludeSubdocsInStats() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DONOTINCLUDESUBDOCSINSTATS$176, 0);
    } 
  }
  
  public CTOnOff getDoNotAutoCompressPictures() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(DONOTAUTOCOMPRESSPICTURES$178, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetDoNotAutoCompressPictures() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DONOTAUTOCOMPRESSPICTURES$178) != 0);
    } 
  }
  
  public void setDoNotAutoCompressPictures(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(DONOTAUTOCOMPRESSPICTURES$178, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(DONOTAUTOCOMPRESSPICTURES$178); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewDoNotAutoCompressPictures() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(DONOTAUTOCOMPRESSPICTURES$178);
      return cTOnOff;
    } 
  }
  
  public void unsetDoNotAutoCompressPictures() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DONOTAUTOCOMPRESSPICTURES$178, 0);
    } 
  }
  
  public CTEmpty getForceUpgrade() {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(FORCEUPGRADE$180, 0);
      if (cTEmpty == null)
        return null; 
      return cTEmpty;
    } 
  }
  
  public boolean isSetForceUpgrade() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FORCEUPGRADE$180) != 0);
    } 
  }
  
  public void setForceUpgrade(CTEmpty paramCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(FORCEUPGRADE$180, 0);
      if (cTEmpty == null)
        cTEmpty = (CTEmpty)get_store().add_element_user(FORCEUPGRADE$180); 
      cTEmpty.set((XmlObject)paramCTEmpty);
    } 
  }
  
  public CTEmpty addNewForceUpgrade() {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().add_element_user(FORCEUPGRADE$180);
      return cTEmpty;
    } 
  }
  
  public void unsetForceUpgrade() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FORCEUPGRADE$180, 0);
    } 
  }
  
  public CTCaptions getCaptions() {
    synchronized (monitor()) {
      check_orphaned();
      CTCaptions cTCaptions = null;
      cTCaptions = (CTCaptions)get_store().find_element_user(CAPTIONS$182, 0);
      if (cTCaptions == null)
        return null; 
      return cTCaptions;
    } 
  }
  
  public boolean isSetCaptions() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CAPTIONS$182) != 0);
    } 
  }
  
  public void setCaptions(CTCaptions paramCTCaptions) {
    synchronized (monitor()) {
      check_orphaned();
      CTCaptions cTCaptions = null;
      cTCaptions = (CTCaptions)get_store().find_element_user(CAPTIONS$182, 0);
      if (cTCaptions == null)
        cTCaptions = (CTCaptions)get_store().add_element_user(CAPTIONS$182); 
      cTCaptions.set((XmlObject)paramCTCaptions);
    } 
  }
  
  public CTCaptions addNewCaptions() {
    synchronized (monitor()) {
      check_orphaned();
      CTCaptions cTCaptions = null;
      cTCaptions = (CTCaptions)get_store().add_element_user(CAPTIONS$182);
      return cTCaptions;
    } 
  }
  
  public void unsetCaptions() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CAPTIONS$182, 0);
    } 
  }
  
  public CTReadingModeInkLockDown getReadModeInkLockDown() {
    synchronized (monitor()) {
      check_orphaned();
      CTReadingModeInkLockDown cTReadingModeInkLockDown = null;
      cTReadingModeInkLockDown = (CTReadingModeInkLockDown)get_store().find_element_user(READMODEINKLOCKDOWN$184, 0);
      if (cTReadingModeInkLockDown == null)
        return null; 
      return cTReadingModeInkLockDown;
    } 
  }
  
  public boolean isSetReadModeInkLockDown() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(READMODEINKLOCKDOWN$184) != 0);
    } 
  }
  
  public void setReadModeInkLockDown(CTReadingModeInkLockDown paramCTReadingModeInkLockDown) {
    synchronized (monitor()) {
      check_orphaned();
      CTReadingModeInkLockDown cTReadingModeInkLockDown = null;
      cTReadingModeInkLockDown = (CTReadingModeInkLockDown)get_store().find_element_user(READMODEINKLOCKDOWN$184, 0);
      if (cTReadingModeInkLockDown == null)
        cTReadingModeInkLockDown = (CTReadingModeInkLockDown)get_store().add_element_user(READMODEINKLOCKDOWN$184); 
      cTReadingModeInkLockDown.set((XmlObject)paramCTReadingModeInkLockDown);
    } 
  }
  
  public CTReadingModeInkLockDown addNewReadModeInkLockDown() {
    synchronized (monitor()) {
      check_orphaned();
      CTReadingModeInkLockDown cTReadingModeInkLockDown = null;
      cTReadingModeInkLockDown = (CTReadingModeInkLockDown)get_store().add_element_user(READMODEINKLOCKDOWN$184);
      return cTReadingModeInkLockDown;
    } 
  }
  
  public void unsetReadModeInkLockDown() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(READMODEINKLOCKDOWN$184, 0);
    } 
  }
  
  public List<CTSmartTagType> getSmartTagTypeList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTSmartTagType>)new SmartTagTypeList(this);
    } 
  }
  
  public CTSmartTagType[] getSmartTagTypeArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SMARTTAGTYPE$186, arrayList);
      CTSmartTagType[] arrayOfCTSmartTagType = new CTSmartTagType[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTSmartTagType);
      return arrayOfCTSmartTagType;
    } 
  }
  
  public CTSmartTagType getSmartTagTypeArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSmartTagType cTSmartTagType = null;
      cTSmartTagType = (CTSmartTagType)get_store().find_element_user(SMARTTAGTYPE$186, paramInt);
      if (cTSmartTagType == null)
        throw new IndexOutOfBoundsException(); 
      return cTSmartTagType;
    } 
  }
  
  public int sizeOfSmartTagTypeArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SMARTTAGTYPE$186);
    } 
  }
  
  public void setSmartTagTypeArray(CTSmartTagType[] paramArrayOfCTSmartTagType) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTSmartTagType, SMARTTAGTYPE$186);
    } 
  }
  
  public void setSmartTagTypeArray(int paramInt, CTSmartTagType paramCTSmartTagType) {
    synchronized (monitor()) {
      check_orphaned();
      CTSmartTagType cTSmartTagType = null;
      cTSmartTagType = (CTSmartTagType)get_store().find_element_user(SMARTTAGTYPE$186, paramInt);
      if (cTSmartTagType == null)
        throw new IndexOutOfBoundsException(); 
      cTSmartTagType.set((XmlObject)paramCTSmartTagType);
    } 
  }
  
  public CTSmartTagType insertNewSmartTagType(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSmartTagType cTSmartTagType = null;
      cTSmartTagType = (CTSmartTagType)get_store().insert_element_user(SMARTTAGTYPE$186, paramInt);
      return cTSmartTagType;
    } 
  }
  
  public CTSmartTagType addNewSmartTagType() {
    synchronized (monitor()) {
      check_orphaned();
      CTSmartTagType cTSmartTagType = null;
      cTSmartTagType = (CTSmartTagType)get_store().add_element_user(SMARTTAGTYPE$186);
      return cTSmartTagType;
    } 
  }
  
  public void removeSmartTagType(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SMARTTAGTYPE$186, paramInt);
    } 
  }
  
  public CTSchemaLibrary getSchemaLibrary() {
    synchronized (monitor()) {
      check_orphaned();
      CTSchemaLibrary cTSchemaLibrary = null;
      cTSchemaLibrary = (CTSchemaLibrary)get_store().find_element_user(SCHEMALIBRARY$188, 0);
      if (cTSchemaLibrary == null)
        return null; 
      return cTSchemaLibrary;
    } 
  }
  
  public boolean isSetSchemaLibrary() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SCHEMALIBRARY$188) != 0);
    } 
  }
  
  public void setSchemaLibrary(CTSchemaLibrary paramCTSchemaLibrary) {
    synchronized (monitor()) {
      check_orphaned();
      CTSchemaLibrary cTSchemaLibrary = null;
      cTSchemaLibrary = (CTSchemaLibrary)get_store().find_element_user(SCHEMALIBRARY$188, 0);
      if (cTSchemaLibrary == null)
        cTSchemaLibrary = (CTSchemaLibrary)get_store().add_element_user(SCHEMALIBRARY$188); 
      cTSchemaLibrary.set((XmlObject)paramCTSchemaLibrary);
    } 
  }
  
  public CTSchemaLibrary addNewSchemaLibrary() {
    synchronized (monitor()) {
      check_orphaned();
      CTSchemaLibrary cTSchemaLibrary = null;
      cTSchemaLibrary = (CTSchemaLibrary)get_store().add_element_user(SCHEMALIBRARY$188);
      return cTSchemaLibrary;
    } 
  }
  
  public void unsetSchemaLibrary() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SCHEMALIBRARY$188, 0);
    } 
  }
  
  public CTShapeDefaults getShapeDefaults() {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeDefaults cTShapeDefaults = null;
      cTShapeDefaults = (CTShapeDefaults)get_store().find_element_user(SHAPEDEFAULTS$190, 0);
      if (cTShapeDefaults == null)
        return null; 
      return cTShapeDefaults;
    } 
  }
  
  public boolean isSetShapeDefaults() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SHAPEDEFAULTS$190) != 0);
    } 
  }
  
  public void setShapeDefaults(CTShapeDefaults paramCTShapeDefaults) {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeDefaults cTShapeDefaults = null;
      cTShapeDefaults = (CTShapeDefaults)get_store().find_element_user(SHAPEDEFAULTS$190, 0);
      if (cTShapeDefaults == null)
        cTShapeDefaults = (CTShapeDefaults)get_store().add_element_user(SHAPEDEFAULTS$190); 
      cTShapeDefaults.set((XmlObject)paramCTShapeDefaults);
    } 
  }
  
  public CTShapeDefaults addNewShapeDefaults() {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeDefaults cTShapeDefaults = null;
      cTShapeDefaults = (CTShapeDefaults)get_store().add_element_user(SHAPEDEFAULTS$190);
      return cTShapeDefaults;
    } 
  }
  
  public void unsetShapeDefaults() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SHAPEDEFAULTS$190, 0);
    } 
  }
  
  public CTOnOff getDoNotEmbedSmartTags() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(DONOTEMBEDSMARTTAGS$192, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetDoNotEmbedSmartTags() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DONOTEMBEDSMARTTAGS$192) != 0);
    } 
  }
  
  public void setDoNotEmbedSmartTags(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(DONOTEMBEDSMARTTAGS$192, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(DONOTEMBEDSMARTTAGS$192); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewDoNotEmbedSmartTags() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(DONOTEMBEDSMARTTAGS$192);
      return cTOnOff;
    } 
  }
  
  public void unsetDoNotEmbedSmartTags() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DONOTEMBEDSMARTTAGS$192, 0);
    } 
  }
  
  public CTString getDecimalSymbol() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(DECIMALSYMBOL$194, 0);
      if (cTString == null)
        return null; 
      return cTString;
    } 
  }
  
  public boolean isSetDecimalSymbol() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DECIMALSYMBOL$194) != 0);
    } 
  }
  
  public void setDecimalSymbol(CTString paramCTString) {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(DECIMALSYMBOL$194, 0);
      if (cTString == null)
        cTString = (CTString)get_store().add_element_user(DECIMALSYMBOL$194); 
      cTString.set((XmlObject)paramCTString);
    } 
  }
  
  public CTString addNewDecimalSymbol() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().add_element_user(DECIMALSYMBOL$194);
      return cTString;
    } 
  }
  
  public void unsetDecimalSymbol() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DECIMALSYMBOL$194, 0);
    } 
  }
  
  public CTString getListSeparator() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(LISTSEPARATOR$196, 0);
      if (cTString == null)
        return null; 
      return cTString;
    } 
  }
  
  public boolean isSetListSeparator() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LISTSEPARATOR$196) != 0);
    } 
  }
  
  public void setListSeparator(CTString paramCTString) {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(LISTSEPARATOR$196, 0);
      if (cTString == null)
        cTString = (CTString)get_store().add_element_user(LISTSEPARATOR$196); 
      cTString.set((XmlObject)paramCTString);
    } 
  }
  
  public CTString addNewListSeparator() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().add_element_user(LISTSEPARATOR$196);
      return cTString;
    } 
  }
  
  public void unsetListSeparator() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LISTSEPARATOR$196, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTSettingsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */