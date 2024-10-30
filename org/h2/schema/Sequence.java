/*     */ package org.h2.schema;
/*     */ 
/*     */ import java.math.BigInteger;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.table.Table;
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
/*     */ public class Sequence
/*     */   extends SchemaObjectBase
/*     */ {
/*     */   public static final int DEFAULT_CACHE_SIZE = 32;
/*     */   private long value;
/*     */   private long valueWithMargin;
/*     */   private long increment;
/*     */   private long cacheSize;
/*     */   private long minValue;
/*     */   private long maxValue;
/*     */   private boolean cycle;
/*     */   private boolean belongsToTable;
/*  36 */   private Object flushSync = new Object();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean writeWithMargin;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Sequence(Schema paramSchema, int paramInt, String paramString, long paramLong1, long paramLong2) {
/*  50 */     this(paramSchema, paramInt, paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), (Long)null, (Long)null, (Long)null, false, true);
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
/*     */   public Sequence(Schema paramSchema, int paramInt, String paramString, Long paramLong1, Long paramLong2, Long paramLong3, Long paramLong4, Long paramLong5, boolean paramBoolean1, boolean paramBoolean2) {
/*  72 */     initSchemaObjectBase(paramSchema, paramInt, paramString, 9);
/*  73 */     this.increment = (paramLong2 != null) ? paramLong2.longValue() : 1L;
/*     */     
/*  75 */     this.minValue = (paramLong4 != null) ? paramLong4.longValue() : getDefaultMinValue(paramLong1, this.increment);
/*     */     
/*  77 */     this.maxValue = (paramLong5 != null) ? paramLong5.longValue() : getDefaultMaxValue(paramLong1, this.increment);
/*     */     
/*  79 */     this.value = (paramLong1 != null) ? paramLong1.longValue() : getDefaultStartValue(this.increment);
/*     */     
/*  81 */     this.valueWithMargin = this.value;
/*  82 */     this.cacheSize = (paramLong3 != null) ? Math.max(1L, paramLong3.longValue()) : 32L;
/*     */     
/*  84 */     this.cycle = paramBoolean1;
/*  85 */     this.belongsToTable = paramBoolean2;
/*  86 */     if (!isValid(this.value, this.minValue, this.maxValue, this.increment)) {
/*  87 */       throw DbException.get(90009, new String[] { paramString, String.valueOf(this.value), String.valueOf(this.minValue), String.valueOf(this.maxValue), String.valueOf(this.increment) });
/*     */     }
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
/*     */   public synchronized void modify(Long paramLong1, Long paramLong2, Long paramLong3, Long paramLong4) {
/* 108 */     if (paramLong1 == null) {
/* 109 */       paramLong1 = Long.valueOf(this.value);
/*     */     }
/* 111 */     if (paramLong2 == null) {
/* 112 */       paramLong2 = Long.valueOf(this.minValue);
/*     */     }
/* 114 */     if (paramLong3 == null) {
/* 115 */       paramLong3 = Long.valueOf(this.maxValue);
/*     */     }
/* 117 */     if (paramLong4 == null) {
/* 118 */       paramLong4 = Long.valueOf(this.increment);
/*     */     }
/* 120 */     if (!isValid(paramLong1.longValue(), paramLong2.longValue(), paramLong3.longValue(), paramLong4.longValue())) {
/* 121 */       throw DbException.get(90009, new String[] { getName(), String.valueOf(paramLong1), String.valueOf(paramLong2), String.valueOf(paramLong3), String.valueOf(paramLong4) });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 127 */     this.value = paramLong1.longValue();
/* 128 */     this.valueWithMargin = paramLong1.longValue();
/* 129 */     this.minValue = paramLong2.longValue();
/* 130 */     this.maxValue = paramLong3.longValue();
/* 131 */     this.increment = paramLong4.longValue();
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
/*     */   private static boolean isValid(long paramLong1, long paramLong2, long paramLong3, long paramLong4) {
/* 146 */     return (paramLong2 <= paramLong1 && paramLong3 >= paramLong1 && paramLong3 > paramLong2 && paramLong4 != 0L && BigInteger.valueOf(paramLong4).abs().compareTo(BigInteger.valueOf(paramLong3).subtract(BigInteger.valueOf(paramLong2))) < 0);
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
/*     */   private static long getDefaultMinValue(Long paramLong, long paramLong1) {
/* 158 */     long l = (paramLong1 >= 0L) ? 1L : Long.MIN_VALUE;
/* 159 */     if (paramLong != null && paramLong1 >= 0L && paramLong.longValue() < l) {
/* 160 */       l = paramLong.longValue();
/*     */     }
/* 162 */     return l;
/*     */   }
/*     */   
/*     */   private static long getDefaultMaxValue(Long paramLong, long paramLong1) {
/* 166 */     long l = (paramLong1 >= 0L) ? Long.MAX_VALUE : -1L;
/* 167 */     if (paramLong != null && paramLong1 < 0L && paramLong.longValue() > l) {
/* 168 */       l = paramLong.longValue();
/*     */     }
/* 170 */     return l;
/*     */   }
/*     */   
/*     */   private long getDefaultStartValue(long paramLong) {
/* 174 */     return (paramLong >= 0L) ? this.minValue : this.maxValue;
/*     */   }
/*     */   
/*     */   public boolean getBelongsToTable() {
/* 178 */     return this.belongsToTable;
/*     */   }
/*     */   
/*     */   public long getIncrement() {
/* 182 */     return this.increment;
/*     */   }
/*     */   
/*     */   public long getMinValue() {
/* 186 */     return this.minValue;
/*     */   }
/*     */   
/*     */   public long getMaxValue() {
/* 190 */     return this.maxValue;
/*     */   }
/*     */   
/*     */   public boolean getCycle() {
/* 194 */     return this.cycle;
/*     */   }
/*     */   
/*     */   public void setCycle(boolean paramBoolean) {
/* 198 */     this.cycle = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDropSQL() {
/* 203 */     if (getBelongsToTable()) {
/* 204 */       return null;
/*     */     }
/* 206 */     return "DROP SEQUENCE IF EXISTS " + getSQL();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateSQLForCopy(Table paramTable, String paramString) {
/* 211 */     throw DbException.throwInternalError();
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized String getCreateSQL() {
/* 216 */     long l = this.writeWithMargin ? this.valueWithMargin : this.value;
/* 217 */     StringBuilder stringBuilder = new StringBuilder("CREATE SEQUENCE ");
/* 218 */     stringBuilder.append(getSQL()).append(" START WITH ").append(l);
/* 219 */     if (this.increment != 1L) {
/* 220 */       stringBuilder.append(" INCREMENT BY ").append(this.increment);
/*     */     }
/* 222 */     if (this.minValue != getDefaultMinValue(Long.valueOf(l), this.increment)) {
/* 223 */       stringBuilder.append(" MINVALUE ").append(this.minValue);
/*     */     }
/* 225 */     if (this.maxValue != getDefaultMaxValue(Long.valueOf(l), this.increment)) {
/* 226 */       stringBuilder.append(" MAXVALUE ").append(this.maxValue);
/*     */     }
/* 228 */     if (this.cycle) {
/* 229 */       stringBuilder.append(" CYCLE");
/*     */     }
/* 231 */     if (this.cacheSize != 32L) {
/* 232 */       stringBuilder.append(" CACHE ").append(this.cacheSize);
/*     */     }
/* 234 */     if (this.belongsToTable) {
/* 235 */       stringBuilder.append(" BELONGS_TO_TABLE");
/*     */     }
/* 237 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getNext(Session paramSession) {
/*     */     long l;
/* 247 */     boolean bool = false;
/*     */     
/* 249 */     synchronized (this) {
/* 250 */       if ((this.increment > 0L && this.value >= this.valueWithMargin) || (this.increment < 0L && this.value <= this.valueWithMargin)) {
/*     */         
/* 252 */         this.valueWithMargin += this.increment * this.cacheSize;
/* 253 */         bool = true;
/*     */       } 
/* 255 */       if ((this.increment > 0L && this.value > this.maxValue) || (this.increment < 0L && this.value < this.minValue))
/*     */       {
/* 257 */         if (this.cycle) {
/* 258 */           this.value = (this.increment > 0L) ? this.minValue : this.maxValue;
/* 259 */           this.valueWithMargin = this.value + this.increment * this.cacheSize;
/* 260 */           bool = true;
/*     */         } else {
/* 262 */           throw DbException.get(90006, getName());
/*     */         } 
/*     */       }
/* 265 */       l = this.value;
/* 266 */       this.value += this.increment;
/*     */     } 
/* 268 */     if (bool) {
/* 269 */       flush(paramSession);
/*     */     }
/* 271 */     return l;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void flushWithoutMargin() {
/* 278 */     if (this.valueWithMargin != this.value) {
/* 279 */       this.valueWithMargin = this.value;
/* 280 */       flush((Session)null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void flush(Session paramSession) {
/* 290 */     if (isTemporary()) {
/*     */       return;
/*     */     }
/* 293 */     if (paramSession == null || !this.database.isSysTableLockedBy(paramSession)) {
/*     */ 
/*     */ 
/*     */       
/* 297 */       Session session = this.database.getSystemSession();
/* 298 */       synchronized (session) {
/* 299 */         synchronized (this.flushSync) {
/* 300 */           flushInternal(session);
/*     */         } 
/* 302 */         session.commit(false);
/*     */       } 
/*     */     } else {
/* 305 */       synchronized (paramSession) {
/* 306 */         synchronized (this.flushSync) {
/* 307 */           flushInternal(paramSession);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void flushInternal(Session paramSession) {
/* 314 */     boolean bool = this.database.lockMeta(paramSession);
/*     */     
/*     */     try {
/* 317 */       this.writeWithMargin = true;
/* 318 */       this.database.updateMeta(paramSession, this);
/*     */     } finally {
/* 320 */       this.writeWithMargin = false;
/*     */     } 
/* 322 */     if (!bool) {
/* 323 */       this.database.unlockMeta(paramSession);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/* 331 */     flushWithoutMargin();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 336 */     return 3;
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeChildrenAndResources(Session paramSession) {
/* 341 */     this.database.removeMeta(paramSession, getId());
/* 342 */     invalidate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkRename() {}
/*     */ 
/*     */   
/*     */   public synchronized long getCurrentValue() {
/* 351 */     return this.value - this.increment;
/*     */   }
/*     */   
/*     */   public void setBelongsToTable(boolean paramBoolean) {
/* 355 */     this.belongsToTable = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setCacheSize(long paramLong) {
/* 359 */     this.cacheSize = Math.max(1L, paramLong);
/*     */   }
/*     */   
/*     */   public long getCacheSize() {
/* 363 */     return this.cacheSize;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\schema\Sequence.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */