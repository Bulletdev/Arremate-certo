/*    */ package org.jsoup;
/*    */ 
/*    */ import java.io.IOException;
/*    */ 
/*    */ 
/*    */ public class UnsupportedMimeTypeException
/*    */   extends IOException
/*    */ {
/*    */   private String mimeType;
/*    */   private String url;
/*    */   
/*    */   public UnsupportedMimeTypeException(String paramString1, String paramString2, String paramString3) {
/* 13 */     super(paramString1);
/* 14 */     this.mimeType = paramString2;
/* 15 */     this.url = paramString3;
/*    */   }
/*    */   
/*    */   public String getMimeType() {
/* 19 */     return this.mimeType;
/*    */   }
/*    */   
/*    */   public String getUrl() {
/* 23 */     return this.url;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 28 */     return super.toString() + ". Mimetype=" + this.mimeType + ", URL=" + this.url;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\UnsupportedMimeTypeException.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */