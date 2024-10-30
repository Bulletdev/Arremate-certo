/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.LittleEndian;
/*     */ import org.apache.poi.util.LittleEndianByteArrayOutputStream;
/*     */ import org.apache.poi.util.LittleEndianInput;
/*     */ import org.apache.poi.util.LittleEndianInputStream;
/*     */ import org.apache.poi.util.LittleEndianOutput;
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
/*     */ public final class ObjRecord
/*     */   extends Record
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 93;
/*     */   private static final int NORMAL_PAD_ALIGNMENT = 2;
/*  38 */   private static int MAX_PAD_ALIGNMENT = 4;
/*     */ 
/*     */ 
/*     */   
/*     */   private List<SubRecord> subrecords;
/*     */ 
/*     */   
/*     */   private final byte[] _uninterpretedData;
/*     */ 
/*     */   
/*     */   private boolean _isPaddedToQuadByteMultiple;
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjRecord() {
/*  53 */     this.subrecords = new ArrayList<SubRecord>(2);
/*     */     
/*  55 */     this._uninterpretedData = null;
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
/*     */   public ObjRecord(RecordInputStream paramRecordInputStream) {
/*     */     SubRecord subRecord;
/*  70 */     byte[] arrayOfByte = paramRecordInputStream.readRemainder();
/*  71 */     if (LittleEndian.getUShort(arrayOfByte, 0) != 21) {
/*     */ 
/*     */ 
/*     */       
/*  75 */       this._uninterpretedData = arrayOfByte;
/*  76 */       this.subrecords = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  88 */     this.subrecords = new ArrayList<SubRecord>();
/*  89 */     ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrayOfByte);
/*  90 */     LittleEndianInputStream littleEndianInputStream = new LittleEndianInputStream(byteArrayInputStream);
/*  91 */     CommonObjectDataSubRecord commonObjectDataSubRecord = (CommonObjectDataSubRecord)SubRecord.createSubRecord((LittleEndianInput)littleEndianInputStream, 0);
/*  92 */     this.subrecords.add(commonObjectDataSubRecord);
/*     */     do {
/*  94 */       subRecord = SubRecord.createSubRecord((LittleEndianInput)littleEndianInputStream, commonObjectDataSubRecord.getObjectType());
/*  95 */       this.subrecords.add(subRecord);
/*  96 */     } while (!subRecord.isTerminating());
/*     */ 
/*     */ 
/*     */     
/* 100 */     int i = byteArrayInputStream.available();
/* 101 */     if (i > 0) {
/*     */       
/* 103 */       this._isPaddedToQuadByteMultiple = (arrayOfByte.length % MAX_PAD_ALIGNMENT == 0);
/* 104 */       if (i >= (this._isPaddedToQuadByteMultiple ? MAX_PAD_ALIGNMENT : 2)) {
/* 105 */         if (!canPaddingBeDiscarded(arrayOfByte, i)) {
/* 106 */           String str = "Leftover " + i + " bytes in subrecord data " + HexDump.toHex(arrayOfByte);
/*     */           
/* 108 */           throw new RecordFormatException(str);
/*     */         } 
/* 110 */         this._isPaddedToQuadByteMultiple = false;
/*     */       } 
/*     */     } else {
/*     */       
/* 114 */       this._isPaddedToQuadByteMultiple = false;
/*     */     } 
/* 116 */     this._uninterpretedData = null;
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
/*     */   private static boolean canPaddingBeDiscarded(byte[] paramArrayOfbyte, int paramInt) {
/* 130 */     for (int i = paramArrayOfbyte.length - paramInt; i < paramArrayOfbyte.length; i++) {
/* 131 */       if (paramArrayOfbyte[i] != 0) {
/* 132 */         return false;
/*     */       }
/*     */     } 
/* 135 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 140 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 142 */     stringBuffer.append("[OBJ]\n");
/* 143 */     if (this.subrecords != null) {
/* 144 */       for (byte b = 0; b < this.subrecords.size(); b++) {
/* 145 */         SubRecord subRecord = this.subrecords.get(b);
/* 146 */         stringBuffer.append("SUBRECORD: ").append(subRecord.toString());
/*     */       } 
/*     */     }
/* 149 */     stringBuffer.append("[/OBJ]\n");
/* 150 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRecordSize() {
/* 155 */     if (this._uninterpretedData != null) {
/* 156 */       return this._uninterpretedData.length + 4;
/*     */     }
/* 158 */     int i = 0;
/* 159 */     for (int j = this.subrecords.size() - 1; j >= 0; j--) {
/* 160 */       SubRecord subRecord = this.subrecords.get(j);
/* 161 */       i += subRecord.getDataSize() + 4;
/*     */     } 
/* 163 */     if (this._isPaddedToQuadByteMultiple) {
/* 164 */       while (i % MAX_PAD_ALIGNMENT != 0) {
/* 165 */         i++;
/*     */       }
/*     */     } else {
/* 168 */       while (i % 2 != 0) {
/* 169 */         i++;
/*     */       }
/*     */     } 
/* 172 */     return i + 4;
/*     */   }
/*     */ 
/*     */   
/*     */   public int serialize(int paramInt, byte[] paramArrayOfbyte) {
/* 177 */     int i = getRecordSize();
/* 178 */     int j = i - 4;
/* 179 */     LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream = new LittleEndianByteArrayOutputStream(paramArrayOfbyte, paramInt, i);
/*     */     
/* 181 */     littleEndianByteArrayOutputStream.writeShort(93);
/* 182 */     littleEndianByteArrayOutputStream.writeShort(j);
/*     */     
/* 184 */     if (this._uninterpretedData == null) {
/*     */       int k;
/* 186 */       for (k = 0; k < this.subrecords.size(); k++) {
/* 187 */         SubRecord subRecord = this.subrecords.get(k);
/* 188 */         subRecord.serialize((LittleEndianOutput)littleEndianByteArrayOutputStream);
/*     */       } 
/* 190 */       k = paramInt + j;
/*     */       
/* 192 */       while (littleEndianByteArrayOutputStream.getWriteIndex() < k) {
/* 193 */         littleEndianByteArrayOutputStream.writeByte(0);
/*     */       }
/*     */     } else {
/* 196 */       littleEndianByteArrayOutputStream.write(this._uninterpretedData);
/*     */     } 
/* 198 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 203 */     return 93;
/*     */   }
/*     */   
/*     */   public List<SubRecord> getSubRecords() {
/* 207 */     return this.subrecords;
/*     */   }
/*     */   
/*     */   public void clearSubRecords() {
/* 211 */     this.subrecords.clear();
/*     */   }
/*     */   
/*     */   public void addSubRecord(int paramInt, SubRecord paramSubRecord) {
/* 215 */     this.subrecords.add(paramInt, paramSubRecord);
/*     */   }
/*     */   
/*     */   public boolean addSubRecord(SubRecord paramSubRecord) {
/* 219 */     return this.subrecords.add(paramSubRecord);
/*     */   }
/*     */ 
/*     */   
/*     */   public ObjRecord clone() {
/* 224 */     ObjRecord objRecord = new ObjRecord();
/*     */     
/* 226 */     for (byte b = 0; b < this.subrecords.size(); b++) {
/* 227 */       SubRecord subRecord = this.subrecords.get(b);
/* 228 */       objRecord.addSubRecord((SubRecord)subRecord.clone());
/*     */     } 
/* 230 */     return objRecord;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\ObjRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */