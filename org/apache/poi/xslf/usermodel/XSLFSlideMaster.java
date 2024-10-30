/*     */ package org.apache.poi.xslf.usermodel;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.sl.usermodel.Background;
/*     */ import org.apache.poi.sl.usermodel.MasterSheet;
/*     */ import org.apache.poi.sl.usermodel.Placeholder;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTBackground;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterTextStyles;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.SldMasterDocument;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XSLFSlideMaster
/*     */   extends XSLFSheet
/*     */   implements MasterSheet<XSLFShape, XSLFTextParagraph>
/*     */ {
/*     */   private CTSlideMaster _slide;
/*     */   private Map<String, XSLFSlideLayout> _layouts;
/*     */   private XSLFTheme _theme;
/*     */   
/*     */   XSLFSlideMaster() {
/*  69 */     this._slide = CTSlideMaster.Factory.newInstance();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected XSLFSlideMaster(PackagePart paramPackagePart) throws IOException, XmlException {
/*  76 */     super(paramPackagePart);
/*  77 */     SldMasterDocument sldMasterDocument = SldMasterDocument.Factory.parse(getPackagePart().getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*     */     
/*  79 */     this._slide = sldMasterDocument.getSldMaster();
/*  80 */     setCommonSlideData(this._slide.getCSld());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected XSLFSlideMaster(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) throws IOException, XmlException {
/*  88 */     this(paramPackagePart);
/*     */   }
/*     */ 
/*     */   
/*     */   public CTSlideMaster getXmlObject() {
/*  93 */     return this._slide;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String getRootElementName() {
/*  98 */     return "sldMaster";
/*     */   }
/*     */ 
/*     */   
/*     */   public XSLFSlideMaster getMasterSheet() {
/* 103 */     return null;
/*     */   }
/*     */   
/*     */   private Map<String, XSLFSlideLayout> getLayouts() {
/* 107 */     if (this._layouts == null) {
/* 108 */       this._layouts = new HashMap<String, XSLFSlideLayout>();
/* 109 */       for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
/* 110 */         if (pOIXMLDocumentPart instanceof XSLFSlideLayout) {
/* 111 */           XSLFSlideLayout xSLFSlideLayout = (XSLFSlideLayout)pOIXMLDocumentPart;
/* 112 */           this._layouts.put(xSLFSlideLayout.getName().toLowerCase(Locale.ROOT), xSLFSlideLayout);
/*     */         } 
/*     */       } 
/*     */     } 
/* 116 */     return this._layouts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSLFSlideLayout[] getSlideLayouts() {
/* 124 */     return (XSLFSlideLayout[])getLayouts().values().toArray((Object[])new XSLFSlideLayout[this._layouts.size()]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSLFSlideLayout getLayout(SlideLayout paramSlideLayout) {
/* 135 */     for (XSLFSlideLayout xSLFSlideLayout : getLayouts().values()) {
/* 136 */       if (xSLFSlideLayout.getType() == paramSlideLayout) {
/* 137 */         return xSLFSlideLayout;
/*     */       }
/*     */     } 
/* 140 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSLFSlideLayout getLayout(String paramString) {
/* 151 */     return getLayouts().get(paramString.toLowerCase(Locale.ROOT));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public XSLFTheme getTheme() {
/* 157 */     if (this._theme == null) {
/* 158 */       for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
/* 159 */         if (pOIXMLDocumentPart instanceof XSLFTheme) {
/* 160 */           this._theme = (XSLFTheme)pOIXMLDocumentPart;
/* 161 */           CTColorMapping cTColorMapping = this._slide.getClrMap();
/* 162 */           if (cTColorMapping != null) {
/* 163 */             this._theme.initColorMap(cTColorMapping);
/*     */           }
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     }
/* 169 */     return this._theme;
/*     */   }
/*     */ 
/*     */   
/*     */   protected CTTextListStyle getTextProperties(Placeholder paramPlaceholder) {
/* 174 */     CTSlideMasterTextStyles cTSlideMasterTextStyles = getXmlObject().getTxStyles();
/* 175 */     switch (paramPlaceholder)
/*     */     { case TITLE:
/*     */       case CENTERED_TITLE:
/*     */       case SUBTITLE:
/* 179 */         cTTextListStyle = cTSlideMasterTextStyles.getTitleStyle();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 188 */         return cTTextListStyle;case BODY: cTTextListStyle = cTSlideMasterTextStyles.getBodyStyle(); return cTTextListStyle; }  CTTextListStyle cTTextListStyle = cTSlideMasterTextStyles.getOtherStyle(); return cTTextListStyle;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canDraw(XSLFShape paramXSLFShape) {
/* 197 */     if (paramXSLFShape instanceof XSLFSimpleShape) {
/* 198 */       XSLFSimpleShape xSLFSimpleShape = (XSLFSimpleShape)paramXSLFShape;
/* 199 */       CTPlaceholder cTPlaceholder = xSLFSimpleShape.getCTPlaceholder();
/* 200 */       if (cTPlaceholder != null) {
/* 201 */         return false;
/*     */       }
/*     */     } 
/* 204 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public XSLFBackground getBackground() {
/* 209 */     CTBackground cTBackground = this._slide.getCSld().getBg();
/* 210 */     if (cTBackground != null) {
/* 211 */       return new XSLFBackground(cTBackground, this);
/*     */     }
/* 213 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFSlideMaster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */