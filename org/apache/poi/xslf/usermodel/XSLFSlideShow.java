/*     */ package org.apache.poi.xslf.usermodel;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import org.apache.poi.POIXMLDocument;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/*     */ import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
/*     */ import org.apache.poi.openxml4j.opc.OPCPackage;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
/*     */ import org.apache.poi.openxml4j.opc.TargetMode;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTCommentList;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTNotesSlide;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTSlide;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdList;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdListEntry;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdList;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdListEntry;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CmLstDocument;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.NotesDocument;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.PresentationDocument;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.SldDocument;
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
/*     */ public class XSLFSlideShow
/*     */   extends POIXMLDocument
/*     */ {
/*     */   private PresentationDocument presentationDoc;
/*     */   private List<PackagePart> embedds;
/*     */   
/*     */   public XSLFSlideShow(OPCPackage paramOPCPackage) throws OpenXML4JException, IOException, XmlException {
/*  71 */     super(paramOPCPackage);
/*     */     
/*  73 */     if (getCorePart().getContentType().equals(XSLFRelation.THEME_MANAGER.getContentType())) {
/*  74 */       rebase(getPackage());
/*     */     }
/*     */     
/*  77 */     this.presentationDoc = PresentationDocument.Factory.parse(getCorePart().getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*     */ 
/*     */     
/*  80 */     this.embedds = new LinkedList<PackagePart>();
/*  81 */     for (CTSlideIdListEntry cTSlideIdListEntry : getSlideReferences().getSldIdArray()) {
/*  82 */       PackagePart packagePart1 = getCorePart();
/*  83 */       PackagePart packagePart2 = packagePart1.getRelatedPart(packagePart1.getRelationship(cTSlideIdListEntry.getId2()));
/*     */       
/*  85 */       for (PackageRelationship packageRelationship : packagePart2.getRelationshipsByType("http://schemas.openxmlformats.org/officeDocument/2006/relationships/oleObject")) {
/*  86 */         if (TargetMode.EXTERNAL == packageRelationship.getTargetMode()) {
/*     */           continue;
/*     */         }
/*     */         
/*  90 */         this.embedds.add(packagePart2.getRelatedPart(packageRelationship));
/*     */       } 
/*     */       
/*  93 */       for (PackageRelationship packageRelationship : packagePart2.getRelationshipsByType("http://schemas.openxmlformats.org/officeDocument/2006/relationships/package"))
/*  94 */         this.embedds.add(packagePart2.getRelatedPart(packageRelationship)); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public XSLFSlideShow(String paramString) throws OpenXML4JException, IOException, XmlException {
/*  99 */     this(openPackage(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public CTPresentation getPresentation() {
/* 107 */     return this.presentationDoc.getPresentation();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public CTSlideIdList getSlideReferences() {
/* 118 */     if (!getPresentation().isSetSldIdLst()) {
/* 119 */       getPresentation().setSldIdLst(CTSlideIdList.Factory.newInstance());
/*     */     }
/* 121 */     return getPresentation().getSldIdLst();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public CTSlideMasterIdList getSlideMasterReferences() {
/* 132 */     return getPresentation().getSldMasterIdLst();
/*     */   }
/*     */   
/*     */   public PackagePart getSlideMasterPart(CTSlideMasterIdListEntry paramCTSlideMasterIdListEntry) throws IOException, XmlException {
/*     */     try {
/* 137 */       PackagePart packagePart = getCorePart();
/* 138 */       return packagePart.getRelatedPart(packagePart.getRelationship(paramCTSlideMasterIdListEntry.getId2()));
/*     */     
/*     */     }
/* 141 */     catch (InvalidFormatException invalidFormatException) {
/* 142 */       throw new XmlException(invalidFormatException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public CTSlideMaster getSlideMaster(CTSlideMasterIdListEntry paramCTSlideMasterIdListEntry) throws IOException, XmlException {
/* 151 */     PackagePart packagePart = getSlideMasterPart(paramCTSlideMasterIdListEntry);
/* 152 */     SldMasterDocument sldMasterDocument = SldMasterDocument.Factory.parse(packagePart.getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*     */     
/* 154 */     return sldMasterDocument.getSldMaster();
/*     */   }
/*     */   
/*     */   public PackagePart getSlidePart(CTSlideIdListEntry paramCTSlideIdListEntry) throws IOException, XmlException {
/*     */     try {
/* 159 */       PackagePart packagePart = getCorePart();
/* 160 */       return packagePart.getRelatedPart(packagePart.getRelationship(paramCTSlideIdListEntry.getId2()));
/* 161 */     } catch (InvalidFormatException invalidFormatException) {
/* 162 */       throw new XmlException(invalidFormatException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public CTSlide getSlide(CTSlideIdListEntry paramCTSlideIdListEntry) throws IOException, XmlException {
/* 171 */     PackagePart packagePart = getSlidePart(paramCTSlideIdListEntry);
/* 172 */     SldDocument sldDocument = SldDocument.Factory.parse(packagePart.getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*     */     
/* 174 */     return sldDocument.getSld();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PackagePart getNodesPart(CTSlideIdListEntry paramCTSlideIdListEntry) throws IOException, XmlException {
/*     */     PackageRelationshipCollection packageRelationshipCollection;
/* 183 */     PackagePart packagePart = getSlidePart(paramCTSlideIdListEntry);
/*     */     
/*     */     try {
/* 186 */       packageRelationshipCollection = packagePart.getRelationshipsByType(XSLFRelation.NOTES.getRelation());
/* 187 */     } catch (InvalidFormatException invalidFormatException) {
/* 188 */       throw new IllegalStateException(invalidFormatException);
/*     */     } 
/*     */     
/* 191 */     if (packageRelationshipCollection.size() == 0)
/*     */     {
/* 193 */       return null;
/*     */     }
/* 195 */     if (packageRelationshipCollection.size() > 1) {
/* 196 */       throw new IllegalStateException("Expecting 0 or 1 notes for a slide, but found " + packageRelationshipCollection.size());
/*     */     }
/*     */     
/*     */     try {
/* 200 */       return packagePart.getRelatedPart(packageRelationshipCollection.getRelationship(0));
/* 201 */     } catch (InvalidFormatException invalidFormatException) {
/* 202 */       throw new IllegalStateException(invalidFormatException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public CTNotesSlide getNotes(CTSlideIdListEntry paramCTSlideIdListEntry) throws IOException, XmlException {
/* 211 */     PackagePart packagePart = getNodesPart(paramCTSlideIdListEntry);
/* 212 */     if (packagePart == null) {
/* 213 */       return null;
/*     */     }
/* 215 */     NotesDocument notesDocument = NotesDocument.Factory.parse(packagePart.getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*     */ 
/*     */     
/* 218 */     return notesDocument.getNotes();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public CTCommentList getSlideComments(CTSlideIdListEntry paramCTSlideIdListEntry) throws IOException, XmlException {
/*     */     PackageRelationshipCollection packageRelationshipCollection;
/* 227 */     PackagePart packagePart = getSlidePart(paramCTSlideIdListEntry);
/*     */     
/*     */     try {
/* 230 */       packageRelationshipCollection = packagePart.getRelationshipsByType(XSLFRelation.COMMENTS.getRelation());
/* 231 */     } catch (InvalidFormatException invalidFormatException) {
/* 232 */       throw new IllegalStateException(invalidFormatException);
/*     */     } 
/*     */     
/* 235 */     if (packageRelationshipCollection.size() == 0)
/*     */     {
/* 237 */       return null;
/*     */     }
/* 239 */     if (packageRelationshipCollection.size() > 1) {
/* 240 */       throw new IllegalStateException("Expecting 0 or 1 comments for a slide, but found " + packageRelationshipCollection.size());
/*     */     }
/*     */     
/*     */     try {
/* 244 */       PackagePart packagePart1 = packagePart.getRelatedPart(packageRelationshipCollection.getRelationship(0));
/*     */ 
/*     */       
/* 247 */       CmLstDocument cmLstDocument = CmLstDocument.Factory.parse(packagePart1.getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*     */       
/* 249 */       return cmLstDocument.getCmLst();
/* 250 */     } catch (InvalidFormatException invalidFormatException) {
/* 251 */       throw new IllegalStateException(invalidFormatException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<PackagePart> getAllEmbedds() throws OpenXML4JException {
/* 260 */     return this.embedds;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFSlideShow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */