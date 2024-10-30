/*     */ package org.h2.expression;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.value.Transfer;
/*     */ import org.h2.value.Value;
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
/*     */ public class ParameterRemote
/*     */   implements ParameterInterface
/*     */ {
/*     */   private Value value;
/*     */   private final int index;
/*  23 */   private int dataType = -1;
/*     */   private long precision;
/*     */   private int scale;
/*  26 */   private int nullable = 2;
/*     */   
/*     */   public ParameterRemote(int paramInt) {
/*  29 */     this.index = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValue(Value paramValue, boolean paramBoolean) {
/*  34 */     if (paramBoolean && this.value != null) {
/*  35 */       this.value.remove();
/*     */     }
/*  37 */     this.value = paramValue;
/*     */   }
/*     */ 
/*     */   
/*     */   public Value getParamValue() {
/*  42 */     return this.value;
/*     */   }
/*     */ 
/*     */   
/*     */   public void checkSet() {
/*  47 */     if (this.value == null) {
/*  48 */       throw DbException.get(90012, "#" + (this.index + 1));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isValueSet() {
/*  54 */     return (this.value != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/*  59 */     return (this.value == null) ? this.dataType : this.value.getType();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPrecision() {
/*  64 */     return (this.value == null) ? this.precision : this.value.getPrecision();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getScale() {
/*  69 */     return (this.value == null) ? this.scale : this.value.getScale();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNullable() {
/*  74 */     return this.nullable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readMetaData(Transfer paramTransfer) throws IOException {
/*  83 */     this.dataType = paramTransfer.readInt();
/*  84 */     this.precision = paramTransfer.readLong();
/*  85 */     this.scale = paramTransfer.readInt();
/*  86 */     this.nullable = paramTransfer.readInt();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void writeMetaData(Transfer paramTransfer, ParameterInterface paramParameterInterface) throws IOException {
/*  97 */     paramTransfer.writeInt(paramParameterInterface.getType());
/*  98 */     paramTransfer.writeLong(paramParameterInterface.getPrecision());
/*  99 */     paramTransfer.writeInt(paramParameterInterface.getScale());
/* 100 */     paramTransfer.writeInt(paramParameterInterface.getNullable());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\expression\ParameterRemote.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */