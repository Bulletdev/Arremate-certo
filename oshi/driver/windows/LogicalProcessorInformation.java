/*     */ package oshi.driver.windows;
/*     */ 
/*     */ import com.sun.jna.platform.win32.Kernel32Util;
/*     */ import com.sun.jna.platform.win32.WinNT;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.hardware.CentralProcessor;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ @ThreadSafe
/*     */ public final class LogicalProcessorInformation
/*     */ {
/*     */   public static List<CentralProcessor.LogicalProcessor> getLogicalProcessorInformationEx() {
/*  61 */     WinNT.SYSTEM_LOGICAL_PROCESSOR_INFORMATION_EX[] arrayOfSYSTEM_LOGICAL_PROCESSOR_INFORMATION_EX = Kernel32Util.getLogicalProcessorInformationEx(65535);
/*     */     
/*  63 */     ArrayList<WinNT.GROUP_AFFINITY[]> arrayList = new ArrayList();
/*  64 */     ArrayList<WinNT.GROUP_AFFINITY> arrayList1 = new ArrayList();
/*     */     
/*  66 */     ArrayList<WinNT.NUMA_NODE_RELATIONSHIP> arrayList2 = new ArrayList();
/*     */     
/*  68 */     for (byte b = 0; b < arrayOfSYSTEM_LOGICAL_PROCESSOR_INFORMATION_EX.length; b++) {
/*  69 */       switch ((arrayOfSYSTEM_LOGICAL_PROCESSOR_INFORMATION_EX[b]).relationship) {
/*     */         
/*     */         case 3:
/*  72 */           arrayList.add(((WinNT.PROCESSOR_RELATIONSHIP)arrayOfSYSTEM_LOGICAL_PROCESSOR_INFORMATION_EX[b]).groupMask);
/*     */           break;
/*     */         
/*     */         case 0:
/*  76 */           arrayList1.add(((WinNT.PROCESSOR_RELATIONSHIP)arrayOfSYSTEM_LOGICAL_PROCESSOR_INFORMATION_EX[b]).groupMask[0]);
/*     */           break;
/*     */         case 1:
/*  79 */           arrayList2.add((WinNT.NUMA_NODE_RELATIONSHIP)arrayOfSYSTEM_LOGICAL_PROCESSOR_INFORMATION_EX[b]);
/*     */           break;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     } 
/*  89 */     arrayList1.sort(Comparator.comparing(paramGROUP_AFFINITY -> Long.valueOf(paramGROUP_AFFINITY.group * 64L + paramGROUP_AFFINITY.mask.longValue())));
/*     */     
/*  91 */     arrayList.sort(Comparator.comparing(paramArrayOfGROUP_AFFINITY -> Long.valueOf((paramArrayOfGROUP_AFFINITY[0]).group * 64L + (paramArrayOfGROUP_AFFINITY[0]).mask.longValue())));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  97 */     arrayList2.sort(Comparator.comparing(paramNUMA_NODE_RELATIONSHIP -> Integer.valueOf(paramNUMA_NODE_RELATIONSHIP.nodeNumber)));
/*  98 */     ArrayList<CentralProcessor.LogicalProcessor> arrayList3 = new ArrayList();
/*  99 */     for (WinNT.NUMA_NODE_RELATIONSHIP nUMA_NODE_RELATIONSHIP : arrayList2) {
/* 100 */       int i = nUMA_NODE_RELATIONSHIP.nodeNumber;
/* 101 */       short s = nUMA_NODE_RELATIONSHIP.groupMask.group;
/* 102 */       long l = nUMA_NODE_RELATIONSHIP.groupMask.mask.longValue();
/*     */ 
/*     */       
/* 105 */       int j = Long.numberOfTrailingZeros(l);
/* 106 */       int k = 63 - Long.numberOfLeadingZeros(l);
/* 107 */       for (int m = j; m <= k; m++) {
/* 108 */         if ((l & 1L << m) != 0L) {
/*     */           
/* 110 */           CentralProcessor.LogicalProcessor logicalProcessor = new CentralProcessor.LogicalProcessor(m, getMatchingCore(arrayList1, s, m), getMatchingPackage((List<WinNT.GROUP_AFFINITY[]>)arrayList, s, m), i, s);
/* 111 */           arrayList3.add(logicalProcessor);
/*     */         } 
/*     */       } 
/*     */     } 
/* 115 */     return arrayList3;
/*     */   }
/*     */   
/*     */   private static int getMatchingPackage(List<WinNT.GROUP_AFFINITY[]> paramList, int paramInt1, int paramInt2) {
/* 119 */     for (byte b = 0; b < paramList.size(); b++) {
/* 120 */       for (byte b1 = 0; b1 < ((WinNT.GROUP_AFFINITY[])paramList.get(b)).length; b1++) {
/* 121 */         if (((((WinNT.GROUP_AFFINITY[])paramList.get(b))[b1]).mask.longValue() & 1L << paramInt2) != 0L && (((WinNT.GROUP_AFFINITY[])paramList.get(b))[b1]).group == paramInt1) {
/* 122 */           return b;
/*     */         }
/*     */       } 
/*     */     } 
/* 126 */     return 0;
/*     */   }
/*     */   
/*     */   private static int getMatchingCore(List<WinNT.GROUP_AFFINITY> paramList, int paramInt1, int paramInt2) {
/* 130 */     for (byte b = 0; b < paramList.size(); b++) {
/* 131 */       if ((((WinNT.GROUP_AFFINITY)paramList.get(b)).mask.longValue() & 1L << paramInt2) != 0L && ((WinNT.GROUP_AFFINITY)paramList.get(b)).group == paramInt1) {
/* 132 */         return b;
/*     */       }
/*     */     } 
/* 135 */     return 0;
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
/*     */   public static List<CentralProcessor.LogicalProcessor> getLogicalProcessorInformation() {
/* 150 */     ArrayList<Long> arrayList1 = new ArrayList();
/* 151 */     ArrayList<Long> arrayList2 = new ArrayList();
/* 152 */     WinNT.SYSTEM_LOGICAL_PROCESSOR_INFORMATION[] arrayOfSYSTEM_LOGICAL_PROCESSOR_INFORMATION = Kernel32Util.getLogicalProcessorInformation();
/* 153 */     for (WinNT.SYSTEM_LOGICAL_PROCESSOR_INFORMATION sYSTEM_LOGICAL_PROCESSOR_INFORMATION : arrayOfSYSTEM_LOGICAL_PROCESSOR_INFORMATION) {
/* 154 */       if (sYSTEM_LOGICAL_PROCESSOR_INFORMATION.relationship == 3) {
/* 155 */         arrayList1.add(Long.valueOf(sYSTEM_LOGICAL_PROCESSOR_INFORMATION.processorMask.longValue()));
/* 156 */       } else if (sYSTEM_LOGICAL_PROCESSOR_INFORMATION.relationship == 0) {
/* 157 */         arrayList2.add(Long.valueOf(sYSTEM_LOGICAL_PROCESSOR_INFORMATION.processorMask.longValue()));
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 162 */     arrayList2.sort(null);
/* 163 */     arrayList1.sort(null);
/*     */ 
/*     */     
/* 166 */     ArrayList<CentralProcessor.LogicalProcessor> arrayList = new ArrayList();
/* 167 */     for (byte b = 0; b < arrayList2.size(); b++) {
/* 168 */       long l = ((Long)arrayList2.get(b)).longValue();
/*     */       
/* 170 */       int i = Long.numberOfTrailingZeros(l);
/* 171 */       int j = 63 - Long.numberOfLeadingZeros(l);
/*     */       
/* 173 */       for (int k = i; k <= j; k++) {
/* 174 */         if ((l & 1L << k) != 0L) {
/*     */           
/* 176 */           CentralProcessor.LogicalProcessor logicalProcessor = new CentralProcessor.LogicalProcessor(k, b, getBitMatchingPackageNumber(arrayList1, k));
/* 177 */           arrayList.add(logicalProcessor);
/*     */         } 
/*     */       } 
/*     */     } 
/* 181 */     return arrayList;
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
/*     */   private static int getBitMatchingPackageNumber(List<Long> paramList, int paramInt) {
/* 194 */     for (byte b = 0; b < paramList.size(); b++) {
/* 195 */       if ((((Long)paramList.get(b)).longValue() & 1L << paramInt) != 0L) {
/* 196 */         return b;
/*     */       }
/*     */     } 
/* 199 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\windows\LogicalProcessorInformation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */