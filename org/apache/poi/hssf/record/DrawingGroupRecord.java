/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.apache.poi.ddf.EscherRecord;
/*     */ import org.apache.poi.ddf.EscherSerializationListener;
/*     */ import org.apache.poi.ddf.NullEscherSerializationListener;
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
/*     */ public final class DrawingGroupRecord
/*     */   extends AbstractEscherHolderRecord
/*     */ {
/*     */   public static final short sid = 235;
/*     */   static final int MAX_RECORD_SIZE = 8228;
/*     */   private static final int MAX_DATA_SIZE = 8224;
/*     */   
/*     */   public DrawingGroupRecord() {}
/*     */   
/*     */   public DrawingGroupRecord(RecordInputStream paramRecordInputStream) {
/*  40 */     super(paramRecordInputStream);
/*     */   }
/*     */ 
/*     */   
/*     */   protected String getRecordName() {
/*  45 */     return "MSODRAWINGGROUP";
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/*  50 */     return 235;
/*     */   }
/*     */ 
/*     */   
/*     */   public int serialize(int paramInt, byte[] paramArrayOfbyte) {
/*  55 */     byte[] arrayOfByte1 = getRawData();
/*  56 */     if (getEscherRecords().size() == 0 && arrayOfByte1 != null)
/*     */     {
/*  58 */       return writeData(paramInt, paramArrayOfbyte, arrayOfByte1);
/*     */     }
/*  60 */     byte[] arrayOfByte2 = new byte[getRawDataSize()];
/*  61 */     int i = 0;
/*  62 */     for (EscherRecord escherRecord : getEscherRecords())
/*     */     {
/*     */       
/*  65 */       i += escherRecord.serialize(i, arrayOfByte2, (EscherSerializationListener)new NullEscherSerializationListener());
/*     */     }
/*     */     
/*  68 */     return writeData(paramInt, paramArrayOfbyte, arrayOfByte2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void processChildRecords() {
/*  78 */     convertRawBytesToEscherRecords();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRecordSize() {
/*  83 */     return grossSizeFromDataSize(getRawDataSize());
/*     */   }
/*     */   
/*     */   private int getRawDataSize() {
/*  87 */     List<EscherRecord> list = getEscherRecords();
/*  88 */     byte[] arrayOfByte = getRawData();
/*  89 */     if (list.size() == 0 && arrayOfByte != null)
/*     */     {
/*  91 */       return arrayOfByte.length;
/*     */     }
/*  93 */     int i = 0;
/*  94 */     for (EscherRecord escherRecord : list)
/*     */     {
/*     */       
/*  97 */       i += escherRecord.getRecordSize();
/*     */     }
/*  99 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   static int grossSizeFromDataSize(int paramInt) {
/* 104 */     return paramInt + ((paramInt - 1) / 8224 + 1) * 4;
/*     */   }
/*     */ 
/*     */   
/*     */   private int writeData(int paramInt, byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/* 109 */     int i = 0;
/* 110 */     int j = 0;
/* 111 */     while (j < paramArrayOfbyte2.length) {
/*     */       
/* 113 */       int k = Math.min(paramArrayOfbyte2.length - j, 8224);
/* 114 */       if (j / 8224 >= 2) {
/* 115 */         writeContinueHeader(paramArrayOfbyte1, paramInt, k);
/*     */       } else {
/* 117 */         writeHeader(paramArrayOfbyte1, paramInt, k);
/* 118 */       }  i += true;
/* 119 */       paramInt += 4;
/* 120 */       System.arraycopy(paramArrayOfbyte2, j, paramArrayOfbyte1, paramInt, k);
/* 121 */       paramInt += k;
/* 122 */       j += k;
/* 123 */       i += k;
/*     */     } 
/* 125 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   private void writeHeader(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 130 */     LittleEndian.putShort(paramArrayOfbyte, 0 + paramInt1, getSid());
/* 131 */     LittleEndian.putShort(paramArrayOfbyte, 2 + paramInt1, (short)paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   private void writeContinueHeader(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 136 */     LittleEndian.putShort(paramArrayOfbyte, 0 + paramInt1, (short)60);
/* 137 */     LittleEndian.putShort(paramArrayOfbyte, 2 + paramInt1, (short)paramInt2);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\DrawingGroupRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */