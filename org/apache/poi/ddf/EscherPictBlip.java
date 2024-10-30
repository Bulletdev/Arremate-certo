/*     */ package org.apache.poi.ddf;
/*     */ 
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Rectangle;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
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
/*     */ public final class EscherPictBlip
/*     */   extends EscherBlipRecord
/*     */ {
/*  33 */   private static final POILogger log = POILogFactory.getLogger(EscherPictBlip.class);
/*     */   
/*     */   public static final short RECORD_ID_EMF = -4070;
/*     */   
/*     */   public static final short RECORD_ID_WMF = -4069;
/*     */   
/*     */   public static final short RECORD_ID_PICT = -4068;
/*     */   private static final int HEADER_SIZE = 8;
/*  41 */   private final byte[] field_1_UID = new byte[16];
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
/*     */   
/*     */   public int fillFields(byte[] paramArrayOfbyte, int paramInt, EscherRecordFactory paramEscherRecordFactory) {
/*  57 */     int i = readHeader(paramArrayOfbyte, paramInt);
/*  58 */     int j = paramInt + 8;
/*     */     
/*  60 */     System.arraycopy(paramArrayOfbyte, j, this.field_1_UID, 0, 16); j += 16;
/*  61 */     this.field_2_cb = LittleEndian.getInt(paramArrayOfbyte, j); j += 4;
/*  62 */     this.field_3_rcBounds_x1 = LittleEndian.getInt(paramArrayOfbyte, j); j += 4;
/*  63 */     this.field_3_rcBounds_y1 = LittleEndian.getInt(paramArrayOfbyte, j); j += 4;
/*  64 */     this.field_3_rcBounds_x2 = LittleEndian.getInt(paramArrayOfbyte, j); j += 4;
/*  65 */     this.field_3_rcBounds_y2 = LittleEndian.getInt(paramArrayOfbyte, j); j += 4;
/*  66 */     this.field_4_ptSize_w = LittleEndian.getInt(paramArrayOfbyte, j); j += 4;
/*  67 */     this.field_4_ptSize_h = LittleEndian.getInt(paramArrayOfbyte, j); j += 4;
/*  68 */     this.field_5_cbSave = LittleEndian.getInt(paramArrayOfbyte, j); j += 4;
/*  69 */     this.field_6_fCompression = paramArrayOfbyte[j]; j++;
/*  70 */     this.field_7_fFilter = paramArrayOfbyte[j]; j++;
/*     */     
/*  72 */     this.raw_pictureData = new byte[this.field_5_cbSave];
/*  73 */     System.arraycopy(paramArrayOfbyte, j, this.raw_pictureData, 0, this.field_5_cbSave);
/*     */ 
/*     */ 
/*     */     
/*  77 */     if (this.field_6_fCompression == 0) {
/*     */       
/*  79 */       this.field_pictureData = inflatePictureData(this.raw_pictureData);
/*     */     }
/*     */     else {
/*     */       
/*  83 */       this.field_pictureData = this.raw_pictureData;
/*     */     } 
/*     */     
/*  86 */     return i + 8;
/*     */   }
/*     */ 
/*     */   
/*     */   public int serialize(int paramInt, byte[] paramArrayOfbyte, EscherSerializationListener paramEscherSerializationListener) {
/*  91 */     paramEscherSerializationListener.beforeRecordSerialize(paramInt, getRecordId(), this);
/*     */     
/*  93 */     int i = paramInt;
/*  94 */     LittleEndian.putShort(paramArrayOfbyte, i, getOptions()); i += 2;
/*  95 */     LittleEndian.putShort(paramArrayOfbyte, i, getRecordId()); i += 2;
/*  96 */     LittleEndian.putInt(paramArrayOfbyte, 0, getRecordSize() - 8); i += 4;
/*     */     
/*  98 */     System.arraycopy(this.field_1_UID, 0, paramArrayOfbyte, i, 16); i += 16;
/*  99 */     LittleEndian.putInt(paramArrayOfbyte, i, this.field_2_cb); i += 4;
/* 100 */     LittleEndian.putInt(paramArrayOfbyte, i, this.field_3_rcBounds_x1); i += 4;
/* 101 */     LittleEndian.putInt(paramArrayOfbyte, i, this.field_3_rcBounds_y1); i += 4;
/* 102 */     LittleEndian.putInt(paramArrayOfbyte, i, this.field_3_rcBounds_x2); i += 4;
/* 103 */     LittleEndian.putInt(paramArrayOfbyte, i, this.field_3_rcBounds_y2); i += 4;
/* 104 */     LittleEndian.putInt(paramArrayOfbyte, i, this.field_4_ptSize_w); i += 4;
/* 105 */     LittleEndian.putInt(paramArrayOfbyte, i, this.field_4_ptSize_h); i += 4;
/* 106 */     LittleEndian.putInt(paramArrayOfbyte, i, this.field_5_cbSave); i += 4;
/* 107 */     paramArrayOfbyte[i] = this.field_6_fCompression; i++;
/* 108 */     paramArrayOfbyte[i] = this.field_7_fFilter; i++;
/*     */     
/* 110 */     System.arraycopy(this.raw_pictureData, 0, paramArrayOfbyte, i, this.raw_pictureData.length);
/*     */     
/* 112 */     paramEscherSerializationListener.afterRecordSerialize(paramInt + getRecordSize(), getRecordId(), getRecordSize(), this);
/* 113 */     return 25 + this.raw_pictureData.length;
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
/* 124 */       InflaterInputStream inflaterInputStream = new InflaterInputStream(new ByteArrayInputStream(paramArrayOfbyte));
/* 125 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 126 */       byte[] arrayOfByte = new byte[4096];
/*     */       int i;
/* 128 */       while ((i = inflaterInputStream.read(arrayOfByte)) > 0) {
/* 129 */         byteArrayOutputStream.write(arrayOfByte, 0, i);
/*     */       }
/* 131 */       return byteArrayOutputStream.toByteArray();
/* 132 */     } catch (IOException iOException) {
/* 133 */       log.log(3, new Object[] { "Possibly corrupt compression or non-compressed data", iOException });
/* 134 */       return paramArrayOfbyte;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRecordSize() {
/* 140 */     return 58 + this.raw_pictureData.length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getUID() {
/* 150 */     return this.field_1_UID;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUID(byte[] paramArrayOfbyte) {
/* 160 */     if (paramArrayOfbyte == null || paramArrayOfbyte.length != 16) {
/* 161 */       throw new IllegalArgumentException("uid must be byte[16]");
/*     */     }
/* 163 */     System.arraycopy(paramArrayOfbyte, 0, this.field_1_UID, 0, this.field_1_UID.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getUncompressedSize() {
/* 172 */     return this.field_2_cb;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUncompressedSize(int paramInt) {
/* 181 */     this.field_2_cb = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle getBounds() {
/* 190 */     return new Rectangle(this.field_3_rcBounds_x1, this.field_3_rcBounds_y1, this.field_3_rcBounds_x2 - this.field_3_rcBounds_x1, this.field_3_rcBounds_y2 - this.field_3_rcBounds_y1);
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
/* 202 */     this.field_3_rcBounds_x1 = paramRectangle.x;
/* 203 */     this.field_3_rcBounds_y1 = paramRectangle.y;
/* 204 */     this.field_3_rcBounds_x2 = paramRectangle.x + paramRectangle.width;
/* 205 */     this.field_3_rcBounds_y2 = paramRectangle.y + paramRectangle.height;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Dimension getSizeEMU() {
/* 214 */     return new Dimension(this.field_4_ptSize_w, this.field_4_ptSize_h);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSizeEMU(Dimension paramDimension) {
/* 223 */     this.field_4_ptSize_w = paramDimension.width;
/* 224 */     this.field_4_ptSize_h = paramDimension.height;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCompressedSize() {
/* 233 */     return this.field_5_cbSave;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCompressedSize(int paramInt) {
/* 242 */     this.field_5_cbSave = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCompressed() {
/* 251 */     return (this.field_6_fCompression == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCompressed(boolean paramBoolean) {
/* 260 */     this.field_6_fCompression = paramBoolean ? 0 : -2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 267 */     String str = HexDump.toHex(this.field_pictureData, 32);
/* 268 */     return getClass().getName() + ":" + '\n' + "  RecordId: 0x" + HexDump.toHex(getRecordId()) + '\n' + "  Version: 0x" + HexDump.toHex(getVersion()) + '\n' + "  Instance: 0x" + HexDump.toHex(getInstance()) + '\n' + "  UID: 0x" + HexDump.toHex(this.field_1_UID) + '\n' + "  Uncompressed Size: " + HexDump.toHex(this.field_2_cb) + '\n' + "  Bounds: " + getBounds() + '\n' + "  Size in EMU: " + getSizeEMU() + '\n' + "  Compressed Size: " + HexDump.toHex(this.field_5_cbSave) + '\n' + "  Compression: " + HexDump.toHex(this.field_6_fCompression) + '\n' + "  Filter: " + HexDump.toHex(this.field_7_fFilter) + '\n' + "  Extra Data:" + '\n' + str;
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
/*     */   public String toXml(String paramString) {
/* 284 */     String str = "";
/* 285 */     StringBuilder stringBuilder = new StringBuilder();
/* 286 */     stringBuilder.append(paramString).append(formatXmlRecordHeader(getClass().getSimpleName(), HexDump.toHex(getRecordId()), HexDump.toHex(getVersion()), HexDump.toHex(getInstance()))).append(paramString).append("\t").append("<UID>0x").append(HexDump.toHex(this.field_1_UID)).append("</UID>\n").append(paramString).append("\t").append("<UncompressedSize>0x").append(HexDump.toHex(this.field_2_cb)).append("</UncompressedSize>\n").append(paramString).append("\t").append("<Bounds>").append(getBounds()).append("</Bounds>\n").append(paramString).append("\t").append("<SizeInEMU>").append(getSizeEMU()).append("</SizeInEMU>\n").append(paramString).append("\t").append("<CompressedSize>0x").append(HexDump.toHex(this.field_5_cbSave)).append("</CompressedSize>\n").append(paramString).append("\t").append("<Compression>0x").append(HexDump.toHex(this.field_6_fCompression)).append("</Compression>\n").append(paramString).append("\t").append("<Filter>0x").append(HexDump.toHex(this.field_7_fFilter)).append("</Filter>\n").append(paramString).append("\t").append("<ExtraData>").append(str).append("</ExtraData>\n");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 295 */     stringBuilder.append(paramString).append("</").append(getClass().getSimpleName()).append(">\n");
/* 296 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ddf\EscherPictBlip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */