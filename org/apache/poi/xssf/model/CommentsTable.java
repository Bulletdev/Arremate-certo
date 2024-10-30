/*     */ package org.apache.poi.xssf.model;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.TreeMap;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.ss.util.CellAddress;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.xssf.usermodel.XSSFComment;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComment;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCommentList;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComments;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CommentsDocument;
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
/*     */ @Internal
/*     */ public class CommentsTable
/*     */   extends POIXMLDocumentPart
/*     */ {
/*     */   public static final String DEFAULT_AUTHOR = "";
/*     */   public static final int DEFAULT_AUTHOR_ID = 0;
/*     */   private CTComments comments;
/*     */   private Map<CellAddress, CTComment> commentRefs;
/*     */   
/*     */   public CommentsTable() {
/*  58 */     this.comments = CTComments.Factory.newInstance();
/*  59 */     this.comments.addNewCommentList();
/*  60 */     this.comments.addNewAuthors().addAuthor("");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CommentsTable(PackagePart paramPackagePart) throws IOException {
/*  67 */     super(paramPackagePart);
/*  68 */     readFrom(paramPackagePart.getInputStream());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public CommentsTable(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) throws IOException {
/*  76 */     this(paramPackagePart);
/*     */   }
/*     */   
/*     */   public void readFrom(InputStream paramInputStream) throws IOException {
/*     */     try {
/*  81 */       CommentsDocument commentsDocument = CommentsDocument.Factory.parse(paramInputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*  82 */       this.comments = commentsDocument.getComments();
/*  83 */     } catch (XmlException xmlException) {
/*  84 */       throw new IOException(xmlException.getLocalizedMessage());
/*     */     } 
/*     */   }
/*     */   public void writeTo(OutputStream paramOutputStream) throws IOException {
/*  88 */     CommentsDocument commentsDocument = CommentsDocument.Factory.newInstance();
/*  89 */     commentsDocument.setComments(this.comments);
/*  90 */     commentsDocument.save(paramOutputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void commit() throws IOException {
/*  95 */     PackagePart packagePart = getPackagePart();
/*  96 */     OutputStream outputStream = packagePart.getOutputStream();
/*  97 */     writeTo(outputStream);
/*  98 */     outputStream.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void referenceUpdated(String paramString, CTComment paramCTComment) {
/* 107 */     referenceUpdated(new CellAddress(paramString), paramCTComment);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void referenceUpdated(CellAddress paramCellAddress, CTComment paramCTComment) {
/* 117 */     if (this.commentRefs != null) {
/* 118 */       this.commentRefs.remove(paramCellAddress);
/* 119 */       this.commentRefs.put(new CellAddress(paramCTComment.getRef()), paramCTComment);
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getNumberOfComments() {
/* 124 */     return this.comments.getCommentList().sizeOfCommentArray();
/*     */   }
/*     */   
/*     */   public int getNumberOfAuthors() {
/* 128 */     return this.comments.getAuthors().sizeOfAuthorArray();
/*     */   }
/*     */   
/*     */   public String getAuthor(long paramLong) {
/* 132 */     return this.comments.getAuthors().getAuthorArray((int)paramLong);
/*     */   }
/*     */   
/*     */   public int findAuthor(String paramString) {
/* 136 */     String[] arrayOfString = this.comments.getAuthors().getAuthorArray();
/* 137 */     for (byte b = 0; b < arrayOfString.length; b++) {
/* 138 */       if (arrayOfString[b].equals(paramString)) {
/* 139 */         return b;
/*     */       }
/*     */     } 
/* 142 */     return addNewAuthor(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFComment findCellComment(String paramString) {
/* 153 */     return findCellComment(new CellAddress(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFComment findCellComment(CellAddress paramCellAddress) {
/* 163 */     CTComment cTComment = getCTComment(paramCellAddress);
/* 164 */     return (cTComment == null) ? null : new XSSFComment(this, cTComment, null);
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
/*     */   @Internal
/*     */   public CTComment getCTComment(String paramString) {
/* 177 */     return getCTComment(new CellAddress(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public CTComment getCTComment(CellAddress paramCellAddress) {
/* 189 */     prepareCTCommentCache();
/*     */ 
/*     */     
/* 192 */     return this.commentRefs.get(paramCellAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<CellAddress, XSSFComment> getCellComments() {
/* 201 */     prepareCTCommentCache();
/* 202 */     TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>();
/*     */     
/* 204 */     for (Map.Entry<CellAddress, CTComment> entry : this.commentRefs.entrySet()) {
/* 205 */       treeMap.put(entry.getKey(), new XSSFComment(this, (CTComment)entry.getValue(), null));
/*     */     }
/*     */     
/* 208 */     return (Map)treeMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void prepareCTCommentCache() {
/* 218 */     if (this.commentRefs == null) {
/* 219 */       this.commentRefs = new HashMap<CellAddress, CTComment>();
/* 220 */       for (CTComment cTComment : this.comments.getCommentList().getCommentArray()) {
/* 221 */         this.commentRefs.put(new CellAddress(cTComment.getRef()), cTComment);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public CTComment newComment(String paramString) {
/* 235 */     return newComment(new CellAddress(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public CTComment newComment(CellAddress paramCellAddress) {
/* 246 */     CTComment cTComment = this.comments.getCommentList().addNewComment();
/* 247 */     cTComment.setRef(paramCellAddress.formatAsString());
/* 248 */     cTComment.setAuthorId(0L);
/*     */     
/* 250 */     if (this.commentRefs != null) {
/* 251 */       this.commentRefs.put(paramCellAddress, cTComment);
/*     */     }
/* 253 */     return cTComment;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeComment(String paramString) {
/* 264 */     return removeComment(new CellAddress(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeComment(CellAddress paramCellAddress) {
/* 274 */     String str = paramCellAddress.formatAsString();
/* 275 */     CTCommentList cTCommentList = this.comments.getCommentList();
/* 276 */     if (cTCommentList != null) {
/* 277 */       CTComment[] arrayOfCTComment = cTCommentList.getCommentArray();
/* 278 */       for (byte b = 0; b < arrayOfCTComment.length; b++) {
/* 279 */         CTComment cTComment = arrayOfCTComment[b];
/* 280 */         if (str.equals(cTComment.getRef())) {
/* 281 */           cTCommentList.removeComment(b);
/*     */           
/* 283 */           if (this.commentRefs != null) {
/* 284 */             this.commentRefs.remove(paramCellAddress);
/*     */           }
/* 286 */           return true;
/*     */         } 
/*     */       } 
/*     */     } 
/* 290 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int addNewAuthor(String paramString) {
/* 301 */     int i = this.comments.getAuthors().sizeOfAuthorArray();
/* 302 */     this.comments.getAuthors().insertAuthor(i, paramString);
/* 303 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public CTComments getCTComments() {
/* 313 */     return this.comments;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xssf\model\CommentsTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */