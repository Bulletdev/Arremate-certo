/*     */ package org.apache.poi.ddf;
/*     */ 
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Rectangle;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.util.zip.DeflaterOutputStream;
/*     */ import java.util.zip.InflaterInputStream;
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.LittleEndian;
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
/*     */ public final class EscherMetafileBlip
/*     */   extends EscherBlipRecord
/*     */ {
/*  35 */   private static final POILogger log = POILogFactory.getLogger(EscherMetafileBlip.class);
/*     */   
/*     */   public static final short RECORD_ID_EMF = -4070;
/*     */   
/*     */   public static final short RECORD_ID_WMF = -4069;
/*     */   
/*     */   public static final short RECORD_ID_PICT = -4068;
/*     */   private static final int HEADER_SIZE = 8;
/*  43 */   private final byte[] field_1_UID = new byte[16];
/*     */ 
/*     */ 
/*     */   
/*  47 */   private final byte[] field_2_UID = new byte[16];
/*     */   
/*     */   private int field_2_cb;
/*     */   
/*     */   private int field_3_rcBounds_x1;
/*     */   private int field_3_rcBounds_y1;
/*     */   private int field_3_rcBounds_x2;
/*     */   private int field_3_rcBounds_y2;
/*     */   private int field_4_ptSize_w;
/*     */   private int field_4_ptSize_h;
/*     */   private int field_5_cbSave;
/*     */   private byte field_6_fCompression;
/*     */   private byte field_7_fFilter;
/*     */   private byte[] raw_pictureData;
/*     */   private byte[] remainingData;
/*     */   
/*     */   public int fillFields(byte[] paramArrayOfbyte, int paramInt, EscherRecordFactory paramEscherRecordFactory) {
/*  64 */     int i = readHeader(paramArrayOfbyte, paramInt);
/*  65 */     int j = paramInt + 8;
/*  66 */     System.arraycopy(paramArrayOfbyte, j, this.field_1_UID, 0, 16); j += 16;
/*     */     
/*  68 */     if ((getOptions() ^ getSignature()) == 16) {
/*  69 */       System.arraycopy(paramArrayOfbyte, j, this.field_2_UID, 0, 16); j += 16;
/*     */     } 
/*     */     
/*  72 */     this.field_2_cb = LittleEndian.getInt(paramArrayOfbyte, j); j += 4;
/*  73 */     this.field_3_rcBounds_x1 = LittleEndian.getInt(paramArrayOfbyte, j); j += 4;
/*  74 */     this.field_3_rcBounds_y1 = LittleEndian.getInt(paramArrayOfbyte, j); j += 4;
/*  75 */     this.field_3_rcBounds_x2 = LittleEndian.getInt(paramArrayOfbyte, j); j += 4;
/*  76 */     this.field_3_rcBounds_y2 = LittleEndian.getInt(paramArrayOfbyte, j); j += 4;
/*  77 */     this.field_4_ptSize_w = LittleEndian.getInt(paramArrayOfbyte, j); j += 4;
/*  78 */     this.field_4_ptSize_h = LittleEndian.getInt(paramArrayOfbyte, j); j += 4;
/*  79 */     this.field_5_cbSave = LittleEndian.getInt(paramArrayOfbyte, j); j += 4;
/*  80 */     this.field_6_fCompression = paramArrayOfbyte[j]; j++;
/*  81 */     this.field_7_fFilter = paramArrayOfbyte[j]; j++;
/*     */     
/*  83 */     this.raw_pictureData = new byte[this.field_5_cbSave];
/*  84 */     System.arraycopy(paramArrayOfbyte, j, this.raw_pictureData, 0, this.field_5_cbSave);
/*  85 */     j += this.field_5_cbSave;
/*     */ 
/*     */ 
/*     */     
/*  89 */     if (this.field_6_fCompression == 0) {
/*  90 */       this.field_pictureData = inflatePictureData(this.raw_pictureData);
/*     */     } else {
/*  92 */       this.field_pictureData = this.raw_pictureData;
/*     */     } 
/*     */     
/*  95 */     int k = i - j + paramInt + 8;
/*  96 */     if (k > 0) {
/*  97 */       this.remainingData = new byte[k];
/*  98 */       System.arraycopy(paramArrayOfbyte, j, this.remainingData, 0, k);
/*     */     } 
/* 100 */     return i + 8;
/*     */   }
/*     */ 
/*     */   
/*     */   public int serialize(int paramInt, byte[] paramArrayOfbyte, EscherSerializationListener paramEscherSerializationListener) {
/* 105 */     paramEscherSerializationListener.beforeRecordSerialize(paramInt, getRecordId(), this);
/*     */     
/* 107 */     int i = paramInt;
/* 108 */     LittleEndian.putShort(paramArrayOfbyte, i, getOptions()); i += 2;
/* 109 */     LittleEndian.putShort(paramArrayOfbyte, i, getRecordId()); i += 2;
/* 110 */     LittleEndian.putInt(paramArrayOfbyte, i, getRecordSize() - 8); i += 4;
/*     */     
/* 112 */     System.arraycopy(this.field_1_UID, 0, paramArrayOfbyte, i, this.field_1_UID.length); i += this.field_1_UID.length;
/* 113 */     if ((getOptions() ^ getSignature()) == 16) {
/* 114 */       System.arraycopy(this.field_2_UID, 0, paramArrayOfbyte, i, this.field_2_UID.length); i += this.field_2_UID.length;
/*     */     } 
/* 116 */     LittleEndian.putInt(paramArrayOfbyte, i, this.field_2_cb); i += 4;
/* 117 */     LittleEndian.putInt(paramArrayOfbyte, i, this.field_3_rcBounds_x1); i += 4;
/* 118 */     LittleEndian.putInt(paramArrayOfbyte, i, this.field_3_rcBounds_y1); i += 4;
/* 119 */     LittleEndian.putInt(paramArrayOfbyte, i, this.field_3_rcBounds_x2); i += 4;
/* 120 */     LittleEndian.putInt(paramArrayOfbyte, i, this.field_3_rcBounds_y2); i += 4;
/* 121 */     LittleEndian.putInt(paramArrayOfbyte, i, this.field_4_ptSize_w); i += 4;
/* 122 */     LittleEndian.putInt(paramArrayOfbyte, i, this.field_4_ptSize_h); i += 4;
/* 123 */     LittleEndian.putInt(paramArrayOfbyte, i, this.field_5_cbSave); i += 4;
/* 124 */     paramArrayOfbyte[i] = this.field_6_fCompression; i++;
/* 125 */     paramArrayOfbyte[i] = this.field_7_fFilter; i++;
/*     */     
/* 127 */     System.arraycopy(this.raw_pictureData, 0, paramArrayOfbyte, i, this.raw_pictureData.length); i += this.raw_pictureData.length;
/* 128 */     if (this.remainingData != null) {
/* 129 */       System.arraycopy(this.remainingData, 0, paramArrayOfbyte, i, this.remainingData.length); i += this.remainingData.length;
/*     */     } 
/*     */     
/* 132 */     paramEscherSerializationListener.afterRecordSerialize(paramInt + getRecordSize(), getRecordId(), getRecordSize(), this);
/* 133 */     return getRecordSize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static byte[] inflatePictureData(byte[] paramArrayOfbyte) {
/*     */     try {
/* 144 */       InflaterInputStream inflaterInputStream = new InflaterInputStream(new ByteArrayInputStream(paramArrayOfbyte));
/*     */       
/* 146 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 147 */       byte[] arrayOfByte = new byte[4096];
/*     */       int i;
/* 149 */       while ((i = inflaterInputStream.read(arrayOfByte)) > 0) {
/* 150 */         byteArrayOutputStream.write(arrayOfByte, 0, i);
/*     */       }
/* 152 */       return byteArrayOutputStream.toByteArray();
/* 153 */     } catch (IOException iOException) {
/* 154 */       log.log(5, new Object[] { "Possibly corrupt compression or non-compressed data", iOException });
/* 155 */       return paramArrayOfbyte;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRecordSize() {
/* 161 */     int i = 58 + this.raw_pictureData.length;
/* 162 */     if (this.remainingData != null) i += this.remainingData.length; 
/* 163 */     if ((getOptions() ^ getSignature()) == 16) {
/* 164 */       i += this.field_2_UID.length;
/*     */     }
/* 166 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getUID() {
/* 176 */     return this.field_1_UID;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUID(byte[] paramArrayOfbyte) {
/* 186 */     if (paramArrayOfbyte == null || paramArrayOfbyte.length != 16) {
/* 187 */       throw new IllegalArgumentException("uid must be byte[16]");
/*     */     }
/* 189 */     System.arraycopy(paramArrayOfbyte, 0, this.field_1_UID, 0, this.field_1_UID.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getPrimaryUID() {
/* 199 */     return this.field_2_UID;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPrimaryUID(byte[] paramArrayOfbyte) {
/* 209 */     if (paramArrayOfbyte == null || paramArrayOfbyte.length != 16) {
/* 210 */       throw new IllegalArgumentException("primaryUID must be byte[16]");
/*     */     }
/* 212 */     System.arraycopy(paramArrayOfbyte, 0, this.field_2_UID, 0, this.field_2_UID.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getUncompressedSize() {
/* 221 */     return this.field_2_cb;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUncompressedSize(int paramInt) {
/* 230 */     this.field_2_cb = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle getBounds() {
/* 239 */     return new Rectangle(this.field_3_rcBounds_x1, this.field_3_rcBounds_y1, this.field_3_rcBounds_x2 - this.field_3_rcBounds_x1, this.field_3_rcBounds_y2 - this.field_3_rcBounds_y1);
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
/*     */   public void setBounds(Rectangle paramRectangle) {
/* 251 */     this.field_3_rcBounds_x1 = paramRectangle.x;
/* 252 */     this.field_3_rcBounds_y1 = paramRectangle.y;
/* 253 */     this.field_3_rcBounds_x2 = paramRectangle.x + paramRectangle.width;
/* 254 */     this.field_3_rcBounds_y2 = paramRectangle.y + paramRectangle.height;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Dimension getSizeEMU() {
/* 263 */     return new Dimension(this.field_4_ptSize_w, this.field_4_ptSize_h);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSizeEMU(Dimension paramDimension) {
/* 272 */     this.field_4_ptSize_w = paramDimension.width;
/* 273 */     this.field_4_ptSize_h = paramDimension.height;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCompressedSize() {
/* 282 */     return this.field_5_cbSave;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCompressedSize(int paramInt) {
/* 291 */     this.field_5_cbSave = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCompressed() {
/* 300 */     return (this.field_6_fCompression == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCompressed(boolean paramBoolean) {
/* 309 */     this.field_6_fCompression = paramBoolean ? 0 : -2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getRemainingData() {
/* 318 */     return this.remainingData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 325 */     String str = "";
/* 326 */     return getClass().getName() + ":" + '\n' + "  RecordId: 0x" + HexDump.toHex(getRecordId()) + '\n' + "  Version: 0x" + HexDump.toHex(getVersion()) + '\n' + "  Instance: 0x" + HexDump.toHex(getInstance()) + '\n' + "  UID: 0x" + HexDump.toHex(this.field_1_UID) + '\n' + ((this.field_2_UID == null) ? "" : ("  UID2: 0x" + HexDump.toHex(this.field_2_UID) + '\n')) + "  Uncompressed Size: " + HexDump.toHex(this.field_2_cb) + '\n' + "  Bounds: " + getBounds() + '\n' + "  Size in EMU: " + getSizeEMU() + '\n' + "  Compressed Size: " + HexDump.toHex(this.field_5_cbSave) + '\n' + "  Compression: " + HexDump.toHex(this.field_6_fCompression) + '\n' + "  Filter: " + HexDump.toHex(this.field_7_fFilter) + '\n' + "  Extra Data:" + '\n' + str + ((this.remainingData == null) ? null : ("\n Remaining Data: " + HexDump.toHex(this.remainingData, 32)));
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
/*     */   public String toXml(String paramString) {
/* 345 */     String str = "";
/* 346 */     StringBuilder stringBuilder = new StringBuilder();
/* 347 */     stringBuilder.append(paramString).append(formatXmlRecordHeader(getClass().getSimpleName(), HexDump.toHex(getRecordId()), HexDump.toHex(getVersion()), HexDump.toHex(getInstance()))).append(paramString).append("\t").append("<UID>0x").append(HexDump.toHex(this.field_1_UID) + '\n' + ((this.field_2_UID == null) ? "" : ("  UID2: 0x" + HexDump.toHex(this.field_2_UID) + '\n'))).append("</UID>\n").append(paramString).append("\t").append("<UncompressedSize>0x").append(HexDump.toHex(this.field_2_cb)).append("</UncompressedSize>\n").append(paramString).append("\t").append("<Bounds>").append(getBounds()).append("</Bounds>\n").append(paramString).append("\t").append("<SizeInEMU>").append(getSizeEMU()).append("</SizeInEMU>\n").append(paramString).append("\t").append("<CompressedSize>0x").append(HexDump.toHex(this.field_5_cbSave)).append("</CompressedSize>\n").append(paramString).append("\t").append("<Compression>0x").append(HexDump.toHex(this.field_6_fCompression)).append("</Compression>\n").append(paramString).append("\t").append("<Filter>0x").append(HexDump.toHex(this.field_7_fFilter)).append("</Filter>\n").append(paramString).append("\t").append("<ExtraData>").append(str).append("</ExtraData>\n").append(paramString).append("\t").append("<RemainingData>0x").append(HexDump.toHex(this.remainingData, 32)).append("</RemainingData>\n");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 358 */     stringBuilder.append(paramString).append("</").append(getClass().getSimpleName()).append(">\n");
/* 359 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getSignature() {
/* 368 */     switch (getRecordId()) { case -4070:
/* 369 */         return 15680;
/* 370 */       case -4069: return 8544;
/* 371 */       case -4068: return 21536; }
/*     */     
/* 373 */     if (log.check(5)) {
/* 374 */       log.log(5, new Object[] { "Unknown metafile: " + getRecordId() });
/*     */     }
/* 376 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPictureData(byte[] paramArrayOfbyte) {
/* 381 */     super.setPictureData(paramArrayOfbyte);
/* 382 */     setUncompressedSize(paramArrayOfbyte.length);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 389 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 390 */       DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
/* 391 */       deflaterOutputStream.write(paramArrayOfbyte);
/* 392 */       deflaterOutputStream.close();
/* 393 */       this.raw_pictureData = byteArrayOutputStream.toByteArray();
/* 394 */     } catch (IOException iOException) {
/* 395 */       throw new RuntimeException("Can't compress metafile picture data", iOException);
/*     */     } 
/*     */     
/* 398 */     setCompressedSize(this.raw_pictureData.length);
/* 399 */     setCompressed(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFilter(byte paramByte) {
/* 408 */     this.field_7_fFilter = paramByte;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ddf\EscherMetafileBlip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */