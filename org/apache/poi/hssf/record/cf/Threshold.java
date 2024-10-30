/*     */ package org.apache.poi.hssf.record.cf;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import org.apache.poi.ss.formula.Formula;
/*     */ import org.apache.poi.ss.formula.ptg.Ptg;
/*     */ import org.apache.poi.ss.usermodel.ConditionalFormattingThreshold;
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
/*     */ public abstract class Threshold
/*     */ {
/*     */   private byte type;
/*     */   private Formula formula;
/*     */   private Double value;
/*     */   
/*     */   protected Threshold() {
/*  37 */     this.type = (byte)ConditionalFormattingThreshold.RangeType.NUMBER.id;
/*  38 */     this.formula = Formula.create(null);
/*  39 */     this.value = Double.valueOf(0.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Threshold(LittleEndianInput paramLittleEndianInput) {
/*  44 */     this.type = paramLittleEndianInput.readByte();
/*  45 */     short s = paramLittleEndianInput.readShort();
/*  46 */     if (s > 0) {
/*  47 */       this.formula = Formula.read(s, paramLittleEndianInput);
/*     */     } else {
/*  49 */       this.formula = Formula.create(null);
/*     */     } 
/*     */     
/*  52 */     if (s == 0 && this.type != ConditionalFormattingThreshold.RangeType.MIN.id && this.type != ConditionalFormattingThreshold.RangeType.MAX.id)
/*     */     {
/*  54 */       this.value = Double.valueOf(paramLittleEndianInput.readDouble());
/*     */     }
/*     */   }
/*     */   
/*     */   public byte getType() {
/*  59 */     return this.type;
/*     */   }
/*     */   public void setType(byte paramByte) {
/*  62 */     this.type = paramByte;
/*     */ 
/*     */     
/*  65 */     if (paramByte == ConditionalFormattingThreshold.RangeType.MIN.id || paramByte == ConditionalFormattingThreshold.RangeType.MAX.id || paramByte == ConditionalFormattingThreshold.RangeType.FORMULA.id) {
/*     */       
/*  67 */       this.value = null;
/*  68 */     } else if (this.value == null) {
/*  69 */       this.value = Double.valueOf(0.0D);
/*     */     } 
/*     */   }
/*     */   public void setType(int paramInt) {
/*  73 */     this.type = (byte)paramInt;
/*     */   }
/*     */   
/*     */   protected Formula getFormula() {
/*  77 */     return this.formula;
/*     */   }
/*     */   public Ptg[] getParsedExpression() {
/*  80 */     return this.formula.getTokens();
/*     */   }
/*     */   public void setParsedExpression(Ptg[] paramArrayOfPtg) {
/*  83 */     this.formula = Formula.create(paramArrayOfPtg);
/*  84 */     if (paramArrayOfPtg.length > 0) {
/*  85 */       this.value = null;
/*     */     }
/*     */   }
/*     */   
/*     */   public Double getValue() {
/*  90 */     return this.value;
/*     */   }
/*     */   public void setValue(Double paramDouble) {
/*  93 */     this.value = paramDouble;
/*     */   }
/*     */   
/*     */   public int getDataLength() {
/*  97 */     int i = 1 + this.formula.getEncodedSize();
/*  98 */     if (this.value != null) {
/*  99 */       i += 8;
/*     */     }
/* 101 */     return i;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 105 */     StringBuffer stringBuffer = new StringBuffer();
/* 106 */     stringBuffer.append("    [CF Threshold]\n");
/* 107 */     stringBuffer.append("          .type    = ").append(Integer.toHexString(this.type)).append("\n");
/* 108 */     stringBuffer.append("          .formula = ").append(Arrays.toString((Object[])this.formula.getTokens())).append("\n");
/* 109 */     stringBuffer.append("          .value   = ").append(this.value).append("\n");
/* 110 */     stringBuffer.append("    [/CF Threshold]\n");
/* 111 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void copyTo(Threshold paramThreshold) {
/* 115 */     paramThreshold.type = this.type;
/* 116 */     paramThreshold.formula = this.formula;
/* 117 */     paramThreshold.value = this.value;
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 121 */     paramLittleEndianOutput.writeByte(this.type);
/* 122 */     if ((this.formula.getTokens()).length == 0) {
/* 123 */       paramLittleEndianOutput.writeShort(0);
/*     */     } else {
/* 125 */       this.formula.serialize(paramLittleEndianOutput);
/*     */     } 
/* 127 */     if (this.value != null)
/* 128 */       paramLittleEndianOutput.writeDouble(this.value.doubleValue()); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\cf\Threshold.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */