/*     */ package org.apache.poi.xslf.usermodel;
/*     */ 
/*     */ import java.awt.Graphics2D;
/*     */ import java.io.IOException;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.sl.draw.DrawFactory;
/*     */ import org.apache.poi.sl.draw.DrawSlide;
/*     */ import org.apache.poi.sl.usermodel.Background;
/*     */ import org.apache.poi.sl.usermodel.MasterSheet;
/*     */ import org.apache.poi.sl.usermodel.Notes;
/*     */ import org.apache.poi.sl.usermodel.Placeholder;
/*     */ import org.apache.poi.sl.usermodel.Slide;
/*     */ import org.apache.poi.util.DocumentHelper;
/*     */ import org.apache.poi.util.NotImplemented;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTBlip;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTBackground;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShapeNonVisual;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTSlide;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.SldDocument;
/*     */ import org.w3c.dom.Document;
/*     */ import org.xml.sax.SAXException;
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
/*     */ public final class XSLFSlide
/*     */   extends XSLFSheet
/*     */   implements Slide<XSLFShape, XSLFTextParagraph>
/*     */ {
/*     */   private final CTSlide _slide;
/*     */   private XSLFSlideLayout _layout;
/*     */   private XSLFComments _comments;
/*     */   private XSLFNotes _notes;
/*     */   
/*     */   XSLFSlide() {
/*  64 */     this._slide = prototype();
/*  65 */     setCommonSlideData(this._slide.getCSld());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XSLFSlide(PackagePart paramPackagePart) throws IOException, XmlException {
/*  77 */     super(paramPackagePart);
/*     */     
/*     */     Document document;
/*     */     try {
/*  81 */       document = DocumentHelper.readDocument(getPackagePart().getInputStream());
/*  82 */     } catch (SAXException sAXException) {
/*  83 */       throw new IOException(sAXException);
/*     */     } 
/*     */     
/*  86 */     SldDocument sldDocument = SldDocument.Factory.parse(document, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*  87 */     this._slide = sldDocument.getSld();
/*  88 */     setCommonSlideData(this._slide.getCSld());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   XSLFSlide(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) throws IOException, XmlException {
/*  96 */     this(paramPackagePart);
/*     */   }
/*     */ 
/*     */   
/*     */   private static CTSlide prototype() {
/* 101 */     CTSlide cTSlide = CTSlide.Factory.newInstance();
/* 102 */     CTCommonSlideData cTCommonSlideData = cTSlide.addNewCSld();
/* 103 */     CTGroupShape cTGroupShape = cTCommonSlideData.addNewSpTree();
/*     */     
/* 105 */     CTGroupShapeNonVisual cTGroupShapeNonVisual = cTGroupShape.addNewNvGrpSpPr();
/* 106 */     CTNonVisualDrawingProps cTNonVisualDrawingProps = cTGroupShapeNonVisual.addNewCNvPr();
/* 107 */     cTNonVisualDrawingProps.setId(1L);
/* 108 */     cTNonVisualDrawingProps.setName("");
/* 109 */     cTGroupShapeNonVisual.addNewCNvGrpSpPr();
/* 110 */     cTGroupShapeNonVisual.addNewNvPr();
/*     */     
/* 112 */     CTGroupShapeProperties cTGroupShapeProperties = cTGroupShape.addNewGrpSpPr();
/* 113 */     CTGroupTransform2D cTGroupTransform2D = cTGroupShapeProperties.addNewXfrm();
/* 114 */     CTPoint2D cTPoint2D1 = cTGroupTransform2D.addNewOff();
/* 115 */     cTPoint2D1.setX(0L);
/* 116 */     cTPoint2D1.setY(0L);
/* 117 */     CTPositiveSize2D cTPositiveSize2D1 = cTGroupTransform2D.addNewExt();
/* 118 */     cTPositiveSize2D1.setCx(0L);
/* 119 */     cTPositiveSize2D1.setCy(0L);
/* 120 */     CTPoint2D cTPoint2D2 = cTGroupTransform2D.addNewChOff();
/* 121 */     cTPoint2D2.setX(0L);
/* 122 */     cTPoint2D2.setY(0L);
/* 123 */     CTPositiveSize2D cTPositiveSize2D2 = cTGroupTransform2D.addNewChExt();
/* 124 */     cTPositiveSize2D2.setCx(0L);
/* 125 */     cTPositiveSize2D2.setCy(0L);
/* 126 */     cTSlide.addNewClrMapOvr().addNewMasterClrMapping();
/* 127 */     return cTSlide;
/*     */   }
/*     */ 
/*     */   
/*     */   public CTSlide getXmlObject() {
/* 132 */     return this._slide;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String getRootElementName() {
/* 137 */     return "sld";
/*     */   }
/*     */   
/*     */   public XSLFSlideLayout getMasterSheet() {
/* 141 */     return getSlideLayout();
/*     */   }
/*     */   
/*     */   public XSLFSlideLayout getSlideLayout() {
/* 145 */     if (this._layout == null) {
/* 146 */       for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
/* 147 */         if (pOIXMLDocumentPart instanceof XSLFSlideLayout) {
/* 148 */           this._layout = (XSLFSlideLayout)pOIXMLDocumentPart;
/*     */         }
/*     */       } 
/*     */     }
/* 152 */     if (this._layout == null) {
/* 153 */       throw new IllegalArgumentException("SlideLayout was not found for " + toString());
/*     */     }
/* 155 */     return this._layout;
/*     */   }
/*     */   
/*     */   public XSLFSlideMaster getSlideMaster() {
/* 159 */     return getSlideLayout().getSlideMaster();
/*     */   }
/*     */   
/*     */   public XSLFComments getComments() {
/* 163 */     if (this._comments == null) {
/* 164 */       for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
/* 165 */         if (pOIXMLDocumentPart instanceof XSLFComments) {
/* 166 */           this._comments = (XSLFComments)pOIXMLDocumentPart;
/*     */         }
/*     */       } 
/*     */     }
/* 170 */     if (this._comments == null)
/*     */     {
/*     */       
/* 173 */       return null;
/*     */     }
/* 175 */     return this._comments;
/*     */   }
/*     */   
/*     */   public XSLFNotes getNotes() {
/* 179 */     if (this._notes == null) {
/* 180 */       for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
/* 181 */         if (pOIXMLDocumentPart instanceof XSLFNotes) {
/* 182 */           this._notes = (XSLFNotes)pOIXMLDocumentPart;
/*     */         }
/*     */       } 
/*     */     }
/* 186 */     if (this._notes == null)
/*     */     {
/*     */       
/* 189 */       return null;
/*     */     }
/* 191 */     return this._notes;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTitle() {
/* 196 */     XSLFTextShape xSLFTextShape = getTextShapeByType(Placeholder.TITLE);
/* 197 */     return (xSLFTextShape == null) ? null : xSLFTextShape.getText();
/*     */   }
/*     */ 
/*     */   
/*     */   public XSLFTheme getTheme() {
/* 202 */     return getSlideLayout().getSlideMaster().getTheme();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSLFBackground getBackground() {
/* 211 */     CTBackground cTBackground = this._slide.getCSld().getBg();
/* 212 */     if (cTBackground != null) {
/* 213 */       return new XSLFBackground(cTBackground, this);
/*     */     }
/* 215 */     return getMasterSheet().getBackground();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getFollowMasterGraphics() {
/* 221 */     return (this._slide.isSetShowMasterSp() && this._slide.getShowMasterSp());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFollowMasterGraphics(boolean paramBoolean) {
/* 229 */     this._slide.setShowMasterSp(paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getFollowMasterObjects() {
/* 234 */     return getFollowMasterGraphics();
/*     */   }
/*     */   
/*     */   public void setFollowMasterObjects(boolean paramBoolean) {
/* 238 */     setFollowMasterGraphics(paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public XSLFSlide importContent(XSLFSheet paramXSLFSheet) {
/* 243 */     super.importContent(paramXSLFSheet);
/*     */     
/* 245 */     XSLFBackground xSLFBackground = getBackground();
/* 246 */     if (xSLFBackground != null) {
/* 247 */       CTBackground cTBackground = (CTBackground)xSLFBackground.getXmlObject();
/* 248 */       if (cTBackground.isSetBgPr() && cTBackground.getBgPr().isSetBlipFill()) {
/* 249 */         CTBlip cTBlip = cTBackground.getBgPr().getBlipFill().getBlip();
/* 250 */         String str1 = cTBlip.getEmbed();
/*     */         
/* 252 */         String str2 = importBlip(str1, paramXSLFSheet.getPackagePart());
/* 253 */         cTBlip.setEmbed(str2);
/*     */       } 
/*     */     } 
/* 256 */     return this;
/*     */   }
/*     */   
/*     */   public boolean getFollowMasterBackground() {
/* 260 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   @NotImplemented
/*     */   public void setFollowMasterBackground(boolean paramBoolean) {
/* 266 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public boolean getFollowMasterColourScheme() {
/* 270 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   @NotImplemented
/*     */   public void setFollowMasterColourScheme(boolean paramBoolean) {
/* 276 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   @NotImplemented
/*     */   public void setNotes(Notes<XSLFShape, XSLFTextParagraph> paramNotes) {
/* 282 */     assert paramNotes instanceof XSLFNotes;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSlideNumber() {
/* 288 */     int i = getSlideShow().getSlides().indexOf(this);
/* 289 */     return (i == -1) ? i : (i + 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void draw(Graphics2D paramGraphics2D) {
/* 299 */     DrawFactory drawFactory = DrawFactory.getInstance(paramGraphics2D);
/* 300 */     DrawSlide drawSlide = drawFactory.getDrawable(this);
/* 301 */     drawSlide.draw(paramGraphics2D);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFSlide.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */