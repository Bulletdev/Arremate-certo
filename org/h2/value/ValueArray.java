/*     */ package org.h2.value;
/*     */ 
/*     */ import java.lang.reflect.Array;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.util.ArrayList;
/*     */ import org.h2.util.MathUtils;
/*     */ import org.h2.util.New;
/*     */ import org.h2.util.StatementBuilder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ValueArray
/*     */   extends Value
/*     */ {
/*     */   private final Class<?> componentType;
/*     */   private final Value[] values;
/*     */   private int hash;
/*     */   
/*     */   private ValueArray(Class<?> paramClass, Value[] paramArrayOfValue) {
/*  26 */     this.componentType = paramClass;
/*  27 */     this.values = paramArrayOfValue;
/*     */   }
/*     */   
/*     */   private ValueArray(Value[] paramArrayOfValue) {
/*  31 */     this(Object.class, paramArrayOfValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ValueArray get(Value[] paramArrayOfValue) {
/*  42 */     return new ValueArray(paramArrayOfValue);
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
/*     */   public static ValueArray get(Class<?> paramClass, Value[] paramArrayOfValue) {
/*  54 */     return new ValueArray(paramClass, paramArrayOfValue);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  59 */     if (this.hash != 0) {
/*  60 */       return this.hash;
/*     */     }
/*  62 */     int i = 1;
/*  63 */     for (Value value : this.values) {
/*  64 */       i = i * 31 + value.hashCode();
/*     */     }
/*  66 */     this.hash = i;
/*  67 */     return i;
/*     */   }
/*     */   
/*     */   public Value[] getList() {
/*  71 */     return this.values;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/*  76 */     return 17;
/*     */   }
/*     */   
/*     */   public Class<?> getComponentType() {
/*  80 */     return this.componentType;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPrecision() {
/*  85 */     long l = 0L;
/*  86 */     for (Value value : this.values) {
/*  87 */       l += value.getPrecision();
/*     */     }
/*  89 */     return l;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getString() {
/*  94 */     StatementBuilder statementBuilder = new StatementBuilder("(");
/*  95 */     for (Value value : this.values) {
/*  96 */       statementBuilder.appendExceptFirst(", ");
/*  97 */       statementBuilder.append(value.getString());
/*     */     } 
/*  99 */     return statementBuilder.append(')').toString();
/*     */   }
/*     */ 
/*     */   
/*     */   protected int compareSecure(Value paramValue, CompareMode paramCompareMode) {
/* 104 */     ValueArray valueArray = (ValueArray)paramValue;
/* 105 */     if (this.values == valueArray.values) {
/* 106 */       return 0;
/*     */     }
/* 108 */     int i = this.values.length;
/* 109 */     int j = valueArray.values.length;
/* 110 */     int k = Math.min(i, j);
/* 111 */     for (byte b = 0; b < k; b++) {
/* 112 */       Value value1 = this.values[b];
/* 113 */       Value value2 = valueArray.values[b];
/* 114 */       int m = value1.compareTo(value2, paramCompareMode);
/* 115 */       if (m != 0) {
/* 116 */         return m;
/*     */       }
/*     */     } 
/* 119 */     return (i > j) ? 1 : ((i == j) ? 0 : -1);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getObject() {
/* 124 */     int i = this.values.length;
/* 125 */     Object[] arrayOfObject = (Object[])Array.newInstance(this.componentType, i);
/* 126 */     for (byte b = 0; b < i; b++) {
/* 127 */       arrayOfObject[b] = this.values[b].getObject();
/*     */     }
/* 129 */     return arrayOfObject;
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(PreparedStatement paramPreparedStatement, int paramInt) {
/* 134 */     throw throwUnsupportedExceptionForType("PreparedStatement.set");
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/* 139 */     StatementBuilder statementBuilder = new StatementBuilder("(");
/* 140 */     for (Value value : this.values) {
/* 141 */       statementBuilder.appendExceptFirst(", ");
/* 142 */       statementBuilder.append(value.getSQL());
/*     */     } 
/* 144 */     if (this.values.length == 1) {
/* 145 */       statementBuilder.append(',');
/*     */     }
/* 147 */     return statementBuilder.append(')').toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTraceSQL() {
/* 152 */     StatementBuilder statementBuilder = new StatementBuilder("(");
/* 153 */     for (Value value : this.values) {
/* 154 */       statementBuilder.appendExceptFirst(", ");
/* 155 */       statementBuilder.append((value == null) ? "null" : value.getTraceSQL());
/*     */     } 
/* 157 */     return statementBuilder.append(')').toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDisplaySize() {
/* 162 */     long l = 0L;
/* 163 */     for (Value value : this.values) {
/* 164 */       l += value.getDisplaySize();
/*     */     }
/* 166 */     return MathUtils.convertLongToInt(l);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 171 */     if (!(paramObject instanceof ValueArray)) {
/* 172 */       return false;
/*     */     }
/* 174 */     ValueArray valueArray = (ValueArray)paramObject;
/* 175 */     if (this.values == valueArray.values) {
/* 176 */       return true;
/*     */     }
/* 178 */     int i = this.values.length;
/* 179 */     if (i != valueArray.values.length) {
/* 180 */       return false;
/*     */     }
/* 182 */     for (byte b = 0; b < i; b++) {
/* 183 */       if (!this.values[b].equals(valueArray.values[b])) {
/* 184 */         return false;
/*     */       }
/*     */     } 
/* 187 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMemory() {
/* 192 */     int i = 32;
/* 193 */     for (Value value : this.values) {
/* 194 */       i += value.getMemory() + 8;
/*     */     }
/* 196 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public Value convertPrecision(long paramLong, boolean paramBoolean) {
/* 201 */     if (!paramBoolean) {
/* 202 */       return this;
/*     */     }
/* 204 */     ArrayList<Value> arrayList = New.arrayList();
/* 205 */     for (Value value : this.values) {
/* 206 */       value = value.convertPrecision(paramLong, true);
/*     */ 
/*     */       
/* 209 */       paramLong -= Math.max(1L, value.getPrecision());
/* 210 */       if (paramLong < 0L) {
/*     */         break;
/*     */       }
/* 213 */       arrayList.add(value);
/*     */     } 
/* 215 */     Value[] arrayOfValue = new Value[arrayList.size()];
/* 216 */     arrayList.toArray(arrayOfValue);
/* 217 */     return get(arrayOfValue);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\value\ValueArray.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */