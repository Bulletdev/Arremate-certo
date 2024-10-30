/*     */ package org.apache.poi.xslf.usermodel;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.sl.usermodel.Background;
/*     */ import org.apache.poi.sl.usermodel.MasterSheet;
/*     */ import org.apache.poi.sl.usermodel.Placeholder;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTBackground;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.SldLayoutDocument;
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
/*     */ public class XSLFSlideLayout
/*     */   extends XSLFSheet
/*     */   implements MasterSheet<XSLFShape, XSLFTextParagraph>
/*     */ {
/*     */   private CTSlideLayout _layout;
/*     */   private XSLFSlideMaster _master;
/*     */   
/*     */   XSLFSlideLayout() {
/*  44 */     this._layout = CTSlideLayout.Factory.newInstance();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSLFSlideLayout(PackagePart paramPackagePart) throws IOException, XmlException {
/*  51 */     super(paramPackagePart);
/*  52 */     SldLayoutDocument sldLayoutDocument = SldLayoutDocument.Factory.parse(getPackagePart().getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*     */     
/*  54 */     this._layout = sldLayoutDocument.getSldLayout();
/*  55 */     setCommonSlideData(this._layout.getCSld());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public XSLFSlideLayout(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) throws IOException, XmlException {
/*  63 */     this(paramPackagePart);
/*     */   }
/*     */   
/*     */   public String getName() {
/*  67 */     return this._layout.getCSld().getName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public CTSlideLayout getXmlObject() {
/*  75 */     return this._layout;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String getRootElementName() {
/*  80 */     return "sldLayout";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSLFSlideMaster getSlideMaster() {
/*  90 */     if (this._master == null) {
/*  91 */       for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
/*  92 */         if (pOIXMLDocumentPart instanceof XSLFSlideMaster) {
/*  93 */           this._master = (XSLFSlideMaster)pOIXMLDocumentPart;
/*     */         }
/*     */       } 
/*     */     }
/*  97 */     if (this._master == null) {
/*  98 */       throw new IllegalStateException("SlideMaster was not found for " + toString());
/*     */     }
/* 100 */     return this._master;
/*     */   }
/*     */ 
/*     */   
/*     */   public XSLFSlideMaster getMasterSheet() {
/* 105 */     return getSlideMaster();
/*     */   }
/*     */ 
/*     */   
/*     */   public XSLFTheme getTheme() {
/* 110 */     return getSlideMaster().getTheme();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getFollowMasterGraphics() {
/* 116 */     return (this._layout.isSetShowMasterSp() && this._layout.getShowMasterSp());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canDraw(XSLFShape paramXSLFShape) {
/* 124 */     if (paramXSLFShape instanceof XSLFSimpleShape) {
/* 125 */       XSLFSimpleShape xSLFSimpleShape = (XSLFSimpleShape)paramXSLFShape;
/* 126 */       CTPlaceholder cTPlaceholder = xSLFSimpleShape.getCTPlaceholder();
/* 127 */       if (cTPlaceholder != null) {
/* 128 */         return false;
/*     */       }
/*     */     } 
/* 131 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public XSLFBackground getBackground() {
/* 137 */     CTBackground cTBackground = this._layout.getCSld().getBg();
/* 138 */     if (cTBackground != null) {
/* 139 */       return new XSLFBackground(cTBackground, this);
/*     */     }
/* 141 */     return getMasterSheet().getBackground();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void copyLayout(XSLFSlide paramXSLFSlide) {
/* 151 */     for (XSLFShape xSLFShape : getShapes()) {
/* 152 */       if (xSLFShape instanceof XSLFTextShape) {
/* 153 */         XSLFTextShape xSLFTextShape = (XSLFTextShape)xSLFShape;
/* 154 */         Placeholder placeholder = xSLFTextShape.getTextType();
/* 155 */         if (placeholder == null)
/*     */           continue; 
/* 157 */         switch (placeholder) {
/*     */           case DATETIME:
/*     */           case SLIDE_NUMBER:
/*     */           case FOOTER:
/*     */             continue;
/*     */         } 
/*     */         
/* 164 */         paramXSLFSlide.getSpTree().addNewSp().set(xSLFTextShape.getXmlObject().copy());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SlideLayout getType() {
/* 175 */     int i = this._layout.getType().intValue() - 1;
/* 176 */     return SlideLayout.values()[i];
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFSlideLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */