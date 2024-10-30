/*     */ package org.apache.poi.poifs.storage;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.Arrays;
/*     */ import org.apache.poi.hssf.OldExcelFormatException;
/*     */ import org.apache.poi.poifs.common.POIFSBigBlockSize;
/*     */ import org.apache.poi.poifs.common.POIFSConstants;
/*     */ import org.apache.poi.poifs.filesystem.NotOLE2FileException;
/*     */ import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.IOUtils;
/*     */ import org.apache.poi.util.IntegerField;
/*     */ import org.apache.poi.util.LittleEndian;
/*     */ import org.apache.poi.util.LongField;
/*     */ import org.apache.poi.util.ShortField;
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
/*     */ public final class HeaderBlock
/*     */   implements HeaderBlockConstants
/*     */ {
/*  43 */   private static final byte[] MAGIC_BIFF2 = new byte[] { 9, 0, 4, 0, 0, 0, 112, 0 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  50 */   private static final byte[] MAGIC_BIFF3 = new byte[] { 9, 2, 6, 0, 0, 0, 112, 0 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  57 */   private static final byte[] MAGIC_BIFF4a = new byte[] { 9, 4, 6, 0, 0, 0, 112, 0 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  64 */   private static final byte[] MAGIC_BIFF4b = new byte[] { 9, 4, 6, 0, 0, 0, 0, 1 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final byte _default_value = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final POIFSBigBlockSize bigBlockSize;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int _bat_count;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int _property_start;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int _sbat_start;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int _sbat_count;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int _xbat_start;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int _xbat_count;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final byte[] _data;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HeaderBlock(InputStream paramInputStream) throws IOException {
/* 129 */     this(readFirst512(paramInputStream));
/*     */ 
/*     */     
/* 132 */     if (this.bigBlockSize.getBigBlockSize() != 512) {
/* 133 */       int i = this.bigBlockSize.getBigBlockSize() - 512;
/* 134 */       byte[] arrayOfByte = new byte[i];
/* 135 */       IOUtils.readFully(paramInputStream, arrayOfByte);
/*     */     } 
/*     */   }
/*     */   
/*     */   public HeaderBlock(ByteBuffer paramByteBuffer) throws IOException {
/* 140 */     this(IOUtils.toByteArray(paramByteBuffer, 512));
/*     */   }
/*     */   
/*     */   private HeaderBlock(byte[] paramArrayOfbyte) throws IOException {
/* 144 */     this._data = (byte[])paramArrayOfbyte.clone();
/*     */ 
/*     */     
/* 147 */     long l = LittleEndian.getLong(this._data, 0);
/*     */     
/* 149 */     if (l != -2226271756974174256L) {
/*     */       
/* 151 */       if (cmp(POIFSConstants.OOXML_FILE_HEADER, paramArrayOfbyte)) {
/* 152 */         throw new OfficeXmlFileException("The supplied data appears to be in the Office 2007+ XML. You are calling the part of POI that deals with OLE2 Office Documents. You need to call a different part of POI to process this data (eg XSSF instead of HSSF)");
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 157 */       if (cmp(POIFSConstants.RAW_XML_FILE_HEADER, paramArrayOfbyte)) {
/* 158 */         throw new NotOLE2FileException("The supplied data appears to be a raw XML file. Formats such as Office 2003 XML are not supported");
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 163 */       if (cmp(MAGIC_BIFF2, paramArrayOfbyte)) {
/* 164 */         throw new OldExcelFormatException("The supplied data appears to be in BIFF2 format. HSSF only supports the BIFF8 format, try OldExcelExtractor");
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 169 */       if (cmp(MAGIC_BIFF3, paramArrayOfbyte)) {
/* 170 */         throw new OldExcelFormatException("The supplied data appears to be in BIFF3 format. HSSF only supports the BIFF8 format, try OldExcelExtractor");
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 175 */       if (cmp(MAGIC_BIFF4a, paramArrayOfbyte) || cmp(MAGIC_BIFF4b, paramArrayOfbyte)) {
/* 176 */         throw new OldExcelFormatException("The supplied data appears to be in BIFF4 format. HSSF only supports the BIFF8 format, try OldExcelExtractor");
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 181 */       throw new NotOLE2FileException("Invalid header signature; read " + HexDump.longToHex(l) + ", expected " + HexDump.longToHex(-2226271756974174256L) + " - Your file appears " + "not to be a valid OLE2 document");
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 189 */     if (this._data[30] == 12) {
/* 190 */       this.bigBlockSize = POIFSConstants.LARGER_BIG_BLOCK_SIZE_DETAILS;
/* 191 */     } else if (this._data[30] == 9) {
/* 192 */       this.bigBlockSize = POIFSConstants.SMALLER_BIG_BLOCK_SIZE_DETAILS;
/*     */     } else {
/* 194 */       throw new IOException("Unsupported blocksize  (2^" + this._data[30] + "). Expected 2^9 or 2^12.");
/*     */     } 
/*     */ 
/*     */     
/* 198 */     this._bat_count = (new IntegerField(44, paramArrayOfbyte)).get();
/* 199 */     this._property_start = (new IntegerField(48, this._data)).get();
/* 200 */     this._sbat_start = (new IntegerField(60, this._data)).get();
/* 201 */     this._sbat_count = (new IntegerField(64, this._data)).get();
/* 202 */     this._xbat_start = (new IntegerField(68, this._data)).get();
/* 203 */     this._xbat_count = (new IntegerField(72, this._data)).get();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HeaderBlock(POIFSBigBlockSize paramPOIFSBigBlockSize) {
/* 211 */     this.bigBlockSize = paramPOIFSBigBlockSize;
/*     */ 
/*     */     
/* 214 */     this._data = new byte[512];
/* 215 */     Arrays.fill(this._data, (byte)-1);
/*     */ 
/*     */     
/* 218 */     new LongField(0, -2226271756974174256L, this._data);
/* 219 */     new IntegerField(8, 0, this._data);
/* 220 */     new IntegerField(12, 0, this._data);
/* 221 */     new IntegerField(16, 0, this._data);
/* 222 */     new IntegerField(20, 0, this._data);
/* 223 */     new ShortField(24, (short)59, this._data);
/* 224 */     new ShortField(26, (short)3, this._data);
/* 225 */     new ShortField(28, (short)-2, this._data);
/*     */     
/* 227 */     new ShortField(30, paramPOIFSBigBlockSize.getHeaderValue(), this._data);
/* 228 */     new IntegerField(32, 6, this._data);
/* 229 */     new IntegerField(36, 0, this._data);
/* 230 */     new IntegerField(40, 0, this._data);
/* 231 */     new IntegerField(52, 0, this._data);
/* 232 */     new IntegerField(56, 4096, this._data);
/*     */ 
/*     */     
/* 235 */     this._bat_count = 0;
/* 236 */     this._sbat_count = 0;
/* 237 */     this._xbat_count = 0;
/* 238 */     this._property_start = -2;
/* 239 */     this._sbat_start = -2;
/* 240 */     this._xbat_start = -2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static byte[] readFirst512(InputStream paramInputStream) throws IOException {
/* 246 */     byte[] arrayOfByte = new byte[512];
/* 247 */     int i = IOUtils.readFully(paramInputStream, arrayOfByte);
/* 248 */     if (i != 512) {
/* 249 */       throw alertShortRead(i, 512);
/*     */     }
/* 251 */     return arrayOfByte;
/*     */   }
/*     */   
/*     */   private static IOException alertShortRead(int paramInt1, int paramInt2) {
/*     */     int i;
/* 256 */     if (paramInt1 < 0) {
/*     */       
/* 258 */       i = 0;
/*     */     } else {
/* 260 */       i = paramInt1;
/*     */     } 
/* 262 */     String str = " byte" + ((i == 1) ? "" : "s");
/*     */     
/* 264 */     return new IOException("Unable to read entire header; " + i + str + " read; expected " + paramInt2 + " bytes");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPropertyStart() {
/* 275 */     return this._property_start;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPropertyStart(int paramInt) {
/* 283 */     this._property_start = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSBATStart() {
/* 290 */     return this._sbat_start;
/*     */   }
/*     */   public int getSBATCount() {
/* 293 */     return this._sbat_count;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSBATStart(int paramInt) {
/* 303 */     this._sbat_start = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSBATBlockCount(int paramInt) {
/* 312 */     this._sbat_count = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBATCount() {
/* 319 */     return this._bat_count;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBATCount(int paramInt) {
/* 326 */     this._bat_count = paramInt;
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
/*     */   public int[] getBATArray() {
/* 338 */     int[] arrayOfInt = new int[Math.min(this._bat_count, 109)];
/* 339 */     byte b1 = 76;
/* 340 */     for (byte b2 = 0; b2 < arrayOfInt.length; b2++) {
/* 341 */       arrayOfInt[b2] = LittleEndian.getInt(this._data, b1);
/* 342 */       b1 += 4;
/*     */     } 
/* 344 */     return arrayOfInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBATArray(int[] paramArrayOfint) {
/* 351 */     int i = Math.min(paramArrayOfint.length, 109);
/* 352 */     int j = 109 - i;
/*     */     
/* 354 */     byte b1 = 76; byte b2;
/* 355 */     for (b2 = 0; b2 < i; b2++) {
/* 356 */       LittleEndian.putInt(this._data, b1, paramArrayOfint[b2]);
/* 357 */       b1 += 4;
/*     */     } 
/* 359 */     for (b2 = 0; b2 < j; b2++) {
/* 360 */       LittleEndian.putInt(this._data, b1, -1);
/* 361 */       b1 += 4;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getXBATCount() {
/* 369 */     return this._xbat_count;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setXBATCount(int paramInt) {
/* 375 */     this._xbat_count = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getXBATIndex() {
/* 382 */     return this._xbat_start;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setXBATStart(int paramInt) {
/* 388 */     this._xbat_start = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public POIFSBigBlockSize getBigBlockSize() {
/* 395 */     return this.bigBlockSize;
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
/*     */   void writeData(OutputStream paramOutputStream) throws IOException {
/* 409 */     new IntegerField(44, this._bat_count, this._data);
/* 410 */     new IntegerField(48, this._property_start, this._data);
/* 411 */     new IntegerField(60, this._sbat_start, this._data);
/* 412 */     new IntegerField(64, this._sbat_count, this._data);
/* 413 */     new IntegerField(68, this._xbat_start, this._data);
/* 414 */     new IntegerField(72, this._xbat_count, this._data);
/*     */ 
/*     */     
/* 417 */     paramOutputStream.write(this._data, 0, 512);
/*     */ 
/*     */     
/* 420 */     for (char c = 'Ȁ'; c < this.bigBlockSize.getBigBlockSize(); c++) {
/* 421 */       paramOutputStream.write(0);
/*     */     }
/*     */   }
/*     */   
/*     */   private static boolean cmp(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/* 426 */     byte b = 0;
/* 427 */     for (byte b1 : paramArrayOfbyte1) {
/* 428 */       byte b2 = paramArrayOfbyte2[b++];
/* 429 */       if (b2 != b1 && (b1 != 112 || (b2 != 16 && b2 != 32 && b2 != 64))) {
/* 430 */         return false;
/*     */       }
/*     */     } 
/* 433 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\storage\HeaderBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */