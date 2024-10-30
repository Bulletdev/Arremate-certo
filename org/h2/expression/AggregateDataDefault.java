/*     */ package org.h2.expression;
/*     */ 
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.util.ValueHashMap;
/*     */ import org.h2.value.DataType;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueBoolean;
/*     */ import org.h2.value.ValueDouble;
/*     */ import org.h2.value.ValueLong;
/*     */ import org.h2.value.ValueNull;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class AggregateDataDefault
/*     */   extends AggregateData
/*     */ {
/*     */   private final int aggregateType;
/*     */   private long count;
/*     */   private ValueHashMap<AggregateDataDefault> distinctValues;
/*     */   private Value value;
/*     */   private double m2;
/*     */   private double mean;
/*     */   
/*     */   AggregateDataDefault(int paramInt) {
/*  32 */     this.aggregateType = paramInt;
/*     */   }
/*     */   
/*     */   void add(Database paramDatabase, int paramInt, boolean paramBoolean, Value paramValue) {
/*     */     double d;
/*  37 */     if (paramValue == ValueNull.INSTANCE) {
/*     */       return;
/*     */     }
/*  40 */     this.count++;
/*  41 */     if (paramBoolean) {
/*  42 */       if (this.distinctValues == null) {
/*  43 */         this.distinctValues = ValueHashMap.newInstance();
/*     */       }
/*  45 */       this.distinctValues.put(paramValue, this);
/*     */       return;
/*     */     } 
/*  48 */     switch (this.aggregateType) {
/*     */       case 3:
/*  50 */         if (this.value == null) {
/*  51 */           this.value = paramValue.convertTo(paramInt);
/*     */         } else {
/*  53 */           paramValue = paramValue.convertTo(this.value.getType());
/*  54 */           this.value = this.value.add(paramValue);
/*     */         } 
/*     */         return;
/*     */       case 6:
/*  58 */         if (this.value == null) {
/*  59 */           this.value = paramValue.convertTo(DataType.getAddProofType(paramInt));
/*     */         } else {
/*  61 */           paramValue = paramValue.convertTo(this.value.getType());
/*  62 */           this.value = this.value.add(paramValue);
/*     */         } 
/*     */         return;
/*     */       case 4:
/*  66 */         if (this.value == null || paramDatabase.compare(paramValue, this.value) < 0) {
/*  67 */           this.value = paramValue;
/*     */         }
/*     */         return;
/*     */       case 5:
/*  71 */         if (this.value == null || paramDatabase.compare(paramValue, this.value) > 0) {
/*  72 */           this.value = paramValue;
/*     */         }
/*     */         return;
/*     */ 
/*     */ 
/*     */       
/*     */       case 7:
/*     */       case 8:
/*     */       case 9:
/*     */       case 10:
/*  82 */         d = paramValue.getDouble();
/*  83 */         if (this.count == 1L) {
/*  84 */           this.mean = d;
/*  85 */           this.m2 = 0.0D;
/*     */         } else {
/*  87 */           double d1 = d - this.mean;
/*  88 */           this.mean += d1 / this.count;
/*  89 */           this.m2 += d1 * (d - this.mean);
/*     */         } 
/*     */         return;
/*     */       
/*     */       case 12:
/*  94 */         paramValue = paramValue.convertTo(1);
/*  95 */         if (this.value == null) {
/*  96 */           this.value = paramValue;
/*     */         } else {
/*  98 */           this.value = (Value)ValueBoolean.get((this.value.getBoolean().booleanValue() && paramValue.getBoolean().booleanValue()));
/*     */         } 
/*     */         return;
/*     */       
/*     */       case 11:
/* 103 */         paramValue = paramValue.convertTo(1);
/* 104 */         if (this.value == null) {
/* 105 */           this.value = paramValue;
/*     */         } else {
/* 107 */           this.value = (Value)ValueBoolean.get((this.value.getBoolean().booleanValue() || paramValue.getBoolean().booleanValue()));
/*     */         } 
/*     */         return;
/*     */       
/*     */       case 14:
/* 112 */         if (this.value == null) {
/* 113 */           this.value = paramValue.convertTo(paramInt);
/*     */         } else {
/* 115 */           this.value = ValueLong.get(this.value.getLong() & paramValue.getLong()).convertTo(paramInt);
/*     */         } 
/*     */         return;
/*     */       case 13:
/* 119 */         if (this.value == null) {
/* 120 */           this.value = paramValue.convertTo(paramInt);
/*     */         } else {
/* 122 */           this.value = ValueLong.get(this.value.getLong() | paramValue.getLong()).convertTo(paramInt);
/*     */         } 
/*     */         return;
/*     */     } 
/* 126 */     DbException.throwInternalError("type=" + this.aggregateType);
/*     */   }
/*     */ 
/*     */   
/*     */   Value getValue(Database paramDatabase, int paramInt, boolean paramBoolean) {
/*     */     ValueDouble valueDouble;
/* 132 */     if (paramBoolean) {
/* 133 */       this.count = 0L;
/* 134 */       groupDistinct(paramDatabase, paramInt);
/*     */     } 
/* 136 */     Value value = null;
/* 137 */     switch (this.aggregateType) {
/*     */       case 3:
/*     */       case 4:
/*     */       case 5:
/*     */       case 11:
/*     */       case 12:
/*     */       case 13:
/*     */       case 14:
/* 145 */         value = this.value;
/*     */         break;
/*     */       case 6:
/* 148 */         if (this.value != null) {
/* 149 */           value = divide(this.value, this.count);
/*     */         }
/*     */         break;
/*     */       case 7:
/* 153 */         if (this.count < 1L) {
/* 154 */           return (Value)ValueNull.INSTANCE;
/*     */         }
/* 156 */         valueDouble = ValueDouble.get(Math.sqrt(this.m2 / this.count));
/*     */         break;
/*     */       
/*     */       case 8:
/* 160 */         if (this.count < 2L) {
/* 161 */           return (Value)ValueNull.INSTANCE;
/*     */         }
/* 163 */         valueDouble = ValueDouble.get(Math.sqrt(this.m2 / (this.count - 1L)));
/*     */         break;
/*     */       
/*     */       case 9:
/* 167 */         if (this.count < 1L) {
/* 168 */           return (Value)ValueNull.INSTANCE;
/*     */         }
/* 170 */         valueDouble = ValueDouble.get(this.m2 / this.count);
/*     */         break;
/*     */       
/*     */       case 10:
/* 174 */         if (this.count < 2L) {
/* 175 */           return (Value)ValueNull.INSTANCE;
/*     */         }
/* 177 */         valueDouble = ValueDouble.get(this.m2 / (this.count - 1L));
/*     */         break;
/*     */       
/*     */       default:
/* 181 */         DbException.throwInternalError("type=" + this.aggregateType); break;
/*     */     } 
/* 183 */     return (valueDouble == null) ? (Value)ValueNull.INSTANCE : valueDouble.convertTo(paramInt);
/*     */   }
/*     */   
/*     */   private static Value divide(Value paramValue, long paramLong) {
/* 187 */     if (paramLong == 0L) {
/* 188 */       return (Value)ValueNull.INSTANCE;
/*     */     }
/* 190 */     int i = Value.getHigherOrder(paramValue.getType(), 5);
/* 191 */     Value value = ValueLong.get(paramLong).convertTo(i);
/* 192 */     paramValue = paramValue.convertTo(i).divide(value);
/* 193 */     return paramValue;
/*     */   }
/*     */   
/*     */   private void groupDistinct(Database paramDatabase, int paramInt) {
/* 197 */     if (this.distinctValues == null) {
/*     */       return;
/*     */     }
/* 200 */     this.count = 0L;
/* 201 */     for (Value value : this.distinctValues.keys())
/* 202 */       add(paramDatabase, paramInt, false, value); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\expression\AggregateDataDefault.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */