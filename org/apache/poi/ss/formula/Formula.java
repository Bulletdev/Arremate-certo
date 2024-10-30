/*     */ package org.apache.poi.ss.formula;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import org.apache.poi.ss.formula.ptg.Ptg;
/*     */ import org.apache.poi.ss.util.CellReference;
/*     */ import org.apache.poi.util.LittleEndian;
/*     */ import org.apache.poi.util.LittleEndianByteArrayInputStream;
/*     */ import org.apache.poi.util.LittleEndianInput;
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
/*     */ public class Formula
/*     */ {
/*  38 */   private static final Formula EMPTY = new Formula(new byte[0], 0);
/*     */   
/*     */   private final byte[] _byteEncoding;
/*     */   
/*     */   private final int _encodedTokenLen;
/*     */   
/*     */   private Formula(byte[] paramArrayOfbyte, int paramInt) {
/*  45 */     this._byteEncoding = (byte[])paramArrayOfbyte.clone();
/*  46 */     this._encodedTokenLen = paramInt;
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
/*     */   public static Formula read(int paramInt, LittleEndianInput paramLittleEndianInput) {
/*  65 */     return read(paramInt, paramLittleEndianInput, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Formula read(int paramInt1, LittleEndianInput paramLittleEndianInput, int paramInt2) {
/*  75 */     byte[] arrayOfByte = new byte[paramInt2];
/*  76 */     paramLittleEndianInput.readFully(arrayOfByte);
/*  77 */     return new Formula(arrayOfByte, paramInt1);
/*     */   }
/*     */   
/*     */   public Ptg[] getTokens() {
/*  81 */     LittleEndianByteArrayInputStream littleEndianByteArrayInputStream = new LittleEndianByteArrayInputStream(this._byteEncoding);
/*  82 */     return Ptg.readTokens(this._encodedTokenLen, (LittleEndianInput)littleEndianByteArrayInputStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  93 */     paramLittleEndianOutput.writeShort(this._encodedTokenLen);
/*  94 */     paramLittleEndianOutput.write(this._byteEncoding);
/*     */   }
/*     */   
/*     */   public void serializeTokens(LittleEndianOutput paramLittleEndianOutput) {
/*  98 */     paramLittleEndianOutput.write(this._byteEncoding, 0, this._encodedTokenLen);
/*     */   }
/*     */   public void serializeArrayConstantData(LittleEndianOutput paramLittleEndianOutput) {
/* 101 */     int i = this._byteEncoding.length - this._encodedTokenLen;
/* 102 */     paramLittleEndianOutput.write(this._byteEncoding, this._encodedTokenLen, i);
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
/*     */   public int getEncodedSize() {
/* 116 */     return 2 + this._byteEncoding.length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getEncodedTokenSize() {
/* 126 */     return this._encodedTokenLen;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Formula create(Ptg[] paramArrayOfPtg) {
/* 136 */     if (paramArrayOfPtg == null || paramArrayOfPtg.length < 1) {
/* 137 */       return EMPTY;
/*     */     }
/* 139 */     int i = Ptg.getEncodedSize(paramArrayOfPtg);
/* 140 */     byte[] arrayOfByte = new byte[i];
/* 141 */     Ptg.serializePtgs(paramArrayOfPtg, arrayOfByte, 0);
/* 142 */     int j = Ptg.getEncodedSizeWithoutArrayData(paramArrayOfPtg);
/* 143 */     return new Formula(arrayOfByte, j);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Ptg[] getTokens(Formula paramFormula) {
/* 153 */     if (paramFormula == null) {
/* 154 */       return null;
/*     */     }
/* 156 */     return paramFormula.getTokens();
/*     */   }
/*     */ 
/*     */   
/*     */   public Formula copy() {
/* 161 */     return this;
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
/*     */   public CellReference getExpReference() {
/*     */     int i, j;
/* 175 */     byte[] arrayOfByte = this._byteEncoding;
/* 176 */     if (arrayOfByte.length != 5)
/*     */     {
/* 178 */       return null;
/*     */     }
/* 180 */     switch (arrayOfByte[0]) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 1:
/*     */       case 2:
/* 188 */         i = LittleEndian.getUShort(arrayOfByte, 1);
/* 189 */         j = LittleEndian.getUShort(arrayOfByte, 3);
/* 190 */         return new CellReference(i, j);
/*     */     } 
/*     */     return null; } public boolean isSame(Formula paramFormula) {
/* 193 */     return Arrays.equals(this._byteEncoding, paramFormula._byteEncoding);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\Formula.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */