/*     */ package org.h2.util;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.value.Value;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ValueHashMap<V>
/*     */   extends HashBase
/*     */ {
/*     */   private Value[] keys;
/*     */   private V[] values;
/*     */   
/*     */   public static <T> ValueHashMap<T> newInstance() {
/*  29 */     return new ValueHashMap<>();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void reset(int paramInt) {
/*  35 */     super.reset(paramInt);
/*  36 */     this.keys = new Value[this.len];
/*  37 */     this.values = (V[])new Object[this.len];
/*     */   }
/*     */ 
/*     */   
/*     */   protected void rehash(int paramInt) {
/*  42 */     Value[] arrayOfValue = this.keys;
/*  43 */     V[] arrayOfV = this.values;
/*  44 */     reset(paramInt);
/*  45 */     int i = arrayOfValue.length;
/*  46 */     for (byte b = 0; b < i; b++) {
/*  47 */       Value value = arrayOfValue[b];
/*  48 */       if (value != null && value != ValueNull.DELETED)
/*     */       {
/*     */         
/*  51 */         internalPut(value, arrayOfV[b]);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private int getIndex(Value paramValue) {
/*  57 */     return paramValue.hashCode() & this.mask;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void put(Value paramValue, V paramV) {
/*  67 */     checkSizePut();
/*  68 */     internalPut(paramValue, paramV);
/*     */   }
/*     */   
/*     */   private void internalPut(Value paramValue, V paramV) {
/*  72 */     int i = getIndex(paramValue);
/*  73 */     byte b = 1;
/*  74 */     int j = -1;
/*     */     do {
/*  76 */       Value value = this.keys[i];
/*  77 */       if (value == null) {
/*     */         
/*  79 */         if (j >= 0) {
/*  80 */           i = j;
/*  81 */           this.deletedCount--;
/*     */         } 
/*  83 */         this.size++;
/*  84 */         this.keys[i] = paramValue;
/*  85 */         this.values[i] = paramV; return;
/*     */       } 
/*  87 */       if (value == ValueNull.DELETED) {
/*     */         
/*  89 */         if (j < 0) {
/*  90 */           j = i;
/*     */         }
/*  92 */       } else if (value.equals(paramValue)) {
/*     */         
/*  94 */         this.values[i] = paramV;
/*     */         return;
/*     */       } 
/*  97 */       i = i + b++ & this.mask;
/*  98 */     } while (b <= this.len);
/*     */     
/* 100 */     DbException.throwInternalError("hashmap is full");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(Value paramValue) {
/* 109 */     checkSizeRemove();
/* 110 */     int i = getIndex(paramValue);
/* 111 */     byte b = 1;
/*     */     do {
/* 113 */       Value value = this.keys[i];
/* 114 */       if (value == null) {
/*     */         return;
/*     */       }
/* 117 */       if (value != ValueNull.DELETED)
/*     */       {
/* 119 */         if (value.equals(paramValue)) {
/*     */           
/* 121 */           this.keys[i] = (Value)ValueNull.DELETED;
/* 122 */           this.values[i] = null;
/* 123 */           this.deletedCount++;
/* 124 */           this.size--;
/*     */           return;
/*     */         }  } 
/* 127 */       i = i + b++ & this.mask;
/* 128 */     } while (b <= this.len);
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
/*     */   public V get(Value paramValue) {
/* 140 */     int i = getIndex(paramValue);
/* 141 */     byte b = 1;
/*     */     while (true) {
/* 143 */       Value value = this.keys[i];
/* 144 */       if (value == null)
/*     */       {
/* 146 */         return null; } 
/* 147 */       if (value != ValueNull.DELETED)
/*     */       {
/* 149 */         if (value.equals(paramValue))
/*     */         {
/* 151 */           return this.values[i]; } 
/*     */       }
/* 153 */       i = i + b++ & this.mask;
/* 154 */       if (b > this.len) {
/* 155 */         return null;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<Value> keys() {
/* 164 */     ArrayList<?> arrayList = New.arrayList(this.size);
/* 165 */     for (Value value : this.keys) {
/* 166 */       if (value != null && value != ValueNull.DELETED) {
/* 167 */         arrayList.add(value);
/*     */       }
/*     */     } 
/* 170 */     return (ArrayList)arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<V> values() {
/* 179 */     ArrayList<?> arrayList = New.arrayList(this.size);
/* 180 */     int i = this.keys.length;
/* 181 */     for (byte b = 0; b < i; b++) {
/* 182 */       Value value = this.keys[b];
/* 183 */       if (value != null && value != ValueNull.DELETED) {
/* 184 */         arrayList.add(this.values[b]);
/*     */       }
/*     */     } 
/* 187 */     return (ArrayList)arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\ValueHashMap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */