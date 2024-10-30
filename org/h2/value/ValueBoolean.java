/*     */ package org.h2.value;
/*     */ 
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.SQLException;
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
/*     */ public class ValueBoolean
/*     */   extends Value
/*     */ {
/*     */   public static final int PRECISION = 1;
/*     */   public static final int DISPLAY_SIZE = 5;
/*  30 */   private static final Object TRUE = new ValueBoolean(true);
/*  31 */   private static final Object FALSE = new ValueBoolean(false);
/*     */   
/*     */   private final Boolean value;
/*     */   
/*     */   private ValueBoolean(boolean paramBoolean) {
/*  36 */     this.value = Boolean.valueOf(paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/*  41 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/*  46 */     return getString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getString() {
/*  51 */     return this.value.booleanValue() ? "TRUE" : "FALSE";
/*     */   }
/*     */ 
/*     */   
/*     */   public Value negate() {
/*  56 */     return this.value.booleanValue() ? (ValueBoolean)FALSE : (ValueBoolean)TRUE;
/*     */   }
/*     */ 
/*     */   
/*     */   public Boolean getBoolean() {
/*  61 */     return this.value;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int compareSecure(Value paramValue, CompareMode paramCompareMode) {
/*  66 */     boolean bool1 = ((ValueBoolean)paramValue).value.booleanValue();
/*  67 */     boolean bool2 = this.value.booleanValue();
/*  68 */     return (bool2 == bool1) ? 0 : (bool2 ? 1 : -1);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPrecision() {
/*  73 */     return 1L;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  78 */     return this.value.booleanValue() ? 1 : 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getObject() {
/*  83 */     return this.value;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(PreparedStatement paramPreparedStatement, int paramInt) throws SQLException {
/*  89 */     paramPreparedStatement.setBoolean(paramInt, this.value.booleanValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ValueBoolean get(boolean paramBoolean) {
/*  99 */     return paramBoolean ? (ValueBoolean)TRUE : (ValueBoolean)FALSE;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDisplaySize() {
/* 104 */     return 5;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 110 */     return (this == paramObject);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\value\ValueBoolean.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */