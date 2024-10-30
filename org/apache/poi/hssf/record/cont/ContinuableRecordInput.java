/*     */ package org.apache.poi.hssf.record.cont;
/*     */ 
/*     */ import org.apache.poi.hssf.record.RecordInputStream;
/*     */ import org.apache.poi.util.LittleEndianInput;
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
/*     */ public class ContinuableRecordInput
/*     */   implements LittleEndianInput
/*     */ {
/*     */   private final RecordInputStream _in;
/*     */   
/*     */   public ContinuableRecordInput(RecordInputStream paramRecordInputStream) {
/*  55 */     this._in = paramRecordInputStream;
/*     */   }
/*     */   public int available() {
/*  58 */     return this._in.available();
/*     */   }
/*     */   
/*     */   public byte readByte() {
/*  62 */     return this._in.readByte();
/*     */   }
/*     */   
/*     */   public int readUByte() {
/*  66 */     return this._in.readUByte();
/*     */   }
/*     */   
/*     */   public short readShort() {
/*  70 */     return this._in.readShort();
/*     */   }
/*     */   
/*     */   public int readUShort() {
/*  74 */     int i = readUByte();
/*  75 */     int j = readUByte();
/*  76 */     return (j << 8) + (i << 0);
/*     */   }
/*     */   
/*     */   public int readInt() {
/*  80 */     int i = this._in.readUByte();
/*  81 */     int j = this._in.readUByte();
/*  82 */     int k = this._in.readUByte();
/*  83 */     int m = this._in.readUByte();
/*  84 */     return (m << 24) + (k << 16) + (j << 8) + (i << 0);
/*     */   }
/*     */   
/*     */   public long readLong() {
/*  88 */     int i = this._in.readUByte();
/*  89 */     int j = this._in.readUByte();
/*  90 */     int k = this._in.readUByte();
/*  91 */     int m = this._in.readUByte();
/*  92 */     int n = this._in.readUByte();
/*  93 */     int i1 = this._in.readUByte();
/*  94 */     int i2 = this._in.readUByte();
/*  95 */     int i3 = this._in.readUByte();
/*  96 */     return (i3 << 56L) + (i2 << 48L) + (i1 << 40L) + (n << 32L) + (m << 24L) + (k << 16) + (j << 8) + (i << 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double readDouble() {
/* 107 */     return this._in.readDouble();
/*     */   }
/*     */   public void readFully(byte[] paramArrayOfbyte) {
/* 110 */     this._in.readFully(paramArrayOfbyte);
/*     */   }
/*     */   public void readFully(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 113 */     this._in.readFully(paramArrayOfbyte, paramInt1, paramInt2);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\cont\ContinuableRecordInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */