/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ExternSheetRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 23;
/*     */   private final List<RefSubRecord> _list;
/*     */   
/*     */   private static final class RefSubRecord
/*     */   {
/*     */     public static final int ENCODED_SIZE = 6;
/*     */     private final int _extBookIndex;
/*     */     private int _firstSheetIndex;
/*     */     private int _lastSheetIndex;
/*     */     
/*     */     public void adjustIndex(int param1Int) {
/*  43 */       this._firstSheetIndex += param1Int;
/*  44 */       this._lastSheetIndex += param1Int;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public RefSubRecord(int param1Int1, int param1Int2, int param1Int3) {
/*  50 */       this._extBookIndex = param1Int1;
/*  51 */       this._firstSheetIndex = param1Int2;
/*  52 */       this._lastSheetIndex = param1Int3;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public RefSubRecord(RecordInputStream param1RecordInputStream) {
/*  59 */       this(param1RecordInputStream.readShort(), param1RecordInputStream.readShort(), param1RecordInputStream.readShort());
/*     */     }
/*     */     public int getExtBookIndex() {
/*  62 */       return this._extBookIndex;
/*     */     }
/*     */     public int getFirstSheetIndex() {
/*  65 */       return this._firstSheetIndex;
/*     */     }
/*     */     public int getLastSheetIndex() {
/*  68 */       return this._lastSheetIndex;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/*  73 */       StringBuffer stringBuffer = new StringBuffer();
/*  74 */       stringBuffer.append("extBook=").append(this._extBookIndex);
/*  75 */       stringBuffer.append(" firstSheet=").append(this._firstSheetIndex);
/*  76 */       stringBuffer.append(" lastSheet=").append(this._lastSheetIndex);
/*  77 */       return stringBuffer.toString();
/*     */     }
/*     */     
/*     */     public void serialize(LittleEndianOutput param1LittleEndianOutput) {
/*  81 */       param1LittleEndianOutput.writeShort(this._extBookIndex);
/*  82 */       param1LittleEndianOutput.writeShort(this._firstSheetIndex);
/*  83 */       param1LittleEndianOutput.writeShort(this._lastSheetIndex);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ExternSheetRecord() {
/*  90 */     this._list = new ArrayList<RefSubRecord>();
/*     */   }
/*     */   
/*     */   public ExternSheetRecord(RecordInputStream paramRecordInputStream) {
/*  94 */     this._list = new ArrayList<RefSubRecord>();
/*     */     
/*  96 */     short s = paramRecordInputStream.readShort();
/*     */     
/*  98 */     for (byte b = 0; b < s; b++) {
/*  99 */       RefSubRecord refSubRecord = new RefSubRecord(paramRecordInputStream);
/* 100 */       this._list.add(refSubRecord);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumOfRefs() {
/* 109 */     return this._list.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addREFRecord(RefSubRecord paramRefSubRecord) {
/* 117 */     this._list.add(paramRefSubRecord);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumOfREFRecords() {
/* 124 */     return this._list.size();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 130 */     StringBuffer stringBuffer = new StringBuffer();
/* 131 */     int i = this._list.size();
/* 132 */     stringBuffer.append("[EXTERNSHEET]\n");
/* 133 */     stringBuffer.append("   numOfRefs     = ").append(i).append("\n");
/* 134 */     for (byte b = 0; b < i; b++) {
/* 135 */       stringBuffer.append("refrec         #").append(b).append(": ");
/* 136 */       stringBuffer.append(getRef(b).toString());
/* 137 */       stringBuffer.append('\n');
/*     */     } 
/* 139 */     stringBuffer.append("[/EXTERNSHEET]\n");
/*     */ 
/*     */     
/* 142 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getDataSize() {
/* 147 */     return 2 + this._list.size() * 6;
/*     */   }
/*     */ 
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 152 */     int i = this._list.size();
/*     */     
/* 154 */     paramLittleEndianOutput.writeShort(i);
/*     */     
/* 156 */     for (byte b = 0; b < i; b++) {
/* 157 */       getRef(b).serialize(paramLittleEndianOutput);
/*     */     }
/*     */   }
/*     */   
/*     */   private RefSubRecord getRef(int paramInt) {
/* 162 */     return this._list.get(paramInt);
/*     */   }
/*     */   
/*     */   public void removeSheet(int paramInt) {
/* 166 */     int i = this._list.size();
/* 167 */     for (byte b = 0; b < i; b++) {
/* 168 */       RefSubRecord refSubRecord = this._list.get(b);
/* 169 */       if (refSubRecord.getFirstSheetIndex() == paramInt && refSubRecord.getLastSheetIndex() == paramInt) {
/*     */ 
/*     */         
/* 172 */         this._list.set(b, new RefSubRecord(refSubRecord.getExtBookIndex(), -1, -1));
/* 173 */       } else if (refSubRecord.getFirstSheetIndex() > paramInt && refSubRecord.getLastSheetIndex() > paramInt) {
/*     */         
/* 175 */         this._list.set(b, new RefSubRecord(refSubRecord.getExtBookIndex(), refSubRecord.getFirstSheetIndex() - 1, refSubRecord.getLastSheetIndex() - 1));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 185 */     return 23;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getExtbookIndexFromRefIndex(int paramInt) {
/* 194 */     RefSubRecord refSubRecord = getRef(paramInt);
/* 195 */     return refSubRecord.getExtBookIndex();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int findRefIndexFromExtBookIndex(int paramInt) {
/* 204 */     int i = this._list.size();
/* 205 */     for (byte b = 0; b < i; b++) {
/* 206 */       if (getRef(b).getExtBookIndex() == paramInt) {
/* 207 */         return b;
/*     */       }
/*     */     } 
/* 210 */     return -1;
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
/*     */   public int getFirstSheetIndexFromRefIndex(int paramInt) {
/* 225 */     return getRef(paramInt).getFirstSheetIndex();
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
/*     */   public int getLastSheetIndexFromRefIndex(int paramInt) {
/* 242 */     return getRef(paramInt).getLastSheetIndex();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int addRef(int paramInt1, int paramInt2, int paramInt3) {
/* 275 */     this._list.add(new RefSubRecord(paramInt1, paramInt2, paramInt3));
/* 276 */     return this._list.size() - 1;
/*     */   }
/*     */   
/*     */   public int getRefIxForSheet(int paramInt1, int paramInt2, int paramInt3) {
/* 280 */     int i = this._list.size();
/* 281 */     for (byte b = 0; b < i; b++) {
/* 282 */       RefSubRecord refSubRecord = getRef(b);
/* 283 */       if (refSubRecord.getExtBookIndex() == paramInt1)
/*     */       {
/*     */         
/* 286 */         if (refSubRecord.getFirstSheetIndex() == paramInt2 && refSubRecord.getLastSheetIndex() == paramInt3)
/*     */         {
/* 288 */           return b; } 
/*     */       }
/*     */     } 
/* 291 */     return -1;
/*     */   }
/*     */   
/*     */   public static ExternSheetRecord combine(ExternSheetRecord[] paramArrayOfExternSheetRecord) {
/* 295 */     ExternSheetRecord externSheetRecord = new ExternSheetRecord();
/* 296 */     for (ExternSheetRecord externSheetRecord1 : paramArrayOfExternSheetRecord) {
/* 297 */       int i = externSheetRecord1.getNumOfREFRecords();
/* 298 */       for (byte b = 0; b < i; b++) {
/* 299 */         externSheetRecord.addREFRecord(externSheetRecord1.getRef(b));
/*     */       }
/*     */     } 
/* 302 */     return externSheetRecord;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\ExternSheetRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */