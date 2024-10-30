/*     */ package com.sun.jna.platform;
/*     */ 
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.image.DataBuffer;
/*     */ import java.awt.image.DataBufferByte;
/*     */ import java.awt.image.DataBufferInt;
/*     */ import java.awt.image.MultiPixelPackedSampleModel;
/*     */ import java.awt.image.Raster;
/*     */ import java.awt.image.SampleModel;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import java.util.TreeSet;
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
/*     */ public class RasterRangesUtils
/*     */ {
/*  53 */   private static final int[] subColMasks = new int[] { 128, 64, 32, 16, 8, 4, 2, 1 };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  58 */   private static final Comparator<Object> COMPARATOR = new Comparator()
/*     */     {
/*     */       public int compare(Object param1Object1, Object param1Object2) {
/*  61 */         return ((Rectangle)param1Object1).x - ((Rectangle)param1Object2).x;
/*     */       }
/*     */     };
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
/*     */   public static interface RangesOutput
/*     */   {
/*     */     boolean outputRange(int param1Int1, int param1Int2, int param1Int3, int param1Int4);
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
/*     */   public static boolean outputOccupiedRanges(Raster paramRaster, RangesOutput paramRangesOutput) {
/*  89 */     Rectangle rectangle = paramRaster.getBounds();
/*  90 */     SampleModel sampleModel = paramRaster.getSampleModel();
/*  91 */     boolean bool = (sampleModel.getNumBands() == 4) ? true : false;
/*     */ 
/*     */     
/*  94 */     if (paramRaster.getParent() == null && rectangle.x == 0 && rectangle.y == 0) {
/*     */ 
/*     */       
/*  97 */       DataBuffer dataBuffer = paramRaster.getDataBuffer();
/*  98 */       if (dataBuffer.getNumBanks() == 1)
/*     */       {
/*     */         
/* 101 */         if (sampleModel instanceof MultiPixelPackedSampleModel) {
/* 102 */           MultiPixelPackedSampleModel multiPixelPackedSampleModel = (MultiPixelPackedSampleModel)sampleModel;
/* 103 */           if (multiPixelPackedSampleModel.getPixelBitStride() == 1)
/*     */           {
/* 105 */             return outputOccupiedRangesOfBinaryPixels(((DataBufferByte)dataBuffer).getData(), rectangle.width, rectangle.height, paramRangesOutput);
/*     */           }
/* 107 */         } else if (sampleModel instanceof java.awt.image.SinglePixelPackedSampleModel && 
/* 108 */           sampleModel.getDataType() == 3) {
/*     */           
/* 110 */           return outputOccupiedRanges(((DataBufferInt)dataBuffer).getData(), rectangle.width, rectangle.height, bool ? -16777216 : 16777215, paramRangesOutput);
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 118 */     int[] arrayOfInt = paramRaster.getPixels(0, 0, rectangle.width, rectangle.height, (int[])null);
/* 119 */     return outputOccupiedRanges(arrayOfInt, rectangle.width, rectangle.height, bool ? -16777216 : 16777215, paramRangesOutput);
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
/*     */   public static boolean outputOccupiedRangesOfBinaryPixels(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, RangesOutput paramRangesOutput) {
/* 131 */     HashSet<Rectangle> hashSet = new HashSet();
/* 132 */     Set<?> set = Collections.emptySet();
/* 133 */     int i = paramArrayOfbyte.length / paramInt2;
/* 134 */     for (byte b = 0; b < paramInt2; b++) {
/* 135 */       TreeSet<Rectangle> treeSet = new TreeSet(COMPARATOR);
/* 136 */       int j = b * i;
/* 137 */       int k = -1;
/*     */       
/* 139 */       for (byte b1 = 0; b1 < i; b1++) {
/* 140 */         int m = b1 << 3;
/* 141 */         byte b2 = paramArrayOfbyte[j + b1];
/* 142 */         if (b2 == 0) {
/*     */           
/* 144 */           if (k >= 0) {
/*     */             
/* 146 */             treeSet.add(new Rectangle(k, b, m - k, 1));
/* 147 */             k = -1;
/*     */           } 
/* 149 */         } else if (b2 == 255) {
/*     */           
/* 151 */           if (k < 0)
/*     */           {
/* 153 */             k = m;
/*     */           }
/*     */         } else {
/*     */           
/* 157 */           for (byte b3 = 0; b3 < 8; b3++) {
/* 158 */             int n = m | b3;
/* 159 */             if ((b2 & subColMasks[b3]) != 0) {
/* 160 */               if (k < 0)
/*     */               {
/* 162 */                 k = n;
/*     */               }
/*     */             }
/* 165 */             else if (k >= 0) {
/*     */               
/* 167 */               treeSet.add(new Rectangle(k, b, n - k, 1));
/* 168 */               k = -1;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 174 */       if (k >= 0)
/*     */       {
/* 176 */         treeSet.add(new Rectangle(k, b, paramInt1 - k, 1));
/*     */       }
/* 178 */       Set<Rectangle> set1 = mergeRects((Set)set, treeSet);
/* 179 */       hashSet.addAll(set1);
/* 180 */       set = treeSet;
/*     */     } 
/*     */     
/* 183 */     hashSet.addAll(set);
/* 184 */     for (Rectangle rectangle : hashSet) {
/*     */       
/* 186 */       if (!paramRangesOutput.outputRange(rectangle.x, rectangle.y, rectangle.width, rectangle.height)) {
/* 187 */         return false;
/*     */       }
/*     */     } 
/* 190 */     return true;
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
/*     */   public static boolean outputOccupiedRanges(int[] paramArrayOfint, int paramInt1, int paramInt2, int paramInt3, RangesOutput paramRangesOutput) {
/* 204 */     HashSet<Rectangle> hashSet = new HashSet();
/* 205 */     Set<?> set = Collections.emptySet();
/* 206 */     for (byte b = 0; b < paramInt2; b++) {
/* 207 */       TreeSet<Rectangle> treeSet = new TreeSet(COMPARATOR);
/* 208 */       int i = b * paramInt1;
/* 209 */       byte b1 = -1;
/*     */       
/* 211 */       for (byte b2 = 0; b2 < paramInt1; b2++) {
/* 212 */         if ((paramArrayOfint[i + b2] & paramInt3) != 0) {
/* 213 */           if (b1 < 0) {
/* 214 */             b1 = b2;
/*     */           }
/*     */         }
/* 217 */         else if (b1 >= 0) {
/*     */           
/* 219 */           treeSet.add(new Rectangle(b1, b, b2 - b1, 1));
/* 220 */           b1 = -1;
/*     */         } 
/*     */       } 
/*     */       
/* 224 */       if (b1 >= 0)
/*     */       {
/* 226 */         treeSet.add(new Rectangle(b1, b, paramInt1 - b1, 1));
/*     */       }
/* 228 */       Set<Rectangle> set1 = mergeRects((Set)set, treeSet);
/* 229 */       hashSet.addAll(set1);
/* 230 */       set = treeSet;
/*     */     } 
/*     */     
/* 233 */     hashSet.addAll(set);
/* 234 */     for (Rectangle rectangle : hashSet) {
/*     */       
/* 236 */       if (!paramRangesOutput.outputRange(rectangle.x, rectangle.y, rectangle.width, rectangle.height)) {
/* 237 */         return false;
/*     */       }
/*     */     } 
/* 240 */     return true;
/*     */   }
/*     */   
/*     */   private static Set<Rectangle> mergeRects(Set<Rectangle> paramSet1, Set<Rectangle> paramSet2) {
/* 244 */     HashSet<Rectangle> hashSet = new HashSet<Rectangle>(paramSet1);
/* 245 */     if (!paramSet1.isEmpty() && !paramSet2.isEmpty()) {
/* 246 */       Rectangle[] arrayOfRectangle1 = paramSet1.<Rectangle>toArray(new Rectangle[0]);
/* 247 */       Rectangle[] arrayOfRectangle2 = paramSet2.<Rectangle>toArray(new Rectangle[0]);
/* 248 */       byte b1 = 0;
/* 249 */       byte b2 = 0;
/* 250 */       while (b1 < arrayOfRectangle1.length && b2 < arrayOfRectangle2.length) {
/* 251 */         while ((arrayOfRectangle2[b2]).x < (arrayOfRectangle1[b1]).x) {
/* 252 */           if (++b2 == arrayOfRectangle2.length) {
/* 253 */             return hashSet;
/*     */           }
/*     */         } 
/* 256 */         if ((arrayOfRectangle2[b2]).x == (arrayOfRectangle1[b1]).x && (arrayOfRectangle2[b2]).width == (arrayOfRectangle1[b1]).width) {
/* 257 */           hashSet.remove(arrayOfRectangle1[b1]);
/* 258 */           (arrayOfRectangle2[b2]).y = (arrayOfRectangle1[b1]).y;
/* 259 */           (arrayOfRectangle1[b1]).height++;
/* 260 */           b2++;
/*     */           continue;
/*     */         } 
/* 263 */         b1++;
/*     */       } 
/*     */     } 
/*     */     
/* 267 */     return hashSet;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\RasterRangesUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */