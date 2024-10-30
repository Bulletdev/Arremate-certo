/*     */ package org.h2.mvstore.rtree;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.ArrayList;
/*     */ import org.h2.mvstore.DataUtils;
/*     */ import org.h2.mvstore.WriteBuffer;
/*     */ import org.h2.mvstore.type.DataType;
/*     */ import org.h2.util.New;
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
/*     */ public class SpatialDataType
/*     */   implements DataType
/*     */ {
/*     */   private final int dimensions;
/*     */   
/*     */   public SpatialDataType(int paramInt) {
/*  28 */     DataUtils.checkArgument((paramInt >= 1 && paramInt < 32), "Dimensions must be between 1 and 31, is {0}", new Object[] { Integer.valueOf(paramInt) });
/*     */ 
/*     */     
/*  31 */     this.dimensions = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public int compare(Object paramObject1, Object paramObject2) {
/*  36 */     if (paramObject1 == paramObject2)
/*  37 */       return 0; 
/*  38 */     if (paramObject1 == null)
/*  39 */       return -1; 
/*  40 */     if (paramObject2 == null) {
/*  41 */       return 1;
/*     */     }
/*  43 */     long l1 = ((SpatialKey)paramObject1).getId();
/*  44 */     long l2 = ((SpatialKey)paramObject2).getId();
/*  45 */     return (l1 < l2) ? -1 : ((l1 > l2) ? 1 : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject1, Object paramObject2) {
/*  56 */     if (paramObject1 == paramObject2)
/*  57 */       return true; 
/*  58 */     if (paramObject1 == null || paramObject2 == null) {
/*  59 */       return false;
/*     */     }
/*  61 */     long l1 = ((SpatialKey)paramObject1).getId();
/*  62 */     long l2 = ((SpatialKey)paramObject2).getId();
/*  63 */     return (l1 == l2);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMemory(Object paramObject) {
/*  68 */     return 40 + this.dimensions * 4;
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(ByteBuffer paramByteBuffer, Object[] paramArrayOfObject, int paramInt, boolean paramBoolean) {
/*  73 */     for (byte b = 0; b < paramInt; b++) {
/*  74 */       paramArrayOfObject[b] = read(paramByteBuffer);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(WriteBuffer paramWriteBuffer, Object[] paramArrayOfObject, int paramInt, boolean paramBoolean) {
/*  80 */     for (byte b = 0; b < paramInt; b++) {
/*  81 */       write(paramWriteBuffer, paramArrayOfObject[b]);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(WriteBuffer paramWriteBuffer, Object paramObject) {
/*  87 */     SpatialKey spatialKey = (SpatialKey)paramObject;
/*  88 */     if (spatialKey.isNull()) {
/*  89 */       paramWriteBuffer.putVarInt(-1);
/*  90 */       paramWriteBuffer.putVarLong(spatialKey.getId());
/*     */       return;
/*     */     } 
/*  93 */     int i = 0; byte b;
/*  94 */     for (b = 0; b < this.dimensions; b++) {
/*  95 */       if (spatialKey.min(b) == spatialKey.max(b)) {
/*  96 */         i |= 1 << b;
/*     */       }
/*     */     } 
/*  99 */     paramWriteBuffer.putVarInt(i);
/* 100 */     for (b = 0; b < this.dimensions; b++) {
/* 101 */       paramWriteBuffer.putFloat(spatialKey.min(b));
/* 102 */       if ((i & 1 << b) == 0) {
/* 103 */         paramWriteBuffer.putFloat(spatialKey.max(b));
/*     */       }
/*     */     } 
/* 106 */     paramWriteBuffer.putVarLong(spatialKey.getId());
/*     */   }
/*     */ 
/*     */   
/*     */   public Object read(ByteBuffer paramByteBuffer) {
/* 111 */     int i = DataUtils.readVarInt(paramByteBuffer);
/* 112 */     if (i == -1) {
/* 113 */       long l1 = DataUtils.readVarLong(paramByteBuffer);
/* 114 */       return new SpatialKey(l1, new float[0]);
/*     */     } 
/* 116 */     float[] arrayOfFloat = new float[this.dimensions * 2];
/* 117 */     for (byte b = 0; b < this.dimensions; b++) {
/* 118 */       float f2, f1 = paramByteBuffer.getFloat();
/*     */       
/* 120 */       if ((i & 1 << b) != 0) {
/* 121 */         f2 = f1;
/*     */       } else {
/* 123 */         f2 = paramByteBuffer.getFloat();
/*     */       } 
/* 125 */       arrayOfFloat[b + b] = f1;
/* 126 */       arrayOfFloat[b + b + 1] = f2;
/*     */     } 
/* 128 */     long l = DataUtils.readVarLong(paramByteBuffer);
/* 129 */     return new SpatialKey(l, arrayOfFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOverlap(Object paramObject1, Object paramObject2) {
/* 140 */     SpatialKey spatialKey1 = (SpatialKey)paramObject1;
/* 141 */     SpatialKey spatialKey2 = (SpatialKey)paramObject2;
/* 142 */     if (spatialKey1.isNull() || spatialKey2.isNull()) {
/* 143 */       return false;
/*     */     }
/* 145 */     for (byte b = 0; b < this.dimensions; b++) {
/* 146 */       if (spatialKey1.max(b) < spatialKey2.min(b) || spatialKey1.min(b) > spatialKey2.max(b)) {
/* 147 */         return false;
/*     */       }
/*     */     } 
/* 150 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void increaseBounds(Object paramObject1, Object paramObject2) {
/* 160 */     SpatialKey spatialKey1 = (SpatialKey)paramObject2;
/* 161 */     SpatialKey spatialKey2 = (SpatialKey)paramObject1;
/* 162 */     if (spatialKey1.isNull() || spatialKey2.isNull()) {
/*     */       return;
/*     */     }
/* 165 */     for (byte b = 0; b < this.dimensions; b++) {
/* 166 */       spatialKey2.setMin(b, Math.min(spatialKey2.min(b), spatialKey1.min(b)));
/* 167 */       spatialKey2.setMax(b, Math.max(spatialKey2.max(b), spatialKey1.max(b)));
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
/*     */   public float getAreaIncrease(Object paramObject1, Object paramObject2) {
/* 179 */     SpatialKey spatialKey1 = (SpatialKey)paramObject2;
/* 180 */     SpatialKey spatialKey2 = (SpatialKey)paramObject1;
/* 181 */     if (spatialKey2.isNull() || spatialKey1.isNull()) {
/* 182 */       return 0.0F;
/*     */     }
/* 184 */     float f1 = spatialKey2.min(0);
/* 185 */     float f2 = spatialKey2.max(0);
/* 186 */     float f3 = f2 - f1;
/* 187 */     f1 = Math.min(f1, spatialKey1.min(0));
/* 188 */     f2 = Math.max(f2, spatialKey1.max(0));
/* 189 */     float f4 = f2 - f1;
/* 190 */     for (byte b = 1; b < this.dimensions; b++) {
/* 191 */       f1 = spatialKey2.min(b);
/* 192 */       f2 = spatialKey2.max(b);
/* 193 */       f3 *= f2 - f1;
/* 194 */       f1 = Math.min(f1, spatialKey1.min(b));
/* 195 */       f2 = Math.max(f2, spatialKey1.max(b));
/* 196 */       f4 *= f2 - f1;
/*     */     } 
/* 198 */     return f4 - f3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   float getCombinedArea(Object paramObject1, Object paramObject2) {
/* 209 */     SpatialKey spatialKey1 = (SpatialKey)paramObject1;
/* 210 */     SpatialKey spatialKey2 = (SpatialKey)paramObject2;
/* 211 */     if (spatialKey1.isNull())
/* 212 */       return getArea(spatialKey2); 
/* 213 */     if (spatialKey2.isNull()) {
/* 214 */       return getArea(spatialKey1);
/*     */     }
/* 216 */     float f = 1.0F;
/* 217 */     for (byte b = 0; b < this.dimensions; b++) {
/* 218 */       float f1 = Math.min(spatialKey1.min(b), spatialKey2.min(b));
/* 219 */       float f2 = Math.max(spatialKey1.max(b), spatialKey2.max(b));
/* 220 */       f *= f2 - f1;
/*     */     } 
/* 222 */     return f;
/*     */   }
/*     */   
/*     */   private float getArea(SpatialKey paramSpatialKey) {
/* 226 */     if (paramSpatialKey.isNull()) {
/* 227 */       return 0.0F;
/*     */     }
/* 229 */     float f = 1.0F;
/* 230 */     for (byte b = 0; b < this.dimensions; b++) {
/* 231 */       f *= paramSpatialKey.max(b) - paramSpatialKey.min(b);
/*     */     }
/* 233 */     return f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(Object paramObject1, Object paramObject2) {
/* 244 */     SpatialKey spatialKey1 = (SpatialKey)paramObject1;
/* 245 */     SpatialKey spatialKey2 = (SpatialKey)paramObject2;
/* 246 */     if (spatialKey1.isNull() || spatialKey2.isNull()) {
/* 247 */       return false;
/*     */     }
/* 249 */     for (byte b = 0; b < this.dimensions; b++) {
/* 250 */       if (spatialKey1.min(b) > spatialKey2.min(b) || spatialKey1.max(b) < spatialKey2.max(b)) {
/* 251 */         return false;
/*     */       }
/*     */     } 
/* 254 */     return true;
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
/*     */   public boolean isInside(Object paramObject1, Object paramObject2) {
/* 266 */     SpatialKey spatialKey1 = (SpatialKey)paramObject1;
/* 267 */     SpatialKey spatialKey2 = (SpatialKey)paramObject2;
/* 268 */     if (spatialKey1.isNull() || spatialKey2.isNull()) {
/* 269 */       return false;
/*     */     }
/* 271 */     for (byte b = 0; b < this.dimensions; b++) {
/* 272 */       if (spatialKey1.min(b) <= spatialKey2.min(b) || spatialKey1.max(b) >= spatialKey2.max(b)) {
/* 273 */         return false;
/*     */       }
/*     */     } 
/* 276 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Object createBoundingBox(Object paramObject) {
/* 286 */     SpatialKey spatialKey = (SpatialKey)paramObject;
/* 287 */     if (spatialKey.isNull()) {
/* 288 */       return spatialKey;
/*     */     }
/* 290 */     float[] arrayOfFloat = new float[this.dimensions * 2];
/* 291 */     for (byte b = 0; b < this.dimensions; b++) {
/* 292 */       arrayOfFloat[b + b] = spatialKey.min(b);
/* 293 */       arrayOfFloat[b + b + 1] = spatialKey.max(b);
/*     */     } 
/* 295 */     return new SpatialKey(0L, arrayOfFloat);
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
/*     */   public int[] getExtremes(ArrayList<Object> paramArrayList) {
/* 307 */     paramArrayList = getNotNull(paramArrayList);
/* 308 */     if (paramArrayList.size() == 0) {
/* 309 */       return null;
/*     */     }
/* 311 */     SpatialKey spatialKey1 = (SpatialKey)createBoundingBox(paramArrayList.get(0));
/* 312 */     SpatialKey spatialKey2 = (SpatialKey)createBoundingBox(spatialKey1); byte b1;
/* 313 */     for (b1 = 0; b1 < this.dimensions; b1++) {
/* 314 */       float f = spatialKey2.min(b1);
/* 315 */       spatialKey2.setMin(b1, spatialKey2.max(b1));
/* 316 */       spatialKey2.setMax(b1, f);
/*     */     } 
/* 318 */     for (b1 = 0; b1 < paramArrayList.size(); b1++) {
/* 319 */       Object object = paramArrayList.get(b1);
/* 320 */       increaseBounds(spatialKey1, object);
/* 321 */       increaseMaxInnerBounds(spatialKey2, object);
/*     */     } 
/* 323 */     double d = 0.0D;
/* 324 */     byte b2 = 0;
/* 325 */     for (byte b3 = 0; b3 < this.dimensions; b3++) {
/* 326 */       float f = spatialKey2.max(b3) - spatialKey2.min(b3);
/* 327 */       if (f >= 0.0F) {
/*     */ 
/*     */         
/* 330 */         float f3 = spatialKey1.max(b3) - spatialKey1.min(b3);
/* 331 */         float f4 = f / f3;
/* 332 */         if (f4 > d) {
/* 333 */           d = f4;
/* 334 */           b2 = b3;
/*     */         } 
/*     */       } 
/* 337 */     }  if (d <= 0.0D) {
/* 338 */       return null;
/*     */     }
/* 340 */     float f1 = spatialKey2.min(b2);
/* 341 */     float f2 = spatialKey2.max(b2);
/* 342 */     byte b4 = -1, b5 = -1;
/* 343 */     for (byte b6 = 0; b6 < paramArrayList.size() && (b4 < 0 || b5 < 0); 
/* 344 */       b6++) {
/* 345 */       SpatialKey spatialKey = (SpatialKey)paramArrayList.get(b6);
/* 346 */       if (b4 < 0 && spatialKey.max(b2) == f1) {
/* 347 */         b4 = b6;
/* 348 */       } else if (b5 < 0 && spatialKey.min(b2) == f2) {
/* 349 */         b5 = b6;
/*     */       } 
/*     */     } 
/* 352 */     return new int[] { b4, b5 };
/*     */   }
/*     */   
/*     */   private static ArrayList<Object> getNotNull(ArrayList<Object> paramArrayList) {
/* 356 */     ArrayList<SpatialKey> arrayList = null;
/* 357 */     for (SpatialKey spatialKey1 : paramArrayList) {
/* 358 */       SpatialKey spatialKey2 = spatialKey1;
/* 359 */       if (spatialKey2.isNull()) {
/* 360 */         arrayList = New.arrayList();
/*     */         break;
/*     */       } 
/*     */     } 
/* 364 */     if (arrayList == null) {
/* 365 */       return paramArrayList;
/*     */     }
/* 367 */     for (SpatialKey spatialKey1 : paramArrayList) {
/* 368 */       SpatialKey spatialKey2 = spatialKey1;
/* 369 */       if (!spatialKey2.isNull()) {
/* 370 */         arrayList.add(spatialKey2);
/*     */       }
/*     */     } 
/* 373 */     return (ArrayList)arrayList;
/*     */   }
/*     */   
/*     */   private void increaseMaxInnerBounds(Object paramObject1, Object paramObject2) {
/* 377 */     SpatialKey spatialKey1 = (SpatialKey)paramObject1;
/* 378 */     SpatialKey spatialKey2 = (SpatialKey)paramObject2;
/* 379 */     for (byte b = 0; b < this.dimensions; b++) {
/* 380 */       spatialKey1.setMin(b, Math.min(spatialKey1.min(b), spatialKey2.max(b)));
/* 381 */       spatialKey1.setMax(b, Math.max(spatialKey1.max(b), spatialKey2.min(b)));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\mvstore\rtree\SpatialDataType.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */