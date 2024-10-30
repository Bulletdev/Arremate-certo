/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class PageBreakRecord
/*     */   extends StandardRecord
/*     */ {
/*  40 */   private static final int[] EMPTY_INT_ARRAY = new int[0];
/*     */ 
/*     */   
/*     */   private List<Break> _breaks;
/*     */ 
/*     */   
/*     */   private Map<Integer, Break> _breakMap;
/*     */ 
/*     */   
/*     */   public static final class Break
/*     */   {
/*     */     public static final int ENCODED_SIZE = 6;
/*     */     
/*     */     public int main;
/*     */     
/*     */     public int subFrom;
/*     */     
/*     */     public int subTo;
/*     */ 
/*     */     
/*     */     public Break(int param1Int1, int param1Int2, int param1Int3) {
/*  61 */       this.main = param1Int1;
/*  62 */       this.subFrom = param1Int2;
/*  63 */       this.subTo = param1Int3;
/*     */     }
/*     */     
/*     */     public Break(RecordInputStream param1RecordInputStream) {
/*  67 */       this.main = param1RecordInputStream.readUShort() - 1;
/*  68 */       this.subFrom = param1RecordInputStream.readUShort();
/*  69 */       this.subTo = param1RecordInputStream.readUShort();
/*     */     }
/*     */     
/*     */     public void serialize(LittleEndianOutput param1LittleEndianOutput) {
/*  73 */       param1LittleEndianOutput.writeShort(this.main + 1);
/*  74 */       param1LittleEndianOutput.writeShort(this.subFrom);
/*  75 */       param1LittleEndianOutput.writeShort(this.subTo);
/*     */     }
/*     */   }
/*     */   
/*     */   protected PageBreakRecord() {
/*  80 */     this._breaks = new ArrayList<Break>();
/*  81 */     this._breakMap = new HashMap<Integer, Break>();
/*     */   }
/*     */ 
/*     */   
/*     */   public PageBreakRecord(RecordInputStream paramRecordInputStream) {
/*  86 */     short s = paramRecordInputStream.readShort();
/*  87 */     this._breaks = new ArrayList<Break>(s + 2);
/*  88 */     this._breakMap = new HashMap<Integer, Break>();
/*     */     
/*  90 */     for (byte b = 0; b < s; b++) {
/*  91 */       Break break_ = new Break(paramRecordInputStream);
/*  92 */       this._breaks.add(break_);
/*  93 */       this._breakMap.put(Integer.valueOf(break_.main), break_);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/*  99 */     return this._breaks.isEmpty();
/*     */   }
/*     */   protected int getDataSize() {
/* 102 */     return 2 + this._breaks.size() * 6;
/*     */   }
/*     */   
/*     */   public final void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 106 */     int i = this._breaks.size();
/* 107 */     paramLittleEndianOutput.writeShort(i);
/* 108 */     for (byte b = 0; b < i; b++) {
/* 109 */       ((Break)this._breaks.get(b)).serialize(paramLittleEndianOutput);
/*     */     }
/*     */   }
/*     */   
/*     */   public int getNumBreaks() {
/* 114 */     return this._breaks.size();
/*     */   }
/*     */   
/*     */   public final Iterator<Break> getBreaksIterator() {
/* 118 */     return this._breaks.iterator();
/*     */   }
/*     */   public String toString() {
/*     */     String str1, str2, str3;
/* 122 */     StringBuffer stringBuffer = new StringBuffer();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 128 */     if (getSid() == 27) {
/* 129 */       str1 = "HORIZONTALPAGEBREAK";
/* 130 */       str2 = "row";
/* 131 */       str3 = "col";
/*     */     } else {
/* 133 */       str1 = "VERTICALPAGEBREAK";
/* 134 */       str2 = "column";
/* 135 */       str3 = "row";
/*     */     } 
/*     */     
/* 138 */     stringBuffer.append("[" + str1 + "]").append("\n");
/* 139 */     stringBuffer.append("     .sid        =").append(getSid()).append("\n");
/* 140 */     stringBuffer.append("     .numbreaks =").append(getNumBreaks()).append("\n");
/* 141 */     Iterator<Break> iterator = getBreaksIterator();
/* 142 */     for (byte b = 0; b < getNumBreaks(); b++) {
/*     */       
/* 144 */       Break break_ = iterator.next();
/*     */       
/* 146 */       stringBuffer.append("     .").append(str2).append(" (zero-based) =").append(break_.main).append("\n");
/* 147 */       stringBuffer.append("     .").append(str3).append("From    =").append(break_.subFrom).append("\n");
/* 148 */       stringBuffer.append("     .").append(str3).append("To      =").append(break_.subTo).append("\n");
/*     */     } 
/*     */     
/* 151 */     stringBuffer.append("[" + str1 + "]").append("\n");
/* 152 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addBreak(int paramInt1, int paramInt2, int paramInt3) {
/* 163 */     Integer integer = Integer.valueOf(paramInt1);
/* 164 */     Break break_ = this._breakMap.get(integer);
/* 165 */     if (break_ == null) {
/* 166 */       break_ = new Break(paramInt1, paramInt2, paramInt3);
/* 167 */       this._breakMap.put(integer, break_);
/* 168 */       this._breaks.add(break_);
/*     */     } else {
/* 170 */       break_.main = paramInt1;
/* 171 */       break_.subFrom = paramInt2;
/* 172 */       break_.subTo = paramInt3;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void removeBreak(int paramInt) {
/* 181 */     Integer integer = Integer.valueOf(paramInt);
/* 182 */     Break break_ = this._breakMap.get(integer);
/* 183 */     this._breaks.remove(break_);
/* 184 */     this._breakMap.remove(integer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Break getBreak(int paramInt) {
/* 193 */     Integer integer = Integer.valueOf(paramInt);
/* 194 */     return this._breakMap.get(integer);
/*     */   }
/*     */   
/*     */   public final int[] getBreaks() {
/* 198 */     int i = getNumBreaks();
/* 199 */     if (i < 1) {
/* 200 */       return EMPTY_INT_ARRAY;
/*     */     }
/* 202 */     int[] arrayOfInt = new int[i];
/* 203 */     for (byte b = 0; b < i; b++) {
/* 204 */       Break break_ = this._breaks.get(b);
/* 205 */       arrayOfInt[b] = break_.main;
/*     */     } 
/* 207 */     return arrayOfInt;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\PageBreakRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */