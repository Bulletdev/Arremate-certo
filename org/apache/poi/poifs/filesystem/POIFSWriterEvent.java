/*    */ package org.apache.poi.poifs.filesystem;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POIFSWriterEvent
/*    */ {
/*    */   private DocumentOutputStream stream;
/*    */   private POIFSDocumentPath path;
/*    */   private String documentName;
/*    */   private int limit;
/*    */   
/*    */   POIFSWriterEvent(DocumentOutputStream paramDocumentOutputStream, POIFSDocumentPath paramPOIFSDocumentPath, String paramString, int paramInt) {
/* 50 */     this.stream = paramDocumentOutputStream;
/* 51 */     this.path = paramPOIFSDocumentPath;
/* 52 */     this.documentName = paramString;
/* 53 */     this.limit = paramInt;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public DocumentOutputStream getStream() {
/* 62 */     return this.stream;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public POIFSDocumentPath getPath() {
/* 71 */     return this.path;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getName() {
/* 80 */     return this.documentName;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getLimit() {
/* 89 */     return this.limit;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\filesystem\POIFSWriterEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */