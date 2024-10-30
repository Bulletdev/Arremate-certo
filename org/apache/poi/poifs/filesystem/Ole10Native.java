/*     */ package org.apache.poi.poifs.filesystem;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import org.apache.poi.util.LittleEndian;
/*     */ import org.apache.poi.util.LittleEndianOutputStream;
/*     */ import org.apache.poi.util.StringUtil;
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
/*     */ public class Ole10Native
/*     */ {
/*     */   public static final String OLE10_NATIVE = "\001Ole10Native";
/*     */   protected static final String ISO1 = "ISO-8859-1";
/*     */   private int totalSize;
/*     */   private short flags1;
/*     */   private String label;
/*     */   private String fileName;
/*     */   private short flags2;
/*     */   private short unknown1;
/*     */   private String command;
/*     */   private byte[] dataBuffer;
/*     */   private short flags3;
/*     */   private EncodingMode mode;
/*     */   
/*     */   private enum EncodingMode
/*     */   {
/*  58 */     parsed,
/*     */ 
/*     */ 
/*     */     
/*  62 */     unparsed,
/*     */ 
/*     */ 
/*     */     
/*  66 */     compact;
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
/*     */   public static Ole10Native createFromEmbeddedOleObject(POIFSFileSystem paramPOIFSFileSystem) throws IOException, Ole10NativeException {
/*  84 */     return createFromEmbeddedOleObject(paramPOIFSFileSystem.getRoot());
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
/*     */   public static Ole10Native createFromEmbeddedOleObject(DirectoryNode paramDirectoryNode) throws IOException, Ole10NativeException {
/*  98 */     DocumentEntry documentEntry = (DocumentEntry)paramDirectoryNode.getEntry("\001Ole10Native");
/*     */     
/* 100 */     byte[] arrayOfByte = new byte[documentEntry.getSize()];
/* 101 */     int i = paramDirectoryNode.createDocumentInputStream(documentEntry).read(arrayOfByte);
/* 102 */     assert i == arrayOfByte.length;
/*     */     
/* 104 */     return new Ole10Native(arrayOfByte, 0);
/*     */   }
/*     */   public Ole10Native(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfbyte) {
/*     */     this.flags1 = 2;
/*     */     this.flags2 = 0;
/*     */     this.unknown1 = 3;
/*     */     this.flags3 = 0;
/* 111 */     setLabel(paramString1);
/* 112 */     setFileName(paramString2);
/* 113 */     setCommand(paramString3);
/* 114 */     setDataBuffer(paramArrayOfbyte);
/* 115 */     this.mode = EncodingMode.parsed;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Ole10Native(byte[] paramArrayOfbyte, int paramInt) throws Ole10NativeException {
/*     */     int j, k;
/*     */     this.flags1 = 2;
/*     */     this.flags2 = 0;
/*     */     this.unknown1 = 3;
/*     */     this.flags3 = 0;
/* 126 */     int i = paramInt;
/*     */     
/* 128 */     if (paramArrayOfbyte.length < paramInt + 2) {
/* 129 */       throw new Ole10NativeException("data is too small");
/*     */     }
/*     */     
/* 132 */     this.totalSize = LittleEndian.getInt(paramArrayOfbyte, i);
/* 133 */     i += 4;
/*     */     
/* 135 */     this.mode = EncodingMode.unparsed;
/* 136 */     if (LittleEndian.getShort(paramArrayOfbyte, i) == 2)
/*     */     {
/*     */       
/* 139 */       if (Character.isISOControl(paramArrayOfbyte[i + 2])) {
/* 140 */         this.mode = EncodingMode.compact;
/*     */       } else {
/* 142 */         this.mode = EncodingMode.parsed;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 147 */     switch (this.mode) {
/*     */       case parsed:
/* 149 */         this.flags1 = LittleEndian.getShort(paramArrayOfbyte, i);
/*     */ 
/*     */         
/* 152 */         i += 2;
/*     */         
/* 154 */         k = getStringLength(paramArrayOfbyte, i);
/* 155 */         this.label = StringUtil.getFromCompressedUnicode(paramArrayOfbyte, i, k - 1);
/* 156 */         i += k;
/*     */         
/* 158 */         k = getStringLength(paramArrayOfbyte, i);
/* 159 */         this.fileName = StringUtil.getFromCompressedUnicode(paramArrayOfbyte, i, k - 1);
/* 160 */         i += k;
/*     */         
/* 162 */         this.flags2 = LittleEndian.getShort(paramArrayOfbyte, i);
/* 163 */         i += 2;
/*     */         
/* 165 */         this.unknown1 = LittleEndian.getShort(paramArrayOfbyte, i);
/* 166 */         i += 2;
/*     */         
/* 168 */         k = LittleEndian.getInt(paramArrayOfbyte, i);
/* 169 */         i += 4;
/* 170 */         this.command = StringUtil.getFromCompressedUnicode(paramArrayOfbyte, i, k - 1);
/* 171 */         i += k;
/*     */         
/* 173 */         if (this.totalSize < i) {
/* 174 */           throw new Ole10NativeException("Invalid Ole10Native");
/*     */         }
/*     */         
/* 177 */         j = LittleEndian.getInt(paramArrayOfbyte, i);
/* 178 */         i += 4;
/*     */         
/* 180 */         if (j < 0 || this.totalSize - i - 4 < j) {
/* 181 */           throw new Ole10NativeException("Invalid Ole10Native");
/*     */         }
/*     */         break;
/*     */       
/*     */       case compact:
/* 186 */         this.flags1 = LittleEndian.getShort(paramArrayOfbyte, i);
/* 187 */         i += 2;
/* 188 */         j = this.totalSize - 2;
/*     */         break;
/*     */       
/*     */       default:
/* 192 */         j = this.totalSize;
/*     */         break;
/*     */     } 
/*     */     
/* 196 */     this.dataBuffer = new byte[j];
/* 197 */     System.arraycopy(paramArrayOfbyte, i, this.dataBuffer, 0, j);
/* 198 */     i += j;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int getStringLength(byte[] paramArrayOfbyte, int paramInt) {
/* 205 */     byte b = 0;
/* 206 */     while (b + paramInt < paramArrayOfbyte.length && paramArrayOfbyte[paramInt + b] != 0) {
/* 207 */       b++;
/*     */     }
/* 209 */     b++;
/* 210 */     return b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalSize() {
/* 220 */     return this.totalSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getFlags1() {
/* 229 */     return this.flags1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLabel() {
/* 240 */     return this.label;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFileName() {
/* 250 */     return this.fileName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getFlags2() {
/* 259 */     return this.flags2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getUnknown1() {
/* 268 */     return this.unknown1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCommand() {
/* 279 */     return this.command;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDataSize() {
/* 290 */     return this.dataBuffer.length;
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
/*     */   public byte[] getDataBuffer() {
/* 303 */     return this.dataBuffer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getFlags3() {
/* 312 */     return this.flags3;
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
/*     */   public void writeOut(OutputStream paramOutputStream) throws IOException {
/*     */     ByteArrayOutputStream byteArrayOutputStream;
/* 326 */     LittleEndianOutputStream littleEndianOutputStream2, littleEndianOutputStream1 = new LittleEndianOutputStream(paramOutputStream);
/*     */     
/* 328 */     switch (this.mode) {
/*     */       case parsed:
/* 330 */         byteArrayOutputStream = new ByteArrayOutputStream();
/* 331 */         littleEndianOutputStream2 = new LittleEndianOutputStream(byteArrayOutputStream);
/*     */ 
/*     */         
/* 334 */         littleEndianOutputStream2.writeShort(getFlags1());
/* 335 */         littleEndianOutputStream2.write(getLabel().getBytes("ISO-8859-1"));
/* 336 */         littleEndianOutputStream2.write(0);
/* 337 */         littleEndianOutputStream2.write(getFileName().getBytes("ISO-8859-1"));
/* 338 */         littleEndianOutputStream2.write(0);
/* 339 */         littleEndianOutputStream2.writeShort(getFlags2());
/* 340 */         littleEndianOutputStream2.writeShort(getUnknown1());
/* 341 */         littleEndianOutputStream2.writeInt(getCommand().length() + 1);
/* 342 */         littleEndianOutputStream2.write(getCommand().getBytes("ISO-8859-1"));
/* 343 */         littleEndianOutputStream2.write(0);
/* 344 */         littleEndianOutputStream2.writeInt(getDataSize());
/* 345 */         littleEndianOutputStream2.write(getDataBuffer());
/* 346 */         littleEndianOutputStream2.writeShort(getFlags3());
/* 347 */         littleEndianOutputStream2.close();
/*     */         
/* 349 */         littleEndianOutputStream1.writeInt(byteArrayOutputStream.size());
/* 350 */         byteArrayOutputStream.writeTo(paramOutputStream);
/*     */         return;
/*     */       
/*     */       case compact:
/* 354 */         littleEndianOutputStream1.writeInt(getDataSize() + 2);
/* 355 */         littleEndianOutputStream1.writeShort(getFlags1());
/* 356 */         paramOutputStream.write(getDataBuffer());
/*     */         return;
/*     */     } 
/*     */     
/* 360 */     littleEndianOutputStream1.writeInt(getDataSize());
/* 361 */     paramOutputStream.write(getDataBuffer());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFlags1(short paramShort) {
/* 368 */     this.flags1 = paramShort;
/*     */   }
/*     */   
/*     */   public void setFlags2(short paramShort) {
/* 372 */     this.flags2 = paramShort;
/*     */   }
/*     */   
/*     */   public void setFlags3(short paramShort) {
/* 376 */     this.flags3 = paramShort;
/*     */   }
/*     */   
/*     */   public void setLabel(String paramString) {
/* 380 */     this.label = paramString;
/*     */   }
/*     */   
/*     */   public void setFileName(String paramString) {
/* 384 */     this.fileName = paramString;
/*     */   }
/*     */   
/*     */   public void setCommand(String paramString) {
/* 388 */     this.command = paramString;
/*     */   }
/*     */   
/*     */   public void setUnknown1(short paramShort) {
/* 392 */     this.unknown1 = paramShort;
/*     */   }
/*     */   
/*     */   public void setDataBuffer(byte[] paramArrayOfbyte) {
/* 396 */     this.dataBuffer = (byte[])paramArrayOfbyte.clone();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\filesystem\Ole10Native.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */