/*    */ package org.apache.poi.poifs.eventfilesystem;
/*    */ 
/*    */ import org.apache.poi.poifs.filesystem.DocumentInputStream;
/*    */ import org.apache.poi.poifs.filesystem.POIFSDocumentPath;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POIFSReaderEvent
/*    */ {
/*    */   private final DocumentInputStream stream;
/*    */   private final POIFSDocumentPath path;
/*    */   private final String documentName;
/*    */   
/*    */   POIFSReaderEvent(DocumentInputStream paramDocumentInputStream, POIFSDocumentPath paramPOIFSDocumentPath, String paramString) {
/* 49 */     this.stream = paramDocumentInputStream;
/* 50 */     this.path = paramPOIFSDocumentPath;
/* 51 */     this.documentName = paramString;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public DocumentInputStream getStream() {
/* 60 */     return this.stream;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public POIFSDocumentPath getPath() {
/* 69 */     return this.path;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getName() {
/* 78 */     return this.documentName;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\eventfilesystem\POIFSReaderEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */