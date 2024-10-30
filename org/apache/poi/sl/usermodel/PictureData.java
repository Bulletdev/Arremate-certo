/*    */ package org.apache.poi.sl.usermodel;
/*    */ 
/*    */ import java.awt.Dimension;
/*    */ import java.io.IOException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface PictureData
/*    */ {
/*    */   String getContentType();
/*    */   
/*    */   PictureType getType();
/*    */   
/*    */   byte[] getData();
/*    */   
/*    */   void setData(byte[] paramArrayOfbyte) throws IOException;
/*    */   
/*    */   byte[] getChecksum();
/*    */   
/*    */   Dimension getImageDimension();
/*    */   
/*    */   Dimension getImageDimensionInPixels();
/*    */   
/*    */   public enum PictureType
/*    */   {
/* 27 */     EMF(2, 2, "image/x-emf", ".emf"),
/*    */     
/* 29 */     WMF(3, 3, "image/x-wmf", ".wmf"),
/*    */     
/* 31 */     PICT(4, 4, "image/pict", ".pict"),
/*    */     
/* 33 */     JPEG(5, 5, "image/jpeg", ".jpg"),
/*    */     
/* 35 */     PNG(6, 6, "image/png", ".png"),
/*    */     
/* 37 */     DIB(7, 7, "image/dib", ".dib"),
/*    */     
/* 39 */     GIF(-1, 8, "image/gif", ".gif"),
/*    */     
/* 41 */     TIFF(-1, 9, "image/tiff", ".tif"),
/*    */     
/* 43 */     EPS(-1, 10, "image/x-eps", ".eps"),
/*    */     
/* 45 */     BMP(-1, 11, "image/x-ms-bmp", ".bmp"),
/*    */     
/* 47 */     WPG(-1, 12, "image/x-wpg", ".wpg"),
/*    */     
/* 49 */     WDP(-1, 13, "image/vnd.ms-photo", ".wdp");
/*    */     
/*    */     public final int nativeId;
/*    */     public final int ooxmlId;
/*    */     
/*    */     PictureType(int param1Int1, int param1Int2, String param1String1, String param1String2) {
/* 55 */       this.nativeId = param1Int1;
/* 56 */       this.ooxmlId = param1Int2;
/* 57 */       this.contentType = param1String1;
/* 58 */       this.extension = param1String2;
/*    */     }
/*    */     public final String contentType; public final String extension;
/*    */     public static PictureType forNativeID(int param1Int) {
/* 62 */       for (PictureType pictureType : values()) {
/* 63 */         if (pictureType.nativeId == param1Int) return pictureType; 
/*    */       } 
/* 65 */       return null;
/*    */     }
/*    */     
/*    */     public static PictureType forOoxmlID(int param1Int) {
/* 69 */       for (PictureType pictureType : values()) {
/* 70 */         if (pictureType.ooxmlId == param1Int) return pictureType; 
/*    */       } 
/* 72 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\PictureData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */