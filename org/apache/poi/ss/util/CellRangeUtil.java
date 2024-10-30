/*     */ package org.apache.poi.ss.util;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class CellRangeUtil
/*     */ {
/*     */   public static final int NO_INTERSECTION = 1;
/*     */   public static final int OVERLAP = 2;
/*     */   public static final int INSIDE = 3;
/*     */   public static final int ENCLOSES = 4;
/*     */   
/*     */   public static int intersect(CellRangeAddress paramCellRangeAddress1, CellRangeAddress paramCellRangeAddress2) {
/*  57 */     int i = paramCellRangeAddress2.getFirstRow();
/*  58 */     int j = paramCellRangeAddress2.getLastRow();
/*  59 */     int k = paramCellRangeAddress2.getFirstColumn();
/*  60 */     int m = paramCellRangeAddress2.getLastColumn();
/*     */     
/*  62 */     if (gt(paramCellRangeAddress1.getFirstRow(), j) || lt(paramCellRangeAddress1.getLastRow(), i) || gt(paramCellRangeAddress1.getFirstColumn(), m) || lt(paramCellRangeAddress1.getLastColumn(), k))
/*     */     {
/*     */ 
/*     */ 
/*     */       
/*  67 */       return 1;
/*     */     }
/*  69 */     if (contains(paramCellRangeAddress1, paramCellRangeAddress2))
/*     */     {
/*  71 */       return 3;
/*     */     }
/*  73 */     if (contains(paramCellRangeAddress2, paramCellRangeAddress1))
/*     */     {
/*  75 */       return 4;
/*     */     }
/*     */ 
/*     */     
/*  79 */     return 2;
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
/*     */   public static CellRangeAddress[] mergeCellRanges(CellRangeAddress[] paramArrayOfCellRangeAddress) {
/*  93 */     if (paramArrayOfCellRangeAddress.length < 1) {
/*  94 */       return new CellRangeAddress[0];
/*     */     }
/*  96 */     List<CellRangeAddress> list1 = toList(paramArrayOfCellRangeAddress);
/*  97 */     List<CellRangeAddress> list2 = mergeCellRanges(list1);
/*  98 */     return toArray(list2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static List<CellRangeAddress> mergeCellRanges(List<CellRangeAddress> paramList) {
/* 104 */     while (paramList.size() > 1) {
/* 105 */       boolean bool = false;
/*     */ 
/*     */       
/* 108 */       for (byte b = 0; b < paramList.size(); b++) {
/* 109 */         CellRangeAddress cellRangeAddress = paramList.get(b);
/*     */ 
/*     */         
/* 112 */         for (int i = b + 1; i < paramList.size(); i++) {
/* 113 */           CellRangeAddress cellRangeAddress1 = paramList.get(i);
/*     */           
/* 115 */           CellRangeAddress[] arrayOfCellRangeAddress = mergeRanges(cellRangeAddress, cellRangeAddress1);
/* 116 */           if (arrayOfCellRangeAddress != null) {
/*     */ 
/*     */             
/* 119 */             bool = true;
/*     */             
/* 121 */             paramList.set(b, arrayOfCellRangeAddress[0]);
/*     */             
/* 123 */             paramList.remove(i--);
/*     */             
/* 125 */             for (byte b1 = 1; b1 < arrayOfCellRangeAddress.length; b1++) {
/* 126 */               i++;
/* 127 */               paramList.add(i, arrayOfCellRangeAddress[b1]);
/*     */             } 
/*     */           } 
/*     */         } 
/* 131 */       }  if (!bool) {
/*     */         break;
/*     */       }
/*     */     } 
/*     */     
/* 136 */     return paramList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static CellRangeAddress[] mergeRanges(CellRangeAddress paramCellRangeAddress1, CellRangeAddress paramCellRangeAddress2) {
/* 143 */     int i = intersect(paramCellRangeAddress1, paramCellRangeAddress2);
/* 144 */     switch (i) {
/*     */ 
/*     */       
/*     */       case 1:
/* 148 */         if (hasExactSharedBorder(paramCellRangeAddress1, paramCellRangeAddress2)) {
/* 149 */           return new CellRangeAddress[] { createEnclosingCellRange(paramCellRangeAddress1, paramCellRangeAddress2) };
/*     */         }
/*     */         
/* 152 */         return null;
/*     */ 
/*     */ 
/*     */       
/*     */       case 2:
/* 157 */         return null;
/*     */       
/*     */       case 3:
/* 160 */         return new CellRangeAddress[] { paramCellRangeAddress1 };
/*     */       
/*     */       case 4:
/* 163 */         return new CellRangeAddress[] { paramCellRangeAddress2 };
/*     */     } 
/* 165 */     throw new RuntimeException("unexpected intersection result (" + i + ")");
/*     */   }
/*     */   
/*     */   private static CellRangeAddress[] toArray(List<CellRangeAddress> paramList) {
/* 169 */     CellRangeAddress[] arrayOfCellRangeAddress = new CellRangeAddress[paramList.size()];
/* 170 */     paramList.toArray(arrayOfCellRangeAddress);
/* 171 */     return arrayOfCellRangeAddress;
/*     */   }
/*     */   private static List<CellRangeAddress> toList(CellRangeAddress[] paramArrayOfCellRangeAddress) {
/* 174 */     ArrayList<CellRangeAddress> arrayList = new ArrayList(paramArrayOfCellRangeAddress.length);
/* 175 */     for (CellRangeAddress cellRangeAddress : paramArrayOfCellRangeAddress) {
/* 176 */       arrayList.add(cellRangeAddress);
/*     */     }
/* 178 */     return arrayList;
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
/*     */   public static boolean contains(CellRangeAddress paramCellRangeAddress1, CellRangeAddress paramCellRangeAddress2) {
/* 192 */     return (le(paramCellRangeAddress1.getFirstRow(), paramCellRangeAddress2.getFirstRow()) && ge(paramCellRangeAddress1.getLastRow(), paramCellRangeAddress2.getLastRow()) && le(paramCellRangeAddress1.getFirstColumn(), paramCellRangeAddress2.getFirstColumn()) && ge(paramCellRangeAddress1.getLastColumn(), paramCellRangeAddress2.getLastColumn()));
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
/*     */   public static boolean hasExactSharedBorder(CellRangeAddress paramCellRangeAddress1, CellRangeAddress paramCellRangeAddress2) {
/* 205 */     int i = paramCellRangeAddress2.getFirstRow();
/* 206 */     int j = paramCellRangeAddress2.getLastRow();
/* 207 */     int k = paramCellRangeAddress2.getFirstColumn();
/* 208 */     int m = paramCellRangeAddress2.getLastColumn();
/*     */     
/* 210 */     if ((paramCellRangeAddress1.getFirstRow() > 0 && paramCellRangeAddress1.getFirstRow() - 1 == j) || (i > 0 && i - 1 == paramCellRangeAddress1.getLastRow()))
/*     */     {
/*     */ 
/*     */       
/* 214 */       return (paramCellRangeAddress1.getFirstColumn() == k && paramCellRangeAddress1.getLastColumn() == m);
/*     */     }
/*     */     
/* 217 */     if ((paramCellRangeAddress1.getFirstColumn() > 0 && paramCellRangeAddress1.getFirstColumn() - 1 == m) || (k > 0 && paramCellRangeAddress1.getLastColumn() == k - 1))
/*     */     {
/*     */ 
/*     */       
/* 221 */       return (paramCellRangeAddress1.getFirstRow() == i && paramCellRangeAddress1.getLastRow() == j);
/*     */     }
/* 223 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CellRangeAddress createEnclosingCellRange(CellRangeAddress paramCellRangeAddress1, CellRangeAddress paramCellRangeAddress2) {
/* 232 */     if (paramCellRangeAddress2 == null) {
/* 233 */       return paramCellRangeAddress1.copy();
/*     */     }
/*     */     
/* 236 */     int i = lt(paramCellRangeAddress2.getFirstRow(), paramCellRangeAddress1.getFirstRow()) ? paramCellRangeAddress2.getFirstRow() : paramCellRangeAddress1.getFirstRow();
/* 237 */     int j = gt(paramCellRangeAddress2.getLastRow(), paramCellRangeAddress1.getLastRow()) ? paramCellRangeAddress2.getLastRow() : paramCellRangeAddress1.getLastRow();
/* 238 */     int k = lt(paramCellRangeAddress2.getFirstColumn(), paramCellRangeAddress1.getFirstColumn()) ? paramCellRangeAddress2.getFirstColumn() : paramCellRangeAddress1.getFirstColumn();
/* 239 */     int m = gt(paramCellRangeAddress2.getLastColumn(), paramCellRangeAddress1.getLastColumn()) ? paramCellRangeAddress2.getLastColumn() : paramCellRangeAddress1.getLastColumn();
/*     */     
/* 241 */     return new CellRangeAddress(i, j, k, m);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean lt(int paramInt1, int paramInt2) {
/* 249 */     return (paramInt1 == -1) ? false : ((paramInt2 == -1) ? true : ((paramInt1 < paramInt2)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean le(int paramInt1, int paramInt2) {
/* 257 */     return (paramInt1 == paramInt2 || lt(paramInt1, paramInt2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean gt(int paramInt1, int paramInt2) {
/* 265 */     return lt(paramInt2, paramInt1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean ge(int paramInt1, int paramInt2) {
/* 273 */     return !lt(paramInt1, paramInt2);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\util\CellRangeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */