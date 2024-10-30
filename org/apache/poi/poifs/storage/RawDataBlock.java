/*     */ package org.apache.poi.poifs.storage;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import org.apache.poi.util.IOUtils;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
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
/*     */ public class RawDataBlock
/*     */   implements ListManagedBlock
/*     */ {
/*     */   private byte[] _data;
/*     */   private boolean _eof;
/*     */   private boolean _hasData;
/*  41 */   static POILogger log = POILogFactory.getLogger(RawDataBlock.class);
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
/*     */   public RawDataBlock(InputStream paramInputStream) throws IOException {
/*  54 */     this(paramInputStream, 512);
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
/*     */   public RawDataBlock(InputStream paramInputStream, int paramInt) throws IOException {
/*  69 */     this._data = new byte[paramInt];
/*  70 */     int i = IOUtils.readFully(paramInputStream, this._data);
/*  71 */     this._hasData = (i > 0);
/*     */     
/*  73 */     if (i == -1) {
/*  74 */       this._eof = true;
/*     */     }
/*  76 */     else if (i != paramInt) {
/*     */ 
/*     */ 
/*     */       
/*  80 */       this._eof = true;
/*  81 */       String str = " byte" + ((i == 1) ? "" : "s");
/*     */ 
/*     */       
/*  84 */       log.log(7, new Object[] { "Unable to read entire block; " + i + str + " read before EOF; expected " + paramInt + " bytes. Your document " + "was either written by software that " + "ignores the spec, or has been truncated!" });
/*     */ 
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */ 
/*     */       
/*  93 */       this._eof = false;
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
/*     */   public boolean eof() {
/* 105 */     return this._eof;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasData() {
/* 113 */     return this._hasData;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 117 */     return "RawDataBlock of size " + this._data.length;
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
/*     */   public byte[] getData() throws IOException {
/* 132 */     if (!hasData())
/*     */     {
/* 134 */       throw new IOException("Cannot return empty data");
/*     */     }
/* 136 */     return this._data;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBigBlockSize() {
/* 143 */     return this._data.length;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\storage\RawDataBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */