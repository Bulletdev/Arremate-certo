/*     */ package org.apache.poi.hpsf;
/*     */ 
/*     */ import org.apache.poi.util.LittleEndian;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Thumbnail
/*     */ {
/*     */   public static final int OFFSET_CFTAG = 4;
/*     */   public static final int OFFSET_CF = 8;
/*     */   public static final int OFFSET_WMFDATA = 20;
/*     */   public static final int CFTAG_WINDOWS = -1;
/*     */   public static final int CFTAG_MACINTOSH = -2;
/*     */   public static final int CFTAG_FMTID = -3;
/*     */   public static final int CFTAG_NODATA = 0;
/*     */   public static final int CF_METAFILEPICT = 3;
/*     */   public static final int CF_DIB = 8;
/*     */   public static final int CF_ENHMETAFILE = 14;
/*     */   public static final int CF_BITMAP = 2;
/* 126 */   private byte[] _thumbnailData = null;
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
/*     */   public Thumbnail() {}
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
/*     */   public Thumbnail(byte[] paramArrayOfbyte) {
/* 152 */     this._thumbnailData = paramArrayOfbyte;
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
/*     */   public byte[] getThumbnail() {
/* 166 */     return this._thumbnailData;
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
/*     */   public void setThumbnail(byte[] paramArrayOfbyte) {
/* 180 */     this._thumbnailData = paramArrayOfbyte;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getClipboardFormatTag() {
/* 201 */     return LittleEndian.getInt(getThumbnail(), 4);
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
/*     */   public long getClipboardFormat() throws HPSFException {
/* 229 */     if (getClipboardFormatTag() != -1L) {
/* 230 */       throw new HPSFException("Clipboard Format Tag of Thumbnail must be CFTAG_WINDOWS.");
/*     */     }
/*     */     
/* 233 */     return LittleEndian.getInt(getThumbnail(), 8);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getThumbnailAsWMF() throws HPSFException {
/* 256 */     if (getClipboardFormatTag() != -1L) {
/* 257 */       throw new HPSFException("Clipboard Format Tag of Thumbnail must be CFTAG_WINDOWS.");
/*     */     }
/* 259 */     if (getClipboardFormat() != 3L) {
/* 260 */       throw new HPSFException("Clipboard Format of Thumbnail must be CF_METAFILEPICT.");
/*     */     }
/*     */     
/* 263 */     byte[] arrayOfByte1 = getThumbnail();
/* 264 */     int i = arrayOfByte1.length - 20;
/* 265 */     byte[] arrayOfByte2 = new byte[i];
/* 266 */     System.arraycopy(arrayOfByte1, 20, arrayOfByte2, 0, i);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 271 */     return arrayOfByte2;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\Thumbnail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */