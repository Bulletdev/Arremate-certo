/*     */ package org.apache.poi.xslf.usermodel;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLException;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.sl.usermodel.MasterSheet;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.NotesMasterDocument;
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
/*     */ public class XSLFNotesMaster
/*     */   extends XSLFSheet
/*     */   implements MasterSheet<XSLFShape, XSLFTextParagraph>
/*     */ {
/*     */   private CTNotesMaster _slide;
/*     */   private XSLFTheme _theme;
/*     */   
/*     */   XSLFNotesMaster() {
/*  59 */     this._slide = prototype();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected XSLFNotesMaster(PackagePart paramPackagePart) throws IOException, XmlException {
/*  66 */     super(paramPackagePart);
/*  67 */     NotesMasterDocument notesMasterDocument = NotesMasterDocument.Factory.parse(getPackagePart().getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*     */     
/*  69 */     this._slide = notesMasterDocument.getNotesMaster();
/*  70 */     setCommonSlideData(this._slide.getCSld());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected XSLFNotesMaster(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) throws IOException, XmlException {
/*  78 */     this(paramPackagePart);
/*     */   }
/*     */   
/*     */   private static CTNotesMaster prototype() {
/*  82 */     InputStream inputStream = XSLFNotesMaster.class.getResourceAsStream("notesMaster.xml");
/*  83 */     if (inputStream == null) {
/*  84 */       throw new POIXMLException("Missing resource 'notesMaster.xml'");
/*     */     }
/*     */     
/*     */     try {
/*     */       try {
/*  89 */         NotesMasterDocument notesMasterDocument = NotesMasterDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*  90 */         CTNotesMaster cTNotesMaster = notesMasterDocument.getNotesMaster();
/*  91 */         return cTNotesMaster;
/*     */       } finally {
/*  93 */         inputStream.close();
/*     */       } 
/*  95 */     } catch (Exception exception) {
/*  96 */       throw new POIXMLException("Can't initialize NotesMaster", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public CTNotesMaster getXmlObject() {
/* 102 */     return this._slide;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String getRootElementName() {
/* 107 */     return "notesMaster";
/*     */   }
/*     */ 
/*     */   
/*     */   public MasterSheet<XSLFShape, XSLFTextParagraph> getMasterSheet() {
/* 112 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public XSLFTheme getTheme() {
/* 117 */     if (this._theme == null) {
/* 118 */       for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
/* 119 */         if (pOIXMLDocumentPart instanceof XSLFTheme) {
/* 120 */           this._theme = (XSLFTheme)pOIXMLDocumentPart;
/* 121 */           CTColorMapping cTColorMapping = this._slide.getClrMap();
/* 122 */           if (cTColorMapping != null) {
/* 123 */             this._theme.initColorMap(cTColorMapping);
/*     */           }
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     }
/* 129 */     return this._theme;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFNotesMaster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */