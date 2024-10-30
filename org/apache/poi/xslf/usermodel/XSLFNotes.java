/*     */ package org.apache.poi.xslf.usermodel;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.sl.usermodel.MasterSheet;
/*     */ import org.apache.poi.sl.usermodel.Notes;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTNotesSlide;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.NotesDocument;
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
/*     */ public final class XSLFNotes
/*     */   extends XSLFSheet
/*     */   implements Notes<XSLFShape, XSLFTextParagraph>
/*     */ {
/*     */   private CTNotesSlide _notes;
/*     */   
/*     */   XSLFNotes() {
/*  45 */     this._notes = prototype();
/*  46 */     setCommonSlideData(this._notes.getCSld());
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
/*     */ 
/*     */   
/*     */   XSLFNotes(PackagePart paramPackagePart) throws IOException, XmlException {
/*  60 */     super(paramPackagePart);
/*     */     
/*  62 */     NotesDocument notesDocument = NotesDocument.Factory.parse(getPackagePart().getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*     */     
/*  64 */     this._notes = notesDocument.getNotes();
/*  65 */     setCommonSlideData(this._notes.getCSld());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   XSLFNotes(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) throws IOException, XmlException {
/*  73 */     this(paramPackagePart);
/*     */   }
/*     */   
/*     */   private static CTNotesSlide prototype() {
/*  77 */     CTNotesSlide cTNotesSlide = CTNotesSlide.Factory.newInstance();
/*  78 */     CTCommonSlideData cTCommonSlideData = cTNotesSlide.addNewCSld();
/*  79 */     cTCommonSlideData.addNewSpTree();
/*     */     
/*  81 */     return cTNotesSlide;
/*     */   }
/*     */ 
/*     */   
/*     */   public CTNotesSlide getXmlObject() {
/*  86 */     return this._notes;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String getRootElementName() {
/*  91 */     return "notes";
/*     */   }
/*     */ 
/*     */   
/*     */   public XSLFTheme getTheme() {
/*  96 */     return getMasterSheet().getTheme();
/*     */   }
/*     */ 
/*     */   
/*     */   public XSLFNotesMaster getMasterSheet() {
/* 101 */     for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
/* 102 */       if (pOIXMLDocumentPart instanceof XSLFNotesMaster) {
/* 103 */         return (XSLFNotesMaster)pOIXMLDocumentPart;
/*     */       }
/*     */     } 
/* 106 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<List<XSLFTextParagraph>> getTextParagraphs() {
/* 111 */     ArrayList<List<XSLFTextParagraph>> arrayList = new ArrayList();
/* 112 */     for (XSLFShape xSLFShape : getShapes()) {
/* 113 */       if (xSLFShape instanceof XSLFTextShape) {
/* 114 */         XSLFTextShape xSLFTextShape = (XSLFTextShape)xSLFShape;
/* 115 */         arrayList.add(xSLFTextShape.getTextParagraphs());
/*     */       } 
/*     */     } 
/* 118 */     return arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFNotes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */