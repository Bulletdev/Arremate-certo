/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import org.apache.poi.ss.formula.Formula;
/*     */ import org.apache.poi.ss.formula.ptg.Ptg;
/*     */ import org.apache.poi.ss.usermodel.CellType;
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
/*     */ public final class OldFormulaRecord
/*     */   extends OldCellRecord
/*     */ {
/*     */   public static final short biff2_sid = 6;
/*     */   public static final short biff3_sid = 518;
/*     */   public static final short biff4_sid = 1030;
/*     */   public static final short biff5_sid = 6;
/*     */   private FormulaRecord.SpecialCachedValue specialCachedValue;
/*     */   private double field_4_value;
/*     */   private short field_5_options;
/*     */   private Formula field_6_parsed_expr;
/*     */   
/*     */   public OldFormulaRecord(RecordInputStream paramRecordInputStream) {
/*  41 */     super(paramRecordInputStream, (paramRecordInputStream.getSid() == 6));
/*     */     
/*  43 */     if (isBiff2()) {
/*  44 */       this.field_4_value = paramRecordInputStream.readDouble();
/*     */     } else {
/*  46 */       long l = paramRecordInputStream.readLong();
/*  47 */       this.specialCachedValue = FormulaRecord.SpecialCachedValue.create(l);
/*  48 */       if (this.specialCachedValue == null) {
/*  49 */         this.field_4_value = Double.longBitsToDouble(l);
/*     */       }
/*     */     } 
/*     */     
/*  53 */     if (isBiff2()) {
/*  54 */       this.field_5_options = (short)paramRecordInputStream.readUByte();
/*     */     } else {
/*  56 */       this.field_5_options = paramRecordInputStream.readShort();
/*     */     } 
/*     */     
/*  59 */     short s = paramRecordInputStream.readShort();
/*  60 */     int i = paramRecordInputStream.available();
/*  61 */     this.field_6_parsed_expr = Formula.read(s, paramRecordInputStream, i);
/*     */   }
/*     */   
/*     */   public int getCachedResultType() {
/*  65 */     if (this.specialCachedValue == null) {
/*  66 */       return CellType.NUMERIC.getCode();
/*     */     }
/*  68 */     return this.specialCachedValue.getValueType();
/*     */   }
/*     */   
/*     */   public boolean getCachedBooleanValue() {
/*  72 */     return this.specialCachedValue.getBooleanValue();
/*     */   }
/*     */   public int getCachedErrorValue() {
/*  75 */     return this.specialCachedValue.getErrorValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getValue() {
/*  84 */     return this.field_4_value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getOptions() {
/*  93 */     return this.field_5_options;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ptg[] getParsedExpression() {
/* 100 */     return this.field_6_parsed_expr.getTokens();
/*     */   }
/*     */   
/*     */   public Formula getFormula() {
/* 104 */     return this.field_6_parsed_expr;
/*     */   }
/*     */   
/*     */   protected void appendValueText(StringBuilder paramStringBuilder) {
/* 108 */     paramStringBuilder.append("    .value       = ").append(getValue()).append("\n");
/*     */   }
/*     */   protected String getRecordName() {
/* 111 */     return "Old Formula";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\OldFormulaRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */