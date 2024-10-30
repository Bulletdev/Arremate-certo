/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.poi.ddf.DefaultEscherRecordFactory;
/*     */ import org.apache.poi.ddf.EscherContainerRecord;
/*     */ import org.apache.poi.ddf.EscherRecord;
/*     */ import org.apache.poi.ddf.EscherRecordFactory;
/*     */ import org.apache.poi.ddf.EscherSerializationListener;
/*     */ import org.apache.poi.ddf.NullEscherSerializationListener;
/*     */ import org.apache.poi.hssf.util.LazilyConcatenatedByteArray;
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
/*     */ public abstract class AbstractEscherHolderRecord
/*     */   extends Record
/*     */   implements Cloneable
/*     */ {
/*     */   private static boolean DESERIALISE;
/*     */   private final List<EscherRecord> escherRecords;
/*     */   
/*     */   static {
/*     */     try {
/*  39 */       DESERIALISE = (System.getProperty("poi.deserialize.escher") != null);
/*  40 */     } catch (SecurityException securityException) {
/*  41 */       DESERIALISE = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*  46 */   private final LazilyConcatenatedByteArray rawDataContainer = new LazilyConcatenatedByteArray();
/*     */ 
/*     */   
/*     */   public AbstractEscherHolderRecord() {
/*  50 */     this.escherRecords = new ArrayList<EscherRecord>();
/*     */   }
/*     */ 
/*     */   
/*     */   public AbstractEscherHolderRecord(RecordInputStream paramRecordInputStream) {
/*  55 */     this.escherRecords = new ArrayList<EscherRecord>();
/*  56 */     if (!DESERIALISE) {
/*  57 */       this.rawDataContainer.concatenate(paramRecordInputStream.readRemainder());
/*     */     } else {
/*  59 */       byte[] arrayOfByte = paramRecordInputStream.readAllContinuedRemainder();
/*  60 */       convertToEscherRecords(0, arrayOfByte.length, arrayOfByte);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void convertRawBytesToEscherRecords() {
/*  65 */     if (!DESERIALISE) {
/*  66 */       byte[] arrayOfByte = getRawData();
/*  67 */       convertToEscherRecords(0, arrayOfByte.length, arrayOfByte);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void convertToEscherRecords(int paramInt1, int paramInt2, byte[] paramArrayOfbyte) {
/*  72 */     this.escherRecords.clear();
/*  73 */     DefaultEscherRecordFactory defaultEscherRecordFactory = new DefaultEscherRecordFactory();
/*  74 */     int i = paramInt1;
/*  75 */     while (i < paramInt1 + paramInt2) {
/*     */       
/*  77 */       EscherRecord escherRecord = defaultEscherRecordFactory.createRecord(paramArrayOfbyte, i);
/*  78 */       int j = escherRecord.fillFields(paramArrayOfbyte, i, (EscherRecordFactory)defaultEscherRecordFactory);
/*  79 */       this.escherRecords.add(escherRecord);
/*  80 */       i += j;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  87 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  89 */     String str = System.getProperty("line.separator");
/*  90 */     stringBuffer.append('[' + getRecordName() + ']' + str);
/*  91 */     if (this.escherRecords.size() == 0)
/*  92 */       stringBuffer.append("No Escher Records Decoded" + str); 
/*  93 */     for (EscherRecord escherRecord : this.escherRecords) {
/*  94 */       stringBuffer.append(escherRecord.toString());
/*     */     }
/*  96 */     stringBuffer.append("[/" + getRecordName() + ']' + str);
/*     */     
/*  98 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int serialize(int paramInt, byte[] paramArrayOfbyte) {
/* 106 */     LittleEndian.putShort(paramArrayOfbyte, 0 + paramInt, getSid());
/* 107 */     LittleEndian.putShort(paramArrayOfbyte, 2 + paramInt, (short)(getRecordSize() - 4));
/* 108 */     byte[] arrayOfByte = getRawData();
/* 109 */     if (this.escherRecords.size() == 0 && arrayOfByte != null) {
/*     */       
/* 111 */       LittleEndian.putShort(paramArrayOfbyte, 0 + paramInt, getSid());
/* 112 */       LittleEndian.putShort(paramArrayOfbyte, 2 + paramInt, (short)(getRecordSize() - 4));
/* 113 */       System.arraycopy(arrayOfByte, 0, paramArrayOfbyte, 4 + paramInt, arrayOfByte.length);
/* 114 */       return arrayOfByte.length + 4;
/*     */     } 
/* 116 */     LittleEndian.putShort(paramArrayOfbyte, 0 + paramInt, getSid());
/* 117 */     LittleEndian.putShort(paramArrayOfbyte, 2 + paramInt, (short)(getRecordSize() - 4));
/*     */     
/* 119 */     int i = paramInt + 4;
/* 120 */     for (EscherRecord escherRecord : this.escherRecords) {
/* 121 */       i += escherRecord.serialize(i, paramArrayOfbyte, (EscherSerializationListener)new NullEscherSerializationListener());
/*     */     }
/* 123 */     return getRecordSize();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRecordSize() {
/* 128 */     byte[] arrayOfByte = getRawData();
/* 129 */     if (this.escherRecords.size() == 0 && arrayOfByte != null)
/*     */     {
/* 131 */       return arrayOfByte.length;
/*     */     }
/* 133 */     int i = 0;
/* 134 */     for (EscherRecord escherRecord : this.escherRecords) {
/* 135 */       i += escherRecord.getRecordSize();
/*     */     }
/* 137 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AbstractEscherHolderRecord clone() {
/* 147 */     return (AbstractEscherHolderRecord)cloneViaReserialise();
/*     */   }
/*     */ 
/*     */   
/*     */   public void addEscherRecord(int paramInt, EscherRecord paramEscherRecord) {
/* 152 */     this.escherRecords.add(paramInt, paramEscherRecord);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean addEscherRecord(EscherRecord paramEscherRecord) {
/* 157 */     return this.escherRecords.add(paramEscherRecord);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<EscherRecord> getEscherRecords() {
/* 162 */     return this.escherRecords;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clearEscherRecords() {
/* 167 */     this.escherRecords.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EscherContainerRecord getEscherContainer() {
/* 178 */     for (EscherRecord escherRecord : this.escherRecords) {
/* 179 */       if (escherRecord instanceof EscherContainerRecord) {
/* 180 */         return (EscherContainerRecord)escherRecord;
/*     */       }
/*     */     } 
/* 183 */     return null;
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
/*     */   public EscherRecord findFirstWithId(short paramShort) {
/* 196 */     return findFirstWithId(paramShort, getEscherRecords());
/*     */   }
/*     */ 
/*     */   
/*     */   private EscherRecord findFirstWithId(short paramShort, List<EscherRecord> paramList) {
/* 201 */     for (EscherRecord escherRecord : paramList) {
/* 202 */       if (escherRecord.getRecordId() == paramShort) {
/* 203 */         return escherRecord;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 208 */     for (EscherRecord escherRecord : paramList) {
/* 209 */       if (escherRecord.isContainerRecord()) {
/* 210 */         EscherRecord escherRecord1 = findFirstWithId(paramShort, escherRecord.getChildRecords());
/* 211 */         if (escherRecord1 != null) {
/* 212 */           return escherRecord1;
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 218 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EscherRecord getEscherRecord(int paramInt) {
/* 224 */     return this.escherRecords.get(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void join(AbstractEscherHolderRecord paramAbstractEscherHolderRecord) {
/* 235 */     this.rawDataContainer.concatenate(paramAbstractEscherHolderRecord.getRawData());
/*     */   }
/*     */ 
/*     */   
/*     */   public void processContinueRecord(byte[] paramArrayOfbyte) {
/* 240 */     this.rawDataContainer.concatenate(paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] getRawData() {
/* 245 */     return this.rawDataContainer.toArray();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRawData(byte[] paramArrayOfbyte) {
/* 250 */     this.rawDataContainer.clear();
/* 251 */     this.rawDataContainer.concatenate(paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void decode() {
/* 259 */     if (null == this.escherRecords || 0 == this.escherRecords.size()) {
/* 260 */       byte[] arrayOfByte = getRawData();
/* 261 */       convertToEscherRecords(0, arrayOfByte.length, arrayOfByte);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected abstract String getRecordName();
/*     */   
/*     */   public abstract short getSid();
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\AbstractEscherHolderRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */